/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BizComDAOGetContiListRSQL.java
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

public class BizComDAOGetContiListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetContiList
	  * </pre>
	  */
	public BizComDAOGetContiListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.util.dao").append("\n"); 
		query.append("FileName : BizComDAOGetContiListRSQL").append("\n"); 
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
		query.append("       CONTI_CD as code, CONTI_NM as name" ).append("\n"); 
		query.append("  FROM MDM_CONTINENT" ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND CONTI_CD NOT IN ('X', 'Y')" ).append("\n"); 
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