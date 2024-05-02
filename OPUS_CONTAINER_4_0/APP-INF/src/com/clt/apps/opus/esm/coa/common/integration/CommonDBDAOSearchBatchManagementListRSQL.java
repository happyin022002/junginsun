/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchBatchManagementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchBatchManagementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Batch Management 정보를 조회한다.
	  * </pre>
	  */
	public CommonDBDAOSearchBatchManagementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchBatchManagementListRSQL").append("\n"); 
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
		query.append("SELECT BAT_RCV_DT" ).append("\n"); 
		query.append("   	       , CALL_FM_SRC_ID" ).append("\n"); 
		query.append("   	       ,  BAT_DESC" ).append("\n"); 
		query.append("   	       , COUNT(0) TOTAL" ).append("\n"); 
		query.append("   	       , SUM(DECODE(BAT_FLG, 'Y', 1, 0)) COMPLETE" ).append("\n"); 
		query.append("           --, SUM(DECODE(NVL(BAT_FLG,'N'), 'N', 1, 0)) MISSING		" ).append("\n"); 
		query.append("           , NVL(COUNT(0),0) - NVL(SUM(DECODE(BAT_FLG, 'Y', 1, 0)),0) AS MISSING 	--20150522.ADD" ).append("\n"); 
		query.append("   	  FROM COA_CALC_BAT" ).append("\n"); 
		query.append("   	  GROUP BY BAT_RCV_DT, CALL_FM_SRC_ID, BAT_DESC" ).append("\n"); 
		query.append("   	  ORDER BY BAT_RCV_DT DESC, CALL_FM_SRC_ID ASC, BAT_DESC ASC" ).append("\n"); 

	}
}