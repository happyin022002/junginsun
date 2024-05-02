/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchInvoiceDeleteListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOSearchInvoiceDeleteListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제할 Invoice 목록 조회.
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchInvoiceDeleteListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchInvoiceDeleteListRSQL").append("\n"); 
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
		query.append("WITH V_MDM_ORG AS (" ).append("\n"); 
		query.append("    SELECT D.OFC_CD" ).append("\n"); 
		query.append("         , D.LOC_CD" ).append("\n"); 
		query.append("         , D.AP_CTR_CD" ).append("\n"); 
		query.append("         , D.AP_OFC_CD" ).append("\n"); 
		query.append("         , D.FINC_RGN_CD" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION D" ).append("\n"); 
		query.append("         , MDM_ORGANIZATION E" ).append("\n"); 
		query.append("     WHERE D.OFC_CD = E.AP_OFC_CD" ).append("\n"); 
		query.append("       AND E.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("       AND ROWNUM   = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT INV.INV_NO" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , INV.TOT_AMOUNT AS ACT_AMT" ).append("\n"); 
		query.append("     , INV.ACCT_YRMON" ).append("\n"); 
		query.append("     --, INV.AR_AP_DIV_CD" ).append("\n"); 
		query.append("     --, 'F0' AS EVID_TP_CD" ).append("\n"); 
		query.append("     --, INV.INV_NO AS CSR_OFFST_NO" ).append("\n"); 
		query.append("     --, TO_CHAR(TO_DATE(INV.ACCT_YRMON,'YYYYMM'),'RR/MM')||' '||INV.ACCTG_CRR_CD||' settlement' AS CSR_DESC" ).append("\n"); 
		query.append("     , ORG.OFC_CD AS SLP_ISS_OFC_CD /*Login Office*/" ).append("\n"); 
		query.append("     --, ORG.FINC_RGN_CD AS SLP_ISS_RGN_CD" ).append("\n"); 
		query.append("     , DECODE(INV.RE_DIVR_CD, 'R', '18', '06') AS SLP_TP_CD" ).append("\n"); 
		query.append("     , DECODE(INV.RE_DIVR_CD, 'R', 'T' , (CASE WHEN INV.TOT_AMOUNT< 0 THEN 'C' ELSE 'S' END)) AS SLP_FUNC_CD" ).append("\n"); 
		query.append("     , ORG.AP_OFC_CD AS SLP_OFC_CD /*AP OFFICE*/" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(INV.RQST_DT,'YYYYMMDD'),'RRMM') AS SLP_ISS_DT" ).append("\n"); 
		query.append("     , NULL AS SLP_SER_NO" ).append("\n"); 
		query.append("     --, DECODE(INV.RE_DIVR_CD, 'E', (CASE WHEN INV.TOT_AMOUNT< 0 THEN 'CREDIT' ELSE 'STANDARD' END), NULL) AS CSR_TP_CD" ).append("\n"); 
		query.append("     , CASE WHEN INV.RE_DIVR_CD = 'R' THEN " ).append("\n"); 
		query.append("                 ( SELECT M.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                     FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                    WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND M.CUST_CNT_CD   = INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("                      AND M.CUST_SEQ      = INV.CUST_VNDR_SEQ )" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 ( SELECT M.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                     FROM MDM_VENDOR M" ).append("\n"); 
		query.append("                    WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND M.VNDR_SEQ      = INV.CUST_VNDR_SEQ )" ).append("\n"); 
		query.append("       END AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("  FROM (     " ).append("\n"); 
		query.append("        SELECT INV.INV_NO" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , SUM(INV.ACT_AMT) AS TOT_AMOUNT" ).append("\n"); 
		query.append("             , INV.ACCT_YRMON" ).append("\n"); 
		query.append("             , INV.AR_AP_DIV_CD" ).append("\n"); 
		query.append("             , TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(GLOBALDATE_PKG.GET_LOCCD_FNC('SINHO')),'YYYYMMDD') AS RQST_DT" ).append("\n"); 
		query.append("             , TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(GLOBALDATE_PKG.GET_LOCCD_FNC('SINHO')),'YYYYMMDD') AS ISS_DT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT INV.INV_NO" ).append("\n"); 
		query.append("                     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("                     , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                     , DECODE(INV.RE_DIVR_CD,'R',SUBSTR(INV.PRNR_REF_NO,1,2), NULL) AS CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("                     , DECODE(INV.RE_DIVR_CD,'R',SUBSTR(INV.PRNR_REF_NO,3), INV.PRNR_REF_NO) AS CUST_VNDR_SEQ" ).append("\n"); 
		query.append("                     , DECODE(INV.RE_DIVR_CD,'R','R', 'P') AS AR_AP_DIV_CD" ).append("\n"); 
		query.append("                     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("                     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , INV.JO_CRR_CD" ).append("\n"); 
		query.append("                     , INV.ACT_AMT" ).append("\n"); 
		query.append("                     , INV.ACCT_YRMON" ).append("\n"); 
		query.append("                  FROM JOO_INVOICE INV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND INV.ACCT_YRMON   BETWEEN REPLACE(@[fr_acct_yrmon],'-') AND REPLACE(@[to_acct_yrmon],'-')" ).append("\n"); 
		query.append("                   AND TRIM(INV.SLP_TP_CD||INV.SLP_FUNC_CD||INV.SLP_OFC_CD||INV.SLP_ISS_DT||INV.SLP_SER_NO) IS NULL" ).append("\n"); 
		query.append("#if (${jo_crr_cds} != '' && ${jo_crr_cds} != 'ALL') " ).append("\n"); 
		query.append("                   /* Condition Actual Carrier */ " ).append("\n"); 
		query.append("                   AND INV.ACCTG_CRR_CD IN ( #foreach($key IN ${jo_crr_cds})#if($velocityCount < $jo_crr_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd}!='')" ).append("\n"); 
		query.append("                   /* Condition Auth Office Cd */" ).append("\n"); 
		query.append("                   AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                                  FROM JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                                     , JOO_STL_TGT TGT" ).append("\n"); 
		query.append("                                     , JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("                                 WHERE DTL.ACCT_YRMON   = INV.ACCT_YRMON" ).append("\n"); 
		query.append("                                   AND DTL.JO_CRR_CD    = INV.JO_CRR_CD" ).append("\n"); 
		query.append("                                   AND DTL.INV_NO       = INV.INV_NO" ).append("\n"); 
		query.append("                                   AND DTL.RE_DIVR_CD   = INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                                   AND DTL.VSL_CD       = TGT.VSL_CD" ).append("\n"); 
		query.append("                                   AND DTL.SKD_VOY_NO   = TGT.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND DTL.SKD_DIR_CD   = TGT.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND DTL.REV_DIR_CD   = TGT.REV_DIR_CD" ).append("\n"); 
		query.append("                                   AND DTL.REV_YRMON    = TGT.REV_YRMON" ).append("\n"); 
		query.append("                                   AND DTL.STL_VVD_SEQ  = TGT.STL_VVD_SEQ" ).append("\n"); 
		query.append("                                   AND TGT.JO_CRR_CD    = CA.JO_CRR_CD" ).append("\n"); 
		query.append("                                   AND TGT.RLANE_CD     = CA.RLANE_CD" ).append("\n"); 
		query.append("                                   AND CA.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                                   AND CA.AUTH_OFC_CD   = @[auth_ofc_cd]" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ORDER BY INV.INV_NO" ).append("\n"); 
		query.append("                     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("                     , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("             ) INV" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        GROUP BY INV.INV_NO" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.ACCT_YRMON" ).append("\n"); 
		query.append("             , INV.AR_AP_DIV_CD" ).append("\n"); 
		query.append("        ) INV" ).append("\n"); 
		query.append("      , V_MDM_ORG ORG" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" ORDER BY INV.INV_NO" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.RE_DIVR_CD" ).append("\n"); 

	}
}