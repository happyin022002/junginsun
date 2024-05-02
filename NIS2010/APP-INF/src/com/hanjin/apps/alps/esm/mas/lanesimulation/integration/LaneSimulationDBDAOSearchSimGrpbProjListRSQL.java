/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimGrpbProjListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.07.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimGrpbProjListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Simulation GRPB project List 조회
	  * 
	  * 2010.07.29 이윤정 : CHM-201004777-01 [MAS] MAS 코드매핑 불일치건 조치 요청 : SRC_PRD_CD 삭제
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimGrpbProjListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sect_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimGrpbProjListRSQL").append("\n"); 
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
		query.append("SELECT B2.POL_CD," ).append("\n"); 
		query.append("#foreach($header_value IN ${header})" ).append("\n"); 
		query.append("NVL(SUM(DECODE(B2.POD_CD, '${header_value}', B1.GRS_RPB_REV)),0) POD_$header_value," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MAX(B1.SIM_DT) AS SIM_DT" ).append("\n"); 
		query.append(",MAX(B1.SIM_NO) AS SIM_NO" ).append("\n"); 
		query.append(",MAX(B1.SECT_NO) AS SECT_NO" ).append("\n"); 
		query.append(",MAX(B1.TRD_CD) AS TRD_CD" ).append("\n"); 
		query.append(",MAX(B1.SUB_TRD_CD) AS SUB_TRD_CD" ).append("\n"); 
		query.append(",MAX(B1.RLANE_CD) AS RLANE_CD" ).append("\n"); 
		query.append(",MAX(B1.SKD_DIR_CD) AS DIR_CD" ).append("\n"); 
		query.append(",MAX(B2.NUM) AS NUM" ).append("\n"); 
		query.append("FROM MAS_SIM_VOL_PRJ B1" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT A1.POL_CD, A2.POD_CD, A1.NUM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#set($j = 0)" ).append("\n"); 
		query.append("#set($k = 0)" ).append("\n"); 
		query.append("#set($header_size = ${header_size})" ).append("\n"); 
		query.append("#foreach( $header_value IN ${header})" ).append("\n"); 
		query.append("#set($k = $j+1)" ).append("\n"); 
		query.append("#if($j < $header_size)" ).append("\n"); 
		query.append("SELECT '${header_value}' AS POL_CD ,'$k' AS NUM FROM DUAL UNION ALL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT '${header_value}' AS POL_CD ,'$k' AS NUM FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#set($j = $j + 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") a1" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("#set($j = 0)" ).append("\n"); 
		query.append("#foreach( $header_value IN ${header})" ).append("\n"); 
		query.append("#if($j < $header_size)" ).append("\n"); 
		query.append("SELECT '${header_value}' AS POD_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT '${header_value}' AS POD_CD FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#set($j = $j + 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("WHERE B1.POL_CD(+)  = B2.POL_CD" ).append("\n"); 
		query.append("AND B1.POD_CD(+)  = B2.POD_CD" ).append("\n"); 
		query.append("AND B1.SIM_DT(+)  = @[f_sim_dt]" ).append("\n"); 
		query.append("AND B1.SIM_NO(+)  = @[f_sim_no]" ).append("\n"); 
		query.append("AND B1.SECT_NO(+) = @[f_sect_no]" ).append("\n"); 
		query.append("GROUP BY B2.POL_CD" ).append("\n"); 
		query.append("ORDER BY MAX(B2.NUM)" ).append("\n"); 

	}
}