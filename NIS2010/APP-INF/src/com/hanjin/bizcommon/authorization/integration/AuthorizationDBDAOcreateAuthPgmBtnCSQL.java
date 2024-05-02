/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOcreateAuthPgmBtnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.03 
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

public class AuthorizationDBDAOcreateAuthPgmBtnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AUTH_PGM_BTN 새 항목 추가 및 Update
	  * </pre>
	  */
	public AuthorizationDBDAOcreateAuthPgmBtnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_btn_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dtl_pgm_url_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auth_pgm_btn_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auth_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOcreateAuthPgmBtnCSQL").append("\n"); 
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
		query.append("MERGE INTO COM_AUTH_PGM_BTN B" ).append("\n"); 
		query.append("USING (SELECT P.AUTH_PGM_SEQ, P.SUB_SYS_CD, P.PGM_NO FROM COM_AUTH_PGM P WHERE P.SUB_SYS_CD = @[sub_sys_cd_auth] AND P.PGM_NO = @[pgm_no]) P" ).append("\n"); 
		query.append("ON ((B.AUTH_PGM_SEQ = P.AUTH_PGM_SEQ AND B.PGM_BTN_ID = @[pgm_btn_id] AND B.AUTH_APRO_TP_CD = @[auth_apro_tp_cd]) OR (B.AUTH_PGM_BTN_SEQ = @[auth_pgm_btn_seq]))" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET" ).append("\n"); 
		query.append("        B.PGM_BTN_ID = @[pgm_btn_id]," ).append("\n"); 
		query.append("		B.AUTH_APRO_TP_CD = @[auth_apro_tp_cd]," ).append("\n"); 
		query.append("        B.UPD_USR_ID = @[usr_id],  --UPD_USR_ID,-" ).append("\n"); 
		query.append("        B.UPD_DT = SYSDATE  --UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        AUTH_PGM_BTN_SEQ," ).append("\n"); 
		query.append("        AUTH_PGM_SEQ," ).append("\n"); 
		query.append("        PGM_BTN_NM," ).append("\n"); 
		query.append("        PGM_BTN_ID," ).append("\n"); 
		query.append("        DTL_PGM_URL_CTNT," ).append("\n"); 
		query.append("        AUTH_APRO_TP_CD," ).append("\n"); 
		query.append("     USE_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT" ).append("\n"); 
		query.append(" ) VALUES (" ).append("\n"); 
		query.append("        (SELECT NVL(MAX(X.AUTH_PGM_BTN_SEQ),0) + 1 NEWSEQ FROM COM_AUTH_PGM_BTN X), --AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append("        (SELECT MAX(P.AUTH_PGM_SEQ) AUTH_PGM_SEQ FROM COM_AUTH_PGM P WHERE P.SUB_SYS_CD = @[sub_sys_cd_auth] AND P.PGM_NO = @[pgm_no]), --AUTH_PGM_SEQ " ).append("\n"); 
		query.append("        @[pgm_btn_nm], --PGM_BTN_NM," ).append("\n"); 
		query.append("        @[pgm_btn_id], --PGM_BTN_ID" ).append("\n"); 
		query.append("        @[dtl_pgm_url_ctnt], --DTL_PGM_URL_CTNT" ).append("\n"); 
		query.append("        @[auth_apro_tp_cd], --AUTH_APRO_TP_CD " ).append("\n"); 
		query.append("     'Y', --USE_FLG," ).append("\n"); 
		query.append("        @[usr_id], --CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE, --CRE_DT" ).append("\n"); 
		query.append("        @[usr_id], --UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE  --UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}