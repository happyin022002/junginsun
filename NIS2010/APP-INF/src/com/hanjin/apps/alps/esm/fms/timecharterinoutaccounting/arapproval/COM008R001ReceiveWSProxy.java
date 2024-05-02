package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.TimeCharterInOutAccountingSC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0088Event;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alpsws.COM008R001Document;
import com.hanjin.irep.alpsws.COM008R001Document.COM008R001;
import com.hanjin.irep.alpsws.COM008R001Document.COM008R001.DataArea;
import com.hanjin.irep.alpsws.COM008R001Document.COM008R001.DataArea.CSRInfoResponse;
import com.hanjin.irep.alpsws.COM008R001Document.COM008R001.DataArea.CSRInfoReturn;

/**
 * COM008R001ReceiveWSProxy.java
 * @author JungHo Min
 * @see 
 * @since J2SE 1.6
 * 2014. 10. 20.
 */

@WebService(name="COM008R001ReceiveWSProxyPortType", serviceName="COM008R001ReceiveWSProxy",
targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/COM008R001ReceiveWSProxy",
     portName="COM008R001ReceiveWSProxyPort")

public class COM008R001ReceiveWSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());
		
	/**
	 * WS Receive(COM006_R001)<br>
	 * 
	 * @param COM008R001Document com008R001Document
	 * @return 
	 * @throws EventException 
	 * @exception EventException, XmlException, Exception
	 */
	@WebMethod()
	public String com008R001ReceiveWS(COM008R001Document com008R001Document) throws DAOException, EventException {
		
		TimeCharterInOutAccountingSC sc = new TimeCharterInOutAccountingSC();
		
		//WebService EAI Result
		String EAIResult = "Failure";
		
		// ========= Validation Parameters for WebServices ========= 
		if( com008R001Document == null || "".equals(com008R001Document) )
		{
			throw new EventException("Parameter is not valided !");
		}
		// ========= Validation Parameters for WebServices ========= 
		
		// EAI에서 제공된 XSD파일을 Reading
		COM008R001 com008R001doc = com008R001Document.getCOM008R001();
		log.error(":::::>>> com008R001Document : " + com008R001Document);
					
		DataArea data = com008R001doc.getDataArea();		
		CSRInfoReturn[] vos =  data.getCSRInfoReturnArray();
		CSRInfoResponse csrResponse = data.addNewCSRInfoResponse();
		
		try {		
			
			EsmFms0088Event event = new EsmFms0088Event();	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.COMMAND03);
			event.setFormCommand(f);
			
			if (vos != null && vos.length > 0) {				
				ComCsrInfoVO vo = new ComCsrInfoVO();
				
				CSRInfoReturn param = data.getCSRInfoReturnArray(0);
				// ---------------------------------------------
				// 승인여부 
				// --------------------------------------------
				// C (CANCLE)    : 창닫기
				// N (REJECT)    : disapprove
				// Y (COMPLETE)  : 최종결재 완료.
				// P (PANDING)   : 기안완료
				// --------------------------------------------
				String result = param.getRESULT();				
				// request id
				String requestId = param.getREQUESTID();			
				// 승인 코멘트
				String resultMsg = param.getRESULTMSG();
				// 승인자 아이디
				String userId = param.getATTRIBUTE1();
				//승인자 직책
				String aproUsrJbTitNm = param.getATTRIBUTE2();
				//승인자 이름
				String aproUsrNm = param.getATTRIBUTE3();			
				//csr_no
				//CSR NO : 05SPENBS14101500001
				String[] arrCsrNo = param.getATTRIBUTE6().split(":");
				String csrNo = arrCsrNo[1];
				
				//Agreement Flag
				String gwAgmtDocCfmCd = param.getATTRIBUTE15();
				
				log.error("===========================");
				log.error("result : " + result);
				log.error("requestId : " + requestId);
				log.error("resultMsg : " + resultMsg);
				log.error("userId : " + userId);
				log.error("csrNo : " + csrNo);
				log.error("gwAgmtDocCfmCd : " + gwAgmtDocCfmCd);
				log.error("===========================");
				
				vo.setRequestId(requestId);
				vo.setResultMsg(resultMsg);
				vo.setUserId(userId);
				vo.setResult(result);
				vo.setAproUsrJbTitNm(aproUsrJbTitNm);
				vo.setAproUsrNm(aproUsrNm);
				vo.setCsrNo(csrNo);		
				vo.setGwAgmtDocCfmCd(gwAgmtDocCfmCd);
					
				//존재하지 않는 경우 EAI처리 실패
				if(( requestId == null || requestId.equals("") ) 
						|| ( result == null || result.equals("") )
						|| ( csrNo == null || csrNo.equals("") ) ) {
					throw new EventException("Invalid RQST DATE");
				} else {
					
					event.setComCsrInfoVO(vo);
					EventResponse eventResponse = sc.perform(event);
					
					if (eventResponse != null) {
						log.error("eventResponse : " + eventResponse.getUserMessage());
						if(eventResponse.getUserMessage() != null && !"".equals(eventResponse.getUserMessage())){
							EAIResult = "Success";
						}
					} else {
						log.debug("eventResponse is null.");
					}
					
					log.error("EAIResult : " + EAIResult);
					if(csrResponse != null) {
						csrResponse.setCSRInfoResult(EAIResult);
						data.setCSRInfoResponseArray(0, csrResponse);
						
					}
				}	
			}									
			
		}  catch (EventException ex){
			//에러내용을 GW에 전달
			if(csrResponse != null) {
				csrResponse.setCSRInfoResult(JSPUtil.getNull(ex.toString()));
				data.setCSRInfoResponseArray(0, csrResponse);
			}
			log.error(ex.getMessage(), ex);
			EAIResult = JSPUtil.getNull(ex.toString());
			
			throw new EventException(ex.getMessage());
		}
		
		return EAIResult;
	}
}