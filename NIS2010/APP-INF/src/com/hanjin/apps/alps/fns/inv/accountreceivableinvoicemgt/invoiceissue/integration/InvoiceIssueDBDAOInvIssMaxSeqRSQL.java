/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("auto_inv_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
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
		query.append("         WHERE OFC_CD = CASE WHEN @[ofc_cd] = 'VLCSC' THEN " ).append("\n"); 
		query.append("                             CASE WHEN @[auto_inv_iss_flg] = 'Y' THEN" ).append("\n"); 
		query.append("                                  @[ofc_cd]" ).append("\n"); 
		query.append("                             ELSE " ).append("\n"); 
		query.append("                                  (SELECT OFC_CD" ).append("\n"); 
		query.append("                                   FROM COM_USER" ).append("\n"); 
		query.append("                                   WHERE USR_ID = @[user_id])" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                        ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                        END                                         " ).append("\n"); 
		query.append("           AND NVL(DELT_FLG, 'N') <> 'Y') A" ).append("\n"); 
		query.append("      ,INV_AR_ISS_NO B     " ).append("\n"); 
		query.append("WHERE A.INV_PFX_CD = B.INV_PFX_CD(+)  " ).append("\n"); 
		query.append("FOR UPDATE" ).append("\n"); 

	}
}