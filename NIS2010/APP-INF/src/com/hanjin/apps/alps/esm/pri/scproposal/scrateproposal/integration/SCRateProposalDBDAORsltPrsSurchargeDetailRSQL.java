/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPrsSurchargeDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltPrsSurchargeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Detail ( UI_PRI_6018, UC-PRI-062 )
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPrsSurchargeDetailRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltPrsSurchargeDetailRSQL").append("\n"); 
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
		query.append("select 	pri_scg.prop_no, pri_scg.amdt_seq, pri_scg.svc_scp_cd, pri_scg.gen_spcl_rt_tp_cd," ).append("\n"); 
		query.append("		pri_scg.cmdt_hdr_seq, pri_scg.rout_seq, pri_scg.rt_seq, pri_scg.chg_cd," ).append("\n"); 
		query.append("		pri_scg.bkg_rat_ut_cd, pri_scg.curr_cd, pri_scg.adj_scg_amt, pri_scg.adj_scg_usd_amt," ).append("\n"); 
		query.append("		pri_scg.trf_scg_amt, pri_scg.trf_scg_rmk,pri_scg.adj_flg," ).append("\n"); 
		query.append("		(SELECT CHG_NM FROM MDM_CHARGE MDM WHERE MDM.CHG_CD = pri_scg.CHG_CD) CHG_NM" ).append("\n"); 
		query.append("from pri_sp_scp_rt_scg pri_scg" ).append("\n"); 
		query.append("where   prop_no = @[prop_no]" ).append("\n"); 
		query.append("    and amdt_seq = @[amdt_seq]" ).append("\n"); 
		query.append("    and svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("    and gen_spcl_rt_tp_cd = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("    and cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("    and rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("    and rt_seq = @[rt_seq]" ).append("\n"); 

	}
}