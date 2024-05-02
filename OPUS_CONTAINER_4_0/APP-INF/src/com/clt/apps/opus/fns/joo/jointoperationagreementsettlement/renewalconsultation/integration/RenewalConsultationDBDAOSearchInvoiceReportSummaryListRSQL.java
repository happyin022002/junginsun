/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchInvoiceReportSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.02 
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

public class RenewalConsultationDBDAOSearchInvoiceReportSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Inquiry Summary Search.
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchInvoiceReportSummaryListRSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchInvoiceReportSummaryListRSQL").append("\n"); 
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
		query.append("WITH V_INV_RAWDATA AS (" ).append("\n"); 
		query.append("        SELECT INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.RLANE_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.INV_NO" ).append("\n"); 
		query.append("             , INV.CSR_NO" ).append("\n"); 
		query.append("             , INV.APRO_FLG" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("             , SUM(INV.REV_ACT_AMT) AS INV_REV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(INV.EXP_ACT_AMT) AS INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT INV.JO_CRR_CD" ).append("\n"); 
		query.append("                     , STL.RLANE_CD" ).append("\n"); 
		query.append("                     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , DTL.ACT_AMT" ).append("\n"); 
		query.append("                     , INV.INV_NO" ).append("\n"); 
		query.append("                     , NVL(INV.SLP_TP_CD||INV.SLP_FUNC_CD||INV.SLP_OFC_CD||INV.SLP_ISS_DT||INV.SLP_SER_NO,'N/A') AS CSR_NO" ).append("\n"); 
		query.append("                     , NVL(CSR.APRO_FLG, 'N') AS APRO_FLG" ).append("\n"); 
		query.append("                     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("                     , DECODE(INV.RE_DIVR_CD,'R',SUBSTR(INV.PRNR_REF_NO,1,2), NULL) AS CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("                     , DECODE(INV.RE_DIVR_CD,'R',SUBSTR(INV.PRNR_REF_NO,3), INV.PRNR_REF_NO) AS CUST_VNDR_SEQ" ).append("\n"); 
		query.append("                     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("                     , DECODE('R', STL.RE_DIVR_CD, DTL.ACT_AMT, 0) AS REV_ACT_AMT" ).append("\n"); 
		query.append("                     , DECODE('E', STL.RE_DIVR_CD, DTL.ACT_AMT, 0) AS EXP_ACT_AMT" ).append("\n"); 
		query.append("                     , CASE WHEN INV.RE_DIVR_CD = 'R' THEN" ).append("\n"); 
		query.append("                                 ( SELECT M.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                     FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                                    WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                      AND M.CUST_CNT_CD   = SUBSTR(INV.PRNR_REF_NO,1,2)" ).append("\n"); 
		query.append("                                      AND M.CUST_SEQ      = SUBSTR(INV.PRNR_REF_NO,3) )" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                 ( SELECT M.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                                     FROM MDM_VENDOR M" ).append("\n"); 
		query.append("                                    WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                      AND M.VNDR_SEQ      = INV.PRNR_REF_NO )" ).append("\n"); 
		query.append("                       END AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("                  FROM JOO_INVOICE INV" ).append("\n"); 
		query.append("                     , JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                     , JOO_STL_TGT STL" ).append("\n"); 
		query.append("                     , JOO_CSR     CSR" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND INV.ACCT_YRMON   BETWEEN REPLACE(@[fr_acct_yrmon],'-','') AND REPLACE(@[to_acct_yrmon],'-','') /* Condition Target Invoice Month*/" ).append("\n"); 
		query.append("#if (${jo_crr_cds}!=''  && ${jo_crr_cds} != 'ALL')" ).append("\n"); 
		query.append("                   /* Condition partner Items */" ).append("\n"); 
		query.append("                   AND INV.JO_CRR_CD    IN ( #foreach($key IN ${jo_crr_cds})#if($velocityCount < $jo_crr_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd}!='')" ).append("\n"); 
		query.append("                   AND INV.RE_DIVR_CD   = @[re_divr_cd]        /* Condition ALL, Revenue : R , Expense : E */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("                    /* Condition Trade */" ).append("\n"); 
		query.append("                   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                                      FROM JOO_CARRIER CRR" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND CRR.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                       AND CRR.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                       AND CRR.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                                       AND CRR.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd}!='')" ).append("\n"); 
		query.append("                   /* Condition Auth Office Cd */" ).append("\n"); 
		query.append("                   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                                      FROM JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND CA.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                       AND CA.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                       AND CA.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                                       AND CA.AUTH_OFC_CD      = @[auth_ofc_cd]" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!='')" ).append("\n"); 
		query.append("                   AND STL.RLANE_CD     = @[rlane_cd]   /* Condition Lane */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND INV.RVS_CMB_FLG   = 'N'" ).append("\n"); 
		query.append("                   AND INV.RJCT_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("                   AND DTL.ACCT_YRMON    = INV.ACCT_YRMON" ).append("\n"); 
		query.append("                   AND DTL.JO_CRR_CD     = INV.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND DTL.INV_NO        = INV.INV_NO" ).append("\n"); 
		query.append("                   AND DTL.RE_DIVR_CD    = INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                   AND STL.VSL_CD        = DTL.VSL_CD" ).append("\n"); 
		query.append("                   AND STL.SKD_VOY_NO    = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND STL.SKD_DIR_CD    = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND STL.REV_DIR_CD    = DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                   AND STL.REV_YRMON     = DTL.REV_YRMON" ).append("\n"); 
		query.append("                   AND STL.STL_VVD_SEQ   = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                   AND INV.SLP_TP_CD     = CSR.SLP_TP_CD(+)" ).append("\n"); 
		query.append("                   AND INV.SLP_FUNC_CD   = CSR.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("                   AND INV.SLP_OFC_CD    = CSR.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND INV.SLP_ISS_DT    = CSR.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("                   AND INV.SLP_SER_NO    = CSR.SLP_SER_NO(+)" ).append("\n"); 
		query.append("                   --AND CSR.APRO_FLG      = 'Y'" ).append("\n"); 
		query.append("               ) INV" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         GROUP BY INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.RLANE_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.INV_NO" ).append("\n"); 
		query.append("             , INV.CSR_NO" ).append("\n"); 
		query.append("             , INV.APRO_FLG" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("         ORDER BY" ).append("\n"); 
		query.append("               INV.INV_NO" ).append("\n"); 
		query.append("             , INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.RLANE_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT * FROM V_INV_RAWDATA;" ).append("\n"); 
		query.append("SELECT DECODE(INV.DTAT_ORD, 2, 'Subtotal:'||INV.LOCL_CURR_CD, 3, 'Total:'||INV.LOCL_CURR_CD, INV.JO_CRR_CD) AS JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.RLANE_CD" ).append("\n"); 
		query.append("     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , DECODE(INV.DTAT_ORD, 2, ' ', 3, '  ', INV.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("     , DECODE(INV.DTAT_ORD, 2, ' ', 3, '  ', INV.CSR_NO) AS CSR_NO" ).append("\n"); 
		query.append("     , DECODE(INV.DTAT_ORD, 2, ' ', 3, '  ', INV.APRO_FLG) AS APRO_FLG" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("     , INV.INV_REV_ACT_AMT" ).append("\n"); 
		query.append("     , INV.INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        /*RawData*/" ).append("\n"); 
		query.append("        SELECT 1 AS DTAT_ORD" ).append("\n"); 
		query.append("             , INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.RLANE_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.INV_NO" ).append("\n"); 
		query.append("             , INV.CSR_NO" ).append("\n"); 
		query.append("             , INV.APRO_FLG" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("             , INV.INV_REV_ACT_AMT" ).append("\n"); 
		query.append("             , INV.INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("          FROM V_INV_RAWDATA INV" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        /*SubTotal : Inv_no, Locl_curr_cd*/" ).append("\n"); 
		query.append("        SELECT 2 AS DTAT_ORD" ).append("\n"); 
		query.append("             , NULL AS JO_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS RLANE_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.INV_NO" ).append("\n"); 
		query.append("             , NULL AS CSR_NO" ).append("\n"); 
		query.append("             , NULL AS APRO_FLG" ).append("\n"); 
		query.append("             , NULL AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , NULL AS PRNR_REF_NO" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("             , SUM(INV.INV_REV_ACT_AMT) AS INV_REV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(INV.INV_EXP_ACT_AMT) AS INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("          FROM V_INV_RAWDATA INV" ).append("\n"); 
		query.append("         GROUP BY INV.INV_NO" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        /*Total : Locl_curr_cd*/" ).append("\n"); 
		query.append("        SELECT 3 AS DTAT_ORD" ).append("\n"); 
		query.append("             , NULL AS JO_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS RLANE_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , NULL AS INV_NO" ).append("\n"); 
		query.append("             , NULL AS CSR_NO" ).append("\n"); 
		query.append("             , NULL AS APRO_FLG" ).append("\n"); 
		query.append("             , NULL AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_SEQ" ).append("\n"); 
		query.append("             , NULL AS PRNR_REF_NO" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("             , SUM(INV.INV_REV_ACT_AMT) AS INV_REV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(INV.INV_EXP_ACT_AMT) AS INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("          FROM V_INV_RAWDATA INV" ).append("\n"); 
		query.append("         GROUP BY INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("        ) INV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" ORDER BY INV.INV_NO" ).append("\n"); 
		query.append("     , INV.DTAT_ORD" ).append("\n"); 
		query.append("     , INV.JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.RLANE_CD" ).append("\n"); 
		query.append("     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_SEQ" ).append("\n"); 
		query.append("     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_ENG_NM" ).append("\n"); 

	}
}