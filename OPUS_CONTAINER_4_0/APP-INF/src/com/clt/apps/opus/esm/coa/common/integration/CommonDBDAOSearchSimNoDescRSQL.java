/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOSearchSimNoDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.09.26 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungMin CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSimNoDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * simulation info 조회
	  * </pre>
	  */
	public CommonDBDAOSearchSimNoDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSimNoDescRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append("	,SIM_DEPT_CD" ).append("\n"); 
		query.append("	,SIM_DT" ).append("\n"); 
		query.append("	,SIM_NO" ).append("\n"); 
		query.append("	,CRE_USR_ID SIM_USR_ID" ).append("\n"); 
		query.append("	,SIM_RMK " ).append("\n"); 
		query.append("FROM COA_SIM_INFO " ).append("\n"); 
		query.append("WHERE SLAN_CD = @[f_slan_cd]" ).append("\n"); 
		query.append("	AND SIM_DT  = @[f_sim_dt]" ).append("\n"); 
		query.append("	AND SIM_NO  = @[f_sim_no]" ).append("\n"); 

	}
}