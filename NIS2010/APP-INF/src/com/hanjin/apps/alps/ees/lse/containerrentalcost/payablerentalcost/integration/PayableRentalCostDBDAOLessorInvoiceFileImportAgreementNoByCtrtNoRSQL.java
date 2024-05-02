/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.23 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Agreement No. by Contract No.
	  * </pre>
	  */
	public PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL").append("\n"); 
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
		query.append("SELECT AGMT_CTY_CD || AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT" ).append("\n"); 
		query.append("WHERE  LSE_CTRT_NO = @[lse_ctrt_no]" ).append("\n"); 

	}
}