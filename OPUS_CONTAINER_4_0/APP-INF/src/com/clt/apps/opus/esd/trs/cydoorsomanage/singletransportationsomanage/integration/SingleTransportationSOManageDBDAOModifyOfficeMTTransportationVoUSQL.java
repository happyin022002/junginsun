/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOModifyOfficeMTTransportationVoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.11.10 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOModifyOfficeMTTransportationVoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MT Office Transfer update
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOModifyOfficeMTTransportationVoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_trns_rqst_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_trns_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOModifyOfficeMTTransportationVoUSQL").append("\n"); 
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
		query.append("UPDATE EQR_REPO_EXE_SO_IF" ).append("\n"); 
		query.append("SET TRNS_RQST_OFC_CD = @[ctrl_ofc_cd]," ).append("\n"); 
		query.append("TRNS_RQST_USR_ID     = @[upd_usr_id]," ).append("\n"); 
		query.append("TRNS_RQST_RSN        = @[new_trns_rqst_rsn]," ).append("\n"); 
		query.append("EQ_CTRL_OFC_CD       = @[new_trns_rqst_ofc_cd]," ).append("\n"); 
		query.append("UPD_DT               = SYSDATE," ).append("\n"); 
		query.append("UPD_USR_ID           = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE  REPO_PLN_ID          = @[repo_pln_id]" ).append("\n"); 
		query.append("AND    PLN_YRWK  = @[pln_yrwk]" ).append("\n"); 
		query.append("AND    REF_ID    = @[ref_id]" ).append("\n"); 
		query.append("AND    REF_SEQ   = @[ref_seq]" ).append("\n"); 

	}
}