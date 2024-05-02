/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCLCmpnAgreementDBDAOModifySPCLCmpnAgreementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnAgreementDBDAOModifySPCLCmpnAgreementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySPCLCmpnAgreement
	  * 
	  * 2016.04.21 박다은 [CSR:#11434] CSA - ACM - Special Compensation CSR to be created in local currency
	  * </pre>
	  */
	public SPCLCmpnAgreementDBDAOModifySPCLCmpnAgreementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("spcl_bx_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_rf_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_rf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_bkg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_chg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_rf_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.integration").append("\n"); 
		query.append("FileName : SPCLCmpnAgreementDBDAOModifySPCLCmpnAgreementUSQL").append("\n"); 
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
		query.append("UPDATE ACM_SPCL_AGMT" ).append("\n"); 
		query.append("   SET CUST_CNT_CD = SUBSTR(@[cust_cnt_seq], 0, 2)," ).append("\n"); 
		query.append("       CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cnt_seq], 3))," ).append("\n"); 
		query.append("       SPCL_AGMT_SEQ = @[spcl_agmt_seq]," ).append("\n"); 
		query.append("       CUST_KND_CD = @[cust_knd_cd]," ).append("\n"); 
		query.append("       SC_NO = @[sc_no]," ).append("\n"); 
		query.append("       RFA_NO = @[rfa_no]," ).append("\n"); 
		query.append("       SHPR_CNT_CD = DECODE(@[shpr_cnt_seq], '*', '*', SUBSTR(@[shpr_cnt_seq], 0, 2))," ).append("\n"); 
		query.append("       SHPR_SEQ = DECODE(@[shpr_cnt_seq], '*', 0, TO_NUMBER(SUBSTR(@[shpr_cnt_seq], 3)))," ).append("\n"); 
		query.append("       FM_EFF_DT = @[fm_eff_dt]," ).append("\n"); 
		query.append("       TO_EFF_DT = @[to_eff_dt]," ).append("\n"); 
		query.append("       CMDT_TP_CD = @[cmdt_tp_cd]," ).append("\n"); 
		query.append("       CMDT_CD = @[cmdt_cd]," ).append("\n"); 
		query.append("       POR_GRP_TP_CD = @[por_grp_tp_cd]," ).append("\n"); 
		query.append("       POR_ROUT_CD = @[por_rout_cd]," ).append("\n"); 
		query.append("       POL_GRP_TP_CD = @[pol_grp_tp_cd]," ).append("\n"); 
		query.append("       POL_ROUT_CD = @[pol_rout_cd]," ).append("\n"); 
		query.append("       POD_GRP_TP_CD = @[pod_grp_tp_cd]," ).append("\n"); 
		query.append("       POD_ROUT_CD = @[pod_rout_cd]," ).append("\n"); 
		query.append("       SPCL_DIV_CD = @[spcl_div_cd]," ).append("\n"); 
		query.append("       SPCL_BKG_RT = @[spcl_bkg_rt]," ).append("\n"); 
		query.append("       SPCL_BX_AMT = @[spcl_bx_amt]," ).append("\n"); 
		query.append("       SPCL_TEU_AMT = @[spcl_teu_amt]," ).append("\n"); 
		query.append("       SPCL_FEU_AMT = @[spcl_feu_amt]," ).append("\n"); 
		query.append("       SPCL_RF_AMT = @[spcl_rf_amt]," ).append("\n"); 
		query.append("       SPCL_RF_TEU_AMT = @[spcl_rf_teu_amt]," ).append("\n"); 
		query.append("       SPCL_RF_FEU_AMT = @[spcl_rf_feu_amt]," ).append("\n"); 
		query.append("       SPCL_CHG_CTNT = @[spcl_chg_ctnt]," ).append("\n"); 
		query.append("       CURR_CD = @[curr_cd]," ).append("\n"); 
		query.append("       PAY_XCH_RT = @[pay_xch_rt]," ).append("\n"); 
		query.append("       UPD_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE SPCL_OFC_CD = @[spcl_ofc_cd]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   AND SPCL_AGMT_SEQ = @[spcl_agmt_seq]" ).append("\n"); 

	}
}