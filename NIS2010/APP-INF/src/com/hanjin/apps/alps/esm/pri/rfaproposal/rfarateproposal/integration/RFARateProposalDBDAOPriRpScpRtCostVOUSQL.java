/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtCostVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.12 송민석
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

public class RFARateProposalDBDAOPriRpScpRtCostVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_sq_rt 테이블에 cost를 update한다.
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtCostVOUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_usd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtCostVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_RT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if (${cost_tp} == 'C')" ).append("\n"); 
		query.append("PRS_RESPB_CM_UC_AMT = @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append(", PRS_RESPB_CMPB_AMT = PROP_FRT_RT_AMT + PRS_SCG_AMT - @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("PRS_RESPB_OPFIT_UC_AMT = @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append(", PRS_RESPB_OPB_AMT = PROP_FRT_RT_AMT + PRS_SCG_AMT - @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  PROP_NO        = @[prop_no]" ).append("\n"); 
		query.append("AND  AMDT_SEQ       = @[amdt_seq]" ).append("\n"); 
		query.append("AND  SVC_SCP_CD       = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND  CMDT_HDR_SEQ   = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND  ROUT_SEQ       = @[rout_seq]" ).append("\n"); 
		query.append("AND  RT_SEQ         = @[rt_seq]" ).append("\n"); 

	}
}