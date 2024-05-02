/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ComCsrEAIDAO.java
 *@FileTitle : Com CSR Business Logic Command Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.08
 *@LastModifier : Young Shin Kim
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
 * =========================================================
 */
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.com.COM0100001Document;
import com.hanjin.irep.com.COM0100001Document.COM0100001;
import com.hanjin.irep.com.COM0100001Document.COM0100001.DataArea.CSRInfo;
import com.hanjin.irep.com.COM0100001Document.COM0100001.DataArea.CSRInfoResponse;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxDocClient;

/**
 * EAI에 대한 DB 처리를 담당<br>
 * - Common CSR Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Young Shin Kim
 * @see 
 * @since J2EE 1.4
 */

public class GEMConsultationSlipEAIDAO extends EAIDAOSupport {
private transient Logger log = Logger.getLogger(GEMConsultationSlipEAIDAO.class.getName());
	
	/**
	 * Settlement 기안정보를 EAI서버로 전송후 groupware 주소 OPEN.<br>
	 * 
	 * @param ComCsrInfoVO vo
	 * @return String GW URL
	 * @throws DAOException
	 */
	public String sendGWData(GemCsrInfoVO vo) throws DAOException {
		
		if (vo == null){
			return null;
		}
		
		//Request Start
		String target = SubSystemConfigFactory.get("CSR.COM0100001.WSDL");
		TransferEAI transferEAI = new AxDocClient(target, this.getClass());
		
		try {			
			this.log.info("@@WSDL Address -->["+target+"]");
			// 1. Send doc 생성
	    	COM0100001Document document = COM0100001Document.Factory.newInstance();
	    	COM0100001 com010001 = document.addNewCOM0100001();    	
	    	
			// ----------------------------------------------------------------------
			//(500자까지 가능) - 'COM006-' + 날짜(yyMMddHHmmss) + '-ALPSCSR-' + CSR_NO
			// ----------------------------------------------------------------------
			
	    	// 해더 작성
	    	com.hanjin.irep.com.EAIHeaderType headerType = com010001.addNewEAIHeader();
	    	String instanceId = "COM010-" + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date()) + "-ALPSGEM-" + vo.getCsrNo();
	    	headerType.setInstanceId(instanceId);
	
	    	COM0100001Document.COM0100001.DataArea dataArea = com010001.addNewDataArea();
	    	CSRInfo info = dataArea.addNewCSRInfo();
	    	
	    	info.setUSERID(vo.getUserId());
	    	info.setDOCID(vo.getSysDocId());
	    	info.setREQID(vo.getRequestId());
	    	info.setXMLDATA(vo.getXmlData());
	    	info.setUSERTP(vo.getUserTp());
	    	info.setSYSTP(vo.getSysTp());
	
			//비동기호출
			this.log.info("Request Document -->[" + document.toString()+"]");
		
			transferEAI.setMessage(document.toString());
		
			// Response Xml
			String responseXml = transferEAI.commit(headerType.getInstanceId());
			
			// Response Xml
	    	COM0100001Document outDoc = COM0100001Document.Factory.parse(responseXml);
	    	COM0100001 out = outDoc.getCOM0100001();    	
	    	COM0100001Document.COM0100001.DataArea outDataArea = out.getDataArea();
	    	CSRInfoResponse[] responses = (CSRInfoResponse[]) outDataArea.getCSRInfoResponseArray();
	
	    	if (responses == null || responses.length == 0) {
	    		return null;
	    	}
	    	
	    	return  responses[0].getCSRInfoResult();
	    	
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
