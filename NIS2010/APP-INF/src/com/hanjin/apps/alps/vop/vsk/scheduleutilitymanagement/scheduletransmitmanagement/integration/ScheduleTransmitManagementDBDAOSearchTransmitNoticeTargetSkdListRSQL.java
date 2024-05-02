/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ScheduleTransmitManagementDBDAOSearchTransmitNoticeTargetSkdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleTransmitManagementDBDAOSearchTransmitNoticeTargetSkdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ETA Sending(Auto-fax) 대상 및 Pre-Stowage Notice 대상 Schedule을 조회합니다.
	  * </pre>
	  */
	public ScheduleTransmitManagementDBDAOSearchTransmitNoticeTargetSkdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_purp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleTransmitManagementDBDAOSearchTransmitNoticeTargetSkdListRSQL").append("\n"); 
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
		query.append("SELECT		" ).append("\n"); 
		query.append("			XX.VPS_PORT_CD" ).append("\n"); 
		query.append("		,	XX.YD_CD" ).append("\n"); 
		query.append("		,	XX.YD_NM" ).append("\n"); 
		query.append("		,	XX.SLAN_CD" ).append("\n"); 
		query.append("		,	XX.VVD" ).append("\n"); 
		query.append("		,	XX.VSL_CD" ).append("\n"); 
		query.append("		,	XX.SKD_VOY_NO" ).append("\n"); 
		query.append("		,	XX.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	XX.VSL_ENG_NM" ).append("\n"); 
		query.append("		,	XX.ACT_CRR_CD" ).append("\n"); 
		query.append("		,	XX.VPS_ETA_DT" ).append("\n"); 
		query.append("		,	XX.VPS_ETB_DT" ).append("\n"); 
		query.append("		,	XX.VPS_ETD_DT" ).append("\n"); 
		query.append("		,	XX.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,	XX.VPS_PORT_CD" ).append("\n"); 
		query.append("		,	XX.PORT_NM" ).append("\n"); 
		query.append("		,	XX.TRSM_HIS_SEQ" ).append("\n"); 
		query.append("		,	XX.TRSM_MZD_CD" ).append("\n"); 
		query.append("		,	XX.TRSM_OWNR_CD" ).append("\n"); 
		query.append("		,	XX.NTC_ETA_DT" ).append("\n"); 
		query.append("		,	XX.NTC_ETB_DT" ).append("\n"); 
		query.append("		,	XX.NTC_ETD_DT" ).append("\n"); 
		query.append("		,	XX.TRSM_RSN" ).append("\n"); 
		query.append("		,	XX.VSL_FAX_NO" ).append("\n"); 
		query.append("		,	XX.VSL_TLX_NO" ).append("\n"); 
		query.append("		,	XX.VSL_EML" ).append("\n"); 
		query.append("		,	XX.DFLT_FAX_IMST_CD" ).append("\n"); 
		query.append("		,	XX.DFLT_TLX_IMST_CD" ).append("\n"); 
		query.append("		,	XX.VSL_FAX_TRSM_EML" ).append("\n"); 
		query.append("		,	XX.VSL_TLX_TRSM_EML" ).append("\n"); 
		query.append("		,	XX.TRSM_LOCL_DT" ).append("\n"); 
		query.append("		,	XX.SKD_TRSM_STS_CD" ).append("\n"); 
		query.append("		,	XX.SKD_TRSM_STS_CD" ).append("\n"); 
		query.append("		,	XX.RPM_ADJ_DT" ).append("\n"); 
		query.append("		,	XX.ORG_RPM_PWR" ).append("\n"); 
		query.append("		,	XX.CRNT_RPM_PWR" ).append("\n"); 
		query.append("		,	XX.ESVC_VNDR_SEQ" ).append("\n"); 
		query.append("		,	XX.CRE_USR_ID" ).append("\n"); 
		query.append("		,	XX.LOCL_CRE_DT" ).append("\n"); 
		query.append("		,	XX.UPD_USR_ID" ).append("\n"); 
		query.append("		,	XX.LOCL_UPD_DT" ).append("\n"); 
		query.append("		,	XX.AUTO_FAX_POP  " ).append("\n"); 
		query.append("		,	XX.CONTI_CD" ).append("\n"); 
		query.append("	    ,   VSK_GET_LANE_PIC_EML_FNC(XX.SLAN_CD, XX.VPS_PORT_CD)   AS LANE_PIC_EML" ).append("\n"); 
		query.append("		,	XX.TRSM_PURP_CD" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("          --====================================================================================" ).append("\n"); 
		query.append("			SELECT T2.VPS_PORT_CD" ).append("\n"); 
		query.append("			    , T2.YD_CD" ).append("\n"); 
		query.append("			    , (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = T2.YD_CD) YD_NM" ).append("\n"); 
		query.append("			    , T1.VSL_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("			    , T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("			    , T2.VSL_CD" ).append("\n"); 
		query.append("			    , T2.SKD_VOY_NO" ).append("\n"); 
		query.append("			    , T2.SKD_DIR_CD" ).append("\n"); 
		query.append("			    , T3.VSL_ENG_NM" ).append("\n"); 
		query.append("			    , NVL(T1.ACT_CRR_CD, T3.CRR_CD) ACT_CRR_CD" ).append("\n"); 
		query.append("			    , TO_CHAR(T2.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("			    , TO_CHAR(T2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append("			    , TO_CHAR(T2.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("			    , T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			    , (CASE WHEN TO_NUMBER(T2.CLPT_IND_SEQ)=1 THEN T2.VPS_PORT_CD" ).append("\n"); 
		query.append("			      ELSE T2.VPS_PORT_CD||'('||T2.CLPT_IND_SEQ||')'" ).append("\n"); 
		query.append("			      END) PORT_NM" ).append("\n"); 
		query.append("			    , T4.TRSM_HIS_SEQ" ).append("\n"); 
		query.append("			    , T4.TRSM_MZD_CD" ).append("\n"); 
		query.append("			    , T4.TRSM_OWNR_CD" ).append("\n"); 
		query.append("			    , TO_CHAR(T4.NTC_ETA_DT, 'YYYY-MM-DD HH24:MI') NTC_ETA_DT" ).append("\n"); 
		query.append("			    , TO_CHAR(T4.NTC_ETB_DT, 'YYYY-MM-DD HH24:MI') NTC_ETB_DT" ).append("\n"); 
		query.append("			    , TO_CHAR(T4.NTC_ETD_DT, 'YYYY-MM-DD HH24:MI') NTC_ETD_DT" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			    , T4.TRSM_RSN" ).append("\n"); 
		query.append("			    , VSK_REMOVE_NONE_NUMERIC_FNC(T3.FAX_NO, 'FAX_TELEX') VSL_FAX_NO" ).append("\n"); 
		query.append("			    , VSK_REMOVE_NONE_NUMERIC_FNC(T3.TLX_NO, 'FAX_TELEX') VSL_TLX_NO" ).append("\n"); 
		query.append("			    , T3.VSL_EML" ).append("\n"); 
		query.append("			    , CASE WHEN (T5.LON_UT_CD='E' AND T5.LOC_LON<25) OR (T5.LON_UT_CD='W' AND T5.LOC_LON<=35) THEN '871' -- AOR-E 대서양 동부" ).append("\n"); 
		query.append("			           WHEN (T5.LON_UT_CD='E' AND T5.LOC_LON>=120) OR (T5.LON_UT_CD='W' AND T5.LOC_LON>115) THEN '872' -- POR 태평양" ).append("\n"); 
		query.append("			           WHEN T5.LON_UT_CD='E' AND T5.LOC_LON>=25 AND T5.LOC_LON<120 THEN '873' -- IOR 인도양" ).append("\n"); 
		query.append("			           WHEN T5.LON_UT_CD='W' AND T5.LOC_LON>35 AND T5.LOC_LON<=115 THEN '874' -- AOR-W 대서양 서부" ).append("\n"); 
		query.append("			           ELSE '870'" ).append("\n"); 
		query.append("			      END AS DFLT_FAX_IMST_CD" ).append("\n"); 
		query.append("			    , CASE WHEN (T5.LON_UT_CD='E' AND T5.LOC_LON<25) OR (T5.LON_UT_CD='W' AND T5.LOC_LON<=35) THEN '0581'" ).append("\n"); 
		query.append("			           WHEN (T5.LON_UT_CD='E' AND T5.LOC_LON>=120) OR (T5.LON_UT_CD='W' AND T5.LOC_LON>115) THEN '0582'" ).append("\n"); 
		query.append("			           WHEN T5.LON_UT_CD='E' AND T5.LOC_LON>=25 AND T5.LOC_LON<120 THEN '0583'" ).append("\n"); 
		query.append("			           WHEN T5.LON_UT_CD='W' AND T5.LOC_LON>35 AND T5.LOC_LON<=115 THEN '0584'" ).append("\n"); 
		query.append("			           ELSE ''" ).append("\n"); 
		query.append("			      END AS DFLT_TLX_IMST_CD" ).append("\n"); 
		query.append("			    , T4.VSL_FAX_TRSM_EML" ).append("\n"); 
		query.append("			    , T4.VSL_TLX_TRSM_EML" ).append("\n"); 
		query.append("			    , TO_CHAR(T4.TRSM_LOCL_DT, 'YYYY-MM-DD HH24:MI') TRSM_LOCL_DT" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			    --, DECODE(T4.SKD_TRSM_STS_CD, 'SN', 'Success', '') SKD_TRSM_STS_CD" ).append("\n"); 
		query.append("			    , DECODE ( (SELECT	EML_PROC_STS_CD" ).append("\n"); 
		query.append("			              	FROM	COM_EML_SND_INFO	EL" ).append("\n"); 
		query.append("				          	WHERE	EL.EML_SND_NO		= T4.EML_SND_NO)" ).append("\n"); 
		query.append("							, '1', 'Waiting'" ).append("\n"); 
		query.append("							, '2', 'Processing'" ).append("\n"); 
		query.append("							, '3', 'Success'" ).append("\n"); 
		query.append("							, '4', 'Failed'" ).append("\n"); 
		query.append("							, ''" ).append("\n"); 
		query.append("						) 								AS SKD_TRSM_STS_CD" ).append("\n"); 
		query.append("			    , TO_CHAR(T4.RPM_ADJ_DT, 'YYYY-MM-DD HH24:MI') AS RPM_ADJ_DT" ).append("\n"); 
		query.append("			    , T4.ORG_RPM_PWR" ).append("\n"); 
		query.append("			    , T4.CRNT_RPM_PWR" ).append("\n"); 
		query.append("			    , T4.ESVC_VNDR_SEQ" ).append("\n"); 
		query.append("			    , T4.CRE_USR_ID" ).append("\n"); 
		query.append("			    , T4.LOCL_CRE_DT" ).append("\n"); 
		query.append("			    , T4.UPD_USR_ID" ).append("\n"); 
		query.append("			    , T4.LOCL_UPD_DT" ).append("\n"); 
		query.append("			    , 0 auto_fax_pop" ).append("\n"); 
		query.append("            	, T5.CONTI_CD" ).append("\n"); 
		query.append("				, T4.TRSM_PURP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM  VSK_VSL_SKD               	T1" ).append("\n"); 
		query.append("			    , VSK_VSL_PORT_SKD          	T2" ).append("\n"); 
		query.append("			    , MDM_VSL_CNTR              	T3" ).append("\n"); 
		query.append("			    , VSK_VSL_PORT_SKD_TRSM_HIS 	T4" ).append("\n"); 
		query.append("			    , MDM_LOCATION              	T5" ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("        	AND   T1.VSL_CD          			= T2.VSL_CD" ).append("\n"); 
		query.append("        	AND   T1.SKD_VOY_NO      			= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        	AND   T1.SKD_DIR_CD      			= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        	AND   T1.VSL_CD          			= T3.VSL_CD" ).append("\n"); 
		query.append("        	AND   T2.VPS_PORT_CD     			= T5.LOC_CD" ).append("\n"); 
		query.append("        	AND   T2.VSL_CD          			= T4.VSL_CD(+)" ).append("\n"); 
		query.append("        	AND   T2.SKD_VOY_NO      			= T4.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        	AND   T2.SKD_DIR_CD      			= T4.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        	AND   T2.VPS_PORT_CD     			= T4.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("        	AND   T2.CLPT_IND_SEQ    			= T4.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("        	AND   NVL(T4.TRSM_HIS_SEQ,0) 		>= (SELECT 	NVL(MAX(T.TRSM_HIS_SEQ),0) " ).append("\n"); 
		query.append("													FROM 	VSK_VSL_PORT_SKD_TRSM_HIS 	T" ).append("\n"); 
		query.append("													WHERE 	T.VSL_CD 					= T2.VSL_CD" ).append("\n"); 
		query.append("													AND 	T.SKD_VOY_NO 				= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("													AND 	T.SKD_DIR_CD 				= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("													AND 	T.VPS_PORT_CD 				= T2.VPS_PORT_CD" ).append("\n"); 
		query.append("													AND 	T.CLPT_IND_SEQ 				= T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("													AND		T.TRSM_PURP_CD				= @[trsm_purp_cd]" ).append("\n"); 
		query.append("			                              		)" ).append("\n"); 
		query.append("			AND NVL(T2.SKD_CNG_STS_CD,' ') 		<> 'S'" ).append("\n"); 
		query.append("			AND T2.TURN_PORT_IND_CD 			IN ('Y','N')" ).append("\n"); 
		query.append("			#if (${fm_eta_dt} != '' && ${to_eta_dt} != '') " ).append("\n"); 
		query.append("			AND T2.VPS_ETA_DT 					BETWEEN TO_DATE(@[fm_eta_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eta_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--AND NVL(T1.ACT_CRR_CD, T3.CRR_CD) 	= [act_crr_cd]" ).append("\n"); 
		query.append("			AND NVL(T1.ACT_CRR_CD, T3.CRR_CD) 	= 'SML'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("			AND T2.VPS_PORT_CD 					= @[vps_port_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${slan_cd} != '') " ).append("\n"); 
		query.append("			AND T1.VSL_SLAN_CD 					= @[slan_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("			AND T1.VSL_CD 						= @[vsl_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("			AND T1.SKD_VOY_NO 					= @[skd_voy_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("			AND T1.SKD_DIR_CD 					= @[skd_dir_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND T4.TRSM_PURP_CD	  (+)			= @[trsm_purp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          --====================================================================================  " ).append("\n"); 
		query.append("          ) XX" ).append("\n"); 
		query.append("WHERE     1 = 1           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY  XX.VPS_PORT_CD" ).append("\n"); 
		query.append("      ,   XX.VSL_CD" ).append("\n"); 
		query.append("      ,   XX.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,   XX.SKD_DIR_CD" ).append("\n"); 

	}
}