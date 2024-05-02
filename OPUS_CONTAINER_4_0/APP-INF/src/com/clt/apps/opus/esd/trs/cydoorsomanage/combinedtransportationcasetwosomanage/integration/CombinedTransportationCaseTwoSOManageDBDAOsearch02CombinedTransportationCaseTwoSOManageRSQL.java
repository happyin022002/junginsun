/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CombinedTransportationCaseTwoSOManageDBDAOsearch02CombinedTransportationCaseTwoSOManageRSQL.java
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

public class CombinedTransportationCaseTwoSOManageDBDAOsearch02CombinedTransportationCaseTwoSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Matchmaking One Popup조회
	  * </pre>
	  */
	public CombinedTransportationCaseTwoSOManageDBDAOsearch02CombinedTransportationCaseTwoSOManageRSQL(){
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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sNodeL",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.integration").append("\n"); 
		query.append("FileName : CombinedTransportationCaseTwoSOManageDBDAOsearch02CombinedTransportationCaseTwoSOManageRSQL").append("\n"); 
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
		query.append("SELECT  NULL REPO_PLN_ID" ).append("\n"); 
		query.append(", NULL PLN_YRWK" ).append("\n"); 
		query.append(", NULL REF_SEQ" ).append("\n"); 
		query.append(", NULL REF_ID" ).append("\n"); 
		query.append(", 'COP' AS SOURCE" ).append("\n"); 
		query.append(", AAA.TRSP_SO_SEQ" ).append("\n"); 
		query.append(", AAA.COP_NO" ).append("\n"); 
		query.append(", AAA.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(", AAA.EQ_NO" ).append("\n"); 
		query.append(", AAA.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", AAA.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(", AAA.VNDR_SEQ" ).append("\n"); 
		query.append(", AAA.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(", AAA.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", AAA.FM_NOD_CD" ).append("\n"); 
		query.append(", AAA.FM_NOD_YARD" ).append("\n"); 
		query.append(", AAA.TO_NOD_CD" ).append("\n"); 
		query.append(", AAA.TO_NOD_YARD" ).append("\n"); 
		query.append(", AAA.VIA_NOD_CD" ).append("\n"); 
		query.append(", AAA.VIA_NOD_YARD" ).append("\n"); 
		query.append(", AAA.DOR_NOD_CD" ).append("\n"); 
		query.append(", AAA.DOR_NOD_YARD" ).append("\n"); 
		query.append(", '' FM_NOD_CD2" ).append("\n"); 
		query.append(", '' FM_NOD_YARD2 " ).append("\n"); 
		query.append(", '' TO_NOD_CD2" ).append("\n"); 
		query.append(", '' TO_NOD_YARD2 " ).append("\n"); 
		query.append(", '' VIA_NOD_CD2" ).append("\n"); 
		query.append(", '' VIA_NOD_YARD2" ).append("\n"); 
		query.append(", '' DOR_NOD_CD2" ).append("\n"); 
		query.append(", '' DOR_NOD_YARD2" ).append("\n"); 
		query.append(", AAA.BKG_NO" ).append("\n"); 
		query.append(", AAA.BL_NO" ).append("\n"); 
		query.append(", AAA.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append(", AAA.N1ST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append(", AAA.LST_NOD_PLN_DT" ).append("\n"); 
		query.append(", AAA.LST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append(", AAA.DOR_NOD_PLN_DT" ).append("\n"); 
		query.append(", AAA.DOR_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append(", AAA.TRSP_BND_CD" ).append("\n"); 
		query.append(", AAA.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append(", AAA.TRSP_SO_CMB_SEQ" ).append("\n"); 
		query.append(", AAA.CGO_TP_CD" ).append("\n"); 
		query.append(", AAA.CNTR_WGT" ).append("\n"); 
		query.append(", AAA.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(", AAA.CMDT_CD" ).append("\n"); 
		query.append(", AAA.TRUNKVVD" ).append("\n"); 
		query.append(", AAA.CUST_CNT_CD" ).append("\n"); 
		query.append(", AAA.DOR_DE_ADDR" ).append("\n"); 
		query.append(", AAA.MLT_STOP_DE_FLG" ).append("\n"); 
		query.append(", AAA.DOR_SVC_TP_CD" ).append("\n"); 
		query.append(", AAA.DOR_SVC_TP_CD DOR_SVC_TP_CD2" ).append("\n"); 
		query.append(", AAA.INTER_RMK " ).append("\n"); 
		query.append(", AAA.CRE_USR_ID" ).append("\n"); 
		query.append(", AAA.UPD_USR_ID" ).append("\n"); 
		query.append(", AAA.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", AAA.FEEDERVVD" ).append("\n"); 
		query.append(", AAA.SPCL_INSTR_RMK" ).append("\n"); 
		query.append(", AAA.BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append(", AAA.SLAN_CD" ).append("\n"); 
		query.append(", AAA.POR_CD" ).append("\n"); 
		query.append(", AAA.POL_CD" ).append("\n"); 
		query.append(", AAA.POD_CD" ).append("\n"); 
		query.append(", AAA.DEL_CD" ).append("\n"); 
		query.append(", AAA.CRE_OFC_CD" ).append("\n"); 
		query.append(", AAA.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append(", SUBSTR(AAA.SHPR_CUST_INFO, INSTR(AAA.SHPR_CUST_INFO, '$', 1, 2) + 1) SHPR_CUST_NM" ).append("\n"); 
		query.append(", SUBSTR(AAA.CNEE_CUST_INFO, INSTR(AAA.CNEE_CUST_INFO, '$', 1, 2) + 1) CNEE_CUST_NM" ).append("\n"); 
		query.append(", AAA.NTFY_CUST_NM" ).append("\n"); 
		query.append(", SUBSTR(AAA.FOC, 1, INSTR(AAA.FOC, '$', 1, 1) - 1) CGOR_FRT_PAY_IND_FLG" ).append("\n"); 
		query.append(", SUBSTR(AAA.FOC, INSTR(AAA.FOC, '$', 1, 1) + 1, INSTR(AAA.FOC, '$', 1, 2) - instr(AAA.FOC, '$', 1, 1) - 1) CGOR_ORG_BL_RCVR_IND_FLG" ).append("\n"); 
		query.append(", SUBSTR(AAA.FOC, INSTR(AAA.FOC, '$', 1, 2) + 1) CGOR_CSTMS_ACPT_RE_IND_FLG" ).append("\n"); 
		query.append(", AAA.IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append(", AAA.OWNR_CO_CD" ).append("\n"); 
		query.append(", SUBSTR(AAA.MST_CNTR, 1, INSTR(AAA.MST_CNTR, '$', 1, 1) - 1) IMDT_EXT_FLG" ).append("\n"); 
		query.append(", SUBSTR(AAA.MST_CNTR, INSTR(AAA.MST_CNTR, '$', 1, 1) + 1) LSTM_CD" ).append("\n"); 
		query.append(", AAA.LST_LOC_CD" ).append("\n"); 
		query.append(", '' LSTM_EXP_FLG" ).append("\n"); 
		query.append(", DECODE(AAA.CONTI_CD, 'E', SUBSTR(AAA.TRO_INFO, INSTR(AAA.TRO_INFO, '$', 1, 4) + 1), MDM_CO_CMDT_NM) CMDT_NAME" ).append("\n"); 
		query.append(", SUBSTR(AAA.PKGCODE_NOOFPKG, 1, INSTR(AAA.PKGCODE_NOOFPKG, '$', 1, 1) - 1) PKGCODE" ).append("\n"); 
		query.append(", AAA.SEALNO" ).append("\n"); 
		query.append(", AAA.SEALNO2" ).append("\n"); 
		query.append(", SUBSTR(AAA.PKGCODE_NOOFPKG, INSTR(AAA.PKGCODE_NOOFPKG, '$', 1, 1) + 1) NOOFPKG" ).append("\n"); 
		query.append(", AAA.SC_NO" ).append("\n"); 
		query.append(", AAA.RFANO" ).append("\n"); 
		query.append(", SUBSTR(AAA.TRO_INFO, INSTR(AAA.TRO_INFO, '$', 1, 3) + 1, INSTR(AAA.TRO_INFO, '$', 1, 4) - INSTR(AAA.TRO_INFO, '$', 1, 3) - 1) CUSTOMSCLEARANCENO" ).append("\n"); 
		query.append(", DECODE(SUBSTR(AAA.TRO_INFO, INSTR(AAA.TRO_INFO, '$', 1, 3) + 1, INSTR(AAA.TRO_INFO, '$', 1, 4) - INSTR(AAA.TRO_INFO, '$', 1, 3) - 1) ,NULL,'','Y') CUSTOMSCLEARANCE" ).append("\n"); 
		query.append(", AAA.LST_LOC_CD2" ).append("\n"); 
		query.append(", AAA.TRSP_COST_DTL_MOD_SEP" ).append("\n"); 
		query.append(", AAA.CNTR_PKUP_NO" ).append("\n"); 
		query.append(", AAA.AVAL_DT" ).append("\n"); 
		query.append(", AAA.AVAL_DT_HMS" ).append("\n"); 
		query.append(", AAA.LST_FREE_DT" ).append("\n"); 
		query.append(", AAA.LST_FREE_DT_HMS" ).append("\n"); 
		query.append(", AAA.SUB_EQ_TPSZ_CD" ).append("\n"); 
		query.append(", AAA.CNTR_SUB_FLG" ).append("\n"); 
		query.append(", AAA.FCTRY_NM" ).append("\n"); 
		query.append(", AAA.CNTC_PSON_NM" ).append("\n"); 
		query.append(", AAA.CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(", AAA.CNTC_PSON_FAX_NO " ).append("\n"); 
		query.append(", AAA.DOR_PST_CD" ).append("\n"); 
		query.append(", AAA.TRO_CFM_OFC_CD" ).append("\n"); 
		query.append(", AAA.TRO_CFM_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(AAA.TRO_CFM_UPD_DT, 'YYYYMMDD') TRO_CFM_UPD_DT1" ).append("\n"); 
		query.append(", TO_CHAR(AAA.TRO_CFM_UPD_DT, 'HH24MISS') TRO_CFM_UPD_DT2" ).append("\n"); 
		query.append(", AAA.TRO_LOD_REF_NO " ).append("\n"); 
		query.append(", AAA.TRSP_BND_CD TRSP_BND_CD" ).append("\n"); 
		query.append(", AAA.TRO_SEQ TRSP_RQST_ORD_SEQ" ).append("\n"); 
		query.append(", AAA.ORG_EQ_TPSZ_CD" ).append("\n"); 
		query.append(", '' LSE_CNTR_FLG" ).append("\n"); 
		query.append(", DECODE(AAA.TRO_SEQ, NULL, 'N', 'Y') AS TRO_CNFM" ).append("\n"); 
		query.append(", AAA.CNTR_KGS_WGT" ).append("\n"); 
		query.append(", AAA.CNTR_LBS_WGT" ).append("\n"); 
		query.append(", AAA.IB_VVD_CD" ).append("\n"); 
		query.append(", AAA.OB_VVD_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT (SELECT  NVL(TO_CHAR(DCGO_SEQ), ' ')" ).append("\n"); 
		query.append("                  ||'$'||NVL(TO_CHAR(RC_SEQ), ' ')" ).append("\n"); 
		query.append("                  ||'$'||NVL(TO_CHAR(AWK_CGO_SEQ), ' ')" ).append("\n"); 
		query.append("                  ||'$'||NVL(CSTMS_CLR_NO, ' ')" ).append("\n"); 
		query.append("                  ||'$'||NVL(REP_CMDT_DESC, ' ')" ).append("\n"); 
		query.append("              FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("             WHERE BKG_NO    = AA.BKG_NO" ).append("\n"); 
		query.append("               AND IO_BND_CD = AA.TRSP_BND_CD" ).append("\n"); 
		query.append("               AND TRO_SEQ   = AA.TRO_SEQ) AS TRO_INFO" ).append("\n"); 
		query.append("           ,AA.*" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                  A.REPO_PLN_ID" ).append("\n"); 
		query.append("                , A.CONTI_CD" ).append("\n"); 
		query.append("                , A.PLN_YRWK" ).append("\n"); 
		query.append("                , A.REF_ID" ).append("\n"); 
		query.append("                , A.REF_SEQ" ).append("\n"); 
		query.append("                , A.TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("                , A.COP_NO" ).append("\n"); 
		query.append("                , A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                , A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                , A.TRSP_WO_SEQ" ).append("\n"); 
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
		query.append("                , SUBSTR(A.TO_NOD_CD,1,5) TO_NOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.TO_NOD_CD,6,2) TO_NOD_YARD" ).append("\n"); 
		query.append("                , SUBSTR(A.VIA_NOD_CD,1,5) VIA_NOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.VIA_NOD_CD,6,2) VIA_NOD_YARD" ).append("\n"); 
		query.append("                , SUBSTR(A.DOR_NOD_CD,1,5) DOR_NOD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.DOR_NOD_CD,6,2) DOR_NOD_YARD" ).append("\n"); 
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
		query.append("                , A.INTER_RMK" ).append("\n"); 
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
		query.append("                , A.CNTR_PKUP_NO" ).append("\n"); 
		query.append("                , TO_CHAR(A.AVAL_DT, 'YYYYMMDD')       AVAL_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.AVAL_DT, 'HH24:MI:SS')     AVAL_DT_HMS" ).append("\n"); 
		query.append("                , TO_CHAR(A.LST_FREE_DT, 'YYYYMMDD')   LST_FREE_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.LST_FREE_DT, 'HH24:MI:SS') LST_FREE_DT_HMS" ).append("\n"); 
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
		query.append("                , (A.FDR_VSL_CD||A.FDR_SKD_VOY_NO||A.FDR_SKD_DIR_CD) FEEDERVVD" ).append("\n"); 
		query.append("                , (SELECT PCK_TP_CD ||'$'|| TO_CHAR(PCK_QTY)" ).append("\n"); 
		query.append("                     FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                    WHERE BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("                      AND CNTR_NO = A.EQ_NO) AS PKGCODE_NOOFPKG" ).append("\n"); 
		query.append("                , (SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = A.BKG_NO AND CNTR_NO = A.EQ_NO AND CNTR_SEAL_SEQ = 1) AS SEALNO" ).append("\n"); 
		query.append("                , (SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = A.BKG_NO AND CNTR_NO = A.EQ_NO AND CNTR_SEAL_SEQ = 2) AS SEALNO2" ).append("\n"); 
		query.append("                , (SELECT TRO_SEQ" ).append("\n"); 
		query.append("                     FROM SCE_TRO_MAPG" ).append("\n"); 
		query.append("                    WHERE COP_NO        = A.COP_NO" ).append("\n"); 
		query.append("                      AND IO_BND_CD     = A.TRSP_BND_CD" ).append("\n"); 
		query.append("                      AND AREA_CONTI_CD = A.CONTI_CD) AS TRO_SEQ" ).append("\n"); 
		query.append("                , (SELECT CMDT_NM" ).append("\n"); 
		query.append("                     FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                    WHERE CMDT_CD = A.CMDT_CD) AS MDM_CO_CMDT_NM" ).append("\n"); 
		query.append("                , (SELECT BC.CUST_CNT_CD ||'$'|| TO_CHAR(BC.CUST_SEQ) ||'$'|| BC.CUST_NM" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                    WHERE BC.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND BC.BKG_CUST_TP_CD = 'C')    CNEE_CUST_INFO" ).append("\n"); 
		query.append("                , (SELECT BC.CUST_CNT_CD ||'$'|| TO_CHAR(BC.CUST_SEQ) ||'$'|| BC.CUST_NM" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                    WHERE BC.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND BC.BKG_CUST_TP_CD = 'S')    SHPR_CUST_INFO" ).append("\n"); 
		query.append("                , (SELECT BC.CUST_NM" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                    WHERE BC.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND BC.BKG_CUST_TP_CD = 'N')    NTFY_CUST_NM" ).append("\n"); 
		query.append("                , (SELECT NVL(FRT_CLT_FLG, ' ')||'$'||NVL(OBL_RDEM_FLG, ' ')||'$'||DECODE(CSTMS_CLR_CD, 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("                     FROM BKG_CGO_RLSE" ).append("\n"); 
		query.append("                    WHERE BL_NO = A.BL_NO) FOC" ).append("\n"); 
		query.append("                , (SELECT NVL(IMDT_EXT_FLG, ' ')||'$'||NVL(LSTM_CD, ' ')" ).append("\n"); 
		query.append("                     FROM MST_CONTAINER" ).append("\n"); 
		query.append("                    WHERE CNTR_NO  = A.EQ_NO) MST_CNTR" ).append("\n"); 
		query.append("                , (SELECT DECODE(NVL(QTY.EQ_SUBST_CGO_QTY, 0), 0, QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                          ||' '||QTY.OP_CNTR_QTY, QTY.CNTR_TPSZ_CD||' '||QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("                          ||'-SUB '||QTY.EQ_SUBST_CNTR_TPSZ_CD||' '||QTY.EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                     FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                    WHERE A.BKG_NO  = QTY.BKG_NO" ).append("\n"); 
		query.append("                      AND  A.EQ_TPSZ_CD   = QTY.CNTR_TPSZ_CD) BKG_QTY" ).append("\n"); 
		query.append("                , TRS_CYDOOR_COMM_PKG.GET_MULTI_LST_LOC(A.FM_NOD_CD, A.TO_NOD_CD) LST_LOC_CD2" ).append("\n"); 
		query.append("         FROM  TRS_TRSP_SVC_ORD            A" ).append("\n"); 
		query.append("              ,BKG_BOOKING                 B" ).append("\n"); 
		query.append("        WHERE  A.BKG_NO          = B.BKG_NO" ).append("\n"); 
		query.append("          AND  A.HJL_NO          IS NULL" ).append("\n"); 
		query.append("          AND  A.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("          AND  A.CRE_OFC_CD      = @[cre_ofc_cd]" ).append("\n"); 
		query.append("          AND  A.TRSP_SO_TP_CD = 'Y' " ).append("\n"); 
		query.append("          AND  A.HJL_NO       IS NULL                      " ).append("\n"); 
		query.append("          AND  A.TRSP_CRR_MOD_CD IN ( 'TD', 'DT', 'RT', 'TR', 'WT', 'TW' ) " ).append("\n"); 
		query.append("          AND  A.TRSP_SO_STS_CD IN  ('C', 'R') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if( ${strCostMode}=='CY' ) " ).append("\n"); 
		query.append("        AND TO_CHAR(A.N1ST_NOD_PLN_DT, 'YYYYMMDDHH24MISS') BETWEEN @[sFtime] AND @[sTtime]  " ).append("\n"); 
		query.append("        AND A.FM_NOD_CD = @[sNodeL]  " ).append("\n"); 
		query.append("    #elseif( ${strCostMode}=='DOOR' ) " ).append("\n"); 
		query.append("        AND TO_CHAR(A.DOR_NOD_PLN_DT, 'YYYYMMDDHH24MISS') BETWEEN @[sFtime] AND @[sTtime]   " ).append("\n"); 
		query.append("        AND A.TRSP_BND_CD = 'O' " ).append("\n"); 
		query.append("        AND A.DOR_NOD_CD = @[sNodeL]    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND A.EQ_TPSZ_CD = @[eq_tpsz_cd] " ).append("\n"); 
		query.append("     ) AA" ).append("\n"); 
		query.append(" ) AAA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${strCostMode}=='CY' ) " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   BB.REPO_PLN_ID, " ).append("\n"); 
		query.append("   BB.PLN_YRWK," ).append("\n"); 
		query.append("   BB.REF_SEQ, " ).append("\n"); 
		query.append("   BB.REF_ID, " ).append("\n"); 
		query.append("   BB.SOURCE, " ).append("\n"); 
		query.append("   BB.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("   BB.COP_NO, " ).append("\n"); 
		query.append("   BB.COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("   BB.EQ_NO, " ).append("\n"); 
		query.append("   BB.EQ_TPSZ_CD, " ).append("\n"); 
		query.append("   BB.COST_ACT_GRP_CD," ).append("\n"); 
		query.append("   BB.VNDR_SEQ, " ).append("\n"); 
		query.append("   BB.TRSP_COST_DTL_MOD_CD, " ).append("\n"); 
		query.append("   BB.TRSP_CRR_MOD_CD, " ).append("\n"); 
		query.append("   BB.FM_NOD_CD," ).append("\n"); 
		query.append("   BB.FM_NOD_YARD, " ).append("\n"); 
		query.append("   BB.TO_NOD_CD," ).append("\n"); 
		query.append("   BB.TO_NOD_YARD, " ).append("\n"); 
		query.append("   BB.VIA_NOD_CD, " ).append("\n"); 
		query.append("   BB.VIA_NOD_YARD, " ).append("\n"); 
		query.append("   BB.DOR_NOD_CD, " ).append("\n"); 
		query.append("   BB.DOR_NOD_YARD, " ).append("\n"); 
		query.append("   BB.FM_NOD_CD2, " ).append("\n"); 
		query.append("   BB.FM_NOD_YARD2," ).append("\n"); 
		query.append("   BB.TO_NOD_CD2," ).append("\n"); 
		query.append("   BB.TO_NOD_YARD2, " ).append("\n"); 
		query.append("   BB.VIA_NOD_CD2, " ).append("\n"); 
		query.append("   BB.VIA_NOD_YARD2, " ).append("\n"); 
		query.append("   BB.DOR_NOD_CD2, " ).append("\n"); 
		query.append("   BB.DOR_NOD_YARD2, " ).append("\n"); 
		query.append("   BB.BKG_NO, " ).append("\n"); 
		query.append("   BB.BL_NO," ).append("\n"); 
		query.append("   BB.N1ST_NOD_PLN_DT, " ).append("\n"); 
		query.append("   BB.N1ST_NOD_PLN_DT_HMS, " ).append("\n"); 
		query.append("   BB.LST_NOD_PLN_DT, " ).append("\n"); 
		query.append("   BB.LST_NOD_PLN_DT_HMS, " ).append("\n"); 
		query.append("   BB.DOR_NOD_PLN_DT, " ).append("\n"); 
		query.append("   BB.DOR_NOD_PLN_DT_HMS, " ).append("\n"); 
		query.append("   BB.TRSP_BND_CD," ).append("\n"); 
		query.append("   BB.CUST_NOMI_TRKR_FLG, " ).append("\n"); 
		query.append("   BB.TRSP_SO_CMB_SEQ, " ).append("\n"); 
		query.append("   BB.CGO_TP_CD, " ).append("\n"); 
		query.append("   BB.CNTR_WGT, " ).append("\n"); 
		query.append("   BB.WGT_MEAS_UT_CD, " ).append("\n"); 
		query.append("   BB.CMDT_CD, " ).append("\n"); 
		query.append("   BB.TRUNKVVD, " ).append("\n"); 
		query.append("   BB.CUST_CNT_CD, " ).append("\n"); 
		query.append("   BB.DOR_DE_ADDR, " ).append("\n"); 
		query.append("   BB.MLT_STOP_DE_FLG, " ).append("\n"); 
		query.append("   BB.DOR_SVC_TP_CD, " ).append("\n"); 
		query.append("   BB.DOR_SVC_TP_CD DOR_SVC_TP_CD2, " ).append("\n"); 
		query.append("   BB.INTER_RMK, " ).append("\n"); 
		query.append("   BB.CRE_USR_ID, " ).append("\n"); 
		query.append("   BB.UPD_USR_ID, " ).append("\n"); 
		query.append("   BB.TRSP_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("   BB.FEEDERVVD, " ).append("\n"); 
		query.append("   BB.SPCL_INSTR_RMK, " ).append("\n"); 
		query.append("   BB.BKG_RCVDE_TERM_CD, " ).append("\n"); 
		query.append("   BB.SLAN_CD, " ).append("\n"); 
		query.append("   BB.POR_CD, " ).append("\n"); 
		query.append("   BB.POL_CD, " ).append("\n"); 
		query.append("   BB.POD_CD, " ).append("\n"); 
		query.append("   BB.DEL_CD, " ).append("\n"); 
		query.append("   BB.CRE_OFC_CD, " ).append("\n"); 
		query.append("   BB.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("   SUBSTR(BB.CNEE_CUST_INFO, INSTR(BB.CNEE_CUST_INFO, '$', 1, 2) + 1) CNEE_CUST_NM," ).append("\n"); 
		query.append("   SUBSTR(BB.SHPR_CUST_INFO, INSTR(BB.SHPR_CUST_INFO, '$', 1, 2) + 1) SHPR_CUST_NM," ).append("\n"); 
		query.append("   BB.NTFY_CUST_NM,    " ).append("\n"); 
		query.append("   SUBSTR(BB.FOC, 1, INSTR(BB.FOC, '$', 1, 1) - 1) CGOR_FRT_PAY_IND_FLG," ).append("\n"); 
		query.append("   SUBSTR(BB.FOC, INSTR(BB.FOC, '$', 1, 1) + 1, INSTR(BB.FOC, '$', 1, 2) - instr(BB.FOC, '$', 1, 1) - 1) CGOR_ORG_BL_RCVR_IND_FLG," ).append("\n"); 
		query.append("   SUBSTR(BB.FOC, INSTR(BB.FOC, '$', 1, 2) + 1) CGOR_CSTMS_ACPT_RE_IND_FLG," ).append("\n"); 
		query.append("   BB.IBD_CSTMS_CLR_LOC_CD, " ).append("\n"); 
		query.append("   BB.OWNR_CO_CD,  " ).append("\n"); 
		query.append("   SUBSTR(BB.MST_CNTR, 1, INSTR(BB.MST_CNTR, '$', 1, 1) - 1) IMDT_EXT_FLG,   " ).append("\n"); 
		query.append("   SUBSTR(BB.MST_CNTR, INSTR(BB.MST_CNTR, '$', 1, 1) + 1) LSTM_CD," ).append("\n"); 
		query.append("   BB.LST_LOC_CD,  " ).append("\n"); 
		query.append("   BB.LSTM_EXP_FLG, " ).append("\n"); 
		query.append("   BB.CMDT_NAME, " ).append("\n"); 
		query.append("   BB.PKGCODE," ).append("\n"); 
		query.append("   BB.SEALNO, " ).append("\n"); 
		query.append("   BB.SEALNO2, " ).append("\n"); 
		query.append("   BB.NOOFPKG," ).append("\n"); 
		query.append("   BB.SC_NO, " ).append("\n"); 
		query.append("   BB.RFANO," ).append("\n"); 
		query.append("   BB.CUSTOMSCLEARANCENO, " ).append("\n"); 
		query.append("   BB.CUSTOMSCLEARANCE," ).append("\n"); 
		query.append("   BB.LST_LOC_CD2, " ).append("\n"); 
		query.append("   BB.TRSP_COST_DTL_MOD_CD TRSP_COST_DTL_MOD_SEP, " ).append("\n"); 
		query.append("   BB.CNTR_PKUP_NO, " ).append("\n"); 
		query.append("   BB.AVAL_DT, " ).append("\n"); 
		query.append("   BB.AVAL_DT_HMS, " ).append("\n"); 
		query.append("   BB.LST_FREE_DT, " ).append("\n"); 
		query.append("   BB.LST_FREE_DT_HMS, " ).append("\n"); 
		query.append("   BB.SUB_EQ_TPSZ_CD, " ).append("\n"); 
		query.append("   BB.CNTR_SUB_FLG," ).append("\n"); 
		query.append("   BB.FCTRY_NM," ).append("\n"); 
		query.append("   BB.CNTC_PSON_NM, " ).append("\n"); 
		query.append("   BB.CNTC_PSON_PHN_NO, " ).append("\n"); 
		query.append("   BB.CNTC_PSON_FAX_NO, " ).append("\n"); 
		query.append("   BB.DOR_PST_CD, " ).append("\n"); 
		query.append("   BB.TRO_CFM_OFC_CD, " ).append("\n"); 
		query.append("   BB.TRO_CFM_USR_ID, " ).append("\n"); 
		query.append("   BB.TRO_CFM_UPD_DT1," ).append("\n"); 
		query.append("   BB.TRO_CFM_UPD_DT2, " ).append("\n"); 
		query.append("   BB.TRO_LOD_REF_NO,  " ).append("\n"); 
		query.append("   BB.TRSP_BND_CD," ).append("\n"); 
		query.append("   BB.TRSP_RQST_ORD_SEQ," ).append("\n"); 
		query.append("   BB.ORG_EQ_TPSZ_CD," ).append("\n"); 
		query.append("   '' LSE_CNTR_FLG," ).append("\n"); 
		query.append("   DECODE(BB.TRSP_RQST_ORD_SEQ, NULL, 'N', 'Y') AS TRO_CNFM," ).append("\n"); 
		query.append("   NULL CNTR_KGS_WGT," ).append("\n"); 
		query.append("   NULL CNTR_LBS_WGT," ).append("\n"); 
		query.append("   NULL IB_VVD_CD," ).append("\n"); 
		query.append("   NULL OB_VVD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  B.REPO_PLN_ID, B.PLN_YRWK, B.REF_SEQ, B.REF_ID, " ).append("\n"); 
		query.append("  DECODE(B.TRSP_MTY_COST_MOD_CD, 'CN', 'On-Hire', 'CF', 'Off-Hire', 'Empty Repo') SOURCE, " ).append("\n"); 
		query.append("  B.TRSP_SO_SEQ TRSP_SO_SEQ, B.COP_NO, B.COST_ACT_GRP_SEQ, B.EQ_NO, B.EQ_TPSZ_CD, " ).append("\n"); 
		query.append("  B.COST_ACT_GRP_CD, B.VNDR_SEQ, " ).append("\n"); 
		query.append("  DECODE(B.TRSP_COST_DTL_MOD_CD, 'CY', 'CY', 'DR', 'DOOR', '') TRSP_COST_DTL_MOD_CD, " ).append("\n"); 
		query.append("  B.TRSP_CRR_MOD_CD, " ).append("\n"); 
		query.append("  SUBSTR(B.FM_NOD_CD,1,5) FM_NOD_CD, SUBSTR(B.FM_NOD_CD,6,2) FM_NOD_YARD, " ).append("\n"); 
		query.append("  SUBSTR(B.TO_NOD_CD,1,5) TO_NOD_CD, SUBSTR(B.TO_NOD_CD,6,2) TO_NOD_YARD, " ).append("\n"); 
		query.append("  SUBSTR(B.VIA_NOD_CD,1,5) VIA_NOD_CD, SUBSTR(B.VIA_NOD_CD,6,2) VIA_NOD_YARD, " ).append("\n"); 
		query.append("  SUBSTR(B.DOR_NOD_CD,1,5) DOR_NOD_CD, SUBSTR(B.DOR_NOD_CD,6,2) DOR_NOD_YARD, " ).append("\n"); 
		query.append("  '' FM_NOD_CD2,  '' FM_NOD_YARD2, '' TO_NOD_CD2,  '' TO_NOD_YARD2, " ).append("\n"); 
		query.append("  '' VIA_NOD_CD2, '' VIA_NOD_YARD2, '' DOR_NOD_CD2, '' DOR_NOD_YARD2, " ).append("\n"); 
		query.append("  B.BKG_NO, " ).append("\n"); 
		query.append("  TO_CHAR(B.N1ST_NOD_PLN_DT, 'YYYYMMDD') N1ST_NOD_PLN_DT, " ).append("\n"); 
		query.append("  TO_CHAR(B.N1ST_NOD_PLN_DT, 'HH24:MI:SS') N1ST_NOD_PLN_DT_HMS, " ).append("\n"); 
		query.append("  TO_CHAR(B.LST_NOD_PLN_DT, 'YYYYMMDD') LST_NOD_PLN_DT, " ).append("\n"); 
		query.append("  TO_CHAR(B.LST_NOD_PLN_DT, 'HH24:MI:SS') LST_NOD_PLN_DT_HMS, " ).append("\n"); 
		query.append("  TO_CHAR(B.DOR_NOD_PLN_DT, 'YYYYMMDD') DOR_NOD_PLN_DT, " ).append("\n"); 
		query.append("  TO_CHAR(B.DOR_NOD_PLN_DT, 'HH24:MI:SS') DOR_NOD_PLN_DT_HMS, " ).append("\n"); 
		query.append("  B.TRSP_BND_CD, B.CUST_NOMI_TRKR_FLG, B.TRSP_SO_CMB_SEQ, B.CGO_TP_CD, " ).append("\n"); 
		query.append("  B.CNTR_WGT, B.WGT_MEAS_UT_CD, B.CMDT_CD, " ).append("\n"); 
		query.append("  (B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD) TRUNKVVD, (B.CUST_CNT_CD||B.CUST_SEQ) CUST_CNT_CD, " ).append("\n"); 
		query.append("  B.DOR_DE_ADDR, B.MLT_STOP_DE_FLG, B.DOR_SVC_TP_CD, B.DOR_SVC_TP_CD DOR_SVC_TP_CD2, B.INTER_RMK, B.CRE_USR_ID, " ).append("\n"); 
		query.append("  B.UPD_USR_ID, B.TRSP_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("  (B.FDR_VSL_CD||B.FDR_SKD_VOY_NO||B.FDR_SKD_DIR_CD) FEEDERVVD, " ).append("\n"); 
		query.append("  REPLACE(B.SPCL_INSTR_RMK, CHR(13)||CHR(10), ' ') SPCL_INSTR_RMK, " ).append("\n"); 
		query.append("  B.BKG_RCVDE_TERM_CD, B.SLAN_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD, " ).append("\n"); 
		query.append("  B.CRE_OFC_CD, B.SPCL_CGO_CNTR_TP_CD,  " ).append("\n"); 
		query.append("  B.BL_NO BL_NO," ).append("\n"); 
		query.append("  (SELECT NVL(LSTM_CD, ' ')||'$'||NVL(IMDT_EXT_FLG, ' ')" ).append("\n"); 
		query.append("     FROM MST_CONTAINER" ).append("\n"); 
		query.append("    WHERE CNTR_NO  = B.EQ_NO) MST_CNTR," ).append("\n"); 
		query.append("  (SELECT NVL(FRT_CLT_FLG, ' ')||'$'||NVL(OBL_RDEM_FLG, ' ')||'$'||DECODE(CSTMS_CLR_CD, 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("     FROM BKG_CGO_RLSE" ).append("\n"); 
		query.append("    WHERE BL_NO = B.BL_NO) FOC,  " ).append("\n"); 
		query.append("  (SELECT BC.CUST_NM" ).append("\n"); 
		query.append("     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("    WHERE BC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND BC.BKG_CUST_TP_CD = 'N')    NTFY_CUST_NM,                                   " ).append("\n"); 
		query.append("  (SELECT BC.CUST_CNT_CD ||'$'|| TO_CHAR(BC.CUST_SEQ) ||'$'|| BC.CUST_NM" ).append("\n"); 
		query.append("     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("    WHERE BC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND BC.BKG_CUST_TP_CD = 'C')    CNEE_CUST_INFO," ).append("\n"); 
		query.append("  (SELECT BC.CUST_CNT_CD ||'$'|| TO_CHAR(BC.CUST_SEQ) ||'$'|| BC.CUST_NM" ).append("\n"); 
		query.append("     FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("    WHERE BC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND BC.BKG_CUST_TP_CD = 'S')    SHPR_CUST_INFO , " ).append("\n"); 
		query.append("  B.IBD_CSTMS_CLR_LOC_CD, B.OWNR_CO_CD,   '' LST_LOC_CD,  " ).append("\n"); 
		query.append("  '' LSTM_EXP_FLG, '' CMDT_NAME, " ).append("\n"); 
		query.append("  '' PKGCODE, '' SEALNO, '' SEALNO2, NULL NOOFPKG, '' SC_NO, '' RFANO, '' CUSTOMSCLEARANCENO, " ).append("\n"); 
		query.append("  '' CUSTOMSCLEARANCE," ).append("\n"); 
		query.append("  '' LST_LOC_CD2, " ).append("\n"); 
		query.append("  B.TRSP_COST_DTL_MOD_CD TRSP_COST_DTL_MOD_SEP, B.CNTR_PKUP_NO, " ).append("\n"); 
		query.append("  TO_CHAR(B.AVAL_DT, 'YYYYMMDD') AVAL_DT, TO_CHAR(B.AVAL_DT, 'HH24:MI:SS') AVAL_DT_HMS, " ).append("\n"); 
		query.append("  TO_CHAR(B.LST_FREE_DT, 'YYYYMMDD') LST_FREE_DT, TO_CHAR(B.LST_FREE_DT, 'HH24:MI:SS') LST_FREE_DT_HMS, " ).append("\n"); 
		query.append("  B.SUB_EQ_TPSZ_CD, B.CNTR_SUB_FLG, B.FCTRY_NM, B.CNTC_PSON_NM, B.CNTC_PSON_PHN_NO, B.CNTC_PSON_FAX_NO, " ).append("\n"); 
		query.append("  '' DOR_PST_CD, '' TRO_CFM_OFC_CD, '' TRO_CFM_USR_ID, " ).append("\n"); 
		query.append("  '' TRO_CFM_UPD_DT1, '' TRO_CFM_UPD_DT2, '' TRO_LOD_REF_NO,  " ).append("\n"); 
		query.append("  NULL TRSP_RQST_ORD_SEQ," ).append("\n"); 
		query.append("  B.ORG_EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD B " ).append("\n"); 
		query.append("WHERE B.TRSP_SO_TP_CD = 'M' " ).append("\n"); 
		query.append("AND B.TRSP_SO_STS_CD IN ('C', 'R') " ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("AND B.HJL_NO       IS NULL                      " ).append("\n"); 
		query.append("AND B.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND TO_CHAR(B.N1ST_NOD_PLN_DT, 'YYYYMMDD') = @[lst_nod_pln_dt]" ).append("\n"); 
		query.append("AND B.FM_NOD_CD = @[sNodeL]" ).append("\n"); 
		query.append("AND B.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append(")BB" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}