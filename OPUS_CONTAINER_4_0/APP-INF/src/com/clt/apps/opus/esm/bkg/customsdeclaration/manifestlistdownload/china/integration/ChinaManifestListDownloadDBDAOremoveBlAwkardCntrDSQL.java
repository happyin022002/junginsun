/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOremoveBlAwkardCntrDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier :
*@LastVersion : 1.0
* 2009.11.17
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOremoveBlAwkardCntrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * removeBlAwkardCntr
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOremoveBlAwkardCntrDSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOremoveBlAwkardCntrDSQL").append("\n");
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
		query.append("DELETE	FROM	BKG_CSTMS_CHN_AWK" ).append("\n");
		query.append("WHERE	BL_NO		   =	@[bl_no]" ).append("\n");
		query.append("AND	CHN_MF_SND_IND_CD  =	@[trans_mode]" ).append("\n");

	}
}