/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOsearchLocationFirstPOPDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.28 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOsearchLocationFirstPOPDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLocationFirstPOPData
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOsearchLocationFirstPOPDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOsearchLocationFirstPOPDataRSQL").append("\n"); 
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
		query.append("@[rqst_usr_id] AS USR_ID," ).append("\n"); 
		query.append("RCC_CD," ).append("\n"); 
		query.append("DECODE(ECC_CD,'',RCC_CD,ECC_CD) AS ECC_CD," ).append("\n"); 
		query.append("ECC_LVL," ).append("\n"); 
		query.append("'N' AS USE_FLG," ).append("\n"); 
		query.append("@[rqst_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("@[rqst_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT RCC_CD," ).append("\n"); 
		query.append("ECC_CD," ).append("\n"); 
		query.append("DECODE(ECC_CD,'',0,1) ECC_LVL" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS(RCC_CD,(RCC_CD,ECC_CD))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY RCC_CD,ECC_LVL,ECC_CD" ).append("\n"); 

	}
}