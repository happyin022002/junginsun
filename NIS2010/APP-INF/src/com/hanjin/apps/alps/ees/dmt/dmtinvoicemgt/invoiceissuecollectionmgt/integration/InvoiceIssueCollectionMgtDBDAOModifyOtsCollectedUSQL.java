/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOModifyOtsCollectedUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOModifyOtsCollectedUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOModifyOtsCollectedUSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOModifyOtsCollectedUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOModifyOtsCollectedUSQL").append("\n"); 
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
		query.append("update  DMT_INV_MN A" ).append("\n"); 
		query.append("   set  OTS_CLT_FLG = ( select  case " ).append("\n"); 
		query.append("            						when max(T1.INV_AMT) = ROUND(sum(decode(T2.DMDT_INV_PAY_TP_CD, 'V', T2.INV_PAY_AMT * decode(T2.INV_CURR_CD, T1.INV_CURR_CD, 1, T1.INV_XCH_RT),0)) +" ).append("\n"); 
		query.append("                                    						sum(decode(T2.DMDT_INV_PAY_TP_CD, 'M', T2.INV_PAY_AMT * decode(T2.INV_CURR_CD, T1.INV_CURR_CD, 1, T1.INV_XCH_RT),0)),2)" ).append("\n"); 
		query.append("                				then 'Y' " ).append("\n"); 
		query.append("            					else 'N' " ).append("\n"); 
		query.append("        						end" ).append("\n"); 
		query.append("  						  from  DMT_INV_MN  			T1" ).append("\n"); 
		query.append("       						   ,DMT_INV_OTS_PAY_RCV 	T2 " ).append("\n"); 
		query.append("						 where  T1.DMDT_INV_NO = A.DMDT_INV_NO" ).append("\n"); 
		query.append("						   and  T1.DMDT_INV_NO = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("						 group by T1.DMDT_INV_NO )" ).append("\n"); 
		query.append("       ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,UPD_OFC_CD = 'CLTCO'" ).append("\n"); 
		query.append("       ,UPD_DT = sysdate" ).append("\n"); 
		query.append(" where DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("   and DMDT_INV_STS_CD = 'I'" ).append("\n"); 

	}
}