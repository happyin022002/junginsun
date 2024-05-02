/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PakistanManifestListDownloadDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.09.11 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PakistanManifestListDownloadDBDAOsearchBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 파키스탄 세관 신고를 위한 BL Info
	  * </pre>
	  */
	public PakistanManifestListDownloadDBDAOsearchBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration").append("\n"); 
		query.append("FileName : PakistanManifestListDownloadDBDAOsearchBlInfoRSQL").append("\n"); 
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
		query.append("SELECT (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)) AS VVD_NM" ).append("\n"); 
		query.append("     , VVD.SKD_VOY_NO || VVD.SKD_DIR_CD     AS VOY_CD" ).append("\n"); 
		query.append("     , BKG.BKG_NO" ).append("\n"); 
		query.append("     , BKG.BL_NO	AS BL_NO" ).append("\n"); 
		query.append("     , COUNT(DISTINCT BL_NO) OVER() TOTAL_BL" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_NM,CHR(13)||CHR(10),'  ')" ).append("\n"); 
		query.append("              FROM BKG_CUSTOMER CUS " ).append("\n"); 
		query.append("             WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='S' AND ROWNUM=1 ), ' ' ) AS SHPR_NM" ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_ADDR,CHR(13)||CHR(10),'  ') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER CUS " ).append("\n"); 
		query.append("              WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='S' AND ROWNUM=1 ), ' ' ) AS SHPR_ADDR" ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_NM,CHR(13)||CHR(10),'  ') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER CUS" ).append("\n"); 
		query.append("              WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='C' AND ROWNUM=1 ), ' ' ) AS CNEE_NM" ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_ADDR,CHR(13)||CHR(10),'  ') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER CUS " ).append("\n"); 
		query.append("              WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='C' AND ROWNUM=1 ), ' ' ) AS CNEE_ADDR" ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_NM,CHR(13)||CHR(10),'  ') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER CUS " ).append("\n"); 
		query.append("              WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='N' AND ROWNUM=1 ), ' ' ) AS NTFY_NM" ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_ADDR,CHR(13)||CHR(10),'  ') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER CUS " ).append("\n"); 
		query.append("              WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='N' AND ROWNUM=1 ), ' ' ) AS NTFY_ADDR" ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_NM,CHR(13)||CHR(10),'  ') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER CUS " ).append("\n"); 
		query.append("              WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='A' AND ROWNUM=1 ), ' ' ) AS A_NTFY_NM    " ).append("\n"); 
		query.append("     , NVL( (SELECT REPLACE(CUS.CUST_ADDR,CHR(13)||CHR(10),'  ') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER CUS " ).append("\n"); 
		query.append("              WHERE CUS.BKG_NO=BKG.BKG_NO AND CUS.BKG_CUST_TP_CD='A' AND ROWNUM=1 ), ' ' ) AS A_NTFY_ADDR " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , BKG.POL_CD       AS POL_CD" ).append("\n"); 
		query.append("     , BKG.POD_CD       AS POD_CD" ).append("\n"); 
		query.append("     , BKG.DEL_CD       AS DEL_CD" ).append("\n"); 
		query.append("     , ( SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND CLPT_SEQ = ( SELECT CLPT_SEQ -1 FROM VSK_VSL_PORT_SKD WHERE 1=1" ).append("\n"); 
		query.append("                                AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                                	AND VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("                                	AND VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("                                	AND CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                                #if (${pol_cd} != '') " ).append("\n"); 
		query.append("                                	AND VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("									AND VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                	AND CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("            AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("            AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("            AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("            AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("       ) AS LAST_PORT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , BKG.RCV_TERM_CD||'/'||BKG.DE_TERM_CD             AS RD_TERM_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , (SELECT A.OBL_ISS_DT FROM BKG_BL_ISS A WHERE A.BKG_NO = BKG.BKG_NO) AS OBL_ISS_DT" ).append("\n"); 
		query.append("     , (SELECT C.CSTMS_DESC FROM BKG_BL_DOC C WHERE C.BKG_NO = BKG.BKG_NO) AS CSTMS_DESC" ).append("\n"); 
		query.append("     , (SELECT B.MK_DESC FROM BKG_BL_MK_DESC B WHERE B.BKG_NO = BKG.BKG_NO) AS MK_DESC" ).append("\n"); 
		query.append("     , (SELECT B.CMDT_DESC FROM BKG_BL_MK_DESC B WHERE B.BKG_NO = BKG.BKG_NO) AS CMDT_DESC" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("     , BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.VSL_CD		= SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO	= SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD	= SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("  AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("  AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}