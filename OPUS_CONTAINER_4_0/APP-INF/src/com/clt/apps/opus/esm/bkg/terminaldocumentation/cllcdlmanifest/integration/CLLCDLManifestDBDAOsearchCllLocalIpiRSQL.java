/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllLocalIpiRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.22
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

public class CLLCDLManifestDBDAOsearchCllLocalIpiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCllLocalIpi
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllLocalIpiRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCllLocalIpiRSQL").append("\n");
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
		query.append("DISTINCT DECODE(L1.SCC_CD, L2.SCC_CD, DECODE(SUBSTR(C.POD_CD,1,2), SUBSTR(C.DEL_CD,1,2), 'L', 'I'), 'I') LOCAL_IPI" ).append("\n");
		query.append("FROM	BKG_CSTMS_TML_CLL C, MDM_LOCATION L1, MDM_LOCATION L2" ).append("\n");
		query.append("WHERE	C.VSL_CD		= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND	C.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND	C.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("AND	C.PORT_CD		= @[in_pol_cd]" ).append("\n");
		query.append("AND	C.BKG_NO		= @[bkg_no]" ).append("\n");
		query.append("AND	C.POD_CD		= L1.LOC_CD(+)" ).append("\n");
		query.append("AND	C.DEL_CD		= L2.LOC_CD(+)" ).append("\n");

	}
}