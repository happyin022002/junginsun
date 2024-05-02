/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInvoiceLineUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyInvoiceLineUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAP_INV_DTL UPDATE
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInvoiceLineUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_mtch_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_dtrb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_dtrb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_clss_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rnd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_rmn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_add_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtrb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_func_gain_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_rvs_dtrb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csh_bk_pst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtch_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_bk_pst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_tp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_pst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_evnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_vat_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_func_lss_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_func_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_trak_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInvoiceLineUSQL").append("\n"); 
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
		query.append("UPDATE SAP_INV_DTL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   ACCTG_DT	= TO_DATE(REPLACE(@[acctg_dt], '-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append(" , ACCL_BK_PST_FLG	= @[accl_bk_pst_flg]" ).append("\n"); 
		query.append(" , ASET_ADD_FLG	= NVL( @[aset_add_flg], 'N')" ).append("\n"); 
		query.append(" , ASET_TRAK_FLG	= NVL( @[aset_trak_flg], 'N')" ).append("\n"); 
		query.append(" , CSH_BK_PST_FLG	= NVL( @[csh_bk_pst_flg], CSH_BK_PST_FLG)" ).append("\n"); 
		query.append(" , DTRB_LINE_NO	= @[dtrb_line_no]" ).append("\n"); 
		query.append(" , DTRB_COA_CO_CD	= @[dtrb_coa_co_cd]" ).append("\n"); 
		query.append(" , DTRB_COA_RGN_CD	= @[dtrb_coa_rgn_cd]" ).append("\n"); 
		query.append(" , DTRB_COA_CTR_CD	= @[dtrb_coa_ctr_cd]" ).append("\n"); 
		query.append(" , DTRB_COA_ACCT_NO	= @[dtrb_coa_acct_no]" ).append("\n"); 
		query.append(" , DTRB_COA_VVD_CD	= @[dtrb_coa_vvd_cd]" ).append("\n"); 
		query.append(" , DTRB_COA_INTER_CO_CD	= @[dtrb_coa_inter_co_cd]" ).append("\n"); 
		query.append(" , INV_SEQ	= @[inv_seq]" ).append("\n"); 
		query.append(" , LINE_TP_LU_CD	= @[line_tp_lu_cd]" ).append("\n"); 
		query.append(" , EFF_YRMON	= NVL( @[eff_yrmon], EFF_YRMON)" ).append("\n"); 
		query.append(" , DTRB_AMT	= ROUND( TO_NUMBER( REPLACE( @[dtrb_amt], ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , DTRB_FUNC_AMT	= ROUND( TO_NUMBER( REPLACE( @[dtrb_func_amt], ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , INV_RND_AMT	= ROUND( TO_NUMBER( REPLACE( @[inv_rnd_amt], ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , BAT_SEQ	= NVL( @[bat_seq], BAT_SEQ) " ).append("\n"); 
		query.append(" , DTRB_DESC	= @[dtrb_desc]" ).append("\n"); 
		query.append(" , MTCH_STS_FLG	= NVL( @[mtch_sts_flg], MTCH_STS_FLG)" ).append("\n"); 
		query.append(" , ACCTG_PST_FLG	= NVL( @[acctg_pst_flg], ACCTG_PST_FLG )" ).append("\n"); 
		query.append(" , RVS_FLG	= NVL ( @[rvs_flg], RVS_FLG) " ).append("\n"); 
		query.append(" , DTRB_XCH_DT	= NVL( TO_DATE(REPLACE(@[dtrb_xch_dt], '-', ''),'YYYYMMDD'), DTRB_XCH_DT)" ).append("\n"); 
		query.append(" , DTRB_XCH_RT	= NVL( @[dtrb_xch_rt], DTRB_XCH_RT)" ).append("\n"); 
		query.append(" , DTRB_XCH_RT_TP_CD	= NVL( @[dtrb_xch_rt_tp_cd], DTRB_XCH_RT_TP_CD)" ).append("\n"); 
		query.append(" , ATTR_CTNT1	= @[attr_ctnt1]" ).append("\n"); 
		query.append(" , ATTR_CTNT2	= REPLACE(@[attr_ctnt2], '-', '')" ).append("\n"); 
		query.append(" , ATTR_CTNT3	= @[attr_ctnt3]" ).append("\n"); 
		query.append(" , ATTR_CTNT4	= @[attr_ctnt4]" ).append("\n"); 
		query.append(" , ATTR_CTNT5	= @[attr_ctnt5]" ).append("\n"); 
		query.append(" , ATTR_CTNT6	= @[attr_ctnt6]" ).append("\n"); 
		query.append(" , ATTR_CTNT7	= @[attr_ctnt7]" ).append("\n"); 
		query.append(" , ATTR_CTNT8	= @[attr_ctnt8]" ).append("\n"); 
		query.append(" , ATTR_CTNT9	= @[attr_ctnt9]" ).append("\n"); 
		query.append(" , ATTR_CTNT10	= @[attr_ctnt10]" ).append("\n"); 
		query.append(" , ATTR_CTNT11	= REPLACE(@[attr_ctnt11], '-', '')" ).append("\n"); 
		query.append(" , ATTR_CTNT12	= @[attr_ctnt12]" ).append("\n"); 
		query.append(" , ATTR_CTNT13	= @[attr_ctnt13]" ).append("\n"); 
		query.append(" , ATTR_CTNT14	= @[attr_ctnt14]" ).append("\n"); 
		query.append(" , ATTR_CTNT15	= @[attr_ctnt15]" ).append("\n"); 
		query.append(" , ATTR_CATE_NM	= NVL( @[attr_cate_nm], @[dtrb_coa_acct_no] ) " ).append("\n"); 
		query.append(" , PPAY_RMN_AMT	= @[ppay_rmn_amt]" ).append("\n"); 
		query.append(" , GLO_ATTR_CATE_NM	= @[glo_attr_cate_nm]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT1	= @[glo_attr_ctnt1]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT2	= @[glo_attr_ctnt2]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT3	= @[glo_attr_ctnt3]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT4	= @[glo_attr_ctnt4]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT5	= @[glo_attr_ctnt5]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT6	= @[glo_attr_ctnt6]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT7	= @[glo_attr_ctnt7]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT8	= @[glo_attr_ctnt8]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT9	= @[glo_attr_ctnt9]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT10	= @[glo_attr_ctnt10]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT11	= @[glo_attr_ctnt11]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT12	= @[glo_attr_ctnt12]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT13	= @[glo_attr_ctnt13]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT14	= @[glo_attr_ctnt14]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT15	= @[glo_attr_ctnt15]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT16	= @[glo_attr_ctnt16]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT17	= @[glo_attr_ctnt17]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT18	= @[glo_attr_ctnt18]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT19	= @[glo_attr_ctnt19]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT20	= @[glo_attr_ctnt20]" ).append("\n"); 
		query.append(" , DTRB_MTCH_TP_NM	= NVL ( @[dtrb_mtch_tp_nm], DTRB_MTCH_TP_NM)" ).append("\n"); 
		query.append(" , PRNT_RVS_DTRB_SEQ	= NVL( @[prnt_rvs_dtrb_seq], PRNT_RVS_DTRB_SEQ)" ).append("\n"); 
		query.append(" , ACCTG_EVNT_SEQ	= NVL( @[acctg_evnt_seq], ACCTG_EVNT_SEQ)" ).append("\n"); 
		query.append(" , PPAY_DTRB_SEQ	= NVL( @[ppay_dtrb_seq], PPAY_DTRB_SEQ)" ).append("\n"); 
		query.append(" , DTRB_CLSS_NM	= @[dtrb_clss_nm]" ).append("\n"); 
		query.append(" , DTRB_VAT_CD	= @[dtrb_vat_cd]" ).append("\n"); 
		query.append(" , OLD_DTRB_SEQ	= @[old_dtrb_seq]" ).append("\n"); 
		query.append(" , UPD_USR_ID	= @[usr_id]" ).append("\n"); 
		query.append(" , UPD_DT	= SYSDATE" ).append("\n"); 
		query.append(" , DTRB_CD_CMB_SEQ	= @[dtrb_cd_cmb_seq]" ).append("\n"); 
		query.append(" , DTRB_FUNC_GAIN_AMT	= REPLACE(@[dtrb_func_gain_amt], ',', '')" ).append("\n"); 
		query.append(" , DTRB_FUNC_LSS_AMT	= REPLACE(@[dtrb_func_lss_amt], ',', '')" ).append("\n"); 
		query.append("WHERE INV_DTRB_SEQ = TO_NUMBER( @[inv_dtrb_seq] )" ).append("\n"); 

	}
}