/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchAuthChkXlsBtnPrmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
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

public class AuthorizationDBDAOsearchAuthChkXlsBtnPrmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Excel Download 승인여부 확인하는 화면인지 조회
	  * </pre>
	  */
	public AuthorizationDBDAOsearchAuthChkXlsBtnPrmtRSQL(){
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
		params.put("sub_sys_cd_auth",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AuthorizationDBDAOsearchAuthChkXlsBtnPrmtRSQL").append("\n"); 
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
		query.append("WITH XLS_RSTR AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    P.XLS_DL_RSTR_ACT_FLG, P.DFLT_XLS_DL_DUR_HRS" ).append("\n"); 
		query.append("    , P.AUTH_PGM_SEQ, NVL(P.USE_FLG,'N') PGM_USE_FLG" ).append("\n"); 
		query.append("    , B.AUTH_PGM_BTN_SEQ, NVL(B.USE_FLG,'N') BTN_USE_FLG" ).append("\n"); 
		query.append("    FROM COM_AUTH_PGM P, COM_PROGRAM C, COM_AUTH_PGM_BTN B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND P.PGM_NO = C.PGM_NO" ).append("\n"); 
		query.append("    AND NVL(C.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    AND P.AUTH_PGM_SEQ = B.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("    AND P.SUB_SYS_CD = @[sub_sys_cd_auth]" ).append("\n"); 
		query.append("    AND P.PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("    AND B.PGM_BTN_ID = 'EXCEL_DOWN_DUMMY' " ).append("\n"); 
		query.append("    AND B.AUTH_APRO_TP_CD = NVL(@[auth_apro_tp_cd],'BF')" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RQST AS (" ).append("\n"); 
		query.append("    SELECT Q.* FROM (  " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        DENSE_RANK() OVER (ORDER BY DECODE(NVL(R.AUTH_APSTS_CD,'X'),'C',1,'P',2,3), R.AUTH_APRO_RQST_NO DESC) RNK" ).append("\n"); 
		query.append("        , R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("        , NVL(R.AUTH_APSTS_CD,'X') AUTH_APSTS_CD" ).append("\n"); 
		query.append("        FROM COM_AUTH_APRO_RQST R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND NVL(R.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        AND NVL(R.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("        AND R.AUTH_PGM_BTN_SEQ = (SELECT X.AUTH_PGM_BTN_SEQ FROM XLS_RSTR X)" ).append("\n"); 
		query.append("        AND R.RQST_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("            (NVL(R.AUTH_APSTS_CD,'X') = 'C' AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(R.RQST_OFC_CD) BETWEEN R.RQST_END_DT AND R.RQST_END_DT + NVL((SELECT X.DFLT_XLS_DL_DUR_HRS FROM XLS_RSTR X),0)/24)" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            (NVL(R.AUTH_APSTS_CD,'X') = 'P')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    ) Q" ).append("\n"); 
		query.append("    WHERE Q.RNK = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("  WHEN NVL((SELECT X.PGM_USE_FLG FROM XLS_RSTR X),'') = 'Y' AND NVL((SELECT X.AUTH_PGM_SEQ FROM XLS_RSTR X),'') IS NOT NULL AND" ).append("\n"); 
		query.append("       NVL((SELECT X.BTN_USE_FLG FROM XLS_RSTR X),'') = 'Y' AND NVL((SELECT X.AUTH_PGM_BTN_SEQ FROM XLS_RSTR X),'') IS NOT NULL" ).append("\n"); 
		query.append("  THEN NVL((SELECT X.XLS_DL_RSTR_ACT_FLG FROM XLS_RSTR X),'X')" ).append("\n"); 
		query.append("  ELSE 'X'" ).append("\n"); 
		query.append("  END XLS_DL_RSTR_ACT_FLG" ).append("\n"); 
		query.append(", NVL((SELECT R.AUTH_APSTS_CD FROM RQST R),'') AUTH_APSTS_CD" ).append("\n"); 
		query.append(", NVL((SELECT R.AUTH_APRO_RQST_NO FROM RQST R),'') AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append(", NVL((SELECT X.AUTH_PGM_SEQ FROM XLS_RSTR X),'') AUTH_PGM_SEQ  " ).append("\n"); 
		query.append(", NVL((SELECT X.AUTH_PGM_BTN_SEQ FROM XLS_RSTR X),'') AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}