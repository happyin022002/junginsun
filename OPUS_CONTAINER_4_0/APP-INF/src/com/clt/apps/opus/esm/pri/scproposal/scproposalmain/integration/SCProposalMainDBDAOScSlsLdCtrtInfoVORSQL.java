/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCProposalMainDBDAOScSlsLdCtrtInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOScSlsLdCtrtInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRM으로 전송하는 SC Sales Lead Contract Info 를 조회한다.
	  * </pre>
	  */
	public SCProposalMainDBDAOScSlsLdCtrtInfoVORSQL(){
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
		query.append("FileName : SCProposalMainDBDAOScSlsLdCtrtInfoVORSQL").append("\n"); 
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
		query.append("SELECT HD.PROP_NO" ).append("\n"); 
		query.append("     , HD.SC_NO" ).append("\n"); 
		query.append("     , MN.AMDT_SEQ" ).append("\n"); 
		query.append("     , PT.CUST_CNT_CD" ).append("\n"); 
		query.append("     , PT.CUST_SEQ" ).append("\n"); 
		query.append("     , PT.CUST_CNT_CD || LPAD(PT.CUST_SEQ, 6, '0') AS CUST_CODE" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EFF_DT, 'YYYYMMDD')||'000000' AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EXP_DT, 'YYYYMMDD')||'000000' AS EXP_DT" ).append("\n"); 
		query.append("     , MN.PROP_SREP_CD" ).append("\n"); 
		query.append("     , MN.PROP_OFC_CD" ).append("\n"); 
		query.append("     , MQ.FNL_MQC_QTY" ).append("\n"); 
		query.append("     , TO_CHAR(MN.FILE_DT, 'YYYYMMDD')||'000000' AS FILE_DT" ).append("\n"); 
		query.append("FROM PRI_SP_HDR HD" ).append("\n"); 
		query.append("   , PRI_SP_MN MN" ).append("\n"); 
		query.append("   , PRI_SP_CTRT_PTY PT" ).append("\n"); 
		query.append("   , PRI_SP_MQC MQ" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   PT.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   PT.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND   PT.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND   MQ.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   MQ.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 

	}
}