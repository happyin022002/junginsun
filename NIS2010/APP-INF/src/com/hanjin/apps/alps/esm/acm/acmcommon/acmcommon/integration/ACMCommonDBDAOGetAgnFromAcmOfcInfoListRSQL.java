/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetAgnFromAcmOfcInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.02 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetAgnFromAcmOfcInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ACMCommonDBDAOGetAgnFromAcmOfcInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value0",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration").append("\n"); 
		query.append("FileName : ACMCommonDBDAOGetAgnFromAcmOfcInfoListRSQL").append("\n"); 
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
		query.append("SELECT AGN_CD AS VALUE0" ).append("\n"); 
		query.append("  FROM ACM_OFC_INFO" ).append("\n"); 
		query.append("#if (${value0} != '')" ).append("\n"); 
		query.append(" WHERE AGN_CD = @[value0]" ).append("\n"); 
		query.append("   AND AGN_FM_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("   AND AGN_TO_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" GROUP BY AGN_CD" ).append("\n"); 
		query.append(" ORDER BY AGN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}