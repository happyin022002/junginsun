/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : porttariffmgtBC.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.28 김진일
* 1.0 Creation
*
* History
* 2010.11.24 CHM-201006949-01 박희동 특정 Tariff가 존재하는 Yard List를 조회한다.
* 2011.07.28 CHM-201111838-01 진마리아 Split 21-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 // 태깅을 위해 일부 소스 원복처리
* 2011.07.28 CHM-201112475-01 김기종 [VOP_PSO] Port Tariff Inquiry 메뉴 수정 요청건
* 2014.03.12 CHM-201429104-01 박다은 [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
* 2014.03.19 CHM-201428969 최문환  [PSO] Port tariff Inquiry - 조회조건 및 화면 변경
* 2014.07.16 CHM-201430928 이성훈  [PSO] Port Tariff Contract 및 URL 저장
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CondtionOpertionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CostCodeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CurrencyVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.EffectiveDateListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchTariffConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffAtchFileVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVersionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgNoDataInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.PsoFormulaVO;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;
import com.hanjin.syscommon.common.table.PsoYdChgObjListVO;

/**
 * ALPS-Portsomasterdatamgt Business Logic Command Interface<br>
 * - ALPS-Portsomasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jin Ihl
 * @see Ui_pso-0205EventResponse 참조
 * @since J2EE 1.4
 */

public interface PortTariffMgtBC {
	/**
	 * Service Provier Help화면(팝업)  대한 조회 이벤트처리 
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 */
	public List<VendorVO> searchOfficeVendor (VendorVO vendorVO) throws EventException;
	/**
	 * Office별 Object List의 CRUD처리 오퍼레이션
	 * @param psoObjListVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageOfficeObjectList(PsoObjListVO[] psoObjListVOs, SignOnUserAccount account)throws EventException;
	/**
	 * VOP_PSO_0208에서 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @param ofcCd
	 * @param psoObjCd
	 * @param types
	 * @return List<PsoObjListVO>
	 * @throws EventException 
	 */
	public List<PsoObjListVO> searchOfficeObjectList2(String ofcCd,
			String psoObjCd, String types) throws EventException;
	/**
	 * VOP_PSO_0002에서 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @param String ofcCd
	 * @param String types
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchOfficeObjectList1(String ofcCd,
			String types) throws EventException;
	/**
	 * VOP_PSO_0002에서 Object List를 조회한다.
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchObjectListA() throws EventException;
	/**
	 * VOP_PSO_0209에서 Object List를 조회한다.
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchObjectListAll() throws EventException;
	/**
	 * COST CODE LIST를 조회한다.
	 * @param String ofc_cd
	 * @return List<CostCodeVO>
	 * @throws EventException
	 */
	public List<CostCodeVO> searchCostCodeList(String ofc_cd) throws EventException;
	/**
	 * Currency 리스트를 조회
	 * @param String ofcCd
	 * @return List<CurrencyVO>
	 */
	public List<CurrencyVO> searchCurrencyList(String ofcCd) throws EventException;
	/**
	 * VOP_PSO_0208에서 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @return List<CondtionOpertionVO>
	 */
	public List<CondtionOpertionVO> searchConditonAndOrOperator() throws EventException;
	/**
	 * condition 의 비교 연산자를 조회한다.
	 * @return List<CondtionOpertionVO>
	 */
	public List<CondtionOpertionVO> searchConditionCompairingOperator() throws EventException;
	/**
	 * base tariff의 formula를 가져온다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<TariffBaseVO>
	 */
	public List<TariffBaseVO> searchBaseTariff(
			PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException;
	/**
	 * base tariff의 condition를 가져온다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<ConditionVO>
	 */
	public List<ConditionVO> searchBaseCondition(
			PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException;
	/**
	 * TariffList의 version 정보를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @param String uid
	 * @return List<TariffListGRPVO>
	 */
	public List<TariffListGRPVO> searchEffectiveDateList(
			PortTariffCodeGRPVO portTariffCodeGRPVO, String uid) throws EventException;

	/**
	 * Tariff(단순 NEW) 저장
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void managePortChargeSimple(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException;
	/**
	 * Tariff(복잡 NEW) 저장
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void managePortChargeComplex(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException;
	/**
	 * Office의 Object List를 조회한다.
	 * @param PsoObjListVO psoObjListVO
	 * @return List<PsoObjListVO>
	 */
	public List<PsoObjListVO> searchObjectList(PsoObjListVO psoObjListVO) throws EventException;
	/**
	 * Office의 Object List를 조회한다.
	 * @category VOP_PSO_0208_OfficeObjectList
	 * @param String ofcCd
	 * @return	List<PsoObjListVO>
	 */
	public List<PsoObjListVO> searchOfficeObjectList(String ofcCd) throws EventException;
	/**
	 * Office의 Object List를 조회한다.
	 * @category VOP_PSO_0210
	 * @param    UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO
	 * @return   List<UseStatusConditonFormulaDtlVO>
	 */
	public List<UseStatusConditonFormulaDtlVO> searchUseIdConditonFormulaDetail(UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO) throws EventException;

	/**
	 * Tariff 정보를 삭제한다.
	 * @category VOP_PSO_0002
	 * @param    PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void deletePortChargeSimple(PortTariffCodeGRPVO portTariffCodeGRPVO)throws EventException;
	/**
	 * Tariff 정보를 삭제한다.
	 * @category VOP_PSO_0004
	 * @param    PortTariffCodeGRPVO portTariffCodeGRPVO
	 */
	public void deletePortChargeComplex(PortTariffCodeGRPVO portTariffCodeGRPVO)throws EventException;
	/**상세Formula를 조회합니다.
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusFormulaDetaill(UseStatusConForVO useStatusConForVO)throws EventException ;
	/**Formula를 조회합니다.
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusFormula(
			UseStatusConForVO useStatusConForVO)throws EventException ;
	/**Condition을 조회합니다.
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusConditon(
			UseStatusConForVO useStatusConForVO) throws EventException;

	/**Effective Date를 조회합니다.
	 * @param String combo1
	 * @param String vndrSeq
	 * @param String acctCd
	 * @param String ofcCd
	 * @return List<TariffListGRPVO>
	 */
	public List<TariffListGRPVO> searchEffectiveDateList2(String combo1,
			String vndrSeq, String acctCd, String ofcCd)throws EventException;
	/**
	 * Terminal 별로  Tariff List(Account/Vendor/Update ID/Update Date)를 조회함
	 * @category VOP_PSO_0036_RetrieveBtnClick 
	 * @param ydCd
	 * @param year
	 * @param acctCd
	 * @return
	 */
	public List<PortTariffListVO> searchPortTariffList(String ydCd, String year, String acctCd) throws EventException;
	
	/**
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)를 조회한다.
	 * @category VOP_PSO_0036_VerClick
	 * @param portTariffListVO
	 * @return List<EffectiveDateListVO>
	 */
	public List<EffectiveDateListVO> searchDistinctEffectiveDateList(PortTariffListVO portTariffListVO) throws EventException;
	
	/**
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)의 Version 을 조회한다.
	 * @category VOP_PSO_0036_EffDateClick
	 * @param portTariffListVO
	 * @return List<YardChargeVersionVO>
	 */
	public List<YardChargeVersionVO> searchYardChargeVersion(
			PortTariffListVO portTariffListVO)  throws EventException;

	/**
	 * PSO yard Charge 정보와 비교하여 조건에 따흔 Account Code를 조회한다.
	 * @category VOP_PSO_0036_Account Code
	 * @param  String ydCd
	 * @param  String year
	 * @return List<AccountAndCostVO>
	 * @throws EventException
	 */
	public List<AccountAndCostVO> searchAccountAndCostByCondition(String ydCd, String year) throws EventException;
	
	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Formula 정보 조회 
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormula(String formulaNo)  throws EventException;
	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Formula 정보 조회 (Hidden Grid 용)
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormulaSys(String formulaNo)  throws EventException;
	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Condition 정보 조회 
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 * @throws EventException
	 */
	public List<FormulaVO> searchCondition(String conditionNo) throws EventException;
	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Condition 정보 조회 (Hidden Grid 용)
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param conditionNo
	 * @return  List<FormulaVO>
	 * @throws EventException
	 */
	public List<FormulaVO> searchConditionSys(String conditionNo) throws EventException;
	/**
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	 * @category VOP_PSO_0007_DeleteBtnClickFormula
	 * @param formulaNo
	 * @throws EventException
	 */
	public void removeFormula(String formulaNo) throws EventException;
	
	 
	/**
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	 * @category VOP_PSO_0007_DeleteBtnClickCondition
	 * @param conditionNo
	 * @throws EventException 
	 */
	public void removeCondition(String conditionNo) throws EventException;
	
	/**
	 * Formula 정보를 저장한다. 
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageFormula(FormulaGRPVO formulaGRPVO) throws EventException;
	/**
	 * Condition 정보를 저장한다.
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageCondition(FormulaGRPVO formulaGRPVO) throws EventException;
	/**
	 * Formula No 정보를 조회한다.
	 * @category VOP_PSO_0002_페이지로딩시
	 * @return  List<PsoFormulaVO> 
	 * @throws EventException
	 */	
	public List<PsoFormulaVO> searchFormulaNoForLoading() throws EventException;
	
	/**
	 * Condition 저장
	 * @param ConditionVO[] conditionVOs
	 * @return String
	 */
	public String manageConditionByPopup(ConditionVO[] conditionVOs) throws EventException;
	/**
	 * Condition 정보를 조회한다.
	 * @category VOP_PSO_0206_페이지로딩시
	 * @param 	 String condNo	
	 * @return   List<SearchTariffConditionVO>
	 * @throws   EventException
	 */		
	public List<SearchTariffConditionVO> searchTariffCondition(String condNo)  throws EventException;
	/**
	 * PORT_CD로 LOCAL CURRENCY를 조회한다.
	 * @param  String portCd
	 * @return String
	 * @throws EventException
	 */
	public String searchLocalCurrencyByPortCd(String portCd) throws EventException;
	/**
	 * OBJECT 정보를 조회한다.
	 * @category VOP_PSO_0004_페이지로딩시
	 * @param 	 String psoObjListTpCd
	 * @return   List<PsoObjListVO>
	 * @throws   EventException
	 */		
	public List<PsoObjListVO> searchPsoObjListByPsoObjListTpCd(String psoObjListTpCd)  throws EventException;
	/**
	 * YD_CHG_NO, YD_CHG_VER_SEQ, OBJ_LIST_NO 별 DFLT_VAL 정보를 조회한다.
	 * @category VOP_PSO_0004_조회시
	 * @param 	 PsoYdChgObjListVO psoYdChgObjListVO
	 * @return   List<YdChgObjVO>
	 * @throws   EventException
	 */		
	public List<YdChgObjVO> searchPsoYdChgObjListByPK(PsoYdChgObjListVO psoYdChgObjListVO)  throws EventException;
	
	/**
	 * [PSO_YD_CHD] Vendor 정보를 조회한다.
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
	 * 모든 Account & Cost를 조회한다.
	 * @category VOP_PSO_0037
	 * @return   List<AccountAndCostVO>
	 * @throws   EventException
	 */		
	public List<AccountAndCostVO> searchAccountAndCost()  throws EventException;
	/**
	 * Tariff Value Management를 조회한다.
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   List<YardChargeVO>
	 * @throws   EventException
	 */		
	public List<YardChargeVO> searchYardChargeList(YardChargeVO yardChargeVO)  throws EventException;
	/**
	 * YD_CHG_NO, YD_CHG_VER_SEQ별로 Object를 조회한다.
	 * @category VOP_PSO_0037
	 * @param    YdChgObjVO ydChgObjVO
	 * @return   List<YdChgObjVO>
	 * @throws   EventException
	 */	
	public List<YdChgObjVO> searchObjByYdChg(YdChgObjVO ydChgObjVO)  throws EventException;
	/**
	 * Tariff Value List를 저장합니다.
	 * @param TariffValueMgtGRPVO tariffValueMgtGRPVO
	 * @throws   EventException
	 */
	public void manageTariffValue(TariffValueMgtGRPVO tariffValueMgtGRPVO) throws EventException;
	/**
	 * Expired Date 유효성 체크
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   String
	 * @throws   EventException
	 */		
	public String checkExpDateForTariffMgt(YardChargeVO yardChargeVO)  throws EventException;
	/**
	 * Invoice Count 유효성 체크
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   String
	 * @throws   EventException
	 */		
	public String getInvCnt(YardChargeVO yardChargeVO)  throws EventException;
	/**
	 * Tariff 정보를 삭제한다.
	 * @param yardChargeVO
	 * @throws EventException
	 */
	public void deleteTariffAttribute(YardChargeVO yardChargeVO)throws EventException;
	/**
	 * Tariff upload file 을 조회합니다.
	 * @category VOP_PSO_0041 
	 * @param TariffAtchFileVO tariffAtchFileVO
	 * @return List<PsoTrfAtchFileVO>
	 * @throws EventException
	 */	
	public List<PsoTrfAtchFileVO> searchPsoTrfAtchFileList(TariffAtchFileVO tariffAtchFileVO) throws EventException;	
	/**
	 * Tariff upload file 을 저장합니다.
	 * @category VOP_PSO_0041
	 * @param TariffAtchFileVO tariffAtchFileVO
	 * @throws EventException
	 */	
	public void manageTariffUploadFile(TariffAtchFileVO tariffAtchFileVO) throws EventException;
	/**
	 * VNDR_SEQ로 CURRENCY를 조회한다.
	 * @category VOP_PSO_0004
	 * @param  String vndrSeq
	 * @return String
	 * @throws EventException
	 */
	public String searchCurrencyByVndrSeq(String vndrSeq) throws EventException;	
	/**
	 * Yard Charge에 등록된 Remark를 조회한다.
	 * @category VOP_PSO_0042
	 * @param  PortTariffListVO portTariffListVO
	 * @return List<YardChargeVersionVO>
	 * @throws EventException
	 */	
	public List<YardChargeVersionVO> searchYardChargeRemark(PortTariffListVO portTariffListVO) throws EventException;	
	/**
	 * Formula 정보를 저장한다. 
	 * @category VOP_PSO_0007_Auto ID_ClickFormula
	 * @return String
	 * @throws EventException
	 */
	public String autoCreateFormula() throws EventException;
	/**
	 * Formula 정보를 저장한다. 
	 * @category VOP_PSO_0007_Auto ID_ClickCondition
	 * @return String
	 * @throws EventException
	 */
	public String autoCreateCondition() throws EventException;
	
	/**
	 * Yard Charge에 등록된 Remark를 조회한다.
	 * @category VOP_PSO_0237
	 * @param  YdChgNoDataInfoVO ydChgNoDataInfoVO
	 * @return List<ydChgNoDataInfoVO>
	 * @throws EventException
	 */	
	public List<YdChgNoDataInfoVO> searchYdChgNoDataInfo(YdChgNoDataInfoVO ydChgNoDataInfoVO) throws EventException;	
	
	/**
	 * Yard Charge에 등록된 tariff를 copy한다
	 * @category VOP_PSO_0237
	 * @param  YdChgNoDataInfoVO[] ydChgNoDataInfoVOs
     * @param  SignOnUserAccount account
     * @param  String newYdCd
	 * @throws EventException
	 */	
	public void copyTariff(YdChgNoDataInfoVO[] ydChgNoDataInfoVOs,SignOnUserAccount account , String newYdCd) throws EventException;
	
//	/**
//	 * vendor 로  tariff 존재 여부 확인
//	 * @category VOP_PSO_0237
//	 * @param  String vndrSeq
//	 * @return String
//	 * @throws EventException
//	 */	
//	public String searchVendorTariffCheck(String vndrSeq) throws EventException;
	
	/**
	 *  ydCd 존재 여부 확인
	 * @category VOP_PSO_0237
	 * @param  String ydCd
	 * @return String
	 * @throws EventException
	 */	
	public String searchMdmYardCheck(String ydCd) throws EventException;
	
	/**
	 *  ydCd 존재 여부 확인
	 * @category VOP_PSO_0237
     * @param  YdChgNoDataInfoVO[] ydChgNoDataInfoVOs
	 * @param  String newYdCd
	 * @throws EventException
	 */
	public void validationTariff(YdChgNoDataInfoVO[] ydChgNoDataInfoVOs, String newYdCd) throws EventException;
	
	
	//	/*
//	 * CHM-201006949-01
//	 */
//	/**
//	 * 해당 PortCd와 CostCd를 가지는 Tariff List를 조회한다.
//	 * 
//	 * @param String portCd
//	 * @param String costCd
//	 * @return List<TariffListWithYdNmVO>
//	 * @exception EventException
//	 */
//	public List<TariffListWithYdNmVO> searchTariffWithCostCd(String portCd, String costCd) throws EventException;
}