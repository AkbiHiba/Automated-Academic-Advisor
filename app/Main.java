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
                Course csc245 = new Course("CP2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc243)));
                Course mth207 = new Course("Discrete 1", true, true, false, 3, new ArrayList<Course>());
                Course csc320 = new Course("CO", true, true, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
                Course csc320L = new Course("CO LAB", true, true, true, 1, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc320)));
                Course csc310 = new Course("CP3", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
                Course csc375 = new Course("Database Management", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
                Course csc326 = new Course("Operating Systems", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, csc320)));
                Course csc447 = new Course("Parallel", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc326, csc310)));
                Course csc490 = new Course("Software Engineering", true, true, false, 3,
                                new ArrayList<Course>(), new ArrayList<Course>(Arrays.asList(csc375)));
                Course mth307 = new Course("Discrete 2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth207, mth201)));
                Course csc430 = new Course("Networks", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc326)));
                Course csc599 = new Course("Capstone", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc490)),
                                new ArrayList<Course>(Arrays.asList(eng202, com203)));
                Course mth305 = new Course("Statistics", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth201)));
                Course csc491 = new Course("Professional Internship", true, true, false, 1,
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
                Course hum5 = new Course("Humanities 5", true, false, false, 3, new ArrayList<Course>());

                Course felec = new Course("Free Elective", true, false, false, 3, new ArrayList<Course>());

                // Nodes with edges of appropriate weights

                Node nhum1 = new Node(hum1, new ArrayList<Edge>());
                Node nhum2 = new Node(hum2, new ArrayList<Edge>());
                Node nhum3 = new Node(hum3, new ArrayList<Edge>());
                Node nhum4 = new Node(hum4, new ArrayList<Edge>());
                Node nhum5 = new Node(hum5, new ArrayList<Edge>());

                Node nfelec = new Node(felec, new ArrayList<Edge>());
                Node nlas204 = new Node(las204, new ArrayList<Edge>());
                Node nbio209 = new Node(bio209, new ArrayList<Edge>());
                Node nmth1 = new Node(mth1, new ArrayList<Edge>());
                Node nmth307 = new Node(mth307, new ArrayList<Edge>());
                Node ncsc430 = new Node(csc430, new ArrayList<Edge>());
                Node ncsc599 = new Node(csc599, new ArrayList<Edge>());
                Node nmth305 = new Node(mth305, new ArrayList<Edge>());
                Node ncsc491 = new Node(csc491, new ArrayList<Edge>());
                Node ncsc1 = new Node(csc1, new ArrayList<Edge>());
                Node ncsc2 = new Node(csc2, new ArrayList<Edge>());
                Node ncsc3 = new Node(csc3, new ArrayList<Edge>());
                Node ncsc4 = new Node(csc4, new ArrayList<Edge>());
                Node ncsc5 = new Node(csc5, new ArrayList<Edge>());
                Node ncsc447 = new Node(csc447, new ArrayList<Edge>());
                Node ncsc490 = new Node(csc490,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc599, 1), new Edge(ncsc491, 0))));
                Node ncsc320L = new Node(csc320L, new ArrayList<Edge>());
                Node ncsc310 = new Node(csc310,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc1, 1), new Edge(ncsc2, 1),
                                                new Edge(ncsc3, 1), new Edge(ncsc4, 1), new Edge(ncsc5, 1),
                                                new Edge(ncsc447, 1))));
                Node ncsc375 = new Node(csc375,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc491, 0), new Edge(ncsc490, 0))));

                Node ncsc326 = new Node(csc326,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc447, 1), new Edge(ncsc430, 1))));
                Node ncsc320 = new Node(csc320,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc326, 1), new Edge(ncsc320L, 0))));
                Node ncsc245 = new Node(csc245,
                                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc310, 1),
                                                new Edge(ncsc326, 1), new Edge(ncsc375, 1), new Edge(ncsc320, 0))));
                Node nmth207 = new Node(mth207, new ArrayList<Edge>(Arrays.asList(new Edge(nmth307, 1),
                                new Edge(ncsc375, 1), new Edge(ncsc310, 1), new Edge(ncsc320, 0))));
                Node ncsc243 = new Node(csc243, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc245, 1))));
                Node nmth201 = new Node(mth201, new ArrayList<Edge>(
                                Arrays.asList(new Edge(nmth1, 1), new Edge(nmth305, 1), new Edge(nmth307, 1))));
                Node ncom203 = new Node(com203, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc599, 0))));
                Node neng202 = new Node(eng202, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc599, 0))));
                Graph g = new Graph();

                g.addNode(ncsc243);
                g.addNode(nhum1);
                g.addNode(nhum2);
                g.addNode(nhum3);
                g.addNode(nhum4);
                g.addNode(nhum5);

                g.addNode(nfelec);
                g.addNode(nmth201);
                g.addNode(ncom203);
                g.addNode(neng202);
                g.addNode(nlas204);
                g.addNode(nbio209);
                g.addNode(ncsc245);
                g.addNode(nmth207);
                g.addNode(ncsc320);
                g.addNode(ncsc320L);
                g.addNode(ncsc310);
                g.addNode(ncsc375);
                g.addNode(ncsc326);
                g.addNode(ncsc447);
                g.addNode(ncsc490);
                g.addNode(nmth307);
                g.addNode(ncsc430);
                g.addNode(ncsc599);
                g.addNode(nmth305);
                g.addNode(ncsc491);
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
                HashMap<Integer, List<Node>> deferredCourses = new HashMap<>();

                // Iterate over each semester to allocate courses
                for (int s = 0; s < nbOfSemesters; s++) {
                        // Define the credit limit for the semester (higher for the final semester)
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

                                // Check if the course fits within the semester's credit limit
                                if (currentSemCredits + courseCredits <= creditLimit) {
                                        // Check for major course credit limit
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

                if (totalCredits != creditRequirement) {
                        System.out.println("Remaning classes could not fit within " + "nbOfSemesters"
                                        + " number of semesters.\n Total completed credits is " + totalCredits
                                        + " out of "
                                        + creditRequirement);
                }

        }
}
