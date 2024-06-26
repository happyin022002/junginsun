/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOcheckCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOcheckCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOcheckCustomerRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOcheckCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_agent_mark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOcheckCustomerRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[ofc_agent_mark], 'O', @[rep_cust_cnt_cd], 'S', @[rep_cust_cnt_cd], @[cust_cnt_cd]) CUST_CNT_CD" ).append("\n"); 
		query.append("     , DECODE(@[ofc_agent_mark], 'O', @[rep_cust_seq], 'S', @[rep_cust_seq], @[cust_seq]) CUST_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(" WHERE EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                  AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append(" 				  AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                  AND NVL(NMD_CUST_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                  --AND NVL(BLK_DIV_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("                  AND NVL(CNTR_DIV_FLG,'N') ='Y') --2010-06-04 김현화수석" ).append("\n"); 

	}
}