/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOGlineCopyGetGlineSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.12 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOGlineCopyGetGlineSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Copy gline_seq Select
	  * </pre>
	  */
	public RFAProposalMainDBDAOGlineCopyGetGlineSeqRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOGlineCopyGetGlineSeqRSQL").append("\n"); 
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
		query.append("SELECT GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_MN A" ).append("\n"); 
		query.append(",PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   A.EFF_DT BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 

	}
}