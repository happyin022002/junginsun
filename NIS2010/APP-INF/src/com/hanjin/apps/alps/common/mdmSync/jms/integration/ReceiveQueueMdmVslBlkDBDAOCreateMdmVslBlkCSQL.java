/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmVslBlkDBDAOCreateMdmVslBlkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 김준호
*@LastVersion : 1.0
* 2010.03.11 김준호
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

public class ReceiveQueueMdmVslBlkDBDAOCreateMdmVslBlkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateMdmVslBlk
	  * </pre>
	  */
	public ReceiveQueueMdmVslBlkDBDAOCreateMdmVslBlkCSQL(){
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnt_dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_ldn_csm2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trop_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_ldn_csm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trop_dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_foil_ton_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rgst_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgt_shp_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_gt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldn_wgt_spd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cons_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_blst_csm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_blst_csm2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_htch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blst_wgt_spd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blst_wgt_spd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnt_tpc_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loa_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_rgst_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ht_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_doil_ton_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnt_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_idle_doil_ton_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smr_dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_hld_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		query.append("FileName : ReceiveQueueMdmVslBlkDBDAOCreateMdmVslBlkCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_VSL_BLK (" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",	VSL_CLSS_FLG" ).append("\n"); 
		query.append(",	VSL_ENG_NM" ).append("\n"); 
		query.append(",	VSL_KRN_NM" ).append("\n"); 
		query.append(",	FOIL_CAPA" ).append("\n"); 
		query.append(",	DOIL_CAPA" ).append("\n"); 
		query.append(",	FRSH_WTR_CAPA" ).append("\n"); 
		query.append(",	GRN_TONG_CAPA" ).append("\n"); 
		query.append(",	BAIL_TONG_CAPA" ).append("\n"); 
		query.append(",	TNK_TONG_CAPA" ).append("\n"); 
		query.append(",	CALL_SGN_NO" ).append("\n"); 
		query.append(",	RGST_PORT_CD" ).append("\n"); 
		query.append(",	VSL_BLDR_NM" ).append("\n"); 
		query.append(",	LOA_LEN" ).append("\n"); 
		query.append(",	SMR_DRFT_HGT" ).append("\n"); 
		query.append(",	LGT_SHP_TONG_WGT" ).append("\n"); 
		query.append(",	GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	NET_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	PNM_GT_WGT" ).append("\n"); 
		query.append(",	PNM_NET_TONG_WGT" ).append("\n"); 
		query.append(",	SUZ_GT_WGT" ).append("\n"); 
		query.append(",	SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append(",	MN_ENG_MKR_NM" ).append("\n"); 
		query.append(",	BLK_MN_ENG_TP_CD" ).append("\n"); 
		query.append(",	MN_ENG_BHP_PWR" ).append("\n"); 
		query.append(",	VSL_OWN_IND_CD" ).append("\n"); 
		query.append(",	VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",	VSL_BLD_DT" ).append("\n"); 
		query.append(",	LOA_UT_CD" ).append("\n"); 
		query.append(",	VSL_BM_WDT" ).append("\n"); 
		query.append(",	VSL_BM_UT_CD" ).append("\n"); 
		query.append(",	VSL_OWN_CUST_CNT_CD" ).append("\n"); 
		query.append(",	VSL_OWN_CUST_SEQ" ).append("\n"); 
		query.append(",	VSL_CGO_GR_NM" ).append("\n"); 
		query.append(",	VSL_CAPA_UT_CD" ).append("\n"); 
		query.append(",	VSL_DWT_UT_CD" ).append("\n"); 
		query.append(",	BLK_CRR_TP_CD" ).append("\n"); 
		query.append(",	VSL_DRFT_UT_CD" ).append("\n"); 
		query.append(",	SMR_TPC_TON_WGT" ).append("\n"); 
		query.append(",	WNT_TPC_TON_WGT" ).append("\n"); 
		query.append(",	TROP_TPC_TON_WGT" ).append("\n"); 
		query.append(",	BLST_WGT_SPD1" ).append("\n"); 
		query.append(",	LDN_WGT_SPD1" ).append("\n"); 
		query.append(",	BLST_WGT_SPD2" ).append("\n"); 
		query.append(",	LDN_WGT_SPD2" ).append("\n"); 
		query.append(",	FOIL_BLST_CSM1" ).append("\n"); 
		query.append(",	FOIL_LDN_CSM1" ).append("\n"); 
		query.append(",	FOIL_BLST_CSM2" ).append("\n"); 
		query.append(",	FOIL_LDN_CSM2" ).append("\n"); 
		query.append(",	PORT_FOIL_TON_CSM" ).append("\n"); 
		query.append(",	SEA_DOIL_TON_CSM" ).append("\n"); 
		query.append(",	PORT_IDLE_DOIL_TON_CSM" ).append("\n"); 
		query.append(",	PORT_WRK_DOIL_TON_CSM" ).append("\n"); 
		query.append(",	VSL_BUNK_UT_CD" ).append("\n"); 
		query.append(",	CONS_TON_WGT" ).append("\n"); 
		query.append(",	ENT_TP_CD" ).append("\n"); 
		query.append(",	WNT_DRFT_HGT" ).append("\n"); 
		query.append(",	TROP_DRFT_HGT" ).append("\n"); 
		query.append(",	SMR_DWT_WGT" ).append("\n"); 
		query.append(",	WNT_DWT_WGT" ).append("\n"); 
		query.append(",	TROP_DWT_WGT" ).append("\n"); 
		query.append(",	VSL_HTCH_KNT" ).append("\n"); 
		query.append(",	VSL_HLD_KNT" ).append("\n"); 
		query.append(",	BLK_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	HT_FOIL_CSM" ).append("\n"); 
		query.append(",	PMP_OIL_KND_CD" ).append("\n"); 
		query.append(",	PMP_OIL_CSM" ).append("\n"); 
		query.append(",	CLN_OIL_KND_CD" ).append("\n"); 
		query.append(",	CLN_OIL_CSM" ).append("\n"); 
		query.append(",	LNCH_DT" ).append("\n"); 
		query.append(",	RGST_DT" ).append("\n"); 
		query.append(",	IMO_NO" ).append("\n"); 
		query.append(",	VSL_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append(",	VSL_OWN_CUST_NM" ).append("\n"); 
		query.append(",	BLK_VSL_DE_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[vsl_cd]" ).append("\n"); 
		query.append(",	@[vsl_clss_flg]" ).append("\n"); 
		query.append(",	@[vsl_eng_nm]" ).append("\n"); 
		query.append(",	@[vsl_krn_nm]" ).append("\n"); 
		query.append(",	@[foil_capa]" ).append("\n"); 
		query.append(",	@[doil_capa]" ).append("\n"); 
		query.append(",	@[frsh_wtr_capa]" ).append("\n"); 
		query.append(",	@[grn_tong_capa]" ).append("\n"); 
		query.append(",	@[bail_tong_capa]" ).append("\n"); 
		query.append(",	@[tnk_tong_capa]" ).append("\n"); 
		query.append(",	@[call_sgn_no]" ).append("\n"); 
		query.append(",	@[rgst_port_cd]" ).append("\n"); 
		query.append(",	@[vsl_bldr_nm]" ).append("\n"); 
		query.append(",	@[loa_len]" ).append("\n"); 
		query.append(",	@[smr_drft_hgt]" ).append("\n"); 
		query.append(",	@[lgt_shp_tong_wgt]" ).append("\n"); 
		query.append(",	@[grs_rgst_tong_wgt]" ).append("\n"); 
		query.append(",	@[net_rgst_tong_wgt]" ).append("\n"); 
		query.append(",	@[pnm_gt_wgt]" ).append("\n"); 
		query.append(",	@[pnm_net_tong_wgt]" ).append("\n"); 
		query.append(",	@[suz_gt_wgt]" ).append("\n"); 
		query.append(",	@[suz_net_tong_wgt]" ).append("\n"); 
		query.append(",	@[mn_eng_mkr_nm]" ).append("\n"); 
		query.append(",	@[blk_mn_eng_tp_cd]" ).append("\n"); 
		query.append(",	@[mn_eng_bhp_pwr]" ).append("\n"); 
		query.append(",	@[vsl_own_ind_cd]" ).append("\n"); 
		query.append(",	@[vsl_rgst_cnt_cd]" ).append("\n"); 
		query.append(",	SUBSTR(@[vsl_bld_dt],1,8)" ).append("\n"); 
		query.append(",	@[loa_ut_cd]" ).append("\n"); 
		query.append(",	@[vsl_bm_wdt]" ).append("\n"); 
		query.append(",	@[vsl_bm_ut_cd]" ).append("\n"); 
		query.append(",	@[vsl_own_cust_cnt_cd]" ).append("\n"); 
		query.append(",	@[vsl_own_cust_seq]" ).append("\n"); 
		query.append(",	@[vsl_cgo_gr_nm]" ).append("\n"); 
		query.append(",	@[vsl_capa_ut_cd]" ).append("\n"); 
		query.append(",	@[vsl_dwt_ut_cd]" ).append("\n"); 
		query.append(",	@[blk_crr_tp_cd]" ).append("\n"); 
		query.append(",	@[vsl_drft_ut_cd]" ).append("\n"); 
		query.append(",	@[smr_tpc_ton_wgt]" ).append("\n"); 
		query.append(",	@[wnt_tpc_ton_wgt]" ).append("\n"); 
		query.append(",	@[trop_tpc_ton_wgt]" ).append("\n"); 
		query.append(",	@[blst_wgt_spd1]" ).append("\n"); 
		query.append(",	@[ldn_wgt_spd1]" ).append("\n"); 
		query.append(",	@[blst_wgt_spd2]" ).append("\n"); 
		query.append(",	@[ldn_wgt_spd2]" ).append("\n"); 
		query.append(",	@[foil_blst_csm1]" ).append("\n"); 
		query.append(",	@[foil_ldn_csm1]" ).append("\n"); 
		query.append(",	@[foil_blst_csm2]" ).append("\n"); 
		query.append(",	@[foil_ldn_csm2]" ).append("\n"); 
		query.append(",	@[port_foil_ton_csm]" ).append("\n"); 
		query.append(",	@[sea_doil_ton_csm]" ).append("\n"); 
		query.append(",	@[port_idle_doil_ton_csm]" ).append("\n"); 
		query.append(",	@[port_wrk_doil_ton_csm]" ).append("\n"); 
		query.append(",	@[vsl_bunk_ut_cd]" ).append("\n"); 
		query.append(",	@[cons_ton_wgt]" ).append("\n"); 
		query.append(",	@[ent_tp_cd]" ).append("\n"); 
		query.append(",	@[wnt_drft_hgt]" ).append("\n"); 
		query.append(",	@[trop_drft_hgt]" ).append("\n"); 
		query.append(",	@[smr_dwt_wgt]" ).append("\n"); 
		query.append(",	@[wnt_dwt_wgt]" ).append("\n"); 
		query.append(",	@[trop_dwt_wgt]" ).append("\n"); 
		query.append(",	@[vsl_htch_knt]" ).append("\n"); 
		query.append(",	@[vsl_hld_knt]" ).append("\n"); 
		query.append(",	@[blk_vsl_clss_cd]" ).append("\n"); 
		query.append(",	@[ht_foil_csm]" ).append("\n"); 
		query.append(",	@[pmp_oil_knd_cd]" ).append("\n"); 
		query.append(",	@[pmp_oil_csm]" ).append("\n"); 
		query.append(",	@[cln_oil_knd_cd]" ).append("\n"); 
		query.append(",	@[cln_oil_csm]" ).append("\n"); 
		query.append(",	TO_DATE(@[lnch_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",	TO_DATE(@[rgst_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",	@[imo_no]" ).append("\n"); 
		query.append(",	@[vsl_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[cre_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[vsl_own_cust_nm]" ).append("\n"); 
		query.append(",   TO_DATE(@[blk_vsl_de_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}