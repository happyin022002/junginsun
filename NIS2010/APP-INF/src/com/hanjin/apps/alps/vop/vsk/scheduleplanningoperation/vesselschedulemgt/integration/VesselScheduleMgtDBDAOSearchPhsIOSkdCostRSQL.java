/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchPhsIOSkdCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.10 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchPhsIOSkdCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전배가 계획으로 발생할 수 있는 Cost 정보 조회
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchPhsIOSkdCostRSQL(){
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
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchPhsIOSkdCostRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("SIM_DT," ).append("\n"); 
		query.append("SIM_NO," ).append("\n"); 
		query.append("SCNR_SEQ," ).append("\n"); 
		query.append("SWAP_AMT," ).append("\n"); 
		query.append("FM_LANE_CD," ).append("\n"); 
		query.append("FM_VSL_CD," ).append("\n"); 
		query.append("FM_SKD_VOY_NO," ).append("\n"); 
		query.append("FM_SKD_DIR_CD," ).append("\n"); 
		query.append("FM_VPS_PORT_CD," ).append("\n"); 
		query.append("FM_CLPT_IND_SEQ," ).append("\n"); 
		query.append("PHS_OUT_DT," ).append("\n"); 
		query.append("TO_LANE_CD," ).append("\n"); 
		query.append("TO_VSL_CD," ).append("\n"); 
		query.append("TO_SKD_VOY_NO," ).append("\n"); 
		query.append("TO_SKD_DIR_CD," ).append("\n"); 
		query.append("TO_VPS_PORT_CD," ).append("\n"); 
		query.append("TO_CLPT_IND_SEQ," ).append("\n"); 
		query.append("PHS_IN_DT," ).append("\n"); 
		query.append("CASE WHEN PHS_IO_SIM_COST_TP_CD = 'A' THEN 'Port Expense'" ).append("\n"); 
		query.append("WHEN PHS_IO_SIM_COST_TP_CD = 'B' THEN 'Tranfer Shipment Cost'" ).append("\n"); 
		query.append("WHEN PHS_IO_SIM_COST_TP_CD = 'C' THEN 'THC'" ).append("\n"); 
		query.append("WHEN PHS_IO_SIM_COST_TP_CD = 'D' THEN 'Non-Operation Cost'" ).append("\n"); 
		query.append("WHEN PHS_IO_SIM_COST_TP_CD = 'E' THEN 'Bunker Cost for SKD Recovery' END PHS_IO_SIM_COST_TP_CD" ).append("\n"); 
		query.append("FROM	VSK_SWAP_CST_COST" ).append("\n"); 
		query.append("WHERE	SIM_DT	= TO_DATE(@[sim_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND	SIM_NO	= TO_CHAR(TO_NUMBER(@[sim_no]))" ).append("\n"); 
		query.append("ORDER BY SCNR_SEQ" ).append("\n"); 

	}
}