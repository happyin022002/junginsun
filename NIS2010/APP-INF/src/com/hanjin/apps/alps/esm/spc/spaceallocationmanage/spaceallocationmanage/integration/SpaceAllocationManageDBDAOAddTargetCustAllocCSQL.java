/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOAddTargetCustAllocCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2014.01.03 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOAddTargetCustAllocCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회해놓은 Alloc을 새 Season에 존재하는 그룹으로 변경하여 입력합니다.
	  * 
	  * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOAddTargetCustAllocCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_aloc_pod_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnl_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_aq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_ctrl_aloc_pol_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOAddTargetCustAllocCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_CUST_POL_POD(" ).append("\n"); 
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
		query.append("              CUST_CTRL_CD         ," ).append("\n"); 
		query.append("              REP_TRD_CD           ," ).append("\n"); 
		query.append("              REP_SUB_TRD_CD       ," ).append("\n"); 
		query.append("              TRD_CD               ," ).append("\n"); 
		query.append("              SUB_TRD_CD           ," ).append("\n"); 
		query.append("              IOC_CD               ," ).append("\n"); 
		query.append("              SLS_RHQ_CD           ," ).append("\n"); 
		query.append("              SLS_AQ_CD            ," ).append("\n"); 
		query.append("              SLS_RGN_OFC_CD       ," ).append("\n"); 
		query.append("              ASGN_TTL_QTY         ," ).append("\n"); 
		query.append("              ASGN_20FT_QTY        ," ).append("\n"); 
		query.append("              ASGN_40FT_QTY        ," ).append("\n"); 
		query.append("              ASGN_40FT_HC_QTY     ," ).append("\n"); 
		query.append("              ASGN_45FT_HC_QTY     ," ).append("\n"); 
		query.append("              ASGN_53FT_QTY        ," ).append("\n"); 
		query.append("              ASGN_RF_QTY          ," ).append("\n"); 
		query.append("              ASGN_TTL_WGT         ," ).append("\n"); 
		query.append("              BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("              BKG_AVAL_20FT_QTY    ," ).append("\n"); 
		query.append("              BKG_AVAL_40FT_QTY    ," ).append("\n"); 
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
		query.append("              SPC_CTRL_ALOC_RMK    ," ).append("\n"); 
		query.append("              SPC_CTRL_ALOC_POL_RMK," ).append("\n"); 
		query.append("              SPC_CTRL_ALOC_POD_RMK," ).append("\n"); 
		query.append("              MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("              ALOC_USR_ID          ," ).append("\n"); 
		query.append("              ALOC_GDT             ," ).append("\n"); 
		query.append("              POL_IND_SEQ          ," ).append("\n"); 
		query.append("              POD_IND_SEQ          ," ).append("\n"); 
		query.append("              POL_YD_IND_SEQ       ," ).append("\n"); 
		query.append("              POD_YD_IND_SEQ       ," ).append("\n"); 
		query.append("              CRE_USR_ID           ," ).append("\n"); 
		query.append("              CRE_DT               ," ).append("\n"); 
		query.append("              UPD_USR_ID           ," ).append("\n"); 
		query.append("              UPD_DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("              @[rlane_cd]             ," ).append("\n"); 
		query.append("              @[dir_cd]               ," ).append("\n"); 
		query.append("              @[vsl_cd]               ," ).append("\n"); 
		query.append("              @[skd_voy_no]           ," ).append("\n"); 
		query.append("              @[skd_dir_cd]           ," ).append("\n"); 
		query.append("              @[sls_ofc_cd]           ," ).append("\n"); 
		query.append("              @[pol_yd_cd]            ," ).append("\n"); 
		query.append("              @[pod_yd_cd]            ," ).append("\n"); 
		query.append("              @[ts_flg]               ," ).append("\n"); 
		query.append("              @[mnl_flg]              ," ).append("\n"); 
		query.append("              @[cust_cnt_cd]          ," ).append("\n"); 
		query.append("              @[cust_seq]             ," ).append("\n"); 
		query.append("              @[cust_ctrl_cd]         ," ).append("\n"); 
		query.append("              @[rep_trd_cd]           ," ).append("\n"); 
		query.append("              @[rep_sub_trd_cd]       ," ).append("\n"); 
		query.append("              @[trd_cd]               ," ).append("\n"); 
		query.append("              @[sub_trd_cd]           ," ).append("\n"); 
		query.append("              @[ioc_cd]               ," ).append("\n"); 
		query.append("              @[sls_rhq_cd]           ," ).append("\n"); 
		query.append("              @[sls_aq_cd]            ," ).append("\n"); 
		query.append("              @[sls_rgn_ofc_cd]       ," ).append("\n"); 
		query.append("              @[asgn_ttl_qty]         ," ).append("\n"); 
		query.append("              @[asgn_20ft_qty]        ," ).append("\n"); 
		query.append("              @[asgn_40ft_qty]        ," ).append("\n"); 
		query.append("              @[asgn_40ft_hc_qty]     ," ).append("\n"); 
		query.append("              @[asgn_45ft_hc_qty]     ," ).append("\n"); 
		query.append("              @[asgn_53ft_qty]        ," ).append("\n"); 
		query.append("              @[asgn_rf_qty]          ," ).append("\n"); 
		query.append("              @[asgn_ttl_wgt]         ," ).append("\n"); 
		query.append("              @[bkg_aval_ttl_qty]     ," ).append("\n"); 
		query.append("              @[bkg_aval_20ft_qty]    ," ).append("\n"); 
		query.append("              @[bkg_aval_40ft_qty]    ," ).append("\n"); 
		query.append("              @[bkg_aval_40ft_hc_qty] ," ).append("\n"); 
		query.append("              @[bkg_aval_45ft_hc_qty] ," ).append("\n"); 
		query.append("              @[bkg_aval_53ft_qty]    ," ).append("\n"); 
		query.append("              @[bkg_aval_rf_qty]      ," ).append("\n"); 
		query.append("              @[bkg_aval_ttl_wgt]     ," ).append("\n"); 
		query.append("              @[fcast_ttl_qty]        ," ).append("\n"); 
		query.append("              @[fcast_40ft_hc_qty]    ," ).append("\n"); 
		query.append("              @[fcast_45ft_hc_qty]    ," ).append("\n"); 
		query.append("              @[fcast_53ft_qty]       ," ).append("\n"); 
		query.append("              @[fcast_rf_qty]         ," ).append("\n"); 
		query.append("              @[fcast_ttl_wgt]        ," ).append("\n"); 
		query.append("              @[usd_bkg_ttl_qty]      ," ).append("\n"); 
		query.append("              @[usd_bkg_20ft_qty]     ," ).append("\n"); 
		query.append("              @[usd_bkg_40ft_qty]     ," ).append("\n"); 
		query.append("              @[usd_bkg_40ft_hc_qty]  ," ).append("\n"); 
		query.append("              @[usd_bkg_45ft_hc_qty]  ," ).append("\n"); 
		query.append("              @[usd_bkg_53ft_qty]     ," ).append("\n"); 
		query.append("              @[usd_bkg_rf_qty]       ," ).append("\n"); 
		query.append("              @[usd_bkg_ttl_wgt]      ," ).append("\n"); 
		query.append("              @[spc_ctrl_aloc_rmk]    ," ).append("\n"); 
		query.append("              @[spc_ctrl_aloc_pol_rmk]," ).append("\n"); 
		query.append("              @[spc_ctrl_aloc_pod_rmk]," ).append("\n"); 
		query.append("              @[mnl_aloc_rmk]         ," ).append("\n"); 
		query.append("              @[aloc_usr_id]          ," ).append("\n"); 
		query.append("              TO_DATE(@[aloc_gdt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("              @[pol_ind_seq]          ," ).append("\n"); 
		query.append("              @[pod_ind_seq]          ," ).append("\n"); 
		query.append("              @[pol_yd_ind_seq]       ," ).append("\n"); 
		query.append("              @[pod_yd_ind_seq]       ," ).append("\n"); 
		query.append("              @[cre_usr_id]           ," ).append("\n"); 
		query.append("              TO_DATE(@[cre_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("              @[upd_usr_id]           ," ).append("\n"); 
		query.append("              TO_DATE(@[upd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}