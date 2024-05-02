/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PayableRentalCostDBDAOprintComCsrLseAgmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOprintComCsrLseAgmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR 기준으로 Agreement No에 묶여있는 G/W의 정보를 가져온다
	  * </pre>
	  */
	public PayableRentalCostDBDAOprintComCsrLseAgmtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOprintComCsrLseAgmtInfoRSQL").append("\n"); 
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
		query.append("SELECT LSE_AGMT_DOC_NO L_ASSETCD ,LSE_AGMT_DOC_DESC L_DOCUMENT_TITLE" ).append("\n"); 
		query.append("FROM LSE_AGREEMENT B" ).append("\n"); 
		query.append("WHERE (B.AGMT_CTY_CD , B.AGMT_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT AGMT_CTY_CD , AGMT_SEQ" ).append("\n"); 
		query.append("        FROM LSE_PAY_RNTL_CHG A" ).append("\n"); 
		query.append("        WHERE (A.VNDR_SEQ ,A.INV_NO) IN (" ).append("\n"); 
		query.append("            SELECT DISTINCT A.VNDR_NO, D.ATTR_CTNT1 INV_NO" ).append("\n"); 
		query.append("            FROM AP_INV_HDR A," ).append("\n"); 
		query.append("                 AP_INV_DTRB D," ).append("\n"); 
		query.append("                 AP_PAY_INV P" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("            AND A.CSR_NO = @[csr_no] " ).append("\n"); 
		query.append("            AND A.CSR_NO = P.CSR_NO" ).append("\n"); 
		query.append("            AND A.VNDR_NO = P.VNDR_SEQ" ).append("\n"); 
		query.append("            AND D.ATTR_CTNT1 = P.INV_NO" ).append("\n"); 
		query.append("            AND NVL(P.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("            )  " ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("AND LSE_AGMT_DOC_NO IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY LSE_AGMT_DOC_NO ,LSE_AGMT_DOC_DESC" ).append("\n"); 

	}
}