/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOHPEDISendVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.01.20 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOHPEDISendVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOHPEDISendVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOHPEDISendVORSQL").append("\n"); 
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
		query.append("SELECT '' Header" ).append("\n"); 
		query.append(", '' INV_TYPE" ).append("\n"); 
		query.append(", '' INV_NUM" ).append("\n"); 
		query.append(", '' BL_NUM" ).append("\n"); 
		query.append(", '' INV_PAY" ).append("\n"); 
		query.append(", '' INV_DATE" ).append("\n"); 
		query.append(", '' INV_AMT" ).append("\n"); 
		query.append(", '' FINAL_ETA" ).append("\n"); 
		query.append(", '' SCAC_CD" ).append("\n"); 
		query.append(", '' COR_IND" ).append("\n"); 
		query.append(", '' CGO_RCV_DT" ).append("\n"); 
		query.append(", '' TARIFF_SVC_CD" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", '' VSL_LLOYDCODE" ).append("\n"); 
		query.append(", '' CURRENCY_BILL_CD" ).append("\n"); 
		query.append(", '' REF_4G" ).append("\n"); 
		query.append(", '' REF_4L" ).append("\n"); 
		query.append(", '' REF_4M" ).append("\n"); 
		query.append(", '' REF_8X" ).append("\n"); 
		query.append(", '' REF_BM" ).append("\n"); 
		query.append(", '' REF_F2" ).append("\n"); 
		query.append(", '' REF_FR" ).append("\n"); 
		query.append(", '' REF_T2" ).append("\n"); 
		query.append(", '' REF_UJ" ).append("\n"); 
		query.append(", '' REF_VX" ).append("\n"); 
		query.append(", '' REF_8V" ).append("\n"); 
		query.append(", '' REF_VC" ).append("\n"); 
		query.append(", '' CUST_TP_CD" ).append("\n"); 
		query.append(", '' CUST_CD" ).append("\n"); 
		query.append(", '' CUST_NAME" ).append("\n"); 
		query.append(", '' CUST_NAME1" ).append("\n"); 
		query.append(", '' CUST_NAME2" ).append("\n"); 
		query.append(", '' CUST_ADDR" ).append("\n"); 
		query.append(", '' CUST_ADDR1" ).append("\n"); 
		query.append(", '' CUST_CITY" ).append("\n"); 
		query.append(", '' CUST_STATE" ).append("\n"); 
		query.append(", '' CUST_POSTAL" ).append("\n"); 
		query.append(", '' CUST_CNT_CD" ).append("\n"); 
		query.append(", '' LOC_TP_CD" ).append("\n"); 
		query.append(", '' LOC_CD" ).append("\n"); 
		query.append(", '' LOC_NAME" ).append("\n"); 
		query.append(", '' LOC_CNT_CD" ).append("\n"); 
		query.append(", '' LOC_CNT_NAME" ).append("\n"); 
		query.append(", '' CNTR_NO" ).append("\n"); 
		query.append(", '' CNTR_TYPE" ).append("\n"); 
		query.append(", '' CNTR_LOAD" ).append("\n"); 
		query.append(", '' CNTR_SEAL_NO" ).append("\n"); 
		query.append(", '' CNTR_SHIP_ID" ).append("\n"); 
		query.append(", '' CN_REF_PO" ).append("\n"); 
		query.append(", '' CN_REF_PT" ).append("\n"); 
		query.append(", '' CN_REF_SI" ).append("\n"); 
		query.append(", '' CM_PKG" ).append("\n"); 
		query.append(", '' CM_PKG_CD" ).append("\n"); 
		query.append(", '' CM_WGT" ).append("\n"); 
		query.append(", '' CM_WGT_CD" ).append("\n"); 
		query.append(", '' CM_MEA" ).append("\n"); 
		query.append(", '' CM_MEA_CD" ).append("\n"); 
		query.append(", '' CM_DESC" ).append("\n"); 
		query.append(", '' CH_FCTYPE" ).append("\n"); 
		query.append(", '' CH_RATE" ).append("\n"); 
		query.append(", '' CH_RATED_AS" ).append("\n"); 
		query.append(", '' CH_CHARGE" ).append("\n"); 
		query.append(", '' CH_PERTYPE" ).append("\n"); 
		query.append(", '' CH_CUR_CD" ).append("\n"); 
		query.append(", '' CH_BL_RATED_QTY" ).append("\n"); 
		query.append(", '' CH_BL_RATED_QUAL" ).append("\n"); 
		query.append(", '' CH_PERCENT" ).append("\n"); 
		query.append(", '' CH_FRT_IND" ).append("\n"); 
		query.append(", '' CH_BILL_CUR" ).append("\n"); 
		query.append(", '' CH_EX_RATE" ).append("\n"); 
		query.append(", '' VSL_BVVD1" ).append("\n"); 
		query.append(", '' VSL_LLOYDCODE" ).append("\n"); 
		query.append(", '' VSL_FULLNAME" ).append("\n"); 
		query.append(", '' VSL_ORIGIN" ).append("\n"); 
		query.append(", '' VSL_POR" ).append("\n"); 
		query.append(", '' VSL_POL" ).append("\n"); 
		query.append(", '' VSL_POL_FULLNAME" ).append("\n"); 
		query.append(", '' VSL_POD" ).append("\n"); 
		query.append(", '' VSL_DEL" ).append("\n"); 
		query.append(", '' VSL_POD_FULLNAME" ).append("\n"); 
		query.append(", '' VSL_POLETD" ).append("\n"); 
		query.append(", '' VSL_PODETD" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' MAX_IF_NO" ).append("\n"); 
		query.append(", '' AR_OFC_CD" ).append("\n"); 
		query.append(",  '' CH_RATE_CHARGE " ).append("\n"); 
		query.append(", '' CH_BILL_CHARGE" ).append("\n"); 
		query.append(", '' REF_ACB" ).append("\n"); 
		query.append(", '' TS_PRE" ).append("\n"); 
		query.append(", '' TS_POST" ).append("\n"); 
		query.append(", '' INCO_TERM" ).append("\n"); 
		query.append(", '' REF_V9_ORI" ).append("\n"); 
		query.append(", '' REF_V9_DES" ).append("\n"); 
		query.append(", '' CH_RATE_STRING" ).append("\n"); 
		query.append(", '' REF_PID " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}