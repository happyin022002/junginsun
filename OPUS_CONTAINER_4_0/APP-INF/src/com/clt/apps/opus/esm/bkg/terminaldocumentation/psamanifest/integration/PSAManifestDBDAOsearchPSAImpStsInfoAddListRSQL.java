/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL").append("\n"); 
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
		query.append("SELECT 1 AS SEL," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       SEAL_NO," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       CASE WHEN VGM_WGT > 0 THEN 'V'" ).append("\n"); 
		query.append("            WHEN CNTR_WGT > 0 THEN 'C'" ).append("\n"); 
		query.append("            WHEN BKG_CGO_TP_CD IN ('R', 'P') THEN 'E'" ).append("\n"); 
		query.append("            ELSE 'Z'" ).append("\n"); 
		query.append("       END AS PSA_CRE_TP_CD," ).append("\n"); 
		query.append("       CASE WHEN VGM_WGT > 0 THEN" ).append("\n"); 
		query.append("              TRUNC(VGM_WGT)" ).append("\n"); 
		query.append("            WHEN CNTR_WGT > 0 THEN" ).append("\n"); 
		query.append("              SUM(CNTR_WGT) OVER (PARTITION BY CNTR_NO) + MST_SPEC_FNC('TARE', CNTR_NO)" ).append("\n"); 
		query.append("            WHEN BKG_CGO_TP_CD IN ('R', 'P') THEN" ).append("\n"); 
		query.append("              TRUNC(TO_NUMBER(MST_SPEC_FNC('TARE', CNTR_NO)))" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("              0" ).append("\n"); 
		query.append("       END AS CNTR_WGT," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       DCGO_FLG," ).append("\n"); 
		query.append("       MAX(RC_FLG) OVER (PARTITION BY CNTR_NO) AS RC_FLG," ).append("\n"); 
		query.append("       MAX(AWK_CGO_FLG) OVER (PARTITION BY CNTR_NO) AS AWK_CGO_FLG," ).append("\n"); 
		query.append("       MAX(BB_CGO_FLG) OVER (PARTITION BY CNTR_NO) AS BB_CGO_FLG," ).append("\n"); 
		query.append("       MAX(RD_CGO_FLG) OVER (PARTITION BY CNTR_NO) AS RD_CGO_FLG," ).append("\n"); 
		query.append("       OOP," ).append("\n"); 
		query.append("       FM_CD," ).append("\n"); 
		query.append("       NEXT_VSL_CD," ).append("\n"); 
		query.append("       NEXT_SKD_VOY_NO," ).append("\n"); 
		query.append("       NEXT_SKD_DIR_CD," ).append("\n"); 
		query.append("       N1ST_POD_CD," ).append("\n"); 
		query.append("       N2ND_POD_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       SPC," ).append("\n"); 
		query.append("       PSA_VOY_DIR_CD," ).append("\n"); 
		query.append("       PSA_VSL_NM," ).append("\n"); 
		query.append("       SAV," ).append("\n"); 
		query.append("       COP," ).append("\n"); 
		query.append("       IOP," ).append("\n"); 
		query.append("       TS_TP_CD," ).append("\n"); 
		query.append("       LD_INS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               C.BKG_NO," ).append("\n"); 
		query.append("               B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("               C.CNTR_NO," ).append("\n"); 
		query.append("               BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                     FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                    WHERE C.BKG_NO = BKG_NO" ).append("\n"); 
		query.append("                                      AND C.CNTR_NO = CNTR_NO)) AS SEAL_NO," ).append("\n"); 
		query.append("               V.POL_CD," ).append("\n"); 
		query.append("               B.POD_CD," ).append("\n"); 
		query.append("               TRUNC(DECODE(NVL(C.WGT_UT_CD, ' '), 'LBS', ROUND(NVL(C.CNTR_WGT, 0) * 0.4536, 3), NVL(C.CNTR_WGT, 0))) AS CNTR_WGT," ).append("\n"); 
		query.append("               C.VGM_WGT," ).append("\n"); 
		query.append("               COUNT(CNTR_NO) OVER (PARTITION BY C.CNTR_NO) AS VGM_CHK_CNT," ).append("\n"); 
		query.append("               CNTR_TPSZ_TARE_WGT," ).append("\n"); 
		query.append("               CC.CNTR_COUNT," ).append("\n"); 
		query.append("               V.VSL_CD," ).append("\n"); 
		query.append("               V.SKD_VOY_NO," ).append("\n"); 
		query.append("               V.SKD_DIR_CD," ).append("\n"); 
		query.append("               C.DCGO_FLG," ).append("\n"); 
		query.append("               C.RC_FLG," ).append("\n"); 
		query.append("               C.AWK_CGO_FLG," ).append("\n"); 
		query.append("               C.BB_CGO_FLG," ).append("\n"); 
		query.append("               C.RD_CGO_FLG," ).append("\n"); 
		query.append("               DECODE(DECODE(NV.VSL_PRE_PST_CD||NV.VSL_SEQ, V.VSL_PRE_PST_CD||V.VSL_SEQ, '', NV.VSL_CD), 'ASYA', 'APL', 'HBNA', 'HMM', 'HCBA', 'HMM', 'HISA', 'HMM', 'M39A', 'WTC', 'MLBA', 'SPIL', 'MRWA', 'XCL', 'OZSA', 'OOCL', 'PTEA', 'LAU', '', '', 'NYK') AS OOP," ).append("\n"); 
		query.append("               DECODE(B.BKG_CGO_TP_CD, 'F', 'F', 'P', 'M', 'R', 'M', 'B', 'M', 'F') AS FM_CD," ).append("\n"); 
		query.append("               DECODE(NV.VSL_PRE_PST_CD||NV.VSL_SEQ, V.VSL_PRE_PST_CD||V.VSL_SEQ, '', NV.VSL_CD) AS NEXT_VSL_CD," ).append("\n"); 
		query.append("               DECODE(NV.VSL_PRE_PST_CD||NV.VSL_SEQ, V.VSL_PRE_PST_CD||V.VSL_SEQ, '', NV.SKD_VOY_NO) AS NEXT_SKD_VOY_NO," ).append("\n"); 
		query.append("               DECODE(NV.VSL_PRE_PST_CD||NV.VSL_SEQ, V.VSL_PRE_PST_CD||V.VSL_SEQ, '', NV.SKD_DIR_CD) AS NEXT_SKD_DIR_CD," ).append("\n"); 
		query.append("               DECODE(NV.VSL_PRE_PST_CD||NV.VSL_SEQ, V.VSL_PRE_PST_CD||V.VSL_SEQ, '', NV.POD_CD) AS N1ST_POD_CD," ).append("\n"); 
		query.append("--               (SELECT /*+ INDEX_ASC(BKG_VVD XPKBKG_VVD) */ POD_CD" ).append("\n"); 
		query.append("--                  FROM BKG_VVD" ).append("\n"); 
		query.append("--                 WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("--                   AND NV.VSL_PRE_PST_CD||NV.VSL_SEQ < VSL_PRE_PST_CD||VSL_SEQ" ).append("\n"); 
		query.append("--                   AND ROWNUM = 1) AS N2ND_POD_CD," ).append("\n"); 
		query.append("               '' AS N2ND_POD_CD," ).append("\n"); 
		query.append("               C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               CASE" ).append("\n"); 
		query.append("                 WHEN C.DCGO_FLG = 'Y' OR C.RC_FLG = 'Y' OR C.AWK_CGO_FLG = 'Y' OR C.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("                   THEN '1'" ).append("\n"); 
		query.append("                 ELSE '0'" ).append("\n"); 
		query.append("               END AS SPC," ).append("\n"); 
		query.append("               DECODE(NV.VSL_PRE_PST_CD||NV.VSL_SEQ, V.VSL_PRE_PST_CD||V.VSL_SEQ, '', UPPER(TRIM(PV.PSA_VOY_DIR_CD))) AS PSA_VOY_DIR_CD," ).append("\n"); 
		query.append("               DECODE(NV.VSL_PRE_PST_CD||NV.VSL_SEQ, V.VSL_PRE_PST_CD||V.VSL_SEQ, '', UPPER(TRIM(PV.PSA_VSL_NM))) AS PSA_VSL_NM," ).append("\n"); 
		query.append("               '+' AS SAV," ).append("\n"); 
		query.append("               'NYK' AS COP," ).append("\n"); 
		query.append("               DECODE(PV.VSL_CD, 'ASYA', 'APL', 'HBNA', 'HMM', 'HCBA', 'HMM', 'HISA', 'HMM', 'M39A', 'WTC', 'MLBA', 'SPIL', 'MRWA', 'XCL', 'OZSA', 'OOCL', 'PTEA', 'LAU', 'NYK') AS IOP," ).append("\n"); 
		query.append("               'T' AS TS_TP_CD," ).append("\n"); 
		query.append("               SC.STWG_CD AS LD_INS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_VVD V," ).append("\n"); 
		query.append("               BKG_BOOKING B," ).append("\n"); 
		query.append("               BKG_CONTAINER C," ).append("\n"); 
		query.append("               BKG_BL_DOC D," ).append("\n"); 
		query.append("               BKG_VVD NV," ).append("\n"); 
		query.append("               MDM_CNTR_TP_SZ TS," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_VVD PV," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("               (SELECT BC.BKG_NO," ).append("\n"); 
		query.append("                       COUNT(BC.CNTR_NO) AS CNTR_COUNT" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER BC," ).append("\n"); 
		query.append("                       BKG_VVD BV" ).append("\n"); 
		query.append("                 WHERE BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND BV.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                 GROUP BY BC.BKG_NO) CC," ).append("\n"); 
		query.append("               BKG_STWG_CGO SC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("           AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("           AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND V.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("           AND V.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("           AND V.BKG_NO = NV.BKG_NO" ).append("\n"); 
		query.append("           AND V.BKG_NO = CC.BKG_NO" ).append("\n"); 
		query.append("           AND C.CNTR_TPSZ_CD = TS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND NV.VSL_CD = PV.VSL_CD(+)" ).append("\n"); 
		query.append("           AND NV.SKD_VOY_NO = PV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND NV.SKD_DIR_CD = PV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND NV.VSL_PRE_PST_CD||NV.VSL_SEQ = (SELECT NVL(MIN(VSL_PRE_PST_CD||VSL_SEQ), V.VSL_PRE_PST_CD||V.VSL_SEQ)" ).append("\n"); 
		query.append("                                                  FROM BKG_VVD" ).append("\n"); 
		query.append("                                                 WHERE BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                                   AND V.VSL_PRE_PST_CD||V.VSL_SEQ < VSL_PRE_PST_CD||VSL_SEQ)" ).append("\n"); 
		query.append("           AND NV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("           AND NV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND NV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND NV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND B.BKG_NO = SC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND SC.STWG_SEQ(+) = 1" ).append("\n"); 
		query.append("           AND VPS.CLPT_IND_SEQ = (SELECT /*+ INDEX_ASC(P XPKVSK_VSL_PORT_SKD) */ P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                     FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND P.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                                      AND P.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND P.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      AND P.VPS_PORT_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      AND NVL(P.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ORDER BY C.CNTR_NO," ).append("\n"); 
		query.append("                  C.DCGO_FLG DESC," ).append("\n"); 
		query.append("                  C.AWK_CGO_FLG DESC," ).append("\n"); 
		query.append("                  C.RC_FLG DESC," ).append("\n"); 
		query.append("                  C.BB_CGO_FLG DESC," ).append("\n"); 
		query.append("                  C.RD_CGO_FLG DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}