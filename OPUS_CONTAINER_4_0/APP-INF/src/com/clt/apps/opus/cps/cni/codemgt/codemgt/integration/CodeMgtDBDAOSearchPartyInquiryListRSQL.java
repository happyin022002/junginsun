/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeMgtDBDAOSearchPartyInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.06.18 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 * 2010.06.18 윤진영 SRM-201006196 delf_flg null로 넘어 올때 delf_flg='N' 으로 처리.
 */

public class CodeMgtDBDAOSearchPartyInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Party 정보 inquriry
	  * </pre>
	  */
	public CodeMgtDBDAOSearchPartyInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchPartyInquiryListRSQL").append("\n"); 
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
		query.append("CLM_PTY_NO" ).append("\n"); 
		query.append(", CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", PTY_NM" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", INTL_PHN_NO" ).append("\n"); 
		query.append(", PHN_NO" ).append("\n"); 
		query.append(", INTL_FAX_NO" ).append("\n"); 
		query.append(", FAX_NO" ).append("\n"); 
		query.append(", PTY_EML" ).append("\n"); 
		query.append(", PTY_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_PARTY" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${clm_pty_abbr_nm} != '')" ).append("\n"); 
		query.append("AND CLM_PTY_ABBR_NM LIKE  @[clm_pty_abbr_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND LOC_CD LIKE   @[loc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pty_nm} != '')" ).append("\n"); 
		query.append("AND UPPER(PTY_NM) LIKE  UPPER(@[pty_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("AND DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CLM_PTY_ABBR_NM" ).append("\n"); 

	}
}