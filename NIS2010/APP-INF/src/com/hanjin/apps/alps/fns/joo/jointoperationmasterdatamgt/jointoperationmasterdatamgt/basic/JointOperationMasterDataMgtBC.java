/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtBC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.24 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AdditionalSlotManageVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BlkVygSttsVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaCarrieHistoryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaInformationEntryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BzcAgmtCrrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooStlBssPortVO;
import com.hanjin.syscommon.common.table.JooStlVvdVO;

/**
 * ALPS-Jointoperationmasterdatamgt Business Logic Command Interface<br>
 * - ALPS-Jointoperationmasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Hee Dong
 * @see Ui_joo_0028EventResponse 참조
 * @since J2EE 1.4
 */

public interface JointOperationMasterDataMgtBC {
	/**
	 * Account Item List 조회
	 * @return List<STLItemAcctVO>
	 * @throws EventException
	 */
	public List<STLItemAcctVO> searchSTLItemAcctList() throws EventException;
	
	/**
	 * Settlement Item 정보를 저장한다. 
	 * @param STLItemAcctVO[] sTLItemAcctVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageSTLItemAcct(STLItemAcctVO[] sTLItemAcctVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Financial Matrix를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO searchCarFinancialMtrxList(CarrierVO carrierVO) throws EventException;

	/**
	 * Financial Matrix를 생성하기 위해 존재하지 않는 Settlement Item을 조회한다.
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO calCarFinancialMtrx(CarrierVO carrierVO) throws EventException;

	/**
	 * Financial Matrix를 저장한다.
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarFinancialMtrx(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Settlement Pic를 저장한다.
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void managePic(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException;	

	/**
	 * Financial Matrix를 저장한다.(Change Ofc 버튼 실행시) 
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarFinancialMtrxChgOfc(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException;
	
	
	/**
	 * Carrier Merge 정보를 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @return List<JooCrrMrgVO>
	 * @throws EventException
	 */
	public List<JooCrrMrgVO> searchCarrierMerge(MstComInputVO mstComInputVO) throws EventException;
	
	/**
	 * Carrier Merge정보를 저장한다.
	 * @param JooCrrMrgVO[] jooCrrMrgVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarrierMerge(JooCrrMrgVO[] jooCrrMrgVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Carrier의 Vendor/Customer 정보를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<CarrierVO> searchVndrCustListByCar(CarrierVO carrierVO) throws EventException;
	
	/**
	 * Basic Port List를 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @param String lsAbbr
	 * @param String lsDir
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchSettlementBasicPortList(MstComInputVO mstComInputVO, String lsAbbr, String lsDir) throws EventException;
	
	/**
	 * Basic Port를 저장한다.
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageSettlementBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Copy된 자료가 중복되는 경우 사용자의 Confirm을 받아 삭제 후 재 생성한다.
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCopyBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException;	
	
	/**
	 * Basic Port를 생성하기 위해 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchItemDirList(MstComInputVO mstComInputVO) throws EventException;

	/**
	 * Target VVD를 조회한다. 
	 * @param TargetVVDVO targetVVDVO
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> searchTargetVVDList(TargetVVDVO targetVVDVO) throws EventException;

	/**
	 * Target VVD를 생성하기위해 조회한다.
	 * @param TargetVVDVO targetVVDVO
	 * @param String joStlOptCd
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> createTargetVVDList(TargetVVDVO targetVVDVO, String joStlOptCd) throws EventException;
	
	/**
	 * Target VVD를 저장한다.
	 * 
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlVvdVO>
	 * @throws EventException
	 */
	public List<JooStlVvdVO> manageTargetVVD(JooStlVvdVO[] jooStlVvdVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Target VVD에서 OUS인 경우 jo_mnu_nm을 Basis Port 의 jo_stl_tgt_tp_cd에서 조회한다. (TDR/RDR)
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws EventException
	 */
	public List<JooStlVvdVO> searchOusTdrRdrInBssPort(JooStlVvdVO jooStlVvdVO) throws EventException;

	/**
	 * Settlement시 JOO_STL_VVD의 PROC_JB_FLG를 Y로 UPDATE한다.
	 * 삭제시에는 최종 settlement삭제시 N으로 UPDATE한다. 
	 * @param ProcSettlementVO[] procSettlementVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageTargetVVDForSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
    /**
     * Authority Office Creation 의 권한정보를 조회  합니다
     * @param  AuthorityOfficeVO authorityOfficeVO
     * @return List<AuthorityOfficeVO>
     * @throws EventException
     */
    public List<AuthorityOfficeVO> searchAuthorityOffice(AuthorityOfficeVO authorityOfficeVO) throws EventException;
		
	
    /**
     * Authority Office Creation 의 지역 권한정보를 저장  합니다.<br>
     * 
     * @param  AuthorityOfficeVO[] authorityOfficeVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @author jang kang cheol
     */
	public void manageAuthorityOffice(AuthorityOfficeVO[] authorityOfficeVOs, SignOnUserAccount signOnUserAccount) throws EventException;
 
	
    /**
     * S/H Adjustment시 Target VVD에 없는 VVD는 강제 생성한다.
     * @param AdjustSettlementVO[] adjustSettlementVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageTargetVVDForAdjustment(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Target VVD의 Close여부 조회
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCloseYn(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * Target VVD를 삭제한다.
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @throws EventException
	 */
	public void removeTargetVVD(JooStlVvdVO[] jooStlVvdVOs) throws EventException;
	
    /**
     * Office Mapping 정보 조회 합니다
     * @param  CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO
     * @return List<CustomSearchOfficeMappingManagementVO>
     * @throws EventException
     */
    public List<CustomSearchOfficeMappingManagementVO> searchOfficeMappingManagementList(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws EventException;

    /**
     * Office Mapping 정보를 저장 합니다.<br>
     * 
     * @param  CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     * @author Jong Kyu Weon
     */
	public String manageOfficeMappingManagement(CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * JOO_BZC_AGMT를 저장한다.
	 * @param CusBzcAgmtVO[] cusBzcAgmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String manageJooBzcAgmt(CusBzcAgmtVO[] cusBzcAgmtVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	
	/**
	 * Business Agreement list를 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws EventException
	 */
	public List<CusBzcAgmtVO> searchJooBzcAgmtList(CusBzcAgmtVO cusBzcAgmtVO) throws EventException ;

	/**
	 * Business Agreement Ref No list를 조회한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRefNoList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * 같은 OFFICE, R/E, TRADE, RLANE 인 경우 PERIOD가 같으므로 조회하여 Setting한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws EventException
	 */
	public List<CusBzcAgmtVO> searchRefNoNPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws EventException;	
		
	/**
	 * Add Carriers list를 조회한다.
	 * @param BzcAgmtCrrVO bzcAgmtCrrVO
	 * @return List<BzcAgmtCrrVO>
	 * @throws EventException
	 */
	public List<BzcAgmtCrrVO> searchAddCarriersList(BzcAgmtCrrVO bzcAgmtCrrVO) throws EventException ;
	

	/**
	 * Add Carriers를 저장한다.
	 * @param BzcAgmtCrrVO[] bzcAgmtCrrVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String 
	 * @throws EventException   
	 */
	public String addCarriersList(BzcAgmtCrrVO[] bzcAgmtCrrVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * BSA Information Entry를 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryList(BsaInformationEntryVO bsaInformationEntryVO) throws EventException;
	
	/**
	 * YYYY-WW, Date 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationYyyyWwDt(BsaInformationEntryVO bsaInformationEntryVO) throws EventException;
	
	/**
	 * BSA Information Entry를 조회한다.  Target Excel을 위한 조회
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryListForTargetExcel(BsaInformationEntryVO bsaInformationEntryVO) throws EventException;
	
	/**
	 * BSA Information Entry 신규입력 저장 한다.
	 *
	 * @param BsaInformationEntryVO[] bsaInformationEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBsaInformationEntryList(BsaInformationEntryVO[] bsaInformationEntryVOs, SignOnUserAccount account) throws EventException;
	/**
	 * BSA Information Entry 신규입력 저장 한다.
	 *
	 * @param BsaInformationEntryVO[] bsaInformationEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAddCarrierList(BsaInformationEntryVO[] bsaInformationEntryVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * BSA Information Entry History를 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryHistoryList(BsaInformationEntryVO bsaInformationEntryVO) throws EventException;
	
	

	/**
	 * BSA Information Entry Add Carrier를 조회한다.
	 * @param BsaCarrieHistoryVO bsaCarrieHistoryVO
	 * @return List<BsaCarrieHistoryVO>
	 * @throws EventException
	 */
	public List<BsaCarrieHistoryVO> searchAddBsaCarrieList(BsaCarrieHistoryVO bsaCarrieHistoryVO) throws EventException;
	

	/**
	 * BSA Information Entry Add Carrier를 신규입력 등록 한다.
	 *
	 * @param BsaCarrieHistoryVO bsaCarrieHistoryVO
	 * @param BsaCarrieHistoryVO[] bsaCarrieHistoryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAddBsaCarrieList(BsaCarrieHistoryVO bsaCarrieHistoryVO, BsaCarrieHistoryVO[] bsaCarrieHistoryVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Additional Slot Manage 정보를 조회한다.
	 * @param AdditionalSlotManageVO additionalSlotManageVO
	 * @return List<additionalSlotManageVO>
	 * @throws EventException
	 */
	public List<AdditionalSlotManageVO> searchAdditionalSlotManage(AdditionalSlotManageVO additionalSlotManageVO) throws EventException;

	/**
	 * Additional Slot Manage정보를 저장한다.
	 * @param AdditionalSlotManageVO[] additionalSlotManageVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageAdditionalSlotManage(AdditionalSlotManageVO[] additionalSlotManageVOs, SignOnUserAccount signOnUserAccount) throws EventException;

    /**
     * FNS_JOO_0095: SAVE
     * D : [FnsJoo0095Event]<br>
     * Blank Voyage Status 데이터를 JOO_CMPN_AGMT 에 저장, Update  처리 합니다.<br>
     * 
     * @param BlkVygSttsVO[] blkVygSttsVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @author Kim Hyun Joo
     */
    public void manageBlankVoyageStatus(BlkVygSttsVO[] blkVygSttsVOs, SignOnUserAccount signOnUserAccount) throws EventException;
    
    
    /**
     * FNS_JOO_0095: Retrieve
     * D : [FnsJoo0095Event]<br>
     * Blank Voyage Status 데이터를 JOO_CMPN_AGMT 에서 Retrieve 합니다.<br>
     * 
     * @param BlkVygSttsVO blkVygSttsVO
     * @return List<BlkVygSttsVO>
     * @throws EventException
     * @author Kim Hyun Joo
     */   
    public List<BlkVygSttsVO> searchBlankVoyageStatus(BlkVygSttsVO blkVygSttsVO) throws EventException;
}