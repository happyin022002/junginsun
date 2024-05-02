/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WeeklyCMDBDAOIsLaneRgstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.03.25 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOIsLaneRgstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsLaneRgst SELECT
	  * </pre>
	  */
	public WeeklyCMDBDAOIsLaneRgstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOIsLaneRgstRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("   FROM MAS_LANE_RGST" ).append("\n"); 
		query.append("  WHERE RLANE_CD || DIR_CD || TRD_CD || IOC_CD" ).append("\n"); 
		query.append("            IN (" ).append("\n"); 
		query.append("                #set($count = 0)" ).append("\n"); 
		query.append("                #foreach(${keys} IN ${keyList})" ).append("\n"); 
		query.append("                   #if (${count} == 0)" ).append("\n"); 
		query.append("                     '$keys'" ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                     ,'$keys'" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #set($count = $count + 1)" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}