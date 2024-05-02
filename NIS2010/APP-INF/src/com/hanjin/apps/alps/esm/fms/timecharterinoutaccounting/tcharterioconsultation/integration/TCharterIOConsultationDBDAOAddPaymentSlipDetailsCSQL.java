/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOAddPaymentSlipDetailsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOAddPaymentSlipDetailsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOConsultationDBDAOAddPaymentSlipDetailsCSQL
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOAddPaymentSlipDetailsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_src_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bunker_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOAddPaymentSlipDetailsCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_CSUL_SLP(" ).append("\n"); 
		query.append("	SLP_TP_CD," ).append("\n"); 
		query.append("	SLP_FUNC_CD," ).append("\n"); 
		query.append("	SLP_OFC_CD," ).append("\n"); 
		query.append("	SLP_ISS_DT," ).append("\n"); 
		query.append("	SLP_SER_NO," ).append("\n"); 
		query.append("	SLP_SEQ_NO," ).append("\n"); 
		query.append("	ACCT_CD," ).append("\n"); 
		query.append("	CTR_CD," ).append("\n"); 
		query.append("	SLP_LOC_CD," ).append("\n"); 
		query.append("	CSR_CURR_CD," ).append("\n"); 
		query.append("	CSR_AMT," ).append("\n"); 
		query.append("	CSR_DESC," ).append("\n"); 
		query.append("	VNDR_SEQ," ).append("\n"); 
		query.append("	TRNS_CURR_CD," ).append("\n"); 
		query.append("	TRNS_AMT," ).append("\n"); 
		query.append("	INV_SEQ," ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	SKD_VOY_NO," ).append("\n"); 
		query.append("	SKD_DIR_CD," ).append("\n"); 
		query.append("	REV_DIR_CD," ).append("\n"); 
		query.append("	VVD_EFF_DT," ).append("\n"); 
		query.append("	VVD_EXP_DT," ).append("\n"); 
		query.append("    FLET_SRC_TP_CD," ).append("\n"); 
		query.append("	LSG_GR_NO," ).append("\n"); 
		query.append("	ORG_SLP_TP_CD," ).append("\n"); 
		query.append("	ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("	ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("	ORG_ISS_DT," ).append("\n"); 
		query.append("	ORG_SLP_SER_NO," ).append("\n"); 
		query.append("	ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("    SLP_KEY_NO," ).append("\n"); 
		query.append("    AP_SLP_TP_CD," ).append("\n"); 
		query.append("	AP_SLP_FUNC_CD," ).append("\n"); 
		query.append("	AP_SLP_OFC_CD," ).append("\n"); 
		query.append("	AP_SLP_ISS_DT," ).append("\n"); 
		query.append("	AP_SLP_SER_NO," ).append("\n"); 
		query.append("	AP_SLP_SEQ_NO," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	'07'," ).append("\n"); 
		query.append("	@[slp_func_cd]," ).append("\n"); 
		query.append("	@[slp_ofc_cd]," ).append("\n"); 
		query.append("	TO_CHAR(SYSDATE,'YYMMDD')," ).append("\n"); 
		query.append("	@[slp_ser_no],	" ).append("\n"); 
		query.append("	LPAD(@[seq_no],4,'0')," ).append("\n"); 
		query.append("	@[acct_cd]," ).append("\n"); 
		query.append("	@[ctr_cd]," ).append("\n"); 
		query.append("	@[slp_loc_cd]," ).append("\n"); 
		query.append("	@[curr_cd]," ).append("\n"); 
		query.append("	@[csr_amt],	" ).append("\n"); 
		query.append("	@[csr_desc]," ).append("\n"); 
		query.append("	@[vndr_seq]," ).append("\n"); 
		query.append("	'USD'," ).append("\n"); 
		query.append("	(SELECT ROUND(@[csr_amt] / GM.USD_LOCL_XCH_RT)                " ).append("\n"); 
		query.append("	   FROM GL_MON_XCH_RT GM                 " ).append("\n"); 
		query.append("	  WHERE GM.ACCT_XCH_RT_YRMON = SUBSTR(@[slp_eff_dt],1,6)              " ).append("\n"); 
		query.append("		AND GM.ACCT_XCH_RT_LVL = '1'                " ).append("\n"); 
		query.append("		AND GM.CURR_CD = @[curr_cd])," ).append("\n"); 
		query.append("	@[inv_seq]," ).append("\n"); 
		query.append("	DECODE(@[bunker_vvd],NULL,NULL,SUBSTR(@[bunker_vvd],1,4))," ).append("\n"); 
		query.append("	DECODE(@[bunker_vvd],NULL,NULL,SUBSTR(@[bunker_vvd],5,4))," ).append("\n"); 
		query.append("	DECODE(@[bunker_vvd],NULL,NULL,SUBSTR(@[bunker_vvd],9,1))," ).append("\n"); 
		query.append("	DECODE(@[bunker_vvd],NULL,NULL,SUBSTR(@[bunker_vvd],10,1))," ).append("\n"); 
		query.append("	DECODE(@[eff_dt],NULL,NULL,TO_DATE(@[eff_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("	DECODE(@[exp_dt],NULL,NULL,TO_DATE(@[exp_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("    @[flet_src_tp_cd]," ).append("\n"); 
		query.append("	DECODE(@[acct_cd],'511351',(SELECT 'MVM-'||@[vsl_cd]||'-L-'||SUBSTR(@[slp_eff_dt],1,6)||'-'||" ).append("\n"); 
		query.append("		                               LPAD(NVL(TO_NUMBER(MAX(SUBSTR(LSG_GR_NO,19))),0) + 1,4,'0')" ).append("\n"); 
		query.append("                                  FROM FMS_CSUL_SLP" ).append("\n"); 
		query.append("                                 WHERE LSG_GR_NO LIKE 'MVM-'||@[vsl_cd]||'-L-'||SUBSTR(@[slp_eff_dt],1,6)||'%'),NULL)," ).append("\n"); 
		query.append("	DECODE(@[acct_cd],'111431','07',NULL)," ).append("\n"); 
		query.append("	DECODE(@[acct_cd],'111431',@[slp_func_cd],NULL)," ).append("\n"); 
		query.append("	DECODE(@[acct_cd],'111431',@[slp_ofc_cd],NULL)," ).append("\n"); 
		query.append("    DECODE(@[acct_cd],'111431',TO_CHAR(SYSDATE,'YYMMDD'),NULL)," ).append("\n"); 
		query.append("	DECODE(@[acct_cd],'111431',@[slp_ser_no],NULL),	" ).append("\n"); 
		query.append("	DECODE(@[acct_cd],'111431',LPAD(@[seq_no],4,'0'),NULL)," ).append("\n"); 
		query.append("    CASE WHEN @[acct_cd] != '511351' AND @[acct_cd] != '111431' THEN" ).append("\n"); 
		query.append("              DECODE(@[key_number],NULL,NULL,@[key_number])" ).append("\n"); 
		query.append("     END," ).append("\n"); 
		query.append("    DECODE(@[flet_src_tp_cd],'04',@[ap_slp_tp_cd],NULL)," ).append("\n"); 
		query.append("    DECODE(@[flet_src_tp_cd],'04',@[ap_slp_func_cd],NULL)," ).append("\n"); 
		query.append("    DECODE(@[flet_src_tp_cd],'04',@[ap_slp_ofc_cd],NULL)," ).append("\n"); 
		query.append("    DECODE(@[flet_src_tp_cd],'04',@[ap_slp_iss_dt],NULL)," ).append("\n"); 
		query.append("    DECODE(@[flet_src_tp_cd],'04',@[ap_slp_ser_no],NULL)," ).append("\n"); 
		query.append("    DECODE(@[flet_src_tp_cd],'04',@[ap_slp_seq_no],NULL)," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}