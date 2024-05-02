/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchCargoDescDNRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.21 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchCargoDescDNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * RPAD(REPLACE(NVL(CSTMS_DESC,' '),CHR(13)||CHR(10),' '),50,' ') FROM BKG_BL_DOC
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchCargoDescDNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchCargoDescDNRSQL").append("\n");
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
		query.append("SELECT TRIM(REPLACE(NVL(SUBSTR(CSTMS_DESC,1,50),' '),CHR(13)||CHR(10),' ')) DESC_CODE1," ).append("\n");
		query.append("TRIM(REPLACE(NVL(SUBSTR(CSTMS_DESC,51,150),' '),CHR(13)||CHR(10),' ')) DESC_CODE2" ).append("\n");
		query.append("FROM BKG_BL_DOC" ).append("\n");
		query.append("WHERE BKG_NO = @[a_bkg_no]" ).append("\n");

	}
}