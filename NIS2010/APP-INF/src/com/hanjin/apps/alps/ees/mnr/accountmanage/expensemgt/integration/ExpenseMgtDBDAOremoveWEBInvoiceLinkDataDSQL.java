/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseMgtDBDAOremoveWEBInvoiceLinkDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.11.27 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOremoveWEBInvoiceLinkDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOremoveWEBInvoiceLinkDataDSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOremoveWEBInvoiceLinkDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration ").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOremoveWEBInvoiceLinkDataDSQL").append("\n"); 
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
		query.append("DELETE MNR_PAY_INV_TMP" ).append("\n"); 
		query.append("WHERE PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 

	}
}