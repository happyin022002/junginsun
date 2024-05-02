/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOVslNoonRptMssMtchVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.11 진마리아
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

public class VesselReportDBDAOVslNoonRptMssMtchVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 조건에 대한 Lane별 Noon Report Mismatched 현황을 조회한다.
	  * </pre>
	  */
	public VesselReportDBDAOVslNoonRptMssMtchVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOVslNoonRptMssMtchVORSQL").append("\n"); 
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
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("NXT_PORT_CD," ).append("\n"); 
		query.append("TO_CHAR(NOON_RPT_DT, 'YYYY/MM/DD') RPT_DT," ).append("\n"); 
		query.append("REF_NO" ).append("\n"); 
		query.append("FROM FCM_NOON_RPT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("                AND T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("                AND T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("                AND T1.VPS_PORT_CD=NXT_PORT_CD)" ).append("\n"); 
		query.append("#if (${fm_dt} != '') " ).append("\n"); 
		query.append("AND NOON_RPT_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD')     -- 화면조건 : FM_DT" ).append("\n"); 
		query.append("                AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD')+0.99999 -- 화면조건 : TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_slan_cd} != '' )								  " ).append("\n"); 
		query.append("	-- 화면조건 : VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND VSL_SLAN_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslSlanCd in ${vel_vsl_slan_cd})  " ).append("\n"); 
		query.append("			'$sVslSlanCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("	-- 화면조건 : VSL_CD" ).append("\n"); 
		query.append("    AND VSL_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("			'$sVslCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("    AND SKD_DIR_CD=@[skd_dir_cd]                                        -- 화면조건 : SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

	}
}