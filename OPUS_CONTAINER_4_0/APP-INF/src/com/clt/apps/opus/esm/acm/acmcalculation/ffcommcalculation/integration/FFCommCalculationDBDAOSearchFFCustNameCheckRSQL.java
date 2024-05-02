/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchFFCustNameCheckRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.17
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.17
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOSearchFFCustNameCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FFCommCalculationDBDAOSearchFFCustNameCheckRSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchFFCustNameCheckRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n");
		query.append("FileName : FFCommCalculationDBDAOSearchFFCustNameCheckRSQL").append("\n");
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
		query.append("SELECT BC.BKG_NO, NVL(REPLACE(REPLACE(BC.CUST_NM, CHR(13)||CHR(10), ' '), CHR(9),' '), ' ') CUST_NM" ).append("\n");
		query.append("  FROM BKG_CUSTOMER BC," ).append("\n");
		query.append("  (SELECT NVL(REPLACE(REPLACE(UPPER(CUST_LGL_ENG_NM), CHR(13)||CHR(10), ' '), CHR(9),' '), ' ') CUST_LGL_ENG_NM " ).append("\n");
		query.append("          FROM MDM_CUSTOMER " ).append("\n");
		query.append("         WHERE CUST_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n");
		query.append("           AND CUST_SEQ = @[bkg_ff_seq]" ).append("\n");
		query.append("           AND NVL (DELT_FLG, 'N') = 'N' ) CN" ).append("\n");
		query.append(" WHERE BC.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("  AND BC.BKG_CUST_TP_CD = 'F'" ).append("\n");
		query.append("  AND UPPER(BC.CUST_NM) LIKE" ).append("\n");
		query.append("  (CASE WHEN LENGTH(CN.CUST_LGL_ENG_NM) > 10 " ).append("\n");
		query.append("    THEN SUBSTR(CN.CUST_LGL_ENG_NM,1,10) || '%'" ).append("\n");
		query.append("    ELSE CN.CUST_LGL_ENG_NM END)" ).append("\n");

	}
}