/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountCsulSlpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnersAccountCsulSlpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountCsulSlpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pair_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pair_slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oa_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lsg_gr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountCsulSlpCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_CSUL_SLP (" ).append("\n"); 
		query.append("	SLP_TP_CD" ).append("\n"); 
		query.append(",	SLP_FUNC_CD" ).append("\n"); 
		query.append(",	SLP_OFC_CD" ).append("\n"); 
		query.append(",	SLP_ISS_DT" ).append("\n"); 
		query.append(",	SLP_SER_NO	-- 5" ).append("\n"); 
		query.append(",	SLP_SEQ_NO" ).append("\n"); 
		query.append(",	ACCT_CD" ).append("\n"); 
		query.append(",	CTR_CD" ).append("\n"); 
		query.append(",	SLP_LOC_CD" ).append("\n"); 
		query.append(",	CSR_CURR_CD	-- 10" ).append("\n"); 
		query.append(",	CSR_AMT" ).append("\n"); 
		query.append(",	CSR_DESC" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	TRNS_CURR_CD" ).append("\n"); 
		query.append(",	TRNS_AMT	-- 15" ).append("\n"); 
		query.append(",	STL_FLG" ).append("\n"); 
		query.append(",	INV_SEQ" ).append("\n"); 
		query.append(",   FLET_SRC_TP_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO	-- 20" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	ORG_SLP_TP_CD" ).append("\n"); 
		query.append(",	ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	ORG_SLP_OFC_CD	-- 25" ).append("\n"); 
		query.append(",	ORG_ISS_DT" ).append("\n"); 
		query.append(",	ORG_SLP_SER_NO" ).append("\n"); 
		query.append(",	ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	LSG_GR_NO" ).append("\n"); 
		query.append(",	TO_INV_NO	-- 30" ).append("\n"); 
		query.append(",	VVD_EFF_DT" ).append("\n"); 
		query.append(",	VVD_EXP_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID	-- 35" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	ACCT_ITM_SEQ" ).append("\n"); 
		query.append(",	OA_LOC_CD" ).append("\n"); 
		query.append(",	OA_INV_DT" ).append("\n"); 
		query.append(",	ATCH_FILE_OA_LNK_ID	-- 40" ).append("\n"); 
		query.append(",	PAIR_SLP_TP_CD" ).append("\n"); 
		query.append(",	PAIR_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	PAIR_SLP_OFC_CD" ).append("\n"); 
		query.append(",	PAIR_SLP_ISS_DT" ).append("\n"); 
		query.append(",	PAIR_SLP_SER_NO	-- 45" ).append("\n"); 
		query.append(",	PAIR_SLP_SEQ_NO" ).append("\n"); 
		query.append(") SELECT  " ).append("\n"); 
		query.append("	@[slp_tp_cd]" ).append("\n"); 
		query.append(",	@[slp_func_cd]" ).append("\n"); 
		query.append(",	@[slp_ofc_cd]" ).append("\n"); 
		query.append(",   TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append(",	@[slp_ser_no]	-- 5" ).append("\n"); 
		query.append(",	NVL(@[slp_seq_no],    (SELECT LPAD(NVL(TO_NUMBER(MAX(SLP_SEQ_NO)),0)+1,4,'0') " ).append("\n"); 
		query.append("						   FROM 	FMS_CSUL_SLP" ).append("\n"); 
		query.append("						   WHERE	SLP_TP_CD	= @[slp_tp_cd]" ).append("\n"); 
		query.append("					       AND	SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("						   AND	SLP_OFC_CD  = @[slp_ofc_cd]" ).append("\n"); 
		query.append("					       AND	SLP_ISS_DT  = TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("						   AND	SLP_SER_NO  = @[slp_ser_no]" ).append("\n"); 
		query.append("						   AND  SLP_SEQ_NO < 1000" ).append("\n"); 
		query.append("						  )" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(",	@[acct_cd]" ).append("\n"); 
		query.append(",	(SELECT M.AP_CTR_CD" ).append("\n"); 
		query.append("	   FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("	  WHERE M.OFC_CD = @[slp_ofc_cd])" ).append("\n"); 
		query.append(",	(SELECT N.LOC_CD" ).append("\n"); 
		query.append("   	   FROM MDM_ORGANIZATION N" ).append("\n"); 
		query.append("  	  WHERE N.OFC_CD = @[slp_ofc_cd])" ).append("\n"); 
		query.append(",	@[csr_curr_cd]	-- 10" ).append("\n"); 
		query.append(",	@[csr_amt]" ).append("\n"); 
		query.append(",	@[csr_desc]" ).append("\n"); 
		query.append(",	@[vndr_seq]" ).append("\n"); 
		query.append(",	'USD'" ).append("\n"); 
		query.append(",	@[trns_amt]	-- 15" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[inv_seq]" ).append("\n"); 
		query.append(",   '04'" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],5,4)	-- 20" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],10,1)" ).append("\n"); 
		query.append(",	@[org_slp_tp_cd]" ).append("\n"); 
		query.append(",	@[org_slp_func_cd]" ).append("\n"); 
		query.append(",	@[org_slp_ofc_cd]	-- 25" ).append("\n"); 
		query.append(",	@[org_iss_dt]" ).append("\n"); 
		query.append(",	@[org_slp_ser_no]" ).append("\n"); 
		query.append(",	@[org_slp_seq_no]" ).append("\n"); 
		query.append(",	@[lsg_gr_no]" ).append("\n"); 
		query.append(",	@[to_inv_no]	-- 30" ).append("\n"); 
		query.append(",	TO_DATE(REPLACE(@[vvd_eff_dt],'-',''),'yyyymmdd')" ).append("\n"); 
		query.append(",	TO_DATE(REPLACE(@[vvd_exp_dt],'-',''),'yyyymmdd')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]	-- 35" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[acct_itm_seq]" ).append("\n"); 
		query.append(",	@[oa_loc_cd]" ).append("\n"); 
		query.append(",	@[oa_inv_dt]	-- 39" ).append("\n"); 
		query.append(",	@[slp_tp_cd] || @[slp_func_cd] || @[slp_ofc_cd] || TO_CHAR(SYSDATE, 'YYMMDD') || @[slp_ser_no] ||@[slp_seq_no]" ).append("\n"); 
		query.append(",	@[pair_slp_tp_cd]" ).append("\n"); 
		query.append(",	@[pair_slp_func_cd]" ).append("\n"); 
		query.append(",	@[pair_slp_ofc_cd]" ).append("\n"); 
		query.append(",	@[pair_slp_iss_dt]" ).append("\n"); 
		query.append(",	@[pair_slp_ser_no]	-- 45" ).append("\n"); 
		query.append(",	@[pair_slp_seq_no]" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}