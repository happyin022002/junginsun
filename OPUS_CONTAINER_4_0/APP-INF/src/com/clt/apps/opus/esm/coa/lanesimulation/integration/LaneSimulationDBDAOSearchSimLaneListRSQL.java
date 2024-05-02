/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.16 
* 1.0 Creation
* 2010.10.08 박은주 CHM-201006307 Session 정보 변경 및 프로그램 오류수정
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Simulation master Retrieve
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimLaneListRSQL").append("\n"); 
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
		query.append("SELECT A.SIM_DT, A.SIM_NO, A.SECT_NO, A.FREQ_NO, " ).append("\n"); 
		query.append("#if (${f_slan_cd} != '')" ).append("\n"); 
		query.append("	   @[f_slan_cd] SLAN_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	'' SLAN_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   A.TRD_CD," ).append("\n"); 
		query.append("       A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD, A.SKD_DIR_CD, A.LOD_TTL_QTY, " ).append("\n"); 
		query.append("       COUNT(B.VSL_CD) VSL_CNT, C.EXTD_LANE_FLG, " ).append("\n"); 
		query.append("	   '' AS CRE_USR_ID," ).append("\n"); 
		query.append("	   '' AS CRE_DT," ).append("\n"); 
		query.append("       '' AS UPD_USR_ID," ).append("\n"); 
		query.append("	   '' AS UPD_DT," ).append("\n"); 
		query.append("	   '' AS DEPT_CD," ).append("\n"); 
		query.append("       @[f_sim_rmk] SIM_RMK" ).append("\n"); 
		query.append("  FROM COA_SIM_SVC_LANE A, COA_SIM_VSL_SET_INFO B, COA_SIM_INFO C" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND A.SIM_DT        = B.SIM_DT(+) " ).append("\n"); 
		query.append("   AND A.SIM_NO        = B.SIM_NO(+) " ).append("\n"); 
		query.append("   AND A.SECT_NO       = B.SECT_NO(+) " ).append("\n"); 
		query.append("   AND A.SIM_DT        = C.SIM_DT " ).append("\n"); 
		query.append("   AND A.SIM_NO        = C.SIM_NO " ).append("\n"); 
		query.append("#if (${f_sim_dt} != '') " ).append("\n"); 
		query.append("   AND A.SIM_DT        = @[f_sim_dt] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.SIM_NO        = @[f_sim_no]" ).append("\n"); 
		query.append("   AND B.SIM_DIV_CD(+) = '1' " ).append("\n"); 
		query.append(" GROUP BY A.SIM_DT, A.SIM_NO, A.SECT_NO, A.FREQ_NO, A.TRD_CD, " ).append("\n"); 
		query.append("          A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD, A.SKD_DIR_CD, A.LOD_TTL_QTY,C.EXTD_LANE_FLG   " ).append("\n"); 
		query.append(" ORDER BY SECT_NO" ).append("\n"); 

	}
}