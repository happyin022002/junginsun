/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAODblEdiInRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.30 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAODblEdiInRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DblEdiInVO
	  * </pre>
	  */
	public BLIssuanceDBDAODblEdiInRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAODblEdiInRSQL").append("\n"); 
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
		query.append("SELECT '' AS bkg_no," ).append("\n"); 
		query.append("'' AS slct_flg," ).append("\n"); 
		query.append("'' AS ntc_knd_nm," ).append("\n"); 
		query.append("'' AS rank," ).append("\n"); 
		query.append("'' AS ref_code," ).append("\n"); 
		query.append("'' AS edi_receive_id_old," ).append("\n"); 
		query.append("'' AS edi_receive_id," ).append("\n"); 
		query.append("'' AS edi_sender," ).append("\n"); 
		query.append("'' AS eml_send_dt," ).append("\n"); 
		query.append("'' AS group_edi_cust," ).append("\n"); 
		query.append("'' AS group_edi_id," ).append("\n"); 
		query.append("'' AS group_nm," ).append("\n"); 
		query.append("'' AS result," ).append("\n"); 
		query.append("'' AS cnee_chk," ).append("\n"); 
		query.append("'' AS pkg_chk," ).append("\n"); 
		query.append("'' AS desc_chk," ).append("\n"); 
		query.append("'' AS cntr_check," ).append("\n"); 
		query.append("'' AS bl_no," ).append("\n"); 
		query.append("'' AS bl_dt," ).append("\n"); 
		query.append("'' AS bl_ofc," ).append("\n"); 
		query.append("'' AS bl_isu_chk," ).append("\n"); 
		query.append("'' AS bl_tp_cd," ).append("\n"); 
		query.append("'' AS bl_pkg_word," ).append("\n"); 
		query.append("'' AS ib_no," ).append("\n"); 
		query.append("'' AS ib_seq," ).append("\n"); 
		query.append("'' AS auto_manual_flg," ).append("\n"); 
		query.append("'' AS pre_rly_port_cd," ).append("\n"); 
		query.append("'' AS pst_rly_port_cd," ).append("\n"); 
		query.append("'' AS final_eta," ).append("\n"); 
		query.append("'' AS func_code," ).append("\n"); 
		query.append("'' AS tmp_cnt" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}