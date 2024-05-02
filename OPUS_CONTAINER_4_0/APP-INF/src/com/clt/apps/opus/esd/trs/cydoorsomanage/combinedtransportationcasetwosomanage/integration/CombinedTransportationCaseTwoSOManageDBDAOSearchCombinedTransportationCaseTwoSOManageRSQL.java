/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CombinedTransportationCaseTwoSOManageDBDAOSearchCombinedTransportationCaseTwoSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CombinedTransportationCaseTwoSOManageDBDAOSearchCombinedTransportationCaseTwoSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O Creation Combine2 inquiry
	  * </pre>
	  */
	public CombinedTransportationCaseTwoSOManageDBDAOSearchCombinedTransportationCaseTwoSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sTtime",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sFtime",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strCostMode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cydoor_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sNodeL",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.integration").append("\n"); 
		query.append("FileName : CombinedTransportationCaseTwoSOManageDBDAOSearchCombinedTransportationCaseTwoSOManageRSQL").append("\n"); 
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
		query.append("SELECT 'COP' SOURCE," ).append("\n"); 
		query.append("  '' TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("  '' TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("  NULL REPO_PLN_ID," ).append("\n"); 
		query.append("  NULL PLN_YRWK," ).append("\n"); 
		query.append("  NULL REF_SEQ," ).append("\n"); 
		query.append("  NULL REF_ID, " ).append("\n"); 
		query.append("  IB_VVD_CD," ).append("\n"); 
		query.append("  OB_VVD_CD," ).append("\n"); 
		query.append("  CTRL_OFC_CD," ).append("\n"); 
		query.append("  COP_NO," ).append("\n"); 
		query.append("  EQ_NO," ).append("\n"); 
		query.append("  EQ_TPSZ_CD," ).append("\n"); 
		query.append("  COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("  COST_ACT_GRP_CD," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("  TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("  FM_NOD_CD," ).append("\n"); 
		query.append("  FM_NOD_YARD," ).append("\n"); 
		query.append("  TO_NOD_CD," ).append("\n"); 
		query.append("  TO_NOD_YARD," ).append("\n"); 
		query.append("  VIA_NOD_CD," ).append("\n"); 
		query.append("  VIA_NOD_YARD," ).append("\n"); 
		query.append("  DOR_NOD_CD," ).append("\n"); 
		query.append("  DOR_NOD_YARD," ).append("\n"); 
		query.append("  FM_NOD_CD2," ).append("\n"); 
		query.append("  FM_NOD_YARD2," ).append("\n"); 
		query.append("  TO_NOD_CD2," ).append("\n"); 
		query.append("  TO_NOD_YARD2," ).append("\n"); 
		query.append("  VIA_NOD_CD2," ).append("\n"); 
		query.append("  VIA_NOD_YARD2," ).append("\n"); 
		query.append("  DOR_NOD_CD2," ).append("\n"); 
		query.append("  DOR_NOD_YARD2," ).append("\n"); 
		query.append("  N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("  N1ST_NOD_PLN_DT_HMS," ).append("\n"); 
		query.append("  LST_NOD_PLN_DT," ).append("\n"); 
		query.append("  LST_NOD_PLN_DT_HMS," ).append("\n"); 
		query.append("  DOR_NOD_PLN_DT," ).append("\n"); 
		query.append("  DOR_NOD_PLN_DT_HMS," ).append("\n"); 
		query.append("  TRSP_BND_CD," ).append("\n"); 
		query.append("  TRNS_RQST_OFC_CD," ).append("\n"); 
		query.append("  TRNS_RQST_USR_ID," ).append("\n"); 
		query.append("  TRNS_RQST_RSN," ).append("\n"); 
		query.append("  RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("  CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("  BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  BL_NO," ).append("\n"); 
		query.append("  CGO_TP_CD," ).append("\n"); 
		query.append("  PKGCODE," ).append("\n"); 
		query.append("  TRUNKVVD," ).append("\n"); 
		query.append("  SLAN_CD," ).append("\n"); 
		query.append("  POR_CD," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  POD_CD," ).append("\n"); 
		query.append("  DEL_CD," ).append("\n"); 
		query.append("  SEALNO," ).append("\n"); 
		query.append("  SEALNO2," ).append("\n"); 
		query.append("  CNTR_WGT," ).append("\n"); 
		query.append("  WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("  NOOFPKG," ).append("\n"); 
		query.append("  SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("  SHPR_CUST_NM," ).append("\n"); 
		query.append("  CNEE_CUST_NM," ).append("\n"); 
		query.append("  CNTR_KGS_WGT," ).append("\n"); 
		query.append("  CNTR_LBS_WGT," ).append("\n"); 
		query.append("  NTFY_CUST_NM," ).append("\n"); 
		query.append("  SC_NO," ).append("\n"); 
		query.append("  RFANO," ).append("\n"); 
		query.append("  CMDT_CD," ).append("\n"); 
		query.append("  CMDT_NAME," ).append("\n"); 
		query.append("  CGOR_FRT_PAY_IND_FLG," ).append("\n"); 
		query.append("  CGOR_ORG_BL_RCVR_IND_FLG," ).append("\n"); 
		query.append("  CGOR_CSTMS_ACPT_RE_IND_FLG," ).append("\n"); 
		query.append("  OWNR_CO_CD," ).append("\n"); 
		query.append("  IMDT_EXT_FLG," ).append("\n"); 
		query.append("  LSTM_CD," ).append("\n"); 
		query.append("  IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("  DOR_SVC_TP_CD," ).append("\n"); 
		query.append("  INTER_RMK," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("  FEEDERVVD," ).append("\n"); 
		query.append("  TRSP_NXT_PORT_CD," ).append("\n"); 
		query.append("  LST_LOC_CD," ).append("\n"); 
		query.append("  SPCL_INSTR_RMK," ).append("\n"); 
		query.append("  CUSTOMSCLEARANCENO," ).append("\n"); 
		query.append("  CUSTOMSCLEARANCE," ).append("\n"); 
		query.append("  CUST_CNT_CD," ).append("\n"); 
		query.append("  DOR_DE_ADDR," ).append("\n"); 
		query.append("  MLT_STOP_DE_FLG," ).append("\n"); 
		query.append("  PROC_CFM_IND_CD," ).append("\n"); 
		query.append("  TRSP_COST_DTL_MOD_SEP," ).append("\n"); 
		query.append("  UPLN_SO_FLG," ).append("\n"); 
		query.append("  CNTR_PKUP_NO," ).append("\n"); 
		query.append("  AVAL_DT," ).append("\n"); 
		query.append("  AVAL_DT_HMS," ).append("\n"); 
		query.append("  LST_FREE_DT," ).append("\n"); 
		query.append("  LST_FREE_DT_HMS," ).append("\n"); 
		query.append("  TRO_CNFM," ).append("\n"); 
		query.append("  TRO_SEQ," ).append("\n"); 
		query.append("  BKG_QTY," ).append("\n"); 
		query.append("  POD_CONTI_CD AS CONTI_CD," ).append("\n"); 
		query.append("  FCTRY_NM," ).append("\n"); 
		query.append("  CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("  CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("  CNTC_PSON_NM," ).append("\n"); 
		query.append("  DOR_ARR_DT," ).append("\n"); 
		query.append("  ACT_CUST_SEQ," ).append("\n"); 
		query.append("  ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("  CSTMS_CLR_NO," ).append("\n"); 
		query.append("  REP_CMDT_CD," ).append("\n"); 
		query.append("  REV_CURR_CD," ).append("\n"); 
		query.append("  TRSP_RQST_ORD_REV_AMT," ).append("\n"); 
		query.append("  DOR_PST_CD," ).append("\n"); 
		query.append("  TRO_CFM_OFC_CD," ).append("\n"); 
		query.append("  TRO_CFM_USR_ID," ).append("\n"); 
		query.append("  TRO_CFM_UPD_DT1," ).append("\n"); 
		query.append("  TRO_CFM_UPD_DT2," ).append("\n"); 
		query.append("  TRO_CFM_REV_AMT," ).append("\n"); 
		query.append("  TRO_CFM_CURR_CD," ).append("\n"); 
		query.append("  TRO_REP_CMDT_CD," ).append("\n"); 
		query.append("  TRO_LOD_REF_NO," ).append("\n"); 
		query.append("--  EX_SEP_DATA," ).append("\n"); 
		query.append("  TRSP_RQST_ORD_BND_CD," ).append("\n"); 
		query.append("  TRSP_RQST_ORD_SEQ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FM_LOC_CONTI_CD," ).append("\n"); 
		query.append("  CUST_SEQ," ).append("\n"); 
		query.append("  ACT_CUST_ADDR_SEQ," ).append("\n"); 
		query.append("  '' TRSP_CRR_MOD_CD2," ).append("\n"); 
		query.append("  TRO_SUB_SEQ," ).append("\n"); 
		query.append("  FEEDERVVD" ).append("\n"); 
		query.append("FROM TABLE(TRS_CYDOOR_CB2_PKG.F_GET_CY_CANDIDATE (@[trsp_so_ofc_cty_cd], @[strCostMode], @[sFtime], @[sTtime], @[eq_tpsz_cd], @[sNodeL], @[cydoor_div], @[ui_conti_cd]))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${strCostMode}=='CY')" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT                                                                                                           " ).append("\n"); 
		query.append("	DECODE(A.SO_IF_DIV_CD, 'O', 'On-Hire', 'F', 'Off-Hire', 'Empty Repo') SOURCE,                                 " ).append("\n"); 
		query.append("	DECODE(A.SO_IF_DIV_CD, 'O', 'CN', 'F', 'CF', 'ER') TRSP_MTY_COST_MOD_CD,                                      " ).append("\n"); 
		query.append("	A.SO_RQST_DT TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("	A.REPO_PLN_ID," ).append("\n"); 
		query.append("	A.PLN_YRWK," ).append("\n"); 
		query.append("	A.REF_SEQ," ).append("\n"); 
		query.append("	A.REF_ID,                                " ).append("\n"); 
		query.append("	'' IB_VVD_CD," ).append("\n"); 
		query.append("	'' OB_VVD_CD," ).append("\n"); 
		query.append("	A.EQ_CTRL_OFC_CD CTRL_OFC_CD," ).append("\n"); 
		query.append("	'' COP_NO," ).append("\n"); 
		query.append("	A.CNTR_NO EQ_NO,                         " ).append("\n"); 
		query.append("	A.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("	NULL COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("	'' COST_ACT_GRP_CD," ).append("\n"); 
		query.append("	NULL VNDR_SEQ,                               " ).append("\n"); 
		query.append("	'CY' TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("	DECODE(A.TRSP_MOD_CD, 'W','WD', 'T', 'TD', 'R', 'RD', '') TRSP_CRR_MOD_CD,        " ).append("\n"); 
		query.append("	SUBSTR(A.FM_YD_CD, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("	SUBSTR(A.FM_YD_CD, 6) FM_NOD_YARD,                                        " ).append("\n"); 
		query.append("	SUBSTR(A.TO_YD_CD, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("	SUBSTR(A.TO_YD_CD, 6) TO_NOD_YARD,                                        " ).append("\n"); 
		query.append("	'' VIA_NOD_CD," ).append("\n"); 
		query.append("	'' VIA_NOD_YARD," ).append("\n"); 
		query.append("	'' DOR_NOD_CD," ).append("\n"); 
		query.append("	'' DOR_NOD_YARD," ).append("\n"); 
		query.append("	'' FM_NOD_CD2," ).append("\n"); 
		query.append("	'' FM_NOD_YARD2,               " ).append("\n"); 
		query.append("	'' TO_NOD_CD2," ).append("\n"); 
		query.append("	'' TO_NOD_YARD2," ).append("\n"); 
		query.append("	'' VIA_NOD_CD2," ).append("\n"); 
		query.append("	'' VIA_NOD_YARD2," ).append("\n"); 
		query.append("	'' DOR_NOD_CD2," ).append("\n"); 
		query.append("	'' DOR_NOD_YARD2,           " ).append("\n"); 
		query.append("	A.FM_DT N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("	'' N1ST_NOD_PLN_DT_HMS," ).append("\n"); 
		query.append("	A.TO_DT LST_NOD_PLN_DT	," ).append("\n"); 
		query.append("	'' LST_NOD_PLN_DT_HMS,               " ).append("\n"); 
		query.append("	'' DOR_NOD_PLN_DT," ).append("\n"); 
		query.append("	'' DOR_NOD_PLN_DT_HMS," ).append("\n"); 
		query.append("	'' TRSP_BND_CD," ).append("\n"); 
		query.append("	'' TRNS_RQST_OFC_CD," ).append("\n"); 
		query.append("	'' TRNS_RQST_USR_ID,           " ).append("\n"); 
		query.append("	'' TRNS_RQST_RSN," ).append("\n"); 
		query.append("	'' RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("	'' CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("	'' BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("	'' BKG_NO,             " ).append("\n"); 
		query.append("	'' BL_NO," ).append("\n"); 
		query.append("	'M' CGO_TP_CD," ).append("\n"); 
		query.append("	'' PKGCODE," ).append("\n"); 
		query.append("	(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) TRUNKVVD,        " ).append("\n"); 
		query.append("	A.VSL_LANE_CD SLAN_CD," ).append("\n"); 
		query.append("	'' POR_CD," ).append("\n"); 
		query.append("	'' POL_CD," ).append("\n"); 
		query.append("	'' POD_CD," ).append("\n"); 
		query.append("	'' DEL_CD," ).append("\n"); 
		query.append("	'' SEALNO," ).append("\n"); 
		query.append("	'' SEALNO2," ).append("\n"); 
		query.append("	NULL CNTR_WGT,                  " ).append("\n"); 
		query.append("	'' WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("	NULL NOOFPKG," ).append("\n"); 
		query.append("	'' SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("	'' SHPR_CUST_NM," ).append("\n"); 
		query.append("	'' CNEE_CUST_NM," ).append("\n"); 
		query.append("	NULL CNTR_KGS_WGT," ).append("\n"); 
		query.append("	NULL CNTR_LBS_WGT," ).append("\n"); 
		query.append("	'' NTFY_CUST_NM," ).append("\n"); 
		query.append("	'' SC_NO," ).append("\n"); 
		query.append("	'' RFANO," ).append("\n"); 
		query.append("	'' CMDT_CD," ).append("\n"); 
		query.append("	'' CMDT_NAME," ).append("\n"); 
		query.append("	'' CGOR_FRT_PAY_IND_FLG,      " ).append("\n"); 
		query.append("	'' CGOR_ORG_BL_RCVR_IND_FLG," ).append("\n"); 
		query.append("	'' CGOR_CSTMS_ACPT_RE_IND_FLG," ).append("\n"); 
		query.append("	B.OWNR_CO_CD," ).append("\n"); 
		query.append("	B.IMDT_EXT_FLG," ).append("\n"); 
		query.append("	B.LSTM_CD,          " ).append("\n"); 
		query.append("	'' IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("	'' DOR_SVC_TP_CD," ).append("\n"); 
		query.append("	'' INTER_RMK," ).append("\n"); 
		query.append("	'' CRE_USR_ID," ).append("\n"); 
		query.append("	'' UPD_USR_ID," ).append("\n"); 
		query.append("	'' TRSP_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("	'' FEEDERVVD," ).append("\n"); 
		query.append("	'' TRSP_NXT_PORT_CD" ).append("\n"); 
		query.append("	, '' LST_LOC_CD," ).append("\n"); 
		query.append("	A.REPO_PURP_RMK SPCL_INSTR_RMK," ).append("\n"); 
		query.append("	'' CUSTOMSCLEARANCENO," ).append("\n"); 
		query.append("	'' CUSTOMSCLEARANCE," ).append("\n"); 
		query.append("	'' CUST_CNT_CD,       " ).append("\n"); 
		query.append("	'' DOR_DE_ADDR," ).append("\n"); 
		query.append("	'' MLT_STOP_DE_FLG," ).append("\n"); 
		query.append("	'' PROC_CFM_IND_CD," ).append("\n"); 
		query.append("	'' TRSP_COST_DTL_MOD_SEP," ).append("\n"); 
		query.append("	'' UPLN_SO_FLG,              " ).append("\n"); 
		query.append("	'' CNTR_PKUP_NO," ).append("\n"); 
		query.append("	'' AVAL_DT," ).append("\n"); 
		query.append("	'' AVAL_DT_HMS," ).append("\n"); 
		query.append("	'' LST_FREE_DT, " ).append("\n"); 
		query.append("	'' LST_FREE_DT_HMS," ).append("\n"); 
		query.append("	'' TRO_CNFM," ).append("\n"); 
		query.append("	NULL TRO_SEQ," ).append("\n"); 
		query.append("	NULL BKG_QTY," ).append("\n"); 
		query.append("	'' CONTI_CD, " ).append("\n"); 
		query.append("	'' FCTRY_NM, " ).append("\n"); 
		query.append("	'' CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("	'' CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("	'' CNTC_PSON_NM, " ).append("\n"); 
		query.append("	'' DOR_ARR_DT," ).append("\n"); 
		query.append("	NULL ACT_CUST_SEQ," ).append("\n"); 
		query.append("	'' ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("	'' CSTMS_CLR_NO," ).append("\n"); 
		query.append("	'' REP_CMDT_CD," ).append("\n"); 
		query.append("	'' REV_CURR_CD," ).append("\n"); 
		query.append("	NULL TRSP_RQST_ORD_REV_AMT," ).append("\n"); 
		query.append("	'' DOR_PST_CD," ).append("\n"); 
		query.append("	'' TRO_CFM_OFC_CD," ).append("\n"); 
		query.append("	'' TRO_CFM_USR_ID," ).append("\n"); 
		query.append("	'' TRO_CFM_UPD_DT1," ).append("\n"); 
		query.append("	'' TRO_CFM_UPD_DT2," ).append("\n"); 
		query.append("	NULL TRO_CFM_REV_AMT," ).append("\n"); 
		query.append("	'' TRO_CFM_CURR_CD, " ).append("\n"); 
		query.append("	'' TRO_REP_CMDT_CD," ).append("\n"); 
		query.append("	'' TRO_LOD_REF_NO," ).append("\n"); 
		query.append("	'' TRSP_RQST_ORD_BND_CD," ).append("\n"); 
		query.append("	NULL TRSP_RQST_ORD_SEQ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    NULL FM_LOC_CONTI_CD," ).append("\n"); 
		query.append("    NULL CUST_SEQ," ).append("\n"); 
		query.append("    NULL ACT_CUST_ADDR_SEQ," ).append("\n"); 
		query.append("    NULL TRSP_CRR_MOD_CD2," ).append("\n"); 
		query.append("    NULL TRO_SUB_SEQ," ).append("\n"); 
		query.append("    NULL FEEDERVVD" ).append("\n"); 
		query.append("FROM EQR_REPO_EXE_SO_IF A, MST_CONTAINER B                                                                       " ).append("\n"); 
		query.append("WHERE A.WO_RQST_FLG = 'Y'                                                                                        " ).append("\n"); 
		query.append("AND A.WO_EXE_FLG = 'N'                                                                                           " ).append("\n"); 
		query.append("AND A.TRSP_SO_STS_CD = 'P'                                                                                       " ).append("\n"); 
		query.append("AND A.CO_CD = 'H'                                                                                                " ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO(+)                                                                                     " ).append("\n"); 
		query.append("AND A.FM_YD_CD = @[sNodeL]                                                                                               " ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = @[eq_tpsz_cd]                                                                                           " ).append("\n"); 
		query.append("AND A.EQ_CTRL_OFC_CD = @[trsp_so_ofc_cty_cd]                                                                                         " ).append("\n"); 
		query.append("AND A.FM_DT = @[lst_nod_pln_dt]                                                                                                  " ).append("\n"); 
		query.append("AND NOT EXISTS                                                                                                   " ).append("\n"); 
		query.append("(                                                                                                                " ).append("\n"); 
		query.append("	SELECT 'X' FROM MDM_LOCATION LOC, EQR_REPO_EXE_SO_IF BB                                                       " ).append("\n"); 
		query.append("	WHERE LOC.LOC_CD = SUBSTR(BB.FM_YD_CD, 1, 5)                                                                  " ).append("\n"); 
		query.append("	AND LOC.CONTI_CD = 'M'                                                                                        " ).append("\n"); 
		query.append("	AND A.TRSP_MOD_CD = 'R'                                                                                       " ).append("\n"); 
		query.append("	AND A.REPO_PLN_ID = BB.REPO_PLN_ID                                                                            " ).append("\n"); 
		query.append("	AND A.PLN_YRWK = BB.PLN_YRWK                                                                                  " ).append("\n"); 
		query.append("	AND A.REF_ID = BB.REF_ID                                                                                      " ).append("\n"); 
		query.append("	AND A.REF_SEQ = BB.REF_SEQ                                                                                    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}