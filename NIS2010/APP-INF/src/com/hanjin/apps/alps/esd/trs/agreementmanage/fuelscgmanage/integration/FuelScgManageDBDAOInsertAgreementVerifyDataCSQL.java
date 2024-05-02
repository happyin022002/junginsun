/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FuelScgManageDBDAOInsertAgreementVerifyDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.06.05 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FuelScgManageDBDAOInsertAgreementVerifyDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Verify 대상 데이타를 global temp에 Insert
	  * </pre>
	  */
	public FuelScgManageDBDAOInsertAgreementVerifyDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_scg_rt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rout_all_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rowno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_scg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_rowno",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dist_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_dist_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration").append("\n"); 
		query.append("FileName : FuelScgManageDBDAOInsertAgreementVerifyDataCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_TMP (" ).append("\n"); 
		query.append("	   	    TRSP_TMP_SEQ" ).append("\n"); 
		query.append("		   ,TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		   ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		   ,EQ_KND_CD" ).append("\n"); 
		query.append("		   ,CGO_TP_CD" ).append("\n"); 
		query.append("		   ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("		   ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("		   ,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("		   ,CMDT_GRP_CD" ).append("\n"); 
		query.append("		   ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("		   ,CUST_CNT_CD" ).append("\n"); 
		query.append("		   ,CUST_SEQ" ).append("\n"); 
		query.append("		   ,FM_NOD_CD" ).append("\n"); 
		query.append("		   ,VIA_NOD_CD" ).append("\n"); 
		query.append("		   ,DOR_NOD_CD" ).append("\n"); 
		query.append("		   ,TO_NOD_CD" ).append("\n"); 
		query.append("		   ,TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("		   ,TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("		   ,EFF_FM_DT" ).append("\n"); 
		query.append("		   ,EFF_TO_DT" ).append("\n"); 
		query.append("		   ,TO_WGT" ).append("\n"); 
		query.append("		   ,CURR_CD" ).append("\n"); 
		query.append("		   ,TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("		   ,TRSP_RND_RT" ).append("\n"); 
		query.append("		   ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("		   ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("		   ,TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("		   ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("		   ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("		   ,TRSP_AGMT_DIST" ).append("\n"); 
		query.append("		   ,DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("		   ,TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("		   ,TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("		   ,TRSP_SCG_CD" ).append("\n"); 
		query.append("		   ,AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("		   ,ROW_NO" ).append("\n"); 
		query.append("		   ,SUB_ROW_NO" ).append("\n"); 
		query.append("		   ,CRE_USR_ID" ).append("\n"); 
		query.append("		   ,UPD_USR_ID" ).append("\n"); 
		query.append("		   ,RT_UPD_STS_CD" ).append("\n"); 
		query.append("		   ,DELT_FLG" ).append("\n"); 
		query.append("		   ,AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("		   ,AGMT_APRO_DT" ).append("\n"); 
		query.append("	)VALUES( " ).append("\n"); 
		query.append("		    @[trsp_tmp_seq]" ).append("\n"); 
		query.append("		   ,SUBSTR(@[agmt_no],1,3)" ).append("\n"); 
		query.append("		   ,SUBSTR(@[agmt_no],4)" ).append("\n"); 
		query.append("		   ,NVL(@[eq_knd_cd],'U')" ).append("\n"); 
		query.append("	       ,NVL(@[cgo_tp_cd],'0')" ).append("\n"); 
		query.append("		   ,@[agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("		   ,@[trsp_cost_mod_cd]" ).append("\n"); 
		query.append("		   ,DECODE(@[cust_cd], null, 'N', 'Y')" ).append("\n"); 
		query.append("		   ,NVL(@[cmdt_grp_cd], 'XXXX')" ).append("\n"); 
		query.append("		   ,NVL(@[rail_svc_tp_cd], '00')" ).append("\n"); 
		query.append("		   ,NVL(SUBSTR(@[cust_cd], 1, 2),'XX')" ).append("\n"); 
		query.append("		   ,NVL(SUBSTR(@[cust_cd], 3), 0)" ).append("\n"); 
		query.append("		   ,NVL(@[fm_nod_cd]||@[fm_nod_yd], '0000000')" ).append("\n"); 
		query.append("		   ,NVL(@[via_nod_cd]||@[via_nod_yd], '0000000')" ).append("\n"); 
		query.append("		   ,NVL(@[dor_nod_cd]||@[dor_nod_yd], '0000000')" ).append("\n"); 
		query.append("		   ,NVL(@[to_nod_cd]||@[to_nod_yd], '0000000')" ).append("\n"); 
		query.append("		   ,@[trsp_agmt_eq_tp_cd]" ).append("\n"); 
		query.append("		   ,@[trsp_agmt_eq_sz_cd]" ).append("\n"); 
		query.append("		   ,TO_DATE(@[eff_fm_dt],'yyyyMMdd')" ).append("\n"); 
		query.append("		   ,TO_DATE(@[eff_to_dt],'yyyyMMdd')" ).append("\n"); 
		query.append("		   ,DECODE(@[to_wgt], 'MAX', '999999.99', NULL, '0', @[to_wgt])" ).append("\n"); 
		query.append("		   ,NVL(@[curr_cd], 'XXX')" ).append("\n"); 
		query.append("		   ,@[trsp_one_wy_rt]" ).append("\n"); 
		query.append("		   ,@[trsp_rnd_rt]" ).append("\n"); 
		query.append("		   ,@[trsp_agmt_rt_tp_cd]" ).append("\n"); 
		query.append("		   ,NVL(DECODE(@[to_wgt], 'MAX', 'XXX', '999999.99', 'XXX', '0', 'XXX',  @[wgt_meas_ut_cd]), 'XXX')" ).append("\n"); 
		query.append("		   ,NVL(@[trsp_agmt_bdl_qty], 0)" ).append("\n"); 
		query.append("		   ,NVL(@[wtr_rcv_term_cd], '0')" ).append("\n"); 
		query.append("		   ,NVL(@[wtr_de_term_cd], '0')" ).append("\n"); 
		query.append("		   ,NVL(DECODE(@[trsp_agmt_dist], 'MAX', '999999.999999', @[trsp_agmt_dist]), 0)" ).append("\n"); 
		query.append("		   ,NVL(@[dist_meas_ut_cd], 'XX')" ).append("\n"); 
		query.append("		   ,NVL(@[trsp_dist_tp_cd], 'X')" ).append("\n"); 
		query.append("		   ,NVL(@[trsp_rvs_aply_flg], 'N')" ).append("\n"); 
		query.append("		   ,NVL(@[trsp_scg_cd],'FUA')" ).append("\n"); 
		query.append("		   ,NVL(@[agmt_rout_all_flg], 'N')" ).append("\n"); 
		query.append("		   ,@[rowno]" ).append("\n"); 
		query.append("		   ,@[chk_rowno]" ).append("\n"); 
		query.append("		   ,@[usr_id]" ).append("\n"); 
		query.append("		   ,@[usr_id]" ).append("\n"); 
		query.append("		   ,@[ibflag]" ).append("\n"); 
		query.append("	       ,@[delt_flg]" ).append("\n"); 
		query.append("		   ,NVL(@[agmt_scg_rt_div_cd], 'X')" ).append("\n"); 
		query.append("		   ,TO_DATE(@[agmt_apro_dt],'yyyyMMdd')" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}