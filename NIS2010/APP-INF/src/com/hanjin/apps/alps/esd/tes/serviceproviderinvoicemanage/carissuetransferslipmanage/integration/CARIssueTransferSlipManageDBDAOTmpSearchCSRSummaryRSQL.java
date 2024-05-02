/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.11.03 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TmpSearchCSRSummary
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryRSQL").append("\n"); 
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
		query.append("select b.cost_ofc_cd" ).append("\n"); 
		query.append(", b.vndr_seq" ).append("\n"); 
		query.append(", a.inv_desc" ).append("\n"); 
		query.append(", '' count_inv" ).append("\n"); 
		query.append(", b.curr_cd, a.csr_amt" ).append("\n"); 
		query.append(", substr(a.inv_term_dt,1,4)||'-'||substr(a.inv_term_dt,5,2)||'-'||substr(a.inv_term_dt,7,2) payment_due_dt" ).append("\n"); 
		query.append("from ap_inv_hdr a, tes_tml_so_hdr b" ).append("\n"); 
		query.append("where a.csr_no = @[csr_no]" ).append("\n"); 
		query.append("and a.csr_no = b.csr_no" ).append("\n"); 
		query.append("AND NVL(b.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}