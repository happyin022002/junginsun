/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BudgetPortChargeMgtBC.java
 *@FileTitle : Budget vs Actual
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstDtlCondVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstSumByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ContinentVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.CtrlOfficeVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstExpnCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstTgtVvdByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ExpnDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.PortChgBudByYearVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PsoBudTgtVvdVO;
import com.clt.syscommon.common.table.PsoTgtYdExpnVO;
import com.clt.syscommon.common.table.PsoYdChgVO;

/**
 * ALPS-Portchargebudget Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference Vop_pso_0025EventResponse
 * @since J2EE 1.6
 */

public interface BudgetPortChargeMgtBC {
	/**
	 * retrieve Expense Plan Per VVD(Pop-Up) 
	 * @category VOP_PSO_0201_windowOpen
	 * @param EstExpnCreVO estExpnCreVO
	 * @return List<BudEstSumByMonVO>
	 * @throws EventException
	 */
	public List<EstExpnCreVO> searchEstTgtVvdByMon(EstExpnCreVO estExpnCreVO) throws EventException ;
	/**
	 * Retrieve estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0013_RetrieveButtonClick
	 * @param ErpSumVO erpSumVO
	 * @return List<ErpSumVO>
	 * @throws EventException
	 */
	public List<ErpSumVO> searchErpSum(ErpSumVO erpSumVO) throws EventException ;	
	
	/**
	 * Detail Down Excel estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0013_DetailDownExcelButtonClick
	 * @param ErpSumVO erpSumVO
	 * @return List<ErpDtlVO>
	 * @exception EventException
	 */
	public List<ErpDtlVO> searchErpDtlExcelData(ErpSumVO erpSumVO) throws EventException;

    /**
     * Detail Down Excel BackEndJob
     * 2016.12.19 Add
	 * @category VOP_PSO_0013_DetailExcelBackEndJobRetrieveBtnClick
     * @param ErpSumVO erpSumVo
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String searchErpDtlExcelDataBackEndJob(ErpSumVO erpSumVo, SignOnUserAccount signOnUserAccount) throws EventException;
	/**
	 * Retrieve a detailed estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 * @throws EventException
	 */
	public List<ErpDtlVO> searchErpDtl(ErpDtlVO erpDtlVO) throws EventException;
	/**
	 * Retrieve a detailed estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 */
	public List<ContinentVO> searchContinentByErp(ErpDtlVO erpDtlVO) throws EventException;
	/**
	 * Change estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_SaveButtonClick
	 * @param ErpDtlVO[] erpDtlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyErpDtl(ErpDtlVO[] erpDtlVOs, SignOnUserAccount account) throws EventException;
	/**
	 * Retrieve business plan by year
	 * @category VOP_PSO_0035_RetrieveButtonClick
	 * @param PortChgBudByYearVO portChgBudByYearVO
	 * @return List<PortChgBudByYearVO>
	 * @throws EventException
	 */
	public List<PortChgBudByYearVO> searchPortChgBudByYear(	PortChgBudByYearVO portChgBudByYearVO)throws EventException;
	/**
	 * Retrieve Invoice Summary
	 * @param InvSumByMonVO invSumByMonVO
	 * @return List<InvSumByMonVO>
	 * @throws EventException
	 */
	public List<InvSumByMonVO> searchSumRptByPeriodInv(
			InvSumByMonVO invSumByMonVO) throws EventException;
	/**
	 * Retrieve Budget vs Actual<br>
	 * @param EstTgtVvdByMonVO estTgtVvdByMonVO
	 * @return List<EstTgtVvdByMonVO>
	 * @throws EventException
	 */
	public List<EstTgtVvdByMonVO> searchSumRptByPeriodSo(
			EstTgtVvdByMonVO estTgtVvdByMonVO) throws EventException;
	/**
	 *  Create VVD which is object of port expense of this month by VVD standard which is object of monthly income
	 * @category VOP_PSO_0010_ExpenseApplyButtonClick
	 * @param EstExpnCreVO[] estExpnCreVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createEstTgtVvdByMon(
			EstExpnCreVO[] estExpnCreVOs, SignOnUserAccount account) throws EventException;
	/**
	 * Create Estimate Expense monthly
	 * @category VOP_PSO_0009_estimateCreationButtonClick
	 * @param String yyyymm
	 * @param String lanecd
	 * @param String userId
	 * @return String
	 * @throws EventException
	 */
	public String createEstExpnByMon(String yyyymm, String lanecd, String userId) throws EventException;
	
	/**
	 * Create business plan by year
	 * @category VOP_PSO_0008_creationButtonClick
	 * @param String startDt
	 * @param String endDt
	 * @param userId String
	 * @return String
	 * @throws EventException
	 */
	public String generateYearBudgetPlan(String startDt, String endDt, String userId) throws EventException;
	
