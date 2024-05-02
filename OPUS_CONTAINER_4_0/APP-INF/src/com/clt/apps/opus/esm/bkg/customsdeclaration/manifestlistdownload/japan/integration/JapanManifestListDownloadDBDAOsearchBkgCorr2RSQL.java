/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBkgCorr2RSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier :
*@LastVersion : 1.0
* 2010.01.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchBkgCorr2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchBkgCorr2
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBkgCorr2RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n");
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBkgCorr2RSQL").append("\n");
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
		query.append("CORR_NO," ).append("\n");
		query.append("TO_CHAR(CORR_DT,'YYYYMMDDHH24MISS') CORR_DT" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("BKG_CORRECTION" ).append("\n");
		query.append("WHERE  CORR_DT = 	(" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("MAX(CORR_DT)" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("BKG_CORRECTION" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append(")" ).append("\n");
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n");

	}
}