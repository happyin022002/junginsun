/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOModifyCHSAgreementMainDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOModifyCHSAgreementMainDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.ModifyCHSAgreementMainData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOModifyCHSAgreementMainDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_hndl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_lmt_prd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpp_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_ver_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
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
		params.put("agmt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lmsm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_lmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_lmt_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_hndl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_lmt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon_dpc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_dpc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_rntl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_dpc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpp_cvrg_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOModifyCHSAgreementMainDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_AGREEMENT" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    EQ_KND_CD 			= @[eq_knd_cd], " ).append("\n"); 
		query.append("    LST_VER_FLG			= @[lst_ver_flg], " ).append("\n"); 
		query.append("    AGMT_ISS_OFC_CD		= @[agmt_iss_ofc_cd], " ).append("\n"); 
		query.append("    AGMT_REF_NO			= @[agmt_ref_no], " ).append("\n"); 
		query.append("    CURR_CD				= @[curr_cd], " ).append("\n"); 
		query.append("    EFF_DT				= TO_DATE(@[eff_dt],'YYYYMMDD'), " ).append("\n"); 
		query.append("    EXP_DT				= TO_DATE(@[exp_dt],'YYYYMMDD'), " ).append("\n"); 
		query.append("    VNDR_SEQ			= @[vndr_seq], " ).append("\n"); 
		query.append("    PAY_TERM_DYS		= @[pay_term_dys]," ).append("\n"); 
		query.append("    AGMT_LSTM_CD		= @[agmt_lstm_cd]," ).append("\n"); 
		query.append("    CHSS_POOL_CD		= @[chss_pool_cd]," ).append("\n"); 
		query.append("    EQ_RNTL_TP_CD		= @[eq_rntl_tp_cd]," ).append("\n"); 
		query.append("    DPP_TP_CD			= @[dpp_tp_cd]," ).append("\n"); 
		query.append("    DPP_RT_AMT			= @[dpp_rt_amt]," ).append("\n"); 
		query.append("    DPP_CVRG_AMT		= @[dpp_cvrg_amt]," ).append("\n"); 
		query.append("    LMSM_AMT			= @[lmsm_amt]," ).append("\n"); 
		query.append("    ONH_HNDL_RT_AMT		= @[onh_hndl_rt_amt]," ).append("\n"); 
		query.append("    OFFH_HNDL_RT_AMT	= @[offh_hndl_rt_amt]," ).append("\n"); 
		query.append("    DRP_OFF_LMT_QTY		= @[drp_off_lmt_qty]," ).append("\n"); 
		query.append("    DRP_OFF_LMT_TP_CD	= @[drp_off_lmt_tp_cd]," ).append("\n"); 
		query.append("    DRP_OFF_LMT_RTO		= @[drp_off_lmt_rto]," ).append("\n"); 
		query.append("    DRP_OFF_LMT_PRD_CD	= @[drp_off_lmt_prd_cd]," ).append("\n"); 
		query.append("    MON_DPC_RT_AMT		= @[mon_dpc_rt_amt]," ).append("\n"); 
		query.append("    MAX_DPC_RT_AMT		= @[max_dpc_rt_amt]," ).append("\n"); 
		query.append("    INIT_DPC_RT_AMT		= @[init_dpc_rt_amt]," ).append("\n"); 
		query.append("    DIFF_RMK			= @[diff_rmk]," ).append("\n"); 
		query.append("	AGMT_DT				= TO_DATE(@[agmt_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("	AGMT_EFF_DT			= TO_DATE(@[agmt_eff_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("	AGMT_EXP_DT			= TO_DATE(@[agmt_exp_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("    UPD_USR_ID			= @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT				= SYSDATE," ).append("\n"); 
		query.append("    AGMT_CTRT_NO        = @[agmt_ctrt_no]," ).append("\n"); 
		query.append("    OLD_AGMT_NO        = @[old_agmt_no]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("    AND AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 

	}
}