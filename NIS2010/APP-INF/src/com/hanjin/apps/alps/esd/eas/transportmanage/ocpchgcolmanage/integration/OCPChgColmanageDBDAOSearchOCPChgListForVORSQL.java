/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OCPChgColmanageDBDAOSearchOCPChgListForVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.16
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.09.16 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OCPChgColmanageDBDAOSearchOCPChgListForVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOCPChgListVO 생성
	  * </pre>
	  */
	public OCPChgColmanageDBDAOSearchOCPChgListForVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.integration").append("\n"); 
		query.append("FileName : OCPChgColmanageDBDAOSearchOCPChgListForVORSQL").append("\n"); 
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
		query.append("/* SearchOCPChgListVO 생성 쿼리*/			" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" ''  s_ctrl_ofc_cd" ).append("\n"); 
		query.append(", '' s_mt_rtn_cd" ).append("\n"); 
		query.append(", '' s_bkg_no" ).append("\n"); 
		query.append(", '' s_cnee_no" ).append("\n"); 
		query.append(", '' fm_dt " ).append("\n"); 
		query.append(", '' to_dt" ).append("\n"); 
		query.append(", '' ctrl_ofc_cd" ).append("\n"); 
		query.append(", '' bkg_sts_cd" ).append("\n"); 
		query.append(", '' bkg_no" ).append("\n"); 
		query.append(", '' cntr_no" ).append("\n"); 
		query.append(", '' ts_cd" ).append("\n"); 
		query.append(", '' rcv_tm" ).append("\n"); 
		query.append(", '' del_tm" ).append("\n"); 
		query.append(", '' shpr_no" ).append("\n"); 
		query.append(", '' cnee_no" ).append("\n"); 
		query.append(", '' por_cd" ).append("\n"); 
		query.append(", '' pol_cd" ).append("\n"); 
		query.append(", '' pod_cd" ).append("\n"); 
		query.append(", '' del_cd" ).append("\n"); 
		query.append(", '' sc_rfa_cd" ).append("\n"); 
		query.append(", '' ib_rlse_cd" ).append("\n"); 
		query.append(", '' ib_rlse_dt" ).append("\n"); 
		query.append(", '' ib_rlse_cnt" ).append("\n"); 
		query.append(", '' mt_rtn_cd" ).append("\n"); 
		query.append(", '' mt_rtn_dt" ).append("\n"); 
		query.append(", '' bkg_ocp_tp" ).append("\n"); 
		query.append(", '' bkg_ocp_amt" ).append("\n"); 
		query.append(", '' tpb_cd" ).append("\n"); 
		query.append(", '' rmk_ctnt" ).append("\n"); 
		query.append(", '' upd_usr_id" ).append("\n"); 
		query.append(", '' cre_usr_id" ).append("\n"); 
		query.append(", '' cre_ofc_cd" ).append("\n"); 
		query.append(", '' eas_expn_tp_cd" ).append("\n"); 
		query.append(", '' del_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}