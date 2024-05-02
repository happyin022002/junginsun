/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchSakuraConversionComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchSakuraConversionComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSakuraConversionCombo
	  * </pre>
	  */
	public StatementCommonDBDAOSearchSakuraConversionComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchSakuraConversionComboRSQL").append("\n"); 
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
		query.append("SELECT  'ALL'    AS LU_TP_CD  -- CONV_TP" ).append("\n"); 
		query.append("    ,   'ALL'    AS LU_DESC   -- CONV_DESC" ).append("\n"); 
		query.append("    ,   '1'      AS TMP_SEQ    " ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  LU_TP_CD              -- CONV_TP" ).append("\n"); 
		query.append("    ,   LU_DESC               -- CONV_DESC" ).append("\n"); 
		query.append("    ,   '2'      AS TMP_SEQ" ).append("\n"); 
		query.append("FROM    SCO_LU_HDR " ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("  AND   CD_CONV_ND_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY  TMP_SEQ" ).append("\n"); 

	}
}