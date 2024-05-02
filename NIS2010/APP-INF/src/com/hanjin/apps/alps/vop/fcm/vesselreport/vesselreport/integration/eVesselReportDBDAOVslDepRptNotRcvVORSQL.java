/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : eVesselReportDBDAOVslDepRptNotRcvVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
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

public class eVesselReportDBDAOVslDepRptNotRcvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0001. Departure RPT 탭 - Not Received
	  * </pre>
	  */
	public eVesselReportDBDAOVslDepRptNotRcvVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : eVesselReportDBDAOVslDepRptNotRcvVORSQL").append("\n"); 
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
		query.append("T2.SLAN_CD VSL_SLAN_CD," ).append("\n"); 
		query.append("T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("T2.VPS_PORT_CD MSS_PORT_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD T1, VSK_VSL_PORT_SKD T2, MDM_VSL_SVC_LANE T3, MDM_VSL_CNTR T4" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("-- 기본 조건" ).append("\n"); 
		query.append("AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD=T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD=T4.VSL_CD" ).append("\n"); 
		query.append("AND T3.VSL_SVC_TP_CD<>'O'" ).append("\n"); 
		query.append("AND NVL(T1.ACT_CRR_CD, T4.CRR_CD)='SML'" ).append("\n"); 
		query.append("AND T2.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' FROM FCM_DEP_RPT" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND T2.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("                AND T2.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("                AND T2.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("                AND T2.VPS_PORT_CD=DEP_PORT_CD" ).append("\n"); 
		query.append("                AND T2.CLPT_IND_SEQ=CLPT_IND_SEQ)" ).append("\n"); 
		query.append("-- 화면 조건 >>>" ).append("\n"); 
		query.append("#if( ${fm_dt} != '' )" ).append("\n"); 
		query.append("    AND T2.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD')     -- 화면조건 : FM_DT" ).append("\n"); 
		query.append("                      AND TO_DATE(@[to_dt], 'YYYY-MM-DD')+0.99999 -- 화면조건 : TO_DT" ).append("\n"); 
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
		query.append("    AND T2.VPS_PORT_CD=@[vps_port_cd]                           -- 화면조건 : VPS_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${skd_dir_cd} != '' )" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD=@[skd_dir_cd]                             -- 화면조건 : SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

	}
}