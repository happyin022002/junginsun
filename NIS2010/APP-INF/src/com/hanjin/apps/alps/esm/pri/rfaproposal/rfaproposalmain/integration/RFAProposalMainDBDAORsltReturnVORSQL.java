/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltReturnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltReturnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 TERMS에 RETURNED 데이터가 있는지 조회
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltReturnVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltReturnVORSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD,CNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append(",1 CNT" ).append("\n"); 
		query.append("FROM            PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE           PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND             AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND             PRC_PROG_STS_CD = 'R'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append(",1 CNT" ).append("\n"); 
		query.append("FROM            PRI_RP_SCP_RT" ).append("\n"); 
		query.append("WHERE           PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND             AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND             PRC_PROG_STS_CD = 'R'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}