/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesTorAudDBDAOMakeRehandlingExpenseTorVsTpbVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.testoraud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesTorAudDBDAOMakeRehandlingExpenseTorVsTpbVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO for Rehandling Expense - TOR vs. TPB
	  * </pre>
	  */
	public TesTorAudDBDAOMakeRehandlingExpenseTorVsTpbVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.testoraud.integration").append("\n"); 
		query.append("FileName : TesTorAudDBDAOMakeRehandlingExpenseTorVsTpbVORSQL").append("\n"); 
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
		query.append("SELECT   ''	s_rhq_ofc_cd" ).append("\n"); 
		query.append("        ,''	s_ofc_cd" ).append("\n"); 
		query.append("        ,''	s_fm_dt" ).append("\n"); 
		query.append("        ,''	s_to_dt" ).append("\n"); 
		query.append("        ,''	s_bkg_no" ).append("\n"); 
		query.append("        ,''	s_cntr_no" ).append("\n"); 
		query.append("        ,''	s_vvd" ).append("\n"); 
		query.append("        ,''	s_shift_rsn" ).append("\n"); 
		query.append("        ,''	s_tpb_flg" ).append("\n"); 
		query.append("        ,''	s_eac_if" ).append("\n"); 
		query.append("        ,''	chk" ).append("\n"); 
		query.append("        ,''	ofc_cd" ).append("\n"); 
		query.append("        ,''	port_cd" ).append("\n"); 
		query.append("        ,''	vvd" ).append("\n"); 
		query.append("        ,''	clpt_ind_seq" ).append("\n"); 
		query.append("        ,''	lane_cd" ).append("\n"); 
		query.append("        ,''	act_dep_dt" ).append("\n"); 
		query.append("        ,''	cntr_no" ).append("\n"); 
		query.append("        ,''	respb_cntr_no" ).append("\n"); 
		query.append("        ,''	sztp" ).append("\n"); 
		query.append("        ,''	pol" ).append("\n"); 
		query.append("        ,''	opr_cd" ).append("\n"); 
		query.append("        ,''	precell" ).append("\n"); 
		query.append("        ,''	position" ).append("\n"); 
		query.append("        ,''	shift_rsn" ).append("\n"); 
		query.append("        ,''	party" ).append("\n"); 
		query.append("        ,''	file_atch" ).append("\n"); 
		query.append("        ,''	tpb_no" ).append("\n"); 
		query.append("        ,''	tpb_amt_usd" ).append("\n"); 
		query.append("        ,''	tpb_ofc" ).append("\n"); 
		query.append("        ,''	tpb_pty_3rd" ).append("\n"); 
		query.append("        ,''	tpb_sts_nm" ).append("\n"); 
		query.append("        ,''	bkg_no" ).append("\n"); 
		query.append("        ,''	eac_if_flg" ).append("\n"); 
		query.append("		,'' rhnd_expn_seq" ).append("\n"); 
		query.append("		,'' s_port_cd" ).append("\n"); 
		query.append("		,'' s_trmnl_cd" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}