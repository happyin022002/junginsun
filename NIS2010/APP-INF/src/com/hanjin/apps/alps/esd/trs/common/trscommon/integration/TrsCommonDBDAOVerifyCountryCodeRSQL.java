/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrsCommonDBDAOVerifyCountryCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOVerifyCountryCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.23 변종건 [] Verify Country Code
	  * </pre>
	  */
	public TrsCommonDBDAOVerifyCountryCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOVerifyCountryCodeRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(A.CNT_CD) - $cnt_cd_arr.size(),0,'N','Y') AS ERR_FLG" ).append("\n"); 
		query.append("FROM    MDM_COUNTRY A" ).append("\n"); 
		query.append(", MDM_SUBCONTINENT B" ).append("\n"); 
		query.append(", MDM_CONTINENT C" ).append("\n"); 
		query.append("WHERE   A.SCONTI_CD=B.SCONTI_CD" ).append("\n"); 
		query.append("AND     B.CONTI_CD=C.CONTI_CD" ).append("\n"); 
		query.append("AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd_arr} != '')" ).append("\n"); 
		query.append("AND	    A.CNT_CD IN (" ).append("\n"); 
		query.append("#foreach ($cnt_cd_arr_num IN ${cnt_cd_arr})" ).append("\n"); 
		query.append("#if($velocityCount < $cnt_cd_arr.size())" ).append("\n"); 
		query.append("'$cnt_cd_arr_num'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$cnt_cd_arr_num'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}