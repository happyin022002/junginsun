/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchCommodityRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class JapanManifestListDownloadDBDAOsearchCommodityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCommodity
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchCommodityRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DECODE(CMDT_NM,NULL,CMDT_NM,SUBSTR(CMDT_NM,1,45)) CMDT_NM" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("MDM_COMMODITY" ).append("\n");
		query.append("WHERE  CMDT_CD = @[cmdt_cd]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration ").append("\n");
		query.append("FileName : JapanManifestListDownloadDBDAOsearchCommodityRSQL").append("\n");
		query.append("*/").append("\n");
	}
}