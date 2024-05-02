/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOSearchRevenueAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchRevenueAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TEMP테이블상 저장된 Revenue Amount를 조회한다.
	  * Application Date / 경리 환율 기준으로 USD 환산한 값
	  * </pre>
	  */
	public BlRatingDBDAOSearchRevenueAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRevenueAmountRSQL").append("\n"); 
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
		query.append("SELECT ROUND(NVL(SUM(AMT),0), 2)     REV_AMT" ).append("\n"); 
		query.append("     , ROUND(NVL(SUM(OFT_AMT),0), 2) OFT_AMT " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT T.CHG_AMT/NVL(G.USD_LOCL_XCH_RT, C.USD_LOCL_XCH_RT) AMT" ).append("\n"); 
		query.append("             , CASE WHEN T.CHG_CD = 'OFT' " ).append("\n"); 
		query.append("                    THEN T.CHG_AMT/NVL(G.USD_LOCL_XCH_RT, C.USD_LOCL_XCH_RT) " ).append("\n"); 
		query.append("                    ELSE 0 END OFT_AMT" ).append("\n"); 
		query.append("        FROM BKG_REV_AUD_CHG_TMP T, " ).append("\n"); 
		query.append("             GL_MON_XCH_RT G, " ).append("\n"); 
		query.append("             GL_MON_XCH_RT C" ).append("\n"); 
		query.append("        WHERE T.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        AND G.ACCT_XCH_RT_LVL(+) = '1'" ).append("\n"); 
		query.append("        AND G.CURR_CD(+) = T.CURR_CD" ).append("\n"); 
		query.append("        AND G.ACCT_XCH_RT_YRMON(+) = SUBSTR(NVL(@[rt_aply_dt], TO_CHAR(SYSDATE, 'YYYYMMDD')), 0, 6)" ).append("\n"); 
		query.append("        AND C.CURR_CD = T.CURR_CD" ).append("\n"); 
		query.append("        AND C.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("        AND C.ACCT_XCH_RT_YRMON = (SELECT MAX(ACCT_XCH_RT_YRMON)" ).append("\n"); 
		query.append("                                   FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                                   WHERE ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                   AND CURR_CD = C.CURR_CD)" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}