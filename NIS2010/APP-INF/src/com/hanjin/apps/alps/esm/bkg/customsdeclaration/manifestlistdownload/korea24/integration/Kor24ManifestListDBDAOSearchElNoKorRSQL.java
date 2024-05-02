/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchElNoKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.07 조원주
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

public class Kor24ManifestListDBDAOSearchElNoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * O/B T/S의 경우 ELNo를 구한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchElNoKorRSQL(){
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
		query.append("FileName : Kor24ManifestListDBDAOSearchElNoKorRSQL").append("\n");
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
		query.append("SELECT DISTINCT TRIM(NVL(V.MRN_NO||V.MRN_CHK_NO||T.MST_BL_SEQ,' ')) D_MRN_NO" ).append("\n");
		query.append("  FROM (" ).append("\n");
		query.append("      SELECT VSL_CD" ).append("\n");
		query.append("           , SKD_VOY_NO" ).append("\n");
		query.append("           , SKD_DIR_CD" ).append("\n");
		query.append("           , 'I' BND" ).append("\n");
		query.append("           , TS_POD_CD POD" ).append("\n");
		query.append("           , NVL(MST_BL_SEQ,' ') MSN_NO" ).append("\n");
		query.append("           , DECODE(USA_BND_FLG,NULL,'N',' ','N',USA_BND_FLG) OB_TYPE" ).append("\n");
		query.append("        FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("       WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("       " ).append("\n");
		query.append("         AND CSTMS_DECL_TP_CD IN ('T','I')" ).append("\n");
		query.append("         AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("         AND TRNS_SEQ = (" ).append("\n");
		query.append("            SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("              FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("              " ).append("\n");
		query.append("               AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("               AND CSTMS_DECL_TP_CD IN ('I','T')" ).append("\n");
		query.append("               AND POD_CD <> TS_POD_CD" ).append("\n");
		query.append("               )" ).append("\n");
		query.append("       ) T" ).append("\n");
		query.append("     , BKG_CSTMS_ADV_KR_VVD_SMRY V" ).append("\n");
		query.append(" WHERE V.VSL_CD = T.VSL_CD" ).append("\n");
		query.append("   AND V.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n");
		query.append("   AND V.SKD_DIR_CD = T.SKD_DIR_CD" ).append("\n");
		query.append("   AND ((T.OB_TYPE IN ('A','B','C','D') AND V.OB_DECL_TP_CD IN ('A','B','C','D')) OR" ).append("\n");
		query.append("      (T.OB_TYPE = 'N' AND T.OB_TYPE = V.OB_DECL_TP_CD))" ).append("\n");
		query.append("   AND V.PORT_CD = T.POD" ).append("\n");
		query.append("   AND V.IO_BND_CD = T.BND" ).append("\n");

	}
}