/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchPrepaymentSettlementInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15 
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

public class AccountPayableInvoiceDBDAOSearchPrepaymentSettlementInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPrepaymentSettlementInvoiceList
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchPrepaymentSettlementInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchPrepaymentSettlementInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   INV_SEQ" ).append("\n"); 
		query.append(" , VNDR_NO" ).append("\n"); 
		query.append(" , INV_NO" ).append("\n"); 
		query.append(" , INV_CURR_CD" ).append("\n"); 
		query.append(" , INV_PAY_CURR_CD" ).append("\n"); 
		query.append(" , TRIM(SAP_GET_CUR_AMT_FNC(INV_CURR_CD, INV_AMT ))  INV_AMT" ).append("\n"); 
		query.append(" , INV_PAY_AMT" ).append("\n"); 
		query.append(" , INV_DT" ).append("\n"); 
		query.append(" , AP_INV_SRC_CD" ).append("\n"); 
		query.append(" , INV_TP_LU_CD" ).append("\n"); 
		query.append(" , INV_DESC" ).append("\n"); 
		query.append(" , BAT_SEQ" ).append("\n"); 
		query.append(" , INV_VAT_AMT" ).append("\n"); 
		query.append(" , INV_TERM_NM" ).append("\n"); 
		query.append(" , INV_TERM_DT" ).append("\n"); 
		query.append(" , PAY_MZD_LU_CD" ).append("\n"); 
		query.append(" , AP_PAY_GRP_LU_CD" ).append("\n"); 
		query.append(" , PAY_STS_FLG" ).append("\n"); 
		query.append(" , INV_FUNC_AMT" ).append("\n"); 
		query.append(" , INV_VAT_CD" ).append("\n"); 
		query.append(" , INV_XCH_RT" ).append("\n"); 
		query.append(" , INV_XCH_RT_TP_CD" ).append("\n"); 
		query.append(" , INV_XCH_DT" ).append("\n"); 
		query.append(" , ERY_STL_DT" ).append("\n"); 
		query.append(" , ATTR_CATE_NM" ).append("\n"); 
		query.append(" , AP_APSTS_CD" ).append("\n"); 
		query.append(" , INV_CXL_DT" ).append("\n"); 
		query.append(" , CXL_USR_ID" ).append("\n"); 
		query.append(" , INV_CXL_AMT" ).append("\n"); 
		query.append(" , OFC_CD" ).append("\n"); 
		query.append(" , GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append(" , PAY_CURR_INV_AMT" ).append("\n"); 
		query.append(" , GL_DT" ).append("\n"); 
		query.append(" , INV_APRO_RDY_FLG" ).append("\n"); 
		query.append(" , DTRB_SET_SEQ" ).append("\n"); 
		query.append(" , XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append(" , LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append(" , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = TO_NUMBER(H.VNDR_NO) AND ROWNUM=1 ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(" , (" ).append("\n"); 
		query.append("	 SELECT  TRIM( SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, SUM(NVL(SID.PPAY_RMN_AMT, SID.DTRB_AMT))) ) " ).append("\n"); 
		query.append("     FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("     WHERE   SID.INV_SEQ = H.INV_SEQ" ).append("\n"); 
		query.append("     AND     SID.LINE_TP_LU_CD IN ('ITEM', 'ACCRUAL', 'REC_TAX', 'NONREC_TAX')" ).append("\n"); 
		query.append("     AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    )  AS PREPAY_RMN_TOT_AMT " ).append("\n"); 
		query.append(" ,(SELECT NVL(DP_PRCS_KNT, 0) FROM MDM_CURRENCY M WHERE M.CURR_CD = H.INV_CURR_CD AND ROWNUM=1 ) AS INV_CURR_PRCS" ).append("\n"); 
		query.append("FROM SAP_INV_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${inv_seq} != '') " ).append("\n"); 
		query.append("AND H.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}