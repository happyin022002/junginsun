/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalculationDBDAOSearchBkgCalculationRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.08.24 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalculationDBDAOSearchBkgCalculationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchBkgCalculation
	  * </pre>
	  */
	public AGNCommCalculationDBDAOSearchBkgCalculationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.integration").append("\n");
		query.append("FileName : AGNCommCalculationDBDAOSearchBkgCalculationRSQL").append("\n");
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
		query.append("SELECT B.BKG_NO," ).append("\n");
		query.append("  B.BL_NO," ).append("\n");
		query.append("  B.BKG_STS_CD," ).append("\n");
		query.append("  TO_CHAR(B.POL_ETD_DT, 'YYYY-MM-DD hh:mi:ss') AS POL_ETD_DT," ).append("\n");
		query.append("  TO_CHAR(I.UPD_DT, 'YYYY-MM-DD hh:mi:ss') AS UPD_DT," ).append("\n");
		query.append("  REV_VVD_CD AS REV_VVD_CD" ).append("\n");
		query.append("FROM BKG_BOOKING B ," ).append("\n");
		query.append("  ACM_AGN_BKG_INFO I" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("       AND B.BKG_NO IN (${bkg_no})" ).append("\n");
		query.append("  AND B.BKG_NO = I.BKG_NO (+)" ).append("\n");

	}
}