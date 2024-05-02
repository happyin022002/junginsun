/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListAsiaDrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.08
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.08 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListAsiaDrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 아시아 Door S/O 대상 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListAsiaDrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListAsiaDrRSQL").append("\n"); 
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
		query.append("SELECT IB_VVD_CD" ).append("\n"); 
		query.append("      ,OB_VVD_CD" ).append("\n"); 
		query.append("      ,CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,COP_NO" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("      ,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,DECODE(TRSP_COST_DTL_MOD_CD, 'CY', 'CY', 'DR', 'DOOR', 'CY') TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,FM_NOD_YARD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_YARD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_YARD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_YARD" ).append("\n"); 
		query.append("      ,DECODE(LENGTH(XX.DOR_NOD_CD || XX.DOR_NOD_YARD), 7, (SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD = XX.DOR_NOD_CD || XX.DOR_NOD_YARD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = XX.DOR_NOD_CD)) AS DOR_NOD_CD_NM" ).append("\n"); 
		query.append("      ,FM_NOD_CD2" ).append("\n"); 
		query.append("      ,FM_NOD_YARD2" ).append("\n"); 
		query.append("      ,TO_NOD_CD2" ).append("\n"); 
		query.append("      ,TO_NOD_YARD2" ).append("\n"); 
		query.append("      ,VIA_NOD_CD2" ).append("\n"); 
		query.append("      ,VIA_NOD_YARD2" ).append("\n"); 
		query.append("      ,DOR_NOD_CD2" ).append("\n"); 
		query.append("      ,DOR_NOD_YARD2" ).append("\n"); 
		query.append("      ,N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,N1ST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("      ,LST_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,LST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,TO_CHAR(DOR_NOD_PLN_DT, 'YYYYMMDD'  ) AS DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(DOR_NOD_PLN_DT, 'HH24:MI:SS') AS DOR_NOD_PLN_DT_HMS    " ).append("\n"); 
		query.append("      ,NULL DOR_ARR_DT_DD " ).append("\n"); 
		query.append("      ,NULL DOR_ARR_DT_HMS" ).append("\n"); 
		query.append("      ,NULL DOR_ARR_DT    " ).append("\n"); 
		query.append("      ,DOR_NOD_PLN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,TRO_SEQ" ).append("\n"); 
		query.append("      ,TRO_SUB_SEQ" ).append("\n"); 
		query.append("      ,TRO_CNFM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,NULL TRO_CFM_OFC_CD " ).append("\n"); 
		query.append("      ,NULL TRO_CFM_USR_ID " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,SUBSTR(T_CFM_DT, 1, 8) TRO_CFM_UPD_DT1" ).append("\n"); 
		query.append("      ,SUBSTR(T_CFM_DT, 9) TRO_CFM_UPD_DT2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,NULL TRO_CFM_CURR_CD" ).append("\n"); 
		query.append("      ,NULL TRO_CFM_REV_AMT" ).append("\n"); 
		query.append("      ,NULL TRO_LOD_REF_NO " ).append("\n"); 
		query.append("      ,NULL TRO_REP_CMDT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,TRSP_BND_CD" ).append("\n"); 
		query.append("      ,TRNS_RQST_OFC_CD" ).append("\n"); 
		query.append("      ,TRNS_RQST_USR_ID" ).append("\n"); 
		query.append("      ,TRNS_RQST_RSN" ).append("\n"); 
		query.append("      ,RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("      ,BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,POD_CONTI_CD" ).append("\n"); 
		query.append("      ,FM_LOC_CONTI_CD" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("      ,CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CNEE_CUST_SEQ" ).append("\n"); 
		query.append("      ,SHPR_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,SHPR_CUST_SEQ" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	  ,CASE WHEN TRSP_COST_DTL_MOD_CD = 'DR' AND TRSP_BND_CD ='I' THEN NVL(T_ACT_CUST_CD, TO_CHAR(CNEE_CUST_SEQ))" ).append("\n"); 
		query.append("		    ELSE T_ACT_CUST_CD" ).append("\n"); 
		query.append("	   END ACT_CUST_CD		" ).append("\n"); 
		query.append("      ,T_ACT_CUST_CNT_CD AS ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,T_ACT_CUST_SEQ AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,T_DOR_PST_CD AS DOR_PST_CD" ).append("\n"); 
		query.append("      ,T_FCTRY_NM AS FCTRY_NM" ).append("\n"); 
		query.append("      ,T_DOR_DE_ADDR AS DOR_DE_ADDR   " ).append("\n"); 
		query.append("      ,T_CNTC_PSON_PHN_NO AS CNTC_PSON_PHN_NO  " ).append("\n"); 
		query.append("      ,T_CNTC_PSON_FAX_NO AS CNTC_PSON_FAX_NO  " ).append("\n"); 
		query.append("      ,T_CNTC_PSON_NM AS CNTC_PSON_NM " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("      ,NULL SPCL_INSTR_RMK" ).append("\n"); 
		query.append("      ,NULL USA_DO_USR_INFO" ).append("\n"); 
		query.append("      ,NULL DO_CRE_DATE " ).append("\n"); 
		query.append("      ,NULL DO_CRE_TIME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      ,CGO_TP_CD" ).append("\n"); 
		query.append("      ,PKGCODE" ).append("\n"); 
		query.append("      ,TRUNKVVD" ).append("\n"); 
		query.append("      ,SLAN_CD" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,BKG_BDR_DT" ).append("\n"); 
		query.append("      ,BKG_BDR_FLG" ).append("\n"); 
		query.append("      ,SEALNO" ).append("\n"); 
		query.append("      ,SEALNO2" ).append("\n"); 
		query.append("      ,CNTR_WGT" ).append("\n"); 
		query.append("      ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,NOOFPKG" ).append("\n"); 
		query.append("      ,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,SHPR_CUST_NM" ).append("\n"); 
		query.append("      ,CNEE_CUST_NM" ).append("\n"); 
		query.append("      ,VGM_WGT_UT_CD" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(VGM_WGT_UT_CD, VGM_WGT) AS VGM_KGS_WGT" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(VGM_WGT_UT_CD, VGM_WGT) AS VGM_LBS_WGT" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(WGT_MEAS_UT_CD, CNTR_WGT) AS CNTR_KGS_WGT" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(WGT_MEAS_UT_CD, CNTR_WGT) AS CNTR_LBS_WGT" ).append("\n"); 
		query.append("      ,NTFY_CUST_NM" ).append("\n"); 
		query.append("      ,SC_NO" ).append("\n"); 
		query.append("      ,RFANO" ).append("\n"); 
		query.append("      ,CMDT_CD" ).append("\n"); 
		query.append("      ,CMDT_NAME" ).append("\n"); 
		query.append("      ,CGOR_FRT_PAY_IND_FLG" ).append("\n"); 
		query.append("      ,CGOR_ORG_BL_RCVR_IND_FLG" ).append("\n"); 
		query.append("      ,CGOR_CSTMS_ACPT_RE_IND_FLG" ).append("\n"); 
		query.append("      ,OWNR_CO_CD" ).append("\n"); 
		query.append("      ,IMDT_EXT_FLG" ).append("\n"); 
		query.append("      ,LSTM_CD" ).append("\n"); 
		query.append("      ,IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("      ,DOR_SVC_TP_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TRSP_NXT_PORT_CD" ).append("\n"); 
		query.append("      ,LST_LOC_CD" ).append("\n"); 
		query.append("      ,NULL CUSTOMSCLEARANCENO" ).append("\n"); 
		query.append("      ,NULL CUSTOMSCLEARANCE  " ).append("\n"); 
		query.append("      ,NULL MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("      ,T_PROC_CFM_IND_CD AS PROC_CFM_IND_CD -- TRO Only" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,TRSP_COST_DTL_MOD_SEP" ).append("\n"); 
		query.append("      ,DCGO_SEQ" ).append("\n"); 
		query.append("      ,RC_SEQ" ).append("\n"); 
		query.append("      ,AWK_CGO_SEQ" ).append("\n"); 
		query.append("      ,CNTR_PKUP_NO" ).append("\n"); 
		query.append("      ,AVAL_DT" ).append("\n"); 
		query.append("      ,AVAL_DT_HMS" ).append("\n"); 
		query.append("      ,LST_FREE_DT" ).append("\n"); 
		query.append("      ,LST_FREE_DT_HMS" ).append("\n"); 
		query.append("      ,BKG_QTY" ).append("\n"); 
		query.append("      ,NULL CSTMS_CLR_NO" ).append("\n"); 
		query.append("      ,NULL REP_CMDT_CD" ).append("\n"); 
		query.append("      ,NULL REV_CURR_CD" ).append("\n"); 
		query.append("      ,NULL TRSP_RQST_ORD_REV_AMT" ).append("\n"); 
		query.append("      ,NULL TRSP_RQST_ORD_BND_CD" ).append("\n"); 
		query.append("      ,NULL TRSP_RQST_ORD_SEQ" ).append("\n"); 
		query.append("      ,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("      ,TRSP_SO_STS_NM" ).append("\n"); 
		query.append("      ,CHK1" ).append("\n"); 
		query.append("      ,PRT_BKG_NO" ).append("\n"); 
		query.append("      ,RAIL_CRE_DT_DD" ).append("\n"); 
		query.append("      ,RAIL_CRE_DT_HMS" ).append("\n"); 
		query.append("      ,RAIL_TO_NOD_CD" ).append("\n"); 
		query.append("      ,LSE_CNTR_FLG" ).append("\n"); 
		query.append("      ,TRSP_CRR_MOD_CD2" ).append("\n"); 
		query.append("      ,FEEDERVVD" ).append("\n"); 
		query.append("      ,'N' DUP_FLG" ).append("\n"); 
		query.append("	  ,STOP_OFF_FLG" ).append("\n"); 
		query.append("      ,STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("      ,STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("      ,STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("      ,DECODE(INTER_RMK_CHK, '', '', 'Y') INTER_RMK" ).append("\n"); 
		query.append("      ,BKG_STS_CD" ).append("\n"); 
		query.append("      ,BKG_STS_CD_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  SUBSTR(X.BKG_VVD_IB, 1, INSTR(X.BKG_VVD_IB, '^', 1, 1) - 1) AS IB_VVD_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.BKG_VVD_OB, 1, INSTR(X.BKG_VVD_OB, '^', 1, 1) - 1) AS OB_VVD_CD" ).append("\n"); 
		query.append("           ,X.CTRL_OFC_CD" ).append("\n"); 
		query.append("           ,X.COP_NO" ).append("\n"); 
		query.append("           ,(CASE WHEN X.EQ_NO = 'COMU0000000' THEN ''" ).append("\n"); 
		query.append("                  WHEN X.TRSP_BND_CD = 'O' AND X.TRSP_COST_DTL_MOD_CD  = 'DR' THEN ''" ).append("\n"); 
		query.append("                  ELSE X.EQ_NO" ).append("\n"); 
		query.append("            END) AS EQ_NO" ).append("\n"); 
		query.append("           ,X.EQ_TPSZ_CD" ).append("\n"); 
		query.append("           ,X.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("           ,X.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("           ,X.VNDR_SEQ" ).append("\n"); 
		query.append("           ,DECODE(X.TRSP_COST_DTL_MOD_CD,'','CY',X.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("           ,X.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("           ,X.FM_NOD_CD" ).append("\n"); 
		query.append("           ,X.FM_NOD_YD_NO AS FM_NOD_YARD" ).append("\n"); 
		query.append("           ,X.TO_NOD_CD" ).append("\n"); 
		query.append("           ,X.TO_NOD_YD_NO AS TO_NOD_YARD" ).append("\n"); 
		query.append("           ,X.VIA_NOD_CD" ).append("\n"); 
		query.append("           ,X.VIA_NOD_YD_NO AS VIA_NOD_YARD" ).append("\n"); 
		query.append("           ,X.DOR_NOD_CD" ).append("\n"); 
		query.append("           ,X.DOR_NOD_YD_NO AS DOR_NOD_YARD" ).append("\n"); 
		query.append("           ,'' AS FM_NOD_CD2" ).append("\n"); 
		query.append("           ,'' AS FM_NOD_YARD2" ).append("\n"); 
		query.append("           ,'' AS TO_NOD_CD2" ).append("\n"); 
		query.append("           ,'' AS TO_NOD_YARD2" ).append("\n"); 
		query.append("           ,'' AS VIA_NOD_CD2 " ).append("\n"); 
		query.append("           ,'' AS VIA_NOD_YARD2" ).append("\n"); 
		query.append("           ,'' AS DOR_NOD_CD2 " ).append("\n"); 
		query.append("           ,'' AS DOR_NOD_YARD2" ).append("\n"); 
		query.append("           ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'YYYYMMDD'  )                              AS N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'HH24:MI:SS')                              AS N1ST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("           ,TO_CHAR(X.LST_NOD_PLN_DT, 'YYYYMMDD'  )                               AS LST_NOD_PLN_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(X.LST_NOD_PLN_DT, 'HH24:MI:SS')                               AS LST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("           ,X.DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(X.DOR_NOD_PLN_DT, 'YYYYMMDDHH24MISS')                         AS DOR_NOD_PLN" ).append("\n"); 
		query.append("           ,X.TRO_SEQ" ).append("\n"); 
		query.append("           ,X.TRO_SUB_SEQ" ).append("\n"); 
		query.append("           ,DECODE(X.TRO_SEQ, NULL, 'N', 'Y') AS TRO_CNFM" ).append("\n"); 
		query.append("           ,X.TRSP_BND_CD" ).append("\n"); 
		query.append("           ,X.TRNS_RQST_OFC_CD" ).append("\n"); 
		query.append("           ,X.TRNS_RQST_USR_ID" ).append("\n"); 
		query.append("           ,X.TRNS_RQST_RSN" ).append("\n"); 
		query.append("           ,X.RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("           ,X.BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("           ,X.BKG_NO" ).append("\n"); 
		query.append("           ,X.POD_CONTI_CD" ).append("\n"); 
		query.append("           ,X.FM_LOC_CONTI_CD" ).append("\n"); 
		query.append("           ,X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("           ,X.CUST_CNT_CD" ).append("\n"); 
		query.append("           ,X.CUST_SEQ" ).append("\n"); 
		query.append("           ,X.CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append("           ,X.CNEE_CUST_SEQ" ).append("\n"); 
		query.append("           ,X.SHPR_CUST_CNT_CD" ).append("\n"); 
		query.append("           ,X.SHPR_CUST_SEQ" ).append("\n"); 
		query.append("           ,X.BL_NO" ).append("\n"); 
		query.append("           ,X.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("           ,X.CGO_TP_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.BKG_CNTR, 1, INSTR(X.BKG_CNTR, '^', 1, 1) - 1) AS PKGCODE" ).append("\n"); 
		query.append("           ,X.TRNK_VVD_CD AS TRUNKVVD" ).append("\n"); 
		query.append("           ,X.SLAN_CD" ).append("\n"); 
		query.append("           ,X.POR_CD" ).append("\n"); 
		query.append("           ,X.POL_CD" ).append("\n"); 
		query.append("           ,X.POD_CD" ).append("\n"); 
		query.append("           ,X.DEL_CD" ).append("\n"); 
		query.append("           ,TO_DATE(SUBSTR(X.BDR_INFO, 1, INSTR(X.BDR_INFO, '^', 1, 1) - 1),'YYYYMMDDHH24MISS') AS BKG_BDR_DT" ).append("\n"); 
		query.append("           ,SUBSTR(X.BDR_INFO, INSTR(X.BDR_INFO, '^', 1, 1) + 1) BKG_BDR_FLG" ).append("\n"); 
		query.append("           ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 1) AS SEALNO" ).append("\n"); 
		query.append("           ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 2) AS SEALNO2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,TRIM((SELECT REGEXP_SUBSTR(X.BKG_CNTR, '[^^]+', 1, 5) FROM DUAL))  VGM_WGT_UT_CD" ).append("\n"); 
		query.append("           ,TO_NUMBER(NVL(TRIM((SELECT REGEXP_SUBSTR(X.BKG_CNTR, '[^^]+', 1, 6) FROM DUAL)), '0'))  VGM_WGT" ).append("\n"); 
		query.append("           ,TO_NUMBER(NVL(TRIM((SELECT REGEXP_SUBSTR(X.BKG_CNTR, '[^^]+', 1, 4) FROM DUAL)), 0))  CNTR_WGT" ).append("\n"); 
		query.append("           ,TRIM((SELECT REGEXP_SUBSTR(X.BKG_CNTR, '[^^]+', 1, 3) FROM DUAL))  WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("           ,TO_NUMBER(NVL(TRIM((SELECT REGEXP_SUBSTR(X.BKG_CNTR, '[^^]+', 1, 2) FROM DUAL)), '0')) NOOFPKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,CASE WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y'" ).append("\n"); 
		query.append("                  AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) = 'Y' THEN 'AD'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y'" ).append("\n"); 
		query.append("                  AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) = 'Y' THEN 'RD'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y'" ).append("\n"); 
		query.append("                  AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) != 'Y'" ).append("\n"); 
		query.append("                  AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) != 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) != 'Y'" ).append("\n"); 
		query.append("                  AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) = 'Y' THEN 'AK'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) != 'Y'" ).append("\n"); 
		query.append("                  AND SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 1) + 1, INSTR(X.BKG_SPE, '^', 1, 2) - INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("                 ELSE 'GP'" ).append("\n"); 
		query.append("            END AS SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,X.SHPR_CUST_NM" ).append("\n"); 
		query.append("           ,X.CNEE_CUST_NM" ).append("\n"); 
		query.append("           ,X.NTFY_CUST_NM" ).append("\n"); 
		query.append("           ,X.SC_NO" ).append("\n"); 
		query.append("           ,X.GEN_RFA_NO AS RFANO" ).append("\n"); 
		query.append("           ,X.CMDT_CD" ).append("\n"); 
		query.append("           , (SELECT REPLACE(W.CMDT_NM, CHR(13)||CHR(10)||CHR(9)||CHR(43), ' ')  FROM MDM_COMMODITY W WHERE W.CMDT_CD = X.CMDT_CD)  AS CMDT_NAME" ).append("\n"); 
		query.append("           ,NULL CGOR_FRT_PAY_IND_FLG" ).append("\n"); 
		query.append("           ,NULL CGOR_ORG_BL_RCVR_IND_FLG" ).append("\n"); 
		query.append("           ,NULL CGOR_CSTMS_ACPT_RE_IND_FLG          " ).append("\n"); 
		query.append("           ,SUBSTR(X.MST_CNTR, 1, INSTR(X.MST_CNTR, '^', 1, 1) - 1) OWNR_CO_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.MST_CNTR, INSTR(X.MST_CNTR, '^', 1, 1) + 1, INSTR(X.MST_CNTR, '^', 1, 2) - INSTR(X.MST_CNTR, '^', 1, 1) - 1) IMDT_EXT_FLG" ).append("\n"); 
		query.append("           ,SUBSTR(X.MST_CNTR, INSTR(X.MST_CNTR, '^', 1, 2) + 1) LSTM_CD" ).append("\n"); 
		query.append("           ,'' AS IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("           ,X.DOR_SVC_TP_CD" ).append("\n"); 
		query.append("           ,X.INTER_RMK" ).append("\n"); 
		query.append("           ,X.CRE_USR_ID" ).append("\n"); 
		query.append("           ,X.UPD_USR_ID" ).append("\n"); 
		query.append("           ,X.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		   ,NVL(CASE WHEN X.TRSP_BND_CD = 'I' THEN SUBSTR(X.BKG_VVD_IB, INSTR(X.BKG_VVD_IB, '^', 1, 1) + 1, INSTR(X.BKG_VVD_IB, '^', 1, 2) - INSTR(X.BKG_VVD_IB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("                     ELSE SUBSTR(X.BKG_VVD_OB, INSTR(X.BKG_VVD_OB, '^', 1, 1) + 1, INSTR(X.BKG_VVD_OB, '^', 1, 2) - INSTR(X.BKG_VVD_OB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("                END,X.POD_CD) AS TRSP_NXT_PORT_CD" ).append("\n"); 
		query.append("           ,TRS_CYDOOR_COMM_PKG.GET_MULTI_LST_LOC(X.FM_NOD_CD, X.TO_NOD_CD) AS LST_LOC_CD" ).append("\n"); 
		query.append("           ,TRS_CYDOOR_COMM_PKG.GET_TRSP_COST_DTL_MOD_SEP(X.TRSP_COST_DTL_MOD_CD, X.FM_NOD_CD, X.TO_NOD_CD, X.TRSP_BND_CD) AS TRSP_COST_DTL_MOD_SEP" ).append("\n"); 
		query.append("           ,'' DCGO_SEQ " ).append("\n"); 
		query.append("           ,'' RC_SEQ " ).append("\n"); 
		query.append("           ,'' AWK_CGO_SEQ " ).append("\n"); 
		query.append("           ,X.CNTR_PKUP_NO" ).append("\n"); 
		query.append("           ,TO_CHAR(X.AVAL_DT, 'YYYYMMDD')       AS AVAL_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(X.AVAL_DT, 'HH24:MI:SS')     AS AVAL_DT_HMS" ).append("\n"); 
		query.append("           ,TO_CHAR(X.LST_FREE_DT, 'YYYYMMDD')   AS LST_FREE_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(X.LST_FREE_DT, 'HH24:MI:SS') AS LST_FREE_DT_HMS" ).append("\n"); 
		query.append("           ,(SELECT DECODE(NVL(U.EQ_SUBST_CGO_QTY, 0), 0, U.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           ||' '||U.OP_CNTR_QTY, U.CNTR_TPSZ_CD||' '||U.OP_CNTR_QTY" ).append("\n"); 
		query.append("                           ||'-SUB '||U.EQ_SUBST_CNTR_TPSZ_CD ||' '||U.EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("              FROM BKG_QUANTITY U" ).append("\n"); 
		query.append("             WHERE U.BKG_NO       = X.BKG_NO" ).append("\n"); 
		query.append("               AND U.CNTR_TPSZ_CD = X.EQ_TPSZ_CD) AS BKG_QTY" ).append("\n"); 
		query.append("           ,X.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("           ,X.TRSP_SO_STS_NM" ).append("\n"); 
		query.append("           ,CASE WHEN X.MST_LCL_CD = 'P'" ).append("\n"); 
		query.append("                  AND SUBSTR(X.BDR_INFO, INSTR(X.BDR_INFO, '^', 1, 1) + 1) = 'N'" ).append("\n"); 
		query.append("                  AND X.TRSP_BND_CD            = 'I'" ).append("\n"); 
		query.append("                  AND X.TRSP_COST_DTL_MOD_CD   = 'DR'" ).append("\n"); 
		query.append("                 THEN 'FALSE'" ).append("\n"); 
		query.append("                 WHEN X.MST_LCL_CD = 'P'" ).append("\n"); 
		query.append("                 THEN 'TRUE'" ).append("\n"); 
		query.append("                 ELSE 'FALSE'" ).append("\n"); 
		query.append("            END                      AS  CHK1" ).append("\n"); 
		query.append("           ,(SELECT U.BKG_NO" ).append("\n"); 
		query.append("               FROM SCE_COP_HDR U" ).append("\n"); 
		query.append("              WHERE U.MST_COP_NO = X.COP_NO" ).append("\n"); 
		query.append("                AND ROWNUM = 1) AS PRT_BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,TO_CHAR(X.RAIL_CRE_DT, 'YYYY-MM-DD') AS RAIL_CRE_DT_DD" ).append("\n"); 
		query.append("           ,TO_CHAR(X.RAIL_CRE_DT, 'HH24:MI:SS') AS RAIL_CRE_DT_HMS" ).append("\n"); 
		query.append("           ,X.RAIL_TO_NOD_CD" ).append("\n"); 
		query.append("           ,'' LSE_CNTR_FLG" ).append("\n"); 
		query.append("           ,'' TRSP_CRR_MOD_CD2" ).append("\n"); 
		query.append("           ,(SELECT DISTINCT RMK.BKG_NO " ).append("\n"); 
		query.append("			   FROM TRS_INTER_RMK RMK" ).append("\n"); 
		query.append("			  WHERE X.BKG_NO = RMK.BKG_NO" ).append("\n"); 
		query.append("                AND NVL2(RMK.EQ_NO, X.EQ_NO, 'X') = NVL(RMK.EQ_NO, 'X')" ).append("\n"); 
		query.append("				AND RMK.DELT_FLG = 'N') AS INTER_RMK_CHK" ).append("\n"); 
		query.append("           ,CASE WHEN X.TRSP_BND_CD = 'I' THEN SUBSTR(X.BKG_VVD_IB, 1, INSTR(X.BKG_VVD_IB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("                 ELSE SUBSTR(X.BKG_VVD_OB, 1, INSTR(X.BKG_VVD_OB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("            END AS FEEDERVVD" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, 1, INSTR(X.TRO_INFO, '^', 1, 1) - 1) AS T_DOR_PST_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 1) + 1,  INSTR(X.TRO_INFO, '^', 1, 2) -  INSTR(X.TRO_INFO, '^', 1, 1)  - 1) AS T_FCTRY_NM" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 2) + 1,  INSTR(X.TRO_INFO, '^', 1, 3) -  INSTR(X.TRO_INFO, '^', 1, 2)  - 1) AS T_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 3) + 1,  INSTR(X.TRO_INFO, '^', 1, 4) -  INSTR(X.TRO_INFO, '^', 1, 3)  - 1) AS T_ACT_CUST_SEQ" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 4) + 1,  INSTR(X.TRO_INFO, '^', 1, 5) -  INSTR(X.TRO_INFO, '^', 1, 4)  - 1) AS T_ACT_CUST_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 5) + 1,  INSTR(X.TRO_INFO, '^', 1, 6) -  INSTR(X.TRO_INFO, '^', 1, 5)  - 1) AS T_DOR_DE_ADDR" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 6) + 1,  INSTR(X.TRO_INFO, '^', 1, 7) -  INSTR(X.TRO_INFO, '^', 1, 6)  - 1) AS T_CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 7) + 1,  INSTR(X.TRO_INFO, '^', 1, 8) -  INSTR(X.TRO_INFO, '^', 1, 7)  - 1) AS T_CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 8) + 1,  INSTR(X.TRO_INFO, '^', 1, 9) -  INSTR(X.TRO_INFO, '^', 1, 8)  - 1) AS T_CNTC_PSON_NM" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1, 9) + 1,  INSTR(X.TRO_INFO, '^', 1,10) -  INSTR(X.TRO_INFO, '^', 1, 9)  - 1) AS T_PROC_CFM_IND_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1,10) + 1,  INSTR(X.TRO_INFO, '^', 1,11) -  INSTR(X.TRO_INFO, '^', 1,10)  - 1) AS T_CFM_DT" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1,11) + 1,  INSTR(X.TRO_INFO, '^', 1,12) -  INSTR(X.TRO_INFO, '^', 1,11)  - 1) AS T_TRSP_RQST_ORD_RMK" ).append("\n"); 
		query.append("           ,SUBSTR(X.TRO_INFO, INSTR(X.TRO_INFO, '^', 1,12) + 1,  INSTR(X.TRO_INFO, '^', 1,13) -  INSTR(X.TRO_INFO, '^', 1,12)  - 1) AS T_EXIST" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("		   ,NVL2(BB.STOP_OFF_LOC_CD, 'Y', 'N') STOP_OFF_FLG" ).append("\n"); 
		query.append("           ,BB.STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("           ,BB.STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("           ,BB.STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("           ,BB.STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("           ,DECODE(X.CGO_TP_CD, 'F', DECODE(BB.BKG_STS_CD, 'W', 'W')) BKG_STS_CD" ).append("\n"); 
		query.append("           ,DECODE(X.CGO_TP_CD, 'F', DECODE(BB.BKG_STS_CD, 'W', INTG.INTG_CD_VAL_DESC)) BKG_STS_CD_NM" ).append("\n"); 
		query.append("    FROM  (SELECT TMP.*" ).append("\n"); 
		query.append("                ,(SELECT NVL(IB.VSL_CD||IB.SKD_VOY_NO||IB.SKD_DIR_CD, ' ')||'^'||NVL(IB.POD_CD, ' ')||'^'||NVL(IB.VSL_PRE_PST_CD, ' ')||'^'" ).append("\n"); 
		query.append("                    FROM BKG_VVD IB" ).append("\n"); 
		query.append("                   WHERE IB.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("                     AND IB.POD_CD = TMP.FM_NOD_CD" ).append("\n"); 
		query.append("                     AND ROWNUM = 1) BKG_VVD_IB" ).append("\n"); 
		query.append("                ,(SELECT NVL(OB.VSL_CD||OB.SKD_VOY_NO||OB.SKD_DIR_CD, ' ')||'^'||NVL(OB.POD_CD, ' ')||'^'" ).append("\n"); 
		query.append("                    FROM BKG_VVD OB" ).append("\n"); 
		query.append("                   WHERE OB.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("                     AND OB.POL_CD = ( CASE WHEN TMP.TRSP_BND_CD <> 'O' THEN TMP.FM_NOD_CD ELSE TMP.TO_NOD_CD END )" ).append("\n"); 
		query.append("                     AND ROWNUM = 1) BKG_VVD_OB" ).append("\n"); 
		query.append("                ,(SELECT NVL(BKG_CNTR.PCK_TP_CD, ' ') || '^' || NVL(TO_CHAR(BKG_CNTR.PCK_QTY), ' ') || '^' || NVL(WGT_UT_CD, ' ')" ).append("\n"); 
		query.append("                         || '^' || NVL(TO_CHAR(BKG_CNTR.CNTR_WGT) , ' ') || '^' ||NVL(BKG_CNTR.VGM_WGT_UT_CD, 'KGS') ||'^'||  NVL(TO_CHAR(BKG_CNTR.VGM_WGT) , ' ') || '^'" ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER BKG_CNTR" ).append("\n"); 
		query.append("                   WHERE BKG_CNTR.BKG_NO  = TMP.BKG_NO" ).append("\n"); 
		query.append("                     AND BKG_CNTR.CNTR_NO = TMP.EQ_NO ) BKG_CNTR" ).append("\n"); 
		query.append("			    ,CASE WHEN TMP.TRSP_BND_CD = 'I' THEN " ).append("\n"); 
		query.append("					(SELECT NVL(BKG.DCGO_FLG, ' ') || '^' || NVL(BKG.BB_CGO_FLG, ' ') || '^' ||" ).append("\n"); 
		query.append("						  NVL(BKG.AWK_CGO_FLG, ' ') || '^' || NVL(BKG.RC_FLG, ' ') || '^' ||" ).append("\n"); 
		query.append("						  NVL(BKG.RD_CGO_FLG, ' ') || '^'" ).append("\n"); 
		query.append("					 FROM BKG_CONTAINER BKG" ).append("\n"); 
		query.append("					WHERE BKG.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("					  AND BKG.CNTR_NO = TMP.EQ_NO          " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				 ELSE" ).append("\n"); 
		query.append("					(SELECT NVL(BKG.DCGO_FLG, ' ') || '^' || NVL(BKG.BB_CGO_FLG, ' ') || '^' ||" ).append("\n"); 
		query.append("						  NVL(BKG.AWK_CGO_FLG, ' ') || '^' || NVL(BKG.RC_FLG, ' ') || '^' ||" ).append("\n"); 
		query.append("						  NVL(BKG.RD_CGO_FLG, ' ') || '^'" ).append("\n"); 
		query.append("					 FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("					WHERE BKG.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				 END BKG_SPE" ).append("\n"); 
		query.append("                ,(SELECT NVL(MST_CNTR.OWNR_CO_CD, ' ') || '^' || NVL(MST_CNTR.IMDT_EXT_FLG, ' ') || '^' || NVL(MST_CNTR.LSTM_CD, ' ')" ).append("\n"); 
		query.append("                    FROM MST_CONTAINER MST_CNTR" ).append("\n"); 
		query.append("                   WHERE MST_CNTR.CNTR_NO = TMP.EQ_NO) MST_CNTR" ).append("\n"); 
		query.append("                ,(SELECT TO_CHAR(BDR_DT,'YYYYMMDDHH24MISS')||'^'||NVL(BDR_FLG,'N')" ).append("\n"); 
		query.append("                    FROM BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                   WHERE DOC.BKG_NO = TMP.BKG_NO) BDR_INFO" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                 -- Door infomation 을 조회하기 위한 정보 조회" ).append("\n"); 
		query.append("                ,(SELECT  TRO.DOR_PST_NO       " ).append("\n"); 
		query.append("                        || '^' || REPLACE(TRO.ACT_SHPR_NM, '^', ' ')" ).append("\n"); 
		query.append("                        || '^' || TRO.ACT_SHPR_CNT_CD  " ).append("\n"); 
		query.append("                        || '^' || TRO.ACT_SHPR_SEQ    " ).append("\n"); 
		query.append("                        || '^' || TRO.ACT_SHPR_CNT_CD || TRO.ACT_SHPR_SEQ" ).append("\n"); 
		query.append("                        || '^' || REPLACE(TRO.ACT_SHPR_ADDR, '^', ' ')" ).append("\n"); 
		query.append("                        || '^' || TRO.ACT_SHPR_PHN_NO " ).append("\n"); 
		query.append("                        || '^' || TRO.CNTC_FAX_NO    " ).append("\n"); 
		query.append("                        || '^' || REPLACE(TRO.CNTC_PSON_NM, '^', ' ')" ).append("\n"); 
		query.append("                        || '^' || TRO.CFM_FLG       " ).append("\n"); 
		query.append("                        || '^' || TO_CHAR(TRO.CFM_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                        || '^' || REPLACE(TRO.DIFF_RMK, '^', ' ')" ).append("\n"); 
		query.append("                        || '^' || TRO.BKG_NO" ).append("\n"); 
		query.append("                        || '^'" ).append("\n"); 
		query.append("                    FROM BKG_TRO TRO" ).append("\n"); 
		query.append("                   WHERE TRO.BKG_NO      = TMP.BKG_NO" ).append("\n"); 
		query.append("                     AND TRO.IO_BND_CD   = TMP.TRSP_BND_CD" ).append("\n"); 
		query.append("                     AND TRO.RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("                     AND TRO.TRO_SEQ     = TMP.TRO_SEQ) TRO_INFO " ).append("\n"); 
		query.append("             FROM TRS_TRSP_SVC_ORD_TMP TMP" ).append("\n"); 
		query.append("            WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("          ) X , BKG_BOOKING BB" ).append("\n"); 
		query.append("         ,COM_INTG_CD_DTL INTG" ).append("\n"); 
		query.append("	WHERE X.BKG_NO = BB.BKG_NO(+)" ).append("\n"); 
		query.append("      AND BB.BKG_STS_CD = INTG.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("      AND INTG.INTG_CD_ID(+) = 'CD00769'" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("ORDER BY N1ST_NOD_PLN_DT DESC" ).append("\n"); 

	}
}