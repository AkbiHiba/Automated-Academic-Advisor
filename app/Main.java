package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import entities.ComparatorTool;
import entities.Course;
import entities.Graph;
import entities.Node;
import entities.Semester;

/**
 * Newest version of the code. Semester is now an Object. Summer heuristic
 * implemented.
 */
public class Main {

        public static int maxSemesters = 6; // max regular semesters allowed. starts from 1
        public static final int TOTAL_CREDIT_REQUIREMENTS = 92;
        public static final int RECOMMENDED_CREDIT_LIMIT = 16;
        public static final int REGULAR_SEMESTER_CREDIT_LIMIT = 18;
        public static final int SUMMER_SEMESTER_CREDIT_LIMIT = 9;
        public static final int FINAL_SEMESTER_CREDIT_LIMIT = 21;
        public static final int MAJOR_CREDITS_SEMESTER_LIMIT = 13;
        public static List<Course> unavailableSummerCourses = new ArrayList<Course>();
        // assume all of these are taken from the user
        public static List<String> completedCourses = Arrays.asList("CP1", "Discrete 1", "Basic Biology",
                        "Humanities 1",
                        "Calculus 3", "CO", "CO LAB", "CP2", "Ethics", "English", "Humanities 2");
        public static int completedSemesters = 5;
        public static int completedCredits = 31;
        public static int startSemester = 0;
        // all above
        public static Graph g;

        public static final int REMAINING_TOTAL_CREDIT_REQUIREMENTS = TOTAL_CREDIT_REQUIREMENTS - completedCredits;

        public static void main(String[] args) {
                // initialize graph
                Init i = new Init(completedCourses);
                g = i.getG();
                unavailableSummerCourses = i.getUnavailableSummerCourses();
                // System.out.println(unavailableSummerCourses);
                // compute reachability of the nodes
                g.computeReachability();

                /******************************************************************************************************
                 * INITIALIZATION OF GRAPH FINISHED
                 ******************************************************************************************************/

                // perform first levelization
                g.levelizeGraph();
                // contains what nodes each level has level 0 [a,b,b], level 1 [e,f,g] ...etc
                HashMap<Integer, List<Node>> map = g.computeLevelMap();

                // System.out.println(map);

                /******************************************************************************************************
                 * REACHABILITY AND LEVELIZATION OF GRAPH FINISHED- PROCEED TO FIND A SOLUTION
                 ******************************************************************************************************/
                int found = 0;
                // this loop to add max 2 semesters if no solutions using all what we had
                for (int extraSem = 0; extraSem <= 2; extraSem++) {
                        int newmaxSemesters = maxSemesters + extraSem; // this will start with 0 extraSem , the regular
                                                                       // case them will keep adding
                        int remainingSemesters = newmaxSemesters - completedSemesters;
                        int newStartSemester = (startSemester + completedSemesters) % 2; /*
                                                                                          * This assumes that the
                                                                                          * completedSemesters given by
                                                                                          * the
                                                                                          * user does not include
                                                                                          * summers( it
                                                                                          * should not really matter to
                                                                                          * us).
                                                                                          * modulo 2 because here we
                                                                                          * want to
                                                                                          * know if the next
                                                                                          * semester to start
                                                                                          * recommending
                                                                                          * courses for student based on
                                                                                          * what
                                                                                          * he completed
                                                                                          * is a full or a summer
                                                                                          */
                        /*
                         * generate all combiantions of semesters, with and without summers
                         * I passes the remainig semesters instead the max number of semesters cz the
                         * student alreasy took semesters
                         * passed the newStart semester which means if the new next sem is a full or a
                         * spring
                         */
                        List<List<Semester>> allCombinationsOfSemesters = Semester
                                        .generateSemestersCombinations(remainingSemesters,
                                                        newStartSemester);
                        allCombinationsOfSemesters.stream().forEach(System.out::println);

                        int currentLevel = 0;
                        int totalCredits = 0;

                        if (findSchedule(g, map, allCombinationsOfSemesters, currentLevel, totalCredits,
                                        0)) {
                                found = 1;
                                break;
                        }

                }
                if (found != 1) {
                        System.out.println("No solution possible");
                }
        }

        /**
         * Function to look for a solution. It tries all different summer/non summer
         * combinations, and for
         * each it tries all courses by calling scheduleCoursesSummer.
         * 
         * @param g
         *                                   is the graph
         * @param map
         *                                   is a map of nodes to their levels [level 0:
         *                                   node 1,2,3, level 1: node 4,5,6]
         * @param currentLevel
         *                                   is initialized to 0
         * @param totalCredits
         *                                   is current count of completed credits,
         *                                   initialized to 0
         * @param allCombinationsofSemesters
         *                                   represents all combinations of fall, spring
         *                                   and summers that can be generated
         */
        private static boolean findSchedule(Graph g, HashMap<Integer, List<Node>> map,
                        List<List<Semester>> allCombinationsOfSemesters, int currentLevel, int totalCredits,
                        int currentSemester) {
                for (List<Semester> semesterCombination : allCombinationsOfSemesters) {
                        // First attempt with regular credit limits (16 and 18)
                        if (scheduleCourses(g, map, new ArrayList<>(semesterCombination), currentLevel, totalCredits,
                                        currentSemester, false)) {

                                return true;
                        }

                        // Second attempt allowing 21 credits in the last semester
                        if (scheduleCourses(g, map, new ArrayList<>(semesterCombination),
                                        currentLevel, totalCredits,
                                        currentSemester, true)) {

                                return true;
                        }

                }
                System.out.println(
                                "NO SOLUTION FOUND WITH THE SET NUMBER OF SEMESTERS, TRYING ADDING 1 MORE SEMESTERS");

                return false;
        }

