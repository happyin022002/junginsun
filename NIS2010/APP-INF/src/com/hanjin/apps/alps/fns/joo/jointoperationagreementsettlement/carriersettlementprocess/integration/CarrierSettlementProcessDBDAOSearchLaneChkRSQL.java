/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchLaneChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.02.06 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchLaneChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane이  적합한지 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchLaneChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchLaneChkRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(WM_CONCAT(LANE),NULL,'Y',WM_CONCAT(LANE)) AS LANE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    AA.LANE" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("         A.LANE" ).append("\n"); 
		query.append("        ,DECODE(A.LANE, M.VSL_SLAN_CD,1,0) AS LANE_YN_CNT" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			#foreach( ${key} in ${arrLane})" ).append("\n"); 
		query.append("				#if($velocityCount == $arrLane.size())" ).append("\n"); 
		query.append("					SELECT '${key}' AS LANE FROM DUAL" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				 	SELECT '${key}' AS LANE FROM DUAL UNION ALL" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        ) A, MDM_VSL_SVC_LANE M" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.LANE = M.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("    ) AA" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND AA.LANE_YN_CNT != 1" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 

	}
}