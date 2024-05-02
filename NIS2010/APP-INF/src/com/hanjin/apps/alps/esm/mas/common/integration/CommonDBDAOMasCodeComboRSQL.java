/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOMasCodeComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2014.12.15 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ock, KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOMasCodeComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MasCodeCombo
	  * </pre>
	  */
	public CommonDBDAOMasCodeComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOMasCodeComboRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" '1' AS CODE_ITEM" ).append("\n"); 
		query.append(",'1' AS CODE_ID" ).append("\n"); 
		query.append(",'1' AS CODE_INIT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}