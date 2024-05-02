/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOaddApplyHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOaddApplyHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Apply Header 정보 생성
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOaddApplyHeaderCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bil_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tj_src_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_tax_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOaddApplyHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_RCT_APLY_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("    , RCT_SEQ" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , OTS_OFC_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , LOCL_VVD_CD" ).append("\n"); 
		query.append("    , TRNK_VVD_CD" ).append("\n"); 
		query.append("    , SAIL_DT" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , OBRD_DT" ).append("\n"); 
		query.append("    , IO_BND_CD" ).append("\n"); 
		query.append("    , DUE_DT" ).append("\n"); 
		query.append("    , SREP_CD" ).append("\n"); 
		query.append("    , OTS_RMK" ).append("\n"); 
		query.append("    , XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , XCH_RT_DT" ).append("\n"); 
		query.append("    , CR_FLG" ).append("\n"); 
		query.append("    , AR_TAX_IND_CD" ).append("\n"); 
		query.append("    , TJ_SRC_NM" ).append("\n"); 
		query.append("    , AR_FINC_SRC_CD" ).append("\n"); 
		query.append("    , RVS_FLG" ).append("\n"); 
		query.append("    , RCT_APLY_AMT" ).append("\n"); 
		query.append("    , RCT_APLY_FLG" ).append("\n"); 
		query.append("    , MAX_AR_IF_NO" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("	, INV_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[rct_aply_hdr_seq]" ).append("\n"); 
		query.append("	, @[rct_seq]" ).append("\n"); 
		query.append("	, @[bl_no]" ).append("\n"); 
		query.append("    , @[bkg_no]" ).append("\n"); 
		query.append("    , @[inv_no]" ).append("\n"); 
		query.append("    , @[ots_ofc_cd]" ).append("\n"); 
		query.append("    , @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("    , @[bil_to_cust_seq]" ).append("\n"); 
		query.append("    , @[locl_vvd_cd]" ).append("\n"); 
		query.append("    , @[trnk_vvd_cd]" ).append("\n"); 
		query.append("    , @[sail_dt]" ).append("\n"); 
		query.append("    , @[sail_arr_dt]" ).append("\n"); 
		query.append("    , @[obrd_dt]" ).append("\n"); 
		query.append("    , @[io_bnd_cd]" ).append("\n"); 
		query.append("    , @[due_dt]" ).append("\n"); 
		query.append("    , @[srep_cd]" ).append("\n"); 
		query.append("    , @[ots_rmk]" ).append("\n"); 
		query.append("    , @[xch_rt_tp_cd]" ).append("\n"); 
		query.append("    , @[xch_rt_dt]" ).append("\n"); 
		query.append("    , @[cr_flg]" ).append("\n"); 
		query.append("    , @[ar_tax_ind_cd]" ).append("\n"); 
		query.append("    , @[tj_src_nm]" ).append("\n"); 
		query.append("    , @[ar_finc_src_cd]" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , @[rct_aply_amt]" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , @[max_ar_if_no]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	, @[inv_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}