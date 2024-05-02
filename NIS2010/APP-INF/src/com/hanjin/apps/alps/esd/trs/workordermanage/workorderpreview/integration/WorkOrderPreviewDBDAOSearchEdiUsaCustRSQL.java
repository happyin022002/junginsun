/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiUsaCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdiUsaCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_USA_CUST
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiUsaCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiUsaCustRSQL").append("\n"); 
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
		query.append("SELECT cust.bkg_cust_tp_cd	as cust_tp" ).append("\n"); 
		query.append(",REPLACE(cust.cust_nm, CHR(13)||CHR(10), ' ') as cust_nm" ).append("\n"); 
		query.append(",REPLACE(cust.cust_addr, CHR(13)||CHR(10), ' ') as cust_addr" ).append("\n"); 
		query.append(",'' as cust_tel" ).append("\n"); 
		query.append(",cust.cust_fax_no	as cust_fax" ).append("\n"); 
		query.append("FROM bkg_customer cust" ).append("\n"); 
		query.append(",bkg_customer cust2" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg	<> 'Y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND so.bkg_no = cust.bkg_no(+)" ).append("\n"); 
		query.append("AND so.bkg_no = cust2.bkg_no(+)" ).append("\n"); 
		query.append("AND cust.bkg_cust_tp_cd	= 'C'" ).append("\n"); 
		query.append("AND cust2.bkg_cust_tp_cd = 'N'" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 

	}
}