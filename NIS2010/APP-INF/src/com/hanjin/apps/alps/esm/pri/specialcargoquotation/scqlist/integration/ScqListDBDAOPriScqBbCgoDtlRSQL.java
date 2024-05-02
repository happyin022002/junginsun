/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAOPriScqBbCgoDtlRSQL.java
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

public class ScqListDBDAOPriScqBbCgoDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriScqBbCgoDtlVO
	  * </pre>
	  */
	public ScqListDBDAOPriScqBbCgoDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration ").append("\n"); 
		query.append("FileName : ScqListDBDAOPriScqBbCgoDtlRSQL").append("\n"); 
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
		query.append("SELECT '' TTL_DIM_LEN," ).append("\n"); 
		query.append("       '' TTL_DIM_WDT," ).append("\n"); 
		query.append("       '' TTL_DIM_HGT," ).append("\n"); 
		query.append("       '' GRS_WGT" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}