/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchManifestSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchManifestSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0613 요약 조회
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchManifestSummaryRSQL(){
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
		params.put("full_empty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchManifestSummaryRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.VSL_CD,' ')||NVL(A.SKD_VOY_NO,' ')||NVL(A.SKD_DIR_CD,' ') VVD," ).append("\n"); 
		query.append("       A.CSTMS_POL_CD POL, A.CSTMS_POD_CD POD," ).append("\n"); 
		query.append("       CASE WHEN MAX(P.VPS_ETA_DT) IS NULL THEN ' ' ELSE TO_CHAR(MAX(P.VPS_ETA_DT), 'YYYY-MM-DD HH24:MI') END ETA,  " ).append("\n"); 
		query.append("       CASE WHEN INSTR(A.CSTMS_POD_CD, 'US') != 1 THEN" ).append("\n"); 
		query.append("           DECODE(" ).append("\n"); 
		query.append("               (SELECT VPS_PORT_CD " ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                WHERE " ).append("\n"); 
		query.append("                   VSL_CD = A.VSL_CD AND SKD_VOY_NO = A.SKD_VOY_NO AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND CLPT_SEQ = " ).append("\n"); 
		query.append("                      (SELECT MIN(CLPT_SEQ) AS SEQ" ).append("\n"); 
		query.append("                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                       WHERE VSL_CD = A.VSL_CD AND SKD_VOY_NO = A.SKD_VOY_NO AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND VPS_PORT_CD LIKE 'US%')" ).append("\n"); 
		query.append("                   AND  VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("               ), NULL, 'N', 'Y' " ).append("\n"); 
		query.append("           )   " ).append("\n"); 
		query.append("       ELSE 'N'" ).append("\n"); 
		query.append("       END  FROB," ).append("\n"); 
		query.append("       A.CSTMS_PORT_CD  CUSTOMS," ).append("\n"); 
		query.append("       CASE WHEN S.SND_DT  IS NULL THEN ' ' ELSE TO_CHAR(S.SND_DT, 'YYYY-MM-DD HH24:MI') END SENT_TIME," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${full_empty} == 'M')" ).append("\n"); 
		query.append("		DECODE(S.TRSM_MSG_TP_ID||S.CGO_TP_CD, 'MIM', 'Y', 'MI', 'Y', 'N') MI," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${full_empty} == 'F') " ).append("\n"); 
		query.append("		DECODE(S.TRSM_MSG_TP_ID||S.CGO_TP_CD, 'MIF', 'Y', 'MI', 'Y', 'N') MI," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       --DECODE(S.TRSM_MSG_TP_ID, 'MI', 'Y', 'N') MI," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       COUNT(DISTINCT B.CNTR_NO) CNTR_COUNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT A.BL_NO) BL_COUNT," ).append("\n"); 
		query.append("		COUNT( DISTINCT DECODE(NVL(A.MF_NO, ' '), ' ', DECODE(DECODE(A.CSTMS_FILE_TP_CD,NULL,'3','0','1', A.CSTMS_FILE_TP_CD), '1', A.BL_NO), NULL)) MBL_COUNT01," ).append("\n"); 
		query.append("		COUNT( DISTINCT DECODE(NVL(A.MF_NO, ' '), ' ', DECODE(DECODE(A.CSTMS_FILE_TP_CD,NULL,'3','0','1', A.CSTMS_FILE_TP_CD), '2', A.BL_NO), NULL)) MBL_COUNT02," ).append("\n"); 
		query.append("		COUNT( DISTINCT DECODE(NVL(A.MF_NO, ' '), ' ', DECODE(DECODE(A.CSTMS_FILE_TP_CD,NULL,'3','0','1', A.CSTMS_FILE_TP_CD), '3', A.BL_NO), NULL)) MBL_COUNT03," ).append("\n"); 
		query.append("		COUNT( DISTINCT DECODE(NVL(A.MF_NO, ' '), ' ', NULL, A.BL_NO)) HBL_COUNT," ).append("\n"); 
		query.append("		CASE WHEN MAX(P2.VPS_ETD_DT) IS NULL THEN ' ' ELSE TO_CHAR(MAX(P2.VPS_ETD_DT), 'YYYY-MM-DD HH24:MI') END ETD," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT SUM(DECODE(TRNK_AUTO_BDR_FLG, 'Y', 1, 0) + DECODE(TRNK_MNL_BDR_FLG, 'Y', 1, 0) + DECODE(TRNK_BDR_FLG, 'Y', 1, 0) ) " ).append("\n"); 
		query.append("			FROM BKG_VVD_BDR_LOG L" ).append("\n"); 
		query.append("			WHERE L.VSL_CD = A.VSL_CD " ).append("\n"); 
		query.append("			AND L.SKD_VOY_NO = A.SKD_VOY_NO " ).append("\n"); 
		query.append("			AND L.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND L.POL_CD = A.CSTMS_POL_CD " ).append("\n"); 
		query.append("		    AND L.POL_CLPT_IND_SEQ = (" ).append("\n"); 
		query.append("				                               SELECT MAX(POL_CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                        		FROM BKG_VVD_BDR_LOG L" ).append("\n"); 
		query.append("                                        			WHERE L.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                        			AND L.SKD_VOY_NO = A.SKD_VOY_NO " ).append("\n"); 
		query.append("                                        			AND L.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        			AND L.POL_CD = A.CSTMS_POL_CD" ).append("\n"); 
		query.append("				                           )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND L.POD_CD = A.CSTMS_POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) BDR_COUNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("	 ,(" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("        WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("        AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("        AND TRSM_MSG_TP_ID = 'MI'" ).append("\n"); 
		query.append("        AND VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("        AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("        AND POL_CD LIKE NVL(@[pol],'%')" ).append("\n"); 
		query.append("        AND POD_CD LIKE NVL(@[pod],'%') " ).append("\n"); 
		query.append("        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND NVL(CGO_TP_CD, 'X') = DECODE(NVL(CGO_TP_CD,'X'), 'X', 'X', @[full_empty])" ).append("\n"); 
		query.append("        AND SND_DT IN (" ).append("\n"); 
		query.append("            SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("            WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("            AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("            AND TRSM_MSG_TP_ID = 'MI'" ).append("\n"); 
		query.append("            AND VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("            AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("            AND POL_CD LIKE NVL(@[pol],'%')" ).append("\n"); 
		query.append("            AND POD_CD LIKE NVL(@[pod],'%') " ).append("\n"); 
		query.append("            AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND NVL(CGO_TP_CD, 'X') = DECODE(NVL(CGO_TP_CD,'X'), 'X', 'X', @[full_empty])" ).append("\n"); 
		query.append("			GROUP BY CNT_CD, IO_BND_CD, TRSM_MSG_TP_ID, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL_CD, POD_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("	   ) S" ).append("\n"); 
		query.append("     , BKG_CSTMS_ADV_CNTR B" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD P2" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("        A.CNT_CD = 'US'" ).append("\n"); 
		query.append("        AND A.VSL_CD         = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("        AND A.CSTMS_POL_CD    LIKE NVL(@[pol],'%')" ).append("\n"); 
		query.append("        AND (A.CSTMS_POD_CD   LIKE NVL(@[pod],'%')" ).append("\n"); 
		query.append("        OR  A.CSTMS_POD_CD    = DECODE(@[pod],'USLAX','MXZLO',@[pod])" ).append("\n"); 
		query.append("        OR  A.CSTMS_POD_CD    = DECODE(@[pod],'USOAK','MXZLO',@[pod])" ).append("\n"); 
		query.append("        OR  A.CSTMS_POD_CD    = DECODE(@[pod],'USLAX','MXESE',@[pod]))" ).append("\n"); 
		query.append("        AND A.MF_STS_CD      = 'A'" ).append("\n"); 
		query.append("		--AND A.CSTMS_FILE_TP_CD not in ('1','2')" ).append("\n"); 
		query.append("        AND A.CNT_CD         = B.CNT_CD(+)" ).append("\n"); 
		query.append("        AND A.BL_NO          = B.BL_NO(+)" ).append("\n"); 
		query.append("        AND B.IBD_CNTR_STS_CD(+)   = 'A'" ).append("\n"); 
		query.append("        AND A.VSL_CD         = P.VSL_CD(+)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO     = P.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD     = P.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND A.CSTMS_POD_CD    = P.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("        AND A.CNT_CD         = S.CNT_CD(+)" ).append("\n"); 
		query.append("        AND A.VSL_CD         = S.VSL_CD(+)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO     = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD     = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND A.CSTMS_POD_CD    = S.POD_CD(+)" ).append("\n"); 
		query.append("        AND A.CSTMS_POL_CD    = S.POL_CD(+)" ).append("\n"); 
		query.append("		--AND S.TRSM_MSG_TP_ID(+) = 'MI'" ).append("\n"); 
		query.append("		--AND S.IO_BND_CD(+) = 'I'" ).append("\n"); 
		query.append("		--AND S.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("        AND A.VSL_CD         = P2.VSL_CD(+)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO     = P2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD     = P2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND A.CSTMS_POL_CD    = P2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     	AND EXISTS" ).append("\n"); 
		query.append("           (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("            WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("              AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND CLPT_SEQ >= ( " ).append("\n"); 
		query.append("                            SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                            WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                              AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                              AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                              AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                              AND ( VPS_PORT_CD LIKE 'US%'  OR VPS_PORT_CD LIKE 'PR%'  )" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("              AND VPS_PORT_CD = A.CSTMS_POD_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${full_empty} == 'M') " ).append("\n"); 
		query.append("		-- 2009/10/26 하동일 수석 요청, Empty코드를 E->M으로 수정." ).append("\n"); 
		query.append("		-- 613화면은 이 부분만 하드코딩하면 해결됨." ).append("\n"); 
		query.append("		and A.FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_empty} == 'F') " ).append("\n"); 
		query.append("		and (A.FULL_MTY_CD = 'F' OR A.FULL_MTY_CD = 'R' OR A.FULL_MTY_CD is null)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${customs} != '') " ).append("\n"); 
		query.append("		and A.CSTMS_PORT_CD like '%' || @[customs] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  A.VSL_CD, A.SKD_VOY_NO,  A.SKD_DIR_CD, A.CSTMS_POD_CD, A.CSTMS_POL_CD, A.CSTMS_PORT_CD," ).append("\n"); 
		query.append("      S.SND_DT,  S.TRSM_MSG_TP_ID, S.CGO_TP_CD" ).append("\n"); 
		query.append("ORDER BY A.VSL_CD" ).append("\n"); 
		query.append("#if (${pod} != '') " ).append("\n"); 
		query.append("		, CASE WHEN MAX(P2.VPS_ETD_DT) IS NULL THEN ' ' ELSE TO_CHAR(MAX(P2.VPS_ETD_DT), 'YYYY-MM-DD HH24:MI')  END " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '') " ).append("\n"); 
		query.append("		, CASE WHEN MAX(P.VPS_ETA_DT) IS NULL THEN ' ' ELSE TO_CHAR(MAX(P.VPS_ETA_DT), 'YYYY-MM-DD HH24:MI')  END " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}