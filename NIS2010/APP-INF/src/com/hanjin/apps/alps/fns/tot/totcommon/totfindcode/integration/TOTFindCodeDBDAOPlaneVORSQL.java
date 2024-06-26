/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TOTFindCodeDBDAOPlaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.12 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TOTFindCodeDBDAOPlaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * lane combo list 조회
	  * </pre>
	  */
	public TOTFindCodeDBDAOPlaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration").append("\n"); 
		query.append("FileName : TOTFindCodeDBDAOPlaneVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SLAN_CD CODE" ).append("\n"); 
		query.append("FROM AR_FINC_DIR_CONV " ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SLAN_CD" ).append("\n"); 

	}
}