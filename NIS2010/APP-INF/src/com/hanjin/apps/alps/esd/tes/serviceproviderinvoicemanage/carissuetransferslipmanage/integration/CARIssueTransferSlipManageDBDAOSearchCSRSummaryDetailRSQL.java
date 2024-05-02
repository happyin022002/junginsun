/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.29 박재흥
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

public class CARIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCSRSummaryDetail
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL").append("\n"); 
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
		query.append("SELECT inv_no" ).append("\n"); 
		query.append(",nvl(ttl_inv_amt,0)	ttl_inv_amt" ).append("\n"); 
		query.append(",nvl(vat_amt,0)   vat_amt" ).append("\n"); 
		query.append(",nvl(whld_tax_amt,0) whld_tax_amt" ).append("\n"); 
		query.append(",(nvl(ttl_inv_amt,0)+nvl(vat_amt,0)-nvl(whld_tax_amt,0)) inv_total_amt" ).append("\n"); 
		query.append(",tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(",tml_so_seq" ).append("\n"); 
		query.append(",vndr_seq" ).append("\n"); 
		query.append("FROM tes_tml_so_hdr" ).append("\n"); 
		query.append("WHERE cost_ofc_cd	= @[cost_ofc_cd]" ).append("\n"); 
		query.append("AND inv_ofc_cd	= @[inv_ofc_cd]" ).append("\n"); 
		query.append("AND vndr_seq	= @[vndr_seq]" ).append("\n"); 
		query.append("AND curr_cd		= @[curr_cd]" ).append("\n"); 
		query.append("AND tml_inv_sts_cd = 'C'" ).append("\n"); 
		query.append("AND tml_inv_rjct_sts_cd in ('NL','RL')" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_cfm_dt} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(inv_cfm_dt,'YYYY-MM-DD') = @[inv_cfm_dt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}