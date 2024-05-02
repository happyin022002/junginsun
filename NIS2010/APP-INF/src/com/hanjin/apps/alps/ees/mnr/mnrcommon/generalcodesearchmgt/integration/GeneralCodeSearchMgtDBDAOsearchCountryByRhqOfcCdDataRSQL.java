/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchCountryByRhqOfcCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.01
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.01 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchCountryByRhqOfcCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCountryByRhqOfcCdData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchCountryByRhqOfcCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchcon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchCountryByRhqOfcCdDataRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT MDC.CNT_CD AS CD_ID,MDC.CNT_NM AS CD_DESC FROM MDM_LOCATION MDL,MDM_COUNTRY MDC" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${searchcon} != 'A')" ).append("\n"); 
		query.append("AND MDL.LOC_CD  IN (" ).append("\n"); 
		query.append("SELECT DISTINCT LOC_CD" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION  A" ).append("\n"); 
		query.append("WHERE A.AR_HD_QTR_OFC_CD LIKE '%'|| NVL(@[searchcon],'') ||'%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MDL.CNT_CD = MDC.CNT_CD" ).append("\n"); 
		query.append("ORDER BY MDC.CNT_CD" ).append("\n"); 

	}
}