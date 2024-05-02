/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOScgImdgPortRstrVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.28 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOScgImdgPortRstrVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PortRestrictionDBDAOScgImdgPortRstrVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_port_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_dy_tm_op_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N"; 
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_lod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtra_hndl_chg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_dchg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_ngt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_dy_tm_inlnd_tz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_dchg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_pass_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_port_rstr_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sft_gad_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_pinsp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kep_sft_dist_ihb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_lod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kep_sft_dist_ihb_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE scg_imdg_port_rstr" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("imdg_clss_cd                =   @[imdg_clss_cd]" ).append("\n"); 
		query.append(",	prohi_lod_flg               =   @[prohi_lod_flg]" ).append("\n"); 
		query.append(",	prohi_dchg_flg              =   @[prohi_dchg_flg]" ).append("\n"); 
		query.append(",	prohi_ts_flg                =   @[prohi_ts_flg]" ).append("\n"); 
		query.append(",	prohi_pass_flg              =   @[prohi_pass_flg]" ).append("\n"); 
		query.append(",	prohi_dy_tm_op_flg          =   @[prohi_dy_tm_op_flg]" ).append("\n"); 
		query.append(",	prohi_dy_tm_inlnd_tz_flg    =   @[prohi_dy_tm_inlnd_tz_flg]" ).append("\n"); 
		query.append(",	prohi_port_flg              =   @[prohi_port_flg]" ).append("\n"); 
		query.append(",	prohi_pinsp_flg             =   @[prohi_pinsp_flg]" ).append("\n"); 
		query.append(",	xtra_hndl_chg_flg           =   @[xtra_hndl_chg_flg]" ).append("\n"); 
		query.append(",	sft_gad_flg                 =   @[sft_gad_flg]" ).append("\n"); 
		query.append(",	kep_sft_dist_ihb_flg        =   @[kep_sft_dist_ihb_flg]" ).append("\n"); 
		query.append(",	kep_sft_dist_ihb_dist       =   @[kep_sft_dist_ihb_dist]" ).append("\n"); 
		query.append(",	rstr_rmk                    =   @[rstr_rmk]" ).append("\n"); 
		query.append(",	prohi_ngt_flg               =   @[prohi_ngt_flg]" ).append("\n"); 
		query.append(",	dir_lod_flg                 =   @[dir_lod_flg]" ).append("\n"); 
		query.append(",	dir_dchg_flg                =   @[dir_dchg_flg]" ).append("\n"); 
		query.append(",	dir_ts_flg                  =   @[dir_ts_flg]" ).append("\n"); 
		query.append(",	cre_usr_id                  =   @[cre_usr_id]" ).append("\n"); 
		query.append(",	cre_dt                      =   SYSDATE" ).append("\n"); 
		query.append(",	upd_usr_id                  =   @[upd_usr_id]" ).append("\n"); 
		query.append(",	upd_dt                      =   SYSDATE" ).append("\n"); 
		query.append(",	port_cd                     =   @[port_cd]" ).append("\n"); 
		query.append(",	imdg_port_rstr_seq          =   @[imdg_port_rstr_seq]" ).append("\n"); 
		query.append(",	imdg_port_rstr_expt_flg     =   @[imdg_port_rstr_expt_flg]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("imdg_un_no                =   @[imdg_un_no]" ).append("\n"); 
		query.append("AND imdg_un_no_seq            =   @[imdg_un_no_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOScgImdgPortRstrVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}