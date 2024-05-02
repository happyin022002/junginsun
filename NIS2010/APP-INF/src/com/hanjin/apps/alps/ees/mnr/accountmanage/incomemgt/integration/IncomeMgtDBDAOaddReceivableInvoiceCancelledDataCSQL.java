/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IncomeMgtDBDAOaddReceivableInvoiceCancelledDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.21 신혜정 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 신혜정
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOaddReceivableInvoiceCancelledDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOaddReceivableInvoiceCancelledDataCSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOaddReceivableInvoiceCancelledDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOaddReceivableInvoiceCancelledDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_CXL_RCV_INV_WRK(" ).append("\n"); 
		query.append("	RCV_INV_SEQ" ).append("\n"); 
		query.append("	, CXL_INV_SEQ  " ).append("\n"); 
		query.append("	, MNR_GRP_TP_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_TP_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_SEQ" ).append("\n"); 
		query.append("	, INV_NO" ).append("\n"); 
		query.append("	, MNR_INV_REF_NO" ).append("\n"); 
		query.append("	, MNR_INV_STS_CD" ).append("\n"); 
		query.append("	, CFM_DT" ).append("\n"); 
		query.append("	, CXL_USR_ID " ).append("\n"); 
		query.append("	, CXL_DT      " ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, BZC_AMT" ).append("\n"); 
		query.append("	, VAT_AMT" ).append("\n"); 
		query.append("	, VAT_XCH_RT" ).append("\n"); 
		query.append("	, WHLD_TAX_AMT" ).append("\n"); 
		query.append("	, TTL_AMT" ).append("\n"); 
		query.append("	, INV_XCH_RT" ).append("\n"); 
		query.append("	, INV_PAY_MZD_CD" ).append("\n"); 
		query.append("	, CHK_TRNS_NO" ).append("\n"); 
		query.append("	, GL_DT" ).append("\n"); 
		query.append("	, ISS_DT" ).append("\n"); 
		query.append("	, ISS_OFC_CD" ).append("\n"); 
		query.append("	, INV_DUE_DT" ).append("\n"); 
		query.append("	, BANK_NM" ).append("\n"); 
		query.append("	, BANK_ACCT_NO" ).append("\n"); 
		query.append("	, MNR_SWIFT_NO" ).append("\n"); 
		query.append("	, MNR_BIL_TO_NM" ).append("\n"); 
		query.append("	, MNR_INV_RMK" ).append("\n"); 
		query.append("	, CLT_STL_FLG" ).append("\n"); 
		query.append("	, CHG_CURR_CD" ).append("\n"); 
		query.append("	, CHG_XCH_RT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	RCV_INV_SEQ" ).append("\n"); 
		query.append("	, (SELECT NVL(MAX(CXL_INV_SEQ), 0)+1 " ).append("\n"); 
		query.append("		FROM MNR_CXL_RCV_INV_WRK" ).append("\n"); 
		query.append("		WHERE RCV_INV_SEQ = @[rcv_inv_seq])" ).append("\n"); 
		query.append("	, MNR_GRP_TP_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_TP_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_SEQ" ).append("\n"); 
		query.append("	, INV_NO" ).append("\n"); 
		query.append("	, MNR_INV_REF_NO" ).append("\n"); 
		query.append("	, MNR_INV_STS_CD" ).append("\n"); 
		query.append("	, CFM_DT" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE      " ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, BZC_AMT" ).append("\n"); 
		query.append("	, VAT_AMT" ).append("\n"); 
		query.append("	, VAT_XCH_RT" ).append("\n"); 
		query.append("	, WHLD_TAX_AMT" ).append("\n"); 
		query.append("	, TTL_AMT" ).append("\n"); 
		query.append("	, INV_XCH_RT" ).append("\n"); 
		query.append("	, INV_PAY_MZD_CD" ).append("\n"); 
		query.append("	, CHK_TRNS_NO" ).append("\n"); 
		query.append("	, GL_DT" ).append("\n"); 
		query.append("	, ISS_DT" ).append("\n"); 
		query.append("	, ISS_OFC_CD" ).append("\n"); 
		query.append("	, INV_DUE_DT" ).append("\n"); 
		query.append("	, BANK_NM" ).append("\n"); 
		query.append("	, BANK_ACCT_NO" ).append("\n"); 
		query.append("	, MNR_SWIFT_NO" ).append("\n"); 
		query.append("	, MNR_BIL_TO_NM" ).append("\n"); 
		query.append("	, MNR_INV_RMK" ).append("\n"); 
		query.append("	, CLT_STL_FLG" ).append("\n"); 
		query.append("	, CHG_CURR_CD" ).append("\n"); 
		query.append("	, CHG_XCH_RT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK" ).append("\n"); 
		query.append("WHERE RCV_INV_SEQ = @[rcv_inv_seq] " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}