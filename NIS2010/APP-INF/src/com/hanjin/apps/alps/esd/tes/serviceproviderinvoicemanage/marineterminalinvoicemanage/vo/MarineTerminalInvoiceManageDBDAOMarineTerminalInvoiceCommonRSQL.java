/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.07 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MarineTerminalInvoiceCommon
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL").append("\n"); 
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
		query.append("select '' cost_code, '' cntr_sty_code, '' inv_date_type, '' rvis_div, '' vvd_type, '' all_tp, '' fm_tp, '' ts_tp, '' wo_no, '' file_import_yn" ).append("\n"); 
		query.append(",'' reverify_yn, '' delIfSeq, '' delCntrSeq, '' temp_lgs_cost_cd" ).append("\n"); 
		query.append(", '' tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", '' tml_so_seq" ).append("\n"); 
		query.append(", '' tml_so_dtl_seq" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}