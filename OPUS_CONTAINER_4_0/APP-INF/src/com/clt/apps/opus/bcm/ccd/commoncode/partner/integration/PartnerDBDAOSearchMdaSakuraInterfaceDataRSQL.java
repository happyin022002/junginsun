/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerDBDAOSearchMdaSakuraInterfaceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchMdaSakuraInterfaceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PartnerDBDAOSearchMdaSakuraInterfaceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchMdaSakuraInterfaceDataRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ," ).append("\n"); 
		query.append("       BANK_ACCT_FLG," ).append("\n"); 
		query.append("       CASE WHEN PAY_MZD_CD IS NULL THEN 'X'" ).append("\n"); 
		query.append("            WHEN PAY_MZD_CD IN ('2', '4', '7', 'C', 'K') THEN 'M'" ).append("\n"); 
		query.append("            WHEN PAY_MZD_CD = 'G' THEN 'T'" ).append("\n"); 
		query.append("            ELSE PAY_MZD_CD END AS PAY_MZD_CD," ).append("\n"); 
		query.append("       VNDR_RCV_IF_SEQ MODI_VNDR_CD," ).append("\n"); 
		query.append("       'E' IF_CMPL_FLG," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       SAP_ID" ).append("\n"); 
		query.append("  FROM MDM_VENDOR_RCV_IF" ).append("\n"); 
		query.append(" WHERE (IF_CMPL_FLG <> 'S' OR IF_CMPL_FLG IS NULL)" ).append("\n"); 

	}
}