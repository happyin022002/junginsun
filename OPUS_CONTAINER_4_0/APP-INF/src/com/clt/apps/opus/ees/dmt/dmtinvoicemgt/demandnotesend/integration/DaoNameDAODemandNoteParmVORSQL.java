/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNoteParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.10 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODemandNoteParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNoteParmVO
	  * </pre>
	  */
	public DaoNameDAODemandNoteParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DaoNameDAODemandNoteParmVORSQL").append("\n"); 
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
		query.append("'' s_bkg_no" ).append("\n"); 
		query.append(",'' s_group_by" ).append("\n"); 
		query.append(",'' s_chg_type" ).append("\n"); 
		query.append(",'' s_ofc_cd" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append(",'' s_dmdt_trf_cd" ).append("\n"); 
		query.append(",'' dmdt_chg_sts_cds" ).append("\n"); 
		query.append(",'' s_cntr_no" ).append("\n"); 
		query.append(",'' s_sc_no" ).append("\n"); 
		query.append(",'' s_rfa_no" ).append("\n"); 
		query.append(",'' s_bl_no" ).append("\n"); 
		query.append(",'' s_cust_cd" ).append("\n"); 
		query.append(",'' s_invoice_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}