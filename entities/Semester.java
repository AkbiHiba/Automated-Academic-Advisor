package entities;

import java.util.ArrayList;
import java.util.List;

public class Semester {

  private String name;
  private boolean isSummer; // is the semester a summer or a regular semester
  private boolean isFinal; // is the last semester, this will be useful once we set a schedule
  private int maxCrds; // probably not needed
  private int currentCrds; // curentCrds in this semester, probably not needed
  private List<Node> nodesAtSemester;
  public static final int REGULAR_SEMESTER_CREDIT_LIMIT = 18;
  public static final int SUMMER_SEMESTER_CREDIT_LIMIT = 9;
  public static final int FINAL_SEMESTER_CREDIT_LIMIT = 21;

  public Semester(String name, boolean isSummer) {
    this.name = name;
    this.isSummer = isSummer;
    this.isFinal = false;
    this.nodesAtSemester = new ArrayList<>();
  }

  public List<Node> getNodesAtSemester() {
    return nodesAtSemester;
  }

  public void setNodesAtSemester(List<Node> nodesAtSemester) {
    this.nodesAtSemester = nodesAtSemester;
    this.currentCrds = getCurrentCrds();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isSummer() {
    return isSummer;
  }

  // probably not needed
  public void setSummer(boolean isSummer) {
    this.isSummer = isSummer;
    if (isSummer) {
      this.setMaxCrds(SUMMER_SEMESTER_CREDIT_LIMIT);
    } else {
      this.setMaxCrds(REGULAR_SEMESTER_CREDIT_LIMIT);
    }
  }

  public boolean isFinal() {
    return isFinal;
  }

  public void setFinal(boolean isFinal) {
    this.isFinal = isFinal;
  }

  public String toString() {
    return name + "(" + getCurrentCrds() + ")" + nodesAtSemester;
  }

  public int getMaxCrds() {
    return maxCrds;
  }

  public void setMaxCrds(int max_crds) {
    this.maxCrds = max_crds;
  }

  public int getCurrentCrds() {
    int x = 0;
    for (Node n : nodesAtSemester) {
      x += n.getCourse().getCrds();
    }

    return x;
  }

  public void setCurrentCrds(int current_crds) {
    this.currentCrds = current_crds;
  }

  /**
   * Function that generates the combinations of summers across the projection
   * plan. Takes k is the
   * maximum amount of summers allowed, generate combinations like [summer 1: yes,
   * summer 2: no],
   * [summer 1: no, summer 2: no] ...etc
   */
  private static List<int[]> generateCombinations(int k) {
    List<int[]> combinations = new ArrayList<>();
    int[] options = { 1, 0 };

    for (int i = 0; i < Math.pow(2, k); i++) {
      int[] combo = new int[k];
      for (int j = 0; j < k; j++) {
        combo[j] = options[(i >> j) & 1];
      }
      combinations.add(combo);
      // System.out.println(Arrays.toString(combo));
    }

    return combinations;
  }

  /**
   * Returns a list of all semester combinations, starting from the combination
   * with no summers.
   * takes the total amount of regular semester needed (6 for a regular projection
   * plan). for
   * example: [r,r,s,r,r,s,r,r] or [r,r,s,r,r,r,r]
   */
  public static List<List<Semester>> generateSemestersCombinations(int maxRegSemesters) {

    // calculate how many sumemrs we cna add based on number of semesters
    int max_summers = (int) Math.ceil(maxRegSemesters / 2.0) - 1;

    // generate our combinations of summers
    List<int[]> summerCombinations = generateCombinations(max_summers);
    List<List<Semester>> semesterCombinations = new ArrayList<>();

    for (int i = summerCombinations.size() - 1; i >= 0; i--)
    // for every combination of summers , starting from no summers [0,0]

    {
      List<Semester> currentCombination = new ArrayList<Semester>();
      int summersAdded = 0;
      for (int j = 0; j < maxRegSemesters; j++) {
        if (j != 0 && j % 2 == 0) // index for a summer
        {
          if (summerCombinations.get(i)[summersAdded] == 1) {
            currentCombination.add(new Semester("S", true));

          }
          summersAdded++;

        }
        currentCombination.add(new Semester("R", false));

      }
      currentCombination.get(currentCombination.size() - 1).setFinal(true);
      semesterCombinations.add(currentCombination);
    }
    return semesterCombinations;
  }

}
