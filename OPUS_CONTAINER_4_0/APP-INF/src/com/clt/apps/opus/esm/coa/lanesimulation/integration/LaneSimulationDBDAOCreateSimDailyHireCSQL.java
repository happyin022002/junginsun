/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimDailyHireCSQL.java
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

public class LaneSimulationDBDAOCreateSimDailyHireCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DailyHire 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimDailyHireCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_yyyymm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("f_fm_yyyymm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimDailyHireCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_SIM_DLY_HIR(SIM_DT, SIM_NO, VSL_CD, SGRP_COST_CD, VSL_DLY_COST_AMT, VSL_DLY_UC_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("         SELECT DISTINCT " ).append("\n"); 
		query.append("                A1.SIM_DT " ).append("\n"); 
		query.append("               ,A1.SIM_NO " ).append("\n"); 
		query.append("               ,A1.VSL_CD " ).append("\n"); 
		query.append("               ,DECODE(A6.VSL_OSHP_CD, 'OWN', A4.SGRP_COST_CD, 'CHT', 'OFTC') SGRP_COST_CD " ).append("\n"); 
		query.append("               ,NVL(SUM(DECODE(A6.VSL_OSHP_CD,'OWN', A2.DHIR_AMT, 'CHT', A3.CHRG_DHIR_AMT)),0)/COUNT(A1.SIM_DT) DHIR_AMT " ).append("\n"); 
		query.append("               ,A5.VSL_DLY_UC_AMT " ).append("\n"); 
		query.append("               ,@[cre_usr_id] " ).append("\n"); 
		query.append("               ,SYSDATE " ).append("\n"); 
		query.append("               ,@[upd_usr_id] " ).append("\n"); 
		query.append("               ,SYSDATE " ).append("\n"); 
		query.append("         FROM COA_SIM_VSL_SET_INFO A1 " ).append("\n"); 
		query.append("             ,COA_OWN_VSL_DLY_HIR A2 " ).append("\n"); 
		query.append("             ,COA_CHRG_VSL_DLY_HIR A3 " ).append("\n"); 
		query.append("             ,COA_STND_ACCT A4 " ).append("\n"); 
		query.append("             ,COA_TM_CHTR_OUT_HIR A5 " ).append("\n"); 
		query.append("             ,( " ).append("\n"); 
		query.append("               SELECT VSL_CD " ).append("\n"); 
		query.append("                     ,VSL_CLSS_CAPA " ).append("\n"); 
		query.append("                     ,VSL_OSHP_CD " ).append("\n"); 
		query.append("                 FROM COA_VSL_RGST " ).append("\n"); 
		query.append("                WHERE VSL_TP_CD         = 'C' " ).append("\n"); 
		query.append("                  AND NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("               ) A6 --D " ).append("\n"); 
		query.append("         WHERE A1.VSL_CD        = A6.VSL_CD " ).append("\n"); 
		query.append("           AND A1.VSL_CD        = A2.VSL_CD(+) " ).append("\n"); 
		query.append("           AND A1.VSL_CLSS_CAPA = A2.VSL_CLSS_CAPA(+) " ).append("\n"); 
		query.append("           AND A1.VSL_CD        = A3.VSL_CD(+) " ).append("\n"); 
		query.append("           AND A2.STND_COST_CD  = A4.STND_COST_CD(+) " ).append("\n"); 
		query.append("           AND A1.VSL_CLSS_CAPA BETWEEN A5.FM_VSL_CLSS_CAPA(+) AND A5.TO_VSL_CLSS_CAPA(+) " ).append("\n"); 
		query.append("           AND A3.COST_YRMON(+) BETWEEN @[f_fm_yyyymm] AND @[f_to_yyyymm] " ).append("\n"); 
		query.append("           AND A2.COST_YRMON(+) BETWEEN @[f_fm_yyyymm] AND @[f_to_yyyymm] " ).append("\n"); 
		query.append("           AND A1.SIM_DT        = @[f_sim_dt] " ).append("\n"); 
		query.append("           AND A1.SIM_NO        = @[f_sim_no] " ).append("\n"); 
		query.append("           AND A1.SIM_DIV_CD    = '1' " ).append("\n"); 
		query.append("           AND A1.VOP_CD        = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("           AND DECODE(A6.VSL_OSHP_CD, 'OWN', A4.SGRP_COST_CD, 'CHT', 'OFTC') IS NOT NULL " ).append("\n"); 
		query.append("         GROUP BY A1.SIM_DT, A1.SIM_NO, A1.VSL_CD, A6.VSL_OSHP_CD, A4.SGRP_COST_CD,A5.VSL_DLY_UC_AMT" ).append("\n"); 

	}
}