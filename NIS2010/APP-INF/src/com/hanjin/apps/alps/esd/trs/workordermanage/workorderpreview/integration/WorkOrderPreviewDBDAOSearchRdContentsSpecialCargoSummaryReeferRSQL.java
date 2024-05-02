/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryReeferRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19 
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

public class WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryReeferRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRdContentsSpecialCargoSummaryReefer
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryReeferRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryReeferRSQL").append("\n"); 
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
		query.append("SELECT row_id as rf_rnum" ).append("\n"); 
		query.append(",cntr.eq_no  as rf_eq_no" ).append("\n"); 
		query.append(",rf.cdo_temp as rf_temper_c" ).append("\n"); 
		query.append(",rf.fdo_temp as rf_temper_f" ).append("\n"); 
		query.append(",DECODE(rf.rf_vent_tp_cd" ).append("\n"); 
		query.append(",'B',rf.new_uusd_vent_no||'% OPEN / '||rf.new_vent_no||'CMH'" ).append("\n"); 
		query.append(",'C',rf.new_vent_no||'CMH'" ).append("\n"); 
		query.append(",rf.new_uusd_vent_no||'% OPEN') as rf_vent" ).append("\n"); 
		query.append("FROM ( SELECT so.eq_no" ).append("\n"); 
		query.append(",so.spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append(",so.bkg_no" ).append("\n"); 
		query.append(",so.bkg_tro_no" ).append("\n"); 
		query.append(",ROWNUM as row_id" ).append("\n"); 
		query.append("FROM trs_trsp_wrk_ord_prv_tmp tmp" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE tmp.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND tmp.wo_iss_no  = @[wo_iss_no]" ).append("\n"); 
		query.append("AND tmp.trsp_so_ofc_cty_cd  = so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND tmp.trsp_so_seq = so.trsp_so_seq" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL) cntr" ).append("\n"); 
		query.append(",bkg_rf_cgo rf" ).append("\n"); 
		query.append("WHERE cntr.bkg_no = rf.bkg_no" ).append("\n"); 
		query.append("AND rf.rc_seq = DECODE(SUBSTR(cntr.bkg_tro_no,2,1)" ).append("\n"); 
		query.append(",'E',TO_NUMBER(SUBSTR(cntr.bkg_tro_no,3, LENGTH(cntr.bkg_tro_no)-4)))" ).append("\n"); 
		query.append(",RF.RC_SEQ)" ).append("\n"); 
		query.append("AND NVL(cntr.eq_no,'-STORMBOY-') = DECODE(SUBSTR(cntr.bkg_tro_no,2,1)" ).append("\n"); 
		query.append(",'E',NVL(cntr.eq_no,'-STORMBOY-')" ).append("\n"); 
		query.append(",rf.cntr_no)" ).append("\n"); 
		query.append("AND NVL(cntr.spcl_cgo_cntr_tp_cd,'-STORMBOY-') = DECODE(SUBSTR(cntr.bkg_tro_no,2,1)" ).append("\n"); 
		query.append(",'E',NVL(cntr.spcl_cgo_cntr_tp_cd,'-STORMBOY-')" ).append("\n"); 
		query.append(",'RF')" ).append("\n"); 

	}
}