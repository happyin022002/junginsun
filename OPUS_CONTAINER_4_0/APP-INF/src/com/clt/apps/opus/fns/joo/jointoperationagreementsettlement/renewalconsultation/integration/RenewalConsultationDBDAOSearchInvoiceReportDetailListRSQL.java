/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchInvoiceReportDetailListRSQL.java
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

public class RenewalConsultationDBDAOSearchInvoiceReportDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Inquiry Datail Search.
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchInvoiceReportDetailListRSQL(){
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
		query.append("FileName : RenewalConsultationDBDAOSearchInvoiceReportDetailListRSQL").append("\n"); 
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
		query.append("    SELECT INV.JO_CRR_CD" ).append("\n"); 
		query.append("         , INV.RLANE_CD" ).append("\n"); 
		query.append("         , INV.INV_NO" ).append("\n"); 
		query.append("         , INV.CSR_NO" ).append("\n"); 
		query.append("         , INV.APRO_FLG" ).append("\n"); 
		query.append("         , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("         , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , INV.ORD_SEQ" ).append("\n"); 
		query.append("         , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("         , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("         , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("         , MAX(INV.REV_VVD) AS REV_VVD" ).append("\n"); 
		query.append("         , SUM(INV.INV_ACT_AMT) AS INV_ACT_AMT" ).append("\n"); 
		query.append("         , SUM(INV.SLP_ACT_AMT) AS SLP_ACT_AMT" ).append("\n"); 
		query.append("         , MAX(INV.STL_RMK) AS STL_RMK" ).append("\n"); 
		query.append("         , MAX(INV.UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("         , MAX(INV.UPD_DT) AS UPD_DT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT INV.*" ).append("\n"); 
		query.append("                 , NVL(CSR.APRO_FLG,'N') AS APRO_FLG" ).append("\n"); 
		query.append("                 , CSR.SLP_TP_CD||CSR.SLP_FUNC_CD||CSR.SLP_OFC_CD||CSR.SLP_ISS_DT||CSR.SLP_SER_NO AS CSR_NO" ).append("\n"); 
		query.append("                 , NVL(SLP.CSR_LOCL_AMT,0) AS SLP_ACT_AMT" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT INV.INV_NO" ).append("\n"); 
		query.append("                         , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                         , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("                         , INV.JO_CRR_CD" ).append("\n"); 
		query.append("                         , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("                         , DTL.VSL_CD||DTL.SKD_VOY_NO||DTL.SKD_DIR_CD||DTL.REV_DIR_CD AS REV_VVD" ).append("\n"); 
		query.append("                         , NVL(DTL.ACT_AMT,0) AS INV_ACT_AMT" ).append("\n"); 
		query.append("                         , DTL.STL_RMK" ).append("\n"); 
		query.append("                         , STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                         , ITM.ORD_SEQ" ).append("\n"); 
		query.append("                         , STL.RLANE_CD" ).append("\n"); 
		query.append("                         , DTL.VSL_CD" ).append("\n"); 
		query.append("                         , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                         , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                         , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                         , DTL.REV_YRMON" ).append("\n"); 
		query.append("                         , DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                         , DTL.UPD_USR_ID" ).append("\n"); 
		query.append("                         , TO_CHAR(DTL.UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("                         , INV.SLP_TP_CD" ).append("\n"); 
		query.append("                         , INV.SLP_FUNC_CD" ).append("\n"); 
		query.append("                         , INV.SLP_OFC_CD" ).append("\n"); 
		query.append("                         , INV.SLP_ISS_DT" ).append("\n"); 
		query.append("                         , INV.SLP_SER_NO" ).append("\n"); 
		query.append("                         , DECODE(INV.RE_DIVR_CD,'R',SUBSTR(INV.PRNR_REF_NO,1,2), NULL) AS CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("                         , DECODE(INV.RE_DIVR_CD,'R',SUBSTR(INV.PRNR_REF_NO,3), INV.PRNR_REF_NO) AS CUST_VNDR_SEQ" ).append("\n"); 
		query.append("                         , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("                         , CASE WHEN INV.RE_DIVR_CD = 'R' THEN" ).append("\n"); 
		query.append("                                     ( SELECT M.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                         FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                                        WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                          AND M.CUST_CNT_CD   = SUBSTR(INV.PRNR_REF_NO,1,2)" ).append("\n"); 
		query.append("                                          AND M.CUST_SEQ      = SUBSTR(INV.PRNR_REF_NO,3) )" ).append("\n"); 
		query.append("                                ELSE" ).append("\n"); 
		query.append("                                     ( SELECT M.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                                         FROM MDM_VENDOR M" ).append("\n"); 
		query.append("                                        WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                          AND M.VNDR_SEQ      = INV.PRNR_REF_NO )" ).append("\n"); 
		query.append("                           END AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("                      FROM JOO_INVOICE INV" ).append("\n"); 
		query.append("                         , JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                         , JOO_STL_TGT STL" ).append("\n"); 
		query.append("                         , JOO_STL_ITM ITM" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND INV.ACCT_YRMON   BETWEEN REPLACE(@[fr_acct_yrmon],'-','') AND REPLACE(@[to_acct_yrmon],'-','') /* Condition Target Invoice Month*/" ).append("\n"); 
		query.append("#if (${jo_crr_cds}!=''  && ${jo_crr_cds} != 'ALL')" ).append("\n"); 
		query.append("                       /* Condition partner Items */" ).append("\n"); 
		query.append("                       AND INV.JO_CRR_CD    IN ( #foreach($key IN ${jo_crr_cds})#if($velocityCount < $jo_crr_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd}!='')" ).append("\n"); 
		query.append("                       AND INV.RE_DIVR_CD   = @[re_divr_cd]        /* Condition ALL, Revenue : R , Expense : E */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("                        /* Condition Trade */" ).append("\n"); 
		query.append("                       AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                                          FROM JOO_CARRIER CRR" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND CRR.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                           AND CRR.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                           AND CRR.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                                           AND CRR.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd}!='')" ).append("\n"); 
		query.append("                       /* Condition Auth Office Cd */" ).append("\n"); 
		query.append("                       AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                                          FROM JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND CA.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                           AND CA.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                           AND CA.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                                           AND CA.AUTH_OFC_CD      = @[auth_ofc_cd]" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!='')" ).append("\n"); 
		query.append("                        AND STL.RLANE_CD     = @[rlane_cd]   /* Condition Lane */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       AND INV.ACCT_YRMON   = DTL.ACCT_YRMON" ).append("\n"); 
		query.append("                       AND INV.JO_CRR_CD    = DTL.JO_CRR_CD" ).append("\n"); 
		query.append("                       AND INV.INV_NO       = DTL.INV_NO" ).append("\n"); 
		query.append("                       AND INV.RE_DIVR_CD   = DTL.RE_DIVR_CD" ).append("\n"); 
		query.append("                       AND DTL.VSL_CD       = STL.VSL_CD" ).append("\n"); 
		query.append("                       AND DTL.SKD_VOY_NO   = STL.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND DTL.SKD_DIR_CD   = STL.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND DTL.REV_DIR_CD   = STL.REV_DIR_CD" ).append("\n"); 
		query.append("                       AND DTL.REV_YRMON    = STL.REV_YRMON" ).append("\n"); 
		query.append("                       AND DTL.STL_VVD_SEQ  = STL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                       AND STL.JO_STL_ITM_CD= ITM.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                       --AND INV.INV_NO IN ('APL1607003','APL1607002')" ).append("\n"); 
		query.append("                   ) INV" ).append("\n"); 
		query.append("                 , JOO_CSR CSR" ).append("\n"); 
		query.append("                 , JOO_SLIP SLP" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND INV.SLP_TP_CD        = CSR.SLP_TP_CD (+)" ).append("\n"); 
		query.append("               AND INV.SLP_FUNC_CD      = CSR.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_OFC_CD       = CSR.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_ISS_DT       = CSR.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("               AND INV.SLP_SER_NO       = CSR.SLP_SER_NO(+)" ).append("\n"); 
		query.append("               AND INV.SLP_TP_CD        = SLP.SLP_TP_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_FUNC_CD      = SLP.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_OFC_CD       = SLP.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_ISS_DT       = SLP.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("               AND INV.SLP_SER_NO       = SLP.SLP_SER_NO(+)" ).append("\n"); 
		query.append("               AND INV.VSL_CD           = SLP.VSL_CD(+)" ).append("\n"); 
		query.append("               AND INV.SKD_VOY_NO       = SLP.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND INV.SKD_DIR_CD       = SLP.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND INV.REV_DIR_CD       = SLP.REV_DIR_CD(+)" ).append("\n"); 
		query.append("               AND INV.REV_YRMON        = SLP.REV_YRMON(+)" ).append("\n"); 
		query.append("               AND INV.STL_VVD_SEQ      = SLP.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("               AND SLP.DR_CR_CD         (+)= 'DR'" ).append("\n"); 
		query.append("           ) INV" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     GROUP BY INV.INV_NO" ).append("\n"); 
		query.append("         , INV.CSR_NO" ).append("\n"); 
		query.append("         , INV.APRO_FLG" ).append("\n"); 
		query.append("         , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("         , INV.ORD_SEQ" ).append("\n"); 
		query.append("         , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , INV.JO_CRR_CD" ).append("\n"); 
		query.append("         , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("         , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("         , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("         , INV.REV_VVD" ).append("\n"); 
		query.append("         , INV.RLANE_CD" ).append("\n"); 
		query.append("     ORDER BY" ).append("\n"); 
		query.append("       INV.INV_NO" ).append("\n"); 
		query.append("     , INV.RE_DIVR_CD DESC" ).append("\n"); 
		query.append("     , INV.JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.RLANE_CD" ).append("\n"); 
		query.append("     , INV.ORD_SEQ" ).append("\n"); 
		query.append("     , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_INV_RAWDATA;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(INV.DTAT_ORD, 2, 'Subtotal:'||INV.LOCL_CURR_CD, 3, 'Total:'||INV.LOCL_CURR_CD, INV.JO_CRR_CD) AS JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.RLANE_CD" ).append("\n"); 
		query.append("     , DECODE(INV.DTAT_ORD, 2, ' ', 3, '  ', INV.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("     , DECODE(INV.DTAT_ORD, 2, ' ', 3, '  ', INV.CSR_NO) AS CSR_NO" ).append("\n"); 
		query.append("     , DECODE(INV.DTAT_ORD, 2, ' ', 3, '  ', INV.APRO_FLG) AS APRO_FLG" ).append("\n"); 
		query.append("     , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("     , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , INV.ORD_SEQ" ).append("\n"); 
		query.append("     , DECODE(INV.DTAT_ORD, 2, NULL, 3, NULL, INV.LOCL_CURR_CD) AS LOCL_CURR_CD" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("     , INV.REV_VVD" ).append("\n"); 
		query.append("     , INV.INV_ACT_AMT" ).append("\n"); 
		query.append("     , INV.SLP_ACT_AMT" ).append("\n"); 
		query.append("     , INV.STL_RMK" ).append("\n"); 
		query.append("     , INV.UPD_USR_ID" ).append("\n"); 
		query.append("     , INV.UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        /*RawData */" ).append("\n"); 
		query.append("        SELECT 1 AS DTAT_ORD" ).append("\n"); 
		query.append("             , INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.RLANE_CD" ).append("\n"); 
		query.append("             , INV.INV_NO" ).append("\n"); 
		query.append("             , INV.CSR_NO" ).append("\n"); 
		query.append("             , INV.APRO_FLG" ).append("\n"); 
		query.append("             , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("             , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , INV.ORD_SEQ" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("             , INV.CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("             , INV.REV_VVD" ).append("\n"); 
		query.append("             , INV.INV_ACT_AMT" ).append("\n"); 
		query.append("             , INV.SLP_ACT_AMT" ).append("\n"); 
		query.append("             , INV.STL_RMK" ).append("\n"); 
		query.append("             , INV.UPD_USR_ID" ).append("\n"); 
		query.append("             , INV.UPD_DT" ).append("\n"); 
		query.append("          FROM V_INV_RAWDATA INV" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        /*SubTotal : Inv_no, Locl_curr_cd*/" ).append("\n"); 
		query.append("        SELECT 2 AS DTAT_ORD" ).append("\n"); 
		query.append("             , NULL AS JO_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS RLANE_CD" ).append("\n"); 
		query.append("             , INV.INV_NO" ).append("\n"); 
		query.append("             , NULL AS CSR_NO" ).append("\n"); 
		query.append("             , NULL AS APRO_FLG" ).append("\n"); 
		query.append("             , NULL AS RE_DIVR_CD" ).append("\n"); 
		query.append("             , NULL AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , NULL AS ORD_SEQ" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , NULL AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS PRNR_REF_NO" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("             , NULL AS REV_VVD" ).append("\n"); 
		query.append("             , SUM(INV.INV_ACT_AMT) AS INV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(INV.SLP_ACT_AMT) AS SLP_ACT_AMT" ).append("\n"); 
		query.append("             , NULL AS STL_RMK" ).append("\n"); 
		query.append("             , NULL AS UPD_USR_ID" ).append("\n"); 
		query.append("             , NULL AS UPD_DT" ).append("\n"); 
		query.append("          FROM V_INV_RAWDATA INV" ).append("\n"); 
		query.append("         GROUP BY INV.INV_NO" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        /*Total : Locl_curr_cd*/" ).append("\n"); 
		query.append("        SELECT 3 AS DTAT_ORD" ).append("\n"); 
		query.append("             , NULL AS JO_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS RLANE_CD" ).append("\n"); 
		query.append("             , NULL AS INV_NO" ).append("\n"); 
		query.append("             , NULL AS CSR_NO" ).append("\n"); 
		query.append("             , NULL AS APRO_FLG" ).append("\n"); 
		query.append("             , NULL AS RE_DIVR_CD" ).append("\n"); 
		query.append("             , NULL AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , NULL AS ORD_SEQ" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , NULL AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS PRNR_REF_NO" ).append("\n"); 
		query.append("             , NULL AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("             , NULL AS REV_VVD" ).append("\n"); 
		query.append("             , SUM(INV.INV_ACT_AMT) AS INV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(INV.SLP_ACT_AMT) AS SLP_ACT_AMT" ).append("\n"); 
		query.append("             , NULL AS STL_RMK" ).append("\n"); 
		query.append("             , NULL AS UPD_USR_ID" ).append("\n"); 
		query.append("             , NULL AS UPD_DT" ).append("\n"); 
		query.append("          FROM V_INV_RAWDATA INV" ).append("\n"); 
		query.append("         GROUP BY INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("        ) INV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" ORDER BY" ).append("\n"); 
		query.append("       INV.INV_NO" ).append("\n"); 
		query.append("     , INV.DTAT_ORD" ).append("\n"); 
		query.append("     , INV.RE_DIVR_CD DESC" ).append("\n"); 
		query.append("     , INV.JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.RLANE_CD" ).append("\n"); 
		query.append("     , INV.ORD_SEQ" ).append("\n"); 
		query.append("     , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("     , INV.CUST_VNDR_ENG_NM" ).append("\n"); 

	}
}