/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselReportDBDAOVslDepRptNotRcvVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOVslDepRptNotRcvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 조건에 대한 Lane별 Departure Report Not Receive 현황을 조회한다.
	  * </pre>
	  */
	public VesselReportDBDAOVslDepRptNotRcvVORSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOVslDepRptNotRcvVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    VSL_SLAN_CD," ).append("\n"); 
		query.append("    VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("    MSS_PORT_CD," ).append("\n"); 
		query.append("    MSS_YD_CD," ).append("\n"); 
		query.append("    CLPT_IND_SEQ" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("            T2.SLAN_CD VSL_SLAN_CD," ).append("\n"); 
		query.append("            T2.VSL_CD ,T2.SKD_VOY_NO,T2.SKD_DIR_CD ," ).append("\n"); 
		query.append("            T2.VPS_PORT_CD MSS_PORT_CD," ).append("\n"); 
		query.append("            SUBSTR(T2.YD_CD, 6, 2) MSS_YD_CD , T2.VPS_ETB_DT , T2.CLPT_IND_SEQ," ).append("\n"); 
		query.append("            DECODE((SELECT DISTINCT 'X' FROM FCM_DEP_RPT WHERE VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("                                    AND SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    AND SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    AND DEP_PORT_CD=T2.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ=T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                    ), 'X', 1, 0) DEP_RPT_CNT" ).append("\n"); 
		query.append("        FROM VSK_VSL_SKD T1, VSK_VSL_PORT_SKD T2, MDM_VSL_SVC_LANE T3, MDM_VSL_CNTR T4 " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND T1.VSL_SLAN_CD=T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND T1.VSL_CD=T4.VSL_CD" ).append("\n"); 
		query.append("        AND T3.VSL_SVC_TP_CD<>'O'" ).append("\n"); 
		query.append("        AND NVL(T1.ACT_CRR_CD, T4.CRR_CD)='HJS'" ).append("\n"); 
		query.append("        AND T2.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("        AND NVL(T2.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("        #if( ${fm_dt} != '' )" ).append("\n"); 
		query.append("            AND T2.VPS_ETD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYY-MM-DD')     -- UI Condition : Period From" ).append("\n"); 
		query.append("            AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYY-MM-DD')+0.99999 -- UI Condition : Period To" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if( ${vsl_slan_cd} != '' )								  " ).append("\n"); 
		query.append("        -- UI Condition : Lane Code" ).append("\n"); 
		query.append("            AND T1.VSL_SLAN_CD IN (                     " ).append("\n"); 
		query.append("                #foreach($sVslSlanCd in ${vel_vsl_slan_cd})  " ).append("\n"); 
		query.append("                    '$sVslSlanCd',  " ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                    '') " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("            -- UI Condition : Vessel Code" ).append("\n"); 
		query.append("            AND T1.VSL_CD IN (                     " ).append("\n"); 
		query.append("                #foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("                    '$sVslCd',  " ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                    '') " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if( ${vps_port_cd} != '' )" ).append("\n"); 
		query.append("            -- UI Condition : Port Code" ).append("\n"); 
		query.append("            AND T2.VPS_PORT_CD IN (                     " ).append("\n"); 
		query.append("                #foreach($sVpsPortCd in ${vel_vps_port_cd})  " ).append("\n"); 
		query.append("                    '$sVpsPortCd',  " ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                    '') " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if( ${skd_dir_cd} != '' )" ).append("\n"); 
		query.append("            -- UI Condition : Direction Code" ).append("\n"); 
		query.append("            AND T1.SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ORDER BY VSL_SLAN_CD                    " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND DEP_RPT_CNT = 0" ).append("\n"); 

	}
}