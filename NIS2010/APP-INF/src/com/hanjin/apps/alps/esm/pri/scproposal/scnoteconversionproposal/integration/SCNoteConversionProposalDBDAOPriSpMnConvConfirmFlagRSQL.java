/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriSpMnConvConfirmFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.12.22 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriSpMnConvConfirmFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * conversion 입력 가능/불가 확인하는 쿼리
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriSpMnConvConfirmFlagRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriSpMnConvConfirmFlagRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN T.AMDT_SEQ = 0 THEN 'Y'" ).append("\n"); 
		query.append("WHEN T.BEF_CONV_CFM_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N' END AS WRITE_YN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT AMDT_SEQ" ).append("\n"); 
		query.append(", CONV_CFM_FLG" ).append("\n"); 
		query.append(", (SELECT CONV_CFM_FLG" ).append("\n"); 
		query.append("FROM PRI_SP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO 	= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ -1 ) BEF_CONV_CFM_FLG" ).append("\n"); 
		query.append("FROM PRI_SP_MN A" ).append("\n"); 
		query.append("WHERE PROP_NO 	= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}