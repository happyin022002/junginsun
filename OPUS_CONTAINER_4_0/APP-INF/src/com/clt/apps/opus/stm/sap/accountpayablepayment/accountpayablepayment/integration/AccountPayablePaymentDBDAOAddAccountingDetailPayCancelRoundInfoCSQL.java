/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddAccountingDetailPayCancelRoundInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.02 
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

public class AccountPayablePaymentDBDAOAddAccountingDetailPayCancelRoundInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAccountingDetailPayCancelRoundInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddAccountingDetailPayCancelRoundInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounted_round_dr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("accounting_header_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounted_round_cr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounting_line_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddAccountingDetailPayCancelRoundInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_ACCTG_EVNT_DTL " ).append("\n"); 
		query.append(" ( ACCTG_LINE_SEQ" ).append("\n"); 
		query.append(" , ACCTG_HDR_SEQ" ).append("\n"); 
		query.append(" , ACCTG_EVNT_LINE_NO" ).append("\n"); 
		query.append(" , ACCTG_LINE_TP_CD" ).append("\n"); 
		query.append(" , CURR_CD" ).append("\n"); 
		query.append(" , CONV_XCH_RT" ).append("\n"); 
		query.append(" , CONV_XCH_RT_TP_CD" ).append("\n"); 
		query.append(" , CONV_XCH_DT" ).append("\n"); 
		query.append(" , INP_DR_AMT" ).append("\n"); 
		query.append(" , INP_CR_AMT" ).append("\n"); 
		query.append(" , ACCT_DR_AMT" ).append("\n"); 
		query.append(" , ACCT_CR_AMT" ).append("\n"); 
		query.append(" , ACCTG_SRC_TBL_NM" ).append("\n"); 
		query.append(" , ACCTG_SRC_SEQ" ).append("\n"); 
		query.append(" , GL_SUB_LEGR_LNK_SEQ" ).append("\n"); 
		query.append(" , ACCTG_DESC" ).append("\n"); 
		query.append(" , ACCTG_ERR_CD" ).append("\n"); 
		query.append(" , GL_TRNS_ERR_CD" ).append("\n"); 
		query.append(" , N3PTY_NO" ).append("\n"); 
		query.append(" , N3PTY_SUB_NO" ).append("\n"); 
		query.append(" , SUB_LEGR_DOC_SEQ" ).append("\n"); 
		query.append(" , ACCTG_PGM_APPL_NM" ).append("\n"); 
		query.append(" , OFC_CD" ).append("\n"); 
		query.append(" , ATTR_CTNT1" ).append("\n"); 
		query.append(" , ATTR_CTNT2" ).append("\n"); 
		query.append(" , ATTR_CTNT3" ).append("\n"); 
		query.append(" , ATTR_CTNT4" ).append("\n"); 
		query.append(" , ATTR_CTNT5" ).append("\n"); 
		query.append(" , ATTR_CTNT6" ).append("\n"); 
		query.append(" , ATTR_CTNT7" ).append("\n"); 
		query.append(" , ATTR_CTNT8" ).append("\n"); 
		query.append(" , ATTR_CTNT9" ).append("\n"); 
		query.append(" , ATTR_CTNT10" ).append("\n"); 
		query.append(" , END_PRN_DOC_NO" ).append("\n"); 
		query.append(" , ACCTG_VAT_CD" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(" , ACCT_CD_CMB_SEQ" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("     SAP_ACCTG_EVNT_DTL_SEQ.NEXTVAL   AS ACCTG_LINE_SEQ" ).append("\n"); 
		query.append("	,ACCTG_HDR_SEQ" ).append("\n"); 
		query.append("	,ACCTG_EVNT_LINE_NO" ).append("\n"); 
		query.append("	,ACCTG_LINE_TP_CD" ).append("\n"); 
		query.append("	,CURR_CD" ).append("\n"); 
		query.append("	,CONV_XCH_RT" ).append("\n"); 
		query.append("	,CONV_XCH_RT_TP_CD" ).append("\n"); 
		query.append("	,CONV_XCH_DT" ).append("\n"); 
		query.append("	,INP_DR_AMT" ).append("\n"); 
		query.append("	,INP_CR_AMT" ).append("\n"); 
		query.append("	,ACCT_DR_AMT" ).append("\n"); 
		query.append("	,ACCT_CR_AMT" ).append("\n"); 
		query.append("	,ACCTG_SRC_TBL_NM" ).append("\n"); 
		query.append("	,ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("	,GL_SUB_LEGR_LNK_SEQ" ).append("\n"); 
		query.append("	,ACCTG_DESC" ).append("\n"); 
		query.append("	,ACCTG_ERR_CD" ).append("\n"); 
		query.append("	,GL_TRNS_ERR_CD" ).append("\n"); 
		query.append("	,N3PTY_NO" ).append("\n"); 
		query.append("	,N3PTY_SUB_NO" ).append("\n"); 
		query.append("	,SUB_LEGR_DOC_SEQ" ).append("\n"); 
		query.append("	,ACCTG_PGM_APPL_NM" ).append("\n"); 
		query.append("	,OFC_CD" ).append("\n"); 
		query.append("	,ATTR_CTNT1" ).append("\n"); 
		query.append("	,ATTR_CTNT2" ).append("\n"); 
		query.append("	,ATTR_CTNT3" ).append("\n"); 
		query.append("	,ATTR_CTNT4" ).append("\n"); 
		query.append("	,ATTR_CTNT5" ).append("\n"); 
		query.append("	,ATTR_CTNT6" ).append("\n"); 
		query.append("	,ATTR_CTNT7" ).append("\n"); 
		query.append("	,ATTR_CTNT8" ).append("\n"); 
		query.append("	,ATTR_CTNT9" ).append("\n"); 
		query.append("	,ATTR_CTNT10" ).append("\n"); 
		query.append("	,END_PRN_DOC_NO" ).append("\n"); 
		query.append("	,ACCTG_VAT_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,ACCT_CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append(" SELECT  @[accounting_header_id]          AS ACCTG_HDR_SEQ" ).append("\n"); 
		query.append("       , @[accounting_line_no]            AS ACCTG_EVNT_LINE_NO" ).append("\n"); 
		query.append("       , 'ROUNDING'                       AS ACCTG_LINE_TP_CD" ).append("\n"); 
		query.append("       , SPH.CURR_CD                      AS CURR_CD" ).append("\n"); 
		query.append("       , SPH.PAY_XCH_RT                   AS CONV_XCH_RT" ).append("\n"); 
		query.append("       , SPH.XCH_RT_TP_CD                 AS CONV_XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , TO_DATE(SPH.PAY_XCH_DT,'YYYYMMDD') AS CONV_XCH_DT" ).append("\n"); 
		query.append("       , DECODE(@[accounted_round_dr], NULL, NULL, 0) AS INP_DR_AMT" ).append("\n"); 
		query.append("       , DECODE(@[accounted_round_cr], NULL, NULL, 0) AS INP_CR_AMT" ).append("\n"); 
		query.append("       , DECODE(@[accounted_round_dr], NULL, NULL, @[accounted_round_dr]) AS ACCT_DR_AMT" ).append("\n"); 
		query.append("       , DECODE(@[accounted_round_cr], NULL, NULL, @[accounted_round_cr]) AS ACCT_CR_AMT" ).append("\n"); 
		query.append("       , 'SAP_PAY_DTL'                    AS ACCTG_SRC_TBL_NM" ).append("\n"); 
		query.append("       , SPH.PAY_SEQ                      AS ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("       , ''                               AS GL_SUB_LEGR_LNK_SEQ" ).append("\n"); 
		query.append("       , SPH.PAY_DESC                     AS ACCTG_DESC" ).append("\n"); 
		query.append("       , ''                               AS ACCTG_ERR_CD" ).append("\n"); 
		query.append("       , ''                               AS GL_TRNS_ERR_CD" ).append("\n"); 
		query.append("       , SPH.VNDR_NO                      AS N3PTY_NO" ).append("\n"); 
		query.append("       , ''                               AS N3PTY_SUB_NO" ).append("\n"); 
		query.append("       , ''                               AS SUB_LEGR_DOC_SEQ" ).append("\n"); 
		query.append("       , 'AP'                             AS ACCTG_PGM_APPL_NM" ).append("\n"); 
		query.append("       , SPH.OFC_CD                       AS OFC_CD" ).append("\n"); 
		query.append("       , MV.VNDR_LGL_ENG_NM               AS ATTR_CTNT1" ).append("\n"); 
		query.append("       , ''                               AS ATTR_CTNT2" ).append("\n"); 
		query.append("       , TO_CHAR(SPH.PAY_SEQ)             AS ATTR_CTNT3" ).append("\n"); 
		query.append("       , SPH.DOC_SEQ                      AS ATTR_CTNT4" ).append("\n"); 
		query.append("       , SPH.DOC_SEQ                      AS ATTR_CTNT5" ).append("\n"); 
		query.append("       , 'AP Payments'                    AS ATTR_CTNT6" ).append("\n"); 
		query.append("       , ''                               AS ATTR_CTNT7" ).append("\n"); 
		query.append("       , ''                               AS ATTR_CTNT8" ).append("\n"); 
		query.append("       , ''                               AS ATTR_CTNT9" ).append("\n"); 
		query.append("       , 'ROUNDING'                       AS ATTR_CTNT10" ).append("\n"); 
		query.append("       , ''                               AS END_PRN_DOC_NO" ).append("\n"); 
		query.append("       , ''                               AS ACCTG_VAT_CD" ).append("\n"); 
		query.append("       , @[usr_id]                        AS CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE                          AS CRE_DT" ).append("\n"); 
		query.append("       , @[usr_id]                        AS UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE                          AS UPD_DT" ).append("\n"); 
		query.append("       , @[coa_seq]                 AS ACCT_CD_CMB_SEQ" ).append("\n"); 
		query.append(" FROM    MDM_VENDOR MV" ).append("\n"); 
		query.append("       , SAP_PAY_HDR SPH" ).append("\n"); 
		query.append(" WHERE   TO_NUMBER(SPH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append(" AND     SPH.PAY_SEQ = @[pay_seq]" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}