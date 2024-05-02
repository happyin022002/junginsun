/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchSRouteFromListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.05.19 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon Yong Park
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class BLIssuanceDBDAOsearchSRouteFromListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ESM_BKG_0278 SRoute Combo Search
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchSRouteFromListRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
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
		query.append("SELECT sconti_cd val," ).append("\n");
		query.append("sconti_cd name" ).append("\n");
		query.append("FROM mdm_subcontinent" ).append("\n");
		query.append("WHERE delt_flg = 'N'" ).append("\n");
		query.append("ORDER BY sconti_cd" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n");
		query.append("FileName : BLIssuanceDBDAOsearchSRouteFromListRSQL").append("\n");
		query.append("*/").append("\n");
	}
}