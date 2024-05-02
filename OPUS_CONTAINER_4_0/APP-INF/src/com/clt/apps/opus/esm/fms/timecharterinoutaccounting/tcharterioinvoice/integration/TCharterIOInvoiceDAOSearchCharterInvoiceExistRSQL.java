/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCharterInvoiceExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchCharterInvoiceExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCharterInvoiceExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration ").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCharterInvoiceExistRSQL").append("\n"); 
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
		query.append("SELECT FLET_CTRT_NO" ).append("\n"); 
		query.append("  FROM FMS_INVOICE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FLET_ISS_TP_CD = 'CHT'" ).append("\n"); 
		query.append("   AND INV_SEQ = 1" ).append("\n"); 

	}
}