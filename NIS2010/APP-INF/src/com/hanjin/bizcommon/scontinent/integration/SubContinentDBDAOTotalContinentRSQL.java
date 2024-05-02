/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SubContinentDBDAOTotalContinentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.scontinent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SubContinentDBDAOTotalContinentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Continent의 총 카운트를 조회한다.
	  * </pre>
	  */
	public SubContinentDBDAOTotalContinentRSQL(){
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
		query.append("FileName : SubContinentDBDAOTotalContinentRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
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