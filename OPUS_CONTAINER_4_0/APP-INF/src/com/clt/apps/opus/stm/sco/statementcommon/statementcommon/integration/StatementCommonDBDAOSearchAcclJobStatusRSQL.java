/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchAcclJobStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
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

public class StatementCommonDBDAOSearchAcclJobStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAcclJobStatus
	  * </pre>
	  */
	public StatementCommonDBDAOSearchAcclJobStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchAcclJobStatusRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("        EXEC_STATUS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  ROW_NUMBER() OVER (ORDER BY TMP_SEQ) AS ROW_SEQ" ).append("\n"); 
		query.append("        ,   AA.*" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT  1 AS TMP_SEQ" ).append("\n"); 
		query.append("            ,   DECODE(AA.ATTR_CTNT3, 'START','Running', 'END','Completed', 'Error') AS EXEC_STATUS" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT  DENSE_RANK() OVER (PARTITION BY PGM_APPL_NM, SRC_MDL_CD, ERR_DESC, EXE_YRMON ORDER BY ATTR_CTNT1 DESC, ATTR_CTNT2 DESC) AS LST_SEQ" ).append("\n"); 
		query.append("                ,   L.*" ).append("\n"); 
		query.append("            FROM    SAC_IF_ERR_LOG L" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("              AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'" ).append("\n"); 
		query.append("              AND   SRC_MDL_CD = @[job_nm]" ).append("\n"); 
		query.append("              AND   ERR_DESC = 'EXEC_LOG'" ).append("\n"); 
		query.append("              AND   L.EXE_YRMON = REPLACE(@[accl_month],'-','')" ).append("\n"); 
		query.append("        ) AA" ).append("\n"); 
		query.append("        WHERE AA.LST_SEQ = 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  2 AS TMP_SEQ" ).append("\n"); 
		query.append("            ,   'Not Run' AS EXEC_STATUS" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("    ) AA" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 
		query.append("WHERE ROW_SEQ = 1" ).append("\n"); 

	}
}