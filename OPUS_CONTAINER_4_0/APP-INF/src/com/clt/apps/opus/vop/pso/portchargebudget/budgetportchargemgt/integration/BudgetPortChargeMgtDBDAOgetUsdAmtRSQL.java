/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOgetUsdAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOgetUsdAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getUsdAmt
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOgetUsdAmtRSQL(){
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
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOgetUsdAmtRSQL").append("\n"); 
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
		query.append("select sum(decode(flg, 1, ttl_usd_amt))||'|'||sum(decode(flg, 2, ttl_usd_amt)) TTL_USD_AMT from " ).append("\n"); 
		query.append("(   " ).append("\n"); 
		query.append("SELECT  1 flg,  ROUND (@[locl_amt] / USD_LOCL_XCH_RT, 2) TTL_USD_AMT" ).append("\n"); 
		query.append("  FROM   GL_MON_XCH_RT" ).append("\n"); 
		query.append(" WHERE       ACCT_XCH_RT_LVL = @[type]--'1'" ).append("\n"); 
		query.append("         AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("         AND ACCT_XCH_RT_YRMON = DECODE(@[type],1, substr(replace(@[iss_dt], '-', ''), 1, 6), (SELECT max(EXE_YRMON) FROM GL_ESTM_REV_VVD) )" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT  2 flg,   ROUND (@[locl_amt]  / USD_LOCL_XCH_RT, 2) TTL_USD_AMT" ).append("\n"); 
		query.append("  FROM   GL_MON_XCH_RT" ).append("\n"); 
		query.append(" WHERE       ACCT_XCH_RT_LVL = @[type]--'1'" ).append("\n"); 
		query.append("         AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("         AND ACCT_XCH_RT_YRMON = TO_CHAR (SYSDATE, 'yyyymm')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}