/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOTemplateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.03.28 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOTemplateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TemplateVO
	  * </pre>
	  */
	public InvoiceIssueDBDAOTemplateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOTemplateVORSQL").append("\n"); 
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
		query.append("SELECT   B.RPT_TMPLT_NM||'▶'||B.AR_OFC_CD AS RPT_TMPLT_NM  FROM INV_CPRT_TMPLT B" ).append("\n"); 
		query.append("WHERE  ( B.RPT_AUTH_ID = ( 'RHQ' )" ).append("\n"); 
		query.append("AND     B.AR_OFC_CD IN (" ).append("\n"); 
		query.append("                        SELECT A.OFC_CD FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                        WHERE AR_HD_QTR_OFC_CD  = (SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE OFC_CD = (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ar_ofc_cd]))" ).append("\n"); 
		query.append("						AND A.OFC_CD = A.AR_OFC_CD)) or " ).append("\n"); 
		query.append(" ( B.RPT_AUTH_ID = 'OFC'" ).append("\n"); 
		query.append("   AND     B.AR_OFC_CD =  @[ar_ofc_cd] ) or" ).append("\n"); 
		query.append(" ( B.RPT_AUTH_ID = 'OFC'" ).append("\n"); 
		query.append("   AND     B.AR_OFC_CD =  (SELECT AR_OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE OFC_CD = @[ar_ofc_cd]) ) or " ).append("\n"); 
		query.append(" ( B.RPT_AUTH_ID  ='ONLY' " ).append("\n"); 
		query.append("   AND    cre_usr_id=@[usr_id] ) or " ).append("\n"); 
		query.append("  B.RPT_AUTH_ID = 'ALL'" ).append("\n"); 
		query.append("GROUP BY   B.RPT_TMPLT_NM, B.AR_OFC_CD" ).append("\n"); 
		query.append("ORDER BY   B.RPT_TMPLT_NM, B.AR_OFC_CD" ).append("\n"); 

	}
}