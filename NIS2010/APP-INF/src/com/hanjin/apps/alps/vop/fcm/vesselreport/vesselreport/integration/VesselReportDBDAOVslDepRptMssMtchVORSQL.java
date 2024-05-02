/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselReportDBDAOVslDepRptMssMtchVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOVslDepRptMssMtchVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 조건에 대한 Lane별 Departure Report Mismatched 현황을 조회한다.
	  * 
	  * History
	  * CHM-201428643 : [FCM] Vessel Report Status - Departure Report calling seq. 체크 로직 삭제
	  * [CHM-201537930] Not Matched칼럼 미조회 Report 로직 수정
	  * </pre>
	  */
	public VesselReportDBDAOVslDepRptMssMtchVORSQL(){
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
		query.append("FileName : VesselReportDBDAOVslDepRptMssMtchVORSQL").append("\n"); 
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
		query.append("    VSL_SLAN_CD," ).append("\n"); 
		query.append("    VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("    CLPT_IND_SEQ," ).append("\n"); 
		query.append("    DEP_PORT_CD," ).append("\n"); 
		query.append("    NXT_PORT_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.*," ).append("\n"); 
		query.append("        DECODE((SELECT DISTINCT 'X' FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                WHERE T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("                AND T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("                AND T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("                AND T1.DEP_PORT_CD=VPS_PORT_CD" ).append("\n"); 
		query.append("                AND T1.CLPT_IND_SEQ=CLPT_IND_SEQ" ).append("\n"); 
		query.append("                ), 'X', 0, 1) MSS_MTCH_RPT_CNT" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT T1" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if( ${fm_dt} != '' )" ).append("\n"); 
		query.append("    -- Canal SKD does not have ETD. RUP_DT is all exist." ).append("\n"); 
		query.append("    AND T1.VPS_ETD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYY-MM-DD')     -- UI Condition : Period From" ).append("\n"); 
		query.append("                   AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYY-MM-DD')+0.99999 -- UI Condition : Period To" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_slan_cd} != '' )								  " ).append("\n"); 
		query.append("	-- UI Condition : Lane Code" ).append("\n"); 
		query.append("    AND VSL_SLAN_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslSlanCd in ${vel_vsl_slan_cd})  " ).append("\n"); 
		query.append("			'$sVslSlanCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("	-- UI Condition : Vessel Code" ).append("\n"); 
		query.append("    AND VSL_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("			'$sVslCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vps_port_cd} != '' )" ).append("\n"); 
		query.append("	-- UI Condition : Port Code" ).append("\n"); 
		query.append("    AND DEP_PORT_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVpsPortCd in ${vel_vps_port_cd})  " ).append("\n"); 
		query.append("			'$sVpsPortCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${skd_dir_cd} != '' )" ).append("\n"); 
		query.append("	-- UI Condition : Direction Code" ).append("\n"); 
		query.append("    AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE MSS_MTCH_RPT_CNT=1" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD, VVD, DEP_PORT_CD" ).append("\n"); 

	}
}