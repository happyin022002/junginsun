/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableRentalChargeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.03.08 장준우
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

public class ReceivableRentalCostDBDAOReceivableRentalChargeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약번호별 Receivable Rental Charge Creation 자료를 개별 갱신합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableRentalChargeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ReceivableRentalCostDBDAOReceivableRentalChargeUSQL").append("\n"); 
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
		query.append("SET     LSE_CNTR_CHG_STS_CD = 'C'," ).append("\n"); 
		query.append("        TTL_CHG_AMT  = (SELECT  NVL(SUM(COST_AMT),0) " ).append("\n"); 
		query.append("                        FROM    LSE_RCV_RNTL_CHG_DTL" ).append("\n"); 
		query.append("                        WHERE   COST_YRMON   = A.COST_YRMON" ).append("\n"); 
		query.append("                        AND     AGMT_CTY_CD  = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                        AND     AGMT_SEQ     = A.AGMT_SEQ" ).append("\n"); 
		query.append("                        AND     RCV_RNTL_SEQ = A.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("						AND     LSE_RCV_CHG_CRE_CD != 'D')," ).append("\n"); 
		query.append("        PNL_AMT      = 0," ).append("\n"); 
		query.append("        CR_AMT       = (SELECT  NVL(SUM(CR_AMT),0) " ).append("\n"); 
		query.append("                        FROM    LSE_RCV_RNTL_CHG_DTL" ).append("\n"); 
		query.append("                        WHERE   COST_YRMON   = A.COST_YRMON" ).append("\n"); 
		query.append("                        AND     AGMT_CTY_CD  = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                        AND     AGMT_SEQ     = A.AGMT_SEQ" ).append("\n"); 
		query.append("                        AND     RCV_RNTL_SEQ = A.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("						AND     LSE_RCV_CHG_CRE_CD != 'D')," ).append("\n"); 
		query.append("        INV_AMT      = 0," ).append("\n"); 
		query.append("        DPS_AMT      = 0," ).append("\n"); 
		query.append("        BAL_AMT      = 0," ).append("\n"); 
		query.append("        UPD_USR_ID	 = @[upd_usr_id]," ).append("\n"); 
		query.append("        UPD_DT		 = SYSDATE" ).append("\n"); 
		query.append("WHERE   COST_YRMON   = @[cost_yrmon]" ).append("\n"); 
		query.append("AND     AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("AND     RCV_RNTL_SEQ = @[rcv_rntl_seq]" ).append("\n"); 

	}
}