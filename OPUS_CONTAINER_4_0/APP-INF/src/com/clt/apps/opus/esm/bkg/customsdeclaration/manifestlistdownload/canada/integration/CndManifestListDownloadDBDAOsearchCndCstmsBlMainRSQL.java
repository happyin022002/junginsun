/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchCndCstmsBlMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchCndCstmsBlMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsBlMain
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchCndCstmsBlMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchCndCstmsBlMainRSQL").append("\n"); 
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
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT   A.BL_NO" ).append("\n"); 
		query.append("        ,DECODE(A.MF_NO, NULL, A.CSTMS_FILE_TP_CD, '0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("        ,DECODE(A.MF_STS_CD,'A','Active',DECODE(A.MF_STS_CD,'D','Deleted','InActive')) AS MF_STS_CD" ).append("\n"); 
		query.append("        --,A.CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("        ,NVL(A.CSTMS_MF_TP_CD, DECODE(A.FULL_MTY_CD, 'M', 'E10', DECODE(A.MF_NO, NULL, 'A6A', 'S10'))) AS CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("        ,A.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("		,DECODE(A.MF_NO, NULL, A.BL_NO, A.MF_NO) AS M_BL_NO" ).append("\n"); 
		query.append("        ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("        ,A.POR_CD" ).append("\n"); 
		query.append("        ,A.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("        ,A.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("        ,A.POD_NOD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(S.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("        ,A.DEL_CD" ).append("\n"); 
		query.append("        ,A.PCK_QTY" ).append("\n"); 
		query.append("        ,A.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("        ,A.CGO_WGT" ).append("\n"); 
		query.append("        ,A.WGT_UT_CD" ).append("\n"); 
		query.append("        ,A.HUB_LOC_CD" ).append("\n"); 
		query.append("        ,A.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,C.FRT_CLT_FLG" ).append("\n"); 
		query.append("        ,C.OBL_RDEM_FLG" ).append("\n"); 
		query.append("        ,A.TRSP_TP_ID" ).append("\n"); 
		query.append("        ,A.BDR_FLG" ).append("\n"); 
		query.append("        ,DECODE(A.FULL_MTY_CD, 'M', '1', '0') AS FULL_MTY_CD" ).append("\n"); 
		query.append("        ,COUNT(HBL.BL_NO) OVER (ORDER BY A.BL_NO) AS HBL_COUNT" ).append("\n"); 
		query.append("        ,'9165'||A.BL_NO AS CCN_NO" ).append("\n"); 
		query.append("        ,SUBSTR(A.IN_TZ_YD_CD,1,5) AS IN_TZ_YD_CD1" ).append("\n"); 
		query.append("        ,SUBSTR(A.IN_TZ_YD_CD,6,2) AS IN_TZ_YD_CD2" ).append("\n"); 
		query.append("        ,A.IN_TZ_YD_ZIP_ID " ).append("\n"); 
		query.append("        ,A.IN_TZ_YD_NM" ).append("\n"); 
		query.append("        ,A.IN_TZ_YD_ADDR " ).append("\n"); 
		query.append("        ,A.IN_TZ_YD_CTY_NM " ).append("\n"); 
		query.append("        ,A.IN_TZ_YD_STE_CD " ).append("\n"); 
		query.append("        ,A.IN_TZ_YD_CNT_CD " ).append("\n"); 
		query.append("        ,A.DIFF_RMK" ).append("\n"); 
		query.append("        ,CASE WHEN BDR.TRNK_MNL_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("              WHEN BDR.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("              WHEN BDR.TRNK_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("              ELSE 'N' " ).append("\n"); 
		query.append("          END T_BDR_FLG" ).append("\n"); 
		query.append("        ,ROW_NUMBER() OVER(ORDER BY A.BL_NO) AS RNUM" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("       ,BKG_CGO_RLSE C" ).append("\n"); 
		query.append("	   ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_BL HBL" ).append("\n"); 
		query.append("       ,BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("   AND  A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND  A.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("   AND  A.VSL_CD = S.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_POD_CD = S.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND  S.CLPT_IND_SEQ(+) = 1" ).append("\n"); 
		query.append("   AND  A.CNT_CD = HBL.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  A.BL_NO = HBL.MF_NO(+)" ).append("\n"); 
		query.append("   AND  A.VSL_CD = BDR.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = BDR.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = BDR.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_POL_CD = BDR.POL_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_POD_CD = BDR.POD_CD(+)" ).append("\n"); 
		query.append("      ) TB" ).append("\n"); 
		query.append(" WHERE TB.RNUM = 1" ).append("\n"); 

	}
}