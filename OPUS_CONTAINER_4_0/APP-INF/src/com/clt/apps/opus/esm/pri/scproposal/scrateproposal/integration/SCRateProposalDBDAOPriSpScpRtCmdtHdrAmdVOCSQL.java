/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtCmdtHdrAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtCmdtHdrAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCRateProposalDBDAOPriSpScpRtCmdtHdrAmdVOCSQL
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtCmdtHdrAmdVOCSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtCmdtHdrAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO pri_sp_scp_rt_cmdt_hdr(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("BLET_DP_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("prop_no             ," ).append("\n"); 
		query.append("amdt_seq+1          ," ).append("\n"); 
		query.append("svc_scp_cd          ," ).append("\n"); 
		query.append("gen_spcl_rt_tp_cd   ," ).append("\n"); 
		query.append("cmdt_hdr_seq        ," ).append("\n"); 
		query.append("n1st_cmnc_amdt_seq	," ).append("\n"); 
		query.append("blet_dp_seq			," ).append("\n"); 
		query.append("@[cre_usr_id]       ," ).append("\n"); 
		query.append("SYSDATE             ," ).append("\n"); 
		query.append("@[upd_usr_id]       ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_scp_rt_cmdt_hdr hdr" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no     = @[prop_no]" ).append("\n"); 
		query.append("AND amdt_seq    = @[amdt_seq]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_scp_rt" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no             = hdr.prop_no" ).append("\n"); 
		query.append("AND amdt_seq            = hdr.amdt_seq" ).append("\n"); 
		query.append("AND svc_scp_cd          = hdr.svc_scp_cd" ).append("\n"); 
		query.append("AND gen_spcl_rt_tp_cd   = hdr.gen_spcl_rt_tp_cd" ).append("\n"); 
		query.append("AND cmdt_hdr_seq        = hdr.cmdt_hdr_seq" ).append("\n"); 
		query.append("AND src_info_cd			<> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}