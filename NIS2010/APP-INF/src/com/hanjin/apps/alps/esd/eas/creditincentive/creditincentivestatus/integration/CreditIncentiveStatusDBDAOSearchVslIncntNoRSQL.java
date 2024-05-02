/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchVslIncntNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.04 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOSearchVslIncntNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL Incentive No Search
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchVslIncntNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchVslIncntNoRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN MAX(SUBSTR(INCNT_NO,4)) IS NULL THEN 'VSL0001'" ).append("\n"); 
		query.append("            ELSE 'VSL'||LPAD(TO_NUMBER(MAX(SUBSTR(INCNT_NO,4)))+1,4,'0')" ).append("\n"); 
		query.append("        END AS INCNT_NO" ).append("\n"); 
		query.append("  FROM EAS_VSL_YRY_CR A" ).append("\n"); 
		query.append(" WHERE A.BSE_YR = @[bse_yr]" ).append("\n"); 

	}
}