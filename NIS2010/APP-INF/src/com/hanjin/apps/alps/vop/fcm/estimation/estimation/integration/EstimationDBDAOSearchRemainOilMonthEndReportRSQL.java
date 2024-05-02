/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchRemainOilMonthEndReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.14 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MIJIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOSearchRemainOilMonthEndReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EstimationDBDAOSearchRemainOilMonthEndReportRSQL
	  * </pre>
	  */
	public EstimationDBDAOSearchRemainOilMonthEndReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchRemainOilMonthEndReportRSQL").append("\n"); 
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
		query.append("/**" ).append("\n"); 
		query.append("-- FcmRmnOilMonEndRptRVO" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' REV_YRMON," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_VOY_NO," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' VSL_SLAN_CD," ).append("\n"); 
		query.append("'' FOIL_RMN_WGT," ).append("\n"); 
		query.append("'' DOIL_RMN_WGT," ).append("\n"); 
		query.append("'' CLND_OIL_RMN_WGT," ).append("\n"); 
		query.append("'' SYS_OIL_RMN_WGT," ).append("\n"); 
		query.append("'' GNR_OIL_RMN_WGT," ).append("\n"); 
		query.append("'' LOW_SULP_DOIL_RMN_WGT," ).append("\n"); 
		query.append("'' TRBN_GNR_OIL_RMN_WGT," ).append("\n"); 
		query.append("'' LOW_SULP_FOIL_RMN_WGT," ).append("\n"); 
		query.append("'' RPT_DOC_NO," ).append("\n"); 
		query.append("'' RPT_ISS_DT," ).append("\n"); 
		query.append("'' RPT_USR_ID," ).append("\n"); 
		query.append("'' RPT_USR_NM," ).append("\n"); 
		query.append("'' TEAM_DESC," ).append("\n"); 
		query.append("'' RPT_RMK," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT" ).append("\n"); 
		query.append("FROM FCM_RMN_OIL_MON_END_RPT" ).append("\n"); 
		query.append("**/" ).append("\n"); 
		query.append("SELECT REV_YRMON" ).append("\n"); 
		query.append("	   ,VSL_CD" ).append("\n"); 
		query.append("	   ,SKD_VOY_NO" ).append("\n"); 
		query.append("	   ,SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,VSL_SLAN_CD" ).append("\n"); 
		query.append("	   ,FOIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,DOIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,CLND_OIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,SYS_OIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,GNR_OIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,LOW_SULP_DOIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,TRBN_GNR_OIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,LOW_SULP_FOIL_RMN_WGT" ).append("\n"); 
		query.append("	   ,RPT_DOC_NO" ).append("\n"); 
		query.append("	   ,RPT_ISS_DT" ).append("\n"); 
		query.append("	   ,RPT_USR_ID" ).append("\n"); 
		query.append("	   ,RPT_USR_NM" ).append("\n"); 
		query.append("	   ,TEAM_DESC" ).append("\n"); 
		query.append("	   ,RPT_RMK" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("FROM    FCM_RMN_OIL_MON_END_RPT" ).append("\n"); 
		query.append("WHERE   REV_YRMON=REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND     VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("AND     SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_dir_cd} != '') " ).append("\n"); 
		query.append("AND     REV_DIR_CD = @[rev_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}