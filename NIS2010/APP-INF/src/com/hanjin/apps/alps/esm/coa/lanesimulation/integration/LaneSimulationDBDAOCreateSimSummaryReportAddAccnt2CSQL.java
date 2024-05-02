/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimSummaryReportAddAccnt2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.23 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimSummaryReportAddAccnt2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addition accent 2 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimSummaryReportAddAccnt2CSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimSummaryReportAddAccnt2CSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SIM_SMRY_RPT C1" ).append("\n"); 
		query.append("USING (SELECT B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.SECT_NO" ).append("\n"); 
		query.append(",B1.SIM_RPT_NO" ).append("\n"); 
		query.append(",B1.VSL_CD" ).append("\n"); 
		query.append(",DECODE(B2.RNUM, 1, 'BEPL', 2, 'BEPB', 3, 'TTCO', 4, 'OPTT', 5, 'NTIN', 6, 'LUCS', 7, 'NOVE', 8, 'OTTT', 9, 'TTSA' ) SGRP_COST_CD" ).append("\n"); 
		query.append(",DECODE(B2.RNUM" ).append("\n"); 
		query.append(",1,((VVTT + VFTT - OTCH) / (DECODE((FRRE + OTIN + DEMT - (CVTT + BUAC + EQTT) ), 0, 1, (FRRE + OTIN + DEMT - (CVTT + BUAC + EQTT) )))) * (DECODE(LOAD, 0, 1, LOAD) / DECODE(TBSA, 0, 1, TBSA))" ).append("\n"); 
		query.append(",2,((VVTT + VFTT - OTCH) + ( (CVTT + BUAC + EQTT) - OTIN - DEMT)) / DECODE(LOAD, 0, 1, LOAD)" ).append("\n"); 
		query.append(",3,((CVTT + BUAC + EQTT) + VVTT + VFTT)                          -- 운항원가 ( TTCO ) = 화물변동비(CVTT) + 일반관리비(BUAC) + 장비비(EQTT) + 운항변동비(VVTT) + 운항고정비(VFTT)" ).append("\n"); 
		query.append(",4,((FRRE + OTCH + DEMT + OTIN) - (CVTT + BUAC + EQTT + VVTT + VFTT))                   -- 영업이익 ( OPTT ) = 총매출액(TTSA) - 운항원가 ( TTCO )" ).append("\n"); 
		query.append(",5,(SBPF - VFTT - ((FRRE + OTCH + DEMT + OTIN) - (CVTT + BUAC + EQTT + VVTT + VFTT)))   -- 수지개선금액(대선시)(NTIN) = 대선수입(SBPF) - 운항고정비(VFTT) - 영업이익(OPTT)" ).append("\n"); 
		query.append(",6,((B3.LCA * B3.P_OPDY ) + OFLU )" ).append("\n"); 
		query.append(",7, VFTT - ( (B3.LCA * B3.P_OPDY ) + OFLU )" ).append("\n"); 
		query.append(",8, (OTCH + DEMT + OTIN)" ).append("\n"); 
		query.append(",9, (FRRE + OTCH + DEMT + OTIN)" ).append("\n"); 
		query.append(") SIM_PERF_AMT" ).append("\n"); 
		query.append(",@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(   SELECT   SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",SIM_RPT_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'VVTT', SIM_PERF_AMT, 0)) VVTT" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'VFTT', SIM_PERF_AMT, 0)) VFTT" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'OTCH', SIM_PERF_AMT, 0)) OTCH" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'FRRE', SIM_PERF_AMT, 0)) FRRE" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'OTIN', SIM_PERF_AMT, 0)) OTIN" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'CVTT', SIM_PERF_AMT, 0)) CVTT" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'LOAD', SIM_PERF_AMT, 0)) LOAD" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'TBSA', SIM_PERF_AMT, 0)) TBSA" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'SBPF', SIM_PERF_AMT, 0)) SBPF" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'BUAC', SIM_PERF_AMT, 0)) BUAC" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'EQTT', SIM_PERF_AMT, 0)) EQTT" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'OFLU', SIM_PERF_AMT, 0)) OFLU" ).append("\n"); 
		query.append(",SUM(DECODE(SGRP_COST_CD, 'DEMT', SIM_PERF_AMT, 0)) DEMT" ).append("\n"); 
		query.append("FROM    COA_SIM_SMRY_RPT" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND     SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("#if($default_rpt_no != '')" ).append("\n"); 
		query.append("AND     SIM_RPT_NO = '${default_rpt_no}'   --DEFAULT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     SGRP_COST_CD IN" ).append("\n"); 
		query.append("('VVTT', 'VFTT', 'OTCH', 'FRRE', 'OTIN', 'CVTT', 'LOAD', 'TBSA', 'SBPF', 'BUAC', 'EQTT', 'OFLU', 'DEMT')" ).append("\n"); 
		query.append("GROUP BY SIM_DT, SIM_NO, SECT_NO, SIM_RPT_NO, VSL_CD) B1" ).append("\n"); 
		query.append(",(  SELECT  ROWNUM RNUM" ).append("\n"); 
		query.append("FROM    COM_CPY_NO" ).append("\n"); 
		query.append("WHERE   ROWNUM <= 9) B2" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT   B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.SECT_NO" ).append("\n"); 
		query.append(",B1.VSL_CD" ).append("\n"); 
		query.append(",B3.LCA" ).append("\n"); 
		query.append(",SUM(B2.TTL_TZ_DYS) P_OPDY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(   SELECT  SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",SECT_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",TML_CD" ).append("\n"); 
		query.append(",VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append("FROM    COA_SIM_NTWK_COST" ).append("\n"); 
		query.append("WHERE   SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND     SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("GROUP   BY SIM_DT, SIM_NO, SECT_NO, VSL_CD, TML_CD, VSL_DBL_CALL_SEQ) B1" ).append("\n"); 
		query.append(",COA_SIM_TML_OP_DYS B2," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  VSL_CD, MAX(LYP_COST_AMT) LCA" ).append("\n"); 
		query.append("FROM    COA_SIM_DLY_HIR" ).append("\n"); 
		query.append("WHERE   SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND     SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("GROUP   BY VSL_CD ) B3" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     B1.SIM_DT = B2.SIM_DT" ).append("\n"); 
		query.append("AND     B1.SIM_NO = B2.SIM_NO" ).append("\n"); 
		query.append("AND     B1.SECT_NO = B2.SECT_NO" ).append("\n"); 
		query.append("AND     B1.TML_CD = B2.TML_CD" ).append("\n"); 
		query.append("AND     B1.VSL_DBL_CALL_SEQ = B2.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append("AND     B1.VSL_CD = B3.VSL_CD" ).append("\n"); 
		query.append("GROUP   BY B1.SIM_DT, B1.SIM_NO, B1.SECT_NO, B1.VSL_CD, B3.LCA ) B3" ).append("\n"); 
		query.append("WHERE   B1.SECT_NO  = B3.SECT_NO(+)" ).append("\n"); 
		query.append("AND     B1.VSL_CD   = B3.VSL_CD(+) ) C2" ).append("\n"); 
		query.append("ON (    C1.SIM_DT = C2.SIM_DT" ).append("\n"); 
		query.append("AND C1.SIM_NO = C2.SIM_NO" ).append("\n"); 
		query.append("AND C1.SECT_NO = C2.SECT_NO" ).append("\n"); 
		query.append("AND C1.SIM_RPT_NO = C2.SIM_RPT_NO" ).append("\n"); 
		query.append("AND C1.SGRP_COST_CD = C2.SGRP_COST_CD" ).append("\n"); 
		query.append("AND C1.VSL_CD = C2.VSL_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET C1.SIM_PERF_AMT = C2.SIM_PERF_AMT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(C1.SIM_DT, C1.SIM_NO, C1.SECT_NO, C1.SIM_RPT_NO, C1.SGRP_COST_CD, C1.VSL_CD, C1.SIM_PERF_AMT" ).append("\n"); 
		query.append(",C1.CRE_USR_ID, C1.CRE_DT,C1.UPD_USR_ID, C1.UPD_DT)" ).append("\n"); 
		query.append("VALUES(C2.SIM_DT, C2.SIM_NO, C2.SECT_NO, C2.SIM_RPT_NO, C2.SGRP_COST_CD, C2.VSL_CD, C2.SIM_PERF_AMT" ).append("\n"); 
		query.append(",C2.CRE_USR_ID, C2.CRE_DT,C2.UPD_USR_ID, C2.UPD_DT)" ).append("\n"); 

	}
}