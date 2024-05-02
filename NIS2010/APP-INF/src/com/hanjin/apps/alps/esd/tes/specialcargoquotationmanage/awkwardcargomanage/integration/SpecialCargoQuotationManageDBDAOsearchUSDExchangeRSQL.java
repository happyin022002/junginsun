/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchUSDExchangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchUSDExchangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USD Exchange for 20ft, 40ft
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchUSDExchangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("man_locl_amt_40ft",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("man_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("man_locl_amt_20ft",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchUSDExchangeRSQL").append("\n"); 
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
		query.append("SELECT ROUND(NVL(NVL(@[man_locl_amt_20ft],1)/NVL(G.USD_LOCL_XCH_RT,1),1),2) man_usd_amt_20ft," ).append("\n"); 
		query.append("ROUND(NVL(NVL(@[man_locl_amt_40ft],1)/NVL(G.USD_LOCL_XCH_RT,1),1),2) man_usd_amt_40ft" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT G, (" ).append("\n"); 
		query.append("SELECT MAX(X.ACCT_XCH_RT_YRMON) ACCT_XCH_RT_YRMON, X.ACCT_XCH_RT_LVL, X.CURR_CD" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.ACCT_XCH_RT_YRMON >= '1'" ).append("\n"); 
		query.append("AND X.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("AND X.CURR_CD = @[man_locl_curr_cd]" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("GROUP BY X.CURR_CD, X.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND G.ACCT_XCH_RT_YRMON >= '1'" ).append("\n"); 
		query.append("AND G.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("AND G.CURR_CD = @[man_locl_curr_cd]" ).append("\n"); 
		query.append("AND G.ACCT_XCH_RT_YRMON = X.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("AND G.ACCT_XCH_RT_LVL = X.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("AND G.CURR_CD = X.CURR_CD" ).append("\n"); 

	}
}