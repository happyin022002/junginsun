/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPriSurchargeAdjustListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.23 송민석
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

public class SCRateProposalDBDAORsltPriSurchargeAdjustListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRS-Surcharge Adjust 조회   
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPriSurchargeAdjustListVORSQL(){
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
		query.append("FileName : SCRateProposalDBDAORsltPriSurchargeAdjustListVORSQL").append("\n"); 
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
		query.append("WITH VW_SCG_ADJ AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO, " ).append("\n"); 
		query.append("	    AMDT_SEQ, " ).append("\n"); 
		query.append("	    SVC_SCP_CD, " ).append("\n"); 
		query.append("		GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("	    SCG_ADJ_SEQ, " ).append("\n"); 
		query.append("	    PRC_CMDT_TP_CD, " ).append("\n"); 
		query.append("	    PRC_CMDT_DEF_CD, " ).append("\n"); 
		query.append("	    ORG_LOC_TP_CD, " ).append("\n"); 
		query.append("	    ORG_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    ORG_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("	    ORG_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    DEST_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("	    DEST_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    DEST_LOC_TP_CD, " ).append("\n"); 
		query.append("	    DEST_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    PRC_RCV_TERM_CD, " ).append("\n"); 
		query.append("	    PRC_DE_TERM_CD, " ).append("\n"); 
		query.append("	    BKG_RAT_UT_CD, " ).append("\n"); 
		query.append("	    PRC_CGO_TP_CD, " ).append("\n"); 
		query.append("	    CHG_CD, " ).append("\n"); 
		query.append("	    CURR_CD, " ).append("\n"); 
		query.append("	    ADJ_SCG_AMT, " ).append("\n"); 
		query.append("	    ADJ_SCG_USD_AMT, " ).append("\n"); 
		query.append("	    CRE_USR_ID, " ).append("\n"); 
		query.append("	    CRE_DT, " ).append("\n"); 
		query.append("	    UPD_USR_ID, " ).append("\n"); 
		query.append("	    UPD_DT " ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_SCG_ADJ" ).append("\n"); 
		query.append("	WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	    AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	    AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("		AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	ORDER BY PRC_CMDT_DEF_CD,ORG_LOC_DEF_CD,ORG_VIA_LOC_DEF_CD,DEST_VIA_LOC_DEF_CD,DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("	ibflag," ).append("\n"); 
		query.append("    PROP_NO, " ).append("\n"); 
		query.append("    AMDT_SEQ, " ).append("\n"); 
		query.append("    SVC_SCP_CD, " ).append("\n"); 
		query.append("	GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("    SCG_ADJ_SEQ, " ).append("\n"); 
		query.append("    PRC_CMDT_TP_CD, " ).append("\n"); 
		query.append("    PRC_CMDT_DEF_CD, " ).append("\n"); 
		query.append("    ORG_LOC_TP_CD, " ).append("\n"); 
		query.append("    ORG_LOC_DEF_CD, " ).append("\n"); 
		query.append("    ORG_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("    ORG_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("    DEST_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("    DEST_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("    DEST_LOC_TP_CD, " ).append("\n"); 
		query.append("    DEST_LOC_DEF_CD, " ).append("\n"); 
		query.append("    PRC_RCV_TERM_CD, " ).append("\n"); 
		query.append("    PRC_DE_TERM_CD, " ).append("\n"); 
		query.append("    BKG_RAT_UT_CD, " ).append("\n"); 
		query.append("    PRC_CGO_TP_CD, " ).append("\n"); 
		query.append("    CHG_CD, " ).append("\n"); 
		query.append("    CURR_CD, " ).append("\n"); 
		query.append("    ADJ_SCG_AMT, " ).append("\n"); 
		query.append("    ADJ_SCG_USD_AMT, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT ," ).append("\n"); 
		query.append("	(SELECT CHG_NM FROM MDM_CHARGE MDM WHERE MDM.CHG_CD = M.CHG_CD) CHG_NM," ).append("\n"); 
		query.append("	RPLC_NOTE_CTNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT 'S' AS ibflag," ).append("\n"); 
		query.append("		PROP_NO, " ).append("\n"); 
		query.append("	    AMDT_SEQ, " ).append("\n"); 
		query.append("	    SVC_SCP_CD, " ).append("\n"); 
		query.append("		GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("	    SCG_ADJ_SEQ, " ).append("\n"); 
		query.append("	    PRC_CMDT_TP_CD, " ).append("\n"); 
		query.append("	    PRC_CMDT_DEF_CD, " ).append("\n"); 
		query.append("	    ORG_LOC_TP_CD, " ).append("\n"); 
		query.append("	    ORG_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    ORG_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("	    ORG_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    DEST_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("	    DEST_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    DEST_LOC_TP_CD, " ).append("\n"); 
		query.append("	    DEST_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    PRC_RCV_TERM_CD, " ).append("\n"); 
		query.append("	    PRC_DE_TERM_CD, " ).append("\n"); 
		query.append("	    BKG_RAT_UT_CD, " ).append("\n"); 
		query.append("	    PRC_CGO_TP_CD, " ).append("\n"); 
		query.append("	    CHG_CD, " ).append("\n"); 
		query.append("	    CURR_CD, " ).append("\n"); 
		query.append("	    ADJ_SCG_AMT, " ).append("\n"); 
		query.append("	    ADJ_SCG_USD_AMT, " ).append("\n"); 
		query.append("	    CRE_USR_ID, " ).append("\n"); 
		query.append("	    CRE_DT, " ).append("\n"); 
		query.append("	    UPD_USR_ID, " ).append("\n"); 
		query.append("	    UPD_DT ," ).append("\n"); 
		query.append("		'' AS RPLC_NOTE_CTNT" ).append("\n"); 
		query.append("	FROM VW_SCG_ADJ" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT 'I' AS ibflag," ).append("\n"); 
		query.append("		PROP_NO, " ).append("\n"); 
		query.append("	    AMDT_SEQ, " ).append("\n"); 
		query.append("	    SVC_SCP_CD, " ).append("\n"); 
		query.append("		GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("	    NULL AS SCG_ADJ_SEQ, " ).append("\n"); 
		query.append("	    NULL AS PRC_CMDT_TP_CD, " ).append("\n"); 
		query.append("	    NULL AS PRC_CMDT_DEF_CD, " ).append("\n"); 
		query.append("	    NULL AS ORG_LOC_TP_CD, " ).append("\n"); 
		query.append("	    NULL AS ORG_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    NULL AS ORG_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("	    NULL AS ORG_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    NULL AS DEST_VIA_LOC_TP_CD, " ).append("\n"); 
		query.append("	    NULL AS DEST_VIA_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    NULL AS DEST_LOC_TP_CD, " ).append("\n"); 
		query.append("	    NULL AS DEST_LOC_DEF_CD, " ).append("\n"); 
		query.append("	    NULL AS PRC_RCV_TERM_CD, " ).append("\n"); 
		query.append("	    NULL AS PRC_DE_TERM_CD, " ).append("\n"); 
		query.append("	    NULL AS BKG_RAT_UT_CD, " ).append("\n"); 
		query.append("	    NULL AS PRC_CGO_TP_CD, " ).append("\n"); 
		query.append("	    CHG_CD, " ).append("\n"); 
		query.append("	    'USD' AS CURR_CD, " ).append("\n"); 
		query.append("	    TO_NUMBER(NULL) AS ADJ_SCG_AMT, " ).append("\n"); 
		query.append("	    TO_NUMBER(NULL) AS ADJ_SCG_USD_AMT, " ).append("\n"); 
		query.append("	    NULL AS CRE_USR_ID, " ).append("\n"); 
		query.append("	    NULL AS CRE_DT, " ).append("\n"); 
		query.append("	    NULL AS UPD_USR_ID, " ).append("\n"); 
		query.append("	   NULL AS  UPD_DT ," ).append("\n"); 
		query.append("		RPLC_NOTE_CTNT " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("			SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD,UPPER(REPLACE(NOTE_CTNT ,' ' , '')) AS RPLC_NOTE_CTNT" ).append("\n"); 
		query.append("			FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("			WHERE (CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD) IN " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("                SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                FROM ( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                        FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                        WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                            AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                            AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                                AND CHG_CD IS NOT NULL" ).append("\n"); 
		query.append("                                AND CHG_CD NOT IN ('GRI', 'PSC','PSS')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                MINUS" ).append("\n"); 
		query.append("                SELECT CHG_CD, PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                FROM VW_SCG_ADJ" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ORDER BY ibflag DESC,PRC_CMDT_DEF_CD,ORG_LOC_DEF_CD,ORG_VIA_LOC_DEF_CD,DEST_VIA_LOC_DEF_CD,DEST_LOC_DEF_CD" ).append("\n"); 

	}
}