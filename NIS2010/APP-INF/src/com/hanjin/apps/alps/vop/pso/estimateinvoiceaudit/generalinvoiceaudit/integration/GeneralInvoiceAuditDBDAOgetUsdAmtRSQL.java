/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetUsdAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.10.20 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetUsdAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getUsdAmt
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetUsdAmtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetUsdAmtRSQL").append("\n"); 
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
		query.append("select sum(decode(flg, 1, ttl_usd_amt))||'|'||sum(decode(flg, 2, ttl_usd_amt)) TTL_USD_AMT from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  1 flg,  ROUND (@[locl_amt] / USD_LOCL_XCH_RT, 2) TTL_USD_AMT" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE       ACCT_XCH_RT_LVL = @[type]--'1'" ).append("\n"); 
		query.append("AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("AND ACCT_XCH_RT_YRMON = substr(replace(@[iss_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT  2 flg,   ROUND (@[locl_amt]  / USD_LOCL_XCH_RT, 2) TTL_USD_AMT" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE       ACCT_XCH_RT_LVL = @[type]--'1'" ).append("\n"); 
		query.append("AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("AND ACCT_XCH_RT_YRMON = TO_CHAR (SYSDATE, 'yyyymm')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}