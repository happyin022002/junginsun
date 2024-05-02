/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesInvoiceAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesInvoiceAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesInvoiceAudit
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesInvoiceAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_diff_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_auto_expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_csr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_from_inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesInvoiceAuditRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("		  '' AS CHK" ).append("\n"); 
		query.append("		, '' AS SEL_AUD_CD" ).append("\n"); 
		query.append("		, '' AS S_SAVE_TP_CD	-- CONFIRM REMARK 저장 구분" ).append("\n"); 
		query.append("		, RHQ_CD" ).append("\n"); 
		query.append("		, INV_OFC_CD" ).append("\n"); 
		query.append("		, COST_OFC_CD" ).append("\n"); 
		query.append("		, YD_CD" ).append("\n"); 
		query.append("		, VNDR_SEQ" ).append("\n"); 
		query.append("		, TML_INV_TP_CD" ).append("\n"); 
		query.append("		, INV_NO" ).append("\n"); 
		query.append("		, TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append("		, ISS_DT" ).append("\n"); 
		query.append("		, INV_CFM_DT" ).append("\n"); 
		query.append("		, INV_CFM_DT_YMD" ).append("\n"); 
		query.append("		, CSR_NO" ).append("\n"); 
		query.append("		, PAY_TERM" ).append("\n"); 
		query.append("		, PAY_DUE_DT" ).append("\n"); 
		query.append("		, PAY_DT" ).append("\n"); 
		query.append("		, CSR_STS_CD" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, VVD" ).append("\n"); 
		query.append("		, IO_BND_CD" ).append("\n"); 
		query.append("		, ATB_DT" ).append("\n"); 
		query.append("		, INV_PRD_DT" ).append("\n"); 
		query.append("		, FM_PRD_DT" ).append("\n"); 
		query.append("		, TO_PRD_DT" ).append("\n"); 
		query.append("		, CURR_CD" ).append("\n"); 
		query.append("		, INV_AMT" ).append("\n"); 
		query.append("		, EXPN_AUD_ESTM_AMT" ).append("\n"); 
		query.append("		, DIFF_RTO" ).append("\n"); 
		query.append("		, AMT_AUD_TGT_FLG" ).append("\n"); 
		query.append("		, AUD_LGS_COST_CD_QTY" ).append("\n"); 
		query.append("		, VRFY_RSLT_CD_CTNT" ).append("\n"); 
		query.append("		, VOL_AUD_TGT_QTY" ).append("\n"); 
		query.append("		, BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("		, BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("		, EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("		, EXPN_AUD_SEQ" ).append("\n"); 
		query.append("		, EAC_FLG" ).append("\n"); 
		query.append("		, '' AS UPD_USR_ID" ).append("\n"); 
		query.append("		, BAT_RSLT" ).append("\n"); 
		query.append("		, CALC_TP_CD_CTNT" ).append("\n"); 
		query.append("		, AUD_CASE_DTL_QTY" ).append("\n"); 
		query.append("		, EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("		, EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("		, (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = EXPN_AUD_RSLT_USR_ID) AS EXPN_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("		, CRE_USR_ID" ).append("\n"); 
		query.append("		, INV_CRE_USR_NM" ).append("\n"); 
		query.append("		, UPD_DT" ).append("\n"); 
		query.append("		, DECODE(EXPN_AUD_STS_CD, NULL, '', AUD_UPD_DT) AS AUD_UPD_DT" ).append("\n"); 
		query.append("		, UPD_USR_ID" ).append("\n"); 
		query.append("		, AUD_UPD_USR_ID" ).append("\n"); 
		query.append("		, DECODE(EXPN_AUD_STS_CD, NULL, '', AUD_UPD_USR_NM) AS AUD_UPD_USR_NM" ).append("\n"); 
		query.append("		, ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("		, EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("		, BAT_PROG_STS_CD" ).append("\n"); 
		query.append("		, INV_AUD_CURR_CD" ).append("\n"); 
		query.append("		, INV_AUD_DIFF_AMT" ).append("\n"); 
		query.append("		, INV_AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	  SELECT   A.RHQ_CD" ).append("\n"); 
		query.append("			, A.INV_OFC_CD" ).append("\n"); 
		query.append("			, A.COST_OFC_CD" ).append("\n"); 
		query.append("			, A.YD_CD" ).append("\n"); 
		query.append("			, A.VNDR_SEQ" ).append("\n"); 
		query.append("			, A.TML_INV_TP_CD" ).append("\n"); 
		query.append("			, A.INV_NO" ).append("\n"); 
		query.append("			, H.TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append("			, TO_CHAR(A.ISS_DT, 'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("			, TO_CHAR(A.INV_CFM_DT, 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("			, TO_CHAR(A.INV_CFM_DT, 'YYYY-MM-DD') AS INV_CFM_DT_YMD" ).append("\n"); 
		query.append("			, H.CSR_NO" ).append("\n"); 
		query.append("			, CASE WHEN AH.VNDR_TERM_NM IS NULL" ).append("\n"); 
		query.append("				THEN (SELECT CASE WHEN X.GEN_PAY_TERM_CD = 'O60'" ).append("\n"); 
		query.append("				   THEN '0'" ).append("\n"); 
		query.append("				   ELSE X.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("				 END" ).append("\n"); 
		query.append("				  FROM MDM_VENDOR X" ).append("\n"); 
		query.append("				 WHERE X.VNDR_SEQ = H.VNDR_SEQ" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				ELSE AH.VNDR_TERM_NM " ).append("\n"); 
		query.append("			  END AS PAY_TERM" ).append("\n"); 
		query.append("			, CASE WHEN AH.VNDR_TERM_NM IS NOT NULL AND SUBSTR(AH.VNDR_TERM_NM, 0, 1) = 'O'" ).append("\n"); 
		query.append("				THEN TO_CHAR(TO_DATE(AH.INV_TERM_DT, 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("				ELSE TO_CHAR(TO_DATE(AH.INV_TERM_DT, 'YYYY-MM-DD') + TO_NUMBER(DECODE(AH.VNDR_TERM_NM, 'O60', '0', AH.VNDR_TERM_NM)), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("			  END PAY_DUE_DT" ).append("\n"); 
		query.append("			, TO_CHAR(H.PAY_DT, 'YYYY-MM-DD') AS PAY_DT" ).append("\n"); 
		query.append("			, CASE WHEN H.TML_INV_STS_CD = 'C' THEN 'C' -- Invoice Confirmed" ).append("\n"); 
		query.append("				WHEN H.TML_INV_STS_CD = 'D' THEN 'D' -- Paid" ).append("\n"); 
		query.append("				WHEN H.TML_INV_RJCT_STS_CD IN ('RJ') AND AH.AFT_ACT_FLG IS NULL THEN 'R' -- Disapproved" ).append("\n"); 
		query.append("				WHEN AH.IF_FLG IS NULL AND AH.APRO_FLG = 'N' AND AH.RQST_APRO_STEP_FLG = 'Y' THEN 'L' -- Requesting Approval" ).append("\n"); 
		query.append("				WHEN AH.IF_FLG IS NULL " ).append("\n"); 
		query.append("					THEN CASE WHEN AH.APRO_FLG = 'Y' THEN 'S' -- Sending" ).append("\n"); 
		query.append("							  ELSE 'A' -- Approval Requested" ).append("\n"); 
		query.append("						 END" ).append("\n"); 
		query.append("				WHEN AH.IF_FLG = 'E' THEN 'E' -- I/F Error" ).append("\n"); 
		query.append("				WHEN AH.RCV_ERR_FLG = 'E' THEN 'J' -- A/P Rejected" ).append("\n"); 
		query.append("				WHEN AH.IF_FLG = 'Y' AND AH.RCV_ERR_FLG IS NULL THEN 'P' -- I/F Success" ).append("\n"); 
		query.append("				ELSE 'ALL'" ).append("\n"); 
		query.append("			  END AS CSR_STS_CD" ).append("\n"); 
		query.append("			, A.VSL_CD" ).append("\n"); 
		query.append("			, A.SKD_VOY_NO" ).append("\n"); 
		query.append("			, A.SKD_DIR_CD" ).append("\n"); 
		query.append("			, A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("			, A.IO_BND_CD" ).append("\n"); 
		query.append("			, TO_CHAR(A.ATB_DT, 'YYYY-MM-DD') AS ATB_DT" ).append("\n"); 
		query.append("			, DECODE(A.FM_PRD_DT, NULL, '', SUBSTR(A.FM_PRD_DT, 0, 4) ||'-'|| SUBSTR(A.FM_PRD_DT, 5, 2) || '-' || SUBSTR(A.FM_PRD_DT, 7, 2) || '~' || SUBSTR(A.TO_PRD_DT, 0, 4) ||'-'|| SUBSTR(A.TO_PRD_DT, 5, 2) || '-' || SUBSTR(A.TO_PRD_DT, 7, 2)) AS INV_PRD_DT" ).append("\n"); 
		query.append("			, A.FM_PRD_DT" ).append("\n"); 
		query.append("			, A.TO_PRD_DT" ).append("\n"); 
		query.append("			, A.CURR_CD" ).append("\n"); 
		query.append("			, A.INV_AMT" ).append("\n"); 
		query.append("			, NVL(A.EXPN_AUD_ESTM_AMT, 0) AS EXPN_AUD_ESTM_AMT" ).append("\n"); 
		query.append("			, DECODE(A.EXPN_AUD_ESTM_AMT, 0, NULL, ROUND(((A.INV_AMT - A.EXPN_AUD_ESTM_AMT) / DECODE(A.EXPN_AUD_ESTM_AMT, 0, 1, A.EXPN_AUD_ESTM_AMT)) * 100, 1)) AS DIFF_RTO" ).append("\n"); 
		query.append("			, A.AMT_AUD_TGT_FLG" ).append("\n"); 
		query.append("			, NVL(A.AUD_LGS_COST_CD_QTY, 0) AS AUD_LGS_COST_CD_QTY" ).append("\n"); 
		query.append("			, A.VRFY_RSLT_CD_CTNT" ).append("\n"); 
		query.append("			, NVL(A.VOL_AUD_TGT_QTY, 0) AS VOL_AUD_TGT_QTY" ).append("\n"); 
		query.append("			, A.BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("			, A.BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("			, A.BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("			, A.AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("			, A.EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("			, A.EXPN_AUD_SEQ" ).append("\n"); 
		query.append("			, ( SELECT DECODE(MAX(EAC_NO), NULL, 'N', 'I')" ).append("\n"); 
		query.append("				  FROM EAS_TML_AUD_DTL" ).append("\n"); 
		query.append("				 WHERE INV_NO   	= A.INV_NO" ).append("\n"); 
		query.append("				   AND VNDR_SEQ  	= A.VNDR_SEQ" ).append("\n"); 
		query.append("				   AND INV_CFM_DT  	= A.INV_CFM_DT" ).append("\n"); 
		query.append("				   AND EXPN_AUD_SEQ = A.EXPN_AUD_SEQ" ).append("\n"); 
		query.append("			   ) AS EAC_FLG" ).append("\n"); 
		query.append("			, (CASE WHEN A.BAT_VOL_RSLT_CD = 'S' AND A.BAT_AMT_RSLT_CD = 'S' AND A.BAT_ESTM_VOL_RSLT_CD = 'S' THEN 'Success'" ).append("\n"); 
		query.append("					WHEN NVL(A.AUD_DTL_TGT_QTY, 0) - NVL(A.BAT_VOL_RSLT_CD_QTY, 0) > 0 " ).append("\n"); 
		query.append("						 AND NVL(A.AUD_DTL_TGT_QTY, 0) - NVL(A.BAT_AMT_RSLT_CD_QTY, 0) > 0 " ).append("\n"); 
		query.append("						 AND NVL(A.AUD_DTL_TGT_QTY, 0) - NVL(A.BAT_ESTM_VOL_RSLT_CD_QTY, 0) > 0 THEN 'P.Fail'" ).append("\n"); 
		query.append("					ELSE 'Fail'" ).append("\n"); 
		query.append("			  END) BAT_RSLT" ).append("\n"); 
		query.append("			, NVL(A.AUD_LGS_COST_CD_QTY, 0) || '/' || A.AUD_DTL_TGT_QTY AS AUD_CASE_DTL_QTY" ).append("\n"); 
		query.append("			, A.CALC_TP_CD_CTNT" ).append("\n"); 
		query.append("			, A.EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("			, A.EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("			, H.CRE_USR_ID" ).append("\n"); 
		query.append("			, (SELECT USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID) AS INV_CRE_USR_NM" ).append("\n"); 
		query.append("			, A.UPD_DT" ).append("\n"); 
		query.append("			, DECODE(A.EXPN_AUD_STS_CD, NULL, '', TO_CHAR(A.UPD_DT, 'YYYYMMDD')) AS AUD_UPD_DT" ).append("\n"); 
		query.append("			, A.UPD_USR_ID" ).append("\n"); 
		query.append("			, DECODE(A.EXPN_AUD_STS_CD, NULL, '', A.UPD_USR_ID) AS AUD_UPD_USR_ID" ).append("\n"); 
		query.append("			, DECODE(A.EXPN_AUD_STS_CD, NULL, '', (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID)) AS AUD_UPD_USR_NM" ).append("\n"); 
		query.append("			, ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("			, EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("			, (SELECT MAX(BAT_PROG_STS_CD) " ).append("\n"); 
		query.append("				FROM EAS_AUTO_AUD_BAT B " ).append("\n"); 
		query.append("				WHERE B.SUB_SYS_CD = 'TES' " ).append("\n"); 
		query.append("				AND B.INV_NO = A.INV_NO " ).append("\n"); 
		query.append("				AND B.INV_VNDR_SEQ = A.VNDR_SEQ " ).append("\n"); 
		query.append("				AND INV_CFM_DT = A.INV_CFM_DT" ).append("\n"); 
		query.append("				AND	NVL(B.VSL_CD, 'X') = NVL(A.VSL_CD, 'X') " ).append("\n"); 
		query.append("				AND NVL(B.SKD_VOY_NO, 'X') = NVL(A.SKD_VOY_NO, 'X') " ).append("\n"); 
		query.append("				AND NVL(B.SKD_DIR_CD, 'X') = NVL(A.SKD_DIR_CD, 'X') " ).append("\n"); 
		query.append("				AND NVL(B.IO_BND_CD, 'X') = NVL(A.IO_BND_CD, 'X')" ).append("\n"); 
		query.append("				AND B.CRE_DT > SYSDATE - 1" ).append("\n"); 
		query.append("				) AS BAT_PROG_STS_CD" ).append("\n"); 
		query.append("			, A.AUD_CURR_CD AS INV_AUD_CURR_CD" ).append("\n"); 
		query.append("			, A.AUD_DIFF_AMT AS INV_AUD_DIFF_AMT" ).append("\n"); 
		query.append("			, A.AUD_USD_DIFF_AMT AS INV_AUD_USD_DIFF_AMT" ).append("\n"); 
		query.append("	  FROM EAS_TML_AUD A" ).append("\n"); 
		query.append("			, TES_TML_SO_HDR H" ).append("\n"); 
		query.append("			, AP_INV_HDR AH" ).append("\n"); 
		query.append("	  WHERE 1 = 1" ).append("\n"); 
		query.append("	  AND  A.YD_CD               = H.YD_CD" ).append("\n"); 
		query.append("	  AND  A.VNDR_SEQ            = H.VNDR_SEQ" ).append("\n"); 
		query.append("	  AND  A.INV_NO              = H.INV_NO" ).append("\n"); 
		query.append("	  AND  A.INV_CFM_DT          = H.INV_CFM_DT" ).append("\n"); 
		query.append("	  AND  NVL(H.DELT_FLG, 'N')	 = 'N'" ).append("\n"); 
		query.append("	  AND  H.TML_INV_STS_CD      <> 'R'" ).append("\n"); 
		query.append("	  AND  H.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("	  AND  AH.RCV_ERR_FLG(+) 	 <> 'E'" ).append("\n"); 
		query.append("	  AND  H.CSR_NO  			 = AH.CSR_NO(+)" ).append("\n"); 
		query.append("	  -- Detail중 한건이라도 Estimation 물량집계 데이타가 있는 데이타를 기본으로 보여주고 Estimation 물량이 없을 경우 Confirm후 14일 이후 심사대상으로 조회한다." ).append("\n"); 
		query.append("	  -- Estimation 물량이 없을 경우 Confirm후 5일 이후 심사대상으로 조회한다. 2017.08.11" ).append("\n"); 
		query.append("	  -- Confirm후 5일이후 조건 잠시 삭제 2018.05.03" ).append("\n"); 
		query.append("	  AND	( ((NVL(A.AUD_DTL_TGT_QTY, 0) - NVL(A.BAT_ESTM_VOL_RSLT_CD_QTY, 0)) > 0) " ).append("\n"); 
		query.append("	  OR	( ((NVL(A.AUD_DTL_TGT_QTY, 0) - NVL(A.BAT_ESTM_VOL_RSLT_CD_QTY, 0)) = 0) " ).append("\n"); 
		query.append("	  --AND	A.INV_CFM_DT < SYSDATE - 5" ).append("\n"); 
		query.append("      ))" ).append("\n"); 
		query.append("#if (${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND  A.RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_inv_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND  A.INV_OFC_CD = @[s_inv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND  A.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[s_from_inv_cfm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_inv_cfm_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_tml_inv_tp_cd} != '')" ).append("\n"); 
		query.append("	AND  A.TML_INV_TP_CD = @[s_tml_inv_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_loc_cd} != '')" ).append("\n"); 
		query.append("	AND  A.YD_CD LIKE @[s_loc_cd]||@[s_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_vsl_cd} != '')" ).append("\n"); 
		query.append("	AND  A.VSL_CD = @[s_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("	AND  A.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- VO 생성시 IN절 조건 삭제후 실행" ).append("\n"); 
		query.append("#if (${s_inv_no}!= '')" ).append("\n"); 
		query.append("	AND A.INV_NO IN (" ).append("\n"); 
		query.append(" #foreach( ${key} IN ${invNos}) " ).append("\n"); 
		query.append("    #if($velocityCount < $invNos.size()) " ).append("\n"); 
		query.append("    '${key}'," ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("    '${key}'" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_csr_no}!= '')" ).append("\n"); 
		query.append("	AND H.CSR_NO IN (" ).append("\n"); 
		query.append(" #foreach( ${key} IN ${csrNos}) " ).append("\n"); 
		query.append("    #if($velocityCount < $csrNos.size()) " ).append("\n"); 
		query.append("    '${key}'," ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("    '${key}'" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	) X" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("-- CSR STATUS" ).append("\n"); 
		query.append("#if (${s_csr_sts_cd} != '')" ).append("\n"); 
		query.append("AND  CSR_STS_CD = @[s_csr_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- DIFF" ).append("\n"); 
		query.append("#if (${s_diff_sgn} == '1')" ).append("\n"); 
		query.append("AND  DIFF_RTO < @[s_diff_rto]" ).append("\n"); 
		query.append("#elseif (${s_diff_sgn} == '2')" ).append("\n"); 
		query.append("AND  DIFF_RTO > @[s_diff_rto]" ).append("\n"); 
		query.append("#elseif (${s_diff_sgn} == '3')" ).append("\n"); 
		query.append("AND  DIFF_RTO = @[s_diff_rto]" ).append("\n"); 
		query.append("#elseif (${s_diff_sgn} == '4')" ).append("\n"); 
		query.append("AND  DIFF_RTO <= @[s_diff_rto]" ).append("\n"); 
		query.append("#elseif (${s_diff_sgn} == '5')" ).append("\n"); 
		query.append("AND  DIFF_RTO >= @[s_diff_rto]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- AUDIT STATUS - AUTO" ).append("\n"); 
		query.append("#if (${s_auto_expn_aud_sts_cd} != '')" ).append("\n"); 
		query.append("AND  AUTO_EXPN_AUD_STS_CD = @[s_auto_expn_aud_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_expn_aud_sts_cd} == 'N')" ).append("\n"); 
		query.append("AND		EXPN_AUD_STS_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${s_expn_aud_sts_cd} == 'D')" ).append("\n"); 
		query.append("AND		EXPN_AUD_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("#elseif(${s_expn_aud_sts_cd} == 'P' || ${s_expn_aud_sts_cd} == 'E' || ${s_expn_aud_sts_cd} == 'A')	" ).append("\n"); 
		query.append("AND		EXPN_AUD_STS_CD	= @[s_expn_aud_sts_cd]" ).append("\n"); 
		query.append("#elseif (${s_expn_aud_sts_cd} == 'I')" ).append("\n"); 
		query.append("AND		EAC_FLG = @[s_expn_aud_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}