/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceFrontGLDateCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceFrontGLDateCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceFrontGLDateCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceFrontGLDateCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_system_div_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceFrontGLDateCheckRSQL").append("\n"); 
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
		query.append("SELECT  MIN(A.PERIOD_USE_FLAG) AS PERIOD_USE_FLAG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("         SELECT  CLZ_STS_CD  AS PERIOD_USE_FLAG" ).append("\n"); 
		query.append("         FROM    AP_PERIOD " ).append("\n"); 
		query.append("         WHERE   EFF_YRMON = SUBSTR(REPLACE(@[gl_dt],'-'), 0, 6) " ).append("\n"); 
		query.append("         AND     SYS_DIV_CD = @[gl_system_div_flg]" ).append("\n"); 
		query.append("         AND     OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("         AND     AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("         UNION " ).append("\n"); 
		query.append("         SELECT  CLZ_STS_CD AS PERIOD_USE_FLAG" ).append("\n"); 
		query.append("         FROM    AP_PERIOD AP" ).append("\n"); 
		query.append("               , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("         WHERE   AP.EFF_YRMON  = SUBSTR(REPLACE(@[gl_dt],'-'), 0, 6) " ).append("\n"); 
		query.append("         AND     AP.SYS_DIV_CD = @[gl_system_div_flg]" ).append("\n"); 
		query.append("         AND     MO.AP_OFC_CD = @[ofc_cd]  " ).append("\n"); 
		query.append("         AND     MO.AP_OFC_CD = MO.OFC_CD  " ).append("\n"); 
		query.append("         AND     AP.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("         AND     AP.OFC_CD = MO.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 

	}
}