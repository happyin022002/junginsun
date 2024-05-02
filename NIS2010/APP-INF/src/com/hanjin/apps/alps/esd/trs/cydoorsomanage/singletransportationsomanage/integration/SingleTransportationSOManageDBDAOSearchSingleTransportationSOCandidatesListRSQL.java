/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 대상 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(X.BKG_VVD_IB, 1, INSTR(X.BKG_VVD_IB, '^', 1, 1) - 1) AS IB_VVD_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.BKG_VVD_OB, 1, INSTR(X.BKG_VVD_OB, '^', 1, 1) - 1) AS OB_VVD_CD" ).append("\n"); 
		query.append("           ,X.CTRL_OFC_CD" ).append("\n"); 
		query.append("           ,X.COP_NO" ).append("\n"); 
		query.append("           ,(CASE WHEN X.EQ_NO = 'SMCU0000000' THEN ''" ).append("\n"); 
		query.append("                  WHEN X.TRSP_BND_CD = 'O' AND X.TRSP_COST_DTL_MOD_CD  = 'DR' THEN ''" ).append("\n"); 
		query.append("                  ELSE X.EQ_NO" ).append("\n"); 
		query.append("            END) AS EQ_NO" ).append("\n"); 
		query.append("           ,X.EQ_TPSZ_CD" ).append("\n"); 
		query.append("           ,X.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("           ,X.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("           ,X.VNDR_SEQ" ).append("\n"); 
		query.append("           ,DECODE(X.TRSP_COST_DTL_MOD_CD,'','CY',X.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("           ,X.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("		   ,X.TRSP_CRR_MOD_CD TRSP_CRR_MOD_CD2" ).append("\n"); 
		query.append("           ,X.FM_NOD_CD" ).append("\n"); 
		query.append("           ,X.FM_NOD_YD_NO AS FM_NOD_YARD" ).append("\n"); 
		query.append("           ,X.TO_NOD_CD" ).append("\n"); 
		query.append("           ,X.TO_NOD_YD_NO AS TO_NOD_YARD" ).append("\n"); 
		query.append("           ,X.VIA_NOD_CD" ).append("\n"); 
		query.append("           ,X.VIA_NOD_YD_NO AS VIA_NOD_YARD" ).append("\n"); 
		query.append("           ,X.DOR_NOD_CD" ).append("\n"); 
		query.append("           ,X.DOR_NOD_YD_NO AS DOR_NOD_YARD" ).append("\n"); 
		query.append("           ,'' AS FM_NOD_CD2    -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,'' AS FM_NOD_YARD2  -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,'' AS TO_NOD_CD2    -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,'' AS TO_NOD_YARD2  -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,'' AS VIA_NOD_CD2   -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,'' AS VIA_NOD_YARD2 -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,'' AS DOR_NOD_CD2   -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,'' AS DOR_NOD_YARD2 -- java Adapter에서 데이타를 셋팅한다." ).append("\n"); 
		query.append("           ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'YYYYMMDD'  )                              AS N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'HH24:MI:SS')                              AS N1ST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("           ,TO_CHAR(X.LST_NOD_PLN_DT, 'YYYYMMDD'  )                               AS LST_NOD_PLN_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(X.LST_NOD_PLN_DT, 'HH24:MI:SS')                               AS LST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("           ,NULL DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("           ,NULL DOR_NOD_PLN_DT_HMS    " ).append("\n"); 
		query.append("           ,NULL DOR_ARR_DT_DD" ).append("\n"); 
		query.append("           ,NULL DOR_ARR_DT_HMS" ).append("\n"); 
		query.append("           ,NULL DOR_ARR_DT" ).append("\n"); 
		query.append("           ,NULL DOR_NOD_PLN" ).append("\n"); 
		query.append("           ,X.TRO_SEQ" ).append("\n"); 
		query.append("           ,X.TRO_SUB_SEQ" ).append("\n"); 
		query.append("           ,DECODE(X.TRO_SEQ, NULL, 'N', 'Y') AS TRO_CNFM" ).append("\n"); 
		query.append("           ,NULL TRO_CFM_OFC_CD" ).append("\n"); 
		query.append("           ,NULL TRO_CFM_USR_ID" ).append("\n"); 
		query.append("           ,NULL TRO_CFM_UPD_DT1" ).append("\n"); 
		query.append("           ,NULL TRO_CFM_UPD_DT2" ).append("\n"); 
		query.append("           ,NULL TRO_CFM_CURR_CD" ).append("\n"); 
		query.append("           ,NULL TRO_CFM_REV_AMT" ).append("\n"); 
		query.append("           ,NULL TRO_LOD_REF_NO" ).append("\n"); 
		query.append("           ,NULL TRO_REP_CMDT_CD" ).append("\n"); 
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
		query.append("           ,NULL ACT_CUST_CD" ).append("\n"); 
		query.append("           ,NULL ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("           ,NULL ACT_CUST_SEQ" ).append("\n"); 
		query.append("           ,NULL ACT_CUST_ADDR_SEQ" ).append("\n"); 
		query.append("           ,NULL DOR_PST_CD" ).append("\n"); 
		query.append("           ,NULL FCTRY_NM" ).append("\n"); 
		query.append("           ,NULL DOR_DE_ADDR" ).append("\n"); 
		query.append("           ,NULL CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("           ,NULL CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("           ,NULL CNTC_PSON_NM" ).append("\n"); 
		query.append("		#if( ${ui_conti_cd} == 'E' )" ).append("\n"); 
		query.append("		   ,(SELECT A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("    		   FROM BKG_EUR_TRO A" ).append("\n"); 
		query.append("			  WHERE  1=1" ).append("\n"); 
		query.append("			    AND A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                AND A.IO_BND_CD = X.TRSP_BND_CD" ).append("\n"); 
		query.append("                AND A.TRO_SEQ  = X.TRO_SEQ" ).append("\n"); 
		query.append("                AND A.RQST_SUB_SEQ = X.TRO_SUB_SEQ ) SPCL_INSTR_RMK" ).append("\n"); 
		query.append("		#else			" ).append("\n"); 
		query.append("           ,NULL SPCL_INSTR_RMK" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("           ,NULL USA_DO_USR_INFO" ).append("\n"); 
		query.append("           ,NULL DO_CRE_DATE" ).append("\n"); 
		query.append("           ,NULL DO_CRE_TIME" ).append("\n"); 
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
		query.append("           ,TO_DATE(SUBSTR(X.BDR_INFO, 1, INSTR(X.BDR_INFO, '^', 1, 1) - 1),'YYYYMMDDHH24MISS') AS BKG_BDR_DT -- SUBSTR의 첫번째 값" ).append("\n"); 
		query.append("           ,SUBSTR(X.BDR_INFO, INSTR(X.BDR_INFO, '^', 1, 1) + 1) BKG_BDR_FLG -- SUBSTR의 두번째 값" ).append("\n"); 
		query.append("           ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 1) AS SEALNO" ).append("\n"); 
		query.append("           ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 2) AS SEALNO2" ).append("\n"); 
		query.append("           ,SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 8) + 1, INSTR(X.BKG_CNTR, '^', 1, 9) - INSTR(X.BKG_CNTR, '^', 1, 8) - 1) AS CNTR_WGT" ).append("\n"); 
		query.append("           ,SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 2) + 1, INSTR(X.BKG_CNTR, '^', 1, 3) - INSTR(X.BKG_CNTR, '^', 1, 2) - 1) AS WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("           ,TO_NUMBER(TRIM(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 1) + 1, INSTR(X.BKG_CNTR, '^', 1, 2) - INSTR(X.BKG_CNTR, '^', 1, 1) - 1))) AS NOOFPKG" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("           ,CASE WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 3) + 1, INSTR(X.BKG_CNTR, '^', 1, 4) - INSTR(X.BKG_CNTR, '^', 1, 3) - 1) = 'Y' THEN 'DG'                            " ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 4) + 1, INSTR(X.BKG_CNTR, '^', 1, 5) - INSTR(X.BKG_CNTR, '^', 1, 4) - 1) = 'Y' THEN 'BB'                            " ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 5) + 1, INSTR(X.BKG_CNTR, '^', 1, 6) - INSTR(X.BKG_CNTR, '^', 1, 5) - 1) = 'Y' THEN 'AK'                            " ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 6) + 1, INSTR(X.BKG_CNTR, '^', 1, 7) - INSTR(X.BKG_CNTR, '^', 1, 6) - 1) = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 7) + 1, INSTR(X.BKG_CNTR, '^', 1, 8) - INSTR(X.BKG_CNTR, '^', 1, 7) - 1) = 'Y' THEN 'RD'                                                   " ).append("\n"); 
		query.append("                ELSE -- Adds logic of Partial Booking Special Cargo" ).append("\n"); 
		query.append("                    CASE WHEN X.EQ_NO = 'SMCU0000000' THEN ''" ).append("\n"); 
		query.append("	                     WHEN X.TRSP_BND_CD = 'O' AND X.TRSP_COST_DTL_MOD_CD  = 'DR' THEN ''" ).append("\n"); 
		query.append("                       ELSE " ).append("\n"); 
		query.append("	                     ( SELECT MAX(DECODE(DCGO_FLG,'Y', 'DG', DECODE(RC_FLG, 'Y', 'RF', DECODE(BB_CGO_FLG, 'Y', 'BB', DECODE(AWK_CGO_FLG, 'Y', 'AK', DECODE(RD_CGO_FLG, 'Y', 'RD', ''))))))" ).append("\n"); 
		query.append("                           FROM BKG_CONTAINER" ).append("\n"); 
		query.append("		                   WHERE (BKG_NO, CNTR_NO) IN (" ).append("\n"); 
		query.append("			                 SELECT BKG_NO,CNTR_NO FROM  SCE_COP_HDR WHERE MST_COP_NO IN (SELECT MST_COP_NO FROM SCE_COP_HDR WHERE BKG_NO = X.BKG_NO AND CNTR_NO = X.EQ_NO)" ).append("\n"); 
		query.append("                         ))" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("            END AS SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("           ,X.SHPR_CUST_NM" ).append("\n"); 
		query.append("           ,X.CNEE_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 2) + 1, INSTR(X.BKG_CNTR, '^', 1, 3) - INSTR(X.BKG_CNTR, '^', 1, 2) - 1)," ).append("\n"); 
		query.append("                                              TRIM(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 8) + 1, INSTR(X.BKG_CNTR, '^', 1, 9) - INSTR(X.BKG_CNTR, '^', 1, 8) - 1))" ).append("\n"); 
		query.append("           ) AS CNTR_KGS_WGT -- EUR TRO에 Weight가 없으면 BKG CNTR 의 Weight값을 조회한다." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 2) + 1, INSTR(X.BKG_CNTR, '^', 1, 3) - INSTR(X.BKG_CNTR, '^', 1, 2) - 1)," ).append("\n"); 
		query.append("                                              TRIM(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '^', 1, 8) + 1, INSTR(X.BKG_CNTR, '^', 1, 9) - INSTR(X.BKG_CNTR, '^', 1, 8) - 1))" ).append("\n"); 
		query.append("           ) AS CNTR_LBS_WGT -- EUR TRO에 Weight가 없으면 BKG CNTR 의 Weight값을 조회한다." ).append("\n"); 
		query.append("           ,X.NTFY_CUST_NM" ).append("\n"); 
		query.append("           ,X.SC_NO" ).append("\n"); 
		query.append("           ,X.GEN_RFA_NO AS RFANO" ).append("\n"); 
		query.append("           ,X.CMDT_CD" ).append("\n"); 
		query.append("           , NVL((SELECT LPAD(NVL(V.PCK_TP_CD, ' '),2, ' ') || TO_CHAR(V.PCK_QTY)" ).append("\n"); 
		query.append("                    FROM BKG_CNTR_MF_DESC V" ).append("\n"); 
		query.append("                   WHERE V.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                     AND V.CNTR_NO  = X.EQ_NO" ).append("\n"); 
		query.append("                     AND V.CNTR_MF_SEQ = 1)," ).append("\n"); 
		query.append("                 (SELECT REPLACE(W.CMDT_NM, CHR(13)||CHR(10)||CHR(9)||CHR(43), ' ') " ).append("\n"); 
		query.append("                    FROM MDM_COMMODITY W" ).append("\n"); 
		query.append("                   WHERE W.CMDT_CD = X.CMDT_CD) " ).append("\n"); 
		query.append("                ) AS CMDT_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,DECODE(@[ui_conti_cd], 'M', SUBSTR(X.CGO_RLSE, 1, INSTR(X.CGO_RLSE, '^', 1, 1) - 1), '') AS CGOR_FRT_PAY_IND_FLG" ).append("\n"); 
		query.append("           ,DECODE(@[ui_conti_cd], 'M', SUBSTR(X.CGO_RLSE, INSTR(X.CGO_RLSE, '^', 1, 1) + 1, INSTR(X.CGO_RLSE, '^', 1, 2) - INSTR(X.CGO_RLSE, '^', 1, 1) - 1), '') AS CGOR_ORG_BL_RCVR_IND_FLG" ).append("\n"); 
		query.append("           ,DECODE(@[ui_conti_cd], 'M', SUBSTR(X.CGO_RLSE, INSTR(X.CGO_RLSE, '^', 1, 2) + 1), '') AS CGOR_CSTMS_ACPT_RE_IND_FLG           " ).append("\n"); 
		query.append("           ,SUBSTR(X.MST_CNTR, 1, INSTR(X.MST_CNTR, '^', 1, 1) - 1) OWNR_CO_CD" ).append("\n"); 
		query.append("           ,SUBSTR(X.MST_CNTR, INSTR(X.MST_CNTR, '^', 1, 1) + 1, INSTR(X.MST_CNTR, '^', 1, 2) - INSTR(X.MST_CNTR, '^', 1, 1) - 1) IMDT_EXT_FLG" ).append("\n"); 
		query.append("           ,SUBSTR(X.MST_CNTR, INSTR(X.MST_CNTR, '^', 1, 2) + 1) LSTM_CD" ).append("\n"); 
		query.append("           ,(SELECT CSTMS_ADV_BL.CSTMS_LOC_CD FROM BKG_CSTMS_ADV_BL CSTMS_ADV_BL WHERE CSTMS_ADV_BL.BL_NO = X.BL_NO AND CSTMS_ADV_BL.CNT_CD = 'US' AND CSTMS_ADV_BL.MF_NO IS NULL AND ROWNUM =1) AS IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("           ,X.DOR_SVC_TP_CD" ).append("\n"); 
		query.append("           ,X.INTER_RMK" ).append("\n"); 
		query.append("           ,X.CRE_USR_ID" ).append("\n"); 
		query.append("           ,X.UPD_USR_ID" ).append("\n"); 
		query.append("           ,X.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		   ,NVL(CASE WHEN X.TRSP_BND_CD = 'I' THEN SUBSTR(X.BKG_VVD_IB, INSTR(X.BKG_VVD_IB, '^', 1, 1) + 1, INSTR(X.BKG_VVD_IB, '^', 1, 2) - INSTR(X.BKG_VVD_IB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("                     ELSE SUBSTR(X.BKG_VVD_OB, INSTR(X.BKG_VVD_OB, '^', 1, 1) + 1, INSTR(X.BKG_VVD_OB, '^', 1, 2) - INSTR(X.BKG_VVD_OB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("                END,X.POD_CD) AS TRSP_NXT_PORT_CD" ).append("\n"); 
		query.append("           ,TRS_CYDOOR_COMM_PKG.GET_MULTI_LST_LOC(X.FM_NOD_CD, X.TO_NOD_CD) AS LST_LOC_CD" ).append("\n"); 
		query.append("           ,NULL CUSTOMSCLEARANCENO" ).append("\n"); 
		query.append("           ,NULL CUSTOMSCLEARANCE" ).append("\n"); 
		query.append("           ,NULL MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("           ,NULL PROC_CFM_IND_CD" ).append("\n"); 
		query.append("           ,TRS_CYDOOR_COMM_PKG.GET_TRSP_COST_DTL_MOD_SEP(X.TRSP_COST_DTL_MOD_CD, X.FM_NOD_CD, X.TO_NOD_CD, X.TRSP_BND_CD) AS TRSP_COST_DTL_MOD_SEP" ).append("\n"); 
		query.append("           ,'' DCGO_SEQ -- CY에서는 데이타 없음" ).append("\n"); 
		query.append("           ,'' RC_SEQ  -- CY에서는 데이타 없음" ).append("\n"); 
		query.append("           ,'' AWK_CGO_SEQ -- CY에서는 데이타 없음" ).append("\n"); 
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
		query.append("           ,NULL CSTMS_CLR_NO" ).append("\n"); 
		query.append("           ,NULL REP_CMDT_CD" ).append("\n"); 
		query.append("           ,NULL REV_CURR_CD" ).append("\n"); 
		query.append("           ,NULL TRSP_RQST_ORD_REV_AMT" ).append("\n"); 
		query.append("           ,NULL TRSP_RQST_ORD_BND_CD" ).append("\n"); 
		query.append("           ,NULL TRSP_RQST_ORD_SEQ" ).append("\n"); 
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
		query.append("           ,CASE WHEN X.TRSP_BND_CD = 'I' THEN SUBSTR(X.BKG_VVD_IB, 1, INSTR(X.BKG_VVD_IB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("                 ELSE SUBSTR(X.BKG_VVD_OB, 1, INSTR(X.BKG_VVD_OB, '^', 1, 1) - 1)" ).append("\n"); 
		query.append("            END AS FEEDERVVD" ).append("\n"); 
		query.append("		   ,(  SELECT CASE" ).append("\n"); 
		query.append("                        WHEN COUNT(*) = 0 THEN 'N'" ).append("\n"); 
		query.append("                        ELSE 'Y'" ).append("\n"); 
		query.append("                      END AS SO_DUP_CHK" ).append("\n"); 
		query.append("                FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                WHERE COP_NO = X.COP_NO" ).append("\n"); 
		query.append("                  AND DECODE(TRSP_COST_DTL_MOD_CD, 'LS', 'CY', 'TS', 'CY', TRSP_COST_DTL_MOD_CD ) = X.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("                  AND TRSP_CRR_MOD_CD = X.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                  AND FM_NOD_CD = X.FM_NOD_CD||X.FM_NOD_YD_NO" ).append("\n"); 
		query.append("                  AND TO_NOD_CD = X.TO_NOD_CD||X.TO_NOD_YD_NO" ).append("\n"); 
		query.append("                  AND NVL(VIA_NOD_CD, ' ') = NVL(X.VIA_NOD_CD||X.VIA_NOD_YD_NO, ' ') " ).append("\n"); 
		query.append("                  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("			) DUP_FLG" ).append("\n"); 
		query.append("      	  ,SUBSTR (X.PRD_DIST, 1, INSTR (X.PRD_DIST, '/') - 1) LNK_DIST_DIV_CD" ).append("\n"); 
		query.append("      	  ,SUBSTR (X.PRD_DIST, INSTR (X.PRD_DIST, '/') + 1) TTL_DIST" ).append("\n"); 
		query.append("          ,X.NON_RT_STS_CD" ).append("\n"); 
		query.append("          ,X.BLCK_STWG" ).append("\n"); 
		query.append("    FROM  (SELECT TMP.*" ).append("\n"); 
		query.append("                ,(SELECT NVL(IB.VSL_CD||IB.SKD_VOY_NO||IB.SKD_DIR_CD, ' ')||'^'||NVL(IB.POD_CD, ' ')||'^'||NVL(IB.VSL_PRE_PST_CD, ' ')||'^'" ).append("\n"); 
		query.append("                    FROM BKG_VVD IB" ).append("\n"); 
		query.append("                   WHERE IB.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("                     AND IB.POD_CD = TMP.FM_NOD_CD" ).append("\n"); 
		query.append("                     AND ROWNUM = 1) BKG_VVD_IB" ).append("\n"); 
		query.append("                ,(SELECT NVL(OB.VSL_CD||OB.SKD_VOY_NO||OB.SKD_DIR_CD, ' ')||'^'||NVL(OB.POD_CD, ' ')||'^'" ).append("\n"); 
		query.append("                    FROM BKG_VVD OB" ).append("\n"); 
		query.append("                   WHERE OB.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("                     AND OB.POL_CD = ( CASE WHEN TMP.TRSP_BND_CD <> 'O' THEN TMP.FM_NOD_CD" ).append("\n"); 
		query.append("                                       ELSE TMP.TO_NOD_CD END )" ).append("\n"); 
		query.append("                     AND ROWNUM = 1) BKG_VVD_OB" ).append("\n"); 
		query.append("                ,(SELECT NVL(RLSE.FRT_CLT_FLG, ' ') || '^' || NVL(RLSE.OBL_RDEM_FLG, ' ') || '^' || DECODE(RLSE.CSTMS_CLR_CD, 'Y', 'Y', ' ')" ).append("\n"); 
		query.append("                    FROM BKG_CGO_RLSE RLSE" ).append("\n"); 
		query.append("                   WHERE RLSE.BL_NO = TMP.BL_NO) CGO_RLSE" ).append("\n"); 
		query.append("                ,(SELECT NVL(BKG_CNTR.PCK_TP_CD, ' ') || '^' || NVL(TO_CHAR(BKG_CNTR.PCK_QTY), ' ') || '^' || NVL(WGT_UT_CD, ' ')" ).append("\n"); 
		query.append("                         || '^' || NVL(BKG_CNTR.DCGO_FLG , ' ') || '^' || NVL(BKG_CNTR.BB_CGO_FLG , ' ') || '^' || NVL(BKG_CNTR.AWK_CGO_FLG , ' ') " ).append("\n"); 
		query.append("                         || '^' || NVL(BKG_CNTR.RC_FLG , ' ') || '^' || NVL(BKG_CNTR.RD_CGO_FLG , ' ') || '^' || NVL(TO_CHAR(BKG_CNTR.CNTR_WGT) , ' ') || '^'   " ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER BKG_CNTR" ).append("\n"); 
		query.append("                   WHERE BKG_CNTR.BKG_NO  = TMP.BKG_NO" ).append("\n"); 
		query.append("                     AND BKG_CNTR.CNTR_NO = TMP.EQ_NO ) BKG_CNTR" ).append("\n"); 
		query.append("                ,(SELECT NVL(MST_CNTR.OWNR_CO_CD, ' ') || '^' || NVL(MST_CNTR.IMDT_EXT_FLG, ' ') || '^' || NVL(MST_CNTR.LSTM_CD, ' ')" ).append("\n"); 
		query.append("                    FROM MST_CONTAINER MST_CNTR" ).append("\n"); 
		query.append("                   WHERE MST_CNTR.CNTR_NO = TMP.EQ_NO) MST_CNTR" ).append("\n"); 
		query.append("                ,(SELECT TO_CHAR(BDR_DT,'YYYYMMDDHH24MISS')||'^'||NVL(BDR_FLG,'N')" ).append("\n"); 
		query.append("                    FROM BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                   WHERE DOC.BKG_NO = TMP.BKG_NO) BDR_INFO" ).append("\n"); 
		query.append("				,TRS_COMMON_PKG.GET_PRD_DISTANCE_FNC ( FM_NOD_CD || FM_NOD_YD_NO" ).append("\n"); 
		query.append("                 			                          ,TO_NOD_CD || TO_NOD_YD_NO" ).append("\n"); 
		query.append("                                                      ,VIA_NOD_CD || VIA_NOD_YD_NO" ).append("\n"); 
		query.append("		                                              ,DOR_NOD_CD || DOR_NOD_YD_NO" ).append("\n"); 
		query.append("                                                      ,TRSP_BND_CD" ).append("\n"); 
		query.append("													  ,TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("                                                      ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                                                      ) PRD_DIST" ).append("\n"); 
		query.append("                ,(SELECT BB.NON_RT_STS_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                  WHERE BB.BKG_NO = TMP.BKG_NO ) NON_RT_STS_CD" ).append("\n"); 
		query.append("                ,(SELECT BB.BLCK_STWG_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = TMP.BKG_NO) AS BLCK_STWG" ).append("\n"); 
		query.append("             FROM TRS_TRSP_SVC_ORD_TMP TMP" ).append("\n"); 
		query.append("            WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("         ORDER BY N1ST_NOD_PLN_DT DESC" ).append("\n"); 

	}
}