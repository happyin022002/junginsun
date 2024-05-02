/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransferOrderIssueDBDAOAddEurTroCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOAddEurTroCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOAddEurTroCSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOAddEurTroCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hlg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trsp_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_chg_cd3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_chg_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_rtn_dt_hhmi",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("optm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_dt_hhmi",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_clr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_amt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_rtn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_trns_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t1_doc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("not_optm_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOAddEurTroCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EUR_TRO (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",   RQST_SUB_SEQ" ).append("\n"); 
		query.append(",   CNTR_NO" ).append("\n"); 
		query.append(",   CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",   RC_SEQ" ).append("\n"); 
		query.append(",   AWK_CGO_SEQ" ).append("\n"); 
		query.append(",   HLG_TP_CD" ).append("\n"); 
		query.append(",   CGO_WGT" ).append("\n"); 
		query.append(",   CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append(",   CNTR_PKUP_DT" ).append("\n"); 
		query.append(",   CNTR_RTN_YD_CD" ).append("\n"); 
		query.append(",   CNTR_RTN_DT" ).append("\n"); 
		query.append(",   CMDT_CD" ).append("\n"); 
		query.append(",   REP_CMDT_CD" ).append("\n"); 
		query.append(",   REP_CMDT_DESC" ).append("\n"); 
		query.append(",   BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",   SPCL_INSTR_RMK" ).append("\n"); 
		query.append(",   T1_DOC_FLG" ).append("\n"); 
		query.append(",   CSTMS_CLR_NO" ).append("\n"); 
		query.append(",   ALL_IN_RT_CD" ).append("\n"); 
		query.append(",   CURR_CD" ).append("\n"); 
		query.append(",   TRNS_REV_AMT" ).append("\n"); 
		query.append(",   NMF_TRNS_REV_AMT" ).append("\n"); 
		query.append(",	ADD_REV_AMT" ).append("\n"); 
		query.append(",	ADD_REV_CHG_CD" ).append("\n"); 
		query.append(",	ADD_REV_AMT2" ).append("\n"); 
		query.append(",	ADD_REV_CHG_CD2" ).append("\n"); 
		query.append(",	ADD_REV_AMT3" ).append("\n"); 
		query.append(",	ADD_REV_CHG_CD3" ).append("\n"); 
		query.append(",	ADD_REV_RMK" ).append("\n"); 
		query.append(",   CXL_FLG" ).append("\n"); 
		query.append(",   VAT_FLG" ).append("\n"); 
		query.append(",   CORR_FLG" ).append("\n"); 
		query.append(",   CFM_ALL_IN_RT_CD" ).append("\n"); 
		query.append(",   CFM_VAT_FLG" ).append("\n"); 
		query.append(",   OPTM_STS_CD" ).append("\n"); 
		query.append(",   NOT_OPTM_RSN" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	@[tro_seq]" ).append("\n"); 
		query.append(",	@[rqst_sub_seq]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[awk_cgo_seq]" ).append("\n"); 
		query.append(",	@[hlg_tp_cd]" ).append("\n"); 
		query.append(",	@[cgo_wgt]" ).append("\n"); 
		query.append(",	UPPER(TRIM(@[cntr_pkup_yd_cd]))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_pkup_dt} != '') " ).append("\n"); 
		query.append(",    TO_DATE(@[cntr_pkup_dt]||' '||@[cntr_pkup_dt_hhmi], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",    @[cntr_pkup_dt]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	UPPER(TRIM(@[cntr_rtn_yd_cd]))" ).append("\n"); 
		query.append("#if (${cntr_rtn_dt} != '') " ).append("\n"); 
		query.append(",    TO_DATE(@[cntr_rtn_dt]||' '||@[cntr_rtn_dt_hhmi], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",    @[cntr_rtn_dt]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(",	NVL(@[tro_cmdt_cd], (select cmdt_cd     from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append(",	NVL(@[rep_cmdt_cd], (select rep_cmdt_cd from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append(",	@[rep_cmdt_nm]" ).append("\n"); 
		query.append(",	@[bkg_trsp_mzd_cd]" ).append("\n"); 
		query.append(",	@[spcl_instr_rmk]" ).append("\n"); 
		query.append(",	NVL(@[t1_doc_flg], 'N')" ).append("\n"); 
		query.append(",	@[cstms_clr_no]" ).append("\n"); 
		query.append(",	NVL(@[all_in_rt_cd], 'N')" ).append("\n"); 
		query.append(",	DECODE(@[hlg_tp_cd], 'C', @[curr_cd], NVL(@[curr_cd], 'EUR'))" ).append("\n"); 
		query.append(",	@[trns_rev_amt]" ).append("\n"); 
		query.append(",	@[non_trns_rev_amt]" ).append("\n"); 
		query.append(",	@[add_rev_amt]" ).append("\n"); 
		query.append(",	@[add_rev_chg_cd]" ).append("\n"); 
		query.append(",	@[add_rev_amt2]" ).append("\n"); 
		query.append(",	@[add_rev_chg_cd2]" ).append("\n"); 
		query.append(",	@[add_rev_amt3]" ).append("\n"); 
		query.append(",	@[add_rev_chg_cd3]" ).append("\n"); 
		query.append(",	@[add_rev_rmk]" ).append("\n"); 
		query.append(",   'N'" ).append("\n"); 
		query.append(",   NVL(@[vat_flg], 'N')" ).append("\n"); 
		query.append(",   'N'" ).append("\n"); 
		query.append(",   'N'" ).append("\n"); 
		query.append(",   'N'" ).append("\n"); 
		query.append(",   @[optm_sts_cd]" ).append("\n"); 
		query.append(",   @[not_optm_rsn]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	NVL((SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[cre_usr_id]),@[cre_ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}