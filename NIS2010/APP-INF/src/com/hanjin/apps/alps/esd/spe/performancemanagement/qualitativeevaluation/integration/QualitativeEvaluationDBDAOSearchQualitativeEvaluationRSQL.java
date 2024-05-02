/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationDBDAOSearchQualitativeEvaluationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.02 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationDBDAOSearchQualitativeEvaluationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Qualitative Evaluation 저장후 데이터 목록 조회
	  * </pre>
	  */
	public QualitativeEvaluationDBDAOSearchQualitativeEvaluationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationDBDAOSearchQualitativeEvaluationRSQL").append("\n"); 
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
		query.append("SELECT EV_YR" ).append("\n"); 
		query.append("     , EG_ID" ).append("\n"); 
		query.append("     , SP_SEQ" ).append("\n"); 
		query.append("     , SP_KPI_ID" ).append("\n"); 
		query.append("     , @[s_ev_svc_cate_cd] AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append("     , EV_MON" ).append("\n"); 
		query.append("     , QUAL_EV_SEQ" ).append("\n"); 
		query.append("     , EV_AREA_CTNT" ).append("\n"); 
		query.append("     , EV_FCTR_CTNT" ).append("\n"); 
		query.append("     , EV_WGT_RT" ).append("\n"); 
		query.append("     , N1ST_EV_GRD_CTNT" ).append("\n"); 
		query.append("     , N2ND_EV_GRD_CTNT" ).append("\n"); 
		query.append("     , N3RD_EV_GRD_CTNT" ).append("\n"); 
		query.append("     , CASE WHEN EV_GRD_CHK_CD = 'A'" ).append("\n"); 
		query.append("            THEN '1' ELSE '0' END AS GRADE_A" ).append("\n"); 
		query.append("     , CASE WHEN EV_GRD_CHK_CD = 'B'" ).append("\n"); 
		query.append("            THEN '1' ELSE '0' END AS GRADE_B" ).append("\n"); 
		query.append("     , CASE WHEN EV_GRD_CHK_CD = 'C'" ).append("\n"); 
		query.append("            THEN '1' ELSE '0' END AS GRADE_C" ).append("\n"); 
		query.append("     , EV_WGT_RSLT_RT" ).append("\n"); 
		query.append("  FROM SPE_SP_QUAL_EV" ).append("\n"); 
		query.append(" WHERE EG_ID     = @[s_eg_id]" ).append("\n"); 
		query.append("   AND EV_YR     = @[s_ev_yr]" ).append("\n"); 
		query.append("   AND EV_MON    = @[s_ev_mon]" ).append("\n"); 
		query.append("   AND SP_KPI_ID = @[s_sp_kpi_id]" ).append("\n"); 
		query.append("   AND SP_SEQ    = @[s_sp_seq]" ).append("\n"); 
		query.append("   AND EVR_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("   AND EV_WGT_RT > 0" ).append("\n"); 

	}
}