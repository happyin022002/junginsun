/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COPSearchDBDAOSearchSOCostInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchSOCostInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSOCostInfo
	  * </pre>
	  */
	public COPSearchDBDAOSearchSOCostInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchSOCostInfoRSQL").append("\n"); 
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
		query.append("SELECT aa.*, aa.so_ofc||aa.so_seq so_num" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("     ( SELECT a.cop_no" ).append("\n"); 
		query.append("			, a.trsp_so_sts_cd                             " ).append("\n"); 
		query.append("            , a.cost_act_grp_seq" ).append("\n"); 
		query.append("            , a.ctrl_ofc_cd     " ).append("\n"); 
		query.append("			, decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_ofc_cty_cd) so_ofc                     " ).append("\n"); 
		query.append("            , d.cost_act_grp_nm cost_act_grp_nm                            " ).append("\n"); 
		query.append("            , c.vndr_abbr_nm vndr_abbr_nm" ).append("\n"); 
		query.append("            , c1.vndr_abbr_nm vndr_abbr_nm_act	-- ADD CHM-201327095                                " ).append("\n"); 
		query.append("            , commcode_pkg.get_comdtl_name_fnc('CD00275', a.trsp_so_sts_cd) trsp_so_sts                        " ).append("\n"); 
		query.append("            , decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_seq) so_seq                       " ).append("\n"); 
		query.append("            , " ).append("\n"); 
		query.append("			  CASE WHEN A.TRSP_SO_STS_CD IN ('N', 'D', 'P') THEN ' - ' ELSE (" ).append("\n"); 
		query.append("			      CASE WHEN e.trsp_bnd_cd = 'O' " ).append("\n"); 
		query.append("    	               THEN e.fm_nod_cd||' - ' ||DECODE(NVL(e.dor_nod_cd, ''), '', '', e.dor_nod_cd||' - ')" ).append("\n"); 
		query.append("        	                ||DECODE(NVL(e.via_nod_cd, ''), '', '', e.via_nod_cd||' - ')||e.to_nod_cd " ).append("\n"); 
		query.append("            	       ELSE e.fm_nod_cd||' - ' ||DECODE(NVL(e.via_nod_cd, ''), '', '', e.via_nod_cd||' - ')" ).append("\n"); 
		query.append("                	        ||DECODE(NVL(e.dor_nod_cd, ''), '', '', e.dor_nod_cd||' - ')||e.to_nod_cd " ).append("\n"); 
		query.append("	              END " ).append("\n"); 
		query.append("			  ) END AS fm_to                          " ).append("\n"); 
		query.append("            , CASE WHEN a.trsp_so_sts_cd ='N' then to_char(a.SO_CNDDT_DELT_DT, 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("                   ELSE TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS') " ).append("\n"); 
		query.append("              END AS so_dt" ).append("\n"); 
		query.append("			, CASE WHEN a.trsp_so_sts_cd ='N' THEN (select g.usr_nm from com_user g where a.SO_CNDDT_DELT_USR_ID = g.usr_id) ELSE (select g.usr_nm from com_user g where e.cre_usr_id = g.usr_id) END user_nm                                                        " ).append("\n"); 
		query.append("--          , CASE WHEN a.trsp_so_sts_cd ='N' THEN a.delt_usr_id ELSE e.cre_usr_id END user_id                             " ).append("\n"); 
		query.append("            , b.intl_phn_no||'-'||b.phn_no sp_h_no                   " ).append("\n"); 
		query.append("            , e.inter_rmk    so_rmk1                                " ).append("\n"); 
		query.append("            , e.inv_rmk   so_rmk2                                     " ).append("\n"); 
		query.append("            , e.spcl_instr_rmk   so_rmk3                                          " ).append("\n"); 
		query.append("            , e.trsp_wo_ofc_cty_cd||e.trsp_wo_seq wo_no                     " ).append("\n"); 
		query.append("            , to_char(f.locl_cre_dt, 'YYYYMMDD HH24:MI:SS') wo_dt  " ).append("\n"); 
		query.append("			, row_number() over (partition by a.cop_no, a.cost_act_grp_seq order by" ).append("\n"); 
		query.append("                CASE WHEN a.trsp_so_sts_cd ='N' then to_char(a.delt_dt, 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("                     ELSE TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS') " ).append("\n"); 
		query.append("                END desc ) mx_knt                     " ).append("\n"); 
		query.append("        FROM  sce_pln_so_list a,   " ).append("\n"); 
		query.append("              mdm_vndr_cntc_pnt b,                       " ).append("\n"); 
		query.append("              mdm_vendor  c," ).append("\n"); 
		query.append("              mdm_vendor  c1,	-- ADD CHM-201327095" ).append("\n"); 
		query.append("              prd_cost_act_grp d                          " ).append("\n"); 
		query.append("              ,trs_trsp_svc_ord e                          " ).append("\n"); 
		query.append("              ,trs_trsp_wrk_ord f                            " ).append("\n"); 
		query.append("       WHERE  a.cost_act_grp_cd = d.cost_act_grp_cd --and a.cost_act_grp_cd <> 'DMLK'                     " ).append("\n"); 
		query.append("         AND  a.n1st_vndr_seq = c.vndr_seq (+) --and cost_act_grp_tp_cd = 'L'                    " ).append("\n"); 
		query.append("         AND  a.n1st_vndr_seq = b.vndr_seq (+)" ).append("\n"); 
		query.append("         AND  e.vndr_seq = c1.vndr_seq(+)	-- ADD CHM-201327095" ).append("\n"); 
		query.append("         AND  b.prmry_chk_flg (+)               = 'Y'                               " ).append("\n"); 
		query.append("         AND  b.phn_no (+)     IS NOT NULL                    " ).append("\n"); 
		query.append("         AND  a.cop_no = @[cop_no]    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         AND  a.cop_no = e.cop_no(+)  " ).append("\n"); 
		query.append("		 AND a.cost_act_grp_seq = e.cost_act_grp_seq (+)                      " ).append("\n"); 
		query.append("         AND  NVL(a.trsp_so_sts_cd, 'U') != 'U'                 " ).append("\n"); 
		query.append("         AND  e.trsp_wo_ofc_cty_cd = f.trsp_wo_ofc_cty_cd(+)                   " ).append("\n"); 
		query.append("         AND  e.trsp_wo_seq = f.trsp_wo_seq(+)       " ).append("\n"); 
		query.append("         AND E.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("         AND  NOT EXISTS                   " ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("                         SELECT 'X' " ).append("\n"); 
		query.append("                           FROM sce_pln_so_list                  " ).append("\n"); 
		query.append("                          WHERE cop_no = a.cop_no                  " ).append("\n"); 
		query.append("                            AND ctrl_ofc_cd = 'PHXSA'                   " ).append("\n"); 
		query.append("                            AND trsp_mod_cd ='RD'                  " ).append("\n"); 
		query.append("                            AND ctrl_ofc_cd = a.ctrl_ofc_cd " ).append("\n"); 
		query.append("                            AND trsp_mod_cd = a.trsp_mod_cd                  " ).append("\n"); 
		query.append("                       )                      " ).append("\n"); 
		query.append("       UNION                         " ).append("\n"); 
		query.append("      SELECT a.cop_no" ).append("\n"); 
		query.append("			, a.trsp_so_sts_cd                          " ).append("\n"); 
		query.append("            , a.cost_act_grp_seq" ).append("\n"); 
		query.append("            , a.ctrl_ofc_cd           " ).append("\n"); 
		query.append("			, decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_ofc_cty_cd) so_ofc                             " ).append("\n"); 
		query.append("            , MAX(d.cost_act_grp_nm) cost_act_grp_nm                                        " ).append("\n"); 
		query.append("            , MAX(c.vndr_abbr_nm) vndr_abbr_nm" ).append("\n"); 
		query.append("            , MAX(DECODE(f.sub_rail_seq, 1, c1.vndr_abbr_nm)) vndr_abbr_nm_act	-- ADD CHM-201327095" ).append("\n"); 
		query.append("            , MAX(commcode_pkg.get_comdtl_name_fnc('CD00275', a.trsp_so_sts_cd)) trsp_so_sts                    " ).append("\n"); 
		query.append("            , MAX(decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_seq)) so_seq                       " ).append("\n"); 
		query.append("			, CASE WHEN MAX(A.TRSP_SO_STS_CD) IN ('N', 'D', 'P') THEN ' - ' ELSE (" ).append("\n"); 
		query.append("	            MAX(decode(f.sub_rail_seq, 1, f.fm_nod_cd))|| ' - '|| MAX(DECODE(f.sub_rail_seq, 1, f.to_nod_cd))" ).append("\n"); 
		query.append("    	          || MAX(decode(f.sub_rail_seq, 2, ' - '||f.to_nod_cd))|| MAX(DECODE(f.sub_rail_seq, 3, ' - '||f.to_nod_cd))    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 				) END AS fm_to                     " ).append("\n"); 
		query.append("            , CASE WHEN MAX(a.trsp_so_sts_cd) ='N' THEN TO_CHAR(max(a.SO_CNDDT_DELT_DT), 'YYYYMMDD HH24:MI:SS')  -- correction SO_CNDDT_DELT_DT" ).append("\n"); 
		query.append("                   ELSE MAX(TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS')) END so_dt                       " ).append("\n"); 
		query.append("            , CASE WHEN MAX(a.trsp_so_sts_cd) ='N' THEN MAX((select g.usr_nm from com_user g where a.SO_CNDDT_DELT_USR_ID = g.usr_id)) ELSE MAX((select g.usr_nm from com_user g where e.cre_usr_id = g.usr_id)) END user_nm    -- correction SO_CNDDT_DELT_USR_ID                             " ).append("\n"); 
		query.append("--			, CASE WHEN MAX(a.trsp_so_sts_cd) ='N' THEN MAX(a.delt_usr_id) ELSE MAX(e.cre_usr_id) END user_id                                  " ).append("\n"); 
		query.append("            , MAX(b.intl_phn_no||'-'||b.phn_no) sp_h_no                   " ).append("\n"); 
		query.append("            , MAX('')                           so_rmk1                   " ).append("\n"); 
		query.append("            , MAX('')                        so_rmk2                      " ).append("\n"); 
		query.append("            , MAX('')                         so_rmk3                    " ).append("\n"); 
		query.append("            , MAX('') wo_no                          " ).append("\n"); 
		query.append("            , MAX(TO_CHAR(e.wo_iss_dt, 'YYYYMMDD HH24:MI:SS')) wo_dt" ).append("\n"); 
		query.append("			, row_number() over (partition by a.cop_no, a.cost_act_grp_seq order by" ).append("\n"); 
		query.append("                CASE WHEN MAX(a.trsp_so_sts_cd) ='N' then to_char(max(a.delt_dt), 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("                     ELSE MAX(TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS')) " ).append("\n"); 
		query.append("                END desc ) mx_knt                       " ).append("\n"); 
		query.append("         FROM sce_pln_so_list a                      " ).append("\n"); 
		query.append("            , mdm_vndr_cntc_pnt b                     " ).append("\n"); 
		query.append("            , mdm_vendor  c" ).append("\n"); 
		query.append("            , mdm_vendor  c1	-- ADD CHM-201327095" ).append("\n"); 
		query.append("            , prd_cost_act_grp d                        " ).append("\n"); 
		query.append("            , trs_trsp_rail_bil_ord e                   " ).append("\n"); 
		query.append("            , trs_trsp_rail_bil_vndr_set f                                       " ).append("\n"); 
		query.append("        WHERE a.cost_act_grp_cd = d.cost_act_grp_cd --and a.cost_act_grp_cd <> 'DMLK'                    " ).append("\n"); 
		query.append("          AND a.n1st_vndr_seq = c.vndr_seq (+) --and cost_act_grp_tp_cd = 'L'" ).append("\n"); 
		query.append("          AND f.vndr_seq = c1.vndr_seq (+)	-- ADD CHM-201327095" ).append("\n"); 
		query.append("          AND a.cop_no = @[cop_no]                              " ).append("\n"); 
		query.append("          AND NVL(a.trsp_so_sts_cd, 'U') != 'U'" ).append("\n"); 
		query.append("          AND a.n1st_vndr_seq = b.vndr_seq (+)                                 " ).append("\n"); 
		query.append("          AND b.prmry_chk_flg (+)               = 'Y'                            " ).append("\n"); 
		query.append("          AND b.phn_no (+)      IS NOT NULL " ).append("\n"); 
		query.append("          AND a.cop_no = e.cop_no(+)      " ).append("\n"); 
		query.append("		  AND a.cost_act_grp_seq = e.cost_act_grp_seq (+)                                             " ).append("\n"); 
		query.append("          AND e.trsp_so_ofc_cty_cd =f.trsp_so_ofc_cty_cd(+)                    " ).append("\n"); 
		query.append("          AND e.trsp_so_seq = f.trsp_so_seq(+)                        " ).append("\n"); 
		query.append("          AND a.ctrl_ofc_cd = 'PHXSA'                   " ).append("\n"); 
		query.append("          AND a.trsp_mod_cd ='RD'                  " ).append("\n"); 
		query.append("      GROUP BY a.cop_no, a.ctrl_ofc_cd,a.cost_act_grp_seq, a.trsp_so_sts_cd, e.trsp_so_ofc_cty_cd   ) aa " ).append("\n"); 
		query.append("	WHERE mx_knt = 1                       " ).append("\n"); 
		query.append("    ORDER BY 1,3" ).append("\n"); 

	}
}