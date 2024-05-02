/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlLocalIpiRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.23
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

public class CLLCDLManifestDBDAOsearchCdlLocalIpiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCdlLocalIpi
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlLocalIpiRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlLocalIpiRSQL").append("\n");
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
		query.append("SELECT	DISTINCT DECODE(L1.SCC_CD, L2.SCC_CD, DECODE(SUBSTR(B.POD_CD,1,2), SUBSTR(B.DEL_CD,1,2), 'L', 'I'), 'I')||L3.LOC_CD||L3.LOC_NM LOCAL_IPI" ).append("\n");
		query.append("FROM BKG_BOOKING B, MDM_LOCATION L1, MDM_LOCATION L2, MDM_LOCATION L3" ).append("\n");
		query.append("WHERE B.BKG_NO		= @[bkg_no]" ).append("\n");
		query.append("AND B.POD_CD		= L1.LOC_CD(+)" ).append("\n");
		query.append("AND B.DEL_CD		= L2.LOC_CD(+)" ).append("\n");
		query.append("AND L2.SCC_CD		= L3.LOC_CD(+)" ).append("\n");

	}
}