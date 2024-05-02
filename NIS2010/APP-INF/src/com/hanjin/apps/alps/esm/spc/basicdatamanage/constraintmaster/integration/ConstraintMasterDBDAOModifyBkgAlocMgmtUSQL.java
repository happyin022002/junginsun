/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ConstraintMasterDBDAOModifyBkgAlocMgmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOModifyBkgAlocMgmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * spc_bkg_aloc_mgmt 수정
	  * </pre>
	  */
	public ConstraintMasterDBDAOModifyBkgAlocMgmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_aply_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_aply_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_per_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cntr_qty_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_svc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_aloc_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnk_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oft_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_asgn_wgt_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_wgt_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_asgn_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_aloc_lod_qty_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aloc_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpb_per_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_bkg_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmpb_ony_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_oft_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_lod_qty_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOModifyBkgAlocMgmtUSQL").append("\n"); 
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
		query.append("UPDATE SPC_BKG_ALOC_MGMT" ).append("\n"); 
		query.append("   SET BKG_ALOC_TP_CD   =@[bkg_aloc_tp_cd]" ).append("\n"); 
		query.append("	 , TRNK_SLAN_CD     =@[trnk_slan_cd]" ).append("\n"); 
		query.append("	 , TRNK_DIR_CD      =@[trnk_dir_cd]" ).append("\n"); 
		query.append("	 , VSL_CD			=SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	 , SKD_VOY_NO		=SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("     , SKD_DIR_CD		=SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("	 , SLS_RHQ_CD		=@[sls_rhq_cd]" ).append("\n"); 
		query.append("     , OB_SLS_OFC_CD	=@[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("	 , POR_NOD_CD       =@[por_nod_cd]" ).append("\n"); 
		query.append("	 , BKG_POR_SCC_CD   =@[bkg_por_scc_cd]" ).append("\n"); 
		query.append("	 , POL_NOD_CD       =@[pol_nod_cd]" ).append("\n"); 
		query.append("	 , N1ST_TS_SLAN_CD  =@[n1st_ts_slan_cd]" ).append("\n"); 
		query.append("     , N1ST_TS_DIR_CD   =@[n1st_ts_dir_cd]" ).append("\n"); 
		query.append("	 , POD_NOD_CD       =@[pod_nod_cd]" ).append("\n"); 
		query.append("	 , DEL_NOD_CD       =@[del_nod_cd]" ).append("\n"); 
		query.append("	 , BKG_DEL_SCC_CD   =@[bkg_del_scc_cd]" ).append("\n"); 
		query.append("	 , SC_NO            =@[sc_no]" ).append("\n"); 
		query.append("     , RFA_NO           =@[rfa_no]" ).append("\n"); 
		query.append("	 , CTRT_CUST_CNT_CD =SUBSTR(@[ctrt_cust_cnt_cd],1,2)" ).append("\n"); 
		query.append("	 , CTRT_CUST_SEQ    =TO_NUMBER(SUBSTR(@[ctrt_cust_cnt_cd],3))" ).append("\n"); 
		query.append("	 , CUST_CNT_CD      =SUBSTR(@[cust_cnt_cd],1,2)" ).append("\n"); 
		query.append("	 , CUST_SEQ         =TO_NUMBER(SUBSTR(@[cust_cnt_cd],3))" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("     , SCG_GRP_CMDT_SEQ =@[scg_grp_cmdt_seq]" ).append("\n"); 
		query.append("	 , ALOC_LOD_QTY     =@[aloc_lod_qty]" ).append("\n"); 
		query.append("	 , ALOC_LOD_QTY_RTO =@[aloc_lod_qty_rto] " ).append("\n"); 
		query.append(" 	 , ASGN_TTL_WGT     =@[asgn_ttl_wgt]" ).append("\n"); 
		query.append("	 , ASGN_WGT_RTO     =@[asgn_wgt_rto]" ).append("\n"); 
		query.append("	 , ALOC_SVC_CD      =@[aloc_svc_cd] " ).append("\n"); 
		query.append("	 , BKG_ALOC_RMK     =@[bkg_aloc_rmk]" ).append("\n"); 
		query.append("	 , UPD_USR_ID       =@[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT           =SYSDATE" ).append("\n"); 
		query.append("	 , CMPB_AMT			=@[cmpb_amt]" ).append("\n"); 
		query.append("	 , BKG_CTRL_TP_CD	=@[bkg_ctrl_tp_cd]	" ).append("\n"); 
		query.append("	 , DCGO_FLG			=@[dcgo_flg]" ).append("\n"); 
		query.append("	 , RD_CGO_FLG		=@[rd_cgo_flg]" ).append("\n"); 
		query.append("     , ALOC_APLY_FM_DT	= REPLACE(@[aloc_aply_fm_dt], '-', '')" ).append("\n"); 
		query.append("     , ALOC_APLY_TO_DT  = REPLACE(@[aloc_aply_to_dt], '-', '')" ).append("\n"); 
		query.append("	 , SUB_TRD_CD		=@[sub_trd_cd]" ).append("\n"); 
		query.append("	 , ALOC_USE_FLG 	=@[aloc_use_flg]" ).append("\n"); 
		query.append("	 , USA_BKG_MOD_CD	=@[usa_bkg_mod_cd]" ).append("\n"); 
		query.append("	 , HUL_BND_CD   	=@[hul_bnd_cd]" ).append("\n"); 
		query.append("	 , OFT_CHG_AMT   	=@[oft_chg_amt]" ).append("\n"); 
		query.append("     , APLY_FM_YRWK	    = REPLACE(@[aply_fm_yrwk], '-', '')" ).append("\n"); 
		query.append("     , APLY_TO_YRWK     = REPLACE(@[aply_to_yrwk], '-', '')" ).append("\n"); 
		query.append("     , RAPLY_CFM_FLG    = CASE WHEN (NVL(TO_NUMBER(@[old_oft_chg_amt]), 0) <> NVL(TO_NUMBER(@[oft_chg_amt]), 0)) " ).append("\n"); 
		query.append("									OR (NVL(TO_NUMBER(@[old_cmpb_amt]), 0) <> NVL(TO_NUMBER(@[cmpb_amt]), 0)) " ).append("\n"); 
		query.append("									OR (NVL(TO_NUMBER(@[old_aloc_lod_qty]), 0) <> NVL(TO_NUMBER(@[aloc_lod_qty]), 0)) " ).append("\n"); 
		query.append("									OR (NVL(TO_NUMBER(@[old_aloc_lod_qty_rto]), 0) <> NVL(TO_NUMBER(@[aloc_lod_qty_rto]), 0))" ).append("\n"); 
		query.append("									OR (NVL(TO_NUMBER(@[old_asgn_ttl_wgt]), 0) <> NVL(TO_NUMBER(@[asgn_ttl_wgt]), 0)) " ).append("\n"); 
		query.append("									OR (NVL(TO_NUMBER(@[old_asgn_wgt_rto]), 0) <> NVL(TO_NUMBER(@[asgn_wgt_rto]), 0)) " ).append("\n"); 
		query.append("						   THEN '1' ELSE '0' END" ).append("\n"); 
		query.append("     , CMPB_ONY_FLG     = NVL(@[cmpb_ony_flg], 'N')" ).append("\n"); 
		query.append("	 , RVIS_CNTR_CUST_TP_CD = @[acct_tp]" ).append("\n"); 
		query.append("	 , OP_CNTR_QTY = @[op_cntr_qty]" ).append("\n"); 
		query.append("	 , OP_CNTR_QTY_RTO = @[op_cntr_qty_rto]" ).append("\n"); 
		query.append("	 , CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 
		query.append("	 , CMPB_PER_TON_AMT = @[cmpb_per_wgt]" ).append("\n"); 
		query.append("	 , TON_PER_TEU_WGT = @[wgt_per_teu]" ).append("\n"); 
		query.append("	 , RFA_CTRT_TP_CD = @[rfa_ctrt_tp_cd]	 " ).append("\n"); 
		query.append(" WHERE BKG_ALOC_SEQ =@[bkg_aloc_seq]" ).append("\n"); 

	}
}