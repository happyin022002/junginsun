/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchSCNoCustomerByProposalNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchSCNoCustomerByProposalNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal No. 로 해당 SC No. 와 Customer 정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchSCNoCustomerByProposalNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchSCNoCustomerByProposalNoRSQL").append("\n"); 
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
		query.append("SELECT  SP_HDR.SC_NO" ).append("\n"); 
		query.append(",       SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append(",       SP_PTY.CUST_SEQ" ).append("\n"); 
		query.append(",       CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append(",       PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append(",       MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   SP_HDR.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND SP_HDR.PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("AND SP_PTY.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */ AMDT_SEQ" ).append("\n"); 
		query.append("FROM    PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE   PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND SP_PTY.CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND SP_PTY.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 

	}
}