/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchOfcLvlPlsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.08.07 최종혁
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

public class EacMgtDBDAOSearchOfcLvlPlsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인한 off_cd 로 offce 의 레벨을 조회한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchOfcLvlPlsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchOfcLvlPlsRSQL").append("\n"); 
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
		query.append("SELECT OFC_TP_CD" ).append("\n"); 
		query.append("     , CASE WHEN OFC_TP_CD = 'H' AND BKG_GET_TOKEN_FNC(EAC_STS,1) IN ('IS', 'AC', 'RC', 'HC') THEN 'W'" ).append("\n"); 
		query.append("            WHEN OFC_TP_CD = 'R' AND BKG_GET_TOKEN_FNC(EAC_STS,2) = '1' AND BKG_GET_TOKEN_FNC(EAC_STS,1) IN ('IS', 'AC') THEN 'W' " ).append("\n"); 
		query.append("            WHEN OFC_TP_CD = 'R' AND BKG_GET_TOKEN_FNC(EAC_STS,2) = '2' AND BKG_GET_TOKEN_FNC(EAC_STS,1) IN ('IS') THEN 'W'" ).append("\n"); 
		query.append("            WHEN OFC_TP_CD = 'O' AND BKG_GET_TOKEN_FNC(EAC_STS,1) = 'IS' THEN 'W'" ).append("\n"); 
		query.append("            ELSE CASE WHEN @[eac_no] IS NULL THEN 'W' ELSE 'R' END " ).append("\n"); 
		query.append("       END RW_AUTH_CD" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(EML_INFO,1) AS EML_SUBJ_CTNT" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(EML_INFO,2) AS EML_CTNT" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(EML_INFO,3) AS KPI_OFC_CD" ).append("\n"); 
		query.append("     , USR_OFC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT CASE WHEN @[ofc_cd] = 'SELADG' THEN 'H'" ).append("\n"); 
		query.append("                    WHEN @[ofc_cd] = TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(@[ofc_cd]) THEN 'R'" ).append("\n"); 
		query.append("                    ELSE 'O'" ).append("\n"); 
		query.append("               END OFC_TP_CD" ).append("\n"); 
		query.append("             , (SELECT EAC_STS_CD || ',' || EAC_APRO_TP_CD " ).append("\n"); 
		query.append("                 FROM EAS_EXPN_AUD_CS_MGMT X" ).append("\n"); 
		query.append("                WHERE EAC_NO = @[eac_no]" ).append("\n"); 
		query.append("               ) EAC_STS" ).append("\n"); 
		query.append("             , (SELECT X.EML_SUBJ_CTNT || ',' || X.EML_CTNT || ',' || X.KPI_OFC_CD" ).append("\n"); 
		query.append("                  FROM EAS_EXPN_AUD_CS_PSON_CFG X" ).append("\n"); 
		query.append("                 WHERE X.EAC_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("               ) AS EML_INFO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , (SELECT X.OFC_CD FROM COM_USER X WHERE X.USR_ID = @[usr_id]) AS USR_OFC_CD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}