/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ExchangeRateDBDAORsltGlMonXchRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.10.07 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.exchangerate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HojinSong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExchangeRateDBDAORsltGlMonXchRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exchange Rate를 조회한다
	  * </pre>
	  */
	public ExchangeRateDBDAORsltGlMonXchRtVORSQL(){
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
		params.put("to_acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.exchangerate.integration").append("\n"); 
		query.append("FileName : ExchangeRateDBDAORsltGlMonXchRtVORSQL").append("\n"); 
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
		query.append("SELECT A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , B.CURR_NM" ).append("\n"); 
		query.append("     , A.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("     , ROUND ( " ).append("\n"); 
		query.append("     (  SELECT  K.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("        FROM    GL_MON_XCH_RT K " ).append("\n"); 
		query.append("        WHERE   K.ACCT_XCH_RT_YRMON = A.ACCT_XCH_RT_YRMON " ).append("\n"); 
		query.append("        AND     K.ACCT_XCH_RT_LVL = A.ACCT_XCH_RT_LVL " ).append("\n"); 
		query.append("        AND     K.CURR_CD = 'KRW' ) / A.USD_LOCL_XCH_RT,  2 )  AS LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("     (  SELECT  K.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("        FROM    GL_MON_XCH_RT K " ).append("\n"); 
		query.append("        WHERE   K.ACCT_XCH_RT_YRMON = A.ACCT_XCH_RT_YRMON " ).append("\n"); 
		query.append("        AND     K.ACCT_XCH_RT_LVL = A.ACCT_XCH_RT_LVL " ).append("\n"); 
		query.append("        AND     K.CURR_CD = 'KRW' )  AS USD_KRW_XCH_RT" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("  FROM GL_MON_XCH_RT A" ).append("\n"); 
		query.append("     , MDM_CURRENCY B" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${from_acct_xch_rt_yrmon} != '' && ${to_acct_xch_rt_yrmon} != '')" ).append("\n"); 
		query.append("   AND A.ACCT_XCH_RT_YRMON BETWEEN REPLACE(@[from_acct_xch_rt_yrmon],'-','') AND REPLACE(@[to_acct_xch_rt_yrmon],'-','')" ).append("\n"); 
		query.append("#elseif (${from_acct_xch_rt_yrmon} != '')" ).append("\n"); 
		query.append("   AND A.ACCT_XCH_RT_YRMON = REPLACE(@[from_acct_xch_rt_yrmon],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${curr_cd} != '')" ).append("\n"); 
		query.append("   AND A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 

	}
}