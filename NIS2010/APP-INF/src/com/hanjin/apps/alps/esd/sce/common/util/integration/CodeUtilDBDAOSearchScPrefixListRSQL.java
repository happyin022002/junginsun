/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CodeUtilDBDAOSearchScPrefixListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.02
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.01.02 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.util.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeUtilDBDAOSearchScPrefixListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC NO를 가져오기
	  * </pre>
	  */
	public CodeUtilDBDAOSearchScPrefixListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.util.integration").append("\n"); 
		query.append("FileName : CodeUtilDBDAOSearchScPrefixListRSQL").append("\n"); 
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
		query.append("SELECT SC_PFX_CD   AS CD" ).append("\n"); 
		query.append(",SC_PFX_DESC AS NM" ).append("\n"); 
		query.append("FROM PRI_SC_PFX" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SC_PFX_CD IN ('AEF','AEN','ANW','ASE','ASW','AWE','AWN','GLO','SAN','SAS','CEN','ANW','CEF','MME')" ).append("\n"); 
		query.append("ORDER BY SC_PFX_CD" ).append("\n"); 

	}
}