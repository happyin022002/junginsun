/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOgetImdgPortRstrForKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.04 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOgetImdgPortRstrForKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOgetImdgPortRstrForKeyRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,N";
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("port_cd" ).append("\n"); 
		query.append(",	imdg_port_rstr_seq" ).append("\n"); 
		query.append(",	imdg_port_rstr_expt_flg" ).append("\n"); 
		query.append(",	imdg_un_no" ).append("\n"); 
		query.append(",	imdg_un_no_seq" ).append("\n"); 
		query.append(",	imdg_clss_cd" ).append("\n"); 
		query.append(",	prohi_lod_flg" ).append("\n"); 
		query.append(",	prohi_dchg_flg" ).append("\n"); 
		query.append(",	prohi_ts_flg" ).append("\n"); 
		query.append(",	prohi_pass_flg" ).append("\n"); 
		query.append(",	prohi_dy_tm_op_flg" ).append("\n"); 
		query.append(",	prohi_dy_tm_inlnd_tz_flg" ).append("\n"); 
		query.append(",	prohi_port_flg" ).append("\n"); 
		query.append(",	prohi_pinsp_flg" ).append("\n"); 
		query.append(",	xtra_hndl_chg_flg" ).append("\n"); 
		query.append(",	sft_gad_flg" ).append("\n"); 
		query.append(",	kep_sft_dist_ihb_flg" ).append("\n"); 
		query.append(",	kep_sft_dist_ihb_dist" ).append("\n"); 
		query.append(",	rstr_rmk" ).append("\n"); 
		query.append(",	prohi_ngt_flg" ).append("\n"); 
		query.append(",	dir_lod_flg" ).append("\n"); 
		query.append(",	dir_dchg_flg" ).append("\n"); 
		query.append(",	dir_ts_flg" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append("FROM scg_imdg_port_rstr" ).append("\n"); 
		query.append("WHERE	port_cd = @[port_cd]" ).append("\n"); 
		query.append("AND	imdg_port_rstr_seq = @[imdg_port_rstr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOgetImdgPortRstrForKeyRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}