/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DefaultCurrDBDAOVerifyCurrencyCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.10.09 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DefaultCurrDBDAOVerifyCurrencyCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * verifyCurrencyCode
	  * </pre>
	  */
	public DefaultCurrDBDAOVerifyCurrencyCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration").append("\n"); 
		query.append("FileName : DefaultCurrDBDAOVerifyCurrencyCodeRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(CURR_CD) - $curr_cd_arr.size(),0,'N','Y') AS ERR_FLG" ).append("\n"); 
		query.append("  FROM MDM_CURRENCY" ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${curr_cd_arr} != '')" ).append("\n"); 
		query.append("AND CURR_CD IN (" ).append("\n"); 
		query.append("    #foreach ($curr_cd_arr_num IN ${curr_cd_arr})" ).append("\n"); 
		query.append("        #if($velocityCount < $curr_cd_arr.size())" ).append("\n"); 
		query.append("          '$curr_cd_arr_num'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$curr_cd_arr_num'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}