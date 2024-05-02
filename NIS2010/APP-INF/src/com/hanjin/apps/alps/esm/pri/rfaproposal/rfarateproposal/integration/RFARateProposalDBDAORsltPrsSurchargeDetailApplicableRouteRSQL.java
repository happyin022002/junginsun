/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.29 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Applicable Rout List  ( UI_PRI_6018, UC-PRI-062 )
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL").append("\n"); 
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
		query.append("select 	pri_rout.prop_no, pri_rout.amdt_seq, pri_rout.svc_scp_cd," ).append("\n"); 
		query.append("pri_rout.cmdt_hdr_seq, pri_rout.rout_seq, pri_rout.rt_seq," ).append("\n"); 
		query.append("pri_rout.por_cd, pri_rout.pol_cd, pri_rout.pod_cd, pri_rout.del_cd," ).append("\n"); 
		query.append("pri_rout.rcv_term_cd, pri_rout.de_term_cd,pri_rout.cre_dt," ).append("\n"); 
		query.append("to_char(pri_rout.cre_dt,'yyyy-mm-dd') cre_ymd, pri_rout.rcv_term_cd, pri_rout.de_term_cd," ).append("\n"); 
		query.append("( 	select com_cd.intg_cd_val_dp_desc" ).append("\n"); 
		query.append("from com_intg_cd_dtl com_cd" ).append("\n"); 
		query.append("where com_cd.intg_cd_id = 'CD02138'" ).append("\n"); 
		query.append("and com_cd.intg_cd_val_ctnt = pri_rout.rcv_term_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("|| '-' ||" ).append("\n"); 
		query.append("( 	select com_cd.intg_cd_val_dp_desc" ).append("\n"); 
		query.append("from com_intg_cd_dtl com_cd" ).append("\n"); 
		query.append("where com_cd.intg_cd_id = 'CD02138'" ).append("\n"); 
		query.append("and com_cd.intg_cd_val_ctnt = pri_rout.de_term_cd" ).append("\n"); 
		query.append(")  as rd_term_cd" ).append("\n"); 
		query.append("from pri_rp_scp_rt_scg_rout pri_rout" ).append("\n"); 
		query.append("where   prop_no = @[prop_no]" ).append("\n"); 
		query.append("and amdt_seq = @[amdt_seq]" ).append("\n"); 
		query.append("and svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("and cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("and rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("and rt_seq = @[rt_seq]" ).append("\n"); 

	}
}