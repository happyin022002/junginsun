/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOAddSceActRcvHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOAddSceActRcvHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceActRcvHis
	  * </pre>
	  */
	public CopDetailReceiveDBDAOAddSceActRcvHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_umch_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_dest_n1st_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_rslt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_rslt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_vskd_seq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dup_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_snd_rslt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("umch_chk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOAddSceActRcvHisCSQL").append("\n"); 
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
		query.append("insert into sce_act_rcv_his(" ).append("\n"); 
		query.append("act_rcv_dt" ).append("\n"); 
		query.append(",act_rcv_no" ).append("\n"); 
		query.append(",cntr_no" ).append("\n"); 
		query.append(",bkg_no" ).append("\n"); 
		query.append(",act_dt" ).append("\n"); 
		query.append(",act_gdt" ).append("\n"); 
		query.append(",act_sts_mapg_cd" ).append("\n"); 
		query.append(",nod_cd" ).append("\n"); 
		query.append(",act_rcv_tp_cd" ).append("\n"); 
		query.append(",vsl_cd" ).append("\n"); 
		query.append(",skd_voy_no" ).append("\n"); 
		query.append(",skd_dir_cd" ).append("\n"); 
		query.append(",clpt_ind_seq" ).append("\n"); 
		query.append(",vps_port_cd" ).append("\n"); 
		query.append(",edi_msg_tp_cd" ).append("\n"); 
		query.append(",err_msg" ).append("\n"); 
		query.append(",cop_no" ).append("\n"); 
		query.append(",eml_snd_rslt_flg" ).append("\n"); 
		query.append(",edi_snd_rslt_flg" ).append("\n"); 
		query.append(",fax_snd_rslt_flg" ).append("\n"); 
		query.append(",vndr_seq" ).append("\n"); 
		query.append(",mst_bkg_no" ).append("\n"); 
		query.append(",trsp_clz_flg" ).append("\n"); 
		query.append(",act_cd" ).append("\n"); 
		query.append(",act_umch_tp_cd" ).append("\n"); 
		query.append(",umch_chk_dt" ).append("\n"); 
		query.append(",rail_dest_n1st_eta_dt" ).append("\n"); 
		query.append(",bnd_vskd_seq_cd" ).append("\n"); 
		query.append(",cre_tp_cd" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",act_gap_desc" ).append("\n"); 
		query.append(",mst_cop_no" ).append("\n"); 
		query.append(",dup_flg" ).append("\n"); 
		query.append(")values(" ).append("\n"); 
		query.append("to_char(sysdate,'YYYYMMDD')" ).append("\n"); 
		query.append(",sce_act_rcv_his_seq1.nextval" ).append("\n"); 
		query.append(",nvl(@[cntr_no],'*')" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",to_date(@[act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",to_date(@[act_gdt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[act_sts_mapg_cd]" ).append("\n"); 
		query.append(",@[nod_cd]" ).append("\n"); 
		query.append(",@[act_rcv_tp_cd]" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[clpt_ind_seq]" ).append("\n"); 
		query.append(",@[vps_port_cd]" ).append("\n"); 
		query.append(",@[edi_msg_tp_cd]" ).append("\n"); 
		query.append(",@[err_msg]" ).append("\n"); 
		query.append(",@[cop_no]" ).append("\n"); 
		query.append(",@[eml_snd_rslt_flg]" ).append("\n"); 
		query.append(",@[edi_snd_rslt_flg]" ).append("\n"); 
		query.append(",@[fax_snd_rslt_flg]" ).append("\n"); 
		query.append(",to_number(@[vndr_seq])" ).append("\n"); 
		query.append(",@[mst_bkg_no]" ).append("\n"); 
		query.append(",@[trsp_clz_flg]" ).append("\n"); 
		query.append(",@[act_cd]" ).append("\n"); 
		query.append(",@[act_umch_tp_cd]" ).append("\n"); 
		query.append(",to_date(@[umch_chk_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",to_date(@[rail_dest_n1st_eta_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[bnd_vskd_seq_cd]" ).append("\n"); 
		query.append(",@[cre_tp_cd]" ).append("\n"); 
		query.append(",nvl(@[cre_usr_id],'*')" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",nvl(@[upd_usr_id],'*')" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",TO_CHAR((TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS') - TO_DATE(@[upd_dt],'YYYY/MM/DD HH24:MI:SS')),'0.0000000000')" ).append("\n"); 
		query.append(",@[mst_cop_no]" ).append("\n"); 
		query.append(",@[dup_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}