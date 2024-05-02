/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOsearchBreakBulkCheckRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.23
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.23
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

public class KorManifestListDBDAOsearchBreakBulkCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * a
	  * </pre>
	  */
	public KorManifestListDBDAOsearchBreakBulkCheckRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchBreakBulkCheckRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("  CASE" ).append("\n");
		query.append("    WHEN AA = BB" ).append("\n");
		query.append("    AND AA = 'N' THEN 'N'" ).append("\n");
		query.append("    WHEN AA = BB" ).append("\n");
		query.append("    AND AA = 'Y' THEN '2'" ).append("\n");
		query.append("    ELSE '2'" ).append("\n");
		query.append("  END" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("    SELECT MAX(BB_CGO_FLG) AA," ).append("\n");
		query.append("      MIN(BB_CGO_FLG) BB" ).append("\n");
		query.append("    FROM BKG_CONTAINER" ).append("\n");
		query.append("    WHERE BKG_NO = @[bkg_no] )" ).append("\n");

	}
}