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
        public static int creditRequirement = 92;
        public static final int REGULAR_SEMESTER_CREDIT_LIMIT = 16;
        public static final int FINAL_SEMESTER_CREDIT_LIMIT = 21;
        public static final int MAJOR_CREDITS_SEMESTER_LIMIT = 13;

        public static void main(String[] args) {
                // all courses
                Course csc243 = new Course("CP1", true, true, false, 3, new ArrayList<Course>());
                Course mth201 = new Course("Calculus 3", true, true, false, 3, new ArrayList<Course>());
                Course com203 = new Course("Public Communication", true, false, false, 3,
                                new ArrayList<Course>());
                Course eng202 = new Course("English", true, false, false, 3, new ArrayList<Course>());
                Course las204 = new Course("Ethics", true, false, false, 3, new ArrayList<Course>());
                Course bio209 = new Course("Basic Biology", true, false, false, 3, new ArrayList<Course>());
                Course csc243L = new Course("CP1 LAB", true, true, true, 1, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc243)));
                Course csc245 = new Course("CP2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc243)));
                Course csc245L = new Course("CP2 LAB", true, true, true, 1, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc245)));
                Course mth207 = new Course("Discrete 1", true, true, false, 3, new ArrayList<Course>());
                Course csc230 = new Course("CO", true, true, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
                Course csc230L = new Course("CO LAB", true, true, true, 1, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc230)));
                Course csc310 = new Course("CP3", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
                Course csc310L = new Course("CP3 LAB", true, true, true, 1, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc310)));
                Course csc375 = new Course("Database Management", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
                Course csc326 = new Course("Operating Systems", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, csc230)));
                Course parallel = new Course("Parallel", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc326, csc310)));
                Course csc340 = new Course("Software Engineering", true, true, false, 3,
                                new ArrayList<Course>(), new ArrayList<Course>(Arrays.asList(csc375)));
                Course csc380 = new Course("Discrete 2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth207, mth201)));
                Course csc430 = new Course("Networks", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc326)));
                Course csc400 = new Course("Capstone", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc340)),
                                new ArrayList<Course>(Arrays.asList(eng202, com203)));
                Course mth305 = new Course("Statistics", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth201)));
                Course csc500 = new Course("Professional Internship", true, true, false, 3,
                                new ArrayList<Course>(), new ArrayList<Course>(Arrays.asList(csc375)));
                Course csc1 = new Course("CS elective 1", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)));
                Course csc2 = new Course("CS elective 2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)));
                Course csc3 = new Course("CS elective 3", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)));
                Course csc4 = new Course("CS elective 4", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)));
                Course csc5 = new Course("CS elective 5", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)));
                Course mth1 = new Course("MTH elective", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth201)));
                Course hum1 = new Course("Humanities 1", true, false, false, 3, new ArrayList<Course>());
                Course hum2 = new Course("Humanities 2", true, false, false, 3, new ArrayList<Course>());
                Course hum3 = new Course("Humanities 3", true, false, false, 3, new ArrayList<Course>());
                Course hum4 = new Course("Humanities 4", true, false, false, 3, new ArrayList<Course>());
                Course felec = new Course("Free Elective", true, false, false, 1, new ArrayList<Course>());

                // Nodes with edges of appropriate weights

                Node nhum1 = new Node(hum1, new ArrayList<Edge>());
                Node nhum2 = new Node(hum2, new ArrayList<Edge>());
                Node nhum3 = new Node(hum3, new ArrayList<Edge>());
                Node nhum4 = new Node(hum4, new ArrayList<Edge>());
                Node nfelec = new Node(felec, new ArrayList<Edge>());
                Node nlas204 = new Node(las204, new ArrayList<Edge>());
                Node nbio209 = new Node(bio209, new ArrayList<Edge>());
                Node ncsc243L = new Node(csc243L, new ArrayList<Edge>());
                Node nmth1 = new Node(mth1, new ArrayList<Edge>());
                Node ncsc380 = new Node(csc380, new ArrayList<Edge>());
                Node ncsc430 = new Node(csc430, new ArrayList<Edge>());
                Node ncsc400 = new Node(csc400, new ArrayList<Edge>());
                Node nmth305 = new Node(mth305, new ArrayList<Edge>());
                Node ncsc500 = new Node(csc500, new ArrayList<Edge>());
                Node ncsc1 = new Node(csc1, new ArrayList<Edge>());
                Node ncsc2 = new Node(csc2, new ArrayList<Edge>());
                Node ncsc3 = new Node(csc3, new ArrayList<Edge>());
                Node ncsc4 = new Node(csc4, new ArrayList<Edge>());
                Node ncsc5 = new Node(csc5, new ArrayList<Edge>());
                Node nparallel = new Node(parallel, new ArrayList<Edge>());
                Node ncsc340 = new Node(csc340,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc400, 1), new Edge(ncsc500, 0))));
                Node ncsc230L = new Node(csc230L, new ArrayList<Edge>());
                Node ncsc310L = new Node(csc310L, new ArrayList<Edge>());
                Node ncsc310 = new Node(csc310,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc1, 1), new Edge(ncsc2, 1),
                                                new Edge(ncsc310L, 0),
                                                new Edge(ncsc3, 1), new Edge(ncsc4, 1), new Edge(ncsc5, 1),
                                                new Edge(nparallel, 1))));
                Node ncsc375 = new Node(csc375,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc500, 0), new Edge(ncsc340, 0))));

                Node ncsc326 = new Node(csc326,
                                new ArrayList<Edge>(Arrays.asList(new Edge(nparallel, 1), new Edge(ncsc430, 1))));
                Node ncsc230 = new Node(csc230,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc326, 1), new Edge(ncsc230L, 0))));
                Node ncsc245L = new Node(csc245L, new ArrayList<Edge>());
                Node ncsc245 = new Node(csc245,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc310, 1), new Edge(ncsc245L, 0),
                                                new Edge(ncsc326, 1), new Edge(ncsc375, 1), new Edge(ncsc230, 0))));
                Node nmth207 = new Node(mth207, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc380, 1),
                                new Edge(ncsc375, 1), new Edge(ncsc310, 1), new Edge(ncsc230, 0))));
                Node ncsc243 = new Node(csc243, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc245, 1))));
                Node nmth201 = new Node(mth201, new ArrayList<Edge>(
                                Arrays.asList(new Edge(nmth1, 1), new Edge(nmth305, 1), new Edge(ncsc380, 1))));
                Node ncom203 = new Node(com203, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc400, 0))));
                Node neng202 = new Node(eng202, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc400, 0))));
                Graph g = new Graph();

                g.addNode(ncsc243);
                g.addNode(nhum1);
                g.addNode(nhum2);
                g.addNode(nhum3);
                g.addNode(nhum4);
                g.addNode(nfelec);
                g.addNode(nmth201);
                g.addNode(ncom203);
                g.addNode(neng202);
                g.addNode(nlas204);
                g.addNode(nbio209);
                g.addNode(ncsc243L);
                g.addNode(ncsc245);
                g.addNode(ncsc245L);
                g.addNode(nmth207);
                g.addNode(ncsc230);
                g.addNode(ncsc230L);
                g.addNode(ncsc310);
                g.addNode(ncsc310L);
                g.addNode(ncsc375);
                g.addNode(ncsc326);
                g.addNode(nparallel);
                g.addNode(ncsc340);
                g.addNode(ncsc380);
                g.addNode(ncsc430);
                g.addNode(ncsc400);
                g.addNode(nmth305);
                g.addNode(ncsc500);
                g.addNode(ncsc1);
                g.addNode(nmth1);
                g.addNode(ncsc2);
                g.addNode(ncsc3);
                g.addNode(ncsc4);
                g.addNode(ncsc5);

                /******************************************************************************************************
                 * INTIALIZATION OF GRAPH FINISHED
                 */

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
                int totalCredits = 0; // total amount of credits within the graduation plan
                for (int s = 0; s < nbOfSemesters; s++) { // for every semester

                        // HEURISTICS OF MAJOR AND REACHABILITY
                        comparator.setStrategy("major");
                        Collections.sort(map.get(currentLevel), comparator);
                        comparator.setStrategy("rechability");
                        Collections.sort(map.get(currentLevel), comparator);

                        int currentSemCredits = 0; // current amount of credits in the semester
                        int majorCredits = 0; // Initialize major credits in the semester

                        // if it is the last semester allow up to 21, else 16
                        int creditLimit = (s == nbOfSemesters - 1) ? FINAL_SEMESTER_CREDIT_LIMIT
                                        : REGULAR_SEMESTER_CREDIT_LIMIT;

                        boolean hasDeferredCourses = false;

                        for (Node n : map.get(currentLevel)) // starts filling semester level by level
                        {

                                int courseCredits = n.getCourse().getCrds();

                                // if adding this course is not a problem and (either this is not a major course
                                // or it is but adding it won't exceed the max number of major per sem)
                                if ((currentSemCredits + courseCredits <= creditLimit) &&
                                                (!n.getCourse().isMajor() || (majorCredits
                                                                + courseCredits <= MAJOR_CREDITS_SEMESTER_LIMIT))) {

                                        List<Node> coursesAtSemester = semesters.getOrDefault(s,
                                                        new ArrayList<>());
                                        coursesAtSemester.add(n);
                                        semesters.put(s, coursesAtSemester);
                                        currentSemCredits += courseCredits;
                                        if (n.getCourse().isMajor()) {
                                                majorCredits += courseCredits;
                                        }
                                } else {
                                        // If the course is a major course and we've reached the major credits limit,
                                        // or if adding the course would exceed the general credit limit, defer it.
                                        hasDeferredCourses = true;
                                }

                        }

                        // After trying to assign all courses at the current level to this semester,
                        // handle deferred courses by pushing them to the next level.
                        if (hasDeferredCourses) {
                                for (Node course : map.get(currentLevel)) {
                                        if (!semesters.get(s).contains(course)) {
                                                // Only increase the level of courses that were not added
                                                // due to reaching the credit limit.
                                                course.setLevel(course.getLevel() + 1); // push one level down
                                        }
                                }

                                for (Node course : map.get(currentLevel)) {
                                        if (!semesters.get(s).contains(course)) {
                                                g.levelizefromRoot(course); // Re-levelize to account for deferred
                                                                            // courses
                                                map = g.computeLevelMap(); // Re-compute the level map after
                                                                           // re-levelizing
                                        }
                                }
                        }

                        System.out.println("semester " + s + ":" + semesters.get(s) + currentSemCredits);
                        totalCredits += currentSemCredits;
                        currentLevel += 1;

                }
                // all 6 semesters have been completed, check if all credits were completed

                if (totalCredits != creditRequirement) {
                        System.out.println("Remaning classes could not fit within " + "nbOfSemesters"
                                        + " number of semesters.\n Total completed credits is " + totalCredits
                                        + " out of "
                                        + creditRequirement);
                }

        }
}
