/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PayableRentalCostDBDAOmodifyOperationPayableRentalChargeInvoiceCancelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.03.15 노정용
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

public class PayableRentalCostDBDAOmodifyOperationPayableRentalChargeInvoiceCancelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * payable Rental Charge Cancel 을 위한 update sql
	  * </pre>
	  */
	public PayableRentalCostDBDAOmodifyOperationPayableRentalChargeInvoiceCancelUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOmodifyOperationPayableRentalChargeInvoiceCancelUSQL").append("\n"); 
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
		query.append("UPDATE LSE_OP_LSE" ).append("\n"); 
		query.append("SET    OP_LSE_STS_CD = 'S'" ).append("\n"); 
		query.append("     , IF_RGST_NO = NULL" ).append("\n"); 
		query.append("WHERE IF_RGST_NO = @[if_rgst_no]" ).append("\n"); 

	}
}