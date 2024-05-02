/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOVslNoonRptVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.11 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOVslNoonRptVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 조건에 대한 Lane별 Noon Report 현황을 조회한다.
	  * </pre>
	  */
	public VesselReportDBDAOVslNoonRptVORSQL(){
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
		query.append("FileName : VesselReportDBDAOVslNoonRptVORSQL").append("\n"); 
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
		query.append("SLAN_CD VSL_SLAN_CD," ).append("\n"); 
		query.append("SUM(VVD_CNT) VVD_CNT," ).append("\n"); 
		query.append("SUM(PORT_DAYS) PORT_DAYS," ).append("\n"); 
		query.append("SUM(SEA_DAYS) SEA_DAYS," ).append("\n"); 
		query.append("SUM(NOON_RPT_CNT) NOON_RPT_CNT," ).append("\n"); 
		query.append("SUM(SEA_DAYS)-SUM(NOON_RPT_CNT) MSS_RPT_CNT," ).append("\n"); 
		query.append("(SELECT COUNT(*) FROM FCM_NOON_RPT T1" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND (T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD) NOT IN" ).append("\n"); 
		query.append("         (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM VSK_VSL_PORT_SKD)" ).append("\n"); 
		query.append(" AND T1.VSL_SLAN_CD=SLAN_CD" ).append("\n"); 
		query.append("#if (${fm_dt} != '') " ).append("\n"); 
		query.append(" AND NOON_RPT_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD')     -- 화면조건 : FM_DT" ).append("\n"); 
		query.append("                 AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD')+0.99999 -- 화면조건 : TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("	-- 화면조건 : VSL_CD" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("			'$sVslCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD=@[skd_dir_cd]                                        -- 화면조건 : SKD_DIR_CD" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append(" ) MSS_MTCH_RPT_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    DECODE(ROW_NUMBER() OVER(PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY T2.VSL_CD), 1, 1, 0) VVD_CNT," ).append("\n"); 
		query.append("    DECODE((SELECT DISTINCT 'X' FROM FCM_NOON_RPT WHERE VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("                                         AND SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                         AND SKD_DIR_CD=T2.SKD_DIR_CD), 'X', 1, 0) NOON_RPT_CNT," ).append("\n"); 
		query.append("    (TRUNC(T2.VPS_ETD_DT-T2.VPS_ETA_DT) + " ).append("\n"); 
		query.append("        DECODE(SIGN(TO_CHAR(T2.VPS_ETA_DT,'HH24')-'12'), -1, 1, 0) +" ).append("\n"); 
		query.append("        DECODE(SIGN(TO_CHAR(T2.VPS_ETD_DT,'HH24')-'12'), 1, 1, 0) +" ).append("\n"); 
		query.append("        DECODE(SIGN(TO_CHAR(T2.VPS_ETD_DT, 'HH24')-TO_CHAR(T2.VPS_ETA_DT, 'HH24')), 1, -1, 0)) PORT_DAYS," ).append("\n"); 
		query.append("    0 SEA_DAYS," ).append("\n"); 
		query.append("    T2.*" ).append("\n"); 
		query.append("    FROM VSK_VSL_SKD T1, VSK_VSL_PORT_SKD T2, MDM_VSL_SVC_LANE T3, MDM_VSL_CNTR T4" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    -- 기본 조건" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.VSL_SLAN_CD=T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T4.VSL_CD" ).append("\n"); 
		query.append("    AND T3.VSL_SVC_TP_CD<>'O'" ).append("\n"); 
		query.append("    AND NVL(T1.ACT_CRR_CD, T4.CRR_CD)='HJS'" ).append("\n"); 
		query.append("    AND T2.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("#if (${fm_dt} != '') " ).append("\n"); 
		query.append("    AND T2.VPS_ETD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD')     -- 화면조건 : FM_DT" ).append("\n"); 
		query.append("                      AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD')+0.99999 -- 화면조건 : TO_DT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_slan_cd} != '' )								  " ).append("\n"); 
		query.append("	-- 화면조건 : VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.VSL_SLAN_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslSlanCd in ${vel_vsl_slan_cd})  " ).append("\n"); 
		query.append("			'$sVslSlanCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("	-- 화면조건 : VSL_CD" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("			'$sVslCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vps_port_cd} != '' )" ).append("\n"); 
		query.append("	-- 화면조건 : VPS_PORT_CD" ).append("\n"); 
		query.append("    AND T2.VPS_PORT_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVpsPortCd in ${vel_vps_port_cd})  " ).append("\n"); 
		query.append("			'$sVpsPortCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD=@[skd_dir_cd]                                        -- 화면조건 : SKD_DIR_CD" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY SLAN_CD" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

	}
}