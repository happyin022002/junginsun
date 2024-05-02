/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeOfficeTransferMgtDBDAOOfficeTransferParmVORSQL.java
*@FileTitle : Office Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.23 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeOfficeTransferMgtDBDAOOfficeTransferParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChargeOfficeTransferMgtDBDAOOfficeTransferParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.integration").append("\n"); 
		query.append("FileName : ChargeOfficeTransferMgtDBDAOOfficeTransferParmVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("1 svr_id" ).append("\n"); 
		query.append(",1 cntr_no" ).append("\n"); 
		query.append(",1 cntr_cyc_no" ).append("\n"); 
		query.append(",1 dmdt_trf_cd" ).append("\n"); 
		query.append(",1 dmdt_chg_loc_div_cd" ).append("\n"); 
		query.append(",1 chg_seq" ).append("\n"); 
		query.append(",1 dmdt_chg_sts_cd" ).append("\n"); 
		query.append(",1 fm_cre_dt" ).append("\n"); 
		query.append(",1 to_cre_dt" ).append("\n"); 
		query.append(",1 fm_rhq" ).append("\n"); 
		query.append(",1 to_rhq" ).append("\n"); 
		query.append(",1 fm_ofc_cd" ).append("\n"); 
		query.append(",1 to_ofc_cd" ).append("\n"); 
		query.append(",1 cond_type" ).append("\n"); 
		query.append(",1 bkg_no" ).append("\n"); 
		query.append(",1 bl_no" ).append("\n"); 
		query.append(",1 trns_rsn" ).append("\n"); 
		query.append(",1 to_svr_id" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}