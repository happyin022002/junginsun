/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCndCstmsManifestDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCndCstmsManifestDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsManifestDtl
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCndCstmsManifestDtlRSQL(){
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
		params.put("frob_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCndCstmsManifestDtlRSQL").append("\n"); 
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
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT  TB.CNT_CD" ).append("\n"); 
		query.append("       ,TB.BL_NO" ).append("\n"); 
		query.append("       ,TB.POL_CD" ).append("\n"); 
		query.append("       ,TB.POD_CD" ).append("\n"); 
		query.append("       ,TB.DEL_CD" ).append("\n"); 
		query.append("       ,TB.HUB_LOC_CD" ).append("\n"); 
		query.append("       ,TB.CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("       ,TB.TRSP_MOD_ID" ).append("\n"); 
		query.append("       ,TB.BL_PCK_QTY" ).append("\n"); 
		query.append("       ,TB.CGO_WGT" ).append("\n"); 
		query.append("       ,TB.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("       ,TB.MF_STS_CD" ).append("\n"); 
		query.append("       ,TB.MH" ).append("\n"); 
		query.append("       ,TB.FULL_MTY_CD" ).append("\n"); 
		query.append("       ,TB.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,TB.WGT_UT_CD" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C1.CUST_NM),NULL,'N','Y') AS CUST_NM1" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C1.CUST_ADDR),NULL,'N','Y') AS CUST_ADDR1" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C1.CUST_CTY_NM),NULL,'N','Y') AS CUST_CTY_NM1" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C1.CUST_STE_CD),NULL,'N','Y') AS CUST_STE_CD1" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C1.CSTMS_DECL_CNT_CD),NULL,'N','Y') AS CUST_CNT_CD1" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C1.CUST_ZIP_ID),NULL,'N','Y') AS CUST_ZIP_ID1" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C2.CUST_NM),NULL,'N','Y') AS CUST_NM2" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C2.CUST_ADDR),NULL,'N','Y') AS CUST_ADDR2" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C2.CUST_CTY_NM),NULL,'N','Y') AS CUST_CTY_NM2" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C2.CUST_STE_CD),NULL,'N','Y') AS CUST_STE_CD2" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C2.CSTMS_DECL_CNT_CD),NULL,'N','Y') AS CUST_CNT_CD2" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C2.CUST_ZIP_ID),NULL,'N','Y') AS CUST_ZIP_ID2" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C3.CUST_NM),NULL,'N','Y') AS CUST_NM3" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C3.CUST_ADDR),NULL,'N','Y') AS CUST_ADDR3" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C3.CUST_CTY_NM),NULL,'N','Y') AS CUST_CTY_NM3" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C3.CUST_STE_CD),NULL,'N','Y') AS CUST_STE_CD3" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C3.CSTMS_DECL_CNT_CD),NULL,'N','Y') AS CUST_CNT_CD3" ).append("\n"); 
		query.append("       ,DECODE(RTRIM(C3.CUST_ZIP_ID),NULL,'N','Y') AS CUST_ZIP_ID3" ).append("\n"); 
		query.append("       ,TB.CNTR_NO" ).append("\n"); 
		query.append("       ,TB.RAIL_CRR_REF_NO" ).append("\n"); 
		query.append("       ,TB.USA_IB_TRSP_NO" ).append("\n"); 
		query.append("       ,DECODE(TB.PCK_QTY, 0, 'Y', 'N') AS PCK_QTY" ).append("\n"); 
		query.append("       ,DECODE(TB.GRS_WGT, 0, 'Y', 'N') AS GRS_WGT" ).append("\n"); 
		query.append("       ,DECODE(TB.MK_DESC, 0, 'Y', 'N') AS MK_DESC" ).append("\n"); 
		query.append("       ,DECODE(TB.CGO_DESC, 0, 'Y', 'N') AS CGO_DESC" ).append("\n"); 
		query.append("       ,DECODE(TB.SEAL_NO,NULL,'N','Y') AS SEAL_NO" ).append("\n"); 
		query.append("       ,TB.BL_NO AS BL_NO2" ).append("\n"); 
		query.append("       ,TB.EDI" ).append("\n"); 
		query.append("       ,TB.SENT_TIME" ).append("\n"); 
		query.append("       ,'' BL_CNT" ).append("\n"); 
		query.append("       ,'' HBL_COUNT" ).append("\n"); 
		query.append("       ,'' MBL1_COUNT" ).append("\n"); 
		query.append("       ,'' MBL2_COUNT" ).append("\n"); 
		query.append("       ,'' MBL3_COUNT" ).append("\n"); 
		query.append("       ,'' BL_TOT_COUNT" ).append("\n"); 
		query.append("       ,CASE WHEN TB.FULL_MTY_CD = 'M' AND DECODE(LENGTH(RTRIM(TB.CNTR_NO)),NULL,'N','Y') = 'Y'" ).append("\n"); 
		query.append("             THEN ''" ).append("\n"); 
		query.append("             ELSE CASE WHEN TB.BL_PCK_QTY = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(TB.AMS_PCK_TP_CD,NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR TB.CGO_WGT = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(TB.WGT_UT_CD,NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C1.CSTMS_DECL_CNT_CD)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C1.CUST_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C1.CUST_ADDR)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C1.CUST_CTY_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C2.CSTMS_DECL_CNT_CD)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C2.CUST_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C2.CUST_ADDR)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C2.CUST_CTY_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C3.CSTMS_DECL_CNT_CD)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C3.CUST_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C3.CUST_ADDR)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(C3.CUST_CTY_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(TB.CNTR_NO)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(LENGTH(RTRIM(TB.SEAL_NO)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(TB.PCK_QTY, 0, 'Y', 'N') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(TB.GRS_WGT, 0, 'Y', 'N') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(TB.MK_DESC, 0, 'Y', 'N') = 'N'" ).append("\n"); 
		query.append("                   OR DECODE(TB.CGO_DESC, 0, 'Y', 'N') = 'N'" ).append("\n"); 
		query.append("                  THEN 'E'" ).append("\n"); 
		query.append("                  ELSE ''" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("         END ERROR" ).append("\n"); 
		query.append("  FROM (            " ).append("\n"); 
		query.append("        SELECT  BL.*" ).append("\n"); 
		query.append("               ,CT.CNTR_NO" ).append("\n"); 
		query.append("               ,CT.RAIL_CRR_REF_NO" ).append("\n"); 
		query.append("               ,CT.USA_IB_TRSP_NO" ).append("\n"); 
		query.append("               ,SUM(DECODE(RTRIM(MF.PCK_QTY),NULL,'1','0')) AS PCK_QTY" ).append("\n"); 
		query.append("               ,SUM(DECODE(RTRIM(MF.GRS_WGT),NULL,'1','0')) AS GRS_WGT" ).append("\n"); 
		query.append("               ,SUM(DECODE(RTRIM(MF.MK_DESC),NULL,'1','0')) AS MK_DESC" ).append("\n"); 
		query.append("               ,SUM(DECODE(RTRIM(MF.CGO_DESC),NULL,'1','0')) AS CGO_DESC" ).append("\n"); 
		query.append("               ,MAX(SL.SEAL_NO) AS SEAL_NO" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT  A.CNT_CD" ).append("\n"); 
		query.append("                       ,A.BL_NO" ).append("\n"); 
		query.append("                       ,A.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("                       ,A.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("                       ,A.DEL_CD" ).append("\n"); 
		query.append("                       ,A.HUB_LOC_CD" ).append("\n"); 
		query.append("                       ,DECODE(A.MF_NO, NULL, A.CSTMS_FILE_TP_CD, '0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("                       ,A.TRSP_MOD_ID" ).append("\n"); 
		query.append("                       ,DECODE(RTRIM(A.PCK_QTY),NULL,'N','Y') AS BL_PCK_QTY" ).append("\n"); 
		query.append("                       ,DECODE(RTRIM(A.CGO_WGT),NULL,'N','Y') AS CGO_WGT" ).append("\n"); 
		query.append("                       ,A.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("                       ,A.MF_STS_CD" ).append("\n"); 
		query.append("                       ,DECODE(A.MF_NO, NULL, 'M', 'H') AS MH" ).append("\n"); 
		query.append("                       ,A.FULL_MTY_CD" ).append("\n"); 
		query.append("                       ,A.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("                       ,A.WGT_UT_CD" ).append("\n"); 
		query.append("                       ,DECODE(A.AMDT_SND_DT, NULL, DECODE(A.MF_SND_DT, NULL, 'N', 'Y'), 'Y') AS EDI" ).append("\n"); 
		query.append("                       ,DECODE(A.AMDT_SND_DT, NULL, DECODE(A.MF_SND_DT, '', NULL, TO_CHAR(A.MF_SND_DT,'YYYY-MM-DD HH24:MI')), TO_CHAR(A.AMDT_SND_DT,'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("                        AS SENT_TIME" ).append("\n"); 
		query.append("                  FROM  BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("                 WHERE  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("                   AND  A.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("                #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                   AND  A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                   AND  A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                   AND  A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                      AND  A.CSTMS_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                   AND  A.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cstms_port_cd} != '')" ).append("\n"); 
		query.append("                   AND  A.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${frob_flg} != '')" ).append("\n"); 
		query.append("                   AND  A.FROB_FLG = @[frob_flg]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cntr_type} != 'A')" ).append("\n"); 
		query.append("                   AND  A.FULL_MTY_CD = @[cntr_type]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("               ) BL" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_CNTR    CT" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_CNTR_MF MF" ).append("\n"); 
		query.append("              ,BKG_CSTMS_SEAL_NO     SL" ).append("\n"); 
		query.append("         WHERE BL.CNT_CD  = CT.CNT_CD(+)" ).append("\n"); 
		query.append("           AND BL.BL_NO   = CT.BL_NO(+)" ).append("\n"); 
		query.append("           AND CT.CNT_CD  = MF.CNT_CD(+)" ).append("\n"); 
		query.append("           AND CT.BL_NO   = MF.BL_NO(+)" ).append("\n"); 
		query.append("           AND CT.CNTR_NO = MF.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND CT.CNT_CD  = SL.CNT_CD(+)" ).append("\n"); 
		query.append("           AND SL.CSTMS_DIV_ID(+) = 'CTM'" ).append("\n"); 
		query.append("           AND CT.BL_NO   = SL.BL_NO(+)" ).append("\n"); 
		query.append("           AND CT.CNTR_NO = SL.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND CT.IBD_CNTR_STS_CD(+) = 'A'" ).append("\n"); 
		query.append("        GROUP BY BL.CNT_CD" ).append("\n"); 
		query.append("                ,BL.BL_NO" ).append("\n"); 
		query.append("                ,BL.POL_CD" ).append("\n"); 
		query.append("                ,BL.POD_CD" ).append("\n"); 
		query.append("                ,BL.DEL_CD" ).append("\n"); 
		query.append("                ,BL.HUB_LOC_CD" ).append("\n"); 
		query.append("                ,BL.CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("                ,BL.TRSP_MOD_ID" ).append("\n"); 
		query.append("                ,BL.BL_PCK_QTY" ).append("\n"); 
		query.append("                ,BL.CGO_WGT" ).append("\n"); 
		query.append("                ,BL.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("                ,BL.MF_STS_CD" ).append("\n"); 
		query.append("                ,BL.MH" ).append("\n"); 
		query.append("                ,BL.FULL_MTY_CD" ).append("\n"); 
		query.append("                ,BL.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("                ,BL.WGT_UT_CD" ).append("\n"); 
		query.append("                ,BL.EDI" ).append("\n"); 
		query.append("                ,BL.SENT_TIME" ).append("\n"); 
		query.append("                ,CT.CNTR_NO" ).append("\n"); 
		query.append("                ,CT.RAIL_CRR_REF_NO" ).append("\n"); 
		query.append("                ,CT.USA_IB_TRSP_NO" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CUST C1" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CUST C2" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CUST C3" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND  TB.CNT_CD = C1.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  TB.BL_NO  = C1.BL_NO(+)" ).append("\n"); 
		query.append("   AND  C1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND  TB.CNT_CD = C2.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  TB.BL_NO  = C2.BL_NO(+)" ).append("\n"); 
		query.append("   AND  C2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND  TB.CNT_CD = C3.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  TB.BL_NO  = C3.BL_NO(+)" ).append("\n"); 
		query.append("   AND  C3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#if (${bl_type} == 'E')" ).append("\n"); 
		query.append(" WHERE ERROR = 'E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BL_NO, CNTR_NO" ).append("\n"); 

	}
}