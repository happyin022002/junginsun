/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOContractForecastHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2014.05.21 김시몬
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

public class DailyForecastManageDBDAOContractForecastHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOContractForecastHisCSQL(){
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
		params.put("fcast_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("view_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOContractForecastHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_CTRT_FCAST_CUST_HIS (" ).append("\n"); 
		query.append("    TRD_CD           ," ).append("\n"); 
		query.append("    RLANE_CD         ," ).append("\n"); 
		query.append("    IOC_TS_CD        ," ).append("\n"); 
		query.append("    SREP_USR_ID      ," ).append("\n"); 
		query.append("    CTRT_OFC_CD      ," ).append("\n"); 
		query.append("    VSL_CD           ," ).append("\n"); 
		query.append("    SKD_VOY_NO       ," ).append("\n"); 
		query.append("    SKD_DIR_CD       ," ).append("\n"); 
		query.append("    CUST_CNT_CD      ," ).append("\n"); 
		query.append("    CUST_SEQ         ," ).append("\n"); 
		query.append("    FCAST_SEQ        ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD   ," ).append("\n"); 
		query.append("    POL_YD_CD        ," ).append("\n"); 
		query.append("    POD_YD_CD        ," ).append("\n"); 
		query.append("    FCAST_MODI_SEQ   ," ).append("\n"); 
		query.append("    SUB_TRD_CD       ," ).append("\n"); 
		query.append("    SC_NO            ," ).append("\n"); 
		query.append("    RFA_NO           ," ).append("\n"); 
		query.append("    FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("    FCAST_20FT_QTY   ," ).append("\n"); 
		query.append("    FCAST_40FT_QTY   ," ).append("\n"); 
		query.append("    FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("    FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("    FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("    FCAST_RF_QTY     ," ).append("\n"); 
		query.append("    FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("    CUST_CTRL_CD     ," ).append("\n"); 
		query.append("    MODI_GDT         ," ).append("\n"); 
		query.append("    FCAST_RMK        ," ).append("\n"); 
		query.append("    CRE_USR_ID       ," ).append("\n"); 
		query.append("    CRE_DT           ," ).append("\n"); 
		query.append("    UPD_USR_ID       ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT @[trd_cd]                       AS TRD_CD           ," ).append("\n"); 
		query.append("         @[rlane_cd]                     AS RLANE_CD         ," ).append("\n"); 
		query.append("         @[ioc_ts_cd]                    AS IOC_TS_CD        ," ).append("\n"); 
		query.append("         @[srep_usr_id]                  AS SREP_USR_ID      ," ).append("\n"); 
		query.append("         @[ctrt_ofc_cd]                  AS CTRT_OFC_CD      ," ).append("\n"); 
		query.append("         @[vsl_cd]                       AS VSL_CD           ," ).append("\n"); 
		query.append("         @[skd_voy_no]                   AS SKD_VOY_NO       ," ).append("\n"); 
		query.append("         @[skd_dir_cd]                   AS SKD_DIR_CD       ," ).append("\n"); 
		query.append("         NVL(@[cust_cnt_cd], '00')       AS CUST_CNT_CD      ," ).append("\n"); 
		query.append("         NVL(@[cust_seq]   , 0)          AS CUST_SEQ         ," ).append("\n"); 
		query.append("         NVL(@[fcast_seq]  , 1)          AS FCAST_SEQ        ," ).append("\n"); 
		query.append("         @[sls_rgn_ofc_cd]               AS SLS_RGN_OFC_CD   ," ).append("\n"); 
		query.append("         NVL(@[pol_yd_cd], '0000000')    AS POL_CD           ," ).append("\n"); 
		query.append("         NVL(@[pod_yd_cd], '0000000')    AS POD_CD           ," ).append("\n"); 
		query.append("         (SELECT NVL(MAX(FCAST_MODI_SEQ), 0) + 1" ).append("\n"); 
		query.append("            FROM SPC_CTRT_FCAST_CUST_HIS" ).append("\n"); 
		query.append("           WHERE TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("             AND RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("             AND IOC_TS_CD      = @[ioc_ts_cd]" ).append("\n"); 
		query.append("             AND SREP_USR_ID    = @[srep_usr_id]" ).append("\n"); 
		query.append("             AND CTRT_OFC_CD    = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("             AND VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("             AND SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("             AND SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("             AND CUST_CNT_CD    = NVL(@[cust_cnt_cd], '00')" ).append("\n"); 
		query.append("             AND CUST_SEQ       = NVL(@[cust_seq]   , 0)" ).append("\n"); 
		query.append("             AND FCAST_SEQ      = NVL(@[fcast_seq]  , 1)" ).append("\n"); 
		query.append("             AND SLS_RGN_OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("             AND POL_YD_CD      = NVL(@[pol_yd_cd], '0000000')" ).append("\n"); 
		query.append("             AND POD_YD_CD      = NVL(@[pod_yd_cd], '0000000') ) AS FCAST_MODI_SEQ," ).append("\n"); 
		query.append("         @[sub_trd_cd]                   AS SUB_TRD_CD       ," ).append("\n"); 
		query.append("         @[sc_no]                        AS SC_NO            ," ).append("\n"); 
		query.append("         DECODE(@[sc_flg],'S','',@[rfa_no]) AS RFA_NO           ," ).append("\n"); 
		query.append("         DECODE(@[view_type], 'FEU', TO_NUMBER(@[fcast_ttl_qty]) * 2, TO_NUMBER(@[fcast_ttl_qty]))   AS FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("         TO_NUMBER(@[fcast_20ft_qty])    AS FCAST_20FT_QTY," ).append("\n"); 
		query.append("         TO_NUMBER(@[fcast_40ft_qty])    AS FCAST_40FT_QTY," ).append("\n"); 
		query.append("         TO_NUMBER(@[fcast_40ft_hc_qty]) AS FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         TO_NUMBER(@[fcast_45ft_hc_qty]) AS FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         TO_NUMBER(@[fcast_53ft_qty])    AS FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         TO_NUMBER(@[fcast_rf_qty])      AS FCAST_RF_QTY     ," ).append("\n"); 
		query.append("         TO_NUMBER(@[fcast_ttl_wgt])     AS FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("         @[cust_ctrl_cd]                 AS CUST_CTRL_CD     ," ).append("\n"); 
		query.append("         CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[modi_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS MODI_GDT," ).append("\n"); 
		query.append("         @[fcast_rmk]  AS FCAST_RMK     ," ).append("\n"); 
		query.append("         @[upd_usr_id] AS CRE_USR_ID    ," ).append("\n"); 
		query.append("         SYSDATE       AS CRE_DT        ," ).append("\n"); 
		query.append("         @[upd_usr_id] AS UPD_USR_ID    ," ).append("\n"); 
		query.append("         SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 

	}
}