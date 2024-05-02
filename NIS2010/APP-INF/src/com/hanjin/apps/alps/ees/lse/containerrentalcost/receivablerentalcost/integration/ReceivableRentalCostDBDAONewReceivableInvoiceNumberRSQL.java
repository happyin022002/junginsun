/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ReceivableRentalCostDBDAONewReceivableInvoiceNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAONewReceivableInvoiceNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 Receivable Rental Invoice Number를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAONewReceivableInvoiceNumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAONewReceivableInvoiceNumberRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN MAX_INV_NO IS NULL " ).append("\n"); 
		query.append("             THEN PRE_FIX_NO||TRIM(TO_CHAR(1,'000'))" ).append("\n"); 
		query.append("             ELSE PRE_FIX_NO||TRIM(TO_CHAR(NEXT_INV_SEQ,'000')) " ).append("\n"); 
		query.append("        END  INV_NO" ).append("\n"); 
		query.append("FROM   (SELECT  MAX(NVL(A.INV_NO, A.CXL_INV_NO)) AS MAX_INV_NO," ).append("\n"); 
		query.append("                'SML'||TO_CHAR(SYSDATE, 'RRRRMM') AS PRE_FIX_NO, " ).append("\n"); 
		query.append("                TO_NUMBER(SUBSTR(MAX(NVL(A.INV_NO, A.CXL_INV_NO)),10,3)) +1 AS NEXT_INV_SEQ                " ).append("\n"); 
		query.append("        FROM    LSE_RCV_RNTL_CHG A                                                                              " ).append("\n"); 
		query.append("        WHERE   TO_CHAR(SYSDATE, 'YYYYMM') = SUBSTR(NVL(A.INV_NO, A.CXL_INV_NO), 4,6)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}