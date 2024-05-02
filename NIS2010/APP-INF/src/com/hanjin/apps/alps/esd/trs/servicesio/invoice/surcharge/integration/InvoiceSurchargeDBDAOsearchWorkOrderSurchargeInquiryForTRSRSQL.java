/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryForTRSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryForTRSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search WorkOrder Surcharge Inquiry For TRS
	  * </pre>
	  */
	public InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryForTRSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration").append("\n"); 
		query.append("FileName : InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryForTRSRSQL").append("\n"); 
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
		query.append("SELECT trsp_so_ofc_cty_cd," ).append("\n"); 
		query.append("trsp_so_seq," ).append("\n"); 
		query.append("lgs_cost_cd," ).append("\n"); 
		query.append("scg_amt," ).append("\n"); 
		query.append("chss_mgst_tpsz_cd," ).append("\n"); 
		query.append("dry_run_rlbl_pty_tp_cd," ).append("\n"); 
		query.append("fne_cuz_desc," ).append("\n"); 
		query.append("fumg_cost_tp_cd," ).append("\n"); 
		query.append("mgst_tpsz_cd," ).append("\n"); 
		query.append("insp_rf_pti_cstms_tp_cd," ).append("\n"); 
		query.append("lftg_knt," ).append("\n"); 
		query.append("lftg_cuz_desc," ).append("\n"); 
		query.append("stop_loc_nod_cd," ).append("\n"); 
		query.append("grs_wgt," ).append("\n"); 
		query.append("TO_CHAR(incrt_dt,'YYYYMMDD')	incrt_dt," ).append("\n"); 
		query.append("scl_stop_plc_nod_cd," ).append("\n"); 
		query.append("ob_bkg_no," ).append("\n"); 
		query.append("otr_rmk," ).append("\n"); 
		query.append("n3pty_vndr_seq," ).append("\n"); 
		query.append("n3pty_ofc_cd," ).append("\n"); 
		query.append("n3pty_amt," ).append("\n"); 
		query.append("n3pty_desc," ).append("\n"); 
		query.append("sto_dys," ).append("\n"); 
		query.append("wt_hrs," ).append("\n"); 
		query.append("CHSS_NO," ).append("\n"); 
		query.append("TO_CHAR(INCUR_DT, 'YYYYMMDD') INCUR_DT" ).append("\n"); 
		query.append("FROM trs_trsp_scg_dtl" ).append("\n"); 
		query.append("WHERE trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND SUBSTR(LGS_COST_CD, 3, 2)	<> 'FU'" ).append("\n"); 
		query.append("--AND scg_amt > 0" ).append("\n"); 

	}
}