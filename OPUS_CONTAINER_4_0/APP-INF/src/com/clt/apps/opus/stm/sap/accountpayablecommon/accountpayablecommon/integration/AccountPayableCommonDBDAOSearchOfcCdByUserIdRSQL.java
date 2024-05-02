/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchOfcCdByUserIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchOfcCdByUserIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Login User의 Office 정보 조건으로 Office 테이블의 AP Office
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchOfcCdByUserIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchOfcCdByUserIdRSQL").append("\n"); 
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
		query.append("SELECT AP_OFC_CD, AR_CURR_CD, LOC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 0 AS ORD, MO2.AP_OFC_CD ,  MO2.AR_CURR_CD , MO2.LOC_CD  " ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("   , MDM_ORGANIZATION MO2" ).append("\n"); 
		query.append("WHERE MO.OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("AND   MO.AP_OFC_CD = MO2.OFC_CD" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 1 AS ORD, MO2.AP_OFC_CD ,  MO2.AR_CURR_CD , MO2.LOC_CD " ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("   , MDM_ORGANIZATION MO2" ).append("\n"); 
		query.append("WHERE MO.OFC_CD  = (SELECT OFC_CD " ).append("\n"); 
		query.append("                FROM COM_USER" ).append("\n"); 
		query.append("                WHERE USR_ID = @[usr_id])" ).append("\n"); 
		query.append("AND   MO.AP_OFC_CD = MO2.OFC_CD" ).append("\n"); 
		query.append("ORDER BY ORD" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND   ROWNUM=1" ).append("\n"); 

	}
}