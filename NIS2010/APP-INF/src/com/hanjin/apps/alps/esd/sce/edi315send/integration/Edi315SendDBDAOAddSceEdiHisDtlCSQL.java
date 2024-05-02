/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceEdiHisDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.22 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceEdiHisDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for adding sce_edi_his_dtl
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceEdiHisDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_itval_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vsl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_conti_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_auto_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("log_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cnt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_evnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_conti_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_cntr_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("host_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cnt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceEdiHisDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_EDI_HIS_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("edi_rcv_dt" ).append("\n"); 
		query.append(",edi_rcv_seq" ).append("\n"); 
		query.append(",edi_rcv_dtl_seq" ).append("\n"); 
		query.append(",edi_grp_cd" ).append("\n"); 
		query.append(",prov_trd_prnr_id" ).append("\n"); 
		query.append(",cust_trd_prnr_id" ).append("\n"); 
		query.append(",org_edi_sts_cd" ).append("\n"); 
		query.append(",edi_stnd_sts_cd" ).append("\n"); 
		query.append(",cust_edi_sts_cd" ).append("\n"); 
		query.append(",edi_sav_flg" ).append("\n"); 
		query.append(",co_div_cd" ).append("\n"); 
		query.append(",edi_evnt_cd" ).append("\n"); 
		query.append(",edi_vsl_tp_cd" ).append("\n"); 
		query.append(",edi_snd_itval_hrmnt" ).append("\n"); 
		query.append(",edi_cntr_snd_tp_cd" ).append("\n"); 
		query.append(",org_conti_desc" ).append("\n"); 
		query.append(",org_dest_cnt_desc" ).append("\n"); 
		query.append(",dest_conti_desc" ).append("\n"); 
		query.append(",dest_cnt_desc" ).append("\n"); 
		query.append("--,edi_cgo_rmk" ).append("\n"); 
		query.append(",edi_auto_snd_flg" ).append("\n"); 
		query.append(",edi_rmk1" ).append("\n"); 
		query.append(",edi_rmk2" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",bkg_no" ).append("\n"); 
		query.append(",bl_no" ).append("\n"); 
		query.append(",cop_no" ).append("\n"); 
		query.append(",cntr_no" ).append("\n"); 
		query.append(",rslt_flg" ).append("\n"); 
		query.append(",edi_snd_rslt_rmk" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[rcv_dt]--rcv_dt" ).append("\n"); 
		query.append(",@[rcv_seq]--rcv_seq" ).append("\n"); 
		query.append(",@[rcv_dtl_seq]--rcv_dtl_seq" ).append("\n"); 
		query.append(",@[edi_grp_cd]--edi_grp_cd" ).append("\n"); 
		query.append(",@[host_tp_id]--host_tp_id" ).append("\n"); 
		query.append(",@[cust_tp_id]--cust_tp_id" ).append("\n"); 
		query.append(",@[org_edi_sts]--org_edi_sts" ).append("\n"); 
		query.append(",@[edi_sts]--edi_sts" ).append("\n"); 
		query.append(",@[cust_edi_sts_cd]--cust_edi_sts_cd" ).append("\n"); 
		query.append(",@[log_flg]--edi_sav_flg" ).append("\n"); 
		query.append(",@[co_div_cd]--co_div_cd" ).append("\n"); 
		query.append(",@[edi_evnt_cd]--edi_evnt_cd" ).append("\n"); 
		query.append(",@[edi_vsl_tp_cd]--edi_vsl_tp_cd" ).append("\n"); 
		query.append(",nvl(@[edi_snd_itval_hrmnt],0)--edi_snd_itval_hrmnt" ).append("\n"); 
		query.append(",@[edi_cntr_snd_tp_cd]--edi_cntr_snd_tp_cd" ).append("\n"); 
		query.append(",@[org_conti_desc]--org_conti_desc" ).append("\n"); 
		query.append(",@[org_dest_cnt_desc]--org_dest_cnt_desc" ).append("\n"); 
		query.append(",@[dest_conti_desc]--dest_conti_desc" ).append("\n"); 
		query.append(",@[dest_cnt_desc]--dest_cnt_desc" ).append("\n"); 
		query.append(",@[edi_auto_snd_flg]--edi_auto_snd_flg" ).append("\n"); 
		query.append(",''--edi_rmk1" ).append("\n"); 
		query.append(",''--edi_rmk2" ).append("\n"); 
		query.append(",nvl(@[cre_usr_id],'-')" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",nvl(@[upd_usr_id],'-')" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[bkg_no]--bkg_no" ).append("\n"); 
		query.append(",@[bl_no]--bl_no" ).append("\n"); 
		query.append(",@[cop_no]--cop_no" ).append("\n"); 
		query.append(",@[cntr_no]--cntr_no" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}