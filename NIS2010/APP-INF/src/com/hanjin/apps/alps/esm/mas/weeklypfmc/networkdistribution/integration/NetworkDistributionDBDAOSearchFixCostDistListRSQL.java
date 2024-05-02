/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchFixCostDistListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.08.05 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchFixCostDistListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History----------------------------------
	  * 2010.11.23 김기종 [CHM-201006017-01] 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 추가 요청
	  * 2010.11.24 이행지 [CHM-201006375-01] Trunk IPC와 Ocean간 내부거래 신규 추가로 인한 기존로직에서 신규계정 제외하도록 수정
	  * 2013.05.06 김수정 [CHM-201324486][MAS] TS Allocation상 WK, Month Display 기능 추가
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchFixCostDistListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selrlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_seltrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchFixCostDistListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      M_COST_YRMON" ).append("\n"); 
		query.append("    , M_COST_WK" ).append("\n"); 
		query.append("    , M_TRD_CD                          AS M_TRD_CD" ).append("\n"); 
		query.append("    , M_RLANE_CD                        AS M_RLANE_CD" ).append("\n"); 
		query.append("    , M_IOC_CD                          AS M_IOC_CD" ).append("\n"); 
		query.append("    , M_VSL_CD                          AS M_VSL_CD" ).append("\n"); 
		query.append("    , M_SKD_VOY_NO                      AS M_SKD_VOY_NO" ).append("\n"); 
		query.append("    , M_DIR_CD                          AS M_DIR_CD" ).append("\n"); 
		query.append("    , M_TS_UC_AMT                       AS M_TS_UC_AMT" ).append("\n"); 
		query.append("	#if (${f_inout} == 'ESM_MAS_0179')" ).append("\n"); 
		query.append("	, DECODE(RNUM,1,SUM(M_HJS_SLS_AMT) OVER(PARTITION BY M_TRD_CD,M_RLANE_CD,M_IOC_CD,M_VSL_CD,M_SKD_VOY_NO,M_DIR_CD),'') AS M_HJS_SLS_AMT" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    , DECODE(RNUM,1,M_HJS_SLS_AMT,'')   AS M_HJS_SLS_AMT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, D_COST_YRMON" ).append("\n"); 
		query.append("	, D_COST_WK" ).append("\n"); 
		query.append("    , D_TRD_CD                          AS D_TRD_CD" ).append("\n"); 
		query.append("    , D_RLANE_CD                        AS D_RLANE_CD" ).append("\n"); 
		query.append("    , D_IOC_CD                          AS D_IOC_CD" ).append("\n"); 
		query.append("    , D_VVD_CD                          AS D_VVD_CD" ).append("\n"); 
		query.append("    , D_LOCL_TS_STS_CD                  AS D_LOCL_TS_STS_CD" ).append("\n"); 
		query.append("    , D_TS_QTY                          AS D_TS_QTY" ).append("\n"); 
		query.append("    , D_TS_RTO                          AS D_TS_RTO" ).append("\n"); 
		query.append("    , D_FX_COST_DTRB_AMT                AS D_FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("    , D_CML_BSE_COST_AMT                AS D_CML_BSE_COST_AMT" ).append("\n"); 
		query.append("    , D_BSA_BSE_COST_AMT                AS D_BSA_BSE_COST_AMT" ).append("\n"); 
		query.append("    , D_TS_CTRB_BSE_COST_AMT            AS D_TS_CTRB_BSE_COST_AMT" ).append("\n"); 
		query.append("    , D_CMMT_QTY                        AS D_CMMT_QTY" ).append("\n"); 
		query.append("    , D_CMMT_BSE_COST_RTO               AS D_CMMT_BSE_COST_RTO" ).append("\n"); 
		query.append("    , D_CMMT_BSE_COST_AMT               AS D_CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("	, D_CMMT_ADD_COST_AMT" ).append("\n"); 
		query.append("	, D_CMMT_DIFF_COST_AMT" ).append("\n"); 
		query.append("	, D_CMMT_FNL_COST_AMT " ).append("\n"); 
		query.append("    , REV_AMT + DMDT_COM_AMT - CM_COST_AMT AS ALOC_CM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("            A.COST_YRMON                                                                                                  AS M_COST_YRMON" ).append("\n"); 
		query.append("           ,A.COST_WK                                                                                                     AS M_COST_WK" ).append("\n"); 
		query.append("           ,A.TRD_CD                                                                                                      AS M_TRD_CD" ).append("\n"); 
		query.append("           ,A.RLANE_CD                                                                                                    AS M_RLANE_CD" ).append("\n"); 
		query.append("           ,A.IOC_CD                                                                                                      AS M_IOC_CD" ).append("\n"); 
		query.append("           ,A.VSL_CD                                                                                                      AS M_VSL_CD" ).append("\n"); 
		query.append("           ,A.SKD_VOY_NO                                                                                                  AS M_SKD_VOY_NO" ).append("\n"); 
		query.append("           ,A.DIR_CD     																								  AS M_DIR_CD" ).append("\n"); 
		query.append("		  #if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("		   ,SUM(B.N4TH_TS_UC_AMT) AS M_TS_UC_AMT" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("		   ,SUM(B.TS_UC_AMT) AS M_TS_UC_AMT" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("                                                                             " ).append("\n"); 
		query.append("		  #if (${f_inout} == 'ESM_MAS_0179')" ).append("\n"); 
		query.append("		  -------------------------------------------------" ).append("\n"); 
		query.append("			--TS Allocation3" ).append("\n"); 
		query.append("			#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("			,SUM(CASE WHEN B.LOCL_TS_STS_CD = 'LO' THEN B.N4TH_CMMT_FNL_COST_AMT ELSE 0 END) AS M_HJS_SLS_AMT " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,SUM(CASE WHEN B.LOCL_TS_STS_CD = 'LO' THEN B.CMMT_FNL_COST_AMT ELSE 0 END) AS M_HJS_SLS_AMT " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append(" 		  #else" ).append("\n"); 
		query.append("		  -------------------------------------------------" ).append("\n"); 
		query.append("		--TS Allocation1" ).append("\n"); 
		query.append("		  #if (${f_inout} == 'ESM_MAS_0047')" ).append("\n"); 
		query.append("		    #if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("		   		,(SELECT SUM(T.N4TH_HJS_SLS_AMT)  --//OP4관련추가" ).append("\n"); 
		query.append("		  	#else" ).append("\n"); 
		query.append("		   		,(SELECT SUM(T.HJS_SLS_AMT)  --//OP4관련추가" ).append("\n"); 
		query.append("		  	#end" ).append("\n"); 
		query.append("		  #else" ).append("\n"); 
		query.append("		--TS Allocation2,3" ).append("\n"); 
		query.append("			#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("		   		,(SELECT SUM(T.N4TH_HJS_SLS_AMT)  --//OP4관련추가" ).append("\n"); 
		query.append("		  	#else" ).append("\n"); 
		query.append("		   		,(SELECT SUM(T.HJS_SLS_AMT)  --//OP4관련추가" ).append("\n"); 
		query.append("		  	#end" ).append("\n"); 
		query.append("		  #end 		" ).append("\n"); 
		query.append("		  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       		FROM MAS_VVD_HIR T" ).append("\n"); 
		query.append("       		WHERE A.TRD_CD     = T.TRD_CD" ).append("\n"); 
		query.append("         	AND A.RLANE_CD   = T.RLANE_CD" ).append("\n"); 
		query.append("         	AND A.IOC_CD     = T.IOC_CD" ).append("\n"); 
		query.append("         	AND A.VSL_CD     = T.VSL_CD" ).append("\n"); 
		query.append("         	AND A.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("         	AND A.DIR_CD     = T.DIR_CD" ).append("\n"); 
		query.append("		 	AND t.stnd_cost_cd not in('43102011', '54600000')" ).append("\n"); 
		query.append("           	#if (${f_selcost} != '')" ).append("\n"); 
		query.append("              AND T.STND_COST_CD = @[f_selcost]" ).append("\n"); 
		query.append("           	#end" ).append("\n"); 
		query.append("        	)	 AS M_HJS_SLS_AMT" ).append("\n"); 
		query.append("		  #end   " ).append("\n"); 
		query.append("			-------------------------------------------------                                                                                                         " ).append("\n"); 
		query.append("           ,ROW_NUMBER() OVER(PARTITION BY A.TRD_CD,A.RLANE_CD,A.IOC_CD,A.VSL_CD,A.SKD_VOY_NO,A.DIR_CD ORDER BY A.TRD_CD) AS RNUM" ).append("\n"); 
		query.append("           ,D.COST_YRMON                                                                                                  AS D_COST_YRMON" ).append("\n"); 
		query.append("           ,D.COST_WK                                                                                                     AS D_COST_WK" ).append("\n"); 
		query.append("           ,B.TO_TRD_CD                                                                                                   AS D_TRD_CD" ).append("\n"); 
		query.append("           ,B.TO_RLANE_CD                                                                                                 AS D_RLANE_CD" ).append("\n"); 
		query.append("           ,B.TO_IOC_CD                                                                                                   AS D_IOC_CD" ).append("\n"); 
		query.append("           ,B.TO_VSL_CD||B.TO_SKD_VOY_NO||B.TO_SKD_DIR_CD                                                                 AS D_VVD_CD" ).append("\n"); 
		query.append("           ,B.LOCL_TS_STS_CD                                                                                              AS D_LOCL_TS_STS_CD" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("		  #if (${f_inout} == 'ESM_MAS_0179')" ).append("\n"); 
		query.append("		   ,MAX(B.CMMT_QTY)                                                                                               AS D_TS_QTY	" ).append("\n"); 
		query.append("		   ,MAX(B.CMMT_BSE_COST_RTO)*100                                                                                  AS D_TS_RTO" ).append("\n"); 
		query.append("		  #else	" ).append("\n"); 
		query.append("		   ,MAX(C.TS_QTY)                                                                                                 AS D_TS_QTY	" ).append("\n"); 
		query.append("           ,MAX(C.TS_RTO)*100                                                                                             AS D_TS_RTO" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${f_inout} == 'ESM_MAS_0179')" ).append("\n"); 
		query.append("			--TS Allocation3" ).append("\n"); 
		query.append("			#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("				,SUM(B.N4TH_CMMT_ALOC_COST_AMT)     AS D_FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				,SUM(B.CMMT_ALOC_COST_AMT)    AS D_FX_COST_DTRB_AMT " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			--TS Allocation 1,2" ).append("\n"); 
		query.append("			#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("		   		,SUM(B.N4TH_FX_COST_DTRB_AMT)     AS D_FX_COST_DTRB_AMT " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				,SUM(B.FX_COST_DTRB_AMT)    AS D_FX_COST_DTRB_AMT " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("		   ,NULL      AS D_CML_BSE_COST_AMT" ).append("\n"); 
		query.append("		   ,NULL      AS D_BSA_BSE_COST_AMT " ).append("\n"); 
		query.append("		   ,NULL 	  AS D_TS_CTRB_BSE_COST_AMT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${f_selcost} != '')" ).append("\n"); 
		query.append("			    ,SUM(B.CMMT_QTY) AS D_CMMT_QTY " ).append("\n"); 
		query.append("			    ,SUM(B.N4TH_CMMT_BSE_COST_RTO)*100 AS D_CMMT_BSE_COST_RTO " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			    ,MAX(B.CMMT_QTY) AS D_CMMT_QTY " ).append("\n"); 
		query.append("			    ,CASE WHEN B.TO_TRD_CD NOT IN ('AES','TPS')  THEN NULL ELSE MAX(B.N4TH_CMMT_BSE_COST_RTO)*100 END AS D_CMMT_BSE_COST_RTO " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   ,SUM(B.N4TH_CMMT_BSE_COST_AMT) AS D_CMMT_BSE_COST_AMT " ).append("\n"); 
		query.append("		   ,SUM(B.N4TH_CMMT_ADD_COST_AMT) AS D_CMMT_ADD_COST_AMT" ).append("\n"); 
		query.append("		   ,SUM(B.N4TH_CMMT_DIFF_COST_AMT) AS D_CMMT_DIFF_COST_AMT	" ).append("\n"); 
		query.append("		   ,SUM(B.N4TH_CMMT_FNL_COST_AMT) AS D_CMMT_FNL_COST_AMT " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		   ,SUM(B.CML_BSE_COST_AMT)      AS D_CML_BSE_COST_AMT " ).append("\n"); 
		query.append("		   ,SUM(B.BSA_BSE_COST_AMT)      AS D_BSA_BSE_COST_AMT " ).append("\n"); 
		query.append("		   ,SUM(B.TS_CTRB_BSE_COST_AMT)  AS D_TS_CTRB_BSE_COST_AMT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${f_selcost} != '')" ).append("\n"); 
		query.append("			    ,SUM(B.CMMT_QTY) AS D_CMMT_QTY " ).append("\n"); 
		query.append("			    ,SUM(B.CMMT_BSE_COST_RTO)*100 AS D_CMMT_BSE_COST_RTO " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			    ,MAX(B.CMMT_QTY) AS D_CMMT_QTY " ).append("\n"); 
		query.append("				,CASE WHEN B.TO_TRD_CD NOT IN ('AES','TPS')  THEN NULL ELSE MAX(B.CMMT_BSE_COST_RTO)*100 END  AS D_CMMT_BSE_COST_RTO " ).append("\n"); 
		query.append("			   -- ,CASE WHEN SUM(B.CMMT_ADD_COST_AMT) =0 OR  B.TO_TRD_CD='IAS'  THEN NULL ELSE MAX(B.CMMT_BSE_COST_RTO)*100 END AS D_CMMT_BSE_COST_RTO " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			,SUM(B.CMMT_BSE_COST_AMT) AS D_CMMT_BSE_COST_AMT " ).append("\n"); 
		query.append("			,SUM(B.CMMT_ADD_COST_AMT) AS D_CMMT_ADD_COST_AMT" ).append("\n"); 
		query.append("			,SUM(B.CMMT_DIFF_COST_AMT) AS D_CMMT_DIFF_COST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,SUM(B.CMMT_FNL_COST_AMT) AS D_CMMT_FNL_COST_AMT " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			,MAX(B.REV_AMT) AS REV_AMT " ).append("\n"); 
		query.append("			,MAX(B.DMDT_COM_AMT) AS DMDT_COM_AMT " ).append("\n"); 
		query.append("			,MAX(B.CM_COST_AMT) AS CM_COST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM MAS_MON_VVD     A" ).append("\n"); 
		query.append("            ,MAS_FX_AMT_DTRB B" ).append("\n"); 
		query.append("            ,MAS_LANE_TS_QTY C" ).append("\n"); 
		query.append("            ,MAS_MON_VVD     D" ).append("\n"); 
		query.append("        WHERE A.TRD_CD        = B.FM_TRD_CD" ).append("\n"); 
		query.append("          AND A.RLANE_CD      = B.FM_RLANE_CD" ).append("\n"); 
		query.append("          AND A.IOC_CD        = B.FM_IOC_CD" ).append("\n"); 
		query.append("          AND A.VSL_CD        = B.FM_VSL_CD" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO    = B.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("          AND A.DIR_CD        = B.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("          AND B.FM_TRD_CD     = C.FM_TRD_CD" ).append("\n"); 
		query.append("          AND B.FM_RLANE_CD   = C.FM_RLANE_CD" ).append("\n"); 
		query.append("          AND B.FM_IOC_CD     = C.FM_IOC_CD" ).append("\n"); 
		query.append("          AND B.FM_VSL_CD     = C.FM_VSL_CD" ).append("\n"); 
		query.append("          AND B.FM_SKD_VOY_NO = C.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("          AND B.FM_SKD_DIR_CD = C.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("          AND B.TO_TRD_CD     = C.TO_TRD_CD" ).append("\n"); 
		query.append("          AND B.TO_RLANE_CD   = C.TO_RLANE_CD" ).append("\n"); 
		query.append("          AND B.TO_IOC_CD     = C.TO_IOC_CD" ).append("\n"); 
		query.append("          AND B.TO_VSL_CD     = C.TO_VSL_CD" ).append("\n"); 
		query.append("          AND B.TO_SKD_VOY_NO = C.TO_SKD_VOY_NO" ).append("\n"); 
		query.append("          AND B.TO_SKD_DIR_CD = C.TO_SKD_DIR_CD" ).append("\n"); 
		query.append("          AND B.TO_TRD_CD     = D.TRD_CD(+)" ).append("\n"); 
		query.append("          AND B.TO_RLANE_CD   = D.RLANE_CD(+)" ).append("\n"); 
		query.append("          AND B.TO_IOC_CD     = D.IOC_CD(+)" ).append("\n"); 
		query.append("          AND B.TO_VSL_CD     = D.VSL_CD(+)" ).append("\n"); 
		query.append("          AND B.TO_SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND B.TO_SKD_DIR_CD = D.DIR_CD(+)" ).append("\n"); 
		query.append("          AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${f_seltrade} != '')" ).append("\n"); 
		query.append("             AND A.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_selrlane} != '')" ).append("\n"); 
		query.append("             AND A.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_selioc} != '')" ).append("\n"); 
		query.append("             AND A.IOC_CD = @[f_selioc]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("             AND A.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("             AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("             AND A.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_selcost} != '')" ).append("\n"); 
		query.append("             AND B.STND_COST_CD = @[f_selcost]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("              #if (${f_fm_mon} != '')" ).append("\n"); 
		query.append("                  AND A.COST_YRMON BETWEEN @[f_year] || @[f_fm_mon] AND @[f_year] || @[f_to_mon]" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("                  AND A.COST_YRMON like @[f_year] || '%'" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("           #elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("              AND A.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("              #if (${f_fm_wk} != '')" ).append("\n"); 
		query.append("                  AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		   #if (${f_inout} == 'ESM_MAS_0047')" ).append("\n"); 
		query.append("		      AND  NVL(DTRB_STEP_CD,'BZC') = 'BZC' 	 " ).append("\n"); 
		query.append("		   #elseif (${f_inout} == 'ESM_MAS_0050')	" ).append("\n"); 
		query.append("			  AND  NVL(DTRB_STEP_CD,'BZC') = 'CMT' 	 " ).append("\n"); 
		query.append("		   #elseif (${f_inout} == 'ESM_MAS_0179')" ).append("\n"); 
		query.append("			  AND (A.TRD_CD = 'IAS' AND B.TO_TRD_CD != 'TPS' AND B.TO_TRD_CD != 'AES')" ).append("\n"); 
		query.append("			  AND  NVL(DTRB_STEP_CD,'BZC') = 'CMT' 	 " ).append("\n"); 
		query.append("		   #end			" ).append("\n"); 
		query.append("        GROUP BY" ).append("\n"); 
		query.append("               A.COST_YRMON" ).append("\n"); 
		query.append("              ,A.COST_WK" ).append("\n"); 
		query.append("              ,A.TRD_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD" ).append("\n"); 
		query.append("              ,A.IOC_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.DIR_CD" ).append("\n"); 
		query.append("              ,D.COST_YRMON" ).append("\n"); 
		query.append("              ,D.COST_WK" ).append("\n"); 
		query.append("              ,B.TO_TRD_CD" ).append("\n"); 
		query.append("              ,B.TO_RLANE_CD" ).append("\n"); 
		query.append("              ,B.TO_IOC_CD" ).append("\n"); 
		query.append("              ,B.TO_VSL_CD||B.TO_SKD_VOY_NO||B.TO_SKD_DIR_CD" ).append("\n"); 
		query.append("              ,B.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("       ) x" ).append("\n"); 
		query.append("ORDER BY 1,2,3,4,5,6,7,8,9,10" ).append("\n"); 

	}
}