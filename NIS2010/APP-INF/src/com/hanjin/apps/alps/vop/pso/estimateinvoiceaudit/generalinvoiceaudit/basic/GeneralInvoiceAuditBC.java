/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditBC.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.16 김진일
* 1.0 Creation
* 
* History
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
* 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
* 2011.07.18 진마리아 CHM-201111882-01 [VOP-PSO] COA data I/F
* 2011.07.28 진마리아 CHM-201111838-01 R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 - 태깅을 위해 일부소스(searchVvdBztpCd) 주석처리
* 2012.01.10 진마리아 선처리(SRM-201222935) invoice creation 화면 오픈시 미 Confirm된 Invoice List Notice 메시지 alert
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
* 2012.11.19 이혜민   CHM-201221185-01 [PSO] 항비 입력시 skip port 에 대한 pop up 메시지 추가 요청
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
* 2013.01.24 SKY    CHM-201322525    Invoice creation 중복 account code 체크 로직 추가
* 2014.05.30 박다은 [CHM-201430328] [PSO] Port Charge invoice Creation 기능 개선
* 2014.08.05 이성훈 CHM-201430972 	[PSO] Invoice내 Exchanage Rate 칼럼 추가
* 2015.05.13 김기원 CHM-201535833 [PSO] USD이외의 Local 환율적용에 따른 exchange Rate 적용
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationInvoiceListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffGRPVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TpbIfVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;

