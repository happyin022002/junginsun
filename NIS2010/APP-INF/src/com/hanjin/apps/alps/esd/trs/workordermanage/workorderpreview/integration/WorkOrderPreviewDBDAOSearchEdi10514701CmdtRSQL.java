/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi10514701CmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.04
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.08.04 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi10514701CmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_105147_01_CMDT
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi10514701CmdtRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi10514701CmdtRSQL").append("\n"); 
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
		query.append("SELECT (SELECT doc.cstms_desc" ).append("\n"); 
		query.append("FROM bkg_bl_doc doc" ).append("\n"); 
		query.append("WHERE doc.bkg_no = so.bkg_no) cmdt_desc" ).append("\n"); 
		query.append(",bkg.pck_tp_cd pkg_tp" ).append("\n"); 
		query.append(",pck.pck_nm pkg_desc" ).append("\n"); 
		query.append(",bkg.pck_qty pkg_cnt" ).append("\n"); 
		query.append("FROM bkg_container bkg" ).append("\n"); 
		query.append(",mdm_pck_tp pck" ).append("\n"); 
		query.append(",bkg_eur_tro th" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append(",mdm_commodity cm" ).append("\n"); 
		query.append("WHERE so.delt_flg	= 'N'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND so.bkg_no = bkg.bkg_no(+)" ).append("\n"); 
		query.append("AND so.eq_no = bkg.cntr_no(+)" ).append("\n"); 
		query.append("AND so.bkg_no = th.bkg_no(+)" ).append("\n"); 
		query.append("AND bkg.pck_tp_cd = pck.pck_cd(+)" ).append("\n"); 
		query.append("AND so.tro_seq = th.tro_seq(+)" ).append("\n"); 
		query.append("AND so.cmdt_cd = cm.cmdt_cd" ).append("\n"); 

	}
}