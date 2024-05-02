/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchMonthlyQtaStatusInquiryStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
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

public class CommonDBDAOSearchMonthlyQtaStatusInquiryStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchMonthlyQtaStatusInquiryStsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMonthlyQtaStatusInquiryStsListRSQL").append("\n"); 
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
		query.append("SELECT					" ).append("\n"); 
		query.append("    CODE, 				" ).append("\n"); 
		query.append("    TEXT				" ).append("\n"); 
		query.append("FROM					" ).append("\n"); 
		query.append("    (					" ).append("\n"); 
		query.append("    SELECT '0' AS CODE,		" ).append("\n"); 
		query.append("	   ' ' AS TEXT		" ).append("\n"); 
		query.append("    FROM DUAL       			" ).append("\n"); 
		query.append("    UNION ALL				" ).append("\n"); 
		query.append("    SELECT 				" ).append("\n"); 
		query.append("	TO_CHAR(INTG_CD_VAL_DP_SEQ) AS  CODE,	" ).append("\n"); 
		query.append("	INTG_CD_VAL_DP_DESC AS TEXT			" ).append("\n"); 
		query.append("    					" ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL		" ).append("\n"); 
		query.append("    					" ).append("\n"); 
		query.append("    WHERE 				" ).append("\n"); 
		query.append("	INTG_CD_ID = 'CD01213'			" ).append("\n"); 
		query.append("    )					" ).append("\n"); 
		query.append("    					" ).append("\n"); 
		query.append("ORDER BY				" ).append("\n"); 
		query.append("    code 	" ).append("\n"); 

	}
}