	/**
	 * Retrieve Expense Plan (Pop-Up) by VVD
	 * @category VOP_PSO_0201_windowOpen
	 * @param BudEstDtlCondVO budEstDtlCondVO
	 * @return List<BudEstSumByMonVO>
	 * @throws EventException
	 */
	public List<BudEstSumByMonVO> searchBudEstDtlByMonCost(
			BudEstDtlCondVO budEstDtlCondVO) throws EventException;
	/**
	 * Recreate Budget Info by VVD chosen from main list  <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param PortChgBudByYearVO[] portChgBudByYearVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createBudget(PortChgBudByYearVO[] portChgBudByYearVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Recreate Budget Info by VVD chosen from main list <br />
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
//	 * Recreate Budget Info by VVD chosen from main list <br />
//	 * @category VOP_PSO_0035_CreationButtonClick
//	 * @param TgtYdExpnVO tgtYdExpnVO
//	 * @throws EventException
//	 */
//	public void createTgtYdExpn(TgtYdExpnVO tgtYdExpnVO) throws EventException;
	/**
	 * Show Ecpense Detail Info by VVD chosen  <br />
	 * @category VOP_PSO_0213_Open
	 * @param ExpnDtlVO expnDtlVO
	 * @return List<ExpnDtlVO>
	 * @throws EventException
	 */
	public List<ExpnDtlVO> searchExpenseDetail(ExpnDtlVO expnDtlVO) throws EventException;
//	/**
//	 * Recreate Budget Info
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
	 * Create VVD Info which is object of canal navigation in PSO module requested by VSK 
	 * @param String portCd
	 * @param String tgtDate
	 * @param boolean flag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendToSppTargetVvd(String portCd, String tgtDate, boolean flag, SignOnUserAccount account) throws EventException;
	
	/**
	 * Check whether VVD chosen is Turning Port.
	 * @param String hvvd
	 * @param String tmnlCode
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode)throws EventException;
	
	/**
	 * Get I/O Bound Info in VopPsoB0003.java Estimate Creation 
	 * @param voIn
	 * @return PsoTgtYdExpnVO[]
	 * @throws DAOException
	 */
	public PsoTgtYdExpnVO[] getPsoTgtYdExpnVO(PsoTgtYdExpnVO voIn)  throws EventException;
	/**
	 * Get Bud_Yrmon value in BudgetExpenseCreation Batch module
	 * @param PsoBudTgtVvdVO budVo
	 * @return String 
	 * @throws EventException
	 */
	public String getBudYrmon(PsoBudTgtVvdVO budVo) throws EventException;;
	
	/**
	 * Retrieve Invoice Summary Detail
	 * @param InvSumDtlVO invSumDtlVO
	 * @return List<InvSumDtlVO> 
	 * @throws EventException
	 */
	public List<InvSumDtlVO> searchInvSumDtl(InvSumDtlVO invSumDtlVO) throws EventException;
	
	
	/**
	 * Create Interface To ERP info
	 * @category VOP_PSO_0013
	 * @param ErpSumVO erpSumVO
	 * @return String
	 * @throws EventException
	 */
	public String createInterfaceToERP(ErpSumVO erpSumVO) throws EventException;
	
	/**
	 * Retrieve Budget Creation 
	 * @category VOP_PSO_0008_Retrieve 
	 * @param String startDt
	 * @param String endDt
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByMon(String startDt, String endDt) throws EventException;
	
	/**
	 * Retrieve Budget Creation exchange rate 
	 * @category VOP_PSO_0008_Retrieve (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByCurrency(String startDt, String endDt) throws EventException;
	
	/**
	 * Retrieve Estimate Creation
	 * @category VOP_PSO_0009_Retrieve (jmh)
	 * @param String revYrmon
	 * @param String vslSlanCd
	 * @return List<EstCreVO>
	 * @throws EventException
	 */
	public List<EstCreVO> searchEstCreByMon(String revYrmon, String vslSlanCd) throws EventException;
	
	/**
	 * Check whether Batch module is in action 
	 * @category VOP_PSO_0009	
	 * @param String batchID
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkRunningBatch(String batchID) throws EventException;
	
	/**
	 * Save date of Budget Creation
	 * @category VOP_PSO_0008_SaveButtonClick
	 * @param BudCreVO[] budCreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBudCre(BudCreVO[] budCreVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Check running state of VVD unit Tariff Simulation
	 * 
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdExpenseSimulationStatus(SearchPortTariffListVO[] searchPortTariffListVOs) throws EventException;
	
	/**
	 * Put in action VVD unit Tariff Simulation Setup.
	 * 
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String processType
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageVvdExpenseSimulationSetup(SearchPortTariffListVO[] searchPortTariffListVOs, String processType, SignOnUserAccount account) throws EventException;
	
	/**
	 * Put in action VVD unit Tariff Simulation
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String manageVvdExpenseSimulation(SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve a detailed estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 */
	public List<CostListVO> searchAccountCodeByErp(ErpDtlVO erpDtlVO) throws EventException;
	

	
	/**
	 * Retrieving Control Office Code of RHQ
	 * 
	 * @param String rhqCd
	 * @return List<CtrlOfficeVO>
	 * @exception EventException
	 */
	public List<CtrlOfficeVO> searchControlOfficeList(String rhqCd) throws EventException;    
	
	/**
     * Retrieve Invoice Summary BackEndJob
     * 2016.05.19 Add
     * @param InvSumByMonVO invSumByMonVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String searchSumRptByPeriodInvBackEndJob(InvSumByMonVO invSumByMonVO, SignOnUserAccount signOnUserAccount) throws EventException;    
    
    /**
     * Retrieve Common BackEndJob Status
     * 2016.05.19 Add
     * 
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchComBackEndJobStatus(String key) throws EventException;
}