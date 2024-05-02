/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LocationDBDAOsearchDyLgtSavTmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOsearchDyLgtSavTmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DayLight Saving Time을 조회합니다.
	  * </pre>
	  */
	public LocationDBDAOsearchDyLgtSavTmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dst_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOsearchDyLgtSavTmRSQL").append("\n"); 
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
		query.append("SELECT DST_ID," ).append("\n"); 
		query.append("       DST_CNT_CD," ).append("\n"); 
		query.append("       DST_NOT_APLY_STE_CD," ).append("\n"); 
		query.append("       DST_YR," ).append("\n"); 
		query.append("       DST_MNTS," ).append("\n"); 
		query.append("       ST_DST_RULE_DESC," ).append("\n"); 
		query.append("       END_DST_RULE_DESC," ).append("\n"); 
		query.append("       ST_DST_DT," ).append("\n"); 
		query.append("       END_DST_DT," ).append("\n"); 
		query.append("       ST_DST_HRMNT," ).append("\n"); 
		query.append("       END_DST_HRMNT," ).append("\n"); 
		query.append("       DELT_FLG" ).append("\n"); 
		query.append("FROM MDM_DYLGT_SAV_TM" ).append("\n"); 
		query.append("WHERE DST_ID = @[dst_id]" ).append("\n"); 

	}
}