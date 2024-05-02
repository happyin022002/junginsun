/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAPIFPaymentProcessListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
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

public class AccountPayablePaymentDBDAOSearchAPIFPaymentProcessListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPIFPaymentProcessList
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAPIFPaymentProcessListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAPIFPaymentProcessListRSQL").append("\n"); 
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
		query.append("SELECT  SAPI.REF_DOC_NO      AS CSR_NO   " ).append("\n"); 
		query.append("      , SAPI.PAY_REF_CD      AS VENDOR_INV_NO" ).append("\n"); 
		query.append("      , SAPI.PAY_DT          AS PAY_DT" ).append("\n"); 
		query.append("      , SAPI.PAY_STS_IF_SEQ  AS PAY_IF_SEQ" ).append("\n"); 
		query.append("	  , (   SELECT  SLD.lU_CD		 " ).append("\n"); 
		query.append("		    FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("		          , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("		    WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("		    AND     SLH.LU_TP_CD = 'FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("		    AND     SLH.LU_APPL_CD = 'SCO'" ).append("\n"); 
		query.append("		    AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("		    AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("		    AND     ROWNUM = 1 ) AS FUNCTIONAL_CURRENCY" ).append("\n"); 
		query.append("      ,'' AS DAT_RSLT_FLG" ).append("\n"); 
		query.append("FROM    SAP_AP_PAY_IF SAPI" ).append("\n"); 
		query.append("WHERE   NVL(SAPI.DAT_PROC_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}