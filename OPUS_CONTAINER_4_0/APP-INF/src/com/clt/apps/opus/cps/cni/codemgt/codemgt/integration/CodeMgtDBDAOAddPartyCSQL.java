/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOAddPartyCSQL.java
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

public class CodeMgtDBDAOAddPartyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNI Party Insert
	  * </pre>
	  */
	public CodeMgtDBDAOAddPartyCSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pty_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_clr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pty_addr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOAddPartyCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_PARTY (" ).append("\n"); 
		query.append("CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	PHN_NO" ).append("\n"); 
		query.append(",	INTL_FAX_NO" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	PTY_EML" ).append("\n"); 
		query.append(",	PTY_ADDR" ).append("\n"); 
		query.append(",	PTY_RMK" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	ZIP_CD_CTNT" ).append("\n"); 
		query.append(",	CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	CLM_PTY_CLR_NO" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",	PRNT_CLM_PTY_NO" ).append("\n"); 
		query.append(",	PTY_NM" ).append("\n"); 
		query.append(",	INTL_PHN_NO" ).append("\n"); 
		query.append(",	CLM_PTY_NO" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[phn_no]" ).append("\n"); 
		query.append(",	@[intl_fax_no]" ).append("\n"); 
		query.append(",	@[fax_no]" ).append("\n"); 
		query.append(",	@[pty_eml]" ).append("\n"); 
		query.append(",	@[pty_addr]" ).append("\n"); 
		query.append(",	@[pty_rmk]" ).append("\n"); 
		query.append(",	@[loc_cd]" ).append("\n"); 
		query.append(",	@[zip_cd_ctnt]" ).append("\n"); 
		query.append(",	@[cnt_cd]" ).append("\n"); 
		query.append(",	@[cust_seq]" ).append("\n"); 
		query.append(",	@[vndr_seq]" ).append("\n"); 
		query.append(",	@[clm_pty_clr_no]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[clm_pty_abbr_nm]" ).append("\n"); 
		query.append(",	@[prnt_clm_pty_no]" ).append("\n"); 
		query.append(",	@[pty_nm]" ).append("\n"); 
		query.append(",	@[intl_phn_no]" ).append("\n"); 
		query.append(",	@[clm_pty_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}