/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcSlsRepCustMapgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.11.26 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSpcSlsRepCustMapgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpcSlsRepCustMapg
	  * 2011.01.03 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcSlsRepCustMapgCSQL(){
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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcSlsRepCustMapgCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_SLS_REP_CUST_MAPG (" ).append("\n"); 
		query.append("    SREP_CD         ," ).append("\n"); 
		query.append("    TRD_CD          ," ).append("\n"); 
		query.append("    SUB_TRD_CD      ," ).append("\n"); 
		query.append("    RLANE_CD        ," ).append("\n"); 
		query.append("    DIR_CD          ," ).append("\n"); 
		query.append("    IOC_TS_CD       ," ).append("\n"); 
		query.append("    CUST_CNT_CD     ," ).append("\n"); 
		query.append("    CUST_SEQ        ," ).append("\n"); 
		query.append("    FCAST_CUST_TP_CD," ).append("\n"); 
		query.append("    REP_TRD_CD      ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD  ," ).append("\n"); 
		query.append("    SLS_RHQ_CD      ," ).append("\n"); 
		query.append("    SLS_AQ_CD       ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD  ," ).append("\n"); 
		query.append("    SLS_OFC_CD      ," ).append("\n"); 
		query.append("    FCAST_OFC_CD    ," ).append("\n"); 
		query.append("    CRE_USR_ID      ," ).append("\n"); 
		query.append("    CRE_DT          ," ).append("\n"); 
		query.append("    UPD_USR_ID      ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[srep_cd]          AS SREP_CD         ," ).append("\n"); 
		query.append("           @[trd_cd]           AS TRD_CD          ," ).append("\n"); 
		query.append("           @[sub_trd_cd]       AS SUB_TRD_CD      ," ).append("\n"); 
		query.append("           @[rlane_cd]         AS RLANE_CD        ," ).append("\n"); 
		query.append("           @[dir_cd]           AS DIR_CD          ," ).append("\n"); 
		query.append("           @[ioc_ts_cd]        AS IOC_TS_CD       ," ).append("\n"); 
		query.append("           @[cust_cnt_cd]      AS CUST_CNT_CD     ," ).append("\n"); 
		query.append("           @[cust_seq]         AS CUST_SEQ        ," ).append("\n"); 
		query.append("           @[fcast_cust_tp_cd] AS FCAST_CUST_TP_CD," ).append("\n"); 
		query.append("           @[cre_usr_id]       AS USR_ID" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT P.SREP_CD         ," ).append("\n"); 
		query.append("         P.TRD_CD          ," ).append("\n"); 
		query.append("         P.SUB_TRD_CD      ," ).append("\n"); 
		query.append("         P.RLANE_CD        ," ).append("\n"); 
		query.append("         P.DIR_CD          ," ).append("\n"); 
		query.append("         P.IOC_TS_CD       ," ).append("\n"); 
		query.append("         P.CUST_CNT_CD     ," ).append("\n"); 
		query.append("         P.CUST_SEQ        ," ).append("\n"); 
		query.append("         P.FCAST_CUST_TP_CD," ).append("\n"); 
		query.append("         SPC_GET_REP_TRD_FNC(P.RLANE_CD)     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("         SPC_GET_REP_SUB_TRD_FNC(P.RLANE_CD) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         O.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("         O.N3RD_PRNT_OFC_CD AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("         O.N4TH_PRNT_OFC_CD AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         NVL(O.N5TH_PRNT_OFC_CD, O.N4TH_PRNT_OFC_CD) AS SLS_OFC_CD," ).append("\n"); 
		query.append("         SR.OFC_CD AS FCAST_OFC_CD," ).append("\n"); 
		query.append("         P.USR_ID  AS CRE_USR_ID  ," ).append("\n"); 
		query.append("         SYSDATE   AS CRE_DT      ," ).append("\n"); 
		query.append("         P.USR_ID  AS UPD_USR_ID  ," ).append("\n"); 
		query.append("         SYSDATE   AS UPD_DT" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL O ," ).append("\n"); 
		query.append("         MDM_SLS_REP SR," ).append("\n"); 
		query.append("         PARAMS      P ," ).append("\n"); 
		query.append("         MAS_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE O.OFC_CD   = SR.OFC_CD" ).append("\n"); 
		query.append("     AND SR.SREP_CD = P.SREP_CD" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 

	}
}
