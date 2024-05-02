/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchLoadSumByMlbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.05 
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

public class CLLCDLManifestDBDAOsearchLoadSumByMlbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLoadSumByMlb
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchLoadSumByMlbRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchLoadSumByMlbRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	BLCK_STWG_CD GUBUN_CD2," ).append("\n"); 
		query.append("	POD_CD GUBUN_CD," ).append("\n"); 
		query.append("	'' GUBUN_CD3," ).append("\n"); 
		query.append("	DECODE(POD_CD, 'USLGB', '1', 2) ORDER_GUBUN," ).append("\n"); 
		query.append("	DECODE(BLCK_STWG_CD, 'LOC', '0', 'ONE', '1', 'TWO', '2', 'THR', '3', 'FOR', '4', 'FIV', '4.5', 'SEV', '4.7', 'HOT','5','TRS', '6', BLCK_STWG_CD) ORDER_GUBUN2," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9),0,'',SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9))   LOCAL_40H," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_40),0,'',SUM(LOCAL_40))    LOCAL_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_20),0,'',SUM(LOCAL_20))    LOCAL_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_45),0,'',SUM(LOCAL_45))    LOCAL_45," ).append("\n"); 
		query.append("	DECODE(SUM(TS_40H_5 + TS_40H_8 + TS_40H_9),0,'',SUM(TS_40H_5 + TS_40H_8 + TS_40H_9))      TS_40H," ).append("\n"); 
		query.append("	DECODE(SUM(TS_40),0,'',SUM(TS_40))       TS_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_20),0,'',SUM(TS_20))       TS_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_45),0,'',SUM(TS_45))       TS_45," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_40H_5 + MTY_40H_8 + MTY_40H_9),0,'',SUM(MTY_40H_5 + MTY_40H_8 + MTY_40H_9))     MTY_40H," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_40),0,'',SUM(MTY_40))      MTY_40," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_20),0,'',SUM(MTY_20))      MTY_20," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_45),0,'',SUM(MTY_45))      MTY_45," ).append("\n"); 
		query.append("	DECODE(SUM(NVL(LOCAL_40H_5,0) + NVL(LOCAL_40H_8,0) + NVL(LOCAL_40H_9,0) + NVL(TS_40H_5,0) + NVL(TS_40H_8,0) + NVL(TS_40H_9,0) + NVL(MTY_40H_5,0) + NVL(MTY_40H_8,0) + NVL(MTY_40H_9,0)),0,'',SUM(NVL(LOCAL_40H_5,0) + NVL(LOCAL_40H_8,0) + NVL(LOCAL_40H_9,0) + NVL(TS_40H_5,0) + NVL(TS_40H_8,0) + NVL(TS_40H_9,0) + NVL(MTY_40H_5,0) + NVL(MTY_40H_8,0) + NVL(MTY_40H_9,0))) SUM_40H," ).append("\n"); 
		query.append("	DECODE(SUM(NVL(LOCAL_40,0) + NVL(TS_40,0) + NVL(MTY_40,0)),0,'',SUM(NVL(LOCAL_40,0) + NVL(TS_40,0) + NVL(MTY_40,0)))    SUM_40," ).append("\n"); 
		query.append("	DECODE(SUM(NVL(LOCAL_20,0) + NVL(TS_20,0) + NVL(MTY_20,0)),0,'',SUM(NVL(LOCAL_20,0) + NVL(TS_20,0) + NVL(MTY_20,0)))    SUM_20," ).append("\n"); 
		query.append("	DECODE(SUM(NVL(LOCAL_45,0) + NVL(TS_45,0) + NVL(MTY_45,0)),0,'',SUM(NVL(LOCAL_45,0) + NVL(TS_45,0) + NVL(MTY_45,0)))    SUM_45," ).append("\n"); 
		query.append("	NVL(ROUND(SUM(WGT),0),1) WGT_MT   " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT MAX(DECODE(BK.POD_CD,'XXXXX','XXXXX',NVL(LO.UN_LOC_CD,BV.POD_CD))) POD_CD," ).append("\n"); 
		query.append("      DECODE(MAX( DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV', 'T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV', 'T','TRS', 'LOC')), " ).append("\n"); 
		query.append("							'USOAK', DECODE(BK.BLCK_STWG_CD, 'OA1', 'OA1' ,'', '', 'OAK'), " ).append("\n"); 
		query.append("							'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','7','SEV','T','TRS', 'LOC'), " ).append("\n"); 
		query.append("							'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')), NULL, MAX(DECODE(BK.POD_CD,'XXXXX','XXXXX',NVL(LO.UN_LOC_CD,BV.POD_CD))), " ).append("\n"); 
		query.append("			 MAX( DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')), " ).append("\n"); 
		query.append("							'USOAK', DECODE(BK.BLCK_STWG_CD, 'OA1', 'OA1' ,'', '', 'OAK'), " ).append("\n"); 
		query.append("							'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','7','SEV','T','TRS', 'LOC'), " ).append("\n"); 
		query.append("							'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),''))) BLCK_STWG_CD," ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0),0)) LOCAL_40H_5," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'8',BQ.OP_CNTR_QTY,0),0)) LOCAL_40H_8," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0),0)) LOCAL_40H_9," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8',0,'9', 0, BQ.OP_CNTR_QTY),0)) LOCAL_40," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) LOCAL_20," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) LOCAL_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0))) TS_40H_5," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'8',BQ.OP_CNTR_QTY,0))) TS_40H_8," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0))) TS_40H_9," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '9', 0, BQ.OP_CNTR_QTY))) TS_40," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0))) TS_20," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0))) TS_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,0), 0) MTY_40H_5," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'8',BQ.OP_CNTR_QTY,0), 0) MTY_40H_8," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'9',BQ.OP_CNTR_QTY,0), 0) MTY_40H_9," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8',0,'9', 0, BQ.OP_CNTR_QTY), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8',0,'9', 0, BQ.OP_CNTR_QTY), 0) MTY_40," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0), 0) MTY_20," ).append("\n"); 
		query.append("      DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0), 0) MTY_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      SUM(TP.CNTR_TPSZ_TARE_WGT*BQ.OP_CNTR_QTY) WGT_MT," ).append("\n"); 
		query.append("      MAX(DECODE(NVL(DOC.WGT_UT_CD, 0), 'LBS', ROUND (NVL(DOC.ACT_WGT, 0)*0.4536, 3), NVL(DOC.ACT_WGT, 0))) WGT" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("	, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("	, BKG_VVD BV" ).append("\n"); 
		query.append("	, BKG_QUANTITY BQ" ).append("\n"); 
		query.append("	, VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("	, MDM_CNTR_TP_SZ TP" ).append("\n"); 
		query.append("	, MDM_LOCATION LO" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("    AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("    AND BQ.CNTR_TPSZ_CD = TP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("    AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n"); 
		query.append("	AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("	AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("	AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("	AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("    AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n"); 
		query.append("    AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("    AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n"); 
		query.append("    GROUP BY BK.BKG_NO, BKG_CGO_TP_CD, BV.POL_CD, BK.POL_CD, BQ.CNTR_TPSZ_CD, BQ.OP_CNTR_QTY " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("GROUP BY BLCK_STWG_CD, POD_CD" ).append("\n"); 
		query.append("ORDER BY ORDER_GUBUN, ORDER_GUBUN2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("/***************************** 기본 조회 *****************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	BLCK_STWG_CD GUBUN_CD2," ).append("\n"); 
		query.append("	POD_CD GUBUN_CD," ).append("\n"); 
		query.append("	'' GUBUN_CD3," ).append("\n"); 
		query.append("	DECODE(POD_CD, 'USLGB', '1', 2) ORDER_GUBUN," ).append("\n"); 
		query.append("	DECODE(BLCK_STWG_CD, 'LOC', '0', 'ONE', '1', 'TWO', '2', 'THR', '3', 'FOR', '4', 'FIV', '4.5', 'SEV', '4.7', 'HOT','5','TRS', '6', BLCK_STWG_CD) ORDER_GUBUN2," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9),0,'',SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9))   LOCAL_40H," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_40),0,'',SUM(LOCAL_40))    LOCAL_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_20),0,'',SUM(LOCAL_20))    LOCAL_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_45),0,'',SUM(LOCAL_45))    LOCAL_45," ).append("\n"); 
		query.append("	DECODE(SUM(TS_40H_5 + TS_40H_8 + TS_40H_9),0,'',SUM(TS_40H_5 + TS_40H_8 + TS_40H_9))      TS_40H," ).append("\n"); 
		query.append("	DECODE(SUM(TS_40),0,'',SUM(TS_40))       TS_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_20),0,'',SUM(TS_20))       TS_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_45),0,'',SUM(TS_45))       TS_45," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_40H_5 + MTY_40H_8 + MTY_40H_9),0,'',SUM(MTY_40H_5 + MTY_40H_8 + MTY_40H_9))     MTY_40H," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_40),0,'',SUM(MTY_40))      MTY_40," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_20),0,'',SUM(MTY_20))      MTY_20," ).append("\n"); 
		query.append("	DECODE(SUM(MTY_45),0,'',SUM(MTY_45))      MTY_45," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9 + TS_40H_5 + TS_40H_8 + TS_40H_9 + MTY_40H_5 + MTY_40H_8 + MTY_40H_9),0,'',SUM(LOCAL_40H_5 + LOCAL_40H_8 + LOCAL_40H_9 + TS_40H_5 + TS_40H_8 + TS_40H_9 + MTY_40H_5 + MTY_40H_8 + MTY_40H_9)) SUM_40H," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_40 + TS_40 + MTY_40),0,'',SUM(LOCAL_40 + TS_40 + MTY_40))    SUM_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_20 + TS_20 + MTY_20),0,'',SUM(LOCAL_20 + TS_20 + MTY_20))    SUM_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_45 + TS_45 + MTY_45),0,'',SUM(LOCAL_45 + TS_45 + MTY_45))    SUM_45," ).append("\n"); 
		query.append("	NVL(ROUND(SUM(WGT),0),1) WGT_MT                          " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		DECODE(CLL.BLCK_STWG_CD, NULL, CLL.POD_CD, CLL.BLCK_STWG_CD)	BLCK_STWG_CD," ).append("\n"); 
		query.append("		CLL.POD_CD	POD_CD," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40H_5," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40H_8," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40H_9," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO)), 0), 0) LOCAL_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_20," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_45," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("		     'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0) TS_40H_5," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("		     'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0), 0) TS_40H_8," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("		     'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0), 0) TS_40H_9," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO))," ).append("\n"); 
		query.append("		     'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO)), 0) TS_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("		     'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0) TS_20," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("		     'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0) TS_45," ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("		DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0) MTY_40H_5," ).append("\n"); 
		query.append("		DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0), 0) MTY_40H_8," ).append("\n"); 
		query.append("		DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0), 0) MTY_40H_9," ).append("\n"); 
		query.append("		DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO)), 0) MTY_40," ).append("\n"); 
		query.append("		DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0) MTY_20," ).append("\n"); 
		query.append("		DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0) MTY_45," ).append("\n"); 
		query.append("		SUM(TP.CNTR_TPSZ_TARE_WGT*BQ.OP_CNTR_QTY) WGT_MT," ).append("\n"); 
		query.append("		SUM(DECODE(NVL(CLL.WGT_UT_CD, 0), 'LBS', ROUND (NVL(CLL.BL_WGT, 0)*0.4536, 3), NVL(CLL.BL_WGT, 0))) WGT" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("		(select QTY.bkg_no, MAX(QTY.CNTR_TPSZ_CD) CNTR_TPSZ_CD, MAX(QTY.OP_CNTR_QTY) OP_CNTR_QTY " ).append("\n"); 
		query.append("		from BKG_QUANTITY QTY,  BKG_CSTMS_TML_KR_CLL CLL, BKG_BOOKING BK" ).append("\n"); 
		query.append("		where QTY.CNTR_TPSZ_CD NOT IN ('Q2','Q4') " ).append("\n"); 
		query.append("		AND QTY.BKG_NO = CLL.BKG_NO	" ).append("\n"); 
		query.append("        AND QTY.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		AND QTY.CNTR_TPSZ_CD = DECODE(BK.FLEX_HGT_FLG , 'Y', QTY.CNTR_TPSZ_CD, CLL.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("		group by QTY.BKG_NO" ).append("\n"); 
		query.append("		) BQ," ).append("\n"); 
		query.append("		(select CNTR_TPSZ_CD, CNTR_TPSZ_TARE_WGT from MDM_CNTR_TP_SZ) TP" ).append("\n"); 
		query.append("	WHERE CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("	AND POD_CD IS NOT NULL" ).append("\n"); 
		query.append("	AND NVL(POL_YD_CD,' ') like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("	AND CLL.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("	AND BQ.CNTR_TPSZ_CD = TP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	GROUP BY CLL.BLCK_STWG_CD, CLL.POD_CD, CLL.KR_CLL_TS_CD, CLL.MTY_BKG_CD, CLL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("GROUP BY BLCK_STWG_CD, POD_CD" ).append("\n"); 
		query.append("ORDER BY ORDER_GUBUN, ORDER_GUBUN2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}