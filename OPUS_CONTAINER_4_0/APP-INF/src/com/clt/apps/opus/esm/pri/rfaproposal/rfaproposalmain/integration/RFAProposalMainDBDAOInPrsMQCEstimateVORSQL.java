/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAProposalMainDBDAOInPrsMQCEstimateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.11 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOInPrsMQCEstimateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Input parameter VO 
	  * </pre>
	  */
	public RFAProposalMainDBDAOInPrsMQCEstimateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOInPrsMQCEstimateVORSQL").append("\n"); 
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
		query.append("	'' AS frm_prop_no" ).append("\n"); 
		query.append("	,'' AS frm_amdt_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}