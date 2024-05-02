/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchARAPOfcCdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.11
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchARAPOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchARAPOfcCdRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchARAPOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n");
		query.append("FileName : FACCommCalculationDBDAOSearchARAPOfcCdRSQL").append("\n");
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
		query.append("SELECT AR_OFC_CD, AP_OFC_CD," ).append("\n");
		query.append("       DECODE (DECODE (LTRIM (OFC_TP_CD), 'BA', 'Y', 'OT', 'Y', 'N')," ).append("\n");
		query.append("               'Y', VNDR_CNT_CD || TO_CHAR (VNDR_SEQ, 'FM000000')," ).append("\n");
		query.append("               ''" ).append("\n");
		query.append("              ) VNDR_CNT_SEQ" ).append("\n");
		query.append("  FROM MDM_ORGANIZATION" ).append("\n");
		query.append(" WHERE OFC_CD = @[ppd_ofc_cd]" ).append("\n");

	}
}