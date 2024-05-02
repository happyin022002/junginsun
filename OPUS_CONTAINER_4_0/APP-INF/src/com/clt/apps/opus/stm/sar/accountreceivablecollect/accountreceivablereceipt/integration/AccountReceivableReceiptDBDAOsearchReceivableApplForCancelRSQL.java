/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchReceivableApplForCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
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

public class AccountReceivableReceiptDBDAOsearchReceivableApplForCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Application 에서 Cancel 대상 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchReceivableApplForCancelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchReceivableApplForCancelRSQL").append("\n"); 
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
		query.append("SELECT RCV_APPL_SEQ" ).append("\n"); 
		query.append("	, APLY_AMT * (-1) APLY_AMT" ).append("\n"); 
		query.append("	, APLY_FM_AMT * (-1) APLY_FM_AMT" ).append("\n"); 
		query.append("	, OTS_TO_RCT_XCH_RT" ).append("\n"); 
		query.append("	, GL_DT" ).append("\n"); 
		query.append("	, '-1' RCV_CD_CMB_SEQ" ).append("\n"); 
		query.append("	, '-1' LEGR_SEQ" ).append("\n"); 
		query.append("	, 'N' DP_FLG" ).append("\n"); 
		query.append("	, RCT_DT" ).append("\n"); 
		query.append("	, 'CANCEL' RCV_APPL_TP_CD" ).append("\n"); 
		query.append("	, RCV_APPL_STS_CD" ).append("\n"); 
		query.append("	, RCT_SEQ" ).append("\n"); 
		query.append("	, WRTF_TP_CD" ).append("\n"); 
		query.append("	, '-1' GL_TRNS_SEQ" ).append("\n"); 
		query.append("	, '' GL_TRNS_DT" ).append("\n"); 
		query.append("	, APLY_FM_ACCT_AMT * (-1) APLY_FM_ACCT_AMT" ).append("\n"); 
		query.append("	, APLY_TO_ACCT_AMT * (-1) APLY_TO_ACCT_AMT" ).append("\n"); 
		query.append("	, '-1' ORZ_SEQ" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, OTS_HIS_SEQ" ).append("\n"); 
		query.append("	, CHG_TP_CD" ).append("\n"); 
		query.append("	, RCT_DPS_DT" ).append("\n"); 
		query.append("	, RCT_APLY_DTL_SEQ" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("	, CONV_XCH_RT" ).append("\n"); 
		query.append("	, RCT_CXL_DT" ).append("\n"); 
		query.append("	, APLY_FM_RCV_APPL_SEQ" ).append("\n"); 
		query.append("	, RCT_TERM_DYS" ).append("\n"); 
		query.append("	, RCV_APPL_RMK" ).append("\n"); 
		query.append("	, AP_RMK" ).append("\n"); 
		query.append("FROM SAR_RCV_APPL" ).append("\n"); 
		query.append("WHERE RCT_SEQ = @[rct_seq]" ).append("\n"); 
		query.append("AND RCV_APPL_TP_CD = 'RECEIPT'" ).append("\n"); 
		query.append("ORDER BY RCV_APPL_SEQ" ).append("\n"); 

	}
}