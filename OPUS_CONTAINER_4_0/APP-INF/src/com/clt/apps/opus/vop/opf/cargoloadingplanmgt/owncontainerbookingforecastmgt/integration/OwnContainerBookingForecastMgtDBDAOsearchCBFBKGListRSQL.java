/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFBKGList 조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL").append("\n"); 
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
		query.append("WITH WGT_GRP AS ( " ).append("\n"); 
		query.append("     SELECT SLAN_CD," ).append("\n"); 
		query.append("            SKD_DIR_CD," ).append("\n"); 
		query.append("            POL_CD," ).append("\n"); 
		query.append("            CNTR_SZ_CD," ).append("\n"); 
		query.append("            FULL_MTY_CD," ).append("\n"); 
		query.append("            CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("            FM_LMT_WGT FROM_LMT_WGT," ).append("\n"); 
		query.append("            TO_LMT_WGT TO_LMT_WGT" ).append("\n"); 
		query.append("       FROM OPF_CGO_BKG_FCAST_WGT_GRP " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", COPY_T AS ( " ).append("\n"); 
		query.append("      --2016-08-02 Improvement--" ).append("\n"); 
		query.append("--   SELECT ROWNUM NO" ).append("\n"); 
		query.append("--   FROM BKG_BOOKING" ).append("\n"); 
		query.append("--   WHERE ROWNUM<=1000 " ).append("\n"); 
		query.append("     SELECT LEVEL NO" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      CONNECT BY LEVEL <= 1000" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VVD_BKG AS (" ).append("\n"); 
		query.append("    SELECT VVD.BKG_NO," ).append("\n"); 
		query.append("           VVD.POD_CD," ).append("\n"); 
		query.append("           VVD.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("           VVD.POL_YD_CD," ).append("\n"); 
		query.append("           VVD.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("           BKG.BLCK_STWG_CD," ).append("\n"); 
		query.append("           BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("           BKG.SPLIT_FLG," ).append("\n"); 
		query.append("           VVD.SLAN_CD," ).append("\n"); 
		query.append("           VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("           VVD.POL_CD," ).append("\n"); 
		query.append("           BKG.PRCT_FLG," ).append("\n"); 
		query.append("           BKG.BKG_STS_CD," ).append("\n"); 
		query.append("           BKG.BKG_CRE_TP_CD," ).append("\n"); 
		query.append("           BKG.FM_BKG_NO" ).append("\n"); 
		query.append("    FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("    WHERE  1=1" ).append("\n"); 
		query.append("           AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND VVD.POL_YD_CD || VVD.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("           AND VVD.POL_CD = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("           AND VVD.POL_CLPT_IND_SEQ = SUBSTR(@[yd_cd], 8)								" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD  <> 'X'" ).append("\n"); 
		query.append("           AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", QTY_CNTR_TMP AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    QTY.BKG_NO," ).append("\n"); 
		query.append("    QTY.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    QTY.OP_CNTR_QTY," ).append("\n"); 
		query.append("    (SELECT COUNT(*)" ).append("\n"); 
		query.append("      FROM BKG_CONTAINER C" ).append("\n"); 
		query.append("     WHERE C.BKG_NO       = QTY.BKG_NO" ).append("\n"); 
		query.append("       AND C.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ) AS AC_CNTR_QTY," ).append("\n"); 
		query.append("    CNTR.CNTR_NO," ).append("\n"); 
		query.append("    CNTR.DCGO_FLG," ).append("\n"); 
		query.append("    CNTR.RC_FLG," ).append("\n"); 
		query.append("    CNTR.AWK_CGO_FLG," ).append("\n"); 
		query.append("    CNTR.BB_CGO_FLG," ).append("\n"); 
		query.append("    CNTR.CNTR_WGT," ).append("\n"); 
		query.append("    CNTR.WGT_UT_CD," ).append("\n"); 
		query.append("	CNTR.CNTR_PRT_FLG" ).append("\n"); 
		query.append("    FROM BKG_QUANTITY  QTY, BKG_CONTAINER CNTR, VVD_BKG BKG" ).append("\n"); 
		query.append("    WHERE QTY.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("    AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("    AND QTY.BKG_NO       = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("    AND QTY.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    CNTR.BKG_NO," ).append("\n"); 
		query.append("    CNTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    0 AS OP_CNTR_QTY," ).append("\n"); 
		query.append("    COUNT(CNTR_NO) OVER (PARTITION BY CNTR.BKG_NO, CNTR.CNTR_TPSZ_CD) AS AC_CNTR_QTY," ).append("\n"); 
		query.append("    CNTR.CNTR_NO," ).append("\n"); 
		query.append("    CNTR.DCGO_FLG," ).append("\n"); 
		query.append("    CNTR.RC_FLG," ).append("\n"); 
		query.append("    CNTR.AWK_CGO_FLG," ).append("\n"); 
		query.append("    CNTR.BB_CGO_FLG," ).append("\n"); 
		query.append("    CNTR.CNTR_WGT," ).append("\n"); 
		query.append("    CNTR.WGT_UT_CD," ).append("\n"); 
		query.append("	CNTR.CNTR_PRT_FLG" ).append("\n"); 
		query.append("    FROM BKG_CONTAINER CNTR, VVD_BKG BKG" ).append("\n"); 
		query.append("    WHERE CNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("    AND CNTR_TPSZ_CD NOT IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = CNTR.BKG_NO)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", QTY_CNTR AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CASE WHEN NON_OP_CNTR_QTY > 0 AND OP_CNTR_QTY != AC_CNTR_QTY AND OP_CNTR_QTY != 0" ).append("\n"); 
		query.append("                THEN OP_CNTR_QTY - (NON_OP_CNTR_QTY / ONLY_OP_CNTR_TP_CNT)" ).append("\n"); 
		query.append("             WHEN OP_CNTR_QTY = 0" ).append("\n"); 
		query.append("                THEN AC_CNTR_QTY" ).append("\n"); 
		query.append("             ELSE OP_CNTR_QTY" ).append("\n"); 
		query.append("        END AS OP_CNTR_QTY," ).append("\n"); 
		query.append("        AC_CNTR_QTY," ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        DCGO_FLG," ).append("\n"); 
		query.append("        RC_FLG," ).append("\n"); 
		query.append("        AWK_CGO_FLG," ).append("\n"); 
		query.append("        BB_CGO_FLG," ).append("\n"); 
		query.append("        CNTR_WGT," ).append("\n"); 
		query.append("        WGT_UT_CD," ).append("\n"); 
		query.append("		CNTR_PRT_FLG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            T1.BKG_NO," ).append("\n"); 
		query.append("            T1.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            T1.OP_CNTR_QTY," ).append("\n"); 
		query.append("            T1.AC_CNTR_QTY," ).append("\n"); 
		query.append("            T2.ONLY_OP_CNTR_QTY," ).append("\n"); 
		query.append("            T3.NON_OP_CNTR_QTY," ).append("\n"); 
		query.append("            T4.ONLY_OP_CNTR_TP_CNT," ).append("\n"); 
		query.append("            T1.CNTR_NO," ).append("\n"); 
		query.append("            T1.DCGO_FLG," ).append("\n"); 
		query.append("            T1.RC_FLG," ).append("\n"); 
		query.append("            T1.AWK_CGO_FLG," ).append("\n"); 
		query.append("            T1.BB_CGO_FLG," ).append("\n"); 
		query.append("            T1.CNTR_WGT," ).append("\n"); 
		query.append("            T1.WGT_UT_CD," ).append("\n"); 
		query.append("			T1.CNTR_PRT_FLG" ).append("\n"); 
		query.append("        FROM QTY_CNTR_TMP T1," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT BKG_NO, (SUM(OP_CNTR_QTY) - SUM(AC_CNTR_QTY)) AS ONLY_OP_CNTR_QTY" ).append("\n"); 
		query.append("                FROM QTY_CNTR_TMP" ).append("\n"); 
		query.append("                GROUP BY BKG_NO" ).append("\n"); 
		query.append("            ) T2," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT BKG_NO, SUM(AC_CNTR_QTY) AS NON_OP_CNTR_QTY" ).append("\n"); 
		query.append("                FROM QTY_CNTR_TMP" ).append("\n"); 
		query.append("                WHERE OP_CNTR_QTY = 0" ).append("\n"); 
		query.append("                GROUP BY BKG_NO" ).append("\n"); 
		query.append("            ) T3," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT BKG_NO, COUNT(CNTR_TPSZ_CD) AS ONLY_OP_CNTR_TP_CNT" ).append("\n"); 
		query.append("                FROM QTY_CNTR_TMP" ).append("\n"); 
		query.append("                WHERE OP_CNTR_QTY = 0" ).append("\n"); 
		query.append("                GROUP BY BKG_NO" ).append("\n"); 
		query.append("            ) T4" ).append("\n"); 
		query.append("        WHERE T1.BKG_NO = T2.BKG_NO" ).append("\n"); 
		query.append("        AND T1.BKG_NO = T3.BKG_NO(+)" ).append("\n"); 
		query.append("        AND T1.BKG_NO = T4.BKG_NO(+)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT --DISTINCT --QT.BKG_NO," ).append("\n"); 
		query.append("	   QT.BKG_NO||DECODE(QT.C_BKG_NO, NULL, '', '/')||QT.C_BKG_NO AS BKG_REF_NO_CTNT," ).append("\n"); 
		query.append("       QT.BKG_NO," ).append("\n"); 
		query.append("       QT.CNTR_NO," ).append("\n"); 
		query.append("       QT.POD POD_CD," ).append("\n"); 
		query.append("       QT.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       QT.MLB MLB_CD," ).append("\n"); 
		query.append("       COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() CRR_CD," ).append("\n"); 
		query.append("       QT.TP CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       WP.CNTR_WGT_GRP_CD CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("       QT.FM FULL_MTY_CD," ).append("\n"); 
		query.append("       QT.DG DCGO_FLG," ).append("\n"); 
		query.append("       QT.RF RC_FLG," ).append("\n"); 
		query.append("       QT.AK AWK_CGO_FLG," ).append("\n"); 
		query.append("       QT.BB BB_CGO_FLG," ).append("\n"); 
		query.append("       QT.STWG_CD," ).append("\n"); 
		query.append("       QT.STWG_CGO_FLG," ).append("\n"); 
		query.append("       QT.PRCT_FLG," ).append("\n"); 
		query.append("       ROUND(CNTR_GRS_WGT,3) CNTR_GRS_WGT," ).append("\n"); 
		query.append("       QT.STS BKG_STS_CD," ).append("\n"); 
		query.append("       @[vsl_cd] VSL_CD," ).append("\n"); 
		query.append("       @[skd_voy_no] SKD_VOY_NO," ).append("\n"); 
		query.append("       @[skd_dir_cd] SKD_DIR_CD," ).append("\n"); 
		query.append("       QT.POL_YD_CD  YD_CD," ).append("\n"); 
		query.append("       QT.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       'D' RD_ST," ).append("\n"); 
		query.append("       'Y' BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("       (SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = @[skd_dir_cd]) SLAN_CD," ).append("\n"); 
		query.append("       'V' CBF_DP_CD" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("        SELECT QT.BKG_NO," ).append("\n"); 
		query.append("			   QT.C_BKG_NO," ).append("\n"); 
		query.append("               QT.CNTR_NO," ).append("\n"); 
		query.append("               QT.POD," ).append("\n"); 
		query.append("               QT.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("               QT.POL_YD_CD," ).append("\n"); 
		query.append("               QT.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("               QT.MLB," ).append("\n"); 
		query.append("               QT.TP," ).append("\n"); 
		query.append("               QT.FM," ).append("\n"); 
		query.append("               QT.DG," ).append("\n"); 
		query.append("               QT.RF," ).append("\n"); 
		query.append("               QT.AK," ).append("\n"); 
		query.append("               QT.BB," ).append("\n"); 
		query.append("               -- Modify weight calculation!" ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                        WHEN CNTR_NO IS NOT NULL AND CNTR_WGT > 0 AND CNTR_PRT_FLG = 'Y'" ).append("\n"); 
		query.append("                            THEN (" ).append("\n"); 
		query.append("                                SELECT   (SELECT SUM(BCC.CNTR_WGT)     ---- Container total cargo weight ----" ).append("\n"); 
		query.append("                                          FROM   BKG_BOOKING       BKK" ).append("\n"); 
		query.append("                                               , BKG_CONTAINER     BCC " ).append("\n"); 
		query.append("                                          WHERE  1 = 1" ).append("\n"); 
		query.append("                                          AND    BKK.BKG_NO        = BCC.BKG_NO" ).append("\n"); 
		query.append("                                          AND    BKK.VSL_CD        = BK.VSL_CD        ---- Same Trunk VVD ----" ).append("\n"); 
		query.append("                                          AND    BKK.SKD_VOY_NO    = BK.SKD_VOY_NO    ---- Same Trunk VVD ----" ).append("\n"); 
		query.append("                                          AND    BKK.SKD_DIR_CD    = BK.SKD_DIR_CD    ---- Same Trunk VVD ----" ).append("\n"); 
		query.append("                                          AND    BKK.POL_CD        = BK.POL_CD        ---- Same POL of BKG ----" ).append("\n"); 
		query.append("                                          AND    BKK.POD_CD        = BK.POD_CD        ---- Same POL of BKG ----" ).append("\n"); 
		query.append("                                          AND    BCC.CNTR_NO       = BC.CNTR_NO       ---- Same Container# ----" ).append("\n"); 
		query.append("                                          ) as wgt" ).append("\n"); 
		query.append("                                FROM     BKG_BOOKING               BK" ).append("\n"); 
		query.append("                                       , BKG_CONTAINER             BC" ).append("\n"); 
		query.append("                                       , SCE_COP_HDR               HD" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      BK.BKG_NO                 = BC.BKG_NO" ).append("\n"); 
		query.append("                                AND      BC.BKG_NO                 = HD.BKG_NO" ).append("\n"); 
		query.append("                                AND      BC.CNTR_NO                = HD.CNTR_NO" ).append("\n"); 
		query.append("                                AND      HD.MST_COP_NO             = HD.COP_NO      ---- Partial Container중 Master 추출조건 ----" ).append("\n"); 
		query.append("                                AND      BC.CNTR_PRT_FLG           = 'Y'            ---- Partial Container Indicator ------------" ).append("\n"); 
		query.append("                                AND      BK.BKG_NO                 = QT.BKG_NO" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        WHEN CNTR_NO IS NOT NULL AND CNTR_WGT > 0 AND CNTR_PRT_FLG <> 'Y'" ).append("\n"); 
		query.append("                            THEN CNTR_WGT" ).append("\n"); 
		query.append("                        WHEN (COUNT(CNTR_WGT) OVER (PARTITION BY BKG_NO) - AC_CNTR_QTY) > 0" ).append("\n"); 
		query.append("                            THEN (ACT_WGT - CNTR_WGT_SUM) / (COUNT(CNTR_WGT) OVER (PARTITION BY BKG_NO) - AC_CNTR_QTY)" ).append("\n"); 
		query.append("                        ELSE ACT_WGT / (COUNT(CNTR_WGT) OVER (PARTITION BY BKG_NO))" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("               ) + DECODE(NVL(TP.CNTR_TPSZ_TARE_WGT,0), 0, DECODE(SUBSTR(QT.TP,2,1),2,2500,4000), NVL(TP.CNTR_TPSZ_TARE_WGT,0)) CNTR_GRS_WGT," ).append("\n"); 
		query.append("               QT.SLAN_CD," ).append("\n"); 
		query.append("               QT.SKD_DIR_CD," ).append("\n"); 
		query.append("               QT.POL_CD," ).append("\n"); 
		query.append("               QT.PRCT_FLG," ).append("\n"); 
		query.append("               QT.STWG_CD," ).append("\n"); 
		query.append("               QT.STWG_CGO_FLG," ).append("\n"); 
		query.append("               QT.STS" ).append("\n"); 
		query.append("          FROM ( " ).append("\n"); 
		query.append("                SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("                       BKG_NO," ).append("\n"); 
		query.append("					   C_BKG_NO," ).append("\n"); 
		query.append("                       CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CNTR_NO END CNTR_NO," ).append("\n"); 
		query.append("                       POD," ).append("\n"); 
		query.append("                       POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                       POL_YD_CD," ).append("\n"); 
		query.append("                       POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                       MLB," ).append("\n"); 
		query.append("                       TP," ).append("\n"); 
		query.append("                       FM," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CDG END,DG) DG," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CRF END,RF) RF ," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CAK END,AK) AK ," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CBB END,BB) BB," ).append("\n"); 
		query.append("                       -- Delete because wrong calculation!" ).append("\n"); 
		query.append("--                       (CASE WHEN RN=1 AND NO=1 AND  CNTR_NO IS NULL     THEN ((TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('KGS', ACT_WGT) - TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('KGS', CNTR_WGT_SUM))" ).append("\n"); 
		query.append("--                                                                                /(COUNT(CNTR_WGT) OVER (PARTITION BY BKG_NO) - AC_CNTR_QTY) )" ).append("\n"); 
		query.append("--                             WHEN RN=1 AND NO=1 AND  CNTR_NO IS NOT NULL THEN (TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('KGS', CNTR_WGT) )       " ).append("\n"); 
		query.append("--                             WHEN RN=1 AND NO>1                          THEN ((TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('KGS', ACT_WGT) - TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('KGS', CNTR_WGT_SUM))" ).append("\n"); 
		query.append("--                                                                                /(COUNT(CNTR_WGT) OVER (PARTITION BY BKG_NO) - AC_CNTR_QTY) )" ).append("\n"); 
		query.append("--                             ELSE TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('KGS', CNTR_WGT)" ).append("\n"); 
		query.append("--                       END) AS CNTR_GRS_WGT," ).append("\n"); 
		query.append("                       -- Add columns" ).append("\n"); 
		query.append("                       ACT_WGT," ).append("\n"); 
		query.append("                       CNTR_WGT_SUM," ).append("\n"); 
		query.append("                       CNTR_WGT," ).append("\n"); 
		query.append("                       AC_CNTR_QTY," ).append("\n"); 
		query.append("                       SLAN_CD ," ).append("\n"); 
		query.append("                       SKD_DIR_CD ," ).append("\n"); 
		query.append("                       POL_CD," ).append("\n"); 
		query.append("                       PRCT_FLG," ).append("\n"); 
		query.append("                       STWG_CD," ).append("\n"); 
		query.append("                       STWG_CGO_FLG," ).append("\n"); 
		query.append("                       STS," ).append("\n"); 
		query.append("					   CNTR_PRT_FLG" ).append("\n"); 
		query.append("                  FROM ( " ).append("\n"); 
		query.append("                        SELECT BKG_NO," ).append("\n"); 
		query.append("							   C_BKG_NO," ).append("\n"); 
		query.append("                               POD," ).append("\n"); 
		query.append("                               POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                               POL_YD_CD," ).append("\n"); 
		query.append("                               POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                               MLB," ).append("\n"); 
		query.append("                               TP," ).append("\n"); 
		query.append("                               FM," ).append("\n"); 
		query.append("                               DG," ).append("\n"); 
		query.append("                               RF," ).append("\n"); 
		query.append("                               AK," ).append("\n"); 
		query.append("                               BB," ).append("\n"); 
		query.append("                               --DECODE(ac_cntr_flg,'C',AC_CNTR_QTY,OP_CNTR_QTY) CNTR_QTY," ).append("\n"); 
		query.append("                               OP_CNTR_QTY AS CNTR_QTY," ).append("\n"); 
		query.append("                               SLAN_CD," ).append("\n"); 
		query.append("                               SKD_DIR_CD," ).append("\n"); 
		query.append("                               POL_CD," ).append("\n"); 
		query.append("                               PRCT_FLG," ).append("\n"); 
		query.append("                               STWG_CD," ).append("\n"); 
		query.append("                               STWG_CGO_FLG," ).append("\n"); 
		query.append("                               CNTR_NO," ).append("\n"); 
		query.append("                               CDG," ).append("\n"); 
		query.append("                               CRF," ).append("\n"); 
		query.append("                               CAK," ).append("\n"); 
		query.append("                               CBB," ).append("\n"); 
		query.append("                               STS," ).append("\n"); 
		query.append("                               ROW_NUMBER() OVER (PARTITION BY BKG_NO, TP ORDER BY CNTR_NO) RN," ).append("\n"); 
		query.append("                               COUNT(CNTR_NO) OVER (PARTITION BY BKG_NO, TP ) CNT," ).append("\n"); 
		query.append("                               -- Weight value convert to KGS!" ).append("\n"); 
		query.append("                               --NVL(CNTR_WGT,0) CNTR_WGT," ).append("\n"); 
		query.append("                               --NVL(CNTR_WGT_SUM,0) CNTR_WGT_SUM," ).append("\n"); 
		query.append("                               NVL2(CNTR_WGT, DECODE(CNTR_WGT_UT_CD, 'LBS', VSK_COMMON_PKG.GET_CONV_WGT_FNC('L', 'K', CNTR_WGT), CNTR_WGT), 0) AS CNTR_WGT," ).append("\n"); 
		query.append("                               NVL2(CNTR_WGT_SUM, DECODE(CNTR_WGT_UT_CD, 'LBS', VSK_COMMON_PKG.GET_CONV_WGT_FNC('L', 'K', CNTR_WGT_SUM), CNTR_WGT_SUM), 0) AS CNTR_WGT_SUM," ).append("\n"); 
		query.append("                               -- Delete because not used!" ).append("\n"); 
		query.append("--                               TP_OP_QTY," ).append("\n"); 
		query.append("--                               TOT_TP_OP_QTY," ).append("\n"); 
		query.append("                               -- Weight value convert to KGS!" ).append("\n"); 
		query.append("                               --ACT_WGT," ).append("\n"); 
		query.append("                               DECODE(DOC_WGT_UT_CD, 'LBS', VSK_COMMON_PKG.GET_CONV_WGT_FNC('L', 'K', ACT_WGT), ACT_WGT) AS ACT_WGT," ).append("\n"); 
		query.append("                               AC_CNTR_QTY," ).append("\n"); 
		query.append("                               OP_CNTR_QTY," ).append("\n"); 
		query.append("							   CNTR_PRT_FLG" ).append("\n"); 
		query.append("                          FROM ( " ).append("\n"); 
		query.append("                                SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("                                       VVD_BKG.BKG_NO       BKG_NO," ).append("\n"); 
		query.append("                                       VVD_BKG.POD_CD       POD," ).append("\n"); 
		query.append("                                       VVD_BKG.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                       VVD_BKG.POL_YD_CD," ).append("\n"); 
		query.append("                                       VVD_BKG.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                       VVD_BKG.BLCK_STWG_CD MLB," ).append("\n"); 
		query.append("                                       QTY.CNTR_TPSZ_CD TP," ).append("\n"); 
		query.append("                                       DECODE(NVL(VVD_BKG.BKG_CGO_TP_CD,' '),'F','F','E') FM," ).append("\n"); 
		query.append("                                       DTL.DCGO_FLG     DG," ).append("\n"); 
		query.append("                                       DTL.RC_FLG       RF," ).append("\n"); 
		query.append("                                       DTL.AWK_CGO_FLG  AK," ).append("\n"); 
		query.append("                                       DTL.BB_CGO_FLG   BB," ).append("\n"); 
		query.append("                                       -- If split booking exist, add split booking weight!" ).append("\n"); 
		query.append("                                       --DOC.ACT_WGT," ).append("\n"); 
		query.append("                                       CASE WHEN VVD_BKG.SPLIT_FLG = 'Y'" ).append("\n"); 
		query.append("                                            THEN (" ).append("\n"); 
		query.append("                                                SELECT SUM(ACT_WGT) " ).append("\n"); 
		query.append("                                                FROM BKG_BL_DOC " ).append("\n"); 
		query.append("                                                WHERE BKG_NO IN (" ).append("\n"); 
		query.append("                                                    SELECT BKG_NO " ).append("\n"); 
		query.append("                                                    FROM BKG_BOOKING FM_BKG " ).append("\n"); 
		query.append("                                                    WHERE VVD_BKG.BKG_NO = FM_BKG.FM_BKG_NO " ).append("\n"); 
		query.append("                                                    AND FM_BKG.BKG_CRE_TP_CD ='S' -- Split code" ).append("\n"); 
		query.append("                                                    AND FM_BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                            ) + DOC.ACT_WGT" ).append("\n"); 
		query.append("                                       ELSE DOC.ACT_WGT" ).append("\n"); 
		query.append("                                       END AS ACT_WGT," ).append("\n"); 
		query.append("                                       DOC.WGT_UT_CD    DOC_WGT_UT_CD," ).append("\n"); 
		query.append("                                       -- Delete because not used!" ).append("\n"); 
		query.append("--                                       (SELECT SUM(BQ.OP_CNTR_QTY*DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),2,1,2))  " ).append("\n"); 
		query.append("--                                          FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("--                                         WHERE BQ.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("--                                           AND BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("--                                       ) AS TOT_TP_OP_QTY,                                           " ).append("\n"); 
		query.append("--                                       (SELECT SUM(BQ.OP_CNTR_QTY*DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),2,1,2))" ).append("\n"); 
		query.append("--                                          FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("--                                         WHERE BQ.BKG_NO       = BKG.BKG_NO" ).append("\n"); 
		query.append("--                                           AND BQ.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--                                           AND BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("--                                       ) AS TP_OP_QTY,                                           " ).append("\n"); 
		query.append("--                                       SUM(DISTINCT(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,QTY.ACT_CNTR_QTY,QTY.ACT_CNTR_QTY*2))) OVER (PARTITION BY BKG.BKG_NO, QTY.CNTR_TPSZ_CD) AS TP_AC_QTY, " ).append("\n"); 
		query.append("--                                       SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,1,2)) OVER (PARTITION BY QTY.BKG_NO) AS TOT_TP_AC_QTY," ).append("\n"); 
		query.append("--                                       SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,1,2)) OVER (PARTITION BY QTY.BKG_NO, QTY.CNTR_TPSZ_CD) AS TP_CNR_QTY," ).append("\n"); 
		query.append("                                       (SELECT COUNT(*)" ).append("\n"); 
		query.append("                                          FROM BKG_CONTAINER C" ).append("\n"); 
		query.append("                                         WHERE C.BKG_NO       = QTY.BKG_NO" ).append("\n"); 
		query.append("                                           AND C.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                           AND C.CNTR_WGT != 0" ).append("\n"); 
		query.append("                                       ) AS AC_CNTR_QTY, " ).append("\n"); 
		query.append("                                       QTY.OP_CNTR_QTY AS OP_CNTR_QTY, " ).append("\n"); 
		query.append("                                       VVD_BKG.SLAN_CD      SLAN_CD," ).append("\n"); 
		query.append("                                       VVD_BKG.SKD_DIR_CD   SKD_DIR_CD," ).append("\n"); 
		query.append("                                       VVD_BKG.POL_CD       POL_CD," ).append("\n"); 
		query.append("                                       VVD_BKG.PRCT_FLG     PRCT_FLG," ).append("\n"); 
		query.append("                                       STWG.STWG_CD     STWG_CD," ).append("\n"); 
		query.append("                                       DECODE(STWG.STWG_CD,'','N','Y') STWG_CGO_FLG," ).append("\n"); 
		query.append("                                       QTY.CNTR_NO     CNTR_NO," ).append("\n"); 
		query.append("                                       QTY.DCGO_FLG    CDG," ).append("\n"); 
		query.append("                                       QTY.RC_FLG      CRF," ).append("\n"); 
		query.append("                                       QTY.AWK_CGO_FLG CAK," ).append("\n"); 
		query.append("                                       QTY.BB_CGO_FLG  CBB," ).append("\n"); 
		query.append("                                       QTY.CNTR_WGT    CNTR_WGT," ).append("\n"); 
		query.append("                                       SUM(CNTR_WGT) OVER (PARTITION BY QTY.BKG_NO) AS CNTR_WGT_SUM," ).append("\n"); 
		query.append("                                       QTY.WGT_UT_CD   CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("                                       VVD_BKG.BKG_STS_CD   STS," ).append("\n"); 
		query.append("									   --2016-08-02 Improvement--" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									   --PBKG.C_BKG_NO," ).append("\n"); 
		query.append("									   --DECODE(QTY.BKG_NO, DELG.BKG_NO, 'Y', 'N') DEL_BKG" ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                        SELECT " ).append("\n"); 
		query.append("                                            LISTAGG(SUBSTR(FM_BKG.BKG_NO,-2), '/') WITHIN GROUP( ORDER BY FM_BKG.BKG_NO) AS C_BKG_NO" ).append("\n"); 
		query.append("                                         FROM BKG_BOOKING FM_BKG" ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                        AND VVD_BKG.BKG_NO = FM_BKG.FM_BKG_NO" ).append("\n"); 
		query.append("                                        AND FM_BKG.BKG_CRE_TP_CD ='S' -- Split code" ).append("\n"); 
		query.append("                                        AND FM_BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("--                                        AND EXISTS" ).append("\n"); 
		query.append("--                                           (SELECT 'X' FROM BKG_CONTAINER FM_CNTR WHERE FM_CNTR.BKG_NO = FM_BKG.BKG_NO)" ).append("\n"); 
		query.append("                                        ) AS C_BKG_NO," ).append("\n"); 
		query.append("--									   DECODE(QTY.BKG_NO, DELG.BKG_NO, 'Y', 'N') DEL_BKG" ).append("\n"); 
		query.append("                                       CASE WHEN VVD_BKG.FM_BKG_NO IS NOT NULL AND VVD_BKG.BKG_CRE_TP_CD ='S' -- Split code" ).append("\n"); 
		query.append("                                            THEN 'Y' ELSE 'N' END AS DEL_BKG," ).append("\n"); 
		query.append("									   --2016-08-02 Improvement--" ).append("\n"); 
		query.append("										QTY.CNTR_PRT_FLG" ).append("\n"); 
		query.append("                                  FROM VVD_BKG       VVD_BKG, " ).append("\n"); 
		query.append("                                       BKG_STWG_CGO  STWG, " ).append("\n"); 
		query.append("                                       BKG_BL_DOC    DOC, " ).append("\n"); 
		query.append("                                       BKG_QTY_DTL   DTL," ).append("\n"); 
		query.append("                                       QTY_CNTR      QTY" ).append("\n"); 
		query.append("--                                     --2016-07-29 Improvement--" ).append("\n"); 
		query.append("--                                     (  SELECT P_BKG_NO" ).append("\n"); 
		query.append("--                                             , LISTAGG(SUBSTR(BKG_NO,-2), '/') WITHIN GROUP( ORDER BY BKG_NO) AS C_BKG_NO" ).append("\n"); 
		query.append("--                                          FROM (SELECT /*+USE_HASH(B, A)*/DISTINCT SUBSTR(TRIM(A.CRNT_CTNT), -12) P_BKG_NO" ).append("\n"); 
		query.append("--                                                     , A.BKG_NO" ).append("\n"); 
		query.append("--                                                  FROM BKG_HIS_DTL A" ).append("\n"); 
		query.append("--                                                     , BKG_CONTAINER B" ).append("\n"); 
		query.append("--                                                 WHERE 1 = 1" ).append("\n"); 
		query.append("--                                                   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("--                                                   AND A.HIS_CATE_NM = 'SPLIT'" ).append("\n"); 
		query.append("--                                                   AND A.CRNT_CTNT LIKE 'Split from BKG No%'" ).append("\n"); 
		query.append("--                                               )" ).append("\n"); 
		query.append("--                                       GROUP BY P_BKG_NO" ).append("\n"); 
		query.append("--                                      ) PBKG," ).append("\n"); 
		query.append("--                                     (" ).append("\n"); 
		query.append("--                                     " ).append("\n"); 
		query.append("--                                        SELECT /*+USE_HASH(A, B)*/DISTINCT A.BKG_NO" ).append("\n"); 
		query.append("--                                                  FROM BKG_HIS_DTL A" ).append("\n"); 
		query.append("--                                                     , BKG_CONTAINER B" ).append("\n"); 
		query.append("--                                                 WHERE 1 = 1" ).append("\n"); 
		query.append("--                                                   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("--                                                   AND A.HIS_CATE_NM = 'SPLIT'" ).append("\n"); 
		query.append("--                                                   AND A.CRNT_CTNT LIKE 'Split from BKG No%'" ).append("\n"); 
		query.append("--                                      ) DELG" ).append("\n"); 
		query.append("--                                      --2016-07-29 Improvement--" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   #if(${bk_st} == 'F')" ).append("\n"); 
		query.append("                                   AND VVD_BKG.BKG_STS_CD  LIKE 'F'||'%'            --:BKG_STS(CONFIRM : 'F', ALL : '')" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   AND VVD_BKG.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("                                   AND VVD_BKG.BKG_NO       = QTY.BKG_NO" ).append("\n"); 
		query.append("                                   AND VVD_BKG.BKG_NO       = STWG.BKG_NO(+)" ).append("\n"); 
		query.append("                                   AND QTY.BKG_NO       = DTL.BKG_NO(+)" ).append("\n"); 
		query.append("                                   AND QTY.CNTR_TPSZ_CD = DTL.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                               ) " ).append("\n"); 
		query.append("						 WHERE DEL_BKG = 'N'" ).append("\n"); 
		query.append("                       )      QTY, " ).append("\n"); 
		query.append("                       COPY_T C" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND CNTR_QTY > 0" ).append("\n"); 
		query.append("                   AND DECODE(QTY.RN,1,CNTR_QTY - DECODE(QTY.CNT,0,0,QTY.CNT-1)) >= C.NO(+) " ).append("\n"); 
		query.append("               )              QT, " ).append("\n"); 
		query.append("               MDM_CNTR_TP_SZ TP" ).append("\n"); 
		query.append("         WHERE QT.TP = TP.CNTR_TPSZ_CD(+) " ).append("\n"); 
		query.append("       )       QT, " ).append("\n"); 
		query.append("       WGT_GRP WP" ).append("\n"); 
		query.append(" WHERE QT.SLAN_CD         = WP.SLAN_CD(+)" ).append("\n"); 
		query.append("   AND QT.SKD_DIR_CD      = WP.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND QT.POL_CD          = WP.POL_CD(+)" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(QT.TP,2,1),'2','2','4') = WP.CNTR_SZ_CD(+)" ).append("\n"); 
		query.append("   AND QT.FM              = WP.FULL_MTY_CD(+)" ).append("\n"); 
		query.append("   AND QT.CNTR_GRS_WGT/1000 > WP.FROM_LMT_WGT(+) " ).append("\n"); 
		query.append("   AND QT.CNTR_GRS_WGT/1000 <= NVL(WP.TO_LMT_WGT(+),9999999999)" ).append("\n"); 
		query.append("#if(${ac_cntr_flg} == 'C')" ).append("\n"); 
		query.append("   AND LENGTH(CNTR_NO) > 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY  " ).append("\n"); 
		query.append("       POD_CD, " ).append("\n"); 
		query.append("       POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       MLB_CD, " ).append("\n"); 
		query.append("       BKG_NO, " ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("       CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("       FULL_MTY_CD, " ).append("\n"); 
		query.append("       DECODE(DCGO_FLG,'Y','1',RC_FLG,'Y','2',AWK_CGO_FLG,'Y','3',BB_CGO_FLG,'Y','4')" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}