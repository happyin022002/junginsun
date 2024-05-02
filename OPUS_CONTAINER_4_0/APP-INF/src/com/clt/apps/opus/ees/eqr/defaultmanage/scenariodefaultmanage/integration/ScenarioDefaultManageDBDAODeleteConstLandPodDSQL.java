/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAODeleteConstLandPodDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.03.17 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author chang Ho. chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAODeleteConstLandPodDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_PORT_DCHG_CNST테이블 특정 vsl lane, vsl location 의 데이터 삭제
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAODeleteConstLandPodDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAODeleteConstLandPodDSQL").append("\n"); 
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
		query.append("DELETE FROM " ).append("\n"); 
		query.append("	EQR_PORT_DCHG_CNST" ).append("\n"); 
		query.append("WHERE	" ).append("\n"); 
		query.append("	VSL_LANE_CD	= @[vsl_lane_cd]" ).append("\n"); 
		query.append("	AND	VSL_LOC_CD	= @[vsl_loc_cd]" ).append("\n"); 

	}
}