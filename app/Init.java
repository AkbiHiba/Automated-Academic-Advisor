package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import entities.Course;
import entities.Edge;
import entities.Graph;
import entities.Node;

public class Init {
        private Graph g = new Graph();
        private List<Course> unavailableSummerCourses = new ArrayList<Course>();

        public Init(List<String> completedCourses) {
                initGraph(completedCourses); // Pass the completed courses to the graph initialization
        }

        public Graph getG() {
                return g;
        }

        public void setG(Graph g) {
                this.g = g;
        }

        public List<Course> getUnavailableSummerCourses() {
                return unavailableSummerCourses;
        }

        public void setUnavailableSummerCourses(List<Course> unavailableSummerCourses) {
                this.unavailableSummerCourses = unavailableSummerCourses;
        }

        // Initialize the graph but exclude completed courses
        private void initGraph(List<String> completedCourses) {
                List<Node> allCoursesNodes = getAllcoursesNodes();
                for (Node courseNode : allCoursesNodes) {
                        if (!completedCourses.contains(courseNode.getCourse().getName())) {
                                courseNode.getCourse().setisCompleted(true);
                                g.addNode(courseNode);
                        }
                }
        }

        private List<Node> getAllcoursesNodes() {
                // ths method returns a list of all initialized nodes , this will
                // help when initialzing the array to
                // check is the course taken (on the completed courses list) then add it to the
                // graph, else don't add it

                List<Node> allCoursesNodes = new ArrayList<Node>();

                Course csc243 = new Course("CP1", true, true, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course mth201 = new Course("Calculus 3", true, true, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course com203 = new Course("Public Communication", true, false, false, 3,
                                new ArrayList<Course>(), new ArrayList<Course>(), false);
                Course eng202 = new Course("English", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course las204 = new Course("Ethics", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course bio209 = new Course("Basic Biology", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course csc245 = new Course("CP2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc243)), new ArrayList<Course>(), false);
                Course mth207 = new Course("Discrete 1", true, true, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course csc320 = new Course("CO", true, true, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)), false);
                Course csc320L = new Course("CO LAB", true, true, true, 1, new ArrayList<Course>(),
                                new ArrayList<Course>(Arrays.asList(csc320)), false);
                csc320.setLab(csc320L);
                Course csc310 = new Course("CP3", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)), new ArrayList<Course>(), false);
                Course csc375 = new Course("Database Management", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, mth207)), new ArrayList<Course>(), false);
                Course csc326 = new Course("Operating Systems", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc245, csc320)), new ArrayList<Course>(), false);
                Course csc447 = new Course("Parallel", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc326, csc310)), new ArrayList<Course>(), false);
                Course csc490 = new Course("Software Engineering", true, true, false, 3,
                                new ArrayList<Course>(), new ArrayList<Course>(Arrays.asList(csc375)), false);
                Course mth307 = new Course("Discrete 2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth207, mth201)), new ArrayList<Course>(), false);
                Course csc430 = new Course("Networks", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc326)), new ArrayList<Course>(), false);
                Course csc599 = new Course("Capstone", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc490)),
                                new ArrayList<Course>(Arrays.asList(eng202, com203)), false);
                Course mth305 = new Course("Probability", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth201)), new ArrayList<Course>(), false);
                Course csc491 = new Course("Professional Internship", true, true, false, 1,
                                new ArrayList<Course>(), new ArrayList<Course>(Arrays.asList(csc375)), false);
                Course csc1 = new Course("CS elective 1", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>(), false);
                Course csc2 = new Course("CS elective 2", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>(), false);
                Course csc3 = new Course("CS elective 3", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>(), false);
                Course csc4 = new Course("CS elective 4", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>(), false);
                Course csc5 = new Course("CS elective 5", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(csc310)), new ArrayList<Course>(), false);
                Course mth1 = new Course("MTH elective", true, true, false, 3,
                                new ArrayList<Course>(Arrays.asList(mth201)), new ArrayList<Course>(), false);
                Course hum1 = new Course("Humanities 1", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course hum2 = new Course("Humanities 2", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course hum3 = new Course("Humanities 3", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course hum4 = new Course("Humanities 4", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course hum5 = new Course("Humanities 5", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);
                Course felec = new Course("Free Elective", true, false, false, 3, new ArrayList<Course>(),
                                new ArrayList<Course>(), false);

                List<Course> allCourses = Arrays.asList(csc243, mth201, com203, eng202, las204, bio209, csc245, mth207,
                                csc320, csc320L, csc310, csc375, csc326, csc447, csc490, mth307, csc430, csc599, mth305,
                                csc491,
                                csc1, csc2, csc3, csc4, csc5, mth1, hum1, hum2, hum3, hum4, hum5, felec);

                unavailableSummerCourses.add(csc243);
                unavailableSummerCourses.add(csc245);
                unavailableSummerCourses.add(csc310);
                unavailableSummerCourses.add(csc320);
                unavailableSummerCourses.add(csc320L);
                unavailableSummerCourses.add(csc310);
                unavailableSummerCourses.add(csc375);
                unavailableSummerCourses.add(csc326);
                unavailableSummerCourses.add(csc430);
                unavailableSummerCourses.add(csc490);
                unavailableSummerCourses.add(csc447);

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

                allCoursesNodes = Arrays.asList(ncsc243, nmth201, ncom203, neng202, nlas204, ncsc245,
                                nmth207, ncsc320,
                                ncsc320L, ncsc310, ncsc375, ncsc326, ncsc447, ncsc490, nmth307, ncsc430, ncsc599,
                                nmth305, ncsc491,
                                ncsc1, ncsc2, ncsc3, ncsc4, ncsc5, nmth1, nhum1, nhum2, nhum3, nhum4, nhum5, nfelec);

                return allCoursesNodes;
        }

}
