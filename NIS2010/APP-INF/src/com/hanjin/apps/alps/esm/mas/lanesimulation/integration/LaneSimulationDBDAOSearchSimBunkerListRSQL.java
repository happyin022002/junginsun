/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimBunkerListRSQL.java
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

public class LaneSimulationDBDAOSearchSimBunkerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bunker List 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimBunkerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimBunkerListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("    DECODE(NVL(A3.SIM_DT,'*'), '*', 'I', 'R') IBFLAG " ).append("\n"); 
		query.append("    ,'Sec.'|| TO_NUMBER(A1.SECT_NO) AS SECT_DESC" ).append("\n"); 
		query.append("    ,A1.SECT_NO " ).append("\n"); 
		query.append("    ,A1.TRD_CD " ).append("\n"); 
		query.append("    ,A1.RLANE_CD " ).append("\n"); 
		query.append("    ,A1.IOC_CD " ).append("\n"); 
		query.append("    ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("    ,A2.VSL_CLSS_CAPA " ).append("\n"); 
		query.append("    ,DECODE(NVL(A3.BZC_VSL_SPD,0),0,A4.BZC_VSL_SPD,A3.BZC_VSL_SPD) BZC_VSL_SPD" ).append("\n"); 
		query.append("    ,A3.FOIL_SAIL_CSM " ).append("\n"); 
		query.append("    ,A3.FOIL_PORT_CSM " ).append("\n"); 
		query.append("    ,A3.FOIL_UC_AMT " ).append("\n"); 
		query.append("    ,A3.DOIL_CSM " ).append("\n"); 
		query.append("    ,A3.DOIL_UC_AMT  " ).append("\n"); 
		query.append("FROM MAS_SIM_SVC_LANE A1 " ).append("\n"); 
		query.append("    ,MAS_SIM_VSL_SET_INFO A2 " ).append("\n"); 
		query.append("    ,MAS_SIM_BNK_COST A3 " ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("    SELECT SIM_DT, SIM_NO, MAX(LNK_SPD) BZC_VSL_SPD --윤진영 수정 2009/11/24 BZC_VSL_SPD->LNK_SPD" ).append("\n"); 
		query.append("    FROM MAS_SIM_TML_INFO" ).append("\n"); 
		query.append("    WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("      AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("    GROUP BY SIM_DT, SIM_NO" ).append("\n"); 
		query.append("    ) A4" ).append("\n"); 
		query.append("WHERE A1.SIM_DT        = A2.SIM_DT(+)  " ).append("\n"); 
		query.append("  AND A1.SIM_NO        = A2.SIM_NO(+)  " ).append("\n"); 
		query.append("  AND A1.SECT_NO       = A2.SECT_NO(+)  " ).append("\n"); 
		query.append("  AND '1'              = A2.SIM_DIV_CD(+)  " ).append("\n"); 
		query.append("  AND A2.SIM_DT        = A3.SIM_DT(+)  " ).append("\n"); 
		query.append("  AND A2.SIM_NO        = A3.SIM_NO(+)  " ).append("\n"); 
		query.append("  AND A2.SECT_NO       = A3.SECT_NO(+)  " ).append("\n"); 
		query.append("  AND A2.VSL_CLSS_CAPA = A3.VSL_CLSS_CAPA(+)  " ).append("\n"); 
		query.append("  AND A1.SIM_DT        = A4.SIM_DT(+)" ).append("\n"); 
		query.append("  AND A1.SIM_NO        = A4.SIM_NO(+)" ).append("\n"); 
		query.append("  AND A2.VOP_CD        = 'SML'  " ).append("\n"); 
		query.append("  AND A1.SIM_DT        = @[f_sim_dt] " ).append("\n"); 
		query.append("  AND A1.SIM_NO        = @[f_sim_no] " ).append("\n"); 
		query.append("ORDER BY A1.SECT_NO " ).append("\n"); 
		query.append("       ,A1.RLANE_CD " ).append("\n"); 
		query.append("       ,A1.IOC_CD " ).append("\n"); 
		query.append("       ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("       ,A2.VSL_CLSS_CAPA" ).append("\n"); 

	}
}