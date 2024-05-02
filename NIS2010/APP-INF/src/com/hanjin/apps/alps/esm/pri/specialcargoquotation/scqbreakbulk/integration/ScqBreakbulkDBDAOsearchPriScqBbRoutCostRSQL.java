/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAOsearchPriScqBbRoutCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.24 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOsearchPriScqBbRoutCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPriScqBbRoutCost
	  * </pre>
	  */
	public ScqBreakbulkDBDAOsearchPriScqBbRoutCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOsearchPriScqBbRoutCostRSQL").append("\n"); 
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
		query.append("SELECT TES.BB_CGO_TP_SEQ" ).append("\n"); 
		query.append("     , TES.BB_CGO_DESC" ).append("\n"); 
		query.append("     , NVL( LOCL_CURR_CD, 'USD' ) AS LOCL_CURR_CD" ).append("\n"); 
		query.append("     , LOCL_CURR_AMT" ).append("\n"); 
		query.append("     , COST_AMT" ).append("\n"); 
		query.append("     , SCQ_RQST_NO" ).append("\n"); 
		query.append("     , SCQ_VER_NO" ).append("\n"); 
		query.append("     , ROUT_SEQ" ).append("\n"); 
		query.append("     , ROUT_SEQ_VER_NO" ).append("\n"); 
		query.append("     , ROUT_TP_CD" ).append("\n"); 
		query.append("     , ROUT_RMK" ).append("\n"); 
		query.append("     , CFM_FLG" ).append("\n"); 
		query.append("     , ROUT_COST_SEQ" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , DECODE ( NVL ( LOCL_CURR_CD, 'USD' ), 'USD', 1, " ).append("\n"); 
		query.append("		( SELECT USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("  		 FROM 	GL_MON_XCH_RT R" ).append("\n"); 
		query.append(" 		 WHERE  R.ACCT_XCH_RT_YRMON = ( SELECT MAX(ACCT_XCH_RT_YRMON)" ).append("\n"); 
		query.append("                                     FROM GL_MON_XCH_RT T" ).append("\n"); 
		query.append("                                     WHERE T.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                       AND T.CURR_CD = R.CURR_CD )" ).append("\n"); 
		query.append("         AND R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("         AND R.CURR_CD = LOCL_CURR_CD ) ) AS EX_RATE " ).append("\n"); 
		query.append("  FROM (SELECT ROUT.SCQ_RQST_NO" ).append("\n"); 
		query.append("             , ROUT.SCQ_VER_NO" ).append("\n"); 
		query.append("             , ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("             , ROUT.ROUT_SEQ_VER_NO" ).append("\n"); 
		query.append("             , ROUT.ROUT_TP_CD" ).append("\n"); 
		query.append("             , ROUT.ROUT_RMK" ).append("\n"); 
		query.append("             , ROUT.CFM_FLG" ).append("\n"); 
		query.append("             , RC.ROUT_COST_SEQ" ).append("\n"); 
		query.append("             , RC.BB_CGO_TP_SEQ" ).append("\n"); 
		query.append("             , NVL ( NVL( ROUT.LOCL_CURR_CD," ).append("\n"); 
		query.append("					( 	SELECT 	C.LOCL_CURR_CD " ).append("\n"); 
		query.append("						FROM 	PRI_SCQ_BB_ROUT_COST  C" ).append("\n"); 
		query.append("						WHERE 	C.SCQ_RQST_NO = ROUT.SCQ_RQST_NO " ).append("\n"); 
		query.append("						AND 	C.SCQ_VER_NO  = ROUT.SCQ_VER_NO" ).append("\n"); 
		query.append("        	            AND     C.ROUT_SEQ    = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("            	        AND     C.ROUT_SEQ_VER_NO = ROUT.ROUT_SEQ_VER_NO" ).append("\n"); 
		query.append("                	    AND     C.LOCL_CURR_CD IS NOT NULL " ).append("\n"); 
		query.append("                    	AND     ROWNUM = 1 ) ), 'USD' ) AS LOCL_CURR_CD" ).append("\n"); 
		query.append("             , RC.LOCL_CURR_AMT" ).append("\n"); 
		query.append("             , RC.COST_AMT" ).append("\n"); 
		query.append("             , ROUT.UPD_USR_ID" ).append("\n"); 
		query.append("          FROM PRI_SCQ_BB_ROUT ROUT" ).append("\n"); 
		query.append("             , PRI_SCQ_BB_ROUT_COST RC " ).append("\n"); 
		query.append("         WHERE ROUT.SCQ_RQST_NO = RC.SCQ_RQST_NO" ).append("\n"); 
		query.append("           AND ROUT.SCQ_VER_NO = RC.SCQ_VER_NO  " ).append("\n"); 
		query.append("           AND ROUT.ROUT_SEQ = RC.ROUT_SEQ" ).append("\n"); 
		query.append("           AND ROUT.ROUT_SEQ_VER_NO = RC.ROUT_SEQ_VER_NO " ).append("\n"); 
		query.append("           AND ROUT.ROUT_SEQ_VER_NO = (SELECT MAX(ROUT_SEQ_VER_NO)" ).append("\n"); 
		query.append("                                         FROM PRI_SCQ_BB_ROUT ROUT" ).append("\n"); 
		query.append("                                        WHERE ROUT.SCQ_RQST_NO = @[scq_rqst_no] --SEL201303190001" ).append("\n"); 
		query.append("                                          AND ROUT.SCQ_VER_NO  = @[scq_ver_no]  --000 " ).append("\n"); 
		query.append("                                          AND ROUT.ROUT_SEQ    = @[rout_seq] )  --1 " ).append("\n"); 
		query.append("           AND ROUT.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("           AND ROUT.SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("           AND ROUT.ROUT_SEQ    = @[rout_seq]" ).append("\n"); 
		query.append("       ) PRI" ).append("\n"); 
		query.append("     , (SELECT BB_CGO_TP_SEQ" ).append("\n"); 
		query.append("             , BB_CGO_DESC " ).append("\n"); 
		query.append("          FROM TES_BB_SO_COST " ).append("\n"); 
		query.append("         WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("       ) TES" ).append("\n"); 
		query.append(" WHERE TES.BB_CGO_TP_SEQ = PRI.BB_CGO_TP_SEQ(+)" ).append("\n"); 
		query.append(" ORDER BY TES.BB_CGO_TP_SEQ" ).append("\n"); 

	}
}