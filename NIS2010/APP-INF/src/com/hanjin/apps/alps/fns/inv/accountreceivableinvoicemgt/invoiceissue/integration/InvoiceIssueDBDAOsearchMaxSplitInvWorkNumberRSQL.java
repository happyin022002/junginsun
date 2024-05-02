/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchMaxSplitInvWorkNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.06 
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

public class InvoiceIssueDBDAOsearchMaxSplitInvWorkNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMaxSplitInvWorkNumber
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchMaxSplitInvWorkNumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchMaxSplitInvWorkNumberRSQL").append("\n"); 
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
		query.append("SELECT DECODE(MAX(INV_SPLIT_ISS_WRK_NO), NULL, 1, (MAX(INV_SPLIT_ISS_WRK_NO)+1)) INV_SPLIT_ISS_WRK_NO" ).append("\n"); 
		query.append("   FROM   INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("   WHERE  1=1" ).append("\n"); 
		query.append("   #if (${bl_src_no} != '') " ).append("\n"); 
		query.append("   AND    BL_SRC_NO = @[bl_src_no] " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${bkg_no} != '') " ).append("\n"); 
		query.append("   AND    BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND    AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 

	}
}