/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimVesselListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.03 윤진영
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

public class LaneSimulationDBDAOSearchSimVesselListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimVesselListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("setc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimVesselListRSQL").append("\n"); 
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
		query.append("SELECT  'R' FLAG, DECODE(NVL(C.VSL_CD, '*'), '*','Y','XXXX', 'N', 'N') VSL_FLG, C.VSL_CHG," ).append("\n"); 
		query.append("B.VSL_CD, B.VSL_CLSS_CAPA, C.VSL_OSHP_CD," ).append("\n"); 
		query.append("B.VOP_CD,DECODE(B.VOP_CD,'HJS',1,0) VOP_FLG, A.SKD_DIR_CD," ).append("\n"); 
		query.append("B.VSL_CAPA, B.BSA_CAPA, B.FNL_HJS_BSA_CAPA, B.LDF_RTO, B.OTR_CRR_BSA_CAPA1," ).append("\n"); 
		query.append("B.OTR_CRR_BSA_CAPA2,B.OTR_CRR_BSA_CAPA3,B.OTR_CRR_BSA_CAPA4,B.OTR_CRR_BSA_CAPA5, B.HJS_BFR_BSA_CAPA," ).append("\n"); 
		query.append("B.SUB_LSE_CAPA1, B.SUB_LSE_CAPA2, B.SUB_LSE_CAPA3, B.SUB_LSE_CAPA4, B.SUB_LSE_CAPA5," ).append("\n"); 
		query.append("B.SUB_CHTR_CAPA1, B.SUB_CHTR_CAPA2, B.SUB_CHTR_CAPA3, B.SUB_CHTR_CAPA4, B.SUB_CHTR_CAPA5," ).append("\n"); 
		query.append("B.SIM_DIV_CD, A.SIM_DT, A.SIM_NO, A.SECT_NO ,'' AS USER_ID" ).append("\n"); 
		query.append("FROM COA_SIM_SVC_LANE A," ).append("\n"); 
		query.append("COA_SIM_VSL_SET_INFO B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' VSL_CHG, VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM COA_VSL_RGST" ).append("\n"); 
		query.append("WHERE NVL(LST_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '0' VSL_CHG, VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_RGST" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE A.SIM_DT    = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO    = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO   = B.SECT_NO" ).append("\n"); 
		query.append("AND B.VSL_CD    = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SIM_DT    = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A.SIM_NO    = @[f_sim_no]" ).append("\n"); 
		query.append("AND A.SECT_NO   = @[sect_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD != '3'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'I' FLAG, DECODE(NVL(C.VSL_CD, '*'), '*', 'Y', 'N') VSL_FLG, C.VSL_CHG, B.VSL_CD, B.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("C.VSL_OSHP_CD, B.VOP_CD, DECODE(B.VOP_CD,'HJS',1,0) VOP_FLG," ).append("\n"); 
		query.append("@[dir_cd] SKD_DIR_CD,B.VSL_CAPA, B.BSA_CAPA, B.FNL_HJS_BSA_CAPA, 0 LDF_RTO," ).append("\n"); 
		query.append("0 OTR_CRR_BSA_CAPA1, 0 OTR_CRR_BSA_CAPA2,0 OTR_CRR_BSA_CAPA3,0 OTR_CRR_BSA_CAPA4,0 OTR_CRR_BSA_CAPA5," ).append("\n"); 
		query.append("0 HJS_BFR_BSA_CAPA," ).append("\n"); 
		query.append("0 SUB_LSE_CAPA1, 0 SUB_LSE_CAPA2,  0 SUB_LSE_CAPA3,  0 SUB_LSE_CAPA4,  0 SUB_LSE_CAPA5," ).append("\n"); 
		query.append("0 SUB_CHTR_CAPA1,0 SUB_CHTR_CAPA2, 0 SUB_CHTR_CAPA3, 0 SUB_CHTR_CAPA4, 0 SUB_CHTR_CAPA5," ).append("\n"); 
		query.append("B.SIM_DIV_CD, A.SIM_DT, A.SIM_NO," ).append("\n"); 
		query.append("@[setc_no],'' AS USER_ID" ).append("\n"); 
		query.append("FROM COA_SIM_SVC_LANE A," ).append("\n"); 
		query.append("COA_SIM_VSL_SET_INFO B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' VSL_CHG,VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM COA_VSL_RGST" ).append("\n"); 
		query.append("WHERE NVL(LST_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '0' VSL_CHG, VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_RGST" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE A.SIM_DT    = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO    = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO   = B.SECT_NO" ).append("\n"); 
		query.append("AND B.VSL_CD    = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SIM_DT    = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A.SIM_NO    = @[f_sim_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD  NOT IN ('2','3')" ).append("\n"); 
		query.append("AND B.VSL_CD   NOT IN(SELECT D.VSL_CD" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.SIM_DT    = @[f_sim_dt]" ).append("\n"); 
		query.append("AND D.SIM_NO    = @[f_sim_no]" ).append("\n"); 
		query.append("AND D.SECT_NO   = @[sect_no]" ).append("\n"); 
		query.append("AND D.SIM_DIV_CD NOT IN ('2','3')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.SECT_NO   = (SELECT MIN(SECT_NO)" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SIM_DT    = @[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO    = @[f_sim_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD != '3'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'I' FLAG, DECODE(NVL(C.VSL_CD, '*'), '*', 'Y', 'N') VSL_FLG, C.VSL_CHG, B.VSL_CD, B.VSL_CLSS_CAPA, C.VSL_OSHP_CD, B.VOP_CD, DECODE(B.VOP_CD,'HJS',1,0) VOP_FLG," ).append("\n"); 
		query.append("@[dir_cd] SKD_DIR_CD,B.VSL_CAPA, B.BSA_CAPA, B.FNL_HJS_BSA_CAPA, 0 LDF_RTO," ).append("\n"); 
		query.append("0 OTR_CRR_BSA_CAPA1, 0 OTR_CRR_BSA_CAPA2,0 OTR_CRR_BSA_CAPA3,0 OTR_CRR_BSA_CAPA4,0 OTR_CRR_BSA_CAPA5," ).append("\n"); 
		query.append("0 HJS_BFR_BSA_CAPA," ).append("\n"); 
		query.append("0 SUB_LSE_CAPA1, 0 SUB_LSE_CAPA2,  0 SUB_LSE_CAPA3,  0 SUB_LSE_CAPA4,  0 SUB_LSE_CAPA5," ).append("\n"); 
		query.append("0 SUB_CHTR_CAPA1,0 SUB_CHTR_CAPA2, 0 SUB_CHTR_CAPA3, 0 SUB_CHTR_CAPA4, 0 SUB_CHTR_CAPA5," ).append("\n"); 
		query.append("B.SIM_DIV_CD, A.SIM_DT, A.SIM_NO," ).append("\n"); 
		query.append("@[setc_no] SECT_NO,'' AS USER_ID" ).append("\n"); 
		query.append("FROM COA_SIM_SVC_LANE A," ).append("\n"); 
		query.append("COA_SIM_VSL_SET_INFO B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' VSL_CHG,VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM COA_VSL_RGST" ).append("\n"); 
		query.append("WHERE NVL(LST_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '0' VSL_CHG, VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA, VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_RGST" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE A.SIM_DT    = B.SIM_DT" ).append("\n"); 
		query.append("AND A.SIM_NO    = B.SIM_NO" ).append("\n"); 
		query.append("AND A.SECT_NO   = B.SECT_NO" ).append("\n"); 
		query.append("AND B.VSL_CD    = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SIM_DT    = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A.SIM_NO    = @[f_sim_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD  = '2'" ).append("\n"); 
		query.append("AND 'Y'         = NVL((SELECT 'OK'" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SIM_DT    = @[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO    = @[f_sim_no]" ).append("\n"); 
		query.append("AND SECT_NO   = @[sect_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD NOT IN ('1','3')" ).append("\n"); 
		query.append("AND ROWNUM < 2" ).append("\n"); 
		query.append("),'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.SECT_NO   = (SELECT MIN(SECT_NO)" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SIM_DT    = @[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO    = @[f_sim_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD != '3'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SIM_DIV_CD, VSL_CD" ).append("\n"); 

	}
}