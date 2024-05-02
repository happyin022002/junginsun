/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByIFNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByIFNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceCorrectionDBDAO::searchARInvoiceChargeByIFNo ( ifNo )
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByIFNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByIFNoVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.MF_DIV_CD MF_DIV_CD" ).append("\n"); 
		query.append(",	A.CHG_CD CHG_CD" ).append("\n"); 
		query.append(",	A.CURR_CD CURR_CD" ).append("\n"); 
		query.append(",	A.PER_TP_CD PER_TP_CD" ).append("\n"); 
		query.append(",	SAR_GET_CUR_AMT_FNC(A.CURR_CD,A.TRF_RT_AMT) TRF_RT_AMT" ).append("\n"); 
		query.append(",	A.RAT_AS_CNTR_QTY RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(",	SAR_GET_CUR_AMT_FNC(A.CURR_CD,A.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append(",	A.INV_XCH_RT INV_XCH_RT" ).append("\n"); 
		query.append(",	SAR_GET_CUR_AMT_FNC(C.LOCL_CURR_CD,A.CHG_AMT*A.INV_XCH_RT)  LCL_AMOUNT" ).append("\n"); 
		query.append(",   A.AR_IF_SER_NO AR_IF_SER_NO" ).append("\n"); 
		query.append(",   A.CHG_SEQ CHG_SEQ" ).append("\n"); 
		query.append(",	'' TOTAL_AMT" ).append("\n"); 
		query.append(",	C.LOCL_CURR_CD LCL_CURR_CD" ).append("\n"); 
		query.append(",	D.TJ_SRC_NM" ).append("\n"); 
		query.append(", 	A.INV_XCH_RT_DT" ).append("\n"); 
		query.append(",	A.REP_CHG_CD" ).append("\n"); 
		query.append(",	A.CHG_FULL_NM" ).append("\n"); 
		query.append(",	A.TRF_NO" ).append("\n"); 
		query.append(",	A.SOB_ID" ).append("\n"); 
		query.append(",	A.INV_REV_TP_SRC_CD" ).append("\n"); 
		query.append(",	A.REV_COA_CO_CD" ).append("\n"); 
		query.append(",	A.REV_COA_RGN_CD" ).append("\n"); 
		query.append(",	A.REV_COA_CTR_CD" ).append("\n"); 
		query.append(",	A.REV_COA_ACCT_CD" ).append("\n"); 
		query.append(",	A.REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	A.REV_COA_VSL_CD" ).append("\n"); 
		query.append(",	A.REV_COA_VOY_NO" ).append("\n"); 
		query.append(",	A.REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append(",	A.REV_COA_DIR_CD" ).append("\n"); 
		query.append(",	A.ACCT_CD" ).append("\n"); 
		query.append(",	A.TVA_FLG" ).append("\n"); 
		query.append(",	A.CHG_RMK" ).append("\n"); 
		query.append(",	A.MNL_FLG" ).append("\n"); 
		query.append(",   E.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM INV_AR_CHG A,MDM_CURRENCY B,INV_AR_MN C, INV_AR_AMT D,MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE	A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("AND C.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND A.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("AND A.AR_IF_SER_NO = D.AR_IF_SER_NO" ).append("\n"); 
		query.append("AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("ORDER BY CURR_CD,A.AR_IF_NO,A.AR_IF_SER_NO,A.CHG_SEQ" ).append("\n"); 

	}
}