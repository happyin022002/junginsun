/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclCgoSumByActPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.09 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchSpclCgoSumByActPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpclCgoSumByActPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclCgoSumByActPodRSQL(){
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
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclCgoSumByActPodRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_POD_CD		GUBUN_CD2," ).append("\n"); 
		query.append("'' GUBUN_CD," ).append("\n"); 
		query.append("'' GUBUN_CD3," ).append("\n"); 
		query.append("1 ORDER_GUBUN," ).append("\n"); 
		query.append("SUM(LOCAL_DG_40 + LOCAL_DG_45)	LOCAL_DG_40," ).append("\n"); 
		query.append("SUM(LOCAL_DG_20) LOCAL_DG_20," ).append("\n"); 
		query.append("SUM(LOCAL_DG_40H) LOCAL_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_RF_40 + LOCAL_RF_45)	LOCAL_RF_40," ).append("\n"); 
		query.append("SUM(LOCAL_RF_20) LOCAL_RF_20," ).append("\n"); 
		query.append("SUM(LOCAL_RF_40H) LOCAL_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_FR_40 + LOCAL_RF_45)	LOCAL_FR_40," ).append("\n"); 
		query.append("SUM(LOCAL_FR_20) LOCAL_FR_20," ).append("\n"); 
		query.append("SUM(LOCAL_FR_40H) LOCAL_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_OT_40) LOCAL_OT_40," ).append("\n"); 
		query.append("SUM(LOCAL_OT_20)	LOCAL_OT_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45)	LOCAL_PCOD_40," ).append("\n"); 
		query.append("SUM(LOCAL_PCOD_20) LOCAL_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(TS_DG_40 + TS_DG_45)	TS_DG_40," ).append("\n"); 
		query.append("SUM(TS_DG_20) TS_DG_20," ).append("\n"); 
		query.append("SUM(TS_DG_40H) TS_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(TS_RF_40 + TS_RF_45)	TS_RF_40," ).append("\n"); 
		query.append("SUM(TS_RF_20) TS_RF_20," ).append("\n"); 
		query.append("SUM(TS_RF_40H) TS_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(TS_FR_40 + TS_FR_45)	TS_FR_40," ).append("\n"); 
		query.append("SUM(TS_FR_20) TS_FR_20," ).append("\n"); 
		query.append("SUM(TS_FR_40H) TS_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(TS_OT_40)	TS_OT_40," ).append("\n"); 
		query.append("SUM(TS_OT_20)	TS_OT_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45)	TS_PCOD_40," ).append("\n"); 
		query.append("SUM(TS_PCOD_20)	TS_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_DG_40 + LOCAL_DG_45 + TS_DG_40 + TS_DG_45) SUM_DG_40," ).append("\n"); 
		query.append("SUM(LOCAL_DG_20 + TS_DG_20) SUM_DG_20," ).append("\n"); 
		query.append("SUM(LOCAL_DG_40H + TS_DG_40H) SUM_DG_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_RF_40 + LOCAL_RF_45 + TS_RF_40 + TS_RF_45) SUM_RF_40," ).append("\n"); 
		query.append("SUM(LOCAL_RF_20 + TS_RF_20) SUM_RF_20," ).append("\n"); 
		query.append("SUM(LOCAL_RF_40H + TS_RF_40H) SUM_RF_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_FR_40 + LOCAL_FR_45 + TS_FR_40 + TS_FR_45) SUM_FR_40," ).append("\n"); 
		query.append("SUM(LOCAL_FR_20 + TS_FR_20) SUM_FR_20," ).append("\n"); 
		query.append("SUM(LOCAL_FR_40H + TS_FR_40H) SUM_FR_40H," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_OT_40 + TS_OT_40) SUM_OT_40," ).append("\n"); 
		query.append("SUM(LOCAL_OT_20 + TS_OT_20) SUM_OT_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(LOCAL_PCOD_40 + LOCAL_PCOD_40H + LOCAL_PCOD_45 + TS_PCOD_40 + TS_PCOD_40H + TS_PCOD_45) SUM_PCOD_40," ).append("\n"); 
		query.append("SUM(LOCAL_PCOD_20 + TS_PCOD_20) SUM_PCOD_20" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CLL.BKG_POD_CD," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0) LOCAL_DG_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0) LOCAL_DG_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0) LOCAL_DG_45," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0) LOCAL_DG_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0), 0) LOCAL_RF_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_20," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_RF_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0), 0) LOCAL_FR_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_FR_20," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_FR_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_FR_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0), 0) LOCAL_OT_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD,1,1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0), 0) LOCAL_OT_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_45," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.MTY_BKG_CD, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0), 0) LOCAL_PCOD_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0) TS_DG_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0) TS_DG_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0) TS_DG_45," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0) TS_DG_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0) TS_RF_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_45," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CLL.CLL_RMK1, 1, 2), NULL, 0, 'RD', 0, 'UD', 0, 'OD', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_RF_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', COUNT(CLL.BKG_NO),'2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0) TS_FR_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_FR_20," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', COUNT(CLL.BKG_NO),'5', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_FR_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'F', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'A', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_FR_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)))," ).append("\n"); 
		query.append("'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))), 0), 0), 0) TS_OT_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(DG.IMDG_UN_NO, NULL, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 1, 1), 'O', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'S', DECODE(CLL.CLL_RMK1, NULL, 0, 'IN/GU', 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)), 0), 0), 0) TS_OT_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0))," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0)), 0) TS_PCOD_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0) TS_PCOD_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0) TS_PCOD_45," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0)," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', DECODE(KR_TML_PRCT_ID, 'P', COUNT(CLL.BKG_NO), 0), 0), 0) TS_PCOD_20" ).append("\n"); 
		query.append("FROM		BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	DISTINCT IMDG_UN_NO" ).append("\n"); 
		query.append("FROM 		BKG_DG_CGO" ).append("\n"); 
		query.append(") DG" ).append("\n"); 
		query.append("WHERE		CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND 	CLL.BKG_POD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND  NVL(CLL.POL_YD_CD,' ') like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("AND 	DG.IMDG_UN_NO(+) = CLL.CLL_RMK1" ).append("\n"); 
		query.append("GROUP BY 	BKG_POD_CD, POD_CD, KR_CLL_TS_CD, MTY_BKG_CD, CNTR_TPSZ_CD, DG.IMDG_UN_NO, CLL_RMK1, KR_TML_PRCT_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BKG_POD_CD" ).append("\n"); 

	}
}