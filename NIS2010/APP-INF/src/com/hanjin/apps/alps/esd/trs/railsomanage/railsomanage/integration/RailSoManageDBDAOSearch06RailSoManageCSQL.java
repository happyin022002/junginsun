/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOSearch06RailSoManageCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.02.08 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch06RailSoManageCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail O/B SO 대상 추가 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch06RailSoManageCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sCtrlUserId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_patt_div_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_spe",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("interchange2_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunkvvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pln_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("interchange1_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rail_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtr_div_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_cstms_clr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_cmb_thru_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcvde_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch06RailSoManageCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RAIL_BIL_ORD_TMP (" ).append("\n"); 
		query.append("TRSP_RAIL_TMP_SEQ," ).append("\n"); 
		query.append("TRSP_BND_CD," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("SC_NO," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("POD_NOD_CD," ).append("\n"); 
		query.append("POL_NOD_CD," ).append("\n"); 
		query.append("POR_NOD_CD," ).append("\n"); 
		query.append("FM_NOD_CD," ).append("\n"); 
		query.append("TO_NOD_CD," ).append("\n"); 
		query.append("IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("DEL_SCC_CD," ).append("\n"); 
		query.append("DEL_NOD_CD," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("LST_NOD_PLN_DT," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("CGO_TP_CD," ).append("\n"); 
		query.append("BKG_SPCL_CGO_TP_CTNT," ).append("\n"); 
		query.append("SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("CNTR_WGT," ).append("\n"); 
		query.append("CMDT_NM," ).append("\n"); 
		query.append("VVD_CD," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("CMDT_CD," ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("ACT_GRP_CD," ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("ROUT_PLN_CD," ).append("\n"); 
		query.append("INLND_ROUT_RMK," ).append("\n"); 
		query.append("TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("INTER_RMK," ).append("\n"); 
		query.append("ROUT_DTL_SEQ," ).append("\n"); 
		query.append("ITCHG_LOC_ID1," ).append("\n"); 
		query.append("ITCHG_LOC_ID2," ).append("\n"); 
		query.append("POR_CD," ).append("\n"); 
		query.append("DEL_CD," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("RAIL_TZ_RPT_DIV_KNT," ).append("\n"); 
		query.append("REF_NO_DESC," ).append("\n"); 
		query.append("LNK_ORG_NOD_CD," ).append("\n"); 
		query.append("LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("RAIL_RCV_COFF_TO_DT," ).append("\n"); 
		query.append("GLO_TM_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_rail_tmp_seq]," ).append("\n"); 
		query.append("@[trsp_bnd_cd]," ).append("\n"); 
		query.append("@[eq_no]," ).append("\n"); 
		query.append("@[sc_no]," ).append("\n"); 
		query.append("@[eq_tpsz_cd]," ).append("\n"); 
		query.append("@[pod_nod_cd]," ).append("\n"); 
		query.append("@[pol_nod_cd]," ).append("\n"); 
		query.append("@[por_nod_cd]," ).append("\n"); 
		query.append("@[fm_nod_cd]," ).append("\n"); 
		query.append("@[to_nod_cd]," ).append("\n"); 
		query.append("@[ibd_cstms_clr_loc_cd]," ).append("\n"); 
		query.append("@[del_scc_cd]," ).append("\n"); 
		query.append("@[del_nod_cd]," ).append("\n"); 
		query.append("TO_DATE(@[n1st_nod_pln_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("TO_DATE(@[lst_nod_pln_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("@[bl_no]," ).append("\n"); 
		query.append("@[bkg_rcvde_term_cd]," ).append("\n"); 
		query.append("@[cgo_tp_cd]," ).append("\n"); 
		query.append("@[bkg_spe]," ).append("\n"); 
		query.append("@[spcl_cgo_cntr_tp_cd]," ).append("\n"); 
		query.append("@[cntr_seal_no]," ).append("\n"); 
		query.append("@[cntr_wgt]," ).append("\n"); 
		query.append("@[cmdt_name]," ).append("\n"); 
		query.append("@[trunkvvd]," ).append("\n"); 
		query.append("@[slan_cd]," ).append("\n"); 
		query.append("@[cmdt_cd]," ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("@[rail_cmb_thru_tp_cd]," ).append("\n"); 
		query.append("@[cop_no]," ).append("\n"); 
		query.append("@[cost_act_grp_seq]," ).append("\n"); 
		query.append("@[act_grp_cd]," ).append("\n"); 
		query.append("@[rout_org_nod_cd]," ).append("\n"); 
		query.append("@[rout_dest_nod_cd]," ).append("\n"); 
		query.append("@[rout_seq]," ).append("\n"); 
		query.append("@[bkg_cgo_tp_cd]," ).append("\n"); 
		query.append("@[rout_pln_cd]," ).append("\n"); 
		query.append("@[inlnd_rout_rmk]," ).append("\n"); 
		query.append("@[trsp_cost_dtl_mod_cd]," ).append("\n"); 
		query.append("@[cust_cnt_cd]," ).append("\n"); 
		query.append("@[cust_seq]," ).append("\n"); 
		query.append("@[inter_rmk]," ).append("\n"); 
		query.append("@[rout_dtl_seq]," ).append("\n"); 
		query.append("@[interchange1_loc]," ).append("\n"); 
		query.append("@[interchange2_loc]," ).append("\n"); 
		query.append("@[por_cd]," ).append("\n"); 
		query.append("@[del_cd]," ).append("\n"); 
		query.append("@[inv_bil_patt_div_flg]," ).append("\n"); 
		query.append("@[rtr_div_cnt]," ).append("\n"); 
		query.append("@[ref_no]," ).append("\n"); 
		query.append("@[lnk_org_nod_cd]," ).append("\n"); 
		query.append("@[lnk_dest_nod_cd]," ).append("\n"); 
		query.append("@[trsp_agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_agmt_seq]," ).append("\n"); 
		query.append("TO_DATE(@[rail_rcv_coff_fm_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("TO_DATE(@[rail_rcv_coff_to_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("TO_DATE(@[g_time], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("@[sCtrlUserId]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[sCtrlUserId]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}