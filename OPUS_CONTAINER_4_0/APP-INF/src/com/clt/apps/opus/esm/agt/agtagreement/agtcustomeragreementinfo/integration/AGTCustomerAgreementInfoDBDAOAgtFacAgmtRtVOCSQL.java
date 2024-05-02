/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.09.07 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * agt_fac_agmt_rt 테이블에 저장
	  * </pre>
	  */
	public AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_chg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_feu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_tp_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_tp_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_sgl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_feu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_rt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_teu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_bx_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_rt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rf_feu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rqst_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_fac_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_proc_rslt_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rf_teu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_teu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_apro_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_net_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_dbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO AGT_FAC_AGMT_RT (" ).append("\n"); 
		query.append("FAC_OFC_CD," ).append("\n"); 
		query.append("FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("FRT_FWRD_CUST_SEQ," ).append("\n"); 
		query.append("FAC_RT_SEQ," ).append("\n"); 
		query.append("SHPR_CNT_CD," ).append("\n"); 
		query.append("SHPR_CUST_SEQ," ).append("\n"); 
		query.append("BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("BKG_DE_TERM_CD," ).append("\n"); 
		query.append("POR_GRP_TP_CD," ).append("\n"); 
		query.append("POR_ROUT_CD," ).append("\n"); 
		query.append("POL_GRP_TP_CD," ).append("\n"); 
		query.append("POL_ROUT_CD," ).append("\n"); 
		query.append("POD_GRP_TP_CD," ).append("\n"); 
		query.append("POD_ROUT_CD," ).append("\n"); 
		query.append("DEL_GRP_TP_CD," ).append("\n"); 
		query.append("DEL_ROUT_CD," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("FM_EFF_DT," ).append("\n"); 
		query.append("TO_EFF_DT," ).append("\n"); 
		query.append("SC_NO," ).append("\n"); 
		query.append("RFA_NO," ).append("\n"); 
		query.append("CMDT_TP_CD," ).append("\n"); 
		query.append("CMDT_CD," ).append("\n"); 
		query.append("FAC_DIV_CD," ).append("\n"); 
		query.append("FAC_TP_CD," ).append("\n"); 
		query.append("BKG_FAC_RT," ).append("\n"); 
		query.append("FAC_CHG_CTNT," ).append("\n"); 
		query.append("FAC_BX_RT," ).append("\n"); 
		query.append("FAC_TEU_RT," ).append("\n"); 
		query.append("FAC_FEU_RT," ).append("\n"); 
		query.append("FAC_RF_TEU_RT," ).append("\n"); 
		query.append("FAC_RF_FEU_RT," ).append("\n"); 
		query.append("FAC_SGL_FLG," ).append("\n"); 
		query.append("COMM_PROC_STS_CD," ).append("\n"); 
		query.append("COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("FAC_RQST_USR_ID," ).append("\n"); 
		query.append("FAC_RQST_DT," ).append("\n"); 
		query.append("FAC_APRO_USR_ID," ).append("\n"); 
		query.append("FAC_APRO_DT," ).append("\n"); 
		query.append("FAC_RQST_USR_EML," ).append("\n"); 
		query.append("FAC_APRO_USR_EML," ).append("\n"); 
		query.append("GRS_NET_DIV_CD," ).append("\n"); 
		query.append("FAC_SPCL_TEU_RT," ).append("\n"); 
		query.append("FAC_SPCL_FEU_RT," ).append("\n"); 
		query.append("FAC_DBL_FLG," ).append("\n"); 
		query.append("FAC_SPCL_CNTR_TP_CTNT1," ).append("\n"); 
		query.append("FAC_SPCL_CNTR_RT1," ).append("\n"); 
		query.append("FAC_SPCL_CNTR_TP_CTNT2," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("FAC_SPCL_CNTR_RT2," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[fac_ofc_cd]," ).append("\n"); 
		query.append("@[frt_fwrd_cnt_cd]," ).append("\n"); 
		query.append("@[frt_fwrd_cust_seq]," ).append("\n"); 
		query.append("@[fac_rt_seq]," ).append("\n"); 
		query.append("@[shpr_cnt_cd]," ).append("\n"); 
		query.append("@[shpr_cust_seq]," ).append("\n"); 
		query.append("@[bkg_rcv_term_cd]," ).append("\n"); 
		query.append("@[bkg_de_term_cd]," ).append("\n"); 
		query.append("@[por_grp_tp_cd]," ).append("\n"); 
		query.append("@[por_rout_cd]," ).append("\n"); 
		query.append("@[pol_grp_tp_cd]," ).append("\n"); 
		query.append("@[pol_rout_cd]," ).append("\n"); 
		query.append("@[pod_grp_tp_cd]," ).append("\n"); 
		query.append("@[pod_rout_cd]," ).append("\n"); 
		query.append("@[del_grp_tp_cd]," ).append("\n"); 
		query.append("@[del_rout_cd]," ).append("\n"); 
		query.append("@[svc_scp_cd]," ).append("\n"); 
		query.append("@[fm_eff_dt]," ).append("\n"); 
		query.append("@[to_eff_dt]," ).append("\n"); 
		query.append("@[sc_no]," ).append("\n"); 
		query.append("@[rfa_no]," ).append("\n"); 
		query.append("@[cmdt_tp_cd]," ).append("\n"); 
		query.append("@[cmdt_cd]," ).append("\n"); 
		query.append("@[fac_div_cd]," ).append("\n"); 
		query.append("@[fac_tp_cd]," ).append("\n"); 
		query.append("@[bkg_fac_rt]," ).append("\n"); 
		query.append("@[fac_chg_ctnt]," ).append("\n"); 
		query.append("@[fac_bx_rt]," ).append("\n"); 
		query.append("@[fac_teu_rt]," ).append("\n"); 
		query.append("@[fac_feu_rt]," ).append("\n"); 
		query.append("@[fac_rf_teu_rt]," ).append("\n"); 
		query.append("@[fac_rf_feu_rt]," ).append("\n"); 
		query.append("@[fac_sgl_flg]," ).append("\n"); 
		query.append("@[comm_proc_sts_cd]," ).append("\n"); 
		query.append("@[comm_proc_rslt_rsn]," ).append("\n"); 
		query.append("@[fac_rqst_usr_id]," ).append("\n"); 
		query.append("TO_DATE(@[fac_rqst_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("@[fac_apro_usr_id]," ).append("\n"); 
		query.append("TO_DATE(@[fac_apro_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("@[fac_rqst_usr_eml]," ).append("\n"); 
		query.append("@[fac_apro_usr_eml]," ).append("\n"); 
		query.append("@[grs_net_div_cd]," ).append("\n"); 
		query.append("@[fac_spcl_teu_rt]," ).append("\n"); 
		query.append("@[fac_spcl_feu_rt]," ).append("\n"); 
		query.append("@[fac_dbl_flg]," ).append("\n"); 
		query.append("@[fac_spcl_cntr_tp_ctnt1]," ).append("\n"); 
		query.append("@[fac_spcl_cntr_rt1]," ).append("\n"); 
		query.append("@[fac_spcl_cntr_tp_ctnt2]," ).append("\n"); 
		query.append("@[curr_cd]," ).append("\n"); 
		query.append("@[fac_spcl_cntr_rt2]," ).append("\n"); 
		query.append("NVL(@[cre_usr_id],'NONE')," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("NVL(@[upd_usr_id],'NONE')," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}