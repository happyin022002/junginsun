/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAOPriTaaNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.14 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOPriTaaNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TAA No List Select
	  * </pre>
	  */
	public TAAProposalDBDAOPriTaaNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOPriTaaNoListRSQL").append("\n"); 
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
		query.append("SELECT TH.TAA_NO" ).append("\n"); 
		query.append(", TM.TAA_PROP_NO" ).append("\n"); 
		query.append(", TM.AMDT_SEQ" ).append("\n"); 
		query.append(", TM.SVC_SCP_CD" ).append("\n"); 
		query.append(", TM.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(", TM.RESPB_SREP_CD" ).append("\n"); 
		query.append(", SR.SREP_NM AS RESPB_SREP_NM" ).append("\n"); 
		query.append(", TM.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(", TM.CTRT_CUST_SEQ" ).append("\n"); 
		query.append(", TM.CTRT_CUST_CNT_CD || LPAD(TM.CTRT_CUST_SEQ, 6, '0') AS CTRT_CUST_CD" ).append("\n"); 
		query.append(", CU.CUST_LGL_ENG_NM AS CTRT_CUST_NM" ).append("\n"); 
		query.append(", TO_CHAR(TM.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(TM.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("FROM PRI_TAA_MN TM" ).append("\n"); 
		query.append(", PRI_TAA_HDR TH" ).append("\n"); 
		query.append(", MDM_SLS_REP SR" ).append("\n"); 
		query.append(", MDM_CUSTOMER CU" ).append("\n"); 
		query.append("WHERE TH.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 
		query.append("AND   TM.AMDT_SEQ = (SELECT MAX(TA.AMDT_SEQ)" ).append("\n"); 
		query.append("FROM PRI_TAA_MN TA" ).append("\n"); 
		query.append("WHERE TA.TAA_PROP_NO = TM.TAA_PROP_NO)" ).append("\n"); 
		query.append("AND   SR.SREP_CD = TM.RESPB_SREP_CD" ).append("\n"); 
		query.append("AND   CU.CUST_CNT_CD = TM.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND   CU.CUST_SEQ = TM.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND   TM.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND   TM.CTRT_CUST_CNT_CD = @[ctrt_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_cust_seq} != '')" ).append("\n"); 
		query.append("AND   TM.CTRT_CUST_SEQ = @[ctrt_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TM.SVC_SCP_CD, TH.TAA_NO" ).append("\n"); 

	}
}