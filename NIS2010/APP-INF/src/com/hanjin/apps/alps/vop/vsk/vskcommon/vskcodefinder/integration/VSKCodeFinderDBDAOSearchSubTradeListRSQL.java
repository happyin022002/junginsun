/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchSubTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.16
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.08.16 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchSubTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub Trade 정보를 조회합니다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchSubTradeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchSubTradeListRSQL").append("\n"); 
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
		query.append("SELECT SUB_TRD_CD||':'||SUB_TRD_NM SUB_TRD_CD" ).append("\n"); 
		query.append("FROM MDM_SUB_TRD" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 

	}
}