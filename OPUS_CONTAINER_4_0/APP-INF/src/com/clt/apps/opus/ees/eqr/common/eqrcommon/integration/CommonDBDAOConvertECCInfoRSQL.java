/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOConvertECCInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOConvertECCInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ecc code를 검색해서 and ecc_cd in () 형식 스트링으로 리턴
	  * </pre>
	  */
	public CommonDBDAOConvertECCInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOConvertECCInfoRSQL").append("\n"); 
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
		query.append("DISTINCT(ECC_CD) ECC_CD" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("#if(${loctype} == 'R')" ).append("\n"); 
		query.append("WHERE RCC_CD IN (" ).append("\n"); 
		query.append("#if($locationArr.size() == 0)" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach( ${key} in ${locationArr})" ).append("\n"); 
		query.append("#if($velocityCount < $locationArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${loctype} == 'L')" ).append("\n"); 
		query.append("WHERE LCC_CD IN (" ).append("\n"); 
		query.append("#if($locationArr.size() == 0)" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach( ${key} in ${locationArr})" ).append("\n"); 
		query.append("#if($velocityCount < $locationArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${loctype} == 'E')" ).append("\n"); 
		query.append("WHERE ECC_CD IN (" ).append("\n"); 
		query.append("#if($locationArr.size() == 0)" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach( ${key} in ${locationArr})" ).append("\n"); 
		query.append("#if($velocityCount < $locationArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}