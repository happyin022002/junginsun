/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchAuthPgmInfoRSQL.java
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

public class AuthorizationDBDAOsearchAuthPgmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization 설정 정보 조회
	  * </pre>
	  */
	public AuthorizationDBDAOsearchAuthPgmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOsearchAuthPgmInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("P.SUB_SYS_CD" ).append("\n"); 
		query.append(", P.PGM_NO" ).append("\n"); 
		query.append(", B.AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append(", B.AUTH_APRO_TP_CD" ).append("\n"); 
		query.append(", B.PGM_BTN_ID" ).append("\n"); 
		query.append(", B.PGM_BTN_NM" ).append("\n"); 
		query.append(", B.USE_FLG BTN_USE_FLG" ).append("\n"); 
		query.append(", NVL(F.PGM_FLD_ID,'N/A') PGM_FLD_ID" ).append("\n"); 
		query.append(", NVL(F.PGM_FLD_NM,'N/A') PGM_FLD_NM" ).append("\n"); 
		query.append(", NVL(F.USE_FLG,'N/A') FLD_USE_FLG" ).append("\n"); 
		query.append("FROM COM_AUTH_PGM P, COM_PROGRAM C, COM_AUTH_PGM_BTN B, COM_AUTH_PGM_FLD F" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.SUB_SYS_CD = @[sub_sys_cd] " ).append("\n"); 
		query.append("AND P.PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("AND P.PGM_NO = C.PGM_NO" ).append("\n"); 
		query.append("AND NVL(C.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND P.AUTH_PGM_SEQ = B.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("AND B.AUTH_PGM_BTN_SEQ = F.AUTH_PGM_BTN_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY P.AUTH_PGM_SEQ, B.AUTH_PGM_BTN_SEQ, F.AUTH_PGM_FLD_SEQ " ).append("\n"); 

	}
}