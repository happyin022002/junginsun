/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimDailyHireListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimDailyHireListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Daily Hire List 검색
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimDailyHireListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimDailyHireListRSQL").append("\n"); 
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
		query.append("SELECT FLAG " ).append("\n"); 
		query.append("          ,VSL_CD " ).append("\n"); 
		query.append("          ,VSL_OSHP_CD " ).append("\n"); 
		query.append("          ,VSL_CLSS_CAPA " ).append("\n"); 
		query.append("   #foreach (${header_value} IN ${header})" ).append("\n"); 
		query.append("  	      ,NVL(SUM(DECODE(SGRP_COST_CD,'${header_value}', VSL_DLY_COST_AMT)),0) ${header_value}" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("          ,'0' " ).append("\n"); 
		query.append("          , VSL_DLY_UC_AMT " ).append("\n"); 
		query.append("          , LYP_COST_AMT " ).append("\n"); 
		query.append("          , LYP_FLG " ).append("\n"); 
		query.append("      FROM ( " ).append("\n"); 
		query.append("         SELECT DISTINCT " ).append("\n"); 
		query.append("                DECODE(NVL(A2.VSL_CD,'*'),'*','I','R') FLAG " ).append("\n"); 
		query.append("               ,A1.VSL_CD " ).append("\n"); 
		query.append("               ,A2.VSL_CD AS VSL_CD2 " ).append("\n"); 
		query.append("               ,A1.VOP_CD " ).append("\n"); 
		query.append("               ,A3.VSL_OSHP_CD " ).append("\n"); 
		query.append("               ,A1.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("               ,A2.SGRP_COST_CD " ).append("\n"); 
		query.append("               ,A2.VSL_DLY_COST_AMT " ).append("\n"); 
		query.append("               ,A1.SIM_DT " ).append("\n"); 
		query.append("               ,A1.SIM_NO " ).append("\n"); 
		query.append("               ,A2.VSL_DLY_UC_AMT " ).append("\n"); 
		query.append("               ,A2.LYP_COST_AMT " ).append("\n"); 
		query.append("               ,A2.LYP_FLG " ).append("\n"); 
		query.append("         FROM MAS_SIM_VSL_SET_INFO A1 " ).append("\n"); 
		query.append("             ,MAS_SIM_DLY_HIR A2, " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("               SELECT VSL_CD, VSL_CLSS_CAPA, VSL_OSHP_CD " ).append("\n"); 
		query.append("                 FROM MAS_VSL_RGST " ).append("\n"); 
		query.append("                WHERE VSL_TP_CD = 'C' " ).append("\n"); 
		query.append("                  AND NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("                  AND VSL_OSHP_CD IN ('OWN','CHT') " ).append("\n"); 
		query.append("                  AND VOP_CD IN ('SML') " ).append("\n"); 
		query.append("               UNION ALL " ).append("\n"); 
		query.append("               SELECT VSL_CD, VSL_CLSS_CAPA, VSL_OSHP_CD " ).append("\n"); 
		query.append("                 FROM MAS_SIM_VSL_RGST " ).append("\n"); 
		query.append("                WHERE VSL_OSHP_CD IN ('OWN','CHT') " ).append("\n"); 
		query.append("                  AND VOP_CD IN ('SML') " ).append("\n"); 
		query.append("               ) A3 " ).append("\n"); 
		query.append("         WHERE A1.SIM_DT     = @[sim_dt] " ).append("\n"); 
		query.append("           AND A1.SIM_NO     = @[sim_no] " ).append("\n"); 
		query.append("           AND A1.SIM_DIV_CD = '1' " ).append("\n"); 
		query.append("           AND A1.VSL_CD     = A3.VSL_CD " ).append("\n"); 
		query.append("           AND A1.VSL_CD     = A2.VSL_CD(+) " ).append("\n"); 
		query.append("           AND A1.SIM_DT     = A2.SIM_DT(+) " ).append("\n"); 
		query.append("           AND A1.SIM_NO     = A2.SIM_NO(+) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("   GROUP BY FLAG " ).append("\n"); 
		query.append("           ,VSL_CD " ).append("\n"); 
		query.append("           ,VSL_CD2 " ).append("\n"); 
		query.append("           ,VSL_OSHP_CD " ).append("\n"); 
		query.append("           ,VSL_CLSS_CAPA " ).append("\n"); 
		query.append("           ,VSL_DLY_UC_AMT " ).append("\n"); 
		query.append("           ,LYP_COST_AMT " ).append("\n"); 
		query.append("           ,LYP_FLG " ).append("\n"); 
		query.append("   ORDER BY VSL_CD" ).append("\n"); 

	}
}