/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupNtcListByManualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.05.11 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park, Mi-Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOsearchPkupNtcListByManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manually Pickup Notice를 송부할 대상(Container) 상세 정보를 조회한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupNtcListByManualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupNtcListByManualRSQL").append("\n"); 
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
		query.append("-- PkupNtcManualListVO 생성" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       DECODE(A.BKG_NO,NULL,'Y','N') AS ERR_FLAG" ).append("\n"); 
		query.append("      ,B.BL_NO" ).append("\n"); 
		query.append("      ,A.BKG_NO " ).append("\n"); 
		query.append("      ,A.CNTR_NO   " ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD       " ).append("\n"); 
		query.append("      ,A.VVD" ).append("\n"); 
		query.append("      ,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("      ,A.OBL_CLT_FLG" ).append("\n"); 
		query.append("      ,A.CSTMS_CLR_FLG" ).append("\n"); 
		query.append("      ,A.POD_CD " ).append("\n"); 
		query.append("      ,A.DEL_CD" ).append("\n"); 
		query.append("      ,A.DE_TERM_CD     " ).append("\n"); 
		query.append("      ,A.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,A.PKUP_NO" ).append("\n"); 
		query.append("      ,A.PKUP_AVAL_DT" ).append("\n"); 
		query.append("      ,A.LST_FREE_DT" ).append("\n"); 
		query.append("      ,A.PKUP_YD_CD" ).append("\n"); 
		query.append("      ,A.RTN_YD_CD" ).append("\n"); 
		query.append("      ,A.IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("      ,A.PKUP_NTC_SND_KNT" ).append("\n"); 
		query.append("      ,A.RAIL_ARR_DT" ).append("\n"); 
		query.append("      ,A.RAIL_DEP_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("              ,B.PKUP_NO" ).append("\n"); 
		query.append("              ,B.PKUP_AVAL_DT" ).append("\n"); 
		query.append("              ,B.LST_FREE_DT" ).append("\n"); 
		query.append("              ,B.PKUP_YD_CD" ).append("\n"); 
		query.append("              ,B.RTN_YD_CD" ).append("\n"); 
		query.append("              ,B.PKUP_NTC_SND_KNT" ).append("\n"); 
		query.append("              ,B.RAIL_ARR_DT" ).append("\n"); 
		query.append("              ,B.RAIL_DEP_DT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT B.BL_NO" ).append("\n"); 
		query.append("                      ,B.BKG_NO " ).append("\n"); 
		query.append("                      ,C.CNTR_NO       " ).append("\n"); 
		query.append("                      ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      ,B.VSL_CD" ).append("\n"); 
		query.append("                      ,B.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,B.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,B.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("                      ,B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                      ,D.FRT_CLT_FLG" ).append("\n"); 
		query.append("                      ,D.OBL_RDEM_FLG AS OBL_CLT_FLG" ).append("\n"); 
		query.append("                      ,(CASE WHEN SUBSTR(B.POD_CD,1,2) = 'CA' THEN                  " ).append("\n"); 
		query.append("                                  (SELECT SUBSTR(MAX(LPAD(CSTMS_SEQ,12,'0')||CSTMS_CLR_CD),-1)" ).append("\n"); 
		query.append("                                     FROM BKG_CSTMS_ADV_CNTR_RSLT CN_RSLT" ).append("\n"); 
		query.append("                                    WHERE CNT_CD  = 'US'" ).append("\n"); 
		query.append("                                      AND BL_NO   = B.BL_NO" ).append("\n"); 
		query.append("                                      AND CN_RSLT.CNTR_NO LIKE SUBSTR(C.CNTR_NO,1,LENGTH(C.CNTR_NO)-1)||'%')" ).append("\n"); 
		query.append("                             ELSE NVL(D.CSTMS_CLR_CD,'N')" ).append("\n"); 
		query.append("                        END) AS CSTMS_CLR_FLG" ).append("\n"); 
		query.append("                      ,B.POD_CD " ).append("\n"); 
		query.append("                      ,B.DEL_CD" ).append("\n"); 
		query.append("                      ,B.DE_TERM_CD" ).append("\n"); 
		query.append("                      ,E.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("                      ,I.HUB_LOC_CD AS IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING      B" ).append("\n"); 
		query.append("                      ,BKG_CONTAINER    C" ).append("\n"); 
		query.append("                      ,BKG_CGO_RLSE     D" ).append("\n"); 
		query.append("                      ,MDM_LOCATION     E" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_BL I" ).append("\n"); 
		query.append("                 WHERE B.BL_NO         IN" ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($bl_no IN ${bl_no_list})" ).append("\n"); 
		query.append("    #if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("                        '${bl_no}'," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                        '${bl_no}'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                   AND B.BKG_STS_CD    <> 'X' -- 무효한 bkg제거" ).append("\n"); 
		query.append("                   AND B.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("                   AND C.BKG_NO(+)     = B.BKG_NO" ).append("\n"); 
		query.append("                   AND D.BL_NO(+)      = B.BL_NO  " ).append("\n"); 
		query.append("                   AND E.LOC_CD        = B.DEL_CD" ).append("\n"); 
		query.append("                   AND I.CNT_CD(+)     = 'US'" ).append("\n"); 
		query.append("                   AND I.BL_NO(+)      = B.BL_NO                                                                " ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                     FROM TRS_TRSP_RAIL_BIL_ORD G" ).append("\n"); 
		query.append("                                    WHERE G.BKG_NO      = C.BKG_NO" ).append("\n"); 
		query.append("                                      AND G.EQ_NO       = C.CNTR_NO" ).append("\n"); 
		query.append("                                      AND G.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                                      AND G.DELT_FLG    = 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,BKG_PKUP_NTC_PKUP_NO  B" ).append("\n"); 
		query.append("         WHERE B.BKG_NO(+)         = A.BKG_NO" ).append("\n"); 
		query.append("           AND B.CNTR_NO(+)        = A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($bl_no IN ${bl_no_list})" ).append("\n"); 
		query.append("    #if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("            SELECT '${bl_no}' AS BL_NO FROM DUAL UNION ALL" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("            SELECT '${bl_no}' AS BL_NO FROM DUAL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE A.BL_NO(+)   = B.BL_NO" ).append("\n"); 

	}
}