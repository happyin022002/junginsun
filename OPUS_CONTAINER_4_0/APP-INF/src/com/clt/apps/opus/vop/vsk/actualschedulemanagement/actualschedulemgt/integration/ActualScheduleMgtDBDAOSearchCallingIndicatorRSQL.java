/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
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

public class ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCallingIndicator
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL").append("\n"); 
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
		query.append("SELECT VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT VPS.*" ).append("\n"); 
		query.append("             , RANK() OVER (ORDER BY VPS.DIFF_ETA_DT) AS ETA_RANK" ).append("\n"); 
		query.append("          FROM (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                     , CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , VPS_PORT_CD" ).append("\n"); 
		query.append("                     , VPS_ETA_DT" ).append("\n"); 
		query.append("                     , VPS_ETB_DT" ).append("\n"); 
		query.append("                     , VPS_ETD_DT" ).append("\n"); 
		query.append("                     , ABS(ROUND(TO_DATE(TO_CHAR(VPS_ETA_DT,'YYYYMMDDHH24MI'),'YYYYMMDDHH24MI') - TO_DATE(@[act_arr_dt],'YYYYMMDDHH24MI'),2)) AS DIFF_ETA_DT" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND VPS_PORT_CD = @[vps_port_cd] " ).append("\n"); 
		query.append("				   AND VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("            ) VPS " ).append("\n"); 
		query.append("       ) VPS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VPS.ETA_RANK = 1" ).append("\n"); 

	}
}