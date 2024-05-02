/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentApplyInvSummaryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.29 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentApplyInvSummaryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentApplyInvSummaryCSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentApplyInvSummaryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("unstl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentApplyInvSummaryCSQL").append("\n"); 
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
		query.append("SELECT  SAP_UNSTL_SMRY_SEQ.NEXTVAL        AS UNSTL_ACCT_ITM_SEQ" ).append("\n"); 
		query.append("      , TO_CHAR(SID.ACCTG_DT, 'YYYYMM')   AS UNSTL_YRMON" ).append("\n"); 
		query.append("      , SIH.INV_SEQ                       AS INV_SEQ" ).append("\n"); 
		query.append("      , SIH.INV_NO                        AS INV_NO" ).append("\n"); 
		query.append("      , TO_CHAR(SID.ACCTG_DT, 'YYYYMMDD') AS GL_DT" ).append("\n"); 
		query.append("      , 'AP'                              AS UNSTL_SRC_CD" ).append("\n"); 
		query.append("      , 'PRE_INV_HDR'                     AS UNSTL_CATE_NM" ).append("\n"); 
		query.append("      , SIH.VNDR_NO                       AS VNDR_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM                AS VNDR_NM" ).append("\n"); 
		query.append("      , SIH.INV_NO                        AS STL_KEY_NO" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT2                    AS COA_RGN_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT3                    AS COA_CTR_CD" ).append("\n"); 
		query.append("      , SIH.OFC_CD                        AS OFC_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4                    AS COA_ACCT_CD" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD                   AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("      , SIH.INV_XCH_RT                    AS CONV_XCH_RT" ).append("\n"); 
		query.append("      , 0                                 AS INP_DR_AMT" ).append("\n"); 
		query.append("      , SID.DTRB_AMT * (-1)               AS INP_CR_AMT" ).append("\n"); 
		query.append("      , 0                                 AS ACCT_DR_AMT" ).append("\n"); 
		query.append("      , SID.DTRB_FUNC_AMT * (-1)          AS ACCT_CR_AMT" ).append("\n"); 
		query.append("      , SID.DTRB_AMT                      AS UNSTL_AMT" ).append("\n"); 
		query.append("      , TO_CHAR(SID.ACCTG_DT, 'YYYYMMDD') AS UNSTL_TJ_DT" ).append("\n"); 
		query.append("      , SID.DTRB_DESC                     AS UNSTL_DESC" ).append("\n"); 
		query.append("      , ''                                AS UNSTL_DL_NO" ).append("\n"); 
		query.append("      , ''                                AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("      , 'N'                               AS ACCT_STL_FLG" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT1" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT2" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT3" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT4" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT5" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT6" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT7" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT8" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT9" ).append("\n"); 
		query.append("      , ''                                AS ATTR_CTNT10" ).append("\n"); 
		query.append("      , @[usr_id]                         AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                           AS CRE_DT" ).append("\n"); 
		query.append("      , @[usr_id]                         AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                           AS UPD_DT" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_INV_DTL SID" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ " ).append("\n"); 
		query.append("AND     SIH.INV_SEQ = SID.INV_SEQ" ).append("\n"); 
		query.append("AND     SIH.LIAB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND     SID.DTRB_AMT <> 0" ).append("\n"); 
		query.append("AND     SID.LINE_TP_LU_CD = 'PREPAY'" ).append("\n"); 
		query.append("AND     NVL(SID.RVS_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("AND     SID.ACCTG_DT >= TO_DATE(REPLACE(@[unstl_yrmon],'-',''), 'YYYYMM')" ).append("\n"); 
		query.append("AND     SID.ACCTG_DT <  ADD_MONTHS(TO_DATE(REPLACE(@[unstl_yrmon],'-',''), 'YYYYMM'), 1)" ).append("\n"); 

	}
}