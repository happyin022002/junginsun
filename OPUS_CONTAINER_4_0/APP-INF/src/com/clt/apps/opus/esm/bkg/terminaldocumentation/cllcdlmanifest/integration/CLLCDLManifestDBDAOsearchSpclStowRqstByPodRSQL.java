/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclStowRqstByPodRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.05
*@LastModifier :
*@LastVersion : 1.0
* 2010.08.05
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

public class CLLCDLManifestDBDAOsearchSpclStowRqstByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchSpclStowRqstByPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclStowRqstByPodRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclStowRqstByPodRSQL").append("\n");
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
		query.append("SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) POD_CD3" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) OD_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) OD_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) OD_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) ODET_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) ODET_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) ODET_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) ODHD_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) ODHD_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) ODHD_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) ODTB_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) ODTB_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODTB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) ODTB_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) ODTS_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) ODTS_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'ODTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) ODTS_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) UD_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) UD_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) UD_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) UDAB_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) UDAB_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) UDAB_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) UDAV_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) UDAV_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDAV',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) UDAV_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) UDBW_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) UDBW_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDBW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) UDBW_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) UDHG_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) UDHG_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDHG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) UDHG_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) UDTS_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) UDTS_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(BK.STWG_CD,'UDTS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) UDTS_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))) PCOD_20" ).append("\n");
		query.append(", DECODE(SUM(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0,'',SUM(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0))) PCOD_40" ).append("\n");
		query.append(", DECODE(SUM(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0,'',SUM(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0))) PCOD_40H" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append("	, BKG_VVD BV" ).append("\n");
		query.append("	, BKG_QUANTITY BQ" ).append("\n");
		query.append("	, VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append("	, MDM_COMMODITY CM" ).append("\n");
		query.append("	, MDM_LOCATION LO" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("  AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("  AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n");
		query.append("  AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("  AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("  AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("  AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("  AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n");
		query.append("  AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("  AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n");
		query.append("  AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("  AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("  AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("  AND BV.POL_CD = @[in_pol_cd]" ).append("\n");
		query.append("#if (${in_pol_yd_cd} != '')" ).append("\n");
		query.append("      AND BV.POL_YD_CD = @[in_pol_cd]||@[in_pol_yd_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("  AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("  AND BK.BKG_OFC_CD LIKE @[in_bkg_ofc_cd]||'%'" ).append("\n");
		query.append("  AND VPS.CLPT_IND_SEQ = '1'" ).append("\n");
		query.append("  AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD)" ).append("\n");
		query.append("	, VPS.CLPT_SEQ" ).append("\n");
		query.append("ORDER BY VPS.CLPT_SEQ" ).append("\n");

	}
}