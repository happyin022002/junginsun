/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ClaimMainDBDAOAddClaimLitigationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOAddClaimLitigationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim Litigation 등록
	  * </pre>
	  */
	public ClaimMainDBDAOAddClaimLitigationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smns_sve_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jmt_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_atty_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CLOB + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltgt_cs_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpln_file_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jmt_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_atty_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_deft_atty_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crt_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOAddClaimLitigationCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM_LTGT (" ).append("\n"); 
		query.append("   CGO_CLM_NO" ).append("\n"); 
		query.append(",  PLT_NM " ).append("\n"); 
		query.append(",  DEFT_NM " ).append("\n"); 
		query.append(",  DEFT_ATTY_CLM_PTY_NO " ).append("\n"); 
		query.append(",  DEFT_ATTY_APNT_DT" ).append("\n"); 
		query.append(",  REF_DEFT_ATTY_NO " ).append("\n"); 
		query.append(",  CRT_NM " ).append("\n"); 
		query.append(",  CRT_LOC_CD " ).append("\n"); 
		query.append(",  CRT_CS_NO " ).append("\n"); 
		query.append(",  CPLN_FILE_DT " ).append("\n"); 
		query.append(",  JMT_RSLT_CD " ).append("\n"); 
		query.append(",  JMT_RSLT_DT" ).append("\n"); 
		query.append(",  SMNS_SVE_DT " ).append("\n"); 
		query.append(",  LTGT_CS_DESC " ).append("\n"); 
		query.append(",  CRE_USR_ID " ).append("\n"); 
		query.append(",  CRE_DT  " ).append("\n"); 
		query.append(",  UPD_USR_ID " ).append("\n"); 
		query.append(",  UPD_DT  " ).append("\n"); 
		query.append(") VALUES(       " ).append("\n"); 
		query.append("   @[cgo_clm_no]" ).append("\n"); 
		query.append(",  @[plt_nm] " ).append("\n"); 
		query.append(",  @[deft_nm] " ).append("\n"); 
		query.append(",  @[deft_atty_clm_pty_no] " ).append("\n"); 
		query.append(",  @[deft_atty_apnt_dt]" ).append("\n"); 
		query.append(",  @[ref_deft_atty_no]" ).append("\n"); 
		query.append(",  @[crt_nm] " ).append("\n"); 
		query.append(",  @[crt_loc_cd] " ).append("\n"); 
		query.append(",  @[crt_cs_no] " ).append("\n"); 
		query.append(",  @[cpln_file_dt] " ).append("\n"); 
		query.append(",  @[jmt_rslt_cd] " ).append("\n"); 
		query.append(",  @[jmt_rslt_dt]" ).append("\n"); 
		query.append(",  @[smns_sve_dt] " ).append("\n"); 
		query.append(",  @[ltgt_cs_desc] " ).append("\n"); 
		query.append(",  @[cre_usr_id] " ).append("\n"); 
		query.append(",  CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",  @[upd_usr_id] " ).append("\n"); 
		query.append(",  CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}