/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface;

import core.EncryptionEngine;
import core.Resources;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.bluetooth.RemoteDevice;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import support.FileStatus;
import support.Log;
import support.Logs;
import support.User;
import support.UserFile;
import support.UserFiles;

/**
 *
 * @author adichouhanofficial
 */
public class MyFiles extends javax.swing.JFrame {

    private List<UserFile> myfiles;
    private HashMap<Integer,UserFile> mapper;
    DefaultTableModel model;
    private RemoteDevice device;
    private User user;
    /** Creates new form MyFiles */
    public MyFiles(RemoteDevice device,User user) 
    {
        initComponents();
        this.device=device;
        this.user=user;
        System.out.println(user.getName()+" "+user.getMAC());
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png"));
        setIconImage(image);
    }
//     public MyFiles() 
//    {
////        initComponents();
//        device=null;
//        user=null;
//    }

    private void refreshTable()
    {
            if(mapper!=null){
            myfiles.clear();
            mapper.clear();
            IconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bluetooth.png")));
            FileName.setText("_________SELECT A FILE FROM LIST___________");
            Type.setText("-----------");
            Size.setText("-----------");          
            model.setRowCount(0);}
            EncryptButton.setVisible(false);
            EncryptStatus.setVisible(false);
            showTableData();    
    }
    private void showTableData()
    {
        try 
        {  
            myfiles=UserFiles.getSelectedUserFiles(user);
            mapper=new HashMap();
            int i=0;            
            model=(DefaultTableModel) Table.getModel();
            for(UserFile file: myfiles)
            {
                String name= file.getFile().getName();
                String path =file.getFile().getAbsolutePath();
                mapper.put(i, file);i++;
                model.addRow(new Object[]{name,path});
            }
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this,"Something went wrong with file system !!!");
            dispose();
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        remove = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        EncryptStatus = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        IconLogo = new javax.swing.JLabel();
        FileName = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        Type = new javax.swing.JLabel();
        Size = new javax.swing.JLabel();
        sizee = new javax.swing.JLabel();
        adon = new javax.swing.JLabel();
        DateTime = new javax.swing.JLabel();
        EncryptButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("My Files");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder.png"))); // NOI18N
        jLabel3.setText(" MY FILES");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 14, -1, -1));

        Table.setAutoCreateRowSorter(true);
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FileName", "Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(0).setPreferredWidth(250);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(1).setPreferredWidth(439);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 700, 228));

        remove.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file-removexs.png"))); // NOI18N
        remove.setText("REMOVE FILE");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        jPanel2.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 325, 125, -1));

        add.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filexs.png"))); // NOI18N
        add.setText("Add File");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 325, 102, -1));

        EncryptStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EncryptStatus.setForeground(new java.awt.Color(153, 0, 0));
        EncryptStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        EncryptStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fileicons/file-lock.png"))); // NOI18N
        EncryptStatus.setText(" ENCRYPTED");
        jPanel2.add(EncryptStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 323, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-service.png"))); // NOI18N
        jLabel4.setText(" FILE INFO");

        IconLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bluetooth.png"))); // NOI18N

        FileName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FileName.setText("_________SELECT A FILE FROM LIST___________");

        type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        type.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        type.setText("TYPE :");

        Type.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Type.setText("-----------");

        Size.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Size.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Size.setText("-----------");

        sizee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sizee.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sizee.setText("SIZE :");

        adon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        adon.setText("ADDED ON :");

        DateTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DateTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DateTime.setText("XX.XX.XXXX XX:XX XX");

        EncryptButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EncryptButton.setForeground(new java.awt.Color(153, 0, 0));
        EncryptButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EncryptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fileicons/file-lock.png"))); // NOI18N
        EncryptButton.setText("DECRYPT FILE ");
        EncryptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EncryptButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(IconLogo))
                            .addComponent(FileName, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(sizee, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(adon)
                                .addGap(10, 10, 10)
                                .addComponent(DateTime))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(EncryptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IconLogo)
                .addGap(11, 11, 11)
                .addComponent(FileName)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(type))
                    .addComponent(Type))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(sizee))
                    .addComponent(Size))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(adon))
                    .addComponent(DateTime))
                .addGap(18, 18, 18)
                .addComponent(EncryptButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EncryptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EncryptButtonMouseClicked

    if(Resources.lockFlag)
    {
        String operation = EncryptButton.getText();
        int confirm=JOptionPane.showConfirmDialog(this,"Do you really want to "+operation.toLowerCase()+" selected file ?");
        if(confirm==0)
        {
            try
            {
                int row = Table.getSelectedRow();
                UserFile myfile=mapper.get(row);
                String key = Resources.key(user.getMAC());
                EncryptionEngine ee = new EncryptionEngine(key);
                File file = myfile.getFile();
                boolean encrypted =myfile.isEncrypted();
                if(encrypted)
                {
                    file.setWritable(true);
                    ee.fileDecrypt(file);
                    Log log = new Log(user.getName(),"File encrypted : "+file.getName());
                    Logs.addLog(log);
                }
                else
                {
                    ee.fileEncrypt(file);
                    file.setWritable(false);
                    Log log = new Log(user.getName(),"File decrypted : "+file.getName());
                    Logs.addLog(log);
                }
                UserFiles.removeFile(myfile);
                myfile.setEncrypted(!encrypted);
                UserFiles.addFile(myfile);
                this.refreshTable();
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(this,"Something went wrong with file system");
                System.out.println("Serious issue with file status can be occured");
            }            
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this,"Application under Maintainance");
    }
    }//GEN-LAST:event_EncryptButtonMouseClicked

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked

        int row=Table.getSelectedRow();
        if(row!=-1)
        {
            EncryptButton.setVisible(true);
            EncryptStatus.setVisible(true);
            UserFile file = mapper.get(row);
            String name=file.getFile().getName();
            String type=file.getExtension();
            String imgurl = "/icons/fileicons/"+type+".png";
            boolean encryptStatus = file.isEncrypted();
            long size = file.getFile().length();
            String time = file.getTimestamp();
            FileName.setText(name);
            Size.setText(""+size+" bytes");
            Type.setText(type);
            DateTime.setText(time);
            IconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource(imgurl)));
            if(encryptStatus)
            {
                EncryptStatus.setText("Encrypted");
                EncryptButton.setText("Decrypt File");
                EncryptStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fileicons/file-lock.png")));
                EncryptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fileicons/file-unlock.png")));
            }
            else
            {
                EncryptStatus.setText("Decrypted");
                EncryptButton.setText("Encrypt File");
                EncryptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fileicons/file-lock.png")));
                EncryptStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fileicons/file-unlock.png")));
            }
        }
        
        
    }//GEN-LAST:event_TableMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
    if(Resources.lockFlag)
    {    
        int rowNo = Table.getSelectedRow();
        if(rowNo==-1)
        {
            JOptionPane.showMessageDialog(this,"Please select the file first !");
        }
        else
        {
            int confirm=JOptionPane.showConfirmDialog(this,"Do you really want to remove this file from desksure ?");
            if(confirm==0)
            {
                try 
                {
                    UserFile myfile = mapper.get(rowNo);

                    if(myfile.isEncrypted())  // It will removed file after decrypting it
                    {
                        File file= myfile.getFile();
                        String key = Resources.key(user.getMAC());
                       // System.out.println("key len "+key.length());
                        EncryptionEngine ee = new EncryptionEngine(key);
                        file.setWritable(true);
                        ee.fileDecrypt(file);
                        
                    }
                    UserFiles.removeFile(myfile);
                    JOptionPane.showMessageDialog(this,"File successfully removed !");
                    Log log = new Log(user.getName(),"File removed : "+myfile.getFile().getName());
                    Logs.addLog(log);
                    this.refreshTable();
                } 
                catch (IOException ex) 
                {
                    JOptionPane.showMessageDialog(this,"Something Went wrong with files");
                }
            }
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this,"Application under Maintainance");
    }
    }//GEN-LAST:event_removeMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
    if(Resources.lockFlag)
    {    
        JFileChooser chooser= new JFileChooser("D:\\");
        chooser.setMultiSelectionEnabled(false);
        if(chooser.showDialog(this,"Choose a file")==JFileChooser.APPROVE_OPTION)
        {
            File file=chooser.getSelectedFile();
            String extension = Resources.fetchFileExtension(file.getAbsolutePath());
            if(file.exists() && file.isFile())
            {
                if(!extension.equals("desksure"))
                {   
                    System.out.println(file);
                    int confirm=JOptionPane.showConfirmDialog(this,"Do you really want to Secure this File using DeskSure ?");
                    if(confirm==0) // if user click on yes
                    {
                        String key = Resources.key(user.getMAC());  //generating key by Formatted MAC address               
                        try
                        {
                            EncryptionEngine ee = new EncryptionEngine(key);
                            UserFile userfile = new UserFile(file,extension,user,FileStatus.ENCRYPTED);
                            UserFiles.addFile(userfile);
                            ee.fileEncrypt(file);    
                            file.setWritable(false);
                            Log log = new Log(user.getName(),"New File added : "+file.getName());
                            Logs.addLog(log);
                            this.refreshTable();
                        } 
                        catch (IOException ex) 
                        {
                            JOptionPane.showMessageDialog(this,"Something went wrong with file system");
                        }
                    }      
                 }
                else
                {
                    JOptionPane.showMessageDialog(this,"File is already secured by desksure !");
                }
                
         }
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this,"Application under Maintainance");
    }
    }//GEN-LAST:event_addMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Log log = new Log(user.getName(),"Naive logged out !!!");
        try 
        {
            Logs.addLog(log);
        } catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this,"Something went wrong with file system");
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MyFiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateTime;
    private javax.swing.JLabel EncryptButton;
    private javax.swing.JLabel EncryptStatus;
    private javax.swing.JLabel FileName;
    private javax.swing.JLabel IconLogo;
    private javax.swing.JLabel Size;
    private javax.swing.JTable Table;
    private javax.swing.JLabel Type;
    private javax.swing.JLabel add;
    private javax.swing.JLabel adon;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel remove;
    private javax.swing.JLabel sizee;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables

}
