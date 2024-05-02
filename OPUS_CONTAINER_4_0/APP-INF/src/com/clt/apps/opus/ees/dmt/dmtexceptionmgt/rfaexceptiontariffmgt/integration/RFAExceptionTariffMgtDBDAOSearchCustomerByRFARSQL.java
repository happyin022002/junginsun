/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchCustomerByRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchCustomerByRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request - Before Booking Request Detail 에 소속된 Actual Customer 정보를 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchCustomerByRFARSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchCustomerByRFARSQL").append("\n"); 
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
		query.append("SELECT	A.CUST_CNT_CD || LPAD(A.CUST_SEQ,  6, '0') AS CUST_CD" ).append("\n"); 
		query.append(",	B.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("FROM	PRI_RP_SCP_RT_ACT_CUST RP_ACT_CUST" ).append("\n"); 
		query.append("WHERE	RP_ACT_CUST.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#if(${amdt_seq} != '')" ).append("\n"); 
		query.append("AND	RP_ACT_CUST.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND RP_ACT_CUST.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("FROM 	PRI_RP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("WHERE 	PROP_NO = RP_ACT_CUST.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	CTRT_CUST_CNT_CD AS CUST_CNT_CD, CTRT_CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("FROM	PRI_RP_MN RP_MN" ).append("\n"); 
		query.append("WHERE	RP_MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#if(${amdt_seq} != '')" ).append("\n"); 
		query.append("AND RP_MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("FROM 	PRI_RP_MN" ).append("\n"); 
		query.append("WHERE 	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",	MDM_CUSTOMER B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ 		= B.CUST_SEQ" ).append("\n"); 

	}
}