/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddUnsettledAccountPreviousSummaryMoveNextCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.29 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOAddUnsettledAccountPreviousSummaryMoveNextCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOAddUnsettledAccountPreviousSummaryMoveNextCSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddUnsettledAccountPreviousSummaryMoveNextCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unstl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddUnsettledAccountPreviousSummaryMoveNextCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_UNSTL_SMRY " ).append("\n"); 
		query.append("(   UNSTL_ACCT_ITM_SEQ" ).append("\n"); 
		query.append("  , UNSTL_YRMON" ).append("\n"); 
		query.append("  , INV_SEQ" ).append("\n"); 
		query.append("  , INV_NO" ).append("\n"); 
		query.append("  , GL_DT" ).append("\n"); 
		query.append("  , UNSTL_SRC_CD" ).append("\n"); 
		query.append("  , UNSTL_CATE_NM" ).append("\n"); 
		query.append("  , VNDR_NO" ).append("\n"); 
		query.append("  , VNDR_NM" ).append("\n"); 
		query.append("  , STL_KEY_NO" ).append("\n"); 
		query.append("  , COA_RGN_CD" ).append("\n"); 
		query.append("  , COA_CTR_CD" ).append("\n"); 
		query.append("  , OFC_CD" ).append("\n"); 
		query.append("  , COA_ACCT_CD" ).append("\n"); 
		query.append("  , UNSTL_CURR_CD" ).append("\n"); 
		query.append("  , CONV_XCH_RT" ).append("\n"); 
		query.append("  , INP_DR_AMT" ).append("\n"); 
		query.append("  , INP_CR_AMT" ).append("\n"); 
		query.append("  , ACCT_DR_AMT" ).append("\n"); 
		query.append("  , ACCT_CR_AMT" ).append("\n"); 
		query.append("  , UNSTL_AMT" ).append("\n"); 
		query.append("  , UNSTL_TJ_DT" ).append("\n"); 
		query.append("  , UNSTL_DESC" ).append("\n"); 
		query.append("  , UNSTL_DL_NO" ).append("\n"); 
		query.append("  , UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("  , ACCT_STL_FLG" ).append("\n"); 
		query.append("  , ATTR_CTNT1" ).append("\n"); 
		query.append("  , ATTR_CTNT2" ).append("\n"); 
		query.append("  , ATTR_CTNT3" ).append("\n"); 
		query.append("  , ATTR_CTNT4" ).append("\n"); 
		query.append("  , ATTR_CTNT5" ).append("\n"); 
		query.append("  , ATTR_CTNT6" ).append("\n"); 
		query.append("  , ATTR_CTNT7" ).append("\n"); 
		query.append("  , ATTR_CTNT8" ).append("\n"); 
		query.append("  , ATTR_CTNT9" ).append("\n"); 
		query.append("  , ATTR_CTNT10" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SAP_UNSTL_SMRY_SEQ.NEXTVAL     AS UNSTL_ACCT_ITM_SEQ" ).append("\n"); 
		query.append("      , REPLACE(@[unstl_yrmon],'-','') AS UNSTL_YRMON" ).append("\n"); 
		query.append("      , SUS.INV_SEQ                    AS INV_SEQ" ).append("\n"); 
		query.append("      , SUS.INV_NO                     AS INV_NO" ).append("\n"); 
		query.append("      , SUS.GL_DT                      AS GL_DT" ).append("\n"); 
		query.append("      , SUS.UNSTL_SRC_CD               AS UNSTL_SRC_CD" ).append("\n"); 
		query.append("      , SUS.UNSTL_CATE_NM              AS UNSTL_CATE_NM" ).append("\n"); 
		query.append("      , SUS.VNDR_NO                    AS VNDR_NO" ).append("\n"); 
		query.append("      , SUS.VNDR_NM                    AS VNDR_NM" ).append("\n"); 
		query.append("      , SUS.STL_KEY_NO                 AS STL_KEY_NO" ).append("\n"); 
		query.append("      , SUS.COA_RGN_CD                 AS COA_RGN_CD" ).append("\n"); 
		query.append("      , SUS.COA_CTR_CD                 AS COA_CTR_CD" ).append("\n"); 
		query.append("      , SUS.OFC_CD                     AS OFC_CD" ).append("\n"); 
		query.append("      , SUS.COA_ACCT_CD                AS COA_ACCT_CD" ).append("\n"); 
		query.append("      , SUS.UNSTL_CURR_CD              AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("      , SUS.CONV_XCH_RT                AS CONV_XCH_RT" ).append("\n"); 
		query.append("      , SUS.INP_DR_AMT                 AS INP_DR_AMT" ).append("\n"); 
		query.append("      , SUS.INP_CR_AMT                 AS INP_CR_AMT" ).append("\n"); 
		query.append("      , SUS.ACCT_DR_AMT                AS ACCT_DR_AMT" ).append("\n"); 
		query.append("      , SUS.ACCT_CR_AMT                AS ACCT_CR_AMT" ).append("\n"); 
		query.append("      , SUS.UNSTL_AMT                  AS UNSTL_AMT" ).append("\n"); 
		query.append("      , SUS.UNSTL_TJ_DT                AS UNSTL_TJ_DT" ).append("\n"); 
		query.append("      , SUS.UNSTL_DESC                 AS UNSTL_DESC" ).append("\n"); 
		query.append("      , SUS.UNSTL_DL_NO                AS UNSTL_DL_NO" ).append("\n"); 
		query.append("      , SUS.UNSTL_DL_LINE_NO           AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("      , SUS.ACCT_STL_FLG               AS ACCT_STL_FLG" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT1                 AS ATTR_CTNT1" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT2                 AS ATTR_CTNT2" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT3                 AS ATTR_CTNT3" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT4                 AS ATTR_CTNT4" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT5                 AS ATTR_CTNT5" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT6                 AS ATTR_CTNT6" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT7                 AS ATTR_CTNT7" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT8                 AS ATTR_CTNT8" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT9                 AS ATTR_CTNT9" ).append("\n"); 
		query.append("      , SUS.ATTR_CTNT10                AS ATTR_CTNT10" ).append("\n"); 
		query.append("      , SUS.CRE_USR_ID                 AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                        AS CRE_DT" ).append("\n"); 
		query.append("      , SUS.UPD_USR_ID                 AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                        AS UPD_DT" ).append("\n"); 
		query.append("FROM    SAP_UNSTL_SMRY SUS" ).append("\n"); 
		query.append("WHERE   SUS.UNSTL_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[unstl_yrmon],'-',''), 'YYYYMM'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("AND     SUS.UNSTL_SRC_CD = 'AP'" ).append("\n"); 
		query.append("AND     SUS.ACCT_STL_FLG = 'N'" ).append("\n"); 

	}
}