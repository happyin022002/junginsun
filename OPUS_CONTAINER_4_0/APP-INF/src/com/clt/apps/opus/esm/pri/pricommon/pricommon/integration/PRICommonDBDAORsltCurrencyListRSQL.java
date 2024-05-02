/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAORsltCurrencyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.04.07 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltCurrencyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contract Rate 화면에서 사용하는 Default Currency
	  * </pre>
	  */
	public PRICommonDBDAORsltCurrencyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltCurrencyListRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD AS CD" ).append("\n"); 
		query.append("      ,CURR_CD AS NM" ).append("\n"); 
		query.append("  FROM MDM_CURRENCY" ).append("\n"); 
		query.append(" WHERE CURR_CD IN ('USD','EUR','NOK','CHF','GBP','INR','SEK','DKK','JPY','IDR','MMK','NZD')	" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}