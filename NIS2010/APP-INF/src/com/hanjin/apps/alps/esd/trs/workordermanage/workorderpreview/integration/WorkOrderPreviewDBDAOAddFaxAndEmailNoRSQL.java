/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddFaxAndEmailNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08 
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

public class WorkOrderPreviewDBDAOAddFaxAndEmailNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addFaxAndEmailNo
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddFaxAndEmailNoRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOAddFaxAndEmailNoRSQL").append("\n"); 
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
		query.append("SELECT NVL(b.trsp_wo_ofc_cty_cd, a.trsp_wo_ofc_cty_cd) trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append(",NVL(b.trsp_wo_seq, a.trsp_wo_seq) trsp_wo_seq" ).append("\n"); 
		query.append(",a.wo_iss_knt wo_iss_knt" ).append("\n"); 
		query.append(",a.wo_iss_sts_cd" ).append("\n"); 
		query.append("FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append(",trs_trsp_svc_ord b" ).append("\n"); 
		query.append("WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND a.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("AND a.trsp_so_ofc_cty_cd = b.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND a.trsp_so_seq = b.trsp_so_seq" ).append("\n"); 
		query.append("AND b.hjl_no IS NULL" ).append("\n"); 

	}
}