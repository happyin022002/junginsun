/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL").append("\n"); 
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
		query.append("SELECT  T1.VSL_CD" ).append("\n"); 
		query.append("        , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		, T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        , T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , T1.CLPT_SEQ" ).append("\n"); 
		query.append("        , T1.SLAN_CD" ).append("\n"); 
		query.append("        , T1.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("        , T1.YD_CD" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("			SELECT YD_NM FROM MDM_YARD" ).append("\n"); 
		query.append("			 WHERE LOC_CD = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("			   AND YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("	     ) AS YD_NM" ).append("\n"); 
		query.append("        , T1.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("        , TO_CHAR(T1.PF_ETA_DT, 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.INIT_ETA_DT, 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.INIT_ETB_DT, 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.INIT_ETD_DT, 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("        , T1.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("        , T1.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("        , T1.VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("        , T1.SHP_CALL_NO" ).append("\n"); 
		query.append("        , T1.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("        , T1.SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append("        , T1.TML_VSL_CD" ).append("\n"); 
		query.append("        , T1.TML_VOY_NO" ).append("\n"); 
		query.append("        , TO_CHAR(T1.FT_DT, 'YYYYMMDDHH24MI') AS FT_DT" ).append("\n"); 
		query.append("		, NVL(TO_CHAR(T1.FT_DT, 'YYYYMMDDHH24MI'),  DECODE(SUBSTR(T1.VPS_PORT_CD, 1, 2), 'KR', TO_CHAR((T1.VPS_ETB_DT - 5), 'YYYYMMDDHH24MI'), NULL)) AS FREE_TM_DT" ).append("\n"); 
		query.append("        , T1.PLISM_YD_CD" ).append("\n"); 
		query.append("        , T1.PLISM_VSL_CD" ).append("\n"); 
		query.append("        , T1.PLISM_VOY_NO" ).append("\n"); 
		query.append("		, T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("        , T1.TURN_PORT_FLG" ).append("\n"); 
		query.append("        , T1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        , T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("        , T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("        , T1.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , T1.IB_CGO_QTY" ).append("\n"); 
		query.append("        , T1.OB_CGO_QTY" ).append("\n"); 
		query.append("		, NVL(T1.IB_CGO_QTY, 0) + NVL(T1.OB_CGO_QTY, 0) AS CGO_TTL" ).append("\n"); 
		query.append("        , T1.VPS_RMK" ).append("\n"); 
		query.append("        , RTRIM(REPLACE(T1.VPS_RMK, CHR(13)||CHR(10),' ')) AS WIN_RMK 	/* 화면 조회 용 */" ).append("\n"); 
		query.append("        , T1.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("        , T1.PHS_IO_RMK" ).append("\n"); 
		query.append("        , T1.SKD_BRTH_NO" ).append("\n"); 
		query.append("        , T1.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append("        , T1.OFC_INP_FLG" ).append("\n"); 
		query.append("        , T1.NOON_RPT_INP_FLG" ).append("\n"); 
		query.append("        , T1.DEP_RPT_INP_FLG" ).append("\n"); 
		query.append("        , T1.ACT_INP_FLG" ).append("\n"); 
		query.append("        , T1.PRT_CHK_FLG" ).append("\n"); 
		query.append("        , T1.CRE_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("        , T1.UPD_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(T1.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.UPD_DT, 'YYYYMMDDHH24MI') AS UPD_DT_TXT" ).append("\n"); 
		query.append("        , T1.EDI_SND_KNT" ).append("\n"); 
		query.append("        , T1.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("        , T1.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("        , T1.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append("        , T1.TTL_DLAY_HRS" ).append("\n"); 
		query.append("        , T1.TS_PORT_CD" ).append("\n"); 
		query.append("        , T1.USD_FLG" ).append("\n"); 
		query.append("        , NVL(T1.LNK_SPD, 0) AS LNK_SPD" ).append("\n"); 
		query.append("		, NVL(T1.SEA_BUF_HRS, 0) AS SEA_BUF_HRS" ).append("\n"); 
		query.append("		, NVL(T1.PORT_BUF_HRS, 0) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("		, NVL(T1.TZTM_HRS, 0) AS TZTM_HRS" ).append("\n"); 
		query.append("		, NVL(T1.PORT_WRK_HRS, 0) AS ACT_WRK_HRS" ).append("\n"); 
		query.append("		, NVL(T1.LNK_DIST, 0) AS LNK_DIST" ).append("\n"); 
		query.append("		, NVL(T1.MNVR_OUT_HRS, 0) AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("		, NVL(T1.MNVR_IN_HRS, 0) AS MNVR_IN_HRS" ).append("\n"); 
		query.append("		, T2.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("		, '' AS LANE_GRP" ).append("\n"); 
		query.append("		, '' AS LANE_GRP_NM" ).append("\n"); 
		query.append("		, '' AS USR_ID" ).append("\n"); 
		query.append("		, '' AS FM_DT" ).append("\n"); 
		query.append("		, '' AS TO_DT" ).append("\n"); 
		query.append("		, '' AS EXT_MSG_FLG" ).append("\n"); 
		query.append("		, '' AS USR_INFO" ).append("\n"); 
		query.append("		, '' AS PORT_POS" ).append("\n"); 
		query.append("		, '' AS HEADER_SEQ" ).append("\n"); 
		query.append("		, '' AS DIFF_RMK" ).append("\n"); 
		query.append("		, '' AS USR_NM" ).append("\n"); 
		query.append("		, '' AS MPHN_NO" ).append("\n"); 
		query.append("		, '' AS FAX_NO" ).append("\n"); 
		query.append("		, '' AS USR_EML" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("			SELECT  UQ_VSL_ID_NO" ).append("\n"); 
		query.append("			FROM    BKG_VSL_DCHG_YD" ).append("\n"); 
		query.append("			WHERE   VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("			AND     SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND     SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND     PORT_CD = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND     CLPT_IND_SEQ = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			AND		ROWNUM = 1" ).append("\n"); 
		query.append("		  ) AS UQ_VSL_ID_NO" ).append("\n"); 
		query.append("	   	, (" ).append("\n"); 
		query.append("			SELECT  'X'" ).append("\n"); 
		query.append("			FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("			WHERE   VSL_CD           = T1.VSL_CD" ).append("\n"); 
		query.append("			AND     SKD_VOY_NO       = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND     SKD_DIR_CD       = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND     CLPT_SEQ         > T1.CLPT_SEQ" ).append("\n"); 
		query.append("			AND     ACT_INP_FLG = 'Y'" ).append("\n"); 
		query.append("			AND     ROWNUM = 1" ).append("\n"); 
		query.append("	   	  ) AS BFR_ACT_FLG" ).append("\n"); 
		query.append("        , DECODE(TO_CHAR(T1.PF_ETA_DT, 'D'), 1, 'SUN', 2, 'MON', 3, 'TUE', 4, 'WED', 5, 'THU', 6, 'FRI', 7, 'SAT')  AS PF_ETA_DY" ).append("\n"); 
		query.append("        , DECODE(TO_CHAR(T1.PF_ETB_DT, 'D'), 1, 'SUN', 2, 'MON', 3, 'TUE', 4, 'WED', 5, 'THU', 6, 'FRI', 7, 'SAT')  AS PF_ETB_DY" ).append("\n"); 
		query.append("        , DECODE(TO_CHAR(T1.PF_ETD_DT, 'D'), 1, 'SUN', 2, 'MON', 3, 'TUE', 4, 'WED', 5, 'THU', 6, 'FRI', 7, 'SAT')  AS PF_ETD_DY" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("             WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			   AND CLPT_SEQ||VPS_ETA_DT = (SELECT MIN(T21.CLPT_SEQ || T21.VPS_ETA_DT)" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD T21" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND CLPT_SEQ > TO_CHAR(TO_NUMBER(T1.CLPT_SEQ), '99')" ).append("\n"); 
		query.append("                                   AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("          ) AS NXT_PORT_CD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(T11.VPS_ETA_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("             WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			   AND CLPT_SEQ||VPS_ETA_DT = (SELECT MIN(T21.CLPT_SEQ || T21.VPS_ETA_DT)" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD T21" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND CLPT_SEQ > TO_CHAR(TO_NUMBER(T1.CLPT_SEQ), '99')" ).append("\n"); 
		query.append("                                   AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("          ) AS NXT_ETA_DT" ).append("\n"); 
		query.append("        , (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) AS VSL_ENG_NM" ).append("\n"); 
		query.append("  FROM  VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("		, (SELECT * FROM MDM_VSL_SVC_LANE WHERE DELT_FLG = 'N' AND VSL_TP_CD = 'C') T2" ).append("\n"); 
		query.append(" WHERE	1 = 1" ).append("\n"); 
		query.append("   AND  (T1.SKD_CNG_STS_CD IS NULL OR T1.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("   AND  T1.TURN_PORT_IND_CD NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("   AND	T1.SLAN_CD          = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("   AND	T1.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '' && ${skd_dir_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND	T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("   AND	T1.YD_CD IN (" ).append("\n"); 
		query.append("	#foreach( $key IN ${yd_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $yd_cd.size())" ).append("\n"); 
		query.append("  		'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane_grp} == 'L')" ).append("\n"); 
		query.append("	#if (${slan_cd} != '')" ).append("\n"); 
		query.append("   AND	T1.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${lane_grp} == 'G')" ).append("\n"); 
		query.append("   AND	T1.SLAN_CD IN (" ).append("\n"); 
		query.append("						SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("						FROM VSK_USR_LANE_GRP" ).append("\n"); 
		query.append("						WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("						AND LANE_GRP_NM = @[lane_grp_nm]" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND	T1.VPS_ETB_DT BETWEEN	TO_DATE(@[fm_dt], 'YYYY-MM-DD')	AND	TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == 'O')" ).append("\n"); 
		query.append("   AND  T2.VSL_SVC_TP_CD 		= 'O'" ).append("\n"); 
		query.append("#elseif (${vsl_svc_tp_cd} == 'T') " ).append("\n"); 
		query.append("   AND  T2.VSL_SVC_TP_CD 		!= 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY T1.SLAN_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD" ).append("\n"); 

	}
}