/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriSpHdrCreationTypeCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.12.18 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriSpHdrCreationTypeCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * proposal creation type code 조회
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriSpHdrCreationTypeCdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration ").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriSpHdrCreationTypeCdRSQL").append("\n"); 
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
		query.append("SELECT PRC_PROP_CRE_TP_CD" ).append("\n"); 
		query.append("FROM PRI_SP_HDR" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 

	}
}