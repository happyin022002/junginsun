/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEGKpiTargetManageVORSQL.Query
	  * </pre>
	  */
	public EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetManageRSQL").append("\n"); 
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
		query.append("#if (${mapped} == 'Y')" ).append("\n"); 
		query.append("SELECT A.EG_ID||TO_CHAR(A.EG_ID_SEQ, '000') AS EG_ID," ).append("\n"); 
		query.append("A.EG_RHQ_CD||'-'||A.EG_CTY_CD||'-'|| DECODE(A.SVC_CATE_CD, 'TR', 'TRUCK', 'RL', 'RAIL', 'CY', 'ODCY', 'TM', 'TERMINAL', 'WT', 'WATER', 'EQ', 'EQ M&R') AS EG_NAME," ).append("\n"); 
		query.append("B.SP_KPI_CD," ).append("\n"); 
		query.append("C.SP_KPI_NM," ).append("\n"); 
		query.append("'0' AS PER," ).append("\n"); 
		query.append("'0' AS TARGET," ).append("\n"); 
		query.append("B.KPI_TGT_RTO," ).append("\n"); 
		query.append("B.KPI_UT_CD," ).append("\n"); 
		query.append("B.KPI_WGT_RTO," ).append("\n"); 
		query.append("A.EG_RHQ_CD," ).append("\n"); 
		query.append("A.EG_CTY_CD," ).append("\n"); 
		query.append("A.SVC_CATE_CD," ).append("\n"); 
		query.append("B.EV_YR" ).append("\n"); 
		query.append("FROM SPE_EV_GRP A," ).append("\n"); 
		query.append("SPE_EV_GRP_KPI_TGT_RTO B," ).append("\n"); 
		query.append("SPE_KPI_SVC_CATE C" ).append("\n"); 
		query.append("WHERE B.EG_ID = A.EG_ID" ).append("\n"); 
		query.append("AND B.EG_ID_SEQ = A.EG_ID_SEQ" ).append("\n"); 
		query.append("AND B.SP_KPI_CD = C.SP_KPI_CD" ).append("\n"); 
		query.append("AND B.EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("#if (${eg_id} !='')" ).append("\n"); 
		query.append("AND A.EG_ID||TO_CHAR(A.EG_ID_SEQ, '000') = @[eg_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND A.EG_RHQ_CD||A.EG_CTY_CD||A.SVC_CATE_CD = @[eg_rhq_cd]||UPPER(@[eg_cty_cd])||@[svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY EG_ID,B.SP_KPI_CD" ).append("\n"); 
		query.append("#elseif (${mapped} == 'N')" ).append("\n"); 
		query.append("SELECT EG_ID||TO_CHAR(EG_ID_SEQ, '000') AS EG_ID," ).append("\n"); 
		query.append("EG_RHQ_CD||'-'||EG_CTY_CD||'-'||DECODE(SVC_CATE_CD, 'TR', 'Truck', 'RL', 'Rail', 'CY', 'ODCY', 'TM', 'Terminal', 'WT', 'Water', 'EQ', 'EQ M&R') AS EG_NAME," ).append("\n"); 
		query.append("SP_KPI_CD," ).append("\n"); 
		query.append("SP_KPI_NM," ).append("\n"); 
		query.append("'0' AS PER," ).append("\n"); 
		query.append("'0' AS TARGET," ).append("\n"); 
		query.append("X.KPI_TGT_RTO," ).append("\n"); 
		query.append("X.KPI_UT_CD," ).append("\n"); 
		query.append("X.KPI_WGT_RTO," ).append("\n"); 
		query.append("EG_RHQ_CD," ).append("\n"); 
		query.append("EG_CTY_CD," ).append("\n"); 
		query.append("SVC_CATE_CD," ).append("\n"); 
		query.append("@[ev_yr]" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.EG_ID," ).append("\n"); 
		query.append("A.EG_ID_SEQ," ).append("\n"); 
		query.append("A.EG_RHQ_CD," ).append("\n"); 
		query.append("A.EG_CTY_CD," ).append("\n"); 
		query.append("A.SVC_CATE_CD," ).append("\n"); 
		query.append("' ' KPI_UT_CD," ).append("\n"); 
		query.append("0 KPI_TGT_RTO," ).append("\n"); 
		query.append("0 KPI_WGT_RTO" ).append("\n"); 
		query.append("FROM SPE_EV_GRP A" ).append("\n"); 
		query.append("WHERE A.EG_ID||A.EG_ID_SEQ NOT IN (" ).append("\n"); 
		query.append("SELECT B.EG_ID||B.EG_ID_SEQ" ).append("\n"); 
		query.append("FROM SPE_EV_GRP_KPI_TGT_RTO B" ).append("\n"); 
		query.append("WHERE B.EG_ID = A.EG_ID" ).append("\n"); 
		query.append("AND B.EG_ID_SEQ = A.EG_ID_SEQ" ).append("\n"); 
		query.append("AND B.EV_YR = @[ev_yr] )" ).append("\n"); 
		query.append("#if (${eg_id} !='')" ).append("\n"); 
		query.append("AND A.EG_ID||TO_CHAR(A.EG_ID_SEQ, '000') = @[eg_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND A.EG_RHQ_CD||A.EG_CTY_CD||A.SVC_CATE_CD = @[eg_rhq_cd]||UPPER(@[eg_cty_cd])||@[svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") x," ).append("\n"); 
		query.append("SPE_KPI_SVC_CATE C" ).append("\n"); 
		query.append("WHERE (DECODE(SVC_CATE_CD, 'TR', 'Y', 'Y', 'N') = DECODE(SVC_CATE_TRSP_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'RL', 'Y', 'Y', 'N') = DECODE(SVC_CATE_RAIL_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'CY', 'Y', 'Y', 'N') = DECODE(SVC_CATE_CY_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'TM', 'Y', 'Y', 'N') = DECODE(SVC_CATE_TML_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'WT', 'Y', 'Y', 'N') = DECODE(SVC_CATE_WTR_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'EQ', 'Y', 'Y', 'N') = DECODE(SVC_CATE_EQ_FLG, 'Y', 'Y', 'X'))" ).append("\n"); 
		query.append("ORDER BY EG_ID,SP_KPI_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.EG_ID||TO_CHAR(A.EG_ID_SEQ, '000') AS EG_ID," ).append("\n"); 
		query.append("A.EG_RHQ_CD||'-'||A.EG_CTY_CD||'-'|| DECODE(A.SVC_CATE_CD, 'TR', 'Truck', 'RL', 'Rail', 'CY', 'ODCY', 'TM', 'Terminal', 'WT', 'Water', 'EQ', 'EQ M&R') AS eg_name," ).append("\n"); 
		query.append("B.SP_KPI_CD," ).append("\n"); 
		query.append("C.SP_KPI_NM," ).append("\n"); 
		query.append("'0' AS PER," ).append("\n"); 
		query.append("'0' AS TARGET," ).append("\n"); 
		query.append("B.KPI_TGT_RTO," ).append("\n"); 
		query.append("B.KPI_UT_CD," ).append("\n"); 
		query.append("B.KPI_WGT_RTO," ).append("\n"); 
		query.append("A.EG_RHQ_CD," ).append("\n"); 
		query.append("A.EG_CTY_CD," ).append("\n"); 
		query.append("A.SVC_CATE_CD," ).append("\n"); 
		query.append("B.EV_YR" ).append("\n"); 
		query.append("FROM SPE_EV_GRP A," ).append("\n"); 
		query.append("SPE_EV_GRP_KPI_TGT_RTO B," ).append("\n"); 
		query.append("SPE_KPI_SVC_CATE C" ).append("\n"); 
		query.append("WHERE B.EG_ID = A.EG_ID" ).append("\n"); 
		query.append("AND B.EG_ID_SEQ = A.EG_ID_SEQ" ).append("\n"); 
		query.append("AND B.SP_KPI_CD = C.SP_KPI_CD" ).append("\n"); 
		query.append("AND B.EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("#if (${eg_id} !='')" ).append("\n"); 
		query.append("AND A.EG_ID||TO_CHAR(A.EG_ID_SEQ, '000') = @[eg_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND A.EG_RHQ_CD||A.EG_CTY_CD||A.SVC_CATE_CD = @[eg_rhq_cd]||UPPER(@[eg_cty_cd])||@[svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EG_ID||TO_CHAR(EG_ID_SEQ, '000') AS EG_ID," ).append("\n"); 
		query.append("EG_RHQ_CD||'-'||EG_CTY_CD||'-'||DECODE(SVC_CATE_CD, 'TR', 'Truck', 'RL', 'Rail', 'CY', 'ODCY', 'TM', 'Terminal', 'WT', 'Water', 'EQ', 'EQ M&R') AS eg_name," ).append("\n"); 
		query.append("SP_KPI_CD," ).append("\n"); 
		query.append("SP_KPI_NM," ).append("\n"); 
		query.append("'0' AS PER," ).append("\n"); 
		query.append("'0' AS TARGET," ).append("\n"); 
		query.append("X.KPI_TGT_RTO," ).append("\n"); 
		query.append("X.KPI_UT_CD," ).append("\n"); 
		query.append("X.KPI_WGT_RTO," ).append("\n"); 
		query.append("EG_RHQ_CD," ).append("\n"); 
		query.append("EG_CTY_CD," ).append("\n"); 
		query.append("SVC_CATE_CD," ).append("\n"); 
		query.append("@[ev_yr]" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.EG_ID," ).append("\n"); 
		query.append("A.EG_ID_SEQ," ).append("\n"); 
		query.append("A.EG_RHQ_CD," ).append("\n"); 
		query.append("A.EG_CTY_CD," ).append("\n"); 
		query.append("A.SVC_CATE_CD," ).append("\n"); 
		query.append("' ' KPI_UT_CD," ).append("\n"); 
		query.append("0 KPI_TGT_RTO," ).append("\n"); 
		query.append("0 KPI_WGT_RTO" ).append("\n"); 
		query.append("FROM SPE_EV_GRP A" ).append("\n"); 
		query.append("WHERE A.EG_ID||A.EG_ID_SEQ NOT IN (" ).append("\n"); 
		query.append("SELECT B.EG_ID||B.EG_ID_SEQ" ).append("\n"); 
		query.append("FROM SPE_EV_GRP_KPI_TGT_RTO B" ).append("\n"); 
		query.append("WHERE B.EG_ID = A.EG_ID" ).append("\n"); 
		query.append("AND B.EG_ID_SEQ = A.EG_ID_SEQ" ).append("\n"); 
		query.append("AND B.EV_YR = @[ev_yr] )" ).append("\n"); 
		query.append("#if (${eg_id} !='')" ).append("\n"); 
		query.append("AND A.EG_ID||TO_CHAR(A.EG_ID_SEQ, '000') = @[eg_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND A.EG_RHQ_CD||A.EG_CTY_CD||A.SVC_CATE_CD = @[eg_rhq_cd]||UPPER(@[eg_cty_cd])||@[svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") x," ).append("\n"); 
		query.append("SPE_KPI_SVC_CATE C" ).append("\n"); 
		query.append("WHERE (DECODE(SVC_CATE_CD, 'TR', 'Y', 'Y', 'N') = DECODE(SVC_CATE_TRSP_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'RL', 'Y', 'Y', 'N') = DECODE(SVC_CATE_RAIL_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'CY', 'Y', 'Y', 'N') = DECODE(SVC_CATE_CY_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'TM', 'Y', 'Y', 'N') = DECODE(SVC_CATE_TML_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'WT', 'Y', 'Y', 'N') = DECODE(SVC_CATE_WTR_FLG, 'Y', 'Y', 'X')" ).append("\n"); 
		query.append("OR DECODE(SVC_CATE_CD, 'EQ', 'Y', 'Y', 'N') = DECODE(SVC_CATE_EQ_FLG, 'Y', 'Y', 'X'))" ).append("\n"); 
		query.append("ORDER BY EG_ID,SP_KPI_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}