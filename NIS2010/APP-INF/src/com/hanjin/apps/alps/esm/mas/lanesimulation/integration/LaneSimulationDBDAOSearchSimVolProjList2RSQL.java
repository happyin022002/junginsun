/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimVolProjList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.03.23 윤진영
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

public class LaneSimulationDBDAOSearchSimVolProjList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Step3 > tab1 > volume 정보 가져오는 쿼리
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimVolProjList2RSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sect_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimVolProjList2RSQL").append("\n"); 
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
		query.append("SELECT B2.POL_CD" ).append("\n"); 
		query.append("#foreach(${header_value} IN ${header})" ).append("\n"); 
		query.append(",NVL(SUM(DECODE(B2.POD_CD, '${header_value}', B1.PORT_PAIR_LOD_QTY)),0) pod_$header_value" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",'' AS TOT" ).append("\n"); 
		query.append(",MAX(B2.NUM) AS NUM" ).append("\n"); 
		query.append("FROM MAS_SIM_VOL_PRJ B1" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT A1.POL_CD, A2.POD_CD, A1.NUM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#set($j = 0)" ).append("\n"); 
		query.append("#foreach($header_value IN ${header})" ).append("\n"); 
		query.append("#set($m = $j+1)" ).append("\n"); 
		query.append("SELECT '${header_value}' AS POL_CD, $m AS NUM FROM DUAL" ).append("\n"); 
		query.append("#if($j < ${rowcnt})" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#set($j = $j+1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A1" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("#set($j = 0)" ).append("\n"); 
		query.append("#foreach($header_value IN ${header})" ).append("\n"); 
		query.append("#set($m = $j+1)" ).append("\n"); 
		query.append("SELECT '${header_value}' AS POD_CD,$m AS NUM FROM DUAL" ).append("\n"); 
		query.append("#if($j < ${rowcnt})" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#set($j = $j+1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("WHERE B1.POL_CD(+)       = B2.POL_CD" ).append("\n"); 
		query.append("AND B1.POD_CD(+)       = B2.POD_CD" ).append("\n"); 
		query.append("AND B1.SIM_DT(+)       = @[f_sim_dt]" ).append("\n"); 
		query.append("AND B1.SIM_NO(+)       = @[f_sim_no]" ).append("\n"); 
		query.append("AND B1.SECT_NO(+)      = @[f_sect_no]" ).append("\n"); 
		query.append("GROUP BY B2.POL_CD" ).append("\n"); 
		query.append("ORDER BY MAX(B2.NUM)" ).append("\n"); 

	}
}