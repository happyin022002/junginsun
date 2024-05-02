/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCDurationProposalDBDAOPropCpPriSpDurCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.24 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCDurationProposalDBDAOPropCpPriSpDurCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Copy PRI_SP_DUR Insert
	  * </pre>
	  */
	public SCDurationProposalDBDAOPropCpPriSpDurCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.integration").append("\n"); 
		query.append("FileName : SCDurationProposalDBDAOPropCpPriSpDurCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_DUR (" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", CTRT_EFF_DT" ).append("\n"); 
		query.append(", CTRT_EXP_DT" ).append("\n"); 
		query.append(", PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", SRC_INFO_CD" ).append("\n"); 
		query.append(", N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_USR_ID)" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append(", 0 AS AMDT_SEQ" ).append("\n"); 
		query.append(", TO_DATE('99991231', 'YYYYMMDD') AS CTRT_EFF_DT" ).append("\n"); 
		query.append(", TO_DATE('99991231', 'YYYYMMDD') AS CTRT_EXP_DT" ).append("\n"); 
		query.append(", 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", 'PC' AS SRC_INFO_CD" ).append("\n"); 
		query.append(", 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM PRI_SP_DUR" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}