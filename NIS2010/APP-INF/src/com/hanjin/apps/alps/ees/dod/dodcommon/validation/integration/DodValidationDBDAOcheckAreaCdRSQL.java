/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodValidationDBDAOcheckAreaCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.11.20 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DodValidationDBDAOcheckAreaCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Area Code 유효성 검증
	  * </pre>
	  */
	public DodValidationDBDAOcheckAreaCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration").append("\n"); 
		query.append("FileName : DodValidationDBDAOcheckAreaCdRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 
		query.append(" #if(${s_type} == 'RCC')" ).append("\n"); 
		query.append("   AND RCC_CD = @[s_value]" ).append("\n"); 
		query.append(" #elseif(${s_type} == 'LCC')" ).append("\n"); 
		query.append("   AND LCC_CD = @[s_value]" ).append("\n"); 
		query.append(" #elseif(${s_type} == 'ECC')" ).append("\n"); 
		query.append("   AND ECC_CD = @[s_value]" ).append("\n"); 
		query.append(" #elseif(${s_type} == 'SCC')" ).append("\n"); 
		query.append("   AND SCC_CD = @[s_value]" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("   AND 1 = 2 -- DATA 검색 안되도록 조치" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}