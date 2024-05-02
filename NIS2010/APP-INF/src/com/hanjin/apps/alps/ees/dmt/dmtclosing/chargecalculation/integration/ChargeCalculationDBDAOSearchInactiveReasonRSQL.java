/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchInactiveReasonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchInactiveReasonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchInactiveReasonRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchInactiveReasonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchInactiveReasonRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("CASE WHEN @[mn_rsn_cd] IS NULL THEN A.ATTR_CTNT1" ).append("\n"); 
		query.append("ELSE A.ATTR_CTNT3 END RSN_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN @[mn_rsn_cd] IS NULL THEN A.ATTR_CTNT2" ).append("\n"); 
		query.append("ELSE A.ATTR_CTNT4 END RSN_NM" ).append("\n"); 
		query.append("FROM DMT_HRD_CDG_CTNT A" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("AND A.HRD_CDG_ID = 'CHG_DELT_RSN_CD'" ).append("\n"); 
		query.append("#if (${mn_rsn_cd} != '' && ${mn_rsn_cd} != 'All')" ).append("\n"); 
		query.append("AND	A.ATTR_CTNT1   IN (" ).append("\n"); 
		query.append("#foreach( $mn_rsn_cd in ${mn_rsn_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $mn_rsn_cd_list.size()) '$mn_rsn_cd', #else '$mn_rsn_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}