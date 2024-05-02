/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmVslBlkDBDAOModifyMdmVslBlkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김준호
*@LastVersion : 1.0
* 2010.03.12 김준호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jun-Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVslBlkDBDAOModifyMdmVslBlkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMdmVslBlk
	  * </pre>
	  */
	public ReceiveQueueMdmVslBlkDBDAOModifyMdmVslBlkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_vsl_de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cln_oil_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnt_dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bail_tong_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ent_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_ldn_csm2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trop_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_ldn_csm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trop_dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_foil_ton_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rgst_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgt_shp_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_gt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_wrk_doil_ton_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_own_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ldn_wgt_spd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldn_wgt_spd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cons_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_blst_csm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_blst_csm2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smr_tpc_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pmp_oil_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_own_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_capa_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_htch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blst_wgt_spd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blst_wgt_spd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnt_tpc_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loa_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pmp_oil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_rgst_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trop_tpc_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grn_tong_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tnk_tong_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bunk_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bldr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_drft_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_krn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frsh_wtr_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cgo_gr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loa_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cln_oil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_own_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bm_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dwt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_rgst_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smr_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_own_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_bhp_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ht_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_doil_ton_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnt_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_idle_doil_ton_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("suz_gt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_crr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_mn_eng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smr_dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("suz_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_hld_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bm_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVslBlkDBDAOModifyMdmVslBlkUSQL").append("\n"); 
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
		query.append("UPDATE MDM_VSL_BLK SET" ).append("\n"); 
		query.append("VSL_CLSS_FLG = @[vsl_clss_flg]" ).append("\n"); 
		query.append(",	VSL_ENG_NM = @[vsl_eng_nm]" ).append("\n"); 
		query.append(",	VSL_KRN_NM = @[vsl_krn_nm]" ).append("\n"); 
		query.append(",	FOIL_CAPA = @[foil_capa]" ).append("\n"); 
		query.append(",	DOIL_CAPA = @[doil_capa]" ).append("\n"); 
		query.append(",	FRSH_WTR_CAPA = @[frsh_wtr_capa]" ).append("\n"); 
		query.append(",	GRN_TONG_CAPA = @[grn_tong_capa]" ).append("\n"); 
		query.append(",	BAIL_TONG_CAPA = @[bail_tong_capa]" ).append("\n"); 
		query.append(",	TNK_TONG_CAPA = @[tnk_tong_capa]" ).append("\n"); 
		query.append(",	CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append(",	RGST_PORT_CD = @[rgst_port_cd]" ).append("\n"); 
		query.append(",	VSL_BLDR_NM = @[vsl_bldr_nm]" ).append("\n"); 
		query.append(",	LOA_LEN = @[loa_len]" ).append("\n"); 
		query.append(",	SMR_DRFT_HGT = @[smr_drft_hgt]" ).append("\n"); 
		query.append(",	LGT_SHP_TONG_WGT = @[lgt_shp_tong_wgt]" ).append("\n"); 
		query.append(",	GRS_RGST_TONG_WGT = @[grs_rgst_tong_wgt]" ).append("\n"); 
		query.append(",	NET_RGST_TONG_WGT = @[net_rgst_tong_wgt]" ).append("\n"); 
		query.append(",	PNM_GT_WGT = @[pnm_gt_wgt]" ).append("\n"); 
		query.append(",	PNM_NET_TONG_WGT = @[pnm_net_tong_wgt]" ).append("\n"); 
		query.append(",	SUZ_GT_WGT = @[suz_gt_wgt]" ).append("\n"); 
		query.append(",	SUZ_NET_TONG_WGT = @[suz_net_tong_wgt]" ).append("\n"); 
		query.append(",	MN_ENG_MKR_NM = @[mn_eng_mkr_nm]" ).append("\n"); 
		query.append(",	BLK_MN_ENG_TP_CD = @[blk_mn_eng_tp_cd]" ).append("\n"); 
		query.append(",	MN_ENG_BHP_PWR = @[mn_eng_bhp_pwr]" ).append("\n"); 
		query.append(",	VSL_OWN_IND_CD = @[vsl_own_ind_cd]" ).append("\n"); 
		query.append(",	VSL_RGST_CNT_CD = @[vsl_rgst_cnt_cd]" ).append("\n"); 
		query.append(",	VSL_BLD_DT = SUBSTR(@[vsl_bld_dt],1,8)" ).append("\n"); 
		query.append(",	LOA_UT_CD = @[loa_ut_cd]" ).append("\n"); 
		query.append(",	VSL_BM_WDT = @[vsl_bm_wdt]" ).append("\n"); 
		query.append(",	VSL_BM_UT_CD = @[vsl_bm_ut_cd]" ).append("\n"); 
		query.append(",	VSL_OWN_CUST_CNT_CD = @[vsl_own_cust_cnt_cd]" ).append("\n"); 
		query.append(",	VSL_OWN_CUST_SEQ = @[vsl_own_cust_seq]" ).append("\n"); 
		query.append(",	VSL_CGO_GR_NM = @[vsl_cgo_gr_nm]" ).append("\n"); 
		query.append(",	VSL_CAPA_UT_CD = @[vsl_capa_ut_cd]" ).append("\n"); 
		query.append(",	VSL_DWT_UT_CD = @[vsl_dwt_ut_cd]" ).append("\n"); 
		query.append(",	BLK_CRR_TP_CD = @[blk_crr_tp_cd]" ).append("\n"); 
		query.append(",	VSL_DRFT_UT_CD = @[vsl_drft_ut_cd]" ).append("\n"); 
		query.append(",	SMR_TPC_TON_WGT = @[smr_tpc_ton_wgt]" ).append("\n"); 
		query.append(",	WNT_TPC_TON_WGT = @[wnt_tpc_ton_wgt]" ).append("\n"); 
		query.append(",	TROP_TPC_TON_WGT = @[trop_tpc_ton_wgt]" ).append("\n"); 
		query.append(",	BLST_WGT_SPD1 = @[blst_wgt_spd1]" ).append("\n"); 
		query.append(",	LDN_WGT_SPD1 = @[ldn_wgt_spd1]" ).append("\n"); 
		query.append(",	BLST_WGT_SPD2 = @[blst_wgt_spd2]" ).append("\n"); 
		query.append(",	LDN_WGT_SPD2 = @[ldn_wgt_spd2]" ).append("\n"); 
		query.append(",	FOIL_BLST_CSM1 = @[foil_blst_csm1]" ).append("\n"); 
		query.append(",	FOIL_LDN_CSM1 = @[foil_ldn_csm1]" ).append("\n"); 
		query.append(",	FOIL_BLST_CSM2 = @[foil_blst_csm2]" ).append("\n"); 
		query.append(",	FOIL_LDN_CSM2 = @[foil_ldn_csm2]" ).append("\n"); 
		query.append(",	PORT_FOIL_TON_CSM = @[port_foil_ton_csm]" ).append("\n"); 
		query.append(",	SEA_DOIL_TON_CSM = @[sea_doil_ton_csm]" ).append("\n"); 
		query.append(",	PORT_IDLE_DOIL_TON_CSM = @[port_idle_doil_ton_csm]" ).append("\n"); 
		query.append(",	PORT_WRK_DOIL_TON_CSM = @[port_wrk_doil_ton_csm]" ).append("\n"); 
		query.append(",	VSL_BUNK_UT_CD = @[vsl_bunk_ut_cd]" ).append("\n"); 
		query.append(",	CONS_TON_WGT = @[cons_ton_wgt]" ).append("\n"); 
		query.append(",	ENT_TP_CD = @[ent_tp_cd]" ).append("\n"); 
		query.append(",	WNT_DRFT_HGT = @[wnt_drft_hgt]" ).append("\n"); 
		query.append(",	TROP_DRFT_HGT = @[trop_drft_hgt]" ).append("\n"); 
		query.append(",	SMR_DWT_WGT = @[smr_dwt_wgt]" ).append("\n"); 
		query.append(",	WNT_DWT_WGT = @[wnt_dwt_wgt]" ).append("\n"); 
		query.append(",	TROP_DWT_WGT = @[trop_dwt_wgt]" ).append("\n"); 
		query.append(",	VSL_HTCH_KNT = @[vsl_htch_knt]" ).append("\n"); 
		query.append(",	VSL_HLD_KNT = @[vsl_hld_knt]" ).append("\n"); 
		query.append(",	BLK_VSL_CLSS_CD = @[blk_vsl_clss_cd]" ).append("\n"); 
		query.append(",	HT_FOIL_CSM = @[ht_foil_csm]" ).append("\n"); 
		query.append(",	PMP_OIL_KND_CD = @[pmp_oil_knd_cd]" ).append("\n"); 
		query.append(",	PMP_OIL_CSM = @[pmp_oil_csm]" ).append("\n"); 
		query.append(",	CLN_OIL_KND_CD = @[cln_oil_knd_cd]" ).append("\n"); 
		query.append(",	CLN_OIL_CSM = @[cln_oil_csm]" ).append("\n"); 
		query.append(",	LNCH_DT = TO_DATE(@[lnch_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",	RGST_DT = TO_DATE(@[rgst_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",	IMO_NO = @[imo_no]" ).append("\n"); 
		query.append(",	VSL_RMK = @[vsl_rmk]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	DELT_FLG = NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",	EAI_EVNT_DT = SYSDATE" ).append("\n"); 
		query.append(",	VSL_OWN_CUST_NM = @[vsl_own_cust_nm]" ).append("\n"); 
		query.append(",	BLK_VSL_DE_DT = TO_DATE(@[blk_vsl_de_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}