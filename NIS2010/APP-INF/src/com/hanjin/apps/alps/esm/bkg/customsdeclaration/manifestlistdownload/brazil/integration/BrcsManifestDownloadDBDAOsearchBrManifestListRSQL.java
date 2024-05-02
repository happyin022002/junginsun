/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAOsearchBrManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAOsearchBrManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Brazil세관에서 대상 조회를 한다.
	  * searchBrManifestList
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAOsearchBrManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("br_duv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnpj_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_mid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAOsearchBrManifestListRSQL").append("\n"); 
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
		query.append("SELECT  MAIN.BL_NO " ).append("\n"); 
		query.append("      , MAIN.BL_NO MERGE_BL_NO" ).append("\n"); 
		query.append("      , MAIN.SEQ BL_GROUP" ).append("\n"); 
		query.append("      , MAIN.BKG_NO" ).append("\n"); 
		query.append("      , MAIN.BKG_CGO_TP_CD SEARCH_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	  , MAIN.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , REPLACE(MAIN.SHIPPER_CUST_NM, CHR(13)||CHR(10), ' ') SHIPPER_CUST_NM" ).append("\n"); 
		query.append("      , MAIN.OB_SHPR_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.SHPR_TAX_NO" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , REPLACE(MAIN.CONSIGNEE_CUST_NM, CHR(13)||CHR(10), ' ') CONSIGNEE_CUST_NM" ).append("\n"); 
		query.append("      , MAIN.OB_CNEE_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.CNEE_TAX_NO" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , REPLACE(MAIN.NOTIFY_CUST_NM, CHR(13)||CHR(10), ' ') NOTIFY_CUST_NM" ).append("\n"); 
		query.append("      , MAIN.OB_NTFY_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.NTFY_TAX_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , MAIN.BRZ_DECL_NO" ).append("\n"); 
		query.append("      , MAIN.OB_BRZ_DECL_NO" ).append("\n"); 
		query.append("      , MAIN.KEY_BL_NO" ).append("\n"); 
		query.append("      , MAIN.IF_FLAG" ).append("\n"); 
		query.append("      , MAIN.CNTR_NO" ).append("\n"); 
		query.append("      , MAIN.PCK_QTY" ).append("\n"); 
		query.append("      , MAIN.PCK_TP_CD" ).append("\n"); 
		query.append("      , MAIN.WEIGHT" ).append("\n"); 
		query.append("      , MAIN.WGT_UT_CD" ).append("\n"); 
		query.append("      , MAIN.MEASURE" ).append("\n"); 
		query.append("      , MAIN.MEAS_UT_CD" ).append("\n"); 
		query.append("      , MAIN.BOOKING_CMDT_NM" ).append("\n"); 
		query.append("      , MAIN.CNTR_MF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , MAIN.NCM_NO" ).append("\n"); 
		query.append("      , DECODE(MAIN.NCM_NO,NULL,0,1) NCM_MULTI_POP" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("           SELECT  CASE WHEN COUNT(1) > 1 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM    BKG_CSTMS_BRZ_CNTR_MF_DTL" ).append("\n"); 
		query.append("           WHERE   1 = 1" ).append("\n"); 
		query.append("           AND     BL_NO = MAIN.BL_NO" ).append("\n"); 
		query.append("           AND     CNTR_NO = MAIN.CNTR_NO" ).append("\n"); 
		query.append("           AND     CNTR_MF_SEQ = MAIN.CNTR_MF_SEQ" ).append("\n"); 
		query.append("        ) NCM_MULTI_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , CASE " ).append("\n"); 
		query.append("            WHEN IF_FLAG = 'Y' " ).append("\n"); 
		query.append("                THEN " ).append("\n"); 
		query.append("                    NVL(BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("                                  SELECT  BRZ_CMDT_CD" ).append("\n"); 
		query.append("                                  FROM    BKG_CSTMS_BRZ_CNTR_MF_DTL" ).append("\n"); 
		query.append("                                  WHERE   1 = 1" ).append("\n"); 
		query.append("                                  AND     BL_NO = MAIN.BL_NO" ).append("\n"); 
		query.append("                                  AND     CNTR_NO = MAIN.CNTR_NO" ).append("\n"); 
		query.append("                                  AND     CNTR_MF_SEQ = MAIN.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        ),'')       " ).append("\n"); 
		query.append("                ELSE " ).append("\n"); 
		query.append("                    NVL(BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("                                  SELECT  NCM_NO" ).append("\n"); 
		query.append("                                  FROM    BKG_CNTR_MF_DESC_DTL" ).append("\n"); 
		query.append("                                  WHERE   1 = 1" ).append("\n"); 
		query.append("                                  AND     BKG_NO = MAIN.BKG_NO" ).append("\n"); 
		query.append("                                  AND     CNTR_NO = MAIN.CNTR_NO" ).append("\n"); 
		query.append("                                  AND     CNTR_MF_SEQ = MAIN.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        ),'')       " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("        END AS NCM_MULTI_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , (  SELECT  Z.CMDT_DESC                                          " ).append("\n"); 
		query.append("           FROM    BKG_CSTMS_CMDT Z                                      " ).append("\n"); 
		query.append("           WHERE   Z.CNT_CD = 'BR'                                        " ).append("\n"); 
		query.append("           AND     Z.MF_CMDT_CD = MAIN.NCM_NO" ).append("\n"); 
		query.append("        ) CSTMS_DESC" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("	  , VVD VVD_CD" ).append("\n"); 
		query.append("	  , POL POL_CD" ).append("\n"); 
		query.append("	  , POD POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      , NVL(@[vvd_cd], '') VVD_CD" ).append("\n"); 
		query.append("	  , NVL(@[pol_cd], '') POL_CD" ).append("\n"); 
		query.append("	  , NVL(@[pod_cd], '') POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      , OFT" ).append("\n"); 
		query.append("      , CAP" ).append("\n"); 
		query.append("      , DEL_CD" ).append("\n"); 
		query.append("      , NVL(BR_DUV, ' ') BR_DUV" ).append("\n"); 
		query.append("      , NVL(BR_MID, ' ') BR_MID" ).append("\n"); 
		query.append("      , IB_TS_YN , OB_TS_YN" ).append("\n"); 
		query.append("      , WPM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("           SELECT  SUB1.BL_NO BL_NO " ).append("\n"); 
		query.append("                 , SUM(SUB1.C_BL_NO) OVER (ORDER BY BL_NO) SEQ " ).append("\n"); 
		query.append("                 , SUB1.BKG_NO BKG_NO " ).append("\n"); 
		query.append(" 			     , SUB1.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("				 , SUB1.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 , SUB1.SHIPPER_CUST_NM" ).append("\n"); 
		query.append("                 , SUB1.CONSIGNEE_CUST_NM" ).append("\n"); 
		query.append("				 , SUB1.NOTIFY_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 , SUB1.SHPR_TAX_NO OB_SHPR_TAX_NO" ).append("\n"); 
		query.append("                 , SUB1.CNEE_TAX_NO OB_CNEE_TAX_NO" ).append("\n"); 
		query.append("                 , SUB1.NTFY_TAX_NO OB_NTFY_TAX_NO" ).append("\n"); 
		query.append("				 , SUB1.BRZ_DECL_NO OB_BRZ_DECL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 , DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_SHPR_TAX_NO, SUB1.SHPR_TAX_NO) SHPR_TAX_NO" ).append("\n"); 
		query.append("                 , DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_CNEE_TAX_NO, SUB1.CNEE_TAX_NO) CNEE_TAX_NO" ).append("\n"); 
		query.append("                 , DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_NTFY_TAX_NO, SUB1.NTFY_TAX_NO) NTFY_TAX_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 , DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_BRZ_DECL_NO, SUB1.BRZ_DECL_NO) BRZ_DECL_NO" ).append("\n"); 
		query.append("                 , SUB1.KEY_BL_NO" ).append("\n"); 
		query.append("                 , SUB1.IF_FLAG" ).append("\n"); 
		query.append("                 , SUB1.CNTR_NO" ).append("\n"); 
		query.append("                 , SUB1.PCK_QTY" ).append("\n"); 
		query.append("                 , SUB1.PCK_TP_CD" ).append("\n"); 
		query.append("                 , SUB1.WEIGHT" ).append("\n"); 
		query.append("                 , SUB1.WGT_UT_CD" ).append("\n"); 
		query.append("                 , SUB1.MEASURE" ).append("\n"); 
		query.append("                 , SUB1.MEAS_UT_CD" ).append("\n"); 
		query.append("                 , SUB1.BOOKING_CMDT_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 , SUB1.NEW_SHPR_TAX_NO" ).append("\n"); 
		query.append("                 , SUB1.NEW_CNEE_TAX_NO" ).append("\n"); 
		query.append("                 , SUB1.NEW_NTFY_TAX_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 , SUB1.NEW_BRZ_DECL_NO" ).append("\n"); 
		query.append("                 , SUB1.DEL_CD" ).append("\n"); 
		query.append("--                 , DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_CNTR_MF_SEQ, SUB1.CNTR_MF_SEQ) CNTR_MF_SEQ" ).append("\n"); 
		query.append("--                 , DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_BRZ_CMDT_CD, SUB1.NCM_NO) NCM_NO" ).append("\n"); 
		query.append("                 , NVL(DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_CNTR_MF_SEQ, SUB1.CNTR_MF_SEQ),SUB1.CNTR_MF_SEQ) CNTR_MF_SEQ" ).append("\n"); 
		query.append("                 , DECODE(SUB1.IF_FLAG,'Y',SUB1.NEW_BRZ_CMDT_CD, SUB1.NCM_NO) NCM_NO" ).append("\n"); 
		query.append("			     , DECODE(SUB1.OFT, 'Y', 'Y', 'N') OFT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       			 ,CASE WHEN @[io_type] = 'O' THEN DECODE(SUB1.OTH, 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("						ELSE DECODE(SUB1.DTH, 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("        		  END CAP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 , SUB1.BRZ_CSTMS_DUV_NM BR_DUV" ).append("\n"); 
		query.append("                 , SUB1.BRZ_CSTMS_MF_ID BR_MID" ).append("\n"); 
		query.append("				 , VVD" ).append("\n"); 
		query.append("				 , POL" ).append("\n"); 
		query.append("				 , POD" ).append("\n"); 
		query.append("                 , IB_TS_YN , OB_TS_YN" ).append("\n"); 
		query.append("                 , WPM" ).append("\n"); 
		query.append("           FROM    (" ).append("\n"); 
		query.append("                      SELECT  B.BL_NO BL_NO" ).append("\n"); 
		query.append("                            , DECODE(LAG(B.BL_NO) OVER ( ORDER BY B.BL_NO, B.CNTR_NO, B.CNTR_MF_SEQ) , B.BL_NO, 0, 1) C_BL_NO" ).append("\n"); 
		query.append("                            , B.BKG_NO BKG_NO" ).append("\n"); 
		query.append("                            , B.BL_NO KEY_BL_NO" ).append("\n"); 
		query.append("    		                , B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("							, B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                            , (" ).append("\n"); 
		query.append("                                 SELECT  CUST_NM" ).append("\n"); 
		query.append("                                 FROM    BKG_CUSTOMER" ).append("\n"); 
		query.append("                                 WHERE   BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND     BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                              ) SHIPPER_CUST_NM" ).append("\n"); 
		query.append("                            , (" ).append("\n"); 
		query.append("                                 SELECT  CUST_NM" ).append("\n"); 
		query.append("                                 FROM    BKG_CUSTOMER" ).append("\n"); 
		query.append("                                 WHERE   BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND     BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                              ) CONSIGNEE_CUST_NM" ).append("\n"); 
		query.append("                            , (" ).append("\n"); 
		query.append("                                 SELECT  CUST_NM" ).append("\n"); 
		query.append("                                 FROM    BKG_CUSTOMER" ).append("\n"); 
		query.append("                                 WHERE   BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND     BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                              ) NOTIFY_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , B.CNTR_NO                                                     " ).append("\n"); 
		query.append("                            , B.PCK_QTY                                                     " ).append("\n"); 
		query.append("                            , B.PCK_TP_CD                                                  " ).append("\n"); 
		query.append("                            , B.CNTR_MF_WGT WEIGHT    " ).append("\n"); 
		query.append("                            , B.WGT_UT_CD                         " ).append("\n"); 
		query.append("                            , B.MEAS_QTY MEASURE    " ).append("\n"); 
		query.append("                            , B.MEAS_UT_CD" ).append("\n"); 
		query.append("                            , B.NCM_NO                         " ).append("\n"); 
		query.append("                            , ( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = B.CMDT_CD ) BOOKING_CMDT_NM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , I.SHPR_TAX_NO" ).append("\n"); 
		query.append("                            , I.CNEE_TAX_NO" ).append("\n"); 
		query.append("                            , I.NTFY_TAX_NO" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("                            , I.BRZ_DECL_NO" ).append("\n"); 
		query.append("                            , I.BRZ_CMDT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , BL.SHPR_TAX_NO NEW_SHPR_TAX_NO  " ).append("\n"); 
		query.append("                            , BL.CNEE_TAX_NO NEW_CNEE_TAX_NO   " ).append("\n"); 
		query.append("                            , BL.NTFY_TAX_NO NEW_NTFY_TAX_NO   " ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("                            , BL.BRZ_DECL_NO NEW_BRZ_DECL_NO                                 " ).append("\n"); 
		query.append("                            , BC.BRZ_CMDT_CD NEW_BRZ_CMDT_CD                                 " ).append("\n"); 
		query.append("                            , B.CNTR_MF_SEQ CNTR_MF_SEQ                                    " ).append("\n"); 
		query.append("                            , BC.CNTR_MF_SEQ NEW_CNTR_MF_SEQ                                    " ).append("\n"); 
		query.append("                            , B.DEL_CD" ).append("\n"); 
		query.append("                            , DECODE(NVL(BL.BL_NO, ''), '', 'N', 'Y') IF_FLAG " ).append("\n"); 
		query.append("                            , (" ).append("\n"); 
		query.append("                                 SELECT  'Y' " ).append("\n"); 
		query.append("                                 FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                                 WHERE   BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND     CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                                 AND     ROWNUM = 1" ).append("\n"); 
		query.append("                              ) OFT" ).append("\n"); 
		query.append("                            , (" ).append("\n"); 
		query.append("                                 SELECT 'Y' " ).append("\n"); 
		query.append("                                 FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                                 WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND CHG_CD = 'OTH'" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1" ).append("\n"); 
		query.append("                               ) OTH" ).append("\n"); 
		query.append("                            , (" ).append("\n"); 
		query.append("                                 SELECT 'Y' " ).append("\n"); 
		query.append("                                 FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                                 WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND CHG_CD = 'DTH'" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1" ).append("\n"); 
		query.append("                               ) DTH" ).append("\n"); 
		query.append("                            , BL.BRZ_CSTMS_DUV_NM" ).append("\n"); 
		query.append("                            , BL.BRZ_CSTMS_MF_ID" ).append("\n"); 
		query.append("							, B.VVD" ).append("\n"); 
		query.append("							, B.POL" ).append("\n"); 
		query.append("							, B.POD" ).append("\n"); 
		query.append("                            , IB_TS_YN , OB_TS_YN" ).append("\n"); 
		query.append("                            , WPM" ).append("\n"); 
		query.append("                      FROM    (" ).append("\n"); 
		query.append("                                 SELECT  B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                                       , B.BKG_NO" ).append("\n"); 
		query.append("                                       , B.BL_NO,B.CMDT_CD" ).append("\n"); 
		query.append("                                       , D.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                                       , C.CNTR_NO" ).append("\n"); 
		query.append("        							   , B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                       , MAX(D.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("                                       , MAX( NVL(D.PCK_TP_CD, C.PCK_TP_CD) ) PCK_TP_CD" ).append("\n"); 
		query.append("                                       , MAX(D.CNTR_MF_WGT) CNTR_MF_WGT" ).append("\n"); 
		query.append("                                       , MAX(  NVL(D.WGT_UT_CD, C.WGT_UT_CD) ) WGT_UT_CD" ).append("\n"); 
		query.append("                                       , MAX(D.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("                                       , MAX( NVL(D.MEAS_UT_CD, C.MEAS_UT_CD) ) MEAS_UT_CD" ).append("\n"); 
		query.append("                                       , MAX(D.NCM_NO) NCM_NO" ).append("\n"); 
		query.append("                                       , MAX(B.DEL_CD) DEL_CD" ).append("\n"); 
		query.append("									   , MAX( V.VSL_CD||V.SKD_vOY_NO||V.SKD_dIR_cD) VVD" ).append("\n"); 
		query.append("									   , MAX( V.POL_cD) POL" ).append("\n"); 
		query.append("									   , MAX( V.POD_cD) POD" ).append("\n"); 
		query.append("									   , MAX(CASE WHEN V.POD_CD != B.POD_CD THEN 'Y' ELSE 'N' END) IB_TS_YN" ).append("\n"); 
		query.append("                                       , MAX(CASE WHEN V.POL_CD != B.POL_CD THEN 'Y' ELSE 'N' END) OB_TS_YN" ).append("\n"); 
		query.append("                                       , MAX(CASE WHEN WPM_TRT_CD = 'A' THEN 'N/A' ELSE NVL(WPM_TRT_CD,' ') END) WPM" ).append("\n"); 
		query.append("                                 FROM    BKG_BOOKING B" ).append("\n"); 
		query.append("                                       , BKG_VVD V" ).append("\n"); 
		query.append("                                       , BKG_CONTAINER C" ).append("\n"); 
		query.append("                                       , BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append("                                       , BKG_BOOKING E" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 WHERE   1 = 1" ).append("\n"); 
		query.append("    #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                                 AND     V.VSL_CD     = SUBSTR (@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                 AND     V.SKD_VOY_NO = SUBSTR (@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                 AND     V.SKD_DIR_CD = SUBSTR (@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("                                 AND     V.POL_CD        = @[pol_cd]                    " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("                                 AND     V.POD_CD        = @[pod_cd]                 " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("                                 AND     B.BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("								 AND	 DECODE( @[io_type], 'O', SUBSTR(V.POL_CD,1,2), SUBSTR(V.POD_CD,1,2) )  = 'BR'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 AND     B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                 AND     B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("                                 AND     C.BKG_NO = D.BKG_NO(+) " ).append("\n"); 
		query.append("                                 AND     C.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("                                 AND     B.FM_BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("				                 AND     (     B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("     					                    OR (B.BKG_STS_CD = 'S' AND B.SPLIT_RSN_CD ='M')" ).append("\n"); 
		query.append("   					                     )" ).append("\n"); 
		query.append("				                 AND     NVL(E.SPLIT_RSN_CD,'XX') <> 'M'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${bkg_cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("                                 AND     B.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("	#elseif (${bkg_cgo_tp_cd} == 'P') " ).append("\n"); 
		query.append("								 AND     B.BKG_CGO_TP_CD IN ('P')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${del_cd} != '') " ).append("\n"); 
		query.append("                                 AND     B.DEL_CD        = @[del_cd]                 " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				                 AND     D.CNTR_MF_SEQ(+) > 0" ).append("\n"); 
		query.append("				                 GROUP BY" ).append("\n"); 
		query.append("                                         B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                                       , B.BKG_NO" ).append("\n"); 
		query.append("                                       , B.BL_NO,B.CMDT_CD" ).append("\n"); 
		query.append("									   , B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                       , D.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                                       , C.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                              ) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , (    " ).append("\n"); 
		query.append("                                 SELECT  A.BKG_NO" ).append("\n"); 
		query.append("                                       , A.IO_BND_CD" ).append("\n"); 
		query.append("                                       , MAX(A.XPT_IMP_SEQ) XPT_IMP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       ,MAX(A.SHPR_TAX_NO) SHPR_TAX_NO" ).append("\n"); 
		query.append("                                       ,MAX(A.CNEE_TAX_NO) CNEE_TAX_NO" ).append("\n"); 
		query.append("                                       ,MAX(A.NTFY_TAX_NO) NTFY_TAX_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       , MAX(A.BRZ_DECL_NO) BRZ_DECL_NO" ).append("\n"); 
		query.append("                                       , MAX(A.BRZ_CMDT_CD) BRZ_CMDT_CD" ).append("\n"); 
		query.append("                                 FROM    BKG_XPT_IMP_LIC A" ).append("\n"); 
		query.append("                                       , BKG_BOOKING B" ).append("\n"); 
		query.append("                                       , BKG_VVD V" ).append("\n"); 
		query.append("                                       , BKG_BOOKING E" ).append("\n"); 
		query.append("                                 WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                                 AND     V.VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)   " ).append("\n"); 
		query.append("                                 AND     V.SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)   " ).append("\n"); 
		query.append("                                 AND     V.SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("                                 AND     V.POL_CD        = @[pol_cd]                    " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("                                 AND     V.POD_CD        = @[pod_cd]                 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("                                 AND     B.BL_NO        = @[bl_no]                 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 AND     B.BKG_NO        = V.BKG_NO" ).append("\n"); 
		query.append("                                 AND     B.FM_BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("			                     AND     (B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("     					                     OR (B.BKG_STS_CD = 'S' AND B.SPLIT_RSN_CD ='M')" ).append("\n"); 
		query.append("   					                      )" ).append("\n"); 
		query.append("				                 AND     NVL(E.SPLIT_RSN_CD,'XX') <> 'M'" ).append("\n"); 
		query.append("                                 AND     A.IO_BND_CD     = @[io_type]" ).append("\n"); 
		query.append("                                 AND     A.BKG_NO        = V.BKG_NO " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F') " ).append("\n"); 
		query.append("				                 AND      B.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("#elseif (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("				                 AND      B.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("                                 AND     B.DEL_CD        = @[del_cd]                 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 GROUP BY" ).append("\n"); 
		query.append("                                         A.BKG_NO" ).append("\n"); 
		query.append("                                       , A.IO_BND_CD" ).append("\n"); 
		query.append("                              ) I" ).append("\n"); 
		query.append("                            , BKG_CSTMS_BRZ_BL BL" ).append("\n"); 
		query.append("                            , BKG_CSTMS_BRZ_CNTR_MF BC" ).append("\n"); 
		query.append("                      WHERE   1 = 1" ).append("\n"); 
		query.append("                      AND     B.BKG_NO            = I.BKG_NO(+)              " ).append("\n"); 
		query.append("                      AND     B.BL_NO             = BL.BL_NO(+)    " ).append("\n"); 
		query.append("                      AND     B.BL_NO          	= BC.BL_NO(+)                    " ).append("\n"); 
		query.append("                      AND     B.CNTR_MF_SEQ       = BC.CNTR_MF_SEQ(+)            " ).append("\n"); 
		query.append("                      AND     B.CNTR_NO           = BC.CNTR_NO(+) " ).append("\n"); 
		query.append("#if (${br_duv} != '')" ).append("\n"); 
		query.append("                      AND     UPPER(BL.BRZ_CSTMS_DUV_NM) = @[br_duv]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${br_mid} != '')" ).append("\n"); 
		query.append("                      AND     UPPER(BL.BRZ_CSTMS_MF_ID)  = @[br_mid] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      ORDER BY" ).append("\n"); 
		query.append("                              BL_NO" ).append("\n"); 
		query.append("                            , CNTR_NO" ).append("\n"); 
		query.append("                            , B.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                   ) SUB1" ).append("\n"); 
		query.append("        ) MAIN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   1 = 1                                 " ).append("\n"); 
		query.append("#if (${cnpj_no} != '')" ).append("\n"); 
		query.append("AND     UPPER(CNEE_TAX_NO) = @[cnpj_no] " ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${error_type} == '2') " ).append("\n"); 
		query.append("    #if (${io_type} == 'O') " ).append("\n"); 
		query.append("AND     (   NVL(CNEE_TAX_NO, ' ') = ' '" ).append("\n"); 
		query.append("         OR NVL(BRZ_DECL_NO, ' ') = ' '" ).append("\n"); 
		query.append("         OR NVL(PCK_QTY, 0) = 0" ).append("\n"); 
		query.append("         OR NVL(PCK_TP_CD, ' ') = ' '" ).append("\n"); 
		query.append("         OR NVL(WEIGHT, 0) = 0" ).append("\n"); 
		query.append("         OR NVL(MEASURE, 0) = 0" ).append("\n"); 
		query.append("         OR NVL(NCM_NO, ' ') = ' '" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${io_type} == 'I') " ).append("\n"); 
		query.append("AND     (   " ).append("\n"); 
		query.append("			NVL(SHPR_TAX_NO, ' ') = ' '         " ).append("\n"); 
		query.append("         OR NVL(PCK_QTY, 0) = 0          " ).append("\n"); 
		query.append("         OR NVL(PCK_TP_CD, ' ') = ' '        " ).append("\n"); 
		query.append("         OR NVL(WEIGHT, 0) = 0           " ).append("\n"); 
		query.append("         OR NVL(MEASURE, 0) = 0          " ).append("\n"); 
		query.append("         OR NVL(NCM_NO, ' ') = ' '" ).append("\n"); 
		query.append("        )     " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}