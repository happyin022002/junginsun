/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrDetailForVGMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrDetailForVGMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CLLCDLManifestDBDAOsearchCntrDetailForVGMRSQL
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrDetailForVGMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrDetailForVGMRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	'{CNTR_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTR_QUAL:'||'CN'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTR_NUM:'||CLL.CNTR_NO||CHR(10)||" ).append("\n"); 
		query.append("	'CNTR_TPSZ:'||VSL.ATTR_CTNT2||CHR(10)||" ).append("\n"); 
		query.append("	'CNTR_STS:'||DECODE(CLL.KR_CLL_TS_CD, 'TS', '14', 'TT', '13', '')||CHR(10)||" ).append("\n"); 
		query.append("	'CNTR_FM:'||DECODE(CLL.MTY_BKG_CD, 'F', 5, 4)||CHR(10)||" ).append("\n"); 
		query.append("	'BKG_NUM:'||CLL.BKG_NO||CHR(10)||" ).append("\n"); 
		query.append("	'{LOC_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'LOC_QUAL:'||'11'||CHR(10)||" ).append("\n"); 
		query.append("	'LOC_CD:'|| 	DECODE(CLL.POD_CD,'SADMM','SADMM'," ).append("\n"); 
		query.append("						DECODE(POD.ATTR_CTNT2,NULL,DECODE(CLL.BLCK_STWG_CD,NULL,CLL.POD_CD,DECODE(LENGTH(CLL.BLCK_STWG_CD),2,SUBSTR(CLL.POD_CD,1,3)||CLL.BLCK_STWG_CD,1,SUBSTR(CLL.POD_CD,1,4)||CLL.BLCK_STWG_CD))," ).append("\n"); 
		query.append("							DECODE(CLL.BLCK_STWG_CD,NULL,CLL.POD_CD,DECODE(LENGTH(CLL.BLCK_STWG_CD),2,SUBSTR(POD.ATTR_CTNT2,1,3)||CLL.BLCK_STWG_CD,1,SUBSTR(POD.ATTR_CTNT2,1,4)||CLL.BLCK_STWG_CD))" ).append("\n"); 
		query.append("					))||CHR(10)||" ).append("\n"); 
		query.append("	'LOC_NM:'||(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = (SELECT LOC_CD FROM MDM_LOCATION WHERE NVL(UN_LOC_CD,LOC_CD) = CLL.POD_CD AND ROWNUM=1))||CHR(10)||" ).append("\n"); 
		query.append("	'BLK_STWG:'||CLL.BLCK_STWG_CD||CHR(10)||" ).append("\n"); 
		query.append("	'HOT_DEL:'||DECODE(CLL.HOT_FLG,'Y','1','N','0',CLL.HOT_FLG)||CHR(10)||" ).append("\n"); 
		query.append("	'}LOC_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'{WGT_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'WGT_QUAL:'||'WT'||CHR(10)||" ).append("\n"); 
		query.append("	'WGT_UNIT:'||DECODE(CLL.WGT_UT_CD, 'K', 'KGM', CLL.WGT_UT_CD)||CHR(10)||" ).append("\n"); 
		query.append("	'WGT:'||CLL.BL_WGT||CHR(10)||" ).append("\n"); 
		query.append("	'}WGT_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'{DIM_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'DIM_QUAL:'||'10'||CHR(10)||" ).append("\n"); 
		query.append("	'DIM_UNIT:'||'CMT'||CHR(10)||" ).append("\n"); 
		query.append("	'DIM_LENGTH:'||NVL(CLL.OVR_LEN_QTY, '')||CHR(10)||" ).append("\n"); 
		query.append("	'DIM_WIDTH:'||NVL(CLL.OVR_WGT_QTY, '')||CHR(10)||" ).append("\n"); 
		query.append("	'DIM_HEIGHT:'||NVL(CLL.OVR_HGT_QTY, '')||CHR(10)||" ).append("\n"); 
		query.append("	'}DIM_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'{TEMP_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'TEMP_QUAL:'||DECODE(CLL.CDO_TEMP,NULL,'','2')||CHR(10)||" ).append("\n"); 
		query.append("	'TEMP:'||ROUND(NVL(CLL.CDO_TEMP, ''))||CHR(10)||" ).append("\n"); 
		query.append("	'TEMP_UNIT:'||DECODE(CLL.CDO_TEMP,NULL,'','CEL')||CHR(10)||" ).append("\n"); 
		query.append("	'}TEMP_INFO'||CHR(10)||" ).append("\n"); 
		query.append("    '{VGM'||CHR(10)||" ).append("\n"); 
		query.append("	'DOC_ID:'       || VGM.DOC_ID                   || CHR(10) ||" ).append("\n"); 
		query.append("	'MEAS:'         || CLL.VGM_WGT                  || CHR(10) ||" ).append("\n"); 
		query.append("	'MEAS_UT:'      || SUBSTR(CLL.VGM_WGT_UT_CD,1,1)|| CHR(10) ||" ).append("\n"); 
		query.append("	'DOC_TP:'       || VGM.VGM_DOC_TP               || CHR(10) ||" ).append("\n"); 
		query.append("	'DATE_TP:'      || VGM.VGM_DT_TP_CD             || CHR(10) ||" ).append("\n"); 
		query.append("	'DATE:'         || VGM.VGM_HNDL_DT              || CHR(10) ||" ).append("\n"); 
		query.append("	'CUST_CNTC_TP:' || VGM.CUST_CNTC_TP             || CHR(10) ||" ).append("\n"); 
		query.append("	'CUST_CNTC_NM:' || CUST_CNTC_NM                 || CHR(10) ||" ).append("\n"); 
		query.append("	'CUST_FAX:'     || VGM.CUST_FAX                 || CHR(10) ||" ).append("\n"); 
		query.append("	'CUST_EML:'     || VGM.CUST_EML                 || CHR(10) ||" ).append("\n"); 
		query.append("	'CUST_PHN:'     || VGM.VGM_CUST_PHN_NO          || CHR(10) ||" ).append("\n"); 
		query.append("	'CUST_ML_ADDR:' || VGM.VGM_CUST_PST_ADDR        || CHR(10) ||" ).append("\n"); 
		query.append("    '}VGM'||CHR(10)||" ).append("\n"); 
		query.append("	'{SEAL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'SEAL_NUM:'||REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE((RTRIM(LTRIM(CLL.SEAL_NO))),CHR(42),NULL),CHR(13),NULL),CHR(126),NULL),CHR(34),NULL),CHR(124),NULL),CHR(33),NULL),CHR(47),NULL),CHR(40),NULL),CHR(41),NULL),CHR(38),NULL),CHR(94),NULL),CHR(37),NULL),CHR(36),NULL),CHR(35),NULL),CHR(64),NULL),CHR(43),NULL),CHR(125),NULL),CHR(92),NULL),CHR(123),NULL),CHR(46),NULL),CHR(96),NULL),CHR(63),NULL),CHR(61),NULL),CHR(95),NULL),CHR(45),NULL),CHR(91),NULL),CHR(93),NULL),CHR(32),NULL)||CHR(10)||" ).append("\n"); 
		query.append("	'SEAL_CD:'||'CA'||CHR(10)||" ).append("\n"); 
		query.append("	'}SEAL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'{REMARK'||CHR(10)||" ).append("\n"); 
		query.append("	'REMARK_QUAL:'||" ).append("\n"); 
		query.append("    	DECODE(CLL.CLL_RMK1||CLL.CLL_RMK2||CLL.KR_TML_PRCT_ID" ).append("\n"); 
		query.append("    	,NULL,'','AAN')||CHR(10)||" ).append("\n"); 
		query.append("	'REMARK:'||" ).append("\n"); 
		query.append("    	DECODE(CLL.CLL_RMK1||CLL.CLL_RMK2||CLL.STWG_CD||CLL.KR_TML_PRCT_ID" ).append("\n"); 
		query.append("    	,NULL,''," ).append("\n"); 
		query.append("        CLL.CLL_RMK1||' '||CLL.CLL_RMK2||' '" ).append("\n"); 
		query.append("           ||DECODE(CLL.KR_TML_PRCT_ID,'P','P', NULL))||CHR(10)||" ).append("\n"); 
		query.append("	'}REMARK'||CHR(10)||" ).append("\n"); 
		query.append("	'{DG_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'IMDG_QUAL:'||DECODE(CLL.TML_IMDG_ID,NULL,'','IMD')||CHR(10)||" ).append("\n"); 
		query.append("	'IMDG_CD:'||DECODE(CLL.TML_IMDG_ID,NULL,'',CLL.IMDG_CLSS_ID)||CHR(10)||" ).append("\n"); 
		query.append("	'CLASS:'||DECODE(CLL.TML_IMDG_ID,NULL,'',CLL.TML_IMDG_ID)||CHR(10)||" ).append("\n"); 
		query.append("	'}DG_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'}CNTR_INFO'||CHR(10) CNTR_DETAIL" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("	BKG_CSTMS_CD_CONV_CTNT VSL," ).append("\n"); 
		query.append("	BKG_CSTMS_CD_CONV_CTNT POD," ).append("\n"); 
		query.append("    (SELECT * " ).append("\n"); 
		query.append("        FROM (SELECT BKG_NO, " ).append("\n"); 
		query.append("                     CNTR_NO, " ).append("\n"); 
		query.append("                     DOC_ID," ).append("\n"); 
		query.append("                     VGM_DOC_TP," ).append("\n"); 
		query.append("                     VGM_DT_TP_CD," ).append("\n"); 
		query.append("                     VGM_HNDL_DT," ).append("\n"); 
		query.append("                     CUST_CNTC_TP," ).append("\n"); 
		query.append("                     CUST_CNTC_NM," ).append("\n"); 
		query.append("                     CUST_FAX," ).append("\n"); 
		query.append("                     CUST_EML," ).append("\n"); 
		query.append("                     VGM_CUST_PHN_NO," ).append("\n"); 
		query.append("                     VGM_CUST_PST_ADDR," ).append("\n"); 
		query.append("                     ROW_NUMBER() OVER (PARTITION BY BKG_NO, CNTR_NO ORDER BY VGM_HNDL_DT DESC) AS RNUM" ).append("\n"); 
		query.append("                FROM (SELECT REF_ID AS DOC_ID," ).append("\n"); 
		query.append("                             DECODE(XTER_VGM.USR_ID,'COD','SM1'" ).append("\n"); 
		query.append("                                                              ,'322','SM1'" ).append("\n"); 
		query.append("                                                              ,'304',NVL(XTER_VGM.VGM_DOC_TP_CD,'SM2')" ).append("\n"); 
		query.append("                                                              ,DECODE(XTER_VGM.WGT_TP_CD,'V','SM1','C','SM2')) VGM_DOC_TP,                       " ).append("\n"); 
		query.append("                             'WAT' AS VGM_DT_TP_CD," ).append("\n"); 
		query.append("                             TO_CHAR(XTER_VGM.VGM_CRE_LOCL_DT,'YYYYMMDDHH24MI') AS VGM_HNDL_DT," ).append("\n"); 
		query.append("                             DECODE(ESIG_CO_NM, NULL, '', 'RP') AS CUST_CNTC_TP," ).append("\n"); 
		query.append("                             DECODE(ESIG_CO_NM, NULL, '', ESIG_CO_NM) AS CUST_CNTC_NM," ).append("\n"); 
		query.append("                             NULL AS CUST_FAX," ).append("\n"); 
		query.append("                             XTER_VGM.CUST_EML," ).append("\n"); 
		query.append("                             NULL AS VGM_CUST_PHN_NO," ).append("\n"); 
		query.append("                             NULL AS VGM_CUST_PST_ADDR," ).append("\n"); 
		query.append("                             BC.BKG_NO," ).append("\n"); 
		query.append("                             BC.CNTR_NO," ).append("\n"); 
		query.append("                             XTER_VGM.XTER_VGM_RQST_CD AS VGM_VIA," ).append("\n"); 
		query.append("                             BC.VGM_WGT AS XTER_VGM_WGT," ).append("\n"); 
		query.append("                             'K' AS XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                             XTER_VGM.USR_ID AS IN_USR," ).append("\n"); 
		query.append("                             DECODE(XTER_VGM.ESIG_CO_NM, NULL, 'N', 'Y') AS ESIG," ).append("\n"); 
		query.append("                             XTER_VGM.VGM_SEQ AS VGM_SEQ," ).append("\n"); 
		query.append("                             XTER_VGM.ESIG_CO_NM" ).append("\n"); 
		query.append("                        FROM BKG_XTER_VGM XTER_VGM," ).append("\n"); 
		query.append("                             BKG_CONTAINER BC" ).append("\n"); 
		query.append("                       WHERE XTER_VGM.VGM_CRE_GDT = (SELECT MAX(VGM_CRE_GDT)" ).append("\n"); 
		query.append("                                                   FROM BKG_XTER_VGM" ).append("\n"); 
		query.append("                                                  WHERE BKG_NO = XTER_VGM.BKG_NO" ).append("\n"); 
		query.append("                                                    AND CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("                                                    AND VGM_SEQ = XTER_VGM.VGM_SEQ" ).append("\n"); 
		query.append("                                                    AND ACT_TP_CD = 'I')" ).append("\n"); 
		query.append("                         AND XTER_VGM.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                         AND XTER_VGM.BKG_NO = BC.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                         AND XTER_VGM.VGM_SEQ = BC.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                         AND XTER_VGM.USR_ID = BC.XTER_VGM_USR_ID" ).append("\n"); 
		query.append("                         AND BC.XTER_SNDR_ID = 'WEB'" ).append("\n"); 
		query.append("                         AND BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                         AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT BXVC.VGM_DOC_ID," ).append("\n"); 
		query.append("                             NVL((SELECT VGM_DOC_TP_CD" ).append("\n"); 
		query.append("                                    FROM BKG_XTER_VGM_CUST" ).append("\n"); 
		query.append("                                   WHERE BXVR.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                     AND BXVR.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                     AND BXVR.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                     AND BXVR.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("                                     AND VGM_DOC_TP_CD IN ('SM1', 'SM2')" ).append("\n"); 
		query.append("                                     AND ROWNUM = 1), 'SM1') VGM_DOC_TP," ).append("\n"); 
		query.append("                             BXVC.VGM_DT_TP_CD," ).append("\n"); 
		query.append("                             TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', BXVR.UPD_DT, (SELECT POL_CD" ).append("\n"); 
		query.append("                                                                                           FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                                                                          WHERE BKG_NO = REFNO.REF_NO)), 'YYYYMMDDHH24MI') VGM_HNDL_DT," ).append("\n"); 
		query.append("                             BXVC.VGM_CUST_CNTC_TP_CD AS CUST_CNTC_TP," ).append("\n"); 
		query.append("                             BXVC.VGM_CUST_CNTC_NM AS CUST_CNTC_NM," ).append("\n"); 
		query.append("                             BXVC.VGM_CUST_FAX_NO," ).append("\n"); 
		query.append("                             BXVC.VGM_CUST_EML," ).append("\n"); 
		query.append("                             BXVC.VGM_CUST_PHN_NO," ).append("\n"); 
		query.append("                             BXVC.VGM_CUST_PST_ADDR," ).append("\n"); 
		query.append("                             BC.BKG_NO," ).append("\n"); 
		query.append("                             BC.CNTR_NO," ).append("\n"); 
		query.append("                             'EDI' VGM_VIA," ).append("\n"); 
		query.append("                             BC.VGM_WGT AS XTER_VGM_WGT," ).append("\n"); 
		query.append("                             'K' AS XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                             BXVR.XTER_SNDR_ID IN_USR," ).append("\n"); 
		query.append("                             DECODE(BXVC.VGM_CUST_CNTC_NM, NULL, 'N', 'Y') ESIG," ).append("\n"); 
		query.append("                             BXVR.XTER_VGM_RQST_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                             BXVC.VGM_CUST_CNTC_NM ESIG_CO_NM" ).append("\n"); 
		query.append("                        FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("                             BKG_XTER_VGM_CUST BXVC," ).append("\n"); 
		query.append("                             BKG_XTER_VGM_REF_NO REFNO," ).append("\n"); 
		query.append("                             BKG_CONTAINER BC" ).append("\n"); 
		query.append("                       WHERE BXVR.XTER_SNDR_ID = BXVC.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                         AND BXVR.XTER_VGM_DOC_ID = BXVC.XTER_VGM_DOC_ID(+)" ).append("\n"); 
		query.append("                         AND BXVR.XTER_VGM_RQST_SEQ = BXVC.XTER_VGM_RQST_SEQ(+)" ).append("\n"); 
		query.append("                         AND BXVR.CNTR_NO = BXVC.CNTR_NO(+)" ).append("\n"); 
		query.append("                         AND BXVC.VGM_CUST_CNTC_TP_CD(+) = 'RP'" ).append("\n"); 
		query.append("                         AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("                         AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                         AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                         AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("                         AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("                                                                 FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("                                                                WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                                  AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                                  AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                                                  AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("                                                                  AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("                                                                  AND XTER_REF_TP_CD IN ('BN', 'BM')), 0)" ).append("\n"); 
		query.append("                         AND BC.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("                         AND BC.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                         AND BC.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                         AND BC.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("                         AND NVL(BC.XTER_SNDR_ID,'X') <> 'WEB'" ).append("\n"); 
		query.append("                         AND BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                         AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            WHERE RNUM = 1" ).append("\n"); 
		query.append("     ) VGM" ).append("\n"); 
		query.append("WHERE CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND CLL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CLL.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CLL.BKG_NO = VGM.BKG_NO(+)" ).append("\n"); 
		query.append("AND CLL.CNTR_NO = VGM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND CLL.CNTR_TPSZ_CD = VSL.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND CLL.POD_CD = POD.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND VSL.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("AND VSL.CSTMS_DIV_ID(+) = 'CLL_CNTR_ISO_CD' " ).append("\n"); 
		query.append("AND POD.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("AND POD.CSTMS_DIV_ID(+) = 'KR_CLL_EDI_POD_CD' " ).append("\n"); 
		query.append("AND VSL.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("#if (${in_pol_yd_cd} != '' ) " ).append("\n"); 
		query.append("AND CLL.POL_YD_CD = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cll_type} == 'LOCAL')" ).append("\n"); 
		query.append("AND CLL.KR_CLL_TS_CD IS NULL" ).append("\n"); 
		query.append("AND CLL.MTY_BKG_CD = 'F'" ).append("\n"); 
		query.append("#elseif (${in_cll_type} == 'TS')" ).append("\n"); 
		query.append("AND CLL.KR_CLL_TS_CD IS NOT NULL" ).append("\n"); 
		query.append("AND CLL.MTY_BKG_CD = 'F'" ).append("\n"); 
		query.append("#elseif (${in_cll_type} == 'EMPTY')" ).append("\n"); 
		query.append("AND CLL.MTY_BKG_CD = 'M'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}