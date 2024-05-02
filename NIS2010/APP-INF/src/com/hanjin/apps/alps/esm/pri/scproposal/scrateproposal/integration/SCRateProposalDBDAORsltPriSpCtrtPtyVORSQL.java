/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPriSpCtrtPtyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.03 송민석
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

public class SCRateProposalDBDAORsltPriSpCtrtPtyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPriSpCtrtPtyVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltPriSpCtrtPtyVORSQL").append("\n"); 
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
		query.append("SELECT NVL(A.REAL_CUST_CNT_CD, B.CUST_CNT_CD) CUST_CNT_CD, NVL(REAL_CUST_SEQ,B.CUST_SEQ ) CUST_SEQ" ).append("\n"); 
		query.append("	   ,B.PROP_NO, B.AMDT_SEQ, B.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("	   ,B.CTRT_CUST_VAL_SGM_CD, B.CTRT_CUST_SREP_CD, B.CTRT_CUST_SLS_OFC_CD, B.CTRT_PTY_NM" ).append("\n"); 
		query.append("       , B.CTRT_PTY_ADDR, B.CTRT_PTY_SGN_NM, B.CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("	   ,B.PRC_PROG_STS_CD, B.SRC_INFO_CD, B.N1ST_CMNC_AMDT_SEQ, B.ACPT_USR_ID" ).append("\n"); 
		query.append("	   , B.ACPT_OFC_CD, B.ACPT_DT, B.CRE_USR_ID, B.CRE_DT, B.UPD_USR_ID, B.UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_SP_CTRT_PTY B, PRI_SP_MN A " ).append("\n"); 
		query.append(" WHERE A.PROP_NO =  @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.PROP_NO = B.PROP_NO " ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ " ).append("\n"); 
		query.append("   AND PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 

	}
}