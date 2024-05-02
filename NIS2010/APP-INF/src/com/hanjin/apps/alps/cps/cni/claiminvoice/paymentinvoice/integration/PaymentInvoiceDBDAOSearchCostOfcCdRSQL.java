/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PaymentInvoiceDBDAOSearchCostOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.11 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PaymentInvoiceDBDAOSearchCostOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비용처리 오피스 취득
	  * </pre>
	  */
	public PaymentInvoiceDBDAOSearchCostOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration").append("\n"); 
		query.append("FileName : PaymentInvoiceDBDAOSearchCostOfcCdRSQL").append("\n"); 
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
		query.append("     DECODE (OFC_KND_CD, '2', DECODE (OFC_TP_CD, 'HQ', AR_HD_QTR_OFC_CD, DECODE (OFC_CD, 'SELHO', AR_HD_QTR_OFC_CD, AP_OFC_CD)), DECODE (OFC_CD, 'SELHO', AR_HD_QTR_OFC_CD, AP_OFC_CD)) AS COST_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("     MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("     OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}