/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAgreementBC.java
*@FileTitle : AGNCommAgreementBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.20 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentMinimumCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.CodeDescVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.GrpAgentVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/**
 * ALPS-ACMAgreement Business Logic Command Interface<br>
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0001EventResponse 참조
 * @since J2EE 1.6
 */
 
public interface AGNCommAgreementBC {

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0001-03 / ESM_ACM_0101]
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception EventException
	 */
	public List<AgentRateMasterVO> searchAgentRateMaster(AgentRateMasterVO agentRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0001-01]
	 * [Master]탭 목록을 저장<br>
	 *
	 * @param AgentRateMasterVO[] agentRateMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgentRateMaster(AgentRateMasterVO[] agentRateMasterVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0001-02 / ESM_ACM_0001-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateDetailVO>
	 * @exception EventException
	 */
	public List<AgentRateDetailVO> searchAgentRateDetail(AgentRateMasterVO agentRateMasterVO) throws EventException;
	
	/**
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master의 한 Row 에 해당하는 Minimum Commission 목록을 조회<br>
	 *
	 * @param AgentMinimumCommissionVO agentMinimumCommissionVO
	 * @return List<AgentMinimumCommissionVO>
	 * @exception EventException
	 */
	public List<AgentMinimumCommissionVO> searchAgentRateMinComm(AgentMinimumCommissionVO agentMinimumCommissionVO) throws EventException;
	

	/**
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master 목록을 저장<br>
	 *
	 * @param AgentRateDetailVO[] agentRateDetailVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAgentRateDetail(AgentRateDetailVO[] agentRateDetailVOs, AgentMinimumCommissionVO[] agentMinimumCommissionVOs,SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0101]
	 * New Agreement No. 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception EventException
	 */
	public List<AgentRateMasterVO> getNewAgreementNo(AgentRateMasterVO agentRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0101]
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @exception EventException
	 */
	public void getAgreementNoInfo(AgentRateMasterVO agentRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Master와 Detail, TP/SZ, Route, Charge 목록을 New Ageement No.로 저장<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgmtCopy(AgentRateMasterVO agentRateMasterVO, SignOnUserAccount account) throws EventException;
	/**
	 * [ESM_ACM_0001]
	 * 선택된 Agreement No.가 존재 하는지 확인<br>
	 *
	 * @param String agmt_no
	 * @return String
	 * @exception EventException
	 */
	public String searchAcmAgmtNoData(String agmt_no) throws EventException;
	
	/**
	 * [ESM_ACM_0009]
	 * GW에 EAI전송하기위한 ACM 계약서 정보 가져오기@@<br>
	 * @param AGNCommApprovalMasterVO
	 * @return AgentRateMasterVO
	 * @exception DAOException
	 */
	public List<AgentRateMasterVO> getAgmtDocInfo(AGNCommApprovalMasterVO agnCommApprovalMasterVO) throws EventException ;
	
	/**
	 * [ESM_ACM_0009]
	 * GW에 EAI전송하기위한 스키마데이타만들기@@<br>
	 * @param String csrNo
	 * @return GrpAgentVO
	 * @exception DAOException
	 */
	public GrpAgentVO manageAgentApplication(String csrNo) throws EventException ;
	
    /**
	 * CSR I/F 화면서 호출<br>
	 * @param String csrNo
     * @return List<ComCsrRequestAgmtVO>
     * @throws DAOException
     */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException;
	
	/**
	 * Charge Code 목록을 조회<br>
	 *
	 * @param CodeDescVO codeDescVO
	 * @return List<CodeDescVO>
	 * @exception EventException
	 */
	public List<CodeDescVO> searchChargeCode(CodeDescVO codeDescVO) throws EventException;
	
	/**
	 * Surcharge count 조회<br>
	 *
	 * @param String chgCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSurchargeCnt(String chgCd) throws EventException;
}