/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LseCommonDBDAOSearchServiceLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.28 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOSearchServiceLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel SVC Lane 목록을 조회합니다.
	  * </pre>
	  */
	public LseCommonDBDAOSearchServiceLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration").append("\n"); 
		query.append("FileName : LseCommonDBDAOSearchServiceLaneRSQL").append("\n"); 
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
		query.append("SELECT  VSL_SLAN_CD, VSL_SLAN_NM," ).append("\n"); 
		query.append("        VSL_SVC_TP_CD, CO_CD" ).append("\n"); 
		query.append("FROM    MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     VSL_SLAN_CD = @[slan_cd]" ).append("\n"); 

	}
}