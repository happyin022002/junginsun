/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclCgoSumByPodRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier :
*@LastVersion : 1.0
* 2013.07.16
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author janginho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchSpclCgoSumByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchSpclCgoSumByPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclCgoSumByPodRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclCgoSumByPodRSQL").append("\n");
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
		query.append("SELECT DG.POD_CD2" ).append("\n");
		query.append(", DECODE(SUM(D_LO_40),0,'',SUM(D_LO_40)) D_LO_40" ).append("\n");
		query.append(", DECODE(SUM(D_LO_20),0,'',SUM(D_LO_20)) D_LO_20" ).append("\n");
		query.append(", DECODE(SUM(D_LO_40H),0,'',SUM(D_LO_40H)) D_LO_40H" ).append("\n");
		query.append(", DECODE(SUM(R_LO_40),0,'',SUM(R_LO_40)) R_LO_40" ).append("\n");
		query.append(", DECODE(SUM(R_LO_20),0,'',SUM(R_LO_20)) R_LO_20" ).append("\n");
		query.append(", DECODE(SUM(R_LO_40H),0,'',SUM(R_LO_40H)) R_LO_40H" ).append("\n");
		query.append(", DECODE(SUM(F_LO_40),0,'',SUM(F_LO_40)) F_LO_40" ).append("\n");
		query.append(", DECODE(SUM(F_LO_20),0,'',SUM(F_LO_20)) F_LO_20" ).append("\n");
		query.append(", DECODE(SUM(F_LO_40H),0,'',SUM(F_LO_40H)) F_LO_40H" ).append("\n");
		query.append(", DECODE(SUM(O_LO_40),0,'',SUM(O_LO_40)) O_LO_40" ).append("\n");
		query.append(", DECODE(SUM(O_LO_20),0,'',SUM(O_LO_20)) O_LO_20" ).append("\n");
		query.append(", DECODE(SUM(O_LO_40H),0,'',SUM(O_LO_40H)) O_LO_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(D_TS_40),0,'',SUM(D_TS_40)) D_TS_40" ).append("\n");
		query.append(", DECODE(SUM(D_TS_20),0,'',SUM(D_TS_20)) D_TS_20" ).append("\n");
		query.append(", DECODE(SUM(D_TS_40H),0,'',SUM(D_TS_40H)) D_TS_40H" ).append("\n");
		query.append(", DECODE(SUM(R_TS_40),0,'',SUM(R_TS_40)) R_TS_40" ).append("\n");
		query.append(", DECODE(SUM(R_TS_20),0,'',SUM(R_TS_20)) R_TS_20" ).append("\n");
		query.append(", DECODE(SUM(R_TS_40H),0,'',SUM(R_TS_40H)) R_TS_40H" ).append("\n");
		query.append(", DECODE(SUM(F_TS_40),0,'',SUM(F_TS_40)) F_TS_40" ).append("\n");
		query.append(", DECODE(SUM(F_TS_20),0,'',SUM(F_TS_20)) F_TS_20" ).append("\n");
		query.append(", DECODE(SUM(F_TS_40H),0,'',SUM(F_TS_40H)) F_TS_40H" ).append("\n");
		query.append(", DECODE(SUM(O_TS_40),0,'',SUM(O_TS_40)) O_TS_40" ).append("\n");
		query.append(", DECODE(SUM(O_TS_20),0,'',SUM(O_TS_20)) O_TS_20" ).append("\n");
		query.append(", DECODE(SUM(O_TS_40H),0,'',SUM(O_TS_40H)) O_TS_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", DECODE(SUM(NVL(D_LO_40,0)+NVL(D_TS_40,0)),0,'',SUM(NVL(D_LO_40,0)+NVL(D_TS_40,0))) D_LO_TS_40" ).append("\n");
		query.append(", DECODE(SUM(NVL(D_LO_20,0)+NVL(D_TS_20,0)),0,'',SUM(NVL(D_LO_20,0)+NVL(D_TS_20,0))) D_LO_TS_20" ).append("\n");
		query.append(", DECODE(SUM(NVL(D_LO_40H,0)+NVL(D_TS_40H,0)),0,'',SUM(NVL(D_LO_40H,0)+NVL(D_TS_40H,0))) D_LO_TS_40H" ).append("\n");
		query.append(", DECODE(SUM(NVL(R_LO_40,0)+NVL(R_TS_40,0)),0,'',SUM(NVL(R_LO_40,0)+NVL(R_TS_40,0))) R_LO_TS_40" ).append("\n");
		query.append(", DECODE(SUM(NVL(R_LO_20,0)+NVL(R_TS_20,0)),0,'',SUM(NVL(R_LO_20,0)+NVL(R_TS_20,0))) R_LO_TS_20" ).append("\n");
		query.append(", DECODE(SUM(NVL(R_LO_40H,0)+NVL(R_TS_40H,0)),0,'',SUM(NVL(R_LO_40H,0)+NVL(R_TS_40H,0))) R_LO_TS_40H" ).append("\n");
		query.append(", DECODE(SUM(NVL(F_LO_40,0)+NVL(F_TS_40,0)),0,'',SUM(NVL(F_LO_40,0)+NVL(F_TS_40,0))) F_LO_TS_40" ).append("\n");
		query.append(", DECODE(SUM(NVL(F_LO_20,0)+NVL(F_TS_20,0)),0,'',SUM(NVL(F_LO_20,0)+NVL(F_TS_20,0))) F_LO_TS_20" ).append("\n");
		query.append(", DECODE(SUM(NVL(F_LO_40H,0)+NVL(F_TS_40H,0)),0,'',SUM(NVL(F_LO_40H,0)+NVL(F_TS_40H,0))) F_LO_TS_40H" ).append("\n");
		query.append(", DECODE(SUM(NVL(O_LO_40,0)+NVL(O_TS_40,0)),0,'',SUM(NVL(O_LO_40,0)+NVL(O_TS_40,0))) O_LO_TS_40" ).append("\n");
		query.append(", DECODE(SUM(NVL(O_LO_20,0)+NVL(O_TS_20,0)),0,'',SUM(NVL(O_LO_20,0)+NVL(O_TS_20,0))) O_LO_TS_20" ).append("\n");
		query.append(", DECODE(SUM(NVL(O_LO_40H,0)+NVL(O_TS_40H,0)),0,'',SUM(NVL(O_LO_40H,0)+NVL(O_TS_40H,0))) O_LO_TS_40H" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) POD_CD2" ).append("\n");
		query.append(", BK.BKG_NO BKG_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))       D_LO_20" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',0,'5',0,DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0)),0)) D_LO_40" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))       D_LO_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))       D_TS_20" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',0,'5',0,DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0)))) D_TS_40" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))       D_TS_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", MAX(VPS.CLPT_SEQ) CLPT_SEQ" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_VVD BV" ).append("\n");
		query.append(", VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append(", BKG_DG_CGO DG" ).append("\n");
		query.append(", MDM_LOCATION LO" ).append("\n");
		query.append(", BKG_QTY_DTL BQ" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("AND BK.BKG_NO = DG.BKG_NO(+)" ).append("\n");
		query.append("AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("AND BV.POL_CD=@[in_pol_cd]" ).append("\n");
		query.append("#if (${in_pol_yd_cd} != '')" ).append("\n");
		query.append("AND BV.POL_YD_CD = @[in_pol_cd]||@[in_pol_yd_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("AND BK.BKG_OFC_CD LIKE @[in_bkg_ofc_cd]||'%'" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ='1'" ).append("\n");
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD)" ).append("\n");
		query.append(", BK.BKG_NO) DG," ).append("\n");
		query.append("" ).append("\n");
		query.append("(SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) POD_CD2" ).append("\n");
		query.append(", BK.BKG_NO BKG_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R2',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        R_LO_20" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R4',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        R_LO_40" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R5',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),'R8',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),'R9',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        R_LO_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R2',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        R_TS_20" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R4',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        R_TS_40" ).append("\n");
		query.append(", MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R5',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),'R8',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),'R9',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        R_TS_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_VVD BV" ).append("\n");
		query.append(", VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append(", BKG_RF_CGO RF" ).append("\n");
		query.append(", MDM_LOCATION LO" ).append("\n");
		query.append(", BKG_QTY_DTL BQ" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("AND BK.BKG_NO = RF.BKG_NO(+)" ).append("\n");
		query.append("AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("AND BV.POL_CD=@[in_pol_cd]" ).append("\n");
		query.append("#if (${in_pol_yd_cd} != '')" ).append("\n");
		query.append("AND BV.POL_YD_CD = @[in_pol_cd]||@[in_pol_yd_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("AND BK.BKG_OFC_CD LIKE @[in_bkg_ofc_cd]||'%'" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ='1'" ).append("\n");
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD)" ).append("\n");
		query.append(", BK.BKG_NO" ).append("\n");
		query.append(") RF," ).append("\n");
		query.append("(SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) POD_CD2" ).append("\n");
		query.append(", BK.BKG_NO BKG_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'F2',BQ.OP_CNTR_QTY,'P2',BQ.OP_CNTR_QTY,'A2',BQ.OP_CNTR_QTY,0),0)) F_LO_20" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'F4',BQ.OP_CNTR_QTY,'P4',BQ.OP_CNTR_QTY,'A4',BQ.OP_CNTR_QTY,0),0)) F_LO_40" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'F5',BQ.OP_CNTR_QTY,0),0)) F_LO_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'O2',BQ.OP_CNTR_QTY,'S2',BQ.OP_CNTR_QTY,0),0)) O_LO_20" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'O4',BQ.OP_CNTR_QTY,'S4',BQ.OP_CNTR_QTY,0),0)) O_LO_40" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'O5',BQ.OP_CNTR_QTY,0),0)) O_LO_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'F2',BQ.OP_CNTR_QTY,'P2',BQ.OP_CNTR_QTY,'A2',BQ.OP_CNTR_QTY,0))) F_TS_20" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'F4',BQ.OP_CNTR_QTY,'P4',BQ.OP_CNTR_QTY,'A4',BQ.OP_CNTR_QTY,0))) F_TS_40" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'F5',BQ.OP_CNTR_QTY,0))) F_TS_40H" ).append("\n");
		query.append("" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'O2',BQ.OP_CNTR_QTY,'S2',BQ.OP_CNTR_QTY,0))) O_TS_20" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'O4',BQ.OP_CNTR_QTY,'S4',BQ.OP_CNTR_QTY,0))) O_TS_40" ).append("\n");
		query.append(", SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'O5',BQ.OP_CNTR_QTY,0))) O_TS_40H" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_VVD BV" ).append("\n");
		query.append(", VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append(", BKG_QUANTITY BQ" ).append("\n");
		query.append(", MDM_LOCATION LO" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("AND BV.POL_CD=@[in_pol_cd]" ).append("\n");
		query.append("#if (${in_pol_yd_cd} != '')" ).append("\n");
		query.append("AND BV.POL_YD_CD = @[in_pol_cd]||@[in_pol_yd_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("AND BK.BKG_OFC_CD LIKE @[in_bkg_ofc_cd]||'%'" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ='1'" ).append("\n");
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD)" ).append("\n");
		query.append(", BK.BKG_NO) BQ" ).append("\n");
		query.append("WHERE DG. BKG_NO = RF.BKG_NO" ).append("\n");
		query.append("AND DG. BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("GROUP BY DG.POD_CD2, CLPT_SEQ" ).append("\n");
		query.append("ORDER BY CLPT_SEQ" ).append("\n");

	}
}