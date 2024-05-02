/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportJMSProxy.java
*@FileTitle : Interface 연동 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
* History
* 2012.09.20 이혜민 CHM-201220339-01 [FCM] VMS004송신 및 수신 특수문자 관련 로직보완
* 2014.04.07 박다은 CHM-201429498-01 [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
=========================================================*/
package com.clt.apps.opus.vop.fcm.servicesio;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.clt.apps.opus.vop.fcm.vesselreport.VesselReportSC;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.event.VopFcm0001Event;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
//import com.clt.irep.opus.VMS0040001Document;
//import com.clt.irep.opus.VMS0050001Document;
//import com.clt.irep.opus.VMS0040001Document.VMS0040001;
//import com.clt.irep.opus.VMS0050001Document.VMS0050001;
import com.jf.transfer.TransferEAI;

/**
 * ALPS VMS에서 EAI를 이용하여 Departure Report 수신.<br>
 * 
 * @author Hyuk Ryu
 * @see VopFcm0001Event 참조
 * @since J2EE 1.6
 */
public class VesselReportJMSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(VMS004_0001)
	 * VMS에서 EAI를 이용하여 Departure Report 수신
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
//	public void vopFcm0001ReceiveJMS(TransferEAI eai) throws EventException {
//	log.debug("\n<<<<<<<<<< VMS004_0001 JMS Start >>>>>>>>>>>>>>>>\n");	
//		
//		String str = eai.getMessage();
//		log.debug("\n======================================\n");
//		log.debug("xml : " + str);
//		log.debug("\n======================================\n");
//		
//		Event event = null;
//		VesselReportSC vesselReportSC = new VesselReportSC();
//		
//		try {
//			event = new VopFcm0001Event();
//			
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.MULTI);
//			event.setFormCommand(f);
//			
//			VMS0040001Document doc = VMS0040001Document.Factory.parse(str);
//			VMS0040001 vms0040001 = doc.getVMS0040001();
//			VMS0040001.DataArea dataArea = vms0040001.getDataArea();
//			VMS0040001.DataArea.DepatureETACollection col = dataArea.getDepatureETACollection();
//			
//			String eaiIfId = vms0040001.getEAIHeader().getInstanceId();
//			
//			FcmDepRptLogVO[] fcmDepRptLogVOs = new FcmDepRptLogVO[col.sizeOfDepatureArray()];
//
//			for(int i=0; i<col.sizeOfDepatureArray(); i++){
//				
//				VMS0040001.DataArea.DepatureETACollection.Depature data = col.getDepatureArray(i);
//				
//				fcmDepRptLogVOs[i] = new FcmDepRptLogVO();
//				fcmDepRptLogVOs[i].setEaiIfId                (eaiIfId)                 ;
////				fcmDepRptLogVOs[i].setIfFlg                  ("N")                     ;
//				fcmDepRptLogVOs[i].setVslCd                  (data.getVSLCD()         );    
//				fcmDepRptLogVOs[i].setVoyDirCd               (data.getVOYNO()         );   
//				fcmDepRptLogVOs[i].setVslSlanCd              (data.getLANECD()        );   
//				fcmDepRptLogVOs[i].setDepPortCd              (data.getDEPPORT()       );   
//				fcmDepRptLogVOs[i].setClptIndSeq             (data.getFST()           );   
//				fcmDepRptLogVOs[i].setGmtTdHrs               (data.getZT()            );   
//				fcmDepRptLogVOs[i].setNxtPortCd              (data.getNEXTPORT()      );   
//				fcmDepRptLogVOs[i].setNxtPortEtaDt           (data.getETA()           );  
//				fcmDepRptLogVOs[i].setRmnDist                (data.getTOGOMILE()      );    
//				fcmDepRptLogVOs[i].setRmnAvgSpd              (data.getTOGOSPD()       );   
//				fcmDepRptLogVOs[i].setArrDrftCtnt            (data.getDFTARR()        );   
//				fcmDepRptLogVOs[i].setDepDrftCtnt            (data.getDFTDEP()        );   
//				fcmDepRptLogVOs[i].setNxtDrftCtnt            (data.getDFTNEXT()       );   
//				fcmDepRptLogVOs[i].setArrRobCtnt             (data.getROBARR()        );   
//				fcmDepRptLogVOs[i].setDepRobCtnt             (data.getROBDEP()        );   
//				fcmDepRptLogVOs[i].setNxtRobCtnt             (data.getROBNEXT()       );   
//				fcmDepRptLogVOs[i].setSplOilCtnt             (data.getROBSUP()        );   
//				fcmDepRptLogVOs[i].setNvgtMlDist             (data.getMILESOBS()      );   
//				fcmDepRptLogVOs[i].setAvgSpd                 (data.getSPD()           );    
//				fcmDepRptLogVOs[i].setAvgRpmPwr              (data.getRPM()           );   
//				fcmDepRptLogVOs[i].setBlkLodDchgStsCd        (data.getLOAD()          ); 
//				fcmDepRptLogVOs[i].setBlkCgoTpCd1            (data.getCARGOCD()       );  
//				fcmDepRptLogVOs[i].setBlkHldLoadCtnt         (data.getWTHD()          );  
//				fcmDepRptLogVOs[i].setSbEngDt                (data.getTIMESBE()       );   
//				fcmDepRptLogVOs[i].setPltInDt                (data.getTIMEAPS()       );   
//				fcmDepRptLogVOs[i].setVpsEtbDt               (data.getTIMEBERTH()     );   
//				fcmDepRptLogVOs[i].setCgoWrkStDt             (data.getTIMECOMM()      );  
//				fcmDepRptLogVOs[i].setCgoWrkEndDt            (data.getTIMECOMP()      );  
//				fcmDepRptLogVOs[i].setVpsEtdDt               (data.getTIMEDEP()       );   
//				fcmDepRptLogVOs[i].setPltOutDt               (data.getTIMEDOP()       );   
//				fcmDepRptLogVOs[i].setRupDt                  (data.getTIMERUP()       );    
////				fcmDepRptLogVOs[i].setDepRmk                 (data.getDEPARTURERMK()  );
//				fcmDepRptLogVOs[i].setDepStsCd               (data.getPURPOSECD()     );   
//				fcmDepRptLogVOs[i].setRunHrsInHvWe           (data.getHWX()           );  
//				fcmDepRptLogVOs[i].setSeaDnst                (data.getDENSITY()       );    
//				fcmDepRptLogVOs[i].setDetRsnCtnt             (data.getDET()           );   
//				fcmDepRptLogVOs[i].setEngMlDist              (data.getMILESENG()      );   
//				fcmDepRptLogVOs[i].setMnvrInMlDist           (data.getMILESIN()       );  
//				fcmDepRptLogVOs[i].setMnvrOutMlDist          (data.getMILESOUT()      );  
////				fcmDepRptLogVOs[i].setBlkDepCgoTtlWgt        (data.getWEIGHT()        ); // WEIGHT is BULK item, not CNTR.
//				fcmDepRptLogVOs[i].setBfrBrthAnkDrpDt        (data.getTIMEANC()       ); 
//				fcmDepRptLogVOs[i].setBfrBrthAnkOffDt        (data.getTIMEAWY()       ); 
//				fcmDepRptLogVOs[i].setAftUnbrthAnkDrpDt      (data.getTIMEDEPANC()    ); 
//				fcmDepRptLogVOs[i].setAftUnbrthAnkOffDt      (data.getTIMEDEPAWY()    ); 
//				fcmDepRptLogVOs[i].setSeaFuelCsmCtnt         (data.getROBSEA()        );  
//				fcmDepRptLogVOs[i].setPortFuelCsmCtnt        (data.getROBPORT()       );  
//				fcmDepRptLogVOs[i].setRefNo                  (data.getREFNO()         );    
//				fcmDepRptLogVOs[i].setCntrCgoCtnt            (data.getCARGOCNTR()     );   
//				fcmDepRptLogVOs[i].setDepCgoWgt              (data.getCGOWHT()        );   
//				fcmDepRptLogVOs[i].setDepDplWgt              (data.getCGODIS()        );   
//				fcmDepRptLogVOs[i].setBlkCgoTpCd2            (data.getCARGOCD2()      );  
//				fcmDepRptLogVOs[i].setBlkCgoTpCd3            (data.getCARGOCD3()      );  
//				fcmDepRptLogVOs[i].setBlkCgoTpCd4            (data.getCARGOCD4()      );  
//				fcmDepRptLogVOs[i].setBlkCgoTpCd5            (data.getCARGOCD5()      );  
//				fcmDepRptLogVOs[i].setSeaLowSulpFuelCsmCtnt  (data.getROBSEALS()      );
//				fcmDepRptLogVOs[i].setPortLowSulpFuelCsmCtnt (data.getROBPORTLS()     );
//				fcmDepRptLogVOs[i].setSplLowSulpOilCtnt      (data.getROBSUPLS()      ); 
//				fcmDepRptLogVOs[i].setTtlSlgWgt              (data.getSDGTOTAL()      );
//				fcmDepRptLogVOs[i].setFoSlgWgt               (data.getSDGFO()         );   
//				fcmDepRptLogVOs[i].setIncnrSlgWgt            (data.getSDGINCI()       );   
//				fcmDepRptLogVOs[i].setDplSlgWgt              (data.getSDGDIS()        );   
//				fcmDepRptLogVOs[i].setDplSlgSp               (data.getSDGDISNM()      );   
//				fcmDepRptLogVOs[i].setRmnSdgWgt              (data.getSDGREMAIN()     );   
//				fcmDepRptLogVOs[i].setFoilPurfDchgItval      (data.getSDGPUR()        );  
//				fcmDepRptLogVOs[i].setCapNm                  (data.getCAPNM()         );    
//				fcmDepRptLogVOs[i].setCfEngNm                (data.getCENM()          );    
//				fcmDepRptLogVOs[i].setDepLat                 (data.getDEPLAT()        );    
//				fcmDepRptLogVOs[i].setDepLon                 (data.getDEPLONG()       );    
//				fcmDepRptLogVOs[i].setDepRpmPwr              (data.getDEPRPM()        );   
//				fcmDepRptLogVOs[i].setDepRpmMaxPwr           (data.getDEPRPMMAX()     );  
//				fcmDepRptLogVOs[i].setDepRpmMinPwr           (data.getDEPRPMMIN()     );  
//				fcmDepRptLogVOs[i].setDepRpmUusdFm           (data.getDEPRPMUNSBLFM() );  
//				fcmDepRptLogVOs[i].setDepRpmUusdTo           (data.getDEPRPMUNSBLTO() );   
//				fcmDepRptLogVOs[i].setDepArrPltMgnHrs        (data.getDEPHRS()        ); 
//				fcmDepRptLogVOs[i].setDepArrPltMgnMnts       (data.getDEPMIN()        ); 
//				fcmDepRptLogVOs[i].setDepRmk         		 (data.getDEPRMK().replaceAll("&amp;", "&").replaceAll("&lt;", "<")); 
//				fcmDepRptLogVOs[i].setArrLat                 (data.getARRLAT()        );    
//				fcmDepRptLogVOs[i].setArrLon                 (data.getARRLONG()       );    
//				fcmDepRptLogVOs[i].setArrSailHrs             (data.getARRRH()         );   
//				fcmDepRptLogVOs[i].setArrNvgtMl              (data.getARRMILESOBS()   );   
//				fcmDepRptLogVOs[i].setArrEngMl               (data.getARRMILESENG()   );   
//				fcmDepRptLogVOs[i].setArrRpmPwr              (data.getARRRPM()        );   
//				fcmDepRptLogVOs[i].setArrMnFoilCsmQty        (data.getARRFOCON()      ); 
//				fcmDepRptLogVOs[i].setArrMnLowSulpFoilCsmQty (data.getARRLSFOCON()    );
//				fcmDepRptLogVOs[i].setArrGnrFoilCsmQty       (data.getARRAUXCON()     ); 
//				fcmDepRptLogVOs[i].setArrGnrLowSulpFoilCsmQty(data.getARRLSAUXCON()   );
//				fcmDepRptLogVOs[i].setArrBlrFoilCsmQty       (data.getARRBLRCON()     ); 
//				fcmDepRptLogVOs[i].setArrBlrLowSulpFoilCsmQty(data.getARRLSBLRCON()   );
//				fcmDepRptLogVOs[i].setArrDoilCsmQty          (data.getARRDOCON()      );  
//				fcmDepRptLogVOs[i].setArrLowSulpDoilCsmQty   (data.getARRLSDOCON()    );
//				
//				fcmDepRptLogVOs[i].setCreUsrId               ("VMS004_0001")           ;
//				fcmDepRptLogVOs[i].setUpdUsrId               ("VMS004_0001")           ;
//				fcmDepRptLogVOs[i].setVslRptTjTpCd           (data.getCUDFLG()        );
//
//				//  CHM-201429498-01 [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
//				fcmDepRptLogVOs[i].setOldVslCd				 (data.getOLDVSLCD()	  );
//				fcmDepRptLogVOs[i].setOldVoyDirCd			 (data.getOLDVOYNO()	  );
//				fcmDepRptLogVOs[i].setOldVslSlanCd			 (data.getOLDLANECD()	  );
//				fcmDepRptLogVOs[i].setOldDepPortCd			 (data.getOLDDEPPORT()	  );
//				fcmDepRptLogVOs[i].setOldClptIndSeq			 (data.getOLDFST()	   	  );
//				
//				log.debug("******fcmDepRptLogVO.getColumnValues()********\n" + fcmDepRptLogVOs[i].getColumnValues());
//			}
//			
//			((VopFcm0001Event)event).setFcmDepRptLogVOs(fcmDepRptLogVOs);
//			vesselReportSC.perform(event);
//		
//			eai.commit(eaiIfId);
//		
//			log.debug("\n<<<<<<<<<< VMS004_0001 JMS End >>>>>>>>>>>>>>>>\n");	
//			
//		} catch (EventException ee) {
//			log.error("EventException ee : " + ee.toString(), ee);
//			eai.rollback(ee);
//			throw new EventException(new ErrorHandler(ee).getMessage());
//		} catch (XmlException ex) {
//			log.error("XmlException ex : " + ex.toString(), ex);
//			eai.rollback(ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} catch (Exception e){
//			log.error("Exception e : " + e.toString());
//			eai.rollback(e);
//			throw new EventException(new ErrorHandler(e).getMessage());
//		} finally{
//			eai.close();			
//		}
//		
//	}
	
	/**
	 * JMS Receive(VMS005_0001)
	 * VMS에서 EAI를 이용하여 Departure Report 수신
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
//	public void vopFcm0002ReceiveJMS(TransferEAI eai) throws EventException {
//	log.debug("\n<<<<<<<<<< VMS005_0001 JMS Start >>>>>>>>>>>>>>>>\n");	
//		
//		String str = eai.getMessage();
//		log.debug("\n======================================\n");
//		log.debug("xml : " + str);
//		log.debug("\n======================================\n");
//		
//		Event event = null;
//		VesselReportSC vesselReportSC = new VesselReportSC();
//		
//		try {
//			event = new VopFcm0001Event();
//			
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.MULTI01);
//			event.setFormCommand(f);
//			
//			VMS0050001Document doc = VMS0050001Document.Factory.parse(str);
//			VMS0050001 vms0050001 = doc.getVMS0050001();
//			VMS0050001.DataArea dataArea = vms0050001.getDataArea();
//			VMS0050001.DataArea.NoonCollection col = dataArea.getNoonCollection();
//			
//			String eaiIfId = vms0050001.getEAIHeader().getInstanceId();
//			
//			FcmNoonRptLogVO[] fcmNoonRptLogVOs = new FcmNoonRptLogVO[col.sizeOfNoonArray()];
//
//			for(int i=0; i<col.sizeOfNoonArray(); i++){
//				
//				VMS0050001.DataArea.NoonCollection.Noon data = col.getNoonArray(i);
//				
//				fcmNoonRptLogVOs[i]= new FcmNoonRptLogVO();
//				
//				fcmNoonRptLogVOs[i].setEaiIfId              (eaiIfId)               ;
//				fcmNoonRptLogVOs[i].setVslCd                (data.getVSLCD      () ); 
//				fcmNoonRptLogVOs[i].setVoyDirCd             (data.getVOYNO      () );
//				fcmNoonRptLogVOs[i].setVslSlanCd            (data.getLANECD     () );
//				fcmNoonRptLogVOs[i].setNoonRptDt            (data.getGMT        () );
//				fcmNoonRptLogVOs[i].setNoonRptLat           (data.getLAT        () );
//				fcmNoonRptLogVOs[i].setNoonRptLon           (data.getVSLLONG    () );
//				fcmNoonRptLogVOs[i].setSailHrmnt            (data.getSAILTIME   () );
//				fcmNoonRptLogVOs[i].setNvgtMlDist           (data.getMILESOBS   () );
//				fcmNoonRptLogVOs[i].setEngMlDist            (data.getMILESENG   () );
//				fcmNoonRptLogVOs[i].setWndFrc               (data.getWINDF      () );
//				fcmNoonRptLogVOs[i].setSeaFrc               (data.getSEAF       () );
//				fcmNoonRptLogVOs[i].setVisRngNo             (data.getVIS        () );
//				fcmNoonRptLogVOs[i].setSailAvgSpd           (data.getSPD        () );
//				fcmNoonRptLogVOs[i].setSailAvgRpmPwr        (data.getRPM        () );
//				fcmNoonRptLogVOs[i].setSlpRt                (data.getSLIP       () );
//				fcmNoonRptLogVOs[i].setRmnDist              (data.getTOGOMILE   () );
//				fcmNoonRptLogVOs[i].setRmnAvgSpd            (data.getTOGOSPD    () );
//				fcmNoonRptLogVOs[i].setCrsNo                (data.getCO         () );
//				fcmNoonRptLogVOs[i].setMnFoilCsmQty         (data.getFOCON      () );
//				fcmNoonRptLogVOs[i].setMnDoilCsmQty         (data.getDOCON      () );
//				fcmNoonRptLogVOs[i].setNxtPortCd            (data.getNEXTPORT   () );
//				fcmNoonRptLogVOs[i].setNxtPortEtaDt         (data.getETA        () );
////				fcmNoonRptLogVOs[i].setNoonRptRmk           (data.getNOONRMK    () );
//				fcmNoonRptLogVOs[i].setDgSailFlg            (data.getDANYN      () );
//				fcmNoonRptLogVOs[i].setDgSailRmk            (data.getDANREASON  () );
//				fcmNoonRptLogVOs[i].setBilgeChkFlg          (data.getBILGECHK   () );
//				fcmNoonRptLogVOs[i].setHldTempChkFlg        (data.getTEMPCHK    () );
//				fcmNoonRptLogVOs[i].setHldGasChkFlg         (data.getGASCHK     () );
//				fcmNoonRptLogVOs[i].setBlstXchFlg           (data.getBALLASTEXCH() );
//				fcmNoonRptLogVOs[i].setHldClnFlg            (data.getFOLDCLEAN  () ); // FOLDCLEAN ==> HOLDCLEAN
//				fcmNoonRptLogVOs[i].setPscPrprFlg           (data.getPSCINSP    () );
//				fcmNoonRptLogVOs[i].setRefNo                (data.getREFNO      () );
//				fcmNoonRptLogVOs[i].setGnrFoilCsmQty        (data.getAUXCON     () );
//				fcmNoonRptLogVOs[i].setBlrFoilCsmQty        (data.getBURCON     () ); // BURCON ==> BLRCON
//				fcmNoonRptLogVOs[i].setMnPwr                (data.getENERGY     () );
//				fcmNoonRptLogVOs[i].setLodIndQty            (data.getLI         () );
//				fcmNoonRptLogVOs[i].setMnLowSulpFoilCsmQty  (data.getLSFOCON    () );
//				fcmNoonRptLogVOs[i].setGnrLowSulpFoilCsmQty (data.getLSAUXCON   () );
//				fcmNoonRptLogVOs[i].setBlrLowSulpFoilCsmQty (data.getLSBLRCON   () );
//				fcmNoonRptLogVOs[i].setMnLowSulpDoilCsmQty  (data.getLSDOCON    () );
//				
//				fcmNoonRptLogVOs[i].setCreUsrId             ("VMS005_0001"         );
//				fcmNoonRptLogVOs[i].setUpdUsrId             ("VMS005_0001"         );
//				fcmNoonRptLogVOs[i].setVslRptTjTpCd         (data.getCUDFLG()        );
//				
//				log.debug("******fcmNoonRptLogVO.getColumnValues()********\n" + fcmNoonRptLogVOs[i].getColumnValues());
//			}
//			
//			((VopFcm0001Event)event).setFcmNoonRptLogVOs(fcmNoonRptLogVOs);
//			vesselReportSC.perform(event);
//			
//			eai.commit(eaiIfId);
//			
//			log.debug("\n<<<<<<<<<< VMS005_0001 JMS End >>>>>>>>>>>>>>>>\n");	
//			
//		} catch (EventException ee) {
//			log.error("EventException ee : " + ee.toString(), ee);
//			eai.rollback(ee);
//			throw new EventException(new ErrorHandler(ee).getMessage());
//		} catch (XmlException ex) {
//			log.error("XmlException ex : " + ex.toString(), ex);
//			eai.rollback(ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} catch (Exception e){
//			log.error("Exception e : " + e.toString());
//			eai.rollback(e);
//			throw new EventException(new ErrorHandler(e).getMessage());
//		} finally{
//			eai.close();			
//		}
//		
//	}
	
//	/**
//	 * JMS Receive(VMS006_0001)
//	 * VMS에서 EAI를 이용하여 ABLog Report 수신
//	 * 
//	 * @param TransferEAI eai
//	 * @exception EventException
//	 */
//	public void vopFcm0003ReceiveJMS(TransferEAI eai) throws EventException {
//	log.debug("\n<<<<<<<<<< VMS006_0001 JMS Start >>>>>>>>>>>>>>>>\n");	
//		
//		String str = eai.getMessage();
//		log.debug("\n======================================\n");
//		log.debug("xml : " + str);
//		log.debug("\n======================================\n");
//		
//		Event event = null;
//		VesselReportSC vesselReportSC = new VesselReportSC();
//		
//		try {
//			event = new VopFcm0001Event();
//			
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.MULTI03);
//			event.setFormCommand(f);
//			
//			VMS0060001Document doc = VMS0060001Document.Factory.parse(str);
//			VMS0060001 vms0060001 = doc.getVMS0060001();
//			VMS0060001.DataArea data = vms0060001.getDataArea();
//			
//			FcmAblogRptLogVO fcmAblogRptLogVO= new FcmAblogRptLogVO();
//			fcmAblogRptLogVO.setVslCd(data.getOAblogReportCollection().getVSLCD());
//			fcmAblogRptLogVO.setVslSlanCd(data.getOAblogReportCollection().getLANECD());
//			fcmAblogRptLogVO.setVoyDirCd(data.getOAblogReportCollection().getVOYNO());
//			fcmAblogRptLogVO.setNisVoyDirCd(data.getOAblogReportCollection().getNISVOYNO());
//			fcmAblogRptLogVO.setRptDt(data.getOAblogReportCollection().getREPORTDT());
//			fcmAblogRptLogVO.setSailTm(data.getOAblogReportCollection().getTIMESAIL());
//			fcmAblogRptLogVO.setPltInTm(data.getOAblogReportCollection().getTIMEPILOT());
//			fcmAblogRptLogVO.setBrthTm(data.getOAblogReportCollection().getTIMEBERTH());
//			fcmAblogRptLogVO.setPortTm(data.getOAblogReportCollection().getTIMEPORT());
//			fcmAblogRptLogVO.setPortDlayTm(data.getOAblogReportCollection().getTIMEDETP());
//			fcmAblogRptLogVO.setSeaDlayTm(data.getOAblogReportCollection().getTIMEDETS());
//			fcmAblogRptLogVO.setSailDist(data.getOAblogReportCollection().getDISTSEA());
//			fcmAblogRptLogVO.setSailAvgSpd(data.getOAblogReportCollection().getSPEED());
//						
//			((VopFcm0001Event)event).setFcmAblogRptLogVO(fcmAblogRptLogVO);
//			vesselReportSC.perform(event);
//			
//			eai.commit(doc.getVMS0060001().getEAIHeader().getInstanceId());
//			                                 		                                        
//			log.debug("******fcmAblogRptLogVO.getColumnValues()********\n" + fcmAblogRptLogVO.getColumnValues());                                     	                                        
//			////////////////
//			
//			log.debug("\n<<<<<<<<<< VMS006_0001 JMS End >>>>>>>>>>>>>>>>\n");	
//			
//		} catch (EventException ee) {
//			log.error("EventException ee : " + ee.toString(), ee);
//			eai.rollback(ee);
//			throw new EventException(new ErrorHandler(ee).getMessage());
//		} catch (XmlException ex) {
//			log.error("XmlException ex : " + ex.toString(), ex);
//			eai.rollback(ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} catch (Exception e){
//			log.error("Exception e : " + e.toString());
//			eai.rollback(e);
//			throw new EventException(new ErrorHandler(e).getMessage());
//		} finally{
//			eai.close();			
//		}
//		
//	}
//	
	/**
	 * JMS Receive(VMS007_0001)
	 * VMS에서 EAI를 이용하여 DSL Report 수신
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
//	public void vopFcm0004ReceiveJMS(TransferEAI eai) throws EventException {
//	log.debug("\n<<<<<<<<<< VMS007_0001 JMS Start >>>>>>>>>>>>>>>>\n");	
//		
//		String str = eai.getMessage();
//		log.debug("\n======================================\n");
//		log.debug("xml : " + str);
//		log.debug("\n======================================\n");
//		
//		Event event = null;
//		VesselReportSC vesselReportSC = new VesselReportSC();
//		
//		try {
//			
//			event = new VopFcm0001Event();
//			
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.MULTI02);
//			event.setFormCommand(f);
//			
//			VMS0070001Document doc = VMS0070001Document.Factory.parse(str);
//			VMS0070001 vms0070001 = doc.getVMS0070001();
//			VMS0070001.DataArea dataArea = vms0070001.getDataArea();
//			VMS0070001.DataArea.DslETACollection col = dataArea.getDslETACollection();
//			
//			String eaiIfId = vms0070001.getEAIHeader().getInstanceId();
//			
//			FcmDslRptLogVO[] fcmDslRptLogVOs = new FcmDslRptLogVO[col.sizeOfDslArray()];
//
//			for(int i=0; i<col.sizeOfDslArray(); i++){
//				
//				VMS0070001.DataArea.DslETACollection.Dsl data = col.getDslArray(i);
//				
//				fcmDslRptLogVOs[i] = new FcmDslRptLogVO();
//				fcmDslRptLogVOs[i].setVslCd(              data.getVSLCD());
//				fcmDslRptLogVOs[i].setRptDt(              data.getSVRDT());
//				fcmDslRptLogVOs[i].setRptSeq(             data.getSEQNO());
//				fcmDslRptLogVOs[i].setVoyDirCd(           data.getVOYNO());
//				fcmDslRptLogVOs[i].setVslSpd(             data.getVSLSPD());
//				fcmDslRptLogVOs[i].setVslRpm(             data.getVSLRPM());
//				fcmDslRptLogVOs[i].setRptHrs(             data.getRHR());
//				fcmDslRptLogVOs[i].setFoilCsmWgt(         data.getFOCTD());
//				fcmDslRptLogVOs[i].setClndOilCsmWgt(      data.getCOCLD());
//				fcmDslRptLogVOs[i].setLodInd(             data.getLI());
//				fcmDslRptLogVOs[i].setGovInd(             data.getGI());
//				fcmDslRptLogVOs[i].setJacClngTempHigh(    data.getJCTH());
//				fcmDslRptLogVOs[i].setJacClngTempLow(     data.getJCTL());
//				fcmDslRptLogVOs[i].setPstClngTempHigh(    data.getPCTH());
//				fcmDslRptLogVOs[i].setPstClngTempLow(     data.getPCTH());
//				fcmDslRptLogVOs[i].setScavAirTempHigh(    data.getSATH());
//				fcmDslRptLogVOs[i].setScavAirTempLow(     data.getSATL());
//				fcmDslRptLogVOs[i].setTbcgrRpmHigh(       data.getTCRH());
//				fcmDslRptLogVOs[i].setTbcgrRpmLow(        data.getTCRL());
//				fcmDslRptLogVOs[i].setExhGasTempList(     data.getEGT());
//				fcmDslRptLogVOs[i].setExhGasTempHigh(     data.getEGTH());
//				fcmDslRptLogVOs[i].setExhGasTempLow(      data.getEGTL());
//				fcmDslRptLogVOs[i].setFoilSpecGrav(       data.getFOSG());
//				fcmDslRptLogVOs[i].setClndOilSpecGrav(    data.getCOSG());
//				fcmDslRptLogVOs[i].setSulp(               data.getS());
//				fcmDslRptLogVOs[i].setPm(                 data.getPM());
//				fcmDslRptLogVOs[i].setPmh(                data.getPMH());
//				fcmDslRptLogVOs[i].setPml(                data.getPML());
//				fcmDslRptLogVOs[i].setPc(                 data.getPC());
//				fcmDslRptLogVOs[i].setPch(                data.getPCH());
//				fcmDslRptLogVOs[i].setPcl(                data.getPCL());
//				fcmDslRptLogVOs[i].setRmk(                data.getRMK());
//				fcmDslRptLogVOs[i].setFqs(                data.getFQS());
//				fcmDslRptLogVOs[i].setDpach(              data.getDPACH());
//				fcmDslRptLogVOs[i].setDpacl(              data.getDPACL());
//				fcmDslRptLogVOs[i].setDpeh(               data.getDPEH());
//				fcmDslRptLogVOs[i].setDpel(               data.getDPEL());
//				fcmDslRptLogVOs[i].setRefNo(              data.getREFNO());
//			
//				fcmDslRptLogVOs[i].setCreUsrId             ("VMS007_0001"         );
//				fcmDslRptLogVOs[i].setUpdUsrId             ("VMS007_0001"         );
//				fcmDslRptLogVOs[i].setVslRptTjTpCd         (data.getCUDFLG()      );
//				
//				log.debug("******fcmDslRptLogVO.getColumnValues()********\n" + fcmDslRptLogVOs[i].getColumnValues());
//			}
//			
//			((VopFcm0001Event)event).setFcmDslRptLogVOs(fcmDslRptLogVOs);
//			vesselReportSC.perform(event);
//			
//			eai.commit(eaiIfId);
//			                                 		                                        
//			log.debug("\n<<<<<<<<<< VMS007_0001 JMS End >>>>>>>>>>>>>>>>\n");	
//			
//		} catch (EventException ee) {
//			log.error("EventException ee : " + ee.toString(), ee);
//			eai.rollback(ee);
//			throw new EventException(new ErrorHandler(ee).getMessage());
//		} catch (XmlException ex) {
//			log.error("XmlException ex : " + ex.toString(), ex);
//			eai.rollback(ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} catch (Exception e){
//			log.error("Exception e : " + e.toString());
//			eai.rollback(e);
//			throw new EventException(new ErrorHandler(e).getMessage());
//		} finally{
//			eai.close();			
//		}
//		
//	}

//	/**
//	 * VMS 수신시 특수문자를 찾아서 replace한다.
//	 * 
//	 * @param String depRmk
//	 * @return String
//	 * @exception EventException
//	 */
//	private String searchSpcCharacterReplace(String depRmk) throws EventException {
//		EventResponse eventResponse = new GeneralEventResponse();
//		VesselReportSC vesselReportSC = new VesselReportSC();
//		Event event = null;
//		String depRmkRp = "";
//		try {
//			event = new VopFcm0001Event();
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.SEARCH05);
//			event.setFormCommand(f);
//			
//			eventResponse = vesselReportSC.perform(event);
//
//			depRmkRp = eventResponse.getETCData().get(0);
//			
//		} catch (EventException ee) {
//			log.error("EventException ee : " + ee.toString(), ee);
//			throw new EventException(new ErrorHandler(ee).getMessage());
//		} catch (Exception e){
//			log.error("Exception e : " + e.toString());
//			throw new EventException(new ErrorHandler(e).getMessage());
//		} 
//		return depRmkRp;
//	}
	

}
