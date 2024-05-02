/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOSearchQualitativeEvaluationOrgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.05 백형인
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

public class QualitativeEvaluationCreationDBDAOSearchQualitativeEvaluationOrgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation 저장전 데이터 목록 조회
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOSearchQualitativeEvaluationOrgRSQL(){
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
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOSearchQualitativeEvaluationOrgRSQL").append("\n"); 
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
		query.append("SELECT A.EV_YR" ).append("\n"); 
		query.append("     , A.EV_SVC_CATE_CD " ).append("\n"); 
		query.append("     , A.QUAL_EV_SEQ " ).append("\n"); 
		query.append("     , A.EV_AREA_CTNT " ).append("\n"); 
		query.append("     , A.EV_FCTR_CTNT " ).append("\n"); 
		query.append("     , A.EV_WGT_RT " ).append("\n"); 
		query.append("     , A.N1ST_EV_GRD_CTNT " ).append("\n"); 
		query.append("     , A.N2ND_EV_GRD_CTNT " ).append("\n"); 
		query.append("     , A.N3RD_EV_GRD_CTNT " ).append("\n"); 
		query.append("     , B.EG_ID" ).append("\n"); 
		query.append("     , B.EV_MON" ).append("\n"); 
		query.append("     , B.SP_KPI_ID" ).append("\n"); 
		query.append("     , B.SP_SEQ" ).append("\n"); 
		query.append("  FROM SPE_QUAL_EV A" ).append("\n"); 
		query.append("     , (SELECT @[s_eg_id] AS EG_ID" ).append("\n"); 
		query.append("             , @[s_ev_yr] AS EV_YR" ).append("\n"); 
		query.append("             , @[s_ev_mon] AS EV_MON" ).append("\n"); 
		query.append("             , @[s_sp_kpi_id] AS SP_KPI_ID" ).append("\n"); 
		query.append("             , @[s_sp_seq] AS SP_SEQ" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("       ) B       " ).append("\n"); 
		query.append(" WHERE A.EV_YR          = @[s_ev_yr]" ).append("\n"); 
		query.append("   AND A.EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 

	}
}