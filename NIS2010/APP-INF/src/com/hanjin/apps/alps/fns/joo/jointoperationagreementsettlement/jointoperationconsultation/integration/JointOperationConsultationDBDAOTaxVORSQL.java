/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOTaxVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.31 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOTaxVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tax inquiry   
	  * </pre>
	  */
	public JointOperationConsultationDBDAOTaxVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOTaxVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("a.tax_inv_yrmon," ).append("\n"); 
		query.append("a.ofc_cd," ).append("\n"); 
		query.append("a.tax_ser_no," ).append("\n"); 
		query.append("a.spl_rgst_no," ).append("\n"); 
		query.append("a.co_nm," ).append("\n"); 
		query.append("to_char(a.iss_dt,'YYYYMMDD') iss_dt," ).append("\n"); 
		query.append("b.itm_nm," ).append("\n"); 
		query.append("a.tax_vat_tp_cd," ).append("\n"); 
		query.append("a.tax_pl_cd," ).append("\n"); 
		query.append("a.slp_tp_cd||a.slp_func_cd||a.slp_ofc_cd||to_char(to_date(a.slp_iss_dt,'yyyymmdd'),'rrmmdd')||a.slp_ser_no as slp_no," ).append("\n"); 
		query.append("sum(a.spl_amt) spl_amt," ).append("\n"); 
		query.append("sum(a.tax_amt) tax_amt" ).append("\n"); 
		query.append("from   joo_tax     a," ).append("\n"); 
		query.append("joo_tax_dtl b" ).append("\n"); 
		query.append("where  a.tax_inv_yrmon  = b.tax_inv_yrmon" ).append("\n"); 
		query.append("and    a.ofc_cd         = b.ofc_cd" ).append("\n"); 
		query.append("and    a.tax_ser_no     = b.tax_ser_no" ).append("\n"); 
		query.append("and    a.iss_dt >= to_date(@[tax_inv_yrmon_fr]||'01','yyyymmdd')" ).append("\n"); 
		query.append("and    a.iss_dt <= last_day(to_date(@[tax_inv_yrmon_to]||'01235959','yyyymmddhh24miss'))" ).append("\n"); 
		query.append("group  by" ).append("\n"); 
		query.append("a.tax_inv_yrmon," ).append("\n"); 
		query.append("a.ofc_cd," ).append("\n"); 
		query.append("a.tax_ser_no," ).append("\n"); 
		query.append("a.spl_rgst_no," ).append("\n"); 
		query.append("a.co_nm," ).append("\n"); 
		query.append("a.iss_dt," ).append("\n"); 
		query.append("b.itm_nm," ).append("\n"); 
		query.append("a.tax_vat_tp_cd," ).append("\n"); 
		query.append("a.tax_pl_cd," ).append("\n"); 
		query.append("a.slp_tp_cd||a.slp_func_cd||a.slp_ofc_cd||to_char(to_date(a.slp_iss_dt,'yyyymmdd'),'rrmmdd')||a.slp_ser_no" ).append("\n"); 

	}
}