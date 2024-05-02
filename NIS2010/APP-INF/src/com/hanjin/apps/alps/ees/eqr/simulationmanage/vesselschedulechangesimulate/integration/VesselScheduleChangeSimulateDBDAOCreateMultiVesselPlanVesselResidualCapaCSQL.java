/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateDBDAOCreateMultiVesselPlanVesselResidualCapaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.05 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleChangeSimulateDBDAOCreateMultiVesselPlanVesselResidualCapaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_VSL_RSDL_CAPA 테이블에 SCNR Vessel Residual Capa 입력
	  * </pre>
	  */
	public VesselScheduleChangeSimulateDBDAOCreateMultiVesselPlanVesselResidualCapaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration ").append("\n"); 
		query.append("FileName : VesselScheduleChangeSimulateDBDAOCreateMultiVesselPlanVesselResidualCapaCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_SCNR_VSL_RSDL_CAPA (" ).append("\n"); 
		query.append("SCNR_ID" ).append("\n"); 
		query.append(", CO_CD" ).append("\n"); 
		query.append(", FCAST_YRWK" ).append("\n"); 
		query.append(", ECC_CD" ).append("\n"); 
		query.append(", VSL_LANE_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", VSL_BSA_SPC" ).append("\n"); 
		query.append(", VSL_BSA_WGT" ).append("\n"); 
		query.append(", VSL_FULL_SPC" ).append("\n"); 
		query.append(", VSL_FULL_WGT" ).append("\n"); 
		query.append(", VSL_DEAD_SPC" ).append("\n"); 
		query.append(", VSL_SPC" ).append("\n"); 
		query.append(", TTL_RSDL_SPC" ).append("\n"); 
		query.append(", TTL_RSDL_WGT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[maxScnrId]" ).append("\n"); 
		query.append(", @[co_cd]" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR||PLN_WK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE( @[vsl_etb_dt] , 'YYYY-MM-DD HH24:MI'),'YYYYMMDD')" ).append("\n"); 
		query.append("BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", @[vsl_loc_cd]" ).append("\n"); 
		query.append(", @[vsl_slan_cd]" ).append("\n"); 
		query.append(", @[vsl_cd]" ).append("\n"); 
		query.append(", @[skd_voy_no]" ).append("\n"); 
		query.append(", @[skd_dir_cd]" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", 10000" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", @[usrId]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usrId]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}