/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOContractForecastUSQL.java
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

public class DailyForecastManageDBDAOContractForecastUSQL implements ISQLTemplate{

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
	public DailyForecastManageDBDAOContractForecastUSQL(){
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOContractForecastUSQL").append("\n"); 
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
		query.append("UPDATE SPC_CTRT_FCAST_CUST C" ).append("\n"); 
		query.append("   SET FCAST_TTL_QTY     = DECODE(@[view_type], 'FEU', TO_NUMBER(@[fcast_ttl_qty]) * 2, TO_NUMBER(@[fcast_ttl_qty]))   ," ).append("\n"); 
		query.append("       FCAST_20FT_QTY    = TO_NUMBER(@[fcast_20ft_qty])   ," ).append("\n"); 
		query.append("       FCAST_40FT_QTY    = TO_NUMBER(@[fcast_40ft_qty])   ,         " ).append("\n"); 
		query.append("       FCAST_40FT_HC_QTY = TO_NUMBER(@[fcast_40ft_hc_qty])," ).append("\n"); 
		query.append("       FCAST_45FT_HC_QTY = TO_NUMBER(@[fcast_45ft_hc_qty])," ).append("\n"); 
		query.append("       FCAST_53FT_QTY    = TO_NUMBER(@[fcast_53ft_qty])   ," ).append("\n"); 
		query.append("       FCAST_RF_QTY      = TO_NUMBER(@[fcast_rf_qty])     ," ).append("\n"); 
		query.append("       FCAST_TTL_WGT     = TO_NUMBER(@[fcast_ttl_wgt])    ," ).append("\n"); 
		query.append("       CUST_CTRL_CD      = @[cust_ctrl_cd]," ).append("\n"); 
		query.append("       MODI_GDT          = CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[modi_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) ," ).append("\n"); 
		query.append("       FCAST_RMK         = @[fcast_rmk]," ).append("\n"); 
		query.append("       UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(" WHERE TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("   AND IOC_TS_CD      = @[ioc_ts_cd]" ).append("\n"); 
		query.append("   AND SREP_USR_ID    = @[srep_usr_id]" ).append("\n"); 
		query.append("   AND CTRT_OFC_CD    = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("   AND VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD    = NVL(@[cust_cnt_cd], '00')" ).append("\n"); 
		query.append("   AND CUST_SEQ       = NVL(@[cust_seq]   , 0)" ).append("\n"); 
		query.append("   AND FCAST_SEQ      = @[fcast_seq]" ).append("\n"); 
		query.append("   AND NVL(C.SC_NO,NVL(C.RFA_NO,'X')) = NVL(@[sc_no],NVL(DECODE(@[sc_flg],'S','',@[rfa_no]), 'X'))" ).append("\n"); 
		query.append("   --AND DECODE(C.TRD_CD, 'AES', NVL(C.RFA_NO,'X'), NVL(C.SC_NO,'X')) = DECODE(C.TRD_CD, 'AES', NVL (--[rfa_no], 'X'), COALESCE (--[sc_no], C.SC_NO, 'X'))" ).append("\n"); 
		query.append("   AND SLS_RGN_OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("   AND POL_YD_CD      = NVL(@[pol_yd_cd], '0000000')" ).append("\n"); 

	}
}