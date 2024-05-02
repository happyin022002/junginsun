/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueDBDAOINDInvIssMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOINDInvIssMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INDIA Inv Iss Max Seq
	  * </pre>
	  */
	public InvoiceIssueDBDAOINDInvIssMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ind_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOINDInvIssMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT A.IDA_INV_PFX_CD||A.IDA_INV_ISS_YRMON INV_PFX_CD" ).append("\n"); 
		query.append("     , NVL(B.IDA_INV_MAX_SEQ, 0) INV_MAX_SEQ" ).append("\n"); 
		query.append("     , INV_AR_ISS_NO_SEQ.NEXTVAL WRK_NO" ).append("\n"); 
		query.append("     , TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), 'YYYYMMDD') ISS_DT" ).append("\n"); 
		query.append("FROM (SELECT TRIM(REPLACE(@[ind_iss_tp_cd], 'T', '')||SUBSTR(@[ofc_cd], 1, 4)) IDA_INV_PFX_CD" ).append("\n"); 
		query.append("           , TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), 'YYMM') IDA_INV_ISS_YRMON        " ).append("\n"); 
		query.append("      FROM DUAL) A," ).append("\n"); 
		query.append("     INV_AR_IDA_ISS_NO B" ).append("\n"); 
		query.append("WHERE B.IDA_INV_PFX_CD(+) = A.IDA_INV_PFX_CD" ).append("\n"); 
		query.append("AND B.IDA_INV_ISS_YRMON(+) = CASE WHEN TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),'MM') IN ('01','02','03') THEN TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) - 365,'YYYY') ELSE TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),'YYYY') END" ).append("\n"); 
		query.append("FOR UPDATE" ).append("\n"); 

	}
}