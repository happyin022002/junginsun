/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014.04.01 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O Creation 날짜 기준으로 Invoice 중복여부를 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL").append("\n"); 
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
		query.append("SELECT                                                       " ).append("\n"); 
		query.append("      A.TRSP_SO_OFC_CTY_CD                                    " ).append("\n"); 
		query.append(" ,    A.TRSP_SO_SEQ                                           " ).append("\n"); 
		query.append(" ,    TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT         " ).append("\n"); 
		query.append(" ,    A.FM_NOD_CD                                             " ).append("\n"); 
		query.append(" ,    A.TO_NOD_CD                                             " ).append("\n"); 
		query.append(" ,    A.TRSP_COST_DTL_MOD_CD                                  " ).append("\n"); 
		query.append(" ,    A.TRSP_CRR_MOD_CD                                       " ).append("\n"); 
		query.append(" FROM                                                         " ).append("\n"); 
		query.append("      TRS_TRSP_SVC_ORD     A                                  " ).append("\n"); 
		query.append(" WHERE                                                        " ).append("\n"); 
		query.append("      A.EQ_NO                = @[eq_no]                              " ).append("\n"); 
		query.append(" AND                                                          " ).append("\n"); 
		query.append(" ((                                                           " ).append("\n"); 
		query.append("      A.CONTI_CD             <> 'M'                           " ).append("\n"); 
		query.append(" AND  LOCL_CRE_DT BETWEEN TO_DATE(@[cre_dt], 'YYYYMMDDHH24MISS')-2         " ).append("\n"); 
		query.append("                 AND TO_DATE(@[cre_dt], 'YYYYMMDDHH24MISS')+2         " ).append("\n"); 
		query.append(" )                                                            " ).append("\n"); 
		query.append(" OR                                                           " ).append("\n"); 
		query.append(" (                                                            " ).append("\n"); 
		query.append("      A.CONTI_CD             = 'M'                            " ).append("\n"); 
		query.append(" AND  LOCL_CRE_DT BETWEEN TO_DATE(@[cre_dt], 'YYYYMMDDHH24MISS')-30        " ).append("\n"); 
		query.append("                 AND TO_DATE(@[cre_dt], 'YYYYMMDDHH24MISS')+30        " ).append("\n"); 
		query.append(" ))                                                           " ).append("\n"); 
		query.append(" AND  A.FM_NOD_CD            = @[fm_nod_cd]                              " ).append("\n"); 
		query.append(" AND  A.TRSP_SO_TP_CD        = 'M'                            " ).append("\n"); 
		query.append("        /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("	 AND A.HJL_NO IS NULL" ).append("\n"); 

	}
}