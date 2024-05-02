/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAPAccountingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAPAccountingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPAccountingList
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAPAccountingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_evnt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("functional_currency",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAPAccountingListRSQL").append("\n"); 
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
		query.append("SELECT  SAE.ACCTG_EVNT_TP_CD                AS ACCTG_EVNT_TP_CD" ).append("\n"); 
		query.append("      , SAEH.ACCTG_EVNT_CATE_CD             AS ACCTG_EVNT_CATE_CD" ).append("\n"); 
		query.append("      , SAED.ACCTG_LINE_TP_CD               AS ACCTG_LINE_TP_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SAEH.ACCTG_DT,'YYYY-MM-DD') AS ACCTG_DT" ).append("\n"); 
		query.append("      , SAED.ACCTG_EVNT_LINE_NO             AS ACCTG_EVNT_LINE_NO" ).append("\n"); 
		query.append("      , SAED.CURR_CD                        AS CURR_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT1                      AS COA_CO_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT2                      AS COA_RGN_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT3                      AS COA_CTR_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4                      AS COA_ACCT_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT5                      AS COA_INTER_CO_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT6                      AS COA_VVD_CD" ).append("\n"); 
		query.append("      , SAED.INP_DR_AMT                     AS INP_DR_AMT" ).append("\n"); 
		query.append("      , DECODE(SAED.INP_DR_AMT, NULL, NULL, SAP_GET_CUR_AMT_FNC(SAED.CURR_CD, SAED.INP_DR_AMT)) AS C_INP_DR_AMT" ).append("\n"); 
		query.append("      , SAED.INP_CR_AMT                     AS INP_CR_AMT" ).append("\n"); 
		query.append("      , DECODE(SAED.INP_CR_AMT, NULL, NULL, SAP_GET_CUR_AMT_FNC(SAED.CURR_CD, SAED.INP_CR_AMT)) AS C_INP_CR_AMT" ).append("\n"); 
		query.append("      , SAED.ACCT_DR_AMT                    AS ACCT_DR_AMT" ).append("\n"); 
		query.append("      , DECODE(SAED.ACCT_DR_AMT, NULL, NULL, SAP_GET_CUR_AMT_FNC(@[functional_currency], SAED.ACCT_DR_AMT)) AS C_ACCT_DR_AMT" ).append("\n"); 
		query.append("      , SAED.ACCT_CR_AMT                    AS ACCT_CR_AMT" ).append("\n"); 
		query.append("      , DECODE(SAED.ACCT_CR_AMT, NULL, NULL, SAP_GET_CUR_AMT_FNC(@[functional_currency], SAED.ACCT_CR_AMT)) AS C_ACCT_CR_AMT" ).append("\n"); 
		query.append("      , SAED.CONV_XCH_RT                    AS CONV_XCH_RT" ).append("\n"); 
		query.append("      , SAED.ACCTG_DESC                     AS ACCTG_DESC" ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT5                     AS ATTR_CTNT5" ).append("\n"); 
		query.append("      , SAEH.ACCTG_ERR_CD                   AS ACCTG_ERR_CD" ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT1                     AS ATTR_CTNT1  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT2                     AS ATTR_CTNT2  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT3                     AS ATTR_CTNT3  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT4                     AS ATTR_CTNT4  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT6                     AS ATTR_CTNT6  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT7                     AS ATTR_CTNT7  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT8                     AS ATTR_CTNT8  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT9                     AS ATTR_CTNT9  " ).append("\n"); 
		query.append("      , SAED.ATTR_CTNT10                    AS ATTR_CTNT10 " ).append("\n"); 
		query.append("      , SAE.ACCTG_EVNT_SEQ                  AS ACCTG_EVNT_SEQ  " ).append("\n"); 
		query.append("      , SAEH.ACCTG_HDR_SEQ                  AS ACCTG_HDR_SEQ  " ).append("\n"); 
		query.append("FROM    SAP_ACCTG_EVNT SAE" ).append("\n"); 
		query.append("      , SAP_ACCTG_EVNT_HDR SAEH" ).append("\n"); 
		query.append("      , SAP_ACCTG_EVNT_DTL SAED" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SAE.ACCTG_EVNT_SEQ = SAEH.ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("AND     SAEH.ACCTG_HDR_SEQ = SAED.ACCTG_HDR_SEQ" ).append("\n"); 
		query.append("AND     SAED.ACCT_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND     SAE.ACCTG_DT >= TO_DATE(REPLACE(@[acctg_fr_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND     SAE.ACCTG_DT <  TO_DATE(REPLACE(@[acctg_to_dt],'-',''),'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#if (${acctg_evnt_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND  SAE.ACCTG_EVNT_TP_CD = @[acctg_evnt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("   AND  SAED.ATTR_CTNT5 = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 35,1,2,5,4" ).append("\n"); 

	}
}