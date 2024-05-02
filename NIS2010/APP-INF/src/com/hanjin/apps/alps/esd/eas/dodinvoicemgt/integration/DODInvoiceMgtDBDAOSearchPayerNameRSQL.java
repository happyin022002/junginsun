/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchPayerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.16 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchPayerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPayerName
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchPayerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchPayerNameRSQL").append("\n"); 
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
		query.append("SELECT 'EAS' AS JOB_TP" ).append("\n"); 
		query.append("	,'' AS GUBUN" ).append("\n"); 
		query.append("	, PAYR_NM AS PAYR_NM" ).append("\n"); 
		query.append("FROM EAS_PAYR_INFO " ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD 	= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND    CUST_SEQ 		= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("#if (${s_cust_gubun} == '1') " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("	,'GENERAL' AS GUBUN" ).append("\n"); 
		query.append("	,VNDR_LGL_ENG_NM AS PAYR_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ 			= @[s_cust_cd]" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("    ,'CREDIT' AS GUBUN" ).append("\n"); 
		query.append("    ,LOCL_NM  AS PAYR_NM" ).append("\n"); 
		query.append("FROM MDM_CR_CUST" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("    ,'GENERAL' AS GUBUN" ).append("\n"); 
		query.append("    ,CUST_LGL_ENG_NM AS PAYR_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}