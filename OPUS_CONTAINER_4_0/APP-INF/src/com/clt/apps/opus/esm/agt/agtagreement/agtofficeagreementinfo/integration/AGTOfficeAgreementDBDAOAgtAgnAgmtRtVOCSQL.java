/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.18 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * agt_agn_agmt_rt 테이블에 저장
	  * </pre>
	  */
	public AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.DECIMAL + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_ofc_inp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdrg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdrg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fx_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_comm_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ddct_inp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_n3rd_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_clt_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_net_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ppd_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_inp_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ofc_inp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO AGT_AGN_AGMT_RT(" ).append("\n"); 
		query.append("AGMT_OFC_CD," ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("AGN_AGMT_SEQ," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("AGN_AGMT_VER_SEQ," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AGN_SEQ," ).append("\n"); 
		query.append("CNTR_INP_TERM_CD," ).append("\n"); 
		query.append("FULL_MTY_CD," ).append("\n"); 
		query.append("COMM_PAY_TERM_CD," ).append("\n"); 
		query.append("GRS_NET_DIV_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("CHG_DDCT_INP_CD," ).append("\n"); 
		query.append("HLG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("HLG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("CUST_INP_TERM_CD," ).append("\n"); 
		query.append("SC_INP_TERM_CD," ).append("\n"); 
		query.append("RFA_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("SLS_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POR_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POL_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_DEL_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_PPD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_CLT_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_N3RD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_SOC_FLG," ).append("\n"); 
		query.append("BKG_DBL_FLG," ).append("\n"); 
		query.append("SC_OFC_INP_CD," ).append("\n"); 
		query.append("RFA_OFC_INP_CD," ).append("\n"); 
		query.append("LANE_INP_TERM_CD," ).append("\n"); 
		query.append("VSL_INP_TERM_CD," ).append("\n"); 
		query.append("LOCL_CHG_INP_TERM_CD," ).append("\n"); 
		query.append("COMM_STND_COST_CD," ).append("\n"); 
		query.append("FX_COMM_AMT," ).append("\n"); 
		query.append("BKG_COMM_RT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[agmt_ofc_cd]," ).append("\n"); 
		query.append("@[agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("@[agn_agmt_seq]," ).append("\n"); 
		query.append("@[vndr_cnt_cd]," ).append("\n"); 
		query.append("@[vndr_seq]," ).append("\n"); 
		query.append("@[agn_agmt_ver_seq]," ).append("\n"); 
		query.append("@[io_bnd_cd]," ).append("\n"); 
		query.append("@[ac_tp_cd]," ).append("\n"); 
		query.append("@[agn_seq]," ).append("\n"); 
		query.append("decode(@[cntr_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("@[full_mty_cd]," ).append("\n"); 
		query.append("@[comm_pay_term_cd]," ).append("\n"); 
		query.append("@[grs_net_div_cd]," ).append("\n"); 
		query.append("@[curr_cd]," ).append("\n"); 
		query.append("decode(@[chg_ddct_inp_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[hlg_ddct_org_flg],'','*','S')," ).append("\n"); 
		query.append("decode(@[hlg_ddct_dest_flg],'1','Y','N')," ).append("\n"); 
		query.append("decode(@[fdrg_ddct_org_flg],'1','Y','N')," ).append("\n"); 
		query.append("decode(@[fdrg_ddct_dest_flg],'1','Y','N')," ).append("\n"); 
		query.append("decode(@[cust_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[sc_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[rfa_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_ofc_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[sls_ofc_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_por_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_pol_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_pod_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_del_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_ppd_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_clt_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[bkg_n3rd_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[ac_tp_cd],'O','Y','N'),--bkg_soc_flg" ).append("\n"); 
		query.append("decode(@[ac_tp_cd],'O','Y','N'),--bkg_dbl_flg" ).append("\n"); 
		query.append("decode(@[sc_ofc_inp_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[rfa_ofc_inp_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[lane_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("decode(@[vsl_inp_term_cd],'','*','S')," ).append("\n"); 
		query.append("'*',--locl_chg_inp_term_cd," ).append("\n"); 
		query.append("@[comm_stnd_cost_cd]," ).append("\n"); 
		query.append("decode(@[fx_comm_amt],'','0',@[fx_comm_amt])," ).append("\n"); 
		query.append("decode(@[bkg_comm_rt],'','0',@[bkg_comm_rt])," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}