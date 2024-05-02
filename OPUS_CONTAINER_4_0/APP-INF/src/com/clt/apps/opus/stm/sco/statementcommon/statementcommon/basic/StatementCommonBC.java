/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonBC.java
*@FileTitle : StatementCommonBC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.11
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic;

import java.util.List;

import com.clt.apps.opus.bcm.fin.financemanagement.financecreation.vo.GlEstmRevVvdVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.APCostActivityInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualCodeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualVerificationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ApplicationComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CenterListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.InterCompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationCondVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupDetailVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupHeaderVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfcWrtfTpComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.PopAccountListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RegionListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RevenuePortEachLaneVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraConversionComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoStmtCdConvVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SearchPeriodClosingInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.TesManualCancellationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.VVDListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceCondVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoBatHisVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * StatementCommonBC Logic Command implementation<br>
 * 
 * @author
 * @see StatementCommonBCImpl
 * @since J2EE 1.4
 */
public interface StatementCommonBC {
	/**
	 * [COMMON Period Closing]
	 * @author yhha
	 * @param String effYrMon
	 * @param String prdApplCd 
	 * @return List<SearchPeriodClosingInfoVO>
	 * @exception EventException
	 */
	public List<SearchPeriodClosingInfoVO> searchPeriodClosingList(String effYrMon, String prdApplCd) throws EventException;
	
