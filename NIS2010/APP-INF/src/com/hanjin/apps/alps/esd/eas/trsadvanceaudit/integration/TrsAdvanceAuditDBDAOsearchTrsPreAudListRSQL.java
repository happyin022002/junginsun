/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOsearchTrsPreAudListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOsearchTrsPreAudListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTrsPreAudList 조회쿼리
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOsearchTrsPreAudListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trsp_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_auto_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_csr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOsearchTrsPreAudListRSQL").append("\n"); 
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
		query.append("SELECT '' CHK" ).append("\n"); 
		query.append("      ,'' SEL_AUD_CD" ).append("\n"); 
		query.append("      ,'' IBFLAG" ).append("\n"); 
		query.append("      , AUTO_AUD_STS_CD" ).append("\n"); 
		query.append("      , EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("      , RHQ_OFC_CD" ).append("\n"); 
		query.append("      , INV_OFC_CD" ).append("\n"); 
		query.append("      , TRSP_SO_TP_CD" ).append("\n"); 
		query.append("      , INV_VNDR_SEQ" ).append("\n"); 
		query.append("      , INV_NO" ).append("\n"); 
		query.append("      , HJL_INV_NO" ).append("\n"); 
		query.append("      , HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append("      , NVL2(HJL_INV_VNDR_SEQ, HJL_INV_VNDR_SEQ, INV_VNDR_SEQ) DIS_INV_VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT X.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("           FROM MDM_VENDOR X" ).append("\n"); 
		query.append("          WHERE X.VNDR_SEQ = NVL2(HJL_INV_VNDR_SEQ, HJL_INV_VNDR_SEQ, INV_VNDR_SEQ)" ).append("\n"); 
		query.append("        ) DIS_INV_VNDR_NM" ).append("\n"); 
		query.append("      , INV_ISS_DT" ).append("\n"); 
		query.append("      , INV_AUD_STS_CD" ).append("\n"); 
		query.append("      , CSR_NO" ).append("\n"); 
		query.append("      , CURR_CD" ).append("\n"); 
		query.append("      , WO_AMT" ).append("\n"); 
		query.append("      , INV_AMT" ).append("\n"); 
		query.append("      , CURR_CNG_FLG" ).append("\n"); 
		query.append("      , INV_DIFF_AMT" ).append("\n"); 
		query.append("      , INV_DIFF_AMT_FLG" ).append("\n"); 
		query.append("      , INV_DIFF_PCT" ).append("\n"); 
		query.append("      , NO_AGMT_FLG" ).append("\n"); 
		query.append("      , NO_OPTM_ROUT_FLG" ).append("\n"); 
		query.append("      , EXCEED_AVG_DIFF_AMT" ).append("\n"); 
		query.append("      , EXCEED_AVG_FLG" ).append("\n"); 
		query.append("      , INV_ISS_USR_NM" ).append("\n"); 
		query.append("      , AUD_CFM_USR_NM" ).append("\n"); 
		query.append("      , PAY_TERM_CD" ).append("\n"); 
		query.append("	  , CASE WHEN CSR_NO IS NULL THEN TO_CHAR(TO_DATE(INV_ISS_DT, 'YYYY-MM-DD') + DECODE(PAY_TERM_CD, 'O60', 0, PAY_TERM_CD), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		     ELSE INV_TERM_DT" ).append("\n"); 
		query.append("        END PAY_DUE_DT" ).append("\n"); 
		query.append("      , PAY_DT" ).append("\n"); 
		query.append("      , EAC_IF_FLG" ).append("\n"); 
		query.append("      , AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append("      , EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("      , EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("      , EXPN_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("      , INV_CFM_DT" ).append("\n"); 
		query.append("      , ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      , EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("      , (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = AA.AUTO_AUD_CFM_USR_ID) AUD_CFM_USR_NM" ).append("\n"); 
		query.append("      , (SELECT MAX(BAT_PROG_STS_CD)" ).append("\n"); 
		query.append("           FROM EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("          WHERE SUB_SYS_CD = 'TRS'" ).append("\n"); 
		query.append("            AND X.INV_NO        = AA.INV_NO" ).append("\n"); 
		query.append("            AND X.INV_VNDR_SEQ  = AA.INV_VNDR_SEQ" ).append("\n"); 
		query.append("            AND X.TRSP_SO_TP_CD = AA.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("            AND X.CRE_DT > SYSDATE - 1" ).append("\n"); 
		query.append("        ) BAT_PROG_STS_CD" ).append("\n"); 
		query.append("        , INV_AUD_CURR_CD" ).append("\n"); 
		query.append("        , INV_AUD_DIFF_AMT" ).append("\n"); 
		query.append("        , INV_AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.AUTO_EXPN_AUD_STS_CD AS AUTO_AUD_STS_CD" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("              ,A.RHQ_CD AS RHQ_OFC_CD" ).append("\n"); 
		query.append("              ,A.INV_OFC_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("              ,A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,A.INV_NO" ).append("\n"); 
		query.append("              ,A.HJL_INV_NO" ).append("\n"); 
		query.append("              ,A.HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,TO_CHAR(A.INV_ISS_DT, 'YYYY-MM-DD') INV_ISS_DT" ).append("\n"); 
		query.append("              ,(CASE WHEN B.TRSP_INV_AUD_STS_CD = 'CF' THEN 'C' -- Invoice Confirmed	" ).append("\n"); 
		query.append("                     WHEN (C.IF_FLG IS NULL AND C.RQST_APRO_STEP_FLG = 'Y') OR (B.TRSP_INV_AUD_STS_CD = 'RA') THEN 'L' -- Requesting Approval" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'AR' THEN 'A' -- Approval Requested	" ).append("\n"); 
		query.append("                     WHEN C.IF_ERR_RSN = 'Sending...' THEN 'S' -- Sending	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'DA' THEN 'R' -- Disapproved	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'IE' THEN 'E' -- I/F Error	" ).append("\n"); 
		query.append("                     WHEN C.RCV_ERR_FLG = 'E' THEN 'J'-- A/P Rejected             	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'IF' THEN 'P' -- I/F Success	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'PD' THEN 'D' -- Paid	" ).append("\n"); 
		query.append("                END) INV_AUD_STS_CD	" ).append("\n"); 
		query.append("              ,B.CSR_NO" ).append("\n"); 
		query.append("              ,A.CURR_CD" ).append("\n"); 
		query.append("              ,A.WO_AMT" ).append("\n"); 
		query.append("              ,A.INV_AMT" ).append("\n"); 
		query.append("              ,A.CURR_CNG_FLG" ).append("\n"); 
		query.append("              ,A.INV_DIFF_AMT" ).append("\n"); 
		query.append("              ,A.INV_DIFF_FLG AS INV_DIFF_AMT_FLG" ).append("\n"); 
		query.append("              ,A.INV_DIFF_RTO AS INV_DIFF_PCT" ).append("\n"); 
		query.append("              ,A.AGMT_APLY_FLG AS NO_AGMT_FLG" ).append("\n"); 
		query.append("              ,A.OPTM_ROUT_FLG AS NO_OPTM_ROUT_FLG" ).append("\n"); 
		query.append("              ,A.AVG_OVR_DIFF_AMT AS EXCEED_AVG_DIFF_AMT" ).append("\n"); 
		query.append("              ,A.AVG_OVR_DIFF_FLG AS EXCEED_AVG_FLG" ).append("\n"); 
		query.append("              ,CASE WHEN A.HJL_INV_NO IS NOT NULL THEN 'ETS'" ).append("\n"); 
		query.append("                    ELSE (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.INV_ISS_USR_ID)	" ).append("\n"); 
		query.append("               END INV_ISS_USR_NM" ).append("\n"); 
		query.append("              ,'' AUD_CFM_USR_NM" ).append("\n"); 
		query.append("              ,A.GEN_PAY_TERM_CD AS PAY_TERM_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(TO_DATE(C.INV_TERM_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') INV_TERM_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(B.PAY_DT, 'YYYY-MM-DD') PAY_DT" ).append("\n"); 
		query.append("              ,(SELECT 'Y'" ).append("\n"); 
		query.append("                 FROM EAS_TRSP_AUD_CHK X	" ).append("\n"); 
		query.append("                WHERE X.INV_NO        = A.INV_NO	" ).append("\n"); 
		query.append("                  AND X.INV_VNDR_SEQ  = A.INV_VNDR_SEQ	" ).append("\n"); 
		query.append("                  AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD	" ).append("\n"); 
		query.append("                  AND ROWNUM = 1	" ).append("\n"); 
		query.append("               ) EAC_IF_FLG" ).append("\n"); 
		query.append("              ,DECODE(A.EXPN_AUD_STS_CD, NULL, '', TO_CHAR(A.AUTO_AUD_CFM_DT, 'YYYY-MM-DD')) AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("              ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.EXPN_AUD_RSLT_USR_ID) EXPN_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("              ,TO_CHAR(A.INV_CFM_DT, 'YYYY-MM-DD') INV_CFM_DT" ).append("\n"); 
		query.append("              ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("              ,A.AUTO_AUD_CFM_USR_ID" ).append("\n"); 
		query.append("                , A.AUD_CURR_CD AS INV_AUD_CURR_CD" ).append("\n"); 
		query.append("                , A.AUD_DIFF_AMT AS INV_AUD_DIFF_AMT" ).append("\n"); 
		query.append("                , A.AUD_USD_DIFF_AMT AS INV_AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("          FROM EAS_TRSP_AUD A" ).append("\n"); 
		query.append("              ,TRS_TRSP_INV_WRK B" ).append("\n"); 
		query.append("              ,AP_INV_HDR C" ).append("\n"); 
		query.append("         WHERE A.INV_NO       = B.INV_NO	" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("           AND B.CSR_NO       = C.CSR_NO(+)" ).append("\n"); 
		query.append("           AND A.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[s_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("           AND B.TRSP_INV_AUD_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("           AND C.RCV_ERR_FLG(+) <> 'E'" ).append("\n"); 
		query.append("           -- RHQ로 조회	" ).append("\n"); 
		query.append("           #if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Office로 조회" ).append("\n"); 
		query.append("           #if(${s_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND A.INV_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Service Order Type으로 조회" ).append("\n"); 
		query.append("	 	   #if (${s_trsp_so_tp_cd}!= '')	" ).append("\n"); 
		query.append("           AND A.TRSP_SO_TP_CD = @[s_trsp_so_tp_cd] " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Cost Mode로 조회" ).append("\n"); 
		query.append("           #if(${s_trsp_cost_dtl_mod_cd}!= '')" ).append("\n"); 
		query.append("             AND EXISTS (SELECT 1	" ).append("\n"); 
		query.append("		                   FROM TRS_TRSP_SVC_ORD X	" ).append("\n"); 
		query.append("		                  WHERE X.INV_NO       = A.INV_NO	" ).append("\n"); 
		query.append("		                    AND X.INV_VNDR_SEQ = A.INV_VNDR_SEQ	" ).append("\n"); 
		query.append("		                    AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD	" ).append("\n"); 
		query.append("		                    AND X.TRSP_COST_DTL_MOD_CD = @[s_trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Trans Mode로 조회" ).append("\n"); 
		query.append("           #if (${s_trsp_crr_mod_cd}!= '')" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 1	" ).append("\n"); 
		query.append("                         FROM TRS_TRSP_SVC_ORD X	" ).append("\n"); 
		query.append("                        WHERE X.INV_NO       = A.INV_NO	" ).append("\n"); 
		query.append("                          AND X.INV_VNDR_SEQ = A.INV_VNDR_SEQ	" ).append("\n"); 
		query.append("                          AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD	" ).append("\n"); 
		query.append("                          AND X.TRSP_CRR_MOD_CD = @[s_trsp_crr_mod_cd]" ).append("\n"); 
		query.append("                      )	" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("           -- CSR No로 조회	" ).append("\n"); 
		query.append("           #if (${s_csr_no}!= '')" ).append("\n"); 
		query.append("             AND B.CSR_NO IN (" ).append("\n"); 
		query.append("             #foreach( ${key} IN ${csrNos}) " ).append("\n"); 
		query.append("                #if($velocityCount < $csrNos.size()) " ).append("\n"); 
		query.append("                '${key}'," ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                '${key}'" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- S/P Code로 조회	" ).append("\n"); 
		query.append("           #if (${s_inv_vndr_seq}!= '')" ).append("\n"); 
		query.append("           AND CASE WHEN A.HJL_INV_VNDR_SEQ IS NOT NULL THEN A.HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append("                    ELSE A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("               END = @[s_inv_vndr_seq]	" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Invoice No로 조회 	" ).append("\n"); 
		query.append("           #if (${s_inv_no}!= '')" ).append("\n"); 
		query.append("             AND A.INV_NO IN (" ).append("\n"); 
		query.append("             #foreach( ${key} IN ${invNos}) " ).append("\n"); 
		query.append("                #if($velocityCount < $invNos.size()) " ).append("\n"); 
		query.append("                '${key}'," ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                '${key}'" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	       -- Auto Audit Status로 조회시  " ).append("\n"); 
		query.append("	       #if (${s_auto_aud_sts_cd}!= '')" ).append("\n"); 
		query.append("	         AND A.AUTO_EXPN_AUD_STS_CD = @[s_auto_aud_sts_cd]" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("           -- Audit Status로 조회시	" ).append("\n"); 
		query.append("           #if(${s_expn_aud_sts_cd} == 'N')	" ).append("\n"); 
		query.append("             AND A.EXPN_AUD_STS_CD IS NULL	" ).append("\n"); 
		query.append("           #elseif(${s_expn_aud_sts_cd} == 'D') 	" ).append("\n"); 
		query.append("             AND A.EXPN_AUD_STS_CD IS NOT NULL	" ).append("\n"); 
		query.append("           #elseif(${s_expn_aud_sts_cd} == 'P' || ${s_expn_aud_sts_cd} == 'E' || ${s_expn_aud_sts_cd} == 'A')	" ).append("\n"); 
		query.append("             AND A.EXPN_AUD_STS_CD = @[s_expn_aud_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Diffrence로 조회시" ).append("\n"); 
		query.append("           #if(${s_aud_itm_cd} == 'DA')  	" ).append("\n"); 
		query.append("             AND (A.INV_DIFF_FLG = 'Y' OR A.AGMT_APLY_FLG = 'N' OR A.AVG_OVR_DIFF_FLG = 'Y' OR A.OPTM_ROUT_FLG = 'N')" ).append("\n"); 
		query.append("           #elseif(${s_aud_itm_cd} == 'DF')" ).append("\n"); 
		query.append("             AND A.INV_DIFF_FLG = 'Y'" ).append("\n"); 
		query.append("           #elseif(${s_aud_itm_cd} == 'NT')" ).append("\n"); 
		query.append("             AND A.AGMT_APLY_FLG = 'N'" ).append("\n"); 
		query.append("           #elseif (${s_aud_itm_cd} == 'EX')" ).append("\n"); 
		query.append("             AND A.AVG_OVR_DIFF_FLG = 'Y'" ).append("\n"); 
		query.append("           #elseif (${s_aud_itm_cd} == 'OT')" ).append("\n"); 
		query.append("             AND A.OPTM_ROUT_FLG = 'N'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT A.AUTO_EXPN_AUD_STS_CD AS AUTO_AUD_STS_CD" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("              ,A.RHQ_CD AS RHQ_OFC_CD" ).append("\n"); 
		query.append("              ,A.INV_OFC_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("              ,A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,A.INV_NO" ).append("\n"); 
		query.append("              ,A.HJL_INV_NO" ).append("\n"); 
		query.append("              ,A.HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,TO_CHAR(A.INV_ISS_DT, 'YYYY-MM-DD') INV_ISS_DT" ).append("\n"); 
		query.append("              ,(CASE WHEN B.TRSP_INV_AUD_STS_CD = 'CF' THEN 'C' -- Invoice Confirmed	" ).append("\n"); 
		query.append("                     WHEN (C.IF_FLG IS NULL AND C.RQST_APRO_STEP_FLG = 'Y') OR (B.TRSP_INV_AUD_STS_CD = 'RA') THEN 'L' -- Requesting Approval" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'AR' THEN 'A' -- Approval Requested	" ).append("\n"); 
		query.append("                     WHEN C.IF_ERR_RSN = 'Sending...' THEN 'S' -- Sending	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'DA' THEN 'R' -- Disapproved	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'IE' THEN 'E' -- I/F Error	" ).append("\n"); 
		query.append("                     WHEN C.RCV_ERR_FLG = 'E' THEN 'J'-- A/P Rejected             	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'IF' THEN 'P' -- I/F Success	" ).append("\n"); 
		query.append("                     WHEN B.TRSP_INV_AUD_STS_CD = 'PD' THEN 'D' -- Paid	" ).append("\n"); 
		query.append("                END) INV_AUD_STS_CD	" ).append("\n"); 
		query.append("              ,B.CSR_NO" ).append("\n"); 
		query.append("              ,A.CURR_CD" ).append("\n"); 
		query.append("              ,A.WO_AMT" ).append("\n"); 
		query.append("              ,A.INV_AMT" ).append("\n"); 
		query.append("              ,A.CURR_CNG_FLG" ).append("\n"); 
		query.append("              ,A.INV_DIFF_AMT" ).append("\n"); 
		query.append("              ,A.INV_DIFF_FLG AS INV_DIFF_AMT_FLG" ).append("\n"); 
		query.append("              ,A.INV_DIFF_RTO AS INV_DIFF_PCT" ).append("\n"); 
		query.append("              ,A.AGMT_APLY_FLG AS NO_AGMT_FLG" ).append("\n"); 
		query.append("              ,A.OPTM_ROUT_FLG AS NO_OPTM_ROUT_FLG" ).append("\n"); 
		query.append("              ,A.AVG_OVR_DIFF_AMT AS EXCEED_AVG_DIFF_AMT" ).append("\n"); 
		query.append("              ,A.AVG_OVR_DIFF_FLG AS EXCEED_AVG_FLG" ).append("\n"); 
		query.append("              ,CASE WHEN A.HJL_INV_NO IS NOT NULL THEN 'ETS'" ).append("\n"); 
		query.append("                    ELSE (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.INV_ISS_USR_ID)	" ).append("\n"); 
		query.append("               END INV_ISS_USR_NM" ).append("\n"); 
		query.append("              ,'' AUD_CFM_USR_NM" ).append("\n"); 
		query.append("              ,A.GEN_PAY_TERM_CD AS PAY_TERM_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(TO_DATE(C.INV_TERM_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') INV_TERM_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(B.PAY_DT, 'YYYY-MM-DD') PAY_DT" ).append("\n"); 
		query.append("              ,(SELECT 'Y'" ).append("\n"); 
		query.append("                 FROM EAS_TRSP_AUD_CHK X	" ).append("\n"); 
		query.append("                WHERE X.INV_NO        = A.INV_NO	" ).append("\n"); 
		query.append("                  AND X.INV_VNDR_SEQ  = A.INV_VNDR_SEQ	" ).append("\n"); 
		query.append("                  AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD	" ).append("\n"); 
		query.append("                  AND ROWNUM = 1	" ).append("\n"); 
		query.append("               ) EAC_IF_FLG" ).append("\n"); 
		query.append("              ,DECODE(A.EXPN_AUD_STS_CD, NULL, '', TO_CHAR(A.AUTO_AUD_CFM_DT, 'YYYY-MM-DD')) AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("              ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.EXPN_AUD_RSLT_USR_ID) EXPN_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("              ,TO_CHAR(A.INV_CFM_DT, 'YYYY-MM-DD') INV_CFM_DT" ).append("\n"); 
		query.append("              ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("              ,A.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("              ,A.AUTO_AUD_CFM_USR_ID" ).append("\n"); 
		query.append("                , A.AUD_CURR_CD AS INV_AUD_CURR_CD" ).append("\n"); 
		query.append("                , A.AUD_DIFF_AMT AS INV_AUD_DIFF_AMT" ).append("\n"); 
		query.append("                , A.AUD_USD_DIFF_AMT AS INV_AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("          FROM EAS_TRSP_AUD A" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_INV_WRK B" ).append("\n"); 
		query.append("              ,AP_INV_HDR C" ).append("\n"); 
		query.append("         WHERE A.INV_NO       = B.INV_NO	" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("           AND B.CSR_NO       = C.CSR_NO(+)" ).append("\n"); 
		query.append("           AND A.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[s_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("           AND B.TRSP_INV_AUD_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("           AND C.RCV_ERR_FLG(+) <> 'E'" ).append("\n"); 
		query.append("           -- RHQ로 조회	" ).append("\n"); 
		query.append("           #if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Office로 조회" ).append("\n"); 
		query.append("           #if(${s_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND A.INV_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	 	   -- Service Order Type으로 조회 (ALL 또는 R일 경우만 조회된다.)	" ).append("\n"); 
		query.append("           #if (${s_trsp_so_tp_cd} == 'R' || ${s_trsp_crr_mod_cd} == '' )	" ).append("\n"); 
		query.append("           AND 1=1	" ).append("\n"); 
		query.append("           #else 	" ).append("\n"); 
		query.append("           AND 1=2	" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Cost Mode로 조회" ).append("\n"); 
		query.append("           #if(${s_trsp_cost_dtl_mod_cd}!= '')" ).append("\n"); 
		query.append("             AND EXISTS (SELECT 1	" ).append("\n"); 
		query.append("                           FROM TRS_TRSP_RAIL_INV_WRK X	" ).append("\n"); 
		query.append("                               ,TRS_TRSP_RAIL_INV_DTL Y	" ).append("\n"); 
		query.append("                               ,TRS_TRSP_RAIL_BIL_ORD Z	" ).append("\n"); 
		query.append("                          WHERE X.INV_NO       = Y.INV_NO	" ).append("\n"); 
		query.append("                            AND X.INV_VNDR_SEQ = Y.INV_VNDR_SEQ	" ).append("\n"); 
		query.append("                            AND Y.TRSP_SO_OFC_CTY_CD = Z.TRSP_SO_OFC_CTY_CD	" ).append("\n"); 
		query.append("                            AND Y.TRSP_SO_SEQ        = Z.TRSP_SO_SEQ	" ).append("\n"); 
		query.append("                            AND X.INV_NO       = A.INV_NO	" ).append("\n"); 
		query.append("                            AND X.INV_VNDR_SEQ = A.INV_VNDR_SEQ	" ).append("\n"); 
		query.append("                            AND Z.TRSP_COST_DTL_MOD_CD = @[s_trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           -- Trans Mode로 조회" ).append("\n"); 
		query.append("           #if(${s_trsp_crr_mod_cd} == 'RD' || ${s_trsp_crr_mod_cd} == '' )	" ).append("\n"); 
		query.append("           AND 1=1	" ).append("\n"); 
		query.append("           #else 	" ).append("\n"); 
		query.append("           AND 1=2	" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- CSR No로 조회	" ).append("\n"); 
		query.append("           #if (${s_csr_no}!= '')" ).append("\n"); 
		query.append("             AND B.CSR_NO IN (" ).append("\n"); 
		query.append("             #foreach( ${key} IN ${csrNos}) " ).append("\n"); 
		query.append("                #if($velocityCount < $csrNos.size()) " ).append("\n"); 
		query.append("                '${key}'," ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                '${key}'" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- S/P Code로 조회	" ).append("\n"); 
		query.append("           #if (${s_inv_vndr_seq}!= '')" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ = @[s_inv_vndr_seq]	" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Invoice No로 조회 	" ).append("\n"); 
		query.append("           #if (${s_inv_no}!= '')" ).append("\n"); 
		query.append("             AND A.INV_NO IN (" ).append("\n"); 
		query.append("             #foreach( ${key} IN ${invNos}) " ).append("\n"); 
		query.append("                #if($velocityCount < $invNos.size()) " ).append("\n"); 
		query.append("                '${key}'," ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                '${key}'" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	       -- Auto Audit Status로 조회시  " ).append("\n"); 
		query.append("	       #if (${s_auto_aud_sts_cd}!= '')" ).append("\n"); 
		query.append("	         AND A.AUTO_EXPN_AUD_STS_CD = @[s_auto_aud_sts_cd]" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("           -- Audit Status로 조회시	" ).append("\n"); 
		query.append("           #if(${s_expn_aud_sts_cd} == 'N')	" ).append("\n"); 
		query.append("             AND A.EXPN_AUD_STS_CD IS NULL	" ).append("\n"); 
		query.append("           #elseif(${s_expn_aud_sts_cd} == 'D') 	" ).append("\n"); 
		query.append("             AND A.EXPN_AUD_STS_CD IS NOT NULL	" ).append("\n"); 
		query.append("           #elseif(${s_expn_aud_sts_cd} == 'P' || ${s_expn_aud_sts_cd} == 'E' || ${s_expn_aud_sts_cd} == 'A')	" ).append("\n"); 
		query.append("             AND A.EXPN_AUD_STS_CD = @[s_expn_aud_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- Diffrence로 조회시" ).append("\n"); 
		query.append("           #if(${s_aud_itm_cd} == 'DA')" ).append("\n"); 
		query.append("             AND (A.INV_DIFF_FLG = 'Y' OR A.AGMT_APLY_FLG = 'N' OR A.AVG_OVR_DIFF_FLG = 'Y' OR A.OPTM_ROUT_FLG = 'N')" ).append("\n"); 
		query.append("           #elseif(${s_aud_itm_cd} == 'DF')" ).append("\n"); 
		query.append("             AND A.INV_DIFF_FLG = 'Y'" ).append("\n"); 
		query.append("           #elseif(${s_aud_itm_cd} == 'NT')" ).append("\n"); 
		query.append("             AND A.AGMT_APLY_FLG = 'N'" ).append("\n"); 
		query.append("           #elseif (${s_aud_itm_cd} == 'EX')" ).append("\n"); 
		query.append("             AND A.AVG_OVR_DIFF_FLG = 'Y'" ).append("\n"); 
		query.append("           #elseif (${s_aud_itm_cd} == 'OT')" ).append("\n"); 
		query.append("             AND A.OPTM_ROUT_FLG = 'N'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("-- CSR Status로 조회" ).append("\n"); 
		query.append("#if (${s_csr_sts_cd}!= '')" ).append("\n"); 
		query.append("  AND AA.INV_AUD_STS_CD = @[s_csr_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Audit Status로 조회시" ).append("\n"); 
		query.append("#if(${s_expn_aud_sts_cd} == 'I')	" ).append("\n"); 
		query.append("  AND AA.EAC_IF_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}