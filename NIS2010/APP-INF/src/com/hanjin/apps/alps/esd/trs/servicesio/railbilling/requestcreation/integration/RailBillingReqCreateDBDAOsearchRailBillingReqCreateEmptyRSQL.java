/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchRailBillingReqCreateEmptyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2016.01.27 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchRailBillingReqCreateEmptyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Billing Empty Cntr Request : Location 별 Billing 가능 Cntr Type 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchRailBillingReqCreateEmptyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchRailBillingReqCreateEmptyRSQL").append("\n"); 
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
		query.append("SELECT   x.yd_cd                                                              " ).append("\n"); 
		query.append("        			,x.yd_nm                                                              " ).append("\n"); 
		query.append("        			,x.yd_addr                                                            " ).append("\n"); 
		query.append("        			,x.d2_flg                                                             " ).append("\n"); 
		query.append("        			,x.d4_flg                                                             " ).append("\n"); 
		query.append("        			,x.d5_flg                                                             " ).append("\n"); 
		query.append("        			,x.d7_flg                                                             " ).append("\n"); 
		query.append("        			,x.o2_flg                                                             " ).append("\n"); 
		query.append("        			,x.o4_flg                                                             " ).append("\n"); 
		query.append("        			,x.a2_flg                                                             " ).append("\n"); 
		query.append("        			,x.a4_flg" ).append("\n"); 
		query.append("					,x.a5_flg                                                             " ).append("\n"); 
		query.append("        			,x.r5_flg                                                             " ).append("\n"); 
		query.append("        			,x.r2_flg " ).append("\n"); 
		query.append("        			,x.o5_flg                                                            " ).append("\n"); 
		query.append("        			,x.loc_cd                                                             " ).append("\n"); 
		query.append("        			,x.loc_nm                                                              " ).append("\n"); 
		query.append("        	    FROM (SELECT   SUBSTR(rout_org_nod_cd, 1, 5) loc_cd                       " ).append("\n"); 
		query.append("        	                  ,MAX(b.loc_nm) loc_nm                                       " ).append("\n"); 
		query.append("        	                  ,rout_org_nod_cd yd_cd                                      " ).append("\n"); 
		query.append("        	                  ,MAX(c.yd_nm) yd_nm                                         " ).append("\n"); 
		query.append("        	                  ,REPLACE(MAX(c.yd_addr), CHR(13) || CHR(10), ' ') yd_addr   " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(d2_capa_flg), 'N') d2_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(d4_capa_flg), 'N') d4_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(d5_capa_flg), 'N') d5_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(d7_capa_flg), 'N') d7_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(o2_capa_flg), 'N') o2_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(o4_capa_flg), 'N') o4_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(a2_capa_flg), 'N') a2_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(a4_capa_flg), 'N') a4_flg" ).append("\n"); 
		query.append("							  ,NVL(MAX(a5_capa_flg), 'N') a5_flg                         " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(r5_capa_flg), 'N') r5_flg                          " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(r2_capa_flg), 'N') r2_flg  " ).append("\n"); 
		query.append("        	                  ,NVL(MAX(o5_capa_flg), 'N') o5_flg                          " ).append("\n"); 
		query.append("        	              FROM prd_inlnd_rout_mst a, mdm_location b, mdm_yard c           " ).append("\n"); 
		query.append("        	             WHERE SUBSTR(rout_org_nod_cd, 1, 5) = b.loc_cd                   " ).append("\n"); 
		query.append("        	               AND a.rout_org_nod_cd = c.yd_cd   " ).append("\n"); 
		query.append("        	               AND a.pctl_io_bnd_cd = @[pctl_io_bnd_cd]                                       " ).append("\n"); 
		query.append("        	               AND NVL(a.delt_flg, 'N') = 'N'                                 " ).append("\n"); 
		query.append("        	               AND a.wrs_mty_cmdt_cd IS NOT NULL                              " ).append("\n"); 
		query.append("        	          GROUP BY rout_org_nod_cd) x                                         " ).append("\n"); 
		query.append("        	ORDER BY x.loc_nm, x.yd_nm" ).append("\n"); 

	}
}