/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExpenseMgtDBDAOcheckPayableInvoiceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.07 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOcheckPayableInvoiceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOcheckPayableInvoiceDataRSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOcheckPayableInvoiceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOcheckPayableInvoiceDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_INV_STS_CD" ).append("\n"); 
		query.append("FROM MNR_PAY_INV_WRK" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND ORD_VNDR_SEQ = TO_NUMBER(@[ord_vndr_seq])" ).append("\n"); 
		query.append("AND  MNR_INV_STS_CD IN ( 'HS', 'HC', 'HE')" ).append("\n"); 
		query.append("#if (${pay_inv_seq} != '')" ).append("\n"); 
		query.append("AND  PAY_INV_SEQ <> @[pay_inv_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM  = 1" ).append("\n"); 

	}
}