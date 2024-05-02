/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ArApprovalBC.java
 *@FileTitle : Common CSR Business Logic Command Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12
 *@LastModifier : JungHo Min
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
 * =========================================================
 */
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.basic;
		       
import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Common CSR Business Logic Command Interface<br>
 * - Common CSR에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JungHo Min
 * @see 
 * @since J2EE 1.4
 */

public interface ArApprovalBC {
	
	/**
	 * Settlement GW 정보 eai 전송<br>
	 * 
	 * @param csrNo String
	 * @param invSubSysCd String
	 * @param account SignOnUserAccount
	 * @return String  
	 * @throws EventException
	 */
	public String sendGwApprovalRequestInfo(String csrNo , String invSubSysCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * CSR_No로 SUB_SYS_CD 를 조회한다. <br>
	 *
	 * @param csrNo String
	 * @return String
	 * @throws EventException
	 */
	public String searchSubSysCd(String csrNo) throws EventException;
	
	/**
	 * CSR_No로 OFC_CD 를 조회한다. <br>
	 *
	 * @param csrNo String
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCd(String csrNo) throws EventException;
	
	/**
	 * History table insert<br>
	 *
	 * @param comApCsrHisVO ComApCsrHisVO
	 * @throws EventException
	 */
	public void saveGWInfo(ComApCsrHisVO comApCsrHisVO) throws EventException;
	
	/**
	 * CSR_No로 RQST_APRO_STEP_FLG 상태를 조회한다. <br>
	 *
	 * @param csrNo String
	 * @return String
	 * @throws EventException
	 */
	public String searchRqstAproStepFlg(String csrNo) throws EventException;
	
	/**
	 * 모듈별 Subject를 조회한다. <br>
	 *
	 * @param invSubSydCd String
	 * @return String
	 * @throws EventException
	 */
	public String searchSubject(String invSubSydCd) throws EventException;
	
	
	/**
	 * GW에서 결과 값 전송 <br>
	 * AP_INV_HDR 의 GW Result 값에 따라 날짜 및 계약서 존재여부 업데이트
	 * 
	 * @param comCsrInfoVO ComCsrInfoVO
	 * @throws EventException
	 */
	public void updateAproGwDt(ComCsrInfoVO comCsrInfoVO) throws EventException;
	
	
	/**
	 * AR_INV_HDR 의 RQST_APRO_STEP_FLG, 생성 날짜 업데이트
	 * 
	 * @param csr_no String
	 * @param ofc_cd String
	 * @throws EventException
	 */
	public void updateAproGwFlg(String csr_no, String ofc_cd) throws EventException;	
}
