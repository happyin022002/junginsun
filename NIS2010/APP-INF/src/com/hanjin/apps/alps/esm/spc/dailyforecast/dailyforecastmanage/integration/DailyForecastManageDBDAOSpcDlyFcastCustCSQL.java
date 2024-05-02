/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcDlyFcastCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.01.05 최윤성
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

public class DailyForecastManageDBDAOSpcDlyFcastCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_DLY_FCAST_CUST의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * 2011.01.03 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcDlyFcastCustCSQL(){
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
		params.put("cfm_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcDlyFcastCustCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_DLY_FCAST_CUST (" ).append("\n"); 
		query.append("    RLANE_CD           ," ).append("\n"); 
		query.append("    DIR_CD             ," ).append("\n"); 
		query.append("    VSL_CD             ," ).append("\n"); 
		query.append("    SKD_VOY_NO         ," ).append("\n"); 
		query.append("    SKD_DIR_CD         ," ).append("\n"); 
		query.append("    IOC_TS_CD          ," ).append("\n"); 
		query.append("    SREP_USR_ID        ," ).append("\n"); 
		query.append("    CUST_CNT_CD        ," ).append("\n"); 
		query.append("    CUST_SEQ           ," ).append("\n"); 
		query.append("    POL_YD_CD          ," ).append("\n"); 
		query.append("    POD_YD_CD          ," ).append("\n"); 
		query.append("    FCAST_OFC_CD       ," ).append("\n"); 
		query.append("    FCAST_CUST_TP_CD   ," ).append("\n"); 
		query.append("    IOC_CD             ," ).append("\n"); 
		query.append("    REP_TRD_CD         ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD     ," ).append("\n"); 
		query.append("    TRD_CD             ," ).append("\n"); 
		query.append("    SUB_TRD_CD         ," ).append("\n"); 
		query.append("    SLS_RHQ_CD         ," ).append("\n"); 
		query.append("    SLS_AQ_CD          ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD     ," ).append("\n"); 
		query.append("    SLS_OFC_CD         ," ).append("\n"); 
		query.append("    FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("    FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("    FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("    FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("    FCAST_RF_QTY       ," ).append("\n"); 
		query.append("    FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("    CFM_TTL_QTY        ," ).append("\n"); 
		query.append("    CFM_40FT_HC_QTY    ," ).append("\n"); 
		query.append("    CFM_45FT_HC_QTY    ," ).append("\n"); 
		query.append("    CFM_53FT_QTY       ," ).append("\n"); 
		query.append("    CFM_RF_QTY         ," ).append("\n"); 
		query.append("    CFM_TTL_WGT        ," ).append("\n"); 
		query.append("    USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("    USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("    USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("    USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("    USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("    USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("    USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("    USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("    CTRL_LVL_CD        ," ).append("\n"); 
		query.append("    MODI_GDT           ," ).append("\n"); 
		query.append("    CFM_USR_ID         ," ).append("\n"); 
		query.append("    CFM_DT             ," ).append("\n"); 
		query.append("    CRE_USR_ID         ," ).append("\n"); 
		query.append("    CRE_DT             ," ).append("\n"); 
		query.append("    UPD_USR_ID         ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[trd_cd]      AS TRD_CD     ," ).append("\n"); 
		query.append("           @[sub_trd_cd]  AS SUB_TRD_CD ," ).append("\n"); 
		query.append("           @[rlane_cd]    AS RLANE_CD   ," ).append("\n"); 
		query.append("           @[dir_cd]      AS DIR_CD     ," ).append("\n"); 
		query.append("           @[vsl_cd]      AS VSL_CD     ," ).append("\n"); 
		query.append("           @[skd_voy_no]  AS SKD_VOY_NO ," ).append("\n"); 
		query.append("           @[skd_dir_cd]  AS SKD_DIR_CD ," ).append("\n"); 
		query.append("           @[ioc_ts_cd]   AS IOC_TS_CD  ," ).append("\n"); 
		query.append("           @[srep_usr_id] AS SREP_USR_ID," ).append("\n"); 
		query.append("           NVL(@[cust_cnt_cd], '00')    AS CUST_CNT_CD ," ).append("\n"); 
		query.append("           NVL(@[cust_seq], 0)          AS CUST_SEQ    ," ).append("\n"); 
		query.append("           NVL(@[pol_yd_cd], '0000000') AS POL_CD      ," ).append("\n"); 
		query.append("           NVL(@[pod_yd_cd], '0000000') AS POD_CD      ," ).append("\n"); 
		query.append("           @[fcast_ofc_cd]              AS FCAST_OFC_CD," ).append("\n"); 
		query.append("           NVL(@[fcast_cust_tp_cd], '0')     AS FCAST_CUST_TP_CD   ," ).append("\n"); 
		query.append("           TO_NUMBER(@[fcast_ttl_qty])       AS FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("           TO_NUMBER(@[fcast_40ft_hc_qty])   AS FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("           TO_NUMBER(@[fcast_45ft_hc_qty])   AS FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("           TO_NUMBER(@[fcast_53ft_qty])      AS FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("           TO_NUMBER(@[fcast_rf_qty])        AS FCAST_RF_QTY       ," ).append("\n"); 
		query.append("           TO_NUMBER(@[fcast_ttl_wgt])       AS FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("           TO_NUMBER(@[cfm_ttl_qty])         AS CFM_TTL_QTY        ," ).append("\n"); 
		query.append("           TO_NUMBER(@[cfm_40ft_hc_qty])     AS CFM_40FT_HC_QTY    ," ).append("\n"); 
		query.append("           TO_NUMBER(@[cfm_45ft_hc_qty])     AS CFM_45FT_HC_QTY    ," ).append("\n"); 
		query.append("           TO_NUMBER(@[cfm_53ft_qty])        AS CFM_53FT_QTY       ," ).append("\n"); 
		query.append("           TO_NUMBER(@[cfm_rf_qty])          AS CFM_RF_QTY         ," ).append("\n"); 
		query.append("           TO_NUMBER(@[cfm_ttl_wgt])         AS CFM_TTL_WGT        ," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_ttl_qty])     AS USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_20ft_qty])    AS USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_40ft_qty])    AS USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_40ft_hc_qty]) AS USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_45ft_hc_qty]) AS USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_53ft_qty])    AS USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_rf_qty])      AS USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("           TO_NUMBER(@[usd_bkg_ttl_wgt])     AS USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("           @[ctrl_lvl_cd] AS CTRL_LVL_CD," ).append("\n"); 
		query.append("           @[cfm_dt]      AS CMF_FLG    ," ).append("\n"); 
		query.append("           @[upd_usr_id]  AS USR_ID     ," ).append("\n"); 
		query.append("           @[modi_gdt]    AS MODI_DT" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT P.RLANE_CD        ," ).append("\n"); 
		query.append("         P.DIR_CD          ," ).append("\n"); 
		query.append("         P.VSL_CD          ," ).append("\n"); 
		query.append("         P.SKD_VOY_NO      ," ).append("\n"); 
		query.append("         P.SKD_DIR_CD      ," ).append("\n"); 
		query.append("         P.IOC_TS_CD       ," ).append("\n"); 
		query.append("         P.SREP_USR_ID     ," ).append("\n"); 
		query.append("         P.CUST_CNT_CD     ," ).append("\n"); 
		query.append("         P.CUST_SEQ        ," ).append("\n"); 
		query.append("         P.POL_CD          ," ).append("\n"); 
		query.append("         P.POD_CD          ," ).append("\n"); 
		query.append("         P.FCAST_OFC_CD    ," ).append("\n"); 
		query.append("         P.FCAST_CUST_TP_CD," ).append("\n"); 
		query.append("         DECODE(P.IOC_TS_CD, 'O', 'O', 'I') AS IOC_CD," ).append("\n"); 
		query.append("         RL.REP_TRD_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT RDRL.SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM MDM_DTL_REV_LANE RDRL" ).append("\n"); 
		query.append("             WHERE RDRL.RLANE_CD        = RL.RLANE_CD" ).append("\n"); 
		query.append("               AND RDRL.TRD_CD          = RL.REP_TRD_CD" ).append("\n"); 
		query.append("               AND RDRL.VSL_SLAN_DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         P.TRD_CD," ).append("\n"); 
		query.append("         P.SUB_TRD_CD," ).append("\n"); 
		query.append("         O.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("         O.N3RD_PRNT_OFC_CD AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("         O.N4TH_PRNT_OFC_CD AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         O.SPC_SLS_OFC_CD   AS SLS_OFC_CD    ," ).append("\n"); 
		query.append("         P.FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("         P.FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         P.FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         P.FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         P.FCAST_RF_QTY     ," ).append("\n"); 
		query.append("         P.FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', P.CFM_TTL_QTY    , DECODE(P.POD_CD, '0000000', P.CFM_TTL_QTY))     AS CFM_TTL_QTY   ," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', P.CFM_40FT_HC_QTY, DECODE(P.POD_CD, '0000000', P.CFM_40FT_HC_QTY)) AS CFM_40FT_HC_QTY," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', P.CFM_45FT_HC_QTY, DECODE(P.POD_CD, '0000000', P.CFM_45FT_HC_QTY)) AS CFM_45FT_HC_QTY," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', P.CFM_53FT_QTY   , DECODE(P.POD_CD, '0000000', P.CFM_53FT_QTY))    AS CFM_53FT_QTY   ," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', P.CFM_RF_QTY     , DECODE(P.POD_CD, '0000000', P.CFM_RF_QTY))      AS CFM_RF_QTY     ," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', P.CFM_TTL_WGT    , DECODE(P.POD_CD, '0000000', P.CFM_TTL_WGT))     AS CFM_TTL_WGT    ," ).append("\n"); 
		query.append("         P.USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("         P.USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("         P.USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("         P.USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("         P.USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("         P.USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("         P.USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("         P.USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("         P.CTRL_LVL_CD        ," ).append("\n"); 
		query.append("         CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(MODI_DT, 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS MODI_GDT," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', P.USR_ID) AS CFM_USR_ID," ).append("\n"); 
		query.append("         DECODE(P.CMF_FLG, 'C', SYSDATE)  AS CFM_DT    ," ).append("\n"); 
		query.append("         P.USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("         SYSDATE  AS CRE_DT    ," ).append("\n"); 
		query.append("         P.USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("         SYSDATE  AS UPD_DT" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL  O ," ).append("\n"); 
		query.append("         MDM_SLS_REP  SR," ).append("\n"); 
		query.append("         MDM_REV_LANE RL," ).append("\n"); 
		query.append("         PARAMS       P ," ).append("\n"); 
		query.append("         MAS_MON_VVD  C" ).append("\n"); 
		query.append("   WHERE O.OFC_CD     = SR.OFC_CD" ).append("\n"); 
		query.append("     AND SR.SREP_CD   = P.SREP_USR_ID" ).append("\n"); 
		query.append("     AND RL.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("     AND RL.RLANE_CD  = P.RLANE_CD" ).append("\n"); 
		query.append("     AND C.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("     AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("     AND C.IOC_CD     = DECODE(P.IOC_TS_CD, 'O', 'O', 'I')" ).append("\n"); 
		query.append("     AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("     AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 

	}
}
