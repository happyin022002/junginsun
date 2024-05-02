/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchTmlDistanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.15 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchTmlDistanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 터미널간의 거리,fm_zd, to_zd, 포트버퍼 , crn_knt, tml_prod_qty 를 구한다.
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchTmlDistanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchTmlDistanceRSQL").append("\n"); 
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
		query.append("SELECT NVL(port_dist, 0)  as lnk_dist --  distance" ).append("\n"); 
		query.append(",NVL(fm_port_gmt, 0)-(NVL(to_port_gmt, 0)*-1) zd" ).append("\n"); 
		query.append(",NVL(port_buf_time,0) as port_buf_hrs" ).append("\n"); 
		query.append(",NVL(TO_NUMBER(SUBSTR(cranes_tmnl_prd,1,INSTR(cranes_tmnl_prd,':')-1)),0) as crn_knt" ).append("\n"); 
		query.append(",NVL(ROUND(TO_NUMBER(SUBSTR(cranes_tmnl_prd,INSTR(cranes_tmnl_prd,':')+1)),1),0) AS tml_prod_qty -- 생산성" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  STND_DIST" ).append("\n"); 
		query.append("FROM    VSK_PORT_DIST" ).append("\n"); 
		query.append("WHERE   FM_LOC_CD   = @[port_cd]" ).append("\n"); 
		query.append("AND     TO_LOC_CD = @[next_port_cd]" ).append("\n"); 
		query.append(") AS PORT_DIST" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  GMT_HRS / 60" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD      = @[port_cd]" ).append("\n"); 
		query.append(") AS FM_PORT_GMT" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  GMT_HRS / 60" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD      = @[next_port_cd]" ).append("\n"); 
		query.append(") AS TO_PORT_GMT" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  DOC_HRS + DEAD_HRS" ).append("\n"); 
		query.append("FROM    VSK_PORT_DOC_BUF_TM" ).append("\n"); 
		query.append("WHERE   LOC_CD  = @[next_port_cd]" ).append("\n"); 
		query.append(") AS PORT_BUF_TIME" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT AVG_CRANES ||':'|| ROUND(DECODE(GROSS_WORK, 0, 0, TTL_MOVES / DECODE(GROSS_WORK,NULL,1,0,1,GROSS_WORK)), 2) AS TMNL_PRD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROUND(SUM(1) / DECODE(COUNT(DISTINCT T2.VSL_CD||T2.VOY_NO||T2.DIR_CD||T2.PORT_CD||T2.CALL_IND||T2.CALL_IND),NULL,1,0,1,COUNT(DISTINCT T2.VSL_CD||T2.VOY_NO||T2.DIR_CD||T2.PORT_CD||T2.CALL_IND||T2.CALL_IND)))  AS AVG_CRANES" ).append("\n"); 
		query.append(",SUM(T1.MVS)        AS TTL_MOVES" ).append("\n"); 
		query.append(",SUM(TO_NUMBER(SUBSTR(T1.GROSS_WORK,1,INSTR(T1.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T1.GROSS_WORK,INSTR(T1.GROSS_WORK,':')+1)/60)) AS GROSS_WORK" ).append("\n"); 
		query.append("FROM TDR_HEADER T1, TDR_CRANE T2" ).append("\n"); 
		query.append("WHERE T1.PORT_CD = @[next_port_cd]" ).append("\n"); 
		query.append("AND T1.VSL_CD   = T2.VSL_CD  (+)" ).append("\n"); 
		query.append("AND T1.VOY_NO   = T2.VOY_NO  (+)" ).append("\n"); 
		query.append("AND T1.DIR_CD   = T2.DIR_CD  (+)" ).append("\n"); 
		query.append("AND T1.PORT_CD  = T2.PORT_CD (+)" ).append("\n"); 
		query.append("AND T1.CALL_IND = T2.CALL_IND(+)" ).append("\n"); 
		query.append("AND T1.UPDATE_TIME BETWEEN SYSDATE - 365" ).append("\n"); 
		query.append("AND  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS CRANES_TMNL_PRD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}