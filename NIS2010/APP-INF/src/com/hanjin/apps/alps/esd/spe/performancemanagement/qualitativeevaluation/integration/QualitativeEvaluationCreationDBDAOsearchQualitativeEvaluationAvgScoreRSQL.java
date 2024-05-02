/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOsearchQualitativeEvaluationAvgScoreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.02 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationCreationDBDAOsearchQualitativeEvaluationAvgScoreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation 저장된 후 score 의 평균값을 리턴한다
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOsearchQualitativeEvaluationAvgScoreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sp_kpi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration ").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOsearchQualitativeEvaluationAvgScoreRSQL").append("\n"); 
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
		query.append("SELECT ROUND(SUM(EV_WGT_RSLT_RT)/COUNT(1),2) AS AVGSCORE " ).append("\n"); 
		query.append("  FROM (SELECT SUM(EV_WGT_RSLT_RT) AS EV_WGT_RSLT_RT" ).append("\n"); 
		query.append("          FROM SPE_SP_QUAL_EV" ).append("\n"); 
		query.append("         WHERE EG_ID     = @[s_eg_id]" ).append("\n"); 
		query.append("           AND EV_YR     = @[s_ev_yr]" ).append("\n"); 
		query.append("           AND EV_MON    = @[s_ev_mon]" ).append("\n"); 
		query.append("           AND SP_KPI_ID = @[s_sp_kpi_id]" ).append("\n"); 
		query.append("           AND SP_SEQ    = @[s_sp_seq]" ).append("\n"); 
		query.append("           AND EV_WGT_RT > 0" ).append("\n"); 
		query.append("        GROUP BY EVR_USR_ID" ).append("\n"); 
		query.append("      )   " ).append("\n"); 

	}
}