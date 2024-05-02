/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ChinaManifestListDownloadDBDAOsearchManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaManifestListDetailVO
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchManifestListRSQL").append("\n"); 
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
		query.append("WITH EDI_INFO AS (" ).append("\n"); 
		query.append("    SELECT  * FROM (" ).append("\n"); 
		query.append("        SELECT  DISTINCT" ).append("\n"); 
		query.append("                DENSE_RANK() OVER(PARTITION BY BL.BL_NO ORDER BY SLOG.MF_SND_DT DESC) AS RNUM, " ).append("\n"); 
		query.append("                B.BKG_NO," ).append("\n"); 
		query.append("                SLOG.MF_SND_DT," ).append("\n"); 
		query.append("                SLOG.EDI_REF_ID" ).append("\n"); 
		query.append("        FROM    BKG_CSTMS_CHN_SND_LOG_BL BL," ).append("\n"); 
		query.append("                BKG_CSTMS_CHN_SND_LOG SLOG," ).append("\n"); 
		query.append("                BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE   SLOG.CHN_MF_SND_IND_CD  = @[trans_mode]" ).append("\n"); 
		query.append("        AND     SLOG.VSL_CD 	 = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("        AND     SLOG.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("        AND     SLOG.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("        AND     BL.EDI_REF_ID    = SLOG.EDI_REF_ID" ).append("\n"); 
		query.append("        AND     BL.BL_NO 	 	 = B.BL_NO" ).append("\n"); 
		query.append("        AND     NVL(B.CRR_SOC_FLG, 'N' )='N'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE   RNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  INFO.BKG_NO," ).append("\n"); 
		query.append("        INFO.BL_NO," ).append("\n"); 
		query.append("        INFO.POL_CD," ).append("\n"); 
		query.append("        INFO.POD_CD," ).append("\n"); 
		query.append("        INFO.DEL_CD," ).append("\n"); 
		query.append("        INFO.PCK_QTY," ).append("\n"); 
		query.append("        INFO.PCK_TP_CD," ).append("\n"); 
		query.append("        INFO.ACT_WGT," ).append("\n"); 
		query.append("        INFO.WGT_UT_CD," ).append("\n"); 
		query.append("        INFO.SHPR_NM," ).append("\n"); 
		query.append("        INFO.SHPR_ADDR," ).append("\n"); 
		query.append("		INFO.SHPR_CNT," ).append("\n"); 
		query.append("		INFO.SHPR_ST_PO," ).append("\n"); 
		query.append("		INFO.SHPR_RGST_NO," ).append("\n"); 
		query.append("		INFO.SHPR_FAX," ).append("\n"); 
		query.append("		INFO.SHPR_EML," ).append("\n"); 
		query.append("		INFO.SHPR_PHN," ).append("\n"); 
		query.append("        INFO.CNEE_NM," ).append("\n"); 
		query.append("        INFO.CNEE_ADDR," ).append("\n"); 
		query.append("		INFO.CNEE_CNT," ).append("\n"); 
		query.append("		INFO.CNEE_ST_PO," ).append("\n"); 
		query.append("		INFO.CNEE_RGST_NO," ).append("\n"); 
		query.append("		INFO.CNEE_FAX," ).append("\n"); 
		query.append("		INFO.CNEE_EML," ).append("\n"); 
		query.append("		INFO.CNEE_PHN," ).append("\n"); 
		query.append("        INFO.NTFY_NM," ).append("\n"); 
		query.append("        INFO.NTFY_ADDR," ).append("\n"); 
		query.append("		INFO.NTFY_CNT," ).append("\n"); 
		query.append("		INFO.NTFY_ST_PO," ).append("\n"); 
		query.append("		INFO.NTFY_RGST_NO," ).append("\n"); 
		query.append("		INFO.NTFY_FAX," ).append("\n"); 
		query.append("		INFO.NTFY_EML," ).append("\n"); 
		query.append("		INFO.NTFY_PHN," ).append("\n"); 
		query.append("        INFO.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("        INFO.TR," ).append("\n"); 
		query.append("        INFO.DCGO_FLG, " ).append("\n"); 
		query.append("        INFO.RC_FLG," ).append("\n"); 
		query.append("        INFO.DL_FLG," ).append("\n"); 
		query.append("		INFO.MF_DL_DT," ).append("\n"); 
		query.append("        INFO.CNTR_CNT," ).append("\n"); 
		query.append("        --SLOG.TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("        DECODE(SLOG.TRSM_MSG_TP_ID,'9','Original','0','Original','5','Change','3','Delete') TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("        TO_CHAR(SLOG.MF_SND_DT, 'YYYYMMDDHH24MISS') MF_SND_DT," ).append("\n"); 
		query.append("		MIN(DECODE(TRIM(SEAL.CNTR_SEAL_NO),NULL,'N','Y')) SEAL_NO_FLG," ).append("\n"); 
		query.append("		MIN(DECODE(TRIM(SEAL.SEAL_KND_CD), NULL, 'N', 'Y')) SEAL_KND_FLG," ).append("\n"); 
		query.append("		MIN(DECODE(TRIM(SEAL.SEAL_PTY_TP_CD),NULL,'N','Y')) SEALER_CD_FLG,		" ).append("\n"); 
		query.append("        --SUM(DECODE(CNTR.CNTR_NO,NULL,0,1)) CNTR_CNT," ).append("\n"); 
		query.append("		-- VSL Info" ).append("\n"); 
		query.append("		'' AS CALL_SGN_NO," ).append("\n"); 
		query.append("		'' AS PRE_PORT," ).append("\n"); 
		query.append("		'' AS NXT_PORT," ).append("\n"); 
		query.append("		'' AS VPS_ETA_DT," ).append("\n"); 
		query.append("		'' AS VPS_ETD_DT," ).append("\n"); 
		query.append("		'' AS VPS_ETB_DT," ).append("\n"); 
		query.append("		'' AS VSL_ENG_NM," ).append("\n"); 
		query.append("		-- 조회 조건" ).append("\n"); 
		query.append("		@[vvd] 			 AS VVD," ).append("\n"); 
		query.append("		@[bkg_cgo_tp_cd] AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("		@[loc_cd] 		 AS LOC_CD," ).append("\n"); 
		query.append("		@[trans_mode] 	 AS TRANS_MODE," ).append("\n"); 
		query.append("		-- 총 개수" ).append("\n"); 
		query.append("		'' AS TOTAL," ).append("\n"); 
		query.append("       MIN( CASE WHEN DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD, 1, 1), 'T', 1, 'F', 1, 'A', 1, 0) = 0        --일반CNTR TYPE인 경우" ).append("\n"); 
		query.append("                 THEN " ).append("\n"); 
		query.append("                      (CASE WHEN (DECODE(TRIM(SEAL.CNTR_SEAL_NO), NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                ||DECODE(TRIM(SEAL.SEAL_PTY_TP_CD), NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                ||DECODE(TRIM(SEAL.SEAL_KND_CD), NULL, 'N', 'Y')) = 'YYY'" ).append("\n"); 
		query.append("                            THEN 'Y'" ).append("\n"); 
		query.append("                            ELSE 'N'" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("                 ELSE                                                                               --(T,F,A) CNTR TYPE인 경우 " ).append("\n"); 
		query.append("                      'Y'" ).append("\n"); 
		query.append("            END             " ).append("\n"); 
		query.append("       ) AS DL_CHK_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("            SELECT  B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("					(select count(cntr_no) from bkg_container cc where b.bkg_no = cc.bkg_no group by cc.bkg_no) CNTR_CNT," ).append("\n"); 
		query.append("                    B.BL_NO BL_NO," ).append("\n"); 
		query.append("                    B.POL_CD POL_CD," ).append("\n"); 
		query.append("                    B.POD_CD POD_CD," ).append("\n"); 
		query.append("                    B.DEL_CD DEL_CD," ).append("\n"); 
		query.append("                    DECODE(NVL(BL.PCK_QTY,0),0,'N','Y') PCK_QTY," ).append("\n"); 
		query.append("                    DECODE(BL.PCK_TP_CD,NULL,'N','Y') PCK_TP_CD," ).append("\n"); 
		query.append("                    DECODE(NVL(BL.ACT_WGT,0),0,'N','Y') ACT_WGT," ).append("\n"); 
		query.append("                    DECODE(BL.WGT_UT_CD,NULL,'N','Y') WGT_UT_CD," ).append("\n"); 
		query.append("                    DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_NM)), 0, 'N',NULL,'N', 'Y')) SHPR_NM," ).append("\n"); 
		query.append("                    DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_ADDR)), 0, 'N',NULL,'N', 'Y')) SHPR_ADDR," ).append("\n"); 
		query.append("					DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CSTMS_DECL_CNT_CD)),    0, DECODE(LENGTH(TRIM(S.CUST_CNT_CD)),    0, 'N'" ).append("\n"); 
		query.append("																																  , NULL, 'N'" ).append("\n"); 
		query.append("																													      				, 'Y'" ).append("\n"); 
		query.append("																						 		      )" ).append("\n"); 
		query.append("																						, NULL, DECODE(LENGTH(TRIM(S.CUST_CNT_CD)),    0, 'N'" ).append("\n"); 
		query.append("																																  , NULL, 'N'" ).append("\n"); 
		query.append("																														  				, 'Y'" ).append("\n"); 
		query.append("																								 	  )" ).append("\n"); 
		query.append("  																						, 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) SHPR_CNT," ).append("\n"); 
		query.append("					DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.EUR_CSTMS_ST_NM)), 0, 'N',NULL, 'N', 'Y')) SHPR_ST_PO," ).append("\n"); 
		query.append("                    DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.EORI_NO)), 0, 'N',NULL,'N', 'Y')) SHPR_RGST_NO," ).append("\n"); 
		query.append("					DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_FAX_NO)),   0, CASE WHEN LENGTH(TRIM(S.CUST_EML)) <> 0" ).append("\n"); 
		query.append("													   									  	    OR LENGTH(TRIM(S.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																				  ,NULL, CASE WHEN LENGTH(TRIM(S.CUST_EML)) <> 0" ).append("\n"); 
		query.append("													   									  	    OR LENGTH(TRIM(S.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																					   , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) SHPR_FAX, " ).append("\n"); 
		query.append("					DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_EML)),   0, CASE WHEN LENGTH(TRIM(S.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									     OR LENGTH(TRIM(S.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("                                                     								       THEN '-'" ).append("\n"); 
		query.append("																						   ELSE 'N'" ).append("\n"); 
		query.append("																					   END" ).append("\n"); 
		query.append("																			   ,NULL, CASE WHEN LENGTH(TRIM(S.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									  	 OR LENGTH(TRIM(S.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("                                                     								       THEN '-'" ).append("\n"); 
		query.append("																						   ELSE 'N'" ).append("\n"); 
		query.append("																					   END" ).append("\n"); 
		query.append("																					, 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) SHPR_EML," ).append("\n"); 
		query.append("					DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_PHN_NO)),   0, CASE WHEN LENGTH(TRIM(S.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									        OR LENGTH(TRIM(S.CUST_EML)) <> 0" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																			      ,NULL, CASE WHEN LENGTH(TRIM(S.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									  	    OR LENGTH(TRIM(S.CUST_EML)) <> 0" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																					   , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) SHPR_PHN," ).append("\n"); 
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.CUST_NM)), 0, 'N',NULL,'N', 'Y')) CNEE_NM," ).append("\n"); 
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(B.CUST_TO_ORD_FLG,'Y','Y',DECODE(LENGTH(TRIM(C.CUST_ADDR)), 0, 'N',NULL,'N', 'Y'))) CNEE_ADDR," ).append("\n"); 
		query.append("					DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.CSTMS_DECL_CNT_CD)),    0, DECODE(LENGTH(TRIM(C.CUST_CNT_CD)),    0, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																																									  ,'N'" ).append("\n"); 
		query.append("																																				)" ).append("\n"); 
		query.append("																																  , NULL, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																																									  ,'N'" ).append("\n"); 
		query.append("																																				)" ).append("\n"); 
		query.append("																													  			  		, 'Y'" ).append("\n"); 
		query.append("																				  					  )" ).append("\n"); 
		query.append("																	      				, NULL, DECODE(LENGTH(TRIM(C.CUST_CNT_CD)),    0, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																																									  ,'N'" ).append("\n"); 
		query.append("																																				)" ).append("\n"); 
		query.append("																																  , NULL, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																																									  ,'N'" ).append("\n"); 
		query.append("																																				)" ).append("\n"); 
		query.append("																																	   	, 'Y'" ).append("\n"); 
		query.append("																									  )" ).append("\n"); 
		query.append("																				  					  " ).append("\n"); 
		query.append("																						, 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) CNEE_CNT," ).append("\n"); 
		query.append("					DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.EUR_CSTMS_ST_NM)),    0, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																												          ,'N'" ).append("\n"); 
		query.append("																							        )" ).append("\n"); 
		query.append("																				      , NULL, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																												          ,'N'" ).append("\n"); 
		query.append("																							        )" ).append("\n"); 
		query.append("																				            , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) CNEE_ST_PO," ).append("\n"); 
		query.append("					DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.EORI_NO)),    0, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																										          ,'N'" ).append("\n"); 
		query.append("																							)" ).append("\n"); 
		query.append("																			  , NULL, DECODE(B.CUST_TO_ORD_FLG,'Y','-'" ).append("\n"); 
		query.append("																										          ,'N'" ).append("\n"); 
		query.append("																							)" ).append("\n"); 
		query.append("																			        , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) CNEE_RGST_NO," ).append("\n"); 
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.CUST_FAX_NO)),   0, CASE WHEN LENGTH(TRIM(C.CUST_EML)) <> 0" ).append("\n"); 
		query.append("													   									  	    OR LENGTH(TRIM(C.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							    OR B.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																				  ,NULL, CASE WHEN LENGTH(TRIM(C.CUST_EML)) <> 0" ).append("\n"); 
		query.append("													   									  	    OR LENGTH(TRIM(C.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							    OR B.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																					   , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) CNEE_FAX,		" ).append("\n"); 
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.CUST_EML)),   0, CASE WHEN LENGTH(TRIM(C.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									  	 OR LENGTH(TRIM(C.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							 OR B.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("                                                     								       THEN '-'" ).append("\n"); 
		query.append("																						   ELSE 'N'" ).append("\n"); 
		query.append("																					   END" ).append("\n"); 
		query.append("																			   ,NULL, CASE WHEN LENGTH(TRIM(C.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									  	 OR LENGTH(TRIM(C.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							 OR B.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("                                                     								       THEN '-'" ).append("\n"); 
		query.append("																						   ELSE 'N'" ).append("\n"); 
		query.append("																					   END" ).append("\n"); 
		query.append("																					 , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) CNEE_EML," ).append("\n"); 
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.CUST_PHN_NO)),   0, CASE WHEN LENGTH(TRIM(C.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									        OR LENGTH(TRIM(C.CUST_EML)) <> 0" ).append("\n"); 
		query.append("																							    OR B.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																			      ,NULL, CASE WHEN LENGTH(TRIM(C.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									  	    OR LENGTH(TRIM(C.CUST_EML)) <> 0" ).append("\n"); 
		query.append("																							    OR B.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("                                                     								          THEN '-'" ).append("\n"); 
		query.append("																						      ELSE 'N'" ).append("\n"); 
		query.append("																					      END" ).append("\n"); 
		query.append("																					   , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) CNEE_PHN," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.CUST_NM)), 0, 'N',NULL,'N', 'Y')) NTFY_NM," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(B.SAM_CNEE_NTFY_FLG,'Y','Y',DECODE(LENGTH(TRIM(N.CUST_ADDR)), 0, 'N',NULL,'N', 'Y'))) NTFY_ADDR," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.CSTMS_DECL_CNT_CD)), 	 0,DECODE(LENGTH(TRIM(N.CUST_CNT_CD)),    0, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append("																																									 ,'N'" ).append("\n"); 
		query.append("																																			   )" ).append("\n"); 
		query.append("																																 , NULL, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append("																																									 ,'N'" ).append("\n"); 
		query.append("																																			   )" ).append("\n"); 
		query.append("				 																													   , 'Y'" ).append("\n"); 
		query.append("																				  					 )" ).append("\n"); 
		query.append("																						, NULL,DECODE(LENGTH(TRIM(N.CUST_CNT_CD)),    0, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append(" 																																									 ,'N'" ).append("\n"); 
		query.append("																																			   )" ).append("\n"); 
		query.append("																																 , NULL, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append(" 																																									 ,'N'" ).append("\n"); 
		query.append("																																			   )" ).append("\n"); 
		query.append("																																	   , 'Y'" ).append("\n"); 
		query.append("																				  					 )" ).append("\n"); 
		query.append("																									 " ).append("\n"); 
		query.append("																						, 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) NTFY_CNT," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.EUR_CSTMS_ST_NM)),   0, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append("																													     ,'N'" ).append("\n"); 
		query.append("																							       )" ).append("\n"); 
		query.append("																				      ,NULL, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append("																													     ,'N'" ).append("\n"); 
		query.append("																							       )" ).append("\n"); 
		query.append("																				           , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) NTFY_ST_PO," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.EORI_NO)),   0, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append("																												 ,'N'" ).append("\n"); 
		query.append("																							       )" ).append("\n"); 
		query.append("																			  ,NULL, DECODE(B.CUST_TO_ORD_FLG,'N','-'" ).append("\n"); 
		query.append("																												 ,'N'" ).append("\n"); 
		query.append("																							       )" ).append("\n"); 
		query.append("																				   , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) NTFY_RGST_NO," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.CUST_FAX_NO)),    0, CASE WHEN LENGTH(TRIM(N.CUST_EML)) <> 0" ).append("\n"); 
		query.append("													   									         OR LENGTH(TRIM(N.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							     OR B.CUST_TO_ORD_FLG = 'N'" ).append("\n"); 
		query.append("                                                     								           THEN '-'" ).append("\n"); 
		query.append("																						       ELSE 'N'" ).append("\n"); 
		query.append("																					       END" ).append("\n"); 
		query.append("																				  , NULL, CASE WHEN LENGTH(TRIM(N.CUST_EML)) <> 0" ).append("\n"); 
		query.append("													   									         OR LENGTH(TRIM(N.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							     OR B.CUST_TO_ORD_FLG = 'N'" ).append("\n"); 
		query.append("                                                     								           THEN '-'" ).append("\n"); 
		query.append("																						       ELSE 'N'" ).append("\n"); 
		query.append("																					       END" ).append("\n"); 
		query.append("																				        , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) NTFY_FAX," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.CUST_EML)),    0, CASE WHEN LENGTH(TRIM(N.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									      OR LENGTH(TRIM(N.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							  OR B.CUST_TO_ORD_FLG = 'N'" ).append("\n"); 
		query.append("                                                     								        THEN '-'" ).append("\n"); 
		query.append("																						    ELSE 'N'" ).append("\n"); 
		query.append("																					    END" ).append("\n"); 
		query.append("																			   , NULL, CASE WHEN LENGTH(TRIM(N.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									      OR LENGTH(TRIM(N.CUST_PHN_NO)) <> 0" ).append("\n"); 
		query.append("																							  OR B.CUST_TO_ORD_FLG = 'N'" ).append("\n"); 
		query.append("                                                     								        THEN '-'" ).append("\n"); 
		query.append("																						    ELSE 'N'" ).append("\n"); 
		query.append("																					    END" ).append("\n"); 
		query.append("																				     , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) NTFY_EML," ).append("\n"); 
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.CUST_PHN_NO)),    0, CASE WHEN LENGTH(TRIM(N.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									         OR LENGTH(TRIM(N.CUST_EML)) <> 0" ).append("\n"); 
		query.append("																							     OR B.CUST_TO_ORD_FLG = 'N'" ).append("\n"); 
		query.append("                                                     								           THEN '-'" ).append("\n"); 
		query.append("																						       ELSE 'N'" ).append("\n"); 
		query.append("																					       END" ).append("\n"); 
		query.append("																			      , NULL, CASE WHEN LENGTH(TRIM(N.CUST_FAX_NO)) <> 0" ).append("\n"); 
		query.append("													   									         OR LENGTH(TRIM(N.CUST_EML)) <> 0" ).append("\n"); 
		query.append("																							     OR B.CUST_TO_ORD_FLG = 'N'" ).append("\n"); 
		query.append("                                                     								           THEN '-'" ).append("\n"); 
		query.append("																						       ELSE 'N'" ).append("\n"); 
		query.append("																					       END" ).append("\n"); 
		query.append("																				        , 'Y'" ).append("\n"); 
		query.append("													  )" ).append("\n"); 
		query.append("						  ) NTFY_PHN," ).append("\n"); 
		query.append("                    B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                    DECODE(@[trans_mode], 'D', DECODE(B.POD_CD, @[loc_cd], 'I', 'T'), DECODE(B.POL_CD, @[loc_cd], 'E', 'R')) TR," ).append("\n"); 
		query.append("                    DECODE(B.DCGO_FLG,'N','N','Y') DCGO_FLG, " ).append("\n"); 
		query.append("                    DECODE(B.RC_FLG,'N','N','Y') RC_FLG," ).append("\n"); 
		query.append("                    CASE WHEN ( SELECT  COUNT(*) CNT                        " ).append("\n"); 
		query.append("                                FROM    BKG_CSTMS_CHN_BL                     " ).append("\n"); 
		query.append("                                WHERE   CHN_MF_SND_IND_CD = @[trans_mode]     " ).append("\n"); 
		query.append("                                AND     VSL_CD 	   = SUBSTR(@[vvd],1,4)            " ).append("\n"); 
		query.append("                                AND     SKD_VOY_NO = SUBSTR(@[vvd],5,4)         " ).append("\n"); 
		query.append("                                AND     SKD_DIR_CD = SUBSTR(@[vvd],9,1)         " ).append("\n"); 
		query.append("                                AND     BKG_POL_CD = BV.POL_CD                    " ).append("\n"); 
		query.append("                                AND     BKG_POD_CD = BV.POD_CD                    " ).append("\n"); 
		query.append("                                AND     BL_NO = B.BL_NO ) > 0 THEN 'Y'        " ).append("\n"); 
		query.append("                         ELSE 'N' " ).append("\n"); 
		query.append("                    END DL_FLG," ).append("\n"); 
		query.append("					( SELECT  MF_DL_DT" ).append("\n"); 
		query.append("					FROM    BKG_CSTMS_CHN_DL_HIS" ).append("\n"); 
		query.append("					WHERE   CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("					AND     VSL_CD 	   = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("					AND     SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("					AND     SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("					AND     BL_NO = B.BL_NO " ).append("\n"); 
		query.append("					AND     DELT_FLG = 'N') MF_DL_DT," ).append("\n"); 
		query.append("                    EDI_INFO.EDI_REF_ID" ).append("\n"); 
		query.append("                    --(SELECT  MAX(SLOG.EDI_REF_ID)                        " ).append("\n"); 
		query.append("                    -- FROM    BKG_CSTMS_CHN_SND_LOG_BL BL,               " ).append("\n"); 
		query.append("                    --         BKG_CSTMS_CHN_SND_LOG SLOG			" ).append("\n"); 
		query.append("                    -- WHERE   BL.EDI_REF_ID = SLOG.EDI_REF_ID		" ).append("\n"); 
		query.append("                    -- AND     SLOG.CHN_MF_SND_IND_CD = [trans_mode]		" ).append("\n"); 
		query.append("                    -- AND     SLOG.VSL_CD 	 = SUBSTR([vvd],1,4)		" ).append("\n"); 
		query.append("                    -- AND     SLOG.SKD_VOY_NO = SUBSTR([vvd],5,4)		" ).append("\n"); 
		query.append("                    -- AND     SLOG.SKD_DIR_CD = SUBSTR([vvd],9,1)		" ).append("\n"); 
		query.append("                    -- AND     SLOG.BKG_POL_CD = BV.POL_CD		" ).append("\n"); 
		query.append("                    -- AND     BL.BL_NO = B.BL_NO	" ).append("\n"); 
		query.append("					--) EDI_REF_ID                        " ).append("\n"); 
		query.append("            FROM    BKG_VVD BV, " ).append("\n"); 
		query.append("                    BKG_BOOKING B, " ).append("\n"); 
		query.append("                    BKG_BL_DOC BL," ).append("\n"); 
		query.append("                    BKG_CUSTOMER S, " ).append("\n"); 
		query.append("                    BKG_CUSTOMER C, " ).append("\n"); 
		query.append("                    BKG_CUSTOMER N," ).append("\n"); 
		query.append("                	EDI_INFO" ).append("\n"); 
		query.append("            WHERE   BV.VSL_CD           =    SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("            AND     BV.SKD_VOY_NO       =    SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND     BV.SKD_DIR_CD       =    SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("            AND     BV.BKG_NO           =    B.BKG_NO" ).append("\n"); 
		query.append("            AND     BV.BKG_NO           =    BL.BKG_NO" ).append("\n"); 
		query.append("            AND     B.BKG_STS_CD        NOT IN    ('X','S')" ).append("\n"); 
		query.append("            AND     DECODE(B.BKG_CGO_TP_CD,'P','P','F') LIKE @[bkg_cgo_tp_cd]||'%'" ).append("\n"); 
		query.append("            AND     DECODE(@[trans_mode],'D',BV.POD_CD,'O',BV.POL_CD, BV.POL_CD) = @[loc_cd]" ).append("\n"); 
		query.append("            AND     BV.POD_CD           LIKE    DECODE(@[trans_mode],'D','%','O','CN%','%')" ).append("\n"); 
		query.append("            AND     BV.POD_CD           <>      DECODE(@[trans_mode],'P',' ','CNHKG')/*24HR ?????? ???????? PRE-STOWAGE?? ????*/" ).append("\n"); 
		query.append("            AND     B.BKG_NO            =    S.BKG_NO(+)" ).append("\n"); 
		query.append("            AND     B.BKG_NO            =    C.BKG_NO(+)" ).append("\n"); 
		query.append("            AND     B.BKG_NO            =    N.BKG_NO(+)" ).append("\n"); 
		query.append("            AND     S.BKG_CUST_TP_CD(+) =    'S'" ).append("\n"); 
		query.append("            AND     C.BKG_CUST_TP_CD(+) =    'C'" ).append("\n"); 
		query.append("            AND     N.BKG_CUST_TP_CD(+) =    'N' " ).append("\n"); 
		query.append("        	AND     B.BKG_NO            =    EDI_INFO.BKG_NO(+)" ).append("\n"); 
		query.append("            AND     NVL(B.CRR_SOC_FLG, 'N' )='N'" ).append("\n"); 
		query.append("       ) INFO," ).append("\n"); 
		query.append("         BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("         BKG_CNTR_SEAL_NO SEAL," ).append("\n"); 
		query.append("         BKG_CSTMS_CHN_SND_LOG SLOG" ).append("\n"); 
		query.append("   WHERE INFO.BKG_NO          = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("     AND CNTR.BKG_NO          = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("     AND CNTR.CNTR_NO         = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("     AND INFO.EDI_REF_ID      = SLOG.EDI_REF_ID(+)" ).append("\n"); 
		query.append("#if (${trans_type} == 'local') " ).append("\n"); 
		query.append("	 AND INFO.TR IN ('E','I')" ).append("\n"); 
		query.append("#elseif (${trans_type} == 'ts') " ).append("\n"); 
		query.append("	 AND INFO.TR IN ('R','T')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${err_div} == 'err')" ).append("\n"); 
		query.append("	 AND (INFO.PCK_QTY = 'N' OR INFO.PCK_TP_CD = 'N' OR INFO.ACT_WGT = 'N' OR " ).append("\n"); 
		query.append("		  INFO.WGT_UT_CD = 'N' OR SEAL.CNTR_SEAL_NO IS NULL OR SEAL.SEAL_KND_CD IS NULL OR" ).append("\n"); 
		query.append("		  SEAL.SEAL_PTY_TP_CD IS NULL OR INFO.SHPR_NM = 'N' OR INFO.SHPR_ADDR = 'N' OR" ).append("\n"); 
		query.append("		  INFO.SHPR_CNT = 'N' OR INFO.SHPR_ST_PO = 'N' OR INFO.SHPR_RGST_NO = 'N' OR" ).append("\n"); 
		query.append("		  INFO.SHPR_FAX = 'N' OR INFO.SHPR_EML = 'N' OR INFO.SHPR_PHN = 'N' OR " ).append("\n"); 
		query.append("		  INFO.CNEE_NM = 'N' OR INFO.CNEE_ADDR = 'N' OR INFO.CNEE_CNT = 'N' OR" ).append("\n"); 
		query.append("		  INFO.CNEE_ST_PO = 'N' OR INFO.CNEE_RGST_NO = 'N' OR INFO.CNEE_FAX = 'N' OR" ).append("\n"); 
		query.append("		  INFO.CNEE_EML = 'N' OR INFO.CNEE_PHN = 'N' OR INFO.NTFY_NM = 'N' OR" ).append("\n"); 
		query.append("          INFO.NTFY_ADDR = 'N' OR INFO.NTFY_CNT = 'N' OR INFO.NTFY_ST_PO = 'N' OR" ).append("\n"); 
		query.append("		  INFO.NTFY_RGST_NO = 'N' OR INFO.NTFY_FAX = 'N' OR INFO.NTFY_EML = 'N' OR" ).append("\n"); 
		query.append("		  INFO.NTFY_PHN = 'N' OR INFO.CNTR_CNT = 0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY INFO.BKG_NO, " ).append("\n"); 
		query.append("         INFO.BL_NO," ).append("\n"); 
		query.append("         INFO.POL_CD," ).append("\n"); 
		query.append("         INFO.POD_CD," ).append("\n"); 
		query.append("         INFO.DEL_CD," ).append("\n"); 
		query.append("         INFO.PCK_QTY," ).append("\n"); 
		query.append("         INFO.PCK_TP_CD," ).append("\n"); 
		query.append("         INFO.ACT_WGT," ).append("\n"); 
		query.append("         INFO.WGT_UT_CD," ).append("\n"); 
		query.append("         INFO.SHPR_NM," ).append("\n"); 
		query.append("         INFO.SHPR_ADDR," ).append("\n"); 
		query.append("		 INFO.SHPR_CNT," ).append("\n"); 
		query.append("		 INFO.SHPR_ST_PO," ).append("\n"); 
		query.append("		 INFO.SHPR_RGST_NO," ).append("\n"); 
		query.append("		 INFO.SHPR_FAX," ).append("\n"); 
		query.append("		 INFO.SHPR_EML," ).append("\n"); 
		query.append("		 INFO.SHPR_PHN," ).append("\n"); 
		query.append("         INFO.CNEE_NM," ).append("\n"); 
		query.append("         INFO.CNEE_ADDR," ).append("\n"); 
		query.append("		 INFO.CNEE_CNT," ).append("\n"); 
		query.append("		 INFO.CNEE_ST_PO," ).append("\n"); 
		query.append("		 INFO.CNEE_RGST_NO," ).append("\n"); 
		query.append("		 INFO.CNEE_FAX," ).append("\n"); 
		query.append("		 INFO.CNEE_EML," ).append("\n"); 
		query.append("		 INFO.CNEE_PHN," ).append("\n"); 
		query.append("         INFO.NTFY_NM," ).append("\n"); 
		query.append("         INFO.NTFY_ADDR," ).append("\n"); 
		query.append("		 INFO.NTFY_CNT," ).append("\n"); 
		query.append("		 INFO.NTFY_ST_PO," ).append("\n"); 
		query.append("		 INFO.NTFY_RGST_NO," ).append("\n"); 
		query.append("		 INFO.NTFY_FAX," ).append("\n"); 
		query.append("		 INFO.NTFY_EML," ).append("\n"); 
		query.append("		 INFO.NTFY_PHN," ).append("\n"); 
		query.append("         INFO.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("         INFO.TR," ).append("\n"); 
		query.append("         INFO.DCGO_FLG, " ).append("\n"); 
		query.append("         INFO.RC_FLG," ).append("\n"); 
		query.append("         INFO.DL_FLG," ).append("\n"); 
		query.append("		 INFO.MF_DL_DT," ).append("\n"); 
		query.append("         SLOG.TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("         SLOG.MF_SND_DT," ).append("\n"); 
		query.append("         INFO.CNTR_CNT" ).append("\n"); 
		query.append("ORDER BY INFO.BL_NO" ).append("\n"); 

	}
}