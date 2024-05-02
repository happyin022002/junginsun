/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortFltgCrnVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationMgtDBDAOVskPortFltgCrnVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortFltgCrnVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.REAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_rch_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hndl_cost_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fltg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.REAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_hndl_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.REAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_hndl_cgo_hgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortFltgCrnVOCSQL").append("\n"); 
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
		query.append("INSERT INTO vsk_port_fltg_crn (" ).append("\n"); 
		query.append("	loc_cd" ).append("\n"); 
		query.append(",	crn_seq" ).append("\n"); 
		query.append(",	max_hndl_cgo_wgt" ).append("\n"); 
		query.append(",	max_hndl_cgo_hgt" ).append("\n"); 
		query.append(",	max_rch_len" ).append("\n"); 
		query.append(",	hndl_cost_rmk" ).append("\n"); 
		query.append(",	fltg_rmk" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[loc_cd]" ).append("\n"); 
		query.append("--,	[crn_seq]" ).append("\n"); 
		query.append(",   (SELECT NVL(MAX(X.CRN_SEQ),0)+1   FROM vsk_port_fltg_crn X WHERE X.LOC_CD = @[loc_cd])" ).append("\n"); 
		query.append(",	@[max_hndl_cgo_wgt]" ).append("\n"); 
		query.append(",	@[max_hndl_cgo_hgt]" ).append("\n"); 
		query.append(",	@[max_rch_len]" ).append("\n"); 
		query.append(",	@[hndl_cost_rmk]" ).append("\n"); 
		query.append(",	@[fltg_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}