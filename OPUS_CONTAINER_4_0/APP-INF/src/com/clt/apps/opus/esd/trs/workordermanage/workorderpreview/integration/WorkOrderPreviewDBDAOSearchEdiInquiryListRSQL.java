/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.19 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdiInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiInquiryList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiInquiryListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiInquiryListRSQL").append("\n"); 
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
		query.append("SELECT b.eq_no" ).append("\n"); 
		query.append(", b.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(", b.trsp_so_seq" ).append("\n"); 
		query.append(", b.trsp_so_ofc_cty_cd||b.trsp_so_seq trsp_so_ofc_cty_cd_seq" ).append("\n"); 
		query.append(", TO_CHAR(his.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') edi_iss_dt" ).append("\n"); 
		query.append(", NVL(b.edi_rcv_rslt_msg, his.wo_edi_rcv_rslt_msg) edi_rcv_rslt_msg" ).append("\n"); 
		query.append(", NVL(b.edi_rcv_rslt_cd, his.wo_edi_rcv_rslt_cd) edi_rcv_rslt_cd" ).append("\n"); 
		query.append(", TO_CHAR(NVL(b.edi_rcv_rslt_dt, his.wo_edi_rcv_rslt_dt) , 'YYYYMMDDHH24MISS')  edi_rcv_rslt_dt" ).append("\n"); 
		query.append("FROM trs_trsp_wrk_ord a" ).append("\n"); 
		query.append(", trs_trsp_svc_ord b" ).append("\n"); 
		query.append(", trs_trsp_wrk_ord_his his" ).append("\n"); 
		query.append("WHERE a.trsp_wo_ofc_cty_cd = his.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("AND a.trsp_wo_seq = his.trsp_wo_seq" ).append("\n"); 
		query.append("AND a.trsp_wo_ofc_cty_cd	= @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND a.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("AND a.trsp_wo_ofc_cty_cd = b.trsp_wo_ofc_cty_cd(+)" ).append("\n"); 
		query.append("AND a.trsp_wo_seq = b.trsp_wo_seq(+)" ).append("\n"); 

	}
}