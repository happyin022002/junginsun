/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: VesselPassagePlanReceiveManagementJMSProxy.java
*@FileTitle 	: Receive the passage plan data from VMS
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.04.30
*@LastModifier 	: LIM YE-JI
*@LastVersion 	: 1.0
* 2014-04-30 
* 1.0 Initial Generation

==========================================================*/
package com.hanjin.apps.alps.vop.vsk.servicesio;
  
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.ExternalVesselInfoManagementSC;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.event.VesselPassagePlanReceiveQueueEvent;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo.PassagePlanDtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alps.VMS0080001Document;
import com.hanjin.irep.alps.VMS0080001Document.VMS0080001;
import com.jf.transfer.TransferEAI;
//import com.hanjin.irep.web.VMS0030001Document;

/**
 *  JMS 서버에서 String 메세지를 받아 VesselPassagePlanReceiveManagementJMSProxy 에 넘겨준다. Event 관리를 한다. [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 *
 * @author LIM YE-JI
 * @see VesselPassagePlanReceiveManagementJMSProxy
 * @since J2EE 1.6
 */

public class VesselPassagePlanReceiveManagementJMSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	

	/**
	 * JMS Receive(VMS008_0001)
	 * VMS에서 EAI를 이용하여 Passage Plan report 수신
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void receivePassagePlanFromVMS(TransferEAI eai) throws EventException {
	log.debug("\n<<<<<<<<<< VMS008_0001 JMS Start >>>>>>>>>>>>>>>>\n");	
		
		String str = eai.getMessage();
		log.debug("\n======================================\n");
		log.debug("xml : " + str);
		log.debug("\n======================================\n");
		
		Event event = null;
		ExternalVesselInfoManagementSC externalVesselInfoManagementSC = new ExternalVesselInfoManagementSC();
		
		try {
			event = new VesselPassagePlanReceiveQueueEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
			
			VMS0080001Document doc = VMS0080001Document.Factory.parse(str);
			VMS0080001 vms0080001 = doc.getVMS0080001();
			VMS0080001.DataArea dataArea = vms0080001.getDataArea();
			
			VMS0080001.DataArea.SailingPlanCollection col = dataArea.getSailingPlanCollection();
			
			String eaiIfId = vms0080001.getEAIHeader().getInstanceId();
			
			List<PassagePlanDtVO> passagePlanDtVOs	= new ArrayList<PassagePlanDtVO>();
			PassagePlanDtVO		  tmpVO		= new PassagePlanDtVO();
			
//			PassagePlanDtVO[] passagePlanDtVOs = new PassagePlanDtVO[col.sizeOfDepatureArray()];

			//for(int i=0; i<passagePlanDtVOs.size(); i++){
				
				//VMS0080001.DataArea.SailingPlanCollection.Depature data = tmpVOs.get(i);
				
				//tmpVO = passagePlanDtVOs.get(i);
				
				//passagePlanDtVOs = new PassagePlanDtVO();
//				tmpVO                (eaiIfId)                 ;
				tmpVO.setVslCd(col.getVSLCD());    
				tmpVO.setSkdVoyNo(col.getSKDVOYNO());
				tmpVO.setSkdDirCd(col.getSKDDIRCD());
				tmpVO.setPasgPlnDt(col.getPASGPLNDT());
				tmpVO.setDepPortCd(col.getDEPPORTCD());
				tmpVO.setArrPortCd(col.getARRPORTCD());
				
				tmpVO.setPasgPlnTitNm(col.getPASGPLNTITNM());
				tmpVO.setVslSlanCd(col.getVSLSLANCD());
				tmpVO.setPltStnDesc(col.getPLTSTNDESC());
				tmpVO.setAvgVslSpd(col.getAVGVSLSPD());
				tmpVO.setDepPlnDt(col.getDEPPLNDT());
				tmpVO.setArrPlnDt(col.getARRPLNDT());
				
				tmpVO.setArrDepPlcDiffHrs(col.getARRDEPPLCDIFFHRS());
				tmpVO.setVslAproDocNo(col.getVSLAPRODOCNO());
				tmpVO.setTtlMlgDist(col.getTTLMLGDIST());
				tmpVO.setPortToPortMlgDist(col.getPORTTOPORTMLGDIST());
				tmpVO.setSelfShpFlg(col.getSELFSHPFLG());
//				tmpVO.setCreUsrId("EAI_VMS008_0001");
//				tmpVO.setUpdUsrId("EAI_VMS008_0001");
				
				passagePlanDtVOs.add(tmpVO);
				
				log.debug("******passagePlanDtVO.getVslCd()********    " + tmpVO.getVslCd());
				log.debug("******passagePlanDtVO.getSkdVoyNo()******** " + tmpVO.getSkdVoyNo());
				log.debug("******passagePlanDtVO.getSkdDirCd()******** " + tmpVO.getSkdDirCd());
				log.debug("******passagePlanDtVO.getPasgPlnDt()********" + tmpVO.getPasgPlnDt());
				log.debug("******passagePlanDtVO.getDepPortCd()********" + tmpVO.getDepPortCd());
				log.debug("******passagePlanDtVO.getArrPortCd()********" + tmpVO.getArrPortCd());
				
				log.debug("******passagePlanDtVO.getPasgPlnTitNm()********" + tmpVO.getPasgPlnTitNm());
				log.debug("******passagePlanDtVO.getVslSlanCd()********   " + tmpVO.getVslSlanCd());
				log.debug("******passagePlanDtVO.getPltStnDesc()********  " + tmpVO.getPltStnDesc());
				log.debug("******passagePlanDtVO.getAvgVslSpd()********   " + tmpVO.getAvgVslSpd());
				log.debug("******passagePlanDtVO.getDepPlnDt()********    " + tmpVO.getDepPlnDt());
				log.debug("******passagePlanDtVO.getArrPlnDt()********" + tmpVO.getArrPlnDt());
				
				log.debug("******passagePlanDtVO.getArrDepPlcDiffHrs()********	" + tmpVO.getArrDepPlcDiffHrs());
				log.debug("******passagePlanDtVO.getVslAproDocNo()********		" + tmpVO.getVslAproDocNo());
				log.debug("******passagePlanDtVO.getTtlMlgDist()********		" + tmpVO.getTtlMlgDist());
				log.debug("******passagePlanDtVO.getPortToPortMlgDist()********	" + tmpVO.getPortToPortMlgDist());
				log.debug("******passagePlanDtVO.getSelfShpFlg()********		" + tmpVO.getSelfShpFlg());



			//}
			
			((VesselPassagePlanReceiveQueueEvent)event).setpassagePlanDtVO(tmpVO);
			log.debug("\n<<<<<<<<<< VMS008_0001 JMS End 1>>>>>>>>>>>>>>>>\n");
			externalVesselInfoManagementSC.perform(event);
			log.debug("\n<<<<<<<<<< VMS008_0001 JMS End 2>>>>>>>>>>>>>>>>\n");
		
			eai.commit(eaiIfId);
		
			log.debug("\n<<<<<<<<<< VMS008_0001 JMS End >>>>>>>>>>>>>>>>\n");	
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (XmlException ex) {
			log.error("XmlException ex : " + ex.toString(), ex);
			eai.rollback(ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally{
			eai.close();			
		}
		
	}
}



