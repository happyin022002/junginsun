/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EacMgtDBDAOSearchMonthExchangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchMonthExchangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율정보조회
	  * </pre>
	  */
	public EacMgtDBDAOSearchMonthExchangeRSQL(){
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
		params.put("expn_aud_rslt_inv_aud_diff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchMonthExchangeRSQL").append("\n"); 
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
		query.append("SELECT  ROUND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("            @[expn_aud_rslt_inv_aud_diff_amt] / " ).append("\n"); 
		query.append("            (   SELECT  USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                FROM    GL_MON_XCH_RT XCH " ).append("\n"); 
		query.append("                WHERE   XCH.ACCT_XCH_RT_YRMON   = to_char(to_date(@[inv_cfm_dt], 'YYYY-MM-dd'), 'YYYYMM') -- Confirm Date" ).append("\n"); 
		query.append("                AND     XCH.ACCT_XCH_RT_LVL     = 1" ).append("\n"); 
		query.append("                AND     XCH.CURR_CD             = @[curr_cd] -- w/o 또는 invoice currency" ).append("\n"); 
		query.append("            ) , 2" ).append("\n"); 
		query.append("        ) AS EXPN_AUD_RSLT_INV_USD_DIFF_AMT" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}