/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OceanRouteManageDBDAOSearchOceanRouteListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSearchOceanRouteListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOceanRouteList
	  * 1. 2011.01.18 이수진 CHM-201108245-01] PRD내 Service Provide Inquiry 화면 변경 요청.
	  *    =>  삭제된 HQ Link가 포함된 Ocean Route도 조회되도록 변경
	  *            AND  NVL(B.DELT_FLG,'N') <>'Y'
	  *            AND  NVL(C.DELT_FLG,'N') <>'Y'
	  *            AND  NVL(D.DELT_FLG,'N') <>'Y'
	  *            AND  NVL(E.DELT_FLG,'N') <>'Y' 구문 삭제
	  * </pre>
	  */
	public OceanRouteManageDBDAOSearchOceanRouteListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cnty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stay_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tnk_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cont_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cont_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSearchOceanRouteListRSQL").append("\n"); 
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
		query.append("SELECT ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,POL1,POD1,LANE1,DIR1,FDR_FLG1,SVC_TP1,POL2,POD2,LANE2,DIR2,FDR_FLG2,SVC_TP2," ).append("\n"); 
		query.append("POL3,POD3,LANE3,DIR3,FDR_FLG3,SVC_TP3,POL4,POD4,LANE4,DIR4,FDR_FLG4,SVC_TP4,PRIO,RMK,TZTM_HRS,FMT_TZTM_HRS," ).append("\n"); 
		query.append("N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,ST_HRS,FMT_ST_HRS,N1ST_STAY_TM_HRS,N2ND_STAY_TM_HRS," ).append("\n"); 
		query.append("N3RD_STAY_TM_HRS,TS_IND_CD,F_USED,POD1ETB,POL2ETB,POD2ETB,POL3ETB,POD3ETB,POL4ETB,LNK_CNT,UPD_IND_CD,C_DATE," ).append("\n"); 
		query.append("C_USER,U_DATE,U_USER,ORD,OCN_ROUT_TMP_FLG,OCN_ROUT_TMP_EXP_DT,S_ROUTE_NOTE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ, " ).append("\n"); 
		query.append("       N1ST_POL_CD POL1, N1ST_POD_CD POD1, N1ST_LANE_CD LANE1, N1ST_SKD_DIR_CD DIR1, N1ST_LANE_FDR_FLG FDR_FLG1, " ).append("\n"); 
		query.append("       (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N1ST_LANE_CD) SVC_TP1, " ).append("\n"); 
		query.append("       N2ND_POL_CD POL2, N2ND_POD_CD POD2, N2ND_LANE_CD LANE2, N2ND_SKD_DIR_CD DIR2, N2ND_LANE_FDR_FLG FDR_FLG2, " ).append("\n"); 
		query.append("       (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N2ND_LANE_CD) SVC_TP2, " ).append("\n"); 
		query.append("       N3RD_POL_CD POL3, N3RD_POD_CD POD3, N3RD_LANE_CD LANE3, N3RD_SKD_DIR_CD DIR3, N3RD_LANE_FDR_FLG FDR_FLG3, " ).append("\n"); 
		query.append("       (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N3RD_LANE_CD) SVC_TP3, " ).append("\n"); 
		query.append("       N4TH_POL_CD POL4, N4TH_POD_CD POD4, N4TH_LANE_CD LANE4, N4TH_SKD_DIR_CD DIR4, N4TH_LANE_FDR_FLG FDR_FLG4, " ).append("\n"); 
		query.append("       (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N4TH_LANE_CD) SVC_TP4, " ).append("\n"); 
		query.append("       OCN_ROUT_PRIO_CD PRIO, OCN_ROUT_USR_RMK RMK,  " ).append("\n"); 
		query.append("       (N1ST_TZTM_HRS + N2ND_TZTM_HRS + N3RD_TZTM_HRS + N4TH_TZTM_HRS) TZTM_HRS, " ).append("\n"); 
		query.append("       ltrim(to_char(trunc((N1ST_TZTM_HRS + N2ND_TZTM_HRS + N3RD_TZTM_HRS + N4TH_TZTM_HRS)/24),'00'))||ltrim(to_char(mod((N1ST_TZTM_HRS + N2ND_TZTM_HRS + N3RD_TZTM_HRS + N4TH_TZTM_HRS),24  ),'00')) fmt_tztm_hrs ,  " ).append("\n"); 
		query.append("       N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS, " ).append("\n"); 
		query.append("       (N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS) ST_HRS, " ).append("\n"); 
		query.append("       ltrim(to_char(trunc((N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS)/24),'00'))||ltrim(to_char(mod((N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS),24  ),'00')) fmt_st_hrs ,  " ).append("\n"); 
		query.append("       N1ST_STAY_TM_HRS/24 N1ST_STAY_TM_HRS, N2ND_STAY_TM_HRS/24 N2ND_STAY_TM_HRS, N3RD_STAY_TM_HRS/24 N3RD_STAY_TM_HRS,  " ).append("\n"); 
		query.append("       TS_IND_CD, NVL(FDR_USD_FLG, 'N') F_USED,  " ).append("\n"); 
		query.append("       B.TO_PORT_ETB_DY_CD POD1ETB, C.FM_PORT_ETB_DY_CD POL2ETB, C.TO_PORT_ETB_DY_CD POD2ETB,  " ).append("\n"); 
		query.append("       D.FM_PORT_ETB_DY_CD POL3ETB, D.TO_PORT_ETB_DY_CD POD3ETB, E.FM_PORT_ETB_DY_CD POL4ETB, " ).append("\n"); 
		query.append("       LNK_KNT LNK_CNT, UPD_IND_CD, TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') C_DATE, A.CRE_USR_ID C_USER, " ).append("\n"); 
		query.append("	   TO_CHAR(A.OCN_ROUT_UPD_DT, 'YYYY-MM-DD') U_DATE, A.UPD_USR_ID U_USER, " ).append("\n"); 
		query.append("	   DECODE(UPD_IND_CD, 'G', 1, 'S', 2, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord " ).append("\n"); 
		query.append("       ,OCN_ROUT_TMP_FLG ,TO_CHAR(OCN_ROUT_TMP_EXP_DT, 'YYYY-MM-DD')OCN_ROUT_TMP_EXP_DT" ).append("\n"); 
		query.append("       ,OCN_ROUT_TMP_RMK s_route_note" ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER (ORDER BY DECODE(UPD_IND_CD, 'G', 1, 'S', 2, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7),TO_CHAR(A.OCN_ROUT_UPD_DT , 'YYYY-MM-DD')  DESC) NO" ).append("\n"); 
		query.append("FROM   PRD_OCN_ROUT A, PRD_PF_TZ_TM B, PRD_PF_TZ_TM C, PRD_PF_TZ_TM D, PRD_PF_TZ_TM E " ).append("\n"); 
		query.append("WHERE  ORG_LOC_CD   LIKE RTRIM(@[pol_port_cd])||'%'                          " ).append("\n"); 
		query.append("  AND  DEST_LOC_CD  LIKE RTRIM(@[pod_port_cd])||'%'                          " ).append("\n"); 
		query.append("  AND  TS_IND_CD    =  DECODE(@[ts_type] , 'A', TS_IND_CD, @[ts_type])  " ).append("\n"); 
		query.append("  AND  ( UPD_IND_CD   IN ('C', 'U', 'S', 'T', 'A', 'V','G')                                          " ).append("\n"); 
		query.append("		 OR " ).append("\n"); 
		query.append("		 UPD_IND_CD = 'N' --AND TS_IND_CD = 'D' , not used 일 경우 화면상 수정을 위해  .." ).append("\n"); 
		query.append("        ) 	" ).append("\n"); 
		query.append("  AND  N1ST_POL_CD  = B.FM_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N1ST_POD_CD  = B.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N1ST_LANE_CD = B.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("  AND  N2ND_POL_CD  = C.FM_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N2ND_POD_CD  = C.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N2ND_LANE_CD = C.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("  AND  N3RD_POL_CD  = D.FM_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N3RD_POD_CD  = D.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N3RD_LANE_CD = D.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("  AND  N4TH_POL_CD  = E.FM_PORT_CD(+)  " ).append("\n"); 
		query.append("  AND  N4TH_POD_CD  = E.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N4TH_LANE_CD = E.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("  AND	(NVL(N1ST_STAY_TM_HRS, 0) + NVL(N2ND_STAY_TM_HRS, 0))/24 <= DECODE(TO_NUMBER(NVL(@[stay_time],0)), 0, 50*24, TO_NUMBER(NVL(@[stay_time],0)))" ).append("\n"); 
		query.append("  AND  (DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N1ST_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N2ND_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N3RD_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N4TH_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') )   " ).append("\n"); 
		query.append("  AND  (DECODE(RTRIM(@[ts_port_cd]), NULL, 'ZZZZZ', DECODE(LNK_KNT, 1, 'XXXXX', N1ST_POD_CD))  LIKE NVL(RTRIM(@[ts_port_cd]), 'ZZZZZ')||'%%' OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[ts_port_cd]), NULL, 'ZZZZZ', DECODE(LNK_KNT, 2, 'XXXXX', N2ND_POD_CD))  LIKE NVL(RTRIM(@[ts_port_cd]), 'ZZZZZ')||'%%' OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[ts_port_cd]), NULL, 'ZZZZZ', DECODE(LNK_KNT, 3, 'XXXXX', N3RD_POD_CD))  LIKE NVL(RTRIM(@[ts_port_cd]), 'ZZZZZ')||'%%' )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND EXISTS ( SELECT 'X'                  " ).append("\n"); 
		query.append("                 FROM MDM_LOCATION L " ).append("\n"); 
		query.append("                WHERE A.ORG_LOC_CD = L.LOC_CD " ).append("\n"); 
		query.append("                  AND L.CONTI_CD LIKE RTRIM(@[pol_cont_cd])||'%' " ).append("\n"); 
		query.append("                  AND L.CNT_CD LIKE RTRIM(@[pol_cnty_cd])||'%' " ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("  AND EXISTS ( SELECT 'X'                 " ).append("\n"); 
		query.append("                 FROM MDM_LOCATION L " ).append("\n"); 
		query.append("                WHERE A.DEST_LOC_CD = L.LOC_CD " ).append("\n"); 
		query.append("                  AND L.CONTI_CD LIKE RTRIM(@[pod_cont_cd])||'%' " ).append("\n"); 
		query.append("                  AND L.CNT_CD LIKE RTRIM(@[pod_cnty_cd])||'%'   " ).append("\n"); 
		query.append("             )  " ).append("\n"); 
		query.append(" order by ord, U_DATE desc" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${ipage} != 0 ) " ).append("\n"); 
		query.append("	WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}