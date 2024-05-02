/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297ShDgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.17 
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

public class WorkOrderPreviewDBDAOSearchEdi102297ShDgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_SH_DG
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297ShDgRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297ShDgRSQL").append("\n"); 
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
		query.append("#if (${trsp_bnd_cd} == 'O' && ${trsp_cst_dtl_mod_cd} == 'DR')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT	dg.imdg_clss_cd dg_imo_class" ).append("\n"); 
		query.append(",dg.imdg_un_no dg_unno" ).append("\n"); 
		query.append(",NVL(dg.psa_no,' ') dg_psa_class" ).append("\n"); 
		query.append(",NVL(dg.psa_no,' ') dg_psa" ).append("\n"); 
		query.append("FROM bkg_dg_cgo dg" ).append("\n"); 
		query.append(",trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append(",BKG_TRO_SPCL_CGO_SEQ DG_SEQ" ).append("\n"); 
		query.append(",trs_spcl_cgo_pck_cd pck" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("AND so.bkg_no = dg.bkg_no" ).append("\n"); 
		query.append("AND dg.out_imdg_pck_cd1 = pck.spcl_cgo_pck_cd(+)" ).append("\n"); 
		query.append("AND SO.BKG_NO           = DG_SEQ.BKG_NO" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD      = DG_SEQ.IO_BND_CD" ).append("\n"); 
		query.append("AND SO.TRO_SEQ          = DG_SEQ.TRO_SEQ" ).append("\n"); 
		query.append("AND DG.DCGO_SEQ         = DG_SEQ.TRO_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT	dg.imdg_clss_cd dg_imo_class" ).append("\n"); 
		query.append(",dg.imdg_un_no dg_unno" ).append("\n"); 
		query.append(",NVL(dg.psa_no,' ') dg_psa_class" ).append("\n"); 
		query.append(",NVL(dg.psa_no,' ') dg_psa" ).append("\n"); 
		query.append("FROM bkg_dg_cgo dg" ).append("\n"); 
		query.append(",trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append(",trs_spcl_cgo_pck_cd pck" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("AND dg.out_imdg_pck_cd1 = pck.spcl_cgo_pck_cd(+)" ).append("\n"); 
		query.append("AND SO.BKG_NO           = DG.BKG_NO" ).append("\n"); 
		query.append("AND SO.EQ_NO            = DG.CNTR_NO" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}