        /**
         * This function searches for the lab-course pair. When passed a course it
         * searches for its lab.
         * When passed a lab, it searches for its course. if found return it, else
         * return null.
         */
        private static Node findLabNode(Node node, List<Node> nodes) {
                for (Node n : nodes) {
                        if (node.getCourse().getLab().equals(n.getCourse())) {
                                return n;
                        }
                }
                return null;
        }

        /**
         * Function to determine the different credits allowed in a semester based on
         * different factors
         * like type of semester (summer or not), last semester (final or not) ...etc.
         * return an int[]
         * with the different allowed values.
         */
        private static int[] determineCreditLimits(Semester semester,
                        boolean allowExtraCreditsInLastSemester) {
                if (semester.isSummer()) {
                        return new int[] { SUMMER_SEMESTER_CREDIT_LIMIT };
                } else if (semester.isFinal() && allowExtraCreditsInLastSemester) { // this for the last semester when
                                                                                    // we are
                        return new int[] { FINAL_SEMESTER_CREDIT_LIMIT }; // allowing 21 credits.
                } else if (!semester.isFinal() && allowExtraCreditsInLastSemester) { // this is when we are directly
                                                                                     // passing 18
                        return new int[] { REGULAR_SEMESTER_CREDIT_LIMIT }; // for all semesters.
                } else {
                        return new int[] { RECOMMENDED_CREDIT_LIMIT, REGULAR_SEMESTER_CREDIT_LIMIT };
                }
        }

        /******************************************************************************************************
         * RECURSIVE FUNCTION FOR SCHEDULE GENERATION It backtracks to previous semester
         * when a solution
         * isn't found. Uses ordering by reachability. So far, it implements only the
         * max Credits
         * heuristic. It creates a new copy of the grapha and levels at every recursion,
         * which is
         * terrible.
         * 
         * @param g
         *                        is the graph
         * @param m
         *                        is the list of nodes at every level
         * @param semesters
         *                        is the current combination of semesters , like [fall,
         *                        spring, summer, ...]
         * @param currentLevel
         *                        is the current level we are looping through
         * @param totalCredits
         *                        is the current amount of credits we have completed
         *                        throughout all semesters
         * @param currentSemester
         *                        is the index of the current semester in semesters list
         ******************************************************************************************************/

