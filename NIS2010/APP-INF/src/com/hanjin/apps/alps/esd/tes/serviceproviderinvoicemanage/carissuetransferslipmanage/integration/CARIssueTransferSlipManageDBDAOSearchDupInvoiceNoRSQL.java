/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchDupInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchDupInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDupInvoiceNo
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchDupInvoiceNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchDupInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT B.INV_NO" ).append("\n"); 
		query.append("FROM AP_INV_HDR A, TES_TML_SO_HDR B " ).append("\n"); 
		query.append("WHERE A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND A.IF_FLG = 'E'" ).append("\n"); 
		query.append("AND A.IF_ERR_RSN LIKE 'Duplicated Of Vendor Invoice No%'" ).append("\n"); 

	}
}