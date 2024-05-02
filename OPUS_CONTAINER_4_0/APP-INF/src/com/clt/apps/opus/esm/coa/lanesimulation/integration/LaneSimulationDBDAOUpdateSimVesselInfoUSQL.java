/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOUpdateSimVesselInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.18 윤진영
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

public class LaneSimulationDBDAOUpdateSimVesselInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel정보를 수정한다.
	  * </pre>
	  */
	public LaneSimulationDBDAOUpdateSimVesselInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOUpdateSimVesselInfoUSQL").append("\n"); 
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
		query.append("UPDATE COA_SIM_SVC_LANE A" ).append("\n"); 
		query.append("SET (A.BSA_CAPA,A.LOD_TTL_QTY,A.GRS_RPB_REV,A.LDF_RTO)=(" ).append("\n"); 
		query.append("SELECT SUM(B.FNL_HJS_BSA_CAPA) BSA_CAPA," ).append("\n"); 
		query.append("SUM(B.FNL_HJS_BSA_CAPA * B.LDF_RTO) LOAD," ).append("\n"); 
		query.append("DECODE(SUM(B.FNL_HJS_BSA_CAPA * B.LDF_RTO),0,0,SUM(A.GRS_TTL_REV)/SUM(B.FNL_HJS_BSA_CAPA * B.LDF_RTO)) GRS_RPB_REV," ).append("\n"); 
		query.append("SUM(B.FNL_HJS_BSA_CAPA * B.LDF_RTO)/DECODE(SUM(B.FNL_HJS_BSA_CAPA),0,1,SUM(B.FNL_HJS_BSA_CAPA)) LOAD_FACTOR" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO B" ).append("\n"); 
		query.append("WHERE A.SIM_DT  = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO  = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO = B.SECT_NO" ).append("\n"); 
		query.append("AND B.SIM_DIV_CD = '1'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE A.SIM_DT  = @[sim_dt]" ).append("\n"); 
		query.append("AND A.SIM_NO  = @[sim_no]" ).append("\n"); 
		query.append("AND A.SECT_NO = @[sect_no]" ).append("\n"); 

	}
}