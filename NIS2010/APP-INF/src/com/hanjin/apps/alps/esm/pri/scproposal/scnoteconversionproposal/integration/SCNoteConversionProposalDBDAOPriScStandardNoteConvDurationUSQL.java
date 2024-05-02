/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScStandardNoteConvDurationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.05.24 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SUNGMIN CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScStandardNoteConvDurationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * stanard note duration update 시 conversion duration update
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScStandardNoteConvDurationUSQL(){
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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScStandardNoteConvDurationUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SC_NOTE_CONV SET	" ).append("\n"); 
		query.append("	   EFF_DT					= CASE WHEN ((TO_CHAR(EFF_DT,'YYYY-MM-DD') > @[eff_dt] AND TO_CHAR(EFF_DT,'YYYY-MM-DD') < @[exp_dt] " ).append("\n"); 
		query.append("	                                          AND TO_CHAR(EFF_DT,'YYYY-MM-DD') != @[eff_dt_hidden]) OR TO_CHAR(EFF_DT,'YYYY-MM-DD') = '9999-12-31' ) " ).append("\n"); 
		query.append("        	                           THEN EFF_DT" ).append("\n"); 
		query.append("        	                           WHEN (TO_CHAR(EFF_DT,'YYYY-MM-DD') = @[eff_dt_hidden])" ).append("\n"); 
		query.append("        	                           THEN TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("			                           ELSE TO_DATE(@[eff_dt],'YYYY-MM-DD') END	                               " ).append("\n"); 
		query.append("	 , EXP_DT					= CASE WHEN ((TO_CHAR(EXP_DT,'YYYY-MM-DD') < @[exp_dt] AND TO_CHAR(EXP_DT,'YYYY-MM-DD') > @[eff_dt] " ).append("\n"); 
		query.append("	                                          AND TO_CHAR(EXP_DT,'YYYY-MM-DD') != @[exp_dt_hidden]) OR TO_CHAR(EXP_DT,'YYYY-MM-DD') = '9999-12-31' )  " ).append("\n"); 
		query.append("        	                           THEN EXP_DT" ).append("\n"); 
		query.append("        	                           WHEN (TO_CHAR(EXP_DT,'YYYY-MM-DD') = @[exp_dt_hidden])" ).append("\n"); 
		query.append("        	                           THEN TO_DATE(@[exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("        	                           ELSE TO_DATE(@[exp_dt],'YYYY-MM-DD') END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE NOTE_CONV_MAPG_ID IN (" ).append("\n"); 
		query.append("                    		SELECT NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                    		  FROM PRI_SG_STND_NOTE_CTNT" ).append("\n"); 
		query.append("                    		 WHERE SVC_SCP_CD 				= @[svc_scp_cd]" ).append("\n"); 
		query.append("                    		   AND NOTE_HDR_SEQ 			= @[note_hdr_seq]" ).append("\n"); 
		query.append("                    	   )" ).append("\n"); 

	}
}