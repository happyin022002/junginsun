/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PayableRentalCostDBDAOSearchGwApprAgmtAttach2RSQLRSQL.java
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

public class PayableRentalCostDBDAOSearchGwApprAgmtAttach2RSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/W 연동을 위해서 vendor no, csr_no, inv_no등 조회해오는 쿼리
	  * </pre>
	  */
	public PayableRentalCostDBDAOSearchGwApprAgmtAttach2RSQLRSQL(){
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
		query.append("FileName : PayableRentalCostDBDAOSearchGwApprAgmtAttach2RSQLRSQL").append("\n"); 
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
		query.append("WITH LV_DATA0 AS ( " ).append("\n"); 
		query.append("     SELECT DISTINCT A.VNDR_NO, D.ATTR_CTNT1 INV_NO ,A.CSR_NO" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("            AP_INV_HDR A,   AP_INV_DTRB D,   AP_PAY_INV P" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("            AND A.CSR_NO = @[csr_no] " ).append("\n"); 
		query.append("            AND A.CSR_NO = P.CSR_NO" ).append("\n"); 
		query.append("            AND A.VNDR_NO = P.VNDR_SEQ" ).append("\n"); 
		query.append("            AND D.ATTR_CTNT1 = P.INV_NO" ).append("\n"); 
		query.append("            AND NVL(P.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("LV_INV_NO AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     SELECT DISTINCT AA.AGMT_CTY_CD , AA.AGMT_SEQ , BB.INV_NO , BB.CSR_NO" ).append("\n"); 
		query.append("        FROM LSE_PAY_RNTL_CHG AA," ).append("\n"); 
		query.append("             LV_DATA0 BB" ).append("\n"); 
		query.append("        WHERE AA.VNDR_SEQ = BB.VNDR_NO" ).append("\n"); 
		query.append("        AND   AA.INV_NO   = BB.INV_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  AA.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("        BB.INV_NO AS INV_NO," ).append("\n"); 
		query.append("        BB.CSR_NO AS CSR_NO ," ).append("\n"); 
		query.append("        AA.LSE_AGMT_DOC_NO L_ASSETCD ," ).append("\n"); 
		query.append("        AA.LSE_AGMT_DOC_DESC L_DOCUMENT_TITLE " ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT AA," ).append("\n"); 
		query.append("       LV_INV_NO BB" ).append("\n"); 
		query.append("WHERE AA.AGMT_CTY_CD = BB.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND   AA.AGMT_SEQ = BB.AGMT_SEQ" ).append("\n"); 

	}
}