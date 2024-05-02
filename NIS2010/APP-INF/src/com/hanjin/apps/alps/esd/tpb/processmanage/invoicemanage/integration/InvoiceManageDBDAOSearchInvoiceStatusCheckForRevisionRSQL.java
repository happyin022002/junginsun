/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchInvoiceStatusCheckForRevisionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchInvoiceStatusCheckForRevisionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceStatusCheckForRevision
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchInvoiceStatusCheckForRevisionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchInvoiceStatusCheckForRevisionRSQL").append("\n"); 
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
		query.append("SELECT   CASE WHEN COUNT(1) = 1 THEN 'Y' ELSE 'N' END AS VALIDYN" ).append("\n"); 
		query.append("FROM     TPB_INV_RVIS R" ).append("\n"); 
		query.append("       , TPB_INVOICE V" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      R.N3PTY_INV_NO = V.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND      R.N3PTY_INV_RVIS_SEQ = V.LST_N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND      V.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND      R.N3PTY_INV_STS_CD IN ('N','A','C')" ).append("\n"); 
		query.append("AND      R.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 

	}
}