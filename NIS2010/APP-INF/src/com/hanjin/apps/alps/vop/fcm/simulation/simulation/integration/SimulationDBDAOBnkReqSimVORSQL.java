/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SimulationDBDAOBnkReqSimVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.09
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2014.01.09 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seo Kwan Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOBnkReqSimVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bunker Request Simulation에 필요한 VVD 정보를 조회한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public SimulationDBDAOBnkReqSimVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOBnkReqSimVORSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("--BnkReqSimVO" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' FCM_SIM_CD," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_VOY_NO," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' FCM_SIM_SEQ," ).append("\n"); 
		query.append("'' FCM_SIM_DT," ).append("\n"); 
		query.append("'' VVD_SEQ," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_VOY_NO," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' VPS_PORT_CD," ).append("\n"); 
		query.append("'' CLPT_IND_SEQ," ).append("\n"); 
		query.append("'' YD_CD," ).append("\n"); 
		query.append("'' CLPT_SEQ," ).append("\n"); 
		query.append("'' SLAN_CD," ).append("\n"); 
		query.append("'' PF_SKD_TP_CD," ).append("\n"); 
		query.append("'' VVD," ).append("\n"); 
		query.append("'' SKD_CNG_STS_CD," ).append("\n"); 
		query.append("'' VPS_ETA_DT," ).append("\n"); 
		query.append("'' VPS_ETB_DT," ).append("\n"); 
		query.append("'' VPS_ETD_DT," ).append("\n"); 
		query.append("'' PORT_TM_HRS," ).append("\n"); 
		query.append("'' SEA_TM_HRS," ).append("\n"); 
		query.append("'' SEA_SPD," ).append("\n"); 
		query.append("'' ESTM_CSM_WGT," ).append("\n"); 
		query.append("'' AVG_CSM_WGT," ).append("\n"); 
		query.append("'' DEP_FOIL_WGT," ).append("\n"); 
		query.append("'' DEP_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("'' SUPL_WGT," ).append("\n"); 
		query.append("'' DAY_CSM_WGT," ).append("\n"); 
		query.append("'' PORT_CSM_WGT," ).append("\n"); 
		query.append("'' SAIL_ME_CSM_WGT," ).append("\n"); 
		query.append("'' SAIL_GNR_CSM_WGT," ).append("\n"); 
		query.append("'' PF_PORT_TM_HRS," ).append("\n"); 
		query.append("'' ACT_PORT_TM_HRS," ).append("\n"); 
		query.append("'' PF_SEA_TM_HRS," ).append("\n"); 
		query.append("'' ACT_SEA_TM_HRS," ).append("\n"); 
		query.append("'' PF_PORT_DIST," ).append("\n"); 
		query.append("'' ACT_PORT_DIST," ).append("\n"); 
		query.append("'' PF_SEA_SPD," ).append("\n"); 
		query.append("'' PF_BUFF_SPD," ).append("\n"); 
		query.append("'' TRND_LINE_TP_CD," ).append("\n"); 
		query.append("'' TRND_LINE_NO," ).append("\n"); 
		query.append("'' TRND_LINE_SEQ," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("WITH SKD AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VVD_SEQ," ).append("\n"); 
		query.append("        T2.PF_SKD_TP_CD," ).append("\n"); 
		query.append("        T3.VSL_CD," ).append("\n"); 
		query.append("        T3.SKD_VOY_NO," ).append("\n"); 
		query.append("        T3.SKD_DIR_CD," ).append("\n"); 
		query.append("        T3.VPS_PORT_CD," ).append("\n"); 
		query.append("        T3.CLPT_IND_SEQ," ).append("\n"); 
		query.append("        T3.YD_CD," ).append("\n"); 
		query.append("        T3.CLPT_SEQ," ).append("\n"); 
		query.append("        T3.SLAN_CD," ).append("\n"); 
		query.append("        T3.SKD_CNG_STS_CD," ).append("\n"); 
		query.append("        T3.VPS_ETA_DT," ).append("\n"); 
		query.append("        T3.VPS_ETB_DT," ).append("\n"); 
		query.append("        T3.VPS_ETD_DT," ).append("\n"); 
		query.append("        T3.PF_ETA_DT," ).append("\n"); 
		query.append("        T3.PF_ETB_DT," ).append("\n"); 
		query.append("        T3.PF_ETD_DT," ).append("\n"); 
		query.append("        T3.LNK_DIST," ).append("\n"); 
		query.append("        T3.LNK_SPD," ).append("\n"); 
		query.append("        T4.GMT_HRS," ).append("\n"); 
		query.append("        DECODE(NVL(T3.SKD_CNG_STS_CD, 'X'), 'S', 2, 1) SKIP_FLG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        -- TARGET VVD >>>>>" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        VVD_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT ROWNUM VVD_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("            FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("            AND N1ST_PORT_BRTH_DT >= (SELECT N1ST_PORT_BRTH_DT FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD=@[vsl_cd] AND SKD_VOY_NO=@[skd_voy_no] AND SKD_DIR_CD=@[skd_dir_cd])" ).append("\n"); 
		query.append("            ORDER BY N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE VVD_SEQ <= @[vvd_seq]" ).append("\n"); 
		query.append("        -- <<<<< TARGET VVD" ).append("\n"); 
		query.append("    )T1, VSK_VSL_SKD T2, VSK_VSL_PORT_SKD T3, MDM_LOCATION T4" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T2.VSL_CD=T3.VSL_CD" ).append("\n"); 
		query.append("    AND T2.SKD_VOY_NO=T3.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T2.SKD_DIR_CD=T3.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T3.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("    AND T3.VPS_PORT_CD=T4.LOC_CD" ).append("\n"); 
		query.append("    AND  DECODE(NVL(T3.SKD_CNG_STS_CD, 'X'), 'S', 2, 1) <> 2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    T1.VVD_SEQ," ).append("\n"); 
		query.append("    T1.PF_SKD_TP_CD," ).append("\n"); 
		query.append("    T1.VSL_CD," ).append("\n"); 
		query.append("    T1.SKD_VOY_NO," ).append("\n"); 
		query.append("    T1.SKD_DIR_CD," ).append("\n"); 
		query.append("    T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("    T1.VPS_PORT_CD," ).append("\n"); 
		query.append("    T1.CLPT_IND_SEQ," ).append("\n"); 
		query.append("    SUBSTR(T1.YD_CD, 6, 2) YD_CD," ).append("\n"); 
		query.append("    T1.CLPT_SEQ," ).append("\n"); 
		query.append("    T1.SLAN_CD," ).append("\n"); 
		query.append("    T1.SKD_CNG_STS_CD," ).append("\n"); 
		query.append("    TO_CHAR(T1.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') VPS_ETA_DT," ).append("\n"); 
		query.append("    TO_CHAR(T1.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') VPS_ETB_DT," ).append("\n"); 
		query.append("    TO_CHAR(T1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("    T1.PORT_TM_HRS," ).append("\n"); 
		query.append("    T1.SEA_TM_HRS," ).append("\n"); 
		query.append("    ROUND(NVL(T1.ACT_PORT_DIST, T1.PF_PORT_DIST)/T1.SEA_TM_HRS, 1) SEA_SPD," ).append("\n"); 
		query.append("    T1.PF_PORT_TM_HRS," ).append("\n"); 
		query.append("    T1.ACT_PORT_TM_HRS," ).append("\n"); 
		query.append("    T1.PF_SEA_TM_HRS," ).append("\n"); 
		query.append("    T1.ACT_SEA_TM_HRS," ).append("\n"); 
		query.append("    T1.PF_PORT_DIST," ).append("\n"); 
		query.append("    T1.ACT_PORT_DIST," ).append("\n"); 
		query.append("    T1.PF_SEA_SPD," ).append("\n"); 
		query.append("    T2.DEP_FOIL_WGT," ).append("\n"); 
		query.append("    T2.DEP_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.*," ).append("\n"); 
		query.append("        PORT_TM_HRS ACT_PORT_TM_HRS," ).append("\n"); 
		query.append("        ROUND((VPS_ETA_DT - PRE_VPS_ETD_DT)*24, 1) - (GMT_HRS - PRE_GMT_HRS)/60.0 SEA_TM_HRS," ).append("\n"); 
		query.append("        ROUND((VPS_ETA_DT - PRE_VPS_ETD_DT)*24, 1) - (GMT_HRS - PRE_GMT_HRS)/60.0 ACT_SEA_TM_HRS," ).append("\n"); 
		query.append("        ROUND((PF_ETA_DT - PRE_PF_ETD_DT)*24, 1) - (GMT_HRS - PRE_GMT_HRS)/60.0 PF_SEA_TM_HRS," ).append("\n"); 
		query.append("        (SELECT STND_DIST FROM VSK_PORT_DIST" ).append("\n"); 
		query.append("        WHERE FM_LOC_CD=T1.PRE_VPS_PORT_CD" ).append("\n"); 
		query.append("        AND TO_LOC_CD=T1.VPS_PORT_CD) ACT_PORT_DIST" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            SKD.*," ).append("\n"); 
		query.append("            LAG(VPS_PORT_CD) OVER(ORDER BY VVD_SEQ, CLPT_SEQ) PRE_VPS_PORT_CD," ).append("\n"); 
		query.append("            LAG(VPS_ETD_DT) OVER(ORDER BY VVD_SEQ, CLPT_SEQ) PRE_VPS_ETD_DT," ).append("\n"); 
		query.append("            LAG(PF_ETD_DT) OVER(ORDER BY VVD_SEQ, CLPT_SEQ) PRE_PF_ETD_DT," ).append("\n"); 
		query.append("            LAG(GMT_HRS) OVER(ORDER BY VVD_SEQ, CLPT_SEQ) PRE_GMT_HRS," ).append("\n"); 
		query.append("            LAG(LNK_DIST) OVER(ORDER BY VVD_SEQ, CLPT_SEQ) PF_PORT_DIST," ).append("\n"); 
		query.append("            LAG(LNK_SPD) OVER(ORDER BY VVD_SEQ, CLPT_SEQ) PF_SEA_SPD," ).append("\n"); 
		query.append("            ROUND((VPS_ETD_DT-VPS_ETA_DT)*24, 1) PORT_TM_HRS," ).append("\n"); 
		query.append("            ROUND((PF_ETD_DT-PF_ETA_DT)*24, 1) PF_PORT_TM_HRS" ).append("\n"); 
		query.append("        FROM SKD" ).append("\n"); 
		query.append("        WHERE SKIP_FLG=1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("            SKD.*," ).append("\n"); 
		query.append("            NULL PRE_VPS_PORT_CD," ).append("\n"); 
		query.append("            NULL PRE_VPS_ETD_DT," ).append("\n"); 
		query.append("            NULL PRE_PF_ETD_DT," ).append("\n"); 
		query.append("            NULL PRE_GMT_HRS," ).append("\n"); 
		query.append("            NULL PF_PORT_DIST," ).append("\n"); 
		query.append("            NULL PF_SEA_SPD," ).append("\n"); 
		query.append("            NULL PORT_TM_HRS," ).append("\n"); 
		query.append("            NULL PF_PORT_TM_HRS" ).append("\n"); 
		query.append("        FROM SKD" ).append("\n"); 
		query.append("        WHERE SKIP_FLG=2" ).append("\n"); 
		query.append("    )T1" ).append("\n"); 
		query.append(")T1, FCM_DEP_RPT T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD=T2.VSL_CD(+)" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO=T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD=T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND T1.VPS_PORT_CD=T2.DEP_PORT_CD(+)" ).append("\n"); 
		query.append("AND T1.CLPT_IND_SEQ=T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY VVD_SEQ, CLPT_SEQ" ).append("\n"); 

	}
}