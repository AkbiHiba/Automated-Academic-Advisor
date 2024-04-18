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

    public Init() {
        initGraph();
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

    private void initGraph() {

        Course csc243 = new Course("CP1", true, true, false, 3, new ArrayList<Course>());
        // Course csc243L = new Course("CP1 LAB", true, true, true, 1, new
        // ArrayList<Course>(),
        // new ArrayList<Course>(Arrays.asList(csc243)));
        // csc243.setLab(csc243L);
        // csc243L.setLab(csc243);
        Course mth201 = new Course("Calculus 3", true, true, false, 3, new ArrayList<Course>());
        Course com203 = new Course("Public Communication", true, false, false, 3,
                new ArrayList<Course>());
        Course eng202 = new Course("English", true, false, false, 3, new ArrayList<Course>());
        Course las204 = new Course("Ethics", true, false, false, 3, new ArrayList<Course>());
        Course bio209 = new Course("Basic Biology", true, false, false, 3, new ArrayList<Course>());
        Course csc245 = new Course("CP2", true, true, false, 3,
                new ArrayList<Course>(Arrays.asList(csc243)));
        // Course csc245L = new Course("CP2 LAB", true, true, true, 1, new
        // ArrayList<Course>(),
        // new ArrayList<Course>(Arrays.asList(csc245)));
        // csc245.setLab(csc245L);
        // csc245L.setLab(csc245);
        Course mth207 = new Course("Discrete 1", true, true, false, 3, new ArrayList<Course>());
        Course csc230 = new Course("CO", true, true, false, 3, new ArrayList<Course>(),
                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
        Course csc230L = new Course("CO LAB", true, true, true, 1, new ArrayList<Course>(),
                new ArrayList<Course>(Arrays.asList(csc230)));
        csc230.setLab(csc230L);
        csc230L.setLab(csc230);
        Course csc310 = new Course("CP3", true, true, false, 3,
                new ArrayList<Course>(Arrays.asList(csc245, mth207)));
        // Course csc310L = new Course("CP3 LAB", true, true, true, 1, new
        // ArrayList<Course>(),
        // new ArrayList<Course>(Arrays.asList(csc310)));
        // csc310.setLab(csc310L);
        // csc310L.setLab(csc310);
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
        Course csc500 = new Course("Professional Internship", true, true, false, 1,
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

        unavailableSummerCourses.add(csc310);
        unavailableSummerCourses.add(csc230);
        unavailableSummerCourses.add(csc230L);
        unavailableSummerCourses.add(csc310);
        unavailableSummerCourses.add(csc375);
        unavailableSummerCourses.add(csc326);
        unavailableSummerCourses.add(csc430);
        unavailableSummerCourses.add(csc380);
        unavailableSummerCourses.add(csc340);
        unavailableSummerCourses.add(parallel);

        Node nhum1 = new Node(hum1, new ArrayList<Edge>());
        Node nhum2 = new Node(hum2, new ArrayList<Edge>());
        Node nhum3 = new Node(hum3, new ArrayList<Edge>());
        Node nhum4 = new Node(hum4, new ArrayList<Edge>());
        Node nhum5 = new Node(hum5, new ArrayList<Edge>());
        Node nfelec = new Node(felec, new ArrayList<Edge>());
        Node nlas204 = new Node(las204, new ArrayList<Edge>());
        Node nbio209 = new Node(bio209, new ArrayList<Edge>());
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
        // Node ncsc310L = new Node(csc310L, new ArrayList<Edge>());
        // Node ncsc245L = new Node(csc245L, new ArrayList<Edge>());
        // Node ncsc243L = new Node(csc243L, new ArrayList<Edge>());
        Node ncsc310 = new Node(csc310,
                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc1, 1), new Edge(ncsc2, 1),
                        new Edge(ncsc3, 1), new Edge(ncsc4, 1), new Edge(ncsc5, 1), new Edge(nparallel, 1))));
        Node ncsc375 = new Node(csc375,
                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc500, 0), new Edge(ncsc340, 0))));

        Node ncsc326 = new Node(csc326,
                new ArrayList<Edge>(Arrays.asList(new Edge(nparallel, 1), new Edge(ncsc430, 1))));
        Node ncsc230 = new Node(csc230,
                new ArrayList<Edge>(Arrays.asList(new Edge(ncsc326, 1), new Edge(ncsc230L, 0))));
        Node ncsc245 = new Node(csc245, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc310, 1),
                new Edge(ncsc326, 1), new Edge(ncsc375, 1), new Edge(ncsc230, 0))));
        Node nmth207 = new Node(mth207, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc380, 1),
                new Edge(ncsc375, 1), new Edge(ncsc310, 1), new Edge(ncsc230, 0))));
        Node ncsc243 = new Node(csc243, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc245, 1))));
        Node nmth201 = new Node(mth201, new ArrayList<Edge>(
                Arrays.asList(new Edge(nmth1, 1), new Edge(nmth305, 1), new Edge(ncsc380, 1))));
        Node ncom203 = new Node(com203, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc400, 0))));
        Node neng202 = new Node(eng202, new ArrayList<Edge>(Arrays.asList(new Edge(ncsc400, 0))));

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
        g.addNode(ncsc230);
        g.addNode(ncsc230L);
        // g.addNode(ncsc243L);
        // g.addNode(ncsc245L);
        // g.addNode(ncsc310L);
        g.addNode(ncsc310);
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

    }

}
