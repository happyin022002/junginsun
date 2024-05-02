/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostAssignDBDAOSearchMtDysRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.09
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.12.09 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchMtDysRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cntr Mt Days 구하기
	  * </pre>
	  */
	public CostAssignDBDAOSearchMtDysRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchMtDysRSQL").append("\n"); 
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
		query.append("SELECT DECODE(DYS_DMT, 0, 2, DYS_DMT)" ).append("\n"); 
		query.append("		||'&'|| " ).append("\n"); 
		query.append("		DECODE(DYS_DMT_EXPT_SEA, 0," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("					SELECT NVL(ROUND(NVL(SUM(MCGO_TZ_TTL_DYS),0) / DECODE(SUM(CNTR_QTY),0,1,SUM(CNTR_QTY)),2),0) MT_LAND " ).append("\n"); 
		query.append("					FROM (" ).append("\n"); 
		query.append("					    SELECT DECODE(MAS_UT_TPSZ_FNC('TPS', TPSZ_CD), 'RD2', 'R2', 'RD4', 'R4', 'RD5', 'R5',' RD7', 'R7', 'RD8', 'R8', 'RD9', 'R9', MAS_UT_TPSZ_FNC('TPS', TPSZ_CD)) TPSZ_CD" ).append("\n"); 
		query.append("					          ,TPSZ_CD TPSZ_CD1" ).append("\n"); 
		query.append("					          ,MCGO_TZ_TTL_DYS" ).append("\n"); 
		query.append("					          ,CNTR_QTY" ).append("\n"); 
		query.append("							  ,POR_CD" ).append("\n"); 
		query.append("							  ,DEL_CD" ).append("\n"); 
		query.append("					    FROM MAS_CNTR_MTY_TTL_DYS A" ).append("\n"); 
		query.append("					    WHERE COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(mas_bzc_cost_yrmon_fnc(''),'YYYYMM'), -4),'YYYYMM') AND TO_CHAR(ADD_MONTHS(TO_DATE(mas_bzc_cost_yrmon_fnc(''),'YYYYMM'), -2),'YYYYMM')" ).append("\n"); 
		query.append("					    ) P" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("						AND P.POR_CD = M.POR_CD" ).append("\n"); 
		query.append("						AND P.DEL_CD = M.DEL_CD" ).append("\n"); 
		query.append("						AND P.TPSZ_CD = DECODE(MAS_UT_TPSZ_FNC('TPS', M.CNTR_TP), 'RD2', 'R2', 'RD4', 'R4', 'RD5', 'R5',' RD7', 'R7', 'RD8', 'R8', 'RD9', 'R9', MAS_UT_TPSZ_FNC('TPS', M.CNTR_TP))   " ).append("\n"); 
		query.append("					) + (SUBSTR(M.TTL_TZTM_HRS,0,2) - 2)" ).append("\n"); 
		query.append("              ,DYS_DMT_EXPT_SEA)  CNTR_MT_DYS      " ).append("\n"); 
		query.append("  FROM (      " ).append("\n"); 
		query.append("        SELECT A.POR_CD" ).append("\n"); 
		query.append("              ,A.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("              ,A.POL_CD" ).append("\n"); 
		query.append("              ,A.TS_ROUT" ).append("\n"); 
		query.append("              ,A.POD_CD" ).append("\n"); 
		query.append("              ,A.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("              ,A.DEL_CD" ).append("\n"); 
		query.append("              ,A.TTL_TZTM_HRS" ).append("\n"); 
		query.append("              ,A.REMARK_IMG" ).append("\n"); 
		query.append("              ,A.REMARK" ).append("\n"); 
		query.append("              ,A.TOTAL_COST" ).append("\n"); 
		query.append("              ,A.TRNK_AVAL_SPC" ).append("\n"); 
		query.append("              ,A.PCTL_NO" ).append("\n"); 
		query.append("              ,A.TRNK_VVD" ).append("\n"); 
		query.append("              ,A.TRNK_LANE" ).append("\n"); 
		query.append("              ,A.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("              ,A.POR_NOD_CD" ).append("\n"); 
		query.append("              ,A.DEL_NOD_CD" ).append("\n"); 
		query.append("              ,A.ROUT_CNST_SEQ" ).append("\n"); 
		query.append("              ,A.ROUT_FLAG" ).append("\n"); 
		query.append("              ,A.ORD" ).append("\n"); 
		query.append("              ,A.CNTR_TP" ).append("\n"); 
		query.append("              ,A.MTY_RTN_YD_CD" ).append("\n"); 
		query.append("        	   ,DECODE(MAS_PRE_EQ_DYS_FNC(A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD, A.TS_ROUT, A.CNTR_TP), NULL," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("							SELECT NVL(ROUND(SUM(P.MT_LAND) / DECODE(COUNT(P.MT_LAND),0,1,COUNT(P.MT_LAND)),2),0) MT_AVG" ).append("\n"); 
		query.append("							FROM (                 " ).append("\n"); 
		query.append("    							SELECT DECODE(MAS_UT_TPSZ_FNC('TPS', TPSZ_CD), 'RD2', 'R2', 'RD4', 'R4', 'RD5', 'R5',' RD7', 'R7', 'RD8', 'R8', 'RD9', 'R9', MAS_UT_TPSZ_FNC('TPS', TPSZ_CD)) TPSZ_CD" ).append("\n"); 
		query.append("          							,MT_LAND" ).append("\n"); 
		query.append("									,POR_CD" ).append("\n"); 
		query.append("									,DEL_CD" ).append("\n"); 
		query.append("    							FROM MAS_CNTR_PRECM_CALC" ).append("\n"); 
		query.append("    							) P" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("    							AND P.POR_CD = A.POR_CD" ).append("\n"); 
		query.append("    							AND P.DEL_CD = A.DEL_CD" ).append("\n"); 
		query.append("								AND P.TPSZ_CD = DECODE(MAS_UT_TPSZ_FNC('TPS', A.CNTR_TP), 'RD2', 'R2', 'RD4', 'R4', 'RD5', 'R5',' RD7', 'R7', 'RD8', 'R8', 'RD9', 'R9', MAS_UT_TPSZ_FNC('TPS', A.CNTR_TP)) " ).append("\n"); 
		query.append("                           ) + SUBSTR(A.TTL_TZTM_HRS,0,2)," ).append("\n"); 
		query.append("                           MAS_PRE_EQ_DYS_FNC(A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD, A.TS_ROUT, A.CNTR_TP)) DYS_DMT_EXPT_SEA" ).append("\n"); 
		query.append("--              ,DECODE(B.DYS_DMT, NULL," ).append("\n"); 
		query.append("--                          (" ).append("\n"); 
		query.append("--                            SELECT ROUND(SUM(FULL_DMT) / DECODE(COUNT(FULL_DMT),0,1,COUNT(FULL_DMT)),2) DMT_AVG" ).append("\n"); 
		query.append("--							SELECT ROUND(SUM(FULL_DMT * BX_KNT) / DECODE(SUM(BX_KNT),0,1,SUM(BX_KNT)),2) DMT_AVG" ).append("\n"); 
		query.append("--                              FROM MAS_CNTR_PRECM_CALC" ).append("\n"); 
		query.append("--                              WHERE POR_CD = A.POR_CD AND DEL_CD = A.DEL_CD AND TPSZ_CD = A.CNTR_TP" ).append("\n"); 
		query.append("--                          )," ).append("\n"); 
		query.append("--                          B.DYS_DMT) DYS_DMT " ).append("\n"); 
		query.append("				,(" ).append("\n"); 
		query.append("					SELECT NVL(ROUND(SUM(P.FULL_DMT * P.BX_KNT) / DECODE(SUM(P.BX_KNT),0,1,SUM(P.BX_KNT)),2),0) DMT_AVG" ).append("\n"); 
		query.append("					FROM (" ).append("\n"); 
		query.append("    					SELECT DECODE(MAS_UT_TPSZ_FNC('TPS', TPSZ_CD), 'RD2', 'R2', 'RD4', 'R4', 'RD5', 'R5',' RD7', 'R7', 'RD8', 'R8', 'RD9', 'R9', MAS_UT_TPSZ_FNC('TPS', TPSZ_CD)) TPSZ_CD" ).append("\n"); 
		query.append("          					,FULL_DMT" ).append("\n"); 
		query.append("          					,BX_KNT" ).append("\n"); 
		query.append("							,POR_CD" ).append("\n"); 
		query.append("							,DEL_CD" ).append("\n"); 
		query.append("    					FROM MAS_CNTR_PRECM_CALC" ).append("\n"); 
		query.append("    					) P" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("						AND P.POR_CD = A.POR_CD" ).append("\n"); 
		query.append("      					AND P.DEL_CD = A.DEL_CD" ).append("\n"); 
		query.append("						AND P.TPSZ_CD = DECODE(MAS_UT_TPSZ_FNC('TPS', A.CNTR_TP), 'RD2', 'R2', 'RD4', 'R4', 'RD5', 'R5',' RD7', 'R7', 'RD8', 'R8', 'RD9', 'R9', MAS_UT_TPSZ_FNC('TPS', A.CNTR_TP))" ).append("\n"); 
		query.append("                 ) DYS_DMT      " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("        		SELECT   por_cd, ob_itchg_ctnt, pol_cd," ).append("\n"); 
		query.append("                 	RTRIM (   MAX (DECODE (ts.rk," ).append("\n"); 
		query.append("                                        1, REPLACE (ts.vsl_slan_cd, '-(', '(')" ).append("\n"); 
		query.append("                                       ))" ).append("\n"); 
		query.append("                        || n1st_ts_port_cd" ).append("\n"); 
		query.append("                        || MAX (DECODE (ts.rk, 2, ts.vsl_slan_cd))" ).append("\n"); 
		query.append("                        || n2nd_ts_port_cd" ).append("\n"); 
		query.append("                        || MAX (DECODE (ts.rk, 3, ts.vsl_slan_cd))" ).append("\n"); 
		query.append("                        || n3rd_ts_port_cd" ).append("\n"); 
		query.append("                        || MAX (DECODE (ts.rk, 4, ts.vsl_slan_cd))," ).append("\n"); 
		query.append("                        '-'" ).append("\n"); 
		query.append("                       ) ts_rout," ).append("\n"); 
		query.append("                 	pod_cd, ib_itchg_ctnt, del_cd," ).append("\n"); 
		query.append("                 	   LPAD (FLOOR (ttl_tztm_hrs / 24), 2, 0)" ).append("\n"); 
		query.append("              	   || LPAD (MOD (ttl_tztm_hrs, 24), 2, 0) ttl_tztm_hrs," ).append("\n"); 
		query.append("        		 	DECODE(LENGTH(cnst_flg), 1, '1', '3') remark_img, DECODE(LENGTH(cnst_flg), 1, cnst_flg, '') remark, " ).append("\n"); 
		query.append("                 	round(ttl_expn_amt,2) total_cost, trnk_aval_spc," ).append("\n"); 
		query.append("                 	m.pctl_no," ).append("\n"); 
		query.append("                 	trnk_vsl_cd || trnk_skd_voy_no || trnk_skd_dir_cd trnk_vvd," ).append("\n"); 
		query.append("        		 	(select vsl_slan_cd from vsk_vsl_skd v" ).append("\n"); 
		query.append("        				where v.vsl_cd = trnk_vsl_cd" ).append("\n"); 
		query.append("        				and v.skd_voy_no = trnk_skd_voy_no" ).append("\n"); 
		query.append("        				and v.skd_dir_cd = trnk_skd_dir_cd) trnk_lane," ).append("\n"); 
		query.append("                 	mty_pkup_yd_cd, por_nod_cd, del_nod_cd ," ).append("\n"); 
		query.append("        			--m.PCTL_NO," ).append("\n"); 
		query.append("        		 	m.rout_cnst_seq," ).append("\n"); 
		query.append("        		 	DECODE(rout_flag, 'S', 'Standard', 'T', 'Temporary', 'V', 'Validation', 'N', 'Not Used', 'A', 'Add Call', 'D', 'Deleted', 'G', 'Guide') rout_flag," ).append("\n"); 
		query.append("        		 	DECODE(rout_flag,  'G',1, 'S', 1, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord" ).append("\n"); 
		query.append("                 	,(select CNTR_TPSZ_CD from prd_prod_ctl_qty where pctl_no = m.pctl_no and rownum = 1)  cntr_tp" ).append("\n"); 
		query.append("                 	,MTY_RTN_YD_CD" ).append("\n"); 
		query.append("            	FROM prd_prod_ctl_mst m," ).append("\n"); 
		query.append("                 	(SELECT /*+ LEADING(DTL) USE_NL(ROUT) */" ).append("\n"); 
		query.append("        				 	pctl_no," ).append("\n"); 
		query.append("                         	RANK () OVER (PARTITION BY pctl_no ORDER BY pctl_seq) rk," ).append("\n"); 
		query.append("                         	'-(' || vsl_slan_cd || ')-' vsl_slan_cd," ).append("\n"); 
		query.append("        				 	upd_ind_cd  rout_flag" ).append("\n"); 
		query.append("                    	FROM prd_prod_ctl_rout_dtl dtl, prd_ocn_rout rout" ).append("\n"); 
		query.append("                   	WHERE pctl_no LIKE @[start_pctl_no]||'%' AND vsl_slan_cd IS NOT NULL" ).append("\n"); 
		query.append("         				AND  dtl.rout_org_nod_cd = rout.org_loc_cd(+)" ).append("\n"); 
		query.append("        				AND	 dtl.rout_dest_nod_cd = rout.dest_loc_cd(+)" ).append("\n"); 
		query.append("        				AND	 dtl.rout_seq = rout.rout_seq(+)" ).append("\n"); 
		query.append("        		 	) ts" ).append("\n"); 
		query.append("           		WHERE m.pctl_no LIKE @[start_pctl_no]||'%' AND m.pctl_no = ts.pctl_no(+)" ).append("\n"); 
		query.append("        	GROUP BY por_cd," ).append("\n"); 
		query.append("                 ob_itchg_ctnt," ).append("\n"); 
		query.append("                 pol_cd," ).append("\n"); 
		query.append("                 n1st_ts_port_cd," ).append("\n"); 
		query.append("                 n2nd_ts_port_cd," ).append("\n"); 
		query.append("                 n3rd_ts_port_cd," ).append("\n"); 
		query.append("                 pod_cd," ).append("\n"); 
		query.append("                 ib_itchg_ctnt," ).append("\n"); 
		query.append("                 del_cd," ).append("\n"); 
		query.append("                    LPAD (FLOOR (ttl_tztm_hrs / 24), 2, 0)" ).append("\n"); 
		query.append("                 || LPAD (MOD (ttl_tztm_hrs, 24), 2, 0)," ).append("\n"); 
		query.append("                 ttl_expn_amt," ).append("\n"); 
		query.append("                 trnk_aval_spc," ).append("\n"); 
		query.append("                 cnst_flg," ).append("\n"); 
		query.append("                 m.pctl_no," ).append("\n"); 
		query.append("        		 m.rout_cnst_seq," ).append("\n"); 
		query.append("                 trnk_vsl_cd, trnk_skd_voy_no, trnk_skd_dir_cd," ).append("\n"); 
		query.append("                 mty_pkup_yd_cd," ).append("\n"); 
		query.append("                 por_nod_cd," ).append("\n"); 
		query.append("                 del_nod_cd," ).append("\n"); 
		query.append("        		 rout_flag" ).append("\n"); 
		query.append("        		,MTY_RTN_YD_CD" ).append("\n"); 
		query.append("        	order by ord, TTL_EXPN_AMT,TTL_TZTM_HRS" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("      ) M" ).append("\n"); 

	}
}