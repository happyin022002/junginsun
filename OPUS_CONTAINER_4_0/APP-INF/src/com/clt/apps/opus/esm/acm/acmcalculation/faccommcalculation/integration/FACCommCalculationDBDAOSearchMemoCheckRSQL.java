/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchMemoCheckRSQL.java
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

public class FACCommCalculationDBDAOSearchMemoCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchMemoCheckRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchMemoCheckRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n");
		query.append("FileName : FACCommCalculationDBDAOSearchMemoCheckRSQL").append("\n");
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
		query.append("  CASE" ).append("\n");
		query.append("  WHEN EXISTS" ).append("\n");
		query.append("     (" ).append("\n");
		query.append("           SELECT" ).append("\n");
		query.append("                  1" ).append("\n");
		query.append("             FROM BKG_BOOKING BK3" ).append("\n");
		query.append("            WHERE BK3.BKG_NO = BKG.FM_BKG_NO" ).append("\n");
		query.append("              AND BK3.SPLIT_FLG = 'Y'" ).append("\n");
		query.append("              AND BK3.SPLIT_RSN_CD = 'M'" ).append("\n");
		query.append("              AND BKG.BKG_CRE_TP_CD = 'S'" ).append("\n");
		query.append("     )" ).append("\n");
		query.append("  THEN 1" ).append("\n");
		query.append("  ELSE 0" ).append("\n");
		query.append("   END AS MEMO_CHECK" ).append("\n");
		query.append("  FROM BKG_BOOKING BKG" ).append("\n");
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]--'DUS101173700'" ).append("\n");

	}
}