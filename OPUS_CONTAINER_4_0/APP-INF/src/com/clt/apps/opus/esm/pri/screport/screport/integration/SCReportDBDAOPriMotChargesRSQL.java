/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOPriMotChargesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOPriMotChargesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get the MOT Charges
	  * </pre>
	  */
	public SCReportDBDAOPriMotChargesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOPriMotChargesRSQL").append("\n"); 
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
		query.append("       LISTAGG (''''||CHG.CHG_TY||'''', ',') WITHIN GROUP (ORDER BY CHG.IND)  AS CHARGES" ).append("\n"); 
		query.append("  FROM (SELECT" ).append("\n"); 
		query.append("               Y.IND, Y.CHG_CD, Y.CHG_NM, Y.RMK_FLG, Y.CHG_TY, ROW_NUMBER() OVER(PARTITION BY Y.CHG_CD ORDER BY Y.CHG_TY ) AS IND_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT " ).append("\n"); 
		query.append("                       ROWNUM AS IND" ).append("\n"); 
		query.append("                     , X.CHG_CD" ).append("\n"); 
		query.append("                     , X.CHG_NM" ).append("\n"); 
		query.append("                     , X.RMK_FLG" ).append("\n"); 
		query.append("                     , CASE WHEN X.CHG_GB = 'CURR_FLG' AND X.CHG_TP = 'Y' THEN X.CHG_CD||'_CUR'" ).append("\n"); 
		query.append("                            WHEN X.CHG_GB = 'XCH_RT_FLG' AND X.CHG_TP = 'Y' THEN X.CHG_CD||'_EXE'" ).append("\n"); 
		query.append("                            ELSE X.CHG_TP" ).append("\n"); 
		query.append("                        END CHG_TY" ).append("\n"); 
		query.append("                  FROM (SELECT" ).append("\n"); 
		query.append("                               CHG_CD, CHG_NM, CHG_CD AS CHG_CD1, CURR_FLG, XCH_RT_FLG, RMK_FLG" ).append("\n"); 
		query.append("                          FROM PRI_MOT_CHG)" ).append("\n"); 
		query.append("                  UNPIVOT " ).append("\n"); 
		query.append("                  ( " ).append("\n"); 
		query.append("                    CHG_TP FOR CHG_GB IN ( CHG_CD1, CURR_FLG, XCH_RT_FLG  ) " ).append("\n"); 
		query.append("                  ) X" ).append("\n"); 
		query.append("                 WHERE X.CHG_TP <> 'N') Y" ).append("\n"); 
		query.append("        WHERE Y.CHG_CD <> 'OFT'" ).append("\n"); 
		query.append("        ORDER BY Y.IND) CHG" ).append("\n"); 

	}
}