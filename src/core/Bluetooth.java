/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author adichouhanofficial
 */
import com.intel.bluetooth.RemoteDeviceHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;
public class Bluetooth implements DiscoveryListener
{
    private static  List<RemoteDevice> client = new ArrayList();
    private static Object lock = new Object();
    private static LocalDevice local = null;
    private static DiscoveryAgent agent = null;
    private String serverURL;
   // private static String url;
 //   private static L2CAPConnection con = null;
 //   private static L2CAPConnectionNotifier connect = null;
    public Bluetooth() throws BluetoothStateException
    {
            local = LocalDevice.getLocalDevice();
            agent = local.getDiscoveryAgent();
    }
//    private void printDevices(Vector<RemoteDevice> client)
//    {
//        for(RemoteDevice rd:client){
//            try {
//                System.out.println("name:"+rd.getFriendlyName(false));
//            } catch (IOException ex) {
//                System.out.println(ex);
//            }
//        }    
//    }
    
//    public static Vector<RemoteDevice> getList()
//    {
//        Bluetooth bt = new Bluetooth();
//        System.err.println("Enquiry started");
//        try {
//            bt.searchDevices();
//        } catch (BluetoothStateException ex) {
//            ex.printStackTrace();
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//        
//        return client;
//    }
    
    public List<RemoteDevice> searchDevices() throws BluetoothStateException, InterruptedException
    {
      
       agent.startInquiry(DiscoveryAgent.GIAC, this);
       synchronized(lock)
       {
         lock.wait();
       }
        System.out.println("Enquiry Completed");
        return client;
        
    }
    
//    public void getLink(RemoteDevice device){
//    
//        try {
//            UUID[] uuidSet = new UUID[1];
//            uuidSet[0]= new UUID(0x1105);
//            int[] attrIDs = new int[]{0x0100};
//            printDevices(client);
//            
//            agent.searchServices(null, uuidSet,device, this);
//            synchronized(lock)
//            {
//                try {
//                    lock.wait();
//                } catch (InterruptedException ex) {
//                   ex.printStackTrace();
//                }
//            }
//            // sendMessageToDevice(url);
//
//        } catch (BluetoothStateException ex) {
//            ex.printStackTrace();
//        }
//        
//    }
    public static boolean pairing(RemoteDevice rd)
    {
        boolean paired = false;
        String passKey = "1234";
        if(!rd.isAuthenticated())
        {
            try 
            {
                paired = RemoteDeviceHelper.authenticate(rd,passKey);
            } 
            catch (IOException ex) 
            {
            }
            
        }
        return paired;
    }
    public void connect(String serverUrl){
        try {
            ClientSession clientSession = (ClientSession) Connector.open(serverUrl);
            HeaderSet hsOperation = clientSession.connect(null);
            System.out.println("connected successfully");
           
        } catch (IOException ex) {
            ex.printStackTrace();
       }
    }
     public  String getServerURL(RemoteDevice device) throws BluetoothStateException
    {
        
            UUID[] uuidSet = new UUID[1];
            uuidSet[0]=new UUID(0x1105); //OBEX Object Push service
            
            int[] attrIDs =  new int[] {
                    0x0100 // Service name
            };
            
            agent.searchServices(attrIDs, uuidSet, device, this);
              
            try {
                synchronized(lock){
                    lock.wait();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
            
            return serverURL;
            
            
    }
    @Override
    public void deviceDiscovered(RemoteDevice rd, DeviceClass dc)
    {
////        System.out.println("This is device discovered");
//         String name=null;
//         try
//         {
//            name=rd.getFriendlyName(true);    
//         }
//         catch(Exception e)
//         {
//             name=rd.getBluetoothAddress();
//         }
//       //  System.out.println(name);
        client.add(rd);
      
    }

    @Override
    public void servicesDiscovered(int i, ServiceRecord[] srs)
    {
//        for(int j=0; j<srs.length ; j++)
//        {
//            String url = srs[j].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT,false);
//            if(url==null)
//                continue;
//            DataElement serviceName = srs[j].getAttributeValue(0x0100);
//            if(serviceName!=null)
//                System.out.println("Service "+serviceName.getValue()+" found "+url);
//            else
//                System.out.println("service found "+ url);
//            
//            this.url = url;         
//        }
//        
    }

    @Override
    public void serviceSearchCompleted(int i, int i1)
    {
        synchronized(lock)
        {
            lock.notify();
        }
    }   

    @Override
    public void inquiryCompleted(int i)
    {
        synchronized(lock)
        {
            lock.notify();
        }
        
    }
    
}
