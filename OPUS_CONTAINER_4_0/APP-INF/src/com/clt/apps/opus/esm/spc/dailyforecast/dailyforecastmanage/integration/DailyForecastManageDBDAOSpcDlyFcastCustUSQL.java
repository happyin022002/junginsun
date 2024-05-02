/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcDlyFcastCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.30 
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

public class DailyForecastManageDBDAOSpcDlyFcastCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_DLY_FCAST_CUST의 지정된 ibflag 값에 따라 DB에 반영한다.(수정)
	  * 2016.03.30 CTRT_NO 조건 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcDlyFcastCustUSQL(){
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
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cfm_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cfm_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cfm_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcDlyFcastCustUSQL").append("\n"); 
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
		query.append("UPDATE SPC_DLY_FCAST_CUST " ).append("\n"); 
		query.append("   SET FCAST_TTL_QTY       = @[fcast_ttl_qty]      ," ).append("\n"); 
		query.append("       FCAST_40FT_HC_QTY   = @[fcast_40ft_hc_qty]  ," ).append("\n"); 
		query.append("       FCAST_45FT_HC_QTY   = @[fcast_45ft_hc_qty]  ," ).append("\n"); 
		query.append("       FCAST_53FT_QTY      = @[fcast_53ft_qty]     ," ).append("\n"); 
		query.append("       FCAST_RF_QTY        = @[fcast_rf_qty]       ," ).append("\n"); 
		query.append("       FCAST_TTL_WGT       = @[fcast_ttl_wgt]      ," ).append("\n"); 
		query.append("       CFM_TTL_QTY         = @[cfm_ttl_qty]        ," ).append("\n"); 
		query.append("       CFM_40FT_HC_QTY     = @[cfm_40ft_hc_qty]    ," ).append("\n"); 
		query.append("       CFM_45FT_HC_QTY     = @[cfm_45ft_hc_qty]    ," ).append("\n"); 
		query.append("       CFM_53FT_QTY        = @[cfm_53ft_qty]       ," ).append("\n"); 
		query.append("       CFM_RF_QTY          = @[cfm_rf_qty]         ," ).append("\n"); 
		query.append("       CFM_TTL_WGT         = @[cfm_ttl_wgt]        ," ).append("\n"); 
		query.append("       USD_BKG_TTL_QTY     = @[usd_bkg_ttl_qty]    ," ).append("\n"); 
		query.append("       USD_BKG_20FT_QTY    = @[usd_bkg_20ft_qty]   ," ).append("\n"); 
		query.append("       USD_BKG_40FT_QTY    = @[usd_bkg_40ft_qty]   ," ).append("\n"); 
		query.append("       USD_BKG_40FT_HC_QTY = @[usd_bkg_40ft_hc_qty]," ).append("\n"); 
		query.append("       USD_BKG_45FT_HC_QTY = @[usd_bkg_45ft_hc_qty]," ).append("\n"); 
		query.append("       USD_BKG_53FT_QTY    = @[usd_bkg_53ft_qty]   ," ).append("\n"); 
		query.append("       USD_BKG_RF_QTY      = @[usd_bkg_rf_qty]     ," ).append("\n"); 
		query.append("       USD_BKG_TTL_WGT     = @[usd_bkg_ttl_wgt]    ," ).append("\n"); 
		query.append("       CTRL_LVL_CD         = @[ctrl_lvl_cd]        ," ).append("\n"); 
		query.append("       MODI_GDT            = CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[modi_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE)," ).append("\n"); 
		query.append("       CFM_USR_ID          = DECODE(@[cfm_dt], 'C', @[upd_usr_id], CFM_USR_ID)," ).append("\n"); 
		query.append("       CFM_DT              = DECODE(@[cfm_dt], 'C', SYSDATE, CFM_DT)," ).append("\n"); 
		query.append("       UPD_USR_ID          = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT              = SYSDATE" ).append("\n"); 
		query.append(" WHERE RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("   AND VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND IOC_TS_CD        = @[ioc_ts_cd]" ).append("\n"); 
		query.append("   AND SREP_USR_ID      = @[srep_usr_id]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD      = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST_SEQ         = @[cust_seq]" ).append("\n"); 
		query.append("   AND POL_YD_CD        = @[pol_yd_cd]" ).append("\n"); 
		query.append("   AND POD_YD_CD        = @[pod_yd_cd]" ).append("\n"); 
		query.append("   AND FCAST_OFC_CD     = @[fcast_ofc_cd]" ).append("\n"); 
		query.append("   AND FCAST_CUST_TP_CD = @[fcast_cust_tp_cd]" ).append("\n"); 
		query.append("   --20160204.ADD" ).append("\n"); 
		query.append("   AND NVL(CTRT_CUST_CNT_CD, '00') = NVL(@[ctrt_cust_cnt_cd], '00')" ).append("\n"); 
		query.append("   AND NVL(CTRT_CUST_SEQ, 0)       = NVL(@[ctrt_cust_seq], 0)" ).append("\n"); 
		query.append("   AND NVL(CTRT_NO, '00') = NVL(@[ctrt_no], '00')" ).append("\n"); 
		query.append("  " ).append("\n"); 

	}
}