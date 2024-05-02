/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOTaxTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOTaxTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tax Type Search
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOTaxTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOTaxTypeRSQL").append("\n"); 
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
		query.append("SELECT DP_SEQ" ).append("\n"); 
		query.append("     , (100000 +(ROWNUM * 10)) AS SORT_KEY" ).append("\n"); 
		query.append("     , CODE" ).append("\n"); 
		query.append("     , NAME" ).append("\n"); 
		query.append("     , TAX_RATE" ).append("\n"); 
		query.append("     , TAX_INCOME_FLAG" ).append("\n"); 
		query.append("  FROM (SELECT SLD.LU_CD AS CODE" ).append("\n"); 
		query.append("             , SLD.LU_DESC AS NAME" ).append("\n"); 
		query.append("             , SLD.ATTR_CTNT1 AS TAX_RATE" ).append("\n"); 
		query.append("             , SLD.ATTR_CTNT2 AS TAX_INCOME_FLAG" ).append("\n"); 
		query.append("             , DP_SEQ" ).append("\n"); 
		query.append("          FROM SCO_LU_HDR SLH" ).append("\n"); 
		query.append("             , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("         WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("           AND SLH.LU_TP_CD = @[code]" ).append("\n"); 
		query.append("           AND NVL(SLD.ENBL_FLG, 'Y') = 'Y' " ).append("\n"); 
		query.append("#if(${sortkey} == '1')" ).append("\n"); 
		query.append("         ORDER BY SLD.LU_CD ASC" ).append("\n"); 
		query.append("#elseif(${sortkey} == '2')" ).append("\n"); 
		query.append("         ORDER BY SLD.LU_DESC ASC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         ORDER BY DP_SEQ ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}