/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOcreateAuthPgmFldCSQL.java
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

public class AuthorizationDBDAOcreateAuthPgmFldCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AUTH_PGM_FLD Add/Update
	  * </pre>
	  */
	public AuthorizationDBDAOcreateAuthPgmFldCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_fld_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_pgm_fld_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pgm_btn_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pgm_fld_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOcreateAuthPgmFldCSQL").append("\n"); 
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
		query.append("MERGE INTO COM_AUTH_PGM_FLD F" ).append("\n"); 
		query.append("USING (SELECT B.*" ).append("\n"); 
		query.append("       FROM COM_AUTH_PGM P, COM_AUTH_PGM_BTN B " ).append("\n"); 
		query.append("       WHERE P.AUTH_PGM_SEQ = B.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("       AND P.SUB_SYS_CD = @[sub_sys_cd_auth] AND P.PGM_NO = @[pgm_no] " ).append("\n"); 
		query.append("       AND B.PGM_BTN_ID = @[pgm_btn_id] AND B.AUTH_APRO_TP_CD = @[auth_apro_tp_cd]) P" ).append("\n"); 
		query.append("ON ((F.AUTH_PGM_BTN_SEQ = P.AUTH_PGM_BTN_SEQ AND F.PGM_FLD_NM = @[pgm_fld_nm] AND F.PGM_FLD_ID = @[pgm_fld_id]) OR (F.AUTH_PGM_FLD_SEQ = @[auth_pgm_fld_seq]))" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET" ).append("\n"); 
		query.append("        F.PGM_FLD_NM = @[pgm_fld_nm]," ).append("\n"); 
		query.append("		F.PGM_FLD_ID = @[pgm_fld_id]," ).append("\n"); 
		query.append("        F.UPD_USR_ID = @[usr_id], --UPD_USR_ID," ).append("\n"); 
		query.append("        F.UPD_DT = SYSDATE  --UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        AUTH_PGM_FLD_SEQ," ).append("\n"); 
		query.append("        AUTH_PGM_BTN_SEQ," ).append("\n"); 
		query.append("        PGM_FLD_NM," ).append("\n"); 
		query.append("        PGM_FLD_ID," ).append("\n"); 
		query.append("     USE_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT" ).append("\n"); 
		query.append(" ) VALUES (" ).append("\n"); 
		query.append("        (SELECT NVL(MAX(X.AUTH_PGM_FLD_SEQ),0) + 1 NEWSEQ FROM COM_AUTH_PGM_FLD X), --AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append("        (SELECT MAX(B.AUTH_PGM_BTN_SEQ)" ).append("\n"); 
		query.append("         FROM COM_AUTH_PGM P, COM_AUTH_PGM_BTN B " ).append("\n"); 
		query.append("         WHERE P.AUTH_PGM_SEQ = B.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("         AND P.SUB_SYS_CD = @[sub_sys_cd_auth] AND P.PGM_NO = @[pgm_no] " ).append("\n"); 
		query.append("         AND B.PGM_BTN_ID = @[pgm_btn_id] AND B.AUTH_APRO_TP_CD = @[auth_apro_tp_cd]), --AUTH_PGM_SEQ " ).append("\n"); 
		query.append("        @[pgm_fld_nm], --PGM_BTN_NM," ).append("\n"); 
		query.append("        @[pgm_fld_id], --PGM_BTN_ID" ).append("\n"); 
		query.append("     'Y', --USE_FLG," ).append("\n"); 
		query.append("        @[usr_id], --CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE, --CRE_DT" ).append("\n"); 
		query.append("        @[usr_id], --UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE  --UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}