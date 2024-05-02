/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionDBDAODeleteCorrSumAgmtTargetCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.05.25 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAODeleteCorrSumAgmtTargetCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Rate아래의 모든 Rate를 삭제하기전 History 테이블에 기록한다.
	  * </pre>
	  */
	public AgreementCorrectionDBDAODeleteCorrSumAgmtTargetCSQL(){
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
		params.put("to_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wtr_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_tp_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAODeleteCorrSumAgmtTargetCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_EQ_RT_HIS (" ).append("\n"); 
		query.append("TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(",TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_HIS_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append(",EFF_FM_DT" ).append("\n"); 
		query.append(",EFF_TO_DT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(",TRSP_RND_RT" ).append("\n"); 
		query.append(",WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(",WTR_DE_TERM_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append(",TO_WGT" ).append("\n"); 
		query.append(",WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]" ).append("\n"); 
		query.append(",@[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append(",@[trsp_agmt_nod_seq]" ).append("\n"); 
		query.append(",@[trsp_agmt_rt_seq]" ).append("\n"); 
		query.append(",TRS_AGMT_EQ_RT_HIS_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(",@[trsp_agmt_eq_tp_sz_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[eff_fm_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",TO_DATE(@[eff_to_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",@[curr_cd]" ).append("\n"); 
		query.append(",@[trsp_one_wy_rt]" ).append("\n"); 
		query.append(",@[trsp_rnd_rt]" ).append("\n"); 
		query.append(",@[wtr_rcv_term_cd]" ).append("\n"); 
		query.append(",@[wtr_de_term_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_bdl_qty]" ).append("\n"); 
		query.append(",@[to_wgt]" ).append("\n"); 
		query.append(",@[wgt_meas_ut_cd]" ).append("\n"); 
		query.append(",@[trsp_rvs_aply_flg]" ).append("\n"); 
		query.append(",@[eq_knd_cd]" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",@[fm_account_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[fm_account_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}