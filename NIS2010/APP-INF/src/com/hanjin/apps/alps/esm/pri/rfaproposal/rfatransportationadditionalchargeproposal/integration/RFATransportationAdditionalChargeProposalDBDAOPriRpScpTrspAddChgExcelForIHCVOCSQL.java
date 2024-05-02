/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgExcelForIHCVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.26
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.26 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgExcelForIHCVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arbitrary For AEE/AEW, Arbitrary For Add-On Tariff   Load Excel
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgExcelForIHCVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_gline_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_pnt_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("add_chg_note_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_use_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rout_cmb_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgExcelForIHCVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_TRSP_ADD_CHG (" ).append("\n"); 
		query.append("    PROP_NO" ).append("\n"); 
		query.append("  , AMDT_SEQ" ).append("\n"); 
		query.append("  , SVC_SCP_CD" ).append("\n"); 
		query.append("  , ADD_CHG_TP_CD" ).append("\n"); 
		query.append("  , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("  , ADD_CHG_SEQ" ).append("\n"); 
		query.append("  , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("  , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("  , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("  , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("  , RAT_UT_CD" ).append("\n"); 
		query.append("  , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("  , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("  , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("  , MIN_CGO_WGT" ).append("\n"); 
		query.append("  , MAX_CGO_WGT" ).append("\n"); 
		query.append("  , CUST_CNT_CD" ).append("\n"); 
		query.append("  , CUST_SEQ" ).append("\n"); 
		query.append("  , CURR_CD" ).append("\n"); 
		query.append("  , PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("  , ADD_CHG_NOTE_CTNT" ).append("\n"); 
		query.append("  , NOTE_DP_SEQ" ).append("\n"); 
		query.append("  , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("  , SRC_INFO_CD" ).append("\n"); 
		query.append("  , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append("  , FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append("  , OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("  , FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("  , FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[prop_no]" ).append("\n"); 
		query.append("  , @[amdt_seq]" ).append("\n"); 
		query.append("  , @[svc_scp_cd]" ).append("\n"); 
		query.append("  , @[add_chg_tp_cd]" ).append("\n"); 
		query.append("  , @[org_dest_tp_cd]" ).append("\n"); 
		query.append("  , NVL((SELECT /*+ INDEX_DESC(A XPKPRI_RP_SCP_TRSP_ADD_CHG) */  ADD_CHG_SEQ" ).append("\n"); 
		query.append("       FROM PRI_RP_SCP_TRSP_ADD_CHG A" ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("        AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("        AND ADD_CHG_TP_CD  = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("        AND ORG_DEST_TP_CD  = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("        AND ROWNUM = 1), 0) + 1" ).append("\n"); 
		query.append("  , @[bse_port_tp_cd]" ).append("\n"); 
		query.append("  , @[bse_port_def_cd]" ).append("\n"); 
		query.append("  , @[rout_pnt_loc_tp_cd]" ).append("\n"); 
		query.append("  , @[rout_pnt_loc_def_cd]" ).append("\n"); 
		query.append("  , @[rat_ut_cd]" ).append("\n"); 
		query.append("  , @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append("  , @[prc_trsp_mod_cd]" ).append("\n"); 
		query.append("  , @[rcv_de_term_cd]" ).append("\n"); 
		query.append("  , @[min_cgo_wgt]" ).append("\n"); 
		query.append("  , @[max_cgo_wgt]" ).append("\n"); 
		query.append("  , @[cust_cnt_cd]" ).append("\n"); 
		query.append("  , @[cust_seq]" ).append("\n"); 
		query.append("  , @[curr_cd]" ).append("\n"); 
		query.append("  , @[prop_frt_rt_amt]" ).append("\n"); 
		query.append("  , @[add_chg_note_ctnt]" ).append("\n"); 
		query.append("  , @[note_dp_seq]" ).append("\n"); 
		query.append("  , 'I'" ).append("\n"); 
		query.append("  , 'NW'" ).append("\n"); 
		query.append("  , @[amdt_seq] " ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , sysdate" ).append("\n"); 
		query.append("  , @[upd_usr_id]" ).append("\n"); 
		query.append("  , sysdate" ).append("\n"); 
		query.append("  , @[fic_gline_rt_amt]" ).append("\n"); 
		query.append("  , TO_DATE(@[fic_gline_upd_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("  , NVL(@[optm_trsp_mod_flg], 'N')" ).append("\n"); 
		query.append("  , NVL(@[fic_rout_cmb_tp_cd], 'X')" ).append("\n"); 
		query.append("  , NVL(@[fic_rt_use_sts_cd], 'X')" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}