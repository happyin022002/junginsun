/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTCommonDBDAOSearchAROfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.23
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.06.23 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchAROfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVendorCode
	  * </pre>
	  */
	public AGTCommonDBDAOSearchAROfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchAROfficeListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	DISTINCT X.AR_OFC AS CODE, " ).append("\n"); 
		query.append("		X.AR_OFC AS NAME " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("             DISTINCT '1'," ).append("\n"); 
		query.append("                      A.OFC_CD USRIDOFC," ).append("\n"); 
		query.append("                      A.AR_OFC AR_OFC," ).append("\n"); 
		query.append("                      A.OFC_CD SUB_OFC" ).append("\n"); 
		query.append("                 FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                          SELECT 'JKTBA' AS AR_OFC," ).append("\n"); 
		query.append("                                 'JKTBA' AS OFC_CD" ).append("\n"); 
		query.append("                            FROM DUAL" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("		#if (${code} == 'TPEBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('TPEBB','TPEBA') 	" ).append("\n"); 
		query.append("		#elseif (${code} == 'DXBBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('DXBBA','DXBBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'MNLBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('MNLBA','MNLBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HKGBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('HKGBB','SZPBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHAAAG' || ${code} == 'SHAASG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHAAS','SHADNC','SHADSC', 'SHADSA','SHADPI','DXBBB','SINWA') 	" ).append("\n"); 
		query.append("		#elseif (${code} == 'SAOBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SAOBB','MVDBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SINWA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','JKTBA','JKTBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHADSA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNSG' || ${code} == 'NYCNOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUSG' || ${code} == 'HAMUOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD = @[code] 	--ofc_cd" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("            UNION SELECT DISTINCT '1', " ).append("\n"); 
		query.append("               A.OFC_CD USRIDOFC, " ).append("\n"); 
		query.append("               A.AR_OFC AR_OFC, " ).append("\n"); 
		query.append("               C.OFC_CD SUB_OFC " ).append("\n"); 
		query.append("          FROM (SELECT A.OFC_CD OFC_CD, " ).append("\n"); 
		query.append("                       B.AR_OFC_CD AR_OFC " ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION A, " ).append("\n"); 
		query.append("                       MDM_ORGANIZATION B " ).append("\n"); 
		query.append("		#if (${code} == 'TPEBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('TPEBB','TPEBA') 	" ).append("\n"); 
		query.append("		#elseif (${code} == 'DXBBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('DXBBA','DXBBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'MNLBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('MNLBA','MNLBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HKGBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('HKGBB','SZPBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHAAAG' || ${code} == 'SHAASG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHAAS','SHADNC','SHADSC', 'SHADSA','SHADPI','DXBBB','SINWA') 	" ).append("\n"); 
		query.append("		#elseif (${code} == 'SAOBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SAOBB','MVDBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SINWA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','JKTBA','JKTBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHADSA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNSG' || ${code} == 'NYCNOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUSG' || ${code} == 'HAMUOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD = @[code] 	--ofc_cd" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE(A.OFC_CD, " ).append("\n"); 
		query.append("                                         'HKGBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'TPEBA', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'OSABS', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'TYOBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADPI', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADSA', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADNC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADSC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         DECODE(A.OFC_KND_CD, " ).append("\n"); 
		query.append("                                                '2', NVL(B.AR_HD_QTR_OFC_CD, B.PRNT_OFC_CD), " ).append("\n"); 
		query.append("                                                '3', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                                B.OFC_CD)) " ).append("\n"); 
		query.append("               ) A, " ).append("\n"); 
		query.append("               MDM_ORGANIZATION C " ).append("\n"); 
		query.append("         WHERE A.AR_OFC = NVL(C.AR_OFC_CD, C.OFC_CD) " ).append("\n"); 
		query.append("           AND C.VNDR_CNT_CD IS NOT NULL " ).append("\n"); 
		query.append("        UNION " ).append("\n"); 
		query.append("        SELECT '2', " ).append("\n"); 
		query.append("               B.AR_HD_QTR_OFC_CD, " ).append("\n"); 
		query.append("               A.AGN_FINC_OFC_CD,  " ).append("\n"); 
		query.append("               SUBSTR(A.OFC_CD, 1, 3) || A.CHN_BKG_AGN_CD " ).append("\n"); 
		query.append("          FROM AGT_CHN_BKG_AGN A, " ).append("\n"); 
		query.append("               MDM_ORGANIZATION B " ).append("\n"); 
		query.append("         WHERE A.AGN_FINC_OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("           AND B.OFC_CD IN " ).append("\n"); 
		query.append("               (SELECT DISTINCT B.AR_OFC_CD " ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION A, " ).append("\n"); 
		query.append("                       MDM_ORGANIZATION B " ).append("\n"); 
		query.append("		#if (${code} == 'TPEBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('TPEBB','TPEBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'DXBBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('DXBBA','DXBBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'MNLBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('MNLBA','MNLBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HKGBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('HKGBB','SZPBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHAAAG' || ${code} == 'SHAASG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHAAS','SHADNC','SHADSC', 'SHADSA','SHADPI','DXBBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SAOBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SAOBB','MVDBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SINWA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','JKTBA','JKTBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SHADSA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNSG' || ${code} == 'NYCNOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUSG' || ${code} == 'HAMUOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD = @[code] 	--ofc_cd	" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE(A.OFC_CD, " ).append("\n"); 
		query.append("                                         'HKGBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'TPEBA', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'OSABS', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'TYOBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADPI', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADSA', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADNC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADSC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         DECODE(A.OFC_KND_CD, " ).append("\n"); 
		query.append("                                                '2', NVL(B.AR_HD_QTR_OFC_CD, B.PRNT_OFC_CD), " ).append("\n"); 
		query.append("                                                '3', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                                B.OFC_CD)) " ).append("\n"); 
		query.append("                                   ) " ).append("\n"); 
		query.append("           AND A.AGN_VNDR_CNT_CD IS NOT NULL " ).append("\n"); 
		query.append("        UNION " ).append("\n"); 
		query.append("        SELECT DISTINCT '3', " ).append("\n"); 
		query.append("               B.AR_HD_QTR_OFC_CD, " ).append("\n"); 
		query.append("               A.AGN_FINC_OFC_CD, " ).append("\n"); 
		query.append("               A.OFC_CD " ).append("\n"); 
		query.append("          FROM AGT_CHN_BKG_AGN A, " ).append("\n"); 
		query.append("               MDM_ORGANIZATION B " ).append("\n"); 
		query.append("         WHERE A.AGN_FINC_OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("           AND B.OFC_CD IN " ).append("\n"); 
		query.append("               (SELECT DISTINCT B.AR_OFC_CD " ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION A, " ).append("\n"); 
		query.append("                       MDM_ORGANIZATION B" ).append("\n"); 
		query.append("		#if (${code} == 'TPEBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('TPEBB','TPEBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'DXBBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('DXBBA','DXBBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'MNLBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('MNLBA','MNLBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HKGBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('HKGBB','SZPBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHAAAG' || ${code} == 'SHAASG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHAAS','SHADNC','SHADSC', 'SHADSA','SHADPI','DXBBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SAOBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SAOBB','MVDBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SINWA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','JKTBA','JKTBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SHADSA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNSG' || ${code} == 'NYCNOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUSG' || ${code} == 'HAMUOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD = @[code] 	--ofc_cd	" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE(A.OFC_CD, " ).append("\n"); 
		query.append("                                         'HKGBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'TPEBA', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'OSABS', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'TYOBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADPI', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADSA', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADNC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         'SHADSC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                         DECODE(A.OFC_KND_CD, " ).append("\n"); 
		query.append("                                                '2', NVL(B.AR_HD_QTR_OFC_CD, B.PRNT_OFC_CD), " ).append("\n"); 
		query.append("                                                '3', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                                B.OFC_CD))  " ).append("\n"); 
		query.append("                                     ) " ).append("\n"); 
		query.append("           AND A.AGN_VNDR_CNT_CD IS NOT NULL  " ).append("\n"); 
		query.append("       ) X,  " ).append("\n"); 
		query.append("       AGT_FINC_OFC_INFO Y  " ).append("\n"); 
		query.append(" WHERE X.AR_OFC = Y.AR_OFC_CD  " ).append("\n"); 
		query.append("   AND X.SUB_OFC = Y.AGN_CD  " ).append("\n"); 
		query.append("   AND X.AR_OFC  = DECODE('SHADSC', @[code], DECODE(X.AR_OFC, 'TPEBA', 'TPEXX', X.AR_OFC), X.AR_OFC) 	--ofc_cd" ).append("\n"); 
		query.append("   AND NVL(Y.DELT_FLG,'N') = 'N'  " ).append("\n"); 
		query.append("   AND Y.OFC_GRP_LVL IN (SELECT DISTINCT B.OFC_GRP_LVL  " ).append("\n"); 
		query.append("                          FROM (SELECT A.OFC_CD OFC_CD, B.AR_OFC_CD AR_OFC  " ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION A, MDM_ORGANIZATION B  " ).append("\n"); 
		query.append("		#if (${code} == 'TPEBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('TPEBB','TPEBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'DXBBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('DXBBA','DXBBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'MNLBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('MNLBA','MNLBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HKGBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('HKGBB','SZPBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHAAAG' || ${code} == 'SHAASG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHAAS','SHADNC','SHADSC', 'SHADSA','SHADPI','DXBBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SAOBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SAOBB','MVDBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SINWA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','JKTBA','JKTBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SHADSA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNSG' || ${code} == 'NYCNOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUSG' || ${code} == 'HAMUOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD = @[code] 	--ofc_cd	" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE(A.OFC_CD,  " ).append("\n"); 
		query.append("                                     'HKGBB', B.AR_OFC_CD,  " ).append("\n"); 
		query.append("                                     'TPEBA', B.AR_OFC_CD,  " ).append("\n"); 
		query.append("                                     'OSABS', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                     'TYOBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                     'SHADPI', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                     'SHADSA', B.PRNT_OFC_CD,  " ).append("\n"); 
		query.append("                                     'SHADNC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                     'SHADSC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                     DECODE(A.OFC_KND_CD,  " ).append("\n"); 
		query.append("                                            '2', NVL(B.AR_HD_QTR_OFC_CD, B.PRNT_OFC_CD),  " ).append("\n"); 
		query.append("                                            '3', B.AR_OFC_CD,  " ).append("\n"); 
		query.append("                                            B.OFC_CD))  " ).append("\n"); 
		query.append("                           ) A,  " ).append("\n"); 
		query.append("                           AGT_FINC_OFC_INFO B  " ).append("\n"); 
		query.append("                     WHERE A.AR_OFC = B.AGN_CD  " ).append("\n"); 
		query.append("        UNION  " ).append("\n"); 
		query.append("        SELECT DISTINCT B.OFC_GRP_LVL  " ).append("\n"); 
		query.append("          FROM (SELECT A.OFC_CD OFC_CD, B.AR_OFC_CD AR_OFC  " ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION A, MDM_ORGANIZATION B  " ).append("\n"); 
		query.append("		#if (${code} == 'TPEBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('TPEBB','TPEBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'DXBBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('DXBBA','DXBBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'JKTBA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('JKTBA','JKTBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'MNLBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('MNLBA','MNLBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HKGBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('HKGBB','SZPBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SHAAAG' || ${code} == 'SHAASG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHAAS','SHADNC','SHADSC', 'SHADSA','SHADPI','DXBBB','SINWA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'SAOBB') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SAOBB','MVDBA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SINWA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','JKTBA','JKTBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'SHADSA') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('SHADSA','SHADPI','DXBBB','SINWA')" ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'NYCNSG' || ${code} == 'NYCNOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('ATLBB','BUEBA','GUABA','MEXBA','MVDBA','NYCNA','PTYBA','SAOBB') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUAG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#elseif (${code} == 'HAMUSG' || ${code} == 'HAMUOG') " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD IN ('AARBA','ALYBA','BSLBA','BUDBB','DUBBA','GLWBA','GOABB','GOTBA','HAMBB','HAMUR','HELBA','IZMBA', 'LISBA', 'MLABA', 'KOPBA','OSLBA','SKGBA','VLCBB','WRPBB','HFABA','LEDBA','TLLBA') " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("	                 WHERE A.OFC_CD = @[code] 	--ofc_cd	" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE(A.OFC_CD,  " ).append("\n"); 
		query.append("                                 'HKGBB', B.AR_OFC_CD,  " ).append("\n"); 
		query.append("                                 'TPEBA', B.AR_OFC_CD,  " ).append("\n"); 
		query.append("                                 'OSABS', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                 'TYOBB', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                                 'SHADPI', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                 'SHADSA', B.PRNT_OFC_CD,  " ).append("\n"); 
		query.append("                                 'SHADNC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                 'SHADSC', B.PRNT_OFC_CD, " ).append("\n"); 
		query.append("                                 DECODE(A.OFC_KND_CD,  " ).append("\n"); 
		query.append("                                        '2', NVL(B.AR_HD_QTR_OFC_CD, B.PRNT_OFC_CD),  " ).append("\n"); 
		query.append("                                        '3', B.AR_OFC_CD,  " ).append("\n"); 
		query.append("                                        B.OFC_CD))  " ).append("\n"); 
		query.append("                       ) A,  " ).append("\n"); 
		query.append("                       AGT_FINC_OFC_INFO B  " ).append("\n"); 
		query.append("                 WHERE A.AR_OFC = B.AR_OFC_CD  " ).append("\n"); 
		query.append("       )  " ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}