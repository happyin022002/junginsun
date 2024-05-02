/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchSeasonalSMUCostPopListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2012.06.04 김성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SUNG-HUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchSeasonalSMUCostPopListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.31 SHKIM
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchSeasonalSMUCostPopListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchSeasonalSMUCostPopListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     TRD_CD" ).append("\n"); 
		query.append("	,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM COA_LANE_DIR_CONV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}