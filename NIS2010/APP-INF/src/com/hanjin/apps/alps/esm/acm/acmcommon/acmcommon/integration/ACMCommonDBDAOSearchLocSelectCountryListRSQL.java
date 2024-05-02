/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOSearchLocSelectCountryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.30 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOSearchLocSelectCountryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLocSelectCountryList
	  * </pre>
	  */
	public ACMCommonDBDAOSearchLocSelectCountryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration").append("\n"); 
		query.append("FileName : ACMCommonDBDAOSearchLocSelectCountryListRSQL").append("\n"); 
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
		query.append("    SELECT" ).append("\n"); 
		query.append("           '0' AS CHECKBOX," ).append("\n"); 
		query.append("           CNT_CD," ).append("\n"); 
		query.append("           CNT_NM" ).append("\n"); 
		query.append("      FROM MDM_COUNTRY" ).append("\n"); 
		query.append("     WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("       AND SCONTI_CD" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("#if( '' != ${sconti_cd})" ).append("\n"); 
		query.append("           ${sconti_cd}" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  ORDER BY CNT_CD" ).append("\n"); 

	}
}