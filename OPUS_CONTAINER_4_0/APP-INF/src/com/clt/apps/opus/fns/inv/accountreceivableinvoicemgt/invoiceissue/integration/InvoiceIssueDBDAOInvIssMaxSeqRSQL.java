/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.06 
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

public class InvoiceIssueDBDAOInvIssMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssMaxSeq
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT A.INV_PFX_CD  --||LPAD(NVL(B.INV_MAX_SEQ) + 1,7,'0') INV_NO" ).append("\n"); 
		query.append("      ,NVL(B.INV_MAX_SEQ,0) INV_MAX_SEQ" ).append("\n"); 
		query.append("      ,INV_AR_ISS_NO_SEQ.NEXTVAL WRK_NO -- TEMP TABLE WRK_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), 'YYYYMMDD') ISS_DT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT INV_PFX_CD " ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]                               " ).append("\n"); 
		query.append("           AND NVL(DELT_FLG, 'N') <> 'Y') A" ).append("\n"); 
		query.append("      ,INV_AR_ISS_NO B     " ).append("\n"); 
		query.append("WHERE A.INV_PFX_CD = B.INV_PFX_CD(+) " ).append("\n"); 
		query.append("FOR UPDATE WAIT 30" ).append("\n"); 

	}
}