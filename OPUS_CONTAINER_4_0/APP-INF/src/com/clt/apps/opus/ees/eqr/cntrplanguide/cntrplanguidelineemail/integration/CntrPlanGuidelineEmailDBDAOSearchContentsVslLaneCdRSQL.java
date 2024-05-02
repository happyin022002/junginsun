/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailDBDAOSearchContentsVslLaneCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineEmailDBDAOSearchContentsVslLaneCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가장 최근된 guideline lane 검색(복수개가 나올수도 있음)
	  * </pre>
	  */
	public CntrPlanGuidelineEmailDBDAOSearchContentsVslLaneCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineEmailDBDAOSearchContentsVslLaneCdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.VSL_LANE_CD" ).append("\n"); 
		query.append("FROM EQR_CTRL_GLINE_HDR A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("         -- 가장 최근 CONFIRM 날짜" ).append("\n"); 
		query.append("         SELECT MAX(UPD_DT) MAX_UPD_DT  " ).append("\n"); 
		query.append("         FROM EQR_CTRL_GLINE_HDR" ).append("\n"); 
		query.append("         WHERE CFM_FLG = 'Y'  -- CONFIRM" ).append("\n"); 
		query.append("     ) B" ).append("\n"); 
		query.append("WHERE A.UPD_DT = B.MAX_UPD_DT" ).append("\n"); 
		query.append("AND   A.CFM_FLG = 'Y'" ).append("\n"); 

	}
}