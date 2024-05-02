/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMPlanningPerformanceJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-05-25
 *@LastModifier : choijungmi
 *@LastVersion : 1.0
 * 2009-06-19 
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.cps.gem.servicesio;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.clt.apps.opus.cps.gem.gemplanningperformance.GEMPlanningPerformanceSC;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0030001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0090001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0610001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpPerfVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.erp.FNS0030001Document;
import com.clt.irep.erp.FNS0090001Document;
import com.clt.irep.erp.FNS0610001Document;
import com.clt.irep.erp.FNS0030001Document.FNS0030001;
import com.clt.irep.erp.FNS0090001Document.FNS0090001;
import com.clt.irep.erp.FNS0090001Document.FNS0090001.DataArea;
import com.clt.irep.erp.FNS0090001Document.FNS0090001.DataArea.ROWSET;
import com.clt.irep.erp.FNS0090001Document.FNS0090001.DataArea.ROWSET.ROW;
import com.clt.irep.erp.FNS0610001Document.FNS0610001;
import com.jf.transfer.TransferEAI;

/**
 * It's GEMPlanningPerformanceJMSProxy.java
 * 
 * @author Hyunsu, Ryu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class GEMPlanningPerformanceJMSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	
	/**
	 * JMS Receive(FNS009-0001)<br>
	 * 
	 * @param TransferEAI eai
	 * @throws EventException 
	 * @exception EventException, XmlException, Exception
	 */
	public void fNS0090001ReceiveJMS(TransferEAI eai) throws DAOException, EventException {
		
		GEMPlanningPerformanceSC  planningPerformanceSC = new GEMPlanningPerformanceSC();
		
		String str = eai.getMessage();
		//log.debug("======================================");
		//log.debug("xml : " + str);
		//log.debug("======================================");
		
		Event event = null;
		
		try {
			event = new CpsGemFns0090001Event();			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			FNS0090001Document doc = FNS0090001Document.Factory.parse(str);
			FNS0090001 sync = doc.getFNS0090001();
			DataArea data = sync.getDataArea();
			ROWSET rowset = data.getROWSET();
			ROW[] row = rowset.getROWArray();

			GemSlpIfVO[] models = new GemSlpIfVO[row.length];

			for (int i=0; row!=null && i<row.length; i++) {
				String slpAmt = row[i].getAMOUNT()==null?"0":row[i].getAMOUNT()==""?"0":row[i].getAMOUNT();
				
				models[i] = new GemSlpIfVO();
				models[i].setSlpTjNo(row[i].getINVOICENUM());
				models[i].setSlpSeqNo(row[i].getDISTRIBUTIONLINENUMBER());
				models[i].setOfcCd(row[i].getUSSGLTRANSACTIONCODE());
				models[i].setAcctCd(row[i].getSEGMENT3());
				models[i].setSlpCtrCd(row[i].getSEGMENT2());
				models[i].setSlpCurrCd(row[i].getINVOICECURRENCYCODE());
				models[i].setSlpAmt(slpAmt);
				models[i].setSlpVndrCd(row[i].getSEGMENT1());
				models[i].setGlEffDt(row[i].getGLDATE().substring(0, 8));
				models[i].setSlpDesc(row[i].getDESCRIPTION());
				
				models[i].setSysCateNm("");
				models[i].setPrprUsrId("");
				models[i].setAproUsrId("");
				models[i].setSlpIfFlg("N");
				models[i].setCreUsrId("ERP");
				models[i].setUpdUsrId("ERP");
			}
			
			//((CpsGemFns0090001Event) event).setXmlObject(doc);
			((CpsGemFns0090001Event) event).setGemSlpIfVOs(models);		
			planningPerformanceSC.receiveFns0090001Slip(event);			
			eai.commit(doc.getFNS0090001().getEAIHeader().getInstanceId());						
		} catch (EventException ee) {			
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (XmlException ex) {			
			eai.rollback(ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e){			
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}
	
	/**
	 * JMS Receive(FNS003-0001)<br>
	 * 
	 * @param eai TransferEAI
	 * @throws EventException 
	 * @exception EventException, XmlException, Exception
	 */
	public static void fNS0030001ReceiveJMS(TransferEAI eai) throws DAOException, EventException {

		GEMPlanningPerformanceSC  planningPerformanceSC = new GEMPlanningPerformanceSC();
		
		String str = eai.getMessage();
		//log.debug("======================================");
		//log.debug("xml : " + str);
		//log.debug("======================================");
		
		Event event = null;
		
		try {
			event = new CpsGemFns0030001Event();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			FNS0030001Document doc = FNS0030001Document.Factory.parse(str);
			FNS0030001 sync = doc.getFNS0030001();
			com.clt.irep.erp.FNS0030001Document.FNS0030001.DataArea data = sync.getDataArea();
			com.clt.irep.erp.FNS0030001Document.FNS0030001.DataArea.ROWSET rowset = data.getROWSET();
			com.clt.irep.erp.FNS0030001Document.FNS0030001.DataArea.ROWSET.ROW[] row = rowset.getROWArray();
			
			GemSlpIfVO[] models = new GemSlpIfVO[row.length];

			for (int i=0; row!=null && i<row.length; i++) {
				String slpTjNo = row[i].getTRANSNO().substring(0, 2);
				String slpAmt = row[i].getSLIPAMT()==null?"0":row[i].getSLIPAMT()==""?"0":row[i].getSLIPAMT();
				String trCd = row[i].getTRCD();
				
				if ( trCd != null && (trCd.equals("60") || trCd.equals("61"))) {
						
					slpAmt = String.valueOf(Double.parseDouble(slpAmt) * -1 );
					
				}
												
				models[i] = new GemSlpIfVO();
				models[i].setSlpTjNo(row[i].getTRANSNO());
				models[i].setSlpSeqNo("0001");
				models[i].setSysCateNm(row[i].getSYSCATEGORY());
				models[i].setGlEffDt(row[i].getGLDT());
				models[i].setAcctCd(row[i].getACCT());
				models[i].setSlpCurrCd(row[i].getSLIPCURR());
				models[i].setSlpAmt(slpAmt);
				models[i].setSlpCtrCd(row[i].getSLIPCTR());
				models[i].setSlpDesc(row[i].getSLIPDESC());
				models[i].setOfcCd(row[i].getOFCCD());
				models[i].setSlpVndrCd(row[i].getCSTCD());
				
				models[i].setPrprUsrId("");
				models[i].setAproUsrId("");
				models[i].setCreUsrId("ERP");
				models[i].setUpdUsrId("ERP");
				
				if("00".equals(slpTjNo)) {
					if("0".equals(slpAmt)) models[i].setSlpIfFlg("X");
					else models[i].setSlpIfFlg("N");
				} else {
					models[i].setSlpIfFlg("X");
				}
			}
			
			//((CpsGemFns0030001Event) event).setXmlObject(doc);
			((CpsGemFns0030001Event) event).setGemSlpIfVOs(models);
			planningPerformanceSC.receiveFns0030001Slip(event);
			
			eai.commit(doc.getFNS0030001().getEAIHeader().getInstanceId());
			
			
		} catch (EventException ee) {			
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (XmlException ex) {			
			eai.rollback(ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e){			
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}
	
	/**
	 * JMS Receive(FNS061-0001)<br>
	 * 
	 * @param eai TransferEAI
	 * @throws EventException 
	 * @exception EventException, XmlException, Exception
	 */
	public void fNS0610001ReceiveJMS(TransferEAI eai) throws DAOException, EventException {

		log.debug("<<<<<<<<<< fNS0610001ReceiveJMS Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		//log.debug("======================================");
		//log.debug("xml : " + str);
		//log.debug("======================================");
		
		Event event = null;
		GEMPlanningPerformanceSC planningPerformanceSC = new GEMPlanningPerformanceSC();
		
		try {
			event = new CpsGemFns0610001Event();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			FNS0610001Document doc = FNS0610001Document.Factory.parse(str);
			FNS0610001 sync = doc.getFNS0610001();
			com.clt.irep.erp.FNS0610001Document.FNS0610001.DataArea data = sync.getDataArea();
			com.clt.irep.erp.FNS0610001Document.FNS0610001.DataArea.ROWSET rowset = data.getROWSET();
			com.clt.irep.erp.FNS0610001Document.FNS0610001.DataArea.ROWSET.ROW[] row = rowset.getROWArray();
			
			GemSlpPerfVO[] models = new GemSlpPerfVO[row.length];
			for (int i=0; row!=null && i<row.length; i++) {
				
				models[i] = new GemSlpPerfVO();
				models[i].setSlpTjNo(row[i].getSLPTJNO());
				models[i].setPrprUsrId(row[i].getPRPRUSRID());
				models[i].setAproUsrId(row[i].getAPROUSRID());
				
				models[i].setUpdUsrId("ERP");
			}
			
			//((CpsGemFns0610001Event) event).setXmlObject(doc);
			((CpsGemFns0610001Event) event).setGemSlpPerfVOs(models);
			planningPerformanceSC.perform(event);
			
			eai.commit(doc.getFNS0610001().getEAIHeader().getInstanceId());
			log.debug("<<<<<<<<<< fNS0610001ReceiveJMS End >>>>>>>>>>>>>>>>");
			
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
		}
		eai.close();
	}
}
