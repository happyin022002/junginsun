/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcCtrtFcastOfcMapgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2014.05.22 김시몬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author simonkim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSpcCtrtFcastOfcMapgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcCtrtFcastOfcMapgCSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcCtrtFcastOfcMapgCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_CTRT_FCAST_OFC_MAPG (" ).append("\n"); 
		query.append("    TRD_CD        ," ).append("\n"); 
		query.append("    SUB_TRD_CD    ," ).append("\n"); 
		query.append("    RLANE_CD      ," ).append("\n"); 
		query.append("    DIR_CD        ," ).append("\n"); 
		query.append("    IOC_TS_CD     ," ).append("\n"); 
		query.append("    CTRT_OFC_CD   ," ).append("\n"); 
		query.append("    CUST_CNT_CD   ," ).append("\n"); 
		query.append("    CUST_SEQ      ," ).append("\n"); 
		query.append("    FCAST_SEQ     ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("    SC_NO         ," ).append("\n"); 
		query.append("    RFA_NO        ," ).append("\n"); 
		query.append("    CRE_USR_ID    ," ).append("\n"); 
		query.append("    CRE_DT        ," ).append("\n"); 
		query.append("    UPD_USR_ID    ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD," ).append("\n"); 
		query.append("       IOC_TS_CD," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       NVL((SELECT MAX(FCAST_SEQ)+1 FROM SPC_CTRT_FCAST_OFC_MAPG C" ).append("\n"); 
		query.append("             WHERE C.TRD_CD      = T.TRD_CD" ).append("\n"); 
		query.append("               AND C.SUB_TRD_CD  = T.SUB_TRD_CD" ).append("\n"); 
		query.append("               AND C.RLANE_CD    = T.RLANE_CD" ).append("\n"); 
		query.append("               AND C.DIR_CD      = T.DIR_CD" ).append("\n"); 
		query.append("               AND C.IOC_TS_CD   = T.IOC_TS_CD" ).append("\n"); 
		query.append("               AND C.CTRT_OFC_CD = T.CTRT_OFC_CD" ).append("\n"); 
		query.append("               AND C.CUST_CNT_CD = T.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND C.CUST_SEQ    = T.CUST_SEQ" ).append("\n"); 
		query.append("               AND C.SLS_RGN_OFC_CD = T.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("            ),1) AS FCAST_SEQ," ).append("\n"); 
		query.append("       SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT @[trd_cd]            AS TRD_CD        ," ).append("\n"); 
		query.append("           @[sub_trd_cd]        AS SUB_TRD_CD    ," ).append("\n"); 
		query.append("           @[rlane_cd]          AS RLANE_CD      ," ).append("\n"); 
		query.append("           (SELECT DIR_CD" ).append("\n"); 
		query.append("              FROM SPC_HD_HUL_MST" ).append("\n"); 
		query.append("             WHERE TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("               AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("               AND RLANE_CD   = @[rlane_cd] ) AS DIR_CD," ).append("\n"); 
		query.append("           @[ioc_ts_cd]         AS IOC_TS_CD     ," ).append("\n"); 
		query.append("           @[ctrt_ofc_cd]       AS CTRT_OFC_CD   ," ).append("\n"); 
		query.append("           @[cust_cnt_cd]       AS CUST_CNT_CD   ," ).append("\n"); 
		query.append("           @[cust_seq]          AS CUST_SEQ      ," ).append("\n"); 
		query.append("--           NVL([fcast_seq], 1) AS FCAST_SEQ     ," ).append("\n"); 
		query.append("           @[sls_rgn_ofc_cd]    AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           @[sc_no]             AS SC_NO         ," ).append("\n"); 
		query.append("           DECODE(@[sc_flg],'S','',@[rfa_no]) AS RFA_NO        ," ).append("\n"); 
		query.append("           @[cre_usr_id]        AS CRE_USR_ID    ," ).append("\n"); 
		query.append("           SYSDATE              AS CRE_DT        ," ).append("\n"); 
		query.append("           @[upd_usr_id]        AS UPD_USR_ID    ," ).append("\n"); 
		query.append("           SYSDATE              AS UPD_DT" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}