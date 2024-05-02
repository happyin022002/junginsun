/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOAddOutstandingReceiptTempCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOAddOutstandingReceiptTempCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Outstanding Receipt Temp
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOAddOutstandingReceiptTempCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_aply_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_dup_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_aply_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_prcs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_finc_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rct_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_aply_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_aply_src_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOAddOutstandingReceiptTempCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_OTS_RCT_TMP" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    OTS_RCT_TMP_SEQ" ).append("\n"); 
		query.append("    , RCT_APLY_HDR_NO" ).append("\n"); 
		query.append("    , RCT_APLY_FLG" ).append("\n"); 
		query.append("    , RHQ_CD " ).append("\n"); 
		query.append("    , OFC_CD" ).append("\n"); 
		query.append("    , OTS_OFC_CD" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , LOCL_VVD_CD" ).append("\n"); 
		query.append("    , TRNK_VVD_CD" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , IO_BND_CD" ).append("\n"); 
		query.append("    , DUE_DT" ).append("\n"); 
		query.append("    , SREP_CD" ).append("\n"); 
		query.append("    , OTS_RMK" ).append("\n"); 
		query.append("    , XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , XCH_RT_DT" ).append("\n"); 
		query.append("    , CR_FLG" ).append("\n"); 
		query.append("    , AR_FINC_SRC_CD" ).append("\n"); 
		query.append("    , MAX_AR_IF_NO" ).append("\n"); 
		query.append("    , INV_DT" ).append("\n"); 
		query.append("    , RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("    , RCT_APLY_SRC_CURR_CD" ).append("\n"); 
		query.append("    , OTS_BAL_AMT" ).append("\n"); 
		query.append("    , OTS_APLY_AMT" ).append("\n"); 
		query.append("    , OTS_XCH_RT" ).append("\n"); 
		query.append("    , RCT_APLY_XCH_RT" ).append("\n"); 
		query.append("    , RCT_CURR_CD" ).append("\n"); 
		query.append("    , RCT_APLY_AMT" ).append("\n"); 
		query.append("    , DP_PRCS_KNT" ).append("\n"); 
		query.append("	, HDR_DUP_FLG" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[ots_rct_tmp_seq]" ).append("\n"); 
		query.append("    , @[rct_aply_hdr_seq]" ).append("\n"); 
		query.append("    , @[rct_aply_flg]" ).append("\n"); 
		query.append("    , @[rhq_cd]" ).append("\n"); 
		query.append("    , @[ofc_cd]" ).append("\n"); 
		query.append("    , @[ots_ofc_cd]" ).append("\n"); 
		query.append("    , @[bl_no]" ).append("\n"); 
		query.append("    , @[bkg_no]" ).append("\n"); 
		query.append("    , @[inv_no]" ).append("\n"); 
		query.append("    , @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("    , @[bil_to_cust_seq]" ).append("\n"); 
		query.append("    , @[locl_vvd_cd]" ).append("\n"); 
		query.append("    , @[trnk_vvd_cd]" ).append("\n"); 
		query.append("    , @[sail_arr_dt]" ).append("\n"); 
		query.append("    , @[io_bnd_cd]" ).append("\n"); 
		query.append("    , @[due_dt]" ).append("\n"); 
		query.append("    , @[srep_cd]" ).append("\n"); 
		query.append("    , @[ots_rmk]" ).append("\n"); 
		query.append("    , @[xch_rt_tp_cd]" ).append("\n"); 
		query.append("    , @[xch_rt_dt]" ).append("\n"); 
		query.append("    , @[cr_flg]" ).append("\n"); 
		query.append("    , @[ar_finc_src_cd]" ).append("\n"); 
		query.append("    , @[max_ar_if_no]" ).append("\n"); 
		query.append("    , @[inv_dt]" ).append("\n"); 
		query.append("    , @[rct_aply_chg_cd]" ).append("\n"); 
		query.append("    , @[rct_aply_src_curr_cd]" ).append("\n"); 
		query.append("    , REPLACE(@[ots_bal_amt], ',', '')" ).append("\n"); 
		query.append("    , REPLACE(@[ots_aply_amt], ',', '')" ).append("\n"); 
		query.append("    , REPLACE(@[ots_xch_rt], ',', '')" ).append("\n"); 
		query.append("    , REPLACE(@[rct_aply_xch_rt], ',', '')" ).append("\n"); 
		query.append("    , @[rct_curr_cd]" ).append("\n"); 
		query.append("    , REPLACE(@[rct_aply_amt], ',', '')" ).append("\n"); 
		query.append("    , @[dp_prcs_knt]" ).append("\n"); 
		query.append("	, @[hdr_dup_flg]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}