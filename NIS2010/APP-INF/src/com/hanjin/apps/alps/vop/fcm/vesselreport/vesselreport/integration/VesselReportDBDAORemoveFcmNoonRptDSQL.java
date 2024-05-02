/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAORemoveFcmNoonRptDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAORemoveFcmNoonRptDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Remove noon report.
	  * ============================================================================
	  * </pre>
	  */
	public VesselReportDBDAORemoveFcmNoonRptDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("noon_rpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAORemoveFcmNoonRptDSQL").append("\n"); 
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
		query.append("DELETE FROM FCM_NOON_RPT" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO   = SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD   = SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("AND    NOON_RPT_DT  = (CASE WHEN LENGTH(@[noon_rpt_dt])<=12 THEN" ).append("\n"); 
		query.append("                           TO_DATE(RPAD(@[noon_rpt_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                           TO_DATE(SUBSTR(@[noon_rpt_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 

	}
}