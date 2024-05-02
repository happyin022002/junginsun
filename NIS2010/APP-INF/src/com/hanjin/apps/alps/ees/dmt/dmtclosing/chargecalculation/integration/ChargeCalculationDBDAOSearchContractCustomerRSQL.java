/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchContractCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.05.16 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchContractCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchContractCustomerRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchContractCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchContractCustomerRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("         WHEN EXISTS (SELECT *" ).append("\n"); 
		query.append("        FROM   PRI_SP_HDR HDR" ).append("\n"); 
		query.append("             , PRI_SP_MN MN" ).append("\n"); 
		query.append("             , PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("             , MDM_CUSTOMER R" ).append("\n"); 
		query.append("             , MDM_CUSTOMER A" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    HDR.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("        AND    HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("        AND    MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("        AND    MN.AMDT_SEQ = (SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                FROM   PRI_SP_MN" ).append("\n"); 
		query.append("                WHERE  1=1" ).append("\n"); 
		query.append("                AND    PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                AND    PROP_STS_CD = MN.PROP_STS_CD )" ).append("\n"); 
		query.append("        AND    PTY.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("        AND    PTY.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND    PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("        AND    REAL_CUST_CNT_CD = R.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("        AND    REAL_CUST_SEQ = R.CUST_SEQ (+)" ).append("\n"); 
		query.append("        AND    PTY.CUST_CNT_CD = A.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("        AND    PTY.CUST_SEQ = A.CUST_SEQ(+)" ).append("\n"); 
		query.append("        AND    PTY.CUST_CNT_CD = 'US'" ).append("\n"); 
		query.append("        AND    PTY.CUST_SEQ = 67219 ) THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("       END CUST_YN" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}