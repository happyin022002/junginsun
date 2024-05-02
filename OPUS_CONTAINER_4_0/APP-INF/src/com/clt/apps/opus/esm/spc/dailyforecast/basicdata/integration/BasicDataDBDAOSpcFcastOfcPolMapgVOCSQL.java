/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BasicDataDBDAOSpcFcastOfcPolMapgVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.03.18 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSpcFcastOfcPolMapgVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BasicDataDBDAOSpcFcastOfcPolMapgVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSpcFcastOfcPolMapgVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_FCAST_OFC_POL_MAPG (" ).append("\n"); 
		query.append("    REP_TRD_CD    ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD," ).append("\n"); 
		query.append("    RLANE_CD      ," ).append("\n"); 
		query.append("    DIR_CD        ," ).append("\n"); 
		query.append("    IOC_TS_CD     ," ).append("\n"); 
		query.append("    BSE_YRWK      ," ).append("\n"); 
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
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[rep_trd_cd]     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           @[rep_sub_trd_cd] AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           @[rlane_cd]       AS RLANE_CD      ," ).append("\n"); 
		query.append("           @[dir_cd]         AS DIR_CD        ," ).append("\n"); 
		query.append("           DECODE(@[ioc_ts_cd], 'OCN', 'O', 'IPC', 'I', 'T/S', 'T') AS IOC_TS_CD," ).append("\n"); 
		query.append("           @[bse_yr]         AS BSE_YR        ," ).append("\n"); 
		query.append("           @[bse_wk]         AS BSE_WK        ," ).append("\n"); 
		query.append("           @[sls_ofc_cd]     AS SLS_OFC_CD    ," ).append("\n"); 
		query.append("           @[pol_cd]         AS POL_CD        ," ).append("\n"); 
		query.append("           @[cre_usr_id]     AS CRE_USR_ID    ," ).append("\n"); 
		query.append("           @[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT MAX((SELECT REP_TRD_CD FROM PARAMS))     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("         MAX((SELECT REP_SUB_TRD_CD FROM PARAMS)) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         MAX((SELECT RLANE_CD FROM PARAMS))       AS RLANE_CD      ," ).append("\n"); 
		query.append("         MAX((SELECT DIR_CD FROM PARAMS))         AS DIR_CD        ," ).append("\n"); 
		query.append("         MAX((SELECT IOC_TS_CD  FROM PARAMS))     AS IOC_TS_CD     ," ).append("\n"); 
		query.append("         MAX((SELECT BSE_YR||BSE_WK FROM PARAMS)) AS BSE_YRWK      ," ).append("\n"); 
		query.append("         MAX((SELECT SLS_OFC_CD FROM PARAMS))     AS SLS_OFC_CD    ," ).append("\n"); 
		query.append("         MAX((SELECT POL_CD FROM PARAMS))         AS POL_CD        ," ).append("\n"); 
		query.append("         MAX(CD_DP_SEQ)     ," ).append("\n"); 
		query.append("         MAX(TRD_CD)        ," ).append("\n"); 
		query.append("         MAX(SUB_TRD_CD)    ," ).append("\n"); 
		query.append("         MAX(SLS_RHQ_CD)    ," ).append("\n"); 
		query.append("         MAX(SLS_AQ_CD)     ," ).append("\n"); 
		query.append("         MAX(SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("         MAX((SELECT CRE_USR_ID FROM PARAMS)) AS CRE_USR_ID," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         MAX((SELECT UPD_USR_ID FROM PARAMS)) AS UPD_USR_ID," ).append("\n"); 
		query.append("         SYSDATE" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   NULL AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                   NULL AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("                   NULL AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   NULL AS CD_DP_SEQ" ).append("\n"); 
		query.append("              FROM MDM_DTL_REV_LANE MDR," ).append("\n"); 
		query.append("                   PARAMS           P" ).append("\n"); 
		query.append("             WHERE MDR.RLANE_CD        = P.RLANE_CD" ).append("\n"); 
		query.append("               AND MDR.FM_CONTI_CD     = ( SELECT L.CONTI_CD" ).append("\n"); 
		query.append("                                             FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                            WHERE L.LOC_CD = P.POL_CD )" ).append("\n"); 
		query.append("               AND MDR.VSL_SLAN_DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("               AND MDR.IOC_CD   =  DECODE(P.IOC_TS_CD,'T',DECODE(SUBSTR(P.RLANE_CD,1,3),'IMU','O','I'),P.IOC_TS_CD)" ).append("\n"); 
		query.append("               AND MDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT NULL             AS TRD_CD        ," ).append("\n"); 
		query.append("                   NULL             AS SUB_TRD_CD    ," ).append("\n"); 
		query.append("                   N2ND_PRNT_OFC_CD AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                   N3RD_PRNT_OFC_CD AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("                   N4TH_PRNT_OFC_CD AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   NULL             AS CD_DP_SEQ" ).append("\n"); 
		query.append("              FROM SPC_OFC_LVL SOV," ).append("\n"); 
		query.append("                   PARAMS      P  ," ).append("\n"); 
		query.append("                   COA_WK_PRD  W" ).append("\n"); 
		query.append("             WHERE SOV.OFC_CD = P.SLS_OFC_CD" ).append("\n"); 
		query.append("               AND SOV.OFC_CD = N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("               AND W.COST_YR || W.COST_WK BETWEEN SOV.OFC_APLY_FM_YRWK AND SOV.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("               AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT NULL AS TRD_CD        ," ).append("\n"); 
		query.append("                   NULL AS SUB_TRD_CD    ," ).append("\n"); 
		query.append("                   NULL AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                   NULL AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("                   NULL AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   NVL(MAX(H.CD_DP_SEQ), 0) + 1  AS CD_DP_SEQ" ).append("\n"); 
		query.append("              FROM SPC_FCAST_OFC_POL_MAPG H," ).append("\n"); 
		query.append("                   PARAMS                 P" ).append("\n"); 
		query.append("             WHERE H.REP_TRD_CD     = P.REP_TRD_CD" ).append("\n"); 
		query.append("               AND H.REP_SUB_TRD_CD = P.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("               AND H.RLANE_CD       = P.RLANE_CD" ).append("\n"); 
		query.append("               AND H.DIR_CD         = P.DIR_CD" ).append("\n"); 
		query.append("               AND H.IOC_TS_CD      = P.IOC_TS_CD" ).append("\n"); 
		query.append("               AND H.BSE_YRWK       = P.BSE_YR||P.BSE_WK" ).append("\n"); 
		query.append("               AND H.SLS_OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}