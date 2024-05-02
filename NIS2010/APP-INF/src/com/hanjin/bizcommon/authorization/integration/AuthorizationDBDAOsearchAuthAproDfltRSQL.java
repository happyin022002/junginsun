/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchAuthAproDfltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.authorization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationDBDAOsearchAuthAproDfltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization Approval Default 목록 조회
	  * </pre>
	  */
	public AuthorizationDBDAOsearchAuthAproDfltRSQL(){
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
		params.put("sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOsearchAuthAproDfltRSQL").append("\n"); 
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
		query.append("WITH PRE_APRO_HIS AS ( " ).append("\n"); 
		query.append("    SELECT X.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT R.AUTH_APRO_RQST_NO " ).append("\n"); 
		query.append("        FROM COM_AUTH_APRO_RQST R " ).append("\n"); 
		query.append("        WHERE R.RQST_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("		AND NVL(R.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		AND NVL(R.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("        AND EXISTS (" ).append("\n"); 
		query.append("            SELECT 1 " ).append("\n"); 
		query.append("            FROM COM_AUTH_APRO_RQST_ROUT T" ).append("\n"); 
		query.append("            WHERE T.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("			AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ORDER BY R.AUTH_APRO_RQST_NO DESC" ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append("    WHERE ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("U.AUTH_APRO_ROUT_USR_SEQ, U.AUTH_APRO_USR_ID, U.AUTH_APRO_USR_NM, B.OFC_CD AUTH_APRO_OFC_CD, U.AUTH_APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append("FROM COM_AUTH_APRO_DFLT_ROUT R, COM_AUTH_APRO_DFLT_ROUT_USR U, COM_USER B" ).append("\n"); 
		query.append("WHERE R.AUTH_APRO_ROUT_SEQ = U.AUTH_APRO_ROUT_SEQ" ).append("\n"); 
		query.append("AND R.SUB_SYS_CD = DECODE(@[sub_sys_cd],'TLL','MNR',@[sub_sys_cd]) " ).append("\n"); 
		query.append("AND R.OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("AND R.PGM_NO = @[pgm_no] " ).append("\n"); 
		query.append("AND R.AUTH_APRO_TP_CD = @[auth_apro_tp_cd]" ).append("\n"); 
		query.append("AND NVL(R.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(U.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(B.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND U.AUTH_APRO_USR_ID IN (B.USR_ID,B.EP_ID)" ).append("\n"); 
		query.append("AND 'N' =   CASE " ).append("\n"); 
		query.append("            WHEN NVL((SELECT H.AUTH_APRO_RQST_NO FROM PRE_APRO_HIS H),'') IS NOT NULL" ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("AUTH_APRO_RQST_ROUT_SEQ, AUTH_APRO_USR_ID, AUTH_APRO_USR_NM, AUTH_APRO_OFC_CD, AUTH_APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append("FROM COM_AUTH_APRO_RQST_ROUT " ).append("\n"); 
		query.append("WHERE AUTH_APRO_RQST_NO = (SELECT H.AUTH_APRO_RQST_NO FROM PRE_APRO_HIS H) " ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND 'Y' =   CASE " ).append("\n"); 
		query.append("            WHEN NVL((SELECT H.AUTH_APRO_RQST_NO FROM PRE_APRO_HIS H),'') IS NOT NULL" ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("ORDER BY AUTH_APRO_ROUT_USR_SEQ DESC" ).append("\n"); 

	}
}