/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcSlsRepCustMapgWithFcastCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSpcSlsRepCustMapgWithFcastCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpcSlsRepCustMapgWithFcast
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcSlsRepCustMapgWithFcastCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcSlsRepCustMapgWithFcastCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_SLS_REP_CUST_MAPG A USING " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("WITH PARAMS AS " ).append("\n"); 
		query.append("       (SELECT @[vsl_cd] AS VSL_CD " ).append("\n"); 
		query.append("            , @[skd_voy_no] AS SKD_VOY_NO " ).append("\n"); 
		query.append("            , @[skd_dir_cd] AS SKD_DIR_CD " ).append("\n"); 
		query.append("            , @[rlane_cd] AS RLANE_CD" ).append("\n"); 
		query.append("            , @[dir_cd] AS DIR_CD " ).append("\n"); 
		query.append("            , @[ioc_ts_cd] AS IOC_TS_CD " ).append("\n"); 
		query.append("            , @[cust_cnt_cd] AS CUST_CNT_CD " ).append("\n"); 
		query.append("            , @[cust_seq] AS CUST_SEQ " ).append("\n"); 
		query.append("            , @[fcast_cust_tp_cd] AS FCAST_CUST_TP_CD" ).append("\n"); 
		query.append("            , @[fcast_ofc_cd] AS FCAST_OFC_CD" ).append("\n"); 
		query.append("            , @[upd_usr_id] AS USR_ID " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("SELECT NVL(@[srep_usr_id],SR.SREP_CD) AS SREP_CD " ).append("\n"); 
		query.append("     , C.TRD_CD " ).append("\n"); 
		query.append("     , C.SUB_TRD_CD " ).append("\n"); 
		query.append("     , NVL(P.RLANE_CD, C.RLANE_CD) AS RLANE_CD" ).append("\n"); 
		query.append("     , C.DIR_CD " ).append("\n"); 
		query.append("     , P.IOC_TS_CD " ).append("\n"); 
		query.append("     , P.CUST_CNT_CD " ).append("\n"); 
		query.append("     , P.CUST_SEQ " ).append("\n"); 
		query.append("     , P.FCAST_CUST_TP_CD" ).append("\n"); 
		query.append("     , SAQ_GET_REP_TRD_FNC(NVL(P.RLANE_CD, C.RLANE_CD)) AS REP_TRD_CD " ).append("\n"); 
		query.append("     , SAQ_GET_REP_SUB_TRD_FNC(NVL(P.RLANE_CD, C.RLANE_CD)) AS REP_SUB_TRD_CD" ).append("\n"); 
		query.append("     , O.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD " ).append("\n"); 
		query.append("     , O.N3RD_PRNT_OFC_CD AS SLS_AQ_CD " ).append("\n"); 
		query.append("     , O.N4TH_PRNT_OFC_CD AS SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("     , NVL(O.N5TH_PRNT_OFC_CD, O.N4TH_PRNT_OFC_CD) AS SLS_OFC_CD" ).append("\n"); 
		query.append("     , P.FCAST_OFC_CD" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID " ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT " ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID " ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT " ).append("\n"); 
		query.append("  FROM SPC_OFC_LVL O " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT SREP_CD " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT SREP_CD " ).append("\n"); 
		query.append("                FROM MDM_SLS_REP " ).append("\n"); 
		query.append("               WHERE OFC_CD = @[fcast_ofc_cd] " ).append("\n"); 
		query.append("                     AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("            ORDER BY SREP_CD " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("        WHERE ROWNUM = '1' " ).append("\n"); 
		query.append("       ) SR" ).append("\n"); 
		query.append("     , PARAMS P " ).append("\n"); 
		query.append("     , COA_WK_PRD W" ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT IOC_CD" ).append("\n"); 
		query.append("            , VSL_CD" ).append("\n"); 
		query.append("            , SKD_VOY_NO" ).append("\n"); 
		query.append("            , DIR_CD " ).append("\n"); 
		query.append("            , RLANE_CD" ).append("\n"); 
		query.append("            , TRD_CD" ).append("\n"); 
		query.append("            , SUB_TRD_CD " ).append("\n"); 
		query.append("         FROM COA_MON_VVD " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND IOC_CD = 'O' " ).append("\n"); 
		query.append("              AND VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("              AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("              AND DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("              AND 'O' = DECODE(@[ioc_ts_cd], 'O', 'O', 'I') " ).append("\n"); 
		query.append("           UNION ALL " ).append("\n"); 
		query.append("       SELECT T3.IOC_CD" ).append("\n"); 
		query.append("            , T3.VSL_CD" ).append("\n"); 
		query.append("            , T3.SKD_VOY_NO" ).append("\n"); 
		query.append("            , T3.DIR_CD " ).append("\n"); 
		query.append("            , T3.RLANE_CD" ).append("\n"); 
		query.append("            , T4.TRD_CD " ).append("\n"); 
		query.append("            , T4.SUB_TRD_CD " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT IOC_CD" ).append("\n"); 
		query.append("                   , VSL_CD" ).append("\n"); 
		query.append("                   , SKD_VOY_NO" ).append("\n"); 
		query.append("                   , DIR_CD " ).append("\n"); 
		query.append("                   , MAX(RLANE_CD) AS RLANE_CD " ).append("\n"); 
		query.append("                FROM COA_MON_VVD " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND IOC_CD = DECODE(@[ioc_ts_cd], 'O', 'O', 'I') " ).append("\n"); 
		query.append("                     AND VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("                     AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("                     AND DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("               GROUP BY IOC_CD" ).append("\n"); 
		query.append("                   , VSL_CD" ).append("\n"); 
		query.append("                   , SKD_VOY_NO" ).append("\n"); 
		query.append("                   , DIR_CD " ).append("\n"); 
		query.append("              ) T3 " ).append("\n"); 
		query.append("            , MDM_DTL_REV_LANE T4 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T3.RLANE_CD = T4.RLANE_CD " ).append("\n"); 
		query.append("              AND FM_CONTI_CD IN " ).append("\n"); 
		query.append("              (SELECT CONTI_CD " ).append("\n"); 
		query.append("                FROM MDM_LOCATION " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND LOC_CD = SUBSTR(@[pol_yd_cd], 1, 5) " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("              AND TO_CONTI_CD IN " ).append("\n"); 
		query.append("              (SELECT CONTI_CD " ).append("\n"); 
		query.append("                FROM MDM_LOCATION " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND LOC_CD = SUBSTR(@[pol_yd_cd], 1, 5) " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("              AND T4.DELT_FLG = 'N' " ).append("\n"); 
		query.append("              AND T3.DIR_CD = T4.VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("              AND T3.IOC_CD = T4.IOC_CD " ).append("\n"); 
		query.append("              AND 'I' = DECODE(@[ioc_ts_cd], 'O', 'O', 'I') " ).append("\n"); 
		query.append("       )C " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND O.OFC_CD = P.FCAST_OFC_CD " ).append("\n"); 
		query.append("       AND O.OFC_APLY_FM_YRWK <= W.COST_YR || W.COST_WK " ).append("\n"); 
		query.append("       AND O.OFC_APLY_TO_YRWK >= W.COST_YR || W.COST_WK " ).append("\n"); 
		query.append("       AND W.SLS_FM_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') " ).append("\n"); 
		query.append("       AND W.SLS_TO_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD') ) B " ).append("\n"); 
		query.append("ON ( A.SREP_CD = B.SREP_CD " ).append("\n"); 
		query.append("     AND A.TRD_CD = B.TRD_CD " ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD = B.SUB_TRD_CD " ).append("\n"); 
		query.append("     AND A.RLANE_CD = B.RLANE_CD " ).append("\n"); 
		query.append("     AND A.DIR_CD = B.DIR_CD " ).append("\n"); 
		query.append("     AND A.IOC_TS_CD = B.IOC_TS_CD " ).append("\n"); 
		query.append("     AND A.CUST_CNT_CD = B.CUST_CNT_CD " ).append("\n"); 
		query.append("     AND A.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("     AND A.FCAST_CUST_TP_CD = B.FCAST_CUST_TP_CD) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("           SET A.UPD_USR_ID = B.UPD_USR_ID " ).append("\n"); 
		query.append("         , A.UPD_DT = SYSDATE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("               A.SREP_CD " ).append("\n"); 
		query.append("             , A.TRD_CD " ).append("\n"); 
		query.append("             , A.SUB_TRD_CD " ).append("\n"); 
		query.append("             , A.RLANE_CD " ).append("\n"); 
		query.append("             , A.DIR_CD " ).append("\n"); 
		query.append("             , A.IOC_TS_CD " ).append("\n"); 
		query.append("             , A.CUST_CNT_CD " ).append("\n"); 
		query.append("             , A.CUST_SEQ " ).append("\n"); 
		query.append("             , A.FCAST_CUST_TP_CD" ).append("\n"); 
		query.append("             , A.REP_TRD_CD " ).append("\n"); 
		query.append("             , A.REP_SUB_TRD_CD " ).append("\n"); 
		query.append("             , A.SLS_RHQ_CD " ).append("\n"); 
		query.append("             , A.SLS_AQ_CD " ).append("\n"); 
		query.append("             , A.SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("             , A.SLS_OFC_CD " ).append("\n"); 
		query.append("             , A.FCAST_OFC_CD " ).append("\n"); 
		query.append("             , A.CRE_USR_ID " ).append("\n"); 
		query.append("             , A.CRE_DT " ).append("\n"); 
		query.append("             , A.UPD_USR_ID " ).append("\n"); 
		query.append("             , A.UPD_DT " ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("           VALUES " ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("               B.SREP_CD " ).append("\n"); 
		query.append("             , B.TRD_CD " ).append("\n"); 
		query.append("             , B.SUB_TRD_CD " ).append("\n"); 
		query.append("             , B.RLANE_CD " ).append("\n"); 
		query.append("             , B.DIR_CD " ).append("\n"); 
		query.append("             , B.IOC_TS_CD " ).append("\n"); 
		query.append("             , B.CUST_CNT_CD " ).append("\n"); 
		query.append("             , B.CUST_SEQ " ).append("\n"); 
		query.append("             , B.FCAST_CUST_TP_CD" ).append("\n"); 
		query.append("             , B.REP_TRD_CD " ).append("\n"); 
		query.append("             , B.REP_SUB_TRD_CD " ).append("\n"); 
		query.append("             , B.SLS_RHQ_CD " ).append("\n"); 
		query.append("             , B.SLS_AQ_CD " ).append("\n"); 
		query.append("             , B.SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("             , B.SLS_OFC_CD " ).append("\n"); 
		query.append("             , B.FCAST_OFC_CD " ).append("\n"); 
		query.append("             , B.CRE_USR_ID " ).append("\n"); 
		query.append("             , B.CRE_DT " ).append("\n"); 
		query.append("             , B.UPD_USR_ID " ).append("\n"); 
		query.append("             , B.UPD_DT " ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}