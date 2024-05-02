/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchJbStageRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.03
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
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchJbStageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchJbStage
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchJbStageRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form1_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form1_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("JP_EDI_TRSM_STG_TP_CD" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("BKG_CSTMS_JP_BL" ).append("\n");
		query.append("WHERE VSL_CD        = SUBSTR(@[form1_vvd_cd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[form1_vvd_cd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD    = SUBSTR(@[form1_vvd_cd],9,1)" ).append("\n");
		query.append("AND POD_CD     = @[form1_pod_cd]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration ").append("\n");
		query.append("FileName : JapanManifestListDownloadDBDAOsearchJbStageRSQL").append("\n");
		query.append("*/").append("\n");
	}
}