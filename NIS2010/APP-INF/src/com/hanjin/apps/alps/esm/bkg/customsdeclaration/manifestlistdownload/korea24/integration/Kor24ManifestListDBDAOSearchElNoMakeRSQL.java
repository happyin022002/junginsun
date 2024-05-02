/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchElNoMakeRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.07.10 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchElNoMakeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * O/B T/S의 경우엔, I/B T/S의 MRN_NBR+MSN_NO로 E/L NO를 만들어 주고, BOOKING의 WGT,PKG로 다른 항목들을 채워준다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchElNoMakeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchElNoMakeRSQL").append("\n");
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
		query.append("SELECT DISTINCT TRIM(NVL(V.MRN_NO||V.MRN_CHK_NO||T.MSN_NO,' ')) TRIM_MRN_NO" ).append("\n");
		query.append("  FROM  (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, 'I' BND, TS_POD_CD POD, NVL(MST_BL_SEQ_NO,' ') MSN_NO," ).append("\n");
		query.append("                --DECODE(USA_BND_FLG, NULL, 'N', ' ', 'N', USA_BND_FLG) OB_TYPE" ).append("\n");
		query.append("				'N' OB_TYPE" ).append("\n");
		query.append("         FROM   BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("         WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("         AND    CSTMS_DECL_TP_CD = 'T'" ).append("\n");
		query.append("         AND    DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("         AND    TRNS_SEQ = (SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("                          FROM   BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("                          WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("                          AND    CSTMS_DECL_TP_CD = 'T'" ).append("\n");
		query.append("                          AND    DMST_PORT_CD = @[kt_port])) T," ).append("\n");
		query.append("         BKG_CSTMS_ADV_KR_VVD_SMRY V" ).append("\n");
		query.append("  WHERE  V.VSL_CD = T.VSL_CD" ).append("\n");
		query.append("  AND    V.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n");
		query.append("  AND    V.SKD_DIR_CD = T.SKD_DIR_CD" ).append("\n");
		query.append("  AND  ((T.OB_TYPE IN ('A','B','C','D','M') AND V.OB_DECL_TP_CD IN ('A','B','C','M')) OR" ).append("\n");
		query.append("        (T.OB_TYPE = 'N' AND T.OB_TYPE = V.OB_DECL_TP_CD))" ).append("\n");
		query.append("  AND    V.PORT_CD = T.POD" ).append("\n");
		query.append("  AND    V.IO_BND_CD = T.BND" ).append("\n");

	}
}