/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchLoadSumByActPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.12.23 김승민
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

public class CLLCDLManifestDBDAOsearchLoadSumByActPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLoadSumByActPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchLoadSumByActPodRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchLoadSumByActPodRSQL").append("\n"); 
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
		query.append("SELECT BKG_POD_CD GUBUN_CD," ).append("\n"); 
		query.append("'' GUBUN_CD2," ).append("\n"); 
		query.append("'' GUBUN_CD3," ).append("\n"); 
		query.append("1 ORDER_GUBUN," ).append("\n"); 
		query.append("SUM(LOCAL_40H)   LOCAL_40H," ).append("\n"); 
		query.append("SUM(LOCAL_40)    LOCAL_40," ).append("\n"); 
		query.append("SUM(LOCAL_20)    LOCAL_20," ).append("\n"); 
		query.append("SUM(LOCAL_45)    LOCAL_45," ).append("\n"); 
		query.append("SUM(TS_40H)      TS_40H," ).append("\n"); 
		query.append("SUM(TS_40)       TS_40," ).append("\n"); 
		query.append("SUM(TS_20)       TS_20," ).append("\n"); 
		query.append("SUM(TS_45)       TS_45," ).append("\n"); 
		query.append("SUM(MTY_40H)     MTY_40H," ).append("\n"); 
		query.append("SUM(MTY_40)      MTY_40," ).append("\n"); 
		query.append("SUM(MTY_20)      MTY_20," ).append("\n"); 
		query.append("SUM(MTY_45)      MTY_45," ).append("\n"); 
		query.append("SUM(LOCAL_40H + TS_40H + MTY_40H) SUM_40H," ).append("\n"); 
		query.append("SUM(LOCAL_40 + TS_40 + MTY_40)    SUM_40," ).append("\n"); 
		query.append("SUM(LOCAL_20 + TS_20 + MTY_20)    SUM_20," ).append("\n"); 
		query.append("SUM(LOCAL_45 + TS_45 + MTY_45)    SUM_45," ).append("\n"); 
		query.append("NVL(ROUND(SUM(WGT),0),1) WGT_MT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CLL.BKG_POD_CD   BKG_POD_CD," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)), 0), 0) LOCAL_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_20," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_45," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0) TS_40H," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO))," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)), 0) TS_40," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0) TS_20," ).append("\n"); 
		query.append("DECODE(CLL.KR_CLL_TS_CD, 'TT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)," ).append("\n"); 
		query.append("'TS', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0) TS_45," ).append("\n"); 
		query.append("DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '5', COUNT(CLL.BKG_NO), 0), 0) MTY_40H," ).append("\n"); 
		query.append("DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '5', 0, '7', 0, COUNT(CLL.BKG_NO)), 0) MTY_40," ).append("\n"); 
		query.append("DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0) MTY_20," ).append("\n"); 
		query.append("DECODE(CLL.mty_bkg_cd,  'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0) MTY_45," ).append("\n"); 
		query.append("SUM(TP.CNTR_TPSZ_TARE_WGT*BQ.OP_CNTR_QTY) WGT_MT," ).append("\n"); 
		query.append("SUM(DECODE(NVL(CLL.WGT_UT_CD, 0), 'LBS', ROUND (NVL(CLL.BL_WGT, 0)*0.4536, 3), NVL(CLL.BL_WGT, 0))) WGT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("(select QTY.bkg_no, MAX(QTY.CNTR_TPSZ_CD) CNTR_TPSZ_CD, MAX(QTY.OP_CNTR_QTY) OP_CNTR_QTY" ).append("\n"); 
		query.append("from BKG_QUANTITY QTY,  BKG_CSTMS_TML_KR_CLL CLL" ).append("\n"); 
		query.append("where QTY.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n"); 
		query.append("AND QTY.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("AND CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("group by QTY.BKG_NO" ).append("\n"); 
		query.append(") BQ," ).append("\n"); 
		query.append("(select CNTR_TPSZ_CD, CNTR_TPSZ_TARE_WGT from MDM_CNTR_TP_SZ) TP" ).append("\n"); 
		query.append("WHERE CLL.CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND CLL.BKG_POD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(CLL.POL_YD_CD,' ') like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("AND CLL.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("AND BQ.CNTR_TPSZ_CD = TP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("GROUP BY CLL.BKG_POD_CD, CLL.POD_CD, CLL.KR_CLL_TS_CD, CLL.MTY_BKG_CD, CLL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BKG_POD_CD, 1" ).append("\n"); 
		query.append("ORDER BY BKG_POD_CD" ).append("\n"); 

	}
}