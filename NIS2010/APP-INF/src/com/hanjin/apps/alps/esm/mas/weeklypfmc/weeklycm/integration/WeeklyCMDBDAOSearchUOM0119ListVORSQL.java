/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchUOM0119ListVORSQL.java
*@FileTitle : Acct Code Setting to select UOM
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.09 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchUOM0119ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TML ITEM 코드 조회   
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchUOM0119ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchUOM0119ListVORSQL").append("\n"); 
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
		query.append("SELECT A.TML_CD" ).append("\n"); 
		query.append(",A.TML_TRF_ITM_CD" ).append("\n"); 
		query.append(",A.TML_TRF_DTL_CD" ).append("\n"); 
		query.append(",A.MAS_COST_SRC_CD" ).append("\n"); 
		query.append(",B.MAS_COST_SRC_CD_NM" ).append("\n"); 
		query.append(",A.TML_DESC" ).append("\n"); 
		query.append(",A.TML_TRF_ITM_DESC" ).append("\n"); 
		query.append(",A.TML_TRF_DTL_DESC" ).append("\n"); 
		query.append(",A.TML_UT_CD" ).append("\n"); 
		query.append("--,A.TML_TRF_DTL_CD MN_TRF_DTL_CD" ).append("\n"); 
		query.append("FROM MAS_TML_TRF_GRP A" ).append("\n"); 
		query.append(",MAS_COST_SRC_ACCT B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.MAS_COST_SRC_CD = B.MAS_COST_SRC_CD" ).append("\n"); 
		query.append("ORDER BY A.TML_CD, A.TML_TRF_ITM_CD,A.TML_TRF_DTL_CD,A.MAS_COST_SRC_CD" ).append("\n"); 

	}
}