        private static boolean scheduleCourses(Graph g, HashMap<Integer, List<Node>> m,
                        List<Semester> semesters, int currentLevel, int totalCredits, int currentSemester,
                        boolean allowExtraCreditsInLastSemester) {

                // if finished the creditRequirements, great
                if (totalCredits == REMAINING_TOTAL_CREDIT_REQUIREMENTS) {
                        // print resulting projection plan
                        System.out.println("*************************SOLUTION FOUND*****************************");
                        semesters.stream().forEach(System.out::println);// fancy printing
                        return true;
                }
                // if requirements aren't finished but there's still semesters to add
                if (currentSemester < semesters.size()) {
                        // for this currentsemester and level

                        int currentMaxCrds;
                        int currentCredits;
                        int currentMajorRelatedCredits;
                        int[] creditsHeuristic = determineCreditLimits(semesters.get(currentSemester),
                                        allowExtraCreditsInLastSemester);

                        // implementation of the load balancing, to allow for a balanced semester
                        // between major and
                        // non major courses

                        boolean[] majorBalancingHeuristic = { true, false };
                        for (boolean allowBalancing : majorBalancingHeuristic) {
                                // System.out.println(
                                // "***** (SEMESTER" + (currentSemester + 1) + ") SET BALACING TO= " +
                                // allowBalancing);
                                for (int i : creditsHeuristic) {
                                        // System.out.println("***** CURRENT (SEMESTER" + (currentSemester + 1) + " )
                                        // BALANCING: "
                                        // + allowBalancing + " at this point.******Iteration:" + i);
                                        // try course assignment with different max credit values based on conditions.
                                        currentCredits = 0;
                                        currentMajorRelatedCredits = 0;
                                        currentMaxCrds = i;
                                        Graph graph = g.deepCopy(); // not sure how relevant this is anymore, we need to
                                                                    // check again object refrences

                                        // sort by reachability
                                        HashMap<Integer, List<Node>> map = graph.computeLevelMap();
                                        List<Node> coursesToConsider = map.get(currentLevel);
                                        ComparatorTool comparator = new ComparatorTool();
                                        comparator.setStrategy("major");
                                        Collections.sort(coursesToConsider, comparator);
                                        comparator.setStrategy("reachability");
                                        Collections.sort(coursesToConsider, comparator);

                                        // starts filling semester level by level
                                        List<Node> coursesAtCurrentSemester = new ArrayList<>();
                                        for (int j = 0; j < coursesToConsider.size(); j++) {
                                                Node n = coursesToConsider.get(j);

                                                // handle summer list unavailability

                                                if (semesters.get(currentSemester).isSummer()
                                                                && unavailableSummerCourses.contains(n.getCourse()))
                                                        continue;

                                                boolean isMajor = n.getCourse().isMajor();

                                                // System.out.println(currentLevel+" !!!!!"+n+" : (major) "+isMajor);
                                                if (currentCredits + n.getCourse().getCrds() <= currentMaxCrds) {
                                                        // allow balancing is true, means we only add a course if, it's
                                                        // either not a major
                                                        // course, or it's major but major limit wasn't reached yet
                                                        // allow balancing is false, means we add anyway so if statement
                                                        // must pass everytime
                                                        // there's probably a better way of writing this
                                                        if (!allowBalancing || (!isMajor
                                                                        || allowBalancing && currentMajorRelatedCredits
                                                                                        + n.getCourse().getCrds() <= MAJOR_CREDITS_SEMESTER_LIMIT)) {
                                                                // System.out.println(currentLevel+" !!!!!"+n+" to
                                                                // consider : (major) "+isMajor);
                                                                // LAB MANDATORY HEURISTIC
                                                                boolean hasLab = n.getCourse().getLab() != null;
                                                                boolean isLab = n.getCourse().isLab();

                                                                if (isLab || hasLab)
                                                                // ensure both lab and course are taken together, or
                                                                // none is taken
                                                                {
                                                                        Node labNode = findLabNode(n,
                                                                                        coursesToConsider);
                                                                        if (currentCredits + n.getCourse().getCrds()
                                                                                        + labNode.getCourse()
                                                                                                        .getCrds() <= currentMaxCrds) {
                                                                                coursesAtCurrentSemester.add(n);
                                                                                coursesAtCurrentSemester.add(labNode);

                                                                                semesters.get(currentSemester)
                                                                                                .setNodesAtSemester(
                                                                                                                coursesAtCurrentSemester);
                                                                                currentCredits += n.getCourse()
                                                                                                .getCrds()
                                                                                                + labNode.getCourse()
                                                                                                                .getCrds();
                                                                                currentMajorRelatedCredits += n
                                                                                                .getCourse().getCrds()
                                                                                                + labNode.getCourse()
                                                                                                                .getCrds();

                                                                        }
                                                                        // Prevent lab/course from being processed again
                                                                        coursesToConsider.remove(labNode);

                                                                } else // no lab issue
                                                                {
                                                                        coursesAtCurrentSemester.add(n);

                                                                        semesters.get(currentSemester)
                                                                                        .setNodesAtSemester(
                                                                                                        coursesAtCurrentSemester);
                                                                        currentCredits += n.getCourse().getCrds();
                                                                        if (isMajor)
                                                                                currentMajorRelatedCredits += n
                                                                                                .getCourse().getCrds();
                                                                        // System.out.println(currentLevel+" !!!!!"+n+"
                                                                        // TAKEN : (major) "+isMajor +" CRDS
                                                                        // "+
                                                                        // currentMajorRelatedCredits);
                                                                }
                                                        }
                                                }

                                        }

                                        // Handling courses that were not picked for this current semester.
                                        for (Node course : map.get(currentLevel)) {
                                                if (!semesters.get(currentSemester).getNodesAtSemester()
                                                                .contains(course)) {
                                                        course.setLevel(course.getLevel() + 1); // push one level down

                                                }
                                        }
                                        for (Node course : map.get(currentLevel)) {

                                                if (!semesters.get(currentSemester).getNodesAtSemester()
                                                                .contains(course)) {
                                                        graph.levelizefromRoot(course); // push all levels below
                                                        map = graph.computeLevelMap();
                                                }
                                        }

                                        // move to next semester
                                        if (scheduleCourses(graph, map, semesters, currentLevel + 1,
                                                        totalCredits + currentCredits, (currentSemester + 1),
                                                        allowExtraCreditsInLastSemester))
                                                return true;
                                        // if didn't work, backtrack and change the max credit load
                                        semesters.get(currentSemester).getNodesAtSemester().clear();
                                }
                                // if didn't work, backtrack and do not balance the semester anymore
                                // System.out.println("change balancing value ");
                        }

                }

                // no more semester, and plan was incomplete
                System.out.println("******RETURNED FALSE AT " + currentSemester + "(" +
                                totalCredits + ")");
                semesters.stream().forEach(System.out::println); // printing lien by line

                return false;

        }

}
