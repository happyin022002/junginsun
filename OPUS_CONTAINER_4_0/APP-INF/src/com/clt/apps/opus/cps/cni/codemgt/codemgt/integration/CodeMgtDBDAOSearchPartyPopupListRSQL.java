/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeMgtDBDAOSearchPartyPopupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.10 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchPartyPopupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Party 정보 inquriry
	  * 2010.12.10 이준범 [CHM-201007236-01]
	  *  1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
	  *  2.처리내역
	  *   2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
	  *       그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
	  *       information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완 
	  * </pre>
	  */
	public CodeMgtDBDAOSearchPartyPopupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchPartyPopupListRSQL").append("\n"); 
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
		query.append("SELECT CLM_PTY_NO" ).append("\n"); 
		query.append("      ,CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,PTY_NM" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,INTL_PHN_NO" ).append("\n"); 
		query.append("      ,PHN_NO" ).append("\n"); 
		query.append("      ,INTL_FAX_NO" ).append("\n"); 
		query.append("      ,FAX_NO" ).append("\n"); 
		query.append("      ,PTY_EML" ).append("\n"); 
		query.append("      ,PTY_RMK" ).append("\n"); 
		query.append("  FROM CNI_PARTY" ).append("\n"); 
		query.append(" WHERE CLM_PTY_ABBR_NM LIKE UPPER(@[pty_nm])||'%'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CLM_PTY_NO" ).append("\n"); 
		query.append("      ,CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,PTY_NM" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,INTL_PHN_NO" ).append("\n"); 
		query.append("      ,PHN_NO" ).append("\n"); 
		query.append("      ,INTL_FAX_NO" ).append("\n"); 
		query.append("      ,FAX_NO" ).append("\n"); 
		query.append("      ,PTY_EML" ).append("\n"); 
		query.append("      ,PTY_RMK" ).append("\n"); 
		query.append("  FROM CNI_PARTY" ).append("\n"); 
		query.append(" WHERE CLM_PTY_ABBR_NM LIKE UPPER(SUBSTR(@[pty_nm],1,7))||'%'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CLM_PTY_NO" ).append("\n"); 
		query.append("      ,CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,PTY_NM" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,INTL_PHN_NO" ).append("\n"); 
		query.append("      ,PHN_NO" ).append("\n"); 
		query.append("      ,INTL_FAX_NO" ).append("\n"); 
		query.append("      ,FAX_NO" ).append("\n"); 
		query.append("      ,PTY_EML" ).append("\n"); 
		query.append("      ,PTY_RMK" ).append("\n"); 
		query.append("  FROM CNI_PARTY" ).append("\n"); 
		query.append(" WHERE CLM_PTY_ABBR_NM LIKE UPPER(SUBSTR(@[pty_nm],1,6))||'%' " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CLM_PTY_NO" ).append("\n"); 
		query.append("      ,CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,PTY_NM" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,INTL_PHN_NO" ).append("\n"); 
		query.append("      ,PHN_NO" ).append("\n"); 
		query.append("      ,INTL_FAX_NO" ).append("\n"); 
		query.append("      ,FAX_NO" ).append("\n"); 
		query.append("      ,PTY_EML" ).append("\n"); 
		query.append("      ,PTY_RMK" ).append("\n"); 
		query.append("  FROM CNI_PARTY" ).append("\n"); 
		query.append(" WHERE CLM_PTY_ABBR_NM LIKE UPPER(SUBSTR(@[pty_nm],1,5))||'%'" ).append("\n"); 

	}
}