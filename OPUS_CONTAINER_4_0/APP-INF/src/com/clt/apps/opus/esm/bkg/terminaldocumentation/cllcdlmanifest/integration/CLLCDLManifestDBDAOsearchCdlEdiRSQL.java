/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlEdiRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCdlEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCdlEdi
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_index",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_index",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlEdiRSQL").append("\n");
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
		query.append("SELECT  TML_EDI_CTNT STR" ).append("\n");
		query.append("FROM    BKG_CSTMS_TML_EDI_GEN_TMP " ).append("\n");
		query.append("WHERE	(N1ST_EDI_GEN_ORD_NO = 0 OR N1ST_EDI_GEN_ORD_NO BETWEEN @[start_index] AND @[end_index])" ).append("\n");
		query.append("ORDER BY 	N1ST_EDI_GEN_ORD_NO, N2ND_EDI_GEN_ORD_NO, N3RD_EDI_GEN_ORD_NO" ).append("\n");

	}
}