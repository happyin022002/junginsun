/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CY&DOOR S/O Correction 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_plandate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tonode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmnode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("transmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vianode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_plandate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dorloc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOListRSQL").append("\n"); 
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
		query.append("SELECT  AAA.REPO_PLN_ID" ).append("\n"); 
		query.append("      , AAA.PLN_YRWK" ).append("\n"); 
		query.append("      , AAA.REF_ID" ).append("\n"); 
		query.append("      , AAA.REF_SEQ" ).append("\n"); 
		query.append("      , AAA.TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("      , (AAA.TRSP_SO_OFC_CTY_CD||AAA.TRSP_SO_SEQ)   AS TRSP_SO_OFC_SEQ" ).append("\n"); 
		query.append("	  , AAA.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("      , AAA.COP_NO" ).append("\n"); 
		query.append("      , AAA.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      , AAA.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("      , AAA.EQ_NO" ).append("\n"); 
		query.append("	  , AAA.EQ_NO BEFORE_EQ_NO" ).append("\n"); 
		query.append("      , AAA.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      , AAA.ORG_EQ_TPSZ_CD" ).append("\n"); 
		query.append("      , (AAA.TRSP_WO_OFC_CTY_CD||AAA.TRSP_WO_SEQ)   AS TRSP_WO_OFC_SEQ" ).append("\n"); 
		query.append("	  , AAA.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	  , AAA.TRSP_WO_SEQ" ).append("\n"); 
		query.append("      , AAA.CNTR_SLT_NO" ).append("\n"); 
		query.append("      , AAA.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("      , AAA.VNDR_SEQ" ).append("\n"); 
		query.append("      , AAA.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      , AAA.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , AAA.FM_NOD_CD" ).append("\n"); 
		query.append("      , AAA.FM_NOD_YARD" ).append("\n"); 
		query.append("	  , AAA.FM_NOD_CD_NM" ).append("\n"); 
		query.append("      , AAA.TO_NOD_CD" ).append("\n"); 
		query.append("      , AAA.TO_NOD_YARD" ).append("\n"); 
		query.append("	  , AAA.TO_NOD_CD_NM" ).append("\n"); 
		query.append("      , AAA.VIA_NOD_CD" ).append("\n"); 
		query.append("      , AAA.VIA_NOD_YARD" ).append("\n"); 
		query.append("	  , AAA.VIA_NOD_CD_NM" ).append("\n"); 
		query.append("      , AAA.DOR_NOD_CD" ).append("\n"); 
		query.append("      , AAA.DOR_NOD_YARD" ).append("\n"); 
		query.append("	  , AAA.DOR_NOD_CD_NM	  " ).append("\n"); 
		query.append("      , '' FM_NOD_CD2" ).append("\n"); 
		query.append("      , '' FM_NOD_YARD2" ).append("\n"); 
		query.append("      , '' TO_NOD_CD2" ).append("\n"); 
		query.append("      , '' TO_NOD_YARD2" ).append("\n"); 
		query.append("      , '' VIA_NOD_CD2" ).append("\n"); 
		query.append("      , '' VIA_NOD_YARD2" ).append("\n"); 
		query.append("      , '' DOR_NOD_CD2" ).append("\n"); 
		query.append("      , '' DOR_NOD_YARD2" ).append("\n"); 
		query.append("      , AAA.BKG_NO" ).append("\n"); 
		query.append("      , AAA.BL_NO" ).append("\n"); 
		query.append("      , AAA.CONTI_CD" ).append("\n"); 
		query.append("      , SUBSTR(AAA.CNEE_CUST_INFO,1,2)                  AS CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append("      , TO_NUMBER(DECODE(SUBSTR(AAA.CNEE_CUST_INFO,3,8), 999999, '', TRIM(SUBSTR(AAA.CNEE_CUST_INFO,3,8)))) AS CNEE_CUST_SEQ" ).append("\n"); 
		query.append("      , SUBSTR(AAA.CNEE_CUST_INFO,11,500)               AS CNEE_CUST_NM" ).append("\n"); 
		query.append("      , SUBSTR(AAA.SHPR_CUST_INFO,1,2)                  AS SHPR_CUST_CNT_CD" ).append("\n"); 
		query.append("      , TO_NUMBER(DECODE(SUBSTR(AAA.SHPR_CUST_INFO,3,8), 999999, '', TRIM(SUBSTR(AAA.SHPR_CUST_INFO,3,8)))) AS SHPR_CUST_SEQ" ).append("\n"); 
		query.append("      , SUBSTR(AAA.SHPR_CUST_INFO,11,500)               AS SHPR_CUST_NM" ).append("\n"); 
		query.append("      , AAA.NTFY_CUST_NM" ).append("\n"); 
		query.append("      , AAA.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("      , AAA.N1ST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("      , AAA.LST_NOD_PLN_DT" ).append("\n"); 
		query.append("      , AAA.LST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("      , AAA.DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("      , AAA.DOR_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("      , AAA.TRSP_BND_CD" ).append("\n"); 
		query.append("      , AAA.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("      , AAA.TRSP_SO_CMB_SEQ" ).append("\n"); 
		query.append("      , AAA.CGO_TP_CD" ).append("\n"); 
		query.append("      , AAA.CNTR_WGT" ).append("\n"); 
		query.append("      , AAA.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("      , AAA.CMDT_CD" ).append("\n"); 
		query.append("      , AAA.CNTR_KGS_WGT" ).append("\n"); 
		query.append("      , AAA.CNTR_LBS_WGT" ).append("\n"); 
		query.append("      , AAA.TRUNKVVD" ).append("\n"); 
		query.append("      , AAA.CUST_CNT_CD" ).append("\n"); 
		query.append("      , AAA.ACT_CUST_CD" ).append("\n"); 
		query.append("      , AAA.DOR_DE_ADDR" ).append("\n"); 
		query.append("      , AAA.MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("      , AAA.DOR_SVC_TP_CD" ).append("\n"); 
		query.append("      , AAA.DOR_SVC_TP_CD AS DOR_SVC_TP_CD2" ).append("\n"); 
		query.append("      , DECODE(AAA.INTER_RMK_CHK, '', '', 'Y') INTER_RMK" ).append("\n"); 
		query.append("      , AAA.CRE_USR_ID" ).append("\n"); 
		query.append("      , AAA.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      , AAA.IB_VVD_CD" ).append("\n"); 
		query.append("      , AAA.OB_VVD_CD" ).append("\n"); 
		query.append("      , AAA.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("      , AAA.BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("      , AAA.SLAN_CD" ).append("\n"); 
		query.append("      , AAA.POR_CD" ).append("\n"); 
		query.append("      , AAA.POL_CD" ).append("\n"); 
		query.append("      , AAA.POD_CD" ).append("\n"); 
		query.append("      , AAA.DEL_CD" ).append("\n"); 
		query.append("      , AAA.CRE_OFC_CD" ).append("\n"); 
		query.append("      , AAA.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      , NVL(REGEXP_SUBSTR(AAA.FOC, '[^|]+', 1, 1), 'N') AS CGOR_FRT_PAY_IND_FLG" ).append("\n"); 
		query.append("      , NVL(REGEXP_SUBSTR(AAA.FOC, '[^|]+', 1, 2), 'N') AS CGOR_ORG_BL_RCVR_IND_FLG" ).append("\n"); 
		query.append("      , NVL(REGEXP_SUBSTR(AAA.FOC, '[^|]+', 1, 3), 'N') AS CGOR_CSTMS_ACPT_RE_IND_FLG" ).append("\n"); 
		query.append("      , AAA.IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("      , AAA.OWNR_CO_CD" ).append("\n"); 
		query.append("      , SUBSTR(AAA.MST_CNTR, 1, 1) AS IMDT_EXT_FLG" ).append("\n"); 
		query.append("      , SUBSTR(AAA.MST_CNTR, 2)    AS LSTM_CD" ).append("\n"); 
		query.append("      , AAA.LST_LOC_CD" ).append("\n"); 
		query.append("      , '' LSTM_EXP_FLG" ).append("\n"); 
		query.append("      , AAA.SEALNO" ).append("\n"); 
		query.append("      , AAA.SEALNO2" ).append("\n"); 
		query.append("      , TRIM(REGEXP_SUBSTR(PKGCODE_NOOFPKG, '[^$]+', 1, 1)) AS PKGCODE" ).append("\n"); 
		query.append("      , TRIM(REGEXP_SUBSTR(PKGCODE_NOOFPKG, '[^$]+', 1, 2)) AS NOOFPKG" ).append("\n"); 
		query.append("      , TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(TRIM(REGEXP_SUBSTR(PKGCODE_NOOFPKG, '[^$]+',1, 3)), TRIM(REGEXP_SUBSTR(PKGCODE_NOOFPKG, '[^$]+',1, 4))) AS VGM_KGS_WGT" ).append("\n"); 
		query.append("      , TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(TRIM(REGEXP_SUBSTR(PKGCODE_NOOFPKG, '[^$]+',1, 3)), TRIM(REGEXP_SUBSTR(PKGCODE_NOOFPKG, '[^$]+',1, 4))) AS VGM_LBS_WGT" ).append("\n"); 
		query.append("      , AAA.SC_NO" ).append("\n"); 
		query.append("      , AAA.RFANO" ).append("\n"); 
		query.append("      , AAA.TRSP_COST_DTL_MOD_SEP" ).append("\n"); 
		query.append("      , TRIM(SUBSTR(TRO_CNFM,1,3))   AS DCGO_SEQ" ).append("\n"); 
		query.append("      , TRIM(SUBSTR(TRO_CNFM,4,3))   AS RC_SEQ" ).append("\n"); 
		query.append("      , TRIM(SUBSTR(TRO_CNFM,7,3))   AS AWK_CGO_SEQ" ).append("\n"); 
		query.append("      , TRIM(SUBSTR(TRO_CNFM,10,50)) AS CUSTOMSCLEARANCENO" ).append("\n"); 
		query.append("      , DECODE(TRIM(SUBSTR(TRO_CNFM,10,50)),NULL,'','Y') CUSTOMSCLEARANCE" ).append("\n"); 
		query.append("      , DECODE(AAA.CONTI_CD, 'E', TRIM(SUBSTR(TRO_CNFM,60)), MDM_CO_CMDT_NM) CMDT_NAME" ).append("\n"); 
		query.append("      , REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 1) AS CNTR_PKUP_NO" ).append("\n"); 
		query.append("      , SUBSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 3), 1, INSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 3), ' ') - 1) AS AVAL_DT" ).append("\n"); 
		query.append("      , SUBSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 3), INSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 3), ' ') + 1) AS AVAL_DT_HMS" ).append("\n"); 
		query.append("      , SUBSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 4), 1, INSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 3), ' ') - 1) AS LST_FREE_DT" ).append("\n"); 
		query.append("      , SUBSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 4), INSTR(REGEXP_SUBSTR(AAA.PKUP_INFO, '[^^]+', 1, 3), ' ') + 1) AS LST_FREE_DT_HMS" ).append("\n"); 
		query.append("      , AAA.TRO_CNFM" ).append("\n"); 
		query.append("      , AAA.TRO_SEQ" ).append("\n"); 
		query.append("      , AAA.BKG_QTY" ).append("\n"); 
		query.append("      , '' TRSP_RQST_BKG_FLG" ).append("\n"); 
		query.append("      , AAA.SUB_EQ_TPSZ_CD" ).append("\n"); 
		query.append("      , AAA.CNTR_SUB_FLG" ).append("\n"); 
		query.append("      , AAA.FCTRY_NM" ).append("\n"); 
		query.append("      , AAA.CNTC_PSON_NM" ).append("\n"); 
		query.append("      , AAA.CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("      , AAA.CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("      , AAA.DOR_PST_CD" ).append("\n"); 
		query.append("      , AAA.TRO_CFM_OFC_CD" ).append("\n"); 
		query.append("      , AAA.TRO_CFM_USR_ID" ).append("\n"); 
		query.append("      , TO_CHAR(AAA.TRO_CFM_UPD_DT, 'YYYYMMDD')  AS  TRO_CFM_UPD_DT1" ).append("\n"); 
		query.append("      , TO_CHAR(AAA.TRO_CFM_UPD_DT, 'HH24MISS')  AS  TRO_CFM_UPD_DT2" ).append("\n"); 
		query.append("      , AAA.TRO_LOD_REF_NO" ).append("\n"); 
		query.append("      , AAA.BKG_STS_CD" ).append("\n"); 
		query.append("      , AAA.REV_CURR_CD" ).append("\n"); 
		query.append("      , AAA.TRSP_RQST_ORD_REV_AMT" ).append("\n"); 
		query.append("      , '' TRSP_CRR_MOD_CD2" ).append("\n"); 
		query.append("      , '' LSE_CNTR_FLG" ).append("\n"); 
		query.append("      , AAA.RPLN_UMCH_FLG" ).append("\n"); 
		query.append("      , SUBSTR(AAA.RQST_INFO, 1, INSTR(AAA.RQST_INFO, '^', 1, 1) -1) AS TRNS_RQST_OFC_CD" ).append("\n"); 
		query.append("      , SUBSTR(AAA.RQST_INFO, INSTR(AAA.RQST_INFO, '^', 1, 1) + 1, INSTR(AAA.RQST_INFO, '^', 1, 2) - INSTR(AAA.RQST_INFO, '^', 1, 1) - 1) AS TRNS_RQST_USR_ID" ).append("\n"); 
		query.append("      , SUBSTR(AAA.RQST_INFO, INSTR(AAA.RQST_INFO, '^', 1, 2) + 1, INSTR(AAA.RQST_INFO, '^', 1, 3) - INSTR(AAA.RQST_INFO, '^', 1, 2) - 1) AS TRNS_RQST_RSN" ).append("\n"); 
		query.append("      , AAA.CNMV_STS_CD" ).append("\n"); 
		query.append("      , AAA.CRNT_YD_CD" ).append("\n"); 
		query.append("      , AAA.CNMV_DT" ).append("\n"); 
		query.append("	  , AAA.CNG_IND_FLG" ).append("\n"); 
		query.append("	  , AAA.CNG_IND_FLG	AS CNG_IND_FLG_IMG" ).append("\n"); 
		query.append("      , AAA.BKG_STS_CD_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT (SELECT  RPAD(NVL(TO_CHAR(DCGO_SEQ), ' '), 3, ' ')" ).append("\n"); 
		query.append("                  ||RPAD(NVL(TO_CHAR(RC_SEQ), ' '), 3, ' ')" ).append("\n"); 
		query.append("                  ||RPAD(NVL(TO_CHAR(AWK_CGO_SEQ), ' '), 3, ' ')" ).append("\n"); 
		query.append("                  ||RPAD(NVL(CSTMS_CLR_NO, ' '), 50, ' ')" ).append("\n"); 
		query.append("                  ||NVL(REP_CMDT_DESC, ' ')" ).append("\n"); 
		query.append("              FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("             WHERE BKG_NO    = AA.BKG_NO" ).append("\n"); 
		query.append("               AND IO_BND_CD = AA.TRSP_BND_CD" ).append("\n"); 
		query.append("               AND TRO_SEQ   = AA.TRO_SEQ) TRO_HD" ).append("\n"); 
		query.append("           ,DECODE(AA.TRSP_COST_DTL_MOD_CD, 'DOOR', DECODE(AA.TRO_SEQ, NULL, 'N', 'Y'), NULL) AS TRO_CNFM" ).append("\n"); 
		query.append("           ,( SELECT  SC.TRNS_RQST_OFC_CD" ).append("\n"); 
		query.append("                  || '^' ||SC.TRNS_RQST_USR_ID" ).append("\n"); 
		query.append("                  || '^' ||SC.TRNS_RQST_RSN" ).append("\n"); 
		query.append("                  || '^'" ).append("\n"); 
		query.append("              FROM SCE_PLN_SO_LIST SC" ).append("\n"); 
		query.append("             WHERE SC.COP_NO = AA.COP_NO" ).append("\n"); 
		query.append("               AND SC.COST_ACT_GRP_SEQ = AA.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            ) RQST_INFO" ).append("\n"); 
		query.append("           ,AA.*" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                  A.REPO_PLN_ID" ).append("\n"); 
		query.append("                , A.CONTI_CD" ).append("\n"); 
		query.append("                , A.PLN_YRWK" ).append("\n"); 
		query.append("                , A.REF_ID" ).append("\n"); 
		query.append("                , A.REF_SEQ" ).append("\n"); 
		query.append("                , A.TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("				, A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("                , A.COP_NO" ).append("\n"); 
		query.append("                , A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                , A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                , A.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                , A.CNTR_SLT_NO" ).append("\n"); 
		query.append("                , A.CNTR_KGS_WGT" ).append("\n"); 
		query.append("                , A.CNTR_LBS_WGT" ).append("\n"); 
		query.append("                , A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                , A.EQ_NO" ).append("\n"); 
		query.append("                , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                , A.ORG_EQ_TPSZ_CD" ).append("\n"); 
		query.append("                , A.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                , A.VNDR_SEQ" ).append("\n"); 
		query.append("                , DECODE(A.TRSP_COST_DTL_MOD_CD, 'CY', 'CY', 'DR', 'DOOR', 'CY') TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("                , A.TRSP_COST_DTL_MOD_CD TRSP_COST_DTL_MOD_SEP" ).append("\n"); 
		query.append("                , A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.FM_NOD_CD,1,5) FM_NOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.FM_NOD_CD,6,2) FM_NOD_YARD" ).append("\n"); 
		query.append("				, DECODE(LENGTH(A.FM_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(A.FM_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.FM_NOD_CD)) FM_NOD_CD_NM" ).append("\n"); 
		query.append("                , SUBSTR(A.TO_NOD_CD,1,5) TO_NOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.TO_NOD_CD,6,2) TO_NOD_YARD" ).append("\n"); 
		query.append("				, DECODE(LENGTH(A.TO_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(A.TO_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.TO_NOD_CD)) TO_NOD_CD_NM" ).append("\n"); 
		query.append("                , SUBSTR(A.VIA_NOD_CD,1,5) VIA_NOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.VIA_NOD_CD,6,2) VIA_NOD_YARD" ).append("\n"); 
		query.append("				, DECODE(LENGTH(A.VIA_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(A.VIA_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.VIA_NOD_CD)) VIA_NOD_CD_NM" ).append("\n"); 
		query.append("                , SUBSTR(A.DOR_NOD_CD,1,5) DOR_NOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.DOR_NOD_CD,6,2) DOR_NOD_YARD" ).append("\n"); 
		query.append("				, DECODE(LENGTH(A.DOR_NOD_CD), 7, (SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD = A.DOR_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.DOR_NOD_CD)) AS DOR_NOD_CD_NM		" ).append("\n"); 
		query.append("                , A.BKG_NO BKG_NO" ).append("\n"); 
		query.append("                , A.BL_NO" ).append("\n"); 
		query.append("                , TO_CHAR(A.N1ST_NOD_PLN_DT, 'YYYYMMDD')   N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.N1ST_NOD_PLN_DT, 'HH24:MI:SS') N1ST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("                , TO_CHAR(A.LST_NOD_PLN_DT, 'YYYYMMDD')    LST_NOD_PLN_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.LST_NOD_PLN_DT, 'HH24:MI:SS')  LST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("                , TO_CHAR(A.DOR_NOD_PLN_DT, 'YYYYMMDD')    DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.DOR_NOD_PLN_DT, 'HH24:MI:SS')  DOR_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("                , A.TRSP_BND_CD" ).append("\n"); 
		query.append("                , A.CUST_NOMI_TRKR_FLG                     CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                , (A.CUST_CNT_CD||A.CUST_SEQ)              CUST_CNT_CD" ).append("\n"); 
		query.append("                , (A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ)      ACT_CUST_CD" ).append("\n"); 
		query.append("                , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                , A.ACT_CUST_ADDR_SEQ" ).append("\n"); 
		query.append("                , A.TRSP_SO_CMB_SEQ" ).append("\n"); 
		query.append("                , A.CGO_TP_CD" ).append("\n"); 
		query.append("                , A.CNTR_WGT" ).append("\n"); 
		query.append("                , A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                , A.CMDT_CD" ).append("\n"); 
		query.append("                , (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) TRUNKVVD" ).append("\n"); 
		query.append("                , A.DOR_DE_ADDR" ).append("\n"); 
		query.append("                , A.MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("                , A.DOR_SVC_TP_CD" ).append("\n"); 
		query.append("                , (SELECT MAX(RMK.BKG_NO) FROM TRS_INTER_RMK RMK WHERE RMK.BKG_NO = A.BKG_NO AND NVL(RMK.EQ_NO, 'X') = NVL2(RMK.EQ_NO, A.EQ_NO, 'X')  AND NVL(RMK.DELT_FLG, 'N') = 'N') AS INTER_RMK_CHK" ).append("\n"); 
		query.append("                , A.CRE_USR_ID" ).append("\n"); 
		query.append("                , A.UPD_USR_ID" ).append("\n"); 
		query.append("                , A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                , A.IB_VVD_CD" ).append("\n"); 
		query.append("                , A.OB_VVD_CD" ).append("\n"); 
		query.append("                , REPLACE(A.SPCL_INSTR_RMK, CHR(13)||CHR(10), ' ') SPCL_INSTR_RMK" ).append("\n"); 
		query.append("                , A.BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("                , A.SLAN_CD" ).append("\n"); 
		query.append("                , A.POR_CD" ).append("\n"); 
		query.append("                , A.POL_CD" ).append("\n"); 
		query.append("                , A.POD_CD" ).append("\n"); 
		query.append("                , A.DEL_CD" ).append("\n"); 
		query.append("                , A.CRE_OFC_CD" ).append("\n"); 
		query.append("                , A.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                , A.IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("                , A.OWNR_CO_CD" ).append("\n"); 
		query.append("                , A.LST_LOC_CD" ).append("\n"); 
		query.append("                , B.SC_NO SC_NO" ).append("\n"); 
		query.append("                ,CASE WHEN A.TRSP_BND_CD = 'O' AND A.CONTI_CD = 'M' AND A.TRSP_COST_DTL_MOD_CD <> 'DR' THEN " ).append("\n"); 
		query.append("                    (SELECT PKUP_EDI_322_NO || '^^^'" ).append("\n"); 
		query.append("                     FROM (SELECT  /*+ INDEX (G XAK4EDI_322_MSG) */  G.BKG_EDI_322_NO" ).append("\n"); 
		query.append("                            ,G.EQ_NO" ).append("\n"); 
		query.append("                            ,G.DEST_LOC_NM" ).append("\n"); 
		query.append("                            ,G.PKUP_EDI_322_NO" ).append("\n"); 
		query.append("                            ,ROW_NUMBER() OVER(partition BY G.EQ_NO, G.BKG_EDI_322_NO, G.DEST_LOC_NM order by G.EVNT_DT DESC, G.EQ_NO DESC, G.EDI_322_STS_CD DESC) RK" ).append("\n"); 
		query.append("                          FROM EDI_322_MSG G) P1" ).append("\n"); 
		query.append("                    WHERE P1.BKG_EDI_322_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND P1.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("                      AND P1.DEST_LOC_NM = A.FM_NOD_CD" ).append("\n"); 
		query.append("                      AND P1.RK = 1" ).append("\n"); 
		query.append("                      AND ROWNUM=1" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  ELSE (SELECT TRS_GET_PKUP_NO_FNC(A.BKG_NO, A.EQ_NO, '', '', '', A.FM_NOD_CD) FROM DUAL)  " ).append("\n"); 
		query.append("                 END PKUP_INFO" ).append("\n"); 
		query.append("                , A.SUB_EQ_TPSZ_CD" ).append("\n"); 
		query.append("                , A.CNTR_SUB_FLG" ).append("\n"); 
		query.append("                , A.FCTRY_NM" ).append("\n"); 
		query.append("                , A.CNTC_PSON_NM" ).append("\n"); 
		query.append("                , A.CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("                , A.CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("                , A.DOR_PST_CD" ).append("\n"); 
		query.append("                , A.TRO_CFM_OFC_CD" ).append("\n"); 
		query.append("                , A.TRO_CFM_USR_ID" ).append("\n"); 
		query.append("                , A.TRO_CFM_UPD_DT" ).append("\n"); 
		query.append("                , A.TRO_LOD_REF_NO" ).append("\n"); 
		query.append("                , A.REV_CURR_CD" ).append("\n"); 
		query.append("                , A.TRSP_RQST_ORD_REV_AMT" ).append("\n"); 
		query.append("                , B.MTY_BKG_STS_CD AS BKG_STS_CD" ).append("\n"); 
		query.append("                , B.RFA_NO AS RFANO" ).append("\n"); 
		query.append("                ,(SELECT PCK_TP_CD || '$' || PCK_QTY || '$' || NVL(VGM_WGT_UT_CD, 'KGS') || '$' || NVL(VGM_WGT, 0)" ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                   WHERE BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("                     AND CNTR_NO = A.EQ_NO) AS PKGCODE_NOOFPKG" ).append("\n"); 
		query.append("                ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = A.BKG_NO AND CNTR_NO = A.EQ_NO AND CNTR_SEAL_SEQ = 1) AS SEALNO" ).append("\n"); 
		query.append("                ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = A.BKG_NO AND CNTR_NO = A.EQ_NO AND CNTR_SEAL_SEQ = 2) AS SEALNO2" ).append("\n"); 
		query.append("                , (SELECT TRO_SEQ" ).append("\n"); 
		query.append("                     FROM SCE_TRO_MAPG" ).append("\n"); 
		query.append("                    WHERE COP_NO        = A.COP_NO" ).append("\n"); 
		query.append("                      AND IO_BND_CD     = A.TRSP_BND_CD" ).append("\n"); 
		query.append("                      AND AREA_CONTI_CD = A.CONTI_CD) AS TRO_SEQ" ).append("\n"); 
		query.append("                , (SELECT CMDT_NM" ).append("\n"); 
		query.append("                     FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                    WHERE CMDT_CD = A.CMDT_CD) AS MDM_CO_CMDT_NM" ).append("\n"); 
		query.append("                , (SELECT LPAD(NVL(BC.CUST_CNT_CD, ' '), 2, ' ') || LPAD(TO_CHAR(NVL(BC.CUST_SEQ, 999999)), 8, ' ') || BC.CUST_NM" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                    WHERE BC.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND BC.BKG_CUST_TP_CD = 'C')    CNEE_CUST_INFO" ).append("\n"); 
		query.append("                , (SELECT LPAD(NVL(BC.CUST_CNT_CD, ' '), 2, ' ') || LPAD(TO_CHAR(NVL(BC.CUST_SEQ, 999999)), 8, ' ') || BC.CUST_NM" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                    WHERE BC.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND BC.BKG_CUST_TP_CD = 'S')    SHPR_CUST_INFO" ).append("\n"); 
		query.append("                , (SELECT BC.CUST_NM" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                    WHERE BC.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND BC.BKG_CUST_TP_CD = 'N')    NTFY_CUST_NM" ).append("\n"); 
		query.append("                , (SELECT NVL(FRT_CLT_FLG, 'N') || '|' || NVL(OBL_RDEM_FLG, 'N') || '|' || DECODE(CSTMS_CLR_CD, 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("                  FROM BKG_CGO_RLSE" ).append("\n"); 
		query.append("                 WHERE BL_NO = A.BL_NO) FOC" ).append("\n"); 
		query.append("                , (SELECT NVL(IMDT_EXT_FLG, ' ')||NVL(LSTM_CD, ' ')" ).append("\n"); 
		query.append("                     FROM MST_CONTAINER" ).append("\n"); 
		query.append("                    WHERE CNTR_NO  = A.EQ_NO) MST_CNTR" ).append("\n"); 
		query.append("                , (SELECT LISTAGG(DECODE(NVL(QTY.EQ_SUBST_CGO_QTY, 0), 0, QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                          ||' '||QTY.OP_CNTR_QTY, QTY.CNTR_TPSZ_CD||' '||QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("                          ||'-SUB '||QTY.EQ_SUBST_CNTR_TPSZ_CD||' '||QTY.EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                          ), ', ') WITHIN GROUP (ORDER BY QTY.BKG_NO)" ).append("\n"); 
		query.append("                     FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                    WHERE QTY.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                  ) BKG_QTY" ).append("\n"); 
		query.append("                , A.RPLN_UMCH_FLG" ).append("\n"); 
		query.append("                , MST.CNMV_STS_CD AS CNMV_STS_CD" ).append("\n"); 
		query.append("                , MST.CRNT_YD_CD AS CRNT_YD_CD" ).append("\n"); 
		query.append("                , TO_CHAR(MST.CNMV_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_DT" ).append("\n"); 
		query.append("				, NVL((SELECT CNG_IND_FLG FROM TRS_TRSP_SVC_ORD_CNG ZZ WHERE ZZ.TRSP_SO_OFC_CTY_CD= A.TRSP_SO_OFC_CTY_CD AND ZZ.TRSP_SO_SEQ = A.TRSP_SO_SEQ AND ZZ.TRSP_SO_SUB_SEQ = 1 AND ZZ.BKG_NO = A.BKG_NO), 'N') CNG_IND_FLG" ).append("\n"); 
		query.append("                , DECODE(A.CGO_TP_CD, 'F', DECODE(B.BKG_STS_CD, 'W', INTG.INTG_CD_VAL_DESC)) BKG_STS_CD_NM" ).append("\n"); 
		query.append("         FROM  TRS_TRSP_SVC_ORD            A" ).append("\n"); 
		query.append("              ,BKG_BOOKING                 B" ).append("\n"); 
		query.append("              ,MST_CONTAINER			   MST" ).append("\n"); 
		query.append("              ,COM_INTG_CD_DTL			   INTG" ).append("\n"); 
		query.append("              #if (${frm_plandate} != '' && ${dateCondition} == 'W')" ).append("\n"); 
		query.append("                 ,TRS_TRSP_WRK_ORD C" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("        WHERE  A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("        AND    A.EQ_NO			 = MST.CNTR_NO(+)" ).append("\n"); 
		query.append("      #if(${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        AND MST.CNMV_STS_CD = @[cnmv_sts_cd] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("        AND    A.CRE_OFC_CD      = @[form_usr_ofc_cd]" ).append("\n"); 
		query.append("              #if (${frm_plandate} != '' && ${to_plandate} != '' )" ).append("\n"); 
		query.append("                  #if (${dateCondition} == 'S')" ).append("\n"); 
		query.append("                      AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[frm_plandate], 'YYYYMMDD') AND TO_DATE(@[to_plandate], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                  #elseif (${dateCondition} == 'P')" ).append("\n"); 
		query.append("                      AND A.N1ST_NOD_PLN_DT BETWEEN TO_DATE(@[frm_plandate], 'YYYYMMDD') AND TO_DATE(@[to_plandate], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                  #elseif (${dateCondition} == 'D')" ).append("\n"); 
		query.append("                      AND A.DOR_NOD_PLN_DT BETWEEN TO_DATE(@[frm_plandate], 'YYYYMMDD') AND TO_DATE(@[to_plandate], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                  #elseif (${dateCondition} == 'W')" ).append("\n"); 
		query.append("                      AND A.TRSP_WO_OFC_CTY_CD 					= C.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND A.TRSP_WO_SEQ        					= C.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                      AND C.LOCL_CRE_DT BETWEEN TO_DATE(@[frm_plandate], 'YYYYMMDD') AND TO_DATE(@[to_plandate], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("        AND  A.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("        AND  A.TRSP_SO_TP_CD   = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${svc_provider} != '')" ).append("\n"); 
		query.append("            AND A.VNDR_SEQ  = @[svc_provider]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bound} != 'ALL')" ).append("\n"); 
		query.append("            AND A.TRSP_BND_CD  = @[bound]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${transmode} != 'ALL')" ).append("\n"); 
		query.append("            AND A.TRSP_CRR_MOD_CD  = @[transmode]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${costmode} != 'ALL')" ).append("\n"); 
		query.append("            AND A.TRSP_COST_DTL_MOD_CD  = @[costmode]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${frmnode} != '')" ).append("\n"); 
		query.append("            AND A.FM_NOD_CD LIKE @[frmnode] ||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		-- Multi From Node로 조회" ).append("\n"); 
		query.append("		#if ($arr_fmnode.size() > 0) " ).append("\n"); 
		query.append("		    AND A.FM_NOD_CD in (" ).append("\n"); 
		query.append("		    #foreach( ${key} in ${arr_fmnode}) " ).append("\n"); 
		query.append("			    #if($velocityCount < $arr_fmnode.size()) " ).append("\n"); 
		query.append("			        '$key', " ).append("\n"); 
		query.append("			    #else " ).append("\n"); 
		query.append("		            '$key' " ).append("\n"); 
		query.append("			    #end " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if (${vianode} != '')" ).append("\n"); 
		query.append("            AND A.VIA_NOD_CD LIKE @[vianode] ||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${tonode} != '')" ).append("\n"); 
		query.append("            AND A.TO_NOD_CD LIKE @[tonode] ||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		-- Multi To Node로 조회" ).append("\n"); 
		query.append("		#if ($arr_tonode.size() > 0) " ).append("\n"); 
		query.append("		    AND A.TO_NOD_CD in (" ).append("\n"); 
		query.append("		    #foreach( ${key} in ${arr_tonode}) " ).append("\n"); 
		query.append("			    #if($velocityCount < $arr_tonode.size()) " ).append("\n"); 
		query.append("			        '$key', " ).append("\n"); 
		query.append("			    #else " ).append("\n"); 
		query.append("		            '$key' " ).append("\n"); 
		query.append("			    #end " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		-- Port로 조회 " ).append("\n"); 
		query.append("		#if (${portio} == 'I')" ).append("\n"); 
		query.append("	  		AND B.POD_CD = @[portcd]" ).append("\n"); 
		query.append("		#elseif (${portio} == 'O')" ).append("\n"); 
		query.append("			AND B.POL_CD = @[portcd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if (${dorloc} != '')" ).append("\n"); 
		query.append("            AND A.DOR_NOD_CD LIKE @[dorloc] ||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rad_wo_issued} == 'YES')" ).append("\n"); 
		query.append("           AND A.TRSP_SO_STS_CD = 'I' " ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("           AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_bkgno.size() > 0) " ).append("\n"); 
		query.append("            AND A.BKG_NO in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_bkgno}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_bkgno.size()) " ).append("\n"); 
		query.append("		            '$key', " ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            '$key' " ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_billno.size() > 0) " ).append("\n"); 
		query.append("            AND A.BL_NO in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_billno}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_billno.size()) " ).append("\n"); 
		query.append("		            '$key', " ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            '$key' " ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_cntrno.size() > 0) " ).append("\n"); 
		query.append("            AND A.EQ_NO in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_cntrno}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_cntrno.size()) " ).append("\n"); 
		query.append("		            '$key', " ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            '$key' " ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_trunkvvd.size() > 0) " ).append("\n"); 
		query.append("            AND (A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD) in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_trunkvvd}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_trunkvvd.size()) " ).append("\n"); 
		query.append("		            (SUBSTR('$key',1,4),SUBSTR('$key',5,4),SUBSTR('$key',9,1))," ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            (SUBSTR('$key',1,4),SUBSTR('$key',5,4),SUBSTR('$key',9,1))" ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("            AND (A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ) in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_so_no}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_so_no.size()) " ).append("\n"); 
		query.append("		            (SUBSTR('$key',1,3),SUBSTR('$key',4))," ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            (SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("            AND (A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ) in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_wo_no}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_wo_no.size()) " ).append("\n"); 
		query.append("		            (SUBSTR('$key',1,3),SUBSTR('$key',4))," ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            (SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_zip_code.size() > 0) " ).append("\n"); 
		query.append("            AND A.DOR_PST_CD in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_zip_code}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_zip_code.size()) " ).append("\n"); 
		query.append("		            '$key', " ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            '$key' " ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_cntr_slt_no.size() > 0) " ).append("\n"); 
		query.append("            AND A.CNTR_SLT_NO in (" ).append("\n"); 
		query.append("            #foreach( ${key} in ${arr_cntr_slt_no}) " ).append("\n"); 
		query.append("	            #if($velocityCount < $arr_cntr_slt_no.size()) " ).append("\n"); 
		query.append("		            '$key', " ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("		            '$key' " ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            AND B.BKG_STS_CD = INTG.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("            AND INTG.INTG_CD_ID(+) = 'CD00769'" ).append("\n"); 
		query.append("     ) AA" ).append("\n"); 
		query.append(" ) AAA" ).append("\n"); 

	}
}