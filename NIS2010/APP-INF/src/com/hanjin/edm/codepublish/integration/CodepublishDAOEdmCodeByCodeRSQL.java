/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodepublishDAOEdmCodeByCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.edm.codepublish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodepublishDAOEdmCodeByCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select edm code list
	  * </pre>
	  */
	public CodepublishDAOEdmCodeByCodeRSQL(){
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
		query.append("SELECT a.codeid," ).append("\n"); 
		query.append("a.NAME," ).append("\n"); 
		query.append("a.definition," ).append("\n"); 
		query.append("a.var2," ).append("\n"); 
		query.append("a.datatype," ).append("\n"); 
		query.append("a.precision," ).append("\n"); 
		query.append("a.var1," ).append("\n"); 
		query.append("a.var3," ).append("\n"); 
		query.append("a.var5" ).append("\n"); 
		query.append("FROM t_codedomain a" ).append("\n"); 
		query.append("WHERE A.CODEID IN (" ).append("\n"); 
		query.append("#foreach($key IN ${codes})" ).append("\n"); 
		query.append("#if($velocityCount < $codes.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.edm.codepublish.integration ").append("\n"); 
		query.append("FileName : CodepublishDAOEdmCodeByCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}