/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlBkgQtyListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.10 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalcHistoryDBDAOSearchCalcDtlBkgQtyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AGNCommCalcHistoryDBDAOSearchCalcDtlBkgQtyListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration").append("\n");
		query.append("FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlBkgQtyListRSQL").append("\n");
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
		query.append("SELECT CNTR_TPSZ_CD," ).append("\n");
		query.append("       SUM(OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n");
		query.append("  FROM BKG_QUANTITY" ).append("\n");
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append(" GROUP BY CNTR_TPSZ_CD" ).append("\n");

	}
}