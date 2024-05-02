/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimReportNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimReportNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * report no 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimReportNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimReportNoListRSQL").append("\n"); 
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
		query.append("WITH SUB_SIM_RMK AS (" ).append("\n"); 
		query.append("	SELECT  SIM_RPT_NO,  REPLACE(WM_CONCAT(SIM_RMK),',',' ') SIM_RMK" ).append("\n"); 
		query.append("	  FROM (" ).append("\n"); 
		query.append("    	SELECT SECT_NO, SIM_RPT_NO, SIM_RMK FROM COA_SIM_RPT_MST" ).append("\n"); 
		query.append("    	 WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("    	   AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("    	   AND SECT_NO IN (" ).append("\n"); 
		query.append("        		SELECT SECT_NO FROM COA_SIM_SVC_LANE " ).append("\n"); 
		query.append("         		 WHERE 1=1" ).append("\n"); 
		query.append("           		   AND SIM_DT  = @[f_sim_dt]" ).append("\n"); 
		query.append("           		   AND SIM_NO  = @[f_sim_no]" ).append("\n"); 
		query.append("     			#if(${f_trd_cd} != '')" ).append("\n"); 
		query.append("       		   	   AND TRD_CD  = @[f_trd_cd]" ).append("\n"); 
		query.append("     			#end " ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("		 ORDER BY SECT_NO" ).append("\n"); 
		query.append("    		)" ).append("\n"); 
		query.append("	  GROUP BY SIM_RPT_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT A.SIM_RPT_NO CODE" ).append("\n"); 
		query.append("     , NVL(B.SIM_RMK, ' ') NAME" ).append("\n"); 
		query.append("  FROM COA_SIM_RPT_MST A, SUB_SIM_RMK B " ).append("\n"); 
		query.append(" WHERE A.SIM_RPT_NO = B.SIM_RPT_NO(+)" ).append("\n"); 
		query.append("   AND A.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("   AND A.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append(" ORDER BY A.SIM_RPT_NO" ).append("\n"); 

	}
}