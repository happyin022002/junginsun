/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOAddQualitativeEvaluationCSQL.java
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

public class QualitativeEvaluationCreationDBDAOAddQualitativeEvaluationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation 신규 입력시 정성평가 내용을 일괄 저장한다
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOAddQualitativeEvaluationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_kpi_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOAddQualitativeEvaluationCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_SP_QUAL_EV(EG_ID" ).append("\n"); 
		query.append("                         , SP_KPI_ID" ).append("\n"); 
		query.append("                         , EV_YR" ).append("\n"); 
		query.append("                         , SP_SEQ" ).append("\n"); 
		query.append("                         , EV_MON" ).append("\n"); 
		query.append("                         , QUAL_EV_SEQ" ).append("\n"); 
		query.append("                         , EVR_USR_ID" ).append("\n"); 
		query.append("                         , EV_AREA_CTNT" ).append("\n"); 
		query.append("                         , EV_FCTR_CTNT" ).append("\n"); 
		query.append("                         , EV_WGT_RT" ).append("\n"); 
		query.append("                         , N1ST_EV_GRD_CTNT" ).append("\n"); 
		query.append("                         , N2ND_EV_GRD_CTNT" ).append("\n"); 
		query.append("                         , N3RD_EV_GRD_CTNT" ).append("\n"); 
		query.append("                         , CRE_USR_ID" ).append("\n"); 
		query.append("                         , CRE_DT" ).append("\n"); 
		query.append("                         , UPD_USR_ID" ).append("\n"); 
		query.append("                         , UPD_DT" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                          SELECT B.EG_ID" ).append("\n"); 
		query.append("                               , B.SP_KPI_ID" ).append("\n"); 
		query.append("                               , B.EV_YR" ).append("\n"); 
		query.append("                               , B.SP_SEQ" ).append("\n"); 
		query.append("                               , B.EV_MON" ).append("\n"); 
		query.append("                               , A.QUAL_EV_SEQ " ).append("\n"); 
		query.append("                               , @[cre_usr_id] " ).append("\n"); 
		query.append("                               , A.EV_AREA_CTNT " ).append("\n"); 
		query.append("                               , A.EV_FCTR_CTNT " ).append("\n"); 
		query.append("                               , A.EV_WGT_RT " ).append("\n"); 
		query.append("                               , A.N1ST_EV_GRD_CTNT " ).append("\n"); 
		query.append("                               , A.N2ND_EV_GRD_CTNT " ).append("\n"); 
		query.append("                               , A.N3RD_EV_GRD_CTNT " ).append("\n"); 
		query.append("                               , @[cre_usr_id]    " ).append("\n"); 
		query.append("                               , SYSDATE" ).append("\n"); 
		query.append("                               , @[cre_usr_id]    " ).append("\n"); 
		query.append("                               , SYSDATE" ).append("\n"); 
		query.append("                            FROM SPE_QUAL_EV A" ).append("\n"); 
		query.append("                               , (SELECT @[eg_id] AS EG_ID" ).append("\n"); 
		query.append("                                       , @[ev_yr] AS EV_YR" ).append("\n"); 
		query.append("                                       , @[ev_mon] AS EV_MON" ).append("\n"); 
		query.append("                                       , @[sp_kpi_id] AS SP_KPI_ID" ).append("\n"); 
		query.append("                                       , @[sp_seq] AS SP_SEQ" ).append("\n"); 
		query.append("                                   FROM DUAL" ).append("\n"); 
		query.append("                                 ) B                                   " ).append("\n"); 
		query.append("                           WHERE A.EV_YR          = @[s_ev_yr]" ).append("\n"); 
		query.append("                             AND A.EV_SVC_CATE_CD = @[ev_svc_cate_cd]" ).append("\n"); 

	}
}