/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteCpChkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.01.08 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAOPriSpScpNoteCpChkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copy할 데이터가 존재하는지 확인하는 쿼리
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteCpChkVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteCpChkVORSQL").append("\n"); 
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
		query.append("SELECT A.NOTE_SEQ" ).append("\n"); 
		query.append("FROM PRI_SG_STND_NOTE A," ).append("\n"); 
		query.append("(  SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", NOTE_HDR_SEQ" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", NOTE_HDR_SEQ" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY EFF_DT DESC, PRC_CUST_TP_CD ASC) CHECK_VALUE" ).append("\n"); 
		query.append("FROM PRI_SG_STND_NOTE_HDR" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD	= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND (PRC_CUST_TP_CD = @[prc_cust_tp_cd] OR PRC_CUST_TP_CD IS NULL)" ).append("\n"); 
		query.append("AND CFM_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt],'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CHECK_VALUE = 1 ) B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD 		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.NOTE_HDR_SEQ 		= B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 

	}
}