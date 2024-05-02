/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchAROfficeByRhqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2010.12.23 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchAROfficeByRhqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchAROfficeByRhqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usrOfc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchAROfficeByRhqRSQL").append("\n"); 
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
		query.append("SELECT AR_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT '2' AS GUBN, AR_OFC_CD" ).append("\n"); 
		query.append("   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("#if (${rhq} != 'ALL' )" ).append("\n"); 
		query.append("   AND AR_HD_QTR_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND OFC_CD = AR_OFC_CD" ).append("\n"); 
		query.append("#if (${rhq} != 'ALL'&& ${usrOfc} != 'RHQ')" ).append("\n"); 
		query.append("   AND OFC_CD = DECODE(@[rhq],(SELECT DECODE(AR_HD_QTR_OFC_CD,'SELHO','X',AR_HD_QTR_OFC_CD) FROM  MDM_ORGANIZATION WHERE OFC_CD = @[usrOfc])" ).append("\n"); 
		query.append("                   ,(SELECT AR_OFC_CD FROM  MDM_ORGANIZATION WHERE OFC_CD = @[usrOfc]),OFC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT '1' AS GUBN, DECODE(@[rhq],(SELECT DECODE(AR_HD_QTR_OFC_CD,'SELHO','X',AR_HD_QTR_OFC_CD) FROM  MDM_ORGANIZATION WHERE OFC_CD = @[usrOfc])" ).append("\n"); 
		query.append("             ,NULL,'ALL') AS AR_OFC_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY GUBN, AR_OFC_CD" ).append("\n"); 
		query.append("ORDER BY GUBN, AR_OFC_CD" ).append("\n"); 

	}
}