/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchKorCmdtInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.08 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchKorCmdtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Korea Commodity 정보 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchKorCmdtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchKorCmdtInfoRSQL").append("\n");
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
		query.append("SELECT ATTR_CTNT1 REP_CMDT_CD" ).append("\n");
		query.append(", ATTR_CTNT2 CMDT_CD" ).append("\n");
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n");
		query.append("WHERE CNT_CD = 'KR'" ).append("\n");
		query.append("AND CSTMS_DIV_ID = 'KOR_CSTM_CMDT'" ).append("\n");
		query.append("ORDER BY ATTR_CTNT1, ATTR_CTNT2" ).append("\n");

	}
}