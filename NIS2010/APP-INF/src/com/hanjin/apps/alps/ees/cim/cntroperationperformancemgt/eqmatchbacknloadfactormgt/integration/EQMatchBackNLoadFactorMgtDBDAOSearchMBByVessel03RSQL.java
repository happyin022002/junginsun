/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel03RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Match-back by Vessel
	  * 2010.09.15 이병훈 [CHM-201005967-01] Match-Back by Vessel의 신규 Trade 및 노선 추가
	  * 2011.11.01 신자영 [CHM-201114141-01] [CIM] L/F by trade & M/B by vessel 기능에 EM1 & EM2 Lane 추가
	  * 2012.04.17 신자영 [CHM-201217339-01] iNVENTORY/ Load Factor & M/B by vessel 기능 보완
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel03RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("torgn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromrgn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel03RSQL").append("\n"); 
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
		query.append("SELECT M3.TRD_CD," ).append("\n"); 
		query.append("       M3.SLAN_CD LANE_CD," ).append("\n"); 
		query.append("       M3.VSL_CD||M3.SKD_VOY_NO||M3.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       M3.VSL_CD,                  /* i_vsl_cd     */" ).append("\n"); 
		query.append("       M3.SKD_VOY_NO ,             /* i_skd_voy_no   */" ).append("\n"); 
		query.append("       M3.SKD_DIR_CD ,             /* i_skd_dir_cd   */" ).append("\n"); 
		query.append("       M3.VPS_PORT_CD ,            /* i_vps_port_cd  */" ).append("\n"); 
		query.append("       M3.CLPT_IND_SEQ ,           /* i_clpt_ind_seq */" ).append("\n"); 
		query.append("       M3.CLPT_SEQ ,               /* i_clpt_seq   */" ).append("\n"); 
		query.append("       TO_CHAR(M3.VPS_ETD_DT, 'YYYYMMDD') VPS_ETD_DT,  /* i_vps_etd_dt_1 */" ).append("\n"); 
		query.append("       MAX((SELECT PLN_YR||PLN_WK FROM EQR_WK_PRD WHERE TO_CHAR(M3.VPS_ETD_DT, 'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT)) WEEK,          /* atd week     */" ).append("\n"); 
		query.append("       M3.FROM_RGN ,               /* i_from_rgn   */" ).append("\n"); 
		query.append("       M3.TO_RGN   ,               /* i_to_rgn     */" ).append("\n"); 
		query.append("       'In' IO," ).append("\n"); 
		query.append(" --< BSA > ______________________________________________________________________________________" ).append("\n"); 
		query.append(" -- (1). RDR" ).append("\n"); 
		query.append("       DECODE((SELECT SUM(RA.BSA_SLOT)||','||SUM(RA.BSA_WGT)" ).append("\n"); 
		query.append("                 FROM RDR_HEADER      RH1," ).append("\n"); 
		query.append("                      RDR_ALLOCATION    RA" ).append("\n"); 
		query.append("                WHERE M3.VSL_CD     = RH1.VSL_CD (+)" ).append("\n"); 
		query.append("                  AND M3.SKD_VOY_NO = RH1.VOY_NO (+)" ).append("\n"); 
		query.append("                  AND M3.SKD_DIR_CD = RH1.DIR_CD (+)" ).append("\n"); 
		query.append("                  AND M3.FROM_RGN   = RH1.REGION (+)" ).append("\n"); 
		query.append("                  AND RH1.VSL_CD    = RA.VSL_CD  (+)" ).append("\n"); 
		query.append("                  AND RH1.VOY_NO    = RA.VOY_NO  (+)" ).append("\n"); 
		query.append("                  AND RH1.DIR_CD    = RA.DIR_CD  (+)" ).append("\n"); 
		query.append("                  AND RH1.REGION    = RA.REGION  (+)" ).append("\n"); 
		query.append("                  AND @[company]    = RA.OPR_CD  (+)" ).append("\n"); 
		query.append("               ), ',' , NVL(MAX(DECODE(O1.BSA_OP_JB_CD,'007',O1.CRR_BSA_CAPA,0)),0)||','||NVL(MAX(DECODE(O2.BSA_OP_JB_CD,'009',O2.CRR_BSA_CAPA,0)),0)" ).append("\n"); 
		query.append("                      ,(SELECT SUM(RA.BSA_SLOT)||','||SUM(RA.BSA_WGT)" ).append("\n"); 
		query.append("                          FROM RDR_HEADER      RH1," ).append("\n"); 
		query.append("                               RDR_ALLOCATION    RA" ).append("\n"); 
		query.append("                         WHERE M3.VSL_CD     = RH1.VSL_CD (+)" ).append("\n"); 
		query.append("                           AND M3.SKD_VOY_NO = RH1.VOY_NO (+)" ).append("\n"); 
		query.append("                           AND M3.SKD_DIR_CD = RH1.DIR_CD (+)" ).append("\n"); 
		query.append("                           AND M3.FROM_RGN   = RH1.REGION (+)" ).append("\n"); 
		query.append("                           AND RH1.VSL_CD    = RA.VSL_CD  (+)" ).append("\n"); 
		query.append("                           AND RH1.VOY_NO    = RA.VOY_NO  (+)" ).append("\n"); 
		query.append("                           AND RH1.DIR_CD    = RA.DIR_CD  (+)" ).append("\n"); 
		query.append("                           AND RH1.REGION    = RA.REGION  (+)" ).append("\n"); 
		query.append("                           AND @[company]    = RA.OPR_CD  (+)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             )  bsaspace  ," ).append("\n"); 
		query.append("-- deadSlot-------------------------------------------------------" ).append("\n"); 
		query.append("       (SELECT  NVL(SUM(DECODE(RU.TYPE,'A',RU.SLOT_QTY,0))" ).append("\n"); 
		query.append("               +SUM(DECODE(RU.TYPE,'H',RU.SLOT_QTY,'L',RU.SLOT_QTY,0)),0)  /* deadSlot  */" ).append("\n"); 
		query.append("          FROM RDR_HEADER      H," ).append("\n"); 
		query.append("               RDR_UTILIZE     RU" ).append("\n"); 
		query.append("         WHERE M3.VSL_CD     = H.VSL_CD  (+)" ).append("\n"); 
		query.append("           AND M3.SKD_VOY_NO = H.VOY_NO  (+)" ).append("\n"); 
		query.append("           AND M3.SKD_DIR_CD = H.DIR_CD  (+)" ).append("\n"); 
		query.append("           AND M3.FROM_RGN   = H.REGION  (+)" ).append("\n"); 
		query.append("           AND H.VSL_CD      = RU.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO      = RU.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD      = RU.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION      = RU.REGION" ).append("\n"); 
		query.append("           AND @[company]    = RU.OPR_CD" ).append("\n"); 
		query.append("       ) deadSlot," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--< 실적 > ______________________________________________________________________________________" ).append("\n"); 
		query.append("-- (1). BAY PLAN" ).append("\n"); 
		query.append("       DECODE(SUM(NVL(TO_NUMBER(TRIM(B.WEIGHT)), 0)),0,'','BAY') val01,                            /* dataSource */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '2', SZTP))) val02,  /* full20Qty */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '4', SZTP))) val03,  /* full40Qty */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '5', SZTP))) + COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '9', SZTP))) val04,  /* fullHcQty */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '7', SZTP))) val05,  /* full45Qty */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '2', SZTP))) val06,  /* mty20Qty  */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '4', SZTP))) val07,  /* mty40Qty  */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '5', SZTP))) + COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '9', SZTP))) val08,  /* mtyHcQty  */" ).append("\n"); 
		query.append("       COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '7', SZTP))) val09,  /* mty45Qty  */" ).append("\n"); 
		query.append("       SUM(NVL(TO_NUMBER(TRIM(B.WEIGHT)), 0))  weightTotal  ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--< Release > ______________________________________________________________________________________" ).append("\n"); 
		query.append("/* 20100405 Realese Logic 변경 By Y.H.Nam" ).append("\n"); 
		query.append("       NVL(SUM(RR.SLOT),0)                     releasedteu," ).append("\n"); 
		query.append("       NVL(SUM(RR.WEIGHT),0)                   releasedweight" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/* 20100405 Realese Logic 변경 By Y.H.Nam  */" ).append("\n"); 
		query.append("       (SELECT NVL(NVL(SUM(RA.RELEASE_SLOT),0) + NVL(SUM(RA.SWAP_SLOT),0),0) ||','||  -- releasedteu" ).append("\n"); 
		query.append("               NVL(NVL(SUM(RA.RELEASE_WGT), 0) + NVL(SUM(RA.SWAP_WGT), 0),0)          -- releasedweight" ).append("\n"); 
		query.append("          FROM RDR_HEADER      RH1," ).append("\n"); 
		query.append("               RDR_ALLOCATION    RA" ).append("\n"); 
		query.append("         WHERE M3.VSL_CD     = RH1.VSL_CD  (+)" ).append("\n"); 
		query.append("           AND M3.SKD_VOY_NO = RH1.VOY_NO  (+)" ).append("\n"); 
		query.append("           AND M3.SKD_DIR_CD = RH1.DIR_CD  (+)" ).append("\n"); 
		query.append("           AND M3.FROM_RGN   = RH1.REGION  (+)" ).append("\n"); 
		query.append("           AND RH1.VSL_CD    = RA.VSL_CD   (+)" ).append("\n"); 
		query.append("           AND RH1.VOY_NO    = RA.VOY_NO   (+)" ).append("\n"); 
		query.append("           AND RH1.DIR_CD    = RA.DIR_CD   (+)" ).append("\n"); 
		query.append("           AND RH1.REGION    = RA.REGION   (+)" ).append("\n"); 
		query.append("           AND @[company]    = RA.OPR_CD   (+)" ).append("\n"); 
		query.append("       )  releasedteu" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      SELECT VPS1.VSL_CD," ).append("\n"); 
		query.append("             VPS1.SKD_VOY_NO," ).append("\n"); 
		query.append("             VPS1.SKD_DIR_CD," ).append("\n"); 
		query.append("             VPS1.VPS_PORT_CD," ).append("\n"); 
		query.append("             VPS1.CLPT_IND_SEQ," ).append("\n"); 
		query.append("             VPS1.CLPT_SEQ," ).append("\n"); 
		query.append("             VPS1.VPS_ETD_DT," ).append("\n"); 
		query.append("             VPS1.SLAN_CD," ).append("\n"); 
		query.append("             BSA.TRD_CD," ).append("\n"); 
		query.append("             BSA.RLANE_CD," ).append("\n"); 
		query.append("#if ( ${lane} == '' )" ).append("\n"); 
		query.append("             DECODE(VPS1.SLAN_CD, 'WAF', SCNT1.CONTI_CD, 'EM1', SCNT1.CONTI_CD, 'EM2', SCNT1.CONTI_CD, DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD) ) FROM_RGN," ).append("\n"); 
		query.append("             SUBSTR(MIN(LPAD(VPS2.CLPT_SEQ, 4)||DECODE(VPS1.SLAN_CD, 'WAF', SCNT2.CONTI_CD, 'EM1', SCNT2.CONTI_CD, 'EM2', SCNT2.CONTI_CD, DECODE(SCNT2.CONTI_CD, 'F', 'E', SCNT2.CONTI_CD)) ), 5, 1) TO_RGN" ).append("\n"); 
		query.append("#elseif ( ${lane} != 'WAF' && ${lane} != 'EM1' && ${lane} != 'EM2')" ).append("\n"); 
		query.append("             DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD) FROM_RGN," ).append("\n"); 
		query.append("             SUBSTR(MIN(LPAD(VPS2.CLPT_SEQ, 4)||DECODE(SCNT2.CONTI_CD, 'F', 'E', SCNT2.CONTI_CD)), 5, 1) TO_RGN" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		     SCNT1.CONTI_CD FROM_RGN," ).append("\n"); 
		query.append("             SUBSTR(MIN(LPAD(VPS2.CLPT_SEQ, 4)||SCNT2.CONTI_CD), 5, 1) TO_RGN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("              SELECT  /*+ INDEX_FFS(BSA_VVD_MST XPKBSA_VVD_MST) */" ).append("\n"); 
		query.append("                     DISTINCT TRD_CD, " ).append("\n"); 
		query.append("                     SUBSTR(RLANE_CD,1, 3) LANE_CD," ).append("\n"); 
		query.append("                     RLANE_CD RLANE_CD" ).append("\n"); 
		query.append("                FROM BSA_VVD_MST   -- 108 건" ).append("\n"); 
		query.append("             ) BSA ," ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD VPS1," ).append("\n"); 
		query.append("             MDM_COUNTRY CNT1," ).append("\n"); 
		query.append("             MDM_SUBCONTINENT SCNT1," ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD VPS2," ).append("\n"); 
		query.append("             MDM_COUNTRY CNT2," ).append("\n"); 
		query.append("             MDM_SUBCONTINENT SCNT2" ).append("\n"); 
		query.append("      WHERE NVL(VPS1.VPS_PORT_CD,   ' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("        AND NVL(VPS1.TURN_PORT_IND_CD,  ' ') NOT IN ('D', 'F', 'V')" ).append("\n"); 
		query.append("        AND NVL(VPS1.SKD_CNG_STS_CD,  ' ') <> 'S'" ).append("\n"); 
		query.append("        AND CNT1.CNT_CD       = SUBSTR(VPS1.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("        AND CNT1.SCONTI_CD    = SCNT1.SCONTI_CD" ).append("\n"); 
		query.append("        AND VPS1.SLAN_CD      = @[lane]" ).append("\n"); 
		query.append("        AND VPS1.VPS_ETD_DT BETWEEN TO_DATE(@[fromdate],  'YYYY-MM-DD') AND TO_DATE(@[todate],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        AND VPS2.VSL_CD       = VPS1.VSL_CD" ).append("\n"); 
		query.append("        AND VPS2.SKD_VOY_NO   = VPS1.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND VPS2.SKD_DIR_CD   = VPS1.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND VPS2.CLPT_SEQ     > VPS1.CLPT_SEQ" ).append("\n"); 
		query.append("        AND NVL(VPS2.VPS_PORT_CD,   ' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("        AND NVL(VPS2.SKD_CNG_STS_CD,  ' ') <> 'S'" ).append("\n"); 
		query.append("        AND CNT2.CNT_CD       = SUBSTR(VPS2.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("        AND CNT2.SCONTI_CD    = SCNT2.SCONTI_CD" ).append("\n"); 
		query.append("#if ( ${lane} == '' )" ).append("\n"); 
		query.append("		AND DECODE(VPS1.SLAN_CD, 'WAF', SCNT1.CONTI_CD, 'EM1', SCNT1.CONTI_CD,  'EM2', SCNT1.CONTI_CD,  DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD) ) =@[torgn]" ).append("\n"); 
		query.append("#elseif ( ${lane} != 'WAF' && ${lane} != 'EM1' && ${lane} != 'EM2' )" ).append("\n"); 
		query.append("		AND DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD) =@[torgn]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND SCNT1.CONTI_CD =@[torgn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND VPS1.SLAN_CD = BSA.LANE_CD" ).append("\n"); 
		query.append("#if ( ${lane} == '' )" ).append("\n"); 
		query.append("	    AND BSA.TRD_CD = 'EMS' " ).append("\n"); 
		query.append("#elseif ( ${lane} == 'ALX' ) -- ALX lane일 경우 EMS trade만 가져올 수 있도록 조건 추가" ).append("\n"); 
		query.append("        AND BSA.TRD_CD = 'EMS' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      GROUP BY VPS1.VSL_CD," ).append("\n"); 
		query.append("               VPS1.SKD_VOY_NO," ).append("\n"); 
		query.append("               VPS1.SKD_DIR_CD," ).append("\n"); 
		query.append("               VPS1.VPS_PORT_CD," ).append("\n"); 
		query.append("               VPS1.CLPT_IND_SEQ," ).append("\n"); 
		query.append("               VPS1.CLPT_SEQ," ).append("\n"); 
		query.append("               VPS1.VPS_ETD_DT," ).append("\n"); 
		query.append("               VPS1.SLAN_CD," ).append("\n"); 
		query.append("               BSA.TRD_CD," ).append("\n"); 
		query.append("               BSA.RLANE_CD," ).append("\n"); 
		query.append("#if ( ${lane} == '' )" ).append("\n"); 
		query.append("		       DECODE(VPS1.SLAN_CD, 'WAF', SCNT1.CONTI_CD, 'EM1', SCNT1.CONTI_CD, 'EM2', SCNT1.CONTI_CD, DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD) )" ).append("\n"); 
		query.append("#elseif ( ${lane} != 'WAF' && ${lane} != 'EM1' && ${lane} != 'EM2' )" ).append("\n"); 
		query.append("		       DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               SCNT1.CONTI_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) M3," ).append("\n"); 
		query.append("    BAY_PLAN           B," ).append("\n"); 
		query.append("    BSA_VVD_OTR_CRR   O1," ).append("\n"); 
		query.append("    BSA_VVD_OTR_CRR   O2," ).append("\n"); 
		query.append("    RDR_HEADER        RH2/* , 20100405 Realese Logic 변경 By Y.H.Nam  */" ).append("\n"); 
		query.append("    /*  RDR_SLOT_RELEASE  RR 20100405 Realese Logic 변경 By Y.H.Nam  */" ).append("\n"); 
		query.append("------------------------------------------------------- 실적  (1). BAY PLAN" ).append("\n"); 
		query.append("WHERE ( M3.FROM_RGN = @[torgn] AND M3.TO_RGN = @[fromrgn] )" ).append("\n"); 
		query.append("  AND M3.VSL_CD        = B.VSL_CD        (+)" ).append("\n"); 
		query.append("  AND M3.SKD_VOY_NO    = B.VOY_NO        (+)" ).append("\n"); 
		query.append("  AND M3.SKD_DIR_CD    = B.DIR_CD        (+)" ).append("\n"); 
		query.append("  AND M3.VPS_PORT_CD   = B.PORT_CD       (+)" ).append("\n"); 
		query.append("  AND M3.CLPT_IND_SEQ  = B.CALL_IND      (+)" ).append("\n"); 
		query.append("  AND @[company]       = B.OPR_CD        (+)" ).append("\n"); 
		query.append("  AND 'F'              = B.PLAN_TYPE     (+)" ).append("\n"); 
		query.append("-------------------------------------------------------  BSA (2). COA" ).append("\n"); 
		query.append("  AND M3.TRD_CD        = O1.TRD_CD       (+)" ).append("\n"); 
		query.append("  AND M3.RLANE_CD      = O1.RLANE_CD     (+)" ).append("\n"); 
		query.append("  AND M3.VSL_CD        = O1.VSL_CD       (+)" ).append("\n"); 
		query.append("  AND M3.SKD_VOY_NO    = O1.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("  AND M3.SKD_DIR_CD    = O1.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("  AND '007'            = O1.BSA_OP_JB_CD (+)" ).append("\n"); 
		query.append("  AND @[company]       = O1.CRR_CD       (+)" ).append("\n"); 
		query.append("  AND M3.TRD_CD        = O2.TRD_CD       (+)" ).append("\n"); 
		query.append("  AND M3.RLANE_CD      = O2.RLANE_CD     (+)" ).append("\n"); 
		query.append("  AND M3.VSL_CD        = O2.VSL_CD       (+)" ).append("\n"); 
		query.append("  AND M3.SKD_VOY_NO    = O2.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("  AND M3.SKD_DIR_CD    = O2.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("  AND '009'            = O2.BSA_OP_JB_CD (+)" ).append("\n"); 
		query.append("  AND @[company]       = O2.CRR_CD       (+)" ).append("\n"); 
		query.append("-------------------------------------------------------  RLSE" ).append("\n"); 
		query.append("  AND M3.VSL_CD        = RH2.VSL_CD      (+)" ).append("\n"); 
		query.append("  AND M3.SKD_VOY_NO    = RH2.VOY_NO      (+)" ).append("\n"); 
		query.append("  AND M3.SKD_DIR_CD    = RH2.DIR_CD      (+)" ).append("\n"); 
		query.append("  AND M3.VPS_PORT_CD   = RH2.PORT_CD     (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 20100405 Realese Logic 변경 By Y.H.Nam" ).append("\n"); 
		query.append("  AND RH2.VSL_CD       = RR.VSL_CD (+)" ).append("\n"); 
		query.append("  AND RH2.VOY_NO       = RR.VOY_NO (+)" ).append("\n"); 
		query.append("  AND RH2.DIR_CD       = RR.DIR_CD (+)" ).append("\n"); 
		query.append("  AND RH2.REGION       = RR.REGION (+)" ).append("\n"); 
		query.append("  AND 'SML'            = RR.OPR_CD (+)" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("    M3.TRD_CD," ).append("\n"); 
		query.append("    M3.SLAN_CD ," ).append("\n"); 
		query.append("    M3.VSL_CD,                  /* i_vsl_cd     */" ).append("\n"); 
		query.append("    M3.SKD_VOY_NO ,             /* i_skd_voy_no   */" ).append("\n"); 
		query.append("    M3.SKD_DIR_CD ,             /* i_skd_dir_cd   */" ).append("\n"); 
		query.append("    M3.VPS_PORT_CD ,            /* i_vps_port_cd  */" ).append("\n"); 
		query.append("    M3.CLPT_IND_SEQ ,           /* i_clpt_ind_seq */" ).append("\n"); 
		query.append("    M3.CLPT_SEQ ,               /* i_clpt_seq   */" ).append("\n"); 
		query.append("    TO_CHAR(M3.VPS_ETD_DT, 'YYYYMMDD') ,  /* i_vps_etd_dt_1 */" ).append("\n"); 
		query.append("    M3.FROM_RGN ,               /* i_from_rgn   */" ).append("\n"); 
		query.append("    M3.TO_RGN" ).append("\n"); 

	}
}