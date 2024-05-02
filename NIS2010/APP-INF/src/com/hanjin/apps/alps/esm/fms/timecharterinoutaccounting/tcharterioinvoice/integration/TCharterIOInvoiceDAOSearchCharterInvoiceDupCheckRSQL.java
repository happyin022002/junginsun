/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCharterInvoiceDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchCharterInvoiceDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchCharterInvoiceDupCheckRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCharterInvoiceDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chtr_inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCharterInvoiceDupCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(A.TO_INV_NO), 0, 'Y', 'N') DUP_CNT" ).append("\n"); 
		query.append("FROM FMS_INV_DTL A" ).append("\n"); 
		query.append("WHERE A.TO_INV_NO    = @[to_inv_no]" ).append("\n"); 
		query.append("  AND A.ACCT_CD      = @[acct_cd]" ).append("\n"); 
		query.append("  AND A.ACCT_ITM_SEQ = @[acct_itm_seq]" ).append("\n"); 
		query.append("  AND A.CHTR_INV_DT  = @[chtr_inv_dt]" ).append("\n"); 
		query.append("  AND A.VSL_CD       = substr(@[bunker_vvd],1,4) " ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO   = SUBSTR(@[bunker_vvd],5,4)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD   = SUBSTR(@[bunker_vvd],9,1)" ).append("\n"); 
		query.append("  AND A.REV_DIR_CD   = SUBSTR(@[bunker_vvd],10,1)" ).append("\n"); 

	}
}