/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchEuCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchEuCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEuCheck
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchEuCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchEuCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE (SUM(CONTI_CD), 0 , 'N', 1,'N','Y')  EU_CHECK " ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT COUNT(CONTI_CD) CONTI_CD" ).append("\n"); 
		query.append("    FROM MDM_COUNTRY MCNT" ).append("\n"); 
		query.append("       , MDM_SUBCONTINENT SCNT" ).append("\n"); 
		query.append("    WHERE MCNT.CNT_CD = SUBSTR(@[pol_cd], 1,2)" ).append("\n"); 
		query.append("    AND MCNT.SCONTI_CD = SCNT.SCONTI_CD" ).append("\n"); 
		query.append("    AND SCNT.CONTI_CD = 'E' " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(CONTI_CD) CONTI_CD" ).append("\n"); 
		query.append("    FROM MDM_COUNTRY MCNT" ).append("\n"); 
		query.append("       , MDM_SUBCONTINENT SCNT" ).append("\n"); 
		query.append("    WHERE MCNT.CNT_CD = SUBSTR(@[pod_cd], 1,2)" ).append("\n"); 
		query.append("     AND MCNT.SCONTI_CD = SCNT.SCONTI_CD" ).append("\n"); 
		query.append("     AND SCNT.CONTI_CD = 'E' " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}