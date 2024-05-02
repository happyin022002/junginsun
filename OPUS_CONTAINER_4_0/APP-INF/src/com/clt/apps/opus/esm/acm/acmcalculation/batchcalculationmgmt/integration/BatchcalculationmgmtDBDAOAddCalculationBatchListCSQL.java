/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BatchcalculationmgmtDBDAOAddCalculationBatchListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.17 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.batchcalculationmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BatchcalculationmgmtDBDAOAddCalculationBatchListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * AddCalculationBatchList
	  * </pre>
	  */
	public BatchcalculationmgmtDBDAOAddCalculationBatchListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.batchcalculationmgmt.integration").append("\n");
		query.append("FileName : BatchcalculationmgmtDBDAOAddCalculationBatchListCSQL").append("\n");
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
		query.append("Call ACM_ADD_CALC_BAT_LIST_PRC (@[bkg_no], @[usr_id])" ).append("\n");

	}
}