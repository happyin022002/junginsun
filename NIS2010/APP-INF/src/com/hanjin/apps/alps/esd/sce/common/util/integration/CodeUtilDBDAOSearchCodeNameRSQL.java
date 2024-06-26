/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CodeUtilDBDAOSearchCodeNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.30
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.06.30 채창호
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

public class CodeUtilDBDAOSearchCodeNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TABLE select  구문을 만든다.
	  * </pre>
	  */
	public CodeUtilDBDAOSearchCodeNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codevalue",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.util.integration").append("\n"); 
		query.append("FileName : CodeUtilDBDAOSearchCodeNameRSQL").append("\n"); 
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
		query.append("SELECT  ${valuefield}" ).append("\n"); 
		query.append("FROM ${tablefield}" ).append("\n"); 
		query.append("#if(${wherefield} != '')" ).append("\n"); 
		query.append("WHERE ${wherefield} = @[codevalue]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}