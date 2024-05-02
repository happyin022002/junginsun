/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderDetailDBDAOsearchWorkOrderDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.06.02 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderDetailDBDAOsearchWorkOrderDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Work Order Detail 정보를 조회 한다.
	  * </pre>
	  */
	public WorkOrderDetailDBDAOsearchWorkOrderDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_dvsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderDetailDBDAOsearchWorkOrderDetailRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT so.fm_nod_cd fm_code ," ).append("\n"); 
		query.append("	   yd1.yd_nm fm_full_name ," ).append("\n"); 
		query.append("	   yd1.yd_addr fm_address ," ).append("\n"); 
		query.append("	   yd1.phn_no fm_tel ," ).append("\n"); 
		query.append("	   yd1.fax_no fm_fax ," ).append("\n"); 
		query.append("	   yd1.yd_pic_nm fm_pic ," ).append("\n"); 
		query.append("	   so.via_nod_cd via_code ," ).append("\n"); 
		query.append("	   yd2.yd_nm via_full_name ," ).append("\n"); 
		query.append("	   yd2.yd_addr via_address ," ).append("\n"); 
		query.append("	   yd2.phn_no via_tel ," ).append("\n"); 
		query.append("	   yd2.fax_no via_fax ," ).append("\n"); 
		query.append("	   yd2.yd_pic_nm via_pic ," ).append("\n"); 
		query.append("	   so.to_nod_cd to_code ," ).append("\n"); 
		query.append("	   yd3.yd_nm to_full_name ," ).append("\n"); 
		query.append("	   yd3.yd_addr to_address ," ).append("\n"); 
		query.append("	   yd3.phn_no to_tel ," ).append("\n"); 
		query.append("	   yd3.fax_no to_fax ," ).append("\n"); 
		query.append("	   yd3.yd_pic_nm to_pic ," ).append("\n"); 
		query.append("	   so.dor_nod_cd dor_code ," ).append("\n"); 
		query.append("	   (select zn_nm from mdm_zone where zn_cd = so.dor_nod_cd) zn_nm ," ).append("\n"); 
		query.append("	   so.fctry_nm dor_full_name ," ).append("\n"); 
		query.append("	   so.dor_de_addr dor_address ," ).append("\n"); 
		query.append("	   so.cntc_pson_phn_no dor_tel ," ).append("\n"); 
		query.append("	   so.cntc_pson_fax_no dor_fax ," ).append("\n"); 
		query.append("	   so.cntc_pson_nm dor_pic " ).append("\n"); 
		query.append("	FROM trs_trsp_wrk_ord wo," ).append("\n"); 
		query.append("	  (" ).append("\n"); 
		query.append("	    SELECT s.trsp_so_ofc_cty_cd ," ).append("\n"); 
		query.append("	      s.trsp_so_seq ," ).append("\n"); 
		query.append("	      r.trsp_wo_ofc_cty_cd ," ).append("\n"); 
		query.append("	      r.trsp_wo_seq ," ).append("\n"); 
		query.append("	      s.fm_nod_cd ," ).append("\n"); 
		query.append("	      s.via_nod_cd ," ).append("\n"); 
		query.append("	      s.to_nod_cd ," ).append("\n"); 
		query.append("	      s.dor_nod_cd ," ).append("\n"); 
		query.append("	      s.fctry_nm ," ).append("\n"); 
		query.append("	      s.dor_de_addr ," ).append("\n"); 
		query.append("	      s.cntc_pson_phn_no ," ).append("\n"); 
		query.append("	      s.cntc_pson_fax_no ," ).append("\n"); 
		query.append("	      s.cntc_pson_nm" ).append("\n"); 
		query.append("	    FROM trs_trsp_wrk_ord_rjct_his r," ).append("\n"); 
		query.append("	      trs_trsp_svc_ord s" ).append("\n"); 
		query.append("	    WHERE r.trsp_so_ofc_cty_cd = s.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("	      AND r.trsp_so_seq = s.trsp_so_seq" ).append("\n"); 
		query.append("		  AND (s.trsp_wo_ofc_cty_cd, s.trsp_wo_seq ) IN ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("	    UNION ALL" ).append("\n"); 
		query.append("	    SELECT s.trsp_so_ofc_cty_cd ," ).append("\n"); 
		query.append("	      s.trsp_so_seq ," ).append("\n"); 
		query.append("	      s.trsp_wo_ofc_cty_cd ," ).append("\n"); 
		query.append("	      s.trsp_wo_seq ," ).append("\n"); 
		query.append("	      s.fm_nod_cd ," ).append("\n"); 
		query.append("	      s.via_nod_cd ," ).append("\n"); 
		query.append("	      s.to_nod_cd ," ).append("\n"); 
		query.append("	      s.dor_nod_cd ," ).append("\n"); 
		query.append("	      s.fctry_nm ," ).append("\n"); 
		query.append("	      s.dor_de_addr ," ).append("\n"); 
		query.append("	      s.cntc_pson_phn_no ," ).append("\n"); 
		query.append("	      s.cntc_pson_fax_no ," ).append("\n"); 
		query.append("	      s.cntc_pson_nm" ).append("\n"); 
		query.append("	    FROM trs_trsp_svc_ord s" ).append("\n"); 
		query.append("	    WHERE s.trsp_wo_ofc_cty_cd IS NOT NULL" ).append("\n"); 
		query.append("	      AND s.trsp_wo_seq IS NOT NULL " ).append("\n"); 
		query.append("          AND (s.trsp_wo_ofc_cty_cd, s.trsp_wo_seq ) IN ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))) so ," ).append("\n"); 
		query.append("	  mdm_yard yd1 ," ).append("\n"); 
		query.append("	  mdm_yard yd2 ," ).append("\n"); 
		query.append("	  mdm_yard yd3" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	  AND ((@[vndr_dvsn] = 'S' and wo.wo_vndr_seq IN ( SELECT vndr_seq" ).append("\n"); 
		query.append("	                                FROM mdm_vendor" ).append("\n"); 
		query.append("	                               WHERE prnt_vndr_seq = (SELECT prnt_vndr_seq" ).append("\n"); 
		query.append("	                                                         FROM mdm_vendor" ).append("\n"); 
		query.append("	                                                         WHERE 1=1" ).append("\n"); 
		query.append("	                                                        AND vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("	                                                      )" ).append("\n"); 
		query.append("	                           )" ).append("\n"); 
		query.append("        ) OR @[vndr_dvsn] = 'M')" ).append("\n"); 
		query.append("      AND ( wo.trsp_wo_ofc_cty_cd, wo.trsp_wo_seq ) IN ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("	  AND so.fm_nod_cd = yd1.yd_cd(+)" ).append("\n"); 
		query.append("   	  AND so.via_nod_cd = yd2.yd_cd(+)" ).append("\n"); 
		query.append("   	  AND so.to_nod_cd = yd3.yd_cd(+)" ).append("\n"); 

	}
}