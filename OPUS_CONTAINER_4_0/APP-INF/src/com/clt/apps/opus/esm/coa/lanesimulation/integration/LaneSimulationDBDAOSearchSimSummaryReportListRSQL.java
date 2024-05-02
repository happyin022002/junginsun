/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimSummaryReportListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.03.22 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimSummaryReportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimSummaryReportListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_sim_rpt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimSummaryReportListRSQL").append("\n"); 
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
		query.append("SELECT SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",KR_DP_DESC" ).append("\n"); 
		query.append(",ENG_DP_DESC" ).append("\n"); 
		query.append(",DP_SEQ_NO" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",SUM(DECODE(SECT_NO, '000', AMT_TTL, 0)) AMT_000" ).append("\n"); 
		query.append("#foreach(${header_value} IN ${header})" ).append("\n"); 
		query.append(",SUM(DECODE(sect_no, '${header_value}', amt_ttl, 0)) amt_${header_value}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT   SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO" ).append("\n"); 
		query.append("#if(${f_searchItem2}=='1')" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",NULL VSL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",KR_DP_DESC" ).append("\n"); 
		query.append(",ENG_DP_DESC" ).append("\n"); 
		query.append(",DP_SEQ_NO" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",ROUND(DECODE(SGRP_COST_CD" ).append("\n"); 
		query.append(",'LDFR', AVG(LOAD/TBSA )* 100" ).append("\n"); 
		query.append(",'BEPL', AVG( ( (VVTT+VFTT+OFSC-OTCH)/DECODE((FRRE+OTIN-(CVTT+BUAC+EQTT)),0,1,(FRRE+OTIN+NVL(DEMT,0)-(CVTT+BUAC+EQTT))) )*LOAD/TBSA )* 100" ).append("\n"); 
		query.append(",'GRPB', AVG(FRRE/LOAD * 1)" ).append("\n"); 
		query.append(",'BEPB', AVG( ( (VVTT+VFTT+OFSC-OTCH)+((CVTT+BUAC+EQTT)-OTIN-NVL(DEMT,0)) )/LOAD )" ).append("\n"); 
		query.append("#if(${f_voy_view}=='1')" ).append("\n"); 
		query.append(",'OPIN', DECODE(SECT_NO,'000',AVG(OPTT-NOPE)*2,AVG(OPTT-NOPE))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'OPIN', MAX(OPTT-NOPE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_voy_view}=='1' || ${f_searchItem2}=='2')" ).append("\n"); 
		query.append(",AVG(AMT_TTL )* ${num} )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",SUM(AMT_TTL )* ${num} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",2) AMT_TTL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",KR_DP_DESC" ).append("\n"); 
		query.append(",ENG_DP_DESC" ).append("\n"); 
		query.append(",DP_SEQ_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",LOAD" ).append("\n"); 
		query.append(",TBSA" ).append("\n"); 
		query.append(",FRRE" ).append("\n"); 
		query.append(",OTIN" ).append("\n"); 
		query.append(",CVTT" ).append("\n"); 
		query.append(",VVTT" ).append("\n"); 
		query.append(",VFTT" ).append("\n"); 
		query.append(",OTCH" ).append("\n"); 
		query.append(",BUAC" ).append("\n"); 
		query.append(",EQTT" ).append("\n"); 
		query.append(",DEMT" ).append("\n"); 
		query.append(",OFSC" ).append("\n"); 
		query.append(",NOPE" ).append("\n"); 
		query.append(",OPTT" ).append("\n"); 
		query.append(",SUM(SIM_PERF_AMT) AMT_TTL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",KR_DP_DESC" ).append("\n"); 
		query.append(",ENG_DP_DESC" ).append("\n"); 
		query.append(",DP_SEQ_NO   --SECTION을 때서 컬럼으로 갖는다." ).append("\n"); 
		query.append(",SIM_PERF_AMT" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'LOAD', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS LOAD -- 수송량" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'TBSA', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS TBSA -- 공급량" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'FRRE', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS FRRE -- 운임수입" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'OTIN', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS OTIN -- 기타수입" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'CVTT', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS CVTT -- 화물변동비" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'VVTT', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS VVTT -- 운항변동비" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'VFTT', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS VFTT -- 운항고정비" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'OTCH', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS OTCH -- 선복  임차료" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'BUAC', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS BUAC -- 일반관리비" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'EQTT', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS EQTT -- 장비비" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'DEMT', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS DEMT -- DEM/DET" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'OFSC', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS OFSC -- SPACE CHARTERAGE" ).append("\n"); 
		query.append("#if(${f_voy_view}=='1')" ).append("\n"); 
		query.append(",AVG(DECODE(SGRP_COST_CD, 'NOPE', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS NOPE -- 영업외비용" ).append("\n"); 
		query.append(",AVG(DECODE(SGRP_COST_CD, 'OPTT', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS OPTT -- 영업비용" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'NOPE', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS NOPE -- 영업외비용" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'OPTT', SIM_PERF_AMT)) OVER(PARTITION BY SECT_NO) AS OPTT -- 영업비용" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",DECODE(T.RNUM, 1, '000', A1.SECT_NO) SECT_NO" ).append("\n"); 
		query.append(",A2.SIM_RPT_NO" ).append("\n"); 
		query.append(",A2.VSL_CD" ).append("\n"); 
		query.append(",A2.SGRP_COST_CD" ).append("\n"); 
		query.append(",A3.KR_DP_DESC" ).append("\n"); 
		query.append(",A3.ENG_DP_DESC" ).append("\n"); 
		query.append(",A3.DP_SEQ_NO   --SECTION을 때서 컬럼으로 갖는다." ).append("\n"); 
		query.append(",A2.SIM_PERF_AMT" ).append("\n"); 
		query.append("FROM COA_SIM_SVC_LANE A1, COA_SIM_SMRY_RPT A2, COA_SIM_RPT_INFO A3 ,(SELECT ROWNUM RNUM FROM COA_WK_PRD WHERE ROWNUM < 3) T" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("AND A2.SIM_RPT_NO = @[f_sim_rpt_no]" ).append("\n"); 
		query.append("AND A3.SGRP_COST_CD NOT IN('OPDY')" ).append("\n"); 
		query.append("#set($tmp_trd_cd = '0')" ).append("\n"); 
		query.append("#if($f_trd_cd != '')" ).append("\n"); 
		query.append("#set($tmp_trd_cd = '1')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#set($f_trd_cd = '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A1.TRD_CD = DECODE('1', '${tmp_trd_cd}', '${f_trd_cd}', A1.TRD_CD) --" ).append("\n"); 
		query.append("#set ($tmp_vsl_cd = 0)" ).append("\n"); 
		query.append("#if(${f_searchItem2} == '1')" ).append("\n"); 
		query.append("#if(${f_vsl_cd} != '')" ).append("\n"); 
		query.append("#set ($tmp_vsl_cd = '1')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#set($tmp_vsl_cd='0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A2.VSL_CD = DECODE('1', '${tmp_vsl_cd}', '${f_vsl_cd}', A2.VSL_CD) --" ).append("\n"); 
		query.append("AND A1.SIM_DT = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO = A2.SIM_NO" ).append("\n"); 
		query.append("AND A1.SECT_NO = A2.SECT_NO" ).append("\n"); 
		query.append("AND A2.SGRP_COST_CD = A3.SGRP_COST_CD )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO, VSL_CD" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",KR_DP_DESC" ).append("\n"); 
		query.append(",ENG_DP_DESC" ).append("\n"); 
		query.append(",DP_SEQ_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",LOAD" ).append("\n"); 
		query.append(",TBSA" ).append("\n"); 
		query.append(",FRRE" ).append("\n"); 
		query.append(",OTIN" ).append("\n"); 
		query.append(",CVTT" ).append("\n"); 
		query.append(",VVTT" ).append("\n"); 
		query.append(",VFTT" ).append("\n"); 
		query.append(",OTCH" ).append("\n"); 
		query.append(",BUAC" ).append("\n"); 
		query.append(",EQTT" ).append("\n"); 
		query.append(",DEMT" ).append("\n"); 
		query.append(",OFSC" ).append("\n"); 
		query.append(",NOPE" ).append("\n"); 
		query.append(",OPTT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO" ).append("\n"); 
		query.append("#if(${f_searchItem2}=='1')" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",KR_DP_DESC" ).append("\n"); 
		query.append(",ENG_DP_DESC" ).append("\n"); 
		query.append(",DP_SEQ_NO" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append(",SECT_NO )" ).append("\n"); 
		query.append("GROUP BY SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO, VSL_CD, KR_DP_DESC" ).append("\n"); 
		query.append(",ENG_DP_DESC" ).append("\n"); 
		query.append(",DP_SEQ_NO" ).append("\n"); 
		query.append(",SGRP_COST_CD" ).append("\n"); 
		query.append("ORDER BY SIM_DT, SIM_NO, SIM_RPT_NO" ).append("\n"); 
		query.append("#if(${f_searchItem2}=='1')" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", DP_SEQ_NO" ).append("\n"); 

	}
}