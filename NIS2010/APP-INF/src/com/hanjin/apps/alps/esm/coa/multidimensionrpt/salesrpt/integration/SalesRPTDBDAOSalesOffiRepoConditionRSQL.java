/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SalesRPTDBDAOSalesOffiRepoConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSalesOffiRepoConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트 조건 VO용
	  * </pre>
	  */
	public SalesRPTDBDAOSalesOffiRepoConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSalesOffiRepoConditionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT '' F_OFC_STS" ).append("\n"); 
		query.append("	, '' F_EXCL_STS" ).append("\n"); 
		query.append("	, '' F_TAA_NO" ).append("\n"); 
		query.append("	, '' F_RPT_ITEM" ).append("\n"); 
		query.append("	, '' F_FM_MON" ).append("\n"); 
		query.append("	, '' F_DIR_CD" ).append("\n"); 
		query.append("	, '' F_ISCMDT" ).append("\n"); 
		query.append("	, '' F_USA_BKG_MOD_CD" ).append("\n"); 
		query.append("	, '' F_RHQ_CD" ).append("\n"); 
		query.append("	, '' F_SLS_MON" ).append("\n"); 
		query.append("	, '' F_COB_TRADE" ).append("\n"); 
		query.append("	, '' F_CURR_WEEK" ).append("\n"); 
		query.append("	, '' F_WK_STS" ).append("\n"); 
		query.append("	, '' F_BKG_DEL_CD" ).append("\n"); 
		query.append("	, '' F_SREP_CD" ).append("\n"); 
		query.append("	, '' F_ISSC" ).append("\n"); 
		query.append("	, '' F_VSL_CD" ).append("\n"); 
		query.append("	, '' F_ISTPSZ" ).append("\n"); 
		query.append("	, '' F_USR_OFC_LVL" ).append("\n"); 
		query.append("	, '' F_OFC_LVL" ).append("\n"); 
		query.append("	, '' F_FM_WK" ).append("\n"); 
		query.append("	, '' F_OFC_VW" ).append("\n"); 
		query.append("	, '' F_TO_MON" ).append("\n"); 
		query.append("	, '' F_SKD_VOY_NO" ).append("\n"); 
		query.append("	, '' F_SC_NO" ).append("\n"); 
		query.append("	, '' F_DIR_STS" ).append("\n"); 
		query.append("	, '' F_USR_OFC_CD" ).append("\n"); 
		query.append("	, '' F_TRD_CD" ).append("\n"); 
		query.append("	, '' F_TO_DATE" ).append("\n"); 
		query.append("	, '' F_TO_WK" ).append("\n"); 
		query.append("	, '' F_BKG_STS" ).append("\n"); 
		query.append("	, '' F_FM_DATE" ).append("\n"); 
		query.append("	, '' F_RLANE_CD" ).append("\n"); 
		query.append("	, '' F_BKG_POR_CD" ).append("\n"); 
		query.append("	, '' F_IOC_CD" ).append("\n"); 
		query.append("	, '' F_REV_POL_CD" ).append("\n"); 
		query.append("	, '' F_COB_LANE" ).append("\n"); 
		query.append("	, '' F_YEAR" ).append("\n"); 
		query.append("	, '' F_RF_STS" ).append("\n"); 
		query.append("	, '' F_CHKPRD" ).append("\n"); 
		query.append("	, '' F_MON" ).append("\n"); 
		query.append("	, '' F_ISSREP" ).append("\n"); 
		query.append("	, '' F_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, '' F_WK" ).append("\n"); 
		query.append("	, '' F_SLS_OFC_CD" ).append("\n"); 
		query.append("	, '' F_PRO_VW" ).append("\n"); 
		query.append("	, '' F_COB_SUBTRADE" ).append("\n"); 
		query.append("	, '' F_SHPR_CD" ).append("\n"); 
		query.append("	, '' F_COB_BOUND" ).append("\n"); 
		query.append("	, '' F_BKG_NO" ).append("\n"); 
		query.append("	, '' F_SKD_DIR_CD" ).append("\n"); 
		query.append("	, '' F_RFA" ).append("\n"); 
		query.append("	, '' F_PRD_CD" ).append("\n"); 
		query.append("	, '' F_OFC_LVL2" ).append("\n"); 
		query.append("	, '' F_OFC_LVL1" ).append("\n"); 
		query.append("	, '' F_OFC_CD" ).append("\n"); 
		query.append("	, '' F_PREV_WEEK" ).append("\n"); 
		query.append("	, '' F_PRO_LVL" ).append("\n"); 
		query.append("	, '' F_YEAR2" ).append("\n"); 
		query.append("	, '' F_EXCEL" ).append("\n"); 
		query.append("	, '' F_ISVVD" ).append("\n"); 
		query.append("	, '' F_ISWEEK" ).append("\n"); 
		query.append("	, '' F_STP_FLG" ).append("\n"); 
		query.append("	, '' F_REV_POD_CD" ).append("\n"); 
		query.append("	, '' F_ISBKG" ).append("\n"); 
		query.append("	, '' F_ISSHPR" ).append("\n"); 
		query.append("	, '' F_ISCNEE" ).append("\n"); 
		query.append("	, '' F_ISROUTE" ).append("\n"); 
		query.append("	, '' F_RFA_NO" ).append("\n"); 
		query.append("	, '' F_REP_CMDT_CD" ).append("\n"); 
		query.append("	, '' F_SC_STS" ).append("\n"); 
		query.append("	, '' F_GCUST_STS" ).append("\n"); 
		query.append("	, '' F_OTR_GLOBAL_ACCT" ).append("\n"); 
		query.append("	, '' F_RA_ACCT_GROUP_CD" ).append("\n"); 
		query.append("	, '' F_OTR_REGIONAL_ACCT" ).append("\n"); 
		query.append("	, '' F_OTR_KEY_ACCT" ).append("\n"); 
		query.append("	, '' F_SA_TRD_GROUP_CD" ).append("\n"); 
		query.append("	, '' F_KEY_ACCT_GROUP_CD" ).append("\n"); 
		query.append("	, '' F_VIEW_CUST" ).append("\n"); 
		query.append("	, '' F_R_MONTH_STS" ).append("\n"); 
		query.append("	, '' F_SUB_TRD_CD" ).append("\n"); 
		query.append("	, '' F_HUL_BND_STS" ).append("\n"); 
		query.append("	, '' F_IAS_RGN_STS" ).append("\n"); 
		query.append("	, '' F_HUL_BND_CD" ).append("\n"); 
		query.append("	, '' F_IAS_RGN_CD" ).append("\n"); 
		query.append("	, '' F_OFC_TEAM_CD" ).append("\n"); 
		query.append("	, '' F_OTR_LOCAL_ACCT" ).append("\n"); 
		query.append("	, '' F_INCLUDE_TS" ).append("\n"); 
		query.append("	, '' F_IAS_SECTER_STS" ).append("\n"); 
		query.append("	, '' F_POL_CD" ).append("\n"); 
		query.append("	, '' F_POD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}