/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDBDAOsearchWhfNoticeRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchWhfNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Wharfage Notice정보를 조회함
	  * </pre>
	  */
	public KorManifestListDBDAOsearchWhfNoticeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchWhfNoticeRSQL").append("\n");
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
		query.append("SELECT  NVL(SUBSTR(WHF_NTC_NO,1,4),TO_CHAR(SYSDATE,'YYYY'))||'-'||" ).append("\n");
		query.append("SUBSTR(WHF_NTC_NO,5,2)||'-'||" ).append("\n");
		query.append("SUBSTR(WHF_NTC_NO,7,6) NOTICE" ).append("\n");
		query.append("FROM    BKG_KR_WHF_RT" ).append("\n");
		query.append("WHERE   (BL_NO, VSL_CD,SKD_VOY_NO,SKD_DIR_CD,WHF_BND_CD,CHG_RT_SEQ) IN" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT  B.BL_NO, B.VSL_CD, B.SKD_VOY_NO,B.SKD_DIR_CD, B.WHF_BND_CD, MAX(B.CHG_RT_SEQ) SEQ" ).append("\n");
		query.append("FROM    BKG_KR_WHF_BL A, BKG_KR_WHF_RT B, BKG_BOOKING C" ).append("\n");
		query.append("WHERE   A.VSL_CD    = SUBSTR(@[in_vvd],1,4)" ).append("\n");
		query.append("AND A.SKD_VOY_NO    = SUBSTR(@[in_vvd],5,4)" ).append("\n");
		query.append("AND A.SKD_DIR_CD    = SUBSTR(@[in_vvd],9,1)" ).append("\n");
		query.append("AND A.WHF_POD_CD   = 'KRPUS'" ).append("\n");
		query.append("AND A.WHF_BL_STS_CD    <> 'D'" ).append("\n");
		query.append("AND NVL(A.WHF_BL_STS_CD,'N')   <> 'D'" ).append("\n");
		query.append("AND B.WHF_BND_CD  = 'II'" ).append("\n");
		query.append("AND A.BL_NO         = B.BL_NO" ).append("\n");
		query.append("AND A.VSL_CD        = B.VSL_CD" ).append("\n");
		query.append("AND A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n");
		query.append("AND A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n");
		query.append("AND A.WHF_BND_CD    = DECODE(B.WHF_BND_CD,'II','I','IT','T','OO','E','OT','R')" ).append("\n");
		query.append("AND A.BKG_NO        = C.BKG_NO" ).append("\n");
		query.append("--AND NVL(C.BKG_CGO_TP_CD,' ') != 'P'" ).append("\n");
		query.append("GROUP BY B.BL_NO, B.VSL_CD,B.SKD_VOY_NO,B.SKD_DIR_CD, B.WHF_BND_CD" ).append("\n");
		query.append(")" ).append("\n");
		query.append("AND WHF_BND_CD    = 'II'" ).append("\n");
		query.append("AND WHF_NTC_NO  IS NOT NULL" ).append("\n");
		query.append("AND ROWNUM      = 1" ).append("\n");

	}
}