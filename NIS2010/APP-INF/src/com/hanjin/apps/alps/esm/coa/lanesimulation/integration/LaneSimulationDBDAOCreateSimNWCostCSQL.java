/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimNWCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.15
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.11.15 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimNWCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History------------------------------
	  * 2010.11.15 이행지 [CHM-201006375-01] [COA] Trunk IPC와 Ocean간 내부거래 신규 추가로 인해서
	  *                                                         기존로직에서 제외하도록 수정
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimNWCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimNWCostCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_SIM_NTWK_COST(SIM_DT, SIM_NO, SECT_NO, VSL_CD, TML_CD, VSL_DBL_CALL_SEQ, " ).append("\n"); 
		query.append("                              VSL_CLSS_CAPA, VOP_CD,SGRP_COST_CD, NTWK_COST_AMT, " ).append("\n"); 
		query.append("                              AFT_OCN_TRNS_COST_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("	         SELECT " ).append("\n"); 
		query.append("	                C2.SIM_DT " ).append("\n"); 
		query.append("	               ,C2.SIM_NO " ).append("\n"); 
		query.append("	               ,C2.SECT_NO " ).append("\n"); 
		query.append("	               ,C2.VSL_CD " ).append("\n"); 
		query.append("	               ,C2.TML_CD " ).append("\n"); 
		query.append("	               ,C2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("	               ,C2.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("	               ,C2.VOP_CD " ).append("\n"); 
		query.append("	               ,C1.SGRP_COST_CD " ).append("\n"); 
		query.append("	               ,DECODE(C1.SGRP_COST_CD, 'OVPC', C2.OVPC " ).append("\n"); 
		query.append("	                                      , 'OVCT', C2.OVCT " ).append("\n"); 
		query.append("	                                      , 'OVBK', C2.OVBK " ).append("\n"); 
		query.append("	        	#foreach(${header_value} IN ${header})                               " ).append("\n"); 
		query.append("				   ,'${header_value}', c2.${header_value}" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("	                                      ) NTWK_COST_AMT " ).append("\n"); 
		query.append("	               ,DECODE(C1.SGRP_COST_CD, 'OVPC', C2.OVPC " ).append("\n"); 
		query.append("	                                      , 'OVCT', C2.OVCT " ).append("\n"); 
		query.append("	                                      , 'OVBK', C2.OVBK " ).append("\n"); 
		query.append("	        	#foreach(${header_value} IN ${header})                               " ).append("\n"); 
		query.append("				   ,'${header_value}', c2.${header_value}" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("	                                      ) * NVL2(C2.IOC_CD, DECODE(C2.IOC_CD,'I',(1-C2.HJS_RATIO * C2.LOCAL_RATIO),(1+C2.HJS_RATIO * C2.LOCAL_RATIO)), 1) AS AFT_OCN_TRNS_COST_AMT " ).append("\n"); 
		query.append("	               ,@[cre_usr_id]" ).append("\n"); 
		query.append("	               ,SYSDATE" ).append("\n"); 
		query.append("	               ,@[upd_usr_id]" ).append("\n"); 
		query.append("	               ,SYSDATE" ).append("\n"); 
		query.append("	           FROM ( " ).append("\n"); 
		query.append("	                SELECT ROW_NUMBER() OVER(ORDER BY STND_COST_CD) NUM,STND_COST_NM, STND_COST_CD, SGRP_COST_CD " ).append("\n"); 
		query.append("	                FROM COA_STND_ACCT " ).append("\n"); 
		query.append("	                WHERE MGRP_COST_CD IN ('OV', 'OF') " ).append("\n"); 
		query.append("	                  AND STND_COST_CD NOT IN ('54400000','92200000','92100000','54600000') " ).append("\n"); 
		query.append("	                ORDER BY 1 " ).append("\n"); 
		query.append("	                ) C1 " ).append("\n"); 
		query.append("	               ,( " ).append("\n"); 
		query.append("	                 SELECT " ).append("\n"); 
		query.append("	                        B1.SIM_DT " ).append("\n"); 
		query.append("	                       ,B1.SIM_NO " ).append("\n"); 
		query.append("	                       ,B1.SECT_NO " ).append("\n"); 
		query.append("	                       ,B1.VSL_CD " ).append("\n"); 
		query.append("	                       ,B2.TML_CD " ).append("\n"); 
		query.append("	                       ,B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("	                       ,B1.VOP_CD " ).append("\n"); 
		query.append("	                       ,B1.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("	                       ,B2.PT_TF * B2.APLY_VOY_RTO AS OVPC " ).append("\n"); 
		query.append("	                       ,B2.CL_TF * B2.APLY_VOY_RTO AS OVCT " ).append("\n"); 
		query.append("	                       ,NVL((B1.FO_S * B2.SEA_DYS * B1.FO_UC_AMT + B1.FO_P * B2.PORT_DYS * B1.FO_UC_AMT) + (B1.DO_S * B2.TTL_DYS * B1.DO_UC_AMT),0)  AS OVBK " ).append("\n"); 
		query.append("	        			#foreach(${header_value} IN ${header})                " ).append("\n"); 
		query.append("							,NVL(SUM(DECODE(B3.SGRP_COST_CD,'${header_value}',B3.VSL_DLY_COST_AMT)),0)*B2.TTL_DYS ${header_value}" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("	                       ,B1.HJS_RATIO " ).append("\n"); 
		query.append("	                       ,B4.IOC_CD " ).append("\n"); 
		query.append("	                       ,DECODE(B4.IOC_CD,'I', DECODE(NVL(B4.VSL_TRNS_QTY,0),0,0, B4.VSL_TRNS_QTY/(HJS_BSA+B4.VSL_TRNS_QTY))" ).append("\n"); 
		query.append("	                                        ,'O', DECODE(NVL(B4.VSL_TRNS_QTY,0),0,0, B4.VSL_TRNS_QTY/HJS_BSA)" ).append("\n"); 
		query.append("	                              ) LOCAL_RATIO" ).append("\n"); 
		query.append("	                 FROM " ).append("\n"); 
		query.append("	                     ( " ).append("\n"); 
		query.append("	                      SELECT " ).append("\n"); 
		query.append("	                             A1.SIM_DT " ).append("\n"); 
		query.append("	                            ,A1.SIM_NO " ).append("\n"); 
		query.append("	                            ,A1.SECT_NO " ).append("\n"); 
		query.append("	                            ,A1.RLANE_CD " ).append("\n"); 
		query.append("	                            ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("	                            ,A2.VSL_CD " ).append("\n"); 
		query.append("	                            ,A2.VOP_CD " ).append("\n"); 
		query.append("	                            ,A2.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("	                            ,A2.VSL_CAPA " ).append("\n"); 
		query.append("	                            ,A2.BSA_CAPA " ).append("\n"); 
		query.append("	                            ,DECODE(NVL(A2.BSA_CAPA,0),0,0,A2.FNL_HJS_BSA_CAPA/A2.BSA_CAPA) AS HJS_RATIO " ).append("\n"); 
		query.append("	                            ,A2.FNL_HJS_BSA_CAPA*A2.LDF_RTO AS HJS_BSA " ).append("\n"); 
		query.append("	                            ,A3.FOIL_SAIL_CSM AS FO_S " ).append("\n"); 
		query.append("	                            ,A3.FOIL_PORT_CSM AS FO_P " ).append("\n"); 
		query.append("	                            ,A3.FOIL_UC_AMT AS FO_UC_AMT " ).append("\n"); 
		query.append("	                            ,A3.DOIL_CSM AS DO_S " ).append("\n"); 
		query.append("	                            ,A3.DOIL_UC_AMT AS DO_UC_AMT " ).append("\n"); 
		query.append("	                      FROM COA_SIM_SVC_LANE A1 " ).append("\n"); 
		query.append("	                          ,COA_SIM_VSL_SET_INFO A2 " ).append("\n"); 
		query.append("	                          ,COA_SIM_BNK_COST A3 " ).append("\n"); 
		query.append("	                          ,( " ).append("\n"); 
		query.append("	                            SELECT VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA " ).append("\n"); 
		query.append("	                              FROM COA_VSL_RGST " ).append("\n"); 
		query.append("	                             WHERE DELT_FLG= 'N' " ).append("\n"); 
		query.append("	                             UNION ALL " ).append("\n"); 
		query.append("	                            SELECT VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA " ).append("\n"); 
		query.append("	                             FROM COA_SIM_VSL_RGST " ).append("\n"); 
		query.append("	                           ) A4 " ).append("\n"); 
		query.append("	                      WHERE A1.SIM_DT  = A2.SIM_DT(+) " ).append("\n"); 
		query.append("	                        AND A1.SIM_NO  = A2.SIM_NO(+) " ).append("\n"); 
		query.append("	                        AND A1.SECT_NO = A2.SECT_NO(+) " ).append("\n"); 
		query.append("	                        AND '1'        = A2.SIM_DIV_CD(+) " ).append("\n"); 
		query.append("	                        AND A2.SIM_DT  = A3.SIM_DT(+) " ).append("\n"); 
		query.append("	                        AND A2.SIM_NO  = A3.SIM_NO(+) " ).append("\n"); 
		query.append("	                        AND A2.SECT_NO = A3.SECT_NO(+) " ).append("\n"); 
		query.append("	                        AND A2.VSL_CLSS_CAPA = A3.VSL_CLSS_CAPA(+) " ).append("\n"); 
		query.append("	                        AND A2.VSL_CD  = A4.VSL_CD " ).append("\n"); 
		query.append("	                        AND A1.SIM_DT  = @[sim_dt] " ).append("\n"); 
		query.append("	                        AND A1.SIM_NO  = @[sim_no] " ).append("\n"); 
		query.append("	                        AND A2.VOP_CD  = 'HJS' " ).append("\n"); 
		query.append("	                     )  B1, -- VESSEL,  CLASS CAPA, BUNKER " ).append("\n"); 
		query.append("	                     ( " ).append("\n"); 
		query.append("	                      SELECT DISTINCT " ).append("\n"); 
		query.append("	                             A1.TML_CD " ).append("\n"); 
		query.append("	                            ,A1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("	                            ,A1.SECT_NO " ).append("\n"); 
		query.append("	                            ,A1.PORT_SEQ " ).append("\n"); 
		query.append("	                            ,A1.PORT_DYS " ).append("\n"); 
		query.append("	                            ,A1.SEA_DYS " ).append("\n"); 
		query.append("	                            ,A1.TTL_TZ_DYS TTL_DYS " ).append("\n"); 
		query.append("	                            ,A1.APLY_VOY_RTO " ).append("\n"); 
		query.append("	                            ,A2.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("	                            ,A2.PORT_TRF_AMT PT_TF " ).append("\n"); 
		query.append("	                            ,A2.CNL_FEE_AMT CL_TF " ).append("\n"); 
		query.append("	                      FROM COA_SIM_TML_OP_DYS A1 " ).append("\n"); 
		query.append("	                          ,COA_SIM_PORT_CHG A2 " ).append("\n"); 
		query.append("	                      WHERE A1.SIM_DT   = A2.SIM_DT " ).append("\n"); 
		query.append("	                        AND A1.SIM_NO   = A2.SIM_NO " ).append("\n"); 
		query.append("	                        AND A1.TML_CD   = A2.TML_CD " ).append("\n"); 
		query.append("	                        AND A1.SIM_DT   = @[sim_dt]" ).append("\n"); 
		query.append("	                        AND A1.SIM_NO   = @[sim_no] " ).append("\n"); 
		query.append("	                      ORDER BY A1.SECT_NO, A1.PORT_SEQ " ).append("\n"); 
		query.append("	                     ) B2, -- 운항일수, PORT_CHARGE AND CANAL FEE " ).append("\n"); 
		query.append("	                     ( " ).append("\n"); 
		query.append("	                      SELECT VSL_CD " ).append("\n"); 
		query.append("	                            ,SGRP_COST_CD " ).append("\n"); 
		query.append("	                            ,SUM(VSL_DLY_COST_AMT) VSL_DLY_COST_AMT " ).append("\n"); 
		query.append("	                      FROM COA_SIM_DLY_HIR " ).append("\n"); 
		query.append("	                      WHERE SIM_DT  = @[sim_dt] " ).append("\n"); 
		query.append("	                        AND SIM_NO  = @[sim_no] " ).append("\n"); 
		query.append("	                      GROUP BY VSL_CD,SGRP_COST_CD " ).append("\n"); 
		query.append("	                     ) B3 -- OWN FIXED DAILY HIRE " ).append("\n"); 
		query.append("	                     ,COA_SIM_INTR_TRNS_VOL B4 " ).append("\n"); 
		query.append("	                 WHERE B1.VSL_CLSS_CAPA = B2.VSL_CLSS_CAPA(+) " ).append("\n"); 
		query.append("	                   AND B1.SECT_NO        = B2.SECT_NO(+) " ).append("\n"); 
		query.append("	                   AND B1.VSL_CD         = B3.VSL_CD(+) " ).append("\n"); 
		query.append("	                   AND B1.SIM_DT         = B4.SIM_DT(+) " ).append("\n"); 
		query.append("	                   AND B1.SIM_NO         = B4.SIM_NO(+) " ).append("\n"); 
		query.append("	                   AND B1.VSL_CD         = B4.VSL_CD(+) " ).append("\n"); 
		query.append("	                   AND B1.SKD_DIR_CD     = B4.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("	                 GROUP BY B1.SIM_DT " ).append("\n"); 
		query.append("	                       ,B1.SIM_NO " ).append("\n"); 
		query.append("	                       ,B1.SECT_NO " ).append("\n"); 
		query.append("	                       ,B1.VSL_CD " ).append("\n"); 
		query.append("	                       ,B2.TML_CD " ).append("\n"); 
		query.append("	                       ,B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("	                       ,B1.VOP_CD " ).append("\n"); 
		query.append("	                       ,B1.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("	                       ,B2.PT_TF * B2.APLY_VOY_RTO " ).append("\n"); 
		query.append("	                       ,B2.CL_TF * B2.APLY_VOY_RTO " ).append("\n"); 
		query.append("	                       ,NVL((B1.FO_S * B2.SEA_DYS * B1.FO_UC_AMT + B1.FO_P * B2.PORT_DYS * B1.FO_UC_AMT) + (B1.DO_S * B2.TTL_DYS * B1.DO_UC_AMT),0) " ).append("\n"); 
		query.append("	                       ,B2.TTL_DYS " ).append("\n"); 
		query.append("	                       ,B1.HJS_RATIO " ).append("\n"); 
		query.append("	                       ,B4.IOC_CD " ).append("\n"); 
		query.append("	                       ,DECODE(B4.IOC_CD,'I', DECODE(NVL(B4.VSL_TRNS_QTY,0),0,0, B4.VSL_TRNS_QTY/(HJS_BSA+B4.VSL_TRNS_QTY))" ).append("\n"); 
		query.append("	                                        ,'O', DECODE(NVL(B4.VSL_TRNS_QTY,0),0,0, B4.VSL_TRNS_QTY/HJS_BSA)" ).append("\n"); 
		query.append("	                              ) " ).append("\n"); 
		query.append("	                ORDER BY B1.SECT_NO,B1.VSL_CD,B2.TML_CD " ).append("\n"); 
		query.append("	                ) C2 " ).append("\n"); 
		query.append("	           ORDER BY SECT_NO, VSL_CD,TML_CD,SGRP_COST_CD, VSL_CLSS_CAPA" ).append("\n"); 

	}
}