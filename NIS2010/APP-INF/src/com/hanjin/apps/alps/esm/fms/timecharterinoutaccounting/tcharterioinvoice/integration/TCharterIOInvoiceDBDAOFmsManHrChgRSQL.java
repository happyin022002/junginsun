/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsManHrChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.11 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOFmsManHrChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manhour List Select
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsManHrChgRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("A.slp_tp_cd," ).append("\n"); 
		query.append("A.slp_func_cd," ).append("\n"); 
		query.append("A.slp_ofc_cd slp_team_cd," ).append("\n"); 
		query.append("A.slp_iss_dt," ).append("\n"); 
		query.append("A.slp_ser_no," ).append("\n"); 
		query.append("A.slp_seq_no," ).append("\n"); 
		query.append("A.man_hr_list_seq," ).append("\n"); 
		query.append("A.man_hr_list_seq org_man_hr_list_seq," ).append("\n"); 
		query.append("B.man_hr_itm_nm," ).append("\n"); 
		query.append("A.port_cd," ).append("\n"); 
		query.append("A.mgr_wrk_amt," ).append("\n"); 
		query.append("A.mbr_wrk_amt," ).append("\n"); 
		query.append("A.agn_wrk_amt," ).append("\n"); 
		query.append("A.curr_cd," ).append("\n"); 
		query.append("C.csr_slp_flg" ).append("\n"); 
		query.append("from fms_ownr_acct_slp C, fms_man_hr_chg A, fms_man_hr_list B" ).append("\n"); 
		query.append("where	C.slp_tp_cd = A.slp_tp_cd" ).append("\n"); 
		query.append("and C.slp_func_cd = A.slp_func_cd" ).append("\n"); 
		query.append("and C.slp_ofc_cd = A.slp_ofc_cd" ).append("\n"); 
		query.append("and C.slp_iss_dt = A.slp_iss_dt" ).append("\n"); 
		query.append("and C.slp_ser_no = A.slp_ser_no" ).append("\n"); 
		query.append("and C.slp_seq_no = A.slp_seq_no" ).append("\n"); 
		query.append("and A.man_hr_list_seq = B.man_hr_list_seq" ).append("\n"); 
		query.append("and A.slp_tp_cd = @[slp_tp_cd]" ).append("\n"); 
		query.append("and	A.slp_func_cd = @[slp_func_cd]" ).append("\n"); 
		query.append("and	A.slp_ofc_cd = @[slp_team_cd]" ).append("\n"); 
		query.append("and	A.slp_iss_dt = @[slp_iss_dt]" ).append("\n"); 
		query.append("and	A.slp_ser_no = @[slp_ser_no]" ).append("\n"); 
		query.append("and	A.slp_seq_no = @[slp_seq_no]" ).append("\n"); 
		query.append("order by A.curr_cd, B.man_hr_itm_nm" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsManHrChgRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}