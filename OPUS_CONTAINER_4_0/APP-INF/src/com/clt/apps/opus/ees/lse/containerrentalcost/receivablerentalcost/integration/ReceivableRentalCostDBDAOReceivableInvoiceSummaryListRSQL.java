/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableInvoiceSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.11.20 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableInvoiceSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Rental Invoice Summary 내역을 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableInvoiceSummaryListRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableInvoiceSummaryListRSQL").append("\n"); 
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
		query.append("SELECT  NVL2(AGMT_SEQ, AGMT_CTY_CD||LPAD(AGMT_SEQ, 6,'0'), 'G.TTL') AS AGMT_NO," ).append("\n"); 
		query.append("AGMT_CTY_CD, AGMT_SEQ, RCV_RNTL_SEQ," ).append("\n"); 
		query.append("NVL(LSTM_CD, NVL2(AGMT_SEQ,'S.TTL',NULL)) AS LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD, LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("CNTR_CNT, COST_AMT, BIL_DYS," ).append("\n"); 
		query.append("NVL2(RCV_RNTL_SEQ, ROUND(CHG_RT_AMT/CNTR_CNT, 2), NULL) AS CHG_RT_AMT" ).append("\n"); 
		query.append("FROM   (SELECT  AGMT_CTY_CD, AGMT_SEQ, RCV_RNTL_SEQ," ).append("\n"); 
		query.append("LSTM_CD, CNTR_TPSZ_CD, LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("COUNT(DISTINCT CNTR_NO) AS CNTR_CNT," ).append("\n"); 
		query.append("SUM(COST_AMT + NVL(CR_AMT,0)) AS COST_AMT," ).append("\n"); 
		query.append("SUM(BIL_DYS) AS BIL_DYS," ).append("\n"); 
		query.append("SUM(CHG_RT_AMT) AS CHG_RT_AMT" ).append("\n"); 
		query.append("FROM   (SELECT  AGMT_CTY_CD, AGMT_SEQ, RCV_RNTL_SEQ," ).append("\n"); 
		query.append("LSTM_CD, CNTR_TPSZ_CD, CNTR_NO," ).append("\n"); 
		query.append("LSE_RCV_CHG_TP_CD, COST_AMT, CR_AMT," ).append("\n"); 
		query.append("BIL_DYS, CHG_RT_AMT" ).append("\n"); 
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
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != \"\")" ).append("\n"); 
		query.append("AND     RCV_RNTL_SEQ IN (SELECT RCV_RNTL_SEQ" ).append("\n"); 
		query.append("FROM   LSE_RCV_RNTL_CHG" ).append("\n"); 
		query.append("WHERE  INV_NO = @[inv_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY ROLLUP(AGMT_CTY_CD, AGMT_SEQ, RCV_RNTL_SEQ," ).append("\n"); 
		query.append("LSTM_CD, CNTR_TPSZ_CD, LSE_RCV_CHG_TP_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   LSE_RCV_CHG_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("OR     (RCV_RNTL_SEQ IS NULL" ).append("\n"); 
		query.append("AND     AGMT_SEQ IS NOT NULL)" ).append("\n"); 
		query.append("OR      AGMT_CTY_CD IS NULL" ).append("\n"); 
		query.append("ORDER BY AGMT_CTY_CD, AGMT_NO, RCV_RNTL_SEQ" ).append("\n"); 

	}
}