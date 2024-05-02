/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvEffFilingVOUSQL.java
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

public class SCNoteConversionProposalDBDAOPriScNoteConvEffFilingVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * filing시 변경 note가 amend 된 데이터만 변경한다.
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvEffFilingVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvEffFilingVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SC_NOTE_CONV CONV SET" ).append("\n"); 
		query.append("       EFF_DT = TO_DATE(@[file_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("WHERE NOTE_CONV_MAPG_ID IN (" ).append("\n"); 
		query.append("			                SELECT   NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("			                FROM     PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("			                WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			                     AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			                     AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			                UNION ALL" ).append("\n"); 
		query.append("			                SELECT   NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("			                FROM     PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("			                WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			                     AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			                     AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			                UNION ALL" ).append("\n"); 
		query.append("			                SELECT   NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("			                FROM     PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("			                WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			                     AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			                     AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("AND (TO_CHAR(EFF_DT, 'yyyyMMdd') < @[file_dt]" ).append("\n"); 
		query.append("     OR (TO_CHAR(EFF_DT, 'yyyyMMdd') > @[file_dt] " ).append("\n"); 
		query.append("         AND TO_CHAR(EFF_DT, 'yyyyMMdd') =" ).append("\n"); 
		query.append("              (SELECT TO_CHAR(EFF_DT, 'yyyyMMdd')" ).append("\n"); 
		query.append("               FROM   PRI_SP_SCP_MN" ).append("\n"); 
		query.append("               WHERE  CONV.PROP_NO = PROP_NO" ).append("\n"); 
		query.append("               AND    CONV.AMDT_SEQ = AMDT_SEQ" ).append("\n"); 
		query.append("               AND    CONV.SVC_SCP_CD = SVC_SCP_CD" ).append("\n"); 
		query.append("               AND    CONV.EFF_DT = EFF_DT)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("AND NOTE_CONV_TP_CD <> 'T'" ).append("\n"); 

	}
}