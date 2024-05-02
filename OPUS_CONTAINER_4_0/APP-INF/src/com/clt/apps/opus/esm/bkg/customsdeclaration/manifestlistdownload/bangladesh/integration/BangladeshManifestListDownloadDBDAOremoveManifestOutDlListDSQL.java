/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshManifestListDownloadDBDAOremoveManifestOutDlListDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.19
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshManifestListDownloadDBDAOremoveManifestOutDlListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 방글라데시 Manifest Outbound DownLoad한 List 삭제
	  * </pre>
	  */
	public BangladeshManifestListDownloadDBDAOremoveManifestOutDlListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration").append("\n");
		query.append("FileName : BangladeshManifestListDownloadDBDAOremoveManifestOutDlListDSQL").append("\n");
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
		query.append("DELETE FROM BKG_CSTMS_BD_CNTR" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND VSL_CD 			= SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO 		= SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD 		= SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND BD_CSTMS_BND_CD 	= 'O'" ).append("\n");
		query.append("AND POL_CD 			= @[pol_code]" ).append("\n");

	}
}