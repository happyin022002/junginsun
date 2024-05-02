/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PRICommonDBDAORsltCurrencyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * mdm_currency 테이블에서 통화코드를 가져온다
	  * 2011.07.14 이행지 [CHM-201112327-01] SC, RFA, TRI 에 운임 currency 일본 엔 추가 요청-JPY 통화코드 추가
	  * </pre>
	  */
	public PRICommonDBDAORsltCurrencyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    CURR_CD AS CD" ).append("\n"); 
		query.append("   ,CURR_CD AS NM" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE CURR_CD IN ('USD','EUR','NOK','CHF','GBP','INR','SEK','DKK','JPY', 'SGD', 'CNY' )	" ).append("\n"); 
		query.append("AND  DELT_FLG = 'N'" ).append("\n"); 

	}
}