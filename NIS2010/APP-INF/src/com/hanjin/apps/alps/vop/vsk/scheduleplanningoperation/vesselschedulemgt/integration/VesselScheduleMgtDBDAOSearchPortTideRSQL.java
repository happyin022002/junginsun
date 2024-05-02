/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchPortTideRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.03 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchPortTideRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchPortTideRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("post_type",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT	CASE WHEN @[post_type] = 'ARRIVAL'" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("CASE WHEN (" ).append("\n"); 
		query.append("ABS(TO_DATE(N1ST_TIDE_FM_HRMNT, 'HH24MI') - TO_DATE(TO_CHAR(TO_DATE(@[vps_eta_dt], 'YYYY-MM-DD HH24:MI'), 'HH24MI'), 'HH24MI'))" ).append("\n"); 
		query.append("- ABS(TO_DATE(N2ND_FM_TIDE_HRMNT, 'HH24MI') - TO_DATE(TO_CHAR(TO_DATE(@[vps_eta_dt], 'YYYY-MM-DD HH24:MI'), 'HH24MI'), 'HH24MI'))" ).append("\n"); 
		query.append("< 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN N1ST_HIGH_TIDE_HGT" ).append("\n"); 
		query.append("ELSE N2ND_HIGH_TIDE_HGT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN (" ).append("\n"); 
		query.append("ABS(TO_DATE(N1ST_TIDE_TO_HRMNT, 'HH24MI') - TO_DATE(TO_CHAR(TO_DATE(@[vps_etd_dt], 'YYYY-MM-DD HH24:MI'), 'HH24MI'), 'HH24MI'))" ).append("\n"); 
		query.append("- ABS(TO_DATE(N2ND_TO_TIDE_HRMNT, 'HH24MI') - TO_DATE(TO_CHAR(TO_DATE(@[vps_etd_dt], 'YYYY-MM-DD HH24:MI'), 'HH24MI'), 'HH24MI'))" ).append("\n"); 
		query.append("< 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN N1ST_LOW_TIDE_HGT" ).append("\n"); 
		query.append("ELSE N2ND_LOW_TIDE_HGT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END AS N1ST_HIGH_TIDE_HGT" ).append("\n"); 
		query.append("FROM	VSK_PORT_TIDE" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND  LOC_CD      = @[loc_cd]" ).append("\n"); 
		query.append("AND  TIDE_YR     = CASE WHEN @[post_type] = 'ARRIVAL'" ).append("\n"); 
		query.append("THEN TO_CHAR(TO_DATE(@[vps_eta_dt], 'YYYY-MM-DD HH24:MI'), 'YYYY')" ).append("\n"); 
		query.append("ELSE TO_CHAR(TO_DATE(@[vps_etd_dt], 'YYYY-MM-DD HH24:MI'), 'YYYY')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND  TIDE_MON    = TO_NUMBER(" ).append("\n"); 
		query.append("CASE WHEN @[post_type] = 'ARRIVAL'" ).append("\n"); 
		query.append("THEN TO_CHAR(TO_DATE(@[vps_eta_dt], 'YYYY-MM-DD HH24:MI'), 'MM')" ).append("\n"); 
		query.append("ELSE TO_CHAR(TO_DATE(@[vps_etd_dt], 'YYYY-MM-DD HH24:MI'), 'MM')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  TIDE_DY     = TO_NUMBER(" ).append("\n"); 
		query.append("CASE WHEN @[post_type] = 'ARRIVAL'" ).append("\n"); 
		query.append("THEN TO_CHAR(TO_DATE(@[vps_eta_dt], 'YYYY-MM-DD HH24:MI'), 'DD')" ).append("\n"); 
		query.append("ELSE TO_CHAR(TO_DATE(@[vps_etd_dt], 'YYYY-MM-DD HH24:MI'), 'DD')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchPortTideRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}