/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedCargoAuthorizerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOSearchUncollectedCargoAuthorizerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT  Authorizer
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedCargoAuthorizerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration ").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedCargoAuthorizerRSQL").append("\n"); 
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
		query.append("SELECT A.UC_AUTH_OFC_CD" ).append("\n"); 
		query.append("     , A.UC_AUTH_USR_ID" ).append("\n"); 
		query.append("     , B.USR_NM" ).append("\n"); 
		query.append("FROM   CIM_UC_CGO_AUTH A" ).append("\n"); 
		query.append("     , COM_USER B" ).append("\n"); 
		query.append("WHERE  A.UC_AUTH_USR_ID = B.USR_ID" ).append("\n"); 

	}
}