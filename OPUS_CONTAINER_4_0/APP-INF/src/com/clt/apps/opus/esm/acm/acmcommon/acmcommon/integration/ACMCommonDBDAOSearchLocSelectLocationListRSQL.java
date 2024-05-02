/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOSearchLocSelectLocationListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.30 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOSearchLocSelectLocationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchLocSelectLocationList
	  * </pre>
	  */
	public ACMCommonDBDAOSearchLocSelectLocationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration").append("\n");
		query.append("FileName : ACMCommonDBDAOSearchLocSelectLocationListRSQL").append("\n");
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
		query.append("    SELECT" ).append("\n");
		query.append("           '0' AS CHECKBOX," ).append("\n");
		query.append("           LOC_CD," ).append("\n");
		query.append("           LOC_NM" ).append("\n");
		query.append("      FROM MDM_LOCATION" ).append("\n");
		query.append("     WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("       AND CNT_CD" ).append("\n");
		query.append("        IN" ).append("\n");
		query.append("         (" ).append("\n");
		query.append("#if( '' != ${cnt_cd})" ).append("\n");
		query.append("           ${cnt_cd}" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("           NULL" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("         )" ).append("\n");
		query.append("  ORDER BY CNT_CD||STE_CD" ).append("\n");

	}
}