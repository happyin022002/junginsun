/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOsearchDubaiBlManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOsearchDubaiBlManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DubaiBlManifestListVO
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOsearchDubaiBlManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOsearchDubaiBlManifestListRSQL").append("\n"); 
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
		query.append("#if (${data_type} == 'bl')" ).append("\n"); 
		query.append("    SELECT '0' AS CHK" ).append("\n"); 
		query.append("          ,'' DU_ROTN_NO" ).append("\n"); 
		query.append("          ,'' DU_MRN_NO" ).append("\n"); 
		query.append("          ,TB2.BL_NO" ).append("\n"); 
		query.append("          ,TB2.BKG_NO" ).append("\n"); 
		query.append("          ,'SML' DU_LINE_ID" ).append("\n"); 
		query.append("          ,CASE WHEN @[pod_cd] = 'AESHJ' OR @[pod_cd] = 'AEKLF' THEN 'H0533' " ).append("\n"); 
		query.append("                ELSE 'H0012' END DU_VOY_AGN_ID" ).append("\n"); 
		query.append("          ,TB2.POR_CD" ).append("\n"); 
		query.append("          ,TB2.POL_CD" ).append("\n"); 
		query.append("          ,TB2.POD_CD" ).append("\n"); 
		query.append("          ,TB2.DEL_CD" ).append("\n"); 
		query.append("          ,TB2.DU_TRD_CD" ).append("\n"); 
		query.append("          ,DECODE(TB2.FULL_MTY_CD || TB2.CNTR_NO, 'M', 'M', 'F', 'F', 'G', 'G', 'L') AS DU_CGO_CD" ).append("\n"); 
		query.append("          ,DECODE(TB2.CNTR_NO, NULL, 'N', 'Y') AS CNSL_CGO_FLG" ).append("\n"); 
		query.append("          ,SUBSTR(TB2.POR_CD, 1, 2) AS ORG_CNT_CD" ).append("\n"); 
		query.append("          ,TB2.CUST_NM" ).append("\n"); 
		query.append("          ,TB2.CUST_ADDR" ).append("\n"); 
		query.append("          ,TB2.DU_CMDT_CD" ).append("\n"); 
		query.append("          ,TB2.PCK_QTY" ).append("\n"); 
		query.append("          ,PCK.ATTR_CTNT1 AS DU_PCK_TP_CD" ).append("\n"); 
		query.append("          ,TB2.CGO_WGT" ).append("\n"); 
		query.append("          ,TB2.CGO_WGT + TB2.TARE_WGT AS GRS_WGT" ).append("\n"); 
		query.append("          ,TB2.VSL_CD" ).append("\n"); 
		query.append("          ,TB2.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,TB2.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,VC.VSL_ENG_NM AS VSL_NM" ).append("\n"); 
		query.append("          ,TO_CHAR(SKD.VPS_ETA_DT, 'YYYY-MM-DD') AS ETA_DT" ).append("\n"); 
		query.append("          ,SKD.CLPT_SEQ" ).append("\n"); 
		query.append("          ,TB2.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("           SELECT CASE WHEN MIN(C.CNTR_VOL_QTY) < 1 THEN MIN(C.CNTR_NO)" ).append("\n"); 
		query.append("                   END CNTR_NO" ).append("\n"); 
		query.append("                 ,SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2,1), '2', 1, 2)) AS BKG_TEU_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(NVL(S.TARE_WGT, 0), 0 ," ).append("\n"); 
		query.append("                             DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0 ," ).append("\n"); 
		query.append("                                    DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), MDM.CNTR_TPSZ_TARE_WGT) , S.TARE_WGT )) AS TARE_WGT" ).append("\n"); 
		query.append("                 ,DECODE(TB.BKG_POD_CD, TB.POD_CD, 'I', 'T') AS DU_TRD_CD" ).append("\n"); 
		query.append("                 ,TB.*" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                   SELECT B.BKG_NO" ).append("\n"); 
		query.append("                         ,B.BL_NO" ).append("\n"); 
		query.append("                         ,V.VSL_CD" ).append("\n"); 
		query.append("                         ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("                         ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("                         ,B.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("                         ,B.POR_CD" ).append("\n"); 
		query.append("                         ,V.POL_CD" ).append("\n"); 
		query.append("                         ,V.POD_CD" ).append("\n"); 
		query.append("						 ,nvl((select v2.pod_cd from bkg_vvd v2 where v.bkg_no = v2.bkg_no and  v.pod_cd = v2.pol_cd), v.pod_cd) DEL_CD" ).append("\n"); 
		query.append("                         --,B.DEL_CD" ).append("\n"); 
		query.append("                         ,B.CMDT_CD AS DU_CMDT_CD" ).append("\n"); 
		query.append("                         ,D.PCK_QTY" ).append("\n"); 
		query.append("                         ,D.ACT_WGT AS CGO_WGT" ).append("\n"); 
		query.append("                         ,D.MEAS_QTY" ).append("\n"); 
		query.append("                         ,D.MEAS_QTY AS DU_FRT_WGT" ).append("\n"); 
		query.append("                         ,D.PCK_TP_CD" ).append("\n"); 
		query.append("                         ,DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(B.BB_CGO_FLG, 'Y', 'G','F'), 'M') AS FULL_MTY_CD" ).append("\n"); 
		query.append("                         ,CASE WHEN NVL(INSTR(C.CUST_NM, CHR(13)||CHR(10), 1), 0) = 0 THEN SUBSTR(C.CUST_NM, 1, 48)" ).append("\n"); 
		query.append("                               ELSE SUBSTR(SUBSTR(C.CUST_NM, 1, INSTR(C.CUST_NM, CHR(13)||CHR(10), 1, 1)-1), 1, 48)" ).append("\n"); 
		query.append("                               END CUST_NM" ).append("\n"); 
		query.append("                         ,CASE WHEN NVL(INSTR(C.CUST_NM, CHR(13)||CHR(10), 1), 0) = 0 THEN SUBSTR(C.CUST_ADDR, 1, 240)" ).append("\n"); 
		query.append("                               ELSE SUBSTR(SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(13)||CHR(10), 1, 1)+2) || CHR(13)||C.CUST_ADDR, 1, 240) " ).append("\n"); 
		query.append("                               END CUST_ADDR" ).append("\n"); 
		query.append("                         ,C.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                     FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                         ,BKG_VVD V" ).append("\n"); 
		query.append("                         ,BKG_BL_DOC D" ).append("\n"); 
		query.append("                         ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("                    WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                      AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                      AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                      AND B.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("                      AND B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("                      AND C.BKG_CUST_TP_CD = DECODE(B.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                      AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                      AND V.POD_CD LIKE 'AE%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                      AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                      AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                      AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                      AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                      AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_type} == 'F')" ).append("\n"); 
		query.append("                      AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n"); 
		query.append("#elseif(${cgo_type} == 'M')" ).append("\n"); 
		query.append("                      AND B.BKG_CGO_TP_CD IN ('P', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  ) TB" ).append("\n"); 
		query.append("                 ,BKG_CONTAINER C" ).append("\n"); 
		query.append("                 ,MST_CONTAINER M" ).append("\n"); 
		query.append("                 ,MST_CNTR_SPEC S" ).append("\n"); 
		query.append("                 ,MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("            WHERE TB.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("              AND C.CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("              AND M.CNTR_SPEC_NO = S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("              AND M.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("        GROUP BY  TB.BKG_NO" ).append("\n"); 
		query.append("                 ,TB.BL_NO" ).append("\n"); 
		query.append("                 ,TB.VSL_CD" ).append("\n"); 
		query.append("                 ,TB.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,TB.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,TB.BKG_POD_CD" ).append("\n"); 
		query.append("                 ,TB.POR_CD" ).append("\n"); 
		query.append("                 ,TB.POL_CD" ).append("\n"); 
		query.append("                 ,TB.POD_CD" ).append("\n"); 
		query.append("                 ,TB.DEL_CD" ).append("\n"); 
		query.append("                 ,TB.DU_CMDT_CD" ).append("\n"); 
		query.append("                 ,TB.PCK_QTY" ).append("\n"); 
		query.append("                 ,TB.CGO_WGT" ).append("\n"); 
		query.append("                 ,TB.MEAS_QTY" ).append("\n"); 
		query.append("                 ,TB.DU_FRT_WGT" ).append("\n"); 
		query.append("                 ,TB.PCK_TP_CD" ).append("\n"); 
		query.append("                 ,TB.FULL_MTY_CD" ).append("\n"); 
		query.append("                 ,TB.CUST_NM" ).append("\n"); 
		query.append("                 ,TB.CUST_ADDR" ).append("\n"); 
		query.append("                 ,TB.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           )TB2" ).append("\n"); 
		query.append("          ,MDM_VSL_CNTR VC" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("          ,BKG_CSTMS_CD_CONV_CTNT PCK" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("       AND TB2.VSL_CD = VC.VSL_CD" ).append("\n"); 
		query.append("       AND TB2.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("       AND TB2.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND TB2.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND TB2.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND SKD.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("       AND PCK.CNT_CD(+) = 'AE'" ).append("\n"); 
		query.append("       AND PCK.CSTMS_DIV_ID(+) = 'DUBAI_PCK_CD'" ).append("\n"); 
		query.append("       AND TB2.PCK_TP_CD = PCK.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("       AND (CSTMS_DIV_ID_SEQ IS NULL OR" ).append("\n"); 
		query.append("            CSTMS_DIV_ID_SEQ = (SELECT MAX(CSTMS_DIV_ID_SEQ)" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                                 WHERE CNT_CD = 'AE'" ).append("\n"); 
		query.append("                                   AND CSTMS_DIV_ID = 'DUBAI_PCK_CD'" ).append("\n"); 
		query.append("                                   AND ATTR_CTNT3 = TB2.PCK_TP_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #if (${du_trd_cd} != 'A'&& ${du_trd_cd} != '')" ).append("\n"); 
		query.append("       AND TB2.DU_TRD_CD = @[du_trd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("  ORDER BY TB2.BL_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT '1' AS CHK" ).append("\n"); 
		query.append("          ,B.DU_ROTN_NO" ).append("\n"); 
		query.append("          ,B.BL_NO" ).append("\n"); 
		query.append("          ,BKG.BKG_NO" ).append("\n"); 
		query.append("          ,B.DU_LINE_ID" ).append("\n"); 
		query.append("          ,B.DU_VOY_AGN_ID" ).append("\n"); 
		query.append("          ,B.ORG_PORT_CD" ).append("\n"); 
		query.append("          ,B.POR_CD" ).append("\n"); 
		query.append("          ,B.POL_CD" ).append("\n"); 
		query.append("          ,B.POD_CD" ).append("\n"); 
		query.append("          ,B.DEL_CD" ).append("\n"); 
		query.append("          ,B.DU_TRD_CD" ).append("\n"); 
		query.append("          ,B.DU_CGO_CD" ).append("\n"); 
		query.append("          ,B.CNSL_CGO_FLG" ).append("\n"); 
		query.append("          ,B.ORG_CNT_CD" ).append("\n"); 
		query.append("          ,C.CUST_NM" ).append("\n"); 
		query.append("          ,C.CUST_ADDR" ).append("\n"); 
		query.append("          ,B.DU_CMDT_CD" ).append("\n"); 
		query.append("          ,B.PCK_QTY" ).append("\n"); 
		query.append("          ,B.DU_PCK_TP_CD" ).append("\n"); 
		query.append("          ,B.CGO_WGT" ).append("\n"); 
		query.append("          ,B.GRS_WGT" ).append("\n"); 
		query.append("          ,B.VSL_CD" ).append("\n"); 
		query.append("          ,B.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,B.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,V.VSL_NM" ).append("\n"); 
		query.append("          ,TO_CHAR(V.ETA_DT, 'YYYY-MM-DD') AS ETA_DT" ).append("\n"); 
		query.append("          ,V.CLPT_SEQ" ).append("\n"); 
		query.append("          ,V.DU_ROTN_NO AS V_DU_ROTN_NO" ).append("\n"); 
		query.append("          ,V.DU_INSTL_NO" ).append("\n"); 
		query.append("          ,C.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("          ,V.DU_MRN_NO" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_DU_BL B" ).append("\n"); 
		query.append("          ,BKG_CSTMS_DU_VVD V" ).append("\n"); 
		query.append("          ,BKG_CSTMS_DU_CUST C" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("     WHERE B.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("       AND B.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND B.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND B.POD_CD = V.POD_CD" ).append("\n"); 
		query.append("       AND B.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("       AND B.POD_CD = C.POD_CD(+)" ).append("\n"); 
		query.append("       AND C.BKG_CUST_TP_CD = DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("       AND B.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("	#if (${bl_no} != '')" ).append("\n"); 
		query.append("       AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND B.POD_CD LIKE 'AE%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd} != '')" ).append("\n"); 
		query.append("       AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("       AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pol_cd} != '')" ).append("\n"); 
		query.append("       AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pod_cd} != '')" ).append("\n"); 
		query.append("       AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cgo_code} != '')" ).append("\n"); 
		query.append("       AND B.DU_CGO_CD = @[cgo_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${du_trd_cd} != 'A'&& ${du_trd_cd} != '')" ).append("\n"); 
		query.append("       AND B.DU_TRD_CD = @[du_trd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("ORDER BY B.BL_NO" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}