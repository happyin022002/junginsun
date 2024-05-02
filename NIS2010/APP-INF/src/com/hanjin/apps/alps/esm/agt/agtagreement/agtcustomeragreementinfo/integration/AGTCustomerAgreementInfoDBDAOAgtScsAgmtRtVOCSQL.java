/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.15 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [ESM_AGT_0057]Brokerage Agreement Rate Creation
	  * </pre>
	  */
	public AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_brog_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_rf_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_chg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_feu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_bx_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("brog_rteu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("brog_rfeu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_teu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO AGT_CMPN_AGMT_RT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("CMPN_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("CMPN_RT_SEQ," ).append("\n"); 
		query.append("SHPR_CNT_CD," ).append("\n"); 
		query.append("SHPR_SEQ," ).append("\n"); 
		query.append("POR_GRP_TP_CD," ).append("\n"); 
		query.append("POR_ROUT_CD," ).append("\n"); 
		query.append("POL_GRP_TP_CD," ).append("\n"); 
		query.append("POL_ROUT_CD," ).append("\n"); 
		query.append("POD_GRP_TP_CD," ).append("\n"); 
		query.append("POD_ROUT_CD," ).append("\n"); 
		query.append("FM_EFF_DT," ).append("\n"); 
		query.append("TO_EFF_DT," ).append("\n"); 
		query.append("SC_NO," ).append("\n"); 
		query.append("RFA_NO," ).append("\n"); 
		query.append("CMDT_TP_CD," ).append("\n"); 
		query.append("CMDT_CD," ).append("\n"); 
		query.append("CMPN_DIV_CD," ).append("\n"); 
		query.append("CMPN_TP_CD," ).append("\n"); 
		query.append("CMPN_BKG_RT," ).append("\n"); 
		query.append("CMPN_BX_RT," ).append("\n"); 
		query.append("CMPN_TEU_RT," ).append("\n"); 
		query.append("CMPN_FEU_RT," ).append("\n"); 
		query.append("CMPN_RF_RT," ).append("\n"); 
		query.append("CMPN_RF_TEU_RT," ).append("\n"); 
		query.append("CMPN_RF_FEU_RT," ).append("\n"); 
		query.append("CMPN_CHG_CTNT," ).append("\n"); 
		query.append("CMPN_KND_CD," ).append("\n"); 
		query.append("INTER_MDAL_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[ar_ofc_cd]                     AS AR_OFC_CD," ).append("\n"); 
		query.append("@[brog_cnt_cd]                   AS CMPN_CNT_CD," ).append("\n"); 
		query.append("@[brog_cust_seq]                 AS CUST_SEQ," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(MAX(CMPN_RT_SEQ),0) + 1" ).append("\n"); 
		query.append("FROM AGT_CMPN_AGMT_RT" ).append("\n"); 
		query.append("WHERE CMPN_CNT_CD   = @[brog_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[brog_cust_seq]" ).append("\n"); 
		query.append(")                                  AS CMPN_RT_SEQ," ).append("\n"); 
		query.append("@[shpr_cnt_cd]                   AS SHPR_CNT_CD," ).append("\n"); 
		query.append("@[shpr_seq]                      AS SHPR_SEQ," ).append("\n"); 
		query.append("@[por_grp_tp_cd]                 AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("NVL(@[por_rout_cd],'*')          AS POR_ROUT_CD," ).append("\n"); 
		query.append("@[pol_grp_tp_cd]                 AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("NVL(@[pol_rout_cd],'*')          AS POL_ROUT_CD," ).append("\n"); 
		query.append("@[pod_grp_tp_cd]                 AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("NVL(@[pod_rout_cd],'*')          AS POD_ROUT_CD," ).append("\n"); 
		query.append("CASE @[fm_eff_dt]" ).append("\n"); 
		query.append("WHEN ''" ).append("\n"); 
		query.append("THEN '20000101'" ).append("\n"); 
		query.append("ELSE @[fm_eff_dt]" ).append("\n"); 
		query.append("END                                  AS FM_EFF_DT," ).append("\n"); 
		query.append("CASE @[to_eff_dt]" ).append("\n"); 
		query.append("WHEN ''" ).append("\n"); 
		query.append("THEN '29991231'" ).append("\n"); 
		query.append("ELSE @[to_eff_dt]" ).append("\n"); 
		query.append("END                                  AS TO_EFF_DT," ).append("\n"); 
		query.append("NVL(@[sc_no],'*')                AS SC_NO," ).append("\n"); 
		query.append("NVL(@[rfa_no],'*')               AS RFA_NO," ).append("\n"); 
		query.append("NVL(@[cmdt_tp_cd],'*')           AS CMDT_TP_CD," ).append("\n"); 
		query.append("DECODE(@[cmdt_tp_cd],'*','*',NVL(@[cmdt_cd],'*'))AS CMDT_CD," ).append("\n"); 
		query.append("@[brog_div_cd]                   AS CMPN_DIV_CD," ).append("\n"); 
		query.append("@[brog_tp_cd]                    AS CMPN_TP_CD," ).append("\n"); 
		query.append("@[bkg_brog_rt]                   AS CMPN_BKG_RT," ).append("\n"); 
		query.append("@[brog_bx_rt]                    AS CMPN_BX_RT," ).append("\n"); 
		query.append("@[brog_teu_rt]                   AS CMPN_TEU_RT," ).append("\n"); 
		query.append("@[brog_feu_rt]                   AS CMPN_FEU_RT," ).append("\n"); 
		query.append("@[brog_rf_rt]                    AS CMPN_RF_RT," ).append("\n"); 
		query.append("@[brog_rteu_rt]                    AS CMPN_RF_TEU_RT," ).append("\n"); 
		query.append("@[brog_rfeu_rt]                    AS CMPN_RF_FEU_RT," ).append("\n"); 
		query.append("@[brog_chg_ctnt]                 AS CMPN_CHG_CTNT," ).append("\n"); 
		query.append("@[brog_knd_cd]                   AS CMPN_KND_CD," ).append("\n"); 
		query.append("'n'                              AS INTER_MDAL_FLG," ).append("\n"); 
		query.append("@[cre_usr_id]                    AS CRE_USR_ID," ).append("\n"); 
		query.append("@[upd_usr_id]                    AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE                          AS CRE_DT," ).append("\n"); 
		query.append("SYSDATE                          AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}