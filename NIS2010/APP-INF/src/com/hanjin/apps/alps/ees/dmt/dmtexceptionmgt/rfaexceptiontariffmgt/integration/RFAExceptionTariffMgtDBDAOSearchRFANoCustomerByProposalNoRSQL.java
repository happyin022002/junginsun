/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchRFANoCustomerByProposalNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchRFANoCustomerByProposalNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal No. 로 해당 RFA No. 와 Customer 정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchRFANoCustomerByProposalNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchRFANoCustomerByProposalNoRSQL").append("\n"); 
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
		query.append("SELECT  A.RFA_NO" ).append("\n"); 
		query.append(", 	B.CTRT_CUST_CNT_CD || LPAD(B.CTRT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append(", 	C.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append(",	B.CTRT_CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    PRI_RP_HDR A" ).append("\n"); 
		query.append(", 	PRI_RP_MN B" ).append("\n"); 
		query.append(", 	MDM_CUSTOMER C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("#if(${amdt_seq} != '')" ).append("\n"); 
		query.append("AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.AMDT_SEQ = (SELECT MAX(AMDT_SEQ) FROM PRI_RP_MN WHERE PROP_NO = @[prop_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.CTRT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND B.CTRT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 

	}
}