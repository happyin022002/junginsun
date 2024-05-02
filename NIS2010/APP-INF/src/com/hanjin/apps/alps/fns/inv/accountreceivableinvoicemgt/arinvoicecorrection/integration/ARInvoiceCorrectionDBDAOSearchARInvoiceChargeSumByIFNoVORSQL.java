/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceChargeSumByIFNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.30 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchARInvoiceChargeSumByIFNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * «» searchARInvoiceChargeSumByIFNo ( [in] ifNo : string ) : ARInvoiceChargeSumVO[]
	  * ARInvoiceCorrectionDBDAO::searchARInvoiceChargeSumByIFNo ( ifNo )
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchARInvoiceChargeSumByIFNoVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT A.CURR_CD CURR_CD," ).append("\n"); 
		query.append("ROUND(SUM(A.CHG_AMT),B.DP_PRCS_KNT) CHG_AMT," ).append("\n"); 
		query.append("A.INV_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("C.LOCL_CURR_CD LOCL_CURR_CD," ).append("\n"); 
		query.append("ROUND(SUM(A.CHG_AMT*A.INV_XCH_RT),D.DP_PRCS_KNT) LOCAL_TOTAL," ).append("\n"); 
		query.append("DECODE(A.CURR_CD,'USD',1,C.LOCL_CURR_CD,2,3) SORT_SEQ" ).append("\n"); 
		query.append("FROM INV_AR_CHG A,MDM_CURRENCY B,INV_AR_MN C,MDM_CURRENCY D" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO=@[ar_if_no]" ).append("\n"); 
		query.append("AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("AND C.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("GROUP BY A.CURR_CD,B.DP_PRCS_KNT,D.DP_PRCS_KNT,A.INV_XCH_RT,C.LOCL_CURR_CD" ).append("\n"); 
		query.append("ORDER BY SORT_SEQ ,A.CURR_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceChargeSumByIFNoVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}