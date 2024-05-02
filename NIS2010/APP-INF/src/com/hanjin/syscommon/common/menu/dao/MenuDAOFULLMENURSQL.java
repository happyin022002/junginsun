/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MenuDAOFULLMENURSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.menu.dao;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MenuDAOFULLMENURSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select full menu list
	  * </pre>
	  */
	public MenuDAOFULLMENURSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mnu_cfg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("level",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prnt_pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.common.menu.dao").append("\n"); 
		query.append("FileName : MenuDAOFULLMENURSQL").append("\n"); 
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
		query.append("WITH T1 AS (" ).append("\n"); 
		query.append("    SELECT /*+ MATERIALIZE */" ).append("\n"); 
		query.append("	  A.MNU_CFG_CD," ).append("\n"); 
		query.append("      A.PRNT_PGM_NO," ).append("\n"); 
		query.append("      A.CHD_PGM_NO," ).append("\n"); 
		query.append("      A.PGM_LVL_VAL," ).append("\n"); 
		query.append("      A.DP_SEQ ," ).append("\n"); 
		query.append("      B.PGM_NO," ).append("\n"); 
		query.append("      B.PGM_NM," ).append("\n"); 
		query.append("      B.PGM_URL," ).append("\n"); 
		query.append("      B.PGM_LVL_DIV_CD," ).append("\n"); 
		query.append("      B.POPUP_FLG," ).append("\n"); 
		query.append("      'Y' AUTH_YN" ).append("\n"); 
		query.append("    FROM COM_MNU_CFG A," ).append("\n"); 
		query.append("      COM_PROGRAM B" ).append("\n"); 
		query.append("    WHERE A.MNU_CFG_CD = @[mnu_cfg_cd]" ).append("\n"); 
		query.append("      AND A.CHD_PGM_NO = B.PGM_NO" ).append("\n"); 
		query.append("      AND B.PGM_TP_CD = '00'" ).append("\n"); 
		query.append("      AND B.USE_FLG = 'Y'" ).append("\n"); 
		query.append("      AND B.POPUP_FLG = 'N'" ).append("\n"); 
		query.append("      AND B.PGM_MNU_DIV_CD = '01'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT A.MNU_CFG_CD," ).append("\n"); 
		query.append("      A.PRNT_PGM_NO," ).append("\n"); 
		query.append("      A.CHD_PGM_NO," ).append("\n"); 
		query.append("      A.PGM_LVL_VAL," ).append("\n"); 
		query.append("      A.DP_SEQ ," ).append("\n"); 
		query.append("      B.PGM_NO," ).append("\n"); 
		query.append("      B.PGM_NM," ).append("\n"); 
		query.append("      C.PGM_URL," ).append("\n"); 
		query.append("      B.PGM_LVL_DIV_CD," ).append("\n"); 
		query.append("      B.POPUP_FLG," ).append("\n"); 
		query.append("      DECODE(C.PGM_URL, NULL, 'N', 'Y') AUTH_YN" ).append("\n"); 
		query.append("    FROM COM_MNU_CFG A," ).append("\n"); 
		query.append("      COM_PROGRAM B," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT AUTH.PGM_NO," ).append("\n"); 
		query.append("          AUTH.PGM_NM," ).append("\n"); 
		query.append("          AUTH.PGM_URL," ).append("\n"); 
		query.append("          AUTH.PGM_LVL_DIV_CD," ).append("\n"); 
		query.append("          AUTH.POPUP_FLG" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT /*+ USE_HASH(BA BB BC BD) ORDERED */ DISTINCT BA.PGM_NO," ).append("\n"); 
		query.append("              BA.PGM_NM," ).append("\n"); 
		query.append("              BA.PGM_URL," ).append("\n"); 
		query.append("              BA.PGM_LVL_DIV_CD," ).append("\n"); 
		query.append("              BA.POPUP_FLG" ).append("\n"); 
		query.append("            FROM COM_PROGRAM BA," ).append("\n"); 
		query.append("              COM_PGM_ROLE BB," ).append("\n"); 
		query.append("              COM_USR_ROLE BC," ).append("\n"); 
		query.append("              COM_USR_ROLE_MTCH BD" ).append("\n"); 
		query.append("            WHERE BA.PGM_TP_CD = '00'" ).append("\n"); 
		query.append("              AND BA.USE_FLG = 'Y'" ).append("\n"); 
		query.append("              AND BA.POPUP_FLG = 'N'" ).append("\n"); 
		query.append("              AND BA.PGM_MNU_DIV_CD = '02'" ).append("\n"); 
		query.append("              AND BA.PGM_NO = BB.PGM_NO" ).append("\n"); 
		query.append("              AND BB.USR_ROLE_CD = BC.USR_ROLE_CD" ).append("\n"); 
		query.append("              AND BC.USR_ROLE_CD = BD.USR_ROLE_CD" ).append("\n"); 
		query.append("              AND BD.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("            UNION" ).append("\n"); 
		query.append("            SELECT BB.PGM_NO," ).append("\n"); 
		query.append("              BB.PGM_NM," ).append("\n"); 
		query.append("              BB.PGM_URL," ).append("\n"); 
		query.append("              bb.pgm_lvl_div_cd," ).append("\n"); 
		query.append("              bb.popup_flg" ).append("\n"); 
		query.append("            FROM COM_PROGRAM BB," ).append("\n"); 
		query.append("              COM_USR_PGM_MTCH CC" ).append("\n"); 
		query.append("            WHERE BB.PGM_NO = CC.PGM_NO" ).append("\n"); 
		query.append("              AND BB.PGM_TP_CD = '00'" ).append("\n"); 
		query.append("              AND BB.USE_FLG = 'Y'" ).append("\n"); 
		query.append("              AND NVL(BB.POPUP_FLG, 'N') != 'Y'" ).append("\n"); 
		query.append("              AND CC.ADD_FLG = 'Y'" ).append("\n"); 
		query.append("              AND CC.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("            UNION" ).append("\n"); 
		query.append("			SELECT /*+ LEADING( CC ) */ BB.PGM_NO," ).append("\n"); 
		query.append("              BB.PGM_NM," ).append("\n"); 
		query.append("              BB.PGM_URL," ).append("\n"); 
		query.append("              bb.pgm_lvl_div_cd," ).append("\n"); 
		query.append("              bb.popup_flg" ).append("\n"); 
		query.append("            FROM COM_PROGRAM BB," ).append("\n"); 
		query.append("              COM_PGM_ROLE CC" ).append("\n"); 
		query.append("            WHERE BB.PGM_NO = CC.PGM_NO" ).append("\n"); 
		query.append("              AND CC.USR_ROLE_CD = SUBSTR(@[prnt_pgm_no], 5, 3)||'99'" ).append("\n"); 
		query.append("            MINUS" ).append("\n"); 
		query.append("            SELECT BB.PGM_NO," ).append("\n"); 
		query.append("              BB.PGM_NM," ).append("\n"); 
		query.append("              BB.PGM_URL," ).append("\n"); 
		query.append("              bb.pgm_lvl_div_cd," ).append("\n"); 
		query.append("              bb.popup_flg" ).append("\n"); 
		query.append("            FROM COM_PROGRAM BB," ).append("\n"); 
		query.append("              COM_USR_PGM_MTCH CC" ).append("\n"); 
		query.append("            WHERE BB.PGM_NO = CC.PGM_NO" ).append("\n"); 
		query.append("              AND BB.PGM_TP_CD = '00'" ).append("\n"); 
		query.append("              AND BB.USE_FLG = 'Y'" ).append("\n"); 
		query.append("              AND NVL(BB.POPUP_FLG, 'N') != 'Y'" ).append("\n"); 
		query.append("              AND CC.ADD_FLG = 'N'" ).append("\n"); 
		query.append("              AND CC.USR_ID = @[usr_id] ) AUTH," ).append("\n"); 
		query.append("          COM_OFC_PGM_MTCH OFC" ).append("\n"); 
		query.append("        WHERE OFC.OFC_CD=@[ofc_cd]" ).append("\n"); 
		query.append("          AND AUTH.PGM_NO = OFC.PGM_NO ) C" ).append("\n"); 
		query.append("    WHERE A.MNU_CFG_CD = @[mnu_cfg_cd]" ).append("\n"); 
		query.append("      AND A.CHD_PGM_NO = B.PGM_NO" ).append("\n"); 
		query.append("      AND B.USE_FLG = 'Y'" ).append("\n"); 
		query.append("      AND B.POPUP_FLG = 'N'" ).append("\n"); 
		query.append("      AND B.PGM_MNU_DIV_CD = '02'" ).append("\n"); 
		query.append("      AND B.PGM_NO = C.PGM_NO(+) )" ).append("\n"); 
		query.append("SELECT A.LVL," ).append("\n"); 
		query.append("       A.CHD_PGM_NO," ).append("\n"); 
		query.append("       A.PGM_NM," ).append("\n"); 
		query.append("       A.DP_SEQ," ).append("\n"); 
		query.append("       NVL(B.CHILD_CNT, 0) AS CHILD_CNT," ).append("\n"); 
		query.append("       A.CHILD_MAX_LEN," ).append("\n"); 
		query.append("       A.PRNT_PGM_NO," ).append("\n"); 
		query.append("       A.PGM_URL," ).append("\n"); 
		query.append("       A.POPUP_FLG," ).append("\n"); 
		query.append("       A.AUTH_YN," ).append("\n"); 
		query.append("       A.RN" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    ( SELECT ROWNUM RN," ).append("\n"); 
		query.append("      S.*" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("	  SELECT LEVEL AS LVL," ).append("\n"); 
		query.append("      CHD_PGM_NO," ).append("\n"); 
		query.append("      PGM_NM," ).append("\n"); 
		query.append("      DP_SEQ," ).append("\n"); 
		query.append("      0 AS CHILD_MAX_LEN," ).append("\n"); 
		query.append("      PRNT_PGM_NO," ).append("\n"); 
		query.append("      PGM_URL," ).append("\n"); 
		query.append("      POPUP_FLG," ).append("\n"); 
		query.append("      AUTH_YN" ).append("\n"); 
		query.append("    FROM T1 START WITH PRNT_PGM_NO = @[prnt_pgm_no] CONNECT BY PRIOR CHD_PGM_NO = PRNT_PGM_NO" ).append("\n"); 
		query.append("      AND LEVEL <= @[level]" ).append("\n"); 
		query.append("    ORDER SIBLINGS BY DP_SEQ ) S" ).append("\n"); 
		query.append("	) A," ).append("\n"); 
		query.append("    ( SELECT PRNT_PGM_NO, COUNT(DISTINCT CHD_PGM_NO) AS CHILD_CNT" ).append("\n"); 
		query.append("        FROM T1" ).append("\n"); 
		query.append("      GROUP BY PRNT_PGM_NO      " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append(" WHERE A.CHD_PGM_NO = B.PRNT_PGM_NO(+)" ).append("\n"); 
		query.append(" order by A.RN" ).append("\n"); 

	}
}