/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeCreationMasterUSQL.java
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

public class PayableRentalCostDBDAOPayableChargeCreationMasterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Rental Charge Creation : Master Data Charge Amount Update
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeCreationMasterUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeCreationMasterUSQL").append("\n"); 
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
		query.append("SET    (  TTL_COST_AMT" ).append("\n"); 
		query.append("        , CR_TTL_AMT" ).append("\n"); 
		query.append("        , LR_COST_AMT" ).append("\n"); 
		query.append("--        , PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append("        , INV_NO )" ).append("\n"); 
		query.append("     = ( SELECT NVL(A.TTL_COST_AMT, 0)" ).append("\n"); 
		query.append("              , NVL(A.CR_COST_AMT,  0)" ).append("\n"); 
		query.append("              , NVL(B.DSCR_COST_AMT, 0)" ).append("\n"); 
		query.append("--              , NVL(B.DSCR_COST_AMT, 0) + NVL(A.CR_COST_AMT, 0)" ).append("\n"); 
		query.append("              , B.INV_NO" ).append("\n"); 
		query.append("         FROM   ( SELECT AGMT_CTY_CD" ).append("\n"); 
		query.append("                       , AGMT_SEQ" ).append("\n"); 
		query.append("                       , SUM(TTL_COST_AMT) AS TTL_COST_AMT" ).append("\n"); 
		query.append("                       , SUM(CR_AMT)       AS CR_COST_AMT" ).append("\n"); 
		query.append("                  FROM   LSE_PAY_RNTL_CHG_DTL" ).append("\n"); 
		query.append("                  WHERE  CHG_SEQ     = @[chg_seq]" ).append("\n"); 
		query.append("                  AND    AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("                  AND    AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                  GROUP  BY AGMT_CTY_CD" ).append("\n"); 
		query.append("                          , AGMT_SEQ ) A" ).append("\n"); 
		query.append("               , ( SELECT AGMT_CTY_CD" ).append("\n"); 
		query.append("                        , AGMT_SEQ" ).append("\n"); 
		query.append("                        , MAX(INV_NO)       AS INV_NO" ).append("\n"); 
		query.append("                        , SUM(TTL_COST_AMT) AS DSCR_COST_AMT" ).append("\n"); 
		query.append("                   FROM   LSE_PAY_RNTL_CHG_CO" ).append("\n"); 
		query.append("                   WHERE  CO_COST_YRMON = @[chg_cost_yrmon]" ).append("\n"); 
		query.append("                   AND    AGMT_SEQ      = @[agmt_seq]" ).append("\n"); 
		query.append("                   AND    AGMT_CTY_CD   = @[agmt_cty_cd] " ).append("\n"); 
		query.append("                   GROUP  BY AGMT_CTY_CD" ).append("\n"); 
		query.append("                           , AGMT_SEQ ) B" ).append("\n"); 
		query.append("               , ( SELECT @[agmt_cty_cd] AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                        , @[agmt_seq]    AS AGMT_SEQ" ).append("\n"); 
		query.append("                   FROM   DUAL ) C" ).append("\n"); 
		query.append("         WHERE    C.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("         AND      C.AGMT_SEQ    = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("         AND      C.AGMT_CTY_CD = A.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("         AND      C.AGMT_SEQ    = A.AGMT_SEQ(+)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE  CHG_SEQ     = @[chg_seq]" ).append("\n"); 
		query.append("AND    AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("AND    AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 

	}
}