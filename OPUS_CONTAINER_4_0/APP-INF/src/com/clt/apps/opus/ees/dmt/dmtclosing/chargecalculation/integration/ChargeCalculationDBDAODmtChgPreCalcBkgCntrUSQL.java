/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgPreCalcBkgCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAODmtChgPreCalcBkgCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODmtChgPreCalcBkgCntrUSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgPreCalcBkgCntrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adv_shtg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_prt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgPreCalcBkgCntrUSQL").append("\n"); 
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
		query.append("UPDATE DMT_CHG_PRE_CALC_BKG_CNTR" ).append("\n"); 
		query.append("SET (" ).append("\n"); 
		query.append("	 BL_NO" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,SKD_DIR_CD" ).append("\n"); 
		query.append("	,ESTM_TM_OF_ARR_DT" ).append("\n"); 
		query.append("	,SC_NO" ).append("\n"); 
		query.append("	,RFA_NO" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,REP_CMDT_CD" ).append("\n"); 
		query.append("	,DCGO_FLG" ).append("\n"); 
		query.append("	,RC_FLG" ).append("\n"); 
		query.append("	,BB_CGO_FLG" ).append("\n"); 
		query.append("	,AWK_CGO_FLG" ).append("\n"); 
		query.append("	,RD_CGO_FLG" ).append("\n"); 
		query.append("	,SOC_FLG" ).append("\n"); 
		query.append("	,CNTR_PRT_FLG" ).append("\n"); 
		query.append("	,ADV_SHTG_CD" ).append("\n"); 
		query.append("	,DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("	,DMDT_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	,POR_CD" ).append("\n"); 
		query.append("	,POL_CD" ).append("\n"); 
		query.append("	,POD_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	,BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	,BKG_CNTR_QTY" ).append("\n"); 
		query.append("	,SLS_OFC_CD" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_OFC_CD" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	 @[bl_no]" ).append("\n"); 
		query.append("	,@[vsl_cd]" ).append("\n"); 
		query.append("	,@[skd_voy_no]" ).append("\n"); 
		query.append("	,@[skd_dir_cd]" ).append("\n"); 
		query.append("	,TO_DATE(TRIM(@[vps_eta_dt]), 'YYYYMMDD')" ).append("\n"); 
		query.append("	,@[sc_no]" ).append("\n"); 
		query.append("	,SUBSTR(@[rfa_no],1,11)" ).append("\n"); 
		query.append("	,@[cmdt_cd]" ).append("\n"); 
		query.append("	,@[rep_cmdt_cd]" ).append("\n"); 
		query.append("	,@[dcgo_flg]" ).append("\n"); 
		query.append("	,@[rc_flg]" ).append("\n"); 
		query.append("	,@[bb_cgo_flg]" ).append("\n"); 
		query.append("	,@[awk_cgo_flg]" ).append("\n"); 
		query.append("	,@[rd_cgo_flg]" ).append("\n"); 
		query.append("	,@[soc_flg]" ).append("\n"); 
		query.append("	,@[cntr_prt_flg]" ).append("\n"); 
		query.append("	,@[adv_shtg_cd]" ).append("\n"); 
		query.append("	,@[dmdt_cntr_tp_cd]" ).append("\n"); 
		query.append("	,@[dmdt_bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("	,@[por_cd]" ).append("\n"); 
		query.append("	,@[pol_cd]" ).append("\n"); 
		query.append("	,@[pod_cd]" ).append("\n"); 
		query.append("	,@[del_cd]" ).append("\n"); 
		query.append("	,@[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("	,@[bkg_de_term_cd]" ).append("\n"); 
		query.append("	,@[bkg_cntr_qty]" ).append("\n"); 
		query.append("	,@[sls_ofc_cd]" ).append("\n"); 
		query.append("	,@[rhq_cd]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,@[upd_ofc_cd]" ).append("\n"); 
		query.append("	FROM    DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND     CNTR_NO     	= @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_CYC_NO 	= @[cntr_cyc_no]" ).append("\n"); 

	}
}