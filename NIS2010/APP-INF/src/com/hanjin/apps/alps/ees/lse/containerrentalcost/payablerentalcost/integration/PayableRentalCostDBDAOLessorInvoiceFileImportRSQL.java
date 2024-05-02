/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostDBDAOLessorInvoiceFileImportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.23 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOLessorInvoiceFileImportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Rental Charge 생성을 위한 Lessor Invoice File 의 저장된 데이터를 조회.
	  * </pre>
	  */
	public PayableRentalCostDBDAOLessorInvoiceFileImportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOLessorInvoiceFileImportRSQL").append("\n"); 
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
		query.append("SELECT PAY_IMP_SEQ" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append(", DTL_SEQ" ).append("\n"); 
		query.append(", AGMT_CTY_CD" ).append("\n"); 
		query.append(", AGMT_SEQ" ).append("\n"); 
		query.append(", LSE_CTRT_NO" ).append("\n"); 
		query.append(", CO_COST_YRMON" ).append("\n"); 
		query.append(", INV_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", TO_CHAR(ONH_DT,  'YYYYMMDD') AS ONH_DT" ).append("\n"); 
		query.append(", TO_CHAR(OFFH_DT, 'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append(", ONH_LOC_CD" ).append("\n"); 
		query.append(", OFFH_LOC_CD" ).append("\n"); 
		query.append(", CHG_FREE_DYS" ).append("\n"); 
		query.append(", PD_RT_AMT" ).append("\n"); 
		query.append(", TTL_COST_AMT" ).append("\n"); 
		query.append(", CR_AMT" ).append("\n"); 
		query.append(", CR_NO" ).append("\n"); 
		query.append(", COST_DYS" ).append("\n"); 
		query.append(", BIL_DYS" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append("FROM   LSE_PAY_RNTL_CHG_CO" ).append("\n"); 
		query.append("WHERE  AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND    CO_COST_YRMON = @[co_cost_yrmon]" ).append("\n"); 

	}
}