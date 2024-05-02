/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeDetailByBSTDownloadCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOaddCustAdvisoryNoticeDetailByBSTDownloadCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addCustAdvisoryNoticeDetailByBSTDownload
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOaddCustAdvisoryNoticeDetailByBSTDownloadCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeDetailByBSTDownloadCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_AVC_NTC_DTL (BL_NO,BKG_CUST_TP_CD,FAX_NO,NTC_EML,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT, SRC_DAT_TP_CD)" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.BL_NO          " ).append("\n"); 
		query.append("     , A.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , A.CUST_FAX_NO" ).append("\n"); 
		query.append("     , A.CUST_EML" ).append("\n"); 
		query.append("     , @[cre_usr_id]    AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE          AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id]    AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE          AS UPD_DT" ).append("\n"); 
		query.append("     ,'B'				AS SRC_DAT_TP_CD" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("		SELECT   BKG_NO" ).append("\n"); 
		query.append("        		,BL_NO" ).append("\n"); 
		query.append("		        ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("        		,MAX(DECODE(BKG_CUST_TP_CD,'S',NVL(NVL(SHPR_SI_FAX_NO,SHPR_BK_FAX_NO),CUST_FAX_NO),CUST_FAX_NO)) CUST_FAX_NO" ).append("\n"); 
		query.append("		        ,MAX(DECODE(BKG_CUST_TP_CD,'S',NVL(NVL(SHPR_SI_EML,SHPR_BK_EML),CUST_EML),CUST_EML)) CUST_EML" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("				 SELECT BK.BKG_NO" ).append("\n"); 
		query.append("        		      , BK.BL_NO                " ).append("\n"); 
		query.append("		              , BC.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("		              , NVL(BC.CUST_FAX_NO,CP.FAX_NO) AS CUST_FAX_NO" ).append("\n"); 
		query.append("		              , NVL(BC.CUST_EML,CP.CUST_EML)  AS CUST_EML" ).append("\n"); 
		query.append("		              , DECODE(BP.BKG_CNTC_PSON_TP_CD,'BK',BP.CNTC_PSON_FAX_NO) AS SHPR_BK_FAX_NO" ).append("\n"); 
		query.append("		              , DECODE(BP.BKG_CNTC_PSON_TP_CD,'SI',BP.CNTC_PSON_FAX_NO) AS SHPR_SI_FAX_NO" ).append("\n"); 
		query.append("		              , DECODE(BP.BKG_CNTC_PSON_TP_CD,'BK',BP.CNTC_PSON_EML) AS SHPR_BK_EML" ).append("\n"); 
		query.append("		              , DECODE(BP.BKG_CNTC_PSON_TP_CD,'SI',BP.CNTC_PSON_EML) AS SHPR_SI_EML" ).append("\n"); 
		query.append("		         FROM ( SELECT DISTINCT BK.BKG_NO, BK.BL_NO                   " ).append("\n"); 
		query.append("		                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("		                     , BKG_VVD     BV" ).append("\n"); 
		query.append("		                 WHERE BV.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("		                   AND BV.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("		                   AND BV.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("		                   AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("		                   AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("		                   AND BK.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("						   AND NOT EXISTS (SELECT '*' FROM BKG_CUST_AVC_NTC_DTL A " ).append("\n"); 
		query.append("												WHERE A.SRC_DAT_TP_CD = 'B'" ).append("\n"); 
		query.append("                								AND A.BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("                							)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		              ) BV " ).append("\n"); 
		query.append("		              , BKG_BOOKING       BK" ).append("\n"); 
		query.append("		              , BKG_CUSTOMER      BC" ).append("\n"); 
		query.append("		              , MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("					  , BKG_CNTC_PSON     BP" ).append("\n"); 
		query.append("		        WHERE BK.BL_NO           = BV.BL_NO" ).append("\n"); 
		query.append("		        AND   BK.BKG_STS_CD     <>'X'" ).append("\n"); 
		query.append("		        AND   BK.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("		        AND   BC.BKG_NO          = BK.BKG_NO" ).append("\n"); 
		query.append("		        AND   BC.BKG_CUST_TP_CD  IN ( 'S','C','N' )" ).append("\n"); 
		query.append("		        AND   CP.CUST_CNT_CD(+)       = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("		        AND   CP.CUST_SEQ(+)          = BC.CUST_SEQ " ).append("\n"); 
		query.append("		        AND   CP.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("		        AND   BC.BKG_NO = BP.BKG_NO(+)" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		GROUP BY BKG_NO, BL_NO, BKG_CUST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Contract customer " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("F.BKG_NO" ).append("\n"); 
		query.append(",F.BL_NO" ).append("\n"); 
		query.append(",'T'" ).append("\n"); 
		query.append(", (SELECT FAX_NO FROM MDM_CUST_CNTC_PNT WHERE CUST_CNT_CD = SUBSTR(F.CTRT_CUST_CD,1,2) AND CUST_SEQ = SUBSTR(F.CTRT_CUST_CD,3,8)) CUST_FAX_NO" ).append("\n"); 
		query.append(", (SELECT CUST_EML FROM MDM_CUST_CNTC_PNT WHERE CUST_CNT_CD = SUBSTR(F.CTRT_CUST_CD,1,2) AND CUST_SEQ = SUBSTR(F.CTRT_CUST_CD,3,8)) CUST_EML" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" Distinct T.BKG_NO,T.BL_NO, T.RFA_NO, T.TAA_NO, T.SC_NO," ).append("\n"); 
		query.append("    CASE WHEN T.RFA_NO IS NOT NULL THEN RFA_CUST_CD" ).append("\n"); 
		query.append("         WHEN T.TAA_NO IS NOT NULL THEN TAA_CUST_CD" ).append("\n"); 
		query.append("         WHEN T.SC_NO IS NOT NULL THEN SC_CUST_CD" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("    END CTRT_CUST_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("                BK.BKG_NO" ).append("\n"); 
		query.append("              , BK.BL_NO                " ).append("\n"); 
		query.append("              , 'T'" ).append("\n"); 
		query.append("              , NVL(BC.CUST_FAX_NO,CP.FAX_NO) AS CUST_FAX_NO" ).append("\n"); 
		query.append("              , NVL(BC.CUST_EML,CP.CUST_EML)  AS CUST_EML" ).append("\n"); 
		query.append("              , BK.RFA_NO, BK.TAA_NO, BK.SC_NO" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT NVL(CTRT_CUST_CNT_CD,'00')||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_RP_MN" ).append("\n"); 
		query.append("            WHERE (PROP_NO, AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                            SELECT MAX(A2.PROP_NO), MAX(A2.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                  FROM PRI_RP_HDR A1" ).append("\n"); 
		query.append("                                                      ,PRI_RP_MN  A2" ).append("\n"); 
		query.append("                                            WHERE A1.PROP_NO     = A2.PROP_NO" ).append("\n"); 
		query.append("                                            AND A2.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                            AND A1.RFA_NO = BK.RFA_NO" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("        ) RFA_CUST_CD      " ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT NVL(CTRT_CUST_CNT_CD,'00')||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_TAA_MN" ).append("\n"); 
		query.append("            WHERE (TAA_PROP_NO, AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                            SELECT MAX(A2.TAA_PROP_NO), MAX(A2.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                  FROM PRI_TAA_HDR A1" ).append("\n"); 
		query.append("                                                      ,PRI_TAA_MN  A2" ).append("\n"); 
		query.append("                                            WHERE A1.TAA_PROP_NO      = A2.TAA_PROP_NO " ).append("\n"); 
		query.append("                                            AND A2.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                            AND A1.TAA_NO = BK.TAA_NO" ).append("\n"); 
		query.append("                                        )    " ).append("\n"); 
		query.append("        ) TAA_CUST_CD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("             SELECT NVL(NVL(B.REAL_CUST_CNT_CD, C.CUST_CNT_CD),'00')||TRIM(TO_CHAR(NVL(B.REAL_CUST_SEQ, C.CUST_SEQ),'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_SP_HDR A" ).append("\n"); 
		query.append("                      ,PRI_SP_MN B" ).append("\n"); 
		query.append("                      ,PRI_SP_CTRT_PTY C" ).append("\n"); 
		query.append("            WHERE A.PROP_NO     = B.PROP_NO" ).append("\n"); 
		query.append("               AND B.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("               AND B.PROP_NO     = C.PROP_NO" ).append("\n"); 
		query.append("               --AND A.SC_NO = 'AWN101098'" ).append("\n"); 
		query.append("               AND  (B.PROP_NO , B.AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                            SELECT MAX(B.PROP_NO ), MAX(B.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                  FROM PRI_SP_HDR A" ).append("\n"); 
		query.append("                                                      ,PRI_SP_MN B" ).append("\n"); 
		query.append("                                                      " ).append("\n"); 
		query.append("                                            WHERE A.PROP_NO     = B.PROP_NO" ).append("\n"); 
		query.append("                                               AND B.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                               " ).append("\n"); 
		query.append("                                               AND A.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("            AND B.AMDT_SEQ    = C.AMDT_SEQ" ).append("\n"); 
		query.append("            AND C.PRC_CTRT_PTY_TP_CD = 'C'  " ).append("\n"); 
		query.append("        ) SC_CUST_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         FROM ( " ).append("\n"); 
		query.append("                SELECT DISTINCT BK.BKG_NO, BK.BL_NO                   " ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , BKG_VVD     BV" ).append("\n"); 
		query.append("                 WHERE BV.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("                   AND BV.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("                   AND BV.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("                   AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                   AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("                   AND BK.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   AND NOT EXISTS (SELECT '*' FROM BKG_CUST_AVC_NTC_DTL A " ).append("\n"); 
		query.append("										WHERE A.SRC_DAT_TP_CD = 'B'" ).append("\n"); 
		query.append("                						AND A.BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("                					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ) BV " ).append("\n"); 
		query.append("              , BKG_BOOKING       BK" ).append("\n"); 
		query.append("              , BKG_CUSTOMER      BC" ).append("\n"); 
		query.append("              , MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("        WHERE BK.BL_NO           = BV.BL_NO" ).append("\n"); 
		query.append("               AND   BK.BKG_STS_CD     <>'X'" ).append("\n"); 
		query.append("        AND   BK.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("        AND   BC.BKG_NO          = BK.BKG_NO" ).append("\n"); 
		query.append("        AND   BC.BKG_CUST_TP_CD  IN ( 'S','C','N' )" ).append("\n"); 
		query.append("        AND   CP.CUST_CNT_CD(+)       = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND   CP.CUST_SEQ(+)          = BC.CUST_SEQ " ).append("\n"); 
		query.append("        AND   CP.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("        ) T" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ) F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}