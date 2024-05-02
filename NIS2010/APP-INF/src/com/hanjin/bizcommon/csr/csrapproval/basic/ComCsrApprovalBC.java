/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ComCsrApprovalBC.java
 *@FileTitle : Common CSR Business Logic Command Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.08
 *@LastModifier : Young Shin Kim
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
 * 2014.12.18  I/F Data Update Method add
 * =========================================================
 */
package com.hanjin.bizcommon.csr.csrapproval.basic;

import java.util.List;
//import java.util.ArrayList;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;

/**
 * Common CSR Business Logic Command Interface<br>
 * - Common CSR에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Young Shin Kim
 * @see 
 * @since J2EE 1.4
 */
public interface ComCsrApprovalBC {
	
	/**
	 * Settlement GW 정보 eai 전송<br>
	 * 
	 * @param csrNo
	 * @param invSubSysCd
	 * @param account
	 * @return gwUrl 
	 * @throws EventException
	 */
	public String sendGwApprovalRequestInfo(String csrNo , String invSubSysCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * CSR_No로 SUB_SYS_CD 를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchSubSysCd(String csrNo) throws EventException;
	
	/**
	 * CSR_No로 OFC_CD 를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCd(String csrNo) throws EventException;
	
	/**
	 * History table insert<br>
	 *
	 * @param ComApCsrHisVO comApCsrHisVO
	 * @throws EventException
	 */
	public void saveGWInfo(ComApCsrHisVO comApCsrHisVO) throws EventException;
	
	/**
	 * CSR_No로 RQST_APRO_STEP_FLG 상태를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchRqstAproStepFlg(String csrNo) throws EventException;
	
	/**
	 * 모듈별 Subject를 조회한다. <br>
	 *
	 * @param String invSubSydCd
	 * @return String
	 * @throws EventException
	 */
	public String searchSubject(String invSubSydCd) throws EventException;
	
	/**
	 * I/F Flag의 상태를 조회한다. <br>
	 * COM_CSR_0015 <br>
	 * @author 2015513 심성윤 (2015.03.13)
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckIfFlg(String csrNo) throws EventException;
	
	/**
	 * GW 승인자 정보를 조회한다<br>
	 *
	 * @param String csrNo
	 * @return ComApCsrHisVO 
	 * @throws EventException
	 */
	public ComApCsrHisVO searchCsrHisInfo(String csrNo) throws EventException;
	
	/**
	 * AL 승인자 정보를 조회한다<br>
	 * COM_CSR_0015<br>
	 * @author 심성윤 (2015.03.12)
	 * @param String csrNo
	 * @return ComApCsrHisVO 
	 * @throws EventException
	 */
	public ComCsrInfoVO searchCsrApAproInfo(String csrNo) throws EventException;
	
	/**
	 * 기안이 완료 전 상태인지를 조회한다.<br>
	 * CHM-201535042
	 * @author 심성윤 (2015.03.31)
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckAproStepFlg(String csrNo) throws EventException;
	/**
	 * I/F DT update<br>
	 *
	 * @param String csrNo
	 * @throws EventException
	 */
	public void updateErpInterface(String csrNo) throws EventException;
	
	/**
	 * Batch로 ERP I/F할 대상 CSR 조회
	 * @return List<ComCsrInfoVO>
	 * @throws EventException
	 */
	public List<ComCsrInfoVO> searchBatchCsr() throws EventException;
	
	/**
	 * CSR단위로 ERP I/F 처리
	 * @param ComCsrInfoVO vo
	 * @throws EventException
	 */
	public void processErpInterface(ComCsrInfoVO vo) throws EventException;
}
