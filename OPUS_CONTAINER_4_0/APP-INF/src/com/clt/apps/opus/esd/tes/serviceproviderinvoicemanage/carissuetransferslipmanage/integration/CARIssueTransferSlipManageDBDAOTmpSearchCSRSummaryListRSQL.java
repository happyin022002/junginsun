/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TmpSearchCSRSummaryList
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL").append("\n"); 
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
		query.append("select tml_so_ofc_cty_cd" ).append("\n"); 
		query.append("		, tml_so_seq" ).append("\n"); 
		query.append("		, inv_no" ).append("\n"); 
		query.append("		, vndr_seq" ).append("\n"); 
		query.append("		, ttl_inv_amt" ).append("\n"); 
		query.append("		, vat_amt" ).append("\n"); 
		query.append("		, nvl(whld_tax_amt,0) whld_tax_amt" ).append("\n"); 
		query.append("		, (ttl_inv_amt+vat_amt-nvl(whld_tax_amt,0)) inv_total_amt" ).append("\n"); 
		query.append("		, tml_inv_tp_cd" ).append("\n"); 
		query.append("from tes_tml_so_hdr" ).append("\n"); 
		query.append("where csr_no = @[csr_no]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}