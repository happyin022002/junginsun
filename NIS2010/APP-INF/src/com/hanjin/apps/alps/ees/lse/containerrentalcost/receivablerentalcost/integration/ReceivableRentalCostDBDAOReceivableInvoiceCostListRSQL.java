/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableInvoiceCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.11.20 장준우
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

public class ReceivableRentalCostDBDAOReceivableInvoiceCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Rental Invoice Cost 목록을 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableInvoiceCostListRSQL(){
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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableInvoiceCostListRSQL").append("\n"); 
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
		query.append("SELECT  COST_YRMON, AGMT_CTY_CD, AGMT_SEQ," ).append("\n"); 
		query.append("RCV_RNTL_SEQ, RCV_RNTL_DTL_SEQ," ).append("\n"); 
		query.append("AGMT_CTY_CD||LPAD(AGMT_SEQ, 6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("LSTM_CD, CNTR_NO, CNTR_TPSZ_CD, LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(ONH_DT, 'YYYYMMDD') AS ONH_DT, ONH_LOC_CD," ).append("\n"); 
		query.append("TO_CHAR(OFFH_DT,'YYYYMMDD') AS OFFH_DT, OFFH_LOC_CD," ).append("\n"); 
		query.append("TTL_DYS, FREE_DYS, BIL_DYS, CHG_RT_AMT, COST_AMT, CR_AMT," ).append("\n"); 
		query.append("BIL_FM_DT, BIL_TO_DT, LSE_RCV_CHG_CRE_CD, AUTO_INP_FLG" ).append("\n"); 
		query.append("FROM    LSE_RCV_RNTL_CHG_DTL" ).append("\n"); 
		query.append("WHERE   LSE_RCV_CHG_CRE_CD != 'D'" ).append("\n"); 
		query.append("AND     COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("#if (${rcv_rntl_seq} != \"\")" ).append("\n"); 
		query.append("AND     RCV_RNTL_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${rcv_rntl_no_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $rcv_rntl_no_seq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${inv_no} != \"\")" ).append("\n"); 
		query.append("AND     RCV_RNTL_SEQ IN (SELECT RCV_RNTL_SEQ" ).append("\n"); 
		query.append("FROM   LSE_RCV_RNTL_CHG" ).append("\n"); 
		query.append("WHERE  INV_NO = @[inv_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}