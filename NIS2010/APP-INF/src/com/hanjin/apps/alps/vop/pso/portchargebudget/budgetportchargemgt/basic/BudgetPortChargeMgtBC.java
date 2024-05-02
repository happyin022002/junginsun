/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BudgetPortChargeMgtBC.java
*@FileTitle : Budget vs Actual
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.08 박명종
* 1.0 Creation
* 
* History
* 2010.10.27 진마리아 CHM-201006714-01 추정결산 로직 보완
* 2011.08.10 진마리아 CHM-201111882-01 [VOP-PSO] COA data I/F
* 2012.08.20 이혜민   CHM-201219078-01 사업계획 - 시나리오 연도 추가
* 2015.02.02  [CHM-201533847] PORT내 SKIP여부 처리
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstDtlCondVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstSumByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstExpnCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstTgtVvdByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ExpnDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.PortChgBudByYearVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoBudTgtVvdVO;
import com.hanjin.syscommon.common.table.PsoTgtYdExpnVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListMasVO;//mas용



/**
 * ALPS-Portchargebudget Business Logic Command Interface<br>
 * - ALPS-Portchargebudget에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author myoungjong park
 * @see Vop_pso_0025EventResponse 참조
 * @since J2EE 1.6
 */

public interface BudgetPortChargeMgtBC {
	/**
	 * Expense Plan Per VVD(Pop-Up) 조회 처리 
	 * @category VOP_PSO_0201_windowOpen
	 * @param EstExpnCreVO estExpnCreVO
	 * @return List<BudEstSumByMonVO>
	 * @throws EventException
	 */
	public List<EstExpnCreVO> searchEstTgtVvdByMon(EstExpnCreVO estExpnCreVO) throws EventException ;
	/**
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 조회한다.
	 * @category VOP_PSO_0013_RetrieveButtonClick
	 * @param ErpSumVO erpSumVO
	 * @return List<ErpSumVO>
	 * @throws EventException
	 */
	public List<ErpSumVO> searchErpSum(ErpSumVO erpSumVO) throws EventException ;
	/**
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 상세한 추정비용을 조회한다.
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 * @throws EventException
	 */
	public List<ErpDtlVO> searchErpDtl(ErpDtlVO erpDtlVO) throws EventException;
	/**
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 변경한다.
	 * @category VOP_PSO_0207_SaveButtonClick
	 * @param ErpDtlVO[] erpDtlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyErpDtl(ErpDtlVO[] erpDtlVOs, SignOnUserAccount account) throws EventException;
	/**
	 * 년도별 사업 계획을 조회한다.
	 * @category VOP_PSO_0035_RetrieveButtonClick
	 * @param PortChgBudByYearVO portChgBudByYearVO
	 * @return List<PortChgBudByYearVO>
	 * @throws EventException
	 */
	public List<PortChgBudByYearVO> searchPortChgBudByYear(	PortChgBudByYearVO portChgBudByYearVO)throws EventException;
	/**
	 * Invoice Summary를 조회한다.
	 * @param InvSumByMonVO invSumByMonVO
	 * @return List<InvSumByMonVO>
	 * @throws EventException
	 */
	public List<InvSumByMonVO> searchSumRptByPeriodInv(
			InvSumByMonVO invSumByMonVO) throws EventException;
	/**
	 * Budget vs Actual을 조회한다.<br>
	 * @param EstTgtVvdByMonVO estTgtVvdByMonVO
	 * @return List<EstTgtVvdByMonVO>
	 * @throws EventException
	 */
	public List<EstTgtVvdByMonVO> searchSumRptByPeriodSo(
			EstTgtVvdByMonVO estTgtVvdByMonVO) throws EventException;
	/**
	 * 재무 월간 수입 대상 항차 기준으로 해당월의 항비 대상 항차를 생성한다.
	 * @category VOP_PSO_0010_ExpenseApplyButtonClick
	 * @param EstExpnCreVO[] estExpnCreVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createEstTgtVvdByMon(
			EstExpnCreVO[] estExpnCreVOs, SignOnUserAccount account) throws EventException;
	/**
	 * 월별 Estimate Expense을 생성한다.
	 * @category VOP_PSO_0009_estimateCreationButtonClick
	 * @param String yyyymm
	 * @param String lanecd
	 * @param String userId
	 * @return String
	 * @throws EventException
	 */
	public String createEstExpnByMon(String yyyymm, String lanecd, String userId) throws EventException;
	
	/**
	 * 년도별 사업 계획을 생성한다.
	 * @category VOP_PSO_0008_creationButtonClick
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @param String userId
	 * @return String
	 * @throws EventException
	 */
	public String generateYearBudgetPlan(String startDt, String endDt, String scrNo, String userId) throws EventException;
	
