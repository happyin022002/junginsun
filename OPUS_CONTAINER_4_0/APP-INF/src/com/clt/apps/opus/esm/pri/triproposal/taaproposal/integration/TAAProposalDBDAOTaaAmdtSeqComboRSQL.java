/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAOTaaAmdtSeqComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.27 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOTaaAmdtSeqComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TAA Main 의 Amdt Seq Combo Item을 조회한다.
	  * </pre>
	  */
	public TAAProposalDBDAOTaaAmdtSeqComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOTaaAmdtSeqComboRSQL").append("\n"); 
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
		query.append("SELECT TM.AMDT_SEQ" ).append("\n"); 
		query.append(", LPAD(TM.AMDT_SEQ, 3, '0') AS CD" ).append("\n"); 
		query.append(", TO_CHAR(TM.EFF_DT, 'YYYY-MM-DD') || ' ~ ' || TO_CHAR(TM.EXP_DT, 'YYYY-MM-DD') AS NM" ).append("\n"); 
		query.append("FROM PRI_TAA_HDR TH" ).append("\n"); 
		query.append(", PRI_TAA_MN TM" ).append("\n"); 
		query.append("WHERE TH.TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("AND   TM.TAA_PROP_NO = TH.TAA_PROP_NO" ).append("\n"); 
		query.append("ORDER BY TM.AMDT_SEQ DESC" ).append("\n"); 

	}
}