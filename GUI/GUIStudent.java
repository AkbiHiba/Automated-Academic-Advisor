package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import app.InitUser;
import entities.User;

/**
 * GUI of the student First thing to see when running.
 */
public class GUIStudent extends JFrame implements ActionListener
{
  /**
   * 
   */
  private static final long serialVersionUID = 2686597542318598592L;
  private File file;
  private JTabbedPane tabs;
  private User user;

  public GUIStudent(File f)
  {
    tabs = new JTabbedPane(JTabbedPane.TOP);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.file=f;
    user = InitUser.loadUser(file);
    init();
  }

  private void init()
  {

    // Create panels for new windows (content displayed within tabs)
    JPanel homePanel = createHomePanel();
    JPanel aboutPanel = createAboutPanel();
    JPanel courseCatalogPanel = createCatalogPanel();
    JPanel advisingPanel = createAdvisingPanel();
    JPanel userInfoPanel = createUserInfoPanel();

    // Add panels to the tabbed pane
    tabs.addTab("Home", homePanel);
    tabs.addTab("User Info", userInfoPanel);
    tabs.addTab("Advising", advisingPanel);
    tabs.addTab("Catalog", courseCatalogPanel);
    tabs.addTab("About", aboutPanel);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(tabs, BorderLayout.CENTER);

    setSize(700, 500);
    setVisible(true);
  }

  private JPanel createHomePanel()
  {
    JPanel homePanel;
    homePanel = new JPanel(new BorderLayout());
    homePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    homePanel.add(Box.createHorizontalStrut(60), BorderLayout.WEST);
    homePanel.add(Box.createHorizontalStrut(60), BorderLayout.EAST);

    JPanel outerPanel= panelHelperWelcome(user.getFname()+ ", welcome to the Automatic Academic Advisor","Find below the advising calendar.");
    homePanel.add(outerPanel, BorderLayout.NORTH);

    // copyright panel
    JPanel copyRightPanel = new JPanel();
    copyRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    JLabel copyrightLabel = new JLabel(
        "© 2024 Lebanese American University. All rights reserved. This Automatic Academic Advisor application is protected by copyright.");
    copyrightLabel.setFont(copyrightLabel.getFont().deriveFont(Font.PLAIN, 8));
    copyRightPanel.add(copyrightLabel);
    homePanel.add(copyRightPanel, BorderLayout.SOUTH);

    // Add the home panel to the frame
    return homePanel;
  }

  private JPanel createAboutPanel()
  {

    JPanel aboutPanel = new JPanel(new BorderLayout());
    aboutPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
    aboutPanel.add(Box.createHorizontalStrut(60), BorderLayout.WEST);
    aboutPanel.add(Box.createHorizontalStrut(60), BorderLayout.EAST);

    JTextArea textArea = new JTextArea(20, 50); // Adjust rows and columns as needed
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);

    // Add some sample text
    String text = "This is a large amount of text that will be displayed \nin a scrollable text box. You can add any content here. \nThis text box allows you to scroll through the content if it's too large to fit in the window.";
    textArea.append(text);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show
                                                                                  // scroll bar

    aboutPanel.add(scrollPane, BorderLayout.CENTER);

