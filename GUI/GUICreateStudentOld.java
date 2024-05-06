//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.ButtonGroup;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//
//import app.InitCourses;
//import entities.Course;
//
//public class GUICreateStudentOld extends JFrame implements ActionListener
//{
//
//  private boolean isNew; // True if newly enrolled, false otherwise
//  private CardLayout cardLayout;
//  private Map<String, JPanel> stepPanels;
//  private JButton nextButton, previousButton, saveButton;
//  private String currentCard;
//  private JPanel mainPanel;
//  private static GUICreateStudent singleton;
//  private JComboBox<String> ddMajor;
//  private JComboBox<String> ddMinor;
//  private JTextField fnameField;
//  private JTextField lnameField;
//  private JTextField idField;
//  private JTextField semNbField;
//
//  // singleton pattern ensures object is only created once
//  public static GUICreateStudentOld createStudent(boolean isNew)
//  {
//    if (singleton == null)
//    {
//      singleton = new GUICreateStudentOld(isNew);
//    }
//    return singleton;
//  }
//
//  private GUICreateStudent(boolean isNew)
//  {
//
//    cardLayout = new CardLayout();
//    stepPanels = new HashMap<>();
//    mainPanel = new JPanel(cardLayout);
//    this.isNew = isNew;
//    currentCard=null;
//    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//  }
//
////  public void closeWindow()
////  {
////    singleton = null;
////    
////
////  }
//
//  public void init()
//  {
//    setSize(500, 500);
//    setVisible(true);
//    // add steps based on student status (enrolled or new)
//    stepPanels.put("card1", createCardPanel1());
//    stepPanels.put("card2", createCardPanel2());
//    if (!isNew)
//      stepPanels.put("card3", createCardPanel3());
//    for (String cardName : stepPanels.keySet())
//    {
//      mainPanel.add(stepPanels.get(cardName), cardName);
//    }
//
//    // Create buttons to navigate through steps
//    JPanel buttonPanel = new JPanel();
//
//    nextButton = new JButton("Next");
//    nextButton.addActionListener(this);
//    previousButton = new JButton("Previous");
//    previousButton.addActionListener(this);
//    saveButton = new JButton("Save & Continue");
//    saveButton.addActionListener(this);
//    saveButton.setVisible(false);
//    buttonPanel.add(previousButton);
//    buttonPanel.add(nextButton);
//    buttonPanel.add(saveButton);
//    
//    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//
//    getContentPane().add(Box.createVerticalStrut(30), BorderLayout.NORTH);
//    getContentPane().add(mainPanel, BorderLayout.CENTER);
//    getContentPane().add(Box.createHorizontalStrut(50), BorderLayout.WEST);
//    getContentPane().add(Box.createHorizontalStrut(50), BorderLayout.EAST);
//    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
//
//    // Set initial card
//    currentCard = "card1";
//    displayCard(currentCard);
//
//  }
//
//  // PERSONAL INFOS PANEL
//  private JPanel createCardPanel2()
//  {
//    JPanel container = new JPanel(new BorderLayout());
//
//    JPanel textPanel = new JPanel(new GridLayout(0, 1));
//    JLabel TitleLabel = new JLabel("Personal Information");
//    textPanel.add(TitleLabel);
//    JLabel textLabel = new JLabel("Please enter your personal information below");
//    textLabel.setFont(textLabel.getFont().deriveFont(Font.PLAIN, 12));
//    textPanel.add(textLabel);
//    container.add(textPanel, BorderLayout.NORTH);
//
//    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 15));
//    panel.setBorder(BorderFactory.createEmptyBorder(60, 0, 60, 0));
//    // Create labels and fields
//    JLabel fnameLabel = new JLabel("First Name: ");
//    fnameField = new JTextField(20);
//    panel.add(fnameLabel);
//    panel.add(fnameField);
//
//    JLabel lnameLabel = new JLabel("Last Name: ");
//    lnameField = new JTextField(20);
//    panel.add(lnameLabel);
//    panel.add(lnameField);
//    
//    JLabel idLabel = new JLabel("Student ID: ");
//    idField = new JTextField(20);
//    panel.add(idLabel);
//    panel.add(idField);
//
//    JLabel majorLabel = new JLabel("Select your major: ");
//    String[] optionsMajor = {"Computer Science", "Mathematics", "Biology"};
//    ddMajor = new JComboBox<>(optionsMajor);
//    ddMajor.setSelectedIndex(0);
//    ddMajor.addActionListener(this);
//    panel.add(majorLabel);
//    panel.add(ddMajor);
//
//    JLabel minorLabel = new JLabel("Select your minor: ");
//    String[] optionsMinor = {"None", "Mathematics", "Data Analytics"};
//    ddMinor = new JComboBox<>(optionsMinor);
//    ddMinor.setSelectedIndex(0);
//    ddMinor.addActionListener(this);
//    panel.add(minorLabel);
//    panel.add(ddMinor);
//    container.add(panel, BorderLayout.CENTER);
//
//    return container;
//  }
//
//  // PREVIOUS ACADEMIX PANEL
//  private JPanel createCardPanel3()
//  {
//    JPanel container = new JPanel(new BorderLayout());
//
//    JPanel textPanel = new JPanel(new GridLayout(0, 1));
//    JLabel TitleLabel = new JLabel("Previous Academics");
//    textPanel.add(TitleLabel);
//    JLabel textLabel = new JLabel("Please enter information related to your current projection plan");
//    textLabel.setFont(textLabel.getFont().deriveFont(Font.PLAIN, 12));
//    textPanel.add(textLabel);
//    container.add(textPanel, BorderLayout.NORTH);
//
//    JPanel panel = new JPanel(new GridLayout(0, 1));
//
//    //semester start
//    JLabel semsLabel = new JLabel("What semester did you start your degree?");
//    ButtonGroup optionGroup = new ButtonGroup();
//    JRadioButton option1 = new JRadioButton("FALL");
//    JRadioButton option2 = new JRadioButton("SPRING");
//    optionGroup.add(option1);
//    optionGroup.add(option2);
//    JPanel semesterStartPanel = new JPanel();
//    semesterStartPanel.add(option1);
//    semesterStartPanel.add(option2);
//    panel.add(semsLabel);
//    panel.add(semesterStartPanel);
//    
//    //nb of semesters
//    JPanel nbpanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
//    JLabel semNbLabel = new JLabel("How many semesters have you completed? (Summers not included)");
//    semNbField = new JTextField(20);
//    nbpanel.add(semNbLabel);
//    nbpanel.add(semNbField);
//    panel.add(nbpanel);
//    
//    
//    //courses selction
//    List<Course> coursesList = InitCourses.loadCourses();
//    Course[] courses= new Course[coursesList.size()];
//    int i=0;
//    for(Course c : coursesList) {
//      courses[i]=c;
//      i++;
//    }
//    
////    JPanel coursePickPnael = new JPanel();
//
//    JLabel courseLabel = new JLabel("Select All courses you have taken so far:");
//    panel.add(courseLabel);
//
//    // Dropdown for course selection
//    JComboBox<Course> courseComboBox = new JComboBox<>(new DefaultComboBoxModel<>(courses));
//    panel.add(courseComboBox);
//
//    // Button to add course
//    JButton addButton = new JButton("Add Course");
//    panel.add(addButton);
//
//    // Text area to display selected courses
//    JTextArea selectedCoursesArea = new JTextArea();
//    selectedCoursesArea.setEditable(false);
//    JScrollPane scrollPane = new JScrollPane(selectedCoursesArea);
//    panel.add(scrollPane);
//
//    Set<Course> selectedCourses = new HashSet<Course>();
//
//    addButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Course selectedCourse =  (Course) courseComboBox.getSelectedItem();
//            if (selectedCourse != null) {
//                selectedCourses.add(selectedCourse);
//                selectedCoursesArea.setText("");
//                for (Course course : selectedCourses) {
//                    selectedCoursesArea.append(course + "\n");
//                }
//            }
//        }
//    });
//
//    container.add(panel, BorderLayout.CENTER);
//
//    return container;
//  }
//
//  /**
//   * Function to switch cards based on current card.
//   */
//  private String getNextCard()
//  {
//    if (currentCard.equals("card1"))
//    { // go to card 2
//      return "card2";
//    }
//    else if (currentCard.equals("card2") && !isNew)
//    { // go to card 3
//      return "card3";
//    }
//    else
//      return null; // last card
//  }
//
//  private void displayCard(String card)
//  {
//    currentCard = card;
//    if (currentCard.equals("card1"))
//    { // first card
//
//      cardLayout.show(mainPanel, currentCard);
//      previousButton.setEnabled(false);
//      nextButton.setVisible(true);
//      saveButton.setVisible(false);
//    }
//    else if (currentCard.equals("card2") && isNew || currentCard.equals("card3"))
//    { // last card
//      cardLayout.show(mainPanel, currentCard);
//      previousButton.setEnabled(true);
//      nextButton.setVisible(false);
//      saveButton.setVisible(true);
//    }
//    else
//    { // middle card
//      cardLayout.show(mainPanel, currentCard);
//      previousButton.setEnabled(true);
//      nextButton.setVisible(true);
//      saveButton.setVisible(false);
//    }
//
//  }
//
//  /**
//   * Function to switch cards based on current card.
//   */
//  private String getPreviousCard()
//  {
//    if (currentCard.equals("card2"))
//    { // last card
//      return "card1";
//    }
//    else if (currentCard.equals("card3"))
//    { // go to card 3
//      return "card2";
//    }
//    else
//      return null; // first card
//  }
//
//  @Override
//  public void actionPerformed(ActionEvent e)
//  {
//    if (e.getSource() == nextButton)
//    {
//      
//      displayCard(getNextCard());
//
//    }
//    else if (e.getSource() == previousButton)
//    {
//      
//      displayCard(getPreviousCard());
//    }if (e.getSource() == saveButton)
//    {
//      this.setVisible(false);
//      GUIStudent g= new GUIStudent(null);
//
//    }
//
//  }
//}
