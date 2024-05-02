/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiUsa01CmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdiUsa01CmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiUsa01Cmdt
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiUsa01CmdtRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiUsa01CmdtRSQL").append("\n"); 
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
		query.append("SELECT REPLACE('', CHR(13)||CHR(10), ' ') as cmdt_desc" ).append("\n"); 
		query.append("	  ,BKG.PCK_TP_CD 	PKG_TP" ).append("\n"); 
		query.append("	  ,pck.pck_nm as pkg_desc" ).append("\n"); 
		query.append("  	  ,bkg.pck_qty as pkg_cnt" ).append("\n"); 
		query.append(" FROM bkg_container bkg" ).append("\n"); 
		query.append("	  ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("	  ,mdm_pck_tp pck" ).append("\n"); 
		query.append(" WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("   AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND so.bkg_no = bkg.bkg_no(+)" ).append("\n"); 
		query.append("   AND so.eq_no = bkg.cntr_no(+)" ).append("\n"); 
		query.append("   AND BKG.PCK_tp_CD = PCK.PCK_CD(+) " ).append("\n"); 

	}
}