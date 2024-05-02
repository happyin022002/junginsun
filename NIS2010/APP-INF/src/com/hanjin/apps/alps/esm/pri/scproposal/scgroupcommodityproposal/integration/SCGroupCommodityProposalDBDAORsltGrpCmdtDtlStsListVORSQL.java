/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalDBDAORsltGrpCmdtDtlStsListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.01 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Byeon Young Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityProposalDBDAORsltGrpCmdtDtlStsListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCGroupCommodityProposalDBDAORsltGrpCmdtDtlStsListVORSQL
	  * </pre>
	  */
	public SCGroupCommodityProposalDBDAORsltGrpCmdtDtlStsListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityProposalDBDAORsltGrpCmdtDtlStsListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("dtl.prop_no         ," ).append("\n"); 
		query.append("dtl.amdt_seq        ," ).append("\n"); 
		query.append("dtl.svc_scp_cd      ," ).append("\n"); 
		query.append("dtl.grp_cmdt_seq     ," ).append("\n"); 
		query.append("dtl.grp_cmdt_dtl_seq" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_scp_grp_cmdt_dtl dtl," ).append("\n"); 
		query.append("pri_sp_scp_mn mn" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("mn.prop_no          = @[prop_no]" ).append("\n"); 
		query.append("AND mn.amdt_seq         = @[amdt_seq]" ).append("\n"); 
		query.append("AND mn.svc_scp_cd       = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND mn.prop_no          = dtl.prop_no" ).append("\n"); 
		query.append("AND mn.amdt_seq         = dtl.amdt_seq" ).append("\n"); 
		query.append("AND mn.svc_scp_cd       = dtl.svc_scp_cd" ).append("\n"); 
		query.append("AND dtl.n1st_cmnc_amdt_seq    = mn.amdt_seq" ).append("\n"); 
		query.append("AND dtl.prc_prog_sts_cd <> @[prc_prog_sts_cd]" ).append("\n"); 

	}
}