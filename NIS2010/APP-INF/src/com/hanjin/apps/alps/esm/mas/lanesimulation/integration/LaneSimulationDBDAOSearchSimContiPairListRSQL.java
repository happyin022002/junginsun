/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimContiPairListRSQL.java
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

public class LaneSimulationDBDAOSearchSimContiPairListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Simulation ContiPairList 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimContiPairListRSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimContiPairListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(A.FLAG,'1'), '0', 'FALSE', 'TRUE') FLAG" ).append("\n"); 
		query.append("          ,DECODE(NVL(A.FLAG,'*'), '*', 'I', 'R') IBFLAG" ).append("\n"); 
		query.append("          ,B.SLAN_CD" ).append("\n"); 
		query.append("          ,B.SIM_DT" ).append("\n"); 
		query.append("          ,B.SIM_NO" ).append("\n"); 
		query.append("          ,B.RLANE_CD" ).append("\n"); 
		query.append("          ,B.IOC_CD" ).append("\n"); 
		query.append("          ,B.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,B.TRD_CD" ).append("\n"); 
		query.append("          ,B.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,A.FM_CONTI_CD" ).append("\n"); 
		query.append("          ,A.TO_CONTI_CD" ).append("\n"); 
		query.append("          ,A.FM_CONTI_CD as ORG_FM_CONTI_CD" ).append("\n"); 
		query.append("          ,A.TO_CONTI_CD as ORG_TO_CONTI_CD" ).append("\n"); 
		query.append("          ,'' AS DELT_FLG" ).append("\n"); 
		query.append("          ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("          ,'' AS UPD_USR_ID  " ).append("\n"); 
		query.append("      FROM ( " ).append("\n"); 
		query.append("            SELECT '0' FLAG" ).append("\n"); 
		query.append("                  ,RLANE_CD" ).append("\n"); 
		query.append("                  ,VSL_SLAN_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,IOC_CD" ).append("\n"); 
		query.append("                  ,FM_CONTI_CD" ).append("\n"); 
		query.append("                  ,TO_CONTI_CD" ).append("\n"); 
		query.append("                  ,TRD_CD" ).append("\n"); 
		query.append("                  ,SUB_TRD_CD " ).append("\n"); 
		query.append("              FROM MDM_DTL_REV_LANE " ).append("\n"); 
		query.append("             UNION ALL " ).append("\n"); 
		query.append("            SELECT '1' FLAG" ).append("\n"); 
		query.append("                  ,RLANE_CD" ).append("\n"); 
		query.append("                  ,SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,IOC_CD" ).append("\n"); 
		query.append("                  ,FM_CONTI_CD, TO_CONTI_CD, TRD_CD, SUB_TRD_CD " ).append("\n"); 
		query.append("              FROM MAS_SIM_DTL_REV_LANE " ).append("\n"); 
		query.append("           ) A, " ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("            SELECT B2.SLAN_CD" ).append("\n"); 
		query.append("                  ,B1.SIM_DT" ).append("\n"); 
		query.append("                  ,B1.SIM_NO" ).append("\n"); 
		query.append("                  ,B1.TRD_CD" ).append("\n"); 
		query.append("                  ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                  ,B1.RLANE_CD" ).append("\n"); 
		query.append("                  ,B1.IOC_CD" ).append("\n"); 
		query.append("                  ,B1.SKD_DIR_CD " ).append("\n"); 
		query.append("              FROM MAS_SIM_SVC_LANE B1, MAS_SIM_INFO B2 " ).append("\n"); 
		query.append("             WHERE 1=1 " ).append("\n"); 
		query.append("               AND B1.SIM_DT  = B2.SIM_DT " ).append("\n"); 
		query.append("               AND B1.SIM_NO  = B2.SIM_NO " ).append("\n"); 
		query.append("               AND B2.SLAN_CD = @[slan_cd] " ).append("\n"); 
		query.append("               AND B1.SIM_DT  = @[sim_dt] " ).append("\n"); 
		query.append("               AND B1.SIM_NO  = @[sim_no] " ).append("\n"); 
		query.append("           ) B " ).append("\n"); 
		query.append("     WHERE 1=1 " ).append("\n"); 
		query.append("       AND A.RLANE_CD(+)   = B.RLANE_CD " ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD(+) = B.SKD_DIR_CD " ).append("\n"); 
		query.append("       AND A.IOC_CD(+)     = B.IOC_CD " ).append("\n"); 
		query.append("       AND B.RLANE_CD      = NVL(@[rlane_cd], B.RLANE_CD) " ).append("\n"); 
		query.append("     ORDER BY FLAG, NVL(A.RLANE_CD,B.RLANE_CD), NVL(A.SKD_DIR_CD,B.SKD_DIR_CD)" ).append("\n"); 

	}
}