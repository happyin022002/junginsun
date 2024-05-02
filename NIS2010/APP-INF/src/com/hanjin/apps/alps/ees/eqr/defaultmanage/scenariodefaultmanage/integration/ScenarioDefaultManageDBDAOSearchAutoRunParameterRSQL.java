/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchAutoRunParameterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchAutoRunParameterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Demand forcate
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchAutoRunParameterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchAutoRunParameterRSQL").append("\n"); 
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
		query.append("SELECT A.EFF_ST_YRWK AS EFF_ST_YRWK" ).append("\n"); 
		query.append("       ,RCC_CD" ).append("\n"); 
		query.append("       , CASE WHEN A.CO_CD = 'H' THEN 'SML'  ELSE 'SEN' END AS CO_NM" ).append("\n"); 
		query.append("       , CO_CD" ).append("\n"); 
		query.append("       , REPO_FCAST_TP_CD" ).append("\n"); 
		query.append("       , CASE WHEN A.REPO_FCAST_TP_CD = 'SV'  THEN '1' END AS SALES" ).append("\n"); 
		query.append("       , CASE WHEN A.REPO_FCAST_TP_CD = 'SD'  THEN '1' END AS STATISTICAL" ).append("\n"); 
		query.append("       , CASE WHEN A.REPO_FCAST_TP_CD = 'AV'  THEN '1' END AS AVERAGE" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(A.UPD_DT,'YYYYMMDD') UPD_DT							" ).append("\n"); 
		query.append(" FROM  EQR_AUTO_RUN_FCAST_PARA A, COM_INTG_CD_DTL C							" ).append("\n"); 
		query.append(" WHERE  A.EFF_ST_YRWK = ( 													" ).append("\n"); 
		query.append(" 			SELECT MAX(EFF_ST_YRWK) 											" ).append("\n"); 
		query.append(" 			FROM EQR_AUTO_RUN_FCAST_PARA										" ).append("\n"); 
		query.append(" 			WHERE  EFF_END_YRWK IS NULL )										" ).append("\n"); 
		query.append(" AND  A.EFF_END_YRWK IS NULL 								             		" ).append("\n"); 
		query.append(" AND  C.INTG_CD_ID = 'CD00255'			              									" ).append("\n"); 
		query.append(" AND  A.RCC_CD = C.INTG_CD_VAL_CTNT              								" ).append("\n"); 
		query.append(" ORDER  BY INTG_CD_VAL_DP_SEQ " ).append("\n"); 
		query.append("           , CO_CD" ).append("\n"); 

	}
}