/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOconfirmPsoPreAuditCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.03.25 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOconfirmPsoPreAuditCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOconfirmPsoPreAuditCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_tug_bot_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("madn_voy_suz_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_tr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brth_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_chg_aud_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("select_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_tug_bot_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_save_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdr_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_chg_aud_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_chg_aud_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("st_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOconfirmPsoPreAuditCSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_PORT_SO_CFM_INV K USING DUAL" ).append("\n"); 
		query.append("ON( K.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("AND K.SO_SEQ     = @[so_seq]" ).append("\n"); 
		query.append("AND K.SO_DTL_SEQ = @[so_dtl_seq]" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("    SET UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("		, PORT_CHG_AUD_CHK_CD = DECODE(@[s_save_tp_cd], 'C', @[select_flg], PORT_CHG_AUD_CHK_CD)" ).append("\n"); 
		query.append("		, PORT_CHG_AUD_RSLT_RMK = DECODE(@[s_save_tp_cd], 'S', @[port_chg_aud_rslt_rmk], PORT_CHG_AUD_RSLT_RMK)" ).append("\n"); 
		query.append("		, PORT_CHG_AUD_RSLT_USR_ID = DECODE(@[s_save_tp_cd], 'S', @[upd_usr_id], PORT_CHG_AUD_RSLT_USR_ID)" ).append("\n"); 
		query.append("        , ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("        , EXPN_AUD_RSLT_CD = DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_cd], EXPN_AUD_RSLT_CD)" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("    ,RHQ_CD						= @[rhq_cd]" ).append("\n"); 
		query.append("    ,INV_OFC_CD                 = @[inv_ofc_cd]" ).append("\n"); 
		query.append("    ,INV_CFM_DT                 = TO_DATE(@[inv_cfm_dt], 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("    ,AUTO_EXPN_AUD_STS_CD       = @[auto_expn_aud_sts_cd]" ).append("\n"); 
		query.append("    ,YD_CD                      = @[yd_cd]" ).append("\n"); 
		query.append("    ,VSL_CD                     = @[vsl_cd]" ).append("\n"); 
		query.append("    ,SKD_VOY_NO                 = @[skd_voy_no]" ).append("\n"); 
		query.append("    ,SKD_DIR_CD                 = @[skd_dir_cd]" ).append("\n"); 
		query.append("    ,INV_NO                     = @[inv_no]" ).append("\n"); 
		query.append("    ,ACCT_CD                    = @[acct_cd]" ).append("\n"); 
		query.append("    ,LGS_COST_CD                = @[lgs_cost_cd]" ).append("\n"); 
		query.append("    ,VNDR_SEQ                   = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("    ,CURR_CD                    = @[curr_cd]" ).append("\n"); 
		query.append("    ,CALC_AMT                   = TO_NUMBER(@[calc_amt])" ).append("\n"); 
		query.append("    ,ADJ_AMT                    = TO_NUMBER(@[adj_amt])" ).append("\n"); 
		query.append("    ,LOCL_AMT                   = TO_NUMBER(@[locl_amt])" ).append("\n"); 
		query.append("    ,INV_AMT                    = TO_NUMBER(@[inv_amt])" ).append("\n"); 
		query.append("    --,FLET_CTRT_TP_CD            = [flet_ctrt_tp_cd]" ).append("\n"); 
		query.append("    ,CNTR_VSL_CLSS_CAPA         = TO_NUMBER(@[cntr_vsl_clss_capa])" ).append("\n"); 
		query.append("    ,CSR_NO                     = @[csr_no]" ).append("\n"); 
		query.append("    ,EXPN_AUD_INV_STS_CD        = @[expn_aud_inv_sts_cd]" ).append("\n"); 
		query.append("    ,DP_IO_BND_CD               = @[dp_io_bnd_cd]" ).append("\n"); 
		query.append("    ,VPS_ETB_DT                 = TO_DATE(@[vps_etb_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    ,ISS_DT                     = TO_DATE(@[iss_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    ,INV_CRE_USR_ID             = @[inv_cre_usr_id]" ).append("\n"); 
		query.append("    ,DIFF_AMT                   = TO_NUMBER(@[diff_amt])" ).append("\n"); 
		query.append("    ,FOML_DESC                  = @[foml_desc]" ).append("\n"); 
		query.append("    ,XPR_DESC                   = @[xpr_desc]" ).append("\n"); 
		query.append("    ,PORT_CHG_AUD_DT            = TO_DATE(@[port_chg_aud_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    ,PORT_CHG_AUD_USR_ID        = @[port_chg_aud_usr_id]" ).append("\n"); 
		query.append("    ,DIFF_RMK                   = @[diff_rmk]" ).append("\n"); 
		query.append("    ,BRTH_HRS                   = TO_NUMBER(@[brth_hrs])" ).append("\n"); 
		query.append("    ,LST_PORT_CD                = @[lst_port_cd]" ).append("\n"); 
		query.append("    ,ST_PORT_CD                 = @[st_port_cd]" ).append("\n"); 
		query.append("    ,GRS_RGST_TONG_WGT          = TO_NUMBER(@[grs_rgst_tong_wgt])" ).append("\n"); 
		query.append("    ,NET_RGST_TONG_WGT          = TO_NUMBER(@[net_rgst_tong_wgt])" ).append("\n"); 
		query.append("    ,ARR_TUG_BOT_KNT            = TO_NUMBER(@[arr_tug_bot_knt])" ).append("\n"); 
		query.append("    ,DEP_TUG_BOT_KNT            = TO_NUMBER(@[dep_tug_bot_knt])" ).append("\n"); 
		query.append("    ,PAY_TERM_DYS               = TO_NUMBER(@[pay_term_dys])" ).append("\n"); 
		query.append("    ,PAY_DUE_DT                 = @[pay_due_dt]" ).append("\n"); 
		query.append("    ,AP_PAY_DT                  = TO_DATE(@[ap_pay_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    ,SUZ_GT_WGT                 = TO_NUMBER(@[suz_gt_wgt])" ).append("\n"); 
		query.append("    ,MADN_VOY_SUZ_NET_TONG_WGT  = TO_NUMBER(@[madn_voy_suz_net_tong_wgt])" ).append("\n"); 
		query.append("    ,SDR_XCH_RT                 = TO_NUMBER(@[sdr_xch_rt])" ).append("\n"); 
		query.append("    ,VSL_TR_NO                  = @[vsl_tr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT(" ).append("\n"); 
		query.append("     K.ISS_CTY_CD" ).append("\n"); 
		query.append("    ,K.SO_SEQ" ).append("\n"); 
		query.append("    ,K.SO_DTL_SEQ" ).append("\n"); 
		query.append("    ,K.PORT_CHG_AUD_CHK_CD" ).append("\n"); 
		query.append("	,K.PORT_CHG_AUD_RSLT_RMK" ).append("\n"); 
		query.append("	,K.PORT_CHG_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("	,K.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("	,K.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("    ,K.CRE_USR_ID" ).append("\n"); 
		query.append("    ,K.CRE_DT" ).append("\n"); 
		query.append("    ,K.UPD_USR_ID" ).append("\n"); 
		query.append("    ,K.UPD_DT" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("    ,RHQ_CD" ).append("\n"); 
		query.append("    ,INV_OFC_CD" ).append("\n"); 
		query.append("    ,INV_CFM_DT" ).append("\n"); 
		query.append("    ,AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("    ,YD_CD" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,INV_NO" ).append("\n"); 
		query.append("    ,ACCT_CD" ).append("\n"); 
		query.append("    ,LGS_COST_CD" ).append("\n"); 
		query.append("    ,VNDR_SEQ" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,CALC_AMT" ).append("\n"); 
		query.append("    ,ADJ_AMT" ).append("\n"); 
		query.append("    ,LOCL_AMT" ).append("\n"); 
		query.append("    ,INV_AMT" ).append("\n"); 
		query.append("    --,FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("    ,CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,CSR_NO" ).append("\n"); 
		query.append("    ,EXPN_AUD_INV_STS_CD" ).append("\n"); 
		query.append("    ,DP_IO_BND_CD" ).append("\n"); 
		query.append("    ,VPS_ETB_DT" ).append("\n"); 
		query.append("    ,ISS_DT" ).append("\n"); 
		query.append("    ,INV_CRE_USR_ID" ).append("\n"); 
		query.append("    ,DIFF_AMT" ).append("\n"); 
		query.append("    ,FOML_DESC" ).append("\n"); 
		query.append("    ,XPR_DESC" ).append("\n"); 
		query.append("    ,PORT_CHG_AUD_DT" ).append("\n"); 
		query.append("    ,PORT_CHG_AUD_USR_ID" ).append("\n"); 
		query.append("    ,DIFF_RMK" ).append("\n"); 
		query.append("    ,BRTH_HRS" ).append("\n"); 
		query.append("    ,LST_PORT_CD" ).append("\n"); 
		query.append("    ,ST_PORT_CD" ).append("\n"); 
		query.append("    ,GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("    ,DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("    ,PAY_TERM_DYS" ).append("\n"); 
		query.append("    ,PAY_DUE_DT" ).append("\n"); 
		query.append("    ,AP_PAY_DT" ).append("\n"); 
		query.append("    ,SUZ_GT_WGT" ).append("\n"); 
		query.append("    ,MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("    ,SDR_XCH_RT" ).append("\n"); 
		query.append("    ,VSL_TR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    values" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      @[iss_cty_cd]" ).append("\n"); 
		query.append("    , TO_NUMBER(@[so_seq])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[so_dtl_seq])" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'C', @[select_flg])" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'S', @[port_chg_aud_rslt_rmk])" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'S', @[upd_usr_id])" ).append("\n"); 
		query.append("	, @[atch_file_lnk_id]" ).append("\n"); 
		query.append("	, DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_cd])" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("    , @[rhq_cd]" ).append("\n"); 
		query.append("    , @[inv_ofc_cd]" ).append("\n"); 
		query.append("    , TO_DATE(@[inv_cfm_dt], 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("    , @[auto_expn_aud_sts_cd]" ).append("\n"); 
		query.append("    , @[yd_cd]" ).append("\n"); 
		query.append("    , @[vsl_cd]" ).append("\n"); 
		query.append("    , @[skd_voy_no]" ).append("\n"); 
		query.append("    , @[skd_dir_cd]" ).append("\n"); 
		query.append("    , @[inv_no]" ).append("\n"); 
		query.append("    , @[acct_cd]" ).append("\n"); 
		query.append("    , @[lgs_cost_cd]" ).append("\n"); 
		query.append("    , TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("    , @[curr_cd]" ).append("\n"); 
		query.append("    , TO_NUMBER(@[calc_amt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[adj_amt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[locl_amt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[inv_amt])" ).append("\n"); 
		query.append("    -- [flet_ctrt_tp_cd]" ).append("\n"); 
		query.append("    , TO_NUMBER(@[cntr_vsl_clss_capa])" ).append("\n"); 
		query.append("    , @[csr_no]" ).append("\n"); 
		query.append("    , @[expn_aud_inv_sts_cd]" ).append("\n"); 
		query.append("    , @[dp_io_bnd_cd]" ).append("\n"); 
		query.append("    , TO_DATE(@[vps_etb_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    , TO_DATE(@[iss_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    , @[inv_cre_usr_id]" ).append("\n"); 
		query.append("    , TO_NUMBER(@[diff_amt])" ).append("\n"); 
		query.append("    , @[foml_desc]" ).append("\n"); 
		query.append("    , @[xpr_desc]" ).append("\n"); 
		query.append("    , TO_DATE(@[port_chg_aud_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    , @[port_chg_aud_usr_id]" ).append("\n"); 
		query.append("    , @[diff_rmk]" ).append("\n"); 
		query.append("    , TO_NUMBER(@[brth_hrs])" ).append("\n"); 
		query.append("    , @[lst_port_cd]" ).append("\n"); 
		query.append("    , @[st_port_cd]" ).append("\n"); 
		query.append("    , TO_NUMBER(@[grs_rgst_tong_wgt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[net_rgst_tong_wgt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[arr_tug_bot_knt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[dep_tug_bot_knt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[pay_term_dys])" ).append("\n"); 
		query.append("    , @[pay_due_dt]" ).append("\n"); 
		query.append("    , TO_DATE(@[ap_pay_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    , TO_NUMBER(@[suz_gt_wgt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[madn_voy_suz_net_tong_wgt])" ).append("\n"); 
		query.append("    , TO_NUMBER(@[sdr_xch_rt])" ).append("\n"); 
		query.append("    , @[vsl_tr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}