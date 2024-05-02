/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllLoadSumByPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllLoadSumByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllLoadSumByPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllLoadSumByPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllLoadSumByPodRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_pgm_no} == 'ESM_BKG_0951') " ).append("\n"); 
		query.append("/**************************** ESM_BKG_0951에서 조회된 경우  *****************************/" ).append("\n"); 
		query.append("		SELECT POD_CD GUBUN_CD," ).append("\n"); 
		query.append("			BLCK_STWG_CD AS GUBUN_CD2," ).append("\n"); 
		query.append("			'' GUBUN_CD3," ).append("\n"); 
		query.append("			1 ORDER_GUBUN," ).append("\n"); 
		query.append("			DECODE(SUM(LOCAL_40H_5 + LOCAL_40H_9 + LOCAL_40H_8), 0, '', SUM(LOCAL_40H_5 + LOCAL_40H_9 + LOCAL_40H_8)) LOCAL_40H," ).append("\n"); 
		query.append("			DECODE(SUM(LOCAL_40), 0, '', SUM(LOCAL_40)) LOCAL_40," ).append("\n"); 
		query.append("			DECODE(SUM(LOCAL_20), 0, '', SUM(LOCAL_20)) LOCAL_20," ).append("\n"); 
		query.append("			DECODE(SUM(LOCAL_45), 0, '', SUM(LOCAL_45)) LOCAL_45," ).append("\n"); 
		query.append("			DECODE(SUM(TS_40H_5 + TS_40H_9 + TS_40H_8) , 0, '', SUM(TS_40H_5 + TS_40H_9 + TS_40H_8)) TS_40H," ).append("\n"); 
		query.append("			DECODE(SUM(TS_40), 0, '', SUM(TS_40)) TS_40," ).append("\n"); 
		query.append("			DECODE(SUM(TS_20), 0, '', SUM(TS_20)) TS_20," ).append("\n"); 
		query.append("			DECODE(SUM(TS_45), 0, '', SUM(TS_45)) TS_45," ).append("\n"); 
		query.append("			DECODE(SUM(MTY_40H_5 + MTY_40H_9 + MTY_40H_8), 0, '', SUM(MTY_40H_5 + MTY_40H_9 + MTY_40H_9)) MTY_40H," ).append("\n"); 
		query.append("			DECODE(SUM(MTY_40), 0, '', SUM(MTY_40)) MTY_40," ).append("\n"); 
		query.append("			DECODE(SUM(MTY_20), 0, '', SUM(MTY_20)) MTY_20," ).append("\n"); 
		query.append("			DECODE(SUM(MTY_45), 0, '', SUM(MTY_45)) MTY_45," ).append("\n"); 
		query.append("			DECODE(SUM(NVL(LOCAL_40H_5,0) + NVL(LOCAL_40H_9,0) + NVL(LOCAL_40H_8,0) + NVL(TS_40H_5,0) + NVL(TS_40H_9,0) + NVL(TS_40H_8,0) + NVL(MTY_40H_5,0) + NVL(MTY_40H_9,0)+ NVL(MTY_40H_8,0)), 0, '', SUM(NVL(LOCAL_40H_5,0) + NVL(LOCAL_40H_9,0) + NVL(LOCAL_40H_8,0) + NVL(TS_40H_5,0) + NVL(TS_40H_9,0) + NVL(TS_40H_8,0) + NVL(MTY_40H_5,0) + NVL(MTY_40H_9,0) + NVL(MTY_40H_8,0))) SUM_40H," ).append("\n"); 
		query.append("			DECODE(SUM(NVL(LOCAL_40,0) + NVL(TS_40,0) + NVL(MTY_40,0)), 0, '', SUM(NVL(LOCAL_40,0) + NVL(TS_40,0) + NVL(MTY_40,0))) SUM_40," ).append("\n"); 
		query.append("			DECODE(SUM(NVL(LOCAL_20,0) + NVL(TS_20,0) + NVL(MTY_20,0)), 0, '', SUM(NVL(LOCAL_20,0) + NVL(TS_20,0) + NVL(MTY_20,0))) SUM_20," ).append("\n"); 
		query.append("			DECODE(SUM(NVL(LOCAL_45,0) + NVL(TS_45,0) + NVL(MTY_45,0)), 0, '', SUM(NVL(LOCAL_45,0) + NVL(TS_45,0) + NVL(MTY_45,0))) SUM_45," ).append("\n"); 
		query.append("			ROUND(DECODE(SUM(WGT + WGT_MT),0,'',SUM(WGT + WGT_MT)), 1) WGT_MT," ).append("\n"); 
		query.append("			--NVL(ROUND(SUM(WGT), 0), 1) WGT_MT," ).append("\n"); 
		query.append("			CLPT_SEQ" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("				SELECT MAX(DECODE(BK.POD_CD,'XXXXX','XXXXX',NVL(LO.UN_LOC_CD,BV.POD_CD))) POD_CD," ).append("\n"); 
		query.append("					BK.BLCK_STWG_CD AS BLCK_STWG_CD," ).append("\n"); 
		query.append("					MAX(DECODE(BK.POD_CD,'XXXXX',100,VPS.CLPT_SEQ)) CLPT_SEQ," ).append("\n"); 
		query.append("					1," ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0),0)) LOCAL_40H_5," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'8',BQ.OP_CNTR_QTY,0),0)) LOCAL_40H_8," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0),0)) LOCAL_40H_9," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8', 0,'9', 0, BQ.OP_CNTR_QTY),0)) LOCAL_40," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) LOCAL_20," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) LOCAL_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0))) TS_40H_5," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'8',BQ.OP_CNTR_QTY,0))) TS_40H_8," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0))) TS_40H_9," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8', 0, '9', 0, BQ.OP_CNTR_QTY))) TS_40," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0))) TS_20," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0))) TS_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0), 0) MTY_40H_5," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'8',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'8',BQ.OP_CNTR_QTY,0), 0) MTY_40H_8," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0), 0) MTY_40H_9," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8', 0, '9', 0, BQ.OP_CNTR_QTY), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8', 0, '9', 0, BQ.OP_CNTR_QTY), 0) MTY_40," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0), 0) MTY_20," ).append("\n"); 
		query.append("					DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0), 0) MTY_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					SUM(TP.CNTR_TPSZ_TARE_WGT*BQ.OP_CNTR_QTY) WGT_MT," ).append("\n"); 
		query.append("					MAX(DECODE(NVL(DOC.WGT_UT_CD, 0), 'LBS', ROUND (NVL(DOC.ACT_WGT, 0)*0.4536, 3), NVL(DOC.ACT_WGT, 0))) WGT" ).append("\n"); 
		query.append("				FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("			, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("			, BKG_VVD BV" ).append("\n"); 
		query.append("			, BKG_QUANTITY BQ" ).append("\n"); 
		query.append("			, VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("			, MDM_CNTR_TP_SZ TP" ).append("\n"); 
		query.append("			, MDM_LOCATION LO" ).append("\n"); 
		query.append("				WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("				AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("				AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("				AND BQ.CNTR_TPSZ_CD = TP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("				AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("				AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("				AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n"); 
		query.append("				AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("				AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("				AND BV.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("				AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("				AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("				AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n"); 
		query.append("				AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("				AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n"); 
		query.append("				GROUP BY BK.BKG_NO, BK.BLCK_STWG_CD, BKG_CGO_TP_CD, BV.POL_CD, BK.POL_CD, BQ.CNTR_TPSZ_CD, BQ.OP_CNTR_QTY )" ).append("\n"); 
		query.append("		GROUP BY POD_CD, BLCK_STWG_CD, 1, CLPT_SEQ" ).append("\n"); 
		query.append("		ORDER BY CLPT_SEQ" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("/***************************** 기본 조회 *****************************/" ).append("\n"); 
		query.append("SELECT POD_CD GUBUN_CD," ).append("\n"); 
		query.append("  BLCK_STWG_CD AS GUBUN_CD2,   --'' GUBUN_CD2," ).append("\n"); 
		query.append("  '' GUBUN_CD3," ).append("\n"); 
		query.append("  1 ORDER_GUBUN," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9), 0, '', SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9)) LOCAL_40H," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_40), 0, '', SUM(LOCAL_40)) LOCAL_40," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_20), 0, '', SUM(LOCAL_20)) LOCAL_20," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_45), 0, '', SUM(LOCAL_45)) LOCAL_45," ).append("\n"); 
		query.append("  DECODE(SUM(TS_40H_5 + TS_40H_8 + TS_40H_9) , 0, '', SUM(TS_40H_5 + TS_40H_8 + TS_40H_9)) TS_40H," ).append("\n"); 
		query.append("  DECODE(SUM(TS_40), 0, '', SUM(TS_40)) TS_40," ).append("\n"); 
		query.append("  DECODE(SUM(TS_20), 0, '', SUM(TS_20)) TS_20," ).append("\n"); 
		query.append("  DECODE(SUM(TS_45), 0, '', SUM(TS_45)) TS_45," ).append("\n"); 
		query.append("  DECODE(SUM(MTY_40H_5 + MTY_40H_8 + MTY_40H_9), 0, '', SUM(MTY_40H_5 + MTY_40H_8 + MTY_40H_9)) MTY_40H," ).append("\n"); 
		query.append("  DECODE(SUM(MTY_40), 0, '', SUM(MTY_40)) MTY_40," ).append("\n"); 
		query.append("  DECODE(SUM(MTY_20), 0, '', SUM(MTY_20)) MTY_20," ).append("\n"); 
		query.append("  DECODE(SUM(MTY_45), 0, '', SUM(MTY_45)) MTY_45," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9 + TS_40H_5 + TS_40H_9 + MTY_40H_5 + MTY_40H_9), 0, '', SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9 + TS_40H_5 + TS_40H_9 + MTY_40H_5 + MTY_40H_9)) SUM_40H," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_40 + TS_40 + MTY_40), 0, '', SUM(LOCAL_40 + TS_40 + MTY_40)) SUM_40," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_20 + TS_20 + MTY_20), 0, '', SUM(LOCAL_20 + TS_20 + MTY_20)) SUM_20," ).append("\n"); 
		query.append("  DECODE(SUM(LOCAL_45 + TS_45 + MTY_45), 0, '', SUM(LOCAL_45 + TS_45 + MTY_45)) SUM_45," ).append("\n"); 
		query.append("  NVL(ROUND(SUM(WGT), 0), 1) WGT_MT," ).append("\n"); 
		query.append("  CLPT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT NVL(LO.UN_LOC_CD, CLL.POD_CD) POD_CD," ).append("\n"); 
		query.append("       BKG.BLCK_STWG_CD AS BLCK_STWG_CD," ).append("\n"); 
		query.append("      BQ.CLPT_SEQ CLPT_SEQ," ).append("\n"); 
		query.append("      1," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40H_5," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40H_8," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40H_9," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8', 0, '9', 0, COUNT(CLL.BKG_NO)), 0), 0) LOCAL_40," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_20," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0) TS_40H_5," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0), 'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0), 0) TS_40H_8," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0), 'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0), 0) TS_40H_9," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '9', 0, COUNT(CLL.BKG_NO)), 'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO)), 0) TS_40," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0) TS_20," ).append("\n"); 
		query.append("      DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0) TS_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0) MTY_40H_5," ).append("\n"); 
		query.append("      DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0), 0) MTY_40H_8," ).append("\n"); 
		query.append("      DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0), 0) MTY_40H_9," ).append("\n"); 
		query.append("      DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8', 0, '9', 0, COUNT(CLL.BKG_NO)), 0) MTY_40," ).append("\n"); 
		query.append("      DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0) MTY_20," ).append("\n"); 
		query.append("      DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0) MTY_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      SUM(TP.CNTR_TPSZ_TARE_WGT*BQ.OP_CNTR_QTY) WGT_MT," ).append("\n"); 
		query.append("      SUM(DECODE(NVL(CLL.WGT_UT_CD, 0), 'LBS', ROUND (NVL(CLL.BL_WGT, 0)*0.4536, 3), NVL(CLL.BL_WGT, 0))) WGT" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("         BKG_BOOKING BKG," ).append("\n"); 
		query.append("       (SELECT QTY.BKG_NO," ).append("\n"); 
		query.append("          MAX(QTY.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("          MAX(QTY.OP_CNTR_QTY) OP_CNTR_QTY," ).append("\n"); 
		query.append("          VPS.CLPT_SEQ CLPT_SEQ" ).append("\n"); 
		query.append("        FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("          BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("          MDM_LOCATION LO" ).append("\n"); 
		query.append("        WHERE QTY.CNTR_TPSZ_CD NOT IN ('Q2', 'Q4')" ).append("\n"); 
		query.append("          AND QTY.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("          AND CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no], 2, 3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd], 3, 3)" ).append("\n"); 
		query.append("          AND VPS.VSL_CD = @[in_vsl_cd]" ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("          AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("          AND (DECODE(CLL.POD_CD, 'USSE1', 'USSEA', 'USSE8', 'USSEA', 'CAVA1', 'CAVAN', 'CAYVR', 'CAVAN', 'CAPR1', 'CAPRR', CLL.POD_CD) = LO.UN_LOC_CD" ).append("\n"); 
		query.append("              OR DECODE(CLL.POD_CD, 'USSE1', 'USSEA', 'USSE8', 'USSEA', 'CAVA1', 'CAVAN', 'CAYVR', 'CAVAN', 'CAPR1', 'CAPRR', CLL.POD_CD) = LO.LOC_CD)" ).append("\n"); 
		query.append("          AND LO.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("          AND LO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("          AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("        GROUP BY QTY.BKG_NO, VPS.CLPT_SEQ ) BQ," ).append("\n"); 
		query.append("      (SELECT CNTR_TPSZ_CD, CNTR_TPSZ_TARE_WGT  FROM MDM_CNTR_TP_SZ) TP ," ).append("\n"); 
		query.append("		VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("      MDM_LOCATION LO" ).append("\n"); 
		query.append("    WHERE CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no], 2, 3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd], 3, 3)" ).append("\n"); 
		query.append("      AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("      AND NVL(CLL.POL_YD_CD, ' ') like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("      AND BQ.CNTR_TPSZ_CD = TP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		AND VPS.VSL_CD = @[in_vsl_cd]" ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("          AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("      AND (DECODE(CLL.POD_CD, 'USSE1', 'USSEA', 'USSE8', 'USSEA', 'CAVA1', 'CAVAN', 'CAYVR', 'CAVAN', 'CAPR1', 'CAPRR', CLL.POD_CD) = LO.UN_LOC_CD" ).append("\n"); 
		query.append("          OR DECODE(CLL.POD_CD, 'USSE1', 'USSEA', 'USSE8', 'USSEA', 'CAVA1', 'CAVAN', 'CAYVR', 'CAVAN', 'CAPR1', 'CAPRR', CLL.POD_CD) = LO.LOC_CD)" ).append("\n"); 
		query.append("      AND LO.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("      AND LO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("    GROUP BY NVL(LO.UN_LOC_CD, CLL.POD_CD), BKG.BLCK_STWG_CD, BQ.CLPT_SEQ, CLL.KR_CLL_TS_CD, CLL.MTY_BKG_CD, CLL.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("GROUP BY POD_CD, 1, BLCK_STWG_CD, CLPT_SEQ" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}