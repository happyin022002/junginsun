/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvailabilityDBDAOsearchAvailabilityPeriodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.availability.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailabilityDBDAOsearchAvailabilityPeriodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * availability
	  * </pre>
	  */
	public AvailabilityDBDAOsearchAvailabilityPeriodListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_tmp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_cgor_frt_pay_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_cgor_org_bl_rcvr_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.availability.integration").append("\n"); 
		query.append("FileName : AvailabilityDBDAOsearchAvailabilityPeriodListRSQL").append("\n"); 
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
		query.append("select  x.eq_no" ).append("\n"); 
		query.append("       ,x.eq_tpsz_cd" ).append("\n"); 
		query.append("       ,x.eq_tpsz_nm" ).append("\n"); 
		query.append("       ,x.iso_cd" ).append("\n"); 
		query.append("       ,x.iso_nm" ).append("\n"); 
		query.append("       ,x.cntr_wgt" ).append("\n"); 
		query.append("       ,x.f" ).append("\n"); 
		query.append("       ,x.o" ).append("\n"); 
		query.append("       ,x.c" ).append("\n"); 
		query.append("       --,x.cntr_pkup_no" ).append("\n"); 
		query.append("       --,x.pkup_no" ).append("\n"); 
		query.append("       --,x.aval_dt" ).append("\n"); 
		query.append("       --,x.lst_free_dt" ).append("\n"); 
		query.append("       ,x.trsp_wo_no" ).append("\n"); 
		query.append("       ,x.trsp_so_no" ).append("\n"); 
		query.append("       ,x.bl_no" ).append("\n"); 
		query.append("       ,x.bkg_no" ).append("\n"); 
		query.append("       ,x.cop_no" ).append("\n"); 
		query.append("       --,(select to_char(max(ESTM_DT), 'YYYY-MM-DD HH24:MI:SS') from sce_cop_dtl where cop_no=x.cop_no and act_cd='FIRRAD') lst_nod_pln_dt" ).append("\n"); 
		query.append("	   ,x.lst_nod_pln_dt" ).append("\n"); 
		query.append("       ,x.wo_fmt_tp_cd" ).append("\n"); 
		query.append("	   --,(select count(mvmt_sts_cd) from ctm_movement where 1=1 and cntr_no = x.eq_no and bkg_no = x.bkg_no and mvmt_sts_cd = 'ID') ctmsts_id_cnt" ).append("\n"); 
		query.append("	   --,x.ctmsts_id_cnt" ).append("\n"); 
		query.append("	   ,CASE WHEN (x.f||x.o||x.c = 'YYY'" ).append("\n"); 
		query.append("      		OR x.f||x.o||x.c = 'YYW')" ).append("\n"); 
		query.append("  		AND x.pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  		AND x.pkup_no <> ' '" ).append("\n"); 
		query.append("  		AND X.ctmsts_id_cnt < 1 THEN x.pkup_no WHEN (x.f||x.o||x.c = 'YYY'" ).append("\n"); 
		query.append("      		OR x.f||x.o||x.c = 'YYW')" ).append("\n"); 
		query.append("  		AND x.pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  		AND x.pkup_no <> ' '" ).append("\n"); 
		query.append("  		AND X.ctmsts_id_cnt >= 1 THEN 'Transported' ELSE '' END AS pkup_no" ).append("\n"); 
		query.append("  	   ,CASE WHEN (x.f||x.o||x.c = 'YYY'" ).append("\n"); 
		query.append("  		    OR x.f||x.o||x.c = 'YYW')" ).append("\n"); 
		query.append("  		AND x.pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  		AND x.pkup_no <> ' '" ).append("\n"); 
		query.append("  		AND X.ctmsts_id_cnt < 1 THEN x.aval_dt ELSE '' END AS aval_dt" ).append("\n"); 
		query.append("  	   ,CASE WHEN (x.f||x.o||x.c = 'YYY'" ).append("\n"); 
		query.append("   		   OR x.f||x.o||x.c = 'YYW')" ).append("\n"); 
		query.append("  		AND x.pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  		AND x.pkup_no <> ' '" ).append("\n"); 
		query.append("  		AND X.ctmsts_id_cnt < 1 THEN x.lst_free_dt ELSE '' END AS lst_free_dt" ).append("\n"); 
		query.append("  	   ,CASE WHEN (x.f||x.o||x.c = 'YYY'" ).append("\n"); 
		query.append("  		    OR x.f||x.o||x.c = 'YYW')" ).append("\n"); 
		query.append("  		AND x.pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  		AND x.pkup_no <> ' '" ).append("\n"); 
		query.append("  		AND lst_free_dt IS NOT NULL" ).append("\n"); 
		query.append("  		AND lst_free_dt <> ' '" ).append("\n"); 
		query.append("  		AND X.ctmsts_id_cnt < 1 THEN 'Available' ELSE 'Unavailable' END AS avail_nm" ).append("\n"); 
		query.append("from   (select b.eq_no" ).append("\n"); 
		query.append("              ,b.eq_tpsz_cd" ).append("\n"); 
		query.append("              ,(select cntr_tpsz_rmk from mdm_cntr_tp_sz where cntr_tpsz_cd = b.eq_tpsz_cd) eq_tpsz_nm" ).append("\n"); 
		query.append("              ,(select cntr_tpsz_iso_cd from mdm_cntr_tp_sz where cntr_tpsz_cd = b.eq_tpsz_cd)	iso_cd" ).append("\n"); 
		query.append("              ,(select iso_cntr_tpsz_nm from mst_iso_cntr_tp_sz where iso_cntr_tpsz_cd = (select cntr_tpsz_iso_cd from mdm_cntr_tp_sz where cntr_tpsz_cd = b.eq_tpsz_cd)) as iso_nm" ).append("\n"); 
		query.append("              --,b.cntr_wgt" ).append("\n"); 
		query.append("              ,DECODE(b.wgt_meas_ut_cd, 'KGS', ROUND((b.cntr_wgt) * 2.204623, 1), b.cntr_wgt) cntr_wgt" ).append("\n"); 
		query.append("              ,nvl(d.FRT_CLT_FLG,'N') f" ).append("\n"); 
		query.append("	          ,nvl(d.OBL_RDEM_FLG,'N') o" ).append("\n"); 
		query.append("		      -- POD : 'CA',DEL : 'US'의 경우 Rail AMS 정보를 보여준다." ).append("\n"); 
		query.append("		      ,nvl(CASE WHEN (substr(b.pod_cd,0,2) = 'CA') and (substr(b.del_cd,0,2) = 'US') THEN" ).append("\n"); 
		query.append("                	   (" ).append("\n"); 
		query.append("                		select /*+ index_desc(x XPKBKG_CSTMS_ADV_CNTR_RSLT) */" ).append("\n"); 
		query.append("                		       x.cstms_clr_cd" ).append("\n"); 
		query.append("                		  from bkg_cstms_adv_cntr_rslt x" ).append("\n"); 
		query.append("                		 where x.cnt_cd = 'US'  --상수값 " ).append("\n"); 
		query.append("                           and x.bl_no = b.bl_no" ).append("\n"); 
		query.append("                		   and (substr(x.cntr_no,0,length(x.cntr_no)-1) = substr(b.eq_no,0,length(b.eq_no)-1) OR x.cntr_no = substr(b.eq_no,0,length(b.eq_no)-1))" ).append("\n"); 
		query.append("                		   and rownum < 2" ).append("\n"); 
		query.append("                		)" ).append("\n"); 
		query.append("		           ELSE d.CSTMS_CLR_CD" ).append("\n"); 
		query.append("		           END,'N' ) as c" ).append("\n"); 
		query.append("              ,e.cntr_no cntr_pkup_no" ).append("\n"); 
		query.append("              ,e.pkup_no pkup_no" ).append("\n"); 
		query.append("              ,to_char(e.pkup_aval_dt, 'YYYY-MM-DD HH24:MI:SS') aval_dt" ).append("\n"); 
		query.append("              ,to_char(e.lst_free_dt,  'YYYY-MM-DD HH24:MI:SS') lst_free_dt" ).append("\n"); 
		query.append("              ,a.trsp_wo_ofc_cty_cd ||a.trsp_wo_seq as trsp_wo_no" ).append("\n"); 
		query.append("              ,b.trsp_so_ofc_cty_cd || b.trsp_so_seq as trsp_so_no" ).append("\n"); 
		query.append("              ,b.bl_no" ).append("\n"); 
		query.append("              ,b.bkg_no" ).append("\n"); 
		query.append("              ,b.cop_no" ).append("\n"); 
		query.append("			  ,(select to_char(max(ESTM_DT), 'YYYY-MM-DD HH24:MI:SS') from sce_cop_dtl where cop_no=b.cop_no and act_cd='FIRRAD') lst_nod_pln_dt" ).append("\n"); 
		query.append("        	  ,a.wo_fmt_tp_cd" ).append("\n"); 
		query.append("			  ,(select count(mvmt_sts_cd) from ctm_movement where 1=1 and cntr_no = b.eq_no and bkg_no = b.bkg_no and mvmt_sts_cd = 'ID') ctmsts_id_cnt" ).append("\n"); 
		query.append("       from (select trsp_wo_ofc_cty_cd,trsp_wo_seq,wo_fmt_tp_cd" ).append("\n"); 
		query.append("               from trs_trsp_wrk_ord wk" ).append("\n"); 
		query.append("              where wk.wo_vndr_seq = @[vndr_tmp]" ).append("\n"); 
		query.append("            #if (${r_period_flg} == 'W')" ).append("\n"); 
		query.append("            	AND wk.locl_cre_dt >= to_date(@[r_from_dt],'yyyymmdd')" ).append("\n"); 
		query.append("            	AND wk.locl_cre_dt <= to_date(@[r_to_dt]||'235959','yyyymmddhh24miss')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("			 ) a" ).append("\n"); 
		query.append("    	   ,TRS_TRSP_SVC_ORD b" ).append("\n"); 
		query.append("    	   ,BKG_CGO_RLSE d" ).append("\n"); 
		query.append("    	   ,BKG_PKUP_NTC_PKUP_NO e" ).append("\n"); 
		query.append("    	   ,BKG_CSTMS_ADV_CNTR_RSLT s" ).append("\n"); 
		query.append("    	   ,MDM_LOCATION loc" ).append("\n"); 
		query.append("       where b.trsp_wo_ofc_cty_cd = a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("         and b.trsp_wo_seq = a.trsp_wo_seq" ).append("\n"); 
		query.append("         and nvl(b.WO_RJCT_FLG,'N') != 'Y'" ).append("\n"); 
		query.append("         and b.eq_no is not null" ).append("\n"); 
		query.append("         and b.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		 AND b.cre_dt >= to_date('20170213', 'yyyyMMdd')" ).append("\n"); 
		query.append("       #if (${r_period_flg} == 'A')" ).append("\n"); 
		query.append("         AND e.pkup_aval_dt >= to_date(@[r_from_dt],'yyyymmdd')" ).append("\n"); 
		query.append("         AND e.pkup_aval_dt <= to_date(@[r_to_dt]||'235959','yyyymmddhh24miss')" ).append("\n"); 
		query.append("       #elseif(${r_period_flg} == 'L')" ).append("\n"); 
		query.append("         AND e.lst_free_dt >= to_date(@[r_from_dt],'yyyymmdd')" ).append("\n"); 
		query.append("         AND e.lst_free_dt <= to_date(@[r_to_dt]||'235959','yyyymmddhh24miss')" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("         and d.bl_no(+) = b.bl_no" ).append("\n"); 
		query.append("         and e.cntr_no(+) = b.eq_no" ).append("\n"); 
		query.append("         and e.bkg_no(+) = b.bkg_no" ).append("\n"); 
		query.append("         and e.del_cd = loc.loc_cd(+)" ).append("\n"); 
		query.append("         --and e.ofc_cd = loc.eq_ctrl_ofc_cd(+) " ).append("\n"); 
		query.append("         and s.cntr_no(+) = b.eq_no                                                                                                   " ).append("\n"); 
		query.append("      	 and s.bl_no(+) = b.bl_no" ).append("\n"); 
		query.append("		 AND NVL(TO_DATE(e.upd_dt, 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS')) = NVL((" ).append("\n"); 
		query.append("            SELECT TO_DATE(MAX(Y.UPD_DT), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            FROM BKG_PKUP_NTC_PKUP_NO Y" ).append("\n"); 
		query.append("            WHERE Y.BKG_NO = e.BKG_NO" ).append("\n"); 
		query.append("              AND Y.CNTR_NO = e.CNTR_NO" ).append("\n"); 
		query.append("              AND Y.PKUP_YD_CD = e.PKUP_YD_CD), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append("       --F : Freight Collect 여부" ).append("\n"); 
		query.append("       #if (${r_cgor_frt_pay_ind_flg} != '')" ).append("\n"); 
		query.append("         and d.FRT_CLT_FLG  = @[r_cgor_frt_pay_ind_flg]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       --O : Original B/L 회수 여부" ).append("\n"); 
		query.append("       #if (${r_cgor_org_bl_rcvr_ind_flg} != '')" ).append("\n"); 
		query.append("         and d.OBL_RDEM_FLG  = @[r_cgor_org_bl_rcvr_ind_flg]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       --C : 세관통관여부" ).append("\n"); 
		query.append("       #if (${r_cgor_cstms_acpt_re_ind_flg} != '' && ${r_cgor_cstms_acpt_re_ind_flg} == 'Y')" ).append("\n"); 
		query.append("         and (d.CSTMS_CLR_CD IN ('Y','W') or s.CSTMS_CLR_CD IN ('Y','W'))" ).append("\n"); 
		query.append("	   #elseif (${r_cgor_cstms_acpt_re_ind_flg} != '' && ${r_cgor_cstms_acpt_re_ind_flg} == 'N')" ).append("\n"); 
		query.append("		 and (d.CSTMS_CLR_CD NOT IN ('Y','W') or s.CSTMS_CLR_CD NOT IN ('Y','W'))" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       --Pickup Number  생성 여부" ).append("\n"); 
		query.append("       #if ((${r_cntr_pkup_no_flg} != '') && (${r_cntr_pkup_no_flg} == 'Y'))" ).append("\n"); 
		query.append("         and   e.pkup_no  is not null" ).append("\n"); 
		query.append("       #elseif((${r_cntr_pkup_no_flg} != '') && (${r_cntr_pkup_no_flg} == 'N'))" ).append("\n"); 
		query.append("         and   e.pkup_no  is null" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ) x" ).append("\n"); 
		query.append("#if ((${r_avl_sts_flg} != '') && (${r_avl_sts_flg} == 'A'))" ).append("\n"); 
		query.append("where nvl(x.f,'N')||nvl(x.o,'N')||nvl(x.c,'N') IN ('YYY','YYW')" ).append("\n"); 
		query.append("  and x.pkup_no is not null" ).append("\n"); 
		query.append("  and x.lst_free_dt is not null" ).append("\n"); 
		query.append("  and (select count(mvmt_sts_cd) from ctm_movement where 1=1 and cntr_no = x.eq_no and bkg_no = x.bkg_no and mvmt_sts_cd = 'ID') = 0" ).append("\n"); 
		query.append("#elseif((${r_avl_sts_flg} != '') && (${r_avl_sts_flg} == 'U'))" ).append("\n"); 
		query.append("where (nvl(x.f,'N')||nvl(x.o,'N')||nvl(x.c,'N') NOT IN ('YYY','YYW')" ).append("\n"); 
		query.append("   or x.pkup_no is null" ).append("\n"); 
		query.append("   or x.lst_free_dt is null" ).append("\n"); 
		query.append("   or (select count(mvmt_sts_cd) from ctm_movement where 1=1 and cntr_no = x.eq_no and bkg_no = x.bkg_no and mvmt_sts_cd = 'ID') > 0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by x.eq_no asc" ).append("\n"); 

	}
}