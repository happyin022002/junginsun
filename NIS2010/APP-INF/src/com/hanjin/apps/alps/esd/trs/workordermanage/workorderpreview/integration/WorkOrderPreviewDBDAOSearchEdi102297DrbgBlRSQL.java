/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297DrbgBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.03 
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

public class WorkOrderPreviewDBDAOSearchEdi102297DrbgBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_DRBG_BL
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297DrbgBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297DrbgBlRSQL").append("\n"); 
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
		query.append("SELECT b.bl_no" ).append("\n"); 
		query.append(",RPAD(NVL(B.BL_NO,' '),12,' ') bl_no" ).append("\n"); 
		query.append("--,mf.msn_no	확인 필요!!!" ).append("\n"); 
		query.append("-- ,msn_no		확인 필요!!!" ).append("\n"); 
		query.append(",RPAD(MAX(NVL(so.fm_nod_cd,' ')), 7, ' ') from_yd" ).append("\n"); 
		query.append(",RPAD(MAX(NVL(SUBSTR(so.dor_nod_cd,1,5)  ,' ')), 5, ' ')	door" ).append("\n"); 
		query.append(",RPAD(MAX(TRIM(SUBSTR(REPLACE(REPLACE(REPLACE(T.cust_nm,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '),1,30))), 30, ' ') cust_c" ).append("\n"); 
		query.append(",RPAD(MAX(TRIM(SUBSTR(REPLACE(REPLACE(REPLACE(T2.cust_nm,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '),1,30))), 14, ' ') cust_n" ).append("\n"); 
		query.append("FROM bkg_booking b" ).append("\n"); 
		query.append(",bkg_customer t" ).append("\n"); 
		query.append(",bkg_customer t2" ).append("\n"); 
		query.append(",trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("--,trs_mf_seq_no mf" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd	= @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq	= @[trsp_wo_seq]" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("AND so.bkg_no	= b.bkg_no(+)" ).append("\n"); 
		query.append("AND so.bkg_no = t.bkg_no(+)" ).append("\n"); 
		query.append("AND so.bkg_no	= t2.bkg_no(+)" ).append("\n"); 
		query.append("AND t.bkg_cust_tp_cd(+)	= 'C'" ).append("\n"); 
		query.append("AND t2.bkg_cust_tp_cd(+) = 'N'" ).append("\n"); 
		query.append("--AND so.bkg_no = mf.bkg_no(+)   확인 필요!!!" ).append("\n"); 
		query.append("--AND mf.msn_bd_tp_cd(+) ='E'		확인 필요!!!" ).append("\n"); 
		query.append("--AND mf.msn_cfm_cd(+) = 'Y'		확인 필요!!!" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("GROUP BY b.bl_no" ).append("\n"); 
		query.append("--,mf.msn_no				확인 필요!!!" ).append("\n"); 

	}
}