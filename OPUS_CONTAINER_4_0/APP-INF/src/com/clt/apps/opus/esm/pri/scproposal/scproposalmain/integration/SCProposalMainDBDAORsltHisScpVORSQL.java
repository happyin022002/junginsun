/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAORsltHisScpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.02 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltHisScpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCProposalMainDBDAO
	  * </pre>
	  */
	public SCProposalMainDBDAORsltHisScpVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration ").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltHisScpVORSQL").append("\n"); 
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
		query.append("SELECT SCPMN.SVC_SCP_CD CD" ).append("\n"); 
		query.append(",MDM.SVC_SCP_NM NM" ).append("\n"); 
		query.append("FROM   (SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append("FROM            PRI_SP_SCP_MN" ).append("\n"); 
		query.append("WHERE           PROP_NO = @[prop_no]) SCPMN" ).append("\n"); 
		query.append(",MDM_SVC_SCP MDM" ).append("\n"); 
		query.append("WHERE  SCPMN.SVC_SCP_CD = MDM.SVC_SCP_CD" ).append("\n"); 
		query.append("AND    MDM.DELT_FLG = 'N'" ).append("\n"); 

	}
}