/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.27 
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

public class AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceDetailRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceDetailRSQL").append("\n"); 
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
		query.append("SELECT  SIDI.INV_IF_LINE_SEQ      AS INV_IF_LINE_SEQ" ).append("\n"); 
		query.append("     , SIDI.INV_IF_SEQ           AS INV_IF_SEQ" ).append("\n"); 
		query.append("     , SIDI.INV_LINE_NO          AS INV_LINE_NO" ).append("\n"); 
		query.append("     , SIDI.LINE_TP_LU_CD        AS LINE_TP_LU_CD" ).append("\n"); 
		query.append("     , (SELECT SUM(SIDI2.DTRB_AMT) FROM SAP_INV_DTL_IF SIDI2 WHERE SIDI2.INV_NO = SIDI.INV_NO) AS DTRB_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(SIDI.ACCTG_DT,'YYYYMMDD')             AS ACCTG_DT" ).append("\n"); 
		query.append("     , SIDI.DTRB_DESC            AS DTRB_DESC" ).append("\n"); 
		query.append("     , SIDI.DTRB_VAT_CD          AS DTRB_VAT_CD" ).append("\n"); 
		query.append("     , SIDI.FNL_MTCH_STS_CD      AS FNL_MTCH_STS_CD" ).append("\n"); 
		query.append("     , SIDI.DTRB_SET_NM          AS DTRB_SET_NM" ).append("\n"); 
		query.append("     , SIDI.DTRB_COA_CO_CD       AS DTRB_COA_CO_CD" ).append("\n"); 
		query.append("     , SIDI.DTRB_COA_RGN_CD      AS DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("     , SIDI.DTRB_COA_CTR_CD      AS DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("     , SIDI.DTRB_COA_ACCT_NO     AS DTRB_COA_ACCT_NO" ).append("\n"); 
		query.append("     , SIDI.DTRB_COA_VVD_CD      AS DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("     , SIDI.DTRB_COA_INTER_CO_CD AS DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("     , SIDI.ATTR_CATE_NM         AS ATTR_CATE_NM" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT1           AS ATTR_CTNT1" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT2           AS ATTR_CTNT2" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT3           AS ATTR_CTNT3" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT4           AS ATTR_CTNT4" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT5           AS ATTR_CTNT5" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT6           AS ATTR_CTNT6" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT7           AS ATTR_CTNT7" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT8           AS ATTR_CTNT8" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT9           AS ATTR_CTNT9" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT10          AS ATTR_CTNT10" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT11          AS ATTR_CTNT11" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT12          AS ATTR_CTNT12" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT13          AS ATTR_CTNT13" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT14          AS ATTR_CTNT14" ).append("\n"); 
		query.append("     , SIDI.ATTR_CTNT15          AS ATTR_CTNT15" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CATE_NM     AS GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT1       AS GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT2       AS GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT3       AS GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT4       AS GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT5       AS GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT6       AS GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT7       AS GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT8       AS GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT9       AS GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT10      AS GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT11      AS GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT12      AS GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT13      AS GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT14      AS GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT15      AS GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT16      AS GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT17      AS GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT18      AS GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT19      AS GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("     , SIDI.GLO_ATTR_CTNT20      AS GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("     , SIDI.IF_SRC_NM            AS IF_SRC_NM" ).append("\n"); 
		query.append("     , SIDI.OFC_CD               AS OFC_CD" ).append("\n"); 
		query.append("     , SIDI.DTRB_CD_CMB_SEQ      AS DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("     , SIDI.DTRB_COA_CO_CD || SIDI.DTRB_COA_RGN_CD || SIDI.DTRB_COA_CTR_CD || SIDI.DTRB_COA_ACCT_NO || SIDI.DTRB_COA_VVD_CD || SIDI.DTRB_COA_INTER_CO_CD AS DTRB_CD_COMBINATIONS" ).append("\n"); 
		query.append("FROM    SAP_INV_DTL_IF SIDI" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SIDI.INV_NO = @[csr_no]" ).append("\n"); 
		query.append("AND     SIDI.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ(+)" ).append("\n"); 
		query.append("AND     NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y'" ).append("\n"); 

	}
}