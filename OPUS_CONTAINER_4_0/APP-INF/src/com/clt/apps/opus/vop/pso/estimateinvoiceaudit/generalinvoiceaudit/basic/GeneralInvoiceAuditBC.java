/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralInvoiceAuditBC.java
 *@FileTitle : GeneralInvoiceAuditBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationInvoiceListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffGRPVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.PsoChargeVO;
import com.clt.syscommon.common.table.PsoYdChgVO;

/**
 * ALPS-Estimateinvoiceaudit Business Logic Command Interface<br>
 *
 * @author
 * @see Reference Vop_pso-0018EventResponse
 * @since J2EE 1.6
 */

public interface GeneralInvoiceAuditBC {

	/**
	 * Handling Confirm Click Invoice Createion of Requested Advance Payment
	 * 
	 * @category VOP_PSO_0018_confirm_click_invoicecreateion
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(AuditDataValidVO[] auditDataValidVOs) throws EventException;

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Save in case of Clicking Invoice Creation(Master) & Audit page Save
	 * Button <br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO[] invAuditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAuditMaster(InvAuditDataValidVO[] invAuditDataValidVOs) throws EventException;

	/**
	 * Put in action Tariff calculation by using key value input and parameter
	 * value
	 * 
	 * @category TariffCalcEngine
	 * @param CalcTariffVO calcTariffVO
	 * @return CalcTariffResultVO
	 * @throws EventException
	 */
	public CalcTariffResultVO calGeneralInvAudit(CalcTariffVO calcTariffVO) throws EventException;

	/**
	 * Retrieve PSO_YD_CHG Info
	 * 
	 * @category VOP_PSO_0014_searchPsoYdChg
	 * @param String lgsCostCd
	 * @param String ydCd
	 * @param String vndrSeq
	 * @param String issDt
	 * @return List<PsoYdChgVO>
	 * @throws EventException
	 */
	public List<PsoYdChgVO> searchPsoYdChg(String lgsCostCd, String ydCd, String vndrSeq, String issDt) throws EventException;

	/**
	 * VOP_PSO_0014 : select Issue Date <br/>
	 * Retrieve Effective Date in case of selecting Issue Date on Invoice
	 * Creation & Audit page.<br />
	 * 
	 * @category VOP_PSO_0014_OnChangeIssueDate
	 * @param String issDt
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchEffDateByIssDate(String issDt, String ofcCd) throws EventException;

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Save in case of clicking Save button on Invoice Creation & Audit page<br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(InvAuditDataValidVO[] auditDataValidVOs) throws EventException;

	/**
	 * VOP_PSO_0014 : Retrieve Button Click <br/>
	 * Retrieve in case of clicking Retrieve button on Invoice Creation & Audit
	 * page .<br />
	 * 
	 * @category VOP_PSO_0014_RetrieveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws EventException
	 */
	public List<InvAuditDataValidVO> searchGenInvAudit(InvAuditDataValidVO invAuditDataValidVO) throws EventException;

	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Handle in case of clicking delete button on Invoice Creation & Audit page
	 * Delete Button Click <br />
	 * 
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @throws EventException
	 */
	public void removeGenInvAudit(String vndrSeq, String ydCd, String invNo) throws EventException;

	/**
	 * VOP_PSO_0014 : Grid Account Cd Change <br />
	 * Handle in case of changing Account Code on Grid of Invoice Creation &
	 * Audit page <br />
	 * 
	 * @category VOP_PSO_0014_VvdLevelCheck
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVvdLevel(InvAuditDataValidVO invAuditDataValidVO) throws EventException;

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Retrieve Info which will be saved to AP_PAY_INV VO in case of clicking
	 * Confirm button on Invoice Creation & Audit page <br />
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInv(InvAuditDataValidVO invAuditDataValidVO) throws EventException;

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Retrieve Info which will be saved to AP_PAY_INV_DTL VO in case of
	 * clicking Confirm button on Invoice Creation & Audit page
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvDtlVO[]
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtl(InvAuditDataValidVO invAuditDataValidVO) throws EventException;

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * renew INV_RGST_NO and STATUS CD in case of clicking confirm button on
	 * Invoice Creation & Audit page<br />
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param invAuditDataValidVO
	 * @throws EventException
	 */
	public void updatePsoCharge(InvAuditDataValidVO invAuditDataValidVO) throws EventException;

	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Check existence of CSR No. in case of clicking delete button on Invoice
	 * Creation & Audit page <br />
	 * 
	 * @category VOP_PSO_0014_DeleteButtonClickCSRNoCheck
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkApPayInv(String vndrSeq, String ydCd, String invNo) throws EventException;

	/**
	 * get USD Info
	 * 
	 * @param strLocalAmt
	 * @param currCd
	 * @param string
	 * @param string2
	 * @return String
	 * @throws EventException
	 */
	public String getUsdAmt(String strLocalAmt, String currCd, String string, String string2) throws EventException;

	/**
	 * Check whether port of VVD chosen is Turning Port
	 * 
	 * @param String hvvd
	 * @param String tmnlCode
	 * @param String clptIndSeq
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode, String clptIndSeq) throws EventException;

	/**
	 * VOP_PSO-0014 : INV No. Focus Out Event <br />
	 * VOP_PSO-0014 Check existence of INV No. input
	 * 
	 * @category VOP_PSO_0014_InvNoFocusOut
	 * @param String vndrSeq
	 * @param String invNo
	 * @param String dftVslCd
	 * @return PsoChargeVO
	 * @throws EventException
	 */
	public PsoChargeVO checkInvNo(String vndrSeq, String invNo, String dftVslCd) throws EventException;

