package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import entities.Course;

/**
 * Intializes courses. It creates the object courses, appedn them to a list, and
 * write them into a
 * file. Also included a function to modify into the file again, and read from
 * it
 */
public class InitCourses {
  private static final String COURSES_FILE = "courses.co";

  public static List<Course> loadCourses() {
    List<Course> courses = new ArrayList<>();
    File file = new File(COURSES_FILE);

    if (file.exists()) {
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COURSES_FILE))) {
        courses = (List<Course>) ois.readObject();
      } catch (ClassNotFoundException e) {

        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        saveCourses(initCourses());
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COURSES_FILE));
        courses = (List<Course>) ois.readObject();
      } catch (ClassNotFoundException e) {

        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return courses;
  }

  public static void saveCourses(List<Course> courses) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COURSES_FILE))) {
      oos.writeObject(courses);
    }
  }

  public static List<Course> initCourses() {
    List<Course> courses = new ArrayList<>();
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
    courses.add(csc243);
    courses.add(felec);
    courses.add(hum5);
    courses.add(hum4);
    courses.add(hum3);
    courses.add(hum2);
    courses.add(hum1);
    courses.add(mth1);
    courses.add(csc5);

    return courses;
  }

  public static void main(String[] args) {

  }

}
