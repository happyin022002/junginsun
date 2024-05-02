/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOcreateAuthPgmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.30 
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

public class AuthorizationDBDAOcreateAuthPgmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AUTH_PGM에 새로운 항목 추가
	  * </pre>
	  */
	public AuthorizationDBDAOcreateAuthPgmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_pgm_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_sys_cd_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOcreateAuthPgmCSQL").append("\n"); 
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
		query.append("MERGE INTO COM_AUTH_PGM P" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON ((P.SUB_SYS_CD = @[sub_sys_cd_auth] AND P.PGM_NO = @[pgm_no]) or (P.AUTH_PGM_SEQ = @[auth_pgm_seq]))" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE SET" ).append("\n"); 
		query.append("		P.PGM_NO = @[pgm_no]," ).append("\n"); 
		query.append("        P.PGM_RMK = @[pgm_rmk]," ).append("\n"); 
		query.append("        P.UPD_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("        P.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        AUTH_PGM_SEQ," ).append("\n"); 
		query.append("        SUB_SYS_CD," ).append("\n"); 
		query.append("        PGM_NO," ).append("\n"); 
		query.append("        PGM_RMK," ).append("\n"); 
		query.append("     USE_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT" ).append("\n"); 
		query.append(" ) VALUES (" ).append("\n"); 
		query.append("        (SELECT NVL(MAX(X.AUTH_PGM_SEQ),0) + 1 NEWSEQ FROM COM_AUTH_PGM X), --AUTH_PGM_SEQ" ).append("\n"); 
		query.append("        @[sub_sys_cd_auth], --SUB_SYS_CD," ).append("\n"); 
		query.append("        @[pgm_no], --PGM_NO" ).append("\n"); 
		query.append("        @[pgm_rmk], --PGM_RMK" ).append("\n"); 
		query.append("     'Y', --USE_FLG," ).append("\n"); 
		query.append("        @[usr_id], --CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE, --CRE_DT" ).append("\n"); 
		query.append("        @[usr_id], --UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE  --UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}