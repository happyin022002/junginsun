/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountConsultationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.04.27 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnersAccountConsultationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner's Account 메인 전표 저장   
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountConsultationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evid_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oa_inter_mm_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oa_inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountConsultationCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_CONSULTATION (" ).append("\n"); 
		query.append("	SLP_TP_CD" ).append("\n"); 
		query.append(",	SLP_FUNC_CD" ).append("\n"); 
		query.append(",	SLP_OFC_CD" ).append("\n"); 
		query.append(",	SLP_ISS_DT" ).append("\n"); 
		query.append(",	SLP_SER_NO	-- 5" ).append("\n"); 
		query.append(",	CSR_CURR_CD" ).append("\n"); 
		query.append(",	CSR_AMT" ).append("\n"); 
		query.append(",	CSR_USR_ID" ).append("\n"); 
		query.append(",	CSR_DESC" ).append("\n"); 
		query.append(",   DIFF_AMT	-- 10" ).append("\n"); 
		query.append(",   RQST_AMT" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EVID_TP_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID	-- 15" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	OA_INTER_MM_DESC" ).append("\n"); 
		query.append(",	OA_INV_DT	-- 20" ).append("\n"); 
		query.append(",   OA_IF_FLG" ).append("\n"); 
		query.append(",   ASA_NO" ).append("\n"); 
		query.append(",	VAT_SLP_TP_CD" ).append("\n"); 
		query.append(",	VAT_SLP_FUNC_CD" ).append("\n"); 
		query.append(",   VAT_SLP_OFC_CD" ).append("\n"); 
		query.append(",	VAT_SLP_ISS_DT" ).append("\n"); 
		query.append(",   VAT_SLP_SER_NO " ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[slp_tp_cd]" ).append("\n"); 
		query.append(",	@[slp_func_cd]" ).append("\n"); 
		query.append(",	@[slp_ofc_cd]" ).append("\n"); 
		query.append(",	TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append(",	@[slp_ser_no]	-- 5" ).append("\n"); 
		query.append(",	@[csr_curr_cd]" ).append("\n"); 
		query.append(",	@[csr_amt]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	@[csr_desc]" ).append("\n"); 
		query.append(",	0	-- 10" ).append("\n"); 
		query.append(",	@[csr_amt]" ).append("\n"); 
		query.append(",	@[rqst_dt]" ).append("\n"); 
		query.append(",	@[eff_dt]" ).append("\n"); 
		query.append(",	@[evid_tp_cd]	--" ).append("\n"); 
		query.append(",	@[cre_usr_id]	-- 15" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[oa_inter_mm_desc]" ).append("\n"); 
		query.append(",	@[oa_inv_dt]	-- 20" ).append("\n"); 
		query.append(",   'Y'" ).append("\n"); 
		query.append(", 	@[asa_no]" ).append("\n"); 
		query.append(",	@[vat_slp_tp_cd]" ).append("\n"); 
		query.append(",	@[vat_slp_func_cd]" ).append("\n"); 
		query.append(",	@[vat_slp_ofc_cd]" ).append("\n"); 
		query.append(",	@[vat_slp_iss_dt]" ).append("\n"); 
		query.append(",	@[vat_slp_ser_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}