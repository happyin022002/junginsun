/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltMainStsVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.05 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltMainStsVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Main의 상태를 조회한다.
	  * </pre>
	  */
	public SCProposalMainDBDAORsltMainStsVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltMainStsVORSQL").append("\n"); 
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
		query.append("SELECT MN.PROP_STS_CD " ).append("\n"); 
		query.append("      ,STS.INTG_CD_VAL_DP_DESC PROP_STS" ).append("\n"); 
		query.append("FROM PRI_SP_MN MN" ).append("\n"); 
		query.append("    ,COM_INTG_CD_DTL STS" ).append("\n"); 
		query.append("WHERE PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD = STS.INTG_CD_VAL_CTNT" ).append("\n"); 

	}
}