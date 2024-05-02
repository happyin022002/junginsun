/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchContainerToDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchContainerToDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Container To Date
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchContainerToDateRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchContainerToDateRSQL").append("\n"); 
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
		query.append("#if (${rev_tp_src_cd} == 'MDM' || ${rev_tp_src_cd} == 'MDT')" ).append("\n"); 
		query.append("    SELECT TO_CHAR(MAX(TO_MVMT_DT), 'YYYYMMDDHH24MISS') CNTR_TODATE" ).append("\n"); 
		query.append("    FROM DMT_INV_DTL" ).append("\n"); 
		query.append("    WHERE DMDT_INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') CNTR_TODATE FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}