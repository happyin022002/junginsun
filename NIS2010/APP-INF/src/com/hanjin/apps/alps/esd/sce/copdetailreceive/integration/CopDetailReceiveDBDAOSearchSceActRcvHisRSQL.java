/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchSceActRcvHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchSceActRcvHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSceActRcvHis
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchSceActRcvHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchSceActRcvHisRSQL").append("\n"); 
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
		query.append("SELECT act_rcv_dt" ).append("\n"); 
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
		query.append("FROM SCE_ACT_RCV_HIS" ).append("\n"); 
		query.append("WHERE ACT_RCV_DT = @[act_rcv_dt]" ).append("\n"); 
		query.append("AND   ACT_RCV_NO = @[act_rcv_no]" ).append("\n"); 

	}
}