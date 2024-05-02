/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchConvertedInvoiceAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchConvertedInvoiceAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice , Tariff Currency Local to Local 추가
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchConvertedInvoiceAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchConvertedInvoiceAmountRSQL").append("\n"); 
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
		query.append("WITH V_FR_MON_XCH_RT AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 1 AS GUBUN" ).append("\n"); 
		query.append("                     , FR.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                             , A.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("                             , A.CURR_CD" ).append("\n"); 
		query.append("                             , A.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(PARTITION BY A.CURR_CD ORDER BY A.ACCT_XCH_RT_YRMON DESC) XCH_RANK" ).append("\n"); 
		query.append("                          FROM GL_MON_XCH_RT A" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[dt],'-'), 1, 6)" ).append("\n"); 
		query.append("                           AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("                           AND A.CURR_CD = @[fr_curr_cd]" ).append("\n"); 
		query.append("                        ) FR" ).append("\n"); 
		query.append("                 WHERE FR.XCH_RANK = 1 /*CURR_CD의 Last YRMON*/" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT 2 AS GUBUN" ).append("\n"); 
		query.append("                     , FR.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                             , A.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("                             , A.CURR_CD" ).append("\n"); 
		query.append("                             , A.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(PARTITION BY A.CURR_CD ORDER BY A.ACCT_XCH_RT_YRMON DESC) XCH_RANK" ).append("\n"); 
		query.append("                          FROM GL_MON_XCH_RT A" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("                           AND A.CURR_CD = @[fr_curr_cd]" ).append("\n"); 
		query.append("                        ) FR" ).append("\n"); 
		query.append("                 WHERE FR.XCH_RANK = 1 /*CURR_CD의 Last YRMON*/" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_FR_MON_XCH_RT;    " ).append("\n"); 
		query.append("    , V_TO_MON_XCH_RT AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 1 AS GUBUN" ).append("\n"); 
		query.append("                     , A.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                             , A.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("                             , A.CURR_CD" ).append("\n"); 
		query.append("                             , A.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(PARTITION BY A.CURR_CD ORDER BY A.ACCT_XCH_RT_YRMON DESC) XCH_RANK" ).append("\n"); 
		query.append("                          FROM GL_MON_XCH_RT A" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[dt],'-'), 1, 6)" ).append("\n"); 
		query.append("                           AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("                           AND A.CURR_CD = NVL(@[to_curr_cd],@[fr_curr_cd])" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                 WHERE A.XCH_RANK = 1 /*CURR_CD의 Last YRMON*/" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT 2 AS GUBUN" ).append("\n"); 
		query.append("                     , A.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                             , A.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("                             , A.CURR_CD" ).append("\n"); 
		query.append("                             , A.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(PARTITION BY A.CURR_CD ORDER BY A.ACCT_XCH_RT_YRMON DESC) XCH_RANK" ).append("\n"); 
		query.append("                          FROM GL_MON_XCH_RT A" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("                           AND A.CURR_CD = NVL(@[to_curr_cd],@[fr_curr_cd])" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                 WHERE A.XCH_RANK = 1 /*CURR_CD의 Last YRMON*/" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("--SELECT * FROM V_TO_MON_XCH_RT;        " ).append("\n"); 
		query.append("    , V_MDM_CURRENCY AS (" ).append("\n"); 
		query.append("       SELECT MAX(DECODE(B.CURR_CD, 'USD', 'USD'))             CURR_USD           " ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, 'USD', B.DP_PRCS_KNT))     DP_USD" ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, @[fr_curr_cd], @[fr_curr_cd]))             FR_CURR_LOCAL" ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, @[fr_curr_cd], B.DP_PRCS_KNT))     FR_DP_LOCAL " ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, NVL(@[to_curr_cd],@[fr_curr_cd]), NVL(@[to_curr_cd],@[fr_curr_cd])))             TO_CURR_LOCAL" ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, NVL(@[to_curr_cd],@[fr_curr_cd]), B.DP_PRCS_KNT))     TO_DP_LOCAL " ).append("\n"); 
		query.append("        FROM   MDM_CURRENCY  B" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    B.CURR_CD IN (@[fr_curr_cd], 'USD', NVL(@[to_curr_cd],@[fr_curr_cd])) " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("--SELECT * FROM V_MDM_CURRENCY;        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CASE WHEN 'Local2USD' = @[div] THEN ROUND(@[amt] / FR.USD_LOCL_XCH_RT, MC.DP_USD)" ).append("\n"); 
		query.append("            WHEN 'USD2Local' = @[div] THEN ROUND(@[amt] * FR.USD_LOCL_XCH_RT, MC.FR_DP_LOCAL)" ).append("\n"); 
		query.append("            WHEN 'Local2Local' = @[div] THEN  ROUND( ROUND(@[amt] / FR.USD_LOCL_XCH_RT, MC.DP_USD) * TR.USD_LOCL_XCH_RT, MC.TO_DP_LOCAL)" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS AMT" ).append("\n"); 
		query.append("     , CASE WHEN 'Local2USD' = @[div] OR 'USD2Local' = @[div] THEN '1 USD = ' || FR.USD_LOCL_XCH_RT ||' '|| MC.FR_CURR_LOCAL" ).append("\n"); 
		query.append("            WHEN 'Local2Local' = @[div] THEN  FR.USD_LOCL_XCH_RT ||' '|| MC.FR_CURR_LOCAL || ' = 1 USD = ' || TR.USD_LOCL_XCH_RT ||' '|| MC.TO_CURR_LOCAL" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS XCH" ).append("\n"); 
		query.append("  FROM V_MDM_CURRENCY MC" ).append("\n"); 
		query.append("     , V_FR_MON_XCH_RT FR" ).append("\n"); 
		query.append("     , V_TO_MON_XCH_RT TR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 

	}
}