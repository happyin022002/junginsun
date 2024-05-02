/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDAOSingleTransportationSOManageSearchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2010.01.26 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDAOSingleTransportationSOManageSearchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SingleTransportationSOManageSearch
	  * </pre>
	  */
	public SingleTransportationSOManageDAOSingleTransportationSOManageSearchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDAOSingleTransportationSOManageSearchRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' hid_frmreqdate" ).append("\n"); 
		query.append(", '' hid_toreqdate" ).append("\n"); 
		query.append(", '' frm_reqdate" ).append("\n"); 
		query.append(", '' to_reqdate" ).append("\n"); 
		query.append(", '' sel_kind" ).append("\n"); 
		query.append(", '' ctrl_so_office" ).append("\n"); 
		query.append(", '' chk_office" ).append("\n"); 
		query.append(", '' frm_node" ).append("\n"); 
		query.append(", '' frm_yard" ).append("\n"); 
		query.append(", '' to_node" ).append("\n"); 
		query.append(", '' to_yard" ).append("\n"); 
		query.append(", '' cntr_type" ).append("\n"); 
		query.append(", '' cntr_size" ).append("\n"); 
		query.append(", '' reference_no" ).append("\n"); 
		query.append(", '' cntr_no" ).append("\n"); 
		query.append(", '' hid_ref_id" ).append("\n"); 
		query.append(", '' hid_fm_nod_cd" ).append("\n"); 
		query.append(", '' hid_to_nod_cd" ).append("\n"); 
		query.append(", '' hid_fm_yard_cd" ).append("\n"); 
		query.append(", '' hid_to_yard_cd" ).append("\n"); 
		query.append(", '' hid_eq_tpsz_cd" ).append("\n"); 
		query.append(", '' hid_trsp_cost_mod_cd" ).append("\n"); 
		query.append(", '' hid_trsp_crr_mod_cd" ).append("\n"); 
		query.append(", '' hid_cntr_no" ).append("\n"); 
		query.append(", '' hid_cntr_tpsz_cd" ).append("\n"); 
		query.append(", '' ctrl_ofc_cd" ).append("\n"); 
		query.append(", '' ctrl_user_id" ).append("\n"); 
		query.append(", '' TRSP_SO_EQ_KIND" ).append("\n"); 
		query.append(", '' eq_no_verify" ).append("\n"); 
		query.append(", '' frm_node_verify" ).append("\n"); 
		query.append(", '' old_ofc_cd" ).append("\n"); 
		query.append(", '' cbstatus" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}