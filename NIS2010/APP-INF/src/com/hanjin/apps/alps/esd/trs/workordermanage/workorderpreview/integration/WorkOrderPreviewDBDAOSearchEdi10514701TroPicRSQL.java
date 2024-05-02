/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi10514701TroPicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.20 
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

public class WorkOrderPreviewDBDAOSearchEdi10514701TroPicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi10514701TroPic
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi10514701TroPicRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi10514701TroPicRSQL").append("\n"); 
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
		query.append("SELECT usr.usr_nm tro_pic_name" ).append("\n"); 
		query.append(",usr.xtn_phn_no tro_pic_tel" ).append("\n"); 
		query.append(",org.intl_fax_no||org.ofc_fax_no tro_pic_fax" ).append("\n"); 
		query.append(",usr.usr_eml tro_pic_email" ).append("\n"); 
		query.append("FROM com_user usr" ).append("\n"); 
		query.append(",mdm_organization org" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND DECODE(LENGTH(TRIM(so.upd_usr_id)),0,so.cre_usr_id,so.upd_usr_id) = usr.usr_id" ).append("\n"); 
		query.append("AND usr.ofc_cd = org.ofc_cd" ).append("\n"); 

	}
}