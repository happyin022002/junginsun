/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOUpdateEmptyDetPsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.17 
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

public class InlandRouteManageDBDAOUpdateEmptyDetPsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateEmptyDetPs
	  * </pre>
	  */
	public InlandRouteManageDBDAOUpdateEmptyDetPsUSQL(){
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
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrs_chk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_inv",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOUpdateEmptyDetPsUSQL").append("\n"); 
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
		query.append("UPDATE prd_inlnd_rout_mst m" ).append("\n"); 
		query.append("   SET inlnd_rout_inv_bil_patt_cd = @[i_inv]" ).append("\n"); 
		query.append("      ,rout_pln_cd                = @[i_rout_pln_cd]" ).append("\n"); 
		query.append("      ,mcntr_rout_flg             = ''" ).append("\n"); 
		query.append("      ,inlnd_rout_rmk             = @[i_route_rmk]" ).append("\n"); 
		query.append("      ,wrs_full_cmdt_cd           = ''" ).append("\n"); 
		query.append("      ,wrs_mty_cmdt_cd            = @[wrs_chk]" ).append("\n"); 
		query.append("      ,inlnd_rout_bkg_flg         = ''" ).append("\n"); 
		query.append("      ,upd_usr_id                 = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,upd_dt                     = sysdate" ).append("\n"); 
		query.append("      ,d2_capa_flg                = NVL2(@[wrs_chk], d2_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,d4_capa_flg                = NVL2(@[wrs_chk], d4_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,d5_capa_flg                = NVL2(@[wrs_chk], d5_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,d7_capa_flg                = NVL2(@[wrs_chk], d7_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,o2_capa_flg                = NVL2(@[wrs_chk], o2_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,o4_capa_flg                = NVL2(@[wrs_chk], o4_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,a2_capa_flg                = NVL2(@[wrs_chk], a2_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,a4_capa_flg                = NVL2(@[wrs_chk], a4_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,r5_capa_flg                = NVL2(@[wrs_chk], r5_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,r2_capa_flg                = NVL2(@[wrs_chk], r2_capa_flg, 'N')" ).append("\n"); 
		query.append("      ,r4_capa_flg                = NVL2(@[wrs_chk], r4_capa_flg, 'N')" ).append("\n"); 
		query.append(" WHERE m.rout_org_nod_cd = @[i_rout_org_nod_cd]" ).append("\n"); 
		query.append("   AND m.rout_dest_nod_cd = @[i_rout_dest_nod_cd]" ).append("\n"); 
		query.append("   AND m.rout_seq = @[i_rout_seq]" ).append("\n"); 

	}
}