/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchDueDateByDivCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.12.04 정휘택
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

public class InvoiceIssueDBDAOsearchDueDateByDivCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchDueDateByDivCdRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchDueDateByDivCdRSQL(){
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
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchDueDateByDivCdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.CUST_CR_FLG, 'Y', DECODE(@[io_bnd_cd], 'O', TO_CHAR(TO_DATE(DECODE(A.CUST_CR_DUE_DT_DIV_CD, 'I', @[iss_dt]" ).append("\n"); 
		query.append(", @[sa_dt]), 'YYYYMMDD') + DECODE(A.OB_CR_TERM_DYS, 0, B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append(", NULL, B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append(", A.OB_CR_TERM_DYS), 'YYYYMMDD')" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(DECODE(A.CUST_CR_DUE_DT_DIV_CD, 'I', @[iss_dt]" ).append("\n"); 
		query.append(", @[sa_dt]), 'YYYYMMDD') + DECODE(A.IB_CR_TERM_DYS, 0, B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append(", NULL, B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append(", A.IB_CR_TERM_DYS), 'YYYYMMDD'))" ).append("\n"); 
		query.append(", DECODE(@[io_bnd_cd], 'O', TO_CHAR(TO_DATE(@[sa_dt], 'YYYYMMDD') + NVL(B.OB_CR_TERM_DYS, 0), 'YYYYMMDD')" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(@[sa_dt], 'YYYYMMDD') + NVL(B.IB_CR_TERM_DYS, 0), 'YYYYMMDD'))) DUE_DT" ).append("\n"); 
		query.append("FROM MDM_CR_CUST A" ).append("\n"); 
		query.append(", MDM_ORGANIZATION B" ).append("\n"); 
		query.append(", INV_AR_MN C" ).append("\n"); 
		query.append("WHERE C.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND C.ACT_CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND C.ACT_CUST_SEQ   = @[cust_seq]" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD  = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ   = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND @[sa_dt] BETWEEN A.CR_ST_DT AND A.CR_END_DT" ).append("\n"); 
		query.append("AND B.OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}