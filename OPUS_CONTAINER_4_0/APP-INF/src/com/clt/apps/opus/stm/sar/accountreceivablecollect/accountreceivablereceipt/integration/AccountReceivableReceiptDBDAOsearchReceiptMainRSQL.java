/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchReceiptMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
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

public class AccountReceivableReceiptDBDAOsearchReceiptMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receipt 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchReceiptMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchReceiptMainRSQL").append("\n"); 
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
		query.append("SELECT A.RCT_SEQ" ).append("\n"); 
		query.append("    , A.RCT_NO" ).append("\n"); 
		query.append("    , A.RCT_OFC_CD" ).append("\n"); 
		query.append("    , A.CHQ_NO" ).append("\n"); 
		query.append("    , A.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("	, B.BANK_ACCT_NM" ).append("\n"); 
		query.append("	, C.DP_PRCS_KNT" ).append("\n"); 
		query.append("    , A.RCT_DT" ).append("\n"); 
		query.append("    , A.RCT_DPS_DT" ).append("\n"); 
		query.append("    , A.MTRTY_DT" ).append("\n"); 
		query.append("    , A.RCT_TP_CD" ).append("\n"); 
		query.append("    , A.RCT_CURR_CD" ).append("\n"); 
		query.append("    , SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, A.RCT_AMT) RCT_AMT" ).append("\n"); 
		query.append("    , A.RCT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , LPAD(A.RCT_CUST_SEQ, 6, '0') RCT_CUST_SEQ" ).append("\n"); 
		query.append("    , A.RCT_RMK" ).append("\n"); 
		query.append("    , DECODE(A.BANK_CHG_AMT, '', '', SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, A.BANK_CHG_AMT)) BANK_CHG_AMT" ).append("\n"); 
		query.append("    , A.AGN_OFC_CD" ).append("\n"); 
		query.append("    , A.AGN_CD" ).append("\n"); 
		query.append("    , A.ASA_NO" ).append("\n"); 
		query.append("    , A.RCT_CXL_DT" ).append("\n"); 
		query.append("    , A.RCT_CXL_RSN_CD" ).append("\n"); 
		query.append("    , A.RCT_CXL_CATE_CD" ).append("\n"); 
		query.append("    , A.RCT_CXL_RMK" ).append("\n"); 
		query.append("    , A.RCT_PRN_FLG" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , A.CRE_DT" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , A.UPD_DT" ).append("\n"); 
		query.append("	, A.BAL_RCT_AMT" ).append("\n"); 
		query.append("	, A.RCT_STS_CD" ).append("\n"); 
		query.append("	, DECODE(A.RCT_STS_CD, 'UNID', SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, A.BAL_RCT_AMT), SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, '0')) UNID_AMT" ).append("\n"); 
		query.append("	, DECODE(A.RCT_STS_CD, 'UNAPP', SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, A.BAL_RCT_AMT), SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, '0')) UNAPP_AMT" ).append("\n"); 
		query.append("	, DECODE(A.RCT_STS_CD, 'APP', SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, A.RCT_AMT), 'UNAPP', SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, (A.RCT_AMT - A.BAL_RCT_AMT)), SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, '0')) APP_AMT" ).append("\n"); 
		query.append("	, DECODE(A.RCT_STS_CD, 'CXL', (SELECT LU_DESC" ).append("\n"); 
		query.append("       							   FROM SCO_LU_DTL" ).append("\n"); 
		query.append("       							   WHERE LU_TP_CD = 'RECEIPT CANCEL REASON'" ).append("\n"); 
		query.append("	   							   AND LU_CD = A.RCT_CXL_RSN_CD" ).append("\n"); 
		query.append("       							   AND ENBL_FLG = 'Y'), '') CXL_DESC" ).append("\n"); 
		query.append("	, IB_OB_CD BOUND_TYPE" ).append("\n"); 
		query.append("	, RCT_INV_TP_CD INVOICE_TYPE" ).append("\n"); 
		query.append("FROM SAR_RECEIPT A," ).append("\n"); 
		query.append("	 SAP_BANK_ACCT B," ).append("\n"); 
		query.append("	 MDM_CURRENCY C" ).append("\n"); 
		query.append("WHERE A.BANK_ACCT_SEQ = B.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("AND A.RCT_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("AND A.RCT_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("AND A.RCT_NO = @[rct_no]" ).append("\n"); 

	}
}