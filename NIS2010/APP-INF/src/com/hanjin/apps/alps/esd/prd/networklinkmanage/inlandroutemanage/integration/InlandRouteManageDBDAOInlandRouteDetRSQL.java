/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRouteDetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRouteDetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search detail
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRouteDetRSQL(){
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
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRouteDetRSQL").append("\n"); 
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
		query.append("SELECT   m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq,                       " ).append("\n"); 
		query.append("        	          d.lnk_org_nod_cd, d.lnk_dest_nod_cd, d.rout_dtl_seq, d.trsp_mod_cd,                   " ).append("\n"); 
		query.append("        	          substr(d.lnk_org_nod_cd,1,5) lnk_org_loc,                                             " ).append("\n"); 
		query.append("        	          substr(d.lnk_org_nod_cd,6) lnk_org_type,                                             " ).append("\n"); 
		query.append("        	          substr(d.lnk_dest_nod_cd,1,5) lnk_dest_loc,                                           " ).append("\n"); 
		query.append("        	          substr(d.lnk_dest_nod_cd,6) lnk_dest_type,                                           " ).append("\n"); 
		query.append("        	          COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq        " ).append("\n"); 
		query.append("        	             ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt,               " ).append("\n"); 
		query.append("        	         SUM (l.tztm_hrs) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("        	             ORDER BY m.rout_org_nod_cd,m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time,         " ).append("\n"); 
		query.append("        	          d.vndr_seq, l.lnk_dist, l.dist_ut_cd, l.cre_ofc_cd, d.rail_crr_tp_cd,                 " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        	          m.inlnd_rout_inv_bil_patt_cd, m.rout_pln_cd,                                         " ).append("\n"); 
		query.append("        	          m.mcntr_rout_flg,l.tztm_hrs,m.inlnd_rout_rmk,                                        " ).append("\n"); 
		query.append("        	          d.inlnd_rout_cmb_flg, v.VNDR_LGL_ENG_NM vndr_abbr_nm, d.inlnd_rout_junc_nm,                           " ).append("\n"); 
		query.append("        	          ltrim(to_char(trunc(l.tztm_hrs/24,0),'00'))||ltrim(to_char(mod(l.tztm_hrs,24  ),'00'))  fmt_tztm_hrs," ).append("\n"); 
		query.append("        	          CASE			                                                                        " ).append("\n"); 
		query.append("        	            WHEN SUBSTR (d.lnk_org_nod_cd, 1, 2) IN ('US', 'CA' )							" ).append("\n"); 
		query.append("        					AND SUBSTR (d.lnk_dest_nod_cd, 1, 2) IN ('US', 'CA' )						 " ).append("\n"); 
		query.append("        					AND d.trsp_mod_cd = 'RD'														 " ).append("\n"); 
		query.append("        					THEN 'T'																		 " ).append("\n"); 
		query.append("        					ELSE 'F'																		 " ).append("\n"); 
		query.append("        				END fc,  																			 " ).append("\n"); 
		query.append("        	          CASE                                                                                  " ).append("\n"); 
		query.append("		              WHEN SUBSTR(@[i_rout_org_nod_cd]     ,1,5) = SUBSTR(@[i_rout_dest_nod_cd]     ,1,5)                                                    " ).append("\n"); 
		query.append("		                   AND NVL((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD IN ( @[i_rout_org_nod_cd],@[i_rout_dest_nod_cd] ) AND NOD_TP_CD ='Z'),'X') <> 'Z'      " ).append("\n"); 
		query.append("		                   THEN  'F'                                                                        " ).append("\n"); 
		query.append("		                  ELSE  'T'                                                                        " ).append("\n"); 
		query.append("		              END CC,                                                                               " ).append("\n"); 
		query.append("        				 m.wrs_full_cmdt_cd, m.wrs_mty_cmdt_cd                                              	" ).append("\n"); 
		query.append("        				, m.inlnd_rout_bkg_flg                                                             	 " ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("        	           , a.TRSP_AGMT_OFC_CTY_CD, a.TRSP_AGMT_SEQ,a.TRSP_AGMT_OFC_CTY_CD||lpad(a.TRSP_AGMT_SEQ,6,'0') agmt_no,  a.AGMT_REF_NO " ).append("\n"); 
		query.append("                       , m.inlnd_rout_optm_flg, m.altn_optm_flg" ).append("\n"); 
		query.append("        	     FROM prd_inlnd_rout_mst m,                                                        " ).append("\n"); 
		query.append("        	          prd_inlnd_rout_dtl d,                                                         " ).append("\n"); 
		query.append("        	          prd_inlnd_each_lnk l,                                                        " ).append("\n"); 
		query.append("        	          mdm_vendor v,                                                                  " ).append("\n"); 
		query.append("         	          TRS_AGMT_HDR a  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	    WHERE m.rout_org_nod_cd = @[i_rout_org_nod_cd]                                                                " ).append("\n"); 
		query.append("        	      AND m.rout_dest_nod_cd = @[i_rout_dest_nod_cd]                                                               " ).append("\n"); 
		query.append("        	      AND m.rout_seq = @[i_rout_seq]                                                                        " ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	      AND m.rout_org_nod_cd = d.rout_org_nod_cd                                                 " ).append("\n"); 
		query.append("        	      AND m.rout_dest_nod_cd = d.rout_dest_nod_cd                                               " ).append("\n"); 
		query.append("        	      AND m.rout_seq = d.rout_seq                                                              " ).append("\n"); 
		query.append("        	      AND d.lnk_org_nod_cd = l.lnk_org_nod_cd                                                   " ).append("\n"); 
		query.append("        	      AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd                                                 " ).append("\n"); 
		query.append("        	      AND d.trsp_mod_cd = l.trsp_mod_cd                                                         " ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("        	      AND d.TRSP_AGMT_OFC_CTY_CD = a.TRSP_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("        	      AND d.TRSP_AGMT_SEQ = a.TRSP_AGMT_SEQ(+) " ).append("\n"); 
		query.append("        	    --  AND   NVL(a.DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                  AND m.AUTO_IRG_FLG <> 'Y' -- 컬럼추가로 조건값 추가 " ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("        	      AND d.vndr_seq = v.vndr_seq(+)                                                            " ).append("\n"); 
		query.append("        	 ORDER BY m.rout_seq, d.rout_dtl_seq" ).append("\n"); 

	}
}