/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselReportDBDAOSearchVslPortSkdRSQL.java
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

public class VesselReportDBDAOSearchVslPortSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PK Cleansing 화면의 SKD 조회 쿼리
	  * next port를 위해 +30->45로 변경
	  * </pre>
	  */
	public VesselReportDBDAOSearchVslPortSkdRSQL(){
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
		query.append("FileName : VesselReportDBDAOSearchVslPortSkdRSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("     , T1.VSL_CD" ).append("\n"); 
		query.append("     , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("     , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("     , T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , T1.SKD_VOY_NO || T1.SKD_DIR_CD SKD_VOY_DIR" ).append("\n"); 
		query.append("     , T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , T2.VPS_PORT_CD" ).append("\n"); 
		query.append("     , T2.VPS_PORT_CD DEP_PORT_CD" ).append("\n"); 
		query.append("--   , LEAD(T2.VPS_PORT_CD, 1) OVER(ORDER BY T1.VSL_SLAN_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T2.CLPT_SEQ) NXT_PORT_CD" ).append("\n"); 
		query.append("     , LEAD(T2.VPS_PORT_CD  ) OVER (PARTITION BY T2.VSL_CD ORDER BY T2.SKD_VOY_NO, T5.VSL_SLAN_DIR_SEQ, T2.CLPT_SEQ) AS NXT_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(T2.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("	 , NVL2(R.CLPT_IND_SEQ, 'O', 'X') MTC_YN" ).append("\n"); 
		query.append("--	 , '' FM_DT" ).append("\n"); 
		query.append("--	 , '' TO_DT" ).append("\n"); 
		query.append("     , CLPT_SEQ" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE T3" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR T4" ).append("\n"); 
		query.append("	 , FCM_DEP_RPT R" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE_DIR T5" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("   AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND T1.VSL_SLAN_CD = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND T1.VSL_CD = T4.VSL_CD" ).append("\n"); 
		query.append("   AND T2.SLAN_CD          = T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND T2.SKD_DIR_CD       = T5.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("   AND NVL(T2.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("   AND T3.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("   AND NVL(T1.ACT_CRR_CD, T4.CRR_CD)='SML'" ).append("\n"); 
		query.append("   AND T2.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("   AND T2.VSL_CD = R.VSL_CD(+)" ).append("\n"); 
		query.append("   AND T2.SKD_VOY_NO = R.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND T2.SKD_DIR_CD = R.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND T2.VPS_PORT_CD = R.DEP_PORT_CD(+)" ).append("\n"); 
		query.append("   AND T2.CLPT_IND_SEQ = R.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("-- 화면조건 : FM_DT, TO_DT" ).append("\n"); 
		query.append("   AND T2.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 45  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("-- 화면조건 : vsl_slan_cd" ).append("\n"); 
		query.append("	AND T1.VSL_SLAN_CD IN (" ).append("\n"); 
		query.append("	#foreach($sVslSlanCd in ${vel_vsl_slan_cd})" ).append("\n"); 
		query.append("		'$sVslSlanCd'," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("-- 화면조건 : vsl_cd" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (                     " ).append("\n"); 
		query.append("	#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("		'$sVslCd',  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("		'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vps_port_cd} != '' )" ).append("\n"); 
		query.append("-- 화면조건 : vps_port_cd" ).append("\n"); 
		query.append("    AND T2.VPS_PORT_CD IN (                     " ).append("\n"); 
		query.append("	#foreach($sVslPortCd in ${vel_vps_port_cd})  " ).append("\n"); 
		query.append("		'$sVslPortCd',  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("		'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd} != '')" ).append("\n"); 
		query.append("-- 화면조건 : skd_dir_cd" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("-- 화면조건 : FM_DT, TO_DT" ).append("\n"); 
		query.append("   AND VPS_ETD_DT <= @[to_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VPS_ETD_DT" ).append("\n"); 

	}
}