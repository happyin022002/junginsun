/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USD 통화를 제외한 환율 변환 금액을 구하기 위함 
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bcurr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherRSQL").append("\n"); 
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
		query.append("SELECT AMT,  CASE WHEN AMT <> 0 THEN '1 '||@[curr_cd] ||' = '|| ROUND(@[amt] / AMT,2) ||' '|| @[bcurr_cd]" ).append("\n"); 
		query.append("                  ELSE NULL  " ).append("\n"); 
		query.append("             END," ).append("\n"); 
		query.append("       CASE WHEN AMT <> 0 THEN ROUND(@[amt] / AMT,2)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("            END " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("  WITH AMT_USD AS (" ).append("\n"); 
		query.append("   SELECT ROUND(@[amt] / A.USD_LOCL_XCH_RT, DP_USD) AMT" ).append("\n"); 
		query.append("     FROM GL_MON_XCH_RT A ,(SELECT MAX(DECODE(B.CURR_CD, 'USD', B.DP_PRCS_KNT))  DP_USD" ).append("\n"); 
		query.append("                              FROM MDM_CURRENCY  B" ).append("\n"); 
		query.append("                             WHERE B.CURR_CD IN ( @[bcurr_cd], 'USD')) B " ).append("\n"); 
		query.append("    WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(@[dt], 1, 6)" ).append("\n"); 
		query.append("      AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("      AND A.CURR_CD =  @[bcurr_cd]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT ROUND(@[amt] / A.USD_LOCL_XCH_RT, DP_USD) AMT" ).append("\n"); 
		query.append("      FROM GL_MON_XCH_RT A,(SELECT MAX(DECODE(B.CURR_CD, 'USD', B.DP_PRCS_KNT)) DP_USD" ).append("\n"); 
		query.append("                              FROM MDM_CURRENCY  B" ).append("\n"); 
		query.append("                             WHERE B.CURR_CD IN ( @[bcurr_cd], 'USD')  ) B " ).append("\n"); 
		query.append("     WHERE A.ACCT_XCH_RT_YRMON = SUBSTR((SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT), 1, 6)" ).append("\n"); 
		query.append("       AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("       AND A.CURR_CD = @[bcurr_cd] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ROUND(C.AMT * A.USD_LOCL_XCH_RT, DP_LOCAL) AMT" ).append("\n"); 
		query.append("  FROM GL_MON_XCH_RT A,(SELECT MAX(DECODE(B.CURR_CD, @[curr_cd], B.DP_PRCS_KNT)) DP_LOCAL " ).append("\n"); 
		query.append("                          FROM MDM_CURRENCY  B" ).append("\n"); 
		query.append("                         WHERE B.CURR_CD IN (@[curr_cd], 'USD')) B , AMT_USD C" ).append("\n"); 
		query.append("  WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(@[dt], 1, 6)" ).append("\n"); 
		query.append("    AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("    AND A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ROUND(C.AMT * A.USD_LOCL_XCH_RT, DP_LOCAL) AMT" ).append("\n"); 
		query.append("  FROM GL_MON_XCH_RT A ,(SELECT MAX(DECODE(B.CURR_CD, @[curr_cd], B.DP_PRCS_KNT)) DP_LOCAL " ).append("\n"); 
		query.append("                           FROM MDM_CURRENCY  B" ).append("\n"); 
		query.append("                          WHERE B.CURR_CD IN (@[curr_cd], 'USD') ) B ,AMT_USD C " ).append("\n"); 
		query.append(" WHERE A.ACCT_XCH_RT_YRMON = SUBSTR((SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT), 1, 6)" ).append("\n"); 
		query.append("   AND A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("   AND A.CURR_CD = @[curr_cd] )" ).append("\n"); 

	}
}