/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.04.14 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 불규칙한 Lane-Ofc-POL 입력
	  * 2011.01.05 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 
	  * 2013.05.20 진마리아 [CHM-201324741-01] Lane Office POL 화면 로직 보완 - validation 및 error handling
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2015.04.14 Arie Im [CHM-201535311] "IMU"노선에 대한 T/S적용 예외 룰 삭제 요청
	  * </pre>
	  */
	public BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_IRR_FCAST_OFC_POL_MAPG ( " ).append("\n"); 
		query.append("    REP_TRD_CD    ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD," ).append("\n"); 
		query.append("    RLANE_CD      ," ).append("\n"); 
		query.append("    DIR_CD        ," ).append("\n"); 
		query.append("    IOC_TS_CD     ," ).append("\n"); 
		query.append("    VSL_CD        ," ).append("\n"); 
		query.append("    SKD_VOY_NO    ," ).append("\n"); 
		query.append("    SKD_DIR_CD    ," ).append("\n"); 
		query.append("    SLS_OFC_CD    ," ).append("\n"); 
		query.append("    POL_CD        ," ).append("\n"); 
		query.append("    CD_DP_SEQ     ," ).append("\n"); 
		query.append("    TRD_CD        ," ).append("\n"); 
		query.append("    SUB_TRD_CD    ," ).append("\n"); 
		query.append("    SLS_RHQ_CD    ," ).append("\n"); 
		query.append("    SLS_AQ_CD     ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("    CRE_USR_ID    ," ).append("\n"); 
		query.append("    CRE_DT        ," ).append("\n"); 
		query.append("    UPD_USR_ID    ," ).append("\n"); 
		query.append("    UPD_DT  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[rep_trd_cd]        AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           @[rep_sub_trd_cd]    AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           @[rlane_cd]          AS RLANE_CD      ," ).append("\n"); 
		query.append("           SUBSTR(@[vvd], 9, 1) AS DIR_CD        ," ).append("\n"); 
		query.append("           DECODE(@[ioc_ts_cd], 'OCN', 'O', 'IPC', 'I', 'T/S', 'T') AS IOC_TS_CD," ).append("\n"); 
		query.append("           SUBSTR(@[vvd], 1, 4) AS VSL_CD    ," ).append("\n"); 
		query.append("           SUBSTR(@[vvd], 5, 4) AS SKD_VOY_NO," ).append("\n"); 
		query.append("           SUBSTR(@[vvd], 9, 1) AS SKD_DIR_CD," ).append("\n"); 
		query.append("           @[sls_ofc_cd]        AS SLS_OFC_CD," ).append("\n"); 
		query.append("           @[pol_cd]            AS POL_CD    ," ).append("\n"); 
		query.append("           @[cre_usr_id]        AS CRE_USR_ID," ).append("\n"); 
		query.append("           @[upd_usr_id]        AS UPD_USR_ID" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT REP_TRD_CD," ).append("\n"); 
		query.append("       REP_SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD," ).append("\n"); 
		query.append("       IOC_TS_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       SLS_OFC_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       CD_DP_SEQ," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       SLS_RHQ_CD," ).append("\n"); 
		query.append("       SLS_AQ_CD," ).append("\n"); 
		query.append("       SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("      SELECT MAX((SELECT REP_TRD_CD FROM PARAMS))     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("             MAX((SELECT REP_SUB_TRD_CD FROM PARAMS)) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("             MAX((SELECT RLANE_CD FROM PARAMS))       AS RLANE_CD      ," ).append("\n"); 
		query.append("             MAX((SELECT DIR_CD FROM PARAMS))         AS DIR_CD        ," ).append("\n"); 
		query.append("             MAX((SELECT IOC_TS_CD FROM PARAMS))      AS IOC_TS_CD     ," ).append("\n"); 
		query.append("             MAX((SELECT VSL_CD FROM PARAMS))         AS VSL_CD        ," ).append("\n"); 
		query.append("             MAX((SELECT SKD_VOY_NO FROM PARAMS))     AS SKD_VOY_NO    ," ).append("\n"); 
		query.append("             MAX((SELECT SKD_DIR_CD FROM PARAMS))     AS SKD_DIR_CD    ," ).append("\n"); 
		query.append("             MAX((SELECT SLS_OFC_CD FROM PARAMS))     AS SLS_OFC_CD    ," ).append("\n"); 
		query.append("             MAX((SELECT POL_CD FROM PARAMS))         AS POL_CD        ," ).append("\n"); 
		query.append("             MAX(CD_DP_SEQ)     AS CD_DP_SEQ," ).append("\n"); 
		query.append("             MAX(TRD_CD)        AS TRD_CD," ).append("\n"); 
		query.append("             MAX(SUB_TRD_CD)    AS SUB_TRD_CD," ).append("\n"); 
		query.append("             MAX((SELECT SOV.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                    FROM SPC_OFC_LVL SOV," ).append("\n"); 
		query.append("                         PARAMS      P  ," ).append("\n"); 
		query.append("                         MAS_MON_VVD C" ).append("\n"); 
		query.append("                   WHERE SOV.OFC_CD   = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                     AND SOV.OFC_CD   = N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                     AND C.TRD_CD     = T.TRD_CD" ).append("\n"); 
		query.append("                     AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                     AND C.IOC_CD     = DECODE(IOC_TS_CD, 'O', 'O', 'I')" ).append("\n"); 
		query.append("                     AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                     AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN SOV.OFC_APLY_FM_YRWK AND SOV.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("             )) AS SLS_RHQ_CD," ).append("\n"); 
		query.append("             MAX((SELECT SOV.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                    FROM SPC_OFC_LVL SOV," ).append("\n"); 
		query.append("                         PARAMS      P  ," ).append("\n"); 
		query.append("                         MAS_MON_VVD C" ).append("\n"); 
		query.append("                   WHERE SOV.OFC_CD   = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                     AND SOV.OFC_CD   = N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                     AND C.TRD_CD     = T.TRD_CD" ).append("\n"); 
		query.append("                     AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                     AND C.IOC_CD     = DECODE(IOC_TS_CD, 'O', 'O', 'I')" ).append("\n"); 
		query.append("                     AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                     AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN SOV.OFC_APLY_FM_YRWK AND SOV.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("             )) AS SLS_AQ_CD," ).append("\n"); 
		query.append("             MAX((SELECT SOV.N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                    FROM SPC_OFC_LVL SOV," ).append("\n"); 
		query.append("                         PARAMS      P  ," ).append("\n"); 
		query.append("                         MAS_MON_VVD C" ).append("\n"); 
		query.append("                   WHERE SOV.OFC_CD   = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                     AND SOV.OFC_CD   = N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                     AND C.TRD_CD     = T.TRD_CD" ).append("\n"); 
		query.append("                     AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                     AND C.IOC_CD     = DECODE(IOC_TS_CD, 'O', 'O', 'I')" ).append("\n"); 
		query.append("                     AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                     AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN SOV.OFC_APLY_FM_YRWK AND SOV.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("             )) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("             MAX((SELECT CRE_USR_ID FROM PARAMS)) AS CRE_USR_ID," ).append("\n"); 
		query.append("             SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("             MAX((SELECT UPD_USR_ID FROM PARAMS)) AS UPD_USR_ID," ).append("\n"); 
		query.append("             SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT TRD_CD    ," ).append("\n"); 
		query.append("                       SUB_TRD_CD," ).append("\n"); 
		query.append("                       NULL AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                       NULL AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("                       NULL AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                       NULL AS CD_DP_SEQ" ).append("\n"); 
		query.append("                  FROM MDM_DTL_REV_LANE MDR," ).append("\n"); 
		query.append("                       PARAMS           P" ).append("\n"); 
		query.append("                 WHERE MDR.RLANE_CD        = P.RLANE_CD" ).append("\n"); 
		query.append("                   AND MDR.FM_CONTI_CD     = SPC_CONTI_CONV_FNC('',P.RLANE_CD,'',P.POL_CD)" ).append("\n"); 
		query.append("                   AND MDR.VSL_SLAN_DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("                   /* 신규 IMU노선 추가에 따른 로직 수정 : DECODE(P.IOC_TS_CD,'T','I',P.IOC_TS_CD) */" ).append("\n"); 
		query.append("                   AND MDR.IOC_CD   = DECODE(P.IOC_TS_CD, 'T', 'I', P.IOC_TS_CD)" ).append("\n"); 
		query.append("				   --AND MDR.IOC_CD   = DECODE(P.IOC_TS_CD, 'T', DECODE(SUBSTR(P.RLANE_CD, 1, 3), 'IMU', 'O', 'I'), P.IOC_TS_CD)" ).append("\n"); 
		query.append("                   AND MDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT NULL AS TRD_CD        ," ).append("\n"); 
		query.append("                       NULL AS SUB_TRD_CD    ," ).append("\n"); 
		query.append("                       NULL AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                       NULL AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("                       NULL AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                       NVL(MAX(H.CD_DP_SEQ), 0) + 1 AS CD_DP_SEQ" ).append("\n"); 
		query.append("                  FROM SPC_IRR_FCAST_OFC_POL_MAPG H," ).append("\n"); 
		query.append("                       PARAMS                     P" ).append("\n"); 
		query.append("                 WHERE H.REP_TRD_CD     = P.REP_TRD_CD" ).append("\n"); 
		query.append("                   AND H.REP_SUB_TRD_CD = P.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                   AND H.RLANE_CD       = P.RLANE_CD" ).append("\n"); 
		query.append("                   AND H.DIR_CD         = P.DIR_CD" ).append("\n"); 
		query.append("                   AND H.IOC_TS_CD      = P.IOC_TS_CD" ).append("\n"); 
		query.append("                   AND H.VSL_CD         = P.VSL_CD" ).append("\n"); 
		query.append("                   AND H.SKD_VOY_NO     = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND H.SKD_DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND H.SLS_OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("             ) T" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND SUB_TRD_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND SLS_RGN_OFC_CD IS NOT NULL" ).append("\n"); 

	}
}
