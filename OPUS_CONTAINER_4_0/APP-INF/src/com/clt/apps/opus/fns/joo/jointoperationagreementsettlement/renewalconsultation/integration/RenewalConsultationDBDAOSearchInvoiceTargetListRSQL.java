/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchInvoiceTargetListRSQL.java
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

public class RenewalConsultationDBDAOSearchInvoiceTargetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Target 조회.
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchInvoiceTargetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : RenewalConsultationDBDAOSearchInvoiceTargetListRSQL").append("\n"); 
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
		query.append("SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("     , STL.RLANE_CD" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , TO_CHAR(SYSDATE,'YYYYMM') AS ACCT_YRMON" ).append("\n"); 
		query.append("     , SUM(STL.STL_REV_ACT_AMT) AS STL_REV_ACT_AMT" ).append("\n"); 
		query.append("     , SUM(STL.STL_EXP_ACT_AMT) AS STL_EXP_ACT_AMT" ).append("\n"); 
		query.append("     , ( SELECT MIN(CR.JO_CRR_CD||'^'||CR.CUST_CNT_CD||CUST_SEQ||'^'||CR.VNDR_SEQ)" ).append("\n"); 
		query.append("           FROM JOO_CARRIER CR" ).append("\n"); 
		query.append("          WHERE CR.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("            AND CR.JO_CRR_CD    = STL.JO_CRR_CD" ).append("\n"); 
		query.append("            AND CR.RLANE_CD     = STL.RLANE_CD" ).append("\n"); 
		query.append("        ) AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , STL.JO_CRR_CD || STL.RLANE_CD || STL.LOCL_CURR_CD AS DTL_GRP_KEY" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("             , STL.RLANE_CD" ).append("\n"); 
		query.append("             , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , DECODE(STL.RE_DIVR_CD, 'R', STL.ACT_AMT, NULL) AS STL_REV_ACT_AMT" ).append("\n"); 
		query.append("             , DECODE(STL.RE_DIVR_CD, 'E', STL.ACT_AMT, NULL) AS STL_EXP_ACT_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT STL.JO_CRR_CD" ).append("\n"); 
		query.append("                     , STL.RLANE_CD" ).append("\n"); 
		query.append("                     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , STL.RE_DIVR_CD" ).append("\n"); 
		query.append("                     , ROUND(STL.ACT_AMT, 2) AS ACT_AMT" ).append("\n"); 
		query.append("                  FROM JOO_STL_TGT STL" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND STL.STL_TGT_FLG      = 'Y'" ).append("\n"); 
		query.append("                   AND NVL(STL.ACT_AMT, 0)  <> 0" ).append("\n"); 
		query.append("                   AND STL.REV_YRMON        BETWEEN REPLACE(@[fr_rev_yrmon],'-') AND REPLACE(@[to_rev_yrmon],'-') /* Condition Target Revenue Month*/" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("                   /* Condition Trade */" ).append("\n"); 
		query.append("                   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                                      FROM JOO_CARRIER CRR" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND CRR.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                       AND CRR.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                       AND CRR.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                                       AND CRR.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
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
		query.append("#if (${re_divr_cd}!='')" ).append("\n"); 
		query.append("                    AND STL.RE_DIVR_CD      = @[re_divr_cd]     /* Condition ALL, Revenue : R , Expense : E */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cds} != '' && ${jo_crr_cds} != 'ALL')" ).append("\n"); 
		query.append("                   /* Condition Items */" ).append("\n"); 
		query.append("                   AND STL.JO_CRR_CD        IN ( #foreach($key IN ${jo_crr_cds})#if($velocityCount < $jo_crr_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ) STL" ).append("\n"); 
		query.append("   ) STL" ).append("\n"); 
		query.append("GROUP BY STL.JO_CRR_CD" ).append("\n"); 
		query.append("     , STL.RLANE_CD" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("ORDER BY STL.JO_CRR_CD" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , STL.RLANE_CD" ).append("\n"); 

	}
}