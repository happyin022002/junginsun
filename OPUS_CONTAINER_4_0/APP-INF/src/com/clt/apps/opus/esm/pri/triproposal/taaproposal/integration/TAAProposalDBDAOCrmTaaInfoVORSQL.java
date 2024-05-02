/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAOCrmTaaInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.21 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOCrmTaaInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRM으로 전송하는 TAA 기본정보를 조회한다.
	  * </pre>
	  */
	public TAAProposalDBDAOCrmTaaInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_sts",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("taa_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOCrmTaaInfoVORSQL").append("\n"); 
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
		query.append("SELECT TM.TAA_PROP_NO" ).append("\n"); 
		query.append(", TM.AMDT_SEQ" ).append("\n"); 
		query.append(", TH.TAA_NO" ).append("\n"); 
		query.append(", TM.CTRT_CUST_CNT_CD || LPAD(TM.CTRT_CUST_SEQ, 6, '0') AS CTRT_CUST_CD" ).append("\n"); 
		query.append(", TM.SVC_SCP_CD" ).append("\n"); 
		query.append(", TO_CHAR(TM.EFF_DT,'YYYYMMDD')||'000000' AS EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(TM.EXP_DT,'YYYYMMDD')||'000000' AS EXP_DT" ).append("\n"); 
		query.append(", TM.RESPB_SREP_CD" ).append("\n"); 
		query.append(", TM.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(", @[taa_sts] AS TAA_STS" ).append("\n"); 
		query.append("FROM PRI_TAA_MN TM" ).append("\n"); 
		query.append(", PRI_TAA_HDR TH" ).append("\n"); 
		query.append("WHERE TM.TAA_PROP_NO = @[taa_prop_no]" ).append("\n"); 
		query.append("AND   TM.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   TH.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 

	}
}