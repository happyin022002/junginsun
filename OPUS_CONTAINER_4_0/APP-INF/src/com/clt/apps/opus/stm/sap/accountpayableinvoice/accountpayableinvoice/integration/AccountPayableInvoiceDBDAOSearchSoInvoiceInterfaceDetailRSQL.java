/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchSoInvoiceInterfaceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.15
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.15 차상영
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

public class AccountPayableInvoiceDBDAOSearchSoInvoiceInterfaceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchSoInvoiceInterfaceDetailRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchSoInvoiceInterfaceDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_request_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchSoInvoiceInterfaceDetailRSQL").append("\n"); 
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
		query.append("SELECT  ''                            AS INV_IF_LINE_SEQ" ).append("\n"); 
		query.append("     , @[if_request_seq]             AS INV_IF_SEQ" ).append("\n"); 
		query.append("     , AID.LINE_NO                   AS INV_LINE_NO" ).append("\n"); 
		query.append("     , MAX(AID.LINE_TP_LU_CD)        AS LINE_TP_LU_CD" ).append("\n"); 
		query.append("     , SUM(AID.INV_AMT)              AS DTRB_AMT" ).append("\n"); 
		query.append("     , MAX((SELECT AIH2.GL_DT FROM AP_INV_HDR AIH2 WHERE AIH2.CSR_NO = @[csr_no])) AS ACCTG_DT" ).append("\n"); 
		query.append("     , MAX(AID.INV_DESC)             AS DTRB_DESC" ).append("\n"); 
		query.append("     , MAX(AID.INV_TAX_CD)           AS DTRB_VAT_CD" ).append("\n"); 
		query.append("     , ''                            AS FNL_MTCH_STS_CD" ).append("\n"); 
		query.append("     , ''                            AS DTRB_SET_NM" ).append("\n"); 
		query.append("     , MAX(AID.DTRB_COA_CO_CD)       AS DTRB_COA_CO_CD" ).append("\n"); 
		query.append("     , MAX(AID.DTRB_COA_RGN_CD)      AS DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("     , MAX(AID.DTRB_COA_CTR_CD)      AS DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("     , MAX(AID.DTRB_COA_ACCT_CD)     AS DTRB_COA_ACCT_NO" ).append("\n"); 
		query.append("     , MAX(AID.DTRB_COA_VVD_CD)      AS DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("     , MAX(AID.DTRB_COA_INTER_CO_CD) AS DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CATE_NM)         AS ATTR_CATE_NM" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT1)           AS ATTR_CTNT1" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT2)           AS ATTR_CTNT2" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT3)           AS ATTR_CTNT3" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT4)           AS ATTR_CTNT4" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT5)           AS ATTR_CTNT5" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT6)           AS ATTR_CTNT6" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT7)           AS ATTR_CTNT7" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT8)           AS ATTR_CTNT8" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT9)           AS ATTR_CTNT9" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT10)          AS ATTR_CTNT10" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT11)          AS ATTR_CTNT11" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT12)          AS ATTR_CTNT12" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT13)          AS ATTR_CTNT13" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT14)          AS ATTR_CTNT14" ).append("\n"); 
		query.append("     , MAX(AID.ATTR_CTNT15)          AS ATTR_CTNT15" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("     , ''                            AS GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("     , ''                            AS IF_SRC_NM" ).append("\n"); 
		query.append("     , ''                            AS OFC_CD" ).append("\n"); 
		query.append("     , ''                            AS DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("     , AID.DTRB_COA_CO_CD || AID.DTRB_COA_RGN_CD || AID.DTRB_COA_CTR_CD || AID.DTRB_COA_ACCT_CD || AID.DTRB_COA_VVD_CD || AID.DTRB_COA_INTER_CO_CD AS DTRB_CD_COMBINATIONS" ).append("\n"); 
		query.append("FROM    AP_INV_DTRB AID" ).append("\n"); 
		query.append("WHERE   AID.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("GROUP   BY AID.LINE_NO, AID.DTRB_COA_CO_CD || AID.DTRB_COA_RGN_CD || AID.DTRB_COA_CTR_CD || AID.DTRB_COA_ACCT_CD || AID.DTRB_COA_VVD_CD || AID.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("ORDER   BY AID.LINE_NO" ).append("\n"); 

	}
}