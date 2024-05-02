/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAClearingAccountCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAClearingAccountCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO Interface 처리시 Lookup에 등록된 ASA Clearing Account 을 가져와 Validate 하기 위한 기준 정보
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAClearingAccountCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAClearingAccountCheckRSQL").append("\n"); 
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
		query.append("SELECT  SLD.lU_CD AS ASA_CLEAR_ACCT" ).append("\n"); 
		query.append("FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("      , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("AND     SLH.LU_TP_CD = 'ASA CLEARING ACCOUNT'" ).append("\n"); 
		query.append("AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}