/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchJpcusBlCntrRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.19
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

public class JapanManifestListDownloadDBDAOsearchJpcusBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchJpcusBlCntr
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchJpcusBlCntrRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("BL_NO" ).append("\n");
		query.append(",	BL_SPLIT_NO" ).append("\n");
		query.append(",	CNTR_NO" ).append("\n");
		query.append(",	CNTR_TPSZ_CD" ).append("\n");
		query.append(",	CNTR_SEAL_NO" ).append("\n");
		query.append(",	JP_CSTMS_CNTR_STS_CD" ).append("\n");
		query.append(",	PRT_FLG" ).append("\n");
		query.append(",	RCV_TERM_CD" ).append("\n");
		query.append(",	DE_TERM_CD" ).append("\n");
		query.append(",	FULL_MTY_CD" ).append("\n");
		query.append(",	JP_CNTR_OWNR_CD" ).append("\n");
		query.append(",	CRE_USR_ID" ).append("\n");
		query.append(",	CRE_DT" ).append("\n");
		query.append(",	UPD_USR_ID" ).append("\n");
		query.append(",	UPD_DT" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("BKG_CSTMS_JP_BL_CNTR" ).append("\n");
		query.append("WHERE	BL_NO = @[bl_no]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n");
		query.append("FileName : JapanManifestListDownloadDBDAOsearchJpcusBlCntrRSQL").append("\n");
		query.append("*/").append("\n");
	}
}