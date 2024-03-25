package entities;

import java.util.List;

/**
 * Class represents a course in general, like in the catalogue. I made a course
 * and a node two
 * seperate objects just fr the sake of clarity, because a course has many
 * unecessary details we
 * don't care about during traversal liek the full name of the course ..etc.
 */
public class Course {
  private String name;
  private boolean required;
  private boolean major;
  private boolean isLab;
  private int crds;
  private List<Course> prereq;
  private List<Course> coreq;

  // constructor
  public Course(String name, boolean required, boolean major, boolean isLab, int crds,
      List<Course> prereq) {
    super();
    this.name = name;
    this.required = required;
    this.major = major;
    this.isLab = isLab;
    this.crds = crds;
    this.prereq = prereq;
  }

  public Course(String name, boolean required, boolean major, boolean isLab, int crds, List<Course> prereq,
      List<Course> coreq) {
    super();
    this.name = name;
    this.required = required;
    this.major = major;
    this.isLab = isLab;
    this.crds = crds;
    this.prereq = prereq;
    this.coreq = coreq;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public boolean isMajor() {
    return major;
  }

  public void setMajor(boolean major) {
    this.major = major;
  }

  public boolean isLab() {
    return this.isLab;
  }

  public void setisLab(boolean isLab) {
    this.isLab = isLab;
  }

  public int getCrds() {
    return crds;
  }

  public void setCrds(int crds) {
    this.crds = crds;
  }

  public List<Course> getPrereq() {
    return prereq;
  }

  public void setPrereq(List<Course> prereq) {
    this.prereq = prereq;
  }

  public List<Course> getCoreq() {
    return coreq;
  }

  public void setCoreq(List<Course> coreq) {
    this.coreq = coreq;
  }

}
