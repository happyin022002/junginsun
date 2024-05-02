/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOSearchSpecialSoOfTransportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.03 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOSearchSpecialSoOfTransportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special S/O of Transport 조회
	  * </pre>
	  */
	public TrsAudDBDAOSearchSpecialSoOfTransportRSQL(){
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
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOSearchSpecialSoOfTransportRSQL").append("\n"); 
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
		query.append("SELECT S.EQ_NO" ).append("\n"); 
		query.append("      ,S.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,S.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	  ,( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00279' AND INTG_CD_VAL_CTNT = S.TRSP_SO_TP_CD ) TRSP_SO_TP_CD" ).append("\n"); 
		query.append("      ,S.TRSP_SO_OFC_CTY_CD||S.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("      ,TO_CHAR (S.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') SO_LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = S.UPD_USR_ID) AS SO_USR_NM     " ).append("\n"); 
		query.append("      ,S.TRSP_WO_OFC_CTY_CD||S.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,TO_CHAR (W.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') WO_LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,W.CRE_OFC_CD WO_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = W.CRE_USR_ID) AS WO_USR_NM      " ).append("\n"); 
		query.append("      ,S.FM_NOD_CD" ).append("\n"); 
		query.append("      ,S.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,S.TO_NOD_CD" ).append("\n"); 
		query.append("      ,S.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,WVDR.VNDR_SEQ" ).append("\n"); 
		query.append("      ,WVDR.VNDR_ABBR_NM AS VNDR_NM" ).append("\n"); 
		query.append("      ,PVNDR.VNDR_SEQ AS PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("      ,PVNDR.VNDR_ABBR_NM AS PRNT_VNDR_NM" ).append("\n"); 
		query.append("      ,S.N3PTY_BIL_FLG" ).append("\n"); 
		query.append("      ,S.CURR_CD" ).append("\n"); 
		query.append("      ,S.BZC_AMT" ).append("\n"); 
		query.append("      ,S.NEGO_AMT" ).append("\n"); 
		query.append("      ,S.FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,S.SCG_VAT_AMT" ).append("\n"); 
		query.append("      ,S.ETC_ADD_AMT" ).append("\n"); 
		query.append("      ,S.BZC_AMT + NVL (S.FUEL_SCG_AMT, 0)+ NVL (S.SCG_VAT_AMT, 0) + NVL (S.NEGO_AMT, 0) + NVL (S.ETC_ADD_AMT, 0)+NVL (S.HJL_HNDL_AMT, 0) AS WO_TOT_AMT" ).append("\n"); 
		query.append("      ,ROUND ((NVL (S.BZC_AMT, 0) + NVL (S.FUEL_SCG_AMT, 0) + NVL (S.NEGO_AMT, 0) + NVL (S.ETC_ADD_AMT, 0) + NVL (S.HJL_HNDL_AMT, 0) + NVL (S.SCG_VAT_AMT, 0)) / " ).append("\n"); 
		query.append("             CASE WHEN NVL(S.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                  ELSE " ).append("\n"); 
		query.append("                  (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                     FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                    WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                      AND XCH.CURR_CD           = S.CURR_CD" ).append("\n"); 
		query.append("                      AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(W.LOCL_CRE_DT,'YYYYMM'),TO_CHAR (S.LOCL_CRE_DT, 'YYYYMM')))" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("             , 2) WO_USD_TOT_AMT" ).append("\n"); 
		query.append("      ,S.INV_NO" ).append("\n"); 
		query.append("      ,IVDR.VNDR_SEQ AS INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(DECODE(S.TRSP_SO_TP_CD, 'S', S.SPL_ISS_RSN, S.TRSP_PURP_RSN), CHR(13)||CHR(10), ' '), chr(34), '') TRSP_PURP_RSN  " ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(S.INTER_RMK, CHR(13)||CHR(10), ' '), chr(34), '')  INTER_RMK" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(S.SPCL_INSTR_RMK, CHR(13)||CHR(10), ' '), chr(34), '')  SPCL_INSTR_RMK" ).append("\n"); 
		query.append("      ,S.BKG_NO" ).append("\n"); 
		query.append("	  ,S.POR_CD" ).append("\n"); 
		query.append("      ,S.POL_CD" ).append("\n"); 
		query.append("      ,S.POD_CD" ).append("\n"); 
		query.append("      ,S.DEL_CD" ).append("\n"); 
		query.append("      ,(SELECT 'Y'" ).append("\n"); 
		query.append("          FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("         WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND X.TRSP_SO_SEQ        = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND X.EAC_SYS_IF_CD      = 'TR1'" ).append("\n"); 
		query.append("           AND X.LGS_COST_CD        = 'XXXXXX'" ).append("\n"); 
		query.append("        ) EAC_IF_FLG" ).append("\n"); 
		query.append("      ,CASE WHEN S.TRSP_SO_TP_CD = 'Y' THEN 1" ).append("\n"); 
		query.append("            WHEN S.TRSP_SO_TP_CD = 'S' THEN 2" ).append("\n"); 
		query.append("            WHEN S.TRSP_SO_TP_CD = 'O' THEN 3" ).append("\n"); 
		query.append("       END ORD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD W" ).append("\n"); 
		query.append("      ,MDM_VENDOR WVDR" ).append("\n"); 
		query.append("      ,MDM_VENDOR PVNDR" ).append("\n"); 
		query.append("      ,MDM_VENDOR IVDR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND S.TRSP_WO_OFC_CTY_CD = W.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND S.TRSP_WO_SEQ        = W.TRSP_WO_SEQ   " ).append("\n"); 
		query.append("   AND WVDR.VNDR_SEQ = CASE WHEN S.HJL_NO IS NOT NULL THEN (SELECT X.HJL_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = S.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                            ELSE S.VNDR_SEQ" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("   AND PVNDR.VNDR_SEQ = WVDR.PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("   AND IVDR.VNDR_SEQ = CASE WHEN S.HJL_NO IS NOT NULL THEN (SELECT X.HJL_INV_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = S.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                            ELSE S.VNDR_SEQ" ).append("\n"); 
		query.append("                       END   " ).append("\n"); 
		query.append("   AND S.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND W.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND S.TRSP_SO_TP_CD IN ('S', 'O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND S.CRE_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                       START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("   #if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND S.CRE_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND S.LOCL_CRE_DT BETWEEN TO_DATE (REPLACE(@[s_fm_dt],'-',''), 'rrrrmmdd') AND TO_DATE (REPLACE(@[s_to_dt],'-',''), 'rrrrmmdd') + 0.999999" ).append("\n"); 
		query.append("   #if (${s_bnd_cd} != '')" ).append("\n"); 
		query.append("        AND S.TRSP_BND_CD = @[s_bnd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${s_trsp_crr_mod_cd} != '')" ).append("\n"); 
		query.append("        AND S.TRSP_CRR_MOD_CD = @[s_trsp_crr_mod_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${s_eac_if} != '')" ).append("\n"); 
		query.append("      #if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("         AND EXISTS (SELECT '1'" ).append("\n"); 
		query.append("                       FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("                      WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                        AND X.TRSP_SO_SEQ        = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                        AND X.EAC_SYS_IF_CD      = 'TR1'" ).append("\n"); 
		query.append("                        AND X.LGS_COST_CD        = 'XXXXXX'" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("         AND NOT EXISTS (SELECT '1'" ).append("\n"); 
		query.append("                           FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("                          WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND X.TRSP_SO_SEQ        = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                            AND X.EAC_SYS_IF_CD      = 'TR1'" ).append("\n"); 
		query.append("                            AND X.LGS_COST_CD        = 'XXXXXX'" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT S.EQ_NO" ).append("\n"); 
		query.append("      ,S.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,S.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00279' AND INTG_CD_VAL_CTNT = S.TRSP_SO_TP_CD ) TRSP_SO_TP_CD" ).append("\n"); 
		query.append("      ,S.TRSP_SO_OFC_CTY_CD||S.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("      ,TO_CHAR (S.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') SO_LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = S.UPD_USR_ID) AS SO_USR_NM     " ).append("\n"); 
		query.append("      ,S.TRSP_WO_OFC_CTY_CD||S.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,TO_CHAR (W.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') WO_LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,W.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = W.CRE_USR_ID) AS WO_USR_NM      " ).append("\n"); 
		query.append("      ,S.FM_NOD_CD" ).append("\n"); 
		query.append("      ,S.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,S.TO_NOD_CD" ).append("\n"); 
		query.append("      ,S.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,WVDR.VNDR_SEQ" ).append("\n"); 
		query.append("      ,WVDR.VNDR_ABBR_NM AS VNDR_NM" ).append("\n"); 
		query.append("      ,PVNDR.VNDR_SEQ AS PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("      ,PVNDR.VNDR_ABBR_NM AS PRNT_VNDR_NM" ).append("\n"); 
		query.append("      ,S.N3PTY_BIL_FLG" ).append("\n"); 
		query.append("      ,S.CURR_CD" ).append("\n"); 
		query.append("      ,S.BZC_AMT" ).append("\n"); 
		query.append("      ,S.NEGO_AMT" ).append("\n"); 
		query.append("      ,S.FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,S.SCG_VAT_AMT" ).append("\n"); 
		query.append("      ,S.ETC_ADD_AMT" ).append("\n"); 
		query.append("      ,S.BZC_AMT + NVL (S.FUEL_SCG_AMT, 0)+ NVL (S.SCG_VAT_AMT, 0) + NVL (S.NEGO_AMT, 0) + NVL (S.ETC_ADD_AMT, 0)+NVL (S.HJL_HNDL_AMT, 0) AS WO_TOT_AMT" ).append("\n"); 
		query.append("      ,ROUND ((NVL (S.BZC_AMT, 0) + NVL (S.FUEL_SCG_AMT, 0) + NVL (S.NEGO_AMT, 0) + NVL (S.ETC_ADD_AMT, 0) + NVL (S.HJL_HNDL_AMT, 0) + NVL (S.SCG_VAT_AMT, 0)) / " ).append("\n"); 
		query.append("             CASE WHEN NVL(S.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                  ELSE " ).append("\n"); 
		query.append("                  (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                     FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                    WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                      AND XCH.CURR_CD           = S.CURR_CD" ).append("\n"); 
		query.append("                      AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(W.LOCL_CRE_DT,'YYYYMM'),TO_CHAR (S.LOCL_CRE_DT, 'YYYYMM')))" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("             , 2) WO_USD_TOT_AMT" ).append("\n"); 
		query.append("      ,S.INV_NO" ).append("\n"); 
		query.append("      ,IVDR.VNDR_SEQ AS INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(DECODE(S.TRSP_SO_TP_CD, 'S', S.SPL_ISS_RSN, S.TRSP_PURP_RSN), CHR(13)||CHR(10), ' '), chr(34), '') TRSP_PURP_RSN  " ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(S.INTER_RMK, CHR(13)||CHR(10), ' '), chr(34), '')  INTER_RMK" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(S.SPCL_INSTR_RMK, CHR(13)||CHR(10), ' '), chr(34), '')  SPCL_INSTR_RMK" ).append("\n"); 
		query.append("      ,S.BKG_NO" ).append("\n"); 
		query.append("      ,S.POR_CD" ).append("\n"); 
		query.append("      ,S.POL_CD" ).append("\n"); 
		query.append("      ,S.POD_CD" ).append("\n"); 
		query.append("      ,S.DEL_CD" ).append("\n"); 
		query.append("      ,(SELECT 'Y'" ).append("\n"); 
		query.append("          FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("         WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND X.TRSP_SO_SEQ        = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND X.EAC_SYS_IF_CD      = 'TR1'" ).append("\n"); 
		query.append("           AND X.LGS_COST_CD        = 'XXXXXX'" ).append("\n"); 
		query.append("        ) EAC_IF_FLG" ).append("\n"); 
		query.append("      ,CASE WHEN S.TRSP_SO_TP_CD = 'Y' THEN 1" ).append("\n"); 
		query.append("            WHEN S.TRSP_SO_TP_CD = 'S' THEN 2" ).append("\n"); 
		query.append("            WHEN S.TRSP_SO_TP_CD = 'O' THEN 3" ).append("\n"); 
		query.append("       END ORD      " ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD W" ).append("\n"); 
		query.append("      ,MDM_VENDOR WVDR" ).append("\n"); 
		query.append("      ,MDM_VENDOR PVNDR" ).append("\n"); 
		query.append("      ,MDM_VENDOR IVDR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND S.TRSP_WO_OFC_CTY_CD = W.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND S.TRSP_WO_SEQ        = W.TRSP_WO_SEQ   " ).append("\n"); 
		query.append("   AND WVDR.VNDR_SEQ = CASE WHEN S.HJL_NO IS NOT NULL THEN (SELECT X.HJL_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = S.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                            ELSE S.VNDR_SEQ" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("   AND PVNDR.VNDR_SEQ = WVDR.PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("   AND IVDR.VNDR_SEQ = CASE WHEN S.HJL_NO IS NOT NULL THEN (SELECT X.HJL_INV_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = S.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                            ELSE S.VNDR_SEQ" ).append("\n"); 
		query.append("                       END   " ).append("\n"); 
		query.append("   AND S.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND W.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND (S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ) IN (SELECT X.PRNT_TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                                       ,X.PRNT_TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                                   FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                                                  WHERE X.TRSP_SO_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                    AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                    AND X.CRE_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                          WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                        CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                                                          START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                                                                         )" ).append("\n"); 
		query.append("                                                    #if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("                                                    AND X.CRE_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("                                                    #end" ).append("\n"); 
		query.append("                                                    AND X.LOCL_CRE_DT BETWEEN TO_DATE (REPLACE(@[s_fm_dt],'-',''), 'rrrrmmdd') AND TO_DATE (REPLACE(@[s_to_dt],'-',''), 'rrrrmmdd') + 0.999999" ).append("\n"); 
		query.append("                                                    #if (${s_bnd_cd} != '')" ).append("\n"); 
		query.append("                                                        AND X.TRSP_BND_CD = @[s_bnd_cd]" ).append("\n"); 
		query.append("                                                    #end" ).append("\n"); 
		query.append("                                                    #if (${s_trsp_crr_mod_cd} != '')" ).append("\n"); 
		query.append("                                                        AND X.TRSP_CRR_MOD_CD = @[s_trsp_crr_mod_cd]" ).append("\n"); 
		query.append("                                                    #end" ).append("\n"); 
		query.append("                                                ) " ).append("\n"); 
		query.append("   AND S.TRSP_SO_TP_CD IN ('Y', 'M')" ).append("\n"); 
		query.append("   #if (${s_eac_if} != '')" ).append("\n"); 
		query.append("      #if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("         AND EXISTS (SELECT '1'" ).append("\n"); 
		query.append("                       FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("                      WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                        AND X.TRSP_SO_SEQ        = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                        AND X.EAC_SYS_IF_CD      = 'TR1'" ).append("\n"); 
		query.append("                        AND X.LGS_COST_CD        = 'XXXXXX'" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("         AND NOT EXISTS (SELECT '1'" ).append("\n"); 
		query.append("                           FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("                          WHERE X.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND X.TRSP_SO_SEQ        = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                            AND X.EAC_SYS_IF_CD      = 'TR1'" ).append("\n"); 
		query.append("                            AND X.LGS_COST_CD        = 'XXXXXX'" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY EQ_NO, VNDR_SEQ, ORD" ).append("\n"); 

	}
}