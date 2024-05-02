/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAOPriScqBbHandlingCstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.05.08 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOPriScqBbHandlingCstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriScqBbHandlingCstVO
	  * </pre>
	  */
	public ScqListDBDAOPriScqBbHandlingCstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration ").append("\n"); 
		query.append("FileName : ScqListDBDAOPriScqBbHandlingCstRSQL").append("\n"); 
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
		query.append("SELECT '' POL_SUM, '' POD_SUM, '' PROP_RT, '' APRO_RT" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}