/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * xx
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSqlNameRSQL").append("\n"); 
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
		query.append("SELECT '' STD" ).append("\n"); 
		query.append("	, '' CNT" ).append("\n"); 
		query.append("	, '' CUS" ).append("\n"); 
		query.append("	, '' RMK" ).append("\n"); 
		query.append("	, '' POR_CD" ).append("\n"); 
		query.append("	, '' POD_CD" ).append("\n"); 
		query.append("	, '' POL_CD" ).append("\n"); 
		query.append("	, '' DEL_CD" ).append("\n"); 
		query.append("	, '' BKG_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}