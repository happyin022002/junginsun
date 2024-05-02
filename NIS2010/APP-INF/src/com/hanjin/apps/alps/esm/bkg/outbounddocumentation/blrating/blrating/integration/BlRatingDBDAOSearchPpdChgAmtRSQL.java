/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOSearchPpdChgAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.05 
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

public class BlRatingDBDAOSearchPpdChgAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchPpdChgAmtRSQL
	  * </pre>
	  */
	public BlRatingDBDAOSearchPpdChgAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchPpdChgAmtRSQL").append("\n"); 
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
		query.append("SELECT MAX(USD_CHG_AMT) USD_CHG_AMT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT SUM(ROUND(CHG_AMT/USD_LOCL_XCH_RT,2)) USD_CHG_AMT" ).append("\n"); 
		query.append("        FROM   BKG_CHG_RT BCR," ).append("\n"); 
		query.append("               GL_MON_XCH_RT GMR" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    BCR.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND    BCR.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("        AND    BCR.FRT_INCL_XCLD_DIV_CD <> 'I'" ).append("\n"); 
		query.append("        AND    BCR.N3PTY_RCV_OFC_CD IS NULL" ).append("\n"); 
		query.append("        AND    GMR.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("        AND    GMR.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("        AND    GMR.CURR_CD = BCR.CURR_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 0 FROM DUAL" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}