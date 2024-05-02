/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateDBDAOUpdateMultiVesselPlanVesselScheduleUSQL.java
*@FileTitle : Vessel Schedule Change Simulation Analysis
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.08 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleChangeSimulateDBDAOUpdateMultiVesselPlanVesselScheduleUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_vsl_skd 테이블에 scnr vessel schedule 수정
	  * </pre>
	  */
	public VesselScheduleChangeSimulateDBDAOUpdateMultiVesselPlanVesselScheduleUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("maxScnrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration").append("\n"); 
		query.append("FileName : VesselScheduleChangeSimulateDBDAOUpdateMultiVesselPlanVesselScheduleUSQL").append("\n"); 
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
		query.append("UPDATE EQR_SCNR_VSL_SKD SET" ).append("\n"); 
		query.append("VSL_CALL_SEQ = @[vsl_call_seq]," ).append("\n"); 
		query.append("VSL_ETB_DT   = TO_DATE( @[vsl_etb_dt] , 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("VSL_ETD_DT   = TO_DATE( @[vsl_etd_dt] , 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("UPD_USR_ID   = @[usrId] ," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID             = @[maxScnrId]" ).append("\n"); 
		query.append("AND VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VSL_LOC_CD      = @[vsl_loc_cd]" ).append("\n"); 
		query.append("AND VSL_CALL_IND_CD = @[vsl_call_ind_cd]" ).append("\n"); 
		query.append("AND VSL_CALL_SEQ    = @[vsl_call_seq]" ).append("\n"); 

	}
}