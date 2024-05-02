/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimNWCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimNWCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NWCostList 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimNWCostListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimNWCostListRSQL").append("\n"); 
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
		query.append("               ,B2.RLANE_CD " ).append("\n"); 
		query.append("               ,B2.SKD_DIR_CD " ).append("\n"); 
		query.append("               ,B2.VSL_CAPA " ).append("\n"); 
		query.append("               ,B2.VSL_CD " ).append("\n"); 
		query.append("               ,B2.TML_CD " ).append("\n"); 
		query.append("               ,B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("               ,B2.APLY_VOY_RTO*100 AS DIR_ASGN_RTO" ).append("\n"); 
		query.append("               ,SUM(DECODE(B1.SGRP_COST_CD,'OVPC',B1.NTWK_COST_AMT)) AS PT_TF --PORT EXPENSE " ).append("\n"); 
		query.append("               ,SUM(DECODE(B1.SGRP_COST_CD,'OVCT',B1.NTWK_COST_AMT)) AS CL_TF --CANAL TRANSIT FEE " ).append("\n"); 
		query.append("               ,B2.PORT_DYS " ).append("\n"); 
		query.append("               ,B2.SEA_DYS " ).append("\n"); 
		query.append("               ,(B2.FO_S * B2.SEA_DYS * B2.FO_UC_AMT + B2.FO_P * B2.PORT_DYS * B2.FO_UC_AMT) F_O " ).append("\n"); 
		query.append("               ,(B2.DO_S * B2.TTL_TZ_DYS * B2.DO_UC_AMT)  D_O " ).append("\n"); 
		query.append("               ,B2.TTL_TZ_DYS AS TTL_DYS " ).append("\n"); 
		query.append("            #foreach(${header_value} IN ${header})        " ).append("\n"); 
		query.append("               ,SUM(DECODE(B1.SGRP_COST_CD,'${header_value}',B1.NTWK_COST_AMT)) AS ${header_value}" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("         	  ,B2.PORT_SEQ" ).append("\n"); 
		query.append("         	  ,B2.BSA_CAPA" ).append("\n"); 
		query.append("           FROM COA_SIM_NTWK_COST B1 " ).append("\n"); 
		query.append("               ,( " ).append("\n"); 
		query.append("                 SELECT A1.SIM_DT " ).append("\n"); 
		query.append("                       ,A1.SIM_NO " ).append("\n"); 
		query.append("                       ,A1.SECT_NO " ).append("\n"); 
		query.append("                       ,A1.RLANE_CD " ).append("\n"); 
		query.append("                       ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("                       ,A2.VSL_CAPA " ).append("\n"); 
		query.append("                       ,A2.VSL_CD " ).append("\n"); 
		query.append("                       ,A3.TML_CD " ).append("\n"); 
		query.append("                       ,A3.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("                       ,A3.APLY_VOY_RTO " ).append("\n"); 
		query.append("                       ,A3.PORT_DYS " ).append("\n"); 
		query.append("                       ,A3.SEA_DYS " ).append("\n"); 
		query.append("                       ,A3.TTL_TZ_DYS " ).append("\n"); 
		query.append("                       ,A4.FOIL_SAIL_CSM AS FO_S " ).append("\n"); 
		query.append("                       ,A4.FOIL_PORT_CSM AS FO_P " ).append("\n"); 
		query.append("                       ,A4.FOIL_UC_AMT AS FO_UC_AMT " ).append("\n"); 
		query.append("                       ,A4.DOIL_CSM AS DO_S " ).append("\n"); 
		query.append("                       ,A4.DOIL_UC_AMT AS DO_UC_AMT " ).append("\n"); 
		query.append("         			  ,A3.PORT_SEQ" ).append("\n"); 
		query.append("         		      ,A2.BSA_CAPA" ).append("\n"); 
		query.append("                   FROM COA_SIM_SVC_LANE A1 " ).append("\n"); 
		query.append("                       ,COA_SIM_VSL_SET_INFO A2 " ).append("\n"); 
		query.append("                       ,COA_SIM_TML_OP_DYS A3 " ).append("\n"); 
		query.append("                       ,COA_SIM_BNK_COST A4 " ).append("\n"); 
		query.append("                  WHERE 1=1 " ).append("\n"); 
		query.append("                    AND A1.SIM_DT     = A2.SIM_DT " ).append("\n"); 
		query.append("                    AND A1.SIM_NO     = A2.SIM_NO " ).append("\n"); 
		query.append("                    AND A1.SECT_NO    = A2.SECT_NO " ).append("\n"); 
		query.append("                    AND A1.SIM_DT     = A3.SIM_DT " ).append("\n"); 
		query.append("                    AND A1.SIM_NO     = A3.SIM_NO " ).append("\n"); 
		query.append("                    AND A1.SECT_NO    = A3.SECT_NO " ).append("\n"); 
		query.append("                    AND A2.SIM_DT     = A4.SIM_DT " ).append("\n"); 
		query.append("                    AND A2.SIM_NO     = A4.SIM_NO " ).append("\n"); 
		query.append("                    AND A2.SECT_NO    = A4.SECT_NO " ).append("\n"); 
		query.append("                    AND A2.VSL_CLSS_CAPA = A4.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("                    AND A2.SIM_DIV_CD = '1' " ).append("\n"); 
		query.append("                    AND A1.SIM_DT     = @[sim_dt] " ).append("\n"); 
		query.append("                    AND A1.SIM_NO     = @[sim_no] " ).append("\n"); 
		query.append("                    AND A2.VOP_CD     = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("         --         ORDER BY A1.SECT_NO,A2.VSL_CD,A3.TML_CD " ).append("\n"); 
		query.append("                ) B2 " ).append("\n"); 
		query.append("          WHERE B1.SIM_DT(+)           = B2.SIM_DT " ).append("\n"); 
		query.append("            AND B1.SIM_NO(+)           = B2.SIM_NO " ).append("\n"); 
		query.append("            AND B1.SECT_NO(+)          = B2.SECT_NO " ).append("\n"); 
		query.append("            AND B1.VSL_CD(+)           = B2.VSL_CD " ).append("\n"); 
		query.append("            AND B1.TML_CD(+)           = B2.TML_CD " ).append("\n"); 
		query.append("            AND B1.VSL_DBL_CALL_SEQ(+) = B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("          GROUP BY B2.SECT_NO " ).append("\n"); 
		query.append("                  ,B2.RLANE_CD " ).append("\n"); 
		query.append("                  ,B2.SKD_DIR_CD " ).append("\n"); 
		query.append("                  ,B2.VSL_CAPA " ).append("\n"); 
		query.append("                  ,B2.VSL_CD " ).append("\n"); 
		query.append("                  ,B2.TML_CD " ).append("\n"); 
		query.append("                  ,B2.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("                  ,B2.APLY_VOY_RTO " ).append("\n"); 
		query.append("                  ,B2.PORT_DYS " ).append("\n"); 
		query.append("                  ,B2.SEA_DYS " ).append("\n"); 
		query.append("                  ,(B2.FO_S * B2.SEA_DYS * B2.FO_UC_AMT + B2.FO_P * B2.PORT_DYS * B2.FO_UC_AMT) " ).append("\n"); 
		query.append("                  ,(B2.DO_S * B2.TTL_TZ_DYS * B2.DO_UC_AMT) " ).append("\n"); 
		query.append("                  ,B2.TTL_TZ_DYS " ).append("\n"); 
		query.append("         	     ,B2.PORT_SEQ" ).append("\n"); 
		query.append("         	     ,B2.BSA_CAPA" ).append("\n"); 
		query.append("          ORDER BY B2.SECT_NO,B2.VSL_CD, B2.PORT_SEQ" ).append("\n"); 

	}
}