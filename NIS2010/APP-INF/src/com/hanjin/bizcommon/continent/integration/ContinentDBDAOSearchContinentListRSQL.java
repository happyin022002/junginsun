/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContinentDBDAOSearchContinentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.06 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.continent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContinentDBDAOSearchContinentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Continent의 모든 목록을 가져온다.
	  * </pre>
	  */
	public ContinentDBDAOSearchContinentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.continent.integration").append("\n"); 
		query.append("FileName : ContinentDBDAOSearchContinentListRSQL").append("\n"); 
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
		query.append("SELECT conti_cd," ).append("\n"); 
		query.append("conti_nm" ).append("\n"); 
		query.append("FROM mdm_continent" ).append("\n"); 
		query.append("WHERE 1 = 1 AND nvl(delt_flg,'N') <> 'Y'" ).append("\n"); 

	}
}