/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.04.28 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see 
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtDBDAOSearchCurrencyByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 오피스별 로컬 통화코드 취득
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchCurrencyByOfficeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT DISTINCT LOCL_CURR_CD" ).append("\n"); 
		query.append("FROM GEM_OFFICE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND LOCL_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LOCL_CURR_CD NOT IN (" ).append("\n"); 
		query.append("#foreach($key IN ${locl_curr_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $locl_curr_cd.size()) '$key',  #else '$key' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY LOCL_CURR_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchCurrencyByOfficeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}