/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortGngStrVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.29 장석현
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

public class TerminalInformationMgtDBDAOVskPortGngStrVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortGngStrVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gng_nwork_st_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gng_wrk_st_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gng_nwork_end_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gng_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gng_wrk_end_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE vsk_port_gng_strc SET" ).append("\n"); 
		query.append("gng_wrk_st_hrmnt = @[gng_wrk_st_hrmnt]" ).append("\n"); 
		query.append(",	gng_wrk_end_hrmnt = @[gng_wrk_end_hrmnt]" ).append("\n"); 
		query.append(",	gng_nwork_st_hrmnt = @[gng_nwork_st_hrmnt]" ).append("\n"); 
		query.append(",	gng_nwork_end_hrmnt = @[gng_nwork_end_hrmnt]" ).append("\n"); 
		query.append(",	gng_rmk = @[gng_rmk]" ).append("\n"); 
		query.append(",	upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append(",	upd_dt = sysdate" ).append("\n"); 
		query.append("WHERE	loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("AND	crn_seq = @[crn_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.opf.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortGngStrVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}