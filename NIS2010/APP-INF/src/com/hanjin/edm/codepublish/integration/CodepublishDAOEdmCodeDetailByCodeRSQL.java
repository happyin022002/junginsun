/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodepublishDAOEdmCodeDetailByCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.edm.codepublish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodepublishDAOEdmCodeDetailByCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edm detail code select
	  * </pre>
	  */
	public CodepublishDAOEdmCodeDetailByCodeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT   a.codeid," ).append("\n"); 
		query.append("b.codeid AS KEY," ).append("\n"); 
		query.append("b.NAME AS VALUE," ).append("\n"); 
		query.append("b.description," ).append("\n"); 
		query.append("b.codeorder," ).append("\n"); 
		query.append("b.begindate," ).append("\n"); 
		query.append("b.enddate" ).append("\n"); 
		query.append("FROM t_codedomain a, t_codevalue b" ).append("\n"); 
		query.append("WHERE a.ID = b.ID" ).append("\n"); 
		query.append("AND a.codeid IN (" ).append("\n"); 
		query.append("#foreach($key IN ${codes})" ).append("\n"); 
		query.append("#if($velocityCount < $codes.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY a.codeid, b.codeorder" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.edm.codepublish.integration").append("\n"); 
		query.append("FileName : CodepublishDAOEdmCodeDetailByCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}