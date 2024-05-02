/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.16 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [ESM_AGT_0007]Brokerage Agreement Rate Creation
	  * </pre>
	  */
	public AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOCSQL(){
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
		params.put("brog_hus_bro_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOCSQL").append("\n"); 
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
		query.append("INTO AGT_BROG_AGMT_RT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BROG_CNT_CD," ).append("\n"); 
		query.append("BROG_CUST_SEQ," ).append("\n"); 
		query.append("BROG_RT_SEQ," ).append("\n"); 
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
		query.append("BROG_DIV_CD," ).append("\n"); 
		query.append("BROG_TP_CD," ).append("\n"); 
		query.append("BKG_BROG_RT," ).append("\n"); 
		query.append("BROG_BX_RT," ).append("\n"); 
		query.append("BROG_TEU_RT," ).append("\n"); 
		query.append("BROG_FEU_RT," ).append("\n"); 
		query.append("BROG_RF_RT," ).append("\n"); 
		query.append("BROG_CHG_CTNT," ).append("\n"); 
		query.append("BROG_KND_CD," ).append("\n"); 
		query.append("BROG_HUS_BRO_NO," ).append("\n"); 
		query.append("INTER_MDAL_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[brog_cnt_cd]                   AS BROG_CNT_CD," ).append("\n"); 
		query.append("@[brog_cust_seq]                 AS BROG_CUST_SEQ," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(MAX(BROG_RT_SEQ),0) + 1" ).append("\n"); 
		query.append("FROM AGT_BROG_AGMT_RT" ).append("\n"); 
		query.append("WHERE BROG_CNT_CD   = @[brog_cnt_cd]" ).append("\n"); 
		query.append("AND BROG_CUST_SEQ = @[brog_cust_seq]" ).append("\n"); 
		query.append(")                                  AS BROG_RT_SEQ," ).append("\n"); 
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
		query.append("@[brog_div_cd]                   AS BROG_DIV_CD," ).append("\n"); 
		query.append("@[brog_tp_cd]                    AS BROG_TP_CD," ).append("\n"); 
		query.append("@[bkg_brog_rt]                   AS BKG_BROG_RT," ).append("\n"); 
		query.append("@[brog_bx_rt]                    AS BROG_BX_RT," ).append("\n"); 
		query.append("@[brog_teu_rt]                   AS BROG_TEU_RT," ).append("\n"); 
		query.append("@[brog_feu_rt]                   AS BROG_FEU_RT," ).append("\n"); 
		query.append("@[brog_rf_rt]                    AS BROG_RF_RT," ).append("\n"); 
		query.append("@[brog_chg_ctnt]                 AS BROG_CHG_CTNT," ).append("\n"); 
		query.append("@[brog_knd_cd]                   AS BROG_KND_CD," ).append("\n"); 
		query.append("@[brog_hus_bro_no]               AS BROG_HUS_BRO_NO," ).append("\n"); 
		query.append("'n'                              AS INTER_MDAL_FLG," ).append("\n"); 
		query.append("@[cre_usr_id]                    AS CRE_USR_ID," ).append("\n"); 
		query.append("@[upd_usr_id]                    AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE                          AS CRE_DT," ).append("\n"); 
		query.append("SYSDATE                          AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}