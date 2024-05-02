/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchLoadSumByPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05 
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

public class CLLCDLManifestDBDAOsearchLoadSumByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLoadSumByPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchLoadSumByPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("in_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchLoadSumByPodRSQL").append("\n"); 
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
		query.append("SELECT POD_CD" ).append("\n"); 
		query.append(", BLCK_STWG_CD AS GUBUN_CD2" ).append("\n"); 
		query.append(", DECODE(SUM(LO_40H),0,'',SUM(LO_40H)) LO_40H" ).append("\n"); 
		query.append(", DECODE(SUM(LO_40),0,'',SUM(LO_40)) LO_40" ).append("\n"); 
		query.append(", DECODE(SUM(LO_20),0,'',SUM(LO_20)) LO_20" ).append("\n"); 
		query.append(", DECODE(SUM(LO_45),0,'',SUM(LO_45)) LO_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(SUM(TS_40H),0,'',SUM(TS_40H)) TS_40H" ).append("\n"); 
		query.append(", DECODE(SUM(TS_40),0,'',SUM(TS_40)) TS_40" ).append("\n"); 
		query.append(", DECODE(SUM(TS_20),0,'',SUM(TS_20)) TS_20" ).append("\n"); 
		query.append(", DECODE(SUM(TS_45),0,'',SUM(TS_45)) TS_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(SUM(MT_40H),0,'',SUM(MT_40H)) MT_40H" ).append("\n"); 
		query.append(", DECODE(SUM(MT_40),0,'',SUM(MT_40)) MT_40" ).append("\n"); 
		query.append(", DECODE(SUM(MT_20),0,'',SUM(MT_20)) MT_20" ).append("\n"); 
		query.append(", DECODE(SUM(MT_45),0,'',SUM(MT_45)) MT_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(SUM(NVL(LO_40H,0)+NVL(TS_40H,0)+NVL(MT_40H,0)),0,'',SUM(NVL(LO_40H,0)+NVL(TS_40H,0)+NVL(MT_40H,0))) TO_40H" ).append("\n"); 
		query.append(", DECODE(SUM(NVL(LO_40,0)+NVL(TS_40,0)+NVL(MT_40,0)),0,'',SUM(NVL(LO_40,0)+NVL(TS_40,0)+NVL(MT_40,0))) TO_40" ).append("\n"); 
		query.append(", DECODE(SUM(NVL(LO_20,0)+NVL(TS_20,0)+NVL(MT_20,0)),0,'',SUM(NVL(LO_20,0)+NVL(TS_20,0)+NVL(MT_20,0))) TO_20" ).append("\n"); 
		query.append(", DECODE(SUM(NVL(LO_45,0)+NVL(TS_45,0)+NVL(MT_45,0)),0,'',SUM(NVL(LO_45,0)+NVL(TS_45,0)+NVL(MT_45,0))) TO_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(SUM(WGT + WGT_MT)/1000,0,'',SUM(WGT + WGT_MT)/1000) WGT_MT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT MAX(DECODE(BK.POD_CD,'XXXXX','XXXXX',NVL(LO.UN_LOC_CD,BV.POD_CD))) POD_CD" ).append("\n"); 
		query.append("	, BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append("    , BK.BLCK_STWG_CD AS BLCK_STWG_CD" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) LO_20" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '9', 0, '8', 0, BQ.OP_CNTR_QTY),0))) LO_40" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY, '8',BQ.OP_CNTR_QTY, '9',BQ.OP_CNTR_QTY,0),0))) LO_40H" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0))) LO_45" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0)))) TS_20" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8', 0, '9', 0, BQ.OP_CNTR_QTY)))) TS_40" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,'8',BQ.OP_CNTR_QTY,'9',BQ.OP_CNTR_QTY,0)))) TS_40H" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', 0, 'R', 0, DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0)))) TS_45" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0), 0)) MT_20" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8', 0, '9', 0, BQ.OP_CNTR_QTY), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '5', 0, '7', 0, '8', 0, '9', 0, BQ.OP_CNTR_QTY), 0)) MT_40" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,'8',BQ.OP_CNTR_QTY,'9',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',BQ.OP_CNTR_QTY,'8',BQ.OP_CNTR_QTY,'9',BQ.OP_CNTR_QTY,0), 0)) MT_40H" ).append("\n"); 
		query.append("	, SUM(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0), 0, 'R', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0), 0)) MT_45" ).append("\n"); 
		query.append("	, SUM(TP.CNTR_TPSZ_TARE_WGT*BQ.OP_CNTR_QTY) WGT_MT" ).append("\n"); 
		query.append("	, MAX(DECODE(NVL(DOC.WGT_UT_CD, 0), 'LBS', ROUND (NVL(DOC.ACT_WGT, 0)*0.4536, 3), NVL(DOC.ACT_WGT, 0))) WGT" ).append("\n"); 
		query.append("	, MAX(DECODE(BK.POD_CD,'XXXXX',100,VPS.CLPT_SEQ)) CLPT_SEQ" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("	, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("	, BKG_VVD BV" ).append("\n"); 
		query.append("	, BKG_QUANTITY BQ" ).append("\n"); 
		query.append("	, VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("	, MDM_CNTR_TP_SZ TP" ).append("\n"); 
		query.append("	, MDM_LOCATION LO" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("AND BQ.CNTR_TPSZ_CD = TP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND BV.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("#if (${in_pol_yd_cd} != '')" ).append("\n"); 
		query.append("AND BV.POL_YD_CD = @[in_pol_cd]||@[in_pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("AND BK.BKG_OFC_CD LIKE @[in_bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n"); 
		query.append("AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n"); 
		query.append("GROUP BY BK.BKG_NO, BK.BLCK_STWG_CD)" ).append("\n"); 
		query.append("GROUP BY POD_CD,BLCK_STWG_CD, CLPT_SEQ" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}