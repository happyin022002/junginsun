/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SubContinentDBDAOSearchSubContinentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.06 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.scontinent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SubContinentDBDAOSearchSubContinentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SubContinent의 모든 목록을 가져온다.
	  * </pre>
	  */
	public SubContinentDBDAOSearchSubContinentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.scontinent.integration").append("\n"); 
		query.append("FileName : SubContinentDBDAOSearchSubContinentListRSQL").append("\n"); 
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
		query.append("SELECT sconti_cd," ).append("\n"); 
		query.append("sconti_nm," ).append("\n"); 
		query.append("'' conti_cd," ).append("\n"); 
		query.append("'' conti_nm" ).append("\n"); 
		query.append("FROM mdm_subcontinent" ).append("\n"); 
		query.append("WHERE 1 = 1 AND nvl(delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("#if(${sconti_cd} != '')" ).append("\n"); 
		query.append("AND sconti_cd LIKE @[sconti_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sconti_nm} != '')" ).append("\n"); 
		query.append("AND sconti_nm LIKE '%' || @[sconti_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}