/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchMonthlyAccrualTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchMonthlyAccrualTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accrual Trade Code
	  * </pre>
	  */
	public StatementCommonDBDAOSearchMonthlyAccrualTradeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchMonthlyAccrualTradeListRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD AS CODE" ).append("\n"); 
		query.append("     , TRD_NM AS NAME" ).append("\n"); 
		query.append("  FROM MDM_TRADE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append(" ORDER BY FM_CONTI_CD" ).append("\n"); 
		query.append("     , TRD_CD" ).append("\n"); 

	}
}