/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAgreementDBDAOModifyFFAgreementUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAgreementDBDAOModifyFFAgreementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifyFFAgreement
	  * </pre>
	  */
	public FFCmpnAgreementDBDAOModifyFFAgreementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_bx_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_chg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_bkg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_rf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.integration").append("\n");
		query.append("FileName : FFCmpnAgreementDBDAOModifyFFAgreementUSQL").append("\n");
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
		query.append("UPDATE ACM_FF_AGMT " ).append("\n");
		query.append("  SET  FF_CNT_CD			= SUBSTR(@[ff_cnt_seq],0,2) , " ).append("\n");
		query.append("       FF_SEQ				= TO_NUMBER(SUBSTR(@[ff_cnt_seq],3)), " ).append("\n");
		query.append("       FF_AGMT_SEQ 			= @[ff_agmt_seq]," ).append("\n");
		query.append("       SHPR_CNT_CD			= SUBSTR(@[shpr_cnt_seq],0,2)," ).append("\n");
		query.append("       SHPR_SEQ				= TO_NUMBER(SUBSTR(@[shpr_cnt_seq],3))," ).append("\n");
		query.append("       POR_GRP_TP_CD		= @[por_grp_tp_cd], " ).append("\n");
		query.append("       POR_ROUT_CD			= @[por_rout_cd], " ).append("\n");
		query.append("       POL_GRP_TP_CD		= @[pol_grp_tp_cd], " ).append("\n");
		query.append("       POL_ROUT_CD			= @[pol_rout_cd], " ).append("\n");
		query.append("       POD_GRP_TP_CD		= @[pod_grp_tp_cd], " ).append("\n");
		query.append("       POD_ROUT_CD			= @[pod_rout_cd], " ).append("\n");
		query.append("       FM_EFF_DT			= @[fm_eff_dt], " ).append("\n");
		query.append("       TO_EFF_DT			= @[to_eff_dt], " ).append("\n");
		query.append("       SC_NO				= @[sc_no], " ).append("\n");
		query.append("       RFA_NO				= @[rfa_no], " ).append("\n");
		query.append("       CMDT_TP_CD			= @[cmdt_tp_cd], " ).append("\n");
		query.append("       CMDT_CD				= @[cmdt_cd], " ).append("\n");
		query.append("       FF_DIV_CD			= @[ff_div_cd], " ).append("\n");
		query.append("       FF_BKG_RT			= @[ff_bkg_rt], " ).append("\n");
		query.append("       FF_BX_AMT			= @[ff_bx_amt], " ).append("\n");
		query.append("       FF_TEU_AMT			= @[ff_teu_amt], " ).append("\n");
		query.append("       FF_FEU_AMT			= @[ff_feu_amt], " ).append("\n");
		query.append("       FF_RF_AMT			= @[ff_rf_amt], " ).append("\n");
		query.append("       FF_CHG_CTNT			= @[ff_chg_ctnt], " ).append("\n");
		query.append("       UPD_USR_ID 			= @[usr_id], " ).append("\n");
		query.append("       UPD_DT 				= SYSDATE " ).append("\n");
		query.append("WHERE FF_CNT_CD 			= @[ff_cnt_cd] " ).append("\n");
		query.append("  AND FF_SEQ 				= @[ff_seq] " ).append("\n");
		query.append("  AND FF_AGMT_SEQ 			= @[ff_agmt_seq] " ).append("\n");

	}
}