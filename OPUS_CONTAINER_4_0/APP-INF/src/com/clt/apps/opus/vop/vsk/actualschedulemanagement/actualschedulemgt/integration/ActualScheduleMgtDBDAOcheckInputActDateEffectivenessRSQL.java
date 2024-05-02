/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOcheckInputActDateEffectivenessRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOcheckInputActDateEffectivenessRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Validation Check Logic for Inputted Future Date
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOcheckInputActDateEffectivenessRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOcheckInputActDateEffectivenessRSQL").append("\n"); 
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
		query.append("SELECT 	CASE	WHEN @[act_arr_dt] IS NULL																					THEN ''" ).append("\n"); 
		query.append("				WHEN SIGN(GLOBALDATE_PKG.TIME_LOCAL_FNC(@[vps_port_cd]) - TO_DATE(@[act_arr_dt],'YYYY-MM-DD HH24:MI')) < 0	THEN 'Arrival'" ).append("\n"); 
		query.append("            	ELSE ''" ).append("\n"); 
		query.append("       	END		AS INPUT_ATA_DATE_EFFECTIVENESS" ).append("\n"); 
		query.append("	,	" ).append("\n"); 
		query.append("		CASE	WHEN @[act_brth_dt] IS NULL																					THEN ''" ).append("\n"); 
		query.append("				WHEN SIGN(GLOBALDATE_PKG.TIME_LOCAL_FNC(@[vps_port_cd]) - TO_DATE(@[act_brth_dt],'YYYY-MM-DD HH24:MI')) < 0	THEN 'Berthing'" ).append("\n"); 
		query.append("            	ELSE ''" ).append("\n"); 
		query.append("       	END		AS INPUT_ATB_DATE_EFFECTIVENESS" ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("		CASE	WHEN @[act_dep_dt] IS NULL																					THEN ''" ).append("\n"); 
		query.append("				WHEN SIGN(GLOBALDATE_PKG.TIME_LOCAL_FNC(@[vps_port_cd]) - TO_DATE(@[act_dep_dt],'YYYY-MM-DD HH24:MI')) < 0	THEN 'Departure'" ).append("\n"); 
		query.append("            	ELSE ''" ).append("\n"); 
		query.append("       	END		AS INPUT_ATD_DATE_EFFECTIVENESS" ).append("\n"); 
		query.append(" FROM	DUAL" ).append("\n"); 

	}
}