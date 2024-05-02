/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckCsrNoForApHdrDtrbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.12.01 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCheckCsrNoForApHdrDtrbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckCsrNoForApHdrDtrb
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckCsrNoForApHdrDtrbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckCsrNoForApHdrDtrbRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(H.CSR_NO) 	CSR_KNT" ).append("\n"); 
		query.append("FROM	AP_INV_HDR  		H" ).append("\n"); 
		query.append(",AP_INV_DTRB 		D" ).append("\n"); 
		query.append("WHERE	H.CSR_NO    			= D.CSR_NO" ).append("\n"); 
		query.append("AND H.SRC_CTNT  		= 'SO_TRANS'" ).append("\n"); 
		query.append("AND H.IF_FLG    		= 'Y'" ).append("\n"); 
		query.append("AND H.RCV_ERR_FLG		IS NULL" ).append("\n"); 
		query.append("AND H.CSR_NO    		= @[CSR_NO]" ).append("\n"); 

	}
}