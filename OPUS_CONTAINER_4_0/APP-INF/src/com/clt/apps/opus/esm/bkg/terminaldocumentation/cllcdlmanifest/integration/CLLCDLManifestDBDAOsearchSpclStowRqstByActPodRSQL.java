/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclStowRqstByActPodRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.08
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchSpclStowRqstByActPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchSpclStowRqstByActPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclStowRqstByActPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclStowRqstByActPodRSQL").append("\n");
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
		query.append("SELECT GUBUN_CD3, '' GUBUN_CD2, '' GUBUN_CD, '' BLCK_STWG_CD" ).append("\n");
		query.append(",SUM(OD_20) OD_20, SUM(OD_40) OD_40, SUM(OD_40H) OD_40H" ).append("\n");
		query.append(",SUM(ODET_20) ODET_20, SUM(ODET_40) ODET_40, SUM(ODET_40H) ODET_40H" ).append("\n");
		query.append(",SUM(ODHD_20) ODHD_20, SUM(ODHD_40) ODHD_40, SUM(ODHD_40H) ODHD_40H" ).append("\n");
		query.append(",SUM(ODTB_20) ODTB_20, SUM(ODTB_40) ODTB_40, SUM(ODTB_40H) ODTB_40H" ).append("\n");
		query.append(",SUM(ODTS_20) ODTS_20, SUM(ODTS_40) ODTS_40, SUM(ODTS_40H) ODTS_40H" ).append("\n");
		query.append(",SUM(UD_20) UD_20, SUM(UD_40) UD_40, SUM(UD_40H) UD_40H" ).append("\n");
		query.append(",SUM(UDAB_20) UDAB_20, SUM(UDAB_40) UDAB_40, SUM(UDAB_40H) UDAB_40H" ).append("\n");
		query.append(",SUM(UDAV_20) UDAV_20, SUM(UDAV_40) UDAV_40, SUM(UDAV_40H) UDAV_40H" ).append("\n");
		query.append(",SUM(UDBW_20) UDBW_20, SUM(UDBW_40) UDBW_40, SUM(UDBW_40H) UDBW_40H" ).append("\n");
		query.append(",SUM(UDHG_20) UDHG_20, SUM(UDHG_40) UDHG_40, SUM(UDHG_40H) UDHG_40H" ).append("\n");
		query.append(",SUM(UDTS_20) UDTS_20, SUM(UDTS_40) UDTS_40, SUM(UDTS_40H) UDTS_40H" ).append("\n");
		query.append(",SUM(PCOD_20) PCOD_20, SUM(PCOD_40) PCOD_40, SUM(PCOD_40H) PCOD_40H" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(SELECT NVL(LO.UN_LOC_CD,BK.POD_CD) GUBUN_CD3" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) OD_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) OD_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) OD_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) ODET_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) ODET_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) ODET_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) ODHD_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) ODHD_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) ODHD_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) ODTB_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) ODTB_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) ODTB_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) ODTS_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) ODTS_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) ODTS_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) UD_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) UD_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) UD_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) UDAB_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) UDAB_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) UDAB_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) UDAV_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) UDAV_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) UDAV_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) UDBW_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) UDBW_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) UDBW_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) UDHG_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) UDHG_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) UDHG_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) UDTS_20" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) UDTS_40" ).append("\n");
		query.append(", DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) UDTS_40H" ).append("\n");
		query.append("  " ).append("\n");
		query.append(", DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0) PCOD_20" ).append("\n");
		query.append(", DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0) PCOD_40" ).append("\n");
		query.append(", DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0) PCOD_40H" ).append("\n");
		query.append(", VPS.CLPT_SEQ CLPT_SEQ" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append("	, BKG_VVD BV" ).append("\n");
		query.append("	, BKG_QUANTITY BQ" ).append("\n");
		query.append("	, VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append("	, MDM_COMMODITY CM" ).append("\n");
		query.append("	, MDM_LOCATION LO" ).append("\n");
		query.append("	, BKG_CSTMS_TML_KR_CLL CLL" ).append("\n");
		query.append("	, BKG_CONTAINER BC" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("  AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("  AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("  AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("  AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("  AND BK.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("  AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n");
		query.append("  AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("  AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n");
		query.append("  AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("  AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("  AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("  AND BV.POL_CD = @[in_pol_cd]" ).append("\n");
		query.append("  AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("  AND VPS.CLPT_IND_SEQ = '1'" ).append("\n");
		query.append("  AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("  AND CLL.CNTR_LIST_NO = BV.VSL_CD||SUBSTR(BV.SKD_VOY_NO,2,3)||BV.SKD_DIR_CD||SUBSTR(BV.POL_CD,3,3)" ).append("\n");
		query.append("  AND CLL.BKG_NO = BK.BKG_NO" ).append("\n");
		query.append("  AND BK.BKG_NO = BC.BKG_NO" ).append("\n");
		query.append("  AND BC.DCGO_FLG = 'N'" ).append("\n");
		query.append("  AND BC.RC_FLG = 'N'" ).append("\n");
		query.append("  AND BC.AWK_CGO_FLG = 'N'" ).append("\n");
		query.append("  --AND CLL.POL_YD_CD = BV.POL_YD_CD" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BK.POD_CD), BK.STWG_CD, BQ.CNTR_TPSZ_CD, BQ.OP_CNTR_QTY, CM.REP_IMDG_LVL_CD, BK.BKG_NO, VPS.CLPT_SEQ)" ).append("\n");
		query.append("GROUP BY GUBUN_CD3, CLPT_SEQ" ).append("\n");
		query.append("ORDER BY CLPT_SEQ" ).append("\n");

	}
}