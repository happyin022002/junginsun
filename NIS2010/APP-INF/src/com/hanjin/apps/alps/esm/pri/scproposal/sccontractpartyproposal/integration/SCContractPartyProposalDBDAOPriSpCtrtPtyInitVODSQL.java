/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyInitVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.08 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtPtyInitVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Init Cancel시 데이터 삭제
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyInitVODSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration ").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyInitVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}