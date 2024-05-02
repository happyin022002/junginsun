/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateDBDAOSearchMaxScnrIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.04 정은호
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

public class VesselScheduleChangeSimulateDBDAOSearchMaxScnrIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_MST 테이블에서 최대값 SCNR 검색
	  * </pre>
	  */
	public VesselScheduleChangeSimulateDBDAOSearchMaxScnrIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnrId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration ").append("\n"); 
		query.append("FileName : VesselScheduleChangeSimulateDBDAOSearchMaxScnrIDRSQL").append("\n"); 
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
		query.append("'SCEN'||SUBSTR( @[scnrId] ,5,6)||'W'||LPAD((MAX(SUBSTR(SCNR_ID, 12,  3)) + 1),3,'0')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_MST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SUBSTR(SCNR_ID,5,6) = SUBSTR( @[scnrId] ,5,6)" ).append("\n"); 

	}
}