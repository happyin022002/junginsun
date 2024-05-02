/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SchedulePlanningOperationJMSProxy.java
*@FileTitle : ENIS Interface Link 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.vop.vsk.servicesio;

import org.apache.log4j.Logger;

import com.clt.bizcommon.erpcom.ReceiveQueueRSC;

/**
 * Getting String Message from JMS, over to SchedulePlanningOperationJMSProxy. [Warn] Define method in queue-mapping.xml
 *
 * @author 
 * @see ReceiveQueueRSC
 * @since J2EE 1.4
 */
public class SchedulePlanningOperationJMSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * JMS Receive(ESD061-0001)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
//	public void esd0610001ReceiveJMS(TransferEAI eai) throws EventException {
//
//		log.debug("\n<<<<<<<<<< ESD0610001 JMS Start >>>>>>>>>>>>>>>>\n");		
//		
//		String str = eai.getMessage();
//		//log.debug("\n======================================\n");
//		//log.debug("xml : " + str);
//		//log.debug("\n======================================\n");
//		
//		Event event = null;
//		SchedulePlanningOperationSC schedulePlanningOperationSC = new SchedulePlanningOperationSC();
//		
//		String[] arrWindInfo = new String[2];	
//		
//		try {
//			event = new VopVskESD0610001Event();
//			
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.MULTI);
//			event.setFormCommand(f);
//			
//		 	// XML SCHEMA
//			//ESM0740001Document doc = ESM0740001Document.Factory.parse(eai.getMessage());
//			//ESM0740001 eSM0740001 = doc.getESM0740001();
//			//ESM0740001.DataArea data = eSM0740001.getDataArea();
//			//ESM0740001.DataArea.CertInfoCollection col = data.getCertInfoCollection();
//			
//			ESD0610001Document doc = ESD0610001Document.Factory.parse(str);
//			ESD0610001 esd0610001 = doc.getESD0610001();
//			ESD0610001.DataArea data = esd0610001.getDataArea();
//			ESD0610001.DataArea.NoonETACollection col = data.getNoonETACollection();
//			
//			VskNoonRptVO[] vskNoonRptVOs = new VskNoonRptVO[col.sizeOfNoonETAArray()];
//
//			for(int i=0; i<col.sizeOfNoonETAArray(); i++){
//				ESD0610001.DataArea.NoonETACollection.NoonETA inbound = col.getNoonETAArray(i);
//				
//				vskNoonRptVOs[i] = new VskNoonRptVO();
//				vskNoonRptVOs[i].setVslCd(inbound.getVSLCD());				//PK	
//				vskNoonRptVOs[i].setSkdVoyNo(inbound.getSKDVOYNO());		//PK
//				vskNoonRptVOs[i].setSkdDirCd(inbound.getSKDDIRCD());		//PK
//				vskNoonRptVOs[i].setNoonRptDt(inbound.getNOONRPTDT());		//PK
//				vskNoonRptVOs[i].setNxtPortCd(inbound.getNXTPORTCD());	
//				vskNoonRptVOs[i].setNxtPortEtaDt(inbound.getNXTPORTETADT());	
//				vskNoonRptVOs[i].setActGdt(inbound.getACTGDT());		
//				vskNoonRptVOs[i].setPortLat(inbound.getPORTLAT());		
//				vskNoonRptVOs[i].setPortLon(inbound.getPORTLON());		
//				vskNoonRptVOs[i].setSailHrmnt(inbound.getSAILHRMNT());	
//				vskNoonRptVOs[i].setNvgtDist(inbound.getNVGTDIST());		
//				vskNoonRptVOs[i].setEngMlDist(inbound.getENGMLDIST());
//				
//				//WND_DIR_CTNT	WND_SCL_NO	( SW3)
//				arrWindInfo = splitWindInfo(inbound.getWNDDIRCTNT());
//				vskNoonRptVOs[i].setWndDirCtnt(arrWindInfo[0]);	
//				vskNoonRptVOs[i].setWndSclNo(arrWindInfo[1]);
//				
//				//OCN_CRNT_CTNT	SEA_STE_NO	( N9)
//				arrWindInfo = splitWindInfo(inbound.getOCNCRNTCTNT());
//				vskNoonRptVOs[i].setOcnCrntCtnt(arrWindInfo[0]);	
//				vskNoonRptVOs[i].setSeaSteNo(arrWindInfo[1]);
//				
//				vskNoonRptVOs[i].setVisRngNo(inbound.getVISRNGNO());		
//				vskNoonRptVOs[i].setCrntActSpd(inbound.getCRNTACTSPD());	
//				vskNoonRptVOs[i].setCrntActRpmPwr(inbound.getCRNTACTRPMPWR());
//				vskNoonRptVOs[i].setSlpRt(inbound.getSLPRT());		
//				vskNoonRptVOs[i].setRmnDist(inbound.getRMNDIST());		
//				vskNoonRptVOs[i].setRmnAvgSpd(inbound.getRMNAVGSPD());	
//				vskNoonRptVOs[i].setFoilCsmWgt(inbound.getFOILCSMWGT());	
//				vskNoonRptVOs[i].setDoilCsmWgt(inbound.getDOILCSMWGT());	
//				vskNoonRptVOs[i].setCrsNo(inbound.getCRSNO());		
//				vskNoonRptVOs[i].setLodIndQty(inbound.getLODINDQTY());	
//				vskNoonRptVOs[i].setCreUsrId("ESD061-0001");		
//				vskNoonRptVOs[i].setCreDt(inbound.getCREDT());		
//				vskNoonRptVOs[i].setUpdUsrId(inbound.getCUDFLG());			//Delete Flag		
//				vskNoonRptVOs[i].setUpdDt(inbound.getUPDDT());		
//			}
//			
//			((VopVskESD0610001Event)event).setVskNoonRptVOs(vskNoonRptVOs);
//			schedulePlanningOperationSC.perform(event);
//			
//			eai.commit(doc.getESD0610001().getEAIHeader().getInstanceId());
//			
//			log.debug("\n<<<<<<<<<< ESD0610001 JMS End >>>>>>>>>>>>>>>>\n");		
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
//	/**
//	 * JMS Receive(ESD062-0001)<br>
//	 * 
//	 * @param TransferEAI eai
//	 * @exception EventException
//	 */
//	public void esd0620001ReceiveJMS(TransferEAI eai) throws EventException {
//		
//		log.debug("\n<<<<<<<<<< ESD0620001 JMS Start >>>>>>>>>>>>>>>>\n");	
//		
//		String str = eai.getMessage();
//		//log.debug("\n======================================\n");
//		//log.debug("xml : " + str);
//		//log.debug("\n======================================\n");
//		
//		Event event = null;
//		SchedulePlanningOperationSC schedulePlanningOperationSC = new SchedulePlanningOperationSC();
//		
//		try {
//			event = new VopVskESD0620001Event();
//			
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.MULTI);
//			event.setFormCommand(f);
//			
//			ESD0620001Document doc = ESD0620001Document.Factory.parse(str);
//			ESD0620001 esd0620001 = doc.getESD0620001();
//			ESD0620001.DataArea data = esd0620001.getDataArea();
//			ESD0620001.DataArea.DepatureETACollection col = data.getDepatureETACollection();
//			
//			VskDepRptVO[] vskDepRptVOs = new VskDepRptVO[col.sizeOfDepatureETAArray()];
//			
//			for(int i=0; i<col.sizeOfDepatureETAArray(); i++){
//				ESD0620001.DataArea.DepatureETACollection.DepatureETA inbound = col.getDepatureETAArray(i);
//				
//				vskDepRptVOs[i] = new VskDepRptVO();
//				
//				vskDepRptVOs[i].setVslCd                    (inbound.getVSLCD()                   );	//PK
//				vskDepRptVOs[i].setSkdVoyNo                 (inbound.getSKDVOYNO()                );	//PK
//				vskDepRptVOs[i].setSkdDirCd                 (inbound.getSKDDIRCD()                );	//PK
//				vskDepRptVOs[i].setVpsPortCd                (inbound.getVPSPORTCD()               );	//PK
//				vskDepRptVOs[i].setClptIndSeq               (inbound.getCLPTINDSEQ()              );	//PK
//				vskDepRptVOs[i].setNxtPortCd                (inbound.getNXTPORTCD()               );
//				vskDepRptVOs[i].setNxtPortEtaDt             (inbound.getNXTPORTETADT()            );
//				vskDepRptVOs[i].setRmnDist                  (inbound.getRMNDIST()                 );
//				vskDepRptVOs[i].setRmnAvgSpd                (inbound.getRMNAVGSPD()               );
//				vskDepRptVOs[i].setArrFwddrHgt              (inbound.getARRFWDDRHGT()             );
//				vskDepRptVOs[i].setArrMidDrftHgt            (inbound.getARRMIDDRFTHGT()           );
//				vskDepRptVOs[i].setArrAftdrHgt              (inbound.getARRAFTDRHGT()             );
//				vskDepRptVOs[i].setArrGmHgt                 (inbound.getARRGMHGT()                );
//				vskDepRptVOs[i].setArrFoilWgt               (inbound.getARRFOILWGT()              );
//				vskDepRptVOs[i].setArrDoilWgt               (inbound.getARRDOILWGT()              );
//				vskDepRptVOs[i].setArrFrshWtrWgt            (inbound.getARRFRSHWTRWGT()           );
//				vskDepRptVOs[i].setArrBlstWgt               (inbound.getARRBLSTWGT()              );
//				vskDepRptVOs[i].setArrLowSulpFoilWgt        (inbound.getARRLOWSULPFOILWGT()       );
//				vskDepRptVOs[i].setArrLowSulpDoilWgt        (inbound.getARRLOWSULPDOILWGT()       );
//				vskDepRptVOs[i].setDepFwddrHgt              (inbound.getDEPFWDDRHGT()             );
//				vskDepRptVOs[i].setDepMidDrftHgt            (inbound.getDEPMIDDRFTHGT()           );
//				vskDepRptVOs[i].setDepAftdrHgt              (inbound.getDEPAFTDRHGT()             );
//				vskDepRptVOs[i].setDepGmHgt                 (inbound.getDEPGMHGT()                );
//				vskDepRptVOs[i].setDepFoilWgt               (inbound.getDEPFOILWGT()              );
//				vskDepRptVOs[i].setDepDoilWgt               (inbound.getDEPDOILWGT()              );
//				vskDepRptVOs[i].setDepFrshWtrWgt            (inbound.getDEPFRSHWTRWGT()           );
//				vskDepRptVOs[i].setDepBlstWgt               (inbound.getDEPBLSTWGT()              );
//				vskDepRptVOs[i].setDepLowSulpFoilWgt        (inbound.getDEPLOWSULPFOILWGT()       );
//				vskDepRptVOs[i].setDepLowSulpDoilWgt        (inbound.getDEPLOWSULPDOILWGT()       );
//				vskDepRptVOs[i].setSplFoilWgt               (inbound.getSPLFOILWGT()              );
//				vskDepRptVOs[i].setSplDoilWgt               (inbound.getSPLDOILWGT()              );
//				vskDepRptVOs[i].setSplFrshWtrWgt            (inbound.getSPLFRSHWTRWGT()           );
//				vskDepRptVOs[i].setSplLowSulpFoilWgt        (inbound.getSPLLOWSULPFOILWGT()       );
//				vskDepRptVOs[i].setSplLowSulpDoilWgt        (inbound.getSPLLOWSULPDOILWGT()       );
//				vskDepRptVOs[i].setNvgtDist                 (inbound.getNVGTDIST()                );
//				vskDepRptVOs[i].setEngMlDist                (inbound.getENGMLDIST()               );
//				vskDepRptVOs[i].setAvgSpd                   (inbound.getAVGSPD()                  );
//				vskDepRptVOs[i].setAvgRpmPwr                (inbound.getAVGRPMPWR()               );
//				vskDepRptVOs[i].setActArrDt                 (inbound.getACTARRDT()                );
//				vskDepRptVOs[i].setPltLstUnldDt             (inbound.getPLTLSTUNLDDT()            );
//				vskDepRptVOs[i].setActBrthDt                (inbound.getACTBRTHDT()               );
//				vskDepRptVOs[i].setCrnWrkCmncDt             (inbound.getCRNWRKCMNCDT()            );
//				vskDepRptVOs[i].setCrnWrkCmplDt             (inbound.getCRNWRKCMPLDT()            );
//				vskDepRptVOs[i].setActDepDt                 (inbound.getACTDEPDT()                );
//				vskDepRptVOs[i].setMnvrInMlDist             (inbound.getMNVRINMLDIST()            );
//				vskDepRptVOs[i].setMnvrOutMlDist            (inbound.getMNVROUTMLDIST()           );
//				vskDepRptVOs[i].setBfrBrthAnkDrpDt          (inbound.getBFRBRTHANKDRPDT()         );
//				vskDepRptVOs[i].setBfrBrthAnkOffDt          (inbound.getBFRBRTHANKOFFDT()         );
//				vskDepRptVOs[i].setAftUnbrthAnkDrpDt        (inbound.getAFTUNBRTHANKDRPDT()       );
//				vskDepRptVOs[i].setAftUnbrthAnkOffDt        (inbound.getAFTUNBRTHANKOFFDT()       );
//				vskDepRptVOs[i].setSeaMnFuelCsmWgt          (inbound.getSEAMNFUELCSMWGT()         );
//				vskDepRptVOs[i].setSeaGnrFuelCsmWgt         (inbound.getSEAGNRFUELCSMWGT()        );
//				vskDepRptVOs[i].setSeaBlrFuelCsmWgt         (inbound.getSEABLRFUELCSMWGT()        );
//				vskDepRptVOs[i].setSeaMnDzlCsmWgt           (inbound.getSEAMNDZLCSMWGT()          );
//				vskDepRptVOs[i].setSeaGnrDzlCsmWgt          (inbound.getSEAGNRDZLCSMWGT()         );
//				vskDepRptVOs[i].setSeaBlrDzlCsmWgt          (inbound.getSEABLRDZLCSMWGT()         );
//				vskDepRptVOs[i].setPortMnFuelCsmWgt         (inbound.getPORTMNFUELCSMWGT()        );
//				vskDepRptVOs[i].setPortGnrFuelCsmWgt        (inbound.getPORTGNRFUELCSMWGT()       );
//				vskDepRptVOs[i].setPortBlrFuelCsmWgt        (inbound.getPORTBLRFUELCSMWGT()       );
//				vskDepRptVOs[i].setPortMnDzlCsmWgt          (inbound.getPORTMNDZLCSMWGT()         );
//				vskDepRptVOs[i].setPortGnrDzlCsmWgt         (inbound.getPORTGNRDZLCSMWGT()        );
//				vskDepRptVOs[i].setPortBlrDzlCsmWgt         (inbound.getPORTBLRDZLCSMWGT()        );
//				vskDepRptVOs[i].setSeaMnLowSulpFuelCsmWgt   (inbound.getSEAMNLOWSULPFUELCSMWGT()  );
//				vskDepRptVOs[i].setSeaGnrLowSulpFuelCsmWgt  (inbound.getSEAGNRLOWSULPFUELCSMWGT() );
//				vskDepRptVOs[i].setSeaBlrLowSulpFuelCsmWgt  (inbound.getSEABLRLOWSULPFUELCSMWGT() );
//				vskDepRptVOs[i].setSeaMnLowSulpDzlCsmWgt    (inbound.getSEAMNLOWSULPDZLCSMWGT()   );
//				vskDepRptVOs[i].setSeaGnrLowSulpDzlCsmWgt   (inbound.getSEAGNRLOWSULPDZLCSMWGT()  );
//				vskDepRptVOs[i].setSeaBlrLowSulpDzlCsmWgt   (inbound.getSEABLRLOWSULPDZLCSMWGT()  );
//				vskDepRptVOs[i].setPortMnLowSulpFuelCsmWgt  (inbound.getPORTMNLOWSULPFUELCSMWGT() );
//				vskDepRptVOs[i].setPortGnrLowSulpFuelCsmWgt (inbound.getPORTGNRLOWSULPFUELCSMWGT());
//				vskDepRptVOs[i].setPortBlrLowSulpFuelCsmWgt (inbound.getPORTBLRLOWSULPFUELCSMWGT());
//				vskDepRptVOs[i].setPortMnLowSulpDzlCsmWgt   (inbound.getPORTMNLOWSULPDZLCSMWGT()  );
//				vskDepRptVOs[i].setPortGnrLowSulpDzlCsmWgt  (inbound.getPORTGNRLOWSULPDZLCSMWGT() );
//				vskDepRptVOs[i].setPortBlrLowSulpDzlCsmWgt  (inbound.getPORTBLRLOWSULPDZLCSMWGT() );
//				vskDepRptVOs[i].setTtlSlgWgt                (inbound.getTTLSLGWGT ()              );
//				vskDepRptVOs[i].setCreUsrId                 ("ESD062-0001"			              );
//				vskDepRptVOs[i].setCreDt                    (inbound.getCREDT()                   );
//				vskDepRptVOs[i].setUpdUsrId                 (inbound.getCUDFLG()	              );	//Delete Flag		
//				vskDepRptVOs[i].setUpdDt                    (inbound.getUPDDT()                   );
//				log.debug("****** " + vskDepRptVOs[i].getSkdVoyNo());
//			}
//			
//			((VopVskESD0620001Event)event).setVskDepRptVOs(vskDepRptVOs);
//			schedulePlanningOperationSC.perform(event);
//			
//			eai.commit(doc.getESD0620001().getEAIHeader().getInstanceId());
//			
//			log.debug("\n<<<<<<<<<< ESD0610001 JMS End >>>>>>>>>>>>>>>>\n");	
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
//	}
//	
//	/**
//	 * JMS Receive(ESD061-0001) WND_DIR_CTNT,WND_SCL_NOJMS br>
//	 * 
//	 * @param String windInfo
//	 * @return String[]
//	 */
//	public String[] splitWindInfo(String windInfo) {
//		String[] arrWindInfo = new String[2];
//		String pattern = "([a-zA-Z]+)([0-9]+)";	//WND_DIR_CTNT:WND_SCL_NO, OCN_CRNT_CTNT:SEA_STE_NO	
//		Pattern p = Pattern.compile(pattern); 
//		Matcher m = p.matcher(windInfo); 
//
//		while(m.find()) { 
//			arrWindInfo[0] = m.group(1);
//			arrWindInfo[1] = m.group(2);
//		} 
//
//		return arrWindInfo;
//	}
//	
//	/**
//	 * JMS Receive(EDI011-0001)<br>
//	 * 
//	 * @param TransferEAI eai
//	 * @exception EventException
//	 */
//	public void esdSettingReceiveJMS(TransferEAI eai) throws EventException {
//		
//		log.debug("\n<<<<<<<<<< EDI0110001 JMS Start >>>>>>>>>>>>>>>>\n");	
//		
//		String str = eai.getMessage();
//		//log.debug("\n======================================\n");
//		//log.debug("xml : " + str);
//		//log.debug("\n======================================\n");
//		
//		Event event = null;
//		SchedulePlanningOperationSC sc = new SchedulePlanningOperationSC();
//		
//		try {
//			event = new SchedulePlanningOperationEvent();
//			
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.MULTI);
//			event.setFormCommand(f);
//			
//			EDI0110001Document  doc = EDI0110001Document .Factory.parse(str);
//			EDI0110001 esd0110001 = doc.getEDI0110001();
//			EDI0110001.DataArea data = esd0110001.getDataArea();
//			EDI0110001.DataArea.EEDISETUPCollection col = data.getEEDISETUPCollection();
//			
//			VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs = new VskCustSkdEdiSetVO[col.sizeOfEEDISETUPArray()];
//			
//			for(int i=0; i<col.sizeOfEEDISETUPArray(); i++){
//				EDI0110001.DataArea.EEDISETUPCollection.EEDISETUP inbound = col.getEEDISETUPArray(i);
//				
//				vskCustSkdEdiSetVOs[i] = new VskCustSkdEdiSetVO();
//				vskCustSkdEdiSetVOs[i].setEdiMsgNm          (inbound.getEDIMSGNM     ()           );  //PK
//				vskCustSkdEdiSetVOs[i].setCustTrdPrnrId     (inbound.getCUSTTRDPRNRID()           );  //PK
//				vskCustSkdEdiSetVOs[i].setEdiStupId         (inbound.getEDISTUPID    ()           );
//				vskCustSkdEdiSetVOs[i].setEdiSndrId         (inbound.getEDISNDRID    ()           );
//				vskCustSkdEdiSetVOs[i].setEdiSvcTpNm        (inbound.getEDISVCTPNM   ()           );
//				vskCustSkdEdiSetVOs[i].setWrkRsrcNm         (inbound.getWRKRSRCNM    ()           );
//				vskCustSkdEdiSetVOs[i].setSndFmDys          (inbound.getSNDFMDYS     ()    		  );
//				vskCustSkdEdiSetVOs[i].setSndToDys          (inbound.getSNDTODYS     ()           );
//				vskCustSkdEdiSetVOs[i].setPreDmySkdFlg      (inbound.getPREDMYSKDFLG ()           );
//				vskCustSkdEdiSetVOs[i].setPstDmySkdFlg      (inbound.getPSTDMYSKDFLG ()           );
//				vskCustSkdEdiSetVOs[i].setUseFlg	        (inbound.getEAISTS		 ()           );
//				vskCustSkdEdiSetVOs[i].setEaiEvntDt	        (inbound.getEAIDT 		 ()           );
//				
//				vskCustSkdEdiSetVOs[i].setCreDt	            (inbound.getCREDT 		 ()           );
//				vskCustSkdEdiSetVOs[i].setUpdDt	        	(inbound.getUPDDT		 ()           );
//				vskCustSkdEdiSetVOs[i].setCreUsrId			(inbound.getCREUSRID	 ()			  );	//"EDI011-0001"
//				vskCustSkdEdiSetVOs[i].setUpdUsrId			(inbound.getUPDUSRID	 ()			  );	//"EDI011-0001"
//				//log.debug("****** " + vskCustSkdEdiSetVOs[i].getCustTrdPrnrId());
//			}
//			
//			((SchedulePlanningOperationEvent)event).setVskCustSkdEdiSetVOs(vskCustSkdEdiSetVOs);
//			sc.perform(event);
//			
//			eai.commit(doc.getEDI0110001().getEAIHeader().getInstanceId());
//			
//			log.debug("\n<<<<<<<<<< EDI0110001 JMS End >>>>>>>>>>>>>>>>\n");	
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
//	}
}
