/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementDBDAOModifyFACAgreementListUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.11
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.11 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACommAgreementDBDAOModifyFACAgreementListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ACM_FAC_AGMT 테이블을 업데이트 한다.
	  * </pre>
	  */
	public FACommAgreementDBDAOModifyFACAgreementListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_bx_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_chg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_fac_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_tp_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_tp_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fac_spcl_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rf_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rf_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_sgl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("all_in_rt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fac_spcl_cntr_rt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_rt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_dbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration").append("\n");
		query.append("FileName : FACommAgreementDBDAOModifyFACAgreementListUSQL").append("\n");
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
		query.append("UPDATE ACM_FAC_AGMT" ).append("\n");
		query.append("SET    SHPR_CNT_CD = @[shpr_cnt_cd]," ).append("\n");
		query.append("       SHPR_SEQ = @[shpr_seq]," ).append("\n");
		query.append("       POR_GRP_TP_CD = @[por_grp_tp_cd]," ).append("\n");
		query.append("       POR_ROUT_CD = @[por_rout_cd]," ).append("\n");
		query.append("       POL_GRP_TP_CD = @[pol_grp_tp_cd]," ).append("\n");
		query.append("       POL_ROUT_CD = @[pol_rout_cd]," ).append("\n");
		query.append("       POD_GRP_TP_CD = @[pod_grp_tp_cd]," ).append("\n");
		query.append("       POD_ROUT_CD = @[pod_rout_cd]," ).append("\n");
		query.append("       DEL_GRP_TP_CD = @[del_grp_tp_cd]," ).append("\n");
		query.append("       DEL_ROUT_CD = @[del_rout_cd]," ).append("\n");
		query.append("       BKG_RCV_TERM_CD = @[bkg_rcv_term_cd]," ).append("\n");
		query.append("       BKG_DE_TERM_CD = @[bkg_de_term_cd]," ).append("\n");
		query.append("       FAC_SGL_FLG = @[fac_sgl_flg]," ).append("\n");
		query.append("       FAC_DBL_FLG = @[fac_dbl_flg]," ).append("\n");
		query.append("       ALL_IN_RT_CD = @[all_in_rt_cd]," ).append("\n");
		query.append("       SVC_SCP_CD = @[svc_scp_cd]," ).append("\n");
		query.append("       FM_EFF_DT = @[fm_eff_dt]," ).append("\n");
		query.append("       TO_EFF_DT = @[to_eff_dt]," ).append("\n");
		query.append("       SC_NO = @[sc_no]," ).append("\n");
		query.append("       RFA_NO = @[rfa_no]," ).append("\n");
		query.append("       CMDT_TP_CD = @[cmdt_tp_cd]," ).append("\n");
		query.append("       CMDT_CD = @[cmdt_cd]," ).append("\n");
		query.append("       FAC_DIV_CD = @[fac_div_cd]," ).append("\n");
		query.append("       FAC_STS_CD = @[fac_sts_cd]," ).append("\n");
		query.append(" #if (${fac_div_cd} != '' && ${fac_div_cd} != 'BL')" ).append("\n");
		query.append("       FAC_BKG_RT = @[bkg_fac_rt]," ).append("\n");
		query.append(" #end" ).append("\n");
		query.append("       FAC_SPCL_CNTR_TP_CTNT1 = @[fac_spcl_cntr_tp_ctnt1]," ).append("\n");
		query.append("       FAC_SPCL_CNTR_RT1 = @[fac_spcl_cntr_rt1]," ).append("\n");
		query.append("       FAC_SPCL_CNTR_TP_CTNT2 = @[fac_spcl_cntr_tp_ctnt2]," ).append("\n");
		query.append("       FAC_SPCL_CNTR_RT2 = @[fac_spcl_cntr_rt2]," ).append("\n");
		query.append("       FAC_BX_AMT = @[fac_bx_amt]," ).append("\n");
		query.append("       FAC_TEU_AMT = @[fac_teu_amt]," ).append("\n");
		query.append("       FAC_FEU_AMT = @[fac_feu_amt]," ).append("\n");
		query.append("       FAC_RF_TEU_AMT = @[fac_rf_teu_amt]," ).append("\n");
		query.append("       FAC_RF_FEU_AMT = @[fac_rf_feu_amt]," ).append("\n");
		query.append("       FAC_SPCL_TEU_AMT = @[fac_spcl_teu_amt]," ).append("\n");
		query.append("       FAC_SPCL_FEU_AMT = @[fac_spcl_feu_amt]," ).append("\n");
		query.append("       CURR_CD = @[curr_cd]," ).append("\n");
		query.append("       FAC_CHG_CTNT = @[fac_chg_ctnt]," ).append("\n");
		query.append("       FAC_RMK = @[fac_rmk]," ).append("\n");
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n");
		query.append("       UPD_DT = SYSDATE" ).append("\n");
		query.append("WHERE  FAC_OFC_CD = @[fac_ofc_cd]" ).append("\n");
		query.append("AND    FF_CNT_CD = @[ff_cnt_cd]" ).append("\n");
		query.append("AND    FF_SEQ = @[ff_seq]" ).append("\n");
		query.append("AND    FAC_AGMT_SEQ = @[fac_agmt_seq]" ).append("\n");

	}
}