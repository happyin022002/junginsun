/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchInactChgCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchInactChgCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchInactChgCountRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchInactChgCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchInactChgCountRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(1)" ).append("\n"); 
		query.append("  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append(" WHERE  DMDT_TRF_CD = 'DMOF'" ).append("\n"); 
		query.append("   AND  OFC_CD      = 'LGBSC'" ).append("\n"); 
		query.append("   AND  DMDT_CHG_STS_CD IN ('F' ,'C', 'N')" ).append("\n"); 
		query.append("   AND  (ORG_CHG_AMT > 0 OR BIL_AMT > 0)" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("			(DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("			(DUL_TP_EXPT_FLG = 'N')" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}