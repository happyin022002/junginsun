/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDAOSearchFileMgmtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.16 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchFileMgmtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * File mgmt 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchFileMgmtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDAOSearchFileMgmtListRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append(",SIMULATION_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO" ).append("\n"); 
		query.append(",SIM_RMK" ).append("\n"); 
		query.append(",SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",COUNT(DISTINCT SIM_RPT_NO) OVER(PARTITION BY SIM_DT, SIM_NO) NUM" ).append("\n"); 
		query.append(",SUBSTR(SIM_RPT_NO, 3, 4) REPORT" ).append("\n"); 
		query.append(",'' USER_ID" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("A.SLAN_CD" ).append("\n"); 
		query.append(",A.SIM_DEPT_CD||'-'||A.SIM_DT||'-'||A.SIM_NO||'-'||A.CRE_USR_ID AS SIMULATION_NO" ).append("\n"); 
		query.append(",B.SIM_RPT_NO" ).append("\n"); 
		query.append(",B.SIM_RMK" ).append("\n"); 
		query.append(",A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",'' USER_ID" ).append("\n"); 
		query.append("FROM COA_SIM_INFO A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.SIM_RPT_NO" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("-- RMK가 다르면 ROW가 하나 이상이 나오게 됨" ).append("\n"); 
		query.append("-- SECT_NO가 현재 4개가 가장 많은 것이라 6개 까지 임의로 넣었음" ).append("\n"); 
		query.append("-- 추후 변경필요" ).append("\n"); 
		query.append("(SELECT SIM_RMK FROM COA_SIM_RPT_MST A1 WHERE A1.SIM_DT = B1.SIM_DT AND A1.SIM_NO = B1.SIM_NO AND A1.SIM_RPT_NO = B1.SIM_RPT_NO AND A1.SECT_NO = '001') || ' ' ||" ).append("\n"); 
		query.append("(SELECT SIM_RMK FROM COA_SIM_RPT_MST A1 WHERE A1.SIM_DT = B1.SIM_DT AND A1.SIM_NO = B1.SIM_NO AND A1.SIM_RPT_NO = B1.SIM_RPT_NO AND A1.SECT_NO = '002') || ' ' ||" ).append("\n"); 
		query.append("(SELECT SIM_RMK FROM COA_SIM_RPT_MST A1 WHERE A1.SIM_DT = B1.SIM_DT AND A1.SIM_NO = B1.SIM_NO AND A1.SIM_RPT_NO = B1.SIM_RPT_NO AND A1.SECT_NO = '003') || ' ' ||" ).append("\n"); 
		query.append("(SELECT SIM_RMK FROM COA_SIM_RPT_MST A1 WHERE A1.SIM_DT = B1.SIM_DT AND A1.SIM_NO = B1.SIM_NO AND A1.SIM_RPT_NO = B1.SIM_RPT_NO AND A1.SECT_NO = '004') || ' ' ||" ).append("\n"); 
		query.append("(SELECT SIM_RMK FROM COA_SIM_RPT_MST A1 WHERE A1.SIM_DT = B1.SIM_DT AND A1.SIM_NO = B1.SIM_NO AND A1.SIM_RPT_NO = B1.SIM_RPT_NO AND A1.SECT_NO = '005') || ' ' ||" ).append("\n"); 
		query.append("(SELECT SIM_RMK FROM COA_SIM_RPT_MST A1 WHERE A1.SIM_DT = B1.SIM_DT AND A1.SIM_NO = B1.SIM_NO AND A1.SIM_RPT_NO = B1.SIM_RPT_NO AND A1.SECT_NO = '006')" ).append("\n"); 
		query.append(") SIM_RMK" ).append("\n"); 
		query.append("FROM COA_SIM_RPT_MST B1" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("GROUP BY B1.SIM_DT, B1.SIM_NO, B1.SIM_RPT_NO" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.SIM_DT = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO = B.SIM_NO" ).append("\n"); 
		query.append("AND A.CRE_USR_ID = @[user_id]" ).append("\n"); 
		query.append("AND   A.SLAN_CD    = @[f_slan_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SLAN_CD ASC, SIM_DT DESC, REPORT ASC" ).append("\n"); 

	}
}