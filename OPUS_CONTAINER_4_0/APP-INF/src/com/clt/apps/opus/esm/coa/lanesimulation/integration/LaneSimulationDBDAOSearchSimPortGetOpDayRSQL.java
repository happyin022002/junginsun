/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimPortGetOpDayRSQL.java
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

public class LaneSimulationDBDAOSearchSimPortGetOpDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 프로포머 정보를 조회한다.
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimPortGetOpDayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimPortGetOpDayRSQL").append("\n"); 
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
		query.append("SELECT     " ).append("\n"); 
		query.append("            @[f_slan_cd] SLAN_CD" ).append("\n"); 
		query.append("           ,@[f_sim_dt] SIM_DT                                                                                                                " ).append("\n"); 
		query.append("           ,@[f_sim_no] SIM_NO                                                                                                                " ).append("\n"); 
		query.append("           ,B1.SKD_DIR_CD                                                                                                           " ).append("\n"); 
		query.append("           ,B1.PORT_CD" ).append("\n"); 
		query.append("           ,NVL(SUBSTR(B2.TML_CD,6,2),'XX') PORT_YD" ).append("\n"); 
		query.append("           ,B4.YD_NM TMNL_NAME                                                                      " ).append("\n"); 
		query.append("           ,B1.CLPT_SEQ AS VSL_DBL_CALL_SEQ                                                                                         " ).append("\n"); 
		query.append("           ,B1.PORT_ROTN_SEQ AS PORT_SEQ                                                                                            " ).append("\n"); 
		query.append("           ,ROUND((TO_NUMBER(B1.ETD_DY_NO*24*60 + SUBSTR(B1.ETD_TM_HRMNT,1,2)*60 + TO_NUMBER(SUBSTR(B1.ETD_TM_HRMNT,3,2)))          " ).append("\n"); 
		query.append("                  -TO_NUMBER(B1.ETB_DY_NO*24*60 + SUBSTR(B1.ETB_TM_HRMNT,1,2)*60 + TO_NUMBER(SUBSTR(B1.ETB_TM_HRMNT,3,2)))          " ).append("\n"); 
		query.append("                   )/(60*24)                                                                                                        " ).append("\n"); 
		query.append("                 ,3) PORT_DYS   " ).append("\n"); 
		query.append("           ,ROUND((B1.NEXT_ETB_DY_NO*24*60 + SUBSTR(B1.NEXT_ETB_TM_HRMNT,1,2)*60 + TO_NUMBER(SUBSTR(B1.NEXT_ETB_TM_HRMNT,3,2))      " ).append("\n"); 
		query.append("                  -B1.ETD_DY_NO*24*60 + SUBSTR(B1.ETD_TM_HRMNT,1,2)*60 + TO_NUMBER(SUBSTR(B1.ETD_TM_HRMNT,3,2))                     " ).append("\n"); 
		query.append("                   )/(60*24)                                                                                                        " ).append("\n"); 
		query.append("                 ,3) SEA_DYS   " ).append("\n"); 
		query.append("           ,B1.TURN_PORT_FLG" ).append("\n"); 
		query.append("           ,STND_SVC_SPD BZC_VSL_SPD                                                                                                " ).append("\n"); 
		query.append("       FROM (                                                                                                                       " ).append("\n"); 
		query.append("             SELECT A2.VSL_SLAN_CD                                                                                                  " ).append("\n"); 
		query.append("                   ,A2.SKD_DIR_CD                                                                                                   " ).append("\n"); 
		query.append("                   ,A2.PORT_CD    " ).append("\n"); 
		query.append("                   ,A2.YD_CD                                                                                                  " ).append("\n"); 
		query.append("                   ,A2.CLPT_SEQ                                                                                                     " ).append("\n"); 
		query.append("                   ,A2.PORT_ROTN_SEQ                                                                                                " ).append("\n"); 
		query.append("                   ,A2.ETB_DY_NO                                                                                                    " ).append("\n"); 
		query.append("                   ,A2.ETB_TM_HRMNT                                                                                                 " ).append("\n"); 
		query.append("                   ,A2.ETD_DY_NO                                                                                                    " ).append("\n"); 
		query.append("                   ,A2.ETD_TM_HRMNT                                                                                                 " ).append("\n"); 
		query.append("                   ,LEAD(A2.ETB_DY_NO) OVER(PARTITION BY A2.VSL_SLAN_CD                                                             " ).append("\n"); 
		query.append("             		                           ORDER BY A2.PORT_ROTN_SEQ) NEXT_ETB_DY_NO                                                " ).append("\n"); 
		query.append("                   ,LEAD(A2.ETB_TM_HRMNT) OVER(PARTITION BY A2.VSL_SLAN_CD                                                          " ).append("\n"); 
		query.append("             		                           ORDER BY A2.PORT_ROTN_SEQ) NEXT_ETB_TM_HRMNT                                             " ).append("\n"); 
		query.append("                   ,A2.TURN_PORT_FLG                                                                                                " ).append("\n"); 
		query.append("      		      ,A1.STND_SVC_SPD                                                                                                    " ).append("\n"); 
		query.append("      		      ,MAX(A2.PORT_ROTN_SEQ) OVER() MAX_SEQ " ).append("\n"); 
		query.append("               FROM VSK_PF_SKD A1                                                                                                   " ).append("\n"); 
		query.append("                   ,VSK_PF_SKD_DTL A2                                                                                               " ).append("\n"); 
		query.append("              WHERE A1.VSL_SLAN_CD   = A2.VSL_SLAN_CD                                                                               " ).append("\n"); 
		query.append("                AND A1.PF_SVC_TP_CD  = A2.PF_SVC_TP_CD                                                                              " ).append("\n"); 
		query.append("                AND A1.SLAN_STND_FLG = 'Y'   " ).append("\n"); 
		query.append("                --AND A1.MML_USD_FLG = 'Y'                                                                                       " ).append("\n"); 
		query.append("                --AND A1.PF_SRC_TP_CD  = 'P'                                                                                          " ).append("\n"); 
		query.append("                AND A1.VSL_SLAN_CD   = @[f_slan_cd]                                                                                            " ).append("\n"); 
		query.append("             ) B1                                                                                                                   " ).append("\n"); 
		query.append("            ,PRD_PORT_TML_MTX B2                                                                                                    " ).append("\n"); 
		query.append("            ,COA_SIM_TML_INFO B3" ).append("\n"); 
		query.append("            ,MDM_YARD B4                                                                                                     " ).append("\n"); 
		query.append("     WHERE 1=1                                                                                                                      " ).append("\n"); 
		query.append("       AND B1.PORT_CD        = B2.PORT_CD(+)                                                                                        " ).append("\n"); 
		query.append("       AND B1.VSL_SLAN_CD    = B2.VSL_SLAN_CD(+)                                                                                    " ).append("\n"); 
		query.append("       AND B1.SKD_DIR_CD     = B2.SKD_DIR_CD(+)                                                                                     " ).append("\n"); 
		query.append("       AND B2.CRR_CD(+)      = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()                                                                                                " ).append("\n"); 
		query.append("       AND B1.PORT_CD         =  SUBSTR(B3.TML_CD(+),1,5)                                                                           " ).append("\n"); 
		query.append("       AND B1.SKD_DIR_CD     =  B3.SKD_DIR_CD(+)                                                                                    " ).append("\n"); 
		query.append("       AND B3.SIM_DT(+)      =  @[f_sim_dt]                                                                                           		  " ).append("\n"); 
		query.append("       AND B3.SIM_NO(+)      =  @[f_sim_no]                                                                                                	  " ).append("\n"); 
		query.append("       AND B2.TML_CD         = B4.YD_CD(+)" ).append("\n"); 
		query.append("     ORDER BY B1.PORT_ROTN_SEQ" ).append("\n"); 

	}
}