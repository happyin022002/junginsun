/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchContainerTypeRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.30 박상훈
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

public class KorManifestListDBDAOsearchContainerTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Container No가 추가되었을때 해당 CNTR의 Type을 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchContainerTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchContainerTypeRSQL").append("\n");
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
		query.append("FROM MST_CONTAINER" ).append("\n");
		query.append("WHERE CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n");
		query.append("AND ROWNUM = 1" ).append("\n");

	}
}