	/**
	 * VVD별 Expense Plan (Pop-Up) 조회
	 * @category VOP_PSO_0201_windowOpen
	 * @param BudEstDtlCondVO budEstDtlCondVO
	 * @return List<BudEstSumByMonVO>
	 * @throws EventException
	 */
	public List<BudEstSumByMonVO> searchBudEstDtlByMonCost(
			BudEstDtlCondVO budEstDtlCondVO) throws EventException;
	/**
	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param PortChgBudByYearVO[] portChgBudByYearVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createBudget(PortChgBudByYearVO[] portChgBudByYearVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String revYrmon
	 * @return List<PsoYdChgVO>
	 * @throws EventException
	 */
	public List<PsoYdChgVO> searchYardChargeByVvd(String vslCd,
			String skdVoyNo, String skdDirCd, String revYrmon) throws EventException;
//	/**
//	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
//	 * @category VOP_PSO_0035_CreationButtonClick
//	 * @param TgtYdExpnVO tgtYdExpnVO
//	 * @throws EventException
//	 */
//	public void createTgtYdExpn(TgtYdExpnVO tgtYdExpnVO) throws EventException;
	/**
	 * 선택한 VVD 별 Expense Detail 정보를 표시한다. <br />
	 * @category VOP_PSO_0213_Open
	 * @param ExpnDtlVO expnDtlVO
	 * @return List<ExpnDtlVO>
	 * @throws EventException
	 */
	public List<ExpnDtlVO> searchExpenseDetail(ExpnDtlVO expnDtlVO) throws EventException;
//	/**
//	 * Budget 정보를 생성한다.
//	 * @category VOP_PSO_0008_CreationButtonClick
//	 * @param String startDt
//	 * @param String endDt
//	 * @param String usrId
//	 * @return String
//	 * @throws EventException
//	 */
//	public String generateYearBudgetPlanAddition(String startDt,
//			String endDt, String usrId) throws EventException;

	/**
	 * PSO 모쥴에 운하 통항 대상 VVD 정보를 VSK 로 부터 요청 받아서 생성한다.
	 * @param String portCd
	 * @param String tgtDate
	 * @param boolean flag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendToSppTargetVvd(String portCd, String tgtDate, boolean flag, SignOnUserAccount account) throws EventException;
	
	/**
	 * 해당 VVD가 Turning Port인지 확인한다.
	 * @param String hvvd
	 * @param String tmnlCode
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode)throws EventException;
	
	/**
	 * VopPsoB0003.java Estimate Creation 에서 I/O Bound 정보 획득 처리
	 * @param voIn
	 * @return PsoTgtYdExpnVO[]
	 * @throws DAOException
	 */
	public PsoTgtYdExpnVO[] getPsoTgtYdExpnVO(PsoTgtYdExpnVO voIn)  throws EventException;
	/**
	 * BudgetExpenseCreation Batch 모듈에서 Bud_Yrmon 의 값을 구한다.
	 * @param PsoBudTgtVvdVO budVo
	 * @return String 
	 * @throws EventException
	 */
	public String getBudYrmon(PsoBudTgtVvdVO budVo) throws EventException;;
	
	/**
	 * Invoice Summary Detail을 조회한다.
	 * @param InvSumDtlVO invSumDtlVO
	 * @return List<InvSumDtlVO> 
	 * @throws EventException
	 */
	public List<InvSumDtlVO> searchInvSumDtl(InvSumDtlVO invSumDtlVO) throws EventException;
	
	/*
	 * CHM-201006714-01 추정결산 로직 보완
	 */
	/**
	 * Interface To ERP 정보를 생성한다.
	 * @category VOP_PSO_0013
	 * @param ErpSumVO erpSumVO
	 * @return String
	 * @throws EventException
	 */
	public String createInterfaceToERP(ErpSumVO erpSumVO) throws EventException;
	
	/**
	 * VOP_PSO_0008 Budget Creation 조회
	 * @category VOP_PSO_0008_Retrieve (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByMon(String startDt, String endDt, String scrNo) throws EventException;
	
	/**
	 * VOP_PSO_0008 Budget Creation 환율조회
	 * @category VOP_PSO_0008_Retrieve (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByCurrency(String startDt, String endDt, String scrNo) throws EventException;
	
	/**
	 * VOP_PSO_0009 Estimate Creation 조회
	 * @category VOP_PSO_0009_Retrieve (jmh)
	 * @param String revYrmon
	 * @param String vslSlanCd
	 * @return List<EstCreVO>
	 * @throws EventException
	 */
	public List<EstCreVO> searchEstCreByMon(String revYrmon, String vslSlanCd) throws EventException;
	
	/**
	 * Batch 모듈이 실행 중인지 확인한다. 
	 * @category VOP_PSO_0009	(jmh)
	 * @param String batchID
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkRunningBatch(String batchID) throws EventException;
	
	/**
	 * VVD 단위 Tariff Simulation의 실행 상태를 확인한다.
	 * 
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdExpenseSimulationStatus(SearchPortTariffListVO[] searchPortTariffListVOs) throws EventException;
	
	/**
	 * VVD 단위 Tariff Simulation Setup을 실행한다.
	 * 
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String processType
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageVvdExpenseSimulationSetup(SearchPortTariffListVO[] searchPortTariffListVOs, String processType, SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD 단위 Tariff Simulation을 실행한다.
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String manageVvdExpenseSimulation(SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD 단위 Tariff Simulation의 실행 상태를 확인한다. (MAS용)
	 * 
	 * @param SearchPortTariffListMasVO[] searchPortTariffListMasVOs
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdExpenseSimulationStatusMas(SearchPortTariffListMasVO[] searchPortTariffListMasVOs) throws EventException;

	/**
	 * VVD 단위 Tariff Simulation Setup을 실행한다. (MAS용)
	 * 
	 * @param SearchPortTariffListMasVO[] searchPortTariffListMasVOs
	 * @param String processType
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageVvdExpenseSimulationSetupMas(SearchPortTariffListMasVO[] searchPortTariffListMasVOs, String processType, SignOnUserAccount account) throws EventException;
	
	
}