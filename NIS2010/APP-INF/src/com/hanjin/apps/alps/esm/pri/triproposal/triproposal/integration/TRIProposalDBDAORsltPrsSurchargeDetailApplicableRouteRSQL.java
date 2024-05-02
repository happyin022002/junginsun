/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Applicable Rout List  ( UI_PRI_6085 )
	  * </pre>
	  */
	public TRIProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL").append("\n"); 
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
		query.append("select 	pri_rout.tri_prop_no, pri_rout.amdt_seq," ).append("\n"); 
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
		query.append("from pri_tri_rt_scg_rout pri_rout" ).append("\n"); 
		query.append("where   tri_prop_no = @[tri_prop_no]" ).append("\n"); 
		query.append("and amdt_seq = @[amdt_seq]" ).append("\n"); 

	}
}