/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckBC.java
*@FileTitle : common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoGrpVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComActualCarrierVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComCodeVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComRlaneVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Joocommon Business Logic Command Interface<br>
 * - OPUS-Joocommon: Business Logic Interface<br>
 *
 * @author
 * @see JoocommonEventResponse
 * @since J2EE 1.4
 */

public interface JOOFindCodeAndCheckBC {
	/**
	 * retrieving MDM TRADE CODE
	 * Search Condition : code = trade code (optional) 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchMdmTrdCdList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * retrieving MDM Revenue Lane
	 * Search Condition 
	 * - super_cd1 : representative Trade code
	 * - code : Lane code 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchMdmRlaneCdList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * retrieving Common Code (com_intg_cd_dtl)
	 * Search Condition
	 *  - super_cd1 : group code(intg_cd_id) - mandatory
	 *  - code : code(intg_cd_val_ctnt) - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchComCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * validation checking and retrieving customer name in case of inpputing  customer code by key-in
	 * Search Condition 
	 *  - code : cust_cnt_cd, cust_seq
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCustomerList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * validation checking and retrieving vendor name in case of inpputing  vendor code by key-in
	 * Search Condition
	 *  - code : vendor code - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchVendorList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * retrieving trade code list used in joint operation 
	 * Search Condition
	 *  - super_cd1 : Carrier (optional)
	 *  - code : trade code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTradeCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * retrieving lane code list used in joint operation
	 * Search Condition 
	 *  - super_cd1 : Carrier code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRlaneCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * retrieving trade and lane list used in joint operation
	 * Search Condition : exists not
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRLaneCodeListByTrade(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving carrier code used in joint operation
	 * Search Condition 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * VVD Validation Check in Vessel schedule
	 * Search Condition 
	 *  - code : Vessel Code, Voyage Number, Direction (mandatory)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> checkVVD(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	
	/**
	 * checking validation of account item by key-in
	 * Search Condition 
	 *  - code : account item 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchItemAcctList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * retrieving Settlement Account Code List (joo_stl_itm)
	 * Search Condition
	 *  - super_cd1 : jo_auto_cre_flg (optional)
	 *  - super_cd2 : jo_mnl_cre_flg (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchStlItemCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Rev Dir, Basic Port List, Pair Port List, Unit Cost Port List 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return JooCodeInfoGrpVO
	 * @throws EventException
	 */
	public JooCodeInfoGrpVO searchRevDirPortList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving port list that ETA is after -100 days
	 * Search Condition
	 *  - super_cd1 : lane code 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchPortListByLane(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * retrieving VSK_CARRIER
	 * Search Condition
	 *  - code : Carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchVskCarrierList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Office Code and name in AP_WORKPLACE
	 * Search Condition : exists not
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTaxOfcList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Unit Cost Port in Vessel Port Schedule by Lane and VVD
	 * Search Condition
	 *  - super_cd1 : lane code - mandatory
	 *  - super_cd2 : VVD (9 digits) - mandatory
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchUnitCostPortList(JooCodeParamVO jooCodeParamVO) throws EventException;


	/**
	 * retrieving Lane, RTU, Currency
	 * Search Condition
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : settlement ITEM (mandatory)
	 *  - name : (re_divr_cd) (mandatory)  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRlaneRTUList(JooCodeParamVO jooCodeParamVO) throws EventException;


	/**
	 * getting Rlane and Currency of Financial Matix in case of changing Trade
	 * Search Condition
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : settlement ITEM (mandatory)
	 *  - name : (re_divr_cd) (mandatory)  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRlaneCurrList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving combined no in JOO_STL_CMB
	 * Search Condition
	 *  - super_cd1 : Account Month (ACCT_YRMON)
	 *  - super_cd2 : Carrier Code (JO_CRR_CD)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCombinedNoList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
    /**
     * 
     * retrieving JOO_STL_ITM<br>
     *
     * @param jooCodeParamVO
     * @throws EventException
     * @return List<JooCodeInfoVO>
     * @author 
     */ 
	public List<JooCodeInfoVO> searchSettlementItemCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
    /**
     * checking Estimation closing status
     * @param JooCodeParamVO jooCodeParamVO
     * @return JooCodeInfoVO
     * @throws EventException
     */
    public JooCodeInfoVO searchCheckEstmClz(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving carrier code used in joint operation
	 * Search Condition 
	 *  - super_cd2 : trade code (optional)
	 *  - super_cd1 : rlane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierCodeListByTradeAndRlane(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving REVENUE MONTH MINIMUM, MAXMUM
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchRevYrmonFrTo(EstmConditionVO estmConditionVO) throws EventException;

	/**
	 * retrieving Trade code list
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchTradeCodeListEstm(EstmConditionVO estmConditionVO) throws EventException;

	/**
	 * retrieving Rlane code list
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchRlaneCodeListEstm(EstmConditionVO estmConditionVO) throws EventException;

	/**
	 * retrieving Carrier code list
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchCarrierCodeListEstm(EstmConditionVO estmConditionVO) throws EventException;
	
    /**
     * retrieving MDM_VSL_SVC_LANE Rlane code list used in joint operation
     * Search Condition 
     *  - code : Lane code (optional)
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchSvcRlaneCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Rlane list in case of changing carrier, trade code
	 * Search Condition 
	 *  - super_cd1 : Carrier code (mandatory)
	 *  - super_cd2 : Trade code (mandatory)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRLaneStlOptList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving AR HQ office code of login user
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return String
	 * @throws EventException
	 */
	public String searchArHqOfcCd(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * returning local datetime of login user
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchLocalDateTime(String ofcCd) throws EventException;

	/**
	 * retrieving  Revenue Direction, UnitCostPort List
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRevDirAndUnitCostPortList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
    /**
     * retrieving  SLP_OFC_CD of JOO_SLIP 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO> 
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchOfcCdSlip(JooCodeParamVO jooCodeParamVO) throws EventException;
    /**
     * retrieving  Authority Office Code 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO> 
     * @throws EventException
     */ 
    public List<JooCodeInfoVO> searchAuthOfficeList(JooCodeParamVO JooCodeParamVO) throws EventException;

    /**
     * retrieving office code check 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchOfcCd(JooCodeParamVO jooCodeParamVO) throws EventException;

    /**
     * retrieving RHQ Code
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchArHqOfcAllList(JooCodeParamVO jooCodeParamVO) throws EventException;
      
    /**
     * retrieving carrier code 3 digits 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchRLaneStlOpt3CodeList(JooCodeParamVO jooCodeParamVO) throws EventException;
    
    /**
     * retrieving combined no
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchCombinedNoOptAuthList(JooCodeParamVO jooCodeParamVO) throws EventException;

    /**
     * checking validation of VSL CODE + VOYAGE NUMBER
     * 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchVslVoyageList(JooCodeParamVO jooCodeParamVO) throws EventException;

    
	/**
	 * retrieving carrier code used in joint operation
	 * Search Condition 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving trade code list used in joint operation 
	 * Search Condition
	 *  - super_cd1 : Carrier (optional)
	 *  - code : trade code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTradeCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException;
	

    /**
     * retrieving lane code list used in joint operation
     * Search Condition 
     *  - super_cd1 : Carrier code (optional)
     *  - super_cd2 : Trade code (optional)
     *  - code : Lane code (optional)
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchRlaneCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException;

    /**
     * retrieving lane code list used in joint operation
     * Search Condition 
     * @param String ofcCd
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchCarrierByLaneList(String ofcCd) throws EventException;

	/**
	 * retrieving Carrier, Trade, Lane Code used in joint operation only
	 * Search Condition 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierTradeLaneWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException;
	
	/**
	 * Common Tax Type Search.
	 * Search Condition 
	 *  - code : tax group code (optional)
	 *  - sortkey : 0 - dp_seq
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTaxTypeList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - super_cd1 : lane code 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchVslSlanDirCdByLane(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - code : joo_com_ppt 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooComCodeVO> searchJooComCodeList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - code : joo_com_ppt Laden
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooComCodeVO> searchJooComCodeByLadenList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - code : joo_com_ppt Empty
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooComCodeVO> searchJooComCodeByEmptyList(JooCodeParamVO jooCodeParamVO) throws EventException;
 
    /**
     * retrieving 공동운항에서 사용하는 VSK_VSL_SKD, MDM_VSL_SVC_LANE vsl_slan_cd used in joint operation
     * Search Condition 
     *  - code : vsl_cd + skd_voy_no
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchVslSlanCdInfoByVvd(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * JOO_STL_CMB 전표 번호를 체크 한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckDBDAOCheckSlipByStlCmbSeq(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
     * 공통 Rlane_cd 조회 
     *  -rlane_cd, JO_CRR_CD, TRD_CD, JO_STL_OPT_CD, JO_CRR_AUTH_CD, LOCL_CURR_CD, JO_STL_TGT_TP_CD
	 * @param JooComRlaneVO jooComRlaneVO
	 * @return List<JooComRlaneVO>
	 * @throws EventException
	 */
	public List<JooComRlaneVO> searchRlaneCodeList(JooComRlaneVO jooComRlaneVO) throws EventException;

	/**
	 * retrieving Common Code: Region (com_intg_cd_dtl)
	 * Search Condition
	 *  - super_cd1 : group code(intg_cd_id) - mandatory
	 *  - code : (intg_cd_val_ctnt) - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRegionList(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * Actual Carrier/Vender/Coustomer 조회합니다.
	 * 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooComActualCarrierVO>
	 * @throws EventException
	 */
	public List<JooComActualCarrierVO> searchActualCarrierList(JooCodeParamVO jooCodeParamVO) throws EventException;
}