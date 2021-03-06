/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jammieshuttletimesdownloader;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sun.applet.Main;

/**
 *
 * @author Mordechai
 */
public class HomeScreen extends javax.swing.JFrame
{

    public static final String originalStartPath = "C:\\Jammie Shuttle Time Tables";
    public static String startPath = "C:\\Jammie Shuttle Time Tables";
    public static String endPath = ".pdf";
    private String[] routes;
    private Downloader d;

    public HomeScreen()
    {
        d = new Downloader();
        routes = d.getRoutes();
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                saveProperties();
            }
        });

        try
          {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

          } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
          {
            System.out.println("Problem setting look and feel.");
          }
        initComponents();

//        URL windowurl = Main.class.getResource("/uct2.jpg");
//        BufferedImage windowImage = null;
//        try
//        {
//            windowImage = ImageIO.read(windowurl);
//            this.setIconImage(windowImage);
//            
//        } catch (IOException ex)
//        {
//            System.out.println("could not get window image " + ex);
//        }
        this.setLocationRelativeTo(null);
        for (int i = 0; i < routes.length; i++)
          {
            routesCombo.addItem(routes[i]);
          }

        File f = new File(startPath);
        if (!f.exists())
          {
            try
              {
                if (f.mkdir())
                  {
                    System.out.println("Directory Created");
                  } else
                  {
                    System.out.println("Directory is not created");
                  }
              } catch (Exception e)
              {
                e.printStackTrace();
              }
          }
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        loadProperties();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        fileChooser = new javax.swing.JFileChooser();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        routesCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        downloadB = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        deleteFileMB = new javax.swing.JMenuItem();
        setSaveLocationMB = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jammie Shuttle Times");

        jLabel2.setText("Select a route:");

        downloadB.setText("View");
        downloadB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                downloadBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(routesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(downloadB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(routesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(downloadB)
                        .addContainerGap(13, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(routesCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(downloadB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("File");

        deleteFileMB.setText("Delete old timetables");
        URL delurl = Main.class.getResource("/delete_icon.png");
        ImageIcon delIcon = new ImageIcon(delurl);
        deleteFileMB.setIcon(delIcon);
        deleteFileMB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteFileMBActionPerformed(evt);
            }
        });
        jMenu1.add(deleteFileMB);

        setSaveLocationMB.setText("Set timetable save location");
        URL saveurl = Main.class.getResource("/folder_icon.png");
        ImageIcon saveIcon = new ImageIcon(saveurl);
        setSaveLocationMB.setIcon(saveIcon);
        setSaveLocationMB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                setSaveLocationMBActionPerformed(evt);
            }
        });
        jMenu1.add(setSaveLocationMB);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void downloadBActionPerformed(java.awt.event.ActionEvent evt)
    {
        String selected = (String) routesCombo.getSelectedItem();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        File f = new File(getPath(selected));

        if (!f.exists())
          {
            d.downloadRoute(selected);
          }

        if (Desktop.isDesktopSupported())
          {
            try
              {
                File myFile = new File(getPath(selected));
                Desktop.getDesktop().open(myFile);
              } catch (IOException ex)
              {
                System.out.println("Could not open PDF: " + getPath(selected));
              }
          }

        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void deleteFileMBActionPerformed(java.awt.event.ActionEvent evt)
    {

        for (int i = 0; i < routes.length; i++)
          {
            File f = new File(getPath(routes[i]));
            f.delete();
          }

    }

    private void setSaveLocationMBActionPerformed(java.awt.event.ActionEvent evt)
    {
        File folderSelected = null;
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
          {
            folderSelected = fileChooser.getSelectedFile();
            try
              {
                startPath = folderSelected.getAbsolutePath();
              } catch (Exception ex)
              {
                System.out.println("Error accessing file" + folderSelected.getAbsolutePath());
              }
          } else
          {
            System.out.println("File access cancelled.");
          }
    }

    public static String getPath(String routeName)
    {
        return startPath + "\\" + routeName + " Timetable" + endPath;
    }

    private void loadProperties()
    {
        Properties prop = new Properties();

        try
          {
            //load a properties file
            prop.load(new FileInputStream(originalStartPath + "\\jammietimetables.properties"));

            //get the property value and print it out
            startPath = prop.getProperty("startPath");
            endPath = prop.getProperty("endPath");

          } catch (FileNotFoundException fne)
          {
            try// create one
              {
                //set the properties value
                prop.setProperty("startPath", startPath);
                prop.setProperty("endPath", endPath);

                //save properties to project root folder
                prop.store(new FileOutputStream(originalStartPath + "\\jammietimetables.properties"), "Do not tamper with.");

                Runtime rt = Runtime.getRuntime();
                Process proc = rt.exec("attrib -s -h -r " + originalStartPath + "\\jammietimetables.properties");
                proc.waitFor();

              } catch (IOException ex)
              {
                System.out.println("Error making properties file after not finding one " + ex);
              } catch (InterruptedException e)
              {
                System.out.println(e);
              }

          } catch (IOException ex)
          {
            System.out.println("Error reading from properties " + ex);
          }

    }

    private void saveProperties()
    {
        Properties prop = new Properties();
        try// create one
          {
            //set the properties value
            prop.setProperty("startPath", startPath);
            prop.setProperty("endPath", endPath);

            //save properties to project root folder
            prop.store(new FileOutputStream(originalStartPath + "\\jammietimetables.properties"), "Do not tamper with.");
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("attrib -s -h -r " + originalStartPath + "\\jammietimetables.properties");
            proc.waitFor();
          } catch (IOException ex)
          {
            System.out.println("Error making properties file after not finding one " + ex);
          } catch (InterruptedException e)
          {
            System.out.println(e);
          }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new HomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem deleteFileMB;
    private javax.swing.JButton downloadB;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JComboBox routesCombo;
    private javax.swing.JMenuItem setSaveLocationMB;
    // End of variables declaration                   
}
