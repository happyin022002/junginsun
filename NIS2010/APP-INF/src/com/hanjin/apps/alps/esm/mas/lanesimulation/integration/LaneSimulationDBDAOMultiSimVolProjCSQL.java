/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimVolProjCSQL.java
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

public class LaneSimulationDBDAOMultiSimVolProjCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vol Project 머지
	  * 
	  * 2010.07.29 이윤정 : CHM-201004777-01 [MAS] MAS 코드매핑 불일치건 조치 요청 : SRC_PRD_CD 삭제
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimVolProjCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_pair_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_pair_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_pair_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOMultiSimVolProjCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_SIM_VOL_PRJ A" ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("SELECT  @[sim_dt]  AS SIM_DT," ).append("\n"); 
		query.append("@[sim_no]  AS SIM_NO," ).append("\n"); 
		query.append("@[sect_no] AS SECT_NO," ).append("\n"); 
		query.append("@[pol_cd]  AS POL_CD," ).append("\n"); 
		query.append("@[pod_cd]  AS POD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("A.SIM_DT  = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO  = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO = B.SECT_NO" ).append("\n"); 
		query.append("AND A.POL_CD  = B.POL_CD" ).append("\n"); 
		query.append("AND A.POD_CD  = B.POD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET PORT_PAIR_QTY     = @[port_pair_qty]," ).append("\n"); 
		query.append("PORT_PAIR_LOD_QTY = @[port_pair_lod_qty]," ).append("\n"); 
		query.append("PORT_PAIR_RTO     = @[port_pair_rto]," ).append("\n"); 
		query.append("UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(SIM_DT," ).append("\n"); 
		query.append("SIM_NO," ).append("\n"); 
		query.append("SECT_NO," ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("PORT_PAIR_QTY," ).append("\n"); 
		query.append("PORT_PAIR_LOD_QTY," ).append("\n"); 
		query.append("PORT_PAIR_RTO," ).append("\n"); 
		query.append("TRD_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES(@[sim_dt]," ).append("\n"); 
		query.append("@[sim_no]," ).append("\n"); 
		query.append("@[sect_no]," ).append("\n"); 
		query.append("@[pol_cd]," ).append("\n"); 
		query.append("@[pod_cd]," ).append("\n"); 
		query.append("@[port_pair_qty]," ).append("\n"); 
		query.append("@[port_pair_rto]," ).append("\n"); 
		query.append("@[trd_cd]," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}