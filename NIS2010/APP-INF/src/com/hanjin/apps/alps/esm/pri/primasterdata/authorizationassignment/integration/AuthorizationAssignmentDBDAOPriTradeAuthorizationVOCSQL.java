/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOPriTradeAuthorizationVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentDBDAOPriTradeAuthorizationVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade Authorization Insert
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOPriTradeAuthorizationVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOPriTradeAuthorizationVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_AUTHORIZATION (" ).append("\n"); 
		query.append("      PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , USR_ID" ).append("\n"); 
		query.append("    , EFF_DT" ).append("\n"); 
		query.append("    , EXP_DT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("	, TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[prc_ctrt_tp_cd] AS PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("	, SVC_SCP_CD" ).append("\n"); 
		query.append("	, @[usr_id] AS USR_ID" ).append("\n"); 
		query.append("	, TO_DATE(@[eff_dt],'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("	, TO_DATE('99991231','YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("	, @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("	, SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("	, @[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("	, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("	, @[trd_cd]" ).append("\n"); 
		query.append("FROM PRI_SCG_TRD_SVC_SCP_MAPG" ).append("\n"); 
		query.append("WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}