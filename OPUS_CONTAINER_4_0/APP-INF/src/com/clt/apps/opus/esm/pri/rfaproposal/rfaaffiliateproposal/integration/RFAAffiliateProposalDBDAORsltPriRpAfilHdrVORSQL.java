/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAAffiliateProposalDBDAORsltPriRpAfilHdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.12.04 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAAffiliateProposalDBDAORsltPriRpAfilHdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAM/DET화면에서 호출시 Proposal No.로 조회한다.
	  * </pre>
	  */
	public RFAAffiliateProposalDBDAORsltPriRpAfilHdrVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.integration").append("\n"); 
		query.append("FileName : RFAAffiliateProposalDBDAORsltPriRpAfilHdrVORSQL").append("\n"); 
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
		query.append("SELECT   A.RFA_NO" ).append("\n"); 
		query.append(",B.AMDT_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(B.CTRT_EFF_DT, 'yyyy-MM-dd') CTRT_EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(B.CTRT_EXP_DT, 'yyyy-MM-dd') CTRT_EXP_DT" ).append("\n"); 
		query.append("FROM     PRI_RP_HDR A" ).append("\n"); 
		query.append(", PRI_RP_DUR B" ).append("\n"); 
		query.append("WHERE    A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND      A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND      B.AMDT_SEQ = (SELECT /*+ INDEX_DESC(MN XPKPRI_RP_MN)*/  AMDT_SEQ" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    ROWNUM = 1)" ).append("\n"); 

	}
}