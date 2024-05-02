/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculateDBDAOPriPrsRoutCsInfoSimulationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.24 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAOPriPrsRoutCsInfoSimulationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   Insert
	  * </pre>
	  */
	public CalculateDBDAOPriPrsRoutCsInfoSimulationCSQL(){
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
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_itchg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_finc_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_finc_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ho_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_clss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnee_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_itchg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_subst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prod_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_rout_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_rout_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_aval_spc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_finc_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_finc_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sel_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration").append("\n"); 
		query.append("FileName : CalculateDBDAOPriPrsRoutCsInfoSimulationCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_PRS_ROUT_CS_INFO (" ).append("\n"); 
		query.append("		ROUT_CS_NO" ).append("\n"); 
		query.append("		, ROUT_CS_CLSS_NO" ).append("\n"); 
		query.append("		, PCTL_NO" ).append("\n"); 
		query.append("		, BKG_NO" ).append("\n"); 
		query.append("		, MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("		, POR_CD" ).append("\n"); 
		query.append("		, POR_NOD_CD" ).append("\n"); 
		query.append("		, POL_CD" ).append("\n"); 
		query.append("		, N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("		, N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("		, N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("		, POD_CD" ).append("\n"); 
		query.append("		, DEL_CD" ).append("\n"); 
		query.append("		, DEL_NOD_CD" ).append("\n"); 
		query.append("		, MTY_RTN_YD_CD" ).append("\n"); 
		query.append("		, TTL_TZTM_HRS" ).append("\n"); 
		query.append("		, PROD_REV" ).append("\n"); 
		query.append("		, TTL_EXPN_AMT" ).append("\n"); 
		query.append("		, CM_AMT" ).append("\n"); 
		query.append("		, TRNK_AVAL_SPC" ).append("\n"); 
		query.append("		, BKG_SEL_FLG" ).append("\n"); 
		query.append("		, COP_CRE_FLG" ).append("\n"); 
		query.append("		, OB_ITCHG_CTNT" ).append("\n"); 
		query.append("		, IB_ITCHG_CTNT" ).append("\n"); 
		query.append("		, TRNK_VSL_CD" ).append("\n"); 
		query.append("		, TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("		, TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("		, CNST_FLG" ).append("\n"); 
		query.append("		, BKG_CGO_TP_CD" ).append("\n"); 
		query.append("		, BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("		, CMDT_CD" ).append("\n"); 
		query.append("		, BKG_DE_TERM_CD" ).append("\n"); 
		query.append("		, REP_CMDT_CD" ).append("\n"); 
		query.append("		, SHPR_CNT_CD" ).append("\n"); 
		query.append("		, SHPR_SEQ" ).append("\n"); 
		query.append("		, CNEE_CNT_CD" ).append("\n"); 
		query.append("		, CNEE_SEQ" ).append("\n"); 
		query.append("		, SC_NO" ).append("\n"); 
		query.append("		, RFA_NO" ).append("\n"); 
		query.append("		, DG_CLSS_CD" ).append("\n"); 
		query.append("		, DG_SPCL_FLG" ).append("\n"); 
		query.append("		, RF_SPCL_FLG" ).append("\n"); 
		query.append("		, SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("		, BB_SPCL_FLG" ).append("\n"); 
		query.append("		, RD_SPCL_FLG" ).append("\n"); 
		query.append("		, HNGR_SPCL_FLG" ).append("\n"); 
		query.append("		, SOC_FLG" ).append("\n"); 
		query.append("		, EQ_SUBST_FLG" ).append("\n"); 
		query.append("		, BKG_WGT" ).append("\n"); 
		query.append("		, BKG_WGT_UT_CD" ).append("\n"); 
		query.append("		, SLS_OFC_CD" ).append("\n"); 
		query.append("		, SLS_RHQ_CD" ).append("\n"); 
		query.append("		, SLS_HO_CD" ).append("\n"); 
		query.append("		, BKG_OFC_CD" ).append("\n"); 
		query.append("		, CRE_OFC_CD" ).append("\n"); 
		query.append("		, N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("		, N1ST_RLANE_CD" ).append("\n"); 
		query.append("		, N2ND_RLANE_CD" ).append("\n"); 
		query.append("		, N3RD_RLANE_CD" ).append("\n"); 
		query.append("		, N4TH_RLANE_CD" ).append("\n"); 
		query.append("		, N1ST_TRD_CD" ).append("\n"); 
		query.append("		, N2ND_TRD_CD" ).append("\n"); 
		query.append("		, N3RD_TRD_CD" ).append("\n"); 
		query.append("		, N4TH_TRD_CD" ).append("\n"); 
		query.append("		, SC_OFC_CD" ).append("\n"); 
		query.append("		, RFA_OFC_CD" ).append("\n"); 
		query.append("		, COST_ROUT_NO" ).append("\n"); 
		query.append("		, PARA_ROUT_NO" ).append("\n"); 
		query.append("		, PPD_OFC_CD" ).append("\n"); 
		query.append("		, CLT_OFC_CD" ).append("\n"); 
		query.append("		, CRE_USR_ID" ).append("\n"); 
		query.append("		, CRE_DT" ).append("\n"); 
		query.append("		, UPD_USR_ID" ).append("\n"); 
		query.append("		, UPD_DT" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("		@[rout_cs_no]" ).append("\n"); 
		query.append("		, @[rout_cs_clss_no]" ).append("\n"); 
		query.append("		, @[pctl_no]" ).append("\n"); 
		query.append("		, @[bkg_no]" ).append("\n"); 
		query.append("		, @[mty_pkup_yd_cd]" ).append("\n"); 
		query.append("		, @[por_cd]" ).append("\n"); 
		query.append("		, @[por_nod_cd]" ).append("\n"); 
		query.append("		, @[pol_cd]" ).append("\n"); 
		query.append("		, @[n1st_ts_port_cd]" ).append("\n"); 
		query.append("		, @[n2nd_ts_port_cd]" ).append("\n"); 
		query.append("		, @[n3rd_ts_port_cd]" ).append("\n"); 
		query.append("		, @[pod_cd]" ).append("\n"); 
		query.append("		, @[del_cd]" ).append("\n"); 
		query.append("		, @[del_nod_cd]" ).append("\n"); 
		query.append("		, @[mty_rtn_yd_cd]" ).append("\n"); 
		query.append("		, @[ttl_tztm_hrs]" ).append("\n"); 
		query.append("		, @[prod_rev]" ).append("\n"); 
		query.append("		, @[ttl_expn_amt]" ).append("\n"); 
		query.append("		, @[cm_amt]" ).append("\n"); 
		query.append("		, @[trnk_aval_spc]" ).append("\n"); 
		query.append("		, @[bkg_sel_flg]" ).append("\n"); 
		query.append("		, @[cop_cre_flg]" ).append("\n"); 
		query.append("		, @[ob_itchg_ctnt]" ).append("\n"); 
		query.append("		, @[ib_itchg_ctnt]" ).append("\n"); 
		query.append("		, @[trnk_vsl_cd]" ).append("\n"); 
		query.append("		, @[trnk_skd_voy_no]" ).append("\n"); 
		query.append("		, @[trnk_skd_dir_cd]" ).append("\n"); 
		query.append("		, @[cnst_flg]" ).append("\n"); 
		query.append("		, @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("		, @[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("		, @[cmdt_cd]" ).append("\n"); 
		query.append("		, @[bkg_de_term_cd]" ).append("\n"); 
		query.append("		, @[rep_cmdt_cd]" ).append("\n"); 
		query.append("		, @[shpr_cnt_cd]" ).append("\n"); 
		query.append("		, @[shpr_seq]" ).append("\n"); 
		query.append("		, @[cnee_cnt_cd]" ).append("\n"); 
		query.append("		, @[cnee_seq]" ).append("\n"); 
		query.append("		, @[sc_no]" ).append("\n"); 
		query.append("		, @[rfa_no]" ).append("\n"); 
		query.append("		, @[dg_clss_cd]" ).append("\n"); 
		query.append("		, @[dg_spcl_flg]" ).append("\n"); 
		query.append("		, @[rf_spcl_flg]" ).append("\n"); 
		query.append("		, @[spcl_awk_cgo_flg]" ).append("\n"); 
		query.append("		, @[bb_spcl_flg]" ).append("\n"); 
		query.append("		, @[rd_spcl_flg]" ).append("\n"); 
		query.append("		, @[hngr_spcl_flg]" ).append("\n"); 
		query.append("		, @[soc_flg]" ).append("\n"); 
		query.append("		, @[eq_subst_flg]" ).append("\n"); 
		query.append("		, @[bkg_wgt]" ).append("\n"); 
		query.append("		, @[bkg_wgt_ut_cd]" ).append("\n"); 
		query.append("		, @[sls_ofc_cd]" ).append("\n"); 
		query.append("		, @[sls_rhq_cd]" ).append("\n"); 
		query.append("		, @[sls_ho_cd]" ).append("\n"); 
		query.append("		, @[bkg_ofc_cd]" ).append("\n"); 
		query.append("		, @[cre_ofc_cd]" ).append("\n"); 
		query.append("		, @[n1st_finc_vvd_cd]" ).append("\n"); 
		query.append("		, @[n2nd_finc_vvd_cd]" ).append("\n"); 
		query.append("		, @[n3rd_finc_vvd_cd]" ).append("\n"); 
		query.append("		, @[n4th_finc_vvd_cd]" ).append("\n"); 
		query.append("		, @[n1st_rlane_cd]" ).append("\n"); 
		query.append("		, @[n2nd_rlane_cd]" ).append("\n"); 
		query.append("		, @[n3rd_rlane_cd]" ).append("\n"); 
		query.append("		, @[n4th_rlane_cd]" ).append("\n"); 
		query.append("		, @[n1st_trd_cd]" ).append("\n"); 
		query.append("		, @[n2nd_trd_cd]" ).append("\n"); 
		query.append("		, @[n3rd_trd_cd]" ).append("\n"); 
		query.append("		, @[n4th_trd_cd]" ).append("\n"); 
		query.append("		, @[sc_ofc_cd]" ).append("\n"); 
		query.append("		, @[rfa_ofc_cd]" ).append("\n"); 
		query.append("		, @[cost_rout_no]" ).append("\n"); 
		query.append("		, @[para_rout_no]" ).append("\n"); 
		query.append("		, @[ppd_ofc_cd]" ).append("\n"); 
		query.append("		, @[clt_ofc_cd]" ).append("\n"); 
		query.append("		, 'CALC',SYSDATE,'CALC',SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}