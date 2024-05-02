/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPriSurchargeLastAccessDateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.21 송민석
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

public class SCRateProposalDBDAORsltPriSurchargeLastAccessDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    S/C Proposal/Amendment Surcharge View All
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPriSurchargeLastAccessDateVORSQL(){
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
		query.append("FileName : SCRateProposalDBDAORsltPriSurchargeLastAccessDateVORSQL").append("\n"); 
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
		query.append("SELECT GEN_SPCL_RT_TP_CD, TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD') CRE_YMD " ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_SCG_ROUT" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("#if( ${gen_spcl_rt_tp_cd} != 'B'   )" ).append("\n"); 
		query.append("    AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("GROUP BY  GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CUST_TYPE' , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("FROM  PRI_SP_CTRT_CUST_TP" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND AMDT_SEQ          =  @[amdt_seq]" ).append("\n"); 
		query.append("    AND PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 

	}
}