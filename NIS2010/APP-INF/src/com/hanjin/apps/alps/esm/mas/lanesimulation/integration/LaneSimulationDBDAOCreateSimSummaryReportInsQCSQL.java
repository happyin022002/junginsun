/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimSummaryReportInsQCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.23 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimSummaryReportInsQCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트 Summary 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimSummaryReportInsQCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimSummaryReportInsQCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_SIM_SMRY_RPT" ).append("\n"); 
		query.append("SELECT   A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append("#if(${default_rpt_no} != '')" ).append("\n"); 
		query.append(",'${default_rpt_no}' SIM_RPT_NO --처음인 경우 AA001을 사용" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",NVL(B.SGRP_COST_CD, A.SGRP_COST_CD) SGRP_COST_CD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",NVL(B.AMT, 0) SIM_PERF_AMT" ).append("\n"); 
		query.append(",@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM (SELECT A.SGRP_COST_CD" ).append("\n"); 
		query.append(",A.DP_SEQ_NO" ).append("\n"); 
		query.append(",A.KR_DP_DESC" ).append("\n"); 
		query.append(",B.SIM_DT" ).append("\n"); 
		query.append(",B.SIM_NO" ).append("\n"); 
		query.append(",B.SECT_NO" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append("FROM MAS_SIM_RPT_INFO A, MAS_SIM_VSL_SET_INFO B" ).append("\n"); 
		query.append("WHERE SIM_DIV_CD = '3'" ).append("\n"); 
		query.append("AND B.SIM_DT = @[f_sim_dt] --" ).append("\n"); 
		query.append("AND B.SIM_NO = @[f_sim_no] ) A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("-- 영업외비용" ).append("\n"); 
		query.append("SELECT A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",'NOPE' SGRP_COST_CD" ).append("\n"); 
		query.append(",B.UC_AMT*C.TOT_AMT AMT" ).append("\n"); 
		query.append("FROM MAS_SIM_VSL_SET_INFO A,MAS_SIM_NON_OP_EXPN B," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("SECT_NO" ).append("\n"); 
		query.append(",SUM(TTL_TZ_DYS) TOT_AMT" ).append("\n"); 
		query.append("FROM MAS_SIM_TML_OP_DYS" ).append("\n"); 
		query.append("WHERE SIM_DT=@[f_sim_dt] AND SIM_NO=@[f_sim_no]" ).append("\n"); 
		query.append("GROUP BY SECT_NO) C" ).append("\n"); 
		query.append("WHERE A.VSL_CD=B.VSL_CD" ).append("\n"); 
		query.append("AND A.SECT_NO = C.SECT_NO" ).append("\n"); 
		query.append("AND A.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("AND A.SIM_DIV_CD = '3'" ).append("\n"); 
		query.append("AND SUBSTR(A.SIM_DT,0,6)=B.COST_YRMON" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- 기타 계정항목" ).append("\n"); 
		query.append("SELECT A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",DECODE(B.RNUM, 1, 'TBSA', 2, 'LOAD', 3, 'LDFR', 4, 'FRRE', 5, 'GRPB', 6, 'OTCH', 7, 'OTTT', 8, 'OFSC', 9, 'TVVD', 10, 'TTSA') SGRP_COST_CD" ).append("\n"); 
		query.append(",DECODE(B.RNUM, 1, TBSA, 2, LOAD, 3, LDFR, 4, FRRE, 5, GRPB, 6, OTCH, 7, OTCH, 8, OFSC, 9, '1', 10, OTCH + FRRE) AMT" ).append("\n"); 
		query.append("FROM (SELECT A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append(",B.FNL_HJS_BSA_CAPA TBSA" ).append("\n"); 
		query.append(", B.FNL_HJS_BSA_CAPA * B.LDF_RTO LOAD" ).append("\n"); 
		query.append(",DECODE(NVL(B.FNL_HJS_BSA_CAPA, 0), 0, 0,(B.FNL_HJS_BSA_CAPA * B.LDF_RTO) / B.FNL_HJS_BSA_CAPA) LDFR" ).append("\n"); 
		query.append(", A.GRS_RPB_REV *(B.FNL_HJS_BSA_CAPA * B.LDF_RTO) FRRE" ).append("\n"); 
		query.append(",A.GRS_RPB_REV GRPB" ).append("\n"); 
		query.append(", B.OTR_CRR_BSA_CAPA1 + B.OTR_CRR_BSA_CAPA2 + B.OTR_CRR_BSA_CAPA3 + B.OTR_CRR_BSA_CAPA4 + B.OTR_CRR_BSA_CAPA5 + B.SUB_LSE_CAPA1 + B.SUB_LSE_CAPA2" ).append("\n"); 
		query.append("+ B.SUB_LSE_CAPA3 + B.SUB_LSE_CAPA4 + B.SUB_LSE_CAPA5 OTCH" ).append("\n"); 
		query.append(", B.HJS_BFR_BSA_CAPA + B.SUB_CHTR_CAPA1 + B.SUB_CHTR_CAPA2 + B.SUB_CHTR_CAPA3 + B.SUB_CHTR_CAPA4 + B.SUB_CHTR_CAPA5 OFSC" ).append("\n"); 
		query.append("FROM MAS_SIM_SVC_LANE A, MAS_SIM_VSL_SET_INFO B" ).append("\n"); 
		query.append("WHERE A.SIM_DT = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO = B.SECT_NO" ).append("\n"); 
		query.append("AND A.SIM_DT = @[f_sim_dt] --" ).append("\n"); 
		query.append("AND A.SIM_NO = @[f_sim_no] --" ).append("\n"); 
		query.append("AND B.SIM_DIV_CD = '3') A" ).append("\n"); 
		query.append(",(SELECT ROWNUM RNUM" ).append("\n"); 
		query.append("FROM COM_CPY_NO" ).append("\n"); 
		query.append("WHERE ROWNUM <= 10) B" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- CARGO RELATED VARIABLE COST(화물변동비)/EQ HOLDING COST(장비비)" ).append("\n"); 
		query.append("SELECT SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",AMT" ).append("\n"); 
		query.append("FROM (SELECT   A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",   --C.MGRP_COST_CD," ).append("\n"); 
		query.append("DECODE(GROUPING_ID(C.MGRP_COST_CD, B.SGRP_COST_CD)" ).append("\n"); 
		query.append(",3, 'XXXX'" ).append("\n"); 
		query.append(",1, DECODE(C.MGRP_COST_CD, 'EQ', 'EQTT', 'CV', 'CVTT', 'FR', 'XXXX','BU', 'XXXX')" ).append("\n"); 
		query.append(",0, B.SGRP_COST_CD" ).append("\n"); 
		query.append(") SGRP_COST_CD" ).append("\n"); 
		query.append(",SUM(B.CGO_VAR_AMT) AMT1" ).append("\n"); 
		query.append(",A.RTO" ).append("\n"); 
		query.append(", SUM(B.CGO_VAR_AMT) * A.RTO AMT" ).append("\n"); 
		query.append("FROM (SELECT A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",RATIO_TO_REPORT(A.LDF_RTO * A.FNL_HJS_BSA_CAPA) OVER(PARTITION BY A.SECT_NO) RTO" ).append("\n"); 
		query.append("FROM MAS_SIM_VSL_SET_INFO A" ).append("\n"); 
		query.append("WHERE A.SIM_DT = @[f_sim_dt] --" ).append("\n"); 
		query.append("AND A.SIM_NO = @[f_sim_no] --" ).append("\n"); 
		query.append("AND A.SIM_DIV_CD = '1') A" ).append("\n"); 
		query.append(",MAS_SIM_CTRB_MGN_COST B" ).append("\n"); 
		query.append(",(SELECT MGRP_COST_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("FROM MAS_SUB_GRP_COST" ).append("\n"); 
		query.append("WHERE MGRP_COST_CD IN('CV', 'BU', 'EQ' )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'FR'" ).append("\n"); 
		query.append(",'DEMT'" ).append("\n"); 
		query.append(",'CNTR DEM/DET'" ).append("\n"); 
		query.append("FROM DUAL ) C" ).append("\n"); 
		query.append("WHERE A.SIM_DT = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO = B.SECT_NO" ).append("\n"); 
		query.append("AND C.SGRP_COST_CD = B.SGRP_COST_CD" ).append("\n"); 
		query.append("GROUP BY A.SIM_DT, A.SIM_NO, A.SECT_NO, A.VSL_CD, A.RTO, ROLLUP(C.MGRP_COST_CD, B.SGRP_COST_CD))" ).append("\n"); 
		query.append("WHERE SGRP_COST_CD != 'XXXX'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- VOYAGE COST(운항변동비)/VESSEL FIXED COST(운항고정비[SPACE CHARTERAGE(OFSC) : 선복임차료는 제외])" ).append("\n"); 
		query.append("SELECT   A.SIM_DT" ).append("\n"); 
		query.append(",A.SIM_NO" ).append("\n"); 
		query.append(",A.SECT_NO" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",DECODE(GROUPING_ID(A.SGRP_COST_CD), 1, DECODE(B.MGRP_COST_CD, 'OF', 'VFTT', 'OV', 'VVTT'), 0, A.SGRP_COST_CD) SGRP_COST_CD" ).append("\n"); 
		query.append(",SUM(A.AFT_OCN_TRNS_COST_AMT) AMT --NTWK_COST_AMT  AFT_OCN_TRNS_COST_AMT" ).append("\n"); 
		query.append("FROM MAS_SIM_NTWK_COST A" ).append("\n"); 
		query.append(",(SELECT MGRP_COST_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("FROM MAS_SUB_GRP_COST" ).append("\n"); 
		query.append("WHERE MGRP_COST_CD IN('OF', 'OV')) B" ).append("\n"); 
		query.append("WHERE A.SGRP_COST_CD = B.SGRP_COST_CD" ).append("\n"); 
		query.append("AND A.SIM_DT = @[f_sim_dt] --" ).append("\n"); 
		query.append("AND A.SIM_NO = @[f_sim_no] --" ).append("\n"); 
		query.append("AND A.SGRP_COST_CD != 'OFSC'" ).append("\n"); 
		query.append("GROUP BY A.SIM_DT, A.SIM_NO, A.SECT_NO, A.VSL_CD, B.MGRP_COST_CD, ROLLUP(A.SGRP_COST_CD)) B" ).append("\n"); 
		query.append("WHERE A.SIM_DT = B.SIM_DT(+)" ).append("\n"); 
		query.append("AND A.SIM_NO = B.SIM_NO(+)" ).append("\n"); 
		query.append("AND A.SECT_NO = B.SECT_NO(+)" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SGRP_COST_CD = B.SGRP_COST_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.VSL_CD, TO_NUMBER(A.DP_SEQ_NO)" ).append("\n"); 

	}
}