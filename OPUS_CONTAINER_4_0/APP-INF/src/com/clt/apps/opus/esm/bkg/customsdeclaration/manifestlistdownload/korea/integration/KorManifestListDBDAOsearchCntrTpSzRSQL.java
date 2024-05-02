/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCntrTpSzRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.22 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchCntrTpSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MDM에서 CNTR Type Size별 코드를 가져온다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCntrTpSzRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchCntrTpSzRSQL").append("\n");
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
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n");
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n");
		query.append("ORDER BY CNTR_TPSZ_CD" ).append("\n");

	}
}