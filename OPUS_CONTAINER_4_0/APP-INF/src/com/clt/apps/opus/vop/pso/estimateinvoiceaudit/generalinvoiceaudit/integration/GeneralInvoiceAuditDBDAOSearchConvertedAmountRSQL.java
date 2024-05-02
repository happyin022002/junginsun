/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchConvertedAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.14 
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

public class GeneralInvoiceAuditDBDAOSearchConvertedAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율변환된 금액 가져오기
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchConvertedAmountRSQL(){
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
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchConvertedAmountRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[div] " ).append("\n"); 
		query.append("             ,'Local2USD'" ).append("\n"); 
		query.append("             ,ROUND(@[amt] / A.USD_LOCL_XCH_RT, DP_USD)" ).append("\n"); 
		query.append("             ,'USD2Local'" ).append("\n"); 
		query.append("             ,ROUND(@[amt] * A.USD_LOCL_XCH_RT, DP_LOCAL)) AMT" ).append("\n"); 
		query.append("	  ,'1 USD = ' || A.USD_LOCL_XCH_RT ||' '|| B.CURR_LOCAL      XCH  " ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT A" ).append("\n"); 
		query.append("      ,(SELECT MAX(DECODE(B.CURR_CD, 'USD', 'USD'))              CURR_USD           " ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, 'USD', B.DP_PRCS_KNT))      DP_USD" ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, @[curr_cd], @[curr_cd]))    CURR_LOCAL" ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, @[curr_cd], B.DP_PRCS_KNT)) DP_LOCAL " ).append("\n"); 
		query.append("        FROM   MDM_CURRENCY  B" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    B.CURR_CD IN (@[curr_cd], 'USD')" ).append("\n"); 
		query.append("       ) B " ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.ACCT_XCH_RT_YRMON = SUBSTR(@[dt], 1, 6)" ).append("\n"); 
		query.append("AND    A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("AND    A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* 위쪽 쿼리에서는 해당 월의 환율을 사용하지만 만약 해당 환율이 입력되지 않았을 경우" ).append("\n"); 
		query.append("아래쪽 쿼리에 의해 가장 최근의 환율을 사용한다.*/" ).append("\n"); 
		query.append("SELECT DECODE(@[div] " ).append("\n"); 
		query.append("             ,'Local2USD'" ).append("\n"); 
		query.append("             ,ROUND(@[amt] / A.USD_LOCL_XCH_RT, DP_USD)" ).append("\n"); 
		query.append("             ,'USD2Local'" ).append("\n"); 
		query.append("             ,ROUND(@[amt] * A.USD_LOCL_XCH_RT, DP_LOCAL)) AMT" ).append("\n"); 
		query.append("	  ,'1 USD = ' || A.USD_LOCL_XCH_RT ||' '|| B.CURR_LOCAL      XCH  " ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT A" ).append("\n"); 
		query.append("      ,(SELECT MAX(DECODE(B.CURR_CD, 'USD', 'USD'))              CURR_USD           " ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, 'USD', B.DP_PRCS_KNT))      DP_USD" ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, @[curr_cd], @[curr_cd]))    CURR_LOCAL" ).append("\n"); 
		query.append("              ,MAX(DECODE(B.CURR_CD, @[curr_cd], B.DP_PRCS_KNT)) DP_LOCAL " ).append("\n"); 
		query.append("        FROM   MDM_CURRENCY  B" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    B.CURR_CD IN (@[curr_cd], 'USD')" ).append("\n"); 
		query.append("       ) B " ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.ACCT_XCH_RT_YRMON = SUBSTR((SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT), 1, 6)" ).append("\n"); 
		query.append("AND    A.ACCT_XCH_RT_LVL = 1  " ).append("\n"); 
		query.append("AND    A.CURR_CD = @[curr_cd]" ).append("\n"); 

	}
}