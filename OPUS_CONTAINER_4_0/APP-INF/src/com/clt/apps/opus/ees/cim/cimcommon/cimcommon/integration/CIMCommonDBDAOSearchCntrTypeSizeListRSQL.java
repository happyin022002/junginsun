/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CIMCommonDBDAOSearchCntrTypeSizeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOSearchCntrTypeSizeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrType Select Query
	  * </pre>
	  */
	public CIMCommonDBDAOSearchCntrTypeSizeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ").append("\n"); 
		query.append("FileName : CIMCommonDBDAOSearchCntrTypeSizeListRSQL").append("\n"); 
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
		query.append("SELECT 	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM 	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE 	ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 

	}
}