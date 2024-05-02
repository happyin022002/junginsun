/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOSearchChargeCodeListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.23 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOSearchChargeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMSetupDBDAOSearchChargeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration").append("\n");
		query.append("FileName : ACMSetupDBDAOSearchChargeCodeListRSQL").append("\n");
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
		query.append("SELECT CHG_CD," ).append("\n");
		query.append("       CHG_NM," ).append("\n");
		query.append("       REP_CHG_CD," ).append("\n");
		query.append("       'C' AS CHG_DIV_CD" ).append("\n");
		query.append("  FROM MDM_CHARGE" ).append("\n");
		query.append(" WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append(" ORDER BY REP_CHG_CD" ).append("\n");

	}
}