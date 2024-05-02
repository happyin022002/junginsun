/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeAuditChargeMasterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.03.25 노정용
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

public class PayableRentalCostDBDAOPayableChargeAuditChargeMasterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Charge Audit 후  LSE_PAY_RNTL_CHG 테이블의 금액을 수정한다.
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeAuditChargeMasterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeAuditChargeMasterUSQL").append("\n"); 
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
		query.append("UPDATE LSE_PAY_RNTL_CHG" ).append("\n"); 
		query.append("SET    ( TTL_COST_AMT" ).append("\n"); 
		query.append("       , CR_TTL_AMT" ).append("\n"); 
		query.append("--       , LR_COST_AMT" ).append("\n"); 
		query.append("       , PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append("       , LSE_PAY_RNTL_STS_CD" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT)" ).append("\n"); 
		query.append("     = ( SELECT NVL(TTL_COST_AMT,  0)" ).append("\n"); 
		query.append("              , NVL(CR_COST_AMT,   0)" ).append("\n"); 
		query.append("--              , NVL(DSCR_COST_AMT, 0)" ).append("\n"); 
		query.append("              , NVL(DSCR_COST_AMT, 0) + NVL(CR_COST_AMT, 0)" ).append("\n"); 
		query.append("              , 'A'" ).append("\n"); 
		query.append("              , @[usr_id]" ).append("\n"); 
		query.append("              , SYSDATE" ).append("\n"); 
		query.append("         FROM   ( SELECT SUM(TTL_COST_AMT)                                   AS TTL_COST_AMT" ).append("\n"); 
		query.append("                       , SUM(DECODE(CNTR_AUD_STS_CD, 'A', CR_AMT, 0))        AS CR_COST_AMT" ).append("\n"); 
		query.append("                       , SUM(DECODE(CNTR_AUD_STS_CD, 'A', DSCR_COST_AMT, 0)) AS DSCR_COST_AMT" ).append("\n"); 
		query.append("                  FROM   LSE_PAY_RNTL_CHG_DTL" ).append("\n"); 
		query.append("                  WHERE  CHG_SEQ = @[chg_seq]" ).append("\n"); 
		query.append("                  AND    AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("                  AND    AGMT_CTY_CD = @[agmt_cty_cd] ))" ).append("\n"); 
		query.append("WHERE  CHG_SEQ = @[chg_seq]" ).append("\n"); 
		query.append("AND    AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND    AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 

	}
}