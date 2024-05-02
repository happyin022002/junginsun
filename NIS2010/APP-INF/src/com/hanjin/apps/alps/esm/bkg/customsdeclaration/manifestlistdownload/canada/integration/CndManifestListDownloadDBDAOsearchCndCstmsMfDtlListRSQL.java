/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchCndCstmsMfDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchCndCstmsMfDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsMfDtlList
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchCndCstmsMfDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchCndCstmsMfDtlListRSQL").append("\n"); 
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
		query.append("      DECODE(ERR_CD1,'F',DECODE(SUBSTR(POL_CD,1,2),'CA','',ERR_CD1),ERR_CD1) AS ERR_CD  ------ EXPORT에서는 FILER가 필요 없다." ).append("\n"); 
		query.append("    , Y.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  TB.*" ).append("\n"); 
		query.append("       ,DECODE(TB.SND_DT, NULL, 'N', 'Y') AS EDI_FLG" ).append("\n"); 
		query.append("       ,TB.SND_DT AS EDI_SND_DT" ).append("\n"); 
		query.append("       ,DECODE(EMP_FLG, 'N', BKG_GET_CSTMS_ADV_ERR_CD_FNC(TB.BKG_NO, TB.BL_TYPE, 'CA')" ).append("\n"); 
		query.append("               , (SELECT DECODE (COUNT(1), 0, 'E', '')" ).append("\n"); 
		query.append("                   FROM BKG_CONTAINER " ).append("\n"); 
		query.append("                  WHERE BKG_NO = TB.BKG_NO)) AS ERR_CD1" ).append("\n"); 
		query.append("       ,'' CA_ISS_DT" ).append("\n"); 
		query.append("       ,'' MF_STS_Cd" ).append("\n"); 
		query.append("       ,'' CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("       ,'' CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  BKG.BL_NO" ).append("\n"); 
		query.append("               ,BKG.BL_NO AS BL_NOS" ).append("\n"); 
		query.append("               ,'' AS CNTR_MF_NO" ).append("\n"); 
		query.append("               ,BKG.CND_CSTMS_FILE_CD AS FILER" ).append("\n"); 
		query.append("               ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(BKG.BKG_CGO_TP_CD,'P','Y','N') AS EMP_FLG" ).append("\n"); 
		query.append("               ,DECODE(ABL.BKG_NO,NULL,'N','Y') AS IF_FLG" ).append("\n"); 
		query.append("               ,BKG.BKG_NO" ).append("\n"); 
		query.append("               ,VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD" ).append("\n"); 
		query.append("               ,VVD.POD_CD" ).append("\n"); 
		query.append("               ,DOC.PCK_QTY" ).append("\n"); 
		query.append("               ,DOC.PCK_TP_CD" ).append("\n"); 
		query.append("               ,DOC.ACT_WGT" ).append("\n"); 
		query.append("               ,DOC.WGT_UT_CD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST1.CUST_NM)),NULL,'N','Y') AS SHPR_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST1.CUST_ADDR)),NULL,'N','Y') AS SHPR_AD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST2.CUST_NM)),NULL,'N','Y') AS CNEE_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST2.CUST_ADDR)),NULL,'N','Y') AS CNEE_AD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST3.CUST_NM)),NULL,'N','Y') AS NTFY_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST3.CUST_ADDR)),NULL,'N','Y') AS NTFY_AD" ).append("\n"); 
		query.append("               ,DOC.BDR_FLG" ).append("\n"); 
		query.append("               ,(SELECT MAX(CORR_NO) FROM BKG_CORRECTION WHERE BKG_NO = BKG.BKG_NO) AS CA_NO" ).append("\n"); 
		query.append("               ,(SELECT MAX(SND_DT) FROM BKG_NTC_HIS WHERE BKG_NO = BKG.BKG_NO AND NTC_KND_CD = 'CA') AS SND_DT" ).append("\n"); 
		query.append("               ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("               ,'M' BL_TYPE" ).append("\n"); 
		query.append("               ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("          FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST1" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST2" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST3" ).append("\n"); 
		query.append("               ,BKG_CSTMS_ADV_BL ABL" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND  VVD.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("           AND  VVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("           AND  VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("           AND  BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND  ABL.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("           AND  BKG.BL_NO = ABL.BL_NO(+)" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = ABL.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = CST1.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  CST1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = CST2.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  CST2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = CST3.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  CST3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("               ,H.CNTR_MF_NO AS BL_NOS" ).append("\n"); 
		query.append("               ,H.CNTR_MF_NO" ).append("\n"); 
		query.append("               ,'0' AS FILER" ).append("\n"); 
		query.append("               ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("               ,'N' AS EMP_FLG" ).append("\n"); 
		query.append("               ,DECODE(ABL.BKG_NO,NULL,'N','Y') AS IF_FLG" ).append("\n"); 
		query.append("               ,BKG.BKG_NO" ).append("\n"); 
		query.append("               ,VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD" ).append("\n"); 
		query.append("               ,VVD.POD_CD" ).append("\n"); 
		query.append("               ,H.PCK_QTY" ).append("\n"); 
		query.append("               ,H.PCK_TP_CD" ).append("\n"); 
		query.append("               ,H.HBL_WGT AS ACT_WGT" ).append("\n"); 
		query.append("               ,H.WGT_UT_CD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST1.CUST_NM)),NULL,'N','Y') AS SHPR_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST1.CUST_ADDR)),NULL,'N','Y') AS SHPR_AD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST2.CUST_NM)),NULL,'N','Y') AS CNEE_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST2.CUST_ADDR)),NULL,'N','Y') AS CNEE_AD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST3.CUST_NM)),NULL,'N','Y') AS NTFY_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST3.CUST_ADDR)),NULL,'N','Y') AS NTFY_AD" ).append("\n"); 
		query.append("               ,DOC.BDR_FLG" ).append("\n"); 
		query.append("               ,'' AS CA_NO" ).append("\n"); 
		query.append("               ,(SELECT MAX(SND_DT) FROM BKG_NTC_HIS WHERE BKG_NO = BKG.BKG_NO AND NTC_KND_CD = 'CA') AS SND_DT" ).append("\n"); 
		query.append("               ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("               ,'H' BL_TYPE" ).append("\n"); 
		query.append("               ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("          FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("               ,BKG_HBL H" ).append("\n"); 
		query.append("               ,BKG_HBL_CUST CST1" ).append("\n"); 
		query.append("               ,BKG_HBL_CUST CST2" ).append("\n"); 
		query.append("               ,BKG_HBL_CUST CST3" ).append("\n"); 
		query.append("               ,BKG_CSTMS_ADV_BL ABL" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND  VVD.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("           AND  VVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("           AND  VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  BKG.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("           AND  BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("           AND  H.CNTR_MF_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND  ABL.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("           AND  H.CNTR_MF_NO = ABL.BL_NO(+)" ).append("\n"); 
		query.append("           AND  H.BKG_NO = CST1.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  H.HBL_SEQ = CST1.HBL_SEQ(+)" ).append("\n"); 
		query.append("           AND  CST1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("           AND  H.BKG_NO = CST2.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  H.HBL_SEQ = CST2.HBL_SEQ(+)" ).append("\n"); 
		query.append("           AND  CST2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("           AND  H.BKG_NO = CST3.BKG_NO(+)" ).append("\n"); 
		query.append("           AND  H.HBL_SEQ = CST3.HBL_SEQ(+)" ).append("\n"); 
		query.append("           AND  CST3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("           AND  BKG.CND_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND  SKD.CLPT_SEQ   >= @[clpt_seq]" ).append("\n"); 
		query.append("   AND  TB.VSL_CD 		= SKD.VSL_CD" ).append("\n"); 
		query.append("   AND  TB.SKD_VOY_NO 	= SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  TB.SKD_DIR_CD 	= SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  TB.POD_CD 		= SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND  SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F') " ).append("\n"); 
		query.append("   AND  TB.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("   AND  TB.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("--ORDER BY TB.BKG_NO, TB.BL_TYPE DESC, TB.BL_NO" ).append("\n"); 
		query.append("ORDER BY BKG_NO, BL_TYPE DESC, BL_NO" ).append("\n"); 

	}
}