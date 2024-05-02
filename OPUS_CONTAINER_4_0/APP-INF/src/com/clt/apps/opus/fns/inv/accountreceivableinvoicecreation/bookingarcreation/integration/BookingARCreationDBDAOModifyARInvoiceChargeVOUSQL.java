/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyARInvoiceChargeVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyARInvoiceChargeVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_AR_CHG
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyARInvoiceChargeVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tva_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rev_tp_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("per_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyARInvoiceChargeVOUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG SET " ).append("\n"); 
		query.append("	MF_DIV_CD = NVL(@[mf_div_cd], MF_DIV_CD)" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append(",	CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append(",	CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append(",	PER_TP_CD = @[per_tp_cd]" ).append("\n"); 
		query.append(",	TRF_RT_AMT = @[trf_rt_amt]" ).append("\n"); 
		query.append(",	RAT_AS_CNTR_QTY = @[rat_as_cntr_qty]" ).append("\n"); 
		query.append(",	CHG_AMT = @[chg_amt]" ).append("\n"); 
		query.append(",	INV_XCH_RT = NVL(@[inv_xch_rt], 0)" ).append("\n"); 
		query.append(",	USD_XCH_RT = NVL(@[usd_xch_rt], NVL(USD_XCH_RT, 0))" ).append("\n"); 
		query.append(",   REV_COA_CO_CD = NVL(@[rev_coa_co_cd],REV_COA_CO_CD)" ).append("\n"); 
		query.append(",   REV_COA_RGN_CD = NVL(@[rev_coa_rgn_cd],REV_COA_RGN_CD)" ).append("\n"); 
		query.append(",   REV_COA_CTR_CD = NVL(@[rev_coa_ctr_cd],REV_COA_CTR_CD)" ).append("\n"); 
		query.append(",   REV_COA_ACCT_CD = NVL(@[rev_coa_acct_cd],REV_COA_ACCT_CD)" ).append("\n"); 
		query.append(",   REV_COA_INTER_CO_CD = NVL(@[rev_coa_inter_co_cd],REV_COA_INTER_CO_CD)" ).append("\n"); 
		query.append(",   REV_COA_VSL_CD = NVL(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_vsl_cd], '7', @[rev_coa_vsl_cd], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_vsl_cd], '0000'))),REV_COA_VSL_CD)" ).append("\n"); 
		query.append(",   REV_COA_VOY_NO = NVL(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_voy_no], '7', @[rev_coa_voy_no], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_voy_no], '0000'))),REV_COA_VOY_NO)" ).append("\n"); 
		query.append(",   REV_COA_SKD_DIR_CD = NVL(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_skd_dir_cd], '7', @[rev_coa_skd_dir_cd], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_skd_dir_cd], '0'))),REV_COA_SKD_DIR_CD)" ).append("\n"); 
		query.append(",   REV_COA_DIR_CD = NVL(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_dir_cd], '7', @[rev_coa_dir_cd], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_dir_cd], '0'))),REV_COA_DIR_CD)" ).append("\n"); 
		query.append(",   ACCT_CD = NVL(@[acct_cd],ACCT_CD)   " ).append("\n"); 
		query.append(",	TVA_FLG = DECODE(@[tva_flg],'1','Y','0','N','',TVA_FLG,@[tva_flg])" ).append("\n"); 
		query.append(",	INV_REV_TP_SRC_CD = NVL(@[inv_rev_tp_src_cd],INV_REV_TP_SRC_CD)   " ).append("\n"); 
		query.append("WHERE	AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND AR_IF_SER_NO = @[ar_if_ser_no]" ).append("\n"); 
		query.append("AND CHG_SEQ = @[chg_seq]" ).append("\n"); 

	}
}