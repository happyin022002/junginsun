/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimSummaryReportMg2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.16 
* 1.0 Creation
* 2010.10.08 박은주 CHM-201006307 Session 정보 변경 및 프로그램 오류수정
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOMultiSimSummaryReportMg2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * summary 레포트 머지 2
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimSummaryReportMg2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rpb_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldf_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_rpt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOMultiSimSummaryReportMg2CSQL").append("\n"); 
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
		query.append("		    USING (SELECT B1.SIM_DT " ).append("\n"); 
		query.append("		                 ,B1.SIM_NO " ).append("\n"); 
		query.append("		                 ,B1.SECT_NO " ).append("\n"); 
		query.append("		                 ,B1.SIM_RPT_NO " ).append("\n"); 
		query.append("		                 ,B1.VSL_CD " ).append("\n"); 
		query.append("		                 ,DECODE(RNUM " ).append("\n"); 
		query.append("		                        , 1, 'LOAD' " ).append("\n"); 
		query.append("		                        , 2, 'FRRE' " ).append("\n"); 
		query.append("		                        , 3, 'OTTT' " ).append("\n"); 
		query.append("		                        , 4, 'DEMT' " ).append("\n"); 
		query.append("		                        , 5, 'TTSA' " ).append("\n"); 
		query.append("		                        , 6, 'CVTT' " ).append("\n"); 
		query.append("		                        , 7, 'CVFS' " ).append("\n"); 
		query.append("		                        , 8, 'CVVI' " ).append("\n"); 
		query.append("		                        , 9, 'CVIP' " ).append("\n"); 
		query.append("		                        ,10, 'CVTR' " ).append("\n"); 
		query.append("		                        ,11, 'CVES' " ).append("\n"); 
		query.append("		                        ,12, 'CVET' " ).append("\n"); 
		query.append("		                        ,13, 'CVAC' " ).append("\n"); 
		query.append("		                        ,14, 'BUAC' " ).append("\n"); 
		query.append("		                        ,15, 'EQTT' " ).append("\n"); 
		query.append("		                        ,16, 'EQCF' " ).append("\n"); 
		query.append("		                        ,17, 'EQSF' " ).append("\n"); 
		query.append("		                        ,18, 'VVTT' " ).append("\n"); 
		query.append("		                        ,19, 'TTCO' " ).append("\n"); 
		query.append("		                        ,20, 'OPTT' " ).append("\n"); 
		query.append("		                        ,21, 'NTIN' " ).append("\n"); 
		query.append("		                        ,22, 'BEPL' " ).append("\n"); 
		query.append("		                        ,23, 'BEPB' " ).append("\n"); 
		query.append("		                        ) SGRP_COST_CD " ).append("\n"); 
		query.append("		                 , DECODE(RNUM " ).append("\n"); 
		query.append("		                        , 1, TBSA * LDFR   --LOAD " ).append("\n"); 
		query.append("		                        , 2, GRPB * (TBSA * LDFR)   --FRRE " ).append("\n"); 
		query.append("		                        , 3,(OTCH + ( ( DEMT / PLOAD ) * (TBSA * LDFR ) ) + OTIN )   -- OTTT " ).append("\n"); 
		query.append("		                        , 4,( DEMT / PLOAD ) * (TBSA * LDFR )    -- DEMT " ).append("\n"); 
		query.append("		                        , 5,(GRPB * (TBSA * LDFR)) + (OTCH + ( ( DEMT / PLOAD ) * (TBSA * LDFR ) ) + OTIN)   --TTSA " ).append("\n"); 
		query.append("		                        , 6,(  " ).append("\n"); 
		query.append("		                            (CVFS / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                            (CVVI / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVIP / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVTR / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVES / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVET / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVAC / PLOAD) *(TBSA * LDFR) )  -- CVTT   (이전화물변동비/이전수송량=단가)* 신규수송량 " ).append("\n"); 
		query.append("		                        , 7,(CVFS / PLOAD) *(TBSA * LDFR) -- CVFS " ).append("\n"); 
		query.append("		                        , 8,(CVVI / PLOAD) *(TBSA * LDFR) -- CVVI " ).append("\n"); 
		query.append("		                        , 9,(CVIP / PLOAD) *(TBSA * LDFR) -- CVIP " ).append("\n"); 
		query.append("		                        ,10,(CVTR / PLOAD) *(TBSA * LDFR) -- CVTR " ).append("\n"); 
		query.append("		                        ,11,(CVES / PLOAD) *(TBSA * LDFR) -- CVES " ).append("\n"); 
		query.append("		                        ,12,(CVET / PLOAD) *(TBSA * LDFR) -- CVET " ).append("\n"); 
		query.append("		                        ,13,(CVAC / PLOAD) *(TBSA * LDFR) -- CVAC " ).append("\n"); 
		query.append("		                        ,14,(BUAC / PLOAD) *(TBSA * LDFR) -- BUAC " ).append("\n"); 
		query.append("		                        ,15,(EQCF / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                            (EQSF / PLOAD) *(TBSA * LDFR) -- EQTT " ).append("\n"); 
		query.append("		                        ,16,(EQCF / PLOAD) *(TBSA * LDFR) -- EQCF " ).append("\n"); 
		query.append("		                        ,17,(EQSF / PLOAD) *(TBSA * LDFR) -- EQSF " ).append("\n"); 
		query.append("		                        ,18,(OVPC + OVCT + OVBK)   -- VVTT --6-11계산항목에 1-5까지 바뀐것들 적용 " ).append("\n"); 
		query.append("		                        ,19,(  " ).append("\n"); 
		query.append("		                            (CVFS / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVVI / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVIP / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVTR / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVES / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVET / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVAC / PLOAD) *(TBSA * LDFR) ) +  " ).append("\n"); 
		query.append("		                            ( (BUAC / PLOAD) *(TBSA * LDFR) ) + " ).append("\n"); 
		query.append("		                            ( (EQCF / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                              (EQSF / PLOAD) *(TBSA * LDFR) ) + (OVPC + OVCT + OVBK) + VFTT --TTCO " ).append("\n"); 
		query.append("		                        ,20, ( (GRPB * (TBSA * LDFR)) + (OTCH + ( ( DEMT / PLOAD ) * (TBSA * LDFR ) ) + OTIN) ) - " ).append("\n"); 
		query.append("		                             ( " ).append("\n"); 
		query.append("		                             (  " ).append("\n"); 
		query.append("		                            (CVFS / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVVI / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVIP / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVTR / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVES / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVET / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVAC / PLOAD) *(TBSA * LDFR) ) +  " ).append("\n"); 
		query.append("		                            ( (BUAC / PLOAD) *(TBSA * LDFR) ) + " ).append("\n"); 
		query.append("		                            ( (EQCF / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                              (EQSF / PLOAD) *(TBSA * LDFR) ) + (OVPC + OVCT + OVBK) + VFTT ) -- OPTT " ).append("\n"); 
		query.append("		                        ,21, SBPF - VFTT -  " ).append("\n"); 
		query.append("		                             ( " ).append("\n"); 
		query.append("		                             ( (GRPB * (TBSA * LDFR)) + (OTCH + ( ( DEMT / PLOAD ) * (TBSA * LDFR ) ) + OTIN) ) - " ).append("\n"); 
		query.append("		                             ( " ).append("\n"); 
		query.append("		                             (  " ).append("\n"); 
		query.append("		                            (CVFS / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVVI / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVIP / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVTR / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVES / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVET / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                            (CVAC / PLOAD) *(TBSA * LDFR) ) +  " ).append("\n"); 
		query.append("		                            ( (BUAC / PLOAD) *(TBSA * LDFR) ) + " ).append("\n"); 
		query.append("		                            ( (EQCF / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                              (EQSF / PLOAD) *(TBSA * LDFR) ) + (OVPC + OVCT + OVBK) + VFTT ) ) -- NTIN " ).append("\n"); 
		query.append("		                        ,22,( " ).append("\n"); 
		query.append("		                               ( (OVPC + OVCT + OVBK) + VFTT - OTCH ) / " ).append("\n"); 
		query.append("		                               DECODE( (GRPB *(TBSA * LDFR) + OTIN + DEMT - ( (  " ).append("\n"); 
		query.append("		                                                                        (CVFS / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVVI / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVIP / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVTR / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVES / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVET / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVAC / PLOAD) *(TBSA * LDFR) ) +  " ).append("\n"); 
		query.append("		                                                                        ( " ).append("\n"); 
		query.append("		                                                                        (BUAC / PLOAD) *(TBSA * LDFR) ) + " ).append("\n"); 
		query.append("		                                                                        ( " ).append("\n"); 
		query.append("		                                                                        (EQCF / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                                                                        (EQSF / PLOAD) *(TBSA * LDFR) )  " ).append("\n"); 
		query.append("		                                                                        ) ), 0, 1,  " ).append("\n"); 
		query.append("		                                        (GRPB *(TBSA * LDFR) + OTIN + DEMT - ( (  " ).append("\n"); 
		query.append("		                                                                        (CVFS / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVVI / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVIP / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVTR / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVES / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVET / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVAC / PLOAD) *(TBSA * LDFR) ) +  " ).append("\n"); 
		query.append("		                                                                        ( " ).append("\n"); 
		query.append("		                                                                        (BUAC / PLOAD) *(TBSA * LDFR) ) + " ).append("\n"); 
		query.append("		                                                                        ( " ).append("\n"); 
		query.append("		                                                                        (EQCF / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                                                                        (EQSF / PLOAD) *(TBSA * LDFR) )  " ).append("\n"); 
		query.append("		                                                                        ) ) ) ) * LDFR -- BEPL " ).append("\n"); 
		query.append("		                        ,23, ( " ).append("\n"); 
		query.append("		                               ( (OVPC + OVCT + OVBK) + VFTT - OTCH - DEMT) + (  " ).append("\n"); 
		query.append("		                                                                        (CVFS / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVVI / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVIP / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVTR / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVES / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVET / PLOAD) *(TBSA * LDFR) + " ).append("\n"); 
		query.append("		                                                                        (CVAC / PLOAD) *(TBSA * LDFR) ) +  " ).append("\n"); 
		query.append("		                                                                        ( " ).append("\n"); 
		query.append("		                                                                        (BUAC / PLOAD) *(TBSA * LDFR) ) + " ).append("\n"); 
		query.append("		                                                                        ( " ).append("\n"); 
		query.append("		                                                                        (EQCF / PLOAD) *(TBSA * LDFR) +  " ).append("\n"); 
		query.append("		                                                                        (EQSF / PLOAD) *(TBSA * LDFR) ) - OTIN ) / DECODE ( (TBSA * LDFR) , 0, 1 , (TBSA * LDFR) ) -- BEPB " ).append("\n"); 
		query.append("		                                                                         " ).append("\n"); 
		query.append("		                        ) SIM_PERF_AMT " ).append("\n"); 
		query.append("		                 ,@[cre_usr_id] CRE_USR_ID " ).append("\n"); 
		query.append("		                 ,SYSDATE CRE_DT " ).append("\n"); 
		query.append("		             FROM (SELECT   SIM_DT " ).append("\n"); 
		query.append("		                           ,SIM_NO " ).append("\n"); 
		query.append("		                           ,SECT_NO " ).append("\n"); 
		query.append("		                           ,SIM_RPT_NO " ).append("\n"); 
		query.append("		                           ,VSL_CD " ).append("\n"); 
		query.append("		                           ,(NVL(@[ldf_rto], SUM(DECODE(SGRP_COST_CD, 'LDFR', SIM_PERF_AMT, 0)))) / 100 LDFR   --L/F " ).append("\n"); 
		query.append("		                           , NVL(@[grs_rpb_rev], SUM(DECODE(SGRP_COST_CD, 'GRPB', SIM_PERF_AMT, 0))) GRPB " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'TBSA', SIM_PERF_AMT, 0)) TBSA   --공급량 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'LOAD', SIM_PERF_AMT, 0)) LOAD   --수송량 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'OTCH', SIM_PERF_AMT, 0)) OTCH   --선복임대수입 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'OTIN', SIM_PERF_AMT, 0)) OTIN   --기타수입 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'CVFS', SIM_PERF_AMT, 0)) CVFS   --FULL하역비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'CVVI', SIM_PERF_AMT, 0)) CVVI   --VOLUME할인 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'CVIP', SIM_PERF_AMT, 0)) CVIP   --자가터미널비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'CVTR', SIM_PERF_AMT, 0)) CVTR   --FULL운반비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'CVES', SIM_PERF_AMT, 0)) CVES   --MT하역비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'CVET', SIM_PERF_AMT, 0)) CVET   --MT운반비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'CVAC', SIM_PERF_AMT, 0)) CVAC   --대리점비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'BUAC', SIM_PERF_AMT, 0)) BUAC   --일반관리비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'EQCF', SIM_PERF_AMT, 0)) EQCF   --CNTR " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'EQSF', SIM_PERF_AMT, 0)) EQSF   --CHZ " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'OVPC', SIM_PERF_AMT, 0)) OVPC   --항비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'OVCT', SIM_PERF_AMT, 0)) OVCT   --운하통과료 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'OVBK', SIM_PERF_AMT, 0)) OVBK   --연료비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'VFTT', SIM_PERF_AMT, 0)) VFTT   --운항고정비 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'SBPF', SIM_PERF_AMT, 0)) SBPF   --대선수입 " ).append("\n"); 
		query.append("		                           ,SUM(DECODE(SGRP_COST_CD, 'DEMT', SIM_PERF_AMT, 0)) DEMT   --DEM/DET " ).append("\n"); 
		query.append("		                           ,DECODE ( SUM(DECODE(SGRP_COST_CD, 'LOAD', SIM_PERF_AMT, 0)), 0, 1, SUM(DECODE(SGRP_COST_CD, 'LOAD', SIM_PERF_AMT, 0)) )  PLOAD   --보정수송량 " ).append("\n"); 
		query.append("		                       FROM COA_SIM_SMRY_RPT " ).append("\n"); 
		query.append("		                      WHERE SIM_DT = @[sim_dt] " ).append("\n"); 
		query.append("		                        AND SIM_NO = @[sim_no] " ).append("\n"); 
		query.append("		                        AND SECT_NO = @[sect_no] " ).append("\n"); 
		query.append("		                        AND SIM_RPT_NO = @[sim_rpt_no] " ).append("\n"); 
		query.append("		                        AND SGRP_COST_CD IN " ).append("\n"); 
		query.append("		                                 ('LDFR', 'GRPB', 'TBSA', 'LOAD', 'OTCH', 'OTIN', 'CVFS', 'CVVI', 'CVIP', 'CVES', 'CVTR', 'CVET', 'CVAC', " ).append("\n"); 
		query.append("		                                  'BUAC', 'EQCF', 'EQSF', 'OVPC', 'OVCT', 'OVBK', 'VFTT', 'OTCH', 'SBPF', 'BUAC','DEMT' ) " ).append("\n"); 
		query.append("		                   GROUP BY SIM_DT, SIM_NO, SECT_NO, SIM_RPT_NO, VSL_CD) B1 " ).append("\n"); 
		query.append("		                 ,(SELECT ROWNUM RNUM " ).append("\n"); 
		query.append("		                     FROM COM_CPY_NO " ).append("\n"); 
		query.append("		                    WHERE ROWNUM <= 23) B2 )C2 " ).append("\n"); 
		query.append("		    ON (    C1.SIM_DT = C2.SIM_DT" ).append("\n"); 
		query.append("		        AND C1.SIM_NO = C2.SIM_NO" ).append("\n"); 
		query.append("		        AND C1.SECT_NO = C2.SECT_NO" ).append("\n"); 
		query.append("		        AND C1.SIM_RPT_NO = C2.SIM_RPT_NO" ).append("\n"); 
		query.append("		        AND C1.SGRP_COST_CD = C2.SGRP_COST_CD" ).append("\n"); 
		query.append("		        AND C1.VSL_CD = C2.VSL_CD)" ).append("\n"); 
		query.append("		    WHEN MATCHED THEN" ).append("\n"); 
		query.append("		       UPDATE" ).append("\n"); 
		query.append("		          SET C1.SIM_PERF_AMT = C2.SIM_PERF_AMT" ).append("\n"); 
		query.append("                     ,C1.UPD_USR_ID = C2.CRE_USR_ID" ).append("\n"); 
		query.append("                     ,C1.UPD_DT = C2.CRE_DT" ).append("\n"); 
		query.append("		    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("		       INSERT(C1.SIM_DT, C1.SIM_NO, C1.SECT_NO, C1.SIM_RPT_NO, C1.SGRP_COST_CD, C1.VSL_CD, C1.SIM_PERF_AMT" ).append("\n"); 
		query.append("		             ,C1.CRE_USR_ID, C1.CRE_DT,C1.UPD_USR_ID,C1.UPD_DT)" ).append("\n"); 
		query.append("		       VALUES(C2.SIM_DT, C2.SIM_NO, C2.SECT_NO, C2.SIM_RPT_NO, C2.SGRP_COST_CD, C2.VSL_CD, C2.SIM_PERF_AMT" ).append("\n"); 
		query.append("		             ,C2.CRE_USR_ID, C2.CRE_DT,C2.CRE_USR_ID, C2.CRE_DT)" ).append("\n"); 

	}
}