/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOInsertIHCGuidelineDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOInsertIHCGuidelineDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면(ESM_PRI_7001) 화면을 통한 PRI_TRF_IHC_RT 입력.
	  * 
	  * *History
	  * 2013.03.16 [CHM-201534279] 전지예 Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public IHCGuideLineDBDAOInsertIHCGuidelineDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_cost_loc_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnt_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_locl_curr_20ft_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ihc_rt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_trf_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ihc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_locl_curr_45ft_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_locl_curr_40ft_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOInsertIHCGuidelineDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_IHC_RT" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   ORG_DEST_TP_CD," ).append("\n"); 
		query.append("   IHC_TRF_NO," ).append("\n"); 
		query.append("   AMDT_SEQ," ).append("\n"); 
		query.append("   IHC_CGO_TP_CD," ).append("\n"); 
		query.append("   RT_SEQ," ).append("\n"); 
		query.append("   N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("   PNT_LOC_CD," ).append("\n"); 
		query.append("   BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("   HUB_LOC_CD," ).append("\n"); 
		query.append("   PNT_NOD_CD," ).append("\n"); 
		query.append("   HUB_NOD_CD," ).append("\n"); 
		query.append("   BSE_PORT_NOD_CD," ).append("\n"); 
		query.append("   IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("   RCV_DE_TERM_CD," ).append("\n"); 
		query.append("   PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("   GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_45FT_FRT_RT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("   OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("   SRC_INFO_CD," ).append("\n"); 
		query.append("   IHC_RT_RMK," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   DCGO_SVC_FLG," ).append("\n"); 
		query.append("   PRC_TRF_CRE_TP_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   GLINE_LOCL_CURR_20FT_AMT," ).append("\n"); 
		query.append("   GLINE_LOCL_CURR_45FT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("   GLINE_LOCL_CURR_40FT_AMT)" ).append("\n"); 
		query.append("SELECT @[svc_scp_cd]," ).append("\n"); 
		query.append("       @[org_dest_tp_cd]," ).append("\n"); 
		query.append("       @[ihc_trf_no]," ).append("\n"); 
		query.append("       @[amdt_seq]," ).append("\n"); 
		query.append("       @[ihc_cgo_tp_cd]," ).append("\n"); 
		query.append("       NVL(MAX(RT_SEQ), 0) + 1," ).append("\n"); 
		query.append("       @[n1st_cmnc_amdt_seq]," ).append("\n"); 
		query.append("       @[pnt_loc_cd]," ).append("\n"); 
		query.append("       @[bse_port_loc_cd]," ).append("\n"); 
		query.append("       @[hub_loc_cd]," ).append("\n"); 
		query.append("       @[pnt_nod_cd]," ).append("\n"); 
		query.append("       @[hub_nod_cd]," ).append("\n"); 
		query.append("       @[bse_port_nod_cd]," ).append("\n"); 
		query.append("       @[ihc_cost_loc_grp_no]," ).append("\n"); 
		query.append("       @[rcv_de_term_cd]," ).append("\n"); 
		query.append("       @[prc_trsp_mod_cd]," ).append("\n"); 
		query.append("       @[gline_20ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[gline_40ft_frt_rt_amt]," ).append("\n"); 
		query.append("       @[gline_45ft_frt_rt_amt], -- 45' Cost 추가" ).append("\n"); 
		query.append("       @[optm_trsp_mod_flg]," ).append("\n"); 
		query.append("       @[src_info_cd]," ).append("\n"); 
		query.append("       @[ihc_rt_rmk]," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[upd_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[dcgo_svc_flg]," ).append("\n"); 
		query.append("       @[prc_trf_cre_tp_cd]," ).append("\n"); 
		query.append("       @[locl_curr_cd]," ).append("\n"); 
		query.append("       @[gline_locl_curr_20ft_amt]," ).append("\n"); 
		query.append("       @[gline_locl_curr_45ft_amt], -- 45' Cost 추가" ).append("\n"); 
		query.append("       @[gline_locl_curr_40ft_amt]" ).append("\n"); 
		query.append("  FROM PRI_TRF_IHC_RT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD       = @[svc_scp_cd] " ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD   = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND IHC_TRF_NO       = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ         = @[amdt_seq]" ).append("\n"); 
		query.append("   AND IHC_CGO_TP_CD    = @[ihc_cgo_tp_cd]" ).append("\n"); 

	}
}