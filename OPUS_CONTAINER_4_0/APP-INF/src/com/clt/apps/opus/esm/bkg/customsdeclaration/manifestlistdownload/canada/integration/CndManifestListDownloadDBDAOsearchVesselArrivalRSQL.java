/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchVesselArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchVesselArrivalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVesselArrivalRSQL
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchVesselArrivalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchVesselArrivalRSQL").append("\n"); 
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
		query.append("SELECT  A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.VPS_PORT_CD " ).append("\n"); 
		query.append("       ,B.CRR_CD" ).append("\n"); 
		query.append("       ,DECODE(C.ETA_DT,NULL,TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD'),TO_CHAR(C.ETA_DT,'YYYY-MM-DD'))	AS VPS_ETA_DT" ).append("\n"); 
		query.append("       ,C.CVY_REF_NO" ).append("\n"); 
		query.append("       ,C.CAP_NM" ).append("\n"); 
		query.append("       ,D.CGO_WGT" ).append("\n"); 
		query.append("       ,E1.TEU_FUL" ).append("\n"); 
		query.append("       ,E2.FEU_FUL" ).append("\n"); 
		query.append("       ,E3.OTH_FUL" ).append("\n"); 
		query.append("       ,E4.TEU_MTY" ).append("\n"); 
		query.append("       ,E5.FEU_MTY" ).append("\n"); 
		query.append("       ,E6.OTH_MTY" ).append("\n"); 
		query.append("       ,Z.ATTR_CTNT2" ).append("\n"); 
		query.append("       ,A.UPD_USR_ID" ).append("\n"); 
		query.append("       ,C.VSL_CD AS CND_VSL_CD" ).append("\n"); 
		query.append("       ,C.VSL_ARR_RPT_SND_DT" ).append("\n"); 
		query.append("       ,B.CRW_KNT " ).append("\n"); 
		query.append("       ,DECODE(C.ACT_ARR_DT,NULL," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("         SELECT  TO_CHAR(ACT_ARR_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("           FROM  VSK_ACT_PORT_SKD  D" ).append("\n"); 
		query.append("          WHERE  D.VSL_CD = A.VSL_CD " ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = CASE WHEN A.TURN_PORT_IND_CD IN ('Y', 'N') THEN A.SKD_VOY_NO ELSE A.TURN_SKD_VOY_NO END" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = CASE WHEN A.TURN_PORT_IND_CD IN ('Y', 'N') THEN A.SKD_DIR_CD ELSE A.TURN_SKD_DIR_CD END" ).append("\n"); 
		query.append("            AND  D.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("        ),  TO_CHAR(C.ACT_ARR_DT,'YYYY-MM-DD HH24:MI'))	AS ACT_ARR_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("       ,MDM_VSL_CNTR B" ).append("\n"); 
		query.append("       ,BKG_CSTMS_CND_VSL C" ).append("\n"); 
		query.append("       ,BKG_HRD_CDG_CTNT Z" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT  ROUND(NVL(SUM(NVL(D.CGO_WGT,0)),0)/1000) AS CGO_WGT" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL  D" ).append("\n"); 
		query.append("          WHERE  D.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  D.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("            AND  D.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("            AND  D.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("        ) D" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT  COUNT(DISTINCT E1.CNTR_NO)                 AS TEU_FUL" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL  D, BKG_CSTMS_ADV_CNTR E1" ).append("\n"); 
		query.append("          WHERE  D.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  D.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("            AND  D.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("            AND  D.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("            AND  D.CNT_CD = E1.CNT_CD   " ).append("\n"); 
		query.append("            AND  D.BL_NO  = E1.BL_NO    " ).append("\n"); 
		query.append("            AND  D.MF_NO IS NULL" ).append("\n"); 
		query.append("            AND  E1.CNTR_TPSZ_CD LIKE '_2'" ).append("\n"); 
		query.append("            AND  E1.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("            AND  E1.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("        ) E1" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT  COUNT(DISTINCT E1.CNTR_NO)                 AS FEU_FUL" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL  D, BKG_CSTMS_ADV_CNTR E1" ).append("\n"); 
		query.append("          WHERE  D.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  D.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("            AND  D.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("            AND  D.POD_CD LIKE 'CA%'" ).append("\n"); 
		query.append("            AND  D.CNT_CD = E1.CNT_CD   " ).append("\n"); 
		query.append("            AND  D.BL_NO  = E1.BL_NO    " ).append("\n"); 
		query.append("            AND  E1.CNTR_TPSZ_CD LIKE '_4'" ).append("\n"); 
		query.append("            AND  D.MF_NO IS NULL" ).append("\n"); 
		query.append("            AND  E1.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("            AND  E1.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("        ) E2" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT  COUNT(DISTINCT E1.CNTR_NO)                 AS OTH_FUL" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL  D, BKG_CSTMS_ADV_CNTR E1" ).append("\n"); 
		query.append("          WHERE  D.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  D.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("            AND  D.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("            AND  D.POD_CD LIKE 'CA%'" ).append("\n"); 
		query.append("            AND  D.CNT_CD = E1.CNT_CD   " ).append("\n"); 
		query.append("            AND  D.BL_NO  = E1.BL_NO    " ).append("\n"); 
		query.append("            AND  D.MF_NO IS NULL" ).append("\n"); 
		query.append("            AND  (E1.CNTR_TPSZ_CD LIKE '_5' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD LIKE '_7' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD LIKE '_8' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD LIKE '_9' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD IN ('DW', 'DX'))" ).append("\n"); 
		query.append("            AND  E1.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("            AND  E1.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("        ) E3" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT  COUNT(DISTINCT E1.CNTR_NO)                 AS TEU_MTY" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL  D, BKG_CSTMS_ADV_CNTR E1" ).append("\n"); 
		query.append("          WHERE  D.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  D.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("            AND  D.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("            AND  D.POD_CD LIKE 'CA%'" ).append("\n"); 
		query.append("            AND  D.CNT_CD = E1.CNT_CD   " ).append("\n"); 
		query.append("            AND  D.BL_NO  = E1.BL_NO    " ).append("\n"); 
		query.append("            AND  D.MF_NO IS NULL" ).append("\n"); 
		query.append("            AND  E1.CNTR_TPSZ_CD LIKE '_2'" ).append("\n"); 
		query.append("            AND  E1.FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("            AND  E1.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("        ) E4" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT  COUNT(DISTINCT E1.CNTR_NO)                 AS FEU_MTY" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL  D, BKG_CSTMS_ADV_CNTR E1" ).append("\n"); 
		query.append("          WHERE  D.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  D.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("            AND  D.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("            AND  D.POD_CD LIKE 'CA%'" ).append("\n"); 
		query.append("            AND  D.CNT_CD = E1.CNT_CD   " ).append("\n"); 
		query.append("            AND  D.BL_NO  = E1.BL_NO    " ).append("\n"); 
		query.append("            AND  D.MF_NO IS NULL" ).append("\n"); 
		query.append("            AND  E1.CNTR_TPSZ_CD LIKE '_4'" ).append("\n"); 
		query.append("            AND  E1.FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("            AND  E1.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("        ) E5" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT  COUNT(DISTINCT E1.CNTR_NO)                 AS OTH_MTY" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL  D, BKG_CSTMS_ADV_CNTR E1" ).append("\n"); 
		query.append("          WHERE  D.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  D.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("            AND  D.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("            AND  D.POD_CD LIKE 'CA%'" ).append("\n"); 
		query.append("            AND  D.CNT_CD = E1.CNT_CD   " ).append("\n"); 
		query.append("            AND  D.BL_NO  = E1.BL_NO    " ).append("\n"); 
		query.append("            AND  D.MF_NO IS NULL" ).append("\n"); 
		query.append("            AND  (E1.CNTR_TPSZ_CD LIKE '_5' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD LIKE '_7' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD LIKE '_8' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD LIKE '_9' OR" ).append("\n"); 
		query.append("                  E1.CNTR_TPSZ_CD IN ('DW', 'DX'))" ).append("\n"); 
		query.append("            AND  E1.FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("            AND  E1.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("        ) E6" ).append("\n"); 
		query.append(" WHERE  A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND  A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  B.CRR_CD = Z.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND  Z.HRD_CDG_ID(+) = 'CND_CSTMS_CRR_CD'" ).append("\n"); 
		query.append("   AND  A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("   AND  A.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND  A.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("   AND  A.VPS_PORT_CD = C.PORT_CD(+)" ).append("\n"); 

	}
}