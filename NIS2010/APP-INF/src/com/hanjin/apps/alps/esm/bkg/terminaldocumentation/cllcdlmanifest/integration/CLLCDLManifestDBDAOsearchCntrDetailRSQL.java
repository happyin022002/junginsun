/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrDetail
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrDetailRSQL(){
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
		params.put("in_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrDetailRSQL").append("\n"); 
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
		query.append("	'{13'||CHR(10)||" ).append("\n"); 
		query.append("	'CN'||CHR(10)||" ).append("\n"); 
		query.append("	CLL.CNTR_NO||CHR(10)||" ).append("\n"); 
		query.append("	VSL.ATTR_CTNT2||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(CLL.KR_CLL_TS_CD, 'TS', '14', 'TT', '13', '')||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(CLL.MTY_BKG_CD, 'F', 5, 4)||CHR(10)||" ).append("\n"); 
		query.append("	CLL.BKG_NO||CHR(10)||" ).append("\n"); 
		query.append("	'{22'||CHR(10)||" ).append("\n"); 
		query.append("	'11'||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(CLL.POD_CD,'SADMM', CASE WHEN (SELECT VVD.SLAN_CD " ).append("\n"); 
		query.append("                                       FROM  BKG_VVD VVD, MDM_LOCATION X" ).append("\n"); 
		query.append("                                      WHERE VVD.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("                                       AND   VVD.VSL_CD = CLL.VSL_CD" ).append("\n"); 
		query.append("                                       AND   VVD.SKD_VOY_NO = CLL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       AND   VVD.SKD_DIR_CD = CLL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       AND   VVD.POD_CD  = X.LOC_CD" ).append("\n"); 
		query.append("                                       AND   CLL.POD_CD = X.UN_LOC_CD" ).append("\n"); 
		query.append("                                       ) = 'PSG'" ).append("\n"); 
		query.append("                                 THEN CASE WHEN  (SELECT BB.BLCK_STWG_CD " ).append("\n"); 
		query.append("                                       FROM  BKG_BOOKING BB" ).append("\n"); 
		query.append("                                       WHERE BB.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("                                       AND 1=1" ).append("\n"); 
		query.append("                                       ) = 'DM1'" ).append("\n"); 
		query.append("                                       THEN 'SADM1'" ).append("\n"); 
		query.append("                                       WHEN (SELECT BB.BLCK_STWG_CD " ).append("\n"); 
		query.append("                                       FROM  BKG_BOOKING BB" ).append("\n"); 
		query.append("                                       WHERE BB.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("                                       AND 1=1" ).append("\n"); 
		query.append("                                       ) = 'DM2'" ).append("\n"); 
		query.append("                                       THEN 'SADM2'" ).append("\n"); 
		query.append("                                       ELSE 'SADMM'" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("                                   ELSE 'SADMM' END," ).append("\n"); 
		query.append("    	'CNSHA', CASE WHEN (SELECT VVD.SLAN_CD " ).append("\n"); 
		query.append("                                       FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("                                       WHERE VVD.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("                                       AND   VVD.VSL_CD = CLL.VSL_CD" ).append("\n"); 
		query.append("                                       AND   VVD.SKD_VOY_NO = CLL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       AND   VVD.SKD_DIR_CD = CLL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       AND   VVD.POD_CD  = CLL.POD_CD" ).append("\n"); 
		query.append("                                       ) = 'NE6'" ).append("\n"); 
		query.append("                                 THEN CASE WHEN  (SELECT BB.BLCK_STWG_CD " ).append("\n"); 
		query.append("                                       FROM  BKG_BOOKING BB" ).append("\n"); 
		query.append("                                       WHERE BB.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("                                       AND 1=1" ).append("\n"); 
		query.append("                                       ) = 'SH1'" ).append("\n"); 
		query.append("                                       THEN 'CNSH1'" ).append("\n"); 
		query.append("                                       WHEN (SELECT BB.BLCK_STWG_CD " ).append("\n"); 
		query.append("                                       FROM  BKG_BOOKING BB" ).append("\n"); 
		query.append("                                       WHERE BB.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("                                       AND 1=1" ).append("\n"); 
		query.append("                                       ) = 'SH2'" ).append("\n"); 
		query.append("                                       THEN 'CNSH2'" ).append("\n"); 
		query.append("                                       ELSE 'CNSHA'" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("                                   ELSE 'CNSHA' END," ).append("\n"); 
		query.append("		'KRPUS', CASE WHEN CLL.POL_CD IN ('KRINC','KRKAN')" ).append("\n"); 
		query.append("             		 THEN CASE WHEN (SELECT VVD.SLAN_CD" ).append("\n"); 
		query.append("                                      FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("                                      WHERE VVD.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("                                      AND   VVD.VSL_CD = CLL.VSL_CD" ).append("\n"); 
		query.append("                                      AND   VVD.SKD_VOY_NO = CLL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND   VVD.SKD_DIR_CD = CLL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      AND   VVD.POD_CD  = CLL.POD_CD" ).append("\n"); 
		query.append("                                      ) = 'KPI'" ).append("\n"); 
		query.append("                         THEN CASE WHEN CLL.POD_YD_CD = 'YG'" ).append("\n"); 
		query.append("                                   THEN 'KRPU1' " ).append("\n"); 
		query.append("                                   ELSE 'KRPUS'" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                         ELSE 'KRPUS'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("              ELSE 'KRPUS'" ).append("\n"); 
		query.append("         END,  -- Add, 2014.11.05" ).append("\n"); 
		query.append("        'MYPKG'," ).append("\n"); 
		query.append("		DECODE(CLL.VSL_CD,'KOPI','MYWSP','KTOB','MYWSP','SCTR','MYWSP','KOPD','MYWSP','KPER','MYWSP'," ).append("\n"); 
		query.append("			DECODE(@[in_rcv_id], " ).append("\n"); 
		query.append("				'DPCTC010',DECODE(CLL.POD_CD,'CNXGG','CNTSN',NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = CLL.POD_CD AND ROWNUM=1),CLL.POD_CD))," ).append("\n"); 
		query.append("				'PNCOC010',DECODE(CLL.POD_CD,'SADMN','SADMN',NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = CLL.POD_CD AND ROWNUM=1),CLL.POD_CD)), " ).append("\n"); 
		query.append("				NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = CLL.POD_CD AND ROWNUM=1),CLL.POD_CD)))," ).append("\n"); 
		query.append("		DECODE(@[in_rcv_id], " ).append("\n"); 
		query.append("			'DPCTC010',DECODE(CLL.POD_CD,'CNXGG','CNTSN','CAYVR','CAVAN','CAVA1','CAVA1','USSE1','USSE1',NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = CLL.POD_CD AND ROWNUM=1),CLL.POD_CD))," ).append("\n"); 
		query.append("			'PNCOC010',DECODE(CLL.POD_CD,'SADMN','SADMN','CAYVR','CAVAN','CAVA1','CAVA1','USSE1','USSE1',NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = CLL.POD_CD AND ROWNUM=1),CLL.POD_CD)), " ).append("\n"); 
		query.append("			'ICTPC050',DECODE(CLL.POD_CD,'CNXGG','CNTXG',NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = CLL.POD_CD AND ROWNUM=1),CLL.POD_CD)), " ).append("\n"); 
		query.append("			NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = CLL.POD_CD AND ROWNUM=1),DECODE(CLL.POD_CD,'CAYVR','CAVAN',CLL.POD_CD))))||CHR(10)||" ).append("\n"); 
		query.append("	(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = (SELECT LOC_CD FROM MDM_LOCATION WHERE NVL(UN_LOC_CD,LOC_CD) = DECODE(CLL.POD_CD, 'CAYVR','CAVAN', 'CAVA1','CAVAN', 'USSE1','USSEA', 'USSE8','USSEA', 'CAPR1','CAPRR', CLL.POD_CD) AND ROWNUM=1))||CHR(10)||" ).append("\n"); 
		query.append("	CLL.BLCK_STWG_CD||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(CLL.HOT_FLG,'Y','1','N','0',CLL.HOT_FLG)||CHR(10)||" ).append("\n"); 
		query.append("	'}22'||CHR(10)||" ).append("\n"); 
		query.append("	'{23'||CHR(10)||" ).append("\n"); 
		query.append("	'WT'||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(CLL.WGT_UT_CD, 'K', 'KGM', CLL.WGT_UT_CD)||CHR(10)||" ).append("\n"); 
		query.append("	CLL.BL_WGT||CHR(10)||" ).append("\n"); 
		query.append("	'}23'||CHR(10)||" ).append("\n"); 
		query.append("	'{24'||CHR(10)||" ).append("\n"); 
		query.append("	'10'||CHR(10)||" ).append("\n"); 
		query.append("	'CMT'||CHR(10)||" ).append("\n"); 
		query.append("	NVL(CLL.OVR_LEN_QTY, '')||CHR(10)||" ).append("\n"); 
		query.append("	NVL(CLL.OVR_WGT_QTY, '')||CHR(10)||" ).append("\n"); 
		query.append("	NVL(CLL.OVR_HGT_QTY, '')||CHR(10)||" ).append("\n"); 
		query.append("	'}24'||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(CLL.CDO_TEMP,NULL,'','{25'||CHR(10)||" ).append("\n"); 
		query.append("	'2'||CHR(10)||" ).append("\n"); 
		query.append("	NVL(CLL.CDO_TEMP, '')||CHR(10)||" ).append("\n"); 
		query.append("	'CEL'||CHR(10)||" ).append("\n"); 
		query.append("	'}25'||CHR(10))||" ).append("\n"); 
		query.append("	'{27'||CHR(10)||" ).append("\n"); 
		query.append("	REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE((RTRIM(LTRIM(CLL.SEAL_NO))),CHR(42),NULL),CHR(13),NULL),CHR(126),NULL),CHR(34),NULL),CHR(124),NULL),CHR(33),NULL),CHR(47),NULL),CHR(40),NULL),CHR(41),NULL),CHR(38),NULL),CHR(94),NULL),CHR(37),NULL),CHR(36),NULL),CHR(35),NULL),CHR(64),NULL),CHR(43),NULL),CHR(125),NULL),CHR(92),NULL),CHR(123),NULL),CHR(46),NULL),CHR(96),NULL),CHR(63),NULL),CHR(61),NULL),CHR(95),NULL),CHR(45),NULL),CHR(91),NULL),CHR(93),NULL),CHR(32),NULL)||CHR(10)||" ).append("\n"); 
		query.append("	'CA'||CHR(10)||" ).append("\n"); 
		query.append("	'}27'||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(CASE WHEN CLL.CLL_RMK1 IS NULL THEN NULL" ).append("\n"); 
		query.append("	   WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='S' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='-' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) BETWEEN '1' AND '9' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) = '0' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='O' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='+' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='.' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) ='RD' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='BB :' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='INGU' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) IN ('F:', 'B:', 'H:', 'L:', 'R:') THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,3) ='PS:' THEN NULL" ).append("\n"); 
		query.append("       ELSE CLL.CLL_RMK1" ).append("\n"); 
		query.append("       END||" ).append("\n"); 
		query.append("       CASE WHEN CLL.CLL_RMK2 IS NULL THEN NULL" ).append("\n"); 
		query.append("	   WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='S' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='-' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) BETWEEN '1' AND '9' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) = '0' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='O' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='+' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='.' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) ='RD' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='BB :' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='INGU' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) IN ('F:', 'B:', 'H:', 'L:', 'R:') THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,3) ='PS:' THEN NULL" ).append("\n"); 
		query.append("       ELSE CLL.CLL_RMK2 END||CLL.STWG_CD||CLL.KR_TML_PRCT_ID,NULL,'','{28'||CHR(10)||" ).append("\n"); 
		query.append("	'AAN'||CHR(10)||" ).append("\n"); 
		query.append("	''||" ).append("\n"); 
		query.append("    CASE WHEN CLL.CLL_RMK1 IS NULL THEN NULL" ).append("\n"); 
		query.append("	   WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='S' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='-' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) BETWEEN '1' AND '9' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) = '0' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='O' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='+' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='.' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) ='RD' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='BB :' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='INGU' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) IN ('F:', 'B:', 'H:', 'L:', 'R:') THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,3) ='PS:' THEN NULL" ).append("\n"); 
		query.append("       ELSE CLL.CLL_RMK1||' '" ).append("\n"); 
		query.append("       END||" ).append("\n"); 
		query.append("       CASE WHEN CLL.CLL_RMK2 IS NULL THEN NULL" ).append("\n"); 
		query.append("	   WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='S' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='-' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) BETWEEN '1' AND '9' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) = '0' THEN NULL " ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='O' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='+' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,1) ='.' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) ='RD' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='BB :' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,4) ='INGU' THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,2) IN ('F:', 'B:', 'H:', 'L:', 'R:') THEN NULL" ).append("\n"); 
		query.append("       WHEN SUBSTR(CLL.CLL_RMK1,1,3) ='PS:' THEN NULL" ).append("\n"); 
		query.append("       ELSE CLL.CLL_RMK2||' '" ).append("\n"); 
		query.append("       END||" ).append("\n"); 
		query.append("    CLL.STWG_CD||DECODE(CLL.STWG_CD,NULL,'',' ')||DECODE(CLL.KR_TML_PRCT_ID,'P','P', NULL)||CHR(10)||" ).append("\n"); 
		query.append("	'}28'||CHR(10))||  	" ).append("\n"); 
		query.append("	DECODE(CLL.TML_IMDG_ID,NULL,'','{29'||CHR(10)||" ).append("\n"); 
		query.append("	'IMD'||CHR(10)||" ).append("\n"); 
		query.append("	CLL.IMDG_CLSS_ID||CHR(10)||" ).append("\n"); 
		query.append("	CLL.TML_IMDG_ID||CHR(10)||" ).append("\n"); 
		query.append("	'}29'||CHR(10))||" ).append("\n"); 
		query.append("	'{30'||CHR(10)||" ).append("\n"); 
		query.append("	'AAW'||CHR(10)||" ).append("\n"); 
		query.append("	CLL.VGM_MZD_TP_CD ||CHR(10)||" ).append("\n"); 
		query.append("    'KGM' ||CHR(10)||" ).append("\n"); 
		query.append("	CLL.VGM_WGT ||CHR(10)||" ).append("\n"); 
		query.append("	'AGK'||CHR(10)||" ).append("\n"); 
		query.append("    SUBSTR(CLL.VGM_VRFY_SIG_CTNT , 1, 512)||CHR(10)||" ).append("\n"); 
		query.append("	SUBSTR(CLL.VGM_VRFY_SIG_CTNT, 513)||CHR(10)||" ).append("\n"); 
		query.append("	'}30'||CHR(10)||" ).append("\n"); 
		query.append("	'}13'||CHR(10) CNTR_DETAIL" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("	BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("	BKG_CSTMS_CD_CONV_CTNT VSL" ).append("\n"); 
		query.append("WHERE CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND CLL.CNTR_TPSZ_CD = VSL.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND VSL.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("AND VSL.CSTMS_DIV_ID(+) = 'CLL_CNTR_ISO_CD' " ).append("\n"); 
		query.append("AND VSL.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("#if (${in_pol_yd_cd} != '' ) " ).append("\n"); 
		query.append("AND CLL.POL_YD_CD = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}