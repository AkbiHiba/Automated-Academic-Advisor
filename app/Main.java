package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import entities.ComparatorTool;
import entities.Course;
import entities.Edge;
import entities.Graph;
import entities.Node;

public class Main {

        public static int nbOfSemesters = 6;
        public static final int TOTAL_CREDIT_REQUIREMENTS = 92;
        public static final int REGULAR_SEMESTER_CREDIT_LIMIT = 16;
        public static final int FINAL_SEMESTER_CREDIT_LIMIT = 21;
        public static final int MAJOR_CREDITS_SEMESTER_LIMIT = 12;

        // all courses
        static Course csc243 = new Course("CP1", true, true, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course mth201 = new Course("Calculus 3", true, true, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course com203 = new Course("Public Communication", true, false, false, 3,
                        new ArrayList<Course>(), new ArrayList<Course>());
        static Course eng202 = new Course("English", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course las204 = new Course("Ethics", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course bio209 = new Course("Basic Biology", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course csc245 = new Course("CP2", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc243)), new ArrayList<Course>());
        static Course mth207 = new Course("Discrete 1", true, true, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course csc320 = new Course("CO", true, true, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>(Arrays.asList(csc245, mth207)));
        static Course csc320L = new Course("CO LAB", true, true, true, 1, new ArrayList<Course>(),
                        new ArrayList<Course>(Arrays.asList(csc320)));
        static Course csc310 = new Course("CP3", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc245, mth207)), new ArrayList<Course>());
        static Course csc375 = new Course("Database Management", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc245, mth207)), new ArrayList<Course>());
        static Course csc326 = new Course("Operating Systems", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc245, csc320)), new ArrayList<Course>());
        static Course csc447 = new Course("Parallel", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc326, csc310)), new ArrayList<Course>());
        static Course csc490 = new Course("Software Engineering", true, true, false, 3,
                        new ArrayList<Course>(), new ArrayList<Course>(Arrays.asList(csc375)));
        static Course mth307 = new Course("Discrete 2", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(mth207, mth201)), new ArrayList<Course>());
        static Course csc430 = new Course("Networks", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc326)), new ArrayList<Course>());
        static Course csc599 = new Course("Capstone", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc490)),
                        new ArrayList<Course>(Arrays.asList(eng202, com203)));
        static Course mth305 = new Course("Statistics", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(mth201)), new ArrayList<Course>());
        static Course csc491 = new Course("Professional Internship", true, true, false, 1,
                        new ArrayList<Course>(), new ArrayList<Course>(Arrays.asList(csc375)));
        static Course csc1 = new Course("CS elective 1", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>());
        static Course csc2 = new Course("CS elective 2", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>());
        static Course csc3 = new Course("CS elective 3", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>());
        static Course csc4 = new Course("CS elective 4", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>());
        static Course csc5 = new Course("CS elective 5", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>());
        static Course mth1 = new Course("MTH elective", true, true, false, 3,
                        new ArrayList<Course>(Arrays.asList(mth201)), new ArrayList<Course>());
        static Course hum1 = new Course("Humanities 1", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course hum2 = new Course("Humanities 2", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course hum3 = new Course("Humanities 3", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course hum4 = new Course("Humanities 4", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course hum5 = new Course("Humanities 5", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());
        static Course felec = new Course("Free Elective", true, false, false, 3, new ArrayList<Course>(),
                        new ArrayList<Course>());

        static List<Course> allCourses = Arrays.asList(csc243, mth201, com203, eng202, las204, bio209, csc245, mth207,
                        csc320,
                        csc320L, csc310, csc375, csc326, csc447, csc490, mth307, csc430, csc599, mth305, csc491,
                        csc1, csc2, csc3, csc4, csc5, mth1, hum1, hum2, hum3, hum4, hum5, felec);

        // Nodes with edges of appropriate weights
        static Node nhum1 = new Node(hum1, new ArrayList<Edge>());
        static Node nhum2 = new Node(hum2, new ArrayList<Edge>());
        static Node nhum3 = new Node(hum3, new ArrayList<Edge>());
        static Node nhum4 = new Node(hum4, new ArrayList<Edge>());
        static Node nhum5 = new Node(hum5, new ArrayList<Edge>());

        static Node nfelec = new Node(felec, new ArrayList<Edge>());
        static Node nlas204 = new Node(las204, new ArrayList<Edge>());
        static Node nbio209 = new Node(bio209, new ArrayList<Edge>());
        static Node nmth1 = new Node(mth1, new ArrayList<Edge>());
        static Node nmth307 = new Node(mth307, new ArrayList<Edge>());
        static Node ncsc430 = new Node(csc430, new ArrayList<Edge>());
        static Node ncsc599 = new Node(csc599, new ArrayList<Edge>());
        static Node nmth305 = new Node(mth305, new ArrayList<Edge>());
        static Node ncsc491 = new Node(csc491, new ArrayList<Edge>());
        static Node ncsc1 = new Node(csc1, new ArrayList<Edge>());
        static Node ncsc2 = new Node(csc2, new ArrayList<Edge>());
        static Node ncsc3 = new Node(csc3, new ArrayList<Edge>());
        static Node ncsc4 = new Node(csc4, new ArrayList<Edge>());
        static Node ncsc5 = new Node(csc5, new ArrayList<Edge>());
        static Node ncsc447 = new Node(csc447, new ArrayList<Edge>());
        static Node ncsc490 = new Node(csc490,
                        new ArrayList<Edge>(Arrays.asList(new Edge(ncsc599, 1), new Edge(ncsc491, 0))));
        static Node ncsc320L = new Node(csc320L, new ArrayList<Edge>());
        static Node ncsc310 = new Node(csc310,
                        new ArrayList<Edge>(Arrays.asList(new Edge(ncsc1, 1), new Edge(ncsc2, 1),
                                        new Edge(ncsc3, 1), new Edge(ncsc4, 1), new Edge(ncsc5, 1),
                                        new Edge(ncsc447, 1))));
        static Node ncsc375 = new Node(csc375,
                        new ArrayList<Edge>(Arrays.asList(new Edge(ncsc491, 0), new Edge(ncsc490, 0))));

        static Node ncsc326 = new Node(csc326,
                        new ArrayList<Edge>(Arrays.asList(new Edge(ncsc447, 1), new Edge(ncsc430, 1))));
        static Node ncsc320 = new Node(csc320,
                        new ArrayList<Edge>(Arrays.asList(new Edge(ncsc326, 1), new Edge(ncsc320L, 0))));
        static Node ncsc245 = new Node(csc245,
                        new ArrayList<Edge>(Arrays.asList(new Edge(ncsc310, 1),
                                        new Edge(ncsc326, 1), new Edge(ncsc375, 1), new Edge(ncsc320, 0))));
        static Node nmth207 = new Node(mth207, new ArrayList<Edge>(Arrays.asList(new Edge(nmth307, 1),
                        new Edge(ncsc375, 1), new Edge(ncsc310, 1), new Edge(ncsc320, 0))));
        static Node ncsc243 = new Node(csc243, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc245, 1))));
        static Node nmth201 = new Node(mth201, new ArrayList<Edge>(
                        Arrays.asList(new Edge(nmth1, 1), new Edge(nmth305, 1), new Edge(nmth307, 1))));
        static Node ncom203 = new Node(com203, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc599, 0))));
        static Node neng202 = new Node(eng202, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc599, 0))));

        static List<Node> allCoursesNodes = Arrays.asList(ncsc243, nmth201, ncom203, neng202, nlas204, nbio209, ncsc245,
                        nmth207, ncsc320,
                        ncsc320L, ncsc310, ncsc375, ncsc326, ncsc447, ncsc490, nmth307, ncsc430, ncsc599,
                        nmth305, ncsc491,
                        ncsc1, ncsc2, ncsc3, ncsc4, ncsc5, nmth1, nhum1, nhum2, nhum3, nhum4, nhum5, nfelec);

        private static Graph initializeGraphForNewStudent() {
                Graph g = new Graph();
                for (Node node : allCoursesNodes) {
                        g.addNode(node);
                }
                return g;
        }

        private static void generateGraduationPlanForNewStudent() {
                Graph g = initializeGraphForNewStudent();

                // compute reachability of the nodes
                g.computeReachability();

                // perform first levelization
                g.levelizeGraph();
                HashMap<Integer, List<Node>> map = g.computeLevelMap(); // contains what nodes each level has,
                                                                        // level 0 [a,b,b], level 1 [e,f,g]
                                                                        // ...etc

                ComparatorTool comparator = new ComparatorTool();
                comparator.setStrategy("reachability");
                for (Integer key : map.keySet()) {
                        List<Node> nodesAtLevel = map.get(key);
                        Collections.sort(nodesAtLevel, comparator); // sort based on reachability
                        System.out.println("Level " + key + ": " + nodesAtLevel);
                }

                /******************************************************************************************************
                 * REACHABILITY AND LEVELIZATION OF GRAPH FINISHED- PROCEED TO SEMESTER
                 * SPLITTING
                 */

                HashMap<Integer, List<Node>> semesters = new HashMap<>(); // contains what nodes each semester
                                                                          // has, s1[a,b,c], s2[e,f,g] ...etc
                int currentLevel = 0;
                int totalCredits = 0;
                HashMap<Integer, List<Node>> deferredCourses = new HashMap<>();

                // Iterate over each semester to allocate courses
                for (int s = 0; s < nbOfSemesters; s++) {
                        // Define the credit limit for the semester (21 for the final semester)
                        int creditLimit = (s == nbOfSemesters - 1) ? FINAL_SEMESTER_CREDIT_LIMIT
                                        : REGULAR_SEMESTER_CREDIT_LIMIT;

                        // Initialize counters for the current semester
                        int currentSemCredits = 0;
                        int majorCredits = 0;

                        // Prepare the list of courses for this semester by combining deferred and new
                        // courses
                        List<Node> coursesToConsider = new ArrayList<>(
                                        deferredCourses.getOrDefault(currentLevel, new ArrayList<>()));
                        List<Node> newCourses = map.get(currentLevel);
                        if (newCourses != null) {
                                coursesToConsider.addAll(newCourses);
                        }
                        deferredCourses.remove(currentLevel); // Clear deferred courses for the current level

                        // Sort the courses for this semester based on major status and reachability
                        comparator.setStrategy("major");
                        Collections.sort(coursesToConsider, comparator);
                        comparator.setStrategy("reachability");
                        Collections.sort(coursesToConsider, comparator);

                        // List to store courses added to this semester
                        List<Node> coursesAddedToSemester = new ArrayList<>();

                        // Process each course for potential inclusion in the current semester
                        for (Node n : coursesToConsider) {
                                int courseCredits = n.getCourse().getCrds();
                                boolean isMajorCourse = n.getCourse().isMajor();
                                boolean hasLab = hasLab(n.getCourse());

                                // Check if the course fits within the semester's credit limit
                                if (currentSemCredits + courseCredits <= creditLimit) {

                                        if (!isMajorCourse || (majorCredits
                                                        + courseCredits <= MAJOR_CREDITS_SEMESTER_LIMIT)) {
                                                coursesAddedToSemester.add(n); // Add to the semester
                                                currentSemCredits += courseCredits;
                                                if (isMajorCourse) {
                                                        majorCredits += courseCredits; // Update major credits if it's a
                                                                                       // major course
                                                }
                                        } else {
                                                // Defer major course if it exceeds major credit limit
                                                deferredCourses.computeIfAbsent(currentLevel + 1,
                                                                k -> new ArrayList<>()).add(n);
                                        }
                                } else {
                                        // Defer the course if it exceeds the general credit limit
                                        deferredCourses.computeIfAbsent(currentLevel + 1, k -> new ArrayList<>())
                                                        .add(n);
                                }
                        }

                        // Update the semesters map with the courses planned for this semester
                        semesters.put(s, coursesAddedToSemester);
                        System.out.println("semester " + s + ":" + semesters.get(s) + currentSemCredits);

                        // Update the total credits and proceed to the next level
                        totalCredits += currentSemCredits;
                        currentLevel++;
                }
                // all 6 semesters have been completed, check if all credits were completed

                if (totalCredits != TOTAL_CREDIT_REQUIREMENTS) {
                        System.out.println("Remaning classes could not fit within " + "nbOfSemesters"
                                        + " number of semesters.\n Total completed credits is " + totalCredits
                                        + " out of "
                                        + TOTAL_CREDIT_REQUIREMENTS);
                }

        }

        // -------------------------------------- For Enrolled
        // Student-------------------------------------------------------------

        private static Graph initializeGraphForEnrolledStudent(List<String> completedCourses) {
                Graph g = new Graph();

                for (Node courseNode : allCoursesNodes) {
                        if (!completedCourses.contains(courseNode.getCourse().getName())) {
                                g.addNode(courseNode);
                        }
                }

                return g;

        }

        // maybe these should be apart of the course/Node class
        private static boolean hasLab(Course course) {
                String labName = course.getName() + " LAB";
                for (Course coReq : course.getCoreq()) {
                        if (coReq.getName().equals(labName)) {
                                return true;
                        }
                }
                return false;
        }

        private static Node findLabNode(Course course, List<Node> nodes) {
                String labName = course.getName() + " LAB";
                for (Node node : nodes) {
                        if (node.getCourse().getName().equals(labName)) {
                                return node;
                        }
                }
                return null;
        }

        private static void generateGraduationPlanForEnrolledStudent(List<String> completedCourses,
                        int creditsCompleted, int semestersCompleted) {

                int creditsLeft = TOTAL_CREDIT_REQUIREMENTS - creditsCompleted;
                int semestersRemaining = nbOfSemesters - semestersCompleted;
                int dynamicCreditLimit = (int) Math.ceil((double) creditsLeft / semestersRemaining);
                int newCreditLimit = Math.min(dynamicCreditLimit, 18); // take the min btwn 18 credits and the new
                                                                       // division, in
                // case we have the new credit limit is above 18
                Graph g = initializeGraphForEnrolledStudent(completedCourses);

                // compute reachability of the nodes
                g.computeReachability();

                // perform first levelization
                g.levelizeGraph();
                HashMap<Integer, List<Node>> map = g.computeLevelMap(); // contains what nodes each level has,
                                                                        // level 0 [a,b,b], level 1 [e,f,g]
                                                                        // ...etc

                ComparatorTool comparator = new ComparatorTool();
                comparator.setStrategy("reachability");
                for (Integer key : map.keySet()) {
                        List<Node> nodesAtLevel = map.get(key);
                        Collections.sort(nodesAtLevel, comparator); // sort based on reachability
                        System.out.println("Level " + key + ": " + nodesAtLevel);
                }

                /******************************************************************************************************
                 * REACHABILITY AND LEVELIZATION OF GRAPH FINISHED- PROCEED TO SEMESTER
                 * SPLITTING
                 */

                HashMap<Integer, List<Node>> semesters = new HashMap<>(); // contains what nodes each semester
                                                                          // has, s1[a,b,c], s2[e,f,g] ...etc
                int currentLevel = 0;
                int totalCredits = 0;
                HashMap<Integer, List<Node>> deferredCourses = new HashMap<>();

                // Iterate over each semester to allocate courses
                for (int s = semestersCompleted; s < nbOfSemesters; s++) {
                        // Define the credit limit for the semester (higher for the final semester)
                        int creditLimit = (s == nbOfSemesters - 1) ? FINAL_SEMESTER_CREDIT_LIMIT
                                        : newCreditLimit;

                        // Initialize counters for the current semester
                        int currentSemCredits = 0;
                        int majorCredits = 0;

                        // Prepare the list of courses for this semester by combining deferred and new
                        // courses
                        List<Node> coursesToConsider = new ArrayList<>(
                                        deferredCourses.getOrDefault(currentLevel, new ArrayList<>()));
                        List<Node> newCourses = map.get(currentLevel);
                        if (newCourses != null) {
                                coursesToConsider.addAll(newCourses);
                        }
                        deferredCourses.remove(currentLevel); // Clear deferred courses for the current level

                        // Sort the courses for this semester based on major status and reachability
                        comparator.setStrategy("major");
                        Collections.sort(coursesToConsider, comparator);
                        comparator.setStrategy("reachability");
                        Collections.sort(coursesToConsider, comparator);

                        // List to store courses added to this semester
                        List<Node> coursesAddedToSemester = new ArrayList<>();

                        // Process each course for potential inclusion in the current semester
                        for (Node n : coursesToConsider) {
                                int courseCredits = n.getCourse().getCrds();
                                boolean isMajorCourse = n.getCourse().isMajor();
                                boolean hasLab = hasLab(n.getCourse());

                                // Check if the course fits within the semester's credit limit
                                if (currentSemCredits + courseCredits <= creditLimit) {
                                        if (hasLab) {
                                                // If the course has a lab, find the lab Node
                                                Node labNode = findLabNode(n.getCourse(), coursesToConsider);
                                                if (labNode != null && currentSemCredits + courseCredits
                                                                + labNode.getCourse().getCrds() <= creditLimit) {
                                                        // If both course and lab fit, add them to the semester
                                                        coursesAddedToSemester.add(n);
                                                        coursesAddedToSemester.add(labNode);
                                                        currentSemCredits += courseCredits
                                                                        + labNode.getCourse().getCrds();
                                                        if (isMajorCourse) {
                                                                majorCredits += courseCredits; // Update major credits
                                                                                               // if it's a major course
                                                        }
                                                        // Remove lab node from coursesToConsider to avoid processing it
                                                        // again
                                                        coursesToConsider.remove(labNode);
                                                } else {
                                                        // Defer if course and lab don't fit in the current semester
                                                        deferredCourses.computeIfAbsent(currentLevel + 1,
                                                                        k -> new ArrayList<>()).add(n);
                                                }
                                        }
                                        // Check for major course credit limit
                                        else if (!isMajorCourse || (majorCredits
                                                        + courseCredits <= MAJOR_CREDITS_SEMESTER_LIMIT)) {
                                                coursesAddedToSemester.add(n); // Add to the semester
                                                currentSemCredits += courseCredits;
                                                if (isMajorCourse) {
                                                        majorCredits += courseCredits; // Update major credits if it's a
                                                                                       // major course
                                                }
                                        } else {
                                                // Defer major course if it exceeds major credit limit
                                                deferredCourses.computeIfAbsent(currentLevel + 1,
                                                                k -> new ArrayList<>()).add(n);
                                        }
                                } else {
                                        // Defer the course if it exceeds the general credit limit
                                        deferredCourses.computeIfAbsent(currentLevel + 1, k -> new ArrayList<>())
                                                        .add(n);
                                }
                        }

                        // Update the semesters map with the courses planned for this semester
                        semesters.put(s, coursesAddedToSemester);
                        System.out.println("semester " + s + ":" + semesters.get(s) + currentSemCredits);

                        // Update the total credits and proceed to the next level
                        totalCredits += currentSemCredits;
                        currentLevel++;
                }
                // all 6 semesters have been completed, check if all credits were completed

                // After the semester planning loop
                if (totalCredits + creditsCompleted < TOTAL_CREDIT_REQUIREMENTS) {
                        System.out.println("It may not be possible to complete " + creditsLeft
                                        + " credits in the remaining "
                                        +
                                        semestersRemaining + " semesters. Additional semesters may be required.");
                } else {
                        System.out.println(
                                        "It is possible to complete " + creditsLeft
                                                        + " credits in the remaining "
                                                        +
                                                        semestersRemaining + " semesters");
                }

        }

        public static void main(String[] args) {
                // in the case of a new student
                // generateGraduationPlanForNewStudent();

                // in the case of an enrolled student:
                List<String> completedCourses = Arrays.asList("CP1", "Calculus 3", "Discrete 1", "English",
                                "Humanities 1", "CP2", "Discrete 2", "Basic Biology", "MTH elective",
                                "felec", "CP3", "Database Management");

                // experiment with all possiblities
                generateGraduationPlanForEnrolledStudent(completedCourses, 36, 3);

        }
}
