/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndCustomsReportDBDAOsearchCndAdviceNotesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.24 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsReportDBDAOsearchCndAdviceNotesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndAdviceNotes
	  * </pre>
	  */
	public CndCustomsReportDBDAOsearchCndAdviceNotesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mtch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsReportDBDAOsearchCndAdviceNotesRSQL").append("\n"); 
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
		query.append("SELECT  TB.*" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("SELECT  A.*" ).append("\n"); 
		query.append("       ,DECODE(TRIM(C.CUST_CNT_CD), NULL, '', C.CUST_CNT_CD || LPAD(C.CUST_SEQ, 6, '0')) AS CUST_SEQ" ).append("\n"); 
		query.append("       ,C.CUST_NM" ).append("\n"); 
		query.append("       ,D1.FAX_NO AS FAX_NO1" ).append("\n"); 
		query.append("       ,D2.FAX_NO AS FAX_NO2" ).append("\n"); 
		query.append("       ,D3.FAX_NO AS FAX_NO3" ).append("\n"); 
		query.append("       ,D4.FAX_NO AS FAX_NO4" ).append("\n"); 
		query.append("       ,D5.FAX_NO AS FAX_NO5" ).append("\n"); 
		query.append("       ,D1.FAX_SND_FLG AS FAX_SND_FLG1" ).append("\n"); 
		query.append("       ,D2.FAX_SND_FLG AS FAX_SND_FLG2" ).append("\n"); 
		query.append("       ,D3.FAX_SND_FLG AS FAX_SND_FLG3" ).append("\n"); 
		query.append("       ,D4.FAX_SND_FLG AS FAX_SND_FLG4" ).append("\n"); 
		query.append("       ,D5.FAX_SND_FLG AS FAX_SND_FLG5" ).append("\n"); 
		query.append("       ,TO_CHAR(FAX.SND_DT, 'YYYY-MM-DD HH24:MI') AS FAX_SND_DT" ).append("\n"); 
		query.append("       ,E1.NTC_EML AS NTC_EML1" ).append("\n"); 
		query.append("       ,E2.NTC_EML AS NTC_EML2" ).append("\n"); 
		query.append("       ,E3.NTC_EML AS NTC_EML3" ).append("\n"); 
		query.append("       ,E4.NTC_EML AS NTC_EML4" ).append("\n"); 
		query.append("       ,E5.NTC_EML AS NTC_EML5" ).append("\n"); 
		query.append("       ,E1.EML_SND_FLG AS EML_SND_FLG1" ).append("\n"); 
		query.append("       ,E2.EML_SND_FLG AS EML_SND_FLG2" ).append("\n"); 
		query.append("       ,E3.EML_SND_FLG AS EML_SND_FLG3" ).append("\n"); 
		query.append("       ,E4.EML_SND_FLG AS EML_SND_FLG4" ).append("\n"); 
		query.append("       ,E5.EML_SND_FLG AS EML_SND_FLG5" ).append("\n"); 
		query.append("       ,TO_CHAR(EML.SND_DT, 'YYYY-MM-DD HH24:MI') AS EML_SND_DT" ).append("\n"); 
		query.append("       ,FAX.SND_USR_ID AS FAX_SND_USR_ID" ).append("\n"); 
		query.append("       ,EML.SND_USR_ID AS EML_SND_USR_ID" ).append("\n"); 
		query.append("       ,U1.USR_NM AS FAX_SND_USR_NM" ).append("\n"); 
		query.append("       ,U2.USR_NM AS EML_SND_USR_NM" ).append("\n"); 
		query.append("       ,FAX.BKG_NTC_SND_RSLT_CD AS FAX_PROC_STS_CD" ).append("\n"); 
		query.append("       ,EML.BKG_NTC_SND_RSLT_CD AS EML_PROC_STS_CD" ).append("\n"); 
		query.append("       ,DECODE(BC.VAL_USR_ID, NULL, 'N', 'Y') AS CHK_FLG" ).append("\n"); 
		query.append("       ,TO_CHAR(Z.VPS_ETA_DT, 'YYYY-MM-DD') AS ETA_DT" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND D1.FAX_NO IS NOT NULL AND D1.FAX_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END FAX_FLG1" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND D2.FAX_NO IS NOT NULL AND D2.FAX_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END FAX_FLG2" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND D3.FAX_NO IS NOT NULL AND D3.FAX_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END FAX_FLG3" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND D4.FAX_NO IS NOT NULL AND D4.FAX_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END FAX_FLG4" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND D5.FAX_NO IS NOT NULL AND D5.FAX_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END FAX_FLG5" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND E1.NTC_EML IS NOT NULL AND E1.EML_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END EML_FLG1" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND E2.NTC_EML IS NOT NULL AND E2.EML_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END EML_FLG2" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND E3.NTC_EML IS NOT NULL AND E3.EML_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END EML_FLG3" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND E4.NTC_EML IS NOT NULL AND E4.EML_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END EML_FLG4" ).append("\n"); 
		query.append("       ,CASE WHEN BC.VAL_USR_ID IS NOT NULL AND E5.NTC_EML IS NOT NULL AND E5.EML_SND_FLG = 'Y' THEN '0'" ).append("\n"); 
		query.append("             ELSE '0'" ).append("\n"); 
		query.append("        END EML_FLG5" ).append("\n"); 
		query.append("       ,'C1' AS CUST_CNTC_TP_CD1" ).append("\n"); 
		query.append("       ,'C2' AS CUST_CNTC_TP_CD2" ).append("\n"); 
		query.append("       ,'B1' AS CUST_CNTC_TP_CD3" ).append("\n"); 
		query.append("       ,'B2' AS CUST_CNTC_TP_CD4" ).append("\n"); 
		query.append("       ,'AN' AS CUST_CNTC_TP_CD5" ).append("\n"); 
		query.append("       ,''  AS CNTR_NO" ).append("\n"); 
		query.append("       ,'0' AS CHK" ).append("\n"); 
		query.append("       ,''  AS Attach_Max_Cnt" ).append("\n"); 
		query.append("       ,''  AS Attach_Flg" ).append("\n"); 
		query.append("       ,DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C') AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER(PARTITION BY A.BL_NO ORDER BY A.BL_NO, FAX.HIS_SEQ DESC, EML.HIS_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("         SELECT  A.CNT_CD" ).append("\n"); 
		query.append("                ,A.BL_NO" ).append("\n"); 
		query.append("                ,A.BKG_NO" ).append("\n"); 
		query.append("                ,A.POR_CD" ).append("\n"); 
		query.append("                ,A.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("                ,A.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("                ,A.DEL_CD" ).append("\n"); 
		query.append("                ,A.HUB_LOC_CD" ).append("\n"); 
		query.append("                ,A.TRSP_MOD_ID" ).append("\n"); 
		query.append("                ,A.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("                ,A.AVC_NOTE_TP_ID" ).append("\n"); 
		query.append("                ,A.FAX_OFC_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,CASE WHEN COUNT(B.CNTR_NO) = 0  THEN 'NO'" ).append("\n"); 
		query.append("                      WHEN COUNT(B.CNTR_NO) = SUM(DECODE(TRIM(B.USA_IB_TRSP_NO), NULL, 0, 1)) THEN 'AC'" ).append("\n"); 
		query.append("                      WHEN COUNT(B.CNTR_NO) > SUM(DECODE(TRIM(B.USA_IB_TRSP_NO), NULL, 0, 1)) AND SUM(DECODE(TRIM(B.USA_IB_TRSP_NO), NULL, 0, 1)) = 0 THEN 'NO'" ).append("\n"); 
		query.append("                      ELSE 'AP'" ).append("\n"); 
		query.append("                  END IT_CHK" ).append("\n"); 
		query.append("                ,CASE WHEN COUNT(DISTINCT B.USA_IB_TRSP_NO) > 1 THEN MAX(B.USA_IB_TRSP_NO) || '...'" ).append("\n"); 
		query.append("                      ELSE MAX(B.USA_IB_TRSP_NO)" ).append("\n"); 
		query.append("                  END P_MIB_NO" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                 SELECT COUNT(BKC_CNTR.CNTR_NO)" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_ADV_CNTR BKC_CNTR" ).append("\n"); 
		query.append("                  WHERE BKC_CNTR.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                    AND BKC_CNTR.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("                    AND BKC_CNTR.IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("                ) AS BL_CNTR_CNT" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                 SELECT COUNT(BKG_CNTR.BKG_NO)" ).append("\n"); 
		query.append("                   FROM  BKG_BOOKING BKG_BKG" ).append("\n"); 
		query.append("                        ,BKG_CONTAINER BKG_CNTR" ).append("\n"); 
		query.append("                   WHERE BKG_CNTR.BKG_NO = BKG_BKG.BKG_NO" ).append("\n"); 
		query.append("                     AND BKG_BKG.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("                ) AS IT_NO_CNTR_CNT" ).append("\n"); 
		query.append("           FROM  BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("                ,BKG_CSTMS_ADV_CNTR B" ).append("\n"); 
		query.append("          WHERE  A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("            AND  A.BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("            AND  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND  A.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("    #if (${sch_bl_no} != '') " ).append("\n"); 
		query.append("            AND  A.BL_NO = @[sch_bl_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("            AND  A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("            AND  A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("            AND  A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pod_cd} != '') " ).append("\n"); 
		query.append("            AND  A.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${del_cd} != '') " ).append("\n"); 
		query.append("            AND  A.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       GROUP BY  A.CNT_CD" ).append("\n"); 
		query.append("                ,A.BL_NO" ).append("\n"); 
		query.append("                ,A.BKG_NO" ).append("\n"); 
		query.append("                ,A.POR_CD" ).append("\n"); 
		query.append("                ,A.CSTMS_POL_CD" ).append("\n"); 
		query.append("                ,A.CSTMS_POD_CD" ).append("\n"); 
		query.append("                ,A.DEL_CD" ).append("\n"); 
		query.append("                ,A.HUB_LOC_CD" ).append("\n"); 
		query.append("                ,A.TRSP_MOD_ID" ).append("\n"); 
		query.append("                ,A.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("                ,A.AVC_NOTE_TP_ID" ).append("\n"); 
		query.append("                ,A.FAX_OFC_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CUST C" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL D1" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL D2" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL D3" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL D4" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL D5" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL E1" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL E2" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL E3" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL E4" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_DTL E5" ).append("\n"); 
		query.append("       ,BKG_NTC_HIS FAX" ).append("\n"); 
		query.append("       ,BKG_NTC_HIS EML" ).append("\n"); 
		query.append("       ,COM_USER U1" ).append("\n"); 
		query.append("       ,COM_USER U2" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD Z" ).append("\n"); 
		query.append("       ,BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE  A.CNT_CD                = C.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  A.BL_NO                 = C.BL_NO(+)" ).append("\n"); 
		query.append("   AND  C.BKG_CUST_TP_CD        = DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = D1.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  D1.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  D1.CUST_CNTC_TP_CD(+)   = 'C1'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = D2.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  D2.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  D2.CUST_CNTC_TP_CD(+)   = 'C2'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = D3.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  D3.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  D3.CUST_CNTC_TP_CD(+)   = 'B1'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = D4.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  D4.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  D4.CUST_CNTC_TP_CD(+)   = 'B2'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = D5.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  D5.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  D5.CUST_CNTC_TP_CD(+)   = 'AN'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = E1.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  E1.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  E1.CUST_CNTC_TP_CD(+)   = 'C1'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = E2.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  E2.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  E2.CUST_CNTC_TP_CD(+)   = 'C2'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = E3.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  E3.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  E3.CUST_CNTC_TP_CD(+)   = 'B1'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = E4.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  E4.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  E4.CUST_CNTC_TP_CD(+)   = 'B2'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = E5.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  E5.BKG_CUST_TP_CD(+)    = 'C'" ).append("\n"); 
		query.append("   AND  E5.CUST_CNTC_TP_CD(+)   = 'AN'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = FAX.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  FAX.NTC_VIA_CD(+)       = 'F'" ).append("\n"); 
		query.append("   AND  FAX.NTC_KND_CD(+)       = 'AV'" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = EML.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  EML.NTC_VIA_CD(+)       = 'M'" ).append("\n"); 
		query.append("   AND  EML.NTC_KND_CD(+)       = 'AV'" ).append("\n"); 
		query.append("   AND  FAX.SND_USR_ID          = U1.USR_ID(+)" ).append("\n"); 
		query.append("   AND  EML.SND_USR_ID          = U2.USR_ID(+)" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = BC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  A.BKG_NO                = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND  BC.BKG_CUST_TP_CD       = DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("   AND  A.VSL_CD                = Z.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO            = Z.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD            = Z.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  A.POD_CD          = Z.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND  Z.CLPT_IND_SEQ(+)       = 1 " ).append("\n"); 
		query.append("   AND  BKG.BKG_STS_CD          IN ('F','W')" ).append("\n"); 
		query.append("#if (${mtch_flg} != '') " ).append("\n"); 
		query.append("   AND  DECODE(BC.VAL_USR_ID, NULL, 'N', 'Y') = @[mtch_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append(" WHERE  TB.RNUM = 1" ).append("\n"); 

	}
}