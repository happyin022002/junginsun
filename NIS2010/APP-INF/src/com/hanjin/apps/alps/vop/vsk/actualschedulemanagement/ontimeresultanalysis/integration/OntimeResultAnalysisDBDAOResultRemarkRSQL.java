/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OntimeResultAnalysisDBDAOResultRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.08.27 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OntimeResultAnalysisDBDAOResultRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OntimeResultAnalysisDBDAOResultRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OntimeResultAnalysisDBDAOResultRemarkRSQL").append("\n"); 
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
		query.append("SELECT  '' AS VVD" ).append("\n"); 
		query.append(", '' AS VPS_PORT_CD" ).append("\n"); 
		query.append(", '' AS REASON_PORT" ).append("\n"); 
		query.append(", '' AS ARR_DEP" ).append("\n"); 
		query.append(", '' AS RSN_CD" ).append("\n"); 
		query.append(", '' AS DELAY_TM" ).append("\n"); 
		query.append(", '' AS RMK" ).append("\n"); 
		query.append(", '' AS FM_DT" ).append("\n"); 
		query.append(", '' AS TO_DT" ).append("\n"); 
		query.append(", '' AS IG_FLG" ).append("\n"); 
		query.append(", '' AS VSL_SLAN_CD" ).append("\n"); 
		query.append(", '' AS VSL_CD" ).append("\n"); 
		query.append(", '' AS CRR_CD" ).append("\n"); 
		query.append(", '' AS TAB_FLG" ).append("\n"); 
		query.append(", '' AS GRP_FLG" ).append("\n"); 
		query.append(", '' AS CONDITION" ).append("\n"); 
		query.append(", '' AS USR_ID" ).append("\n"); 
		query.append(", '' AS LANE_GRP_NM" ).append("\n"); 
		query.append(", '' AS IE_FLG" ).append("\n"); 
		query.append(", '' AS PORT_SKP_TP_CD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}