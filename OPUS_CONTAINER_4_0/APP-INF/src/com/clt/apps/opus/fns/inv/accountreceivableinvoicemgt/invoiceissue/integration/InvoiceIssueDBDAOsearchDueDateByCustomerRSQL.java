/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchDueDateByCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.12.29 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchDueDateByCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchDueDateByCustomerRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchDueDateByCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchDueDateByCustomerRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.CUST_CR_FLG, 'Y', DECODE(@[io_bnd_cd], 'O', TO_CHAR(TO_DATE(DECODE(A.CUST_CR_DUE_DT_DIV_CD, 'I', @[iss_dt], @[sail_arr_dt]), 'YYYYMMDD') + DECODE(A.OB_CR_TERM_DYS, 0, B.OB_CR_TERM_DYS, NULL, B.OB_CR_TERM_DYS, A.OB_CR_TERM_DYS), 'YYYYMMDD') -- 신용 O/B" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(DECODE(A.CUST_CR_DUE_DT_DIV_CD, 'I', @[iss_dt], @[sail_arr_dt]), 'YYYYMMDD') + DECODE(A.IB_CR_TERM_DYS, 0, B.IB_CR_TERM_DYS, NULL, B.IB_CR_TERM_DYS, A.IB_CR_TERM_DYS) ,'YYYYMMDD'))-- 신용 I/B" ).append("\n"); 
		query.append(", DECODE(@[io_bnd_cd], 'O', TO_CHAR(TO_DATE(@[sail_arr_dt],'YYYYMMDD') + NVL(B.OB_CR_TERM_DYS, 0),'YYYYMMDD'), TO_CHAR(TO_DATE(@[sail_arr_dt],'YYYYMMDD') + NVL(B.IB_CR_TERM_DYS,0),'YYYYMMDD')) -- 비신용" ).append("\n"); 
		query.append(") DUE_DT" ).append("\n"); 
		query.append("FROM MDM_CR_CUST A, MDM_ORGANIZATION B, INV_AR_MN C" ).append("\n"); 
		query.append("WHERE C.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND C.ACT_CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND C.ACT_CUST_SEQ   = @[cust_seq]" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD  = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ   = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND @[sail_arr_dt] BETWEEN A.CR_ST_DT AND A.CR_END_DT" ).append("\n"); 
		query.append("AND B.OFC_CD  = @[ofc_cd]" ).append("\n"); 

	}
}