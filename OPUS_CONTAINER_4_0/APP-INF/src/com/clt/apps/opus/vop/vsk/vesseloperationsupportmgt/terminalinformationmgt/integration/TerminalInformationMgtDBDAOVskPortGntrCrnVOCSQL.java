/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortGntrCrnVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.09 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TerminalInformationMgtDBDAOVskPortGntrCrnVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortGntrCrnVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "7,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_max_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "7,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clr_btwn_leg_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tr_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "7,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_max_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_rch_row_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "7,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_gntr_crn_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "7,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_gntr_crn_max_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO vsk_port_gntr_crn (" ).append("\n"); 
		query.append("yd_cd" ).append("\n"); 
		query.append(",	grs_max_wgt" ).append("\n"); 
		query.append(",	net_max_wgt" ).append("\n"); 
		query.append(",	clr_btwn_leg_wdt" ).append("\n"); 
		query.append(",	crn_rch_row_knt" ).append("\n"); 
		query.append(",	cntr_tr_knt" ).append("\n"); 
		query.append(",	ttl_gntr_crn_qty" ).append("\n"); 
		query.append(",	vsl_gntr_crn_max_qty" ).append("\n"); 
		query.append(",	gntr_rmk" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[yd_cd]" ).append("\n"); 
		query.append(",	@[grs_max_wgt]" ).append("\n"); 
		query.append(",	@[net_max_wgt]" ).append("\n"); 
		query.append(",	@[clr_btwn_leg_wdt]" ).append("\n"); 
		query.append(",	@[crn_rch_row_knt]" ).append("\n"); 
		query.append(",	@[cntr_tr_knt]" ).append("\n"); 
		query.append(",	@[ttl_gntr_crn_qty]" ).append("\n"); 
		query.append(",	@[vsl_gntr_crn_max_qty]" ).append("\n"); 
		query.append(",	@[gntr_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.opf.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortGntrCrnVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}