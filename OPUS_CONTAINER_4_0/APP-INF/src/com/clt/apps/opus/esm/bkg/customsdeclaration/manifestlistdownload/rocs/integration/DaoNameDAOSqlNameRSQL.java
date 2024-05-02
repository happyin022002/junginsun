/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSqlNameRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' frm_Crn_Number" ).append("\n"); 
		query.append(",'' frt_Term_Cd" ).append("\n"); 
		query.append(",'' bl_No" ).append("\n"); 
		query.append(",'' cust_Eml" ).append("\n"); 
		query.append(",'' cnee_Addr1" ).append("\n"); 
		query.append(",'' n_Cust_Addr" ).append("\n"); 
		query.append(",'' cnee_Addr2" ).append("\n"); 
		query.append(",'' ofc_Cd" ).append("\n"); 
		query.append(",'' ntfy_Addr2" ).append("\n"); 
		query.append(",'' bl_No_Chk" ).append("\n"); 
		query.append(",'' bkg_No" ).append("\n"); 
		query.append(",'' t1_Doc_Cd" ).append("\n"); 
		query.append(",'' user_Id" ).append("\n"); 
		query.append(",'' shpr_Addr2" ).append("\n"); 
		query.append(",'' bl_No_Tp" ).append("\n"); 
		query.append(",'' fax_No" ).append("\n"); 
		query.append(",'' n_Cust_Nm" ).append("\n"); 
		query.append(",'' shpr_Addr1" ).append("\n"); 
		query.append(",'' ntfy_Addr1" ).append("\n"); 
		query.append(",'' shpr_cnt_cd" ).append("\n"); 
		query.append(",'' shpr_cust_seq" ).append("\n"); 
		query.append(",'' cnee_cnt_cd" ).append("\n"); 
		query.append(",'' cnee_cust_seq" ).append("\n"); 
		query.append(",'' ntfy_cnt_cd" ).append("\n"); 
		query.append(",'' ntfy_cust_seq" ).append("\n"); 
		query.append(",'' shpr_eori_no" ).append("\n"); 
		query.append(",'' shpr_cty_nm" ).append("\n"); 
		query.append(",'' shpr_cstms_decl_cnt_cd" ).append("\n"); 
		query.append(",'' shpr_zip_id" ).append("\n"); 
		query.append(",'' shpr_st_nm" ).append("\n"); 
		query.append(",'' cnee_eori_no" ).append("\n"); 
		query.append(",'' cnee_cty_nm" ).append("\n"); 
		query.append(",'' cnee_cstms_decl_cnt_cd" ).append("\n"); 
		query.append(",'' cnee_zip_id" ).append("\n"); 
		query.append(",'' cnee_st_nm" ).append("\n"); 
		query.append(",'' ntfy_eori_no" ).append("\n"); 
		query.append(",'' ntfy_cty_nm" ).append("\n"); 
		query.append(",'' ntfy_cstms_decl_cnt_cd" ).append("\n"); 
		query.append(",'' ntfy_zip_id" ).append("\n"); 
		query.append(",'' ntfy_st_nm" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}