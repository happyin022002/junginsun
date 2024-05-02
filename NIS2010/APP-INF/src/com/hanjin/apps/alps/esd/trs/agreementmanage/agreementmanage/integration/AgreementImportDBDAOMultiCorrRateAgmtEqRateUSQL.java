/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.07.08 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOMultiCorrRateAgmtEqRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Rate Update
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtEqRateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_nod_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_one_wy_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_bdl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rvs_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateUSQL").append("\n"); 
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
		query.append("UPDATE TRS_AGMT_EQ_RT" ).append("\n"); 
		query.append("   SET EFF_FM_DT         = TO_DATE(@[eff_fm_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("      ,EFF_TO_DT         = TO_DATE(@[eff_to_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("      ,CURR_CD           = @[curr_cd]" ).append("\n"); 
		query.append("      ,TRSP_ONE_WY_RT    = @[trsp_one_wy_rt]" ).append("\n"); 
		query.append("      ,TRSP_RND_RT       = @[trsp_rnd_rt]" ).append("\n"); 
		query.append("      ,WTR_RCV_TERM_CD   = @[wtr_rcv_term_cd]" ).append("\n"); 
		query.append("      ,WTR_DE_TERM_CD    = @[wtr_de_term_cd]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_BDL_QTY = @[trsp_agmt_bdl_qty]" ).append("\n"); 
		query.append("      ,TO_WGT            = @[to_wgt]" ).append("\n"); 
		query.append("      ,WGT_MEAS_UT_CD    = @[wgt_meas_ut_cd]" ).append("\n"); 
		query.append("      ,TRSP_RVS_APLY_FLG = @[trsp_rvs_aply_flg]" ).append("\n"); 
		query.append("      ,EQ_KND_CD         = @[eq_knd_cd]" ).append("\n"); 
		query.append("      ,CFM_FLG           = 'N'" ).append("\n"); 
		query.append("      ,CFM_USR_ID        = null" ).append("\n"); 
		query.append("      ,CFM_DT            = null" ).append("\n"); 
		query.append("      ,UPD_USR_ID        = @[fm_account_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("      ,DELT_FLG          = @[delt_flg]" ).append("\n"); 
		query.append("      ,AGMT_EXP_DT       = NULL" ).append("\n"); 
		query.append("      ,AGMT_APRO_DT      = TO_DATE(@[agmt_apro_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(" WHERE TRSP_AGMT_OFC_CTY_CD   = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_AGMT_SEQ          = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("   AND TRSP_AGMT_RT_TP_SER_NO = @[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("   AND TRSP_AGMT_NOD_SEQ      = @[trsp_agmt_nod_seq]" ).append("\n"); 
		query.append("   AND TRSP_AGMT_RT_SEQ       = @[trsp_agmt_rt_seq]" ).append("\n"); 

	}
}