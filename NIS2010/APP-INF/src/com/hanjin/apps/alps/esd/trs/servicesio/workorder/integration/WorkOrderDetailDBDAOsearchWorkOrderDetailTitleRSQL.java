/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderDetailDBDAOsearchWorkOrderDetailTitleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.05.26 윤권영
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

public class WorkOrderDetailDBDAOsearchWorkOrderDetailTitleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderDetailTitle
	  * </pre>
	  */
	public WorkOrderDetailDBDAOsearchWorkOrderDetailTitleRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderDetailDBDAOsearchWorkOrderDetailTitleRSQL").append("\n"); 
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
		query.append("SELECT																																										" ).append("\n"); 
		query.append("		DISTINCT wo.trsp_wo_ofc_cty_cd ||wo.trsp_wo_seq trsp_wo_no,							  " ).append("\n"); 
		query.append("		wo.wo_iss_sts_cd Issue_type_cd,						                                  " ).append("\n"); 
		query.append("		decode(wo.wo_iss_sts_cd,'C','Correction',                                             " ).append("\n"); 
		query.append("		                        'I','Issued',                                                 " ).append("\n"); 
		query.append("		                        'J','Rejected',                                               " ).append("\n"); 
		query.append("		                        'N','Cancellation',                                           " ).append("\n"); 
		query.append("		                        'P','Partially Rejected',                                     " ).append("\n"); 
		query.append("		                        'R','Reissued' ) issue_type_nm,						          " ).append("\n"); 
		query.append("		so.trsp_cost_dtl_mod_cd ,	                                      					  " ).append("\n"); 
		query.append("		(SELECT	intg_cd_val_dp_desc	                                                          " ).append("\n"); 
		query.append("		   FROM com_intg_cd_dtl                                                               " ).append("\n"); 
		query.append("		  WHERE intg_cd_id = 'CD00744'                                    					  " ).append("\n"); 
		query.append("		  AND	intg_cd_val_ctnt = so.trsp_cost_dtl_mod_cd) trsp_kind_nm,   				  " ).append("\n"); 
		query.append("		so.trsp_crr_mod_cd,														              " ).append("\n"); 
		query.append("		(SELECT	intg_cd_val_dp_desc	                                                          " ).append("\n"); 
		query.append("		   FROM com_intg_cd_dtl                												  " ).append("\n"); 
		query.append("		  WHERE	intg_cd_id = 'CD00283'                                    					  " ).append("\n"); 
		query.append("		  AND	intg_cd_val_ctnt = so.trsp_crr_mod_cd) trsp_mode_nm,        				  " ).append("\n"); 
		query.append("		wo.wo_fmt_tp_cd trsp_so_cmb_tp_cd ,				                                      " ).append("\n"); 
		query.append("		decode(wo.wo_fmt_tp_cd,'CC','Combined Case 1',										  " ).append("\n"); 
		query.append("			  		           'CM','Combined Case 2',                                        " ).append("\n"); 
		query.append("			  		           'CY','Combined Case 2',                                        " ).append("\n"); 
		query.append("			  		           'IB','Combined Case 2',								          " ).append("\n"); 
		query.append("			  		           'NC','Normal',                                                 " ).append("\n"); 
		query.append("			  		           'MM','Empty' ) trsp_type_nm, 						          " ).append("\n"); 
		query.append("		to_char(wo.cre_dt, 'YYYY-MM-DD HH24:MI:SS') cre_dt,						              " ).append("\n"); 
		query.append("		so.dor_svc_tp_cd," ).append("\n"); 
		query.append("  		wo.cre_ofc_cd," ).append("\n"); 
		query.append("  		(SELECT USR_EML FROM COM_USER WHERE USR_ID = wo.cre_usr_id) cre_usr_eml 											  						  " ).append("\n"); 
		query.append(" FROM trs_trsp_wrk_ord wo,																								                " ).append("\n"); 
		query.append("		(SELECT                                                                               " ).append("\n"); 
		query.append("		  s.trsp_so_ofc_cty_cd                                                                " ).append("\n"); 
		query.append("		  ,s.trsp_so_seq                                                                      " ).append("\n"); 
		query.append("		  ,r.trsp_wo_ofc_cty_cd                                                               " ).append("\n"); 
		query.append("		  ,r.trsp_wo_seq                                                                      " ).append("\n"); 
		query.append("		  ,s.trsp_cost_dtl_mod_cd                                                             " ).append("\n"); 
		query.append("		  ,s.trsp_crr_mod_cd  																  " ).append("\n"); 
		query.append("		  ,s.dor_svc_tp_cd  																  " ).append("\n"); 
		query.append("		  FROM trs_trsp_wrk_ord_rjct_his r, trs_trsp_svc_ord s          					  " ).append("\n"); 
		query.append("		 WHERE r.trsp_so_ofc_cty_cd = s.trsp_so_ofc_cty_cd             						  " ).append("\n"); 
		query.append("		 AND   r.trsp_so_seq = s.trsp_so_seq                           						  " ).append("\n"); 
		query.append("		UNION ALL                                                     						  " ).append("\n"); 
		query.append("		SELECT                                                                                " ).append("\n"); 
		query.append("		  s.trsp_so_ofc_cty_cd                                                                " ).append("\n"); 
		query.append("		  ,s.trsp_so_seq                                                                      " ).append("\n"); 
		query.append("		  ,s.trsp_wo_ofc_cty_cd                                                               " ).append("\n"); 
		query.append("		  ,s.trsp_wo_seq                                                                      " ).append("\n"); 
		query.append("		  ,s.trsp_cost_dtl_mod_cd                                                             " ).append("\n"); 
		query.append("		  ,s.trsp_crr_mod_cd  																  " ).append("\n"); 
		query.append("		  ,s.dor_svc_tp_cd  																  " ).append("\n"); 
		query.append("		  FROM trs_trsp_svc_ord s 	  												  		  " ).append("\n"); 
		query.append("		WHERE s.trsp_wo_ofc_cty_cd IS NOT NULL   			                  				  " ).append("\n"); 
		query.append("		AND s.trsp_wo_seq IS NOT NULL  ) so																										" ).append("\n"); 
		query.append(" WHERE 1 = 1																																							" ).append("\n"); 
		query.append("   AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd(+)										  " ).append("\n"); 
		query.append("   AND wo.trsp_wo_seq = so.trsp_wo_seq(+)													  " ).append("\n"); 
		query.append("   AND wo.wo_vndr_seq IN ( SELECT vndr_seq                                              " ).append("\n"); 
		query.append("		                    FROM mdm_vendor                                         " ).append("\n"); 
		query.append("		                   WHERE prnt_vndr_seq = (SELECT prnt_vndr_seq                " ).append("\n"); 
		query.append("		                                            FROM mdm_vendor                 " ).append("\n"); 
		query.append("		                                           WHERE 1=1                   	" ).append("\n"); 
		query.append("		                                             AND vndr_seq = @[vndr_seq] ))               " ).append("\n"); 
		query.append("#if (${trsp_so_ofc_cty_cd} != '') " ).append("\n"); 
		query.append("	   AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]                                                          " ).append("\n"); 
		query.append("	   AND so.trsp_so_seq = @[trsp_so_seq]                                                               " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trsp_wo_ofc_cty_cd} != '') " ).append("\n"); 
		query.append("	   AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]                                                           " ).append("\n"); 
		query.append("	   AND wo.trsp_wo_seq = @[trsp_wo_seq]                                                                  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}