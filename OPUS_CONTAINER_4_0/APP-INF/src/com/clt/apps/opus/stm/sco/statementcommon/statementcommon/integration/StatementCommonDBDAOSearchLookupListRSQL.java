/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchLookupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.26 
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

public class StatementCommonDBDAOSearchLookupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * lookup 정보 조회
	  * </pre>
	  */
	public StatementCommonDBDAOSearchLookupListRSQL(){
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
		query.append("FileName : StatementCommonDBDAOSearchLookupListRSQL").append("\n"); 
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
		query.append("   D.LU_TP_CD" ).append("\n"); 
		query.append(" , D.LU_CD" ).append("\n"); 
		query.append(" , D.LU_DESC" ).append("\n"); 
		query.append(" , D.ENBL_FLG" ).append("\n"); 
		query.append(" , TO_CHAR(D.LU_ST_DT, 'YYYY-MM-DD')  AS LU_ST_DT" ).append("\n"); 
		query.append(" , TO_CHAR(D.LU_END_DT, 'YYYY-MM-DD') AS LU_END_DT" ).append("\n"); 
		query.append(" , D.ATTR_CTNT1" ).append("\n"); 
		query.append(" , D.ATTR_CTNT2" ).append("\n"); 
		query.append(" , D.ATTR_CTNT3" ).append("\n"); 
		query.append(" , D.ATTR_CTNT4" ).append("\n"); 
		query.append(" , D.ATTR_CTNT5" ).append("\n"); 
		query.append(" , D.CRE_USR_ID" ).append("\n"); 
		query.append(" , D.CRE_DT" ).append("\n"); 
		query.append(" , D.UPD_USR_ID" ).append("\n"); 
		query.append(" , D.UPD_DT" ).append("\n"); 
		query.append("FROM SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("WHERE H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("AND   D.LU_TP_CD = @[lu_tp_cd]" ).append("\n"); 
		query.append("AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}