/**
 * ALPS-Estimateinvoiceaudit Business Logic Command Interface<br>
 * - ALPS-Estimateinvoiceaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jin Ihl
 * @see Vop_pso-0018EventResponse 참조
 * @since J2EE 1.6
 */

   public interface GeneralInvoiceAuditBC {
	
	/**
	 * Requested Advance Payment의 Confirm Click Invoice Createion 처리 
	 * @category VOP_PSO_0018_confirm_click_invoicecreateion
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(AuditDataValidVO[] auditDataValidVOs) throws EventException;
	/**
	 * 입력된 키값 및 매개변수값을 이용하여 Tariff계산을 실행한다.
	 * @category TariffCalcEngine
	 * @param CalcTariffVO calcTariffVO
	 * @return CalcTariffResultVO
	 * @throws EventException
	 */
	public CalcTariffResultVO calGeneralInvAudit(CalcTariffVO calcTariffVO) throws EventException;
	
	/**
	 * 주어진 조건으로 PSO_YD_CHG 의 정보를 조회 한다. 
	 * @category VOP_PSO_0014_searchPsoYdChg
	 * @param String lgsCostCd
	 * @param String ydCd
	 * @param String vndrSeq
	 * @param String issDt
	 * @return List<PsoYdChgVO>
	 * @throws EventException
	 */
	public List<PsoYdChgVO> searchPsoYdChg(String lgsCostCd, String ydCd,
			String vndrSeq, String issDt) throws EventException;
	
	/**
	 * VOP_PSO_0014 : select Issue Date <br/>
	 * Invoice Creation & Audit 화면에서 Issue Date 선택 시 Effective Date 를 조회한다.<br />
	 * @category VOP_PSO_0014_OnChangeIssueDate
	 * @param String issDt
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchEffDateByIssDate(String issDt, String ofcCd) throws EventException;
	
	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 저장처리를 한다.<br />
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageGenInvAudit(
			InvAuditDataValidVO[] auditDataValidVOs)  throws EventException;
	/**
	 * VOP_PSO_0014 : Retrieve Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Retrieve Button Click 시 조회 처리를 한다.<br />
	 * @category VOP_PSO_0014_RetrieveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws EventException
	 */
	public List<InvAuditDataValidVO> searchGenInvAudit(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 처리를 한다.<br />
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @throws EventException
	 */
	public void removeGenInvAudit(String vndrSeq, String ydCd, String invNo) throws EventException;
	/**
	 * VOP_PSO_0014 : Grid Account Cd Change <br />
	 * Invoice Creation & Audit 화면의 그리드에서 Account Code 변경 시 처리를 한다.<br />
	 * @category VOP_PSO_0014_VvdLevelCheck
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVvdLevel(InvAuditDataValidVO invAuditDataValidVO) throws EventException;
//	/**
//	 * VOP_PSO_0014 : Confirm Button Click <br />
//	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 처리를 한다.<br />
//	 * @category VOP_PSO_0014_ConfirmButtonClick
//	 * @param InvAuditDataValidVO invAuditDataValidVO
//	 * @throws EventException
//	 */
//	public void createInvApprovalRqstAp(InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV VO 에 저장 할 정보를 조회한다. <br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInv(InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV_DTL VO 에 저장할 정보를 조회한다.<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvDtlVO[] 
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtl(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV_DTL VO 에 저장할 정보를 조회한다.TONNAGE 배분 로직 포함<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvDtlVO[]
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtlDiv(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException ;
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV_DTL VO 에 저장할 정보를 조회한다. tonnage배분 로직이 들어가는 지 여부 판단<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return String
	 * @throws EventException
	 */
	
	public String searchTonnageDiv(
			InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	
	/**
	 * VOP_PSO_0014 : Retrieve Button Click <br />
	 * tonnage 입력시 cost_calc_eff_fm_dt와 cost_calc_eff_to_dt를 입력했는지 여부 확인 <br />
	 * @category VOP_PSO_0014_RetrieveButtonClick
	 * @param String invNo  
	 * @param String vndrSeq 
	 * @return String 
	 * @exception EventException
	 */
	public String searchTonnageDivFlag(String invNo, String vndrSeq) throws EventException;
	
	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 INV_RGST_NO 및 STATUS CD 를 갱신한다.<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param invAuditDataValidVO
	 * @throws EventException
	 */
	
	public void updatePsoCharge(InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 CSR No. 의 존재 여부 확인 <br />
	 * @category VOP_PSO_0014_DeleteButtonClickCSRNoCheck
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkApPayInv(String vndrSeq, String ydCd, String invNo) throws EventException;
	/**
	 * USD정보를 가져온다.
	 * @param strLocalAmt
	 * @param currCd
	 * @param string
	 * @param string2
	 * @return String
	 * @throws EventException
	 */
	public String getUsdAmt(String strLocalAmt, String currCd, String string,
			String string2) throws EventException;
	/**
	 * 해당 VVD의 포트가 Turning Port인지 확인
	 * @param String hvvd
	 * @param String tmnlCode
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode) throws EventException;
	/**
	 * VOP_PSO-0014 : INV No. Focus Out Event <br />
	 * VOP_PSO-0014 입력된 INV No.가 존재하는지 확인한다.
	 * @category VOP_PSO_0014_InvNoFocusOut
	 * @param String vndrSeq
	 * @param String invNo
	 * @return String
	 * @throws EventException
	 */
	public String checkInvNo(String vndrSeq, String invNo) throws EventException;
	
	/**
	 * 최근 버전의 Tariff를 조회한다.
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<TariffInfoVO>
	 * @throws   EventException
	 */		
	public List<TariffInfoVO> getTariff(SimulationConditionVO simulationConditionVO)  throws EventException;
	/**
	 * Tariff에 사용된 Formula/Condition를 구성하는 Objects를 조회한다.
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<SimulationObjectListVO>
	 * @throws   EventException
	 */		
	public List<SimulationObjectListVO> searchObjectBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException;
	/**
	 * Invoice Detail 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @param    SimulationConditionVO[] simulationConditionVOs
	 * @return   List<SimulationInvoiceListVO>
	 * @throws   EventException
	 */		
	public List<SimulationInvoiceListVO> searchInvoiceBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs)  throws EventException;
	
	/**
	 * Auto Object 의 DefaultValue 값을 구한다.
	 * @category VOP_PSO_0038_setAutoObjectDfltVal
	 * @param SimulationConditionVO simulationConditionVO 
	 * @param SimulationConditionVO simulationConditionVO2
	 * @param List<SimulationObjectListVO> objectsList
	 * @throws EventException
	 */
	public void setAutoObjectDfltVal(SimulationConditionVO simulationConditionVO, SimulationConditionVO simulationConditionVO2, List<SimulationObjectListVO> objectsList) throws EventException;
	/**
	 * Tariff에 해당하는 Service Providers 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<SimulationConditionVO>
	 * @throws   EventException
	 */		
	public List<SimulationConditionVO> searchProviderBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException;
	/**
	 * Tariff에서 사용하는 Account 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<CostListVO>
	 * @throws   EventException
	 */		
	public List<CostListVO> searchAccountBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException;

	/**
	 * 환율변환된 금액을 조회한다.
	 * @category VOP_PSO_0014_Calculation
	 * @param    String div
	 * @param    String amt
	 * @param    String dt
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmount(String div, String amt, String dt, String currCd)  throws EventException;
	
	/**
	 * 환율변환된 금액을 조회한다.2015-05-08 ex) tariff : XOF  invoice : EUR 인 경우   XOF --> USD ---> EUR로  환율 계산을 해 주도록 함.
	 * @category VOP_PSO_0014_Calculation
	 * @param    String amt
	 * @param    String dt
	 * @param    String bcurrCd
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmountOther( String amt, String dt, String bcurrCd, String currCd)  throws EventException;
	
	/**
	 * yard 정보를 조회한다.
	 * @category VOP_PSO_0038
	 * @param String portCd
	 * @param String issueDate
	 * @return List<SearchYardsVO>
	 * @exception EventException
	 */
	public List<SearchYardsVO> searchYardList (String portCd, String issueDate) throws EventException;
	
	/**
	 * Tariff에서 사용하는 Cost 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @return   List<CostListVO>
	 * @throws   EventException
	 */		
	public List<CostListVO> searchCostBySimulation(SimulationConditionVO simulationConditionVO)  throws EventException;

	/**
	 * object list 조회하기
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO simulationConditionVO
	 * @param    SimulationConditionVO[] simulationConditionVOs
	 * @return   List<SimulationObjectListVO>
	 * @throws   EventException
	 */		
	public List<SimulationObjectListVO> searchObjectListBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO[] simulationConditionVOs)  throws EventException;
	
	/**
	 * Calculation
	 * @category VOP_PSO_0038
	 * @param    SimulationConditionVO sVO
	 * @param    SimulationConditionVO[] sVOs
	 * @param    SimulationObjectListVO[] autovos
	 * @param    SimulationObjectListVO[] vos
	 * @return   List<CalcTariffResultVO>
	 * @throws   EventException
	 */		
	public List<CalcTariffResultVO> calculateTariff(SimulationConditionVO sVO, SimulationConditionVO[] sVOs, SimulationObjectListVO[] autovos, SimulationObjectListVO[] vos)  throws EventException;
	
	/**
	 * Tariff Simulation By VVD 정보를 조회한다.
	 * @category VOP_PSO_0039
	 * @param TariffSimByVvdVO tariffSimByVvdVO
	 * @return TariffGRPVO
	 * @exception EventException
	 */
	public TariffGRPVO searchSimulationByVvd (TariffSimByVvdVO tariffSimByVvdVO) throws EventException;
	
	/**
	 * 대상 VVD가 사업계획용인지 Live용인지 조회한다.
	 * 사업계획 == 1 / Live == 2
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchVvdBztpCd(String vvd) throws EventException;
	
	/**
	 * 해당 유저가 생성한 invoice 중, 미 confirm된 invoice list를 조회한다.
	 * 
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchNoConfirmInvoice(SignOnUserAccount account) throws EventException;

	/**
	 * 유저가 입력한 VVD의 Yard가 스킵인지 확인
	 * @param String vslCd  
	 * @param String skdVoyNo 
	 * @param String skdDirCd 
	 * @param String ydCd
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkSkipYardInVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;	
	
	
	/**
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD가 기존 입력된 Invoice가 있는지 체크
	 * @param String vndrSeq  
	 * @param String costOfcCd 
	 * @param String ydCd 
	 * @param String costCd
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> checkDoublePayInv(String vndrSeq,String costOfcCd,String ydCd, String costCd, String vslCd, String skdVoyNo, String skdDirCd) throws EventException ;
	
		/**
	 * PSO-TPB Interface할 때의 billing type을 조회합니다.
	 * 
	 * @return List<TpbIfVO>
	 * @throws EventException
	 */
	public List<TpbIfVO> searchTpbBillType() throws EventException;
	
	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 처리를 한다.<br />
	 * TPB IF 대상건 삭제
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String issCtyCd 
	 * @param String  soSeq 
	 * @throws EventException 
	 */
	public void removeTpbInv(String issCtyCd, String soSeq)	throws EventException;
	
	/**
	 * ERP에서 인보이스 승인시 호출되며, TPB 대상건의 IF_FLG를 Y로 변경하고 TPB procedure를 호출한다.
	 * @param String csrNo
	 * @throws EventException 
	 */
	public void manageApprovalCsr(String csrNo)	throws EventException;
	
	/**
	 * [VOP_PSO_0014] VVD 입력 시 해당 ATD 를 조회한다.
	 * 
	 * @param invAuditDataValidVO
	 * @return
	 * @throws EventException
	 */
	public String searchAtdData(InvAuditDataValidVO invAuditDataValidVO) throws EventException;
	
	/**
	 * 환율변환된 금액을 조회한다.
	 * @category VOP_PSO_0014_Calculation
	 * @param    String div
	 * @param    String amt
	 * @param    String xchRt
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmountByXchRt(String div, String amt, String xchRt, String currCd)  throws EventException;	
	
	/**
	 * 2015.05.08 USD를 제외한 통화를 계산하기 위해서는 중간에 한번 USD로 바꾸고 난 후 다시 INVOICE 통화로 변경
	 * @category VOP_PSO_0014_Calculation
	 * @param    String amt
	 * @param    String xchRt
	 * @param    String bcurrCd
	 * @param    String currCd
	 * @return   String[]
	 * @throws   EventException
	 */		
	public String[] searchConvertedAmountOtherByXchRt( String amt, String xchRt, String bcurrCd, String currCd)  throws EventException;
	
	/**
	 * VOP_PSO_0014 : Tariff File GW폴더로 카피 <br/>
	 * Invoice Creation & Audit 화면에서 Confirm Button Click 시 Tariff File GW폴더로 카피.<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO[] fileSrchVOs
	 * @throws EventException
	 */
	public void fileSrchYdChgNos(InvAuditDataValidVO[] fileSrchVOs)  throws EventException;
	
	 /**
	 * VOP_PSO-0014 : INV No. Focus Out Event <br />  2014.12.16 중복 ALERT MSG상세화
	 * VOP_PSO-0014 입력된 INV No.가 존재하는지 확인한다.
	 * @category VOP_PSO_0014_InvNoFocusOut
	 * @param String vndrSeq
	 * @param String invNo
	 * @return String
	 * @throws EventException
	 */
	public String checkDoubleInvNo(String vndrSeq, String invNo) throws EventException;
	
	 /**
	 * COM_CSR_0002 : CSR Confirm시 해당 CSR의 INVOICE건에 대해 Tariff가 있는 경우 attach해 주기 위함.
	 * @category COM_CSR_0002_CSR_CREATE버튼 CLICK시
	 * @param String csrno
	 * @param String creusrid
	 * @throws EventException
	 */
	public void addCsrAttchTariffFile(String csrno, String creusrid)	throws EventException;
	
	 /**
		 * VOP_PSO_0014 : TUG BOAT를 사용하는 계정을 CHECK하기 위함.
		 * @category VOP_PSO-0014_ACCT_CD가 입력되는 순간
		 * @param String vndrSeq
		 * @param String ydCd
		 * @param String costCd
		 * @param String issDt
		 * @return String
		 * @throws EventException
		 */
	public String searchAddInfo(String vndrSeq, String ydCd, String costCd, String issDt )	throws EventException;
	
	 /**
	 * VOP_PSO_0014 : BAF를 사용하는 계정을 CHECK하기 위함.
	 * @category VOP_PSO-0014_ACCT_CD가 입력되는 순간
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String costCd
	 * @param String issDt
	 * @return String
	 * @throws EventException
	 */
   public String searchAddCharge(String vndrSeq, String ydCd, String costCd, String issDt )	throws EventException;
	
	/**
	 * VOP_PSO_0217 :  TUG BOAT를 사용하는 계정인 경우 regular value값 가져오기..
	 * @category VOP_PSO-0014_ACCT_CD가 입력되는 순간
	 * @param String vvd
	 * @param String ydcd
	 * @param String io
	 * @param String ydchgno
	 * @param String ydchgverseq
	 * @return String
	 * @throws EventException
	 */
	public String searchRegularAddInfo(String vvd,String ydcd, String io,  String ydchgno, String ydchgverseq) throws EventException ;
	/**
	 * VOP_PSO_0217 :  BAF를 사용하는 계정인 경우 가장 최근 value값 가져오기..
	 * @category VOP_PSO-0014_ACCT_CD가 입력되는 순간
	 * @param String vndrSeq
	 * @param String ydcd
	 * @param String lgscostCd
	 * @return String
	 * @throws EventException
	 */
	public String searchLastBafRate(String vndrSeq,String ydcd, String lgscostCd) throws EventException ;
	
	
}