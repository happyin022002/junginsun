/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AvailabilityDBDAOsearchAvailabilityNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.23
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2016.08.23 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.availability.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailabilityDBDAOsearchAvailabilityNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAvailabilityNoList Inquiry 의 데이타 모델에 해당되는 값을 불러온다
	  * </pre>
	  */
	public AvailabilityDBDAOsearchAvailabilityNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_tmp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.availability.integration").append("\n"); 
		query.append("FileName : AvailabilityDBDAOsearchAvailabilityNoListRSQL").append("\n"); 
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
		query.append("select  x.eq_no																																																	" ).append("\n"); 
		query.append("       ,x.eq_tpsz_cd                                                                                                                " ).append("\n"); 
		query.append("       ,x.eq_tpsz_nm                                                                                                                " ).append("\n"); 
		query.append("       ,x.iso_cd                                                                                                                    " ).append("\n"); 
		query.append("       ,x.iso_nm                                                                                                                    " ).append("\n"); 
		query.append("       ,x.cntr_wgt                                                                                                                  " ).append("\n"); 
		query.append("       ,x.f                                                                                                                         " ).append("\n"); 
		query.append("       ,x.o                                                                                                                         " ).append("\n"); 
		query.append("       ,x.c                                                                                                                         " ).append("\n"); 
		query.append("       --,x.cntr_pkup_no                                                                                                              " ).append("\n"); 
		query.append("       --,x.pkup_no                                                                                                                   " ).append("\n"); 
		query.append("       --,x.aval_dt                                                                                                                   " ).append("\n"); 
		query.append("       --,x.lst_free_dt                                                                                                               " ).append("\n"); 
		query.append("       ,x.trsp_wo_no                                                                                                                " ).append("\n"); 
		query.append("       ,x.trsp_so_no                                                                                                                " ).append("\n"); 
		query.append("       ,x.bl_no                                                                                                                     " ).append("\n"); 
		query.append("       ,x.bkg_no                                                                                                                    " ).append("\n"); 
		query.append("       ,x.cop_no                                                                                                                    " ).append("\n"); 
		query.append("       --,(select to_char(max(ESTM_DT), 'YYYY-MM-DD HH24:MI:SS') from sce_cop_dtl where cop_no=x.cop_no and act_cd='FIRRAD') lst_nod_pln_dt" ).append("\n"); 
		query.append("	   ,x.lst_nod_pln_dt	" ).append("\n"); 
		query.append("	   ,x.wo_fmt_tp_cd" ).append("\n"); 
		query.append("	   --,(select count(mvmt_sts_cd) from ctm_movement where 1=1 and cntr_no = x.eq_no and bkg_no = x.bkg_no and mvmt_sts_cd = 'ID') ctmsts_id_cnt" ).append("\n"); 
		query.append("	   --,x.ctmsts_id_cnt" ).append("\n"); 
		query.append("  	   ,CASE WHEN (x.f||x.o||x.c = 'YYY'" ).append("\n"); 
		query.append("      		OR x.f||x.o||x.c = 'YYW')" ).append("\n"); 
		query.append("  		AND x.pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  		AND x.pkup_no <> ' '" ).append("\n"); 
		query.append("  		AND x.ctmsts_id_cnt < 1 THEN x.pkup_no WHEN (x.f||x.o||x.c = 'YYY'" ).append("\n"); 
		query.append("      		OR x.f||x.o||x.c = 'YYW')" ).append("\n"); 
		query.append("  		AND x.pkup_no IS NOT NULL" ).append("\n"); 
		query.append("  		AND x.pkup_no <> ' '" ).append("\n"); 
		query.append("  		AND x.ctmsts_id_cnt >= 1 THEN 'Transported' ELSE '' END AS pkup_no" ).append("\n"); 
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
		query.append("from   (select b.eq_no                                                                                                                " ).append("\n"); 
		query.append("              ,b.eq_tpsz_cd                                                                                                            " ).append("\n"); 
		query.append("              ,(select cntr_tpsz_rmk from mdm_cntr_tp_sz where cntr_tpsz_cd = b.eq_tpsz_cd) eq_tpsz_nm                                 " ).append("\n"); 
		query.append("              ,(select cntr_tpsz_iso_cd from mdm_cntr_tp_sz where cntr_tpsz_cd = b.eq_tpsz_cd)	iso_cd                                 " ).append("\n"); 
		query.append("              ,(select iso_cntr_tpsz_nm from mst_iso_cntr_tp_sz where iso_cntr_tpsz_cd = (select cntr_tpsz_iso_cd from mdm_cntr_tp_sz where cntr_tpsz_cd = b.eq_tpsz_cd)) as iso_nm                                              " ).append("\n"); 
		query.append("              --,b.cntr_wgt" ).append("\n"); 
		query.append("              ,DECODE(b.wgt_meas_ut_cd, 'KGS', ROUND((b.cntr_wgt) * 2.204623, 1), b.cntr_wgt) cntr_wgt                                                                                                              " ).append("\n"); 
		query.append("              ,nvl(d.FRT_CLT_FLG,'N') f                                                                                       " ).append("\n"); 
		query.append("              ,nvl(d.OBL_RDEM_FLG,'N') o                                                                                   " ).append("\n"); 
		query.append("              -- POD : 'CA',DEL : 'US'의 경우 Rail AMS 정보를 보여준다.                                                                                " ).append("\n"); 
		query.append("              ,nvl(CASE WHEN (substr(b.pod_cd,0,2) = 'CA') and (substr(b.del_cd,0,2) = 'US') THEN" ).append("\n"); 
		query.append("                	   (" ).append("\n"); 
		query.append("                		select /*+ index_desc(x XPKBKG_CSTMS_ADV_CNTR_RSLT) */" ).append("\n"); 
		query.append("                			   x.cstms_clr_cd" ).append("\n"); 
		query.append("                		  from bkg_cstms_adv_cntr_rslt x" ).append("\n"); 
		query.append("                		 where x.cnt_cd = 'US'  --상수값" ).append("\n"); 
		query.append("                           and x.bl_no = b.bl_no" ).append("\n"); 
		query.append("                		   and (substr(x.cntr_no,0,length(x.cntr_no)-1) = substr(b.eq_no,0,length(b.eq_no)-1)OR x.cntr_no = substr(b.eq_no,0,length(b.eq_no)-1))" ).append("\n"); 
		query.append("                		   and rownum < 2" ).append("\n"); 
		query.append("                	    )" ).append("\n"); 
		query.append("    		       ELSE d.CSTMS_CLR_CD" ).append("\n"); 
		query.append("    		       END,'N' ) as c" ).append("\n"); 
		query.append("              ,e.cntr_no cntr_pkup_no                                                                                           " ).append("\n"); 
		query.append("              ,e.pkup_no pkup_no                                                                                                " ).append("\n"); 
		query.append("              ,to_char(e.pkup_aval_dt, 'YYYY-MM-DD HH24:MI:SS') aval_dt                                                                     " ).append("\n"); 
		query.append("              ,to_char(e.lst_free_dt,  'YYYY-MM-DD HH24:MI:SS') lst_free_dt                                                                " ).append("\n"); 
		query.append("              ,b.trsp_wo_ofc_cty_cd || b.trsp_wo_seq as trsp_wo_no                                                                      " ).append("\n"); 
		query.append("              ,b.trsp_so_ofc_cty_cd || b.trsp_so_seq as trsp_so_no                                                                     " ).append("\n"); 
		query.append("              ,b.bl_no as bl_no                                                                               " ).append("\n"); 
		query.append("              ,b.bkg_no                                                                                                                " ).append("\n"); 
		query.append("              ,b.cop_no" ).append("\n"); 
		query.append("			  ,(select to_char(max(ESTM_DT), 'YYYY-MM-DD HH24:MI:SS') from sce_cop_dtl where cop_no=b.cop_no and act_cd='FIRRAD') lst_nod_pln_dt                                                                                                                " ).append("\n"); 
		query.append("        	  ,b.wo_fmt_tp_cd" ).append("\n"); 
		query.append("			  ,(select count(mvmt_sts_cd) from ctm_movement where 1=1 and cntr_no = b.eq_no and bkg_no = b.bkg_no and mvmt_sts_cd = 'ID') ctmsts_id_cnt" ).append("\n"); 
		query.append("        from ( select /*+ index(wk XPKTRS_TRSP_WRK_ORD) */                                             " ).append("\n"); 
		query.append("	                    b.eq_no                                                                                                                " ).append("\n"); 
		query.append("	    	           ,b.eq_tpsz_cd                                                                                                            " ).append("\n"); 
		query.append("	    	           ,b.cntr_wgt" ).append("\n"); 
		query.append("                       ,b.wgt_meas_ut_cd                                                                                                              " ).append("\n"); 
		query.append("	    	           ,b.trsp_so_ofc_cty_cd                                                            " ).append("\n"); 
		query.append("	    	           ,b.trsp_so_seq                                                                     " ).append("\n"); 
		query.append("	    	           ,b.bkg_no                                                                                                               " ).append("\n"); 
		query.append("	    	           ,b.cop_no                                                                                                                " ).append("\n"); 
		query.append("	    	           ,wk.trsp_wo_ofc_cty_cd                                                           " ).append("\n"); 
		query.append("	    	           ,wk.trsp_wo_seq                                                                                  " ).append("\n"); 
		query.append("	    	           ,b.bl_no" ).append("\n"); 
		query.append("					   ,wk.wo_fmt_tp_cd" ).append("\n"); 
		query.append("					   ,b.pod_cd" ).append("\n"); 
		query.append("					   ,b.del_cd" ).append("\n"); 
		query.append("               from trs_trsp_wrk_ord wk                                                              " ).append("\n"); 
		query.append("                   ,trs_trsp_svc_ord b                                                                                             " ).append("\n"); 
		query.append("               where 1 = 1                                                                            " ).append("\n"); 
		query.append("            #if ($wo_no.size() > 0) " ).append("\n"); 
		query.append("                 AND (wk.trsp_wo_ofc_cty_cd,wk.trsp_wo_seq) in (" ).append("\n"); 
		query.append("                #foreach($wonoKey in ${wo_no}) " ).append("\n"); 
		query.append("                	#if($velocityCount < $wo_no.size()) " ).append("\n"); 
		query.append("                		(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("                	#else " ).append("\n"); 
		query.append("                		(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("                	#end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                 )                             " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if ($EqNo.size() > 0) " ).append("\n"); 
		query.append("                 and  (1,b.eq_no) in ( " ).append("\n"); 
		query.append("                #foreach($EqNokey IN ${EqNo}) " ).append("\n"); 
		query.append("                	#if($velocityCount < $EqNo.size()) " ).append("\n"); 
		query.append("                		(1,'$EqNokey')," ).append("\n"); 
		query.append("                	#else " ).append("\n"); 
		query.append("                		(1,'$EqNokey')" ).append("\n"); 
		query.append("                	#end " ).append("\n"); 
		query.append("                #end  " ).append("\n"); 
		query.append("                 )                             " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if ($BkgNo.size() > 0) " ).append("\n"); 
		query.append("                 and  (1,b.bkg_no) in ( " ).append("\n"); 
		query.append("                #foreach($BkgNokey IN ${BkgNo}) " ).append("\n"); 
		query.append("                	#if($velocityCount < $BkgNo.size()) " ).append("\n"); 
		query.append("                		(1,'$BkgNokey')," ).append("\n"); 
		query.append("                	#else " ).append("\n"); 
		query.append("                		(1,'$BkgNokey')" ).append("\n"); 
		query.append("                	#end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                 )                             " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if ($BlNo.size() > 0) " ).append("\n"); 
		query.append("                 and  (b.bl_no) in ( " ).append("\n"); 
		query.append("                #foreach($BlNokey IN ${BlNo}) " ).append("\n"); 
		query.append("                	#if($velocityCount < $BlNo.size()) " ).append("\n"); 
		query.append("                		('$BlNokey'), " ).append("\n"); 
		query.append("                	#else " ).append("\n"); 
		query.append("                		('$BlNokey')" ).append("\n"); 
		query.append("                	#end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                 )                             " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 and b.trsp_wo_ofc_cty_cd = wk.trsp_wo_ofc_cty_cd                                                                               " ).append("\n"); 
		query.append("                 and b.trsp_wo_seq = wk.trsp_wo_seq                                                                                                                                      " ).append("\n"); 
		query.append("                 and nvl(b.WO_RJCT_FLG,'N') != 'Y'                                                                                            " ).append("\n"); 
		query.append("                 and b.eq_no is not null                                                                                                      " ).append("\n"); 
		query.append("                 and b.DELT_FLG = 'N'                                                                                       	          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	#if (${vndr_dvsn} != 'M')" ).append("\n"); 
		query.append("        	     and wk.wo_vndr_seq  =  @[vndr_tmp]  " ).append("\n"); 
		query.append("        	#end " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("             ) b                                                                                                                     " ).append("\n"); 
		query.append("       --,bkg_booking c                                                                                                           " ).append("\n"); 
		query.append("       ,BKG_CGO_RLSE d                                                                                                 " ).append("\n"); 
		query.append("       ,BKG_PKUP_NTC_PKUP_NO e" ).append("\n"); 
		query.append("       ,MDM_LOCATION loc" ).append("\n"); 
		query.append("     where d.bl_no(+) = b.bl_no" ).append("\n"); 
		query.append("	   and e.cntr_no(+) = b.eq_no                                                                                                   " ).append("\n"); 
		query.append("       and e.bkg_no(+) = b.bkg_no" ).append("\n"); 
		query.append("       and e.del_cd = loc.loc_cd(+)" ).append("\n"); 
		query.append("       --and e.ofc_cd = loc.eq_ctrl_ofc_cd(+)" ).append("\n"); 
		query.append("	   AND NVL(TO_DATE(e.upd_dt, 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS')) = NVL((" ).append("\n"); 
		query.append("            SELECT TO_DATE(MAX(Y.UPD_DT), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            FROM BKG_PKUP_NTC_PKUP_NO Y" ).append("\n"); 
		query.append("            WHERE Y.BKG_NO = e.BKG_NO" ).append("\n"); 
		query.append("              AND Y.CNTR_NO = e.CNTR_NO" ).append("\n"); 
		query.append("              AND Y.PKUP_YD_CD = e.PKUP_YD_CD), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS'))                                                                                                   " ).append("\n"); 
		query.append("	   ) x                                                                                          " ).append("\n"); 
		query.append("order by x.eq_no asc" ).append("\n"); 

	}
}