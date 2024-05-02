/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOInsertFDRGuidelineDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOInsertFDRGuidelineDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert FDR Guideline Detail
	  * 
	  * * History
	  * 2013.03.16 [CHM-201534279] 전지예 Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOInsertFDRGuidelineDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rf_20ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_rf_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_45ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_40ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_rt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_40ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_20ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cost_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rf_40ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_45ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cost_rf_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_20ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cost_rf_40ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_rf_40ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_rf_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_rf_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_rf_20ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cost_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cost_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_rf_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOInsertFDRGuidelineDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_FDR_RT" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   ORG_DEST_TP_CD," ).append("\n"); 
		query.append("   FDR_TRF_NO," ).append("\n"); 
		query.append("   AMDT_SEQ," ).append("\n"); 
		query.append("   RT_SEQ," ).append("\n"); 
		query.append("   N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("   PNT_LOC_CD," ).append("\n"); 
		query.append("   BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("   RCV_DE_TERM_CD," ).append("\n"); 
		query.append("   GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_45FT_FRT_RT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("   COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_45FT_FRT_RT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("   LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_45FT_FRT_RT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("   TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("   TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("   TRSP_45FT_COST_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("   TML_20FT_COST_AMT," ).append("\n"); 
		query.append("   TML_40FT_COST_AMT," ).append("\n"); 
		query.append("   TML_45FT_COST_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("   GLINE_RF_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_RF_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_RF_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_RF_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_RF_20FT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_RF_40FT_RT_AMT," ).append("\n"); 
		query.append("   TRSP_RF_20FT_COST_AMT," ).append("\n"); 
		query.append("   TRSP_RF_40FT_COST_AMT," ).append("\n"); 
		query.append("   TML_RF_20FT_COST_AMT," ).append("\n"); 
		query.append("   TML_RF_40FT_COST_AMT," ).append("\n"); 
		query.append("   RC_SVC_FLG,   " ).append("\n"); 
		query.append("   WTR_RCV_TERM_CD," ).append("\n"); 
		query.append("   WTR_DE_TERM_CD," ).append("\n"); 
		query.append("   RHQ_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   SRC_INFO_CD," ).append("\n"); 
		query.append("   FDR_RT_RMK)" ).append("\n"); 
		query.append("SELECT @[svc_scp_cd]," ).append("\n"); 
		query.append("       @[org_dest_tp_cd]," ).append("\n"); 
		query.append("       @[fdr_trf_no]," ).append("\n"); 
		query.append("       @[amdt_seq]," ).append("\n"); 
		query.append("       NVL(MAX(RT_SEQ), 0) + 1," ).append("\n"); 
		query.append("       @[n1st_cmnc_amdt_seq]," ).append("\n"); 
		query.append("       @[pnt_loc_cd]," ).append("\n"); 
		query.append("       @[bse_port_loc_cd]," ).append("\n"); 
		query.append("       @[rcv_de_term_cd]," ).append("\n"); 
		query.append("       @[gline_20ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[gline_40ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[gline_45ft_frt_rt_amt], -- 45' cost 추가" ).append("\n"); 
		query.append("       @[cost_20ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[cost_40ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[cost_45ft_frt_rt_amt], -- 45' cost 추가" ).append("\n"); 
		query.append("       @[locl_curr_cost_20ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[locl_curr_cost_40ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[locl_curr_cost_45ft_frt_rt_amt], -- 45' cost 추가" ).append("\n"); 
		query.append("       @[trsp_20ft_cost_amt]," ).append("\n"); 
		query.append("       @[trsp_40ft_cost_amt]," ).append("\n"); 
		query.append("       @[trsp_45ft_cost_amt], -- 45' cost 추가" ).append("\n"); 
		query.append("       @[tml_20ft_cost_amt]," ).append("\n"); 
		query.append("       @[tml_40ft_cost_amt]," ).append("\n"); 
		query.append("       @[tml_45ft_cost_amt], -- 45' cost 추가" ).append("\n"); 
		query.append("       @[gline_rf_20ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[gline_rf_40ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[cost_rf_20ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[cost_rf_40ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[locl_curr_cost_rf_20ft_rt_amt]," ).append("\n"); 
		query.append("       @[locl_curr_cost_rf_40ft_rt_amt]," ).append("\n"); 
		query.append("       @[trsp_rf_20ft_cost_amt]," ).append("\n"); 
		query.append("       @[trsp_rf_40ft_cost_amt]," ).append("\n"); 
		query.append("       @[tml_rf_20ft_cost_amt]," ).append("\n"); 
		query.append("       @[tml_rf_40ft_cost_amt]," ).append("\n"); 
		query.append("       @[rc_svc_flg]," ).append("\n"); 
		query.append("       @[wtr_rcv_term_cd]," ).append("\n"); 
		query.append("       @[wtr_de_term_cd]," ).append("\n"); 
		query.append("       @[rhq_cd]," ).append("\n"); 
		query.append("       @[locl_curr_cd]," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[upd_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[src_info_cd]," ).append("\n"); 
		query.append("       @[fdr_rt_rmk]" ).append("\n"); 
		query.append("FROM PRI_TRF_FDR_RT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD       = @[svc_scp_cd] " ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD   = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND FDR_TRF_NO       = @[fdr_trf_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ         = @[amdt_seq]" ).append("\n"); 

	}
}