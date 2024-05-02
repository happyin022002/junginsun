/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : eqrcommonBC.java
*@FileTitle : retrieving for  Max UPD_USR_ID , UPD_DT
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrWkPrdVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Eqrcommon Business Logic Command Interface<br>
 *
 * @author 
 * @see EqrcommonEesCommonVO
 * @since J2EE 1.6
 */

public interface CommonBC {

	/**
	 * retiriving for ECC Information convertiong
	 * @param loctype  String 
	 * @param location String 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO convertECCInfo(String loctype, String location) throws EventException;
	
	/**
	 * retrieving for Scnr_id Remark, SCNR_AUTO_GEN_FLG, REPO_PLN_CRE_FLG, REPO_PLN_DTRB_FLG
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO scnridReMarkSearch
	 * @exception EventException
	 */	
	public EesCommonVO scnridReMarkSearch (EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for weeklyCondition
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO weeklyConditionSearch
	 * @exception EventException
	 */	
	public EesCommonVO weeklyConditionSearch(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for ECC Information converting<br>
	 * @param loctype  String 
	 * @param location String 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */		
    public CommonVO convertECCInfoString(String loctype, String location) throws EventException;
    
	/**
	 * retrieving for MAX UPD_USR_ID, UPD_DT <br>
	 * @param table     String 
	 * @param condition String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		    
	public CommonVO searchMaxInfo(String table, String condition) throws EventException;
	
	/**
	 * retrieving for CheckFlg  <br>
	 * @param scnr_id String 
	 * @return String searchADRflg
	 * @exception EventException
	 */		    	
	public CommonVO searchADRflg(String scnr_id) throws EventException;
	
	/**
	 * retrieving for min week of current year, max week of last year when current week is the first week of the year<br>
	 * @param curYear String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		 	
	public CommonVO minMax01(String curYear) throws EventException;
	
	/**
	 * retrieving for max week of current year, min week of last year when current week is the last week of the year <br>
	 * @param curYear String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		 		
	public CommonVO maxMin52(String curYear) throws EventException;

	/**
	 * retrieving for min week = 01, max week = 53<br>
	 * @param curYear String 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		 	
	public CommonVO getMinMaxWeek(String curYear) throws EventException;

	/**
	 * retrieving for repo_plan_id Remark, SCNR_AUTO_GEN_FLG, REPO_PLN_CRE_FLG, REPO_PLN_DTRB_FLG
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO repoidReMarkSearch
	 * @exception EventException
	 */	
	public EesCommonVO repoidReMarkSearch (EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * modifying REPO_RMK  <br>
	 * @param repoId  String 
	 * @param repoRmk String 
	 * @param usrId   String 
	 * @return CommonVO isResultBoolean()
	 * @exception EventException
	 */		
	public CommonVO modifyRepoRmk(String repoId, String repoRmk, String usrId) throws EventException;
	
	/**
	 * retrieving for Week  <br>
	 * @param year String 
	 * @return CommonVO getList()
	 * @exception EventException
	 */		
	public CommonVO searchWeek(String year) throws EventException;
	
	/**
	 * checking ecc code <br>
	 * @param ecc_cd String
	 * @return CommonVO
	 * @exception EventException
	 */			
	public EesCommonVO checkEccCode(String ecc_cd) throws EventException;

	/**
	 * checking LocCode <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */		
	public EesCommonVO checkLocCode(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * checking LocCodeWithMaster <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO checkLocCodeWithMaster
	 * @exception EventException
	 */	
	public EesCommonVO checkLocCodeWithMaster(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * modifying SCNR_RMK  <br>
	 * @param scnrId String 
	 * @param scnrRmk String 
	 * @param usrId String 
	 * @return CommonVO isResultBoolean()
	 * @exception EventException
	 */	
	public CommonVO modifyScnrRmk(String scnrId, String scnrRmk, String usrId) throws EventException;

	/**
	 * retrieving for month info<br>
	 * @param conStr String[] 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */	
	public CommonVO tiltelMakMonth(String[] conStr) throws EventException;
	
	/**
	 * retrieving for week info <br>
	 * @param conStr String[] 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */		
	public CommonVO tiltelMakWeek(String[] conStr) throws EventException;
	
	/**
	 * counting weeks in the month <br>
	 * @param conStr String[] 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */			
	public CommonVO monthCount(String[] conStr) throws EventException;

	/**
	 * retrieving for LOC YARD Exist <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardExist(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for LOC YARD Company Exist <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardCompanyExist(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for LOC YARD <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	
	/**
	 * retrieving for LOC YARD <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchEccYardInfo(EesCommonConditionVO conditionVO) throws EventException; 
	
	
	/**
	 * retrieving for LOC YARD <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocByYardInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for LOC YARD<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardCompanyInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardCompanyInfo(EesCommonConditionVO conditionVO) throws EventException;	
	
	/**
	 * retrieving for LOC YARD(vessel)<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardVesselInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for LOC YARD INITIAL<br>
	 * @param EesCommonConditionVO conditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	
	/**
	 * retrieving for LOC YARD INITIAL<br>
	 * @param EesCommonConditionVO conditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardDischargeInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for lessor YARD<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLseCoYardInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for LOC YARD-ECC<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardEccInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardEccInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	
	/**
	 * retrieving for LOC YARD-ECC<br>
	 * @param conditionVO EesCommonConditionVO
	 * @param account SignOnUserAccount
	 * @return EesCommonVO searchLocYardEccInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchEqrLocYardEccInfo(EesCommonConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * retrieving for LOC YARD-LCC<br>
	 * @param conditionVO EesCommonConditionVO
	 * @param account SignOnUserAccount
	 * @return EesCommonVO searchLocYardEccInfo
	 * @exception EventException
	 */			
	public String searchEqrLocYardLccInfo(EesCommonConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving for VENDOR
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVendorInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchVendorInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for VENDOR
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVendorInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchVendorInfoBySeq(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for VVD<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVvdInfo
	 * @exception EventException
	 */				
	public EesCommonVO searchVvdInfo(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for vvd combo box
	 * in Fixed Plan of Execute Plan Inland, click Row Add, retrieving for To LOC(ECC), ETA Week
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVvdInlandInfo
	 * @exception EventException
	 */
	public EesCommonVO searchVvdInlandInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for VVD<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchVvdInfo
	 * @exception EventException
	 */				
	public EesCommonVO searchVvdExist(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for Scnr_id on the week<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchWeekScnrId
	 * @exception EventException
	 */			
	public EesCommonVO searchWeekScnrId(EesCommonConditionVO conditionVO) throws EventException;

	/**
	 * retrieving for Country<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCountryInfo
	 * @exception EventException
	 */		
	public EesCommonVO searchCountryInfo(EesCommonConditionVO conditionVO) throws EventException;

	
	/**
	 * retrieving for Period Valid Check<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchCheckPeriod(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for Period Valid Check(FM, To)<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriodOpt
	 * @exception EventException
	 */			
	public EesCommonVO searchCheckPeriodOpt(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for start Day on the week<br>
	 * @param yyyyww String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */			
	public CommonVO searchWeekToDate(String yyyyww) throws EventException;	
	
	/**
	 * week를 endDay 조회 <br>
	 * @param yyyyww String
	 * @param strDs String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * CSR NO :R200904090006
	 */			
	public CommonVO searchWeekEndDate(String yyyyww ,String strDs) throws EventException;	
	
	/**
	 * retrieving for start+gapmonth on the week <br>
	 * @param yyyyww
	 * @param gapmonth
	 * @param strDs
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * CSR NO :R200904090006
	 */			
	public CommonVO searchWeekStartDate(String yyyyww, String gapMonth , String strDs) throws EventException;	
	
	/**
	 * retrieving for dates with year week<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriodOpt
	 * @exception EventException
	 */			
	public EesCommonVO searchBetweenWeek(EesCommonConditionVO conditionVO) throws EventException;
	
	
	/**
	 * retrieving for REPO_PLAN with REPO_ID<br>
	 * @param repo_plan_id String
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */			
	public CommonVO searchOldRepoPlantype(String repo_plan_id) throws EventException;
	 
	 /**
	   * creating scenario ID <br>
		 * @param scnario_id String
		 * @return CommonVO getResultString()
		 * @exception EventException
		 */			
	public CommonVO createNewScnarioId(String scnario_id) throws EventException;
	
	 /**
	 * creating REPO_PLAN_ID <br>
	 * @param repo_plan_id String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */	
	public CommonVO  createNewRepoPlanId(String repo_plan_id) throws EventException; 
	
	 /**
	 * converting wee to month<br>
	 * @param yyyyww String
	 * @param gap int
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */	
	public CommonVO  weewklyConvertMonth(String yyyyww , int gap) throws EventException;

	/**
	 * retrieving for Week Date Period <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchWeekDatePeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchWeekDatePeriod(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for search eta date<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO search eta date
	 * @exception EventException
	 */			
	public EesCommonVO searchEtaDate(EesCommonConditionVO conditionVO) throws EventException;	
	
	/**
	 * retrieving for ECC Information convertiong <br>
	 * 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getTpszInitial() throws EventException;	
	
	/**
	 * retrieving for Country code of Yard Code<br>
	 * 
	 * @param yard_code
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getYardCNTCode(String yard_code) throws EventException;		

	/**
	 * converting day to week
	 *     
	 * @param date
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO convertDayWeekly(String date) throws EventException;	
	
	/**
	 * converting yard code To ECC
	 * 
	 * @param yard_code
	 * @param column_name
	 * @return
	 * @exception EventException
	 */
	public CommonVO convertYardToECC(String yard_code, String column_name) throws EventException;	
	
	/**
	 * checking VVD duplicate
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchDuplicatCheckPod(EesCommonConditionVO conditionVO) throws EventException;	
	
	/**
	 * retrieving for Period Valid Check<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchBeforeCheckPeriod(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for vessel <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchCheckPeriod
	 * @exception EventException
	 */			
	public EesCommonVO searchVesselScheduleCheck(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for BayPort List of the VVD
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchBayPort
	 * @exception EventException
	 */			
	public EesCommonVO searchBayPort(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for Lane
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLane
	 * @exception EventException
	 */			
	public EesCommonVO searchLane(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for  Next PLN_SEQ with REPO_PLN_ID, PLN_YRWK
	 * @param tableName String
	 * @param repoPlnId String
	 * @param plnYrwk String
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getNextPlnSeq(String tableName, String repoPlnId, String plnYrwk) throws EventException;
	
	/**
	 * ritrieving for USR_NM, OFC_CD with USR_ID
	 * 
	 * @param usrId String 
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getUserInfo(String usrId) throws EventException;
	
	/**
	 * retrieving for EQR Week with the year
	 * 
	 * @param plnYr String
	 * @return List<EqrWkPrdVO>
	 * @exception EventException
	 */
	public List<EqrWkPrdVO> searchEqrWkPrd(String plnYr) throws EventException;
	
	/**
	 * Managing EQR Week
	 * 
	 * @param EqrWkPrdVO[] eqrWkPrdVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageEqrWkPrd(EqrWkPrdVO[] eqrWkPrdVOs, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * Trade 
	 * 
	 * @return List<EqrCommonVO>
	 * @exception EventException
	 */
	public List<EqrCommonVO> searchTradeList() throws EventException;
	
	/**
     * 
     * @param modual 명
     * @param tag 명
     * @param valueField value 필드명
     * @param textField text 필드명
     * @param sSelectedCode명
     * @param mainCode 
     * @param orderByField 정렬 필드명
     * @param options select 옵션
     * @param addOption 추가 옵션
     * @return selectTag 
     */
    public String getTpSzCodeCombo(String modual, String tagName, String sSelectedCode, String mainCode, String orderByField, String delOptions, String addOption) throws EventException;
    
    
    /**
   	 * Default Data Setting
   	 * 
   	 * @param conditionVO EesCommonConditionVO 
   	 * @return EesCommonVO
   	 * @exception EventException
   	 */
   	public EesCommonVO repoidDefaultSearch (EesCommonConditionVO conditionVO) throws EventException;
   	
   	
   	/**
	 * retrieving for LOC YARD INITIAL<br>
	 * @param EesCommonConditionVO conditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchWaterLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	
	/**
	 * retrieving for LOC YARD-ECC<br>
	 * @param conditionVO EesCommonConditionVO
	 * @param account SignOnUserAccount
	 * @return EesCommonVO searchLocYardEccInfo
	 * @exception EventException
	 */			
	public String searchEqrLocTrwYardLccInfo(EesCommonConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<EqrCommonVO> searchEqrSubContinentList() throws EventException;
	
	
	/**
	 * 
	 * @param conditionVO
	 * @return
	 * @throws EventException
	 */
	public EesCommonVO repoidDefaultRepoPlanIdSearch (EesCommonConditionVO conditionVO) throws EventException;
   	
}
