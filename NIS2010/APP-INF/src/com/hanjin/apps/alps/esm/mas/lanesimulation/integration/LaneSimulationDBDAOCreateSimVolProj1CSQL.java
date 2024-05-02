/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimVolProj1CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimVolProj1CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * route projection volumn insert.
	  * 
	  * 2010.07.29 이윤정 : CHM-201004777-01 [MAS] MAS 코드매핑 불일치건 조치 요청 : SRC_PRD_CD 삭제
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimVolProj1CSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimVolProj1CSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_SIM_VOL_PRJ(SIM_DT, SIM_NO, SECT_NO, POL_CD, POD_CD, PORT_PAIR_QTY, PORT_PAIR_LOD_QTY, PORT_PAIR_RTO, GRS_RPB_REV, TRD_CD, SUB_TRD_CD, RLANE_CD, SKD_DIR_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("	         SELECT C1.SIM_DT " ).append("\n"); 
		query.append("	               ,C1.SIM_NO " ).append("\n"); 
		query.append("	               ,C1.SECT_NO " ).append("\n"); 
		query.append("	               ,C1.POL_CD " ).append("\n"); 
		query.append("	               ,C1.POD_CD " ).append("\n"); 
		query.append("	               ,C1.LOAD_QTY PORT_PAIR_QTY " ).append("\n"); 
		query.append("	               ,(C1.LOAD_QTY/SUM(C1.LOAD_QTY) OVER (PARTITION BY C1.SECT_NO)) * C1.LOD_TTL_QTY PORT_PAIR_LOD_QTY " ).append("\n"); 
		query.append("	               ,C1.LOAD_QTY/SUM(C1.LOAD_QTY) OVER (PARTITION BY C1.SECT_NO) PORT_PAIR_RTO " ).append("\n"); 
		query.append("	               ,C1.REV/C1.LOAD_QTY  GRS_RPB_REV " ).append("\n"); 
		query.append("	               ,C1.TRD_CD " ).append("\n"); 
		query.append("	               ,'' SUB_TRD_CD " ).append("\n"); 
		query.append("	               ,C1.RLANE_CD " ).append("\n"); 
		query.append("	               ,C1.SKD_DIR_CD " ).append("\n"); 
		query.append("	               ,@[cre_usr_id] " ).append("\n"); 
		query.append("	               ,SYSDATE" ).append("\n"); 
		query.append("	               ,@[upd_usr_id] " ).append("\n"); 
		query.append("	               ,SYSDATE" ).append("\n"); 
		query.append("	           FROM ( " ).append("\n"); 
		query.append("	                  SELECT B2.SIM_DT " ).append("\n"); 
		query.append("	                        ,B2.SIM_NO " ).append("\n"); 
		query.append("	                        ,B2.TRD_CD " ).append("\n"); 
		query.append("	                        ,B2.RLANE_CD " ).append("\n"); 
		query.append("	                        ,B2.SKD_DIR_CD " ).append("\n"); 
		query.append("	                        ,B2.IOC_CD " ).append("\n"); 
		query.append("	                        ,B2.NUM " ).append("\n"); 
		query.append("	                        ,B2.SECT_NO " ).append("\n"); 
		query.append("	                        ,B2.POL_CD " ).append("\n"); 
		query.append("	                        ,B2.POD_CD " ).append("\n"); 
		query.append("	                        ,B2.LOD_TTL_QTY " ).append("\n"); 
		query.append("	                        ,SUM(DECODE(B1.SGRP_COST_CD, 'LOAD', B1.SIM_PERF_AMT)) LOAD_QTY " ).append("\n"); 
		query.append("	                        ,SUM(DECODE(B1.SGRP_COST_CD, 'FRRE', B1.SIM_PERF_AMT)) REV " ).append("\n"); 
		query.append("	                    FROM MAS_SIM_SMRY B1 " ).append("\n"); 
		query.append("	                        ,( " ).append("\n"); 
		query.append("	                          SELECT A1.SIM_DT " ).append("\n"); 
		query.append("	                                ,A1.SIM_NO " ).append("\n"); 
		query.append("	                                ,A1.TRD_CD " ).append("\n"); 
		query.append("	                                ,A1.RLANE_CD " ).append("\n"); 
		query.append("	                                ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("	                                ,A1.IOC_CD " ).append("\n"); 
		query.append("	                                ,A2.POL_CD " ).append("\n"); 
		query.append("	                                ,A3.POD_CD " ).append("\n"); 
		query.append("	                                ,A2.NUM " ).append("\n"); 
		query.append("	                                ,A2.SECT_NO " ).append("\n"); 
		query.append("	                                ,A1.LOD_TTL_QTY " ).append("\n"); 
		query.append("	                            FROM MAS_SIM_SVC_LANE A1 " ).append("\n"); 
		query.append("	                                 ,( " ).append("\n"); 
		query.append("				#if (${rowcnt} > 0) " ).append("\n"); 
		query.append("					#set($i = 1)	        	" ).append("\n"); 
		query.append("		        	#foreach(${key} in ${parentArr})" ).append("\n"); 
		query.append("	        		                          SELECT '${key.dTmlCd}' AS POL_CD, '${key.dNum}' AS NUM, '${key.dSectNo}' AS SECT_NO FROM DUAL " ).append("\n"); 
		query.append("		        		#if(${rowcnt} > $i) " ).append("\n"); 
		query.append("							UNION ALL" ).append("\n"); 
		query.append("							#set ($i = $i+1)	        		" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                	#end" ).append("\n"); 
		query.append("			    #end" ).append("\n"); 
		query.append("	    	    #if(${rowcnt} == 0 )" ).append("\n"); 
		query.append("	        	                          SELECT ' ' AS POL_CD,  0 AS NUM, '' AS SECT_NO FROM DUAL " ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	                                  ) a2 " ).append("\n"); 
		query.append("	                                 ,( " ).append("\n"); 
		query.append("				#if (${rowcnt} > 0) " ).append("\n"); 
		query.append("					#set($i = 1)	        	" ).append("\n"); 
		query.append("		        	#foreach(${key} in ${parentArr})" ).append("\n"); 
		query.append("	        		                          SELECT '${key.dTmlCd}' AS POD_CD, '${key.dNum}' AS NUM, '${key.dSectNo}' AS SECT_NO FROM DUAL " ).append("\n"); 
		query.append("		        		#if(${rowcnt} > $i) " ).append("\n"); 
		query.append("							UNION ALL" ).append("\n"); 
		query.append("							#set ($i = $i+1)	        		" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                	#end" ).append("\n"); 
		query.append("			    #end" ).append("\n"); 
		query.append("	    	    #if(${rowcnt} == 0 )" ).append("\n"); 
		query.append("	        	                          SELECT ' ' AS POD_CD,  0 AS NUM, '' AS SECT_NO FROM DUAL " ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	                                  ) A3 " ).append("\n"); 
		query.append("	                           WHERE A2.SECT_NO = A3.SECT_NO " ).append("\n"); 
		query.append("	                             AND A1.SECT_NO = A2.SECT_NO " ).append("\n"); 
		query.append("	                             AND A1.SIM_DT  = @[sim_dt] " ).append("\n"); 
		query.append("	                             AND A1.SIM_NO  = @[sim_no] " ).append("\n"); 
		query.append("	                        ) B2 " ).append("\n"); 
		query.append("	                   WHERE 1=1 " ).append("\n"); 
		query.append("	                     AND B1.POL_CD       = B2.POL_CD " ).append("\n"); 
		query.append("	                     AND B1.POD_CD       = B2.POD_CD " ).append("\n"); 
		query.append("	                     AND B1.SGRP_COST_CD IN ('LOAD','FRRE') " ).append("\n"); 
		query.append("	                     AND B1.COST_YRMON   >= TO_CHAR(ADD_MONTHS(SYSDATE,-${prd_cd}),'YYYYMM') " ).append("\n"); 
		query.append("	                     AND B1.TRD_CD       = B2.TRD_CD " ).append("\n"); 
		query.append("	                     AND B1.DIR_CD       = B2.SKD_DIR_CD " ).append("\n"); 
		query.append("					#if (${trd_cd} != '') " ).append("\n"); 
		query.append("						 AND B1.TRD_CD       = @[trd_cd] " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("			        #if (${rlane_cd} != '')              " ).append("\n"); 
		query.append("						 AND B1.RLANE_CD     = @[rlane_cd] " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("			        #if(${dir_cd} != '')                " ).append("\n"); 
		query.append("						 AND B1.DIR_CD       = @[dir_cd] " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("	                   GROUP BY B2.SIM_DT " ).append("\n"); 
		query.append("	                           ,B2.SIM_NO " ).append("\n"); 
		query.append("	                           ,B2.TRD_CD " ).append("\n"); 
		query.append("	                           ,B2.RLANE_CD " ).append("\n"); 
		query.append("	                           ,B2.SKD_DIR_CD " ).append("\n"); 
		query.append("	                           ,B2.IOC_CD " ).append("\n"); 
		query.append("	                           ,B2.NUM " ).append("\n"); 
		query.append("	                           ,B2.SECT_NO " ).append("\n"); 
		query.append("	                           ,B2.POL_CD " ).append("\n"); 
		query.append("	                           ,B2.POD_CD " ).append("\n"); 
		query.append("	                           ,B2.LOD_TTL_QTY " ).append("\n"); 
		query.append("	                ) C1 " ).append("\n"); 
		query.append("	          ORDER BY C1.SECT_NO,C1.NUM" ).append("\n"); 

	}
}