/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateDBDAOReRunVesselPlanCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.10 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleChangeSimulateDBDAOReRunVesselPlanCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * simulation에 맞는 새로운 시나리오 한 SET을 만들어줌
	  * </pre>
	  */
	public VesselScheduleChangeSimulateDBDAOReRunVesselPlanCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_result_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration ").append("\n"); 
		query.append("FileName : VesselScheduleChangeSimulateDBDAOReRunVesselPlanCSQL").append("\n"); 
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
		query.append("call EQR_VSL_SIM_PRC(@[new_scnr_id],@[old_scnr_id],@[n_user_id],@[out_result_no])" ).append("\n"); 

	}
}