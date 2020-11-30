/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import UserInterface.AdminLogin;
import UserInterface.NaiveLogin;
import UserInterface.NewInstall;
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import support.Users;

/**
 *
 * @author adichouhanofficial
 */
public class Start 
{
    public static void main(String[] args) throws IOException, AWTException 
    {
        if(Users.fileNotPresent()) 
            new NewInstall().setVisible(true);
        else
        {
            new Start().runApplication();
        }
    }
    
    private void runApplication() throws IOException, AWTException
    {
        if(!SystemTray.isSupported())
            System.out.println("System Tray is not supported");
        else
        {
            SystemTray tray=SystemTray.getSystemTray();
            TrayIcon trayIcon = new TrayIcon(ImageIO.read(getClass().getResource("logo.png")));
            PopupMenu popup = new PopupMenu();
            MenuItem adminPanel = new MenuItem("Open admin panel");
            MenuItem manageFile = new MenuItem("My files");
            MenuItem exitApp = new MenuItem("Exit");
            popup.add(adminPanel);
            popup.add(manageFile);
            popup.add(exitApp); 
            tray.add(trayIcon);
            trayIcon.setPopupMenu(popup);   
            
            adminPanel.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    new AdminLogin().setVisible(true);   // pending : avoid multiple instance
                }
            });
            
            manageFile.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    new NaiveLogin().setVisible(true);
                } 
            });
            
            exitApp.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                       System.exit(0);
                }
            });
        }
    }
}
