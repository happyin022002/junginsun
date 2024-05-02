/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContinentDBDAOTotalContinentRSQL.java
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.05.22 정인선
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.continent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung In Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContinentDBDAOTotalContinentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Continent의 총 카운트를 조회한다.
	  * </pre>
	  */
	public ContinentDBDAOTotalContinentRSQL(){
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM mdm_continent" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(delt_flg, 'N') <> 'Y'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.continent.integration").append("\n"); 
		query.append("FileName : ContinentDBDAOTotalContinentRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}