/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltNewRoutCaseNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
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

public class SCRateProposalDBDAORsltNewRoutCaseNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CmdtHdrSeq 구하기
	  * </pre>
	  */
	public SCRateProposalDBDAORsltNewRoutCaseNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_info_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_bat_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltNewRoutCaseNoRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(ROUT_CS_NO),0) +1 AS ROUT_CS_NO , @[para_info_ctnt] AS ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    select max(ROUT_CS_NO) AS ROUT_CS_NO" ).append("\n"); 
		query.append("    from PRI_PRS_ROUT_CS" ).append("\n"); 
		query.append("	WHERE ROUT_CS_CLSS_NO = @[prs_bat_id]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    select max(ROUT_CS_NO)" ).append("\n"); 
		query.append("    from PRI_PRS_USD_ROUT_CS_INFO " ).append("\n"); 
		query.append("    where ROUT_CS_SRC_DT = @[para_info_ctnt]  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}