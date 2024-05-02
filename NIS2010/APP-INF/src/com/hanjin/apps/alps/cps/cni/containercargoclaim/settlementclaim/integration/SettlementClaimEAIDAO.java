/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClaimMainEAIDAO.java
*@FileTitle : CRM Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.04.01 진윤오
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.integration;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CMSServiceVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.GwCargoInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.com.COM0050001Document;
import com.hanjin.irep.com.COM0050001Document.COM0050001;
import com.hanjin.irep.com.COM0050001Document.COM0050001.DataArea.CargoClaimInfo;
import com.hanjin.irep.com.COM0050001Document.COM0050001.DataArea.CargoClaimInfoResponse;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;
import com.jf.transfer.ws.AxDocClient;

/**
 * SettlementClaimEAIDAO Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class SettlementClaimEAIDAO extends EAIDAOSupport {

	private transient Logger log = Logger.getLogger(SettlementClaimEAIDAO.class.getName());
	
	/**
	 * Settlement 기안정보를 EAI서버로 전송후 groupware 주소 OPEN.<br>
	 * 
	 * @param GwCargoInfoVO vo
	 * @return String GW URL
	 * @throws DAOException
	 */
	public String sendGWData(GwCargoInfoVO vo) throws DAOException {
		
		if (vo == null){
			return null;
		}
		
		//Request Start
		String target = SubSystemConfigFactory.get("CNI.COM0050001.WSDL");
		TransferEAI transferEAI = new AxDocClient(target, this.getClass());
		
		try {			

			this.log.info("@@WSDL Address -->["+target+"]");
			// 1. Send doc 생성
	    	COM0050001Document document = COM0050001Document.Factory.newInstance();
	    	COM0050001 com005001 = document.addNewCOM0050001();    	
	    	// 해더 작성
	    	com.hanjin.irep.com.EAIHeaderType headerType = com005001.addNewEAIHeader();
	    	String curDt = DateTime.getFormatDate(new Date(), "yyyy-MM-dd:HH:mm:ss:SSS");
	    	String instanceId = "COM005_0001_" + curDt + "_" + vo.getCgoClmNo();
	    	headerType.setInstanceId(instanceId);
	
	    	COM0050001Document.COM0050001.DataArea dataArea = com005001.addNewDataArea();
	    	CargoClaimInfo info = dataArea.addNewCargoClaimInfo();
	    	
	    	info.setUSERID(vo.getUserId());
	    	info.setDOCID(vo.getDocId());
	    	info.setREQID(vo.getReqId());
	    	info.setXMLDATA(vo.getXmlData());
	    	info.setUSERTP(vo.getUserTp());
	    	info.setSYSTP(vo.getSysTp());
	
			//비동기호출
			this.log.info("Request Document -->[" + document.toString()+"]");
		
			transferEAI.setMessage(document.toString());
		
			// Response Xml
			String responseXml = transferEAI.commit(headerType.getInstanceId());
			
			// Response Xml
	    	COM0050001Document outDoc = COM0050001Document.Factory.parse(responseXml);
	    	COM0050001 out = outDoc.getCOM0050001();    	
	    	COM0050001Document.COM0050001.DataArea outDataArea = out.getDataArea();
	    	CargoClaimInfoResponse[] responses = outDataArea.getCargoClaimInfoResponseArray();
	
	    	if (responses == null || responses.length == 0) {
	    		return null;
	    	}
	    	
	    	return  responses[0].getCargoClaimInfoResult();
	    	
		} catch (EAIException ex) {
			transferEAI.rollback(ex);
			this.log.error(ex.getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (XmlException e) {
			transferEAI.rollback(e);
			this.log.error(e.getMessage());
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} finally {
			transferEAI.close();
		}
	}
}

