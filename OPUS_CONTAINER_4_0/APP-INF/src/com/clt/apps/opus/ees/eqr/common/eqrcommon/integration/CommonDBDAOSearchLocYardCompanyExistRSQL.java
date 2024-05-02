/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchLocYardCompanyExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.18 
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

public class CommonDBDAOSearchLocYardCompanyExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC Yard 가 사용해도 되는 것인지 확인
	  * </pre>
	  */
	public CommonDBDAOSearchLocYardCompanyExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLocYardCompanyExistRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	COUNT(1) YD_CD							" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	MDM_LSE_CO_YD   	 		                " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	LSE_CO_YD_CD = @[locyard]                         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND  DELT_FLG <> 'Y'                           	    " ).append("\n"); 
		query.append("ORDER BY LSE_CO_YD_CD " ).append("\n"); 

	}
}