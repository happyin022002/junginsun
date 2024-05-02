/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAORsltStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.11
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.11 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C/Offer check
	  * </pre>
	  */
	public SCProposalMainDBDAORsltStatusVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltStatusVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_AFIL                WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_BLPL                WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_BLPL_CTNT           WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_CTRT_CUST_TP        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_CTRT_PTY            WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_DUR                 WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_MQC                 WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SUB_MQC             WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_DUR             WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_GOH_CHG         WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_GRP_CMDT_DTL    WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_GRP_LOC_DTL     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_LODG_AGN        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_MQC             WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_NOTE_CTNT       WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_ROUT_PNT        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT              WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ACT_CUST     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_CMDT         WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_CMDT_RNOTE   WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_CNOTE        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ROUT_DIR     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ROUT_PNT     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_RT_ROUT_VIA     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_SP_SCP_TRSP_ADD_CHG    WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1" ).append("\n"); 

	}
}