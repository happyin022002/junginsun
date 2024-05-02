/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchInvoiceIssueTempListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchInvoiceIssueTempListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceIssueTempList
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchInvoiceIssueTempListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchInvoiceIssueTempListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   INV_ISS_TMP_SEQ" ).append("\n"); 
		query.append(" , INV_LINE_NO" ).append("\n"); 
		query.append(" , INV_NO" ).append("\n"); 
		query.append(" , ACT_INV_NO" ).append("\n"); 
		query.append(" , LOCL_PO_NO" ).append("\n"); 
		query.append(" , INV_ISS_CMB_FLG" ).append("\n"); 
		query.append(" , ISS_OFC_CD" ).append("\n"); 
		query.append(" , ISS_DT" ).append("\n"); 
		query.append(" , INV_XCH_RT_DT" ).append("\n"); 
		query.append(" , USD_XCH_RT" ).append("\n"); 
		query.append(" , RISS_DT" ).append("\n"); 
		query.append(" , INV_ISS_RMK" ).append("\n"); 
		query.append(" , ISS_GRP_TP_CD" ).append("\n"); 
		query.append(" , INV_SGL_FLG" ).append("\n"); 
		query.append(" , FM_INV_NO" ).append("\n"); 
		query.append(" , TO_INV_NO" ).append("\n"); 
		query.append(" , MLT_INV_NO_CTNT" ).append("\n"); 
		query.append(" , PRV_FLG" ).append("\n"); 
		query.append(" , INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append(" , N2ND_INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append(" , ISS_OPT_RISS_FLG" ).append("\n"); 
		query.append(" , ISS_OPT_OFC_CD" ).append("\n"); 
		query.append(" , ISS_OPT_RPT_FILE_NM" ).append("\n"); 
		query.append(" , ISS_OPT_SND_FLG" ).append("\n"); 
		query.append(" , ISS_OPT_TP_FLG" ).append("\n"); 
		query.append(" , ISS_OPT_CPY_KNT" ).append("\n"); 
		query.append(" , ISS_OPT_LGO_FLG" ).append("\n"); 
		query.append(" , ATTR_CTNT1" ).append("\n"); 
		query.append(" , ATTR_CTNT2" ).append("\n"); 
		query.append(" , ATTR_CTNT3" ).append("\n"); 
		query.append(" , ATTR_CTNT4" ).append("\n"); 
		query.append(" , ATTR_CTNT5" ).append("\n"); 
		query.append(" , ATTR_CTNT6" ).append("\n"); 
		query.append(" , ATTR_CTNT7" ).append("\n"); 
		query.append(" , ATTR_CTNT8" ).append("\n"); 
		query.append(" , ATTR_CTNT9" ).append("\n"); 
		query.append(" , ATTR_CTNT10" ).append("\n"); 
		query.append(" , ATTR_CTNT11" ).append("\n"); 
		query.append(" , ATTR_CTNT12" ).append("\n"); 
		query.append(" , ATTR_CTNT13" ).append("\n"); 
		query.append(" , ATTR_CTNT14" ).append("\n"); 
		query.append(" , ATTR_CTNT15" ).append("\n"); 
		query.append(" , ATTR_CTNT16" ).append("\n"); 
		query.append(" , ATTR_CTNT17" ).append("\n"); 
		query.append(" , ATTR_CTNT18" ).append("\n"); 
		query.append(" , ATTR_CTNT19" ).append("\n"); 
		query.append(" , ATTR_CTNT20" ).append("\n"); 
		query.append(" , ATTR_CTNT21" ).append("\n"); 
		query.append(" , ATTR_CTNT22" ).append("\n"); 
		query.append(" , ATTR_CTNT23" ).append("\n"); 
		query.append(" , ATTR_CTNT24" ).append("\n"); 
		query.append(" , ATTR_CTNT25" ).append("\n"); 
		query.append(" , CRE_USR_ID AS USR_ID" ).append("\n"); 
		query.append("FROM INV_AR_ISS_TMP" ).append("\n"); 
		query.append("WHERE INV_ISS_TMP_SEQ = @[inv_iss_tmp_seq]" ).append("\n"); 

	}
}