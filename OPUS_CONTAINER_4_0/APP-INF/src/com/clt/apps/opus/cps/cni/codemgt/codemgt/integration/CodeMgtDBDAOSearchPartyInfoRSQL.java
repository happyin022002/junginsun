/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOSearchPartyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.03 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchPartyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Party 정보 조회
	  * </pre>
	  */
	public CodeMgtDBDAOSearchPartyInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchPartyInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.CLM_PTY_NO" ).append("\n"); 
		query.append(", A.CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(", A.PRNT_CLM_PTY_NO" ).append("\n"); 
		query.append(", (SELECT CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("FROM CNI_PARTY" ).append("\n"); 
		query.append("WHERE CLM_PTY_NO = A.PRNT_CLM_PTY_NO" ).append("\n"); 
		query.append(") PRNT_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(", A.PTY_NM" ).append("\n"); 
		query.append(", A.INTL_PHN_NO" ).append("\n"); 
		query.append(", A.PHN_NO" ).append("\n"); 
		query.append(", A.INTL_FAX_NO" ).append("\n"); 
		query.append(", A.FAX_NO" ).append("\n"); 
		query.append(", A.PTY_EML" ).append("\n"); 
		query.append(", A.PTY_ADDR" ).append("\n"); 
		query.append(", A.PTY_RMK" ).append("\n"); 
		query.append(", A.LOC_CD" ).append("\n"); 
		query.append(", A.ZIP_CD_CTNT" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append(", A.CUST_SEQ" ).append("\n"); 
		query.append(", A.VNDR_SEQ" ).append("\n"); 
		query.append(", A.CLM_PTY_CLR_NO" ).append("\n"); 
		query.append(", (SELECT CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("FROM CNI_PARTY" ).append("\n"); 
		query.append("WHERE CLM_PTY_NO = A.CLM_PTY_CLR_NO" ).append("\n"); 
		query.append(") CLM_PTY_CLR_CD" ).append("\n"); 
		query.append(", A.DELT_FLG" ).append("\n"); 
		query.append(", A.CRE_OFC_CD" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR (A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(", B.CLM_AREA_CD" ).append("\n"); 
		query.append(", C.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_PARTY A" ).append("\n"); 
		query.append(", CNI_AREA_OFC B" ).append("\n"); 
		query.append(", MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CRE_OFC_CD   = B.OFC_CD(+)" ).append("\n"); 
		query.append("AND A.CNT_CD =  C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ =  C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CLM_PTY_NO = @[clm_pty_no]" ).append("\n"); 
		query.append("ORDER BY A.CLM_PTY_NO DESC" ).append("\n"); 

	}
}