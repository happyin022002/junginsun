/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOLessorInvoiceFileCntrDuplicateCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.03.23 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOLessorInvoiceFileCntrDuplicateCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice File Import시 container no와 charge type을  중복인 경우 체크하는 로직
	  * </pre>
	  */
	public PayableRentalCostDBDAOLessorInvoiceFileCntrDuplicateCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOLessorInvoiceFileCntrDuplicateCheckRSQL").append("\n"); 
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
		query.append("SELECT 'There are duplicate container/charge type found( '||count(*)||' count).  Please check again.' AS CHECK_WARNING" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT DISTINCT 'CHK' TP, CNTR_NO" ).append("\n"); 
		query.append("		FROM LSE_PAY_RNTL_CHG_CO" ).append("\n"); 
		query.append("		WHERE  1 = 1" ).append("\n"); 
		query.append("		AND    CO_COST_YRMON = @[chg_cost_yrmon]" ).append("\n"); 
		query.append("        AND    AGMT_CTY_CD 	 = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND    AGMT_SEQ 	 = @[agmt_seq]" ).append("\n"); 
		query.append("		GROUP BY CNTR_NO, LSE_PAY_CHG_TP_NM" ).append("\n"); 
		query.append("		HAVING COUNT(*) > 1 " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY TP" ).append("\n"); 

	}
}