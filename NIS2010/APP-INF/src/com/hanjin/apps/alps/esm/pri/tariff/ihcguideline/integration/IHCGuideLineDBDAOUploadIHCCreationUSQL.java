/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOUploadIHCCreationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
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

public class IHCGuideLineDBDAOUploadIHCCreationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_TRF_IHC_RT테이블에 업데이트한다.
	  * * History
	  * 2013.03.16 [CHM-201534279] 전지예 Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public IHCGuideLineDBDAOUploadIHCCreationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_locl_curr_dg_40ft_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_trsp_40ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_ovr_wgt_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_cost_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_dg_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_locl_curr_dg_20ft_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_ovr_wgt_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_40ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mb_40ft_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_cost_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_ovr_wgt_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mb_20ft_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_cost_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_locl_curr_ovr_40ft_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cost_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_locl_curr_dg_45ft_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hub_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_locl_curr_ovr_45ft_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_dg_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cost_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_trsp_45ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_trsp_20ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mb_45ft_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_dg_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_locl_curr_ovr_20ft_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOUploadIHCCreationUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_TRF_IHC_RT A1" ).append("\n"); 
		query.append("      USING (" ).append("\n"); 
		query.append("             SELECT   @[svc_scp_cd] SVC_SCP_CD" ).append("\n"); 
		query.append("                     ,@[org_dest_tp_cd] ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     ,@[ihc_trf_no] IHC_TRF_NO                " ).append("\n"); 
		query.append("                     ,@[amdt_seq] AMDT_SEQ" ).append("\n"); 
		query.append("                     ,@[ihc_cgo_tp_cd] IHC_CGO_TP_CD  " ).append("\n"); 
		query.append("                     ,@[pnt_loc_cd] PNT_LOC_CD " ).append("\n"); 
		query.append("                     ,@[bse_port_loc_cd] BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                     ,@[hub_loc_cd] HUB_LOC_CD" ).append("\n"); 
		query.append("                     ,@[rcv_de_term_cd] RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                     ,@[prc_trsp_mod_cd] PRC_TRSP_MOD_CD " ).append("\n"); 
		query.append("                     ,@[gline_20ft_frt_rt_amt] GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                     ,@[gline_40ft_frt_rt_amt] GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                     ,@[gline_45ft_frt_rt_amt] GLINE_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                     ,@[gline_locl_curr_20ft_amt] GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("                     ,@[gline_locl_curr_40ft_amt] GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("                     ,@[gline_locl_curr_45ft_amt] GLINE_LOCL_CURR_45FT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                     ,NVL((SELECT MAX(RT_SEQ) " ).append("\n"); 
		query.append("                            FROM PRI_TRF_IHC_RT    " ).append("\n"); 
		query.append("                           WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("                             AND ORG_DEST_TP_CD = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("                             AND IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("                             AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND IHC_CGO_TP_CD = @[ihc_cgo_tp_cd] " ).append("\n"); 
		query.append("                        GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append("                                ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                ,IHC_TRF_NO                " ).append("\n"); 
		query.append("                                ,AMDT_SEQ" ).append("\n"); 
		query.append("                                ,IHC_CGO_TP_CD )  " ).append("\n"); 
		query.append("                          ,0)    RT_SEQ" ).append("\n"); 
		query.append("                     ,( SELECT RHQ_CD" ).append("\n"); 
		query.append("                          FROM PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("                         WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("                           AND ORG_DEST_TP_CD = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("                           AND IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("                       ) RHQ_CD" ).append("\n"); 
		query.append("               FROM DUAL       " ).append("\n"); 
		query.append("            ) A2" ).append("\n"); 
		query.append("      ON (    A1.SVC_SCP_CD      = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("          AND A1.ORG_DEST_TP_CD  = A2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          AND A1.IHC_TRF_NO      = A2.IHC_TRF_NO" ).append("\n"); 
		query.append("          AND A1.AMDT_SEQ        = A2.AMDT_SEQ" ).append("\n"); 
		query.append("          AND A1.IHC_CGO_TP_CD   = A2.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("          AND A1.PNT_LOC_CD      = A2.PNT_LOC_CD" ).append("\n"); 
		query.append("          AND A1.BSE_PORT_LOC_CD = A2.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("          AND NVL(A1.HUB_LOC_CD, 'N') = NVL(A2.HUB_LOC_CD, 'N')" ).append("\n"); 
		query.append("          AND A1.RCV_DE_TERM_CD  = A2.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("          AND A1.PRC_TRSP_MOD_CD = A2.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("          AND A1.OPTM_TRSP_MOD_FLG = 'Y' ) --Optimum flag가 'Y'인 것만 화면에서 조회되므로 'Y'인 것 기준으로 비교함" ).append("\n"); 
		query.append("      WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT " ).append("\n"); 
		query.append("                   (SVC_SCP_CD" ).append("\n"); 
		query.append("                   ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                   ,IHC_TRF_NO" ).append("\n"); 
		query.append("                   ,AMDT_SEQ" ).append("\n"); 
		query.append("                   ,IHC_CGO_TP_CD" ).append("\n"); 
		query.append("                   ,RT_SEQ" ).append("\n"); 
		query.append("                   ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   ,PNT_LOC_CD" ).append("\n"); 
		query.append("                   ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                   ,HUB_LOC_CD" ).append("\n"); 
		query.append("                   ,PNT_NOD_CD" ).append("\n"); 
		query.append("                   ,HUB_NOD_CD" ).append("\n"); 
		query.append("                   ,BSE_PORT_NOD_CD" ).append("\n"); 
		query.append("                   ,IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                   ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                   ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                   ,GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,LOCL_CURR_COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("                   ,TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("                   ,TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("                   ,MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("                   ,MTY_TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,TML_20FT_COST_AMT" ).append("\n"); 
		query.append("                   ,TML_40FT_COST_AMT" ).append("\n"); 
		query.append("                   ,TML_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,MB_20FT_RTO" ).append("\n"); 
		query.append("                   ,MB_40FT_RTO" ).append("\n"); 
		query.append("                   ,MB_45FT_RTO -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_DG_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,GLINE_OVR_WGT_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_OVR_WGT_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_OVR_WGT_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,ORG_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,ORG_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                   ,ORG_COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_45FT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_DG_20FT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_DG_40FT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_DG_45FT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_OVR_20FT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_OVR_40FT_AMT" ).append("\n"); 
		query.append("                   ,GLINE_LOCL_CURR_OVR_45FT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("                   ,OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("                   ,SRC_INFO_CD" ).append("\n"); 
		query.append("                   ,IHC_RT_RMK" ).append("\n"); 
		query.append("                   ,DCGO_SVC_FLG" ).append("\n"); 
		query.append("                   ,PRC_TRF_CRE_TP_CD" ).append("\n"); 
		query.append("                   ,CRE_USR_ID" ).append("\n"); 
		query.append("                   ,CRE_DT" ).append("\n"); 
		query.append("                   ,UPD_USR_ID" ).append("\n"); 
		query.append("                   ,UPD_DT" ).append("\n"); 
		query.append("                   ,LOCL_CURR_CD" ).append("\n"); 
		query.append("                   )      " ).append("\n"); 
		query.append("         VALUES" ).append("\n"); 
		query.append("           (@[svc_scp_cd]" ).append("\n"); 
		query.append("           ,@[org_dest_tp_cd]" ).append("\n"); 
		query.append("           ,@[ihc_trf_no]" ).append("\n"); 
		query.append("           ,@[amdt_seq]" ).append("\n"); 
		query.append("           ,@[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("           ,A2.RT_SEQ +1" ).append("\n"); 
		query.append("           ,0" ).append("\n"); 
		query.append("           ,@[pnt_loc_cd]" ).append("\n"); 
		query.append("           ,@[bse_port_loc_cd]" ).append("\n"); 
		query.append("           ,@[hub_loc_cd]" ).append("\n"); 
		query.append("           ,@[pnt_nod_cd]" ).append("\n"); 
		query.append("           ,@[hub_nod_cd]" ).append("\n"); 
		query.append("           ,@[bse_port_nod_cd]" ).append("\n"); 
		query.append("           ,@[ihc_cost_loc_grp_no]" ).append("\n"); 
		query.append("           ,@[rcv_de_term_cd]" ).append("\n"); 
		query.append("           ,@[prc_trsp_mod_cd]" ).append("\n"); 
		query.append("           ,@[gline_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,@[gline_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[gline_45ft_frt_rt_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[cost_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,@[cost_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[cost_45ft_frt_rt_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[locl_curr_cost_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,@[locl_curr_cost_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[locl_curr_cost_45ft_frt_rt_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[trsp_20ft_cost_amt]" ).append("\n"); 
		query.append("           ,@[trsp_40ft_cost_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[trsp_45ft_cost_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[mty_trsp_20ft_cost_amt]" ).append("\n"); 
		query.append("           ,@[mty_trsp_40ft_cost_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[mty_trsp_45ft_cost_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[tml_20ft_cost_amt]" ).append("\n"); 
		query.append("           ,@[tml_40ft_cost_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[tml_45ft_cost_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[mb_20ft_rto]" ).append("\n"); 
		query.append("           ,@[mb_40ft_rto]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[mb_45ft_rto], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[gline_dg_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,@[gline_dg_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[gline_dg_45ft_frt_rt_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[gline_ovr_wgt_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,@[gline_ovr_wgt_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[gline_ovr_wgt_45ft_frt_rt_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[org_cost_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,@[org_cost_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[org_cost_45ft_frt_rt_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[gline_locl_curr_20ft_amt]" ).append("\n"); 
		query.append("           ,@[gline_locl_curr_40ft_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[gline_locl_curr_45ft_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[gline_locl_curr_dg_20ft_amt]" ).append("\n"); 
		query.append("           ,@[gline_locl_curr_dg_40ft_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[gline_locl_curr_dg_45ft_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,@[gline_locl_curr_ovr_20ft_amt]" ).append("\n"); 
		query.append("           ,@[gline_locl_curr_ovr_40ft_amt]" ).append("\n"); 
		query.append("           ,DECODE(RHQ_CD, 'HAMRU', @[gline_locl_curr_ovr_45ft_amt], '') -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,'Y' -- 업로드 한 route는 optimum flag를 모두 'Y'로 해줌" ).append("\n"); 
		query.append("           ,'NW'" ).append("\n"); 
		query.append("           ,'Excel upload'" ).append("\n"); 
		query.append("           ,@[dcgo_svc_flg]" ).append("\n"); 
		query.append("           ,'G' -- 기존에 있던 route가 아닌 생성 route, term 일 경우는 'G'로 해줌" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[locl_curr_cd])" ).append("\n"); 
		query.append("       WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("            SET A1.GLINE_20FT_FRT_RT_AMT = A2.GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("              , A1.GLINE_40FT_FRT_RT_AMT = A2.GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("              , A1.GLINE_45FT_FRT_RT_AMT = DECODE(RHQ_CD, 'HAMRU', A2.GLINE_45FT_FRT_RT_AMT, '') -- 45' Cost 추가" ).append("\n"); 
		query.append("              -- LOC CURR에 대해 추가" ).append("\n"); 
		query.append("              , A1.GLINE_LOCL_CURR_20FT_AMT = A2.GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("              , A1.GLINE_LOCL_CURR_40FT_AMT = A2.GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("              , A1.GLINE_LOCL_CURR_45FT_AMT = A2.GLINE_LOCL_CURR_45FT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("              , A1.SRC_INFO_CD = 'NW', A1.PRC_TRF_CRE_TP_CD = DECODE(A1.PRC_TRF_CRE_TP_CD, 'G', 'G', 'X') -- 생성 route의 경우 엑셀 업로드 후 code를 X로 업데이트 하지 않는다." ).append("\n"); 
		query.append("              , A1.IHC_RT_RMK = 'Excel upload',A1.UPD_USR_ID = @[upd_usr_id], A1.UPD_DT = SYSDATE" ).append("\n"); 

	}
}