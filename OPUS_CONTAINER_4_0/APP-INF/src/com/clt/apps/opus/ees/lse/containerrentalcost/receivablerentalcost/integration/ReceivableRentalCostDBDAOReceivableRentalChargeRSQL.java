/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableRentalChargeRSQL.java
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

public class ReceivableRentalCostDBDAOReceivableRentalChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Rental Charge Creation 내역을 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableRentalChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_rntl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableRentalChargeRSQL").append("\n"); 
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
		query.append("SELECT  COST_YRMON, AGMT_CTY_CD, AGMT_SEQ, RCV_RNTL_SEQ," ).append("\n"); 
		query.append("QTY_YRMON, LSE_CNTR_CHG_STS_CD," ).append("\n"); 
		query.append("DECODE(LSE_CNTR_CHG_STS_CD, 'N','', CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("DECODE(LSE_CNTR_CHG_STS_CD, 'N','', TTL_CHG_AMT) AS TTL_CHG_AMT," ).append("\n"); 
		query.append("DECODE(LSE_CNTR_CHG_STS_CD, 'N','', CR_AMT) AS CR_AMT" ).append("\n"); 
		query.append("FROM    LSE_RCV_RNTL_CHG" ).append("\n"); 
		query.append("WHERE   COST_YRMON   = @[cost_yrmon]" ).append("\n"); 
		query.append("AND     AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("#if (${rcv_rntl_seq} != \"\")" ).append("\n"); 
		query.append("AND     RCV_RNTL_SEQ = @[rcv_rntl_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}