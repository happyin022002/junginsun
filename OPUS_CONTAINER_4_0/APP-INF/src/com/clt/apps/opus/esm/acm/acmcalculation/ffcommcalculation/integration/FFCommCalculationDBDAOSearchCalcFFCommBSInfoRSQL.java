/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchCalcFFCommBSInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
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

public class FFCommCalculationDBDAOSearchCalcFFCommBSInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOSearchCalcFFCommBSInfoRSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchCalcFFCommBSInfoRSQL(){
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
		params.put("ff_bkg_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOSearchCalcFFCommBSInfoRSQL").append("\n"); 
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
		query.append("SELECT ROUND (NVL( SUM(CHG_AMT), 0), 2) FF_CALC_AMT, ROUND (NVL((SUM(CHG_AMT) * @[ff_bkg_rt]) / 100, 0), 2) ACT_COMM_AMT " ).append("\n"); 
		query.append("  FROM BKG_CHG_RT " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("	AND CURR_CD = 'USD' " ).append("\n"); 
		query.append("#if (${ff_chg_ctnt_div} != '') " ).append("\n"); 
		query.append("   AND CHG_CD IN ( " ).append("\n"); 
		query.append("				  #foreach ($key IN ${ff_chg_ctnt_div})" ).append("\n"); 
		query.append("		              #if($velocityCount < $ff_chg_ctnt_div.size())" ).append("\n"); 
		query.append("		                  '$key'," ).append("\n"); 
		query.append("		              #else" ).append("\n"); 
		query.append("		                  '$key'" ).append("\n"); 
		query.append("		              #end" ).append("\n"); 
		query.append("		          #end" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}