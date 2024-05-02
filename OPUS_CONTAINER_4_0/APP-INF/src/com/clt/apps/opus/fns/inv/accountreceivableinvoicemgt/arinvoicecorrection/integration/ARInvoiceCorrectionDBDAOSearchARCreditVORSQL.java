/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchARCreditVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.17 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchARCreditVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceCorrectionDBDAO::searchARCredit ( custCd , ofcCd , saDt , bnd )
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchARCreditVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("SELECT CR_FLG," ).append("\n"); 
		query.append("#if (${bnd} == \"I\")" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[sa_dt],'YYYYMMDD')+IB_CR_TERM_DYS,'YYYYMMDD') DUE_DATE," ).append("\n"); 
		query.append("IB_CR_TERM_DYS CR_TERM_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bnd} == \"O\")" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[sa_dt],'YYYYMMDD')+OB_CR_TERM_DYS,'YYYYMMDD') DUE_DATE," ).append("\n"); 
		query.append("OB_CR_TERM_DYS CR_TERM_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DECODE(CR_FLG,'Y',A.CR_FLG,'N') CR_FLG," ).append("\n"); 
		query.append("DECODE(CR_FLG,'Y',A.IB_CR_TERM_DYS,B.IB_CR_TERM_DYS) IB_CR_TERM_DYS," ).append("\n"); 
		query.append("DECODE(CR_FLG,'Y',A.OB_CR_TERM_DYS,B.OB_CR_TERM_DYS) OB_CR_TERM_DYS" ).append("\n"); 
		query.append("FROM MDM_CR_CUST A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[cust_cnt_cd] AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchARCreditVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}