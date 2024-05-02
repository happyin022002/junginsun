/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableInvoiceCancelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.30 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableInvoiceCancelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Rental Invoice Creation 자료를 취소합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableInvoiceCancelUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableInvoiceCancelUSQL").append("\n"); 
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
		query.append("UPDATE  LSE_RCV_RNTL_CHG A" ).append("\n"); 
		query.append("SET     LSE_CNTR_CHG_STS_CD = 'N'," ).append("\n"); 
		query.append("        INV_NO       = NULL," ).append("\n"); 
		query.append("		TTL_CHG_AMT  = 0," ).append("\n"); 
		query.append("		CR_AMT		 = 0," ).append("\n"); 
		query.append("        INV_AMT      = 0," ).append("\n"); 
		query.append("        INV_CRE_OFC_CD = NULL," ).append("\n"); 
		query.append("        INV_CRE_USR_ID = NULL," ).append("\n"); 
		query.append("        INV_CRE_DT   = NULL," ).append("\n"); 
		query.append("		INV_ISS_DT   = NULL," ).append("\n"); 
		query.append("		INV_DUE_DT   = NULL," ).append("\n"); 
		query.append("        SRC_IF_SEQ   = NULL," ).append("\n"); 
		query.append("        SRC_IF_DT    = NULL," ).append("\n"); 
		query.append("        UPD_USR_ID   = @[cre_usr_id]," ).append("\n"); 
		query.append("        UPD_DT       = SYSDATE," ).append("\n"); 
		query.append("		CUST_CNT_CD  = NULL," ).append("\n"); 
		query.append("		CUST_SEQ     = NULL," ).append("\n"); 
		query.append("		LOCL_XCH_RT  = NULL," ).append("\n"); 
		query.append("		LOCL_CURR_CD = NULL," ).append("\n"); 
		query.append("		LOCL_TAX_FLG = 'N'," ).append("\n"); 
		query.append("		CFM_FLG		 = 'N'," ).append("\n"); 
		query.append("		CFM_OFC_CD 	 = NULL," ).append("\n"); 
		query.append("		CFM_IF_FLG   = 'N'," ).append("\n"); 
		query.append("		CXL_INV_NO	 = @[inv_no]," ).append("\n"); 
		query.append("		CXL_USR_ID	 = @[cre_usr_id]," ).append("\n"); 
		query.append("		CXL_DT		 = SYSDATE," ).append("\n"); 
		query.append("		CXL_FLG		 = 'Y'" ).append("\n"); 
		query.append("WHERE   COST_YRMON   = @[cost_yrmon]" ).append("\n"); 
		query.append("AND		INV_NO		 = @[inv_no]" ).append("\n"); 
		query.append("AND     LSE_CNTR_CHG_STS_CD = 'I'" ).append("\n"); 

	}
}