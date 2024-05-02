/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDAOMarineTerminalStorageInvoiceManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.27 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDAOMarineTerminalStorageInvoiceManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MarineTerminalStorageInvoiceManage
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDAOMarineTerminalStorageInvoiceManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDAOMarineTerminalStorageInvoiceManageRSQL").append("\n"); 
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
		query.append("select '' tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", '' tml_so_seq" ).append("\n"); 
		query.append(", '' tml_so_dtl_seq" ).append("\n"); 
		query.append(", '' tmp_dtl_seq" ).append("\n"); 
		query.append(", '' tml_so_cntr_list_seq" ).append("\n"); 
		query.append(", '' calc_tp_cd" ).append("\n"); 
		query.append(", '' calc_cost_grp_cd" ).append("\n"); 
		query.append(", '' param_cntr_no" ).append("\n"); 
		query.append(", '' param_cntr_tpsz_cd" ).append("\n"); 
		query.append(", '' param_lgs_cost_cd" ).append("\n"); 
		query.append(", '' dtl_by_day_only_mode" ).append("\n"); 
		query.append(", '' dtl_by_pool_only_mode" ).append("\n"); 
		query.append(", '' del_if_seq" ).append("\n"); 
		query.append(", '' del_cntr_seq" ).append("\n"); 
		query.append(", '' inv_no" ).append("\n"); 
		query.append(", '' yd_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}