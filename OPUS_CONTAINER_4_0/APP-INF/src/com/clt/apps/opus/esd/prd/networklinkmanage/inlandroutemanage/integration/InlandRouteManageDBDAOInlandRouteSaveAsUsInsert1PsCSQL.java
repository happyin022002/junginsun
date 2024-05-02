/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRouteSaveAsUsInsert1PsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRouteSaveAsUsInsert1PsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandRouteSaveAsUsInsert1Ps
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRouteSaveAsUsInsert1PsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_mcntr_rout_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_route_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_pln_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("i_inv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_inbound",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRouteSaveAsUsInsert1PsCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_INLND_ROUT_MST (" ).append("\n"); 
		query.append("   ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("  ,ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("  ,ROUT_SEQ" ).append("\n"); 
		query.append("  ,PRIO_SEQ" ).append("\n"); 
		query.append("  ,INLND_ROUT_INV_BIL_PATT_CD" ).append("\n"); 
		query.append("  ,ROUT_PLN_CD" ).append("\n"); 
		query.append("  ,MCNTR_ROUT_FLG" ).append("\n"); 
		query.append("  ,INLND_ROUT_RMK" ).append("\n"); 
		query.append("  ,CRE_OFC_CD" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,INLND_ROUT_BKG_FLG" ).append("\n"); 
		query.append("  ,PCTL_IO_BND_CD" ).append("\n"); 
		query.append("  ,DELT_FLG" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   @[i_rout_org_nod_cd]" ).append("\n"); 
		query.append("  ,@[i_rout_dest_nod_cd]" ).append("\n"); 
		query.append("  ,TO_NUMBER(@[i_rout_seq])" ).append("\n"); 
		query.append("  ,99" ).append("\n"); 
		query.append("  ,@[i_inv]" ).append("\n"); 
		query.append("  ,@[i_rout_pln_cd]" ).append("\n"); 
		query.append("  ,@[i_mcntr_rout_flg]" ).append("\n"); 
		query.append("  ,@[i_route_rmk]" ).append("\n"); 
		query.append("  ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,@[upd_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[i_bkg_flg]" ).append("\n"); 
		query.append("  ,@[r_inbound]" ).append("\n"); 
		query.append("  ,'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}