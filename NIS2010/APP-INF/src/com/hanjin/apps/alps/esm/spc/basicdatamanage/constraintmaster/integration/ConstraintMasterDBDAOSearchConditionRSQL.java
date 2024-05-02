/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.04.22 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCondition vo 생성
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchConditionRSQL").append("\n"); 
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
		query.append("SELECT '' F_SVC_TRNS_PRC_CNT_CD" ).append("\n"); 
		query.append("      ,'' F_CBO_RCC" ).append("\n"); 
		query.append("      ,'' F_FM_MON" ).append("\n"); 
		query.append("      ,'' F_SELCLASS" ).append("\n"); 
		query.append("      ,'' F_COBTRADE" ).append("\n"); 
		query.append("      ,'' F_MT_PU_YD_CD" ).append("\n"); 
		query.append("      ,'' F_POD_ECC_CD" ).append("\n"); 
		query.append("      ,'' F_STRTOMONTH" ).append("\n"); 
		query.append("      ,'' F_TO" ).append("\n"); 
		query.append("      ,'' F_SREP_CD" ).append("\n"); 
		query.append("      ,'' F_VSL_CD" ).append("\n"); 
		query.append("      ,'' F_SELCOST" ).append("\n"); 
		query.append("      ,'' F_AVG_GRP_CD" ).append("\n"); 
		query.append("      ,'' F_OFC_TEAM_CD" ).append("\n"); 
		query.append("      ,'' F_STRTOWEEK" ).append("\n"); 
		query.append("      ,'' F_COST_USE_TP_CD" ).append("\n"); 
		query.append("      ,'' F_RLANE_CD" ).append("\n"); 
		query.append("      ,'' F_BKG_POR_CD" ).append("\n"); 
		query.append("      ,'' F_STRVOYAGE" ).append("\n"); 
		query.append("      ,'' F_STRFMMONTH" ).append("\n"); 
		query.append("      ,'' F_DIVIDENAME" ).append("\n"); 
		query.append("      ,'' F_CHKPRD" ).append("\n"); 
		query.append("      ,'' F_TML_CD" ).append("\n"); 
		query.append("      ,'' F_OTR_REGIONAL_ACCT" ).append("\n"); 
		query.append("      ,'' F_SOC_STS" ).append("\n"); 
		query.append("      ,'' F_LOCAL_ACCT" ).append("\n"); 
		query.append("      ,'' F_FROM_ECC" ).append("\n"); 
		query.append("      ,'' F_SDATE" ).append("\n"); 
		query.append("      ,'' F_EDATE" ).append("\n"); 
		query.append("      ,'' F_CUST_SEQ" ).append("\n"); 
		query.append("      ,'' F_CBOTRADE" ).append("\n"); 
		query.append("      ,'' F_EMON" ).append("\n"); 
		query.append("      ,'' F_PRO_VW" ).append("\n"); 
		query.append("      ,'' F_YEARMONTH" ).append("\n"); 
		query.append("      ,'' F_TO_ECC_CD" ).append("\n"); 
		query.append("      ,'' F_SHPR" ).append("\n"); 
		query.append("      ,'' F_SHPR_CD" ).append("\n"); 
		query.append("      ,'' F_OTR_STRG_ACCT" ).append("\n"); 
		query.append("      ,'' F_VESSEL" ).append("\n"); 
		query.append("      ,'' F_FROM_ECC_CD" ).append("\n"); 
		query.append("      ,'' F_COMM_LOC_CD" ).append("\n"); 
		query.append("      ,'' F_POR" ).append("\n"); 
		query.append("      ,'' F_RFA" ).append("\n"); 
		query.append("      ,'' F_OTR_RF_CORE_ACCT" ).append("\n"); 
		query.append("      ,'' F_OFC_CD" ).append("\n"); 
		query.append("      ,'' F_SUB_TRD_CD" ).append("\n"); 
		query.append("      ,'' F_LCC_CD" ).append("\n"); 
		query.append("      ,'' F_RFA_NO" ).append("\n"); 
		query.append("      ,'' F_SIM_NO" ).append("\n"); 
		query.append("      ,'' F_HUL_BND_CD" ).append("\n"); 
		query.append("      ,'' F_DIR_CD" ).append("\n"); 
		query.append("      ,'' F_USA_BKG_MOD_CD" ).append("\n"); 
		query.append("      ,'' F_OP_LANE_TP_CD" ).append("\n"); 
		query.append("      ,'' F_FULL_MTY_CD" ).append("\n"); 
		query.append("      ,'' F_MDM_CHARGE_TYPE_CD" ).append("\n"); 
		query.append("      ,'' F_WK_STS" ).append("\n"); 
		query.append("      ,'' F_SELRLANE" ).append("\n"); 
		query.append("      ,'' F_STRTYPE" ).append("\n"); 
		query.append("      ,'' F_REV_YRMON" ).append("\n"); 
		query.append("      ,'' F_COBDIR" ).append("\n"); 
		query.append("      ,'' F_MTY_LCC_CD" ).append("\n"); 
		query.append("      ,'' F_OFC_LVL" ).append("\n"); 
		query.append("      ,'' F_HEADER" ).append("\n"); 
		query.append("      ,'' F_OFC_VW" ).append("\n"); 
		query.append("      ,'' F_SPCL_CGO_AWK_FLG" ).append("\n"); 
		query.append("      ,'' F_SC_NO" ).append("\n"); 
		query.append("      ,'' F_USR_ID" ).append("\n"); 
		query.append("      ,'' F_KEY_ACCT_GROUP_CD" ).append("\n"); 
		query.append("      ,'' F_TO_WK" ).append("\n"); 
		query.append("      ,'' F_SPCL_CGO_DG_FLG" ).append("\n"); 
		query.append("      ,'' F_CBOSLANE" ).append("\n"); 
		query.append("      ,'' F_H_DIR_CD" ).append("\n"); 
		query.append("      ,'' F_SPCL_CGO_RF_FLG" ).append("\n"); 
		query.append("      ,'' F_STRDIR" ).append("\n"); 
		query.append("      ,'' F_CHKPREVCRE" ).append("\n"); 
		query.append("      ,'' F_STRFMWEEK" ).append("\n"); 
		query.append("      ,'' F_SLAN_CD" ).append("\n"); 
		query.append("      ,'' F_FROM" ).append("\n"); 
		query.append("      ,'' F_ECC_CD2" ).append("\n"); 
		query.append("      ,'' F_ACT_GRP_CD" ).append("\n"); 
		query.append("      ,'' F_CHK_BSAZRFLG" ).append("\n"); 
		query.append("      ,'' F_VOYAGE" ).append("\n"); 
		query.append("      ,'' F_MTY_RCC_CD" ).append("\n"); 
		query.append("      ,'' F_X_LEV" ).append("\n"); 
		query.append("      ,'' F_CHKDEL" ).append("\n"); 
		query.append("      ,'' F_SLS_OFC_CD" ).append("\n"); 
		query.append("      ,'' F_LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,'' F_CBO_LCC" ).append("\n"); 
		query.append("      ,'' F_TO_ECC" ).append("\n"); 
		query.append("      ,'' F_H_RLANE_CD" ).append("\n"); 
		query.append("      ,'' F_SMON" ).append("\n"); 
		query.append("      ,'' F_COST_LOC_GRP_CD" ).append("\n"); 
		query.append("      ,'' F_IAS_SUB_GRP_CD" ).append("\n"); 
		query.append("      ,'' F_SELIOC" ).append("\n"); 
		query.append("      ,'' F_MLT_TRD_GROUP_CD" ).append("\n"); 
		query.append("      ,'' F_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,'' F_DIR" ).append("\n"); 
		query.append("      ,'' F_COST_FM_MON" ).append("\n"); 
		query.append("      ,'' F_POL_POD_CD" ).append("\n"); 
		query.append("      ,'' F_CALC_TERM_CD" ).append("\n"); 
		query.append("      ,'' F_INOUT" ).append("\n"); 
		query.append("      ,'' ISTRADE" ).append("\n"); 
		query.append("      ,'' F_SELSLANE" ).append("\n"); 
		query.append("      ,'' F_REV_POD_CD" ).append("\n"); 
		query.append("      ,'' F_STRVESSEL" ).append("\n"); 
		query.append("      ,'' F_STRYEAR" ).append("\n"); 
		query.append("      ,'' F_1ST" ).append("\n"); 
		query.append("      ,'' F_RD_IND" ).append("\n"); 
		query.append("      ,'' F_EXCL_STS" ).append("\n"); 
		query.append("      ,'' F_TAA_NO" ).append("\n"); 
		query.append("      ,'' F_RCC_CD" ).append("\n"); 
		query.append("      ,'' F_H_IOC_CD" ).append("\n"); 
		query.append("      ,'' F_RF_CORE_ACCT_CD" ).append("\n"); 
		query.append("      ,'' F_WTR_TERM_CD" ).append("\n"); 
		query.append("      ,'' F_STRTRADE" ).append("\n"); 
		query.append("      ,'' F_SAVENAME" ).append("\n"); 
		query.append("      ,'' F_EXCL_SUB" ).append("\n"); 
		query.append("      ,'' F_CUST_TP" ).append("\n"); 
		query.append("      ,'' F_BKG_POD_CD" ).append("\n"); 
		query.append("      ,'' F_BKG_DEL_CD" ).append("\n"); 
		query.append("      ,'' F_MDM_CHARGE_CD" ).append("\n"); 
		query.append("      ,'' F_ROUT_NO" ).append("\n"); 
		query.append("      ,'' F_VIEW_TPSZ" ).append("\n"); 
		query.append("      ,'' F_BKG_POL_CD" ).append("\n"); 
		query.append("      ,'' F_STRPRCNM" ).append("\n"); 
		query.append("      ,'' F_TO_MON" ).append("\n"); 
		query.append("      ,'' F_RA_ACCT_GROUP_CD" ).append("\n"); 
		query.append("      ,'' F_SIM" ).append("\n"); 
		query.append("      ,'' F_TRD_CD" ).append("\n"); 
		query.append("      ,'' F_SIM_DT" ).append("\n"); 
		query.append("      ,'' F_BKG_STS" ).append("\n"); 
		query.append("      ,'' F_MT_PU_CD" ).append("\n"); 
		query.append("      ,'' F_IOC_CD" ).append("\n"); 
		query.append("      ,'' F_EWEEK" ).append("\n"); 
		query.append("      ,'' F_ECC_CD" ).append("\n"); 
		query.append("      ,'' F_SELVESSEL" ).append("\n"); 
		query.append("      ,'' F_REV_POL_CD" ).append("\n"); 
		query.append("      ,'' F_MTY_ECC_CD" ).append("\n"); 
		query.append("      ,'' F_TYPE_CD" ).append("\n"); 
		query.append("      ,'' F_COBLANE" ).append("\n"); 
		query.append("      ,'' F_UC_CD" ).append("\n"); 
		query.append("      ,'' F_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,'' F_DEL" ).append("\n"); 
		query.append("      ,'' F_RA_ACCT_INDVL_CD" ).append("\n"); 
		query.append("      ,'' F_OTR_GLOBAL_ACCT" ).append("\n"); 
		query.append("      ,'' F_SRC_MON" ).append("\n"); 
		query.append("      ,'' F_ORI_DEST" ).append("\n"); 
		query.append("      ,'' F_LGS_KPI3_CD" ).append("\n"); 
		query.append("      ,'' F_GROUP" ).append("\n"); 
		query.append("      ,'' F_BKG_NO" ).append("\n"); 
		query.append("      ,'' F_COST_YR" ).append("\n"); 
		query.append("      ,'' F_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,'' F_PRO_LVL" ).append("\n"); 
		query.append("      ,'' F_SA_TRD_INDVL_CD" ).append("\n"); 
		query.append("      ,'' F_H_TRD_CD" ).append("\n"); 
		query.append("      ,'' F_SHIPPER" ).append("\n"); 
		query.append("      ,'' F_POD" ).append("\n"); 
		query.append("      ,'' F_YEARWEEK" ).append("\n"); 
		query.append("      ,'' F_COBIOC" ).append("\n"); 
		query.append("      ,'' F_YRTYPE" ).append("\n"); 
		query.append("      ,'' F_OFC_ACT_CD" ).append("\n"); 
		query.append("      ,'' F_3TD" ).append("\n"); 
		query.append("      ,'' F_RHQ_CD" ).append("\n"); 
		query.append("      ,'' F_SLS_MON" ).append("\n"); 
		query.append("      ,'' F_KEY_ACCT_INDVL_CD" ).append("\n"); 
		query.append("      ,'' F_LOC_CD" ).append("\n"); 
		query.append("      ,'' F_CUST_RHQ_CD" ).append("\n"); 
		query.append("      ,'' F_CMDT_CD" ).append("\n"); 
		query.append("      ,'' F_OTR_KEY_ACCT" ).append("\n"); 
		query.append("      ,'' F_OP_VIEW" ).append("\n"); 
		query.append("      ,'' F_SA_TRD_GROUP_CD" ).append("\n"); 
		query.append("      ,'' F_CRR_CD" ).append("\n"); 
		query.append("      ,'' F_2ND" ).append("\n"); 
		query.append("      ,'' F_SELGROUP" ).append("\n"); 
		query.append("      ,'' F_SWEEK" ).append("\n"); 
		query.append("      ,'' F_FM_WK" ).append("\n"); 
		query.append("      ,'' F_COBCOST" ).append("\n"); 
		query.append("      ,'' F_SPCL_CGO_CD" ).append("\n"); 
		query.append("      ,'' F_MLT_TRD_INDVL_CD" ).append("\n"); 
		query.append("      ,'' F_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,'' F_DIR_STS" ).append("\n"); 
		query.append("      ,'' F_WK_CD" ).append("\n"); 
		query.append("      ,'' F_HEADERNM" ).append("\n"); 
		query.append("      ,'' F_TRD_STS" ).append("\n"); 
		query.append("      ,'' F_TRD_DIR_CD" ).append("\n"); 
		query.append("      ,'' F_LOC" ).append("\n"); 
		query.append("      ,'' F_PCTL_NO" ).append("\n"); 
		query.append("      ,'' F_CBO_ECC" ).append("\n"); 
		query.append("      ,'' F_YEAR" ).append("\n"); 
		query.append("      ,'' F_MON" ).append("\n"); 
		query.append("      ,'' F_SPCL_CGO_BB_FLG" ).append("\n"); 
		query.append("      ,'' F_BKG_DISP" ).append("\n"); 
		query.append("      ,'' F_SELDIR" ).append("\n"); 
		query.append("      ,'' F_STS_CD" ).append("\n"); 
		query.append("      ,'' F_AVG_SUVGRP" ).append("\n"); 
		query.append("      ,'' F_STRCHKPRD" ).append("\n"); 
		query.append("      ,'' F_TAR_MON" ).append("\n"); 
		query.append("      ,'' F_VOP_CD" ).append("\n"); 
		query.append("      ,'' F_COA_CD" ).append("\n"); 
		query.append("      ,'' F_COST_YRMON" ).append("\n"); 
		query.append("      ,'' F_IAS_RGN_CD" ).append("\n"); 
		query.append("      ,'' F_SELTRADE" ).append("\n"); 
		query.append("      ,'' F_STRLANE" ).append("\n"); 
		query.append("      ,'' F_ECC" ).append("\n"); 
		query.append("      ,'' F_VSL_CD2" ).append("\n"); 
		query.append("      ,'' F_BKG_NO_SPLIT" ).append("\n"); 
		query.append("      ,'' F_SELCAPA" ).append("\n"); 
		query.append("      ,'' F_4TH" ).append("\n"); 
		query.append("      ,'' F_LEVEL" ).append("\n"); 
		query.append("      ,'' F_VVD_CD" ).append("\n"); 
		query.append("      ,'' F_ALOC_STS_CD" ).append("\n"); 
		query.append("      ,'' F_SB_RSN_TP_CD" ).append("\n"); 
		query.append("      ,'' F_WEEK" ).append("\n"); 
		query.append("      ,'' F_DURATION" ).append("\n"); 
		query.append("      ,'' F_ACCT_CD" ).append("\n"); 
		query.append("      ,'' F_BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("      ,'' F_CTRT_NO" ).append("\n"); 
		query.append("      ,'' F_CHK_DUMMY" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 

	}
}