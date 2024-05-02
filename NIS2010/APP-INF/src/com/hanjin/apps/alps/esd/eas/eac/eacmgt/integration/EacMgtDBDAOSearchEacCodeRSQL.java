/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchEacCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.01.07 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchEacCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Expense Audit Case에서 사용하는 코드 조회
	  * </pre>
	  */
	public EacMgtDBDAOSearchEacCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchEacCodeRSQL").append("\n"); 
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
		query.append("SELECT TP_CD" ).append("\n"); 
		query.append("      ,TP_NM" ).append("\n"); 
		query.append("      ,BIL_TP_CD" ).append("\n"); 
		query.append("      ,BIL_TP_NM" ).append("\n"); 
		query.append("      ,BIL_TP_DESC" ).append("\n"); 
		query.append("      ,IF_TP_NM" ).append("\n"); 
		query.append("      ,EXPN_TP_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    /* MISS BILLING */" ).append("\n"); 
		query.append("    SELECT 'M' AS TP_CD" ).append("\n"); 
		query.append("          ,(SELECT X.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD00587' AND INTG_CD_VAL_CTNT = 'M') AS TP_NM" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_CTNT AS BIL_TP_CD" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_DP_DESC AS BIL_TP_NM" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_DESC AS BIL_TP_DESC" ).append("\n"); 
		query.append("          ,'' AS IF_TP_NM" ).append("\n"); 
		query.append("          ,'' AS EXPN_TP_NM" ).append("\n"); 
		query.append("          ,1 AS ORD" ).append("\n"); 
		query.append("          ,TO_CHAR(INTG_CD_VAL_DP_SEQ) AS ORD2" ).append("\n"); 
		query.append("          ,'0' AS ORD3" ).append("\n"); 
		query.append("      FROM COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("     WHERE INTG_CD_ID = 'CD03339'" ).append("\n"); 
		query.append("    /* TPB MISSING */" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'T' AS TP_CD" ).append("\n"); 
		query.append("          ,(SELECT X.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD00587' AND INTG_CD_VAL_CTNT = 'T') AS TP_NM" ).append("\n"); 
		query.append("          ,N3PTY_BIL_TP_CD AS BIL_TP_CD" ).append("\n"); 
		query.append("          ,N3PTY_BIL_TP_NM AS BIL_TP_NM" ).append("\n"); 
		query.append("          ,N3PTY_BIL_TP_DESC AS BIL_TP_DESC" ).append("\n"); 
		query.append("          ,(SELECT X.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD00581' AND INTG_CD_VAL_CTNT = A.N3PTY_IF_TP_CD) AS IF_TP_NM" ).append("\n"); 
		query.append("          --,N3PTY_EXPN_TP_CD AS EXPN_TP_NM" ).append("\n"); 
		query.append("          ,(SELECT X.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03352' AND INTG_CD_VAL_CTNT = A.N3PTY_EXPN_TP_CD) AS EXPN_TP_NM          " ).append("\n"); 
		query.append("          ,2 AS ORD" ).append("\n"); 
		query.append("          ,N3PTY_EXPN_TP_CD AS ORD2" ).append("\n"); 
		query.append("          ,N3PTY_BIL_TP_CD  AS ORD3" ).append("\n"); 
		query.append("      FROM TPB_N3RD_PTY_BIL_TP A" ).append("\n"); 
		query.append("     WHERE ACT_FLG = 'Y'" ).append("\n"); 
		query.append("       AND N3PTY_IF_TP_CD   = 'S'" ).append("\n"); 
		query.append("       AND N3PTY_BIL_TP_CD != 'JO'" ).append("\n"); 
		query.append("       #if (${s_eac_expn_tp_cd} != '') " ).append("\n"); 
		query.append("         AND N3PTY_EXPN_TP_CD = @[s_eac_expn_tp_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    /* INTERNAL ERROR */" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'I' AS TP_CD" ).append("\n"); 
		query.append("          ,(SELECT X.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD00587' AND INTG_CD_VAL_CTNT = 'I') AS TP_NM" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_CTNT AS BIL_TP_CD" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_DP_DESC AS BIL_TP_NM" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_DESC AS BIL_TP_DESC" ).append("\n"); 
		query.append("          ,'' AS IF_TP_NM" ).append("\n"); 
		query.append("          ,'' AS EXPN_TP_NM" ).append("\n"); 
		query.append("          ,3 AS ORD" ).append("\n"); 
		query.append("          ,TO_CHAR(INTG_CD_VAL_DP_SEQ) AS ORD2" ).append("\n"); 
		query.append("          ,'0' AS ORD3" ).append("\n"); 
		query.append("      FROM COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("     WHERE INTG_CD_ID = 'CD03340'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    #if (${s_eac_tp_cd} != '') " ).append("\n"); 
		query.append("      AND TP_CD = @[s_eac_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("ORDER BY ORD, ORD2, ORD3" ).append("\n"); 

	}
}