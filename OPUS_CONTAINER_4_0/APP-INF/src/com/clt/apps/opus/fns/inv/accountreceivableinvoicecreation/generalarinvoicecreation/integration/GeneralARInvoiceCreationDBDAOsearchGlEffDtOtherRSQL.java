/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.09.16 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mri_max_yymm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL").append("\n"); 
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
		query.append("SELECT NVL((SELECT MAX(@[gl_eff_dt])" ).append("\n"); 
		query.append("                  FROM AP_PERIOD  " ).append("\n"); 
		query.append("                 WHERE SYS_DIV_CD = '33'" ).append("\n"); 
		query.append("                   AND CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("                   AND (OFC_CD = @[ofc_cd] OR OFC_CD = (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                         WHERE OFC_CD =@[ofc_cd]))" ).append("\n"); 
		query.append("                   AND AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("                   AND EFF_YRMON = SUBSTR(@[gl_eff_dt], 1, 6))," ).append("\n"); 
		query.append("            @[mri_max_yymm]||'01') GL_EFF_DT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}