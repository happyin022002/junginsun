/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOAddCHSCpsAgreementMainDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOAddCHSCpsAgreementMainDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NP(ZP) Agreement 정보를 CGM_AGREEMENT 테이블에 create 한다.
	  * -- 2014.11 10만불 결제관련
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOAddCHSCpsAgreementMainDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gw_uq_doc_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gw_uq_doc_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOAddCHSCpsAgreementMainDataCSQL").append("\n"); 
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
		query.append("    VNDR_SEQ, " ).append("\n"); 
		query.append("    PAY_TERM_DYS," ).append("\n"); 
		query.append("    AGMT_LSTM_CD," ).append("\n"); 
		query.append("    CHSS_POOL_CD," ).append("\n"); 
		query.append("    DIFF_RMK," ).append("\n"); 
		query.append("	AGMT_EFF_DT," ).append("\n"); 
		query.append("	AGMT_EXP_DT," ).append("\n"); 
		query.append("    EFF_DT," ).append("\n"); 
		query.append("    EXP_DT," ).append("\n"); 
		query.append("    CTRT_NO," ).append("\n"); 
		query.append("    GW_UQ_DOC_TIT_NM," ).append("\n"); 
		query.append("    GW_UQ_DOC_NO," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("    @[agmt_seq]," ).append("\n"); 
		query.append("    @[agmt_ver_no]," ).append("\n"); 
		query.append("    'Z'," ).append("\n"); 
		query.append("    @[lst_ver_flg]," ).append("\n"); 
		query.append("    @[agmt_iss_ofc_cd]," ).append("\n"); 
		query.append("    @[agmt_ref_no]," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("    @[vndr_seq]," ).append("\n"); 
		query.append("    @[pay_term_dys]," ).append("\n"); 
		query.append("    @[agmt_lstm_cd]," ).append("\n"); 
		query.append("    @[chss_pool_cd]," ).append("\n"); 
		query.append("    @[diff_rmk]," ).append("\n"); 
		query.append("	TO_DATE(@[agmt_eff_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("	TO_DATE(@[agmt_exp_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("    TO_DATE(@[agmt_eff_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("    TO_DATE(@[agmt_exp_dt],'YYYYMMDD')," ).append("\n"); 
		query.append("    @[ctrt_no]," ).append("\n"); 
		query.append("    @[gw_uq_doc_tit_nm]," ).append("\n"); 
		query.append("    @[gw_uq_doc_no]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}