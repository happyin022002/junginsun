/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclCgoSumByMlbRSQL.java
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

public class CLLCDLManifestDBDAOsearchSpclCgoSumByMlbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpclCgoSumByMlb
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclCgoSumByMlbRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclCgoSumByMlbRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	BLCK_STWG_CD GUBUN_CD,     " ).append("\n"); 
		query.append("	DG.POD_CD GUBUN_CD2,                                                   " ).append("\n"); 
		query.append("	DECODE(DG.POD_CD, 'USLGB', '1', 2) ORDER_GUBUN," ).append("\n"); 
		query.append("	DECODE(BLCK_STWG_CD, 'LOC', '0', 'ONE', '1', 'TWO', '2', 'THR', '3', 'FOR', '4', 'FIV', '4.5', 'SEV', '4.7', 'HOT','5','TRS', '6', BLCK_STWG_CD) ORDER_GUBUN2," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40 + LOCAL_DG_45),0,'',SUM(LOCAL_DG_40 + LOCAL_DG_45))	LOCAL_DG_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_20),0,'',SUM(LOCAL_DG_20)) LOCAL_DG_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40H),0,'',SUM(LOCAL_DG_40H)) LOCAL_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40 + LOCAL_RF_45),0,'',SUM(LOCAL_RF_40 + LOCAL_RF_45))	LOCAL_RF_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_20),0,'',SUM(LOCAL_RF_20)) LOCAL_RF_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9),0,'',SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9)) LOCAL_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40 + LOCAL_RF_45),0,'',SUM(LOCAL_FR_40 + LOCAL_RF_45))	LOCAL_FR_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_20),0,'',SUM(LOCAL_FR_20)) LOCAL_FR_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40H),0,'',SUM(LOCAL_FR_40H)) LOCAL_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_40),0,'',SUM(LOCAL_OT_40)) LOCAL_OT_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_20),0,'',SUM(LOCAL_OT_20))	LOCAL_OT_20," ).append("\n"); 
		query.append("    DECODE(SUM(LOCAL_OT_40H),0,'',SUM(LOCAL_OT_40H)) LOCAL_OT_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45),0,'',SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45))	LOCAL_PCOD_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_20),0,'',SUM(LOCAL_PCOD_20)) LOCAL_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_DG_40 + TS_DG_45),0,'',SUM(TS_DG_40 + TS_DG_45))	TS_DG_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_DG_20),0,'',SUM(TS_DG_20)) TS_DG_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_DG_40H),0,'',SUM(TS_DG_40H)) TS_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_RF_40 + TS_RF_45),0,'',SUM(TS_RF_40 + TS_RF_45))	TS_RF_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_RF_20),0,'',SUM(TS_RF_20)) TS_RF_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9),0,'',SUM(TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9)) TS_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_FR_40 + TS_FR_45),0,'',SUM(TS_FR_40 + TS_FR_45))	TS_FR_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_FR_20),0,'',SUM(TS_FR_20)) TS_FR_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_FR_40H),0,'',SUM(TS_FR_40H)) TS_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_OT_40),0,'',SUM(TS_OT_40))	TS_OT_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_OT_20),0,'',SUM(TS_OT_20))	TS_OT_20," ).append("\n"); 
		query.append("    DECODE(SUM(TS_OT_40H),0,'',SUM(TS_OT_40H))	TS_OT_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45),0,'',SUM(TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45))	TS_PCOD_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_PCOD_20),0,'',SUM(TS_PCOD_20))	TS_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40 + LOCAL_DG_45 + TS_DG_40 + TS_DG_45),0,'',SUM(LOCAL_DG_40 + LOCAL_DG_45 + TS_DG_40 + TS_DG_45)) SUM_DG_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_20 + TS_DG_20),0,'',SUM(LOCAL_DG_20 + TS_DG_20)) SUM_DG_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40H + TS_DG_40H),0,'',SUM(LOCAL_DG_40H + TS_DG_40H)) SUM_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40 + LOCAL_RF_45 + TS_RF_40 + TS_RF_45),0,'',SUM(LOCAL_RF_40 + LOCAL_RF_45 + TS_RF_40 + TS_RF_45)) SUM_RF_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_20 + TS_RF_20),0,'',SUM(LOCAL_RF_20 + TS_RF_20)) SUM_RF_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9 + TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9),0,'',SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9 + TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9)) SUM_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40 + LOCAL_FR_45 + TS_FR_40 + TS_FR_45),0,'',SUM(LOCAL_FR_40 + LOCAL_FR_45 + TS_FR_40 + TS_FR_45)) SUM_FR_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_20 + TS_FR_20),0,'',SUM(LOCAL_FR_20 + TS_FR_20)) SUM_FR_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40H + TS_FR_40H),0,'',SUM(LOCAL_FR_40H + TS_FR_40H)) SUM_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_40 + TS_OT_40),0,'',SUM(LOCAL_OT_40 + TS_OT_40)) SUM_OT_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_20 + TS_OT_20),0,'',SUM(LOCAL_OT_20 + TS_OT_20)) SUM_OT_20," ).append("\n"); 
		query.append("    DECODE(SUM(LOCAL_OT_40H + TS_OT_40H),0,'',SUM(LOCAL_OT_40H + TS_OT_40H)) SUM_OT_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45 + TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45),0,'',SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45 + TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45)) SUM_PCOD_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_20 + TS_PCOD_20),0,'',SUM(LOCAL_PCOD_20 + TS_PCOD_20)) SUM_PCOD_20" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    	(SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) POD_CD" ).append("\n"); 
		query.append("    		, BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append("            , DECODE(MAX( DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')), " ).append("\n"); 
		query.append("        							'USOAK', DECODE(BK.BLCK_STWG_CD, 'OA1', 'OA1' ,'' , '', 'OAK'), " ).append("\n"); 
		query.append("        							'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','7','SEV','T','TRS', 'LOC'), " ).append("\n"); 
		query.append("        							'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')), NULL, MAX(DECODE(BK.POD_CD,'XXXXX','XXXXX',NVL(LO.UN_LOC_CD,BV.POD_CD))), " ).append("\n"); 
		query.append("        			 MAX( DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')), " ).append("\n"); 
		query.append("        							'USOAK', DECODE(BK.BLCK_STWG_CD, 'OA1', 'OA1' ,'', '', 'OAK'), " ).append("\n"); 
		query.append("        							'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','7','SEV','T','TRS', 'LOC'), " ).append("\n"); 
		query.append("        							'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),''))) BLCK_STWG_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))       LOCAL_DG_20" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',0,'5',0,DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0)),0)) LOCAL_DG_40" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))       LOCAL_DG_40H" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))       LOCAL_DG_45" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))       TS_DG_20" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',0,'5',0,DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0)))) TS_DG_40" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'5',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))       TS_DG_40H" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',DECODE(BQ.DCGO_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))       TS_DG_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    		, BKG_VVD BV" ).append("\n"); 
		query.append("    		, VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("    		, BKG_DG_CGO DG" ).append("\n"); 
		query.append("    		, MDM_LOCATION LO" ).append("\n"); 
		query.append("    		, BKG_QTY_DTL BQ" ).append("\n"); 
		query.append("    	WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    	  AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("    	  AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("    	  AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("    	  AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("    	  AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("    	  AND BK.BKG_NO = DG.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("		  AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("		  AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	  AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("    	  AND VPS.CLPT_IND_SEQ='1'" ).append("\n"); 
		query.append("    	  AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n"); 
		query.append("    	  AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("    	GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD)" ).append("\n"); 
		query.append("    		, BK.BKG_NO) DG, " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	(SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) POD_CD" ).append("\n"); 
		query.append("    		, BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R2',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        LOCAL_RF_20" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R4',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        LOCAL_RF_40" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R5',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        LOCAL_RF_40H_5" ).append("\n"); 
		query.append("	    , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R8',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        LOCAL_RF_40H_8" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R9',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        LOCAL_RF_40H_9" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'R7',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0),0))        LOCAL_RF_45" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R2',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        TS_RF_20" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R4',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        TS_RF_40" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R5',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        TS_RF_40H_5" ).append("\n"); 
		query.append("	    , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R8',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        TS_RF_40H_8" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R9',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        TS_RF_40H_9" ).append("\n"); 
		query.append("            , MAX(DECODE(BV.POL_CD,BK.POL_CD, 0,DECODE(BQ.CNTR_TPSZ_CD,'R7',DECODE(BQ.RC_FLG,'Y',BQ.OP_CNTR_QTY,0),0)))        TS_RF_45" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    	FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    		, BKG_VVD BV" ).append("\n"); 
		query.append("    		, VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("    		, BKG_RF_CGO RF" ).append("\n"); 
		query.append("    		, MDM_LOCATION LO" ).append("\n"); 
		query.append("    		, BKG_QTY_DTL BQ" ).append("\n"); 
		query.append("    	WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    	  AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("    	  AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("    	  AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("    	  AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("    	  AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("    	  AND BK.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("		  AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("		  AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	  AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("    	  AND VPS.CLPT_IND_SEQ='1'" ).append("\n"); 
		query.append("    	  AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n"); 
		query.append("    	  AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("    	GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD)" ).append("\n"); 
		query.append("    		, BK.BKG_NO " ).append("\n"); 
		query.append("    	) RF," ).append("\n"); 
		query.append("    	(SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) POD_CD" ).append("\n"); 
		query.append("    		, BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'F2',BQ.OP_CNTR_QTY,'P2',BQ.OP_CNTR_QTY,'A2',BQ.OP_CNTR_QTY,0),0)) LOCAL_FR_20" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'F4',BQ.OP_CNTR_QTY,'P4',BQ.OP_CNTR_QTY,'A4',BQ.OP_CNTR_QTY,0),0)) LOCAL_FR_40" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'F5',BQ.OP_CNTR_QTY,0),0)) LOCAL_FR_40H" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'F7',BQ.OP_CNTR_QTY,0),0)) LOCAL_FR_45" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'O2',BQ.OP_CNTR_QTY,'S2',BQ.OP_CNTR_QTY,0),0)) LOCAL_OT_20" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'O4',BQ.OP_CNTR_QTY,'S4',BQ.OP_CNTR_QTY,0),0)) LOCAL_OT_40" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(BQ.CNTR_TPSZ_CD,'O5',BQ.OP_CNTR_QTY,'S5',BQ.OP_CNTR_QTY,0),0)) LOCAL_OT_40H" ).append("\n"); 
		query.append("    		" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)),0)) LOCAL_PCOD_20" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)),0)) LOCAL_PCOD_40" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)),0)) LOCAL_PCOD_40H" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7', BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7', BQ.OP_CNTR_QTY,0),0)),0)) LOCAL_PCOD_45" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'F2',BQ.OP_CNTR_QTY,'P2',BQ.OP_CNTR_QTY,'A2',BQ.OP_CNTR_QTY,0))) TS_FR_20" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'F4',BQ.OP_CNTR_QTY,'P4',BQ.OP_CNTR_QTY,'A4',BQ.OP_CNTR_QTY,0))) TS_FR_40" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'F5',BQ.OP_CNTR_QTY,0))) TS_FR_40H" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'F7',BQ.OP_CNTR_QTY,0))) TS_FR_45" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'O2',BQ.OP_CNTR_QTY,'S2',BQ.OP_CNTR_QTY,0))) TS_OT_20" ).append("\n"); 
		query.append("    		, SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'O4',BQ.OP_CNTR_QTY,'S4',BQ.OP_CNTR_QTY,0))) TS_OT_40" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(BQ.CNTR_TPSZ_CD,'O5',BQ.OP_CNTR_QTY,'S5',BQ.OP_CNTR_QTY,0))) TS_OT_40H" ).append("\n"); 
		query.append("    		" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)))) TS_PCOD_20" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)))) TS_PCOD_40" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  BQ.OP_CNTR_QTY),0)))) TS_PCOD_40H" ).append("\n"); 
		query.append("            , SUM(DECODE(BV.POL_CD,BK.POL_CD, 0, DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7', BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7', BQ.OP_CNTR_QTY,0),0)))) TS_PCOD_45" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    		, BKG_VVD BV" ).append("\n"); 
		query.append("    		, VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("    		, BKG_QUANTITY BQ" ).append("\n"); 
		query.append("    		, MDM_LOCATION LO" ).append("\n"); 
		query.append("    		, MDM_COMMODITY CM" ).append("\n"); 
		query.append("    	WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    	  AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("    	  AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("    	  AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("    	  AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("    	  AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("    	  AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("		  AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("		  AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	  AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("    	  AND VPS.CLPT_IND_SEQ='1'" ).append("\n"); 
		query.append("    	  AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n"); 
		query.append("    	  AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n"); 
		query.append("    	  AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n"); 
		query.append("    	GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD) " ).append("\n"); 
		query.append("    		, BK.BKG_NO) BQ" ).append("\n"); 
		query.append("    WHERE DG. BKG_NO = RF.BKG_NO" ).append("\n"); 
		query.append("    AND DG. BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("GROUP BY BLCK_STWG_CD, DG.POD_CD" ).append("\n"); 
		query.append("ORDER BY ORDER_GUBUN, ORDER_GUBUN2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("/***************************** 기본 조회 *****************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	BLCK_STWG_CD GUBUN_CD,    " ).append("\n"); 
		query.append("	POD_CD GUBUN_CD2,                                                   " ).append("\n"); 
		query.append("	DECODE(POD_CD, 'USLGB', '1', 2) ORDER_GUBUN," ).append("\n"); 
		query.append("	DECODE(BLCK_STWG_CD, 'LOC', '0', 'ONE', '1', 'TWO', '2', 'THR', '3', 'FOR', '4', 'FIV', '4.5', 'SEV', '4.7', 'HOT','5','TRS', '6', BLCK_STWG_CD) ORDER_GUBUN2," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40 + LOCAL_DG_45),0,'',SUM(LOCAL_DG_40 + LOCAL_DG_45))	LOCAL_DG_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_20),0,'',SUM(LOCAL_DG_20)) LOCAL_DG_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40H),0,'',SUM(LOCAL_DG_40H)) LOCAL_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40 + LOCAL_RF_45),0,'',SUM(LOCAL_RF_40 + LOCAL_RF_45))	LOCAL_RF_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_20),0,'',SUM(LOCAL_RF_20)) LOCAL_RF_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9),0,'',SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9)) LOCAL_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40 + LOCAL_RF_45),0,'',SUM(LOCAL_FR_40 + LOCAL_RF_45))	LOCAL_FR_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_20),0,'',SUM(LOCAL_FR_20)) LOCAL_FR_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40H),0,'',SUM(LOCAL_FR_40H)) LOCAL_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_40),0,'',SUM(LOCAL_OT_40)) LOCAL_OT_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_20),0,'',SUM(LOCAL_OT_20))	LOCAL_OT_20," ).append("\n"); 
		query.append("    DECODE(SUM(LOCAL_OT_40H), 0, '', SUM(LOCAL_OT_40H)) LOCAL_OT_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45),0,'',SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45))	LOCAL_PCOD_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_20),0,'',SUM(LOCAL_PCOD_20)) LOCAL_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_DG_40 + TS_DG_45),0,'',SUM(TS_DG_40 + TS_DG_45))	TS_DG_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_DG_20),0,'',SUM(TS_DG_20)) TS_DG_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_DG_40H),0,'',SUM(TS_DG_40H)) TS_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_RF_40 + TS_RF_45),0,'',SUM(TS_RF_40 + TS_RF_45))	TS_RF_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_RF_20),0,'',SUM(TS_RF_20)) TS_RF_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9),0,'',SUM(TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9)) TS_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_FR_40 + TS_FR_45),0,'',SUM(TS_FR_40 + TS_FR_45))	TS_FR_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_FR_20),0,'',SUM(TS_FR_20)) TS_FR_20," ).append("\n"); 
		query.append("	DECODE(SUM(TS_FR_40H),0,'',SUM(TS_FR_40H)) TS_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_OT_40),0,'',SUM(TS_OT_40))	TS_OT_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_OT_20),0,'',SUM(TS_OT_20))	TS_OT_20," ).append("\n"); 
		query.append("    DECODE(SUM(TS_OT_40H),0,'',SUM(TS_OT_40H)) TS_OT_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45),0,'',SUM(TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45))	TS_PCOD_40," ).append("\n"); 
		query.append("	DECODE(SUM(TS_PCOD_20),0,'',SUM(TS_PCOD_20))	TS_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40 + LOCAL_DG_45 + TS_DG_40 + TS_DG_45),0,'',SUM(LOCAL_DG_40 + LOCAL_DG_45 + TS_DG_40 + TS_DG_45)) SUM_DG_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_20 + TS_DG_20),0,'',SUM(LOCAL_DG_20 + TS_DG_20)) SUM_DG_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_DG_40H + TS_DG_40H),0,'',SUM(LOCAL_DG_40H + TS_DG_40H)) SUM_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40 + LOCAL_RF_45 + TS_RF_40 + TS_RF_45),0,'',SUM(LOCAL_RF_40 + LOCAL_RF_45 + TS_RF_40 + TS_RF_45)) SUM_RF_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_20 + TS_RF_20),0,'',SUM(LOCAL_RF_20 + TS_RF_20)) SUM_RF_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9 + TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9),0,'',SUM(LOCAL_RF_40H_5 + LOCAL_RF_40H_8 + LOCAL_RF_40H_9 + TS_RF_40H_5 + TS_RF_40H_8 + TS_RF_40H_9)) SUM_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40 + LOCAL_FR_45 + TS_FR_40 + TS_FR_45),0,'',SUM(LOCAL_FR_40 + LOCAL_FR_45 + TS_FR_40 + TS_FR_45)) SUM_FR_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_20 + TS_FR_20),0,'',SUM(LOCAL_FR_20 + TS_FR_20)) SUM_FR_20," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_FR_40H + TS_FR_40H),0,'',SUM(LOCAL_FR_40H + TS_FR_40H)) SUM_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_40 + TS_OT_40),0,'',SUM(LOCAL_OT_40 + TS_OT_40)) SUM_OT_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_OT_20 + TS_OT_20),0,'',SUM(LOCAL_OT_20 + TS_OT_20)) SUM_OT_20," ).append("\n"); 
		query.append("    DECODE(SUM(LOCAL_OT_40H + TS_OT_40H),0,'',SUM(LOCAL_OT_40H + TS_OT_40H)) SUM_OT_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45 + TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45),0,'',SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45 + TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45)) SUM_PCOD_40," ).append("\n"); 
		query.append("	DECODE(SUM(LOCAL_PCOD_20 + TS_PCOD_20),0,'',SUM(LOCAL_PCOD_20 + TS_PCOD_20)) SUM_PCOD_20" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT	" ).append("\n"); 
		query.append("		DECODE(BLCK_STWG_CD, NULL, POD_CD, BLCK_STWG_CD)	BLCK_STWG_CD," ).append("\n"); 
		query.append("		CLL.POD_CD," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0) LOCAL_DG_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0) LOCAL_DG_40H," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0) LOCAL_DG_45," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0) LOCAL_DG_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO))), 0), 0), 0), 0) LOCAL_RF_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_40H_5," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_40H_8," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_40H_9," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_20," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("		                                                                                                         'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0), 0) LOCAL_FR_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                                         'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_FR_20," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                                         'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_FR_40H," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                                         'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_FR_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("		                                                                                                         'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0), 0) LOCAL_OT_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                                         'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_OT_20," ).append("\n"); 
		query.append("        DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5',                    COUNT(CLL.BKG_NO), 0)), " ).append("\n"); 
		query.append("                                                                                                                 'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_OT_40H," ).append("\n"); 
		query.append("        DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7',                    COUNT(CLL.BKG_NO), 0)), " ).append("\n"); 
		query.append("                                                                                                                 'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_OT_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_40H," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_45," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("		               'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0) TS_DG_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		               'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0) TS_DG_40H," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		            'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0) TS_DG_45," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		    	         'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0) TS_DG_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO))), 0), 0)," ).append("\n"); 
		query.append("		       	      'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, '8',0,'9', 0, COUNT(CLL.BKG_NO))), 0), 0), 0) TS_RF_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		          	   'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_40H_5," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		          	   'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '8', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_40H_8,		" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		          	   'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '9', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_40H_9," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		       	      'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_45," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		          	   'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0)," ).append("\n"); 
		query.append("		                'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', COUNT(CLL.BKG_NO),'2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0) TS_FR_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		                'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_FR_20," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		                'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO),'5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_FR_40H," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		                'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_FR_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("		                                                                                   'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0)," ).append("\n"); 
		query.append("		                'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("		                                                                                   'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0) TS_OT_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("		                'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		                                                                                   'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_OT_20," ).append("\n"); 
		query.append("        DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), " ).append("\n"); 
		query.append("                                                                                           'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5',                    COUNT(CLL.BKG_NO), 0)), 0), 0), 'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_OT_40H," ).append("\n"); 
		query.append("        DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7',                    COUNT(CLL.BKG_NO), 0)), 0), 0), 'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), " ).append("\n"); 
		query.append("                                                                                           'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_OT_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("		               'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0)), 0) TS_PCOD_40," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0)," ).append("\n"); 
		query.append("		               'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0) TS_PCOD_40H," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0)," ).append("\n"); 
		query.append("		            'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0) TS_PCOD_45," ).append("\n"); 
		query.append("		DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0)," ).append("\n"); 
		query.append("		    	         'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0) TS_PCOD_20" ).append("\n"); 
		query.append("	FROM		BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT	DISTINCT IMDG_UN_NO" ).append("\n"); 
		query.append("		FROM 		BKG_DG_CGO" ).append("\n"); 
		query.append("		) DG" ).append("\n"); 
		query.append("	WHERE		CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("	AND 	CLL.BKG_POD_CD IS NOT NULL" ).append("\n"); 
		query.append("	AND  NVL(CLL.POL_YD_CD,' ') like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("	AND 	DG.IMDG_UN_NO(+) = CLL.CLL_RMK1" ).append("\n"); 
		query.append("	GROUP BY 	BLCK_STWG_CD, POD_CD, KR_CLL_TS_CD, MTY_BKG_CD, CNTR_TPSZ_CD, DG.IMDG_UN_NO, CLL_RMK1, KR_TML_PRCT_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BLCK_STWG_CD, POD_CD" ).append("\n"); 
		query.append("ORDER BY ORDER_GUBUN, ORDER_GUBUN2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}