/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchEffDateByIssDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.10.07 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchEffDateByIssDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEffDateByIssDate
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchEffDateByIssDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchEffDateByIssDateRSQL").append("\n"); 
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
		query.append("SELECT DECODE (a.sts, 'O', @[rcv_dt], 'C', substr(b.dt, 1,4)||'-'||substr(b.dt, 5,2)||'-'||substr(b.dt, 7)) EFF_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT clz_sts_cd sts" ).append("\n"); 
		query.append("FROM ap_period" ).append("\n"); 
		query.append("WHERE sys_div_cd = 13" ).append("\n"); 
		query.append("AND ar_ap_div_cd = 'P'" ).append("\n"); 
		query.append("AND ofc_cd IN (SELECT ar_hd_qtr_ofc_cd  FROM MDM_ORGANIZATION  WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND eff_yrmon = SUBSTR (replace(@[rcv_dt],'-',''), 1, 6)" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append(", (SELECT MIN (eff_yrmon) || '01' dt" ).append("\n"); 
		query.append("FROM ap_period" ).append("\n"); 
		query.append("WHERE sys_div_cd = 13" ).append("\n"); 
		query.append("AND ar_ap_div_cd = 'P'" ).append("\n"); 
		query.append("AND ofc_cd IN (SELECT ar_hd_qtr_ofc_cd  FROM MDM_ORGANIZATION  WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND clz_sts_cd = 'O' AND eff_yrmon >= SUBSTR(replace(@[rcv_dt],'-',''), 1, 6)" ).append("\n"); 
		query.append(") b" ).append("\n"); 

	}
}