    // copyright panel
    JPanel copyRightPanel = new JPanel();
    copyRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    JLabel copyrightLabel = new JLabel(
        "© 2024 Lebanese American University. All rights reserved. This Automatic Academic Advisor application is protected by copyright.");
    copyrightLabel.setFont(copyrightLabel.getFont().deriveFont(Font.PLAIN, 8));
    copyRightPanel.add(copyrightLabel);
    aboutPanel.add(copyRightPanel, BorderLayout.SOUTH);
    return aboutPanel;
  }

  // CATALOG displays courses and their infos and all
  private JPanel createCatalogPanel()
  {

    JPanel catalogPanel = new JPanel(new BorderLayout());
    catalogPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
    catalogPanel.add(Box.createHorizontalStrut(60), BorderLayout.WEST);
    catalogPanel.add(Box.createHorizontalStrut(60), BorderLayout.EAST);

    // copyright panel
    JPanel copyRightPanel = new JPanel();
    copyRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    JLabel copyrightLabel = new JLabel(
        "© 2024 Lebanese American University. All rights reserved. This Automatic Academic Advisor application is protected by copyright.");
    copyrightLabel.setFont(copyrightLabel.getFont().deriveFont(Font.PLAIN, 8));
    copyRightPanel.add(copyrightLabel);
    catalogPanel.add(copyRightPanel, BorderLayout.SOUTH);

    return catalogPanel;
  }

  // USER INFO displays courses and their infos and all
  private JPanel createUserInfoPanel()
  {

    JPanel userInfoPanel = new JPanel(new BorderLayout());
    userInfoPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
    userInfoPanel.add(Box.createHorizontalStrut(60), BorderLayout.WEST);
    userInfoPanel.add(Box.createHorizontalStrut(60), BorderLayout.EAST);

    JPanel outerPanel= panelHelperWelcome("Your Profile","Find below your student information.");
    userInfoPanel.add(outerPanel, BorderLayout.NORTH);
    
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    JPanel fname = panelHelper("First name: ", user.getFname());
    JPanel lname = panelHelper("Last name: ", user.getLname());
    JPanel id = panelHelper("ID: ", user.getID());
    JPanel major = panelHelper("Major: ", user.getMajor());
    JPanel minor = panelHelper("Minor: ", user.getMinor());
    JPanel startSem = panelHelper("First Enrolled Semester: ", user.getStartSemester());
    JPanel completedCRds = panelHelper("Number of Credits Completed: ", Integer.toString(user.getCreditsCompleted()));
    
    mainPanel.add(fname);
    mainPanel.add(lname);
    mainPanel.add(id);
    mainPanel.add(major);
    mainPanel.add(minor);
    mainPanel.add(startSem);
    mainPanel.add(completedCRds);

    userInfoPanel.add(mainPanel, BorderLayout.NORTH);

    // copyright panel
    JPanel copyRightPanel = new JPanel();
    copyRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    JLabel copyrightLabel = new JLabel(
        "© 2024 Lebanese American University. All rights reserved. This Automatic Academic Advisor application is protected by copyright.");
    copyrightLabel.setFont(copyrightLabel.getFont().deriveFont(Font.PLAIN, 8));
    copyRightPanel.add(copyrightLabel);
    userInfoPanel.add(copyRightPanel, BorderLayout.SOUTH);

    return userInfoPanel;
  }

  
  /**Helper function to create fields in user Info*/
  private JPanel panelHelper(String labelText, String field)
  {

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));

    JLabel label = new JLabel(labelText);
    label.setFont(label.getFont().deriveFont(Font.BOLD));
    panel.add(label);

    JLabel fieldLabel = new JLabel(field);
    panel.add(fieldLabel);

    return panel;
  }
  
  /**Helper fucntion to create the explanatory text at the begining to each panel*/
  private JPanel panelHelperWelcome(String title, String text) 
  {

    FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
    JPanel outerPanel = new JPanel(flowLayout);
    JPanel textPanel = new JPanel(new GridLayout(0, 1));
    textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    JLabel welcomeLabel = new JLabel(title);
    textPanel.add(welcomeLabel);
    JLabel optionLabel = new JLabel(text);
    optionLabel.setFont(optionLabel.getFont().deriveFont(Font.PLAIN, 12));
    textPanel.add(optionLabel);
    outerPanel.add(textPanel);
    
    return outerPanel;
  }

  // ADVISING PANEL displays the advising
  private JPanel createAdvisingPanel()
  {

    JPanel advisingPanel = new JPanel(new BorderLayout());
    advisingPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
    advisingPanel.add(Box.createHorizontalStrut(60), BorderLayout.WEST);
    advisingPanel.add(Box.createHorizontalStrut(60), BorderLayout.EAST);

    // copyright panel
    JPanel copyRightPanel = new JPanel();
    copyRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    JLabel copyrightLabel = new JLabel(
        "© 2024 Lebanese American University. All rights reserved. This Automatic Academic Advisor application is protected by copyright.");
    copyrightLabel.setFont(copyrightLabel.getFont().deriveFont(Font.PLAIN, 8));
    copyRightPanel.add(copyrightLabel);
    advisingPanel.add(copyRightPanel, BorderLayout.SOUTH);

    return advisingPanel;
  }

  /** Click behaviors on different elements */
  @Override
  public void actionPerformed(ActionEvent e)
  {

  }

}
