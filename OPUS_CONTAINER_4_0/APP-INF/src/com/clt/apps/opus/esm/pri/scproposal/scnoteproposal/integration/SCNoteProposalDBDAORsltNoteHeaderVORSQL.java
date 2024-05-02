/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteProposalDBDAORsltNoteHeaderVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.01.08 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAORsltNoteHeaderVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCNoteProposalDBDAORsltNoteHeaderVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAORsltNoteHeaderVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append(", B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01714'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = B.PRC_CUST_TP_CD) CUST_TP_DESC" ).append("\n"); 
		query.append(", B.NOTE_REF_YR" ).append("\n"); 
		query.append(", B.NOTE_NM" ).append("\n"); 
		query.append(", B.EFF_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN A" ).append("\n"); 
		query.append(", PRI_SG_STND_NOTE_HDR B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.NOTE_HDR_SEQ = B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("ORDER BY B.PRC_CUST_TP_CD ASC" ).append("\n"); 

	}
}