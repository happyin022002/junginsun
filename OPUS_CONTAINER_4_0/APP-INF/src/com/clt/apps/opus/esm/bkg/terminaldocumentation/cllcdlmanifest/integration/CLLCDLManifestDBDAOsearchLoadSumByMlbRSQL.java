/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchLoadSumByMlbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.07 
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
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
		query.append("    SELECT BLCK_STWG_CD GUBUN_CD2," ).append("\n"); 
		query.append("      POD_CD GUBUN_CD," ).append("\n"); 
		query.append("      '' GUBUN_CD3," ).append("\n"); 
		query.append("      POD_CD ORDER_GUBUN," ).append("\n"); 
		query.append("      BLCK_STWG_CD ORDER_GUBUN2," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_40H), 0, '', SUM(LOCAL_40H)) LOCAL_40H," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_40), 0, '', SUM(LOCAL_40)) LOCAL_40," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_20), 0, '', SUM(LOCAL_20)) LOCAL_20," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_45), 0, '', SUM(LOCAL_45)) LOCAL_45," ).append("\n"); 
		query.append("      DECODE(SUM(TS_40H) , 0, '', SUM(TS_40H)) TS_40H," ).append("\n"); 
		query.append("      DECODE(SUM(TS_40), 0, '', SUM(TS_40)) TS_40," ).append("\n"); 
		query.append("      DECODE(SUM(TS_20), 0, '', SUM(TS_20)) TS_20," ).append("\n"); 
		query.append("      DECODE(SUM(TS_45), 0, '', SUM(TS_45)) TS_45," ).append("\n"); 
		query.append("      DECODE(SUM(MTY_40H), 0, '', SUM(MTY_40H)) MTY_40H," ).append("\n"); 
		query.append("      DECODE(SUM(MTY_40), 0, '', SUM(MTY_40)) MTY_40," ).append("\n"); 
		query.append("      DECODE(SUM(MTY_20), 0, '', SUM(MTY_20)) MTY_20," ).append("\n"); 
		query.append("      DECODE(SUM(MTY_45), 0, '', SUM(MTY_45)) MTY_45," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_40H + TS_40H + MTY_40H), 0, '', SUM(LOCAL_40H + TS_40H + MTY_40H)) SUM_40H," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_40 + TS_40 + MTY_40), 0, '', SUM(LOCAL_40 + TS_40 + MTY_40)) SUM_40," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_20 + TS_20 + MTY_20), 0, '', SUM(LOCAL_20 + TS_20 + MTY_20)) SUM_20," ).append("\n"); 
		query.append("      DECODE(SUM(LOCAL_45 + TS_45 + MTY_45), 0, '', SUM(LOCAL_45 + TS_45 + MTY_45)) SUM_45," ).append("\n"); 
		query.append("      NVL(ROUND(SUM(WGT), 0), 1) WGT_MT," ).append("\n"); 
		query.append("	  NVL(ROUND(SUM(VGM), 0), 0) VGM_MT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT DECODE(CLL.BLCK_STWG_CD, NULL, CLL.POD_CD, CLL.BLCK_STWG_CD) BLCK_STWG_CD," ).append("\n"); 
		query.append("          CLL.POD_CD POD_CD," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_20," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_40," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, COUNT(CLL.BKG_NO)), 0), 0) LOCAL_40H," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, DECODE(CLL.mty_bkg_cd, 'F', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0), 0) LOCAL_45," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0)) TS_20," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', COUNT(CLL.BKG_NO), 0)) TS_40," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, COUNT(CLL.BKG_NO))) TS_40H," ).append("\n"); 
		query.append("          DECODE(CLL.KR_CLL_TS_CD, NULL, 0, DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0)) TS_45," ).append("\n"); 
		query.append("          DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', COUNT(CLL.BKG_NO), 0), 0) MTY_20," ).append("\n"); 
		query.append("          DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', COUNT(CLL.BKG_NO), 0), 0) MTY_40," ).append("\n"); 
		query.append("          DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, COUNT(CLL.BKG_NO)), 0) MTY_40H," ).append("\n"); 
		query.append("          DECODE(CLL.mty_bkg_cd, 'M', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', COUNT(CLL.BKG_NO), 0), 0) MTY_45," ).append("\n"); 
		query.append("          SUM(DECODE(NVL(CLL.WGT_UT_CD, 0), 'LBS', ROUND (NVL(CLL.BL_WGT, 0)*0.4536, 3), NVL(CLL.BL_WGT, 0))) WGT," ).append("\n"); 
		query.append("		  SUM(NVL(CLL.VGM_WGT, 0)) VGM" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_TML_KR_CLL CLL" ).append("\n"); 
		query.append("        WHERE CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no], 2, 3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd], 3, 3)" ).append("\n"); 
		query.append("          AND POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND NVL(POL_YD_CD, ' ') like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("#if (${in_cll_type} == 'LOCAL')" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#elseif (${in_cll_type} == 'TS')" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NOT NULL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY CLL.BLCK_STWG_CD, CLL.POD_CD, CLL.KR_CLL_TS_CD, CLL.MTY_BKG_CD, CLL.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY POD_CD, BLCK_STWG_CD" ).append("\n"); 
		query.append("    ORDER BY ORDER_GUBUN, ORDER_GUBUN2 " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}