/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeUtilDAOSearchCodeComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.20 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.util.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeUtilDAOSearchCodeComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select code
	  * </pre>
	  */
	public CodeUtilDAOSearchCodeComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.util.integration").append("\n"); 
		query.append("FileName : CodeUtilDAOSearchCodeComboRSQL").append("\n"); 
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
		query.append("SELECT  ${valuefield} ," ).append("\n"); 
		query.append("${textfield}" ).append("\n"); 
		query.append("FROM ${tablefield}" ).append("\n"); 
		query.append("#if(${wherefield} != '')" ).append("\n"); 
		query.append("WHERE ${wherefield}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${orderbyfield} != '')" ).append("\n"); 
		query.append("ORDER BY ${orderbyfield}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}