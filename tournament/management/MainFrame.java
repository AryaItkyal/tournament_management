/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends javax.swing.JFrame {



    private final String userName = "root";
    private final String password = "1234";
    int count = 0;
    private int teamId;
    private int updateId;
    Statement statement = null;
    private ResultSet resultSet = null;
    private String DATABASE_URL = "jdbc:mysql://localhost:3306/ipl";
    ArrayList<String> teamName = new ArrayList<String>();
    ArrayList<String> playerName = new ArrayList<String>();
    ArrayList<String> allName = new ArrayList<String>();
    // Variables declaration - do not modify
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel ExitLabel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JPanel PlayerManagePanel;
    private javax.swing.JLabel SearchLabel;
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JPanel addPlayerPanel;
    private javax.swing.JButton addTeamButton;
    private javax.swing.JPanel addTeamPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deletePlayerButton;
    private javax.swing.JButton deleteTeamButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel leagueTablePanel;
    private javax.swing.JLabel managePlayerLabel;
    private javax.swing.JLabel manageTeamLabel;
    private javax.swing.JPanel matchResultPanel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton playerButton;
    private javax.swing.JComboBox playerComboBox;
    private javax.swing.JLabel playerManagementLabel;
    private javax.swing.JPanel playerProfilePanel;
    private javax.swing.JTable playerTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton teamButton;
    private javax.swing.JComboBox teamComboBox;
    private javax.swing.JPanel teamManagePanel;
    private javax.swing.JLabel teamManagementLabel;
    private javax.swing.JTable teamManagementTable;
    private javax.swing.JLabel teamNameLabel;
    private javax.swing.JTextField teamNameTextField;
    private javax.swing.JComboBox teamPreferenceComboBox;
    private javax.swing.JButton updatePlayerButton;
    private javax.swing.JPanel updatePlayerPanel;
    private javax.swing.JButton updateTeamButton;
    private javax.swing.JPanel updateTeamPanel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTextField valueTextField;
    private javax.swing.JLabel yearFoundedLabel;
    private javax.swing.JTextField yearFoundedTextField;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

                        Properties props = new Properties();
                        props.put("logoString", "my company");
                        HiFiLookAndFeel.setCurrentTheme(props);
                        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new MainFrame().setVisible(true);
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LoginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        userNameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        MainMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        playerButton = new javax.swing.JButton();
        teamButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        SearchLabel = new javax.swing.JLabel();
        managePlayerLabel = new javax.swing.JLabel();
        ExitLabel = new javax.swing.JLabel();
        manageTeamLabel = new javax.swing.JLabel();
        teamManagePanel = new javax.swing.JPanel();
        teamManagementLabel = new javax.swing.JLabel();
        addTeamButton = new javax.swing.JButton();
        updateTeamButton = new javax.swing.JButton();
        deleteTeamButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        teamManagementTable = new javax.swing.JTable();
        teamComboBox = new javax.swing.JComboBox();
        jButton15 = new javax.swing.JButton();
        PlayerManagePanel = new javax.swing.JPanel();
        playerManagementLabel = new javax.swing.JLabel();
        addPlayerButton = new javax.swing.JButton();
        updatePlayerButton = new javax.swing.JButton();
        deletePlayerButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        playerComboBox = new javax.swing.JComboBox();
        jButton16 = new javax.swing.JButton();
        addPlayerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel80 = new javax.swing.JLabel();
        teamPreferenceComboBox = new javax.swing.JComboBox();
        addTeamPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        teamNameLabel = new javax.swing.JLabel();
        teamNameTextField = new javax.swing.JTextField();
        yearFoundedLabel = new javax.swing.JLabel();
        yearFoundedTextField = new javax.swing.JTextField();
        valueLabel = new javax.swing.JLabel();
        valueTextField = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        playerProfilePanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        updatePlayerPanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        updateTeamPanel = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        leagueTablePanel = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        matchResultPanel = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel85 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel89 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Login");

        userNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userNameLabel.setText("User name ");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Password");

        signInButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signInButton.setText("Sign in");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        ExitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(userNameTextField)
                                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(96, 96, 96)
                                                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameLabel))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
                LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(141, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
                LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(178, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(513, 513, 513))
        );

        jPanel1.add(LoginPanel, "loginPanelCard");

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 3, 34)); // NOI18N
        jLabel2.setText("Tournament Management System");

        playerButton.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cricketer-90.png")))); // NOI18N
        playerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerButtonActionPerformed(evt);
            }
        });

        teamButton.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("team.png")))); // NOI18N
        teamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamButtonActionPerformed(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("search.png")))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-logout-100.png")))); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        SearchLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchLabel.setText("Standing");

        managePlayerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        managePlayerLabel.setText("Manage Players");

        ExitLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ExitLabel.setText("Log out");

        manageTeamLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageTeamLabel.setText("Manage Teams");

        javax.swing.GroupLayout MainMenuLayout = new javax.swing.GroupLayout(MainMenu);
        MainMenu.setLayout(MainMenuLayout);
        MainMenuLayout.setHorizontalGroup(
                MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainMenuLayout.createSequentialGroup()
                                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainMenuLayout.createSequentialGroup()
                                                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMenuLayout.createSequentialGroup()
                                                                .addGap(93, 93, 93)
                                                                .addComponent(SearchLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(manageTeamLabel)
                                                                .addGap(98, 98, 98))
                                                        .addGroup(MainMenuLayout.createSequentialGroup()
                                                                .addGap(64, 64, 64)
                                                                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(MainMenuLayout.createSequentialGroup()
                                                                                .addComponent(searchButton)
                                                                                .addGap(54, 54, 54)
                                                                                .addComponent(teamButton)))
                                                                .addGap(52, 52, 52)))
                                                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(playerButton)
                                                        .addGroup(MainMenuLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(managePlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(MainMenuLayout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMenuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ExitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(285, 285, 285))
        );
        MainMenuLayout.setVerticalGroup(
                MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(teamButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(searchButton)
                                                .addComponent(playerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(managePlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(manageTeamLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(exitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ExitLabel)
                                .addGap(82, 82, 82))
        );

        jPanel1.add(MainMenu, "mainMenuCard");

        teamManagementLabel.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        teamManagementLabel.setText("Team Management");

        addTeamButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addTeamButton.setText("Add Team ");
        addTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamButtonActionPerformed(evt);
            }
        });

        updateTeamButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateTeamButton.setText("Update Team");
        updateTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTeamButtonActionPerformed(evt);
            }
        });

        deleteTeamButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteTeamButton.setText("Match Result");
        deleteTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTeamButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        teamManagementTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Team ID", "Team Name", "Year Founded", "Value"
                }
        ) {
            final Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(teamManagementTable);
        if (teamManagementTable.getColumnModel().getColumnCount() > 0) {
            teamManagementTable.getColumnModel().getColumn(0).setResizable(false);
            teamManagementTable.getColumnModel().getColumn(1).setResizable(false);
            teamManagementTable.getColumnModel().getColumn(3).setResizable(false);
        }

        teamComboBox.setEditable(true);
        teamComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton15.setText("Search");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teamManagePanelLayout = new javax.swing.GroupLayout(teamManagePanel);
        teamManagePanel.setLayout(teamManagePanelLayout);
        teamManagePanelLayout.setHorizontalGroup(
                teamManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamManagePanelLayout.createSequentialGroup()
                                .addContainerGap(204, Short.MAX_VALUE)
                                .addComponent(teamManagementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182))
                        .addGroup(teamManagePanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(teamManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addTeamButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteTeamButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(updateTeamButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(teamManagePanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(teamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(29, 29, 29))
        );
        teamManagePanelLayout.setVerticalGroup(
                teamManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(teamManagePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(teamManagementLabel)
                                .addGap(20, 20, 20)
                                .addGroup(teamManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(teamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(teamManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(teamManagePanelLayout.createSequentialGroup()
                                                .addComponent(addTeamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)
                                                .addComponent(updateTeamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(deleteTeamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(74, 74, 74)
                                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(113, Short.MAX_VALUE))
        );

        jPanel1.add(teamManagePanel, "teamManageCard");

        playerManagementLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        playerManagementLabel.setText("PLAYER MANAGEMENT ");

        addPlayerButton.setText("ADD PLAYER");
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });

        updatePlayerButton.setText("UPDATE PLAYER");
        updatePlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePlayerButtonActionPerformed(evt);
            }
        });

        deletePlayerButton.setText("DELETE PLAYER");
        deletePlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePlayerButtonActionPerformed(evt);
            }
        });

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        playerTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Player ID ", "First Name", "Last Name", "Team Name"
                }
        ) {
            final Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            final boolean[] canEdit = new boolean[]{
                    false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(playerTable);

        jButton2.setText("PLAYER PROFILE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        playerComboBox.setEditable(true);
        playerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton16.setText("Search");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlayerManagePanelLayout = new javax.swing.GroupLayout(PlayerManagePanel);
        PlayerManagePanel.setLayout(PlayerManagePanelLayout);
        PlayerManagePanelLayout.setHorizontalGroup(
                PlayerManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerManagePanelLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(playerManagementLabel)
                                .addContainerGap(168, Short.MAX_VALUE))
                        .addGroup(PlayerManagePanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(PlayerManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(updatePlayerButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addPlayerButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deletePlayerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PlayerManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PlayerManagePanelLayout.createSequentialGroup()
                                                .addComponent(playerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PlayerManagePanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2)
                                                .addContainerGap())))
        );
        PlayerManagePanelLayout.setVerticalGroup(
                PlayerManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerManagePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(playerManagementLabel)
                                .addGap(32, 32, 32)
                                .addGroup(PlayerManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(playerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PlayerManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PlayerManagePanelLayout.createSequentialGroup()
                                                .addComponent(addPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(updatePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(deletePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel1.add(PlayerManagePanel, "playerManageCard");

        jLabel3.setBackground(java.awt.Color.lightGray);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setText("                ADD PLAYER");

        jLabel4.setText("First Name");

        jLabel5.setText("Last Name");

        jLabel6.setText("Registration Number");

        jLabel7.setText("Country");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Bangladesh", "Nepal", "India", "Pakistan", "Sri-Lanka", "Bhutan", "Bhutan", "Japan", "China", "South-Korea", "North-Korea"}));

        jLabel9.setText("Team");

        jComboBox3.setEditable(true);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"No Team", "CoreI7", "Chetona71", "Race71", " "}));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("ADD PLAYER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("BACK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel79.setText("Role");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Batsmen", "Bowler", "All Rounder"}));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel80.setText("Team Preference:");

        teamPreferenceComboBox.setEditable(true);
        teamPreferenceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        javax.swing.GroupLayout addPlayerPanelLayout = new javax.swing.GroupLayout(addPlayerPanel);
        addPlayerPanel.setLayout(addPlayerPanelLayout);
        addPlayerPanelLayout.setHorizontalGroup(
                addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPlayerPanelLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPlayerPanelLayout.createSequentialGroup()
                                                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(teamPreferenceComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 119, Short.MAX_VALUE))))
                                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel5)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPlayerPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel4)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE))
                                        .addComponent(jLabel80))
                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                .addGap(122, 122, 122)
                                                .addComponent(jButton4))
                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel9)
                                                .addGap(51, 51, 51)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32))
        );
        addPlayerPanelLayout.setVerticalGroup(
                addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel7))
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel79)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addPlayerPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel80)
                                                .addGap(99, 99, 99)
                                                .addGroup(addPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(teamPreferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel1.add(addPlayerPanel, "card6");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel16.setText("ADD TEAM ");

        teamNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        teamNameLabel.setText("Team Name :");

        teamNameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        yearFoundedLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yearFoundedLabel.setText("Year Founded :");

        yearFoundedTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        valueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        valueLabel.setText("Value :");

        valueTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("ADD TEAM");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("BACK");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addTeamPanelLayout = new javax.swing.GroupLayout(addTeamPanel);
        addTeamPanel.setLayout(addTeamPanelLayout);
        addTeamPanelLayout.setHorizontalGroup(
                addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addTeamPanelLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yearFoundedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(teamNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(valueTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                .addComponent(yearFoundedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(teamNameTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTeamPanelLayout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(186, 186, 186))
        );
        addTeamPanelLayout.setVerticalGroup(
                addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTeamPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16)
                                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addTeamPanelLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(teamNameLabel)
                                                        .addComponent(teamNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(90, 90, 90)
                                                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(yearFoundedLabel)
                                                        .addComponent(yearFoundedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(84, 84, 84)
                                                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(valueLabel)
                                                        .addComponent(valueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 260, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTeamPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(103, 103, 103))))
        );

        jPanel1.add(addTeamPanel, "card7");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("PLAYER PROFILE");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("First Name :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("f_name");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Last Name :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("l_name");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Country     :");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("jLabel26");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Team         :");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("jLabel35");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setText("Information");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playerProfilePanelLayout = new javax.swing.GroupLayout(playerProfilePanel);
        playerProfilePanel.setLayout(playerProfilePanelLayout);
        playerProfilePanelLayout.setHorizontalGroup(
                playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerProfilePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193))
                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(jLabel43)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playerProfilePanelLayout.setVerticalGroup(
                playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(playerProfilePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel17)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel43)
                                .addGap(34, 34, 34)
                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel26))
                                .addGap(65, 65, 65)
                                .addGroup(playerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel35))
                                .addGap(54, 54, 54)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(125, Short.MAX_VALUE))
        );

        jPanel1.add(playerProfilePanel, "playerProfile");

        jLabel22.setBackground(java.awt.Color.lightGray);
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel22.setText("             UPDATE PLAYER");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("First Name");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Last Name");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("UPDATE PLAYER");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("BACK");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updatePlayerPanelLayout = new javax.swing.GroupLayout(updatePlayerPanel);
        updatePlayerPanel.setLayout(updatePlayerPanelLayout);
        updatePlayerPanelLayout.setHorizontalGroup(
                updatePlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatePlayerPanelLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(updatePlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(updatePlayerPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, updatePlayerPanelLayout.createSequentialGroup()
                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(updatePlayerPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addGap(58, 58, 58)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(100, 100, 100)
                                .addComponent(jButton9)
                                .addGap(152, 152, 152))
        );
        updatePlayerPanelLayout.setVerticalGroup(
                updatePlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updatePlayerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(updatePlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(updatePlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel24)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(235, 235, 235)
                                .addGroup(updatePlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel1.add(updatePlayerPanel, "card_updateplayer");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 255));
        jLabel44.setText("TEAM UPDATE");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("Team Name     :");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setText("Foundation Year:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("Value              :");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setText("UPDATE");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton12.setText("BACK");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updateTeamPanelLayout = new javax.swing.GroupLayout(updateTeamPanel);
        updateTeamPanel.setLayout(updateTeamPanelLayout);
        updateTeamPanelLayout.setHorizontalGroup(
                updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updateTeamPanelLayout.createSequentialGroup()
                                .addGroup(updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(updateTeamPanelLayout.createSequentialGroup()
                                                .addGap(152, 152, 152)
                                                .addGroup(updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                                        .addComponent(jTextField6)
                                                        .addComponent(jTextField7)))
                                        .addGroup(updateTeamPanelLayout.createSequentialGroup()
                                                .addGap(191, 191, 191)
                                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(256, Short.MAX_VALUE))
                        .addGroup(updateTeamPanelLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142))
        );
        updateTeamPanelLayout.setVerticalGroup(
                updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updateTeamPanelLayout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addGroup(updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addGroup(updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel46)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addGroup(updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel47)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addGroup(updateTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(113, 113, 113))
        );

        jPanel1.add(updateTeamPanel, "card10");

        jTextField9.setText("jTextField9");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(165, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(549, Short.MAX_VALUE))
        );

        jPanel1.add(searchPanel, "card11");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel81.setText("LEAGUE TABLE");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane3.setViewportView(jTable1);

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setText("BACK");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leagueTablePanelLayout = new javax.swing.GroupLayout(leagueTablePanel);
        leagueTablePanel.setLayout(leagueTablePanelLayout);
        leagueTablePanelLayout.setHorizontalGroup(
                leagueTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leagueTablePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))
                        .addGroup(leagueTablePanelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButton20)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leagueTablePanelLayout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );
        leagueTablePanelLayout.setVerticalGroup(
                leagueTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leagueTablePanelLayout.createSequentialGroup()
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel1.add(leagueTablePanel, "card14");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel82.setText("MATCH RESULT");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel83.setText("HOME");

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel84.setText("Team");

        jComboBox4.setEditable(true);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel85.setText("Result");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Win", "Draw", "Loss"}));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel87.setText("AWAY");

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel88.setText("Team");

        jComboBox7.setEditable(true);
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel89.setText("Result");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Win", "Draw", "Loss"}));

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setText("BACK");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.setText("DONE");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout matchResultPanelLayout = new javax.swing.GroupLayout(matchResultPanel);
        matchResultPanel.setLayout(matchResultPanelLayout);
        matchResultPanelLayout.setHorizontalGroup(
                matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(224, Short.MAX_VALUE))
                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, matchResultPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel88)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel84)
                                                                                .addGap(28, 28, 28)
                                                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(39, 39, 39)
                                                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel85)
                                                                        .addComponent(jLabel89))
                                                                .addGap(36, 36, 36)
                                                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(323, Short.MAX_VALUE))
                                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(250, 250, 250))))
        );
        matchResultPanelLayout.setVerticalGroup(
                matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, matchResultPanelLayout.createSequentialGroup()
                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(matchResultPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(jLabel83)
                                                .addGap(27, 27, 27)
                                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel84)
                                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel85)
                                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(108, 108, 108)
                                                .addComponent(jLabel87)
                                                .addGap(18, 18, 18)
                                                .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel88)
                                                        .addGroup(matchResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel89)
                                                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 227, Short.MAX_VALUE)))
                                .addGap(43, 43, 43))
        );

        jPanel1.add(matchResultPanel, "card15");

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>

    private void jComboBox2ActionPerformed(ActionEvent evt) {
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // TODO add your handling code here:
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT Team_Name,Played,Win,Draw,Loss,Point FROM league_standing ORDER BY Point DESC"));
            jTable1.setModel(DbUtils.resultSetToTableModel(getResultSet()));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "card14");
        DatabaseConnection.closeConnection();

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "mainMenuCard");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "mainMenuCard");
    }

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String username = userNameTextField.getText();
            String password = new String(jPasswordField1.getPassword());

            AbstractAuthenticator authenticator;

            if (username.isEmpty() || password.isEmpty()) {
                authenticator = new EmptyAuthenticator(DatabaseConnection.connection);
            } else {
                authenticator = new NormalAuthenticator(DatabaseConnection.connection);
            }

            authenticator.authenticate(username, password);

            // Authentication successful
            CardLayout card = (CardLayout) jPanel1.getLayout();
            card.show(jPanel1, "mainMenuCard");
            userNameTextField.setText(null);
            jPasswordField1.setText(null);

            createArrayListDB();
            createArrayListDB2();
            searchPlayer();
            searchCompany();

        } catch (AuthenticationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        DatabaseConnection.closeConnection();
    }







    private void teamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // TODO add your handling code here:
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT * FROM team WHERE Value > 0"));
            ResultSetMetaData resultSetMetaData = getResultSet().getMetaData();
            teamManagementTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "teamManageCard");
        DatabaseConnection.closeConnection();

    }

    private void playerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // TODO add your handling code here: CardLayout card = (CardLayout) jPanel1.getLayout();
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT Player_ID,First_name,Last_Name,Team_Name,Country_Name FROM player_info Natural join team WHERE team.`Team_ID`=player_info.`Team_ID`"));

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        playerTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));
        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "playerManageCard");
        DatabaseConnection.closeConnection();

    }

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "card6");
    }

    private void addTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "card7");
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        teamNameTextField.setText(null);
        yearFoundedTextField.setText(null);
        valueTextField.setText(null);
        try {

            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT * FROM team"));
            teamManagementTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "teamManageCard");
        DatabaseConnection.closeConnection();

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String teamName = teamNameTextField.getText();
        String yearFoundation = (yearFoundedTextField.getText());
        String value = (valueTextField.getText());

        if (teamName.equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Insert A Team Name ");


        } else if (yearFoundation.equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Insert A Foundation Year ");
        } else if (value.equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Insert A Value ");
        } else {
            String query = "INSERT INTO team(Team_Name,Year_Founded,Value) values(" +
                    "'" + teamName + "' " + " ," + Integer.parseInt(yearFoundation) + " ," + Integer.parseInt(value) + " )";

            System.out.println("query:" + query);


            try {
                Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Team has been inserted successfully ");
            teamNameTextField.setText(null);
            yearFoundedTextField.setText(null);
            valueTextField.setText(null);
        }
        DatabaseConnection.closeConnection();

    }

    private void deleteTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "card15");

    }

    private void updateTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int row = teamManagementTable.getSelectedRow();
        int column = teamManagementTable.getColumnCount();
        int teamId = 0;
        String teamName = null;
        int yearFounded = 0;
        int value = 0;
        try {
            teamId = (int) teamManagementTable.getValueAt(row, 0);
            teamName = (String) teamManagementTable.getValueAt(row, 1);
            yearFounded = (int) teamManagementTable.getValueAt(row, 2);
            value = (int) teamManagementTable.getValueAt(row, 3);
            System.out.println("TeamId:" + teamId);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "please select a Team");
            return;
        }

        jTextField6.setText(teamName);
        jTextField7.setText(Integer.toString(yearFounded));
        jTextField8.setText(Integer.toString(value));


        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "card10");
    }

    private void deletePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int row = playerTable.getSelectedRow();
        int column = playerTable.getColumnCount();
        int id = 0;
        try {
            id = (int) playerTable.getValueAt(row, 0);
            String name = (String) playerTable.getValueAt(row, 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "please select a Item");
        }


        String deletedString = "DELETE FROM player_info WHERE Player_ID=" + id;


        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            statement.executeUpdate(deletedString);


            setResultSet(statement.executeQuery("SELECT * FROM player_info"));
            playerTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));
            JOptionPane.showMessageDialog(this, "Player has been deleted successfully");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseConnection.closeConnection();
    }

    private void updatePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int row = playerTable.getSelectedRow();
        int column = playerTable.getColumnCount();
        String firstName = null;
        String lastName = null;
        try {
            setUpdateId((int) playerTable.getValueAt(row, 0));
            firstName = (String) playerTable.getValueAt(row, 1);
            lastName = (String) playerTable.getValueAt(row, 2);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "please select a Item");
            return;
        }
        jTextField4.setText(firstName);
        jTextField5.setText(lastName);
        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            getResultSet().next();

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "card_updateplayer");
        DatabaseConnection.closeConnection();

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int row = playerTable.getSelectedRow();
        int column = playerTable.getColumnCount();

        int id = 0;
        String firstName = null;
        String lastName = null;
        String country = null;
        String team = null;
        try {
            id = (int) playerTable.getValueAt(row, 0);
            firstName = (String) playerTable.getValueAt(row, 1);
            lastName = (String) playerTable.getValueAt(row, 2);
            country = (String) playerTable.getValueAt(row, 4);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "please select a Item");
            return;
        }


        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        int teamId;
        try {
            setResultSet(statement.executeQuery("SELECT Team_ID FROM Player_info WHERE Player_ID= " + id));
            getResultSet().next();
            teamId = getResultSet().getInt("Team_Id");
            setResultSet(statement.executeQuery("SELECT Team_Name FROM team WHERE Team_ID=" + teamId));
            getResultSet().next();
            team = getResultSet().getString("Team_Name");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel19.setText(firstName);
        jLabel21.setText(lastName);
        jLabel26.setText(country);
        jLabel35.setText(team);


        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "playerProfile");
        DatabaseConnection.closeConnection();

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "playerManageCard");
    }

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String teamName = null;
        int foundationYear, value;
        teamName = jTextField6.getText();
        if (teamName.length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert a Team name");
            return;
        } else if (jTextField7.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert a Foundation Year");
            return;
        } else if (jTextField8.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert a Team Value");
            return;
        }
        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT Team_ID FROM team WHERE Team_Name =" + "'" + teamName + "'"));
            getResultSet().next();
            setTeamId(getResultSet().getInt("Team_ID"));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseConnection.closeConnection();
        foundationYear = Integer.parseInt(jTextField7.getText());
        value = Integer.parseInt(jTextField8.getText());
        System.out.println("Foundation:" + foundationYear + " value: " + value + "teamId: " + getTeamId());
        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE team SET Team_Name = " + "'" + teamName + "', Year_Founded = " + foundationYear + ", Value=" +
                    value + " WHERE Team_ID =" + getTeamId());
            JOptionPane.showMessageDialog(this, "Team has benn updated successfully");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "teamManageCard");
        DatabaseConnection.closeConnection();
    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "teamManageCard");
    }

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "loginPanelCard");
    }

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        try {
            teamComboBox.getSelectedItem().toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Select a Team");
            return;
        }

        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT * FROM team WHERE Team_Name=" + "'" + teamComboBox.getSelectedItem().toString() + "' "));
            teamManagementTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));


        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseConnection.closeConnection();

    }

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        try {
            playerComboBox.getSelectedItem().toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Select a Player");
            return;
        }
        String sql = "SELECT Player_ID,First_name,Last_Name,Team_Name,Country_Name FROM player_info, team "
                + "WHERE team.`Team_ID`=(SELECT Team_ID FROM player_info WHERE First_Name =" + "'" + playerComboBox.getSelectedItem().toString() + "'" + ") "
                + " AND player_info.`Team_ID`=(SELECT Team_ID FROM player_info WHERE First_Name =" + "'" + playerComboBox.getSelectedItem().toString() + "'" + ")"
                + " AND player_info.`Team_ID`=team.`Team_ID` AND First_Name=" + "'" + playerComboBox.getSelectedItem().toString() + "' ";
        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery(sql));
            playerTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseConnection.closeConnection();

    }

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "mainMenuCard");
    }

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // TODO add your handling code here:
            int pointHome, pointAway;
            int resultHome, resultAway;
            String matchResult;
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();

            //HOME
            String updateHome = null;
            switch (jComboBox5.getSelectedItem().toString()) {
                case "Win":
                    pointHome = 3;
                    matchResult = jComboBox4.getSelectedItem().toString();
                    setResultSet(statement.executeQuery("SELECT Win From league_standing WHERE Team_Name =" + "'" + jComboBox4.getSelectedItem().toString() + "'"));
                    getResultSet().next();
                    resultHome = getResultSet().getInt("Win") + 1;
                    updateHome = "UPDATE league_standing SET Win=" + resultHome + " WHERE Team_Name =" + "'" + jComboBox4.getSelectedItem().toString() + "'";
                    break;
                case "Draw":
                    pointHome = 1;
                    matchResult = "Draw";
                    setResultSet(statement.executeQuery("SELECT Draw From league_standing WHERE Team_Name =" + "'" + jComboBox4.getSelectedItem().toString() + "'"));
                    getResultSet().next();
                    resultHome = getResultSet().getInt("Draw") + 1;
                    updateHome = "UPDATE league_standing SET Draw=" + resultHome + " WHERE Team_Name =" + "'" + jComboBox4.getSelectedItem().toString() + "'";
                    break;
                default:
                    pointHome = 0;
                    matchResult = jComboBox7.getSelectedItem().toString();
                    setResultSet(statement.executeQuery("SELECT Loss From league_standing WHERE Team_Name =" + "'" + jComboBox4.getSelectedItem().toString() + "'"));
                    getResultSet().next();
                    resultHome = getResultSet().getInt("Loss") + 1;
                    updateHome = "UPDATE league_standing SET Loss=" + resultHome + " WHERE Team_Name =" + "'" + jComboBox4.getSelectedItem().toString() + "'";
                    break;
            }
            statement.executeUpdate(updateHome);

            // AWAY
            String updateAway = null;
            switch (jComboBox8.getSelectedItem().toString()) {
                case "Win":
                    pointAway = 3;
                    setResultSet(statement.executeQuery("SELECT Win From league_standing WHERE Team_Name =" + "'" + jComboBox7.getSelectedItem().toString() + "'"));
                    getResultSet().next();
                    resultHome = getResultSet().getInt("Win") + 1;
                    updateAway = "UPDATE league_standing SET Win=" + resultHome + " WHERE Team_Name =" + "'" + jComboBox7.getSelectedItem().toString() + "'";
                    break;
                case "Draw":
                    pointAway = 1;
                    setResultSet(statement.executeQuery("SELECT Draw From league_standing WHERE Team_Name =" + "'" + jComboBox7.getSelectedItem().toString() + "'"));
                    getResultSet().next();
                    resultHome = getResultSet().getInt("Draw") + 1;
                    updateAway = "UPDATE league_standing SET Draw=" + resultHome + " WHERE Team_Name =" + "'" + jComboBox7.getSelectedItem().toString() + "'";
                    break;
                default:
                    pointAway = 0;
                    setResultSet(statement.executeQuery("SELECT Loss From league_standing WHERE Team_Name =" + "'" + jComboBox7.getSelectedItem().toString() + "'"));
                    getResultSet().next();
                    resultHome = getResultSet().getInt("Loss") + 1;
                    updateAway = "UPDATE league_standing SET Loss=" + resultHome + " WHERE Team_Name =" + "'" + jComboBox7.getSelectedItem().toString() + "'";
                    break;
            }
            statement.executeUpdate(updateAway);
            System.out.println("pointHome:" + pointHome + "updateHome:" + updateHome + "pointAway:" + pointAway + "updateAway:" + updateAway);

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


        jComboBox4.setSelectedItem("");
        jComboBox7.setSelectedItem("");

        JOptionPane.showMessageDialog(this, "Match Result has been updated");
        DatabaseConnection.closeConnection();
    }

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CardLayout card = (CardLayout) jPanel1.getLayout();
        card.show(jPanel1, "teamManageCard");

    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        try {

            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT * FROM player_info"));
            playerTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "playerManageCard");
        DatabaseConnection.closeConnection();
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (jTextField4.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert a First Name");
            return;
        } else if (jTextField5.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert a Last Name");
            return;
        }
        String firstName = null;
        String lastName = null;

        firstName = jTextField4.getText();
        lastName = jTextField5.getText();


        String updateQueryInfo = "UPDATE player_info SET First_Name=" + "'" + firstName + "', " + "Last_Name=" + "'" + lastName + "' WHERE Player_id=" + getUpdateId();
        System.out.println("updateQueryInfo:" + updateQueryInfo);

        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            statement.executeUpdate(updateQueryInfo);
            JOptionPane.showMessageDialog(this, "Player has been updated successfully");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "playerManageCard");
        DatabaseConnection.closeConnection();

    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {

            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
            setResultSet(statement.executeQuery("SELECT * FROM player_info"));
            playerTable.setModel(DbUtils.resultSetToTableModel(getResultSet()));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        CardLayout card = (CardLayout) jPanel1.getLayout();

        card.show(jPanel1, "playerManageCard");
        DatabaseConnection.closeConnection();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // Player Information
        String firstName = null;
        String lastName = null;
        String country = null;
        String team = null;

        int playerID;
        firstName = jTextField1.getText();
        lastName = jTextField2.getText();
        country = (String) jComboBox1.getSelectedItem();
        team = (String) jComboBox3.getSelectedItem();

        try {
            Connection connection = DatabaseConnection.startConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        String insertQuery1 = null;
        String insertAttributesQuery = null;
        if (firstName.length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert A First Name");
            return;
        } else if (lastName.length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert A Last Name");
            return;
        } else if (jTextField3.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Insert A Registration Number");
            return;
        }

        try {
            playerID = Integer.parseInt(jTextField3.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Insert A valid Registration Number");
            return;
        }

        try {
            setResultSet(statement.executeQuery("SELECT Team_ID FROM team WHERE Team_name=" + "'" + team + "'"));
            getResultSet().next();
            int id = getResultSet().getInt("Team_ID");
            insertQuery1 = "INSERT INTO player_info(Player_ID,Team_ID,First_Name,Last_Name,Country_Name,Role,Team_Preference) values(" +
                    playerID + "," + id + "," + "'" + firstName + "'" + "," + "'" + lastName + "'" + "," + "'" + country + "'"
                    + "," + "'" + jComboBox2.getSelectedItem().toString() + "'" + "," + "'" + teamPreferenceComboBox.getSelectedItem().toString() + "'" + ")";

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            statement.execute(insertQuery1);

            JOptionPane.showMessageDialog(this, "Player has benn inserted successfully");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("insertQuery1:" + insertQuery1);

        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        DatabaseConnection.closeConnection();

    }
    // End of variables declaration


//    public Connection startConnection() {
//        try {
//            //        String DATABASE_URL = "jdbc:mysql://localhost:3306/mynewdatabase";
//            Object newInstance = Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            connection = DriverManager.startConnection(getDATABASE_URL(), getUserName(), getPassword());
//
//            System.out.println("connected");
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return connection;
//    }
//
//
//    public void closeConnection() {
//        try {
//            connection.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void comboFilter(String enteredText) {
        ArrayList<String> filterArray = new ArrayList<String>();

        String str1 = "";

        try {


            String str = "SELECT First_Name FROM player_info WHERE First_Name  LIKE '" + enteredText + "%'";

            Connection connection = DatabaseConnection.startConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(str);
            while (rs.next()) {

                str1 = rs.getString("First_Name");
                filterArray.add(str1);


            }

        } catch (Exception ex) {
            System.out.println("error" + ex);
        }
        DatabaseConnection.closeConnection();

    }


    private void searchPlayer() {

        //starting--

        SearchBoxModel sbm2 = new SearchBoxModel(playerComboBox, playerName);
        playerComboBox.setModel(sbm2);
        playerComboBox.addItemListener(sbm2);

    }

    public void searchCompany() {

        SearchBoxModel sbmc1 = new SearchBoxModel(teamComboBox, teamName);
        teamComboBox.setModel(sbmc1);
        teamComboBox.addItemListener(sbmc1);

        SearchBoxModel sbmc2 = new SearchBoxModel(teamPreferenceComboBox, teamName);
        teamPreferenceComboBox.setModel(sbmc2);
        teamPreferenceComboBox.addItemListener(sbmc2);

        SearchBoxModel sbmc3 = new SearchBoxModel(jComboBox3, teamName);
        jComboBox3.setModel(sbmc3);
        jComboBox3.addItemListener(sbmc3);

        SearchBoxModel sbmc4 = new SearchBoxModel(jComboBox4, teamName);
        jComboBox4.setModel(sbmc4);
        jComboBox4.addItemListener(sbmc4);

        SearchBoxModel sbmc5 = new SearchBoxModel(jComboBox7, teamName);
        jComboBox7.setModel(sbmc5);
        jComboBox7.addItemListener(sbmc5);


    }

    private void createArrayListDB() {
        try {
            String sql = "select First_Name from player_info";
            Connection connection = DatabaseConnection.startConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                playerName.add(rs.getString("First_Name"));
                System.out.println(rs.getString("First_Name"));

            }
        } catch (SQLException ex) {

        }
        DatabaseConnection.closeConnection();



    }

    public void createArrayListDB2() {
        try {
            String sql = "SELECT Team_Name FROM team";
            Connection connection = DatabaseConnection.startConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                teamName.add(rs.getString("Team_Name"));

            }
        } catch (SQLException ex) {

        }
        DatabaseConnection.closeConnection();

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public void setDATABASE_URL(String DATABASE_URL) {
        this.DATABASE_URL = DATABASE_URL;
    }
}
