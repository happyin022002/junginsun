/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRatingDBDAOSearchVATtoEurRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.07.27 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchVATtoEurRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchVATtoEurRSQL
	  * </pre>
	  */
	public BlRatingDBDAOSearchVATtoEurRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchVATtoEurRSQL").append("\n"); 
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
		query.append("SELECT ROUND((@[rate] / INPUT_CURR.USD_LOCL_XCH_RT) * EURO_CURR.USD_LOCL_XCH_RT, 2) VAT" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT INPUT_CURR" ).append("\n"); 
		query.append(", GL_MON_XCH_RT EURO_CURR" ).append("\n"); 
		query.append("WHERE INPUT_CURR.ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("AND INPUT_CURR.CURR_CD           = @[curr_cd]" ).append("\n"); 
		query.append("AND INPUT_CURR.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("AND EURO_CURR.ACCT_XCH_RT_LVL    = 1" ).append("\n"); 
		query.append("AND EURO_CURR.CURR_CD            = 'EUR'" ).append("\n"); 
		query.append("AND EURO_CURR.ACCT_XCH_RT_YRMON  = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 

	}
}