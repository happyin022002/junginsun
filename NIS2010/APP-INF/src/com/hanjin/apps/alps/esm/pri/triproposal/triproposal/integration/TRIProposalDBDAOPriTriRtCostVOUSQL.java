/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtCostVOUSQL.java
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

public class TRIProposalDBDAOPriTriRtCostVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_sq_rt 테이블에 cost를 update한다.
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtCostVOUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtCostVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRI_RT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if (${cost_tp} == 'C')" ).append("\n"); 
		query.append("PRS_RESPB_CM_UC_AMT = @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append(", PRS_RESPB_CMPB_AMT = PROP_FRT_RT_AMT + PRS_SCG_AMT - @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("PRS_RESPB_OPFIT_UC_AMT = @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append(", PRS_RESPB_OPB_AMT = PROP_FRT_RT_AMT + PRS_SCG_AMT - @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  TRI_PROP_NO        = @[tri_prop_no]" ).append("\n"); 
		query.append("AND  AMDT_SEQ       = @[amdt_seq]" ).append("\n"); 

	}
}