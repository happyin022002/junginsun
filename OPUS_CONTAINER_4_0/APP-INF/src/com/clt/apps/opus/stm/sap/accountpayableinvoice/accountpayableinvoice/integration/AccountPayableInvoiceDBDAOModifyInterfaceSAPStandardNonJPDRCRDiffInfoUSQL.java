/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInterfaceSAPStandardNonJPDRCRDiffInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.19 
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

public class AccountPayableInvoiceDBDAOModifyInterfaceSAPStandardNonJPDRCRDiffInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAKURA로 I/F된 내역 중 Prepayment와 Apply된 경우 건별 Accounted 금액의 산출과 합계 금액의 Accounted 금액 Diff 내역을 조정 처리
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInterfaceSAPStandardNonJPDRCRDiffInfoUSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInterfaceSAPStandardNonJPDRCRDiffInfoUSQL").append("\n"); 
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
		query.append("UPDATE SAP_AP_IF SAI" ).append("\n"); 
		query.append("SET    SAI.LOCL_AMT = SAI.LOCL_AMT + (((SELECT  SUM(DECODE(SAI3.PST_KEY_CD, '40', SAI3.LOCL_AMT, '21', SAI3.LOCL_AMT, '01', SAI3.LOCL_AMT, 0)) " ).append("\n"); 
		query.append("                                        FROM    SAP_AP_IF SAI3 " ).append("\n"); 
		query.append("                                        WHERE   SAI3.REF_DOC_NO = @[csr_no])" ).append("\n"); 
		query.append("                                     - (SELECT  SUM(DECODE(SAI3.PST_KEY_CD, '50', SAI3.LOCL_AMT, '31', SAI3.LOCL_AMT, '11', SAI3.LOCL_AMT, 0)) " ).append("\n"); 
		query.append("                                        FROM    SAP_AP_IF SAI3 " ).append("\n"); 
		query.append("                                        WHERE   SAI3.REF_DOC_NO = @[csr_no])) * (-1))" ).append("\n"); 
		query.append("WHERE  SAI.REF_DOC_NO = @[csr_no]" ).append("\n"); 
		query.append("AND    AP_IF_SEQ = (SELECT  MAX(SAI2.AP_IF_SEQ) " ).append("\n"); 
		query.append("                    FROM    SAP_AP_IF SAI2 " ).append("\n"); 
		query.append("                    WHERE   SAI2.REF_DOC_NO = @[csr_no] AND SAI2.PST_KEY_CD IN ('40', '21', '01') AND SAI2.LOCL_AMT IS NOT NULL )" ).append("\n"); 
		query.append("AND    (SELECT  SUM(DECODE(SAI3.PST_KEY_CD, '40', SAI3.LOCL_AMT, '21', SAI3.LOCL_AMT, '01', SAI3.LOCL_AMT, 0)) " ).append("\n"); 
		query.append("        FROM    SAP_AP_IF SAI3 " ).append("\n"); 
		query.append("        WHERE   SAI3.REF_DOC_NO = @[csr_no])" ).append("\n"); 
		query.append("       <> (SELECT  SUM(DECODE(SAI3.PST_KEY_CD, '50', SAI3.LOCL_AMT, '31', SAI3.LOCL_AMT, '11', SAI3.LOCL_AMT, 0)) " ).append("\n"); 
		query.append("           FROM    SAP_AP_IF SAI3 " ).append("\n"); 
		query.append("           WHERE   SAI3.REF_DOC_NO = @[csr_no])" ).append("\n"); 

	}
}