/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CountryDBDAOTotalLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.09
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.09 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.country.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CountryDBDAOTotalLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff에서 사용하는 Total Country
	  * </pre>
	  */
	public CountryDBDAOTotalLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.country.integration").append("\n"); 
		query.append("FileName : CountryDBDAOTotalLocationRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  FROM (SELECT A.CNT_CD" ).append("\n"); 
		query.append("          FROM AOC_TRF_CURR A" ).append("\n"); 
		query.append("         GROUP BY A.CNT_CD) X," ).append("\n"); 
		query.append("       MDM_COUNTRY Y" ).append("\n"); 
		query.append(" WHERE X.CNT_CD = Y.CNT_CD" ).append("\n"); 
		query.append("   AND Y.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("   AND UPPER(X.CNT_CD) like UPPER(@[cnt_cd]) || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cnt_nm} != '')" ).append("\n"); 
		query.append("   AND UPPER(Y.CNT_NM) like '%' || UPPER(@[cnt_nm]) || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}