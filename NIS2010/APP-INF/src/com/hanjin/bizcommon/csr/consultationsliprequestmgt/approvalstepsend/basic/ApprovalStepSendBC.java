/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalStepSendBC.java
*@FileTitle : ERP A/P로 I/F된 CSR에 대한 Approval Step 정보 I/F 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-03-08 
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.basic;


import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

import com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.vo.ComComAproSndLogVO;
import com.hanjin.syscommon.common.table.ComAproSndMnRuleVO;
import com.hanjin.syscommon.common.table.ComCsrErrLogVO;


/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br> 
 *
 * @author 
 * @see ApprovalStepSendBCImpl 참조
 * @since J2EE 1.4
 */
public interface ApprovalStepSendBC  {
	
	static final String APROSTEP_ACT_TP_CD     	= "APROSTEP_ACT_TP_CD";
	static final String APROSTEP_ACT_TP_BATCH  	= "B";
	static final String APROSTEP_ACT_TP_ONLINE 	= "O";
	static final String APROSTEP_SND_RULE    	= "APROSTEP_SND_RULE";
	static final String APROSTEP_SND_LOG      	= "APROSTEP_SND_LOG";
	static final String APROSTEP_SND_CSR_LST    = "APROSTEP_SND_CSR_LST";
	static final String APROSTEP_DOCS			= "APROSTEP_DOCS";
	static final String APROSTEP_SND_VOS		= "APROSTEP_SND_VOS";
	static final String CSR_ERROR_TP_APROIF		= "I";
	static final String CSR_ERROR_TP_CSR		= "C";
	static final String CSR_ERROR_TP_APROSTEP	= "A";
	static final String CSR_ERROR_TP_REPLY		= "R";
	static final String CSR_ERROR_TP_PAYMENT	= "P";
	
	
	/**
	 * AproStep 대상 EDI invoice 대상 초기화
	 * @param eventResponse
	 * @throws EventException
	 */
	public void initAproStepSend(EventResponse eventResponse) throws EventException;

	/**
	 * AproStep 대상 EDI invoice 대상 추출 및 F/F 조합
	 * @param eventResponse
	 * @throws EventException
	 */
	public void makeAproStepDocReq(EventResponse eventResponse) throws EventException;
	
	/**
	 * AproStep 대상 EDI invoice 대상 전송
	 * @param eventResponse
	 * @throws EventException
	 */
	public void sendAproStep(EventResponse eventResponse) throws EventException;

	/**
	 * AproStep 전송 규칙 정보 조회
	 * @param ack_act_tp_cd
	 * @return List<TesEdiSndAckMnRuleVO>
	 * @throws EventException
	 */
	public List<ComAproSndMnRuleVO> getAproStepSendMainRule(String ack_act_tp_cd) throws EventException;
	
	/**
	 * AproStep Log관리 table에 Error 남기기
	 * @param aproSndLogVO
	 * @throws EventException
	 */
	public void logAproStepEAIErrMsg(ComComAproSndLogVO aproSndLogVO) throws EventException;
	
	/**
	 * 공통 Error table에 Error 남기기
	 * @param aproSndLogVO
	 * @throws EventException
	 */
	public void logAproCommErrMsg(ComCsrErrLogVO aproSndLogVO) throws EventException; 
	
	
}