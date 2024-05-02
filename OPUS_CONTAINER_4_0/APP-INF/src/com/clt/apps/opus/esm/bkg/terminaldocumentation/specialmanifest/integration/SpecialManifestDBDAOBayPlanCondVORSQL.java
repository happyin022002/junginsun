/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAOBayPlanCondVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOBayPlanCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BayPlanCondVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAOBayPlanCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n");
		query.append("FileName : SpecialManifestDBDAOBayPlanCondVORSQL").append("\n");
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
		query.append("'' BAY_PLN_ID" ).append("\n");
		query.append(",'' EUR_DG_CNTR_ID" ).append("\n");
		query.append(",'' CELL_PSN_NO" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}