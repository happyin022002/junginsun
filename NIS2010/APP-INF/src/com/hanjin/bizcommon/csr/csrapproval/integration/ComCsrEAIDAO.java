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
package com.hanjin.bizcommon.csr.csrapproval.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.com.COM0060001Document;
import com.hanjin.irep.com.COM0060001Document.COM0060001;
import com.hanjin.irep.com.COM0060001Document.COM0060001.DataArea.CSRInfo;
import com.hanjin.irep.com.COM0060001Document.COM0060001.DataArea.CSRInfoResponse;
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

public class ComCsrEAIDAO extends EAIDAOSupport {
private transient Logger log = Logger.getLogger(ComCsrEAIDAO.class.getName());
	
	/**
	 * Settlement 기안정보를 EAI서버로 전송후 groupware 주소 OPEN.<br>
	 * 
	 * @param ComCsrInfoVO vo
	 * @return String GW URL
	 * @throws DAOException
	 */
	public String sendGWData(ComCsrInfoVO vo) throws DAOException {
		
		if (vo == null){
			return null;
		}
		
		//Request Start
		String target = SubSystemConfigFactory.get("CSR.COM0060001.WSDL");
		TransferEAI transferEAI = new AxDocClient(target, this.getClass());
		
		try {			
			this.log.info("@@WSDL Address -->["+target+"]");
			// 1. Send doc 생성
	    	COM0060001Document document = COM0060001Document.Factory.newInstance();
	    	COM0060001 com006001 = document.addNewCOM0060001();    	
	    	
			// ----------------------------------------------------------------------
			//(500자까지 가능) - 'COM006-' + 날짜(yyMMddHHmmss) + '-ALPSCSR-' + CSR_NO
			// ----------------------------------------------------------------------
			
	    	// 해더 작성
	    	com.hanjin.irep.com.EAIHeaderType headerType = com006001.addNewEAIHeader();
	    	String instanceId = "COM006-" + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date()) + "-ALPSCSR-" + vo.getCsrNo();
	    	headerType.setInstanceId(instanceId);
	
	    	COM0060001Document.COM0060001.DataArea dataArea = com006001.addNewDataArea();
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
	    	COM0060001Document outDoc = COM0060001Document.Factory.parse(responseXml);
	    	COM0060001 out = outDoc.getCOM0060001();    	
	    	COM0060001Document.COM0060001.DataArea outDataArea = out.getDataArea();
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
