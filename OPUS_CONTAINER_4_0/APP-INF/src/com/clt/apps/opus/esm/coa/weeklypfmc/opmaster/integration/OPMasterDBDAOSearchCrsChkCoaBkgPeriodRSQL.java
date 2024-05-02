/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOSearchCrsChkCoaBkgPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOSearchCrsChkCoaBkgPeriodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public OPMasterDBDAOSearchCrsChkCoaBkgPeriodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchCrsChkCoaBkgPeriodRSQL").append("\n"); 
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
		query.append("SELECT  a1.bkg_no" ).append("\n"); 
		query.append("       ,a1.bkg_flg" ).append("\n"); 
		query.append("       ,a1.coa_flg" ).append("\n"); 
		query.append("       ,a1.reason_mt" ).append("\n"); 
		query.append("       ,a1.reason_tt" ).append("\n"); 
		query.append("       ,a1.reason_cmdt" ).append("\n"); 
		query.append("       ,DECODE(a1.reason_vvd||a1.reason_vvd2,'NN','N','Y') reason_vvd" ).append("\n"); 
		query.append("       ,(CASE WHEN a1.reason_mt='N' AND a1.reason_tt = 'N' AND a1.reason_cmdt='N' AND a1.reason_vvd='N' AND a1.reason_vvd2='N' AND a1.reason_st='N'  " ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("        END ) reason_oth" ).append("\n"); 
		query.append("       ,(CASE WHEN a1.reason_mt='N' AND a1.reason_tt = 'N' AND a1.reason_cmdt='N' AND a1.reason_vvd='N' AND a1.reason_vvd2='N' AND a1.reason_st='N' " ).append("\n"); 
		query.append("                THEN (" ).append("\n"); 
		query.append("                CASE WHEN a1.bkg_flg='Y' AND a1.coa_flg='Y' AND a1.bkg_teu <> a1.coa_teu  THEN 'BKG quantity is different'" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("                ELSE 'Please contact CLT'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                )  " ).append("\n"); 
		query.append("        ELSE ''" ).append("\n"); 
		query.append("        END ) remark" ).append("\n"); 
		query.append("       ,a1.reason_st" ).append("\n"); 
		query.append("       ,a1.cost_yrmon" ).append("\n"); 
		query.append("       ,a1.sls_yrmon" ).append("\n"); 
		query.append("       ,a1.cost_wk" ).append("\n"); 
		query.append("       ,a1.trunk_vvd" ).append("\n"); 
		query.append("       ,(SELECT VSL_CD||SKD_VOY_NO||DIR_CD FROM COA_RGST_BKG R WHERE R.BKG_NO = A1.BKG_NO) rev_vvd" ).append("\n"); 
		query.append("       ,a1.svc_scp_cd" ).append("\n"); 
		query.append("       ,a1.trd_cd" ).append("\n"); 
		query.append("       ,a1.sub_trd_cd" ).append("\n"); 
		query.append("       ,a1.rlane_cd" ).append("\n"); 
		query.append("       ,a1.ioc_cd" ).append("\n"); 
		query.append("       ,a1.bkg_teu" ).append("\n"); 
		query.append("       ,a1.coa_teu" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT  a1.bkg_no" ).append("\n"); 
		query.append("           ,a1.bkg_flg" ).append("\n"); 
		query.append("           ,a1.coa_flg" ).append("\n"); 
		query.append("           -- 1. MTY PICKUP YARD            " ).append("\n"); 
		query.append("           ,DECODE (  a1.bkg_por_cd, NULL,'N'," ).append("\n"); 
		query.append("            DECODE (" ).append("\n"); 
		query.append("               ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                  FROM mdm_location m1" ).append("\n"); 
		query.append("                 WHERE m1.loc_cd = a1.bkg_por_cd" ).append("\n"); 
		query.append("                   AND m1.delt_flg = 'N'" ).append("\n"); 
		query.append("                   AND m1.MTY_PKUP_YD_CD IS NOT NULL" ).append("\n"); 
		query.append("                 ) , 0, 'Y','N'))   reason_mt" ).append("\n"); 
		query.append("           -- 2. T/T FULL CARGO DAYS ZERO" ).append("\n"); 
		query.append("           , CASE " ).append("\n"); 
		query.append("             WHEN a1.coa_flg ='N' AND  " ).append("\n"); 
		query.append("                  NVL(" ).append("\n"); 
		query.append("                  (" ).append("\n"); 
		query.append("                   select " ).append("\n"); 
		query.append("                         (SUBSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no ) " ).append("\n"); 
		query.append("                            ,INSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no), '#')+1 --# 표시 이후 부터 " ).append("\n"); 
		query.append("                            ,INSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no), 'D', 8) --두 번째 D가 나온 위치 " ).append("\n"); 
		query.append("                            -INSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no), '#')-1) " ).append("\n"); 
		query.append("                             ) --Full cargo days " ).append("\n"); 
		query.append("                         + (SUBSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no) " ).append("\n"); 
		query.append("                                  ,INSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no ), 'D', 8)+2 --두 번째 D가 나온 위치 + 공백 감안 " ).append("\n"); 
		query.append("                                  ,INSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no ), 'H', 10)   --두 번째 H가 나온 위치 " ).append("\n"); 
		query.append("                                  -(INSTR(sce_cop_tot_tran_time_fnc(MIN(h1.cop_no) ,h1.bkg_no ),'D', 8)+2) " ).append("\n"); 
		query.append("                                  ) /24 ) fcgo_tz_dys" ).append("\n"); 
		query.append("                    from sce_cop_hdr h1" ).append("\n"); 
		query.append("                   where h1.bkg_no = a1.bkg_no " ).append("\n"); 
		query.append("                   group by h1.bkg_no" ).append("\n"); 
		query.append("                   ) ,0) = 0" ).append("\n"); 
		query.append("                 THEN 'Y'  " ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("             END  reason_tt" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("           -- 3. CMDT DELETE" ).append("\n"); 
		query.append("           ,DECODE (NVL((" ).append("\n"); 
		query.append("                SELECT 1" ).append("\n"); 
		query.append("                 FROM mdm_commodity a6" ).append("\n"); 
		query.append("                WHERE a6.delt_flg = 'N'" ).append("\n"); 
		query.append("                  AND a6.cmdt_cd = a1.cmdt_cd" ).append("\n"); 
		query.append("               ), 0), 0, 'Y','N') reason_cmdt" ).append("\n"); 
		query.append("            -- 4. VVD NOT EXISTS" ).append("\n"); 
		query.append("           ,DECODE (  " ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT COUNT(*)" ).append("\n"); 
		query.append("                FROM BKG_VVD a, mdm_dtl_rev_lane b , mdm_location c, mdm_location d, COA_MON_VVD E" ).append("\n"); 
		query.append("                WHERE  1=1 " ).append("\n"); 
		query.append("                AND  A.bkg_no = A1.BKG_NO" ).append("\n"); 
		query.append("                and a.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                and b.rlane_cd like a.slan_cd||'%'" ).append("\n"); 
		query.append("                and a.pol_cd = c.loc_cd" ).append("\n"); 
		query.append("                and a.pod_cd = d.loc_cd" ).append("\n"); 
		query.append("                and b.fm_conti_cd = c.conti_cd" ).append("\n"); 
		query.append("                and b.to_conti_cd = d.conti_cd" ).append("\n"); 
		query.append("                and b.vsl_slan_dir_cd = a.skd_dir_cd " ).append("\n"); 
		query.append("                and b.ioc_cd = decode(c.conti_cd,d.conti_cd,'I','O')" ).append("\n"); 
		query.append("                AND E.VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("                AND E.SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND E.DIR_CD        = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND E.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("                AND E.TRD_CD        = B.TRD_CD" ).append("\n"); 
		query.append("                AND E.IOC_CD        = B.IOC_CD" ).append("\n"); 
		query.append("                AND E.DELT_FLG      = 'N'       " ).append("\n"); 
		query.append("               ) , 0, 'Y', 'N')  reason_vvd" ).append("\n"); 
		query.append("           -- 4. VVD NOT EXISTS" ).append("\n"); 
		query.append("           ,DECODE (  " ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT COUNT(*) " ).append("\n"); 
		query.append("                FROM COA_MON_VVD C1" ).append("\n"); 
		query.append("                    ,COA_RGST_BKG C2" ).append("\n"); 
		query.append("                WHERE C2.BKG_NO        = A1.BKG_NO" ).append("\n"); 
		query.append("                  AND C1.VSL_CD        = C2.VSL_CD" ).append("\n"); 
		query.append("                  AND C1.SKD_VOY_NO    = C2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND C1.DIR_CD        = C2.DIR_CD" ).append("\n"); 
		query.append("                  AND C1.RLANE_CD      = C2.RLANE_CD" ).append("\n"); 
		query.append("                  AND C1.TRD_CD        = C2.TRD_CD" ).append("\n"); 
		query.append("                  AND C1.IOC_CD        = C2.IOC_CD" ).append("\n"); 
		query.append("                  AND C1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                  AND C2.BKG_STS_CD    IN('F', 'S', 'W')" ).append("\n"); 
		query.append("                  AND C2.BL_NO_TP      IN('M', '0')" ).append("\n"); 
		query.append("                  AND C2.BKG_CGO_TP_CD <> 'P'    " ).append("\n"); 
		query.append("               ) + (SELECT COUNT(0) FROM COA_RGST_BKG C3 WHERE C3.BKG_NO = A1.BKG_NO)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               , 1, 'Y', 'N')  reason_vvd2" ).append("\n"); 
		query.append("           -- 5. OTHER REASON" ).append("\n"); 
		query.append("           ,'Y'  reason_oth" ).append("\n"); 
		query.append("           -- 6. STATUS DIFFERENT" ).append("\n"); 
		query.append("           ,DECODE(a1.bkg_sts_cd , NVL(a1.coa_bkg_sts_cd, a1.bkg_sts_cd), 'N', 'Y') reason_st" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           ,a1.cost_yrmon" ).append("\n"); 
		query.append("           ,a1.sls_yrmon" ).append("\n"); 
		query.append("           ,a1.cost_wk" ).append("\n"); 
		query.append("           ,a1.trunk_vvd" ).append("\n"); 
		query.append("           ,a1.rev_vvd" ).append("\n"); 
		query.append("           ,a1.svc_scp_cd" ).append("\n"); 
		query.append("           ,a1.trd_cd" ).append("\n"); 
		query.append("           ,a1.sub_trd_cd" ).append("\n"); 
		query.append("           ,a1.rlane_cd" ).append("\n"); 
		query.append("           ,a1.ioc_cd" ).append("\n"); 
		query.append("           ,a1.bkg_teu" ).append("\n"); 
		query.append("           ,a1.coa_teu" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT  a1.bkg_no" ).append("\n"); 
		query.append("                ,'Y' bkg_flg " ).append("\n"); 
		query.append("               ,DECODE(NVL(MIN(c1.bkg_no),'X'),'X','N','Y') coa_flg" ).append("\n"); 
		query.append("               ,MIN(a1.bkg_sts_cd) bkg_sts_cd" ).append("\n"); 
		query.append("               ,MIN(c1.bkg_sts_cd) coa_bkg_sts_cd " ).append("\n"); 
		query.append("               ,MIN(a1.cmdt_cd) cmdt_cd" ).append("\n"); 
		query.append("               ,MIN(c1.cost_yrmon) cost_yrmon" ).append("\n"); 
		query.append("               ,MIN(c1.sls_yrmon)  sls_yrmon" ).append("\n"); 
		query.append("               ,MIN(c1.cost_wk) cost_wk" ).append("\n"); 
		query.append("               ,MIN(a1.trunk_vvd)  trunk_vvd" ).append("\n"); 
		query.append("               ,MIN(c1.vsl_cd||c1.skd_voy_no||c1.dir_cd)  rev_vvd" ).append("\n"); 
		query.append("               ,MIN(a1.svc_scp_cd) svc_scp_cd       " ).append("\n"); 
		query.append("               ,MIN(c1.trd_cd)  trd_cd" ).append("\n"); 
		query.append("               ,MIN(c1.sub_trd_cd) sub_trd_cd" ).append("\n"); 
		query.append("               ,MIN(c1.rlane_cd) rlane_cd" ).append("\n"); 
		query.append("               ,MIN(c1.ioc_cd)  ioc_cd" ).append("\n"); 
		query.append("               ,MIN(a1.bkg_teu) bkg_teu" ).append("\n"); 
		query.append("               ,MIN(c1.bkg_por_cd) bkg_por_cd" ).append("\n"); 
		query.append("               ,MIN(c1.bkg_del_cd) bkg_del_cd" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               ,SUM(DECODE(SUBSTR(c1.cntr_tpsz_cd,-1), '2',1,2) * c1.bkg_qty) coa_teu" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          FROM        " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            SELECT  a1.bkg_no" ).append("\n"); 
		query.append("                   ,MIN(a1.vsl_cd||a1.skd_voy_no||a1.skd_dir_cd)  trunk_vvd" ).append("\n"); 
		query.append("                   ,MIN(a1.svc_scp_cd) svc_scp_cd" ).append("\n"); 
		query.append("                   ,MIN(a1.bkg_sts_cd) bkg_sts_cd" ).append("\n"); 
		query.append("                   ,MIN(a1.cmdt_cd) cmdt_cd               " ).append("\n"); 
		query.append("                   ,SUM(DECODE(SUBSTR(a2.cntr_tpsz_cd,-1), '2',1,2) * a2.op_cntr_qty) bkg_teu" ).append("\n"); 
		query.append("              FROM  bkg_booking a1" ).append("\n"); 
		query.append("                   ,bkg_quantity a2" ).append("\n"); 
		query.append("             WHERE  1=1" ).append("\n"); 
		query.append("               AND  a1.bkg_no = a2.bkg_no" ).append("\n"); 
		query.append("               AND  a1.bkg_sts_cd    IN ('F','S','W') " ).append("\n"); 
		query.append("               AND  a1.bkg_cgo_tp_cd <> 'P'" ).append("\n"); 
		query.append("               AND  a1.bl_no_tp      IN ('M','0')" ).append("\n"); 
		query.append("               AND  a1.bkg_cre_gdt BETWEEN to_date(@[f_fm_dt],'yyyy/mm/dd') " ).append("\n"); 
		query.append("                                   AND to_date(@[f_to_dt],'yyyy/mm/dd') + 0.99999" ).append("\n"); 
		query.append("    --           AND  a1.bkg_no = 'TYO500169400' -- 'HKG500123200' " ).append("\n"); 
		query.append("               AND  NOT EXISTS (" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("                   SELECT 1" ).append("\n"); 
		query.append("                     FROM coa_bkg_expn_dtl c1" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND c1.bkg_no = a1.bkg_no" ).append("\n"); 
		query.append("--                      AND c1.cntr_tpsz_cd = (--a2.cntr_tpsz_cd" ).append("\n"); 
		query.append("--                                            CASE WHEN SUBSTR(a2.cntr_tpsz_cd,0,1)='R' AND c1.soc_flg='Y' THEN" ).append("\n"); 
		query.append("--                                                     'RD' || SUBSTR(a2.cntr_tpsz_cd, -1)" ).append("\n"); 
		query.append("--                                                WHEN SUBSTR(a2.cntr_tpsz_cd,0,1)='R' AND c1.rd_flg='Y' THEN " ).append("\n"); 
		query.append("--                                                     'RD' || SUBSTR(a2.cntr_tpsz_cd, -1)" ).append("\n"); 
		query.append("--                                                ELSE" ).append("\n"); 
		query.append("--                                                     a2.cntr_tpsz_cd" ).append("\n"); 
		query.append("--                                            END )" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      AND c1.bkg_sts_cd    IN ('F','S','W')" ).append("\n"); 
		query.append("                      AND c1.bkg_cgo_tp_cd <> 'P'" ).append("\n"); 
		query.append("                      AND c1.bl_no_tp      IN ('M','0')" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("            GROUP BY a1.bkg_no" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ) a1," ).append("\n"); 
		query.append("          coa_bkg_expn_dtl c1" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND a1.bkg_no = c1.bkg_no(+)" ).append("\n"); 
		query.append("        GROUP BY a1.bkg_no " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       ) a1" ).append("\n"); 
		query.append("    WHERE 1=1   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  ) a1" ).append("\n"); 

	}
}