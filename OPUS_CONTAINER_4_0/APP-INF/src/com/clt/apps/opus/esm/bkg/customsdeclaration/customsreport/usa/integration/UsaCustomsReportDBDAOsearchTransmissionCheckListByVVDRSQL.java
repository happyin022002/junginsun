/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.04.20 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0359 Manifest Status 조회용
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL(){
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
		params.put("min_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blmi",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER(ORDER BY MBL_NO, AMS_FILE_NO) SEQ" ).append("\n"); 
		query.append("      ,GUBUN" ).append("\n"); 
		query.append("      ,AMS_FILE_NO" ).append("\n"); 
		query.append("      ,M_F" ).append("\n"); 
		query.append("      ,FILER" ).append("\n"); 
		query.append("      ,MBL_NO" ).append("\n"); 
		query.append("      ,O_POL -- BKG POL" ).append("\n"); 
		query.append("      ,T_POL -- VVD POL" ).append("\n"); 
		query.append("      ,T_POD -- VVD POD" ).append("\n"); 
		query.append("      ,T_VVD -- BKG_VVD" ).append("\n"); 
		query.append("      ,STS" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX('Y'), 'N')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_SND_LOG E" ).append("\n"); 
		query.append("         WHERE E.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND E.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("           AND E.TRSM_MSG_TP_ID = 'MI'" ).append("\n"); 
		query.append("           AND E.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("           AND E.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND E.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND E.POL_CD     = A.POL_CD" ).append("\n"); 
		query.append("           AND E.POD_CD     = A.POD_CD" ).append("\n"); 
		query.append("       ) AS V_MI" ).append("\n"); 
		query.append("      ,MI" ).append("\n"); 
		query.append("      ,VVD -- US VVD" ).append("\n"); 
		query.append("      ,SENT_TIME" ).append("\n"); 
		query.append("      ,CURR_STAGE" ).append("\n"); 
		query.append("      ,UPDATE_DT" ).append("\n"); 
		query.append("      ,B_OFC" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,MF_STS" ).append("\n"); 
		query.append("      ,USER_ACTION" ).append("\n"); 
		query.append("      ,T_VVD2" ).append("\n"); 
		query.append("      ,T_POL2" ).append("\n"); 
		query.append("      ,FILER2" ).append("\n"); 
		query.append("      ,' ' TMP1" ).append("\n"); 
		query.append("      ,' ' TMP2" ).append("\n"); 
		query.append("      ,' ' TMP3" ).append("\n"); 
		query.append("  FROM (SELECT '00' GUBUN" ).append("\n"); 
		query.append("              ,B.BL_NO AMS_FILE_NO" ).append("\n"); 
		query.append("              ,'M' M_F" ).append("\n"); 
		query.append("              ,B.USA_CSTMS_FILE_CD FILER" ).append("\n"); 
		query.append("              ,B.BL_NO MBL_NO" ).append("\n"); 
		query.append("              ,B.POL_CD O_POL" ).append("\n"); 
		query.append("              ,A.POL_CD T_POL" ).append("\n"); 
		query.append("              ,A.POD_CD T_POD" ).append("\n"); 
		query.append("              ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append("              ,B.BKG_STS_CD STS" ).append("\n"); 
		query.append("              ,DECODE(F.MF_SND_DT, NULL, 'N', 'Y') MI" ).append("\n"); 
		query.append("              ,F.VSL_CD || F.SKD_VOY_NO || F.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI') SENT_TIME" ).append("\n"); 
		query.append("              ,F.CSTMS_MF_TP_CD CURR_STAGE" ).append("\n"); 
		query.append("              ,DECODE(F.CSTMS_MF_TP_CD, 'MI', TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI'), 'AI', TO_CHAR(F.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')) UPDATE_DT" ).append("\n"); 
		query.append("              ,B.BKG_OFC_CD B_OFC" ).append("\n"); 
		query.append("              ,D.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("              ,CASE WHEN F.MF_SND_DT IS NOT NULL AND F.AMDT_SND_DT IS NULL THEN" ).append("\n"); 
		query.append("                         'Sent By MI'" ).append("\n"); 
		query.append("                    WHEN F.MF_SND_DT IS NOT NULL AND F.AMDT_SND_DT IS NOT NULL THEN" ).append("\n"); 
		query.append("                         'Sent By MI'" ).append("\n"); 
		query.append("                    WHEN F.MF_SND_DT IS NULL AND F.AMDT_SND_DT IS NOT NULL THEN" ).append("\n"); 
		query.append("                         'Added By AI'" ).append("\n"); 
		query.append("                    WHEN F.MF_SND_DT IS NULL AND F.AMDT_SND_DT IS NULL THEN" ).append("\n"); 
		query.append("                         'Un-Manifested'" ).append("\n"); 
		query.append("                    ELSE 'Error'" ).append("\n"); 
		query.append("                END MF_STS" ).append("\n"); 
		query.append("              ,CASE WHEN F.VSL_CD IS NULL THEN" ).append("\n"); 
		query.append("                         'ADD'" ).append("\n"); 
		query.append("                    ELSE 'None'" ).append("\n"); 
		query.append("                END USER_ACTION" ).append("\n"); 
		query.append("              ,'' T_VVD2, '' T_POL2, '' FILER2" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.POL_CD" ).append("\n"); 
		query.append("              ,A.POD_CD" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("         FROM BKG_VVD A" ).append("\n"); 
		query.append("             ,BKG_BOOKING B" ).append("\n"); 
		query.append("             ,BKG_BL_DOC C" ).append("\n"); 
		query.append("             ,BKG_CONTAINER D" ).append("\n"); 
		query.append("             ,BKG_CSTMS_ADV_BL F" ).append("\n"); 
		query.append("        WHERE A.VSL_CD                = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO            = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD            = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("          AND A.POL_CD                = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("          AND A.POD_CD               = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND B.BKG_NO                = A.BKG_NO" ).append("\n"); 
		query.append("          AND B.BKG_CGO_TP_CD         IN ('R', 'F')" ).append("\n"); 
		query.append("          AND B.BKG_STS_CD            <> 'X'" ).append("\n"); 
		query.append("#if (${bofc} != '')" ).append("\n"); 
		query.append("          AND B.BKG_OFC_CD            = @[bofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND C.BKG_NO                = B.BKG_NO" ).append("\n"); 
		query.append("          AND D.BKG_NO(+)             = C.BKG_NO" ).append("\n"); 
		query.append("          AND F.CNT_CD(+)             = 'US'" ).append("\n"); 
		query.append("          AND F.BL_NO(+)              = B.BL_NO" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("        SELECT TO_CHAR(G.HBL_SEQ)" ).append("\n"); 
		query.append("              ,G.CNTR_MF_NO AMS_FILE_NO" ).append("\n"); 
		query.append("              ,'H'" ).append("\n"); 
		query.append("              ,'0' FILER" ).append("\n"); 
		query.append("              ,B.BL_NO MBL_NO" ).append("\n"); 
		query.append("              ,B.POL_CD O_POL" ).append("\n"); 
		query.append("              ,A.POL_CD T_POL" ).append("\n"); 
		query.append("              ,A.POD_CD T_POD" ).append("\n"); 
		query.append("              ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append("              ,B.BKG_STS_CD STS" ).append("\n"); 
		query.append("              ,DECODE(F.MF_SND_DT, NULL, 'N', 'Y') MI" ).append("\n"); 
		query.append("              ,F.VSL_CD || F.SKD_VOY_NO || F.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI') SENT_TIME" ).append("\n"); 
		query.append("              ,F.CSTMS_MF_TP_CD CURR_STAGE" ).append("\n"); 
		query.append("              ,DECODE(F.CSTMS_MF_TP_CD, 'MI', TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI'), 'AI', TO_CHAR(F.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')) UPDATE_DT" ).append("\n"); 
		query.append("              ,B.BKG_OFC_CD B_OFC" ).append("\n"); 
		query.append("              ,D.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("              ,CASE WHEN F.MF_SND_DT IS NOT NULL AND F.AMDT_SND_DT IS NULL THEN" ).append("\n"); 
		query.append("                         'Sent By MI'" ).append("\n"); 
		query.append("                    WHEN F.MF_SND_DT IS NOT NULL AND F.AMDT_SND_DT IS NOT NULL THEN" ).append("\n"); 
		query.append("                         'Sent By MI'" ).append("\n"); 
		query.append("                    WHEN F.MF_SND_DT IS NULL AND F.AMDT_SND_DT IS NOT NULL THEN" ).append("\n"); 
		query.append("                         'Added By AI'" ).append("\n"); 
		query.append("                    WHEN F.MF_SND_DT IS NULL AND F.AMDT_SND_DT IS NULL THEN" ).append("\n"); 
		query.append("                         'Un-Manifested'" ).append("\n"); 
		query.append("                    ELSE 'Error'" ).append("\n"); 
		query.append("                END MF_STS" ).append("\n"); 
		query.append("              ,CASE WHEN F.VSL_CD IS NULL THEN" ).append("\n"); 
		query.append("                         'ADD'" ).append("\n"); 
		query.append("                    ELSE 'None'" ).append("\n"); 
		query.append("                END USER_ACTION" ).append("\n"); 
		query.append("              ,'' t_vvd2, '' t_pol2, '' filer2" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.POL_CD" ).append("\n"); 
		query.append("              ,A.POD_CD" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("          FROM BKG_VVD A" ).append("\n"); 
		query.append("              ,BKG_BOOKING B" ).append("\n"); 
		query.append("              ,BKG_BL_DOC C" ).append("\n"); 
		query.append("              ,BKG_HBL G" ).append("\n"); 
		query.append("              ,BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_BL F" ).append("\n"); 
		query.append("         WHERE A.VSL_CD                = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO            = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD            = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("           AND A.POL_CD                = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("           AND A.POD_CD                = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND B.BKG_NO                = A.BKG_NO" ).append("\n"); 
		query.append("           AND B.BKG_CGO_TP_CD            IN ('R', 'F')" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD            <> 'X'" ).append("\n"); 
		query.append("#if (${bofc} != '')" ).append("\n"); 
		query.append("           AND B.BKG_OFC_CD            = @[bofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND C.BKG_NO                = B.BKG_NO" ).append("\n"); 
		query.append("           --as-IS에서는 아래 조건이 사용되나, TO-BE에서 다운로드 화면과 조회수량이 차이가 나므로 아래 조건을 블록한다." ).append("\n"); 
		query.append("           -- 20100531 블록을 다시 활성화" ).append("\n"); 
		query.append("           AND B.USA_CSTMS_FILE_CD     = '1'" ).append("\n"); 
		query.append("           AND G.BKG_NO                = C.BKG_NO" ).append("\n"); 
		query.append("           AND F.CNT_CD(+)                = 'US'" ).append("\n"); 
		query.append("           AND F.BL_NO(+)                = G.CNTR_MF_NO" ).append("\n"); 
		query.append("           AND F.BKG_NO(+)                = G.BKG_NO" ).append("\n"); 
		query.append("           AND D.BKG_NO(+)                = G.BKG_NO" ).append("\n"); 
		query.append("           AND D.CNTR_MF_NO(+)            = G.CNTR_MF_NO" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("     ,(SELECT A.CNT_CD" ).append("\n"); 
		query.append("              ,A.SND_DATE" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.POL_CD" ).append("\n"); 
		query.append("              ,A.POD_CD" ).append("\n"); 
		query.append("              ,A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("              ,A.BL_NO" ).append("\n"); 
		query.append("              ,B.MF_SND_DT" ).append("\n"); 
		query.append("              ,B.AMDT_SND_DT" ).append("\n"); 
		query.append("              ,B.CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("         FROM (SELECT DISTINCT" ).append("\n"); 
		query.append("                       L.CNT_CD" ).append("\n"); 
		query.append("                      ,L.IO_BND_CD" ).append("\n"); 
		query.append("                      ,L.SND_DT AS SND_DATE" ).append("\n"); 
		query.append("                      ,L.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                      ,L.VSL_CD || L.SKD_VOY_NO || L.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,L.VSL_CD" ).append("\n"); 
		query.append("                      ,L.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,L.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,NVL(E.POL_CD, L.POL_CD) AS POL_CD" ).append("\n"); 
		query.append("                      ,NVL(E.POD_CD, L.POD_CD) AS POD_CD" ).append("\n"); 
		query.append("                      ,L.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN TRSM_MSG_TP_ID = 'MI' THEN ''" ).append("\n"); 
		query.append("                            ELSE E.BL_NO" ).append("\n"); 
		query.append("                       END BL_NO" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_ADV_SND_LOG     L" ).append("\n"); 
		query.append("                     ,BKG_CSTMS_ADV_EDI_BL_RSPN E" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND L.CNT_CD = E.CNT_CD(+)" ).append("\n"); 
		query.append("                  AND L.CRR_BAT_NO = E.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("                  AND L.CNT_CD = 'US'" ).append("\n"); 
		query.append("                  AND L.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                  AND L.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                  AND L.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                  AND L.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("            ,BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.CNT_CD    = B.CNT_CD(+)" ).append("\n"); 
		query.append("            AND A.BL_NO     = B.BL_NO(+)" ).append("\n"); 
		query.append("            AND A.VSL_CD        = B.VSL_CD(+)" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO    = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD    = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("            AND A.POL_CD = B.CSTMS_POL_CD(+)" ).append("\n"); 
		query.append("            AND A.POD_CD = B.CSTMS_POD_CD(+)  " ).append("\n"); 
		query.append("       ) HIS" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.T_POD      = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("   AND SKD.CLPT_SEQ >= @[min_seq]" ).append("\n"); 
		query.append("#if (${allerror} != 'ALL')" ).append("\n"); 
		query.append("   AND VVD != T_VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${blmi} == 'Manifested')" ).append("\n"); 
		query.append("   AND (mf_sts = 'Sent By MI' OR mf_sts = 'Added By AI')" ).append("\n"); 
		query.append("#elseif (${blmi} != '')" ).append("\n"); 
		query.append("   AND mf_sts = @[blmi]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE FM_BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                    AND BL_NO_TP = '9'" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("   AND A.VSL_CD     = HIS.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = HIS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = HIS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.MBL_NO     = HIS.BL_NO(+)" ).append("\n"); 
		query.append("ORDER BY MBL_NO, GUBUN" ).append("\n"); 

	}
}