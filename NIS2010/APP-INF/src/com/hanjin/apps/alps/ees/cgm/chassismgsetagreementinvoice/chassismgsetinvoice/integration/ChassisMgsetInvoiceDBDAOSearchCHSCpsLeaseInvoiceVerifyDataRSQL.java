/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSCpsLeaseInvoiceVerifyDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSCpsLeaseInvoiceVerifyDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSCpsLeaseInvoiceVerifyDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSCpsLeaseInvoiceVerifyDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("/*+  USE_NL( A B D)   */" ).append("\n"); 
		query.append("A.EQ_KND_CD" ).append("\n"); 
		query.append(",A.COST_YRMON" ).append("\n"); 
		query.append(",A.EQ_NO" ).append("\n"); 
		query.append(",A.CHG_CRE_SEQ" ).append("\n"); 
		query.append(",A.INV_CUST_EQ_NO" ).append("\n"); 
		query.append(",A.INV_EQ_NO" ).append("\n"); 
		query.append(",A.INV_REF_NO" ).append("\n"); 
		query.append(",A.INV_NO" ).append("\n"); 
		query.append(",A.INV_CHG_TP_NM" ).append("\n"); 
		query.append(",A.CHG_CD" ).append("\n"); 
		query.append(",A.INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.INV_EQ_ONH_DT, 'YYYY-MM-DD') AS INV_EQ_ONH_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.INV_BIL_ST_DT, 'YYYY-MM-DD') AS INV_BIL_ST_DT" ).append("\n"); 
		query.append(",A.INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.INV_EQ_OFFH_DT, 'YYYY-MM-DD') AS INV_EQ_OFFH_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.INV_BIL_END_DT, 'YYYY-MM-DD') AS INV_BIL_END_DT" ).append("\n"); 
		query.append(",A.INV_LSE_USE_DYS" ).append("\n"); 
		query.append(",A.INV_LSE_RT_AMT" ).append("\n"); 
		query.append(",A.INV_LSE_CHG_AMT" ).append("\n"); 
		query.append(",A.INV_TAX_AMT" ).append("\n"); 
		query.append(",A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.AGMT_SEQ" ).append("\n"); 
		query.append(",A.AGMT_VER_NO" ).append("\n"); 
		query.append(",A.AGMT_LSTM_CD" ).append("\n"); 
		query.append(",A.COST_CD" ).append("\n"); 
		query.append(",A.ACCT_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.INV_BKG_NO" ).append("\n"); 
		query.append(",A.PAY_LSE_USE_DYS" ).append("\n"); 
		query.append(",A.VRFY_SCS_FLG" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY A.AGMT_OFC_CTY_CD,A.AGMT_SEQ,A.AGMT_VER_NO,A.COST_YRMON,A.EQ_NO,CHG_CD ORDER BY INV_BIL_ST_DT,INV_LSE_RT_AMT) INV_SEQ" ).append("\n"); 
		query.append("FROM CGM_LSE_INV_TMP A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 

	}
}