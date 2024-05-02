/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOPriTriNoteConvCpyVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOPriTriNoteConvCpyVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 복사
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOPriTriNoteConvCpyVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_max_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_esvc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ts_port_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_min_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dir_call_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ts_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rule_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_rule_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rule_appl_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_appl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOPriTriNoteConvCpyVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRI_NOTE_CONV_CPY" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	  USR_ID" ).append("\n"); 
		query.append("	, NOTE_CONV_SEQ" ).append("\n"); 
		query.append("	, NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("	, TRF_PFX_CD" ).append("\n"); 
		query.append("	, TRF_NO" ).append("\n"); 
		query.append("	, TRI_PROP_NO" ).append("\n"); 
		query.append("	, AMDT_SEQ" ).append("\n"); 
		query.append("	, CHG_RULE_TP_CD" ).append("\n"); 
		query.append("	, NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("	, NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("	, EFF_DT" ).append("\n"); 
		query.append("	, EXP_DT" ).append("\n"); 
		query.append("	, RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("	, RT_APPL_TP_CD" ).append("\n"); 
		query.append("	, RT_OP_CD" ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, FRT_RT_AMT" ).append("\n"); 
		query.append("	, PAY_TERM_CD" ).append("\n"); 
		query.append("	, BKG_RAT_UT_CD" ).append("\n"); 
		query.append("	, BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	, BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("	, BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("	, BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("	, BKG_POR_TP_CD" ).append("\n"); 
		query.append("	, BKG_POR_DEF_CD" ).append("\n"); 
		query.append("	, BKG_POL_TP_CD" ).append("\n"); 
		query.append("	, BKG_POL_DEF_CD" ).append("\n"); 
		query.append("	, BKG_POD_TP_CD" ).append("\n"); 
		query.append("	, BKG_POD_DEF_CD" ).append("\n"); 
		query.append("	, BKG_DEL_TP_CD" ).append("\n"); 
		query.append("	, BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("	, BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	, BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	, BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("	, BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("	, BKG_SOC_FLG" ).append("\n"); 
		query.append("	, BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("	, BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("	, BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("	, BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("	, CONV_RAT_UT_CD" ).append("\n"); 
		query.append("	, CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("    , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	  @[cre_usr_id]" ).append("\n"); 
		query.append("	, @[note_conv_seq]" ).append("\n"); 
		query.append("	, @[note_conv_tp_cd]" ).append("\n"); 
		query.append("	, @[trf_pfx_cd]" ).append("\n"); 
		query.append("	, @[trf_no]" ).append("\n"); 
		query.append("	, @[tri_prop_no]" ).append("\n"); 
		query.append("	, @[amdt_seq]" ).append("\n"); 
		query.append("	, @[chg_rule_tp_cd]" ).append("\n"); 
		query.append("	, @[note_conv_chg_cd]" ).append("\n"); 
		query.append("	, @[note_conv_rule_cd]" ).append("\n"); 
		query.append("	, TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	, TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	, @[rule_appl_chg_tp_cd]" ).append("\n"); 
		query.append("	, @[rt_appl_tp_cd]" ).append("\n"); 
		query.append("	, @[rt_op_cd]" ).append("\n"); 
		query.append("	, @[curr_cd]" ).append("\n"); 
		query.append("	, @[frt_rt_amt]" ).append("\n"); 
		query.append("	, @[pay_term_cd]" ).append("\n"); 
		query.append("	, @[bkg_rat_ut_cd]" ).append("\n"); 
		query.append("	, @[bkg_prc_cgo_tp_cd]" ).append("\n"); 
		query.append("	, @[bkg_imdg_clss_cd]" ).append("\n"); 
		query.append("	, @[bkg_cmdt_tp_cd]" ).append("\n"); 
		query.append("	, @[bkg_cmdt_def_cd]" ).append("\n"); 
		query.append("	, @[bkg_usa_svc_mod_cd]" ).append("\n"); 
		query.append("	, @[bkg_por_tp_cd]" ).append("\n"); 
		query.append("	, DECODE(@[bkg_por_tp_cd], 'T', @[bkg_por_cnt_cd]||@[bkg_por_def_cd], @[bkg_por_def_cd])" ).append("\n"); 
		query.append("	, @[bkg_pol_tp_cd]" ).append("\n"); 
		query.append("	, DECODE(@[bkg_pol_tp_cd], 'T', @[bkg_pol_cnt_cd]||@[bkg_pol_def_cd], @[bkg_pol_def_cd])" ).append("\n"); 
		query.append("	, @[bkg_pod_tp_cd]" ).append("\n"); 
		query.append("	, DECODE(@[bkg_pod_tp_cd], 'T', @[bkg_pod_cnt_cd]||@[bkg_pod_def_cd], @[bkg_pod_def_cd])" ).append("\n"); 
		query.append("	, @[bkg_del_tp_cd]" ).append("\n"); 
		query.append("	, DECODE(@[bkg_del_tp_cd], 'T', @[bkg_del_cnt_cd]||@[bkg_del_def_cd], @[bkg_del_def_cd])" ).append("\n"); 
		query.append("	, @[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("	, @[bkg_de_term_cd]" ).append("\n"); 
		query.append("	, @[bkg_min_cgo_wgt]" ).append("\n"); 
		query.append("	, @[bkg_max_cgo_wgt]" ).append("\n"); 
		query.append("	, @[bkg_soc_flg]" ).append("\n"); 
		query.append("	, @[bkg_ts_port_tp_cd]" ).append("\n"); 
		query.append("	, @[bkg_ts_port_def_cd]" ).append("\n"); 
		query.append("	, @[bkg_dir_call_flg]" ).append("\n"); 
		query.append("	, @[bkg_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("	, @[conv_rat_ut_cd]" ).append("\n"); 
		query.append("	, @[conv_prc_cgo_tp_cd]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, sysdate" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, sysdate" ).append("\n"); 
		query.append("    , @[bkg_esvc_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}