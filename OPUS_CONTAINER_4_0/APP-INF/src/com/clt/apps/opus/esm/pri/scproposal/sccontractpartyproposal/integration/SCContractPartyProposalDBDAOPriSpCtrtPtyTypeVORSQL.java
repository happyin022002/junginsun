/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.08 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtPtyTypeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * radio button data check
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyTypeVORSQL(){
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
		query.append("SELECT CD ," ).append("\n"); 
		query.append("NM ," ).append("\n"); 
		query.append("NVL((SELECT 1 FROM PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE PROP_NO   = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ  = @[amdt_seq]" ).append("\n"); 
		query.append("AND   PRC_CTRT_PTY_TP_CD = A.CD" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("),0)  RCNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT INTG_CD_VAL_CTNT AS CD," ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC NM" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01715'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ DESC" ).append("\n"); 
		query.append(") A" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyTypeVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}