	/**
	 * Retrieve Tariff of latest version
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<TariffInfoVO>
	 * @throws EventException
	 */
	public List<TariffInfoVO> getTariff(SimulationConditionVO simulationConditionVO) throws EventException;

	/**
	 * Retrieve Objects which construct Formula/Condition used in Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<SimulationObjectListVO>
	 * @throws EventException
	 */
	public List<SimulationObjectListVO> searchObjectBySimulation(SimulationConditionVO simulationConditionVO) throws EventException;

	/**
	 * Retrieve Invoice Detail
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO[] simulationConditionVOs
	 * @return List<SimulationInvoiceListVO>
	 * @throws EventException
	 */
	public List<SimulationInvoiceListVO> searchInvoiceBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs) throws EventException;

	/**
	 * Get DefaultValue of Auto Object
	 * 
	 * @category VOP_PSO_0038_setAutoObjectDfltVal
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO simulationConditionVO2
	 * @param List<SimulationObjectListVO> objectsList
	 * @throws EventException
	 */
	public void setAutoObjectDfltVal(SimulationConditionVO simulationConditionVO, SimulationConditionVO simulationConditionVO2, List<SimulationObjectListVO> objectsList) throws EventException;

	/**
	 * Retrieve Service Providers which is applicable to Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<SimulationConditionVO>
	 * @throws EventException
	 */
	public List<SimulationConditionVO> searchProviderBySimulation(SimulationConditionVO simulationConditionVO) throws EventException;

	/**
	 * Retrieve Account used in Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<CostListVO>
	 * @throws EventException
	 */
	public List<CostListVO> searchAccountBySimulation(SimulationConditionVO simulationConditionVO) throws EventException;

	/**
	 * Retrieve tariff converted to exchange rate
	 * 
	 * @category VOP_PSO_0014_Calculation
	 * @param String div
	 * @param String amt
	 * @param String dt
	 * @param String currCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchConvertedAmount(String div, String amt, String dt, String currCd) throws EventException;

	/**
	 * Retrieve tariff converted to exchange rate
	 * 2016.08.17 Add
	 * Local to Local 환율 계산 추가.
	 * 
	 * @category VOP_PSO_0014_Calculation
	 * @param String div
	 * @param String amt
	 * @param String dt
	 * @param String frCurrCd
	 * @param String toCurrCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchConvertedInvoiceAmount(String div, String amt, String dt, String frCurrCd, String toCurrCd) throws EventException;

	/**
	 * Retrieve yard Info
	 * 
	 * @category VOP_PSO_0038
	 * @param String portCd
	 * @param String issueDate
	 * @return List<SearchYardsVO>
	 * @exception EventException
	 */
	public List<SearchYardsVO> searchYardList(String portCd, String issueDate) throws EventException;

	/**
	 * Retrieve cost used in Tariff
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<CostListVO>
	 * @throws EventException
	 */
	public List<CostListVO> searchCostBySimulation(SimulationConditionVO simulationConditionVO) throws EventException;

	/**
	 * Retrieve object list
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO[] simulationConditionVOs
	 * @return List<SimulationObjectListVO>
	 * @throws EventException
	 */
	public List<SimulationObjectListVO> searchObjectListBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs) throws EventException;

	/**
	 * Calculation
	 * 
	 * @category VOP_PSO_0038
	 * @param SimulationConditionVO sVO
	 * @param SimulationConditionVO[] sVOs
	 * @param SimulationObjectListVO[] autovos
	 * @param SimulationObjectListVO[] vos
	 * @return List<CalcTariffResultVO>
	 * @throws EventException
	 */
	public List<CalcTariffResultVO> calculateTariff(SimulationConditionVO sVO, SimulationConditionVO[] sVOs, SimulationObjectListVO[] autovos, SimulationObjectListVO[] vos) throws EventException;

	/**
	 * Retrieve Tariff Simulation By VVD Info
	 * 
	 * @category VOP_PSO_0039
	 * @param TariffSimByVvdVO tariffSimByVvdVO
	 * @return TariffGRPVO
	 * @exception EventException
	 */
	public TariffGRPVO searchSimulationByVvd(TariffSimByVvdVO tariffSimByVvdVO) throws EventException;

	/**
	 * Retrieve whether the VVD applicable is for business plan or for Live
	 * business == 1 / Live == 2
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchVvdBztpCd(String vvd) throws EventException;

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Save in case of clicking Invoice Creation & Audit page Retrieve Button <br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws EventException
	 */
	public List<InvAuditDataValidVO> searchGenInvAuditMaster(InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	
	/**
	 * 유저가 입력한 VVD의 Yard가 스킵인지 확인
	 * 
	 * @category VOP_PSO_0014_vvdCheckClick
	 * @param String vslCd  
	 * @param String skdVoyNo 
	 * @param String skdDirCd 
	 * @param String ydCd
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkSkipYardInVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * Obj Reqular Value(Default Value) Search.
	 * 
	 * @category Obj Reqular Value
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param List<String> objNoList
	 * @return Map<String, Object>
	 * @throws EventException
	 */
	public Map<String, Object> getRegularValueByObjectNoMap(String ydChgNo, String ydChgVerSeq, List<String> objNoList) throws EventException;
	
	/**
	 * Object Test Method.
	 * 
	 * @param HashMap<String, Object> map
	 * @return HashMap<String, Object>
	 * @throws EventException
	 */
	public HashMap<String, Object> getObjectTestValue(HashMap<String, Object> map)  throws EventException;
	
	/**
	 * 2016.12.19 Add
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD가 기존 입력된 Invoice가 있는지 체크
	 * 
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<String> 
	 * @exception EventException
	 */
	public List<String> checkDoublePayInv(InvAuditDataValidVO invAuditDataValidVO) throws EventException;

}