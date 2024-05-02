/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteManageDBDAORowSearchInlandRouteManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.13 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAORowSearchInlandRouteManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RowSearchInlandRouteManage
	  * </pre>
	  */
	public InlandRouteManageDBDAORowSearchInlandRouteManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAORowSearchInlandRouteManageRSQL").append("\n"); 
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
		query.append("SELECT lnk_org_nod_cd, lnk_dest_nod_cd, l.vndr_seq, v.VNDR_LGL_ENG_NM vndr_name," ).append("\n"); 
		query.append("TRIM (TO_CHAR (TRUNC (l.tztm_hrs / 24, 0), '00'))" ).append("\n"); 
		query.append("|| TRIM (TO_CHAR (MOD (l.tztm_hrs, 24), '00')) fmt_tztm_hrs," ).append("\n"); 
		query.append("tztm_hrs, lnk_dist, dist_ut_cd, rail_crr_tp_cd, trsp_mod_cd" ).append("\n"); 
		query.append("FROM prd_inlnd_each_lnk l, mdm_vendor v" ).append("\n"); 
		query.append("WHERE l.lnk_org_nod_cd = @[from_nod]" ).append("\n"); 
		query.append("AND l.lnk_dest_nod_cd = @[to_nod]" ).append("\n"); 
		query.append("AND l.trsp_mod_cd = @[trsp_mod]" ).append("\n"); 
		query.append("AND nvl(l.delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("AND l.vndr_seq = v.vndr_seq(+)" ).append("\n"); 

	}
}