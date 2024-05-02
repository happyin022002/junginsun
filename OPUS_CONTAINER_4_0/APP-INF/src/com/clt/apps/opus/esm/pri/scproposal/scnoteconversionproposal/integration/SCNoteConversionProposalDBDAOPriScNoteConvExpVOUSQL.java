/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvExpVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.05.24 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvExpVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * duration 변경시 exp_dt를 변경한다.
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvExpVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvExpVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SC_NOTE_CONV A SET" ).append("\n"); 
		query.append("	   EXP_DT = TO_DATE(@[exp_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND (TO_CHAR(EXP_DT,'yyyy-MM-dd') >= (SELECT TO_CHAR(EXP_DT,'yyyy-MM-dd') FROM PRI_SP_SCP_MN " ).append("\n"); 
		query.append("			   						 WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("									 AND AMDT_SEQ = A.AMDT_SEQ " ).append("\n"); 
		query.append("									 AND SVC_SCP_CD = A.SVC_SCP_CD) " ).append("\n"); 
		query.append("	 OR TO_CHAR(EXP_DT,'yyyyMMdd') > @[exp_dt]" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}