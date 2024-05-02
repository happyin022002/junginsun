/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimLaneDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.25 윤진영
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

public class LaneSimulationDBDAOMultiSimLaneDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane simulation 삭제
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimLaneDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : LaneSimulationDBDAOMultiSimLaneDSQL").append("\n"); 
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
		query.append("#if(${tname} == '1')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_SVC_LANE" ).append("\n"); 
		query.append("#elseif(${tname} == '2')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("#elseif(${tname} == '3')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_INTR_TRNS_VOL" ).append("\n"); 
		query.append("#elseif(${tname} == '4')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_RPT_MST" ).append("\n"); 
		query.append("#elseif(${tname} == '5')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_VOL_PRJ" ).append("\n"); 
		query.append("#elseif(${tname} == '6')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_CTRB_MGN_COST" ).append("\n"); 
		query.append("#elseif(${tname} == '7')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_BNK_COST" ).append("\n"); 
		query.append("#elseif(${tname} == '8')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_NTWK_COST" ).append("\n"); 
		query.append("#elseif(${tname} == '9')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_SMRY_RPT" ).append("\n"); 
		query.append("#elseif(${tname} == '10')" ).append("\n"); 
		query.append("DELETE FROM MAS_SIM_TML_OP_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_sim_dt} != '')" ).append("\n"); 
		query.append("AND SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sim_no} != '')" ).append("\n"); 
		query.append("AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tname} != '3' && (${sect_no} != '' || ${sect_no} != 'null'))" ).append("\n"); 
		query.append("AND SECT_NO = @[sect_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}