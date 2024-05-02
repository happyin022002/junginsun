/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocCustPolPod044CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.10 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocCustPolPod044CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 성수기 ALLOC BY MAINOFFICE 저장
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocCustPolPod044CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("account_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("us_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_aval_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_aval_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocCustPolPod044CSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_ALOC_CUST_POL_POD T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         WITH PARAMS AS (" ).append("\n"); 
		query.append("             SELECT  @[trd_cd]     AS TRD_CD    ," ).append("\n"); 
		query.append("                     @[sub_trd_cd] AS SUB_TRD_CD," ).append("\n"); 
		query.append("                     @[rlane_cd]   AS RLANE_CD  ," ).append("\n"); 
		query.append("                     @[dir_cd]     AS DIR_CD    ," ).append("\n"); 
		query.append("                     @[vsl_cd]     AS VSL_CD    ," ).append("\n"); 
		query.append("                     @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("                     @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("                     @[sls_ofc_cd] AS SLS_OFC_CD," ).append("\n"); 
		query.append("                     @[pol_cd]     AS POL_YD_CD ," ).append("\n"); 
		query.append("                     @[pod_cd]     AS POD_YD_CD ," ).append("\n"); 
		query.append("                     @[ts_flg]     AS TS_FLG    ," ).append("\n"); 
		query.append("                     @[mnl_flg]    AS MNL_FLG   ," ).append("\n"); 
		query.append("                     DECODE(@[account_cd], 'OTHERS', 'XX', SUBSTR(@[account_cd], 1, 2)) AS CUST_CNT_CD ," ).append("\n"); 
		query.append("                     DECODE(@[account_cd], 'OTHERS', '999999', SUBSTR(@[account_cd], 3, 6)) AS CUST_SEQ ," ).append("\n"); 
		query.append("                     @[ctrt_no]    AS CTRT_NO   ," ).append("\n"); 
		query.append("                     @[cust_ctrl_cd]            AS CUST_CTRL_CD," ).append("\n"); 
		query.append("                     DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I') AS IOC_CD," ).append("\n"); 
		query.append("                     @[sls_rgn_ofc_cd]        AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                     @[bkg_aval_ttl_qty]      AS BKG_AVAL_TTL_QTY," ).append("\n"); 
		query.append("                     @[bkg_aval_40ft_hc_qty]  AS BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("                     @[bkg_aval_45ft_hc_qty]  AS BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("                     @[bkg_aval_53ft_qty]     AS BKG_AVAL_53FT_QTY," ).append("\n"); 
		query.append("                     @[bkg_aval_rf_qty]       AS BKG_AVAL_RF_QTY," ).append("\n"); 
		query.append("                     @[bkg_aval_ttl_wgt]      AS BKG_AVAL_TTL_WGT," ).append("\n"); 
		query.append("                     @[fcast_ttl_qty]         AS FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("                     @[fcast_40ft_hc_qty]     AS FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("                     @[fcast_45ft_hc_qty]     AS FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("                     @[fcast_53ft_qty]        AS FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("                     @[fcast_rf_qty]          AS FCAST_RF_QTY         ," ).append("\n"); 
		query.append("                     @[fcast_ttl_wgt]         AS FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("                     @[usd_bkg_ttl_qty]       AS USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("                     @[usd_bkg_20ft_qty]      AS USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("                     @[usd_bkg_40ft_qty]      AS USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("                     @[usd_bkg_40ft_hc_qty]   AS USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("                     @[usd_bkg_45ft_hc_qty]   AS USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("                     @[usd_bkg_53ft_qty]      AS USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("                     @[usd_bkg_rf_qty]        AS USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("                     @[usd_bkg_ttl_wgt]       AS USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("                     '1'                      AS MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("                     @[upd_usr_id]            AS USR_ID               ," ).append("\n"); 
		query.append("                     CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[aloc_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS ALOC_GDT," ).append("\n"); 
		query.append("                     SYSDATE AS DT," ).append("\n"); 
		query.append("                     -- 2014.08.03 컬럼 추가" ).append("\n"); 
		query.append("    		     DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod]) AS USA_BKG_MOD_CD," ).append("\n"); 
		query.append("    		     DECODE(NVL(@[del_cd], 'XXXXX'), '1', 'XXXXX', 'OTHERS', 'XXXXX', NVL(@[del_cd], '00000'))  AS DEST_LOC_CD," ).append("\n"); 
		query.append("                     @[bkg_aval_d2_qty] AS BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("                     @[bkg_aval_d4_qty] AS BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("                     @[bkg_aval_rd_qty]       AS BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("                     @[fcast_d2_qty]    AS FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("                     @[fcast_d4_qty]    AS FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("                     @[fcast_rd_qty]          AS FCAST_RD_QTY," ).append("\n"); 
		query.append("                     @[usd_bkg_d2_qty]  AS USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("                     @[usd_bkg_d4_qty]  AS USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("                     @[usd_bkg_rd_qty]        AS USD_BKG_RD_QTY" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("           SELECT Z.RLANE_CD      ," ).append("\n"); 
		query.append("                  Z.DIR_CD        ," ).append("\n"); 
		query.append("                  Z.VSL_CD        ," ).append("\n"); 
		query.append("                  Z.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                  Z.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                  Z.SLS_OFC_CD    ," ).append("\n"); 
		query.append("                  Z.POL_YD_CD     ," ).append("\n"); 
		query.append("                  Z.POD_YD_CD     ," ).append("\n"); 
		query.append("                  Z.TS_FLG        ," ).append("\n"); 
		query.append("                  Z.MNL_FLG       ," ).append("\n"); 
		query.append("                  Z.CUST_CNT_CD   ," ).append("\n"); 
		query.append("                  Z.CUST_SEQ      ," ).append("\n"); 
		query.append("                  Z.CTRT_NO       ," ).append("\n"); 
		query.append("                  Z.CUST_CTRL_CD  ," ).append("\n"); 
		query.append("                  Z.REP_TRD_CD    ," ).append("\n"); 
		query.append("                  Z.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                  Z.TRD_CD        ," ).append("\n"); 
		query.append("                  Z.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                  Z.IOC_CD        ," ).append("\n"); 
		query.append("                  Z.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                  Z.SLS_AQ_CD     ," ).append("\n"); 
		query.append("                  Z.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("                  FCAST_TTL_QTY          ," ).append("\n"); 
		query.append("                  FCAST_40FT_HC_QTY      ," ).append("\n"); 
		query.append("                  FCAST_45FT_HC_QTY      ," ).append("\n"); 
		query.append("                  FCAST_53FT_QTY         ," ).append("\n"); 
		query.append("                  FCAST_RF_QTY           ," ).append("\n"); 
		query.append("                  FCAST_TTL_WGT          ," ).append("\n"); 
		query.append("                  USD_BKG_TTL_QTY        ," ).append("\n"); 
		query.append("                  USD_BKG_20FT_QTY       ," ).append("\n"); 
		query.append("                  USD_BKG_40FT_QTY       ," ).append("\n"); 
		query.append("                  USD_BKG_40FT_HC_QTY    ," ).append("\n"); 
		query.append("                  USD_BKG_45FT_HC_QTY    ," ).append("\n"); 
		query.append("                  USD_BKG_53FT_QTY       ," ).append("\n"); 
		query.append("                  USD_BKG_RF_QTY         ," ).append("\n"); 
		query.append("                  USD_BKG_TTL_WGT        ," ).append("\n"); 
		query.append("                  Z.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("                  Z.USR_ID AS ALOC_USR_ID," ).append("\n"); 
		query.append("                  Z.ALOC_GDT             ," ).append("\n"); 
		query.append("                  Z.USR_ID AS CRE_USR_ID ," ).append("\n"); 
		query.append("                  Z.DT CRE_DT            ," ).append("\n"); 
		query.append("                  Z.USR_ID AS UPD_USR_ID ," ).append("\n"); 
		query.append("                  Z.DT UPD_DT," ).append("\n"); 
		query.append("                  -- 2014.08.03 컬럼 추가" ).append("\n"); 
		query.append("    		  DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod]) AS USA_BKG_MOD_CD," ).append("\n"); 
		query.append("    		  DECODE(NVL(@[del_cd], 'XXXXX'), '1', 'XXXXX', 'OTHERS', 'XXXXX', NVL(@[del_cd], '00000'))  AS DEST_LOC_CD," ).append("\n"); 
		query.append("    		      --P.ASGN_D2 AS ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("                  --P.ASGN_D4 AS ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("                  --P.ASGN_RD AS ASGN_RD_QTY," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("                  Z.BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("                  Z.FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("                  Z.FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("                  Z.FCAST_RD_QTY," ).append("\n"); 
		query.append("                  Z.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("                  Z.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("                  Z.USD_BKG_RD_QTY " ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                     SELECT P.RLANE_CD    ," ).append("\n"); 
		query.append("                            P.DIR_CD      ," ).append("\n"); 
		query.append("                            P.VSL_CD      ," ).append("\n"); 
		query.append("                            P.SKD_VOY_NO  ," ).append("\n"); 
		query.append("                            P.SKD_DIR_CD  ," ).append("\n"); 
		query.append("                            P.SLS_OFC_CD," ).append("\n"); 
		query.append("                            P.POL_YD_CD   ," ).append("\n"); 
		query.append("                            P.POD_YD_CD   ," ).append("\n"); 
		query.append("                            P.TS_FLG      ," ).append("\n"); 
		query.append("                            P.MNL_FLG     ," ).append("\n"); 
		query.append("                            P.CUST_CNT_CD ," ).append("\n"); 
		query.append("                            P.CUST_SEQ    ," ).append("\n"); 
		query.append("                            P.CTRT_NO     ," ).append("\n"); 
		query.append("                            P.CUST_CTRL_CD," ).append("\n"); 
		query.append("                            RL.REP_TRD_CD ," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                               SELECT RDRL.SUB_TRD_CD" ).append("\n"); 
		query.append("                                 FROM MDM_DTL_REV_LANE RDRL" ).append("\n"); 
		query.append("                                WHERE RL.RLANE_CD          = RDRL.RLANE_CD" ).append("\n"); 
		query.append("                                  AND RL.REP_TRD_CD        = RDRL.TRD_CD" ).append("\n"); 
		query.append("                                  AND RDRL.VSL_SLAN_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1" ).append("\n"); 
		query.append("                            ) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                            DRL.TRD_CD    ," ).append("\n"); 
		query.append("                            DRL.SUB_TRD_CD," ).append("\n"); 
		query.append("                            P.IOC_CD      ," ).append("\n"); 
		query.append("                            ( SELECT O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                                     MAS_MON_VVD C" ).append("\n"); 
		query.append("                               WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                                 AND C.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("                                 AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                                 AND C.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("                                 AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                                 AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                            ) AS SLS_RHQ_CD," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                               SELECT O.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                 FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                                      MAS_MON_VVD C" ).append("\n"); 
		query.append("                                WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                                  AND C.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("                                  AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                                  AND C.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("                                  AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                                  AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                            ) AS SLS_AQ_CD," ).append("\n"); 
		query.append("                            P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                               SELECT COUNT(1)" ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                                WHERE O.PRNT_OFC_CD = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                                  AND O.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                            ) AS SUB_OFC_CNT," ).append("\n"); 
		query.append("                            P.BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("                            P.FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("                            P.FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("                            P.FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("                            P.FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("                            P.FCAST_RF_QTY         ," ).append("\n"); 
		query.append("                            P.FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("                            P.USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("                            P.USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("                            P.USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("                            P.USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("                            P.USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("                            P.USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("                            P.USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("                            P.USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("                            P.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("                            P.USR_ID               ," ).append("\n"); 
		query.append("                            P.ALOC_GDT             ," ).append("\n"); 
		query.append("                            P.DT," ).append("\n"); 
		query.append("                  	    P.USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                  	    P.DEST_LOC_CD," ).append("\n"); 
		query.append("                            P.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("                            P.FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.FCAST_RD_QTY," ).append("\n"); 
		query.append("                            P.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.USD_BKG_RD_QTY" ).append("\n"); 
		query.append("                       FROM PARAMS           P   ," ).append("\n"); 
		query.append("                            MDM_REV_LANE     RL  ," ).append("\n"); 
		query.append("                            MDM_DTL_REV_LANE DRL ," ).append("\n"); 
		query.append("                            MDM_LOCATION     LLOC," ).append("\n"); 
		query.append("                            MDM_LOCATION     DLOC" ).append("\n"); 
		query.append("                      WHERE P.RLANE_CD                = RL.RLANE_CD" ).append("\n"); 
		query.append("                        AND P.RLANE_CD                = DRL.RLANE_CD" ).append("\n"); 
		query.append("                        AND P.SKD_DIR_CD              = DRL.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                        AND SUBSTR(P.POL_YD_CD, 1, 5) = LLOC.LOC_CD" ).append("\n"); 
		query.append("                        AND SUBSTR(P.POD_YD_CD, 1, 5) = DLOC.LOC_CD" ).append("\n"); 
		query.append("                        AND DRL.FM_CONTI_CD           = SPC_CONTI_CONV_FNC(LLOC.CONTI_CD, P.RLANE_CD,P.SKD_DIR_CD)" ).append("\n"); 
		query.append("                        AND DRL.TO_CONTI_CD           = SPC_CONTI_CONV_FNC(DLOC.CONTI_CD, P.RLANE_CD,P.SKD_DIR_CD)" ).append("\n"); 
		query.append("                        -- AND P.POD_YD_CD              <> '0000000'" ).append("\n"); 
		query.append("                        AND P.DEST_LOC_CD             <> '00000'" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("                     SELECT" ).append("\n"); 
		query.append("                            P.RLANE_CD    ," ).append("\n"); 
		query.append("                            P.DIR_CD      ," ).append("\n"); 
		query.append("                            P.VSL_CD      ," ).append("\n"); 
		query.append("                            P.SKD_VOY_NO  ," ).append("\n"); 
		query.append("                            P.SKD_DIR_CD  ," ).append("\n"); 
		query.append("                            P.SLS_OFC_CD," ).append("\n"); 
		query.append("                            P.POL_YD_CD   ," ).append("\n"); 
		query.append("                            P.POD_YD_CD   ," ).append("\n"); 
		query.append("                            P.TS_FLG      ," ).append("\n"); 
		query.append("                            P.MNL_FLG     ," ).append("\n"); 
		query.append("                            P.CUST_CNT_CD ," ).append("\n"); 
		query.append("                            P.CUST_SEQ    ," ).append("\n"); 
		query.append("                            P.CTRT_NO     ," ).append("\n"); 
		query.append("                            P.CUST_CTRL_CD," ).append("\n"); 
		query.append("                            RL.REP_TRD_CD ," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                               SELECT RDRL.SUB_TRD_CD" ).append("\n"); 
		query.append("                                 FROM MDM_DTL_REV_LANE RDRL" ).append("\n"); 
		query.append("                                WHERE RL.RLANE_CD          = RDRL.RLANE_CD" ).append("\n"); 
		query.append("                                  AND RL.REP_TRD_CD        = RDRL.TRD_CD" ).append("\n"); 
		query.append("                                  AND RDRL.VSL_SLAN_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1" ).append("\n"); 
		query.append("                            ) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                            P.TRD_CD    ," ).append("\n"); 
		query.append("                            P.SUB_TRD_CD," ).append("\n"); 
		query.append("                            P.IOC_CD    ," ).append("\n"); 
		query.append("                            ( SELECT O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                                     MAS_MON_VVD C" ).append("\n"); 
		query.append("                               WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                                 AND C.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("                                 AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                                 AND C.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("                                 AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                                 AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                            ) AS SLS_RHQ_CD," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                               SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                 FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                                      MAS_MON_VVD C" ).append("\n"); 
		query.append("                                WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                                  AND C.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("                                  AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                                  AND C.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("                                  AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                                  AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                            ) AS SLS_AQ_CD," ).append("\n"); 
		query.append("                            P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                               SELECT COUNT(1)" ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                                WHERE O.PRNT_OFC_CD = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                            ) AS SUB_OFC_CNT," ).append("\n"); 
		query.append("                            P.BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("                            P.BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("                            P.FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("                            P.FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("                            P.FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("                            P.FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("                            P.FCAST_RF_QTY         ," ).append("\n"); 
		query.append("                            P.FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("                            P.USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("                            P.USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("                            P.USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("                            P.USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("                            P.USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("                            P.USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("                            P.USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("                            P.USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("                            P.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("                            P.USR_ID               ," ).append("\n"); 
		query.append("                            P.ALOC_GDT             ," ).append("\n"); 
		query.append("                            P.DT," ).append("\n"); 
		query.append("                  	    P.USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                  	    P.DEST_LOC_CD," ).append("\n"); 
		query.append("                            P.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("                            P.FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.FCAST_RD_QTY," ).append("\n"); 
		query.append("                            P.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("                            P.USD_BKG_RD_QTY" ).append("\n"); 
		query.append("                       FROM PARAMS       P ," ).append("\n"); 
		query.append("                            MDM_REV_LANE RL" ).append("\n"); 
		query.append("                      WHERE P.RLANE_CD  = RL.RLANE_CD" ).append("\n"); 
		query.append("                   --   AND P.POD_YD_CD = '0000000'" ).append("\n"); 
		query.append("                        AND P.DEST_LOC_CD = '00000' " ).append("\n"); 
		query.append("                  ) Z" ).append("\n"); 
		query.append("      ) C" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("             T.RLANE_CD     = C.RLANE_CD" ).append("\n"); 
		query.append("         AND T.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("         AND T.VSL_CD       = C.VSL_CD" ).append("\n"); 
		query.append("         AND T.SKD_VOY_NO   = C.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND T.SKD_DIR_CD   = C.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND T.SLS_OFC_CD   = C.SLS_OFC_CD" ).append("\n"); 
		query.append("         AND T.POL_YD_CD    = C.POL_YD_CD" ).append("\n"); 
		query.append("         AND T.POD_YD_CD    = C.POD_YD_CD" ).append("\n"); 
		query.append("         AND T.DEST_LOC_CD  = C.DEST_LOC_CD" ).append("\n"); 
		query.append("         AND T.USA_BKG_MOD_CD   = C.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("         AND T.TS_FLG       = C.TS_FLG" ).append("\n"); 
		query.append("         AND T.MNL_FLG      = C.MNL_FLG" ).append("\n"); 
		query.append("         AND T.CUST_CNT_CD  = C.CUST_CNT_CD" ).append("\n"); 
		query.append("         AND T.CUST_SEQ     = C.CUST_SEQ" ).append("\n"); 
		query.append("         AND T.CTRT_NO      = C.CTRT_NO" ).append("\n"); 
		query.append("         AND T.CUST_CTRL_CD = C.CUST_CTRL_CD" ).append("\n"); 
		query.append("         AND T.IOC_CD       = C.IOC_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("       SET T.BKG_AVAL_TTL_QTY      = C.BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("           T.BKG_AVAL_40FT_HC_QTY  = C.BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("           T.BKG_AVAL_45FT_HC_QTY  = C.BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("           T.BKG_AVAL_53FT_QTY     = C.BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("           T.BKG_AVAL_RF_QTY       = C.BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("           T.BKG_AVAL_TTL_WGT      = C.BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("           T.FCAST_TTL_QTY         = C.FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("           T.FCAST_40FT_HC_QTY     = C.FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("           T.FCAST_45FT_HC_QTY     = C.FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("           T.FCAST_53FT_QTY        = C.FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("           T.FCAST_RF_QTY          = C.FCAST_RF_QTY         ," ).append("\n"); 
		query.append("           T.FCAST_TTL_WGT         = C.FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("           T.USD_BKG_TTL_QTY       = C.USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("           T.USD_BKG_20FT_QTY      = C.USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("           T.USD_BKG_40FT_QTY      = C.USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("           T.USD_BKG_40FT_HC_QTY   = C.USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("           T.USD_BKG_45FT_HC_QTY   = C.USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("           T.USD_BKG_53FT_QTY      = C.USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("           T.USD_BKG_RF_QTY        = C.USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("           T.USD_BKG_TTL_WGT       = C.USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("           T.ALOC_USR_ID           = C.ALOC_USR_ID          ," ).append("\n"); 
		query.append("           T.MNL_ALOC_RMK          = C.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("           T.ALOC_GDT              = C.ALOC_GDT             ," ).append("\n"); 
		query.append("           T.UPD_USR_ID            = C.UPD_USR_ID           ," ).append("\n"); 
		query.append("           T.UPD_DT                = C.UPD_DT		    ," ).append("\n"); 
		query.append("           --T.USA_BKG_MOD_CD		= C.USA_BKG_MOD_CD," ).append("\n"); 
		query.append("           --T.DEST_LOC_CD		= C.DEST_LOC_CD," ).append("\n"); 
		query.append("           T.BKG_AVAL_20FT_DRY_QTY	= C.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("           T.BKG_AVAL_40FT_DRY_QTY	= C.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("           T.BKG_AVAL_RD_QTY		= C.BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("           T.FCAST_20FT_DRY_QTY		= C.FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("           T.FCAST_40FT_DRY_QTY		= C.FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("           T.FCAST_RD_QTY		= C.FCAST_RD_QTY," ).append("\n"); 
		query.append("           T.USD_BKG_20FT_DRY_QTY	= C.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("           T.USD_BKG_40FT_DRY_QTY	= C.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("           T.USD_BKG_RD_QTY		= C.USD_BKG_RD_QTY" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("              RLANE_CD             ," ).append("\n"); 
		query.append("              DIR_CD               ," ).append("\n"); 
		query.append("              VSL_CD               ," ).append("\n"); 
		query.append("              SKD_VOY_NO           ," ).append("\n"); 
		query.append("              SKD_DIR_CD           ," ).append("\n"); 
		query.append("              SLS_OFC_CD           ," ).append("\n"); 
		query.append("              POL_YD_CD            ," ).append("\n"); 
		query.append("              POD_YD_CD            ," ).append("\n"); 
		query.append("              TS_FLG               ," ).append("\n"); 
		query.append("              MNL_FLG              ," ).append("\n"); 
		query.append("              CUST_CNT_CD          ," ).append("\n"); 
		query.append("              CUST_SEQ             ," ).append("\n"); 
		query.append("              CTRT_NO              ," ).append("\n"); 
		query.append("              CUST_CTRL_CD         ," ).append("\n"); 
		query.append("              REP_TRD_CD           ," ).append("\n"); 
		query.append("              REP_SUB_TRD_CD       ," ).append("\n"); 
		query.append("              TRD_CD               ," ).append("\n"); 
		query.append("              SUB_TRD_CD           ," ).append("\n"); 
		query.append("              IOC_CD               ," ).append("\n"); 
		query.append("              SLS_RHQ_CD           ," ).append("\n"); 
		query.append("              SLS_AQ_CD            ," ).append("\n"); 
		query.append("              SLS_RGN_OFC_CD       ," ).append("\n"); 
		query.append("              BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("              BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("              BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("              BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("              BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("              BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("              FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("              FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("              FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("              FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("              FCAST_RF_QTY         ," ).append("\n"); 
		query.append("              FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("              USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("              USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("              USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("              USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("              USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("              USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("              USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("              USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("              MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("              ALOC_USR_ID          ," ).append("\n"); 
		query.append("              ALOC_GDT             ," ).append("\n"); 
		query.append("              CRE_USR_ID           ," ).append("\n"); 
		query.append("              CRE_DT               ," ).append("\n"); 
		query.append("              UPD_USR_ID           ," ).append("\n"); 
		query.append("              UPD_DT	           ," ).append("\n"); 
		query.append("              USA_BKG_MOD_CD	   ," ).append("\n"); 
		query.append("              DEST_LOC_CD	   ," ).append("\n"); 
		query.append("              BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("              BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("              BKG_AVAL_RD_QTY	   ," ).append("\n"); 
		query.append("              FCAST_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("              FCAST_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("              FCAST_RD_QTY	   ," ).append("\n"); 
		query.append("              USD_BKG_20FT_DRY_QTY ," ).append("\n"); 
		query.append("              USD_BKG_40FT_DRY_QTY ," ).append("\n"); 
		query.append("              USD_BKG_RD_QTY" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("              C.RLANE_CD             ," ).append("\n"); 
		query.append("              C.DIR_CD               ," ).append("\n"); 
		query.append("              C.VSL_CD               ," ).append("\n"); 
		query.append("              C.SKD_VOY_NO           ," ).append("\n"); 
		query.append("              C.SKD_DIR_CD           ," ).append("\n"); 
		query.append("              C.SLS_OFC_CD           ," ).append("\n"); 
		query.append("              C.POL_YD_CD            ," ).append("\n"); 
		query.append("              C.POD_YD_CD            ," ).append("\n"); 
		query.append("              C.TS_FLG               ," ).append("\n"); 
		query.append("              C.MNL_FLG              ," ).append("\n"); 
		query.append("              C.CUST_CNT_CD          ," ).append("\n"); 
		query.append("              C.CUST_SEQ             ," ).append("\n"); 
		query.append("              C.CTRT_NO              ," ).append("\n"); 
		query.append("              C.CUST_CTRL_CD         ," ).append("\n"); 
		query.append("              C.REP_TRD_CD           ," ).append("\n"); 
		query.append("              C.REP_SUB_TRD_CD       ," ).append("\n"); 
		query.append("              C.TRD_CD               ," ).append("\n"); 
		query.append("              C.SUB_TRD_CD           ," ).append("\n"); 
		query.append("              C.IOC_CD               ," ).append("\n"); 
		query.append("              C.SLS_RHQ_CD           ," ).append("\n"); 
		query.append("              C.SLS_AQ_CD            ," ).append("\n"); 
		query.append("              C.SLS_RGN_OFC_CD       ," ).append("\n"); 
		query.append("              C.BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("              C.BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("              C.BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("              C.BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("              C.BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("              C.BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("              C.FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("              C.FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("              C.FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("              C.FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("              C.FCAST_RF_QTY         ," ).append("\n"); 
		query.append("              C.FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("              C.USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("              C.USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("              C.USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("              C.USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("              C.USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("              C.USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("              C.USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("              C.USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("              C.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("              C.ALOC_USR_ID          ," ).append("\n"); 
		query.append("              C.ALOC_GDT             ," ).append("\n"); 
		query.append("              C.CRE_USR_ID           ," ).append("\n"); 
		query.append("              C.CRE_DT               ," ).append("\n"); 
		query.append("              C.UPD_USR_ID           ," ).append("\n"); 
		query.append("              C.UPD_DT	             ," ).append("\n"); 
		query.append("              C.USA_BKG_MOD_CD	   ," ).append("\n"); 
		query.append("              C.DEST_LOC_CD	   ," ).append("\n"); 
		query.append("              C.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("              C.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("              C.BKG_AVAL_RD_QTY	   ," ).append("\n"); 
		query.append("              C.FCAST_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("              C.FCAST_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("              C.FCAST_RD_QTY	   ," ).append("\n"); 
		query.append("              C.USD_BKG_20FT_DRY_QTY ," ).append("\n"); 
		query.append("              C.USD_BKG_40FT_DRY_QTY ," ).append("\n"); 
		query.append("              C.USD_BKG_RD_QTY" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}
