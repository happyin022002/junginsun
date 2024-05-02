/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015-12-10 항상 다음분기 값을 가져오도록 변경
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthListRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(ADD_MONTHS(SYSDATE, 3),'YYYY') || TO_CHAR(ADD_MONTHS(SYSDATE, 3), 'Q') || 'Q' AS CODE" ).append("\n"); 
		query.append("      , TO_CHAR(ADD_MONTHS(SYSDATE, 3),'YYYY') || TO_CHAR(ADD_MONTHS(SYSDATE, 3), 'Q') || 'Q' AS TEXT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}