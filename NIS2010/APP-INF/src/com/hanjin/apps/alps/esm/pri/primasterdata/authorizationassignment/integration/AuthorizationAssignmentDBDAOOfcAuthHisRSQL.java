/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOOfcAuthHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29 
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

public class AuthorizationAssignmentDBDAOOfcAuthHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_AUTH_APRO_OFC_HIS 테이블 조회
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOOfcAuthHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("prc_ofc_auth_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOOfcAuthHisRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("	  AUTH_APRO_HIS_SEQ" ).append("\n"); 
		query.append("	, PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("	, PRC_OFC_AUTH_TP_CD" ).append("\n"); 
		query.append("	, AUTH_APRO_OFC_CD" ).append("\n"); 
		query.append("	, (SELECT OFC_ENG_NM FROM MDM_ORGANIZATION WHERE OFC_CD = AUTH_APRO_OFC_CD) AUTH_APRO_OFC_NM" ).append("\n"); 
		query.append("	, AUTH_APRO_DESC" ).append("\n"); 
		query.append("	, AUTH_APRO_USE_FLG" ).append("\n"); 
		query.append("	, PROG_USR_ID" ).append("\n"); 
		query.append("	, (SELECT USR_NM FROM COM_USER WHERE USR_ID = PROG_USR_ID) PROG_USR_NM" ).append("\n"); 
		query.append("	, PROG_OFC_CD" ).append("\n"); 
		query.append("	, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('GMT',PROG_GDT , GLOBALDATE_PKG.GET_LOCCD_FNC('SELSC')),'YYYY-MM-DD') AS PROG_GDT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  FROM PRI_AUTH_APRO_OFC_HIS" ).append("\n"); 
		query.append("	 WHERE PRC_CTRT_TP_CD = @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("	   AND PRC_OFC_AUTH_TP_CD = @[prc_ofc_auth_tp_cd]" ).append("\n"); 
		query.append("	 ORDER BY AUTH_APRO_HIS_SEQ DESC" ).append("\n"); 

	}
}