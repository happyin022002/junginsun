/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOTrimCurrencyAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.10 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOTrimCurrencyAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trimCurrencyAmount
	  * </pre>
	  */
	public DMTCalculationDBDAOTrimCurrencyAmountRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("#if (${type} == '1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	TRUNC( @[amt] ) tmp_amt" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${type} == '2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	ROUND( @[amt] ) tmp_amt" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${type} == '3')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	ROUND( @[amt] , 2 ) tmp_amt" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOTrimCurrencyAmountRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}