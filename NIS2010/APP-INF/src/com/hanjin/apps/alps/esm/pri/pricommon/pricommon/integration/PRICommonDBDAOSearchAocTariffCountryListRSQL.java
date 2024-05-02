/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRICommonDBDAOSearchAocTariffCountryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSearchAocTariffCountryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AocTariffCountryList 조회
	  * </pre>
	  */
	public PRICommonDBDAOSearchAocTariffCountryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchAocTariffCountryListRSQL").append("\n"); 
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
		query.append("SELECT A1.CNT_CD	AS CD" ).append("\n"); 
		query.append("      ,A2.CNT_NM	AS NM" ).append("\n"); 
		query.append("FROM AOC_TRF_CURR A1" ).append("\n"); 
		query.append("    ,MDM_COUNTRY A2" ).append("\n"); 
		query.append("WHERE RHQ_CD IN ('HAMRU', 'NYCRA')" ).append("\n"); 
		query.append("  AND A1.CNT_CD = A2.CNT_CD" ).append("\n"); 

	}
}