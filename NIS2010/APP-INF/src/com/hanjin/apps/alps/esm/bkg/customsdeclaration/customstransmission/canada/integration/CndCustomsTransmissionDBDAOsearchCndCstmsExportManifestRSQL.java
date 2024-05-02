/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCndCstmsExportManifestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCndCstmsExportManifestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Canada Export 조회
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCndCstmsExportManifestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atd_from_tm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("atd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atd_to_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCndCstmsExportManifestRSQL").append("\n"); 
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
		query.append("SELECT  VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("       ,VVD.VSL_CD" ).append("\n"); 
		query.append("       ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,VVD.POL_CD AS POL_CD" ).append("\n"); 
		query.append("       ,VVD.POD_CD AS POD_CD" ).append("\n"); 
		query.append("       ,VVD.POR_CD" ).append("\n"); 
		query.append("       ,VVD.DEL_CD" ).append("\n"); 
		query.append("       ,VVD.BKG_NO" ).append("\n"); 
		query.append("       ,VVD.BL_NO" ).append("\n"); 
		query.append("       ,TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') AS ETD_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(ACT_SKD.ACT_DEP_DT, 'YYYY-MM-DD HH24:MI:SS') ACT_DEP_DT       " ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(VVD.POD_CD, 1,2), 'CA', 'N', 'Y') AS FROB_FLG" ).append("\n"); 
		query.append("       --,TO_CHAR(Z2.VPS_ETB_DT + 1/24,'YYYY-MM-DD HH24:MI:SS') AS ETL_DT" ).append("\n"); 
		query.append("       /*,(CASE WHEN BDR.TRNK_MNL_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("              WHEN BDR.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("              WHEN BDR.TRNK_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("          ELSE 'N' END) AS BDR_FLG*/" ).append("\n"); 
		query.append("       , NVL((" ).append("\n"); 
		query.append("          SELECT 'Y'" ).append("\n"); 
		query.append("          FROM BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append("          WHERE VVD.VSL_CD       = BDR.VSL_CD" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO   = BDR.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD   = BDR.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD.POL_CD       = BDR.POL_CD" ).append("\n"); 
		query.append("           AND VVD.POD_CD       = BDR.POD_CD" ).append("\n"); 
		query.append("           AND (BDR.TRNK_MNL_BDR_FLG = 'Y' OR BDR.TRNK_AUTO_BDR_FLG = 'Y' OR BDR.TRNK_BDR_FLG = 'Y' ) " ).append("\n"); 
		query.append("           AND ROWNUM =1" ).append("\n"); 
		query.append("         ) ,'N') BDR_FLG" ).append("\n"); 
		query.append("       ,CASE WHEN VVD.BKG_CGO_TP_CD = 'P' THEN 'E10'" ).append("\n"); 
		query.append(" 	         WHEN VVD.MF_NO > ' ' THEN 'S10'" ).append("\n"); 
		query.append("	         ELSE 'A6A' END CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("       ,FILER" ).append("\n"); 
		query.append("       ,EMP_FLG" ).append("\n"); 
		query.append("       ,TO_CHAR(SND.SND_DT,'YYYY-MM-DD HH24:MI:SS') AS MF_SND_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT  BKG.BL_NO" ).append("\n"); 
		query.append("               ,BKG.BL_NO AS BL_NOS" ).append("\n"); 
		query.append("               ,'' AS MF_NO" ).append("\n"); 
		query.append("               ,'' AS CNTR_MF_NO" ).append("\n"); 
		query.append("               ,BKG.CND_CSTMS_FILE_CD AS FILER" ).append("\n"); 
		query.append("               ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(BKG.BKG_CGO_TP_CD,'P','Y','N') AS EMP_FLG" ).append("\n"); 
		query.append("               ,BKG.BKG_NO" ).append("\n"); 
		query.append("               ,VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD" ).append("\n"); 
		query.append("               ,VVD.POD_CD" ).append("\n"); 
		query.append("               ,BKG.POR_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD               " ).append("\n"); 
		query.append("               ,DOC.BDR_FLG" ).append("\n"); 
		query.append("               ,(SELECT MAX(CORR_NO) FROM BKG_CORRECTION WHERE BKG_NO = BKG.BKG_NO) AS CA_NO" ).append("\n"); 
		query.append("               ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("               ,'M' BL_TYPE" ).append("\n"); 
		query.append("               ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("          FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("           #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.VSL_CD       = SUBSTR(@[vvd_cd],1, 4)" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO   = SUBSTR(@[vvd_cd],5, 4)" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD   = SUBSTR(@[vvd_cd],9, 1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${pol_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${pod_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${lane} != '') " ).append("\n"); 
		query.append("           AND VVD.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           AND  VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("           AND  BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("               ,H.CNTR_MF_NO AS BL_NOS" ).append("\n"); 
		query.append("               ,H.CNTR_MF_NO" ).append("\n"); 
		query.append("               ,BKG.BL_NO AS MF_NO               " ).append("\n"); 
		query.append("               ,'0' AS FILER" ).append("\n"); 
		query.append("               ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("               ,'N' AS EMP_FLG" ).append("\n"); 
		query.append("               ,BKG.BKG_NO" ).append("\n"); 
		query.append("               ,VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD" ).append("\n"); 
		query.append("               ,VVD.POD_CD" ).append("\n"); 
		query.append("               ,BKG.POR_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD               " ).append("\n"); 
		query.append("               ,DOC.BDR_FLG" ).append("\n"); 
		query.append("               ,'' AS CA_NO" ).append("\n"); 
		query.append("               ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("               ,'H' BL_TYPE" ).append("\n"); 
		query.append("               ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("          FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("               ,BKG_HBL H" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("           #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.VSL_CD       = SUBSTR(@[vvd_cd],1, 4)" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO   = SUBSTR(@[vvd_cd],5, 4)" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD   = SUBSTR(@[vvd_cd],9, 1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${pol_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${pod_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${lane} != '') " ).append("\n"); 
		query.append("           AND VVD.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           AND  VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("           AND  BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("           AND  H.CNTR_MF_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND  BKG.CND_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append(") VVD" ).append("\n"); 
		query.append("  ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("  ,VSK_ACT_PORT_SKD ACT_SKD" ).append("\n"); 
		query.append("  ,(" ).append("\n"); 
		query.append("      SELECT X1.CNT_CD, X1.CRR_BAT_NO,X1.BL_NO" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_ADV_EDI_BL_RSPN X1" ).append("\n"); 
		query.append("      WHERE X1.CNT_CD  = 'CA'" ).append("\n"); 
		query.append("      AND X1.CRR_BAT_NO = (" ).append("\n"); 
		query.append("                  SELECT MAX(X.CRR_BAT_NO)" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_EDI_BL_RSPN X, BKG_CSTMS_ADV_SND_LOG Y" ).append("\n"); 
		query.append("                  WHERE X.CNT_CD  = 'CA'" ).append("\n"); 
		query.append("                  AND X.BL_NO = X1.BL_NO" ).append("\n"); 
		query.append("                  AND X.CNT_CD = X1.CNT_CD  " ).append("\n"); 
		query.append("                  AND X.CNT_CD = Y.CNT_CD                " ).append("\n"); 
		query.append("                  AND X.CRR_BAT_NO = Y.CRR_BAT_NO" ).append("\n"); 
		query.append("		          #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                  AND Y.VSL_CD       = SUBSTR(@[vvd_cd],1, 4)" ).append("\n"); 
		query.append("                  AND Y.SKD_VOY_NO   = SUBSTR(@[vvd_cd],5, 4)" ).append("\n"); 
		query.append("                  AND Y.SKD_DIR_CD   = SUBSTR(@[vvd_cd],9, 1)" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("      )  EDI " ).append("\n"); 
		query.append("  ,BKG_CSTMS_ADV_SND_LOG SND" ).append("\n"); 
		query.append("WHERE   VVD.VSL_CD = SKD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  VVD.SKD_VOY_NO = SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  VVD.SKD_DIR_CD = SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  VVD.POL_CD = SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND  SKD.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("   AND  NVL(SKD.SKD_CNG_STS_CD(+),'X') != 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  VVD.VSL_CD = ACT_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  VVD.SKD_VOY_NO = ACT_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  VVD.SKD_DIR_CD = ACT_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  VVD.POL_CD = ACT_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND  ACT_SKD.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  VVD.BL_NO =  EDI.BL_NO(+)   " ).append("\n"); 
		query.append("   AND  SND.CNT_CD(+)  = 'CA'   " ).append("\n"); 
		query.append("   AND  EDI.CNT_CD = SND.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  EDI.CRR_BAT_NO = SND.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${atd_from_dt} != '' && ${atd_to_dt} != '') " ).append("\n"); 
		query.append("   AND ACT_SKD.VPS_PORT_CD = @[atd_pod_cd]" ).append("\n"); 
		query.append("   AND ACT_SKD.ACT_DEP_DT BETWEEN TO_DATE(REPLACE(REPLACE(@[atd_from_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[atd_from_tm], ':', ''), '-', ''), 'YYYYMMDD HH24MI') AND TO_DATE(REPLACE(REPLACE(@[atd_to_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[atd_to_tm], ':', ''), '-', ''), 'YYYYMMDD HH24MI') " ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}