/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOInsertAgreementVerifyDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.11.23 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOInsertAgreementVerifyDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Verify 대상 데이타를 global temp에 Insert
	  * </pre>
	  */
	public AgreementImportDBDAOInsertAgreementVerifyDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_nod_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_rowno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_scg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_scg_rt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_dist_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_agmt_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dist_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rvs_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_def_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_usr_def_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cost_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_one_wy_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rowno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_bdl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rout_all_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOInsertAgreementVerifyDataCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_TMP" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  TRSP_TMP_SEQ" ).append("\n"); 
		query.append(", TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(", TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(", EQ_KND_CD" ).append("\n"); 
		query.append(", TRSP_BND_CD" ).append("\n"); 
		query.append(", CGO_TP_CD" ).append("\n"); 
		query.append(", SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append(", AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append(", TRSP_COST_MOD_CD" ).append("\n"); 
		query.append(", CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append(", CMDT_GRP_CD" ).append("\n"); 
		query.append(", RAIL_SVC_TP_CD" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", FM_NOD_CD" ).append("\n"); 
		query.append(", VIA_NOD_CD" ).append("\n"); 
		query.append(", DOR_NOD_CD" ).append("\n"); 
		query.append(", TO_NOD_CD" ).append("\n"); 
		query.append(", TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append(", TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append(", EFF_FM_DT" ).append("\n"); 
		query.append(", EFF_TO_DT" ).append("\n"); 
		query.append(", TO_WGT" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(", TRSP_RND_RT" ).append("\n"); 
		query.append(", TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append(", WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(", TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append(", WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(", WTR_DE_TERM_CD" ).append("\n"); 
		query.append(", TRSP_AGMT_DIST" ).append("\n"); 
		query.append(", DIST_MEAS_UT_CD" ).append("\n"); 
		query.append(", TRSP_DIST_TP_CD" ).append("\n"); 
		query.append(", TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append(", TRSP_SCG_CD" ).append("\n"); 
		query.append(", AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append(", ROW_NO" ).append("\n"); 
		query.append(", SUB_ROW_NO" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", RT_UPD_STS_CD" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append(", COM_SCG_APLY_FLG" ).append("\n"); 
		query.append(", WO_APLY_FLG" ).append("\n"); 
		query.append(", USR_DEF_RMK" ).append("\n"); 
		query.append(", AFT_USR_DEF_RMK" ).append("\n"); 
		query.append(", TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(", TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append(", TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append(", AGMT_COST_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[trsp_tmp_seq]" ).append("\n"); 
		query.append(", SUBSTR(@[fm_agmtno], 1, 3)" ).append("\n"); 
		query.append(", TO_NUMBER(TRIM(SUBSTR(@[fm_agmtno], 4)))" ).append("\n"); 
		query.append(", @[fm_eq_knd_cd]" ).append("\n"); 
		query.append(", @[trsp_bnd_cd]" ).append("\n"); 
		query.append(", NVL(@[cgo_tp_cd], '0')" ).append("\n"); 
		query.append(", @[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append(", @[agmt_trsp_tp_cd]" ).append("\n"); 
		query.append(", @[trsp_cost_mod_cd]" ).append("\n"); 
		query.append(", DECODE(@[cust_cd], NULL, 'N', 'Y')" ).append("\n"); 
		query.append(", NVL(@[cmdt_grp_cd], 'XXXX')" ).append("\n"); 
		query.append(", NVL(@[rail_svc_tp_cd], '00')" ).append("\n"); 
		query.append(", NVL(SUBSTR(@[cust_cd], 1, 2),'XX')" ).append("\n"); 
		query.append(", NVL(SUBSTR(@[cust_cd], 3), 0)" ).append("\n"); 
		query.append(", NVL(@[fm_nod_cd]||@[fm_nod_yd], '0000000')" ).append("\n"); 
		query.append(", NVL(@[via_nod_cd]||@[via_nod_yd], '0000000')" ).append("\n"); 
		query.append(", NVL(@[dor_nod_cd]||@[dor_nod_yd], '0000000')" ).append("\n"); 
		query.append(", NVL(@[to_nod_cd]||@[to_nod_yd], '0000000')" ).append("\n"); 
		query.append(", @[trsp_agmt_eq_tp_cd]" ).append("\n"); 
		query.append(", @[trsp_agmt_eq_sz_cd]" ).append("\n"); 
		query.append(", TO_DATE(@[eff_fm_dt],'yyyyMMdd')" ).append("\n"); 
		query.append(", TO_DATE(@[eff_to_dt],'yyyyMMdd')" ).append("\n"); 
		query.append(", DECODE(@[to_wgt], 'MAX', '999999.99', NULL, '0', @[to_wgt])" ).append("\n"); 
		query.append(", NVL(@[curr_cd], 'XXX')" ).append("\n"); 
		query.append(", @[trsp_one_wy_rt]" ).append("\n"); 
		query.append(", @[trsp_rnd_rt]" ).append("\n"); 
		query.append(", @[fm_trsp_agmt_rt_tp_cd]" ).append("\n"); 
		query.append(", NVL(DECODE(@[to_wgt], 'MAX', 'XXX', '999999.99', 'XXX', '0', 'XXX', NULL, 'XXX', @[wgt_meas_ut_cd]), 'XXX')" ).append("\n"); 
		query.append(", NVL(@[trsp_agmt_bdl_qty], 0)" ).append("\n"); 
		query.append(", NVL(@[wtr_rcv_term_cd], '0')" ).append("\n"); 
		query.append(", NVL(@[wtr_de_term_cd], '0')" ).append("\n"); 
		query.append(", NVL(DECODE(@[trsp_agmt_dist], 'MAX', '999999.999999', @[trsp_agmt_dist]), 0)" ).append("\n"); 
		query.append(", NVL(@[dist_meas_ut_cd], 'XX')" ).append("\n"); 
		query.append(", NVL(@[trsp_dist_tp_cd], 'X')" ).append("\n"); 
		query.append(", NVL(@[trsp_rvs_aply_flg], 'N')" ).append("\n"); 
		query.append(", NVL(@[trsp_scg_cd],'XX')" ).append("\n"); 
		query.append(", NVL(@[agmt_rout_all_flg], 'N')" ).append("\n"); 
		query.append(", @[rowno]" ).append("\n"); 
		query.append(", @[chk_rowno]" ).append("\n"); 
		query.append(", 'AGMT'" ).append("\n"); 
		query.append(", 'AGMT'" ).append("\n"); 
		query.append(", @[ibflag]" ).append("\n"); 
		query.append(", NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append(", NVL(@[agmt_scg_rt_div_cd], 'X')" ).append("\n"); 
		query.append(", @[com_scg_aply_flg]" ).append("\n"); 
		query.append(", @[wo_aply_flg]" ).append("\n"); 
		query.append(", @[usr_def_rmk]" ).append("\n"); 
		query.append(", @[aft_usr_def_rmk]" ).append("\n"); 
		query.append(", @[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append(", @[trsp_agmt_nod_seq]" ).append("\n"); 
		query.append(", @[trsp_agmt_rt_seq]" ).append("\n"); 
		query.append(", NVL(@[agmt_cost_flg], '0')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}