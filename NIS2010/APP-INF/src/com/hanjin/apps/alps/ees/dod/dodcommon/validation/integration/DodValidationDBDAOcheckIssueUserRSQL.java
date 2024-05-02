/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodValidationDBDAOcheckIssueUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.12.08 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DodValidationDBDAOcheckIssueUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Login한 사용자가 AR Invoice Issue화면에 접근권한이 있는지 확인한다
	  * </pre>
	  */
	public DodValidationDBDAOcheckIssueUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration").append("\n"); 
		query.append("FileName : DodValidationDBDAOcheckIssueUserRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_HASH(BA BB BC BD) ORDERED */" ).append("\n"); 
		query.append("--        DISTINCT BA.PGM_NO," ).append("\n"); 
		query.append("        COUNT(1) CNT" ).append("\n"); 
		query.append("--       BA.PGM_NM," ).append("\n"); 
		query.append("--       BA.PGM_URL," ).append("\n"); 
		query.append("--       BA.PGM_LVL_DIV_CD," ).append("\n"); 
		query.append("--       BA.POPUP_FLG" ).append("\n"); 
		query.append("  FROM COM_PROGRAM BA," ).append("\n"); 
		query.append("       COM_PGM_ROLE BB," ).append("\n"); 
		query.append("       COM_USR_ROLE BC," ).append("\n"); 
		query.append("       COM_USR_ROLE_MTCH BD" ).append("\n"); 
		query.append(" WHERE BA.PGM_TP_CD = '00'" ).append("\n"); 
		query.append("   AND BA.USE_FLG = 'Y'" ).append("\n"); 
		query.append("   AND BA.POPUP_FLG = 'N'" ).append("\n"); 
		query.append("   AND BA.PGM_MNU_DIV_CD = '02'" ).append("\n"); 
		query.append("   AND BA.PGM_NO = BB.PGM_NO" ).append("\n"); 
		query.append("   AND BB.USR_ROLE_CD = BC.USR_ROLE_CD" ).append("\n"); 
		query.append("   AND BC.USR_ROLE_CD = BD.USR_ROLE_CD" ).append("\n"); 
		query.append("   AND BD.USR_ID = @[s_value] -- Login UserId" ).append("\n"); 
		query.append("   AND BA.PGM_NO ='FNS_INV_0034-01' -- AR Invoice Issue Program" ).append("\n"); 

	}
}