/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchIssueInvoiceAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2010.02.23 박정진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungJin, Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchIssueInvoiceAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchIssueInvoiceAmountRSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchIssueInvoiceAmountRSQL").append("\n"); 
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
		query.append("select rownum ar_if_ser_no, " ).append("\n"); 
		query.append("        tj_src_nm, " ).append("\n"); 
		query.append("        curr_cd, " ).append("\n"); 
		query.append("        inv_amt" ).append("\n"); 
		query.append("   from (" ).append("\n"); 
		query.append("SELECT A.TJ_SRC_NM" ).append("\n"); 
		query.append("       , A.CURR_CD" ).append("\n"); 
		query.append("	   , SUM(A.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("  FROM INV_AR_AMT A" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO IN (SELECT DISTINCT MN.AR_IF_NO AR_IF_NO" ).append("\n"); 
		query.append("						FROM INV_AR_MN MN," ).append("\n"); 
		query.append("							 INV_AR_CHG CHG," ).append("\n"); 
		query.append("							 INV_AR_ISS_DTL DTL" ).append("\n"); 
		query.append("					   WHERE MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("						 AND CHG.AR_IF_NO = DTL.AR_IF_NO" ).append("\n"); 
		query.append("						 AND CHG.CHG_SEQ = DTL.CHG_SEQ" ).append("\n"); 
		query.append("						 AND DTL.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("						 AND MN.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("						 AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("						 --AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("GROUP BY A.TJ_SRC_NM, A.CURR_CD)" ).append("\n"); 

	}
}