/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PortTariffMgtBC.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CondtionOpertionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CostCodeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CurrencyVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.EffectiveDateListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchTariffConditionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListWithYdNmVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVersionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVendorVO;
import com.clt.syscommon.common.table.PsoFormulaVO;
import com.clt.syscommon.common.table.PsoYdChgObjListVO;

/**
 * ALPS-Portsomasterdatamgt Business Logic Command Interface<br>
 *- Interface of Business Logic about Portsomasterdatamgt<br>
 *
 * @author 
 * @see Reference Ui_pso-0205EventResponse 
 * @since J2EE 1.4
 */

public interface PortTariffMgtBC {
	/**
	 * Handling retrieve event about Service Provider Help page (Pop_up)
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 */
	public List<VendorVO> searchOfficeVendor (VendorVO vendorVO) throws EventException;
	/**
	 * Operation CRUD Handling of Object List by Office
	 * @param psoObjListVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageOfficeObjectList(PsoObjListVO[] psoObjListVOs, SignOnUserAccount account)throws EventException;
	/**
	 * Retrieve Object List set by office of login user in VOP_PSO_0208 
	 * @param ofcCd
	 * @param psoObjCd
	 * @param types
	 * @return List<PsoObjListVO>
	 * @throws EventException 
	 */
	public List<PsoObjListVO> searchOfficeObjectList2(String ofcCd,
			String psoObjCd, String types) throws EventException;
	/**
	 * Retrieve Object List set by office of login user in VOP_PSO_0002
	 * @param String ofcCd
	 * @param String types
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchOfficeObjectList1(String ofcCd,
			String types) throws EventException;
	/**
	 * Retrieve Object List in VOP_PSO_0002
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchObjectListA() throws EventException;
	/**
	 * Retrieve  Object List in VOP_PSO_0209
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchObjectListAll() throws EventException;
	/**
	 * Retrieve COST CODE LIST
	 * @param String ofc_cd
	 * @return List<CostCodeVO>
	 * @throws EventException
	 */
	public List<CostCodeVO> searchCostCodeList(String ofc_cd) throws EventException;
	/**
	 * Retrieve Currency List
	 * @param String ofcCd
	 * @return List<CurrencyVO>
	 */
	public List<CurrencyVO> searchCurrencyList(String ofcCd) throws EventException;
	/**
	 * Retrieve Object List set by office of login user in VOP_PSO_0208
	 * @return List<CondtionOpertionVO>
	 */
	public List<CondtionOpertionVO> searchConditonAndOrOperator() throws EventException;
	/**
	 * Retrieve comparing operator  of condition 
	 * @return List<CondtionOpertionVO>
	 */
	public List<CondtionOpertionVO> searchConditionCompairingOperator() throws EventException;
	/**
	 * Get formula of base  tariff
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<TariffBaseVO>
	 */
	public List<TariffBaseVO> searchBaseTariff(
			PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException;
	/**
	 * Get condition of base tariff
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<ConditionVO>
	 */
	public List<ConditionVO> searchBaseCondition(
			PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException;
	/**
	 * Retrieve version Info of TariffList
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @param String uid
	 * @return List<TariffListGRPVO>
	 */
	public List<TariffListGRPVO> searchEffectiveDateList(
			PortTariffCodeGRPVO portTariffCodeGRPVO, String uid) throws EventException;

	/**
	 * Save Tariff(simple NEW) 
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void managePortChargeSimple(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException;
	/**
	 * Save Tariff(complicate NEW) 
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void managePortChargeComplex(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException; 
	/**
	 * Retrieve Object List of Office
	 * @param PsoObjListVO psoObjListVO
	 * @return List<PsoObjListVO>
	 */
	public List<PsoObjListVO> searchObjectList(PsoObjListVO psoObjListVO) throws EventException;
	/**
	 * Retrieve Object List of Office
	 * @category VOP_PSO_0208_OfficeObjectList
	 * @param String ofcCd
	 * @return	List<PsoObjListVO>
	 */
	public List<PsoObjListVO> searchOfficeObjectList(String ofcCd) throws EventException;
	/**
	 * Retrieve Object List of Office
	 * @category VOP_PSO_0210
	 * @param    UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO
	 * @return   List<UseStatusConditonFormulaDtlVO>
	 */
	public List<UseStatusConditonFormulaDtlVO> searchUseIdConditonFormulaDetail(UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO) throws EventException;

	/**
	 * Delete Tariff Info
	 * @category VOP_PSO_0002
	 * @param    PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void deletePortChargeSimple(PortTariffCodeGRPVO portTariffCodeGRPVO)throws EventException;
	/**
	 * Delete Tariff Info
	 * @category VOP_PSO_0004
	 * @param    PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void deletePortChargeComplex(PortTariffCodeGRPVO portTariffCodeGRPVO)throws EventException;
	/**Retrieve detailed Formula
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusFormulaDetaill(UseStatusConForVO useStatusConForVO)throws EventException ;
	/**Retrieve Formula
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusFormula(
			UseStatusConForVO useStatusConForVO)throws EventException ;
	/**Retrieve Condition
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusConditon(
			UseStatusConForVO useStatusConForVO) throws EventException;

	/**Retrieve Effective Date
	 * @param String combo1
	 * @param String vndrSeq
	 * @param String acctCd
	 * @param String ofcCd
	 * @return List<TariffListGRPVO>
	 */
	public List<TariffListGRPVO> searchEffectiveDateList2(String combo1,
			String vndrSeq, String acctCd, String ofcCd)throws EventException;
	/**
	 * Retrieve Tariff List(Account/Vendor/Update ID/Update Date) by Terminal 
	 * @category VOP_PSO_0036_RetrieveBtnClick 
	 * @param ydCd
	 * @param year
	 * @return
	 */
	public List<PortTariffListVO> searchPortTariffList(String ydCd, String year) throws EventException;
	
	/**
	 * Retrieve necessary Effective Date in case of Charge Creation(Creating Invoice)
	 * @category VOP_PSO_0036_VerClick
	 * @param portTariffListVO
	 * @return List<EffectiveDateListVO>
	 */
	public List<EffectiveDateListVO> searchDistinctEffectiveDateList(PortTariffListVO portTariffListVO) throws EventException;
	
	/**
	 * Retrieve necessary Version of Effective Date in case of Charge Creation(Creating Invoice)
	 * @category VOP_PSO_0036_EffDateClick
	 * @param portTariffListVO
	 * @return List<YardChargeVersionVO>
	 */
	public List<YardChargeVersionVO> searchYardChargeVersion(PortTariffListVO portTariffListVO)  throws EventException;

	/**
	 * PSO yard Charge 정보와 비교하여 조건에 따흔 Account Code를 조회한다.
	 * 
	 * @category VOP_PSO_0036_Account Code
	 * @param String ydCd
	 * @param String year
	 * @param String updMnuNo
	 * @return List<AccountAndCostVO>
	 * @throws EventException
	 */
	public List<AccountAndCostVO> searchAccountAndCostByCondition(String ydCd, String year, String updMnuNo) throws EventException;
	
	/**
	 * Retrieve Formula Info in case of Clicking Retrieve Button of Formula N' Condition Creation page
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormula(String formulaNo)  throws EventException;
	/**
	 * Retrieve Formula Info in case of Clicking Retrieve Button of Formula N' Condition Creation page (for Hidden Grid )
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormulaSys(String formulaNo)  throws EventException;
	/**
	 * Retrieve Condition Info in case of Clicking Retrieve Button of Formula N' Condition Creation page
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 * @throws EventException
	 */
	public List<FormulaVO> searchCondition(String conditionNo) throws EventException;
	/**
	 *  Retrieve Condition Info in case of Clicking Retrieve Button of Formula N' Condition Creation page (for Hidden Grid)
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param conditionNo
	 * @return  List<FormulaVO>
	 * @throws EventException
	 */
	public List<FormulaVO> searchConditionSys(String conditionNo) throws EventException;
	/**
	 * Handling in case of clicking Delete Button of Formula N' Condition Creation page
	 * @category VOP_PSO_0007_DeleteBtnClickFormula
	 * @param formulaNo
	 * @throws EventException
	 */
	public void removeFormula(String formulaNo) throws EventException;
	
	 
	/**
	 * Handling in case of clicking Delete Button of Formula N' Condition Creation page
	 * @category VOP_PSO_0007_DeleteBtnClickCondition
	 * @param conditionNo
	 * @throws EventException 
	 */
	public void removeCondition(String conditionNo) throws EventException;
	
	/**
	 * Save Formula Info
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageFormula(FormulaGRPVO formulaGRPVO) throws EventException;
	/**
	 * Save Condition Info
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageCondition(FormulaGRPVO formulaGRPVO) throws EventException;
	/**
	 * Retrieve Formula No Info in case of loading page
	 * @category VOP_PSO_0002
	 * @return  List<PsoFormulaVO> 
	 * @throws EventException
	 */	
	public List<PsoFormulaVO> searchFormulaNoForLoading() throws EventException;
	
	/**
	 * Save Condition 
	 * @param ConditionVO[] conditionVOs
	 * @return String
	 */
	public String manageConditionByPopup(ConditionVO[] conditionVOs) throws EventException;
	/**
	 * Retrieve Condition Info in case of loading page.
	 * @category VOP_PSO_0206
	 * @param 	 String condNo	
	 * @return   List<SearchTariffConditionVO>
	 * @throws   EventException
	 */		
	public List<SearchTariffConditionVO> searchTariffCondition(String condNo)  throws EventException;
	/**
	 * Retrieve  LOCAL CURRENCY by PORT_CD
	 * @param  String portCd
	 * @return String
	 * @throws EventException
	 */
	public String searchLocalCurrencyByPortCd(String portCd) throws EventException;
	/**
	 * Retrieve OBJECT 
	 * @param 	 String psoObjListTpCd
	 * @return   List<PsoObjListVO>
	 * @throws   EventException
	 */		
	public List<PsoObjListVO> searchPsoObjListByPsoObjListTpCd(String psoObjListTpCd)  throws EventException;
	/**
	 * Retrieve DFLT_VAL info by YD_CHG_NO, YD_CHG_VER_SEQ, OBJ_LIST_NO
	 * @param 	 PsoYdChgObjListVO psoYdChgObjListVO
	 * @return   List<YdChgObjVO>
	 * @throws   EventException
	 */		
	public List<YdChgObjVO> searchPsoYdChgObjListByPK(PsoYdChgObjListVO psoYdChgObjListVO)  throws EventException;
	
	/**
	 * Retrieve Vendor Info
	 * @category VOP_PSO_0211,2
	 * @param  String ydCd
	 * @param  String costCd
	 * @param  String year
	 * @param  String uid
	 * @param  String acctcd
	 * @return   List<MdmVendorVO>
	 * @throws   EventException
	 */		
	public List<MdmVendorVO> searchVendorByYardAndCost(String ydCd, String costCd, String year, String uid, String acctcd)  throws EventException;
	/**
	 * Retrieve all Account & Cost
	 * @category VOP_PSO_0037
	 * @param String ofcCd
	 * @return   List<CostCodeVO>
	 * @throws   EventException
	 */		
	public List<CostCodeVO> searchAccountAndCost(String ofcCd)  throws EventException;
	/**
	 * Retrieve Tariff Value Management
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   List<YardChargeVO>
	 * @throws   EventException
	 */		
	public List<YardChargeVO> searchYardChargeList(YardChargeVO yardChargeVO)  throws EventException;
	/**
	 * Retrieve Object by YD_CHG_NO, YD_CHG_VER_SEQ
	 * @category VOP_PSO_0037
	 * @param    YdChgObjVO ydChgObjVO
	 * @return   List<YdChgObjVO>
	 * @throws   EventException
	 */	
	public List<YdChgObjVO> searchObjByYdChg(YdChgObjVO ydChgObjVO)  throws EventException;
	/**
	 * Save Tariff Value List
	 * @param TariffValueMgtGRPVO tariffValueMgtGRPVO
	 * @throws   EventException
	 */
	public void manageTariffValue(TariffValueMgtGRPVO tariffValueMgtGRPVO) throws EventException;
	/**
	 * check validation of Expired Date 
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   String
	 * @throws   EventException
	 */		
	public String checkExpDateForTariffMgt(YardChargeVO yardChargeVO)  throws EventException;
	
	/**
	 * Retrieve Tariff List which contains PortCd and CostCd
	 * 
	 * @param String portCd
	 * @param String costCd
	 * @return List<TariffListWithYdNmVO>
	 * @exception EventException
	 */
	public List<TariffListWithYdNmVO> searchTariffWithCostCd(String portCd, String costCd) throws EventException;
	/**
	 * Retrieve Object List
	 * 
	 * @param String objNm
	 * @return List<PsoObjListVO>
	 * @exception EventException
	 */
	public List<PsoObjListVO> searchObjBasicAll(String objNm) throws EventException;
	/**
	 * Save Object List
	 * 
	 * @param PsoObjListVO[] psoObjListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageObjectList(PsoObjListVO[] psoObjListVOS, SignOnUserAccount account)  throws EventException;
}