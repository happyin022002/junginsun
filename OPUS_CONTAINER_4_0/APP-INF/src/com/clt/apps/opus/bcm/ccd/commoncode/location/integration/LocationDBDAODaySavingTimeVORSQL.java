/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LocationDBDAODaySavingTimeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
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

public class LocationDBDAODaySavingTimeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public LocationDBDAODaySavingTimeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration ").append("\n"); 
		query.append("FileName : LocationDBDAODaySavingTimeVORSQL").append("\n"); 
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
		query.append("SELECT 'DST_ID' DST_ID," ).append("\n"); 
		query.append("       'DST_CNT_CD' DST_CNT_CD," ).append("\n"); 
		query.append("       'DST_NOT_APLY_STE_CD' DST_NOT_APLY_STE_CD," ).append("\n"); 
		query.append("       'DST_YR' DST_YR," ).append("\n"); 
		query.append("       'DST_MNTS' DST_MNTS," ).append("\n"); 
		query.append("       'ST_DST_RULE_DESC' ST_DST_RULE_DESC," ).append("\n"); 
		query.append("       'END_DST_RULE_DESC' END_DST_RULE_DESC," ).append("\n"); 
		query.append("       'ST_DST_DT' ST_DST_DT," ).append("\n"); 
		query.append("       'END_DST_DT' END_DST_DT," ).append("\n"); 
		query.append("       'ST_DST_HRMNT' ST_DST_HRMNT," ).append("\n"); 
		query.append("       'END_DST_HRMNT' END_DST_HRMNT," ).append("\n"); 
		query.append("       'DELT_FLG' DELT_FLG," ).append("\n"); 
		query.append("       'USR_ID' USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}