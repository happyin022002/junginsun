/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationBC.java
*@FileTitle : 공동운항추정 산출
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.04 함대성
* 1.0 Creation
* -------------------------------------------------------
* 2012.01.10 조병연[CHM-201215460-01]
* Title : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 :
* 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)

* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*   분석의 다각화 가능
* 2012.02.13 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차)
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발		
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooEstmClzVO;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;


/**
 * ALPS-Jointoperationagreementsettlement Business Logic Command Interface<br>
 * - ALPS-Jointoperationagreementsettlement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HAM DAE SUNG
 * @see Ui_joo_0030EventResponse 참조
 * @since J2EE 1.6
 */

public interface JointOperationAccrualCreationBC {
	/**
	 * 0030 조회 이벤트 처리<br>
	 * @param JooEstmClzVO jooEstmClzVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooEstmClzVO>
	 * @exception EventException
	 */
	public List<JooEstmClzVO> searchAccrualClosing(JooEstmClzVO jooEstmClzVO, SignOnUserAccount signOnUserAccount) throws EventException;
	/**
     * Accrual Closing 여부를 일괄 수정한다. <br>
	 * @param JooEstmClzVO[] jooEstmClzVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void modifyAccrualClosing(JooEstmClzVO[] jooEstmClzVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 
     * Estimate Report - Account을 조회합니다.<br>
	 *
	 * @param  ActRsltRVO actRsltRVO
	 * @throws EventException
	 * @return List<ActRsltRVO>
	 * @author jang kang cheol
	 */
	public List<ActRsltRVO> searchAccrualListByAccount(ActRsltRVO actRsltRVO) throws EventException;	

	/**
	 * 추정_MAS 용 ESTD Report - MAS 화면에 대한 조회 이벤트 처리<br>
	 * @param ActRsltRVO actRsltRVO
	 * @return List<ActRsltRVO>
	 * @exception EventException
	 */
	public List<ActRsltRVO> searchAccrualListByMAS(ActRsltRVO actRsltRVO) throws EventException;
 
    /**
     *  [Estimate Performance Creation]을 [조회] 합니다.<br>
     *      UID : FNS_JOO_0029<br>
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<EstmActRsltVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<EstmActRsltVO> searchJointOperationAccrualList(SettlementConditionVO settlementConditionVO) throws EventException;
    
    
    /**
     *  [Estimate Performance(ERP)]을 [조회] 합니다.<br>
     *      UID : FNS_JOO_0029<br>
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<EstmActRsltVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<EstmActRsltVO> searchJointOperationAccrualERP(SettlementConditionVO settlementConditionVO) throws EventException;    
    
    
    /**
     * 
     *  [Estimate Performance Creation]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0029<br>
     *
     * @param EstmActRsltVO[] estmActRsltVOs
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String 
     * @throws EventException
     */
    public String manageJointOperationAccrual( EstmActRsltVO[] estmActRsltVOs, SettlementConditionVO settlementConditionVO
                                            , SignOnUserAccount signOnUserAccount) throws EventException;    
    /**
     * 
     * [Estimate Performance Creation]을 [ERP로 전송]합니다.
     *
     * @param EstmActRsltVO[] estmActRsltVOs
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String sendJointOperationAccrualERP( EstmActRsltVO[] estmActRsltVOs,  SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException;    
    
    /**
     * [Estimate Code Check - Carrier]을 [조회Retrieve]합니다.<br>
     *
     * @param  String yearMm 
     * @return List<EstdCarVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<EstdCarVO> searchEstdCarCheckList(String yearMm ) throws EventException;
    
    /**
     * [Estimate Code Check - VVD]을 [조회Retrieve]합니다.<br>
     *
     * @param  EstdVvdVO estdVvdVO
     * @return List<EstdVvdVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<EstdVvdVO> searchEstdVvdCheckList(EstdVvdVO estdVvdVO ) throws EventException;    
 
    /**
     * Estimation Create
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String createJointOperationAccrual(SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException;
    
    
    /**
     * Estimation Create 대상 조회
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String calJointOperationAccrual(SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException;    
    

    /**
     * Estimation Create 대상 조회
     * @param SettlementConditionVO settlementConditionVO
     * @return List<EstmActRsltVO>
     * @throws EventException
     */
    public List<EstmActRsltVO> searchJointOperationAccrual(SettlementConditionVO settlementConditionVO) throws EventException;    
    
    /**
     * Estimate Performance Retrieve
     * @param EstmConditionVO estmConditionVO
     * @return List<EstmActRsltVO>
     * @throws EventException
     */
    public List<EstmActRsltVO> searchEstmPerformanceList(EstmConditionVO estmConditionVO) throws EventException;

    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException;

	/**
	 * Estimation Result의 Total금액 조회
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws EventException
	 */
    public EstmActRsltVO searchJointOperationAccrualTotal(SettlementConditionVO settlementConditionVO) throws EventException;
    
	/**
	 * Estimation Result(ERP)의 Total금액 조회
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws EventException
	 */
    public EstmActRsltVO searchJointOperationAccrualERPTotal(SettlementConditionVO settlementConditionVO) throws EventException;
    
    
    /**
     * Estimate Performance Change Status Retrieve
     * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
     * @return List<EstmPerformanceChangeStatusRsltVO>
     * @throws EventException
     */
    public List<EstmPerformanceChangeStatusRsltVO> searchEstmPerformanceChangeStatusList(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws EventException;

    /**
     * 
     *  Estimate Performance Change Status을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0088<br>
     *
     * @param EstmPerformanceChangeStatusRsltVO[] estmPerformanceChangeStatusRsltVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageEstmPerformanceChangeStatus( EstmPerformanceChangeStatusRsltVO[] estmPerformanceChangeStatusRsltVOs, SignOnUserAccount signOnUserAccount) throws EventException;    
    
    /**
     * Estimate Performance Change Status II Retrieve
     * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
     * @return List<EstmPerformanceChangeStatusIIRsltVO>
     * @throws EventException
     */
    public List<EstmPerformanceChangeStatusIIRsltVO> searchEstmPerformanceChangeStatusIIList(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws EventException;

    
    
    
}