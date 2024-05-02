/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrAccuracyTrendDBDAOSearchCheckLocCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.28
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.03.28 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrAccuracyTrendDBDAOSearchCheckLocCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check validation for Location Code 
	  * </pre>
	  */
	public CntrAccuracyTrendDBDAOSearchCheckLocCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.integration").append("\n"); 
		query.append("FileName : CntrAccuracyTrendDBDAOSearchCheckLocCdRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'T'" ).append("\n"); 
		query.append("                              ELSE 'F'" ).append("\n"); 
		query.append("          END LOCA_FLAG                              " ).append("\n"); 
		query.append("     FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${rcc_cd} != '')" ).append("\n"); 
		query.append("   	  AND RCC_CD  = @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp_cd} == 'L')" ).append("\n"); 
		query.append("	#if (${loc_cd} != '') " ).append("\n"); 
		query.append("	  AND LCC_CD  = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${loc_tp_cd} == 'S')" ).append("\n"); 
		query.append("	#if (${loc_cd} != '') " ).append("\n"); 
		query.append("	  AND SCC_CD  = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${loc_tp_cd} == 'E') " ).append("\n"); 
		query.append("	#if (${loc_cd} != '') " ).append("\n"); 
		query.append("	  AND ECC_CD  = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND DELT_FLG = 'N'" ).append("\n"); 

	}
}