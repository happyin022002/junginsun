/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHblCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.06 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchHblCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaHblCheckDetailVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHblCheckListRSQL(){
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
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mbl_filer",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHblCheckListRSQL").append("\n"); 
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
		query.append("       ,ROW_NUMBER() OVER(PARTITION BY BKG_NO ORDER BY BKG_NO, POD_CD, HBL_SEQ) AS SEQ" ).append("\n"); 
		query.append("       ,'' AS TOT_BKG" ).append("\n"); 
		query.append("       ,'' AS TOT_BL" ).append("\n"); 
		query.append("       ,'' AS TOT_MBL01" ).append("\n"); 
		query.append("       ,'' AS TOT_MBL02" ).append("\n"); 
		query.append("       ,'' AS TOT_MBL03" ).append("\n"); 
		query.append("       ,'' AS TOT_MBL" ).append("\n"); 
		query.append("       ,'' AS TOT_HBL" ).append("\n"); 
		query.append("       ,'' AS TOT_FILENO" ).append("\n"); 
		query.append("       ,'' AS TOT_HBL_ETC" ).append("\n"); 
		query.append("       ,'' AS TOT_FILENO_ETC" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  RSLT.*" ).append("\n"); 
		query.append("               ,CASE WHEN MBL_FILER IS NULL THEN 'Y'" ).append("\n"); 
		query.append("                     WHEN MBL_FILER = '01' THEN DECODE(HBL_FLG,'N','Y',DECODE(HBL_FILENO_FLG,'N','Y',DECODE(HBL_CM_FLG,'N','Y','N')))" ).append("\n"); 
		query.append("                     ELSE DECODE(HBL_FLG,'Y','Y','N')" ).append("\n"); 
		query.append("                END ERR_FLG" ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                       B.BKG_NO" ).append("\n"); 
		query.append("                      ,B.BKG_STS_CD" ).append("\n"); 
		query.append("                      ,B.POL_CD" ).append("\n"); 
		query.append("                      ,B.POD_CD" ).append("\n"); 
		query.append("                      ,B.DEL_CD" ).append("\n"); 
		query.append("                      ,B.BL_NO" ).append("\n"); 
		query.append("                      ,LPAD(B.USA_CSTMS_FILE_CD, 2, '0') AS MBL_FILER" ).append("\n"); 
		query.append("                      ,H.HBL_SEQ" ).append("\n"); 
		query.append("                      ,DECODE(H.HBL_SEQ, NULL, 'N', 'Y') AS HBL_FLG" ).append("\n"); 
		query.append("                      ,DECODE(H.CNTR_MF_NO, NULL, 'N', 'Y') AS HBL_FILENO_FLG" ).append("\n"); 
		query.append("                      ,MIN(DECODE(D.CNTR_MF_NO, NULL, 'N', 'Y')) AS HBL_CM_FLG" ).append("\n"); 
		query.append("                      ,C.CUST_TP_CD AS SHPR_TP" ).append("\n"); 
		query.append("                      ,REPLACE(REPLACE(C.CUST_NM,CHR(9),' '),CHR(13)||CHR(10),' ') AS SHPR_NM" ).append("\n"); 
		query.append("                      ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("                      ,H.HBL_NO" ).append("\n"); 
		query.append("                      ,D.CNTR_MF_NO" ).append("\n"); 
		query.append("                      ,LPAD(B.CND_CSTMS_FILE_CD, 2, '0') AS ETC_FILER" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                      ,BKG_VVD V" ).append("\n"); 
		query.append("                      ,BKG_HBL H" ).append("\n"); 
		query.append("                      ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("                      ,MDM_LOCATION M" ).append("\n"); 
		query.append("                      ,BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append("                      ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                      ,(" ).append("\n"); 
		query.append("                        SELECT MIN(CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                         WHERE VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("                           AND VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                       ) MIN_SEQ" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND V.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_NO         = C.BKG_NO" ).append("\n"); 
		query.append("                   AND C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                   AND B.BKG_NO         = H.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND H.BKG_NO         = D.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND H.CNTR_MF_NO     = D.CNTR_MF_NO(+)" ).append("\n"); 
		query.append("                   AND B.DEL_CD         = M.LOC_CD" ).append("\n"); 
		query.append("                   AND B.BKG_CGO_TP_CD  IN ('F','R')" ).append("\n"); 
		query.append("                   AND B.BKG_STS_CD     <> 'X'" ).append("\n"); 
		query.append("                   AND V.VSL_CD         = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO     = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                   AND V.POL_CD         LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("                   AND V.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND V.POD_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                   AND SKD.CLPT_SEQ    >= MIN_SEQ.CLPT_SEQ" ).append("\n"); 
		query.append("               #if (${conti_cd} == '')" ).append("\n"); 
		query.append("                   AND M.CONTI_CD       LIKE 'M' || '%'" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                   AND M.CONTI_CD       LIKE @[conti_cd] || '%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                   AND V.POD_CD         LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND B.BKG_OFC_CD     LIKE @[bkg_ofc_cd] || '%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("                   AND B.OB_SREP_CD     LIKE @[ob_srep_cd] || '%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${mbl_filer} != 'ALL')" ).append("\n"); 
		query.append("                   AND NVL(B.USA_CSTMS_FILE_CD, ' ') = @[mbl_filer]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("              GROUP BY B.BKG_NO" ).append("\n"); 
		query.append("                      ,B.BKG_STS_CD" ).append("\n"); 
		query.append("                      ,B.POL_CD" ).append("\n"); 
		query.append("                      ,B.POD_CD" ).append("\n"); 
		query.append("                      ,B.DEL_CD" ).append("\n"); 
		query.append("                      ,B.BL_NO" ).append("\n"); 
		query.append("                      ,B.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("                      ,B.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("                      ,H.HBL_SEQ" ).append("\n"); 
		query.append("                      ,H.HBL_SEQ" ).append("\n"); 
		query.append("                      ,H.CNTR_MF_NO" ).append("\n"); 
		query.append("                      ,C.CUST_TP_CD" ).append("\n"); 
		query.append("                      ,C.CUST_NM" ).append("\n"); 
		query.append("                      ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("                      ,H.HBL_NO" ).append("\n"); 
		query.append("                      ,D.CNTR_MF_NO" ).append("\n"); 
		query.append("            ) RSLT" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append("#if (${err_flg} == 'Y')" ).append("\n"); 
		query.append(" WHERE TB.ERR_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}