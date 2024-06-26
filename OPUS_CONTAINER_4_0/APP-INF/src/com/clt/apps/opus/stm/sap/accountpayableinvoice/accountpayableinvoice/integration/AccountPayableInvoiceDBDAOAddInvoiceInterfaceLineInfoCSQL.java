/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfaceLineInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.29 
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

public class AccountPayableInvoiceDBDAOAddInvoiceInterfaceLineInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOAddInvoiceInterfaceLineInfoCSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInvoiceInterfaceLineInfoCSQL(){
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
		params.put("glo_attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_inv_round_amount",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("creation_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_if_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt18",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("line_functional_amount",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_line_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dtrb_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfaceLineInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_INV_DTL" ).append("\n"); 
		query.append("   ( ACCTG_DT" ).append("\n"); 
		query.append("   , ACCL_BK_PST_FLG" ).append("\n"); 
		query.append("   , ASET_ADD_FLG" ).append("\n"); 
		query.append("   , ASET_TRAK_FLG" ).append("\n"); 
		query.append("   , CSH_BK_PST_FLG" ).append("\n"); 
		query.append("   , DTRB_LINE_NO" ).append("\n"); 
		query.append("   , DTRB_COA_CO_CD" ).append("\n"); 
		query.append("   , DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("   , DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("   , DTRB_COA_ACCT_NO" ).append("\n"); 
		query.append("   , DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("   , DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("   , INV_SEQ" ).append("\n"); 
		query.append("   , LINE_TP_LU_CD" ).append("\n"); 
		query.append("   , EFF_YRMON" ).append("\n"); 
		query.append("   , DTRB_AMT" ).append("\n"); 
		query.append("   , DTRB_FUNC_AMT" ).append("\n"); 
		query.append("   , BAT_SEQ" ).append("\n"); 
		query.append("   , DTRB_DESC" ).append("\n"); 
		query.append("   , MTCH_STS_FLG" ).append("\n"); 
		query.append("   , ACCTG_PST_FLG" ).append("\n"); 
		query.append("   , RVS_FLG" ).append("\n"); 
		query.append("   , DTRB_XCH_DT" ).append("\n"); 
		query.append("   , DTRB_XCH_RT" ).append("\n"); 
		query.append("   , DTRB_XCH_RT_TP_CD" ).append("\n"); 
		query.append("   , ATTR_CTNT1" ).append("\n"); 
		query.append("   , ATTR_CTNT2" ).append("\n"); 
		query.append("   , ATTR_CTNT3" ).append("\n"); 
		query.append("   , ATTR_CTNT4" ).append("\n"); 
		query.append("   , ATTR_CTNT5" ).append("\n"); 
		query.append("   , ATTR_CTNT6" ).append("\n"); 
		query.append("   , ATTR_CTNT7" ).append("\n"); 
		query.append("   , ATTR_CTNT8" ).append("\n"); 
		query.append("   , ATTR_CTNT9" ).append("\n"); 
		query.append("   , ATTR_CTNT10" ).append("\n"); 
		query.append("   , ATTR_CTNT11" ).append("\n"); 
		query.append("   , ATTR_CTNT12" ).append("\n"); 
		query.append("   , ATTR_CTNT13" ).append("\n"); 
		query.append("   , ATTR_CTNT14" ).append("\n"); 
		query.append("   , ATTR_CTNT15" ).append("\n"); 
		query.append("   , ATTR_CATE_NM" ).append("\n"); 
		query.append("   , PPAY_RMN_AMT" ).append("\n"); 
		query.append("   , GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("   , DTRB_MTCH_TP_NM" ).append("\n"); 
		query.append("   , INV_DTRB_SEQ" ).append("\n"); 
		query.append("   , PRNT_RVS_DTRB_SEQ" ).append("\n"); 
		query.append("   , ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("   , PPAY_DTRB_SEQ" ).append("\n"); 
		query.append("   , DTRB_CLSS_NM" ).append("\n"); 
		query.append("   , DTRB_VAT_CD" ).append("\n"); 
		query.append("   , OLD_DTRB_SEQ" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append("   , DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("   , INV_RND_AMT" ).append("\n"); 
		query.append("   , DTRB_FUNC_GAIN_AMT" ).append("\n"); 
		query.append("   , DTRB_FUNC_LSS_AMT" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   VALUES" ).append("\n"); 
		query.append("   ( TO_DATE(@[acctg_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("   , 'N'" ).append("\n"); 
		query.append("   , 'N'" ).append("\n"); 
		query.append("   , 'N'" ).append("\n"); 
		query.append("   , 'N'" ).append("\n"); 
		query.append("   , @[inv_line_no]" ).append("\n"); 
		query.append("   , @[dtrb_coa_co_cd]" ).append("\n"); 
		query.append("   , @[dtrb_coa_rgn_cd]" ).append("\n"); 
		query.append("   , @[dtrb_coa_ctr_cd]" ).append("\n"); 
		query.append("   , @[dtrb_coa_acct_no]" ).append("\n"); 
		query.append("   , @[dtrb_coa_vvd_cd]" ).append("\n"); 
		query.append("   , @[dtrb_coa_inter_co_cd]" ).append("\n"); 
		query.append("   , @[inv_seq]" ).append("\n"); 
		query.append("   , @[line_tp_lu_cd]" ).append("\n"); 
		query.append("   , SUBSTR(@[acctg_dt], 1, 6)" ).append("\n"); 
		query.append("   , ROUND(TO_NUMBER(REPLACE(@[dtrb_amt], ',', '')), 3)" ).append("\n"); 
		query.append("   , @[line_functional_amount]" ).append("\n"); 
		query.append("   , @[inv_if_seq]" ).append("\n"); 
		query.append("   , @[dtrb_desc]" ).append("\n"); 
		query.append("   , 'A'" ).append("\n"); 
		query.append("   , 'N'" ).append("\n"); 
		query.append("   , ''" ).append("\n"); 
		query.append("   , TO_DATE(@[dtrb_xch_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("   , @[dtrb_xch_rt]" ).append("\n"); 
		query.append("   , @[dtrb_xch_rt_tp_cd]" ).append("\n"); 
		query.append("   , REPLACE(@[attr_ctnt1], chr(9), '')" ).append("\n"); 
		query.append("   , SUBSTR(REPLACE(REPLACE(@[attr_ctnt2], '/', ''), '-', ''), 1, 8)" ).append("\n"); 
		query.append("   , @[attr_ctnt3]" ).append("\n"); 
		query.append("   , @[attr_ctnt4]" ).append("\n"); 
		query.append("   , @[attr_ctnt5]" ).append("\n"); 
		query.append("   , @[attr_ctnt6]" ).append("\n"); 
		query.append("   , @[attr_ctnt7]" ).append("\n"); 
		query.append("   , @[attr_ctnt8]" ).append("\n"); 
		query.append("   , @[attr_ctnt9]" ).append("\n"); 
		query.append("   , @[attr_ctnt10]" ).append("\n"); 
		query.append("   , @[attr_ctnt11]" ).append("\n"); 
		query.append("   , @[attr_ctnt12]" ).append("\n"); 
		query.append("   , @[attr_ctnt13]" ).append("\n"); 
		query.append("   , @[attr_ctnt14]" ).append("\n"); 
		query.append("   , @[attr_ctnt15]" ).append("\n"); 
		query.append("   , NVL(@[attr_cate_nm], @[dtrb_coa_acct_no]) " ).append("\n"); 
		query.append("   , ''" ).append("\n"); 
		query.append("   , @[glo_attr_cate_nm]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt1]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt2]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt3]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt4]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt5]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt6]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt7]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt8]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt9]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt10]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt11]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt12]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt13]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt14]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt15]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt16]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt17]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt18]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt19]" ).append("\n"); 
		query.append("   , @[glo_attr_ctnt20]" ).append("\n"); 
		query.append("   , 'NOT_MATCHED'" ).append("\n"); 
		query.append("   , SAP_INV_DTL_SEQ.NEXTVAL" ).append("\n"); 
		query.append("   , ''" ).append("\n"); 
		query.append("   , ''" ).append("\n"); 
		query.append("   , ''" ).append("\n"); 
		query.append("   , 'PERMANENT'" ).append("\n"); 
		query.append("   , @[dtrb_vat_cd]" ).append("\n"); 
		query.append("   , ''" ).append("\n"); 
		query.append("   , @[creation_user]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[dtrb_cd_cmb_seq]" ).append("\n"); 
		query.append("   , @[l_inv_round_amount]" ).append("\n"); 
		query.append("   , @[dtrb_func_gain_amt]" ).append("\n"); 
		query.append("   , @[dtrb_func_lss_amt]" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}