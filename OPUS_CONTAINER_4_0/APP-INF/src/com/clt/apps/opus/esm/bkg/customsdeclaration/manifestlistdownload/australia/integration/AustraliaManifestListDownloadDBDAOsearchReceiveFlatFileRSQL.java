/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AustraliaManifestListDownloadDBDAOsearchReceiveFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier :
*@LastVersion : 1.0
* 2015.01.09
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AustraliaManifestListDownloadDBDAOsearchReceiveFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AustraliaManifestListDownloadDBDAOsearchReceiveFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration").append("\n");
		query.append("FileName : AustraliaManifestListDownloadDBDAOsearchReceiveFlatFileRSQL").append("\n");
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
		query.append("SELECT EDI_RCV_MSG_CTNT" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM BKG_CSTMS_AUS_SND_LOG" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE EDI_REF_ID = @[edi_ref_id]" ).append("\n");

	}
}