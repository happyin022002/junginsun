/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi10514701TroMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2012.06.13 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi10514701TroMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_105147_01_TroMaster
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi10514701TroMasterRSQL(){
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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi10514701TroMasterRSQL").append("\n"); 
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
		query.append("SELECT so.trsp_so_seq as so_nbr" ).append("\n"); 
		query.append(",NVL(SO.TRSP_WO_OFC_CTY_CD||SO.TRSP_WO_SEQ,@[trsp_wo_ofc_cty_cd] || @[trsp_wo_seq]) AS WO_NBR" ).append("\n"); 
		query.append(",DECODE(wo.wo_iss_sts_cd,'I','I','R','R','C','E','C') as udt_flag" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(wo.wo_rmk ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) as trm_remark" ).append("\n"); 
		query.append(",th.t1_doc_flg as t1_ind" ).append("\n"); 
		query.append("FROM bkg_eur_tro th" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so, trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("WHERE so.trsp_wo_ofc_cty_cd = wo.trsp_wo_ofc_cty_cd(+)" ).append("\n"); 
		query.append("AND so.trsp_wo_seq = wo.trsp_wo_seq(+)" ).append("\n"); 
		query.append("AND so.bkg_no = th.bkg_no(+)" ).append("\n"); 
		query.append("AND so.tro_seq = th.tro_seq(+)" ).append("\n"); 
		query.append("AND so.delt_flg	<> 'Y'" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 

	}
}