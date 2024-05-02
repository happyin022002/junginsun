/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiUsaTroPicRSQL.java
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

public class WorkOrderPreviewDBDAOSearchEdiUsaTroPicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_USA_TRO_PIC
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiUsaTroPicRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiUsaTroPicRSQL").append("\n"); 
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
		query.append("SELECT usr.usr_nm as tro_pic_name" ).append("\n"); 
		query.append("	,REPLACE(ORG.OFC_ADDR, CHR(13)||CHR(10), ' ') as tro_pic_addr" ).append("\n"); 
		query.append("	,'' as tro_pic_city" ).append("\n"); 
		query.append("	,'' as tro_pic_state" ).append("\n"); 
		query.append("	,org.ofc_zip_cd	as tro_pic_zip" ).append("\n"); 
		query.append("	,usr.xtn_phn_no	as tro_pic_tel" ).append("\n"); 
		query.append("  ,org.ofc_fax_no	as tro_pic_fax" ).append("\n"); 
		query.append("	,usr.usr_eml as tro_pic_email	" ).append("\n"); 
		query.append("FROM	com_user usr" ).append("\n"); 
		query.append("	,mdm_organization org" ).append("\n"); 
		query.append("	,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND DECODE(LENGTH(TRIM(so.upd_usr_id)),0,so.cre_usr_id,so.upd_usr_id) = usr.usr_id" ).append("\n"); 
		query.append("AND usr.ofc_cd = org.ofc_cd" ).append("\n"); 

	}
}