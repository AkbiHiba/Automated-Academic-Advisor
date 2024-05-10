package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3405451627527871966L;
  private String fname;
  private String lname;
  private String ID;
  private int creditsCompleted;
  private int nbSemestersCompleted;
  private String standing;
  private String major;
  private String minor;
  private String startSemester;
  private List<Semester> projection;
  private List<Course> completedCourses;

  public User(String fname, String lname, String ID, String major, String minor, String start, int nbSemestersCompleted,
      List<Course> completedCourses) {
    this.fname = fname;
    this.lname = lname;
    this.ID = ID;
    this.major = major;
    this.minor = minor;
    this.startSemester = start;
    this.nbSemestersCompleted = nbSemestersCompleted;
    this.projection = new ArrayList<Semester>();
    this.completedCourses = completedCourses;
    this.creditsCompleted = getCreditsCompleted();
  }

  public User(String fname, String lname, String ID, String major, String minor, String start) {
    this.fname = fname;
    this.lname = lname;
    this.ID = ID;
    this.major = major;
    this.minor = minor;
    this.startSemester = start;
    this.projection = new ArrayList<Semester>();
    this.completedCourses = new ArrayList<Course>();
    this.creditsCompleted = 0;
  }

  public int getCreditsCompleted() {
    int totalCreditsCompleted = 0;
    if (completedCourses == null)
      return 0;
    for (Course c : completedCourses) {
      totalCreditsCompleted += c.getCrds();
    }
    return totalCreditsCompleted;
  }

  public int getNbSemestersCompleted() {
    return nbSemestersCompleted;
  }

  public void setNbSemestersCompleted(int nbSemestersCompleted) {
    this.nbSemestersCompleted = nbSemestersCompleted;
  }

  public String getStanding() {
    return standing;
  }

  public void setStanding(String standing) {
    this.standing = standing;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getMinor() {
    return minor;
  }

  public void setMinor(String minor) {
    this.minor = minor;
  }

  public String getStartSemester() {
    return startSemester;
  }

  public void setStartSemester(String startSemester) {
    this.startSemester = startSemester;
  }

  public List<Semester> getProjection() {
    return projection;
  }

  public void setProjection(List<Semester> projection) {
    this.projection = projection;
  }

  public List<Course> getCompletedCourses() {
    return completedCourses;
  }

  public void setCompletedCourses(List<Course> completedCourses) {
    this.completedCourses = completedCourses;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getID() {
    return ID;
  }

  public void setID(String iD) {
    ID = iD;
  }

}
