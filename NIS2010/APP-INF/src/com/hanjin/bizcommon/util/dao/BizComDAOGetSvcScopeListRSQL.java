/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BizComDAOGetSvcScopeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.util.dao;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BizComDAOGetSvcScopeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetSvcScopeList
	  * </pre>
	  */
	public BizComDAOGetSvcScopeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.util.dao").append("\n"); 
		query.append("FileName : BizComDAOGetSvcScopeListRSQL").append("\n"); 
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
		query.append("SELECT (100000 + (rownum * 10) ) as sortKey ," ).append("\n"); 
		query.append("       T1.SVC_SCP_CD as code, T1.SVC_SCP_CD as name" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP_LMT T1, MDM_SVC_SCP_LMT T2" ).append("\n"); 
		query.append(" WHERE T1.ORG_DEST_CD = 'O'      " ).append("\n"); 
		query.append("   AND   T2.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("   AND   T1.SVC_SCP_CD = T2.SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${where} != '') " ).append("\n"); 
		query.append("AND ${where}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sortKey} > 0) " ).append("\n"); 
		query.append("ORDER BY ${sortKey}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}