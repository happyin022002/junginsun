/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOSearchMaxSeqDownHistKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.10 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchMaxSeqDownHistKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Download History 테이블에 Delete기록을 남기기위해서 기존의 Max Seq 값을 구해서 +1을 해준다.
	  * </pre>
	  */
	public KorManifestListDBDAOSearchMaxSeqDownHistKorRSQL(){
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
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

	}

	/**
	 *
	 */
	public String getSQL(){
		return query.toString();
	}

	/**
	 *
	 */
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT NVL(MAX(DL_SEQ),0) + 1 DL_SEQ" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_DL_HIS" ).append("\n");
		query.append("WHERE MRN_NO = SUBSTR(@[mrn_nbr],1,10)" ).append("\n");
		query.append("AND MRN_CHK_NO = SUBSTR(@[mrn_nbr],11,1)" ).append("\n");
		query.append("AND VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchMaxSeqDownHistKorRSQL").append("\n");
		query.append("*/").append("\n");
	}
}