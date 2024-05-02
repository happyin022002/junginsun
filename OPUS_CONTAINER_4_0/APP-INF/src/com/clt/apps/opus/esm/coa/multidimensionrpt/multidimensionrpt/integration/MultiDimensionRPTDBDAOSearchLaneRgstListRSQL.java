/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchLaneRgstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.03.02 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchLaneRgstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P&L by Lane 헤더정보
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchLaneRgstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchLaneRgstListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT TRD_CD " ).append("\n"); 
		query.append("FROM COA_LANE_RGST " ).append("\n"); 

	}
}