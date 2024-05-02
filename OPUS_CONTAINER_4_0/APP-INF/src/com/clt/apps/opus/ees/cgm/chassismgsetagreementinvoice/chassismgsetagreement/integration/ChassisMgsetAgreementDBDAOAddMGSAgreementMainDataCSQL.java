/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOAddMGSAgreementMainDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOAddMGSAgreementMainDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.AddMGSAgreementMainData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOAddMGSAgreementMainDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_hndl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_ver_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_hndl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon_dpc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_dpc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_dpc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOAddMGSAgreementMainDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_AGREEMENT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("    AGMT_SEQ, " ).append("\n"); 
		query.append("    AGMT_VER_NO, " ).append("\n"); 
		query.append("    EQ_KND_CD, " ).append("\n"); 
		query.append("    LST_VER_FLG, " ).append("\n"); 
		query.append("    AGMT_ISS_OFC_CD, " ).append("\n"); 
		query.append("    AGMT_REF_NO, " ).append("\n"); 
		query.append("    CURR_CD, " ).append("\n"); 
		query.append("    EFF_DT, " ).append("\n"); 
		query.append("    EXP_DT, " ).append("\n"); 
		query.append("    VNDR_SEQ, " ).append("\n"); 
		query.append("    PAY_TERM_DYS," ).append("\n"); 
		query.append("    AGMT_LSTM_CD," ).append("\n"); 
		query.append("    ONH_HNDL_RT_AMT," ).append("\n"); 
		query.append("    OFFH_HNDL_RT_AMT," ).append("\n"); 
		query.append("    MON_DPC_RT_AMT," ).append("\n"); 
		query.append("    MAX_DPC_RT_AMT," ).append("\n"); 
		query.append("    INIT_DPC_RT_AMT," ).append("\n"); 
		query.append("    DIFF_RMK," ).append("\n"); 
		query.append("	AGMT_DT," ).append("\n"); 
		query.append("	AGMT_EFF_DT," ).append("\n"); 
		query.append("	AGMT_EXP_DT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("    AGMT_CTRT_NO," ).append("\n"); 
		query.append("	OLD_AGMT_NO" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("    @[agmt_seq]," ).append("\n"); 
		query.append("    @[agmt_ver_no]," ).append("\n"); 
		query.append("    @[eq_knd_cd]," ).append("\n"); 
		query.append("    @[lst_ver_flg]," ).append("\n"); 
		query.append("    @[agmt_iss_ofc_cd]," ).append("\n"); 
		query.append("    @[agmt_ref_no]," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("    TO_DATE(@[eff_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("    TO_DATE(@[exp_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("    @[vndr_seq]," ).append("\n"); 
		query.append("    @[pay_term_dys]," ).append("\n"); 
		query.append("    @[agmt_lstm_cd]," ).append("\n"); 
		query.append("    @[onh_hndl_rt_amt]," ).append("\n"); 
		query.append("    @[offh_hndl_rt_amt]," ).append("\n"); 
		query.append("    @[mon_dpc_rt_amt]," ).append("\n"); 
		query.append("    @[max_dpc_rt_amt]," ).append("\n"); 
		query.append("    @[init_dpc_rt_amt]," ).append("\n"); 
		query.append("    @[diff_rmk]," ).append("\n"); 
		query.append("	TO_DATE(@[agmt_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("	TO_DATE(@[agmt_eff_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("	TO_DATE(@[agmt_exp_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("    @[agmt_ctrt_no]," ).append("\n"); 
		query.append("	@[old_agmt_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}