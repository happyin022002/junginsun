/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEccTsTmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchEccTsTmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DefaultManage의 TS 정보 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEccTsTmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eccCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEccTsTmlRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("FM_SLAN_CD," ).append("\n"); 
		query.append("LANE_DIR_CD," ).append("\n"); 
		query.append("TO_SLAN_CD," ).append("\n"); 
		query.append("FM_YD_CD," ).append("\n"); 
		query.append("TO_YD_CD," ).append("\n"); 
		query.append("TS_20FT_UC_AMT," ).append("\n"); 
		query.append("TS_40FT_UC_AMT," ).append("\n"); 
		query.append("TS_45FT_UC_AMT," ).append("\n"); 
		query.append("ECC_CD ECC_CD1  -- HIDDEN" ).append("\n"); 
		query.append("FROM EQR_TS_TML" ).append("\n"); 
		query.append("WHERE ECC_CD = @[eccCd]" ).append("\n"); 

	}
}