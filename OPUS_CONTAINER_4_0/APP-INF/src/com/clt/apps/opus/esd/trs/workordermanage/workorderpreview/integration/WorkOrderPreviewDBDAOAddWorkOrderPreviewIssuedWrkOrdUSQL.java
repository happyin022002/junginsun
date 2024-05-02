/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddWorkOrderPreviewIssuedWrkOrd
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_dis_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_dp_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_eml_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prn_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("wo_fmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_dp_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_n3rd_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_n1st_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_n2nd_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_n3rd_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_fax_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_edi_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inter_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_n1st_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_n2nd_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("WO_ISS_STS_CD          	= @[wo_iss_sts_cd]" ).append("\n"); 
		query.append(", WO_FMT_TP_CD		   	= @[wo_fmt_tp_cd]" ).append("\n"); 
		query.append(", WO_VNDR_SEQ		   	= @[wo_vndr_seq]" ).append("\n"); 
		query.append(", WO_PRN_USE_FLG	   	= @[wo_prn_use_flg]" ).append("\n"); 
		query.append(", WO_FAX_USE_FLG	   	= @[wo_fax_use_flg]" ).append("\n"); 
		query.append(", WO_EML_USE_FLG   	   	= @[wo_eml_use_flg]" ).append("\n"); 
		query.append(", WO_EDI_USE_FLG		= @[wo_edi_use_flg]" ).append("\n"); 
		query.append(", WO_N1ST_FAX_NO		= @[wo_n1st_fax_no]" ).append("\n"); 
		query.append(", WO_N2ND_FAX_NO		= @[wo_n2nd_fax_no]" ).append("\n"); 
		query.append(", WO_N3RD_FAX_NO   		= @[wo_n3rd_fax_no]" ).append("\n"); 
		query.append(", WO_N1ST_FAX_RSLT_FLG	= 'N'" ).append("\n"); 
		query.append(", WO_N2ND_FAX_RSLT_FLG	= 'N'" ).append("\n"); 
		query.append(", WO_N3RD_FAX_RSLT_FLG	= 'N'" ).append("\n"); 
		query.append(", WO_N1ST_EML	     	= @[wo_n1st_eml]" ).append("\n"); 
		query.append(", WO_N2ND_EML	     	= @[wo_n2nd_eml]" ).append("\n"); 
		query.append(", WO_N3RD_EML			= @[wo_n3rd_eml]" ).append("\n"); 
		query.append(", WO_N1ST_EML_RSLT_FLG	= 'N'" ).append("\n"); 
		query.append(", WO_N2ND_EML_RSLT_FLG	= 'N'" ).append("\n"); 
		query.append(", WO_N3RD_EML_RSLT_FLG	= 'N'" ).append("\n"); 
		query.append(", WO_RMK			    = @[wo_rmk]" ).append("\n"); 
		query.append(", RT_DP_USE_FLG		  	= @[rt_dp_use_flg]" ).append("\n"); 
		query.append(", CMDT_DP_USE_FLG	 	= @[cmdt_dp_use_flg]" ).append("\n"); 
		query.append(", PRE_DIS_USE_FLG		= @[pre_dis_use_flg]" ).append("\n"); 
		query.append(", INTER_USE_FLG		  	= @[inter_use_flg]" ).append("\n"); 
		query.append(", DELT_FLG		       	= 'N'" ).append("\n"); 
		query.append(", UPD_DT           		= SYSDATE" ).append("\n"); 
		query.append(", UPD_USR_ID       		= @[upd_usr_id]" ).append("\n"); 
		query.append(", LOCL_UPD_DT           = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("WHERE TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 

	}
}