/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimAfterOcenaTSListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class LaneSimulationDBDAOSearchSimAfterOcenaTSListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AfterOceanTSList 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimAfterOcenaTSListRSQL(){
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
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimAfterOcenaTSListRSQL").append("\n"); 
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
		query.append("SELECT B2.SECT_NO " ).append("\n"); 
		query.append("    	       ,B2.RLANE_CD " ).append("\n"); 
		query.append("    	       ,B2.SKD_DIR_CD " ).append("\n"); 
		query.append("    	       ,B2.VSL_CAPA " ).append("\n"); 
		query.append("    	       ,B2.VSL_CD " ).append("\n"); 
		query.append("    	       ,B2.TML_CD " ).append("\n"); 
		query.append("    	       ,B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	       ,DECODE(B3.IOC_CD,'I', DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,DECODE(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0),0,0,NVL(B3.VSL_TRNS_QTY,0)/(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0)))*100) " ).append("\n"); 
		query.append("    	                        ,'O', DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,DECODE(B2.HJS_BSA,0,0,NVL(B3.VSL_TRNS_QTY,0)/B2.HJS_BSA)*100)" ).append("\n"); 
		query.append("    	               )LOCAL_RTO " ).append("\n"); 
		query.append("    	       ,B2.APLY_VOY_RTO*100 AS DIR_ASGN_RTO " ).append("\n"); 
		query.append("    	       ,SUM(DECODE(B1.SGRP_COST_CD,'OVPC',B1.AFT_OCN_TRNS_COST_AMT)) AS PT_TF --PORT EXPENSE " ).append("\n"); 
		query.append("    	       ,SUM(DECODE(B1.SGRP_COST_CD,'OVCT',B1.AFT_OCN_TRNS_COST_AMT)) AS CL_TF --CANAL TRANSIT FEE " ).append("\n"); 
		query.append("    	       ,B2.PORT_DYS " ).append("\n"); 
		query.append("    	       ,B2.SEA_DYS " ).append("\n"); 
		query.append("    	       ,(B2.FO_S * B2.SEA_DYS * B2.FO_UC_AMT + B2.FO_P * B2.PORT_DYS * B2.FO_UC_AMT) *  " ).append("\n"); 
		query.append("    	         DECODE(B3.IOC_CD,'I'" ).append("\n"); 
		query.append("    	                            ,(1-DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO * DECODE((B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0)),0,0,NVL(B3.VSL_TRNS_QTY,0)/(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0))))) " ).append("\n"); 
		query.append("    	                            ,(1+DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO * DECODE(B2.HJS_BSA,0,0,NVL(B3.VSL_TRNS_QTY,0)/B2.HJS_BSA))) " ).append("\n"); 
		query.append("    	        )F_O" ).append("\n"); 
		query.append("		       ,(B2.DO_S * B2.TTL_TZ_DYS * B2.DO_UC_AMT)*   " ).append("\n"); 
		query.append("    	         DECODE(B3.IOC_CD,'I' " ).append("\n"); 
		query.append("    	                             ,(1-DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO* DECODE((B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0)),0,0,NVL(B3.VSL_TRNS_QTY,0)/(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0))))) " ).append("\n"); 
		query.append("    	                             ,(1+DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO* DECODE(B2.HJS_BSA,0,0,NVL(B3.VSL_TRNS_QTY,0)/B2.HJS_BSA))) " ).append("\n"); 
		query.append("		         )D_O " ).append("\n"); 
		query.append("    	       ,B2.TTL_TZ_DYS AS TTL_DYS " ).append("\n"); 
		query.append("    		#foreach(${header_value} IN ${header})        " ).append("\n"); 
		query.append("				,SUM(DECODE(B1.SGRP_COST_CD,'${header_value}',B1.AFT_OCN_TRNS_COST_AMT)) AS ${header_value}" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("    	   	  ,B2.BSA_CAPA" ).append("\n"); 
		query.append("    	   FROM MAS_SIM_NTWK_COST B1 " ).append("\n"); 
		query.append("    	       ,MAS_SIM_INTR_TRNS_VOL B3 " ).append("\n"); 
		query.append("    	       ,( " ).append("\n"); 
		query.append("    	         SELECT A1.SIM_DT " ).append("\n"); 
		query.append("    	               ,A1.SIM_NO " ).append("\n"); 
		query.append("    	               ,A1.SECT_NO " ).append("\n"); 
		query.append("    	               ,A1.RLANE_CD " ).append("\n"); 
		query.append("    	               ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("    	               ,A2.VSL_CAPA " ).append("\n"); 
		query.append("    	               ,A2.VSL_CD " ).append("\n"); 
		query.append("    	               ,A3.TML_CD " ).append("\n"); 
		query.append("    	               ,A3.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	               ,A3.APLY_VOY_RTO " ).append("\n"); 
		query.append("    	               ,A3.PORT_DYS " ).append("\n"); 
		query.append("    	               ,A3.SEA_DYS " ).append("\n"); 
		query.append("    	               ,A3.TTL_TZ_DYS " ).append("\n"); 
		query.append("    	               ,A4.FOIL_SAIL_CSM AS FO_S " ).append("\n"); 
		query.append("    	               ,A4.FOIL_PORT_CSM AS FO_P " ).append("\n"); 
		query.append("    	               ,A4.FOIL_UC_AMT AS FO_UC_AMT " ).append("\n"); 
		query.append("    	               ,A4.DOIL_CSM AS DO_S " ).append("\n"); 
		query.append("    	               ,A4.DOIL_UC_AMT AS DO_UC_AMT " ).append("\n"); 
		query.append("    	               ,A2.FNL_HJS_BSA_CAPA * A2.LDF_RTO HJS_BSA " ).append("\n"); 
		query.append("    	   	  		   ,A2.BSA_CAPA" ).append("\n"); 
		query.append("    	   	  		   ,A3.PORT_SEQ" ).append("\n"); 
		query.append("    	   	  		   ,DECODE(NVL(A2.BSA_CAPA,0),0,0,A2.FNL_HJS_BSA_CAPA/A2.BSA_CAPA) LDF_RTO" ).append("\n"); 
		query.append("    	           FROM MAS_SIM_SVC_LANE A1 " ).append("\n"); 
		query.append("    	               ,MAS_SIM_VSL_SET_INFO A2 " ).append("\n"); 
		query.append("    	               ,MAS_SIM_TML_OP_DYS A3 " ).append("\n"); 
		query.append("    	               ,MAS_SIM_BNK_COST A4 " ).append("\n"); 
		query.append("    	          WHERE 1=1 " ).append("\n"); 
		query.append("    	            AND A1.SIM_DT     = A2.SIM_DT " ).append("\n"); 
		query.append("    	            AND A1.SIM_NO     = A2.SIM_NO " ).append("\n"); 
		query.append("    	            AND A1.SECT_NO    = A2.SECT_NO " ).append("\n"); 
		query.append("    	            AND A1.SIM_DT     = A3.SIM_DT " ).append("\n"); 
		query.append("    	            AND A1.SIM_NO     = A3.SIM_NO " ).append("\n"); 
		query.append("    	            AND A1.SECT_NO    = A3.SECT_NO " ).append("\n"); 
		query.append("    	            AND A2.SIM_DT     = A4.SIM_DT " ).append("\n"); 
		query.append("    	            AND A2.SIM_NO     = A4.SIM_NO " ).append("\n"); 
		query.append("    	            AND A2.SECT_NO    = A4.SECT_NO " ).append("\n"); 
		query.append("    	            AND A2.VSL_CLSS_CAPA = A4.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("    	            AND A2.SIM_DIV_CD = '1' " ).append("\n"); 
		query.append("    	            AND A1.SIM_DT     = @[sim_dt] " ).append("\n"); 
		query.append("    	            AND A1.SIM_NO     = @[sim_no] " ).append("\n"); 
		query.append("    	            AND A2.VOP_CD  = 'SML' " ).append("\n"); 
		query.append("    	 --         ORDER BY A1.SECT_NO,A2.VSL_CD,A3.TML_CD " ).append("\n"); 
		query.append("    	        ) B2 " ).append("\n"); 
		query.append("    	  WHERE B1.SIM_DT(+)           = B2.SIM_DT " ).append("\n"); 
		query.append("    	    AND B1.SIM_NO(+)           = B2.SIM_NO " ).append("\n"); 
		query.append("    	    AND B1.SECT_NO(+)          = B2.SECT_NO " ).append("\n"); 
		query.append("    	    AND B1.VSL_CD(+)           = B2.VSL_CD " ).append("\n"); 
		query.append("    	    AND B1.TML_CD(+)           = B2.TML_CD " ).append("\n"); 
		query.append("    	    AND B1.VSL_DBL_CALL_SEQ(+) = B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	    AND B2.SIM_DT              = B3.SIM_DT(+) " ).append("\n"); 
		query.append("    	    AND B2.SIM_NO              = B3.SIM_NO(+) " ).append("\n"); 
		query.append("    	    AND B2.VSL_CD              = B3.VSL_CD(+) " ).append("\n"); 
		query.append("    	    AND B2.SKD_DIR_CD          = B3.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("       GROUP BY B2.SECT_NO " ).append("\n"); 
		query.append("    	       ,B2.RLANE_CD " ).append("\n"); 
		query.append("    	       ,B2.SKD_DIR_CD " ).append("\n"); 
		query.append("    	       ,B2.VSL_CAPA " ).append("\n"); 
		query.append("    	       ,B2.VSL_CD " ).append("\n"); 
		query.append("    	       ,B2.TML_CD " ).append("\n"); 
		query.append("    	       ,B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	       ,B2.APLY_VOY_RTO " ).append("\n"); 
		query.append("    	       ,DECODE(B3.IOC_CD,'I', DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,DECODE(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0),0,0,NVL(B3.VSL_TRNS_QTY,0)/(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0)))*100) " ).append("\n"); 
		query.append("    	                        ,'O', DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,DECODE(B2.HJS_BSA,0,0,NVL(B3.VSL_TRNS_QTY,0)/B2.HJS_BSA)*100)" ).append("\n"); 
		query.append("    	               ) " ).append("\n"); 
		query.append("    	       ,B2.PORT_DYS " ).append("\n"); 
		query.append("    	       ,B2.SEA_DYS " ).append("\n"); 
		query.append("    	       ,(B2.FO_S * B2.SEA_DYS * B2.FO_UC_AMT + B2.FO_P * B2.PORT_DYS * B2.FO_UC_AMT) *  " ).append("\n"); 
		query.append("    	         DECODE(B3.IOC_CD,'I'" ).append("\n"); 
		query.append("    	                            ,(1-DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO * DECODE((B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0)),0,0,NVL(B3.VSL_TRNS_QTY,0)/(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0))))) " ).append("\n"); 
		query.append("    	                            ,(1+DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO * DECODE(B2.HJS_BSA,0,0,NVL(B3.VSL_TRNS_QTY,0)/B2.HJS_BSA))) " ).append("\n"); 
		query.append("    	        )" ).append("\n"); 
		query.append("		       ,(B2.DO_S * B2.TTL_TZ_DYS * B2.DO_UC_AMT)*   " ).append("\n"); 
		query.append("    	         DECODE(B3.IOC_CD,'I' " ).append("\n"); 
		query.append("    	                             ,(1-DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO* DECODE((B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0)),0,0,NVL(B3.VSL_TRNS_QTY,0)/(B2.HJS_BSA+NVL(B3.VSL_TRNS_QTY,0))))) " ).append("\n"); 
		query.append("    	                             ,(1+DECODE(NVL(B3.VSL_TRNS_QTY,0),0,0,B2.LDF_RTO* DECODE(B2.HJS_BSA,0,0,NVL(B3.VSL_TRNS_QTY,0)/B2.HJS_BSA))) " ).append("\n"); 
		query.append("		         ) " ).append("\n"); 
		query.append("    	       ,B2.TTL_TZ_DYS " ).append("\n"); 
		query.append("    	   	   ,B2.BSA_CAPA" ).append("\n"); 
		query.append("    	   	   ,B2.PORT_SEQ" ).append("\n"); 
		query.append("    	 ORDER BY B2.SECT_NO,B2.VSL_CD,B2.PORT_SEQ" ).append("\n"); 

	}
}