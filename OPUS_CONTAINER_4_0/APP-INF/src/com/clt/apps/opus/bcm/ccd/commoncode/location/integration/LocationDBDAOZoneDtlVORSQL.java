/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LocationDBDAOZoneDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOZoneDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public LocationDBDAOZoneDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration ").append("\n"); 
		query.append("FileName : LocationDBDAOZoneDtlVORSQL").append("\n"); 
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
		query.append("'ZN_CD' ZN_CD," ).append("\n"); 
		query.append("'ZN_SEQ' ZN_SEQ," ).append("\n"); 
		query.append("'ZIP_CD' ZIP_CD," ).append("\n"); 
		query.append("'DSTR_NM' DSTR_NM," ).append("\n"); 
		query.append("'DELT_FLG' DELT_FLG," ).append("\n"); 
		query.append("'USR_ID' USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}