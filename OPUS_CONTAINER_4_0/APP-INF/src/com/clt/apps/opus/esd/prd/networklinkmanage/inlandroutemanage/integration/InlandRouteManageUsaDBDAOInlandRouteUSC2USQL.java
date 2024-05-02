/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageUsaDBDAOInlandRouteUSC2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.16 
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

public class InlandRouteManageUsaDBDAOInlandRouteUSC2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UPDATE INLANDROUTEUS UPDATE2
	  * </pre>
	  */
	public InlandRouteManageUsaDBDAOInlandRouteUSC2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrs_full_cmdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_incl_sttl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_tmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prio_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageUsaDBDAOInlandRouteUSC2USQL").append("\n"); 
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
		query.append("UPDATE prd_inlnd_rout_mst m          " ).append("\n"); 
		query.append("SET inlnd_rout_bkg_flg = decode(@[inlnd_rout_bkg_flg], '1','Y','N'),  " ).append("\n"); 
		query.append("    wrs_full_cmdt_cd = decode(@[wrs_full_cmdt],'1','FN','')," ).append("\n"); 
		query.append("    delt_flg= decode(@[ibflag], 'D','Y','N') ,  " ).append("\n"); 
		query.append("    prio_seq =  NVL(TO_NUMBER(@[prio_seq]),99)," ).append("\n"); 
		query.append("    INLND_ROUT_TMP_FLG = @[inlnd_rout_tmp_flg], " ).append("\n"); 
		query.append("    INLND_ROUT_INCL_STTL_FLG = @[inlnd_rout_incl_sttl_flg] ,  " ).append("\n"); 
		query.append("    UPD_USR_ID = @[cre_usr_id],  " ).append("\n"); 
		query.append("    UPD_DT = sysdate     " ).append("\n"); 
		query.append("WHERE m.rout_org_nod_cd = @[rout_org_nod_cd]  " ).append("\n"); 
		query.append("AND m.rout_dest_nod_cd = @[rout_dest_nod_cd]  " ).append("\n"); 
		query.append("AND m.rout_seq = @[rout_seq]" ).append("\n"); 

	}
}