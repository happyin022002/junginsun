/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOSearchVvdCdForRecieveRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.21
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOSearchVvdCdForRecieveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchVvdCdForRecieve
	  * </pre>
	  */
	public CLLCDLManifestDBDAOSearchVvdCdForRecieveRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvdcll",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOSearchVvdCdForRecieveRSQL").append("\n");
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
		query.append("VSL_CD IN_VSLCD," ).append("\n");
		query.append("SKD_VOY_NO IN_VSLVOY," ).append("\n");
		query.append("SKD_DIR_CD IN_VSLDIR" ).append("\n");
		query.append("FROM	BKG_CSTMS_TML_CLL" ).append("\n");
		query.append("WHERE	VSL_CD = @[in_vvdcll]" ).append("\n");
		query.append("AND	SKD_VOY_NO||SKD_DIR_CD LIKE '%'||RTRIM(@[in_vvd])||'%'" ).append("\n");
		query.append("AND	ROWNUM = 1" ).append("\n");

	}
}