/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAP 에서 지불, void, delete 되었을때 so 에 flag 및 기타정보 제공시 필요한 데이타 search
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	 MAX(TO_CHAR(SPH.PAY_DT,'YYYYMMDD')) AS PAY_DT" ).append("\n"); 
		query.append("	,SIH.PAY_MZD_LU_CD                   AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append("    ,SUM(SPD.PAY_AMT)                    AS PAY_AMT" ).append("\n"); 
		query.append("FROM  SAP_INV_HDR SIH" ).append("\n"); 
		query.append("	,SAP_PAY_HDR SPH " ).append("\n"); 
		query.append("	,SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("WHERE SPH.PAY_SEQ = SPD.PAY_SEQ" ).append("\n"); 
		query.append("AND   SIH.INV_SEQ = SPD.INV_SEQ" ).append("\n"); 
		query.append("AND   SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("GROUP BY SIH.INV_NO, SIH.PAY_MZD_LU_CD" ).append("\n"); 

	}
}