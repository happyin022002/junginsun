/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationDAOSearchResonListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.11 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KyungMin Woo
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class ContainerMovementValidationDBDAOSearchResonListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Search Reson List
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOSearchResonListRSQL(){
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
		query.append("select" ).append("\n");
		query.append("xch_rsn_cd," ).append("\n");
		query.append("xch_abbr_nm" ).append("\n");
		query.append("from ctm_mvmt_xch_rsn" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration ").append("\n");
		query.append("FileName : ContainerMovementValidationDAOSearchResonListRSQL").append("\n");
		query.append("*/").append("\n");
	}
}