/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevForSectorAddListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchQtaLoadRevForSectorAddListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ddd
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaLoadRevForSectorAddListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration ").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaLoadRevForSectorAddListRSQL").append("\n"); 
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
		query.append("       '' AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,'' AS BSE_YR" ).append("\n"); 
		query.append("      ,'' AS BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'' AS TRD_CD" ).append("\n"); 
		query.append("      ,'' AS SUB_TRD_CD" ).append("\n"); 
		query.append("      ,'' AS IAS_RGN_CD" ).append("\n"); 
		query.append("      ,'' AS RLANE_CD" ).append("\n"); 
		query.append("      ,'' AS PF_GRP_CD" ).append("\n"); 
		query.append("      ,'' AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("      ,'' AS USR_ID" ).append("\n"); 
		query.append("      ,'' AS PF_ROUT_DESC" ).append("\n"); 
		query.append("      ,'' AS F_FM_WK" ).append("\n"); 
		query.append("      ,'' AS F_TO_WK" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}