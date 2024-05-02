/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimCgoCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.08.22 최성민
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

public class LaneSimulationDBDAOSearchSimCgoCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Calcuration 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimCgoCostListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimCgoCostListRSQL").append("\n"); 
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
		query.append("SELECT  'Sec.'|| TO_NUMBER(A.SECT_NO) AS NO" ).append("\n"); 
		query.append("    ,A.SECT_NO" ).append("\n"); 
		query.append("    ,A.TRD_CD" ).append("\n"); 
		query.append("    ,A.RLANE_CD" ).append("\n"); 
		query.append("    ,A.IOC_CD" ).append("\n"); 
		query.append("    ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,A.LOD_TTL_QTY" ).append("\n"); 
		query.append("    ,(SELECT SUM(PORT_DYS) " ).append("\n"); 
		query.append("          FROM COA_SIM_TML_OP_DYS D " ).append("\n"); 
		query.append("          WHERE 1 = 1 " ).append("\n"); 
		query.append("            AND A.SIM_DT  = D.SIM_DT " ).append("\n"); 
		query.append("            AND A.SIM_NO  = D.SIM_NO " ).append("\n"); 
		query.append("            AND A.SECT_NO = D.SECT_NO" ).append("\n"); 
		query.append("         ) PORT_DYS 	" ).append("\n"); 
		query.append("#foreach( $header_value IN ${header} )" ).append("\n"); 
		query.append("        ,C.${header_value} AS ${header_value}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM COA_SIM_SVC_LANE A" ).append("\n"); 
		query.append("	  ,( " ).append("\n"); 
		query.append("      SELECT B.SIM_DT" ).append("\n"); 
		query.append("            ,B.SIM_NO" ).append("\n"); 
		query.append("            ,B.SECT_NO" ).append("\n"); 
		query.append("#foreach( $header_value IN ${header} ) " ).append("\n"); 
		query.append("    	      ,SUM(DECODE(SGRP_COST_CD, '${header_value}', CGO_VAR_AMT)) ${header_value}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      FROM COA_SIM_CTRB_MGN_COST B " ).append("\n"); 
		query.append("      WHERE B.SIM_DT  = @[f_sim_dt] " ).append("\n"); 
		query.append("        AND B.SIM_NO  = @[f_sim_no] " ).append("\n"); 
		query.append("      GROUP BY B.SIM_DT, B.SIM_NO, B.SECT_NO " ).append("\n"); 
		query.append("    ) C  " ).append("\n"); 
		query.append("WHERE A.SIM_DT   = C.SIM_DT(+) " ).append("\n"); 
		query.append("  AND A.SIM_NO   = C.SIM_NO(+) " ).append("\n"); 
		query.append("  AND A.SECT_NO  = C.SECT_NO(+) " ).append("\n"); 
		query.append("  AND A.SIM_DT   = @[f_sim_dt] " ).append("\n"); 
		query.append("  AND A.SIM_NO   = @[f_sim_no] " ).append("\n"); 
		query.append("ORDER BY A.SECT_NO" ).append("\n"); 

	}
}