/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyForMainVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.12.05 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtPtyForMainVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.12.05 OPUS Applied
	  * 2011.05.02 [CHM-201110601-01]
	  * [PRI] Solve the problem attachment file disppearing during S/C Contract Parties Information 
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyForMainVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_pty_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_ctrt_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_pty_sgn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_pty_sgn_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_val_sgm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyForMainVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_CTRT_PTY SET " ).append("\n"); 
		query.append("	PRC_CTRT_PTY_TP_CD    = @[prc_ctrt_pty_tp_cd]" ).append("\n"); 
		query.append(",	CUST_CNT_CD           = DECODE(@[prc_ctrt_pty_tp_cd],'C',@[cust_cnt_cd])" ).append("\n"); 
		query.append(",	CUST_SEQ              = DECODE(@[prc_ctrt_pty_tp_cd],'C',@[cust_seq])" ).append("\n"); 
		query.append(",	CTRT_CUST_VAL_SGM_CD  = DECODE(@[prc_ctrt_pty_tp_cd],'C',@[ctrt_cust_val_sgm_cd])" ).append("\n"); 
		query.append(",	CTRT_CUST_SREP_CD     = DECODE(@[prc_ctrt_pty_tp_cd],'C',@[ctrt_cust_srep_cd])" ).append("\n"); 
		query.append(",	CTRT_CUST_SLS_OFC_CD  = DECODE(@[prc_ctrt_pty_tp_cd],'C',@[ctrt_cust_sls_ofc_cd])" ).append("\n"); 
		query.append(",	CTRT_PTY_NM           = @[ctrt_pty_nm]" ).append("\n"); 
		query.append(",	CTRT_PTY_ADDR         = @[ctrt_pty_addr]" ).append("\n"); 
		query.append(",	CTRT_PTY_SGN_NM       = @[ctrt_pty_sgn_nm]" ).append("\n"); 
		query.append(",	CTRT_PTY_SGN_TIT_NM   = @[ctrt_pty_sgn_tit_nm]" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD       = NVL(@[prc_prog_sts_cd],prc_prog_sts_cd)" ).append("\n"); 
		query.append(",	SRC_INFO_CD           = NVL(@[src_info_cd],src_info_cd)" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ     = NVL(@[n1st_cmnc_amdt_seq],N1ST_CMNC_AMDT_SEQ )" ).append("\n"); 
		query.append(",	ACPT_USR_ID           = @[acpt_usr_id]" ).append("\n"); 
		query.append(",	ACPT_OFC_CD           = @[acpt_ofc_cd]" ).append("\n"); 
		query.append(",	ACPT_DT               = TO_DATE(@[acpt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	UPD_USR_ID            = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT                = SYSDATE" ).append("\n"); 
		query.append("WHERE    " ).append("\n"); 
		query.append("    PROP_NO             = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ            = @[amdt_seq]" ).append("\n"); 
		query.append("AND    PRC_CTRT_PTY_TP_CD  = @[prc_ctrt_pty_tp_cd]" ).append("\n"); 

	}
}