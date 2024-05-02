/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GenExpenseDBDAOCreateGeneralExpenseByVesselCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GenExpenseDBDAOCreateGeneralExpenseByVesselCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비용계산용 PRC, PKG 실행
	  * </pre>
	  */
	public GenExpenseDBDAOCreateGeneralExpenseByVesselCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration").append("\n"); 
		query.append("FileName : GenExpenseDBDAOCreateGeneralExpenseByVesselCSQL").append("\n"); 
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
		query.append("CALL COA_CREATE_VVD_GEN_EXPN_PRC(@[cost_yrmon])" ).append("\n"); 

	}
}