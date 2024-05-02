/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcDlyFcastCustSwitchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSpcDlyFcastCustSwitchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전임 S.REP이 등록한 Forecast 를 승계한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcDlyFcastCustSwitchCSQL(){
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
		params.put("salesRep",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcDlyFcastCustSwitchCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_DLY_FCAST_CUST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    RLANE_CD," ).append("\n"); 
		query.append("    DIR_CD," ).append("\n"); 
		query.append("    VSL_CD, " ).append("\n"); 
		query.append("    SKD_VOY_NO, " ).append("\n"); 
		query.append("    SKD_DIR_CD, " ).append("\n"); 
		query.append("    IOC_TS_CD, " ).append("\n"); 
		query.append("    SREP_USR_ID, " ).append("\n"); 
		query.append("    CUST_CNT_CD, " ).append("\n"); 
		query.append("    CUST_SEQ , " ).append("\n"); 
		query.append("    FCAST_SEQ, " ).append("\n"); 
		query.append("    SC_NO    , " ).append("\n"); 
		query.append("    POL_YD_CD, " ).append("\n"); 
		query.append("    POD_YD_CD, " ).append("\n"); 
		query.append("    FCAST_OFC_CD, " ).append("\n"); 
		query.append("    FCAST_CUST_TP_CD, " ).append("\n"); 
		query.append("    IOC_CD, " ).append("\n"); 
		query.append("    REP_TRD_CD, " ).append("\n"); 
		query.append("    REP_SUB_TRD_CD, " ).append("\n"); 
		query.append("    TRD_CD, " ).append("\n"); 
		query.append("    SUB_TRD_CD, " ).append("\n"); 
		query.append("    SLS_RHQ_CD, " ).append("\n"); 
		query.append("    SLS_AQ_CD, " ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD, " ).append("\n"); 
		query.append("    SLS_OFC_CD, " ).append("\n"); 
		query.append("    FCAST_TTL_QTY, " ).append("\n"); 
		query.append("    FCAST_40FT_HC_QTY, " ).append("\n"); 
		query.append("    FCAST_45FT_HC_QTY, " ).append("\n"); 
		query.append("    FCAST_RF_QTY, " ).append("\n"); 
		query.append("    FCAST_TTL_WGT, " ).append("\n"); 
		query.append("    CFM_TTL_QTY, " ).append("\n"); 
		query.append("    CFM_40FT_HC_QTY, " ).append("\n"); 
		query.append("    CFM_45FT_HC_QTY, " ).append("\n"); 
		query.append("    CFM_RF_QTY, " ).append("\n"); 
		query.append("    CFM_TTL_WGT, " ).append("\n"); 
		query.append("    CTRL_LVL_CD, " ).append("\n"); 
		query.append("    MODI_GDT, " ).append("\n"); 
		query.append("    CFM_USR_ID, " ).append("\n"); 
		query.append("    CFM_DT, " ).append("\n"); 
		query.append("    USD_BKG_TTL_QTY, " ).append("\n"); 
		query.append("    USD_BKG_20FT_QTY, " ).append("\n"); 
		query.append("    USD_BKG_40FT_QTY, " ).append("\n"); 
		query.append("    USD_BKG_40FT_HC_QTY, " ).append("\n"); 
		query.append("    USD_BKG_45FT_HC_QTY, " ).append("\n"); 
		query.append("    USD_BKG_RF_QTY, " ).append("\n"); 
		query.append("    USD_BKG_TTL_WGT, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT, " ).append("\n"); 
		query.append("    POL_IND_SEQ, " ).append("\n"); 
		query.append("    POD_IND_SEQ, " ).append("\n"); 
		query.append("    POL_YD_IND_SEQ, " ).append("\n"); 
		query.append("    POD_YD_IND_SEQ, " ).append("\n"); 
		query.append("    FCAST_53FT_QTY, " ).append("\n"); 
		query.append("    CFM_53FT_QTY, " ).append("\n"); 
		query.append("    USD_BKG_53FT_QTY, " ).append("\n"); 
		query.append("    FCAST_20FT_QTY, " ).append("\n"); 
		query.append("    FCAST_40FT_QTY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.RLANE_CD," ).append("\n"); 
		query.append("       A.DIR_CD," ).append("\n"); 
		query.append("       A.VSL_CD, " ).append("\n"); 
		query.append("       A.SKD_VOY_NO, " ).append("\n"); 
		query.append("       A.SKD_DIR_CD, " ).append("\n"); 
		query.append("       A.IOC_TS_CD, " ).append("\n"); 
		query.append("       @[salesRep] AS SREP_CD, " ).append("\n"); 
		query.append("       A.CUST_CNT_CD, " ).append("\n"); 
		query.append("       A.CUST_SEQ, " ).append("\n"); 
		query.append("       A.FCAST_SEQ, " ).append("\n"); 
		query.append("       A.SC_NO, " ).append("\n"); 
		query.append("       A.POL_YD_CD, " ).append("\n"); 
		query.append("       A.POD_YD_CD, " ).append("\n"); 
		query.append("       A.FCAST_OFC_CD, " ).append("\n"); 
		query.append("       A.FCAST_CUST_TP_CD, " ).append("\n"); 
		query.append("       A.IOC_CD, " ).append("\n"); 
		query.append("       A.REP_TRD_CD, " ).append("\n"); 
		query.append("       A.REP_SUB_TRD_CD, " ).append("\n"); 
		query.append("       A.TRD_CD, " ).append("\n"); 
		query.append("       A.SUB_TRD_CD, " ).append("\n"); 
		query.append("       A.SLS_RHQ_CD, " ).append("\n"); 
		query.append("       A.SLS_AQ_CD, " ).append("\n"); 
		query.append("       A.SLS_RGN_OFC_CD, " ).append("\n"); 
		query.append("       A.SLS_OFC_CD, " ).append("\n"); 
		query.append("       A.FCAST_TTL_QTY, " ).append("\n"); 
		query.append("       A.FCAST_40FT_HC_QTY, " ).append("\n"); 
		query.append("       A.FCAST_45FT_HC_QTY, " ).append("\n"); 
		query.append("       A.FCAST_RF_QTY, " ).append("\n"); 
		query.append("       A.FCAST_TTL_WGT, " ).append("\n"); 
		query.append("       A.CFM_TTL_QTY, " ).append("\n"); 
		query.append("       A.CFM_40FT_HC_QTY, " ).append("\n"); 
		query.append("       A.CFM_45FT_HC_QTY, " ).append("\n"); 
		query.append("       A.CFM_RF_QTY, " ).append("\n"); 
		query.append("       A.CFM_TTL_WGT, " ).append("\n"); 
		query.append("       A.CTRL_LVL_CD, " ).append("\n"); 
		query.append("       CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(SYSDATE, 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS MODI_GDT, " ).append("\n"); 
		query.append("       A.CFM_USR_ID, " ).append("\n"); 
		query.append("       SYSDATE CFM_DT, " ).append("\n"); 
		query.append("       A.USD_BKG_TTL_QTY, " ).append("\n"); 
		query.append("       A.USD_BKG_20FT_QTY, " ).append("\n"); 
		query.append("       A.USD_BKG_40FT_QTY, " ).append("\n"); 
		query.append("       A.USD_BKG_40FT_HC_QTY, " ).append("\n"); 
		query.append("       A.USD_BKG_45FT_HC_QTY, " ).append("\n"); 
		query.append("       A.USD_BKG_RF_QTY, " ).append("\n"); 
		query.append("       A.USD_BKG_TTL_WGT, " ).append("\n"); 
		query.append("       'SYSTEM' CRE_USR_ID, " ).append("\n"); 
		query.append("       SYSDATE CRE_DT, " ).append("\n"); 
		query.append("       'SYSTEM' UPD_USR_ID, " ).append("\n"); 
		query.append("       SYSDATE UPD_DT, " ).append("\n"); 
		query.append("       A.POL_IND_SEQ, " ).append("\n"); 
		query.append("       A.POD_IND_SEQ, " ).append("\n"); 
		query.append("       A.POL_YD_IND_SEQ, " ).append("\n"); 
		query.append("       A.POD_YD_IND_SEQ, " ).append("\n"); 
		query.append("       A.FCAST_53FT_QTY, " ).append("\n"); 
		query.append("       A.CFM_53FT_QTY, " ).append("\n"); 
		query.append("       A.USD_BKG_53FT_QTY, " ).append("\n"); 
		query.append("       A.FCAST_20FT_QTY, " ).append("\n"); 
		query.append("       A.FCAST_40FT_QTY" ).append("\n"); 
		query.append("  FROM SPC_DLY_FCAST_CUST A," ).append("\n"); 
		query.append("       MAS_MON_VVD        V" ).append("\n"); 
		query.append(" WHERE V.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#if(${sub_trd_cd} != '')" ).append("\n"); 
		query.append("   AND V.SUB_TRD_CD  = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rlane_cd} != '')" ).append("\n"); 
		query.append("   AND V.RLANE_CD    IN (${rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND V.IOC_CD      = DECODE(@[ioc_ts_cd], 'T', 'I', @[ioc_ts_cd])" ).append("\n"); 
		query.append("#if(${dir_cd} != '')" ).append("\n"); 
		query.append("   AND V.DIR_CD      = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND V.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND V.TRD_CD      = A.TRD_CD" ).append("\n"); 
		query.append("   AND V.RLANE_CD    = A.RLANE_CD" ).append("\n"); 
		query.append("   AND V.DIR_CD      = A.DIR_CD" ).append("\n"); 
		query.append("   AND V.SUB_TRD_CD  = A.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND V.VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND V.DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.IOC_TS_CD   = @[ioc_ts_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK >= REPLACE(@[cost_wk], '-', '')" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ    = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("   AND A.SREP_USR_ID = @[srep_cd]" ).append("\n"); 

	}
}
