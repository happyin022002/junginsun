/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsInterfaceBCImpl.java
*@FileTitle : TrsInterface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-19
*@LastModifier : changgyu kim
*@LastVersion : 1.0
* 2007-01-19 changgyu kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.common.online.basic;

import com.clt.apps.opus.esd.sce.common.online.integration.TrsInterfaceDBDAO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCEM Business Logic Basic Command implementation<br>
 * - SCEM에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author changgyu kim
 * @see TrsInterfaceBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TrsInterfaceBCImpl extends BasicCommandSupport implements TrsInterfaceBC {

	// Database Access Object
	private transient TrsInterfaceDBDAO dbDao = null;

	/**
	 * TrsInterfaceBCImpl 객체 생성<br>
	 * TrsInterfaceDBDAO 생성한다.<br>
	 */
	public TrsInterfaceBCImpl(){
		dbDao = new TrsInterfaceDBDAO() ;
	}
	
	/** Batch Server Restart 시호출되어지는 Function 비정상 종료 데이터 다시 원복.
     * @throws EventException
     */
    public void modifyTbPatch() throws EventException {
    	try {
    		dbDao.modifyActRcvIf();
        	dbDao.modifyActTmlIf();
        	dbDao.modifyClmIf();
        	dbDao.modifyEdiAmsIf();
        	dbDao.modifyVpsIf();	
    	} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }
	/*
	 Function call Method

	 1. import part

	 import com.clt.apps.opus.esd.sce.common.online.basic.TrsInterfaceBC;
	 import com.clt.apps.opus.esd.sce.common.online.basic.TrsInterfaceBCImpl;
	 import com.clt.apps.opus.esd.sce.common.online.event.TrsInterfaceEvent;
	 import com.clt.apps.opus.esd.sce.common.online.event.TrsInterfaceEventResponse;

	 2. Constructor part

	 TrsInterfaceBC command = new TrsInterfaceBCImpl();

	 3. Event(param) Construct part

	 TrsInterfaceEvent event
	 	= new TrsInterfaceEvent(trspSoOfcCtyCd,trspSoSeq
								,trspSoStsCd,copNo,costActGrpSeq);

	 4. Function part(and response)

	 TrsInterfaceEventResponse response = command.modifyTrsStatus(event);

	 String resultString = response.getFlowFlag();

	 */

	/**
     * S/O Status Upate<br>
     *
     * @param vo TransportationVo
     * @exception EventException
     */
//	public TrsInterfaceEventResponse modifyTrsStatus(TrsInterfaceEvent vo) throws EventException {
//		TrsInterfaceEventResponse eventRes = new TrsInterfaceEventResponse();
//		try {
//
//			log.debug("\n========> modifyTrsStatus Call");
//
//			String trspSoStsCd = vo.getTrspSoStsCd();
//
//			if(trspSoStsCd.equals("C")) {
//				dbDao.modifyCostActGrp(vo);
//				eventRes.setFlowFlag("SUCCESS");
//
//			} else if(trspSoStsCd.equals("I")) {
//				dbDao.modifyCostActGrp(vo);
//
//				EdiSendBC callSend = new EdiSendBCImpl();
//				EdiSendEventResponse eventResponse = (EdiSendEventResponse)callSend.createWOEdiSend(vo.getTrspSoOfcCtyCd(),vo.getTrspSoSeq());
//
//				eventRes.setFlowFlag(eventResponse.getFlowFlag());
//				log.debug("\n EDI Call Result : " + eventResponse.getFlowFlag());
//
//			} else {
//				dbDao.modifyCostActGrp(vo);
//				eventRes.setFlowFlag("SUCCESS");
//			}
//
//
//
//
//		} catch (DAOException de) {
//        	log.error(de.getMessage(), de);
//            throw new EventException(de.getMessage());
//        } catch (Exception e) {
//        	log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//        }
//        return eventRes;
//	}

	/**
     * Cost Group call<br>
     *
     * @param bkg_no String
     * @param bkg_no_split String
     * @param cntr_no String
     * @param cop_no String
     * @param usr_id String
     * @exception EventException
     */
//	public void modifyCost(String bkg_no, String bkg_no_split, String cntr_no, String cop_no, String usr_id) throws EventException{
//		try {
//			dbDao.modifyCost(bkg_no, bkg_no_split, cntr_no, cop_no, usr_id);
//		} catch (DAOException de) { 
//			log.error(de.getMessage(), de);
//            throw new EventException(de.getMessage());
//		}
//	}

	/** Batch Server Restart 시호출되어지는 Function 비정상 종료 데이터 다시 원복.
     * @throws EventException
     */
//    public void modifyTbPatch() throws EventException{
//    	//SERVER에 따라 실행해야할 테이블을 구분하기 위해 프레임웍에서 설정해준 서버의 이름을 가져온다.
//    	//2007.09.21 현재 3,4번 서버로 SCE 배치가 구분되어있고 4번에는 COPCreate만 들어가있다.
//    	ArrayList batchList = new ArrayList();




    	//장회수 추가 2007.10.01
//    	WebManager command = new WebManagerImpl();
//    	List taskList = ((WebManagerJSPEventResponse)command.searchWebManagerList()).getTaskInfoList();
//
//    	Trigger trigger = null;
//    	Task taskInfo = null;
    	
//    	String taskClassName = "";

//    	for (int i = 0; i < taskList.size(); i++) {
//    		taskClassName = "";    		
////    		taskInfo = (Task)taskList.get(i);
////    		trigger = (Trigger)taskInfo.getTrigger();
//    		
//    		taskClassName = taskInfo.getServicecommandClass().getName();
//    		if(taskInfo.isEnabled()){
//    			
//    			log.debug("\n Task Name : " + taskInfo.getName());
//	    		if(taskClassName.equals("com.clt.apps.opus.esd.sce.batch.trsinterface.TrsInterface2PrdBSC")){
//	    			batchList.add(SCEConstants.TB_SCE_SO_IF);
//	    		}else if(taskClassName.equals("com.clt.apps.opus.esd.sce.batch.copmanage.COPManageBSC")){
//	    			batchList.add(SCEConstants.TB_SCE_BKG_IF);
//	    		}else if(taskClassName.equals("com.clt.apps.opus.esd.sce.batch.actualdatareceive.ActualDataReceiveBSC")){
//	    			batchList.add(SCEConstants.TB_SCE_ACT_RCV_IF);
//	    		}else if(taskClassName.equals("com.clt.apps.opus.esd.sce.batch.actualdatareceivevsl.ActualDataReceiveVslBSC")){
//	    			batchList.add(SCEConstants.TB_SCE_VPS_IF);
//	    		}else if(taskClassName.equals("com.clt.apps.opus.esd.sce.batch.trodata.TROManagerBSC")){
//	    			batchList.add(SCEConstants.TB_SCE_TRO_IF);
//	    		}else if(taskClassName.equals("com.clt.apps.opus.esd.sce.batch.rtrmanage.RTRManageBSC")){
//	    			batchList.add(SCEConstants.TB_SCE_CLM_IF); 
//	    		}
//    		}
//    		log.debug(taskInfo.getServicecommandClass());
//    		log.debug(taskInfo.getServicecommandClass().getName());
//    		log.debug(taskInfo.getName());
//    		log.debug("" + taskInfo.isEnabled());
//    	}
    	
//		try {
//			for(int i = 0 ; i < batchList.size() ; i++){
//				dbDao.modifyTbPatch((String)batchList.get(i));
//			}
//		}catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}


//    	if(serverNm.equals("3NPA")){
//			batchList.add(SCEConstants.TB_SCE_ACT_RCV_IF);
//			batchList.add(SCEConstants.TB_SCE_CLM_if);
//			batchList.add(SCEConstants.TB_SCE_SO_IF);
//			batchList.add(SCEConstants.TB_SCE_TRO_IF);
//			batchList.add(SCEConstants.TB_SCE_VPS_IF);
//    	}else if(serverNm.equals("4NPA")){
//    		batchList.add(SCEConstants.TB_SCE_BKG_IF);
//    	}
//        try {
//
//        	for(int i = 0 ; i < batchList.size() ; i++){
//        		dbDao.updateTbPatch((String)batchList.get(i));
//        	}
//        }catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    }

	
}
