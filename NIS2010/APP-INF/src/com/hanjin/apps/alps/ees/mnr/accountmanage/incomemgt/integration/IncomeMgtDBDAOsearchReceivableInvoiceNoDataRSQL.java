/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IncomeMgtDBDAOsearchReceivableInvoiceNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.06.07 김창헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Chang Hun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOsearchReceivableInvoiceNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOsearchReceivableInvoiceNoDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOsearchReceivableInvoiceNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOsearchReceivableInvoiceNoDataRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[user_ofc_cd], 1, 3)||TO_CHAR(sysdate, 'yyyymm')||LTRIM(TO_CHAR(NVL(SUBSTR(MAX(MRIW.INV_NO), 10), '0')+1, '000')) INV_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT INV_NO FROM MNR_RCV_INV_WRK" ).append("\n"); 
		query.append("WHERE INV_NO LIKE SUBSTR(@[user_ofc_cd], 1, 3)||TO_CHAR(sysdate, 'yyyymm')||'%' " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT INV_NO FROM MNR_DISP_CXL_DTL" ).append("\n"); 
		query.append("WHERE INV_NO LIKE SUBSTR(@[user_ofc_cd], 1, 3)||TO_CHAR(sysdate, 'yyyymm')||'%' ) MRIW" ).append("\n"); 

	}
}