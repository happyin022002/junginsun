/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOSearchOceanRouteYDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.15
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.04.15 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOSearchOceanRouteYDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 POL, POD 기준의 Ocean Route 와 
	  * 각 Port 별 Yard 를 Proformer Schedule 및 TES 의 Main Yard 정보를 조회하여 가져온다.
	  * </pre>
	  */
	public ScqAwkwardDBDAOSearchOceanRouteYDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOSearchOceanRouteYDListRSQL").append("\n"); 
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
		query.append("SELECT ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ" ).append("\n"); 
		query.append("   ,   N1ST_POL_CD POL1, N1ST_POD_CD POD1, N1ST_LANE_CD LANE1, N1ST_SKD_DIR_CD DIR1, N1ST_LANE_FDR_FLG FDR_FLG1" ).append("\n"); 
		query.append("   ,   (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N1ST_LANE_CD) SVC_TP1" ).append("\n"); 
		query.append("   ,   N2ND_POL_CD POL2, N2ND_POD_CD POD2, N2ND_LANE_CD LANE2, N2ND_SKD_DIR_CD DIR2, N2ND_LANE_FDR_FLG FDR_FLG2" ).append("\n"); 
		query.append("   ,   (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N2ND_LANE_CD) SVC_TP2" ).append("\n"); 
		query.append("   ,   N3RD_POL_CD POL3, N3RD_POD_CD POD3, N3RD_LANE_CD LANE3, N3RD_SKD_DIR_CD DIR3, N3RD_LANE_FDR_FLG FDR_FLG3" ).append("\n"); 
		query.append("   ,   (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N3RD_LANE_CD) SVC_TP3" ).append("\n"); 
		query.append("   ,   N4TH_POL_CD POL4, N4TH_POD_CD POD4, N4TH_LANE_CD LANE4, N4TH_SKD_DIR_CD DIR4, N4TH_LANE_FDR_FLG FDR_FLG4" ).append("\n"); 
		query.append("   ,   (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N4TH_LANE_CD) SVC_TP4" ).append("\n"); 
		query.append("   ,   OCN_ROUT_PRIO_CD PRIO, OCN_ROUT_USR_RMK RMK" ).append("\n"); 
		query.append("   ,   (N1ST_TZTM_HRS + N2ND_TZTM_HRS + N3RD_TZTM_HRS + N4TH_TZTM_HRS) TZTM_HRS" ).append("\n"); 
		query.append("   ,   ltrim(to_char(trunc((N1ST_TZTM_HRS + N2ND_TZTM_HRS + N3RD_TZTM_HRS + N4TH_TZTM_HRS)/24),'00'))||ltrim(to_char(mod((N1ST_TZTM_HRS + N2ND_TZTM_HRS + N3RD_TZTM_HRS + N4TH_TZTM_HRS),24  ),'00')) fmt_tztm_hrs " ).append("\n"); 
		query.append("   ,   N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS" ).append("\n"); 
		query.append("   ,   (N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS) ST_HRS" ).append("\n"); 
		query.append("   ,   ltrim(to_char(trunc((N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS)/24),'00'))||ltrim(to_char(mod((N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS),24  ),'00')) fmt_st_hrs " ).append("\n"); 
		query.append("   ,   N1ST_STAY_TM_HRS/24 N1ST_STAY_TM_HRS, N2ND_STAY_TM_HRS/24 N2ND_STAY_TM_HRS, N3RD_STAY_TM_HRS/24 N3RD_STAY_TM_HRS" ).append("\n"); 
		query.append("   ,   TS_IND_CD, NVL(FDR_USD_FLG, 'N') F_USED" ).append("\n"); 
		query.append("   ,   LNK_KNT LNK_CNT, UPD_IND_CD, TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') C_DATE, A.CRE_USR_ID C_USER" ).append("\n"); 
		query.append("   ,   TO_CHAR(A.OCN_ROUT_UPD_DT, 'YYYY-MM-DD') U_DATE, A.UPD_USR_ID U_USER" ).append("\n"); 
		query.append("   ,   DECODE(UPD_IND_CD, 'G', 1, 'S', 2, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord " ).append("\n"); 
		query.append("   ,   OCN_ROUT_TMP_FLG ,TO_CHAR(OCN_ROUT_TMP_EXP_DT, 'YYYY-MM-DD')OCN_ROUT_TMP_EXP_DT" ).append("\n"); 
		query.append("   ,   OCN_ROUT_TMP_RMK s_route_note" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N1ST_LANE_CD, A.N1ST_POL_CD, A.N1ST_SKD_DIR_CD, A.N1ST_POD_CD, 'O' ) AS POL1_YD" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N1ST_LANE_CD, A.N1ST_POD_CD, A.N1ST_SKD_DIR_CD, A.N1ST_POL_CD, 'D' ) AS POD1_YD" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N2ND_LANE_CD, A.N2ND_POL_CD, A.N2ND_SKD_DIR_CD, A.N2ND_POD_CD, 'O' ) AS POL2_YD" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N2ND_LANE_CD, A.N2ND_POD_CD, A.N2ND_SKD_DIR_CD, A.N2ND_POL_CD, 'D' ) AS POD2_YD" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N3RD_LANE_CD, A.N3RD_POL_CD, A.N3RD_SKD_DIR_CD, A.N3RD_POD_CD, 'O' ) AS POL3_YD" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N3RD_LANE_CD, A.N3RD_POD_CD, A.N3RD_SKD_DIR_CD, A.N3RD_POL_CD, 'D' ) AS POD3_YD" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N4TH_LANE_CD, A.N4TH_POL_CD, A.N4TH_SKD_DIR_CD, A.N4TH_POD_CD, 'O' ) AS POL4_YD" ).append("\n"); 
		query.append("   ,   PRI_SCQ_YD_MATCH_FNC ( A.N4TH_LANE_CD, A.N4TH_POD_CD, A.N4TH_SKD_DIR_CD, A.N4TH_POL_CD, 'D' ) AS POD4_YD" ).append("\n"); 
		query.append("FROM   PRD_OCN_ROUT A" ).append("\n"); 
		query.append("WHERE  ORG_LOC_CD   = @[pol_port_cd]                   " ).append("\n"); 
		query.append("  AND  DEST_LOC_CD  = @[pod_port_cd]" ).append("\n"); 
		query.append("  AND  ( UPD_IND_CD   IN ('C', 'U', 'S', 'T', 'A', 'V','G')                                          " ).append("\n"); 
		query.append("		 OR " ).append("\n"); 
		query.append("		 UPD_IND_CD = 'N' --AND TS_IND_CD = 'D' , not used 일 경우 화면상 수정을 위해  .." ).append("\n"); 
		query.append("        ) 	" ).append("\n"); 
		query.append(" order by ORD, U_DATE DESC" ).append("\n"); 

	}
}