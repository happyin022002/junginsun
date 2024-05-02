/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAODgSendHistoryVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.07
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAODgSendHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * DgSendHistoryVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgSendHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n");
		query.append("FileName : SpecialManifestDBDAODgSendHistoryVORSQL").append("\n");
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
		query.append("''EUR_EDI_MSG_TP_ID" ).append("\n");
		query.append(",''MSG_SND_NO" ).append("\n");
		query.append(",''SND_DT" ).append("\n");
		query.append(",''SND_USR_ID" ).append("\n");
		query.append(",''AUTO_SND_TP_CD" ).append("\n");
		query.append(",''MSG_FUNC_ID" ).append("\n");
		query.append(",''EUR_DG_DECL_TP_CD" ).append("\n");
		query.append(",''VSL_CD" ).append("\n");
		query.append(",''SKD_VOY_NO" ).append("\n");
		query.append(",''SKD_DIR_CD" ).append("\n");
		query.append(",''PORT_CD" ).append("\n");
		query.append(",''CRE_USR_ID" ).append("\n");
		query.append(",''CRE_DT" ).append("\n");
		query.append(",''UPD_USR_ID" ).append("\n");
		query.append(",''UPD_DT" ).append("\n");
		query.append(",''VVD_CD" ).append("\n");
		query.append(",''KEY_VAL" ).append("\n");
		query.append(",''MSG_DESC" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}