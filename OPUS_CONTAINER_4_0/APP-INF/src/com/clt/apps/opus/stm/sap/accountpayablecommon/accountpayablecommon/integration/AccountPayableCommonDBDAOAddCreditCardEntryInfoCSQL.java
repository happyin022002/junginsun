/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOAddCreditCardEntryInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOAddCreditCardEntryInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0310 - Save button / Insert New Card no Infro
	  * </pre>
	  */
	public AccountPayableCommonDBDAOAddCreditCardEntryInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_dtrb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_mbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_tp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_brnd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_pgm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_pgm_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_inact_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_pgm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_dept_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_dtrb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOAddCreditCardEntryInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_CRD_MST (" ).append("\n"); 
		query.append("       CRD_SEQ" ).append("\n"); 
		query.append("       , CRD_NO" ).append("\n"); 
		query.append("       , CRD_PGM_NM" ).append("\n"); 
		query.append("       , CRD_PGM_CD" ).append("\n"); 
		query.append("       , CRD_TP_LU_CD" ).append("\n"); 
		query.append("       , CRD_PGM_CURR_CD" ).append("\n"); 
		query.append("       , CRD_VNDR_NO" ).append("\n"); 
		query.append("       , CRD_BRND_LU_CD" ).append("\n"); 
		query.append("       , CRD_CD_CMB_SEQ" ).append("\n"); 
		query.append("       , COA_CO_CD" ).append("\n"); 
		query.append("       , COA_RGN_CD" ).append("\n"); 
		query.append("       , COA_CTR_CD" ).append("\n"); 
		query.append("       , COA_ACCT_CD" ).append("\n"); 
		query.append("       , COA_INTER_CO_CD" ).append("\n"); 
		query.append("       , COA_VVD_CD" ).append("\n"); 
		query.append("       , CRD_MBR_NM" ).append("\n"); 
		query.append("       , CRD_DEPT_NM" ).append("\n"); 
		query.append("       , CRD_DTRB_OFC_CD" ).append("\n"); 
		query.append("       , CRD_DTRB_DT" ).append("\n"); 
		query.append("       , CRD_INACT_DT" ).append("\n"); 
		query.append("       , CRD_EXP_DT" ).append("\n"); 
		query.append("       , CRD_DESC" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("       @[crd_seq]" ).append("\n"); 
		query.append("       , REPLACE(@[crd_no], '-', '')" ).append("\n"); 
		query.append("       , @[crd_pgm_nm]" ).append("\n"); 
		query.append("       , @[crd_pgm_cd]" ).append("\n"); 
		query.append("       , @[crd_tp_lu_cd]" ).append("\n"); 
		query.append("       , @[crd_pgm_curr_cd]" ).append("\n"); 
		query.append("       , @[vndr_no]" ).append("\n"); 
		query.append("       , @[crd_brnd_lu_cd]" ).append("\n"); 
		query.append("       , @[crd_cd_cmb_seq]" ).append("\n"); 
		query.append("       , @[coa_co_cd]" ).append("\n"); 
		query.append("       , @[coa_rgn_cd]" ).append("\n"); 
		query.append("       , @[coa_ctr_cd]" ).append("\n"); 
		query.append("       , @[coa_acct_cd]" ).append("\n"); 
		query.append("       , @[coa_inter_co_cd]" ).append("\n"); 
		query.append("       , @[coa_vvd_cd]" ).append("\n"); 
		query.append("       , @[crd_mbr_nm]" ).append("\n"); 
		query.append("       , @[crd_dept_nm]" ).append("\n"); 
		query.append("       , @[crd_dtrb_ofc_cd]" ).append("\n"); 
		query.append("       , TO_DATE(@[crd_dtrb_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("       , TO_DATE(@[crd_inact_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("       , TO_DATE(@[crd_exp_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("       , @[crd_desc]" ).append("\n"); 
		query.append("       , @[usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}