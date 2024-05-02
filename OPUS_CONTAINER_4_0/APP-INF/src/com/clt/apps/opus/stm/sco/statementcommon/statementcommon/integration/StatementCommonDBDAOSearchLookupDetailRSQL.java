/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchLookupDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.02 
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

public class StatementCommonDBDAOSearchLookupDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lookup Detail Search
	  * </pre>
	  */
	public StatementCommonDBDAOSearchLookupDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchLookupDetailRSQL").append("\n"); 
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
		query.append("SELECT  DP_SEQ" ).append("\n"); 
		query.append("      , LU_TP_CD" ).append("\n"); 
		query.append("      , LU_CD" ).append("\n"); 
		query.append("      , LU_DESC" ).append("\n"); 
		query.append("      , DECODE(ENBL_FLG, 'Y', 1, 0)      AS ENBL_FLG" ).append("\n"); 
		query.append("      , TO_CHAR(LU_ST_DT, 'YYYY-MM-DD')  AS LU_ST_DT" ).append("\n"); 
		query.append("      , TO_CHAR(LU_END_DT, 'YYYY-MM-DD') AS LU_END_DT" ).append("\n"); 
		query.append("      , ATTR_CTNT1" ).append("\n"); 
		query.append("      , ATTR_CTNT2" ).append("\n"); 
		query.append("      , ATTR_CTNT3" ).append("\n"); 
		query.append("      , ATTR_CTNT4" ).append("\n"); 
		query.append("      , ATTR_CTNT5" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("  FROM SCO_LU_DTL" ).append("\n"); 
		query.append(" WHERE LU_TP_CD = @[lu_tp_cd]" ).append("\n"); 
		query.append(" ORDER BY DP_SEQ, LU_TP_CD" ).append("\n"); 

	}
}