/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairRouteDBDAOSearchPortPairOceanRouteInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOSearchPortPairOceanRouteInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortPairRouteDBDAOSearchPortPairOceanRouteInformationRSQL
	  * </pre>
	  */
	public PortPairRouteDBDAOSearchPortPairOceanRouteInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("block_lanes",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOSearchPortPairOceanRouteInformationRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("WITH POR_TT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("					MIN(SUM_TT) POR_TT" ).append("\n"); 
		query.append("			FROM (" ).append("\n"); 
		query.append("						SELECT	ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("								ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("								SUM_TT_TIME " ).append("\n"); 
		query.append("											+ MAX( DECODE ( CNT, 1 ,	DECODE(ROUT_DTL_SEQ , 1 , DEST_DW_TIME , 0 ), " ).append("\n"); 
		query.append("																		DECODE(ROUT_DTL_SEQ , 1 , DEST_DW_TIME, 0 )) ) " ).append("\n"); 
		query.append("											+ MAX( DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 2 , DEST_DW_TIME, 0 )) ) " ).append("\n"); 
		query.append("											+ MAX( DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 3 , DEST_DW_TIME, 0 )) ) " ).append("\n"); 
		query.append("											+ MAX( DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 4 , DEST_DW_TIME, 0 )) ) " ).append("\n"); 
		query.append("											+ MAX( DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 5 , DEST_DW_TIME, 0 )) ) SUM_TT" ).append("\n"); 
		query.append("						FROM (" ).append("\n"); 
		query.append("								SELECT	M.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("										M.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("										D.ROUT_DTL_SEQ," ).append("\n"); 
		query.append("										COUNT (*) OVER (PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("											ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ)							AS CNT ," ).append("\n"); 
		query.append("										SUM(L.TZTM_HRS) OVER(PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("											ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ)							AS SUM_TT_TIME," ).append("\n"); 
		query.append("										NVL	(	 " ).append("\n"); 
		query.append("												(" ).append("\n"); 
		query.append("													SELECT NVL(DRY_AVG_DWLL_HRS, 0)" ).append("\n"); 
		query.append("													FROM MDM_YARD" ).append("\n"); 
		query.append("													WHERE YD_CD = D.LNK_DEST_NOD_CD " ).append("\n"); 
		query.append("												), 0" ).append("\n"); 
		query.append("											) DEST_DW_TIME," ).append("\n"); 
		query.append("										NULL" ).append("\n"); 
		query.append("								FROM	" ).append("\n"); 
		query.append("										PRD_INLND_ROUT_MST M," ).append("\n"); 
		query.append("										PRD_INLND_ROUT_DTL D," ).append("\n"); 
		query.append("										PRD_INLND_EACH_LNK L," ).append("\n"); 
		query.append("										TRS_TRSP_AGMT_HDR A" ).append("\n"); 
		query.append("								WHERE   1 = 1  " ).append("\n"); 
		query.append("								AND SUBSTR(M.ROUT_ORG_NOD_CD, 1, 5) =     @[por_cd]" ).append("\n"); 
		query.append("								AND M.ROUT_DEST_NOD_CD		LIKE		  @[pol_cd]||'%' " ).append("\n"); 
		query.append("								AND NVL(M.DELT_FLG, 'N')	='N'" ).append("\n"); 
		query.append("								AND M.INLND_ROUT_BKG_FLG	= 'Y'" ).append("\n"); 
		query.append("								AND M.ROUT_ORG_NOD_CD		= D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("								AND M.ROUT_DEST_NOD_CD		= D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("								AND M.ROUT_SEQ				= D.ROUT_SEQ" ).append("\n"); 
		query.append("								AND D.LNK_ORG_NOD_CD		= L.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("								AND D.LNK_DEST_NOD_CD		= L.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("								AND D.TRSP_MOD_CD			= L.TRSP_MOD_CD" ).append("\n"); 
		query.append("								AND D.TRSP_AGMT_OFC_CTY_CD	= A.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("								AND D.TRSP_AGMT_SEQ			= A.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("								AND NVL(A.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("								AND EXISTS	(" ).append("\n"); 
		query.append("												SELECT 'X'" ).append("\n"); 
		query.append("												FROM PRD_NODE N" ).append("\n"); 
		query.append("												WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("								AND EXISTS	(" ).append("\n"); 
		query.append("												SELECT 'X'" ).append("\n"); 
		query.append("												FROM PRD_NODE N" ).append("\n"); 
		query.append("												WHERE N.NOD_CD = M.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("								ORDER BY M.ROUT_SEQ, D.ROUT_DTL_SEQ " ).append("\n"); 
		query.append("							) M" ).append("\n"); 
		query.append("						GROUP BY M.ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, SUM_TT_TIME " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append(") ,              " ).append("\n"); 
		query.append("DEL_TT AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("					MIN(SUM_TT) DEL_TT" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("						SELECT	ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("								ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("								SUM_TT_TIME + MAX(DECODE ( CNT, 1 , DECODE(ROUT_DTL_SEQ , 1 , DEST_DW_TIME , 0 ), DECODE(ROUT_DTL_SEQ , 1 , DEST_DW_TIME, 0 )) ) + MAX(DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 2 , DEST_DW_TIME, 0 )) ) + MAX(DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 3 , DEST_DW_TIME, 0 )) ) + MAX(DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 4 , DEST_DW_TIME, 0 )) ) + MAX(DECODE ( CNT, 1 , 0, DECODE(ROUT_DTL_SEQ , 5 , DEST_DW_TIME, 0 )) ) SUM_TT" ).append("\n"); 
		query.append("						FROM	(" ).append("\n"); 
		query.append("									SELECT /*+ LEADING(A M) USE_NL(A M) */" ).append("\n"); 
		query.append("											M.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("											M.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("											D.ROUT_DTL_SEQ," ).append("\n"); 
		query.append("											COUNT (*) OVER (PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("												ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ)							AS CNT ," ).append("\n"); 
		query.append("											SUM(L.TZTM_HRS) OVER(PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("												ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ)							AS SUM_TT_TIME," ).append("\n"); 
		query.append("											NVL( " ).append("\n"); 
		query.append("													(" ).append("\n"); 
		query.append("														SELECT NVL(DRY_AVG_DWLL_HRS, 0)" ).append("\n"); 
		query.append("														FROM MDM_YARD" ).append("\n"); 
		query.append("														WHERE YD_CD = D.LNK_DEST_NOD_CD " ).append("\n"); 
		query.append("													), 0" ).append("\n"); 
		query.append("												) DEST_DW_TIME" ).append("\n"); 
		query.append("									FROM	" ).append("\n"); 
		query.append("											PRD_INLND_ROUT_MST	M," ).append("\n"); 
		query.append("											PRD_INLND_ROUT_DTL	D," ).append("\n"); 
		query.append("											PRD_INLND_EACH_LNK	L," ).append("\n"); 
		query.append("											TRS_TRSP_AGMT_HDR	A" ).append("\n"); 
		query.append("									WHERE 1 = 1" ).append("\n"); 
		query.append("									AND SUBSTR(M.ROUT_ORG_NOD_CD, 1, 5) =	@[pod_cd] " ).append("\n"); 
		query.append("									AND M.ROUT_DEST_NOD_CD             LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("									AND NVL(M.DELT_FLG, 'N') ='N'" ).append("\n"); 
		query.append("									AND M.INLND_ROUT_BKG_FLG = 'Y'" ).append("\n"); 
		query.append("									AND M.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("									AND M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("									AND M.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("									AND D.LNK_ORG_NOD_CD = L.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("									AND D.LNK_DEST_NOD_CD = L.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("									AND D.TRSP_MOD_CD = L.TRSP_MOD_CD" ).append("\n"); 
		query.append("									AND D.TRSP_AGMT_OFC_CTY_CD = A.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("									AND D.TRSP_AGMT_SEQ = A.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("									AND NVL(A.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("									AND EXISTS	(" ).append("\n"); 
		query.append("													SELECT 'X'" ).append("\n"); 
		query.append("													FROM PRD_NODE N" ).append("\n"); 
		query.append("													WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("									AND EXISTS	(" ).append("\n"); 
		query.append("													SELECT 'X'" ).append("\n"); 
		query.append("													FROM PRD_NODE N" ).append("\n"); 
		query.append("													WHERE N.NOD_CD = M.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("									ORDER BY M.ROUT_SEQ, D.ROUT_DTL_SEQ " ).append("\n"); 
		query.append("								) M" ).append("\n"); 
		query.append("						GROUP BY M.ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, SUM_TT_TIME " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("BLK_LANES AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT  WM_CONCAT(SLAN_CD)   BLK_LANES  -- CKI,KIS" ).append("\n"); 
		query.append("    FROM    SCE_CUST_EDI_BLCK" ).append("\n"); 
		query.append("    WHERE   1 = 1" ).append("\n"); 
		query.append("    AND     ROUT_RCV_DT =   @[rout_rcv_dt]" ).append("\n"); 
		query.append("    AND     ROUT_SEQ    =   @[rout_seq]   " ).append("\n"); 
		query.append("    AND     DELT_FLG    =   'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--<<---------------------------------------  CHM-201326574 : Added" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        ORG_LOC_CD pol_cd, DEST_LOC_CD pod_cd, ROUT_SEQ, " ).append("\n"); 
		query.append("        N1ST_POL_CD POL1, N1ST_POD_CD POD1, N1ST_LANE_CD LANE1, N1ST_SKD_DIR_CD DIR1, N1ST_LANE_FDR_FLG FDR_FLG1, " ).append("\n"); 
		query.append("        (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N1ST_LANE_CD) SVC_TP1, " ).append("\n"); 
		query.append("        N2ND_POL_CD POL2, N2ND_POD_CD POD2, N2ND_LANE_CD LANE2, N2ND_SKD_DIR_CD DIR2, N2ND_LANE_FDR_FLG FDR_FLG2, " ).append("\n"); 
		query.append("        (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N2ND_LANE_CD) SVC_TP2, " ).append("\n"); 
		query.append("        N3RD_POL_CD POL3, N3RD_POD_CD POD3, N3RD_LANE_CD LANE3, N3RD_SKD_DIR_CD DIR3, N3RD_LANE_FDR_FLG FDR_FLG3, " ).append("\n"); 
		query.append("        (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N3RD_LANE_CD) SVC_TP3, " ).append("\n"); 
		query.append("        N4TH_POL_CD POL4, N4TH_POD_CD POD4, N4TH_LANE_CD LANE4, N4TH_SKD_DIR_CD DIR4, N4TH_LANE_FDR_FLG FDR_FLG4, " ).append("\n"); 
		query.append("        (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N4TH_LANE_CD) SVC_TP4, " ).append("\n"); 
		query.append("        OCN_ROUT_PRIO_CD PRIO, OCN_ROUT_USR_RMK RMK,  " ).append("\n"); 
		query.append("        (N1ST_TZTM_HRS + N2ND_TZTM_HRS + N3RD_TZTM_HRS + N4TH_TZTM_HRS) TZTM_HRS, " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* CHM-201326574 :Replaced */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        LTRIM(TO_CHAR(TRUNC(( nvl(N1ST_TZTM_HRS ,0)+ nvl(N2ND_TZTM_HRS ,0)+ nvl(N3RD_TZTM_HRS,0) + nvl(N4TH_TZTM_HRS,0) + nvl(POR_TT,0) + nvl(DEL_TT,0) )/24),'00'))" ).append("\n"); 
		query.append("        ||" ).append("\n"); 
		query.append("        LTRIM(TO_CHAR(MOD((nvl(N1ST_TZTM_HRS,0) + nvl(N2ND_TZTM_HRS,0) + nvl(N3RD_TZTM_HRS,0) + nvl(N4TH_TZTM_HRS,0) + nvl(POR_TT,0) + nvl(DEL_TT,0) ),24  ),'00')) FMT_TZTM_HRS ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* CHM-201326574 :Replaced */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  " ).append("\n"); 
		query.append("        N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS, " ).append("\n"); 
		query.append("        (N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS) ST_HRS, " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        LTRIM(TO_CHAR(TRUNC((N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS)/24),'00'))||LTRIM(TO_CHAR(MOD  ((N1ST_STAY_TM_HRS + N2ND_STAY_TM_HRS + N3RD_STAY_TM_HRS),24),'00')) FMT_ST_HRS ,  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        N1ST_STAY_TM_HRS/24 N1ST_STAY_TM_HRS, N2ND_STAY_TM_HRS/24 N2ND_STAY_TM_HRS, N3RD_STAY_TM_HRS/24 N3RD_STAY_TM_HRS,  " ).append("\n"); 
		query.append("        TS_IND_CD, NVL(FDR_USD_FLG, 'N') F_USED,  " ).append("\n"); 
		query.append("        B.TO_PORT_ETB_DY_CD POD1ETB, C.FM_PORT_ETB_DY_CD POL2ETB, C.TO_PORT_ETB_DY_CD POD2ETB,  " ).append("\n"); 
		query.append("        D.FM_PORT_ETB_DY_CD POL3ETB, D.TO_PORT_ETB_DY_CD POD3ETB, E.FM_PORT_ETB_DY_CD POL4ETB, " ).append("\n"); 
		query.append("        LNK_KNT LNK_CNT,  TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') C_DATE, A.CRE_USR_ID C_USER, " ).append("\n"); 
		query.append("        TO_CHAR(A.OCN_ROUT_UPD_DT, 'YYYY-MM-DD') U_DATE, A.UPD_USR_ID U_USER, " ).append("\n"); 
		query.append("        DECODE(UPD_IND_CD, 'G', 1, 'S', 2, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord " ).append("\n"); 
		query.append("        ,OCN_ROUT_TMP_FLG ,TO_CHAR(OCN_ROUT_TMP_EXP_DT, 'YYYY-MM-DD')OCN_ROUT_TMP_EXP_DT" ).append("\n"); 
		query.append("        ,OCN_ROUT_TMP_RMK s_route_note" ).append("\n"); 
		query.append("        ,ROW_NUMBER() OVER (ORDER BY DECODE(UPD_IND_CD, 'G', 1, 'S', 2, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7),TO_CHAR(A.OCN_ROUT_UPD_DT , 'YYYY-MM-DD')  DESC) NO" ).append("\n"); 
		query.append("        ,DECODE(UPD_IND_CD, 'G', 'Guide', 'S', 'Standard', 'T', 'Temporary', 'V', 'Validation', 'N', 'Not Used', 'D', 'Deleted') UPD_IND_CD" ).append("\n"); 
		query.append("        -------------------------->> CHM-201326574 : Added" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,CASE    WHEN   instr(@[block_lanes],N1ST_LANE_CD )> 0 OR " ).append("\n"); 
		query.append("                        instr(@[block_lanes],N2ND_LANE_CD )> 0 OR " ).append("\n"); 
		query.append("                        instr(@[block_lanes],N3RD_LANE_CD )> 0 OR " ).append("\n"); 
		query.append("                        instr(@[block_lanes],N4th_LANE_CD )> 0  THEN " ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                        'N'" ).append("\n"); 
		query.append("        END         BLOCK_YN,                      " ).append("\n"); 
		query.append("        @[por_cd] POR_CD,  " ).append("\n"); 
		query.append("        @[del_cd] del_CD                 " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        -------------------------->>  CHM-201326574 : Added" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM   PRD_OCN_ROUT A, PRD_PF_TZ_TM B, PRD_PF_TZ_TM C, PRD_PF_TZ_TM D, PRD_PF_TZ_TM E " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -------------------------->> CHM-201326574 : Added" ).append("\n"); 
		query.append("       ,POR_TT, DEL_TT, BLK_LANES  " ).append("\n"); 
		query.append("       -------------------------->> CHM-201326574 : Added" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  ORG_LOC_CD   LIKE RTRIM(@[pol_cd])||'%'                          " ).append("\n"); 
		query.append("  AND  DEST_LOC_CD  LIKE RTRIM(@[pod_cd])||'%'           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND  UPD_IND_CD   IN ( 'S','G' )                                          " ).append("\n"); 
		query.append("	" ).append("\n"); 
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
		query.append("  " ).append("\n"); 
		query.append("   -------------------------->> Added : CHM-201326574" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    #if (${n1st_pol_cd} != '' ) " ).append("\n"); 
		query.append("    	 AND  N1ST_POL_CD  = @[n1st_pol_cd]" ).append("\n"); 
		query.append("    #end	   " ).append("\n"); 
		query.append("    #if (${n1st_pod_cd} != '' ) " ).append("\n"); 
		query.append("    	 AND  N1ST_POD_CD  = @[n1st_pod_cd]" ).append("\n"); 
		query.append("    #end	   " ).append("\n"); 
		query.append("    #if (${n2nd_pol_cd} != '' ) " ).append("\n"); 
		query.append("    	 AND  N2ND_POL_CD  = @[n2nd_pol_cd]" ).append("\n"); 
		query.append("    #end	   " ).append("\n"); 
		query.append("    #if (${n2nd_pod_cd} != '' ) " ).append("\n"); 
		query.append("    	 AND  N2ND_POD_CD  = @[n2nd_pod_cd]" ).append("\n"); 
		query.append("    #end	   " ).append("\n"); 
		query.append("    #if (${n3rd_pol_cd} != '' ) " ).append("\n"); 
		query.append("    	 AND  N3RD_POL_CD  = @[n3rd_pol_cd]" ).append("\n"); 
		query.append("    #end	   " ).append("\n"); 
		query.append("    #if (${n3rd_pod_cd} != '' ) " ).append("\n"); 
		query.append("    	 AND  N3RD_POD_CD  = @[n3rd_pod_cd]" ).append("\n"); 
		query.append("    #end	     " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("   -------------------------->> Added : CHM-201326574" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" order by ord, U_DATE desc" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}