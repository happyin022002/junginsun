/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgAmdVOCSQL
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgAmdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO pri_sp_scp_trsp_add_chg(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("ADD_CHG_TP_CD," ).append("\n"); 
		query.append("ORG_DEST_TP_CD," ).append("\n"); 
		query.append("ADD_CHG_SEQ," ).append("\n"); 
		query.append("ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("LOC_GRD_CNT_CD," ).append("\n"); 
		query.append("LOC_GRD_CD," ).append("\n"); 
		query.append("BSE_PORT_TP_CD," ).append("\n"); 
		query.append("BSE_PORT_DEF_CD," ).append("\n"); 
		query.append("VIA_PORT_TP_CD," ).append("\n"); 
		query.append("VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("DIR_CALL_FLG," ).append("\n"); 
		query.append("RAT_UT_CD," ).append("\n"); 
		query.append("PRC_CGO_TP_CD," ).append("\n"); 
		query.append("PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("RCV_DE_TERM_CD," ).append("\n"); 
		query.append("PRC_CMDT_TP_CD," ).append("\n"); 
		query.append("PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("PROP_FRT_RT_AMT," ).append("\n"); 
		query.append("COFFR_FRT_RT_AMT," ).append("\n"); 
		query.append("FNL_FRT_RT_AMT," ).append("\n"); 
		query.append("GRI_APPL_TP_CD," ).append("\n"); 
		query.append("GRI_APPL_AMT," ).append("\n"); 
		query.append("ADD_CHG_NOTE_CTNT," ).append("\n"); 
		query.append("NOTE_DP_SEQ," ).append("\n"); 
		query.append("PRC_PROG_STS_CD," ).append("\n"); 
		query.append("SRC_INFO_CD," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("ACPT_USR_ID," ).append("\n"); 
		query.append("ACPT_OFC_CD," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("prop_no                 ," ).append("\n"); 
		query.append("amdt_seq+1              ," ).append("\n"); 
		query.append("svc_scp_cd              ," ).append("\n"); 
		query.append("add_chg_tp_cd           ," ).append("\n"); 
		query.append("org_dest_tp_cd          ," ).append("\n"); 
		query.append("add_chg_seq             ," ).append("\n"); 
		query.append("rout_pnt_loc_tp_cd      ," ).append("\n"); 
		query.append("rout_pnt_loc_def_cd     ," ).append("\n"); 
		query.append("loc_grd_cnt_cd          ," ).append("\n"); 
		query.append("loc_grd_cd              ," ).append("\n"); 
		query.append("bse_port_tp_cd          ," ).append("\n"); 
		query.append("bse_port_def_cd         ," ).append("\n"); 
		query.append("via_port_tp_cd          ," ).append("\n"); 
		query.append("via_port_def_cd         ," ).append("\n"); 
		query.append("dir_call_flg            ," ).append("\n"); 
		query.append("rat_ut_cd               ," ).append("\n"); 
		query.append("prc_cgo_tp_cd           ," ).append("\n"); 
		query.append("prc_trsp_mod_cd         ," ).append("\n"); 
		query.append("rcv_de_term_cd          ," ).append("\n"); 
		query.append("prc_cmdt_tp_cd          ," ).append("\n"); 
		query.append("prc_cmdt_def_cd         ," ).append("\n"); 
		query.append("curr_cd                 ," ).append("\n"); 
		query.append("PROP_FRT_RT_AMT," ).append("\n"); 
		query.append("COFFR_FRT_RT_AMT," ).append("\n"); 
		query.append("FNL_FRT_RT_AMT," ).append("\n"); 
		query.append("'N'          			," ).append("\n"); 
		query.append("0            			," ).append("\n"); 
		query.append("add_chg_note_ctnt		," ).append("\n"); 
		query.append("DECODE(ADD_CHG_NOTE_CTNT,null,null,NOTE_DP_SEQ)" ).append("\n"); 
		query.append("note_dp_seq				," ).append("\n"); 
		query.append("prc_prog_sts_cd         ," ).append("\n"); 
		query.append("src_info_cd             ," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ      ," ).append("\n"); 
		query.append("ACPT_USR_ID," ).append("\n"); 
		query.append("ACPT_OFC_CD," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("@[cre_usr_id]           ," ).append("\n"); 
		query.append("SYSDATE                 ," ).append("\n"); 
		query.append("@[upd_usr_id]           ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_scp_trsp_add_chg" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no     = @[prop_no]" ).append("\n"); 
		query.append("AND amdt_seq    = @[amdt_seq]" ).append("\n"); 
		query.append("AND src_info_cd <> 'AD'" ).append("\n"); 

	}
}