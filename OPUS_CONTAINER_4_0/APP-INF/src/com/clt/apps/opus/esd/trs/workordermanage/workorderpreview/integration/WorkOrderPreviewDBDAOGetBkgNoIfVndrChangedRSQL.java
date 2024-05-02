/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOGetBkgNoIfVndrChangedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.03.21 양봉준
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

public class WorkOrderPreviewDBDAOGetBkgNoIfVndrChangedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 so 건에 대해 bkg_no, vndr_seq 를 조회한다.
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOGetBkgNoIfVndrChangedRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOGetBkgNoIfVndrChangedRSQL").append("\n"); 
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
		query.append("a.vndr_seq" ).append("\n"); 
		query.append(", a.bkg_no" ).append("\n"); 
		query.append("from trs_trsp_svc_ord a, trs_trsp_wrk_ord_prv_tmp b" ).append("\n"); 
		query.append("where a.trsp_so_ofc_cty_cd = b.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("and a.trsp_so_seq = b.trsp_so_seq" ).append("\n"); 
		query.append("and b.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("and b.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("group by 	a.vndr_seq, a.bkg_no" ).append("\n"); 

	}
}