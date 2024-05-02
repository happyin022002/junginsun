/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOModifySOInterfaceTRSUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.12 
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

public class AccountPayablePaymentDBDAOModifySOInterfaceTRSUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySOInterfaceTRS
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOModifySOInterfaceTRSUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOModifySOInterfaceTRSUSQL").append("\n"); 
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
		query.append("--UPDATE 		TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("--SET 		TRSP_INV_AUD_STS_CD  		= 'PD'" ).append("\n"); 
		query.append("--			,PAY_DT 					= TO_DATE(SUBSTR([PAY_DT],1,8),'YYYYMMDD')" ).append("\n"); 
		query.append("--			,INV_CHK_TRNS_NO			= [INV_CHK_TRNS_NO]" ).append("\n"); 
		query.append("--			,INV_PAY_MZD_CD 			= [INV_PAY_MZD_CD]" ).append("\n"); 
		query.append("--WHERE 		CSR_NO 						= [CSR_NO]" ).append("\n"); 
		query.append("UPDATE TRS_TRSP_INV_WRK A" ).append("\n"); 
		query.append("SET (A.TRSP_INV_AUD_STS_CD, A.PAY_DT, A.INV_PAY_MZD_CD)" ).append("\n"); 
		query.append("    = (" ).append("\n"); 
		query.append("       SELECT 'PD'" ).append("\n"); 
		query.append("             ,MAX(SPH.PAY_DT) PAY_DT" ).append("\n"); 
		query.append("             ,SIH.PAY_MZD_LU_CD" ).append("\n"); 
		query.append("       FROM  SAP_INV_HDR SIH" ).append("\n"); 
		query.append("            ,SAP_PAY_HDR SPH " ).append("\n"); 
		query.append("            ,SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("       WHERE SPH.PAY_SEQ = SPD.PAY_SEQ" ).append("\n"); 
		query.append("       AND   SIH.INV_SEQ = SPD.INV_SEQ" ).append("\n"); 
		query.append("       AND   SIH.INV_NO = A.CSR_NO" ).append("\n"); 
		query.append("       GROUP BY SIH.INV_NO, SIH.PAY_MZD_LU_CD" ).append("\n"); 
		query.append("      ) " ).append("\n"); 
		query.append("WHERE   A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND EXISTS  (" ).append("\n"); 
		query.append("              SELECT 'Y'" ).append("\n"); 
		query.append("              FROM  SAP_INV_HDR SIH" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("              AND SIH.INV_NO = A.CSR_NO              " ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}