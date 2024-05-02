/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPriCheckSurchargeNoteListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.22 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltPriCheckSurchargeNoteListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRS-Surcharge Adjust 조회   
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPriCheckSurchargeNoteListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltPriCheckSurchargeNoteListVORSQL").append("\n"); 
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
		query.append("SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD,UPPER(REPLACE(NOTE_CTNT ,' ' , '')) AS RPLC_NOTE_CTNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("WHERE (CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD) IN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	FROM ( " ).append("\n"); 
		query.append("                SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                    AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                        AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                        AND CHG_CD IS NOT NULL" ).append("\n"); 
		query.append("                        AND CHG_CD NOT IN ('GRI', 'PSC','PSS')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("	MINUS" ).append("\n"); 
		query.append("	SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_SCG_ADJ" ).append("\n"); 
		query.append("	WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	    AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	    AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("		AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}