	/**
	 * [COMMON Period Closing manage]
	 * @author yhha
	 * @param SearchPeriodClosingInfoVO[] SearchPeriodClosingInfoVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */	
	public void managePeriodClosingInfo (SearchPeriodClosingInfoVO[] SearchPeriodClosingInfoVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param String lu_tp_cd
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchLookupList(String lu_tp_cd) throws EventException;	
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchLookupComboList(LookupInfoVO lookupInfoVO) throws EventException;	
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchLookupComboListWithChkStartEndDate(LookupInfoVO lookupInfoVO) throws EventException;		
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchEvidenceLookupComboList(LookupInfoVO lookupInfoVO) throws EventException;


	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Retrieve Lookup Header<br>
	 *
	 * @param String lu_tp_cd
	 * @param String lu_appl_cd
	 * @return List<LookupHeaderVO>
	 * @exception EventException
	 */
	public List<LookupHeaderVO> searchLookupHeader(String lu_tp_cd, String lu_appl_cd) throws EventException;
	 
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Retrieve Lookup Detail<br>
	 *
	 * @param String h_lu_tp_cd
	 * @return List<LookupDetailVO>
	 * @exception EventException
	 */
	public List<LookupDetailVO> searchLookupDetail(String h_lu_tp_cd) throws EventException;
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Save Lookup Header	  <br>
	 * 
	 * @param LookupHeaderVO[] lookupHeaderVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLookupHeader(LookupHeaderVO[] lookupHeaderVO,SignOnUserAccount account) throws EventException;	
 
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Save Lookup Detail	  <br>
	 * 
	 * @param LookupDetailVO[] lookupDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLookupDetail(LookupDetailVO[] lookupDetailVO,SignOnUserAccount account) throws EventException;	


	/**
	 * [COMMON Applicaition Combo]
	 * [Applicaition Combo]- Application 목록을 조회<br>
	 *
	 * @return List<ApplicationComboVO>
	 * @exception EventException
	 */
	public List<ApplicationComboVO> searchApplicationCombo() throws EventException;	
	
	/**
	 * [COMMON Office Combo]
	 * [Office Combo]- Office 목록을 조회<br>
	 *
	 * @return List<OfficeComboListVO>
	 * @exception EventException
	 */
	public List<OfficeComboListVO> searchOfficeComboList() throws EventException;	
	
	/**
	 * [COMMON STM Office Info]
	 * [STM Office Information]- Retrieve Office Information<br>
	 *
	 * @param String ofc_cd
	 * @return List<OfficeInfoVO>
	 * @exception EventException
	 */
	public List<OfficeInfoVO> searchOfficeInfo(String ofc_cd) throws EventException;
	
	/**
	 * [COMMON Office Information]
	 * [STM Office Information]- Save manageOfficeInfo	  <br>
	 * by HJPARK
	 * @param OfficeInfoVO[] officeInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficeInfo(OfficeInfoVO[] officeInfoVO, SignOnUserAccount account) throws EventException;	
	
	/**
     * Company Popup<br>
     * 
     * @author MCJung 2014.04.03
     * @category STM_SCO_0051
     * @category searchPopCompanyList
     * @param String companyCode
     * @return List<CompanyListVO>
     * @throws EventException
     */    
    public List<CompanyListVO> searchPopCompanyList(String companyCode) throws EventException;
    
    /**
     * Region Popup - Retrieve <br>	
     * 	
     * @author CYJ	
     * @category STM_SCO_0052	
     * @category SearchPopRegionList	
     * @param String luCd
     * @return List<RegionListVO>	
     * @throws EventException	
     */    	
    public List<RegionListVO> searchPopRegionList(String luCd) throws EventException;	
    
    /**
     * Retrieve Center Popup
     * Cenetr List Popup<br>
     * @author JKKIL
     * @param CenterListVO centerListVO   
     * @return List<CenterListVO>
     * @throws EventException
     */    
    public List<CenterListVO> searchPopCenterListVO(CenterListVO centerListVO) throws EventException ;
    
    /**
     * Account Popup<br>
     * 
     * @author MCJung 2014.04.01
     * @category STM_SCO_0054
     * @category searchPopAccountList
     * @param String accountCode
     * @param String accountType
     * @param String unsettledFlag
     * @return List<PopAccountListVO>
     * @throws EventException
     */    
    public List<PopAccountListVO> searchPopAccountList(String accountCode, String accountType, String unsettledFlag) throws EventException; 
    
    /**
     * Account Popup<br>
     * 
     * @author Kyungsam Jo 2015.03.17
     * @category STM_SCO_0090
     * @category searchPopAccountCommonList
     * @param String accountCode
     * @param String accountType
     * @param String unsettledFlag
     * @param String lineType
     * @param String acctNm
     * @return List<PopAccountListVO>
     * @throws EventException
     */    
    public List<PopAccountListVO> searchPopAccountCommonList(String accountCode, String accountType, String unsettledFlag, String lineType, String acctNm) throws EventException;    

    
    /**
     * Inter Company Popup
     * Inter Company List Popup<br>
     * @author JKKIL
     * @param InterCompanyListVO interCompanyListVO   
     * @return List<InterCompanyListVO>
     * @throws EventException
     */    
    public List<InterCompanyListVO> searchPopInterCompanyListVO(InterCompanyListVO interCompanyListVO) throws EventException ; 
    
    /**
     * VVD Popup
     * VVD List 조회<br>
     * @param String vvd_cd   
     * @return List<VVDListVO>
     * @throws EventException
     */    
    public List<VVDListVO> searchPopVVDList(String vvd_cd) throws EventException; 
    
	/**
	 * [Ledger Code Combination]
	 * [Ledger Code Combination]- Search Ledger Code Combination	  <br>
	 * 
	 * @param LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO
	 * @return List<LedgerCodeCombinationListVO>
	 * @exception EventException
	 */
    public List<LedgerCodeCombinationListVO> searchLedgerCodeCombination( LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO) throws EventException ;
    
	/**
	 * [STM_SCO_0050]
	 * manageLedgerCodeCombination<br>
	 *
	 * @param LedgerCodeCombinationListVO[] ledgerCodeCombinationListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLedgerCodeCombination(LedgerCodeCombinationListVO[] ledgerCodeCombinationListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [STM_SCO_0050]
	 * manageLedgerCodeCombinationBiz<br>
	 *
	 * @param LedgerCodeCombinationListVO ledgerCodeCombinationListVO
	 * @param String usrId
	 * @return String[]
	 * @exception EventException
	 */
	public String[] manageLedgerCodeCombinationBiz(LedgerCodeCombinationListVO ledgerCodeCombinationListVO, String usrId) throws EventException;
	
	/**
	 * [Bank Office Combo]
	 * [Bank Office Combo]- Bank Office 목록을 조회<br>
	 *
	 * @param String mdm_ofc_cd
	 * @param String ofcEntrLvlCd
	 * @return List<OfficeComboListVO>
	 * @exception DAOException
	 */
	public List<OfficeComboListVO> searchBankOfficeComboList(String mdm_ofc_cd, String ofcEntrLvlCd) throws EventException;
	
	/**
	 * [Office Write-off Type Combo]
	 * [Office Write-off Type Combo]- Search Office Write-off Type Combo List<br>
	 *
	 * @return List<OfcWrtfTpComboListVO>
	 * @exception EventException
	 */
	public List<OfcWrtfTpComboListVO> searchOfcWrtfTpComboList() throws EventException;
	
    /**
     * [STM_SCO_0200]<br>
     * 
     * @author ORKIM
     * @category searchAPCostActivityInfoList
     * @param String src_mdl_cd
     * @param String act_cost_cd
     * @param String del_flg
     * @return List<APCostActivityInfoVO>
     * @throws EventException
     */
    public List<APCostActivityInfoVO> searchAPCostActivityInfoList(String src_mdl_cd, String act_cost_cd, String del_flg) throws EventException; 
    
	/**
	 * [STM_SCO_0200]
	 * 
	 * @author ORKIM
	 * @category manageAPCostActivityInfo
	 * @param APCostActivityInfoVO[] aPCostActivityInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException;
	 */
	public void manageAPCostActivityInfo(APCostActivityInfoVO[] aPCostActivityInfoVOs, SignOnUserAccount account) throws EventException; 	
    
	/**
	 * [SAKURA Code Conversion Combo]
	 *
	 * @return List<SakuraConversionComboVO>
	 * @exception EventException
	 */
	public List<SakuraConversionComboVO> searchSakuraConversionCombo() throws EventException;
	
	/**
	 * [SAKURA Code Conversion Info]
     * @param String luTpCd
     * @param String enblFlg
	 * @return List<ScoStmtCdConvVO>
	 * @exception EventException
	 */
	public List<ScoStmtCdConvVO> searchSakuraConversionInfo(String luTpCd, String enblFlg) throws EventException;
	
	/**
	 * SAKURA Code Conversion<br> 
	 * @author JBLEE
	 * @param ScoStmtCdConvVO[] scoStmtCdConvVOs
     * @param String usrId
	 * @exception EventException
	 */
	public void manageSakuraConversionInfo(ScoStmtCdConvVO[] scoStmtCdConvVOs, String usrId) throws EventException;
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 紐⑸줉��議고쉶<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchAcctCtnt2LookupComboList(LookupInfoVO lookupInfoVO) throws EventException;
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 紐⑸줉��議고쉶<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchAcctCtnt3LookupComboList(LookupInfoVO lookupInfoVO) throws EventException;	
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 紐⑸줉��議고쉶<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchAcctCtnt4LookupComboList(LookupInfoVO lookupInfoVO) throws EventException;
	
	/**
	 * [Revenue Port Loading Port per each lane]
	 * [Revenue Port]- 목록을 조회<br>
	 *
	 * @param String slanCd
	 * @param String rLaneCd
	 * @return List<RevenuePortEachLaneVO>
	 * @exception EventException
	 */
	public List<RevenuePortEachLaneVO> searchRevenuePortEachLaneList(String slanCd, String rLaneCd) throws EventException;
	
	/**
	 * [Revenue Port Loading Port per each lane]
	 * [Revenue Port]- 목록을 저장<br>
	 *
	 * @param RevenuePortEachLaneVO[] revenuePortEachLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRevenuePortEachLaneList(RevenuePortEachLaneVO[] revenuePortEachLaneVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Revenue Port]
	 * [Revenue Port]- Port 정보 체크<br>
	 *
	 * @param String revPortCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRevenuePort(String revPortCd) throws EventException;
	
	/**
	 * [Revenue Port]
	 * [Revenue Port]- search Tes Menual Cancellation<br>
	 *
	 * @param String exeYrmon
	 * @param String cancelFlg
	 * @param String vvd
	 * @param String ydCd 
	 * @return List<TesManualCancellationVO>
	 * @exception EventException
	 */
	public List<TesManualCancellationVO> searchTesMenualCancellation(String exeYrmon, String cancelFlg, String vvd, String ydCd ) throws EventException;
	
	/**
	 * [STM_SCO_0400]
	 * 
	 * @author ORKIM
	 * @category cancelTesMenualCancellation
	 * @param TesManualCancellationVO[] tesManualCancellationVOs
	 * @param SignOnUserAccount account
	 * @param String exeYrmon
	 * @throws EventException;
	 */
	public void cancelTesMenualCancellation(TesManualCancellationVO[] tesManualCancellationVOs, SignOnUserAccount account, String exeYrmon) throws EventException;
	 
	 /**
	 * [COMMON Period Closing Info]
	 * [Search] 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchZeroBalanceRunningList() throws EventException;
	
	/**
	 * INV_AR_STUP_OFC 조회
	 *
	 * @param String OfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchInvArOfc(String OfcCd) throws EventException;

	/**
	 * Create Miss Revenue VVD<br>
	 * 
	 * @param String missDt
	 * @param String missVvd
	 * @param String userId
	 * @param String missSlan
	 * @return GlEstmRevVvdVO
	 * @exception EventException
	 */	
	public GlEstmRevVvdVO manageMissVvd(String missDt, String missVvd, String userId, String missSlan) throws EventException;

	/**
	 * Create Migration Revenue VVD<br>
	 * 
	 * @param String migDt
	 * @param String migVvd
	 * @return GlEstmRevVvdVO
	 * @exception EventException
	 */	
	public GlEstmRevVvdVO manageMigVvd(String migDt, String migVvd) throws EventException;

	/**
	 * Create Migration Revenue VVD<br>
	 * 
	 * @param String etlJob
	 * @param String yrMon
	 * @return String
	 * @exception EventException
	 */	
	public String manageRemoteEtlJob(String etlJob, String yrMon) throws EventException;
	
	/**
	 * [Yard Name]
	 *
	 * @param String ydCd
	 * @return String
	 * @exception EventException
	 */
	public String searchYardName(String ydCd) throws EventException;	

	/**
	 * Create Accrual Data<br>
	 * 
	 * @param String jobNm
	 * @param String yrMon
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */	
	public String manageAccrualData(String jobNm, String yrMon, String userId) throws EventException;
	
	/**
	 * [STM_SCO_9999] Refresh<br>
	 * 
	 * @category searchAcclJobStatus
	 * @param String jobNm
	 * @param String yrMon
	 * @return String
	 * @exception EventException
	 */	
	public String searchAcclJobStatus(String jobNm, String yrMon) throws EventException;	
	
	/**
	 * [STM_SCO_9999] DownLoad<br>
	 * 
	 * @category manageAcclDataDownLoad
	 * @param String jobNm
	 * @param String yrMon
	 * @return List<Object>
	 * @exception EventException
	 */	
	public List<Object> manageAcclDataDownLoad(String jobNm, String yrMon) throws EventException;	
	
	/**
	 * Common searchLocalSysdate <br>
	 * 
	 * @category searchLocalSysdate
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchLocalSysdate(String ofcCd) throws EventException;		
	
 	/**
  	 * SAKURA Interface Inquiry<br> 
  	 * 
  	 * @param SakuraInterfaceCondVO sakuraInterfaceCondVO
  	 * @return List<SakuraInterfaceListVO>
  	 * @exception EventException
  	 */
	public List<SakuraInterfaceListVO> searchSakuraInterfaceList(SakuraInterfaceCondVO sakuraInterfaceCondVO) throws EventException;

	/**
	 * [Office Adjustment Type Combo]
	 * [Office Adjustment Type Combo]- Search Office Adjustment Type Combo List<br>
	 *
	 * @return List<OfcWrtfTpComboListVO>
	 * @exception EventException
	 */
	public List<OfcWrtfTpComboListVO> searchOfcAdjustTpComboList()
			throws EventException;
	
	
	/**
	 * search SCO_BAT_HIS_SEQ.NEXTVAL <br>
	 * 
	 * @return String
	 * @exception EventException
	 */	
	public String searchScoBatHisNextSeq() throws EventException;	
	
	
	/**
	 * create SCO_BAT_HIS <br>
	 * 
	 * @param ScoBatHisVO scoBatHisVO
	 * @exception EventException
	 */	
	public void addScoBatHis(ScoBatHisVO scoBatHisVO) throws EventException;		
	
	/**
	 * search SCO_BAT_HIS <br>
	 * 
	 * @param String batSeq
	 * @return ScoBatHisVO
	 * @exception EventException
	 */	
	public ScoBatHisVO searchScoBatHis(String batSeq) throws EventException;	
	
	/**
	 * update SCO_BAT_HIS <br>
	 * 
	 * @param ScoBatHisVO scoBatHisVO
	 * @return int
	 * @exception EventException
	 */	
	public int modifyScoBatHis(ScoBatHisVO scoBatHisVO) throws EventException;	
	
	/**
	 * Monthly TES/TRS/COST Accrual Verification BackEndJob
	 * 2016.12.21 Add
	 * 
	 * @param accrualVerificationVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String searchMonthlyAccrualVerificationBackEndJob(AccrualVerificationVO accrualVerificationVO, SignOnUserAccount account) throws EventException;

	
    /**
  	 * Monthly Accrual Code List : T- Trade/ A - Account, P - Profit Center, S - sakura Account
	 * 2016.12.21 Add
  	 * 
  	 * @param String codeTpCd
  	 * @param AccrualVerificationVO accrualVerificationVO
  	 * @return List<AccrualCodeInfoVO>
  	 * @exception EventException
  	 */
	public List<AccrualCodeInfoVO> searchMonthlyAccrualCodeList(String codeTpCd, AccrualVerificationVO accrualVerificationVO) throws EventException;
}
