/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchPrepaymentSettlementUnapplyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.06 
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

public class AccountPayableInvoiceDBDAOSearchPrepaymentSettlementUnapplyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPrepaymentSettlementUnapplyList
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchPrepaymentSettlementUnapplyListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchPrepaymentSettlementUnapplyListRSQL").append("\n"); 
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
		query.append("SELECT UNAPPLY_V.ROW_ID" ).append("\n"); 
		query.append("      ,UNAPPLY_V.INV_SEQ" ).append("\n"); 
		query.append("      ,UNAPPLY_V.DTRB_LINE_NO" ).append("\n"); 
		query.append("      ,UNAPPLY_V.PPAY_INV_SEQ" ).append("\n"); 
		query.append("      ,UNAPPLY_V.PPAY_LINE_NO" ).append("\n"); 
		query.append("      ,TRIM(SAP_GET_CUR_AMT_FNC( H.INV_CURR_CD, UNAPPLY_V.PREPAY_AMOUNT_APPLIED )) PREPAY_AMOUNT_APPLIED" ).append("\n"); 
		query.append("      ,TRIM(SAP_GET_CUR_AMT_FNC( H.INV_CURR_CD, UNAPPLY_V.TAX_AMOUNT_APPLIED )) TAX_AMOUNT_APPLIED" ).append("\n"); 
		query.append("      ,TO_CHAR(UNAPPLY_V.ACCTG_DT, 'YYYYMMDD') UNAPPLY_GL_DATE" ).append("\n"); 
		query.append("      ,UNAPPLY_V.EFF_YRMON" ).append("\n"); 
		query.append("      ,UNAPPLY_V.DTRB_DESC" ).append("\n"); 
		query.append("      ,UNAPPLY_V.INV_NO" ).append("\n"); 
		query.append("      ,UNAPPLY_V.VNDR_NO" ).append("\n"); 
		query.append("      ,UNAPPLY_V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,UNAPPLY_V.PREPAY_ID" ).append("\n"); 
		query.append("      , 0 AS UNAPPLY_AMOUNT" ).append("\n"); 
		query.append("      ,'0' AS UNAPPLY" ).append("\n"); 
		query.append("      ,UNAPPLY_V.IF_FLAG" ).append("\n"); 
		query.append("FROM   OPUSADM.SAP_UNAP_PREPAYS_FR_PREPAY_V  UNAPPLY_V" ).append("\n"); 
		query.append("      ,SAP_INV_HDR H" ).append("\n"); 
		query.append("WHERE  UNAPPLY_V.PPAY_INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("AND    UNAPPLY_V.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("AND    UNAPPLY_V.INV_SEQ = H.INV_SEQ" ).append("\n"); 

	}
}