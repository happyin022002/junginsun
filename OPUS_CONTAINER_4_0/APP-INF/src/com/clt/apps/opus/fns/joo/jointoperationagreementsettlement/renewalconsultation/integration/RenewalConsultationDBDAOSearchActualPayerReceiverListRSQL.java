/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchActualPayerReceiverListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
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

public class RenewalConsultationDBDAOSearchActualPayerReceiverListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select Actual payer or receiver Search
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchActualPayerReceiverListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchActualPayerReceiverListRSQL").append("\n"); 
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
		query.append("WITH V_JOO_STL_TGT AS (" ).append("\n"); 
		query.append("    SELECT STL.VSL_CD" ).append("\n"); 
		query.append("         , STL.SKD_VOY_NO" ).append("\n"); 
		query.append("         , STL.SKD_DIR_CD" ).append("\n"); 
		query.append("         , STL.REV_DIR_CD" ).append("\n"); 
		query.append("         , STL.REV_YRMON" ).append("\n"); 
		query.append("         , STL.STL_VVD_SEQ" ).append("\n"); 
		query.append("         , STL.JO_CRR_CD" ).append("\n"); 
		query.append("         , STL.RE_DIVR_CD" ).append("\n"); 
		query.append("         , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , STL.ACT_AMT" ).append("\n"); 
		query.append("         , STL.STL_TGT_FLG" ).append("\n"); 
		query.append("      FROM JOO_STL_TGT STL" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       --AND STL.STL_TGT_FLG  = 'Y'" ).append("\n"); 
		query.append("       AND STL.REV_YRMON    BETWEEN REPLACE(@[fr_rev_yrmon],'-','') AND REPLACE(@[to_rev_yrmon],'-','') /* Condition Target Revenue Month*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${jo_crr_cd}!='')" ).append("\n"); 
		query.append("       AND STL.JO_CRR_CD    = @[jo_crr_cd]     /* Condition Carrier */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("       /* Condition Trade */" ).append("\n"); 
		query.append("       AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                          FROM JOO_CARRIER CRR" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND CRR.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                           AND CRR.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                           AND CRR.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                           AND CRR.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!='')" ).append("\n"); 
		query.append("       AND STL.RLANE_CD     = @[rlane_cd]   /* Condition Lane */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd}!='')" ).append("\n"); 
		query.append("       /* Condition Auth Office Cd */" ).append("\n"); 
		query.append("       AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                          FROM JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND CA.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                           AND CA.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                           AND CA.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                           AND CA.AUTH_OFC_CD      = @[auth_ofc_cd]" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd}!='')" ).append("\n"); 
		query.append("       AND STL.RE_DIVR_CD   = @[re_divr_cd]        /* Condition ALL, Revenue : R , Expense : E */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_vvd}!='')" ).append("\n"); 
		query.append("       AND STL.VSL_CD||STL.SKD_VOY_NO||STL.SKD_DIR_CD||STL.REV_DIR_CD LIKE @[rev_vvd]||'%'        /* Condition VVD */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cds} != '' && ${jo_stl_itm_cds} != 'ALL')" ).append("\n"); 
		query.append("       /* Condition Items */" ).append("\n"); 
		query.append("       AND STL.JO_STL_ITM_CD IN ( #foreach($key IN ${jo_stl_itm_cds})#if($velocityCount < $jo_stl_itm_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_JOO_STL_TGT;" ).append("\n"); 
		query.append("    , V_JOO_INVOICE AS (" ).append("\n"); 
		query.append("        SELECT INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , SUM(DTL.ACT_AMT) AS ACT_AMT" ).append("\n"); 
		query.append("          FROM V_JOO_STL_TGT STL" ).append("\n"); 
		query.append("             , JOO_INV_DTL DTL" ).append("\n"); 
		query.append("             , JOO_INVOICE INV" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND STL.VSL_CD        = DTL.VSL_CD" ).append("\n"); 
		query.append("           AND STL.SKD_VOY_NO    = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND STL.SKD_DIR_CD    = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND STL.REV_DIR_CD    = DTL.REV_DIR_CD" ).append("\n"); 
		query.append("           AND STL.REV_YRMON     = DTL.REV_YRMON" ).append("\n"); 
		query.append("           AND STL.STL_VVD_SEQ   = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("           AND DTL.ACCT_YRMON    = INV.ACCT_YRMON" ).append("\n"); 
		query.append("           AND DTL.JO_CRR_CD     = INV.JO_CRR_CD" ).append("\n"); 
		query.append("           AND DTL.INV_NO        = INV.INV_NO" ).append("\n"); 
		query.append("           AND DTL.RE_DIVR_CD    = INV.RE_DIVR_CD" ).append("\n"); 
		query.append("         GROUP BY INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_JOO_INVOICE;" ).append("\n"); 
		query.append("SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , TO_CHAR(SYSDATE,'YYYYMM') AS ACCT_YRMON" ).append("\n"); 
		query.append("     , STL.STL_REV_ACT_AMT" ).append("\n"); 
		query.append("     , STL.STL_EXP_ACT_AMT" ).append("\n"); 
		query.append("     , STL.INV_REV_ACT_AMT" ).append("\n"); 
		query.append("     , STL.INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("     , ( SELECT MIN(CR.JO_CRR_CD||'^'||CR.CUST_CNT_CD||CUST_SEQ||'^'||CR.VNDR_SEQ)" ).append("\n"); 
		query.append("           FROM JOO_CARRIER CR" ).append("\n"); 
		query.append("          WHERE CR.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("            AND CR.JO_CRR_CD    = STL.JO_CRR_CD" ).append("\n"); 
		query.append("        ) AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("             , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , SUM(STL.STL_REV_ACT_AMT) AS STL_REV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(STL.STL_EXP_ACT_AMT) AS STL_EXP_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(STL.INV_REV_ACT_AMT) AS INV_REV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(STL.INV_EXP_ACT_AMT) AS INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("             , STL.JO_CRR_CD AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("                     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , DECODE('R', STL.RE_DIVR_CD, STL.STL_ACT_AMT, 0) AS STL_REV_ACT_AMT" ).append("\n"); 
		query.append("                     , DECODE('E', STL.RE_DIVR_CD, STL.STL_ACT_AMT, 0) AS STL_EXP_ACT_AMT" ).append("\n"); 
		query.append("                     , DECODE('R', STL.RE_DIVR_CD, STL.INV_ACT_AMT, 0) AS INV_REV_ACT_AMT" ).append("\n"); 
		query.append("                     , DECODE('E', STL.RE_DIVR_CD, STL.INV_ACT_AMT, 0) AS INV_EXP_ACT_AMT" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("                             , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("                             , STL.RE_DIVR_CD" ).append("\n"); 
		query.append("                             , NVL(STL.ACT_AMT,0) AS STL_ACT_AMT" ).append("\n"); 
		query.append("                             , NVL(INV.ACT_AMT,0) AS INV_ACT_AMT" ).append("\n"); 
		query.append("                          FROM (SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                     , STL.RE_DIVR_CD" ).append("\n"); 
		query.append("                                     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                     , SUM(STL.ACT_AMT) AS ACT_AMT" ).append("\n"); 
		query.append("                                  FROM V_JOO_STL_TGT STL" ).append("\n"); 
		query.append("                                 WHERE NVL(STL.ACT_AMT, 0) <> 0" ).append("\n"); 
		query.append("                                   AND STL.STL_TGT_FLG      = 'Y'" ).append("\n"); 
		query.append("                                 GROUP BY STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                     , STL.RE_DIVR_CD" ).append("\n"); 
		query.append("                                     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("                               ) STL" ).append("\n"); 
		query.append("                             , V_JOO_INVOICE INV" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND STL.JO_CRR_CD     = INV.JO_CRR_CD     (+)" ).append("\n"); 
		query.append("                          AND STL.LOCL_CURR_CD  = INV.LOCL_CURR_CD  (+)" ).append("\n"); 
		query.append("                          AND STL.RE_DIVR_CD    = INV.RE_DIVR_CD    (+)" ).append("\n"); 
		query.append("                    ) STL" ).append("\n"); 
		query.append("               ) STL" ).append("\n"); 
		query.append("         GROUP BY STL.JO_CRR_CD" ).append("\n"); 
		query.append("             , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("       ) STL" ).append("\n"); 
		query.append(" ORDER BY STL.JO_CRR_CD" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 

	}
}