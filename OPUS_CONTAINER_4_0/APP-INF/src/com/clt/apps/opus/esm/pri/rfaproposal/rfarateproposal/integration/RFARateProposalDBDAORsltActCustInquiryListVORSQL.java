/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalDBDAORsltActCustInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.24 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltActCustInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer 조회
	  * </pre>
	  */
	public RFARateProposalDBDAORsltActCustInquiryListVORSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltActCustInquiryListVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",LPAD(CUST_SEQ, 6, '0') AS CUST_SEQ" ).append("\n"); 
		query.append(",(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01719'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS PRC_PROG_STS_NM" ).append("\n"); 
		query.append(",SRC_INFO_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02198'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = SRC_INFO_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS SRC_INFO_NM" ).append("\n"); 
		query.append(",N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD) AS EFF_DT" ).append("\n"); 
		query.append(",(SELECT CASE" ).append("\n"); 
		query.append("WHEN M.AMDT_SEQ = A.AMDT_SEQ THEN" ).append("\n"); 
		query.append("TO_CHAR(M.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("WHEN M.EFF_DT <= N.EXP_DT THEN" ).append("\n"); 
		query.append("TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TO_CHAR(N.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("END AS EXP_DT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_MN M, PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("WHERE M.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND N.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND M.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND N.AMDT_SEQ = M.AMDT_SEQ - DECODE(@[amdt_seq], A.AMDT_SEQ, 0, 0, 0, 1)" ).append("\n"); 
		query.append("AND M.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND N.SVC_SCP_CD = A.SVC_SCP_CD) AS EXP_DT" ).append("\n"); 
		query.append(",ACPT_USR_ID" ).append("\n"); 
		query.append(",ACPT_OFC_CD" ).append("\n"); 
		query.append(",(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID AND ROWNUM = 1) || ' / ' || A.ACPT_OFC_CD AS ACPT_USR_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.ACPT_DT, 'YYYYMMDD') AS ACPT_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("ORDER BY CMDT_HDR_SEQ, ACT_CUST_SEQ" ).append("\n"); 

	}
}