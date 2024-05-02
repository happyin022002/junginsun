/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SchedulePlanningOperationJMSProxy.java
*@FileTitle : ENIS Interface 연동 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 진마리아
*@LastVersion : 1.1
* 2007-04-10 
* 1.0 최초 생성
* 2009.08.26 서창열
* 1.1 Creation (NIS2010 new F/W 전환작업)
* 
* History
* 2012.10.24 CHM-201220527-01 진마리아 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.servicesio;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.SchedulePlanningOperationSC;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.SchedulePlanningOperationEvent;
import com.hanjin.bizcommon.erpcom.ReceiveQueueRSC;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.edi.EDI0110001Document;
import com.hanjin.irep.edi.EDI0110001Document.EDI0110001;
import com.hanjin.syscommon.common.table.VskCustSkdEdiSetVO;
import com.jf.transfer.TransferEAI;

/**
 *  JMS 서버에서 String 메세지를 받아 SchedulePlanningOperationJMSProxy 에 넘겨준다. Event 관리를 한다. [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 *
 * @author 서창열
 * @see ReceiveQueueRSC
 * @since J2EE 1.4
 */
public class SchedulePlanningOperationJMSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * JMS Receive(EDI011-0001)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void esdSettingReceiveJMS(TransferEAI eai) throws EventException {
		
		log.debug("\n<<<<<<<<<< EDI0110001 JMS Start >>>>>>>>>>>>>>>>\n");	
		
		String str = eai.getMessage();
		//log.debug("\n======================================\n");
		//log.debug("xml : " + str);
		//log.debug("\n======================================\n");
		
		Event event = null;
		SchedulePlanningOperationSC sc = new SchedulePlanningOperationSC();
		
		try {
			event = new SchedulePlanningOperationEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			EDI0110001Document  doc = EDI0110001Document .Factory.parse(str);
			EDI0110001 esd0110001 = doc.getEDI0110001();
			EDI0110001.DataArea data = esd0110001.getDataArea();
			EDI0110001.DataArea.EEDISETUPCollection col = data.getEEDISETUPCollection();
			
			VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs = new VskCustSkdEdiSetVO[col.sizeOfEEDISETUPArray()];
			
			for(int i=0; i<col.sizeOfEEDISETUPArray(); i++){
				EDI0110001.DataArea.EEDISETUPCollection.EEDISETUP inbound = col.getEEDISETUPArray(i);
				
				vskCustSkdEdiSetVOs[i] = new VskCustSkdEdiSetVO();
				vskCustSkdEdiSetVOs[i].setEdiMsgNm          (inbound.getEDIMSGNM     ()           );  //PK
				vskCustSkdEdiSetVOs[i].setCustTrdPrnrId     (inbound.getCUSTTRDPRNRID()           );  //PK
				vskCustSkdEdiSetVOs[i].setEdiStupId         (inbound.getEDISTUPID    ()           );
				vskCustSkdEdiSetVOs[i].setEdiSndrId         (inbound.getEDISNDRID    ()           );
				vskCustSkdEdiSetVOs[i].setEdiSvcTpNm        (inbound.getEDISVCTPNM   ()           );
				vskCustSkdEdiSetVOs[i].setWrkRsrcNm         (inbound.getWRKRSRCNM    ()           );
				vskCustSkdEdiSetVOs[i].setSndFmDys          (inbound.getSNDFMDYS     ()    		  );
				vskCustSkdEdiSetVOs[i].setSndToDys          (inbound.getSNDTODYS     ()           );
				vskCustSkdEdiSetVOs[i].setPreDmySkdFlg      (inbound.getPREDMYSKDFLG ()           );
				vskCustSkdEdiSetVOs[i].setPstDmySkdFlg      (inbound.getPSTDMYSKDFLG ()           );
				vskCustSkdEdiSetVOs[i].setUseFlg	        (inbound.getEAISTS		 ()           );
				vskCustSkdEdiSetVOs[i].setEaiEvntDt	        (inbound.getEAIDT 		 ()           );
				
				vskCustSkdEdiSetVOs[i].setCreDt	            (inbound.getCREDT 		 ()           );
				vskCustSkdEdiSetVOs[i].setUpdDt	        	(inbound.getUPDDT		 ()           );
				vskCustSkdEdiSetVOs[i].setCreUsrId			(inbound.getCREUSRID	 ()			  );	//"EDI011-0001"
				vskCustSkdEdiSetVOs[i].setUpdUsrId			(inbound.getUPDUSRID	 ()			  );	//"EDI011-0001"
				//log.debug("****** " + vskCustSkdEdiSetVOs[i].getCustTrdPrnrId());
			}
			
			((SchedulePlanningOperationEvent)event).setVskCustSkdEdiSetVOs(vskCustSkdEdiSetVOs);
			sc.perform(event);
			
			eai.commit(doc.getEDI0110001().getEAIHeader().getInstanceId());
			
			log.debug("\n<<<<<<<<<< EDI0110001 JMS End >>>>>>>>>>>>>>>>\n");	
			
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
