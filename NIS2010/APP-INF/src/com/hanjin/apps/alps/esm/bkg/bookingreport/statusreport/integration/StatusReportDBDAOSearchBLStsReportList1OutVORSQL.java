/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStsReportList1OutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.20 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStsReportList1OutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStsReportList1OutVORSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStsReportList1OutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStsReportList1OutVORSQL").append("\n"); 
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
		query.append("/* 0647 BlStsReportOut */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   'Booking'        bkg_no        	" ).append("\n"); 
		query.append(",  'BLNo'           bl_no         	" ).append("\n"); 
		query.append(",  'POR'            por_cd        	" ).append("\n"); 
		query.append(",  'POL'            pol_cd       	" ).append("\n"); 
		query.append(",  'POD'            pod_cd        	" ).append("\n"); 
		query.append(",  'DEL'            del_cd           	 " ).append("\n"); 
		query.append(",  'BookingOffice'  bkg_ofc       	" ).append("\n"); 
		query.append(",  'DELOffice'      del_ofc       	" ).append("\n"); 
		query.append(",  'OB_Type'        ob_type       	" ).append("\n"); 
		query.append(",  'OB_Date'        ob_date       	" ).append("\n"); 
		query.append(",  'IR_BL_Type'      IR_BL_TYPE     	" ).append("\n"); 
		query.append(",  'IR_Office'      ir_office     	" ).append("\n"); 
		query.append(",  'IR_Date'        ir_date       	" ).append("\n"); 
		query.append(",  'IR_By'          ir_by         	" ).append("\n"); 
		query.append(",  'ORS_Office'     ors_office    	" ).append("\n"); 
		query.append(",  'ORS_Date'       ors_date      	" ).append("\n"); 
		query.append(",  'ORS_No'         ors_no        	" ).append("\n"); 
		query.append(",  'ORS_Surrender'  ors_surrender  " ).append("\n"); 
		query.append(",  'ORS_DO'         ors_do        	" ).append("\n"); 
		query.append(",  'BDI_SR'         bdi_sr        	" ).append("\n"); 
		query.append(",  'BDI_Complete'   bdi_complete  	" ).append("\n"); 
		query.append(",  'BDI_Office'     bdi_office    	" ).append("\n"); 
		query.append(",  'BDI_By'         bdi_by        	" ).append("\n"); 
		query.append(",  'VVD'            vvd_cd        " ).append("\n"); 
		query.append(",  'Shipper'        shipper       	" ).append("\n"); 
		query.append(",  'Consignee'      consignee     	" ).append("\n"); 
		query.append(",  'SalesOffice'    sales_office   	" ).append("\n"); 
		query.append(",  'SalesRep'       sales_rep      	" ).append("\n"); 
		query.append(",  'PPD'            ppd           	" ).append("\n"); 
		query.append(",  'CCT'            cct" ).append("\n"); 
		query.append(",  'BL_ISSUED'      BL_ISSUED" ).append("\n"); 
		query.append(",  'BL_RELEASED'    BL_RELEASED" ).append("\n"); 
		query.append(",  'PPD_ORG'		ppd_org" ).append("\n"); 
		query.append(",  'PPD_3RD'		ppd_3rd" ).append("\n"); 
		query.append(",  'CCT_DEST'		cct_dest" ).append("\n"); 
		query.append(",  'CCT_3RD'		cct_3rd" ).append("\n"); 
		query.append(",  'OBL_ISS_RMK'    obl_iss_rmk" ).append("\n"); 
		query.append("    , '' PPD_ORG2" ).append("\n"); 
		query.append("    , '' PPD_3RD2" ).append("\n"); 
		query.append("    , '' CCT_DEST2 " ).append("\n"); 
		query.append("    , '' CCT_3RD2" ).append("\n"); 
		query.append("    , '' FOWARDER" ).append("\n"); 
		query.append("    , '' BL_PRINT" ).append("\n"); 
		query.append("    , '' SC_RFA_NO" ).append("\n"); 
		query.append("    , '' PAY_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , 'TOTAL_CNT ' TOTAL_CNT " ).append("\n"); 
		query.append(" , 'ROWS_PER_PAGE ' ROWS_PER_PAGE " ).append("\n"); 
		query.append(" , 'CURR_PAGE' CURR_PAGE" ).append("\n"); 
		query.append(" , 'RNUM' RNUM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}