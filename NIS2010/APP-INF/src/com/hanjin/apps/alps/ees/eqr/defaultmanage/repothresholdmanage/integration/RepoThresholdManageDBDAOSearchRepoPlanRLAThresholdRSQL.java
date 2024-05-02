/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOSearchRepoPlanRLAThresholdRSQL.java
*@FileTitle : Red Light Alert 기준 조회/수정---컨테이너 이송 계획
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoThresholdManageDBDAOSearchRepoPlanRLAThresholdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_PLN_RED_LGT_ALT_MST  테이블의 데이터 조회
	  * </pre>
	  */
	public RepoThresholdManageDBDAOSearchRepoPlanRLAThresholdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("A.RCC_CD" ).append("\n"); 
		query.append(",B.PERF_DUR_WKS" ).append("\n"); 
		query.append(",B.TRSP_CAPA_RTO" ).append("\n"); 
		query.append(",B.LS_RTO" ).append("\n"); 
		query.append(",'' ADHERENCE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- RCC CODE" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_DESC RCC_CD" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00255'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("EQR_REPO_PLN_RED_LGT_ALT_MST B" ).append("\n"); 
		query.append("WHERE A.RCC_CD = B.RCC_CD(+)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOSearchRepoPlanRLAThresholdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}