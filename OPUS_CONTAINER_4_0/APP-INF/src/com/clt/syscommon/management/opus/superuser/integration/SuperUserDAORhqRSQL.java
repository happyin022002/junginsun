/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SuperUserDAOSubSystemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.01 
* 1.0 Creation
=========================================================*/
package com.clt.syscommon.management.opus.superuser.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SuperUserDAORhqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sub system code query
	  * </pre>
	  */
	public SuperUserDAORhqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.syscommon.management.opus.superuser.integration").append("\n"); 
		query.append("FileName : SuperUserDAORhqRSQL").append("\n"); 
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
		query.append("select OFC_CD rhq" ).append("\n"); 
		query.append("from mdm_organization" ).append("\n"); 
		query.append("where ofc_knd_cd = 2" ).append("\n"); 
	}
}