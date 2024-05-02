/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimLaneRPBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.18 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimLaneRPBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RPB리스트 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimLaneRPBListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimLaneRPBListRSQL").append("\n"); 
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
		query.append("SELECT A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SECT_NO" ).append("\n"); 
		query.append(",A1.FREQ_NO" ).append("\n"); 
		query.append(",A1.TRD_CD" ).append("\n"); 
		query.append(",A1.SUB_TRD_CD" ).append("\n"); 
		query.append(",A1.RLANE_CD" ).append("\n"); 
		query.append(",A1.IOC_CD" ).append("\n"); 
		query.append(",A1.SKD_DIR_CD" ).append("\n"); 
		query.append(",A1.GRS_RPB_REV" ).append("\n"); 
		query.append(",A1.GRS_TTL_REV" ).append("\n"); 
		query.append(",A1.BSA_CAPA" ).append("\n"); 
		query.append(",ROUND(SUM(A2.FNL_HJS_BSA_CAPA*A2.LDF_RTO)/SUM(A2.FNL_HJS_BSA_CAPA)*100,2) LDF_RTO" ).append("\n"); 
		query.append(",SUM(A2.FNL_HJS_BSA_CAPA*A2.LDF_RTO) LOD_TTL_QTY" ).append("\n"); 
		query.append(",(SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM MAS_SIM_TML_INFO B" ).append("\n"); 
		query.append("WHERE ROWNUM     = 1" ).append("\n"); 
		query.append("AND A1.SIM_DT  = B.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO  = B.SIM_NO ) PORT_DYS" ).append("\n"); 
		query.append("FROM MAS_SIM_SVC_LANE A1" ).append("\n"); 
		query.append(",MAS_SIM_VSL_SET_INFO A2" ).append("\n"); 
		query.append("WHERE A1.SIM_DT  = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO  = A2.SIM_NO" ).append("\n"); 
		query.append("AND A1.SECT_NO = A2.SECT_NO" ).append("\n"); 
		query.append("AND A1.SIM_DT  = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO  = @[f_sim_no]" ).append("\n"); 
		query.append("AND A2.SIM_DIV_CD = '1'" ).append("\n"); 
		query.append("GROUP BY A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SECT_NO" ).append("\n"); 
		query.append(",A1.FREQ_NO" ).append("\n"); 
		query.append(",A1.TRD_CD" ).append("\n"); 
		query.append(",A1.SUB_TRD_CD" ).append("\n"); 
		query.append(",A1.RLANE_CD" ).append("\n"); 
		query.append(",A1.IOC_CD" ).append("\n"); 
		query.append(",A1.SKD_DIR_CD" ).append("\n"); 
		query.append(",A1.GRS_RPB_REV" ).append("\n"); 
		query.append(",A1.GRS_TTL_REV" ).append("\n"); 
		query.append(",A1.BSA_CAPA" ).append("\n"); 
		query.append(",A1.LDF_RTO" ).append("\n"); 
		query.append("ORDER BY A1.SECT_NO" ).append("\n"); 

	}
}