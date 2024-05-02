/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcDlyFcastCustSwitchUSQL.java
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

public class DailyForecastManageDBDAOSpcDlyFcastCustSwitchUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전임 S.REP이 입력한 Forecast 정보를 삭제한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcDlyFcastCustSwitchUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : DailyForecastManageDBDAOSpcDlyFcastCustSwitchUSQL").append("\n"); 
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
		query.append("UPDATE SPC_DLY_FCAST_CUST A" ).append("\n"); 
		query.append("   SET A.FCAST_TTL_QTY	       	= 0, " ).append("\n"); 
		query.append("       A.FCAST_40FT_HC_QTY     	= 0, " ).append("\n"); 
		query.append("       A.FCAST_45FT_HC_QTY     	= 0, " ).append("\n"); 
		query.append("       A.FCAST_RF_QTY          	= 0, " ).append("\n"); 
		query.append("       A.FCAST_TTL_WGT         	= 0, " ).append("\n"); 
		query.append("       A.CFM_TTL_QTY           	= 0, " ).append("\n"); 
		query.append("       A.CFM_40FT_HC_QTY       	= 0, " ).append("\n"); 
		query.append("       A.CFM_45FT_HC_QTY       	= 0, " ).append("\n"); 
		query.append("       A.CFM_RF_QTY            	= 0, " ).append("\n"); 
		query.append("       A.CFM_TTL_WGT           	= 0, " ).append("\n"); 
		query.append("       A.MODI_GDT              	= CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(SYSDATE, 'YYYY/MM/DD HH24:MI:SS')) AS DATE)," ).append("\n"); 
		query.append("       A.USD_BKG_TTL_QTY       	= 0, " ).append("\n"); 
		query.append("       A.USD_BKG_20FT_QTY      	= 0, " ).append("\n"); 
		query.append("       A.USD_BKG_40FT_QTY      	= 0, " ).append("\n"); 
		query.append("       A.USD_BKG_40FT_HC_QTY   	= 0, " ).append("\n"); 
		query.append("       A.USD_BKG_45FT_HC_QTY   	= 0, " ).append("\n"); 
		query.append("       A.USD_BKG_RF_QTY        	= 0, " ).append("\n"); 
		query.append("       A.USD_BKG_TTL_WGT       	= 0, " ).append("\n"); 
		query.append("       A.UPD_USR_ID	        = @[upd_usr_id], " ).append("\n"); 
		query.append("       A.UPD_DT          	= SYSDATE, " ).append("\n"); 
		query.append("       A.FCAST_53FT_QTY        	= 0, " ).append("\n"); 
		query.append("       A.CFM_53FT_QTY          	= 0, " ).append("\n"); 
		query.append("       A.USD_BKG_53FT_QTY      	= 0, " ).append("\n"); 
		query.append("       A.FCAST_20FT_QTY        	= 0, " ).append("\n"); 
		query.append("       A.FCAST_40FT_QTY        	= 0" ).append("\n"); 
		query.append(" WHERE A.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#if(${sub_trd_cd} != '')" ).append("\n"); 
		query.append("   AND A.SUB_TRD_CD  = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rlane_cd} != '')" ).append("\n"); 
		query.append("   AND A.RLANE_CD    IN (${rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dir_cd} != '')" ).append("\n"); 
		query.append("   AND A.DIR_CD      = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.IOC_TS_CD   = @[ioc_ts_cd]" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ    = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("   AND A.SREP_USR_ID = @[srep_cd]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                 FROM MAS_MON_VVD V" ).append("\n"); 
		query.append("                WHERE SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK >= REPLACE(@[cost_wk], '-', '')" ).append("\n"); 
		query.append("                  AND V.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                  AND V.TRD_CD     = A.TRD_CD" ).append("\n"); 
		query.append("                  AND V.RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("                  AND V.DIR_CD     = A.DIR_CD" ).append("\n"); 
		query.append("                  AND V.SUB_TRD_CD = A.SUB_TRD_CD" ).append("\n"); 
		query.append("                  AND V.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("                  AND V.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND V.DIR_CD     = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND V.IOC_CD     = DECODE(@[ioc_ts_cd], 'T', 'I', @[ioc_ts_cd])" ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}
