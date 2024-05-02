/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PrdCommonManageDBDAOsearchContinentCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.05.15 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOsearchContinentCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 값의 Continent를 조회한다.
	  * </pre>
	  */
	public PrdCommonManageDBDAOsearchContinentCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_data",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOsearchContinentCodeRSQL").append("\n"); 
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
		query.append("SELECT CONTI_CD CHK FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD IN (SELECT SCONTI_CD FROM MDM_COUNTRY WHERE CNT_CD = SUBSTR(@[check_data], 1,2))" ).append("\n"); 

	}
}