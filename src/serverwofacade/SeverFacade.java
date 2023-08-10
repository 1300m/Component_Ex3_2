/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverwofacade;

/**
 *
 * @author 64050355 Jirapat Pichai
 */
public class SeverFacade {
    private static SeverFacade SeverFacadeOBJ = null;
    private SeverFacade() {}
    ScheduleServer scheduleServer = new ScheduleServer();
    
    public static SeverFacade getSeverFacadeObject() {
        if(SeverFacadeOBJ == null) {
            SeverFacadeOBJ = new SeverFacade();
        }
        return SeverFacadeOBJ;
    }
    
    public void startSever() {
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
        System.out.println("Start working......");
    }
    
    public void stopSever() {
        System.out.println("After work done.........");
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}