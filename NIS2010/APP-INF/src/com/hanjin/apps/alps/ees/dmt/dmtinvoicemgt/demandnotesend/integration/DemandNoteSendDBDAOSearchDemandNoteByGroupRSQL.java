/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : DemandNoteSendDBDAOSearchDemandNoteByGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemandNoteSendDBDAOSearchDemandNoteByGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDemandNoteByGroup
	  * </pre>
	  */
	public DemandNoteSendDBDAOSearchDemandNoteByGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DemandNoteSendDBDAOSearchDemandNoteByGroupRSQL").append("\n"); 
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
		query.append("SELECT   VVD_CD" ).append("\n"); 
		query.append("        ,LOC" ).append("\n"); 
		query.append("        ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,FM_MVMT_DT" ).append("\n"); 
		query.append("        ,TO_MVMT_DT" ).append("\n"); 
		query.append("        ,FT_CMNC_DT" ).append("\n"); 
		query.append("        ,FT_END_DT" ).append("\n"); 
		query.append("        ,FM_MVMT_DT_RD" ).append("\n"); 
		query.append("        ,TO_MVMT_DT_RD" ).append("\n"); 
		query.append("        ,FT_CMNC_DT_RD" ).append("\n"); 
		query.append("        ,FT_END_DT_RD" ).append("\n"); 
		query.append("        ,FT_DYS" ).append("\n"); 
		query.append("        ,FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        ,BKG_NO" ).append("\n"); 
		query.append("        ,BL_NO" ).append("\n"); 
		query.append("        ,CNTR_NO" ).append("\n"); 
		query.append("        ,DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        ,OFC_CD" ).append("\n"); 
		query.append("        ,FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        ,PORT" ).append("\n"); 
		query.append("        ,DMDT_TRF_CD" ).append("\n"); 
		query.append("        ,DECODE(" ).append("\n"); 
		query.append("			(CASE WHEN LENGTH(PAYER_CD) = 8 THEN  " ).append("\n"); 
		query.append("           			CASE WHEN SUBSTR(PAYER_CD, 1, 2) = '00' " ).append("\n"); 
		query.append("                     	THEN SUBSTR(PAYER_CD, 3) ELSE PAYER_CD END " ).append("\n"); 
		query.append("           			ELSE PAYER_CD END) , '000000',''," ).append("\n"); 
		query.append("			(CASE WHEN LENGTH(PAYER_CD) = 8 THEN  " ).append("\n"); 
		query.append("           			CASE WHEN SUBSTR(PAYER_CD, 1, 2) = '00' " ).append("\n"); 
		query.append("                     	THEN SUBSTR(PAYER_CD, 3) ELSE PAYER_CD END " ).append("\n"); 
		query.append("           		ELSE PAYER_CD END)" ).append("\n"); 
		query.append("			) AS PAYER_CD" ).append("\n"); 
		query.append("        ,PAYER_NM" ).append("\n"); 
		query.append("        ,SHIPPER_CD" ).append("\n"); 
		query.append("        ,SHIPPER_NM" ).append("\n"); 
		query.append("        ,CNEE_CD" ).append("\n"); 
		query.append("        ,CNEE_NM" ).append("\n"); 
		query.append("        ,NTFY_CD" ).append("\n"); 
		query.append("        ,NTFY_NM" ).append("\n"); 
		query.append("        ,AR_ACT_CD" ).append("\n"); 
		query.append("        ,AR_ACT_NM" ).append("\n"); 
		query.append("        ,SVC_PROVDR_CD" ).append("\n"); 
		query.append("        ,SVC_PROVDR_NM" ).append("\n"); 
		query.append("        ,SC_NO" ).append("\n"); 
		query.append("        ,RFA_NO" ).append("\n"); 
		query.append("        ,AR_CURR_CD AS INV_CURR_CD" ).append("\n"); 
		query.append("        ,BIL_AMT AS INV_CHG_AMT" ).append("\n"); 
		query.append("        ,ORG_CHG_AMT AS INV_ORG_AMT" ).append("\n"); 
		query.append("        ,DC_AMT AS INV_DC_AMT" ).append("\n"); 
		query.append("        ,ORG_CURR_CD" ).append("\n"); 
		query.append("        ,ORG_CHG_AMT" ).append("\n"); 
		query.append("        ,EXPT_AMT" ).append("\n"); 
		query.append("        ,DC_AMT" ).append("\n"); 
		query.append("        ,BIL_AMT" ).append("\n"); 
		query.append("        ,AR_XCH_RT AS INV_XCH_RT" ).append("\n"); 
		query.append("        ,SVR_ID" ).append("\n"); 
		query.append("        ,CNTR_CYC_NO" ).append("\n"); 
		query.append("        ,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        ,CHG_SEQ" ).append("\n"); 
		query.append("        ,DMDT_INV_NO" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,POD_CD" ).append("\n"); 
		query.append("        ,POR_CD" ).append("\n"); 
		query.append("        ,DEL_CD" ).append("\n"); 
		query.append("    FROM (SELECT B.VSL_CD" ).append("\n"); 
		query.append("                 || B.SKD_VOY_NO" ).append("\n"); 
		query.append("                 || B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                ,CASE" ).append("\n"); 
		query.append("                    WHEN C.DMDT_TRF_CD IN ('DMIF', 'DMOF')" ).append("\n"); 
		query.append("                       THEN SUBSTR (C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("                                   ,1" ).append("\n"); 
		query.append("                                   ,5" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                    WHEN C.DMDT_TRF_CD IN ('DTIC', 'CTIC')" ).append("\n"); 
		query.append("                       THEN B.DEL_CD" ).append("\n"); 
		query.append("                    ELSE B.POR_CD" ).append("\n"); 
		query.append("                 END AS LOC" ).append("\n"); 
		query.append("                ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,TO_CHAR (C.FM_MVMT_DT" ).append("\n"); 
		query.append("                         ,'YYYYMMDD'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS FM_MVMT_DT" ).append("\n"); 
		query.append("                ,TO_CHAR (C.TO_MVMT_DT" ).append("\n"); 
		query.append("                         ,'YYYYMMDD'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS TO_MVMT_DT" ).append("\n"); 
		query.append("                ,TO_CHAR (C.FT_CMNC_DT" ).append("\n"); 
		query.append("                         ,'YYYYMMDD'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS FT_CMNC_DT" ).append("\n"); 
		query.append("                ,TO_CHAR (C.FT_END_DT" ).append("\n"); 
		query.append("                         ,'YYYYMMDD'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS FT_END_DT" ).append("\n"); 
		query.append("                ,TO_CHAR (C.FM_MVMT_DT" ).append("\n"); 
		query.append("                         ,'DDMonYY'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS FM_MVMT_DT_RD" ).append("\n"); 
		query.append("                ,TO_CHAR (C.TO_MVMT_DT" ).append("\n"); 
		query.append("                         ,'DDMonYY'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS TO_MVMT_DT_RD" ).append("\n"); 
		query.append("                ,TO_CHAR (C.FT_CMNC_DT" ).append("\n"); 
		query.append("                         ,'DDMonYY'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS FT_CMNC_DT_RD" ).append("\n"); 
		query.append("                ,TO_CHAR (C.FT_END_DT" ).append("\n"); 
		query.append("                         ,'DDMonYY'" ).append("\n"); 
		query.append("                         ,'NLS_DATE_LANGUAGE = American'" ).append("\n"); 
		query.append("                         ) AS FT_END_DT_RD" ).append("\n"); 
		query.append("                ,C.FT_DYS" ).append("\n"); 
		query.append("                ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("                ,B.BKG_NO" ).append("\n"); 
		query.append("                ,B.BL_NO" ).append("\n"); 
		query.append("                ,C.CNTR_NO" ).append("\n"); 
		query.append("                ,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("                ,C.OFC_CD" ).append("\n"); 
		query.append("                ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("                ,DECODE (SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                ,3" ).append("\n"); 
		query.append("                                ,1" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                        ,'O', B.POR_CD" ).append("\n"); 
		query.append("                        ,B.DEL_CD" ).append("\n"); 
		query.append("                        ) AS PORT" ).append("\n"); 
		query.append("                ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("				,DECODE (C.ACT_CNT_CD,'00', '',C.ACT_CNT_CD)" ).append("\n"); 
		query.append("        		         || TO_CHAR (C.ACT_CUST_SEQ, 'FM000000') AS PAYER_CD" ).append("\n"); 
		query.append("                ,CASE" ).append("\n"); 
		query.append("                    WHEN C.DMDT_TRF_CD = 'DTIC'" ).append("\n"); 
		query.append("                    AND INSTR (NVL (B.POD_CD, '  '), 'US') = 1" ).append("\n"); 
		query.append("                       THEN (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                               FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                              WHERE MV.VNDR_SEQ = C.VNDR_SEQ)" ).append("\n"); 
		query.append("                    WHEN C.DMDT_TRF_CD = 'DTOC'" ).append("\n"); 
		query.append("                    AND INSTR (NVL (B.POL_CD, '  '), 'US') = 1" ).append("\n"); 
		query.append("                       THEN (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                               FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                              WHERE MV.VNDR_SEQ = C.VNDR_SEQ)" ).append("\n"); 
		query.append("                    WHEN C.DMDT_TRF_CD IN ('DMIF', 'CTIC')" ).append("\n"); 
		query.append("                     OR (    C.DMDT_TRF_CD = 'DTIC'" ).append("\n"); 
		query.append("                         AND INSTR (NVL (B.POD_CD, '  '), 'US') <> 1" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                       THEN (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                               FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                              WHERE MC.CUST_CNT_CD = C.ACT_CNT_CD" ).append("\n"); 
		query.append("                                AND MC.CUST_SEQ = C.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                    WHEN C.DMDT_TRF_CD IN ('DMOF', 'CTOC')" ).append("\n"); 
		query.append("                     OR (    C.DMDT_TRF_CD = 'DTOC'" ).append("\n"); 
		query.append("                         AND INSTR (NVL (B.POL_CD, '  '), 'US') <> 1" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                       THEN REPLACE (BS.CUST_NM" ).append("\n"); 
		query.append("                                    , CHR (13)" ).append("\n"); 
		query.append("                                      || CHR (10)" ).append("\n"); 
		query.append("                                    ,' '" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                 END AS PAYER_NM" ).append("\n"); 
		query.append("                , BS.CUST_CNT_CD" ).append("\n"); 
		query.append("                  || TRIM (TO_CHAR (BS.CUST_SEQ, '000000')) SHIPPER_CD" ).append("\n"); 
		query.append("                ,REPLACE (BS.CUST_NM" ).append("\n"); 
		query.append("                         , CHR (13)" ).append("\n"); 
		query.append("                           || CHR (10)" ).append("\n"); 
		query.append("                         ,' '" ).append("\n"); 
		query.append("                         ) SHIPPER_NM" ).append("\n"); 
		query.append("                ,DECODE (BC.CUST_CNT_CD" ).append("\n"); 
		query.append("                         || TRIM (TO_CHAR (BC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("                        ,'000000', NULL" ).append("\n"); 
		query.append("                        , BC.CUST_CNT_CD" ).append("\n"); 
		query.append("                          || TRIM (TO_CHAR (BC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("                        ) CNEE_CD" ).append("\n"); 
		query.append("                ,REPLACE (BC.CUST_NM" ).append("\n"); 
		query.append("                         , CHR (13)" ).append("\n"); 
		query.append("                           || CHR (10)" ).append("\n"); 
		query.append("                         ,' '" ).append("\n"); 
		query.append("                         ) CNEE_NM" ).append("\n"); 
		query.append("                ,DECODE (BN.CUST_CNT_CD" ).append("\n"); 
		query.append("                         || TRIM (TO_CHAR (BN.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("                        ,'000000', NULL" ).append("\n"); 
		query.append("                        , BN.CUST_CNT_CD" ).append("\n"); 
		query.append("                          || TRIM (TO_CHAR (BN.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("                        ) NTFY_CD" ).append("\n"); 
		query.append("                ,NVL (RTRIM (REPLACE (REPLACE (BN.CUST_NM" ).append("\n"); 
		query.append("                                              ,CHR (34)" ).append("\n"); 
		query.append("                                              ,''" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                     , CHR (13)" ).append("\n"); 
		query.append("                                       || CHR (10)" ).append("\n"); 
		query.append("                                     ,' '" ).append("\n"); 
		query.append("                                     ))" ).append("\n"); 
		query.append("                     ,'-') NTFY_NM" ).append("\n"); 
		query.append("                , (SELECT I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                          || TRIM (TO_CHAR (ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("                     FROM INV_AR_MN I" ).append("\n"); 
		query.append("                    WHERE I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                      AND I.IO_BND_CD = SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                               ,3" ).append("\n"); 
		query.append("                                               ,1" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                      AND AR_IF_NO =" ).append("\n"); 
		query.append("                             (SELECT MAX (AR_IF_NO)" ).append("\n"); 
		query.append("                                FROM INV_AR_MN" ).append("\n"); 
		query.append("                               WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND IO_BND_CD = SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                                        ,3" ).append("\n"); 
		query.append("                                                        ,1" ).append("\n"); 
		query.append("                                                        ))" ).append("\n"); 
		query.append("                      AND ROWNUM = 1) AS AR_ACT_CD" ).append("\n"); 
		query.append("                , (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                     FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                         ,INV_AR_MN I" ).append("\n"); 
		query.append("                    WHERE MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                      AND MC.CUST_SEQ = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                      AND I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                      AND I.IO_BND_CD = SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                               ,3" ).append("\n"); 
		query.append("                                               ,1" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                      AND AR_IF_NO =" ).append("\n"); 
		query.append("                             (SELECT MAX (AR_IF_NO)" ).append("\n"); 
		query.append("                                FROM INV_AR_MN" ).append("\n"); 
		query.append("                               WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                 AND IO_BND_CD = SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                                        ,3" ).append("\n"); 
		query.append("                                                        ,1" ).append("\n"); 
		query.append("                                                        ))" ).append("\n"); 
		query.append("                      AND ROWNUM = 1) AS AR_ACT_NM" ).append("\n"); 
		query.append("                ,DECODE (TRIM (TO_CHAR (C.VNDR_SEQ, '000000'))" ).append("\n"); 
		query.append("                        ,'000000', NULL" ).append("\n"); 
		query.append("                        ,TRIM (TO_CHAR (C.VNDR_SEQ, '000000'))" ).append("\n"); 
		query.append("                        ) AS SVC_PROVDR_CD" ).append("\n"); 
		query.append("                , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                     FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                    WHERE MV.VNDR_SEQ = C.VNDR_SEQ) AS SVC_PROVDR_NM" ).append("\n"); 
		query.append("                ,B.SC_NO" ).append("\n"); 
		query.append("                ,B.RFA_NO" ).append("\n"); 
		query.append("                ,C.BZC_TRF_CURR_CD AS ORG_CURR_CD" ).append("\n"); 
		query.append("                ,C.ORG_CHG_AMT AS ORG_CHG_AMT" ).append("\n"); 
		query.append("                ,C.SC_RFA_EXPT_AMT AS EXPT_AMT" ).append("\n"); 
		query.append("                ,C.AFT_EXPT_DC_AMT AS DC_AMT" ).append("\n"); 
		query.append("                ,C.BIL_AMT" ).append("\n"); 
		query.append("                ,C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("                ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                ,C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                ,C.CHG_SEQ" ).append("\n"); 
		query.append("                ,CASE WHEN (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]) IN ('MTRBS', 'TORSC', 'VANSO') THEN 'USD'" ).append("\n"); 
		query.append("          			  ELSE (SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("          			   END AS AR_CURR_CD" ).append("\n"); 
		query.append("                ,1 AS AR_XCH_RT" ).append("\n"); 
		query.append("                ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                ,C.DMDT_INV_NO" ).append("\n"); 
		query.append("                ,B.VSL_CD" ).append("\n"); 
		query.append("                ,B.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,B.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,B.POL_CD" ).append("\n"); 
		query.append("                ,B.POD_CD" ).append("\n"); 
		query.append("                ,B.POR_CD" ).append("\n"); 
		query.append("                ,B.DEL_CD" ).append("\n"); 
		query.append("            FROM DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("                ,DMT_CHG_CALC C" ).append("\n"); 
		query.append("                ,BKG_CUSTOMER BS" ).append("\n"); 
		query.append("                ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                ,BKG_CUSTOMER BN" ).append("\n"); 
		query.append("           WHERE B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("             AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("             AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("             AND B.BKG_NO = BS.BKG_NO(+)" ).append("\n"); 
		query.append("             AND BS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("             AND B.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("             AND BC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("             AND B.BKG_NO = BN.BKG_NO(+)" ).append("\n"); 
		query.append("             AND BN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("             AND C.OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("             AND C.DMDT_TRF_CD = @[s_dmdt_trf_cd]" ).append("\n"); 
		query.append("#if (${dmdt_chg_sts_cds} != '') " ).append("\n"); 
		query.append("   			AND C.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("        		#foreach( $chg_sts_cd in ${chg_sts_cd_list} )" ).append("\n"); 
		query.append("            		#if($velocityCount < $chg_sts_cd_list.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("   			AND B.BKG_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("ORDER BY X.BKG_NO" ).append("\n"); 
		query.append("        ,X.CNTR_NO" ).append("\n"); 

	}
}