/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchCustomerListByDMTSCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchCustomerListByDMTSCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT_SC_EXPT_ACT_CUST에 존재하는 Actual Customer 정보를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchCustomerListByDMTSCRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchCustomerListByDMTSCRSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD || LPAD(A.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("	, B.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("FROM DMT_SC_EXPT_ACT_CUST A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ		= B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND A.SC_EXPT_VER_SEQ = (SELECT /*+ INDEX_DESC(DMT_SC_EXPT_VER XPKDMT_SC_EXPT_VER) */   " ).append("\n"); 
		query.append("                                SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                           FROM DMT_SC_EXPT_VER " ).append("\n"); 
		query.append("                          WHERE PROP_NO = @[prop_no] " ).append("\n"); 
		query.append("                            AND ROWNUM = 1) " ).append("\n"); 

	}
}