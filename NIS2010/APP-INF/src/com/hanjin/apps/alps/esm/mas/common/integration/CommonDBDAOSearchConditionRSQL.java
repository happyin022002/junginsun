/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.05.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면의 Object들의 VO를 생성한다.
	  * </pre>
	  */
	public CommonDBDAOSearchConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchConditionRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  '' AS F_SVC_TRNS_PRC_CNT_CD" ).append("\n"); 
		query.append(", '' AS F_CBO_RCC" ).append("\n"); 
		query.append(", '' AS F_FM_MON" ).append("\n"); 
		query.append(", '' AS F_SELCLASS" ).append("\n"); 
		query.append(", '' AS F_COBTRADE" ).append("\n"); 
		query.append(", '' AS F_MT_PU_YD_CD" ).append("\n"); 
		query.append(", '' AS F_POD_ECC_CD" ).append("\n"); 
		query.append(", '' AS F_STRTOMONTH" ).append("\n"); 
		query.append(", '' AS F_TO" ).append("\n"); 
		query.append(", '' AS F_VSL_CD" ).append("\n"); 
		query.append(", '' AS F_SELCOST" ).append("\n"); 
		query.append(", '' AS F_AVG_GRP_CD" ).append("\n"); 
		query.append(", '' AS F_COST_USE_TP_CD" ).append("\n"); 
		query.append(", '' AS F_STRTOWEEK" ).append("\n"); 
		query.append(", '' AS F_RLANE_CD" ).append("\n"); 
		query.append(", '' AS F_BKG_POR_CD" ).append("\n"); 
		query.append(", '' AS F_STRVOYAGE" ).append("\n"); 
		query.append(", '' AS F_STRFMMONTH" ).append("\n"); 
		query.append(", '' AS F_DIVIDENAME" ).append("\n"); 
		query.append(", '' AS F_CHKPRD" ).append("\n"); 
		query.append(", '' AS F_TML_CD" ).append("\n"); 
		query.append(", '' AS F_OTR_REGIONAL_ACCT" ).append("\n"); 
		query.append(", '' AS F_SOC_STS" ).append("\n"); 
		query.append(", '' AS F_FROM_ECC" ).append("\n"); 
		query.append(", '' AS F_SDATE" ).append("\n"); 
		query.append(", '' AS F_CUST_SEQ" ).append("\n"); 
		query.append(", '' AS F_CBOTRADE" ).append("\n"); 
		query.append(", '' AS F_EMON" ).append("\n"); 
		query.append(", '' AS F_PRO_VW" ).append("\n"); 
		query.append(", '' AS F_YEARMONTH" ).append("\n"); 
		query.append(", '' AS F_TO_ECC_CD" ).append("\n"); 
		query.append(", '' AS F_SHPR" ).append("\n"); 
		query.append(", '' AS F_SHPR_CD" ).append("\n"); 
		query.append(", '' AS F_OTR_STRG_ACCT" ).append("\n"); 
		query.append(", '' AS F_VESSEL" ).append("\n"); 
		query.append(", '' AS F_FROM_ECC_CD" ).append("\n"); 
		query.append(", '' AS F_COMM_LOC_CD" ).append("\n"); 
		query.append(", '' AS F_POR" ).append("\n"); 
		query.append(", '' AS F_RFA" ).append("\n"); 
		query.append(", '' AS F_OTR_RF_CORE_ACCT" ).append("\n"); 
		query.append(", '' AS F_OFC_CD" ).append("\n"); 
		query.append(", '' AS F_SUB_TRD_CD" ).append("\n"); 
		query.append(", '' AS F_LCC_CD" ).append("\n"); 
		query.append(", '' AS F_RFA_NO" ).append("\n"); 
		query.append(", '' AS F_SIM_NO" ).append("\n"); 
		query.append(", '' AS F_DIR_CD" ).append("\n"); 
		query.append(", '' AS F_USA_BKG_MOD_CD" ).append("\n"); 
		query.append(", '' AS F_OP_LANE_TP_CD" ).append("\n"); 
		query.append(", '' AS F_FULL_MTY_CD" ).append("\n"); 
		query.append(", '' AS F_MDM_CHARGE_TYPE_CD" ).append("\n"); 
		query.append(", '' AS F_WK_STS" ).append("\n"); 
		query.append(", '' AS F_SELRLANE" ).append("\n"); 
		query.append(", '' AS F_REV_YRMON" ).append("\n"); 
		query.append(", '' AS F_STRTYPE" ).append("\n"); 
		query.append(", '' AS F_COBDIR" ).append("\n"); 
		query.append(", '' AS F_MTY_LCC_CD" ).append("\n"); 
		query.append(", '' AS F_OFC_LVL" ).append("\n"); 
		query.append(", '' AS F_HEADER" ).append("\n"); 
		query.append(", '' AS F_OFC_VW" ).append("\n"); 
		query.append(", '' AS F_SPCL_CGO_AWK_FLG" ).append("\n"); 
		query.append(", '' AS F_SC_NO" ).append("\n"); 
		query.append(", '' AS F_KEY_ACCT_GROUP_CD" ).append("\n"); 
		query.append(", '' AS F_SPCL_CGO_DG_FLG" ).append("\n"); 
		query.append(", '' AS F_TO_WK" ).append("\n"); 
		query.append(", '' AS F_H_DIR_CD" ).append("\n"); 
		query.append(", '' AS F_CBOSLANE" ).append("\n"); 
		query.append(", '' AS F_SPCL_CGO_RF_FLG" ).append("\n"); 
		query.append(", '' AS F_STRDIR" ).append("\n"); 
		query.append(", '' AS F_CHKPREVCRE" ).append("\n"); 
		query.append(", '' AS F_STRFMWEEK" ).append("\n"); 
		query.append(", '' AS F_SLAN_CD" ).append("\n"); 
		query.append(", '' AS F_FROM" ).append("\n"); 
		query.append(", '' AS F_ECC_CD2" ).append("\n"); 
		query.append(", '' AS F_CHK_BSAZRFLG" ).append("\n"); 
		query.append(", '' AS F_ACT_GRP_CD" ).append("\n"); 
		query.append(", '' AS F_VOYAGE" ).append("\n"); 
		query.append(", '' AS F_MTY_RCC_CD" ).append("\n"); 
		query.append(", '' AS F_CHKDEL" ).append("\n"); 
		query.append(", '' AS F_X_LEV" ).append("\n"); 
		query.append(", '' AS F_SLS_OFC_CD" ).append("\n"); 
		query.append(", '' AS F_LOCL_CURR_CD" ).append("\n"); 
		query.append(", '' AS F_CBO_LCC" ).append("\n"); 
		query.append(", '' AS F_H_RLANE_CD" ).append("\n"); 
		query.append(", '' AS F_TO_ECC" ).append("\n"); 
		query.append(", '' AS F_SMON" ).append("\n"); 
		query.append(", '' AS F_COST_LOC_GRP_CD" ).append("\n"); 
		query.append(", '' AS F_IAS_SUB_GRP_CD" ).append("\n"); 
		query.append(", '' AS F_MLT_TRD_GROUP_CD" ).append("\n"); 
		query.append(", '' AS F_SELIOC" ).append("\n"); 
		query.append(", '' AS F_SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS F_DIR" ).append("\n"); 
		query.append(", '' AS F_COST_FM_MON" ).append("\n"); 
		query.append(", '' AS F_CALC_TERM_CD" ).append("\n"); 
		query.append(", '' AS F_INOUT" ).append("\n"); 
		query.append(", '' AS ISTRADE" ).append("\n"); 
		query.append(", '' AS F_SELSLANE" ).append("\n"); 
		query.append(", '' AS F_REV_POD_CD" ).append("\n"); 
		query.append(", '' AS F_STRVESSEL" ).append("\n"); 
		query.append(", '' AS F_STRYEAR" ).append("\n"); 
		query.append(", '' AS F_1ST" ).append("\n"); 
		query.append(", '' AS F_RD_IND" ).append("\n"); 
		query.append(", '' AS F_EXCL_STS" ).append("\n"); 
		query.append(", '' AS F_TAA_NO" ).append("\n"); 
		query.append(", '' AS F_RCC_CD" ).append("\n"); 
		query.append(", '' AS F_H_IOC_CD" ).append("\n"); 
		query.append(", '' AS F_RF_CORE_ACCT_CD" ).append("\n"); 
		query.append(", '' AS F_WTR_TERM_CD" ).append("\n"); 
		query.append(", '' AS F_STRTRADE" ).append("\n"); 
		query.append(", '' AS F_SAVENAME" ).append("\n"); 
		query.append(", '' AS F_EXCL_SUB" ).append("\n"); 
		query.append(", '' AS F_BKG_POD_CD" ).append("\n"); 
		query.append(", '' AS F_BKG_DEL_CD" ).append("\n"); 
		query.append(", '' AS F_MDM_CHARGE_CD" ).append("\n"); 
		query.append(", '' AS F_ROUT_NO" ).append("\n"); 
		query.append(", '' AS F_VIEW_TPSZ" ).append("\n"); 
		query.append(", '' AS F_BKG_POL_CD" ).append("\n"); 
		query.append(", '' AS F_STRPRCNM" ).append("\n"); 
		query.append(", '' AS F_TO_MON" ).append("\n"); 
		query.append(", '' AS F_RA_ACCT_GROUP_CD" ).append("\n"); 
		query.append(", '' AS F_SIM" ).append("\n"); 
		query.append(", '' AS F_TRD_CD" ).append("\n"); 
		query.append(", '' AS F_SIM_DT" ).append("\n"); 
		query.append(", '' AS F_BKG_STS" ).append("\n"); 
		query.append(", '' AS F_MT_PU_CD" ).append("\n"); 
		query.append(", '' AS F_IOC_CD" ).append("\n"); 
		query.append(", '' AS F_EWEEK" ).append("\n"); 
		query.append(", '' AS F_ECC_CD" ).append("\n"); 
		query.append(", '' AS F_SELVESSEL" ).append("\n"); 
		query.append(", '' AS F_REV_POL_CD" ).append("\n"); 
		query.append(", '' AS F_MTY_ECC_CD" ).append("\n"); 
		query.append(", '' AS F_TYPE_CD" ).append("\n"); 
		query.append(", '' AS F_COBLANE" ).append("\n"); 
		query.append(", '' AS F_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", '' AS F_DEL" ).append("\n"); 
		query.append(", '' AS F_RA_ACCT_INDVL_CD" ).append("\n"); 
		query.append(", '' AS F_OTR_GLOBAL_ACCT" ).append("\n"); 
		query.append(", '' AS F_SRC_MON" ).append("\n"); 
		query.append(", '' AS F_ORI_DEST" ).append("\n"); 
		query.append(", '' AS F_GROUP" ).append("\n"); 
		query.append(", '' AS F_BKG_NO" ).append("\n"); 
		query.append(", '' AS F_COST_YR" ).append("\n"); 
		query.append(", '' AS F_CUST_CNT_CD" ).append("\n"); 
		query.append(", '' AS F_PRO_LVL" ).append("\n"); 
		query.append(", '' AS F_SA_TRD_INDVL_CD" ).append("\n"); 
		query.append(", '' AS F_H_TRD_CD" ).append("\n"); 
		query.append(", '' AS F_SHIPPER" ).append("\n"); 
		query.append(", '' AS F_POD" ).append("\n"); 
		query.append(", '' AS F_YEARWEEK" ).append("\n"); 
		query.append(", '' AS F_COBIOC" ).append("\n"); 
		query.append(", '' AS F_YRTYPE" ).append("\n"); 
		query.append(", '' AS F_OFC_ACT_CD" ).append("\n"); 
		query.append(", '' AS F_3TD" ).append("\n"); 
		query.append(", '' AS F_RHQ_CD" ).append("\n"); 
		query.append(", '' AS F_SLS_MON" ).append("\n"); 
		query.append(", '' AS F_KEY_ACCT_INDVL_CD" ).append("\n"); 
		query.append(", '' AS F_LOC_CD" ).append("\n"); 
		query.append(", '' AS F_CMDT_CD" ).append("\n"); 
		query.append(", '' AS F_OTR_KEY_ACCT" ).append("\n"); 
		query.append(", '' AS F_OP_VIEW" ).append("\n"); 
		query.append(", '' AS F_SA_TRD_GROUP_CD" ).append("\n"); 
		query.append(", '' AS F_CRR_CD" ).append("\n"); 
		query.append(", '' AS F_2ND" ).append("\n"); 
		query.append(", '' AS F_SELGROUP" ).append("\n"); 
		query.append(", '' AS F_SWEEK" ).append("\n"); 
		query.append(", '' AS F_FM_WK" ).append("\n"); 
		query.append(", '' AS F_COBCOST" ).append("\n"); 
		query.append(", '' AS F_MLT_TRD_INDVL_CD" ).append("\n"); 
		query.append(", '' AS F_SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS F_DIR_STS" ).append("\n"); 
		query.append(", '' AS F_WK_CD" ).append("\n"); 
		query.append(", '' AS F_HEADERNM" ).append("\n"); 
		query.append(", '' AS F_LOC" ).append("\n"); 
		query.append(", '' AS F_PCTL_NO" ).append("\n"); 
		query.append(", '' AS F_CBO_ECC" ).append("\n"); 
		query.append(", '' AS F_YEAR" ).append("\n"); 
		query.append(", '' AS F_MON" ).append("\n"); 
		query.append(", '' AS F_SPCL_CGO_BB_FLG" ).append("\n"); 
		query.append(", '' AS F_BKG_DISP" ).append("\n"); 
		query.append(", '' AS F_SELDIR" ).append("\n"); 
		query.append(", '' AS F_AVG_SUVGRP" ).append("\n"); 
		query.append(", '' AS F_STRCHKPRD" ).append("\n"); 
		query.append(", '' AS F_TAR_MON" ).append("\n"); 
		query.append(", '' AS F_VOP_CD" ).append("\n"); 
		query.append(", '' AS F_MAS_CD" ).append("\n"); 
		query.append(", '' AS F_COST_YRMON" ).append("\n"); 
		query.append(", '' AS F_SELTRADE" ).append("\n"); 
		query.append(", '' AS F_STRLANE" ).append("\n"); 
		query.append(", '' AS F_ECC" ).append("\n"); 
		query.append(", '' AS F_VSL_CD2" ).append("\n"); 
		query.append(", '' AS F_BKG_NO_SPLIT" ).append("\n"); 
		query.append(", '' AS F_SELCAPA" ).append("\n"); 
		query.append(", '' AS F_4TH" ).append("\n"); 
		query.append(", '' AS F_SREP_CD" ).append("\n"); 
		query.append(", '' AS F_IAS_RGN_CD" ).append("\n"); 
		query.append(", '' AS F_HUL_BND_CD" ).append("\n"); 
		query.append(", '' AS F_OFC_TEAM_CD" ).append("\n"); 
		query.append(", '' AS F_CUST_RHQ_CD" ).append("\n"); 
		query.append(", '' AS F_LOCAL_ACCT" ).append("\n"); 
		query.append(", '' AS F_CUST_TP" ).append("\n"); 
		query.append(", '' AS F_TRD_DIR_CD" ).append("\n"); 
		query.append(", '' AS F_TRD_STS" ).append("\n"); 
		query.append(", '' AS F_STS_CD" ).append("\n"); 
		query.append(", '' AS F_UC_CD" ).append("\n"); 
		query.append(", '' AS F_USR_ID" ).append("\n"); 
		query.append(", '' AS F_POL_POD_CD" ).append("\n"); 
		query.append(", '' AS F_SPCL_CGO_CD" ).append("\n"); 
		query.append(", '' AS F_LGS_KPI3_CD" ).append("\n"); 
		query.append(", '' AS F_TTL_AMT" ).append("\n"); 
		query.append(", '' AS F_DUR" ).append("\n"); 
		query.append(", '' AS F_INCLUDE_TS" ).append("\n"); 
		query.append(", '' AS F_QTR" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}