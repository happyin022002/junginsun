/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchRdContentsCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchRdContentsCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRdContentsCntrList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchRdContentsCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchRdContentsCntrListRSQL").append("\n"); 
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
		query.append("SELECT  cntr_seq as rnum" ).append("\n"); 
		query.append(" 		,equipment_number" ).append("\n"); 
		query.append(" 		,type_size" ).append("\n"); 
		query.append(" 		,rate" ).append("\n"); 
		query.append(" 		,special_cargo" ).append("\n"); 
		query.append(" 		,weight" ).append("\n"); 
		query.append(" 		,commodity_description" ).append("\n"); 
		query.append(" 		,inbond_transit_number" ).append("\n"); 
		query.append(" 		,purchase_order_no" ).append("\n"); 
		query.append(" 		,booking_number" ).append("\n"); 
		query.append(" 		,bl_no" ).append("\n"); 
		query.append(" 		,vessel" ).append("\n"); 
		query.append(" 		,next_port" ).append("\n"); 
		query.append(" 		,shipper_name" ).append("\n"); 
		query.append(" 		,shipper_telephone_number" ).append("\n"); 
		query.append(" 		,door_service_type" ).append("\n"); 
		query.append(" 		,pickup_no" ).append("\n"); 
		query.append(" 		,available_date" ).append("\n"); 
		query.append(" 		,last_free_date" ).append("\n"); 
		query.append(" 		,cs_clear_no" ).append("\n"); 
		query.append(" 		,expected_departure_time" ).append("\n"); 
		query.append(" 		,expected_arrival_time" ).append("\n"); 
		query.append(" 		,door_arrival_appointment_time" ).append("\n"); 
		query.append(" 		,usa_last_city" ).append("\n"); 
		query.append(" 		,blck_stwg" ).append("\n"); 
		query.append(" 		,del_cd" ).append("\n"); 
		query.append(" 		,remark" ).append("\n"); 
		query.append(" 		,wo_cxl_flg" ).append("\n"); 
		query.append(" 		,seal_no" ).append("\n"); 
		query.append("		,detain" ).append("\n"); 
		query.append(" 		,bnum" ).append("\n"); 
		query.append(" 		,tro_lod_ref_no" ).append("\n"); 
		query.append(" 		,MIN(DECODE(mlt_stop_de_flg" ).append("\n"); 
		query.append("					,'Y',DECODE(trsp_rqst_ord_sub_seq" ).append("\n"); 
		query.append("								,1,multi.dor_addr_tp_cd)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			) as dor_addr_tp" ).append("\n"); 
		query.append(" 		,MIN(DECODE(mlt_stop_de_flg" ).append("\n"); 
		query.append("					,'Y',DECODE(trsp_rqst_ord_sub_seq" ).append("\n"); 
		query.append("								,1,DECODE(multi.dor_addr_tp_cd" ).append("\n"); 
		query.append("										  ,'D','Door '" ).append("\n"); 
		query.append("										  ,'C','Customs ')" ).append("\n"); 
		query.append("									||'ADDR : '||'('||multi.dor_pst_cd||') '||" ).append("\n"); 
		query.append("     								RTRIM(SUBSTR(multi.dor_addr,1,30))|| RTRIM(SUBSTR(multi.dor_addr,31,30))||' '||" ).append("\n"); 
		query.append("     								RTRIM(SUBSTR(multi.dor_addr,61,30))||' '||RTRIM(SUBSTR(multi.dor_addr,91,30))||' / '||" ).append("\n"); 
		query.append("									TO_CHAR(dor_arr_dt,'YYYY-MM-DD HH24:MI')||CHR(10))" ).append("\n"); 
		query.append("                 	,'')" ).append("\n"); 
		query.append("		 	)                          as mlt_stop_1" ).append("\n"); 
		query.append(" 		,MIN(DECODE(mlt_stop_de_flg," ).append("\n"); 
		query.append("					'Y',DECODE(trsp_rqst_ord_sub_seq" ).append("\n"); 
		query.append("							   ,2, DECODE(multi.dor_addr_tp_cd" ).append("\n"); 
		query.append("										 ,'D','Door '" ).append("\n"); 
		query.append("										 ,'C','Customs ')" ).append("\n"); 
		query.append("								||'ADDR : '||'('||multi.dor_pst_cd||') '||" ).append("\n"); 
		query.append("								RTRIM(SUBSTR(multi.dor_addr,1,30))|| RTRIM(SUBSTR(multi.dor_addr,31,30))||' '||" ).append("\n"); 
		query.append("								RTRIM(SUBSTR(multi.dor_addr,61,30))||' '||RTRIM(SUBSTR(multi.dor_addr,91,30))||' / '||" ).append("\n"); 
		query.append("								TO_CHAR(dor_arr_dt,'YYYY-MM-DD HH24:MI')||CHR(10))" ).append("\n"); 
		query.append("                  	,'')" ).append("\n"); 
		query.append("          	) as mlt_stop_2" ).append("\n"); 
		query.append("		 ,MIN(DECODE(mlt_stop_de_flg" ).append("\n"); 
		query.append("					,'Y',DECODE(trsp_rqst_ord_sub_seq" ).append("\n"); 
		query.append("								,3,DECODE(multi.dor_addr_tp_cd" ).append("\n"); 
		query.append("										  ,'D','Door '" ).append("\n"); 
		query.append("										  ,'C','Customs ') " ).append("\n"); 
		query.append("								   ||'ADDR : '||'('||multi.dor_pst_cd||') '|| " ).append("\n"); 
		query.append("								   RTRIM(SUBSTR(multi.dor_addr,1,30))||RTRIM(SUBSTR(multi.dor_addr,31,30))||' '||" ).append("\n"); 
		query.append("     							   RTRIM(SUBSTR(multi.dor_addr,61,30))||' '|| RTRIM(SUBSTR(multi.dor_addr,91,30))||' / '" ).append("\n"); 
		query.append("								   ||TO_CHAR(dor_arr_dt,'YYYY-MM-DD HH24:MI')||CHR(10))" ).append("\n"); 
		query.append("        	          ,'')" ).append("\n"); 
		query.append("  	        ) as mlt_stop_3" ).append("\n"); 
		query.append(" 		 ,MIN(DECODE(mlt_stop_de_flg" ).append("\n"); 
		query.append("   	        	      ,'Y',DECODE(trsp_rqst_ord_sub_seq" ).append("\n"); 
		query.append("    	                         ,4,DECODE(multi.dor_addr_tp_cd" ).append("\n"); 
		query.append("        	                               ,'D','Door '" ).append("\n"); 
		query.append("                	                       ,'C','Customs ')" ).append("\n"); 
		query.append("                    	                          ||'ADDR : '||'('||multi.dor_pst_cd||') '||" ).append("\n"); 
		query.append("     	 										    RTRIM(SUBSTR(multi.dor_addr,1,30))|| RTRIM(SUBSTR(multi.dor_addr,31,30))||' '||" ).append("\n"); 
		query.append("                            	                    RTRIM(SUBSTR(multi.dor_addr,61,30))||' '||RTRIM(SUBSTR(multi.dor_addr,91,30))||' / '||" ).append("\n"); 
		query.append("                                	                TO_CHAR(DOR_ARR_DT,'YYYY-MM-DD HH24:MI')||CHR(10))" ).append("\n"); 
		query.append("                  	,'')	" ).append("\n"); 
		query.append("           	) as mlt_stop_4" ).append("\n"); 
		query.append(" 	 	,MIN(DECODE(mlt_stop_de_flg" ).append("\n"); 
		query.append("					,'Y',DECODE(trsp_rqst_ord_sub_seq" ).append("\n"); 
		query.append("								,5,'PLEASE, CONTACT P.I.C. FOR MORE...')" ).append("\n"); 
		query.append("					,'')" ).append("\n"); 
		query.append("			  ) as mlt_stop_5" ).append("\n"); 
		query.append(" 	FROM(SELECT so.eq_no as equipment_number                   " ).append("\n"); 
		query.append("     			,tpsz.cntr_tpsz_rmk as type_size                          " ).append("\n"); 
		query.append("     			,tmp.curr_cd ||' '|| TO_CHAR(NVL(tmp.bzc_amt,0)+NVL(tmp.etc_add_amt,0)+NVL(tmp.fuel_scg_amt,0)+NVL(tmp.scg_vat_amt,0)+NVL(tmp.nego_amt,0)+NVL(tmp.toll_fee_amt,0)) as rate                               " ).append("\n"); 
		query.append("     			,spcl_cgo_cntr_tp_cd as special_cargo                      " ).append("\n"); 
		query.append("     			,CASE WHEN so.wgt_meas_ut_cd = 'KGS'                                           " ).append("\n"); 
		query.append("          			 	THEN so.cntr_kgs_wgt+tpsz.cntr_tpsz_tare_wgt || ' / ' || so.cntr_kgs_wgt || ' KGS'                            " ).append("\n"); 
		query.append("           			  ELSE so.cntr_lbs_wgt+trs_common_pkg.get_conv_wgt_to_lbs_fnc('KGS',tpsz.cntr_tpsz_tare_wgt)|| ' / ' ||so.cntr_lbs_wgt || ' LBS'" ).append("\n"); 
		query.append("           		 END as weight                                                                 " ).append("\n"); 
		query.append("     			,DECODE(SUBSTR(so.bkg_tro_no,2,1),'E' ,NVL(hd.rep_cmdt_desc,cmdt.cmdt_nm),cmdt.cmdt_nm)|| ' /'||TO_CHAR(bkg_cntr.pck_qty) || ' '||bkg_cntr.pck_cd as commodity_description" ).append("\n"); 
		query.append("     			,us_cgo_rlse.ibd_no as inbond_transit_number              " ).append("\n"); 
		query.append("     			,bkg_cntr.po_no as purchase_order_no                  " ).append("\n"); 
		query.append("     			,so.bkg_no as booking_number                     " ).append("\n"); 
		query.append("     			,so.bl_no as bl_no                              " ).append("\n"); 
		query.append("     			,vsl.vsl_eng_nm||' '||so.skd_voy_no||so.skd_dir_cd as vessel                             " ).append("\n"); 
		query.append("     			,DECODE(so.trsp_nxt_port_cd,NULL ,loc2.loc_nm||'('||so.pod_cd||')'  ,loc1.loc_nm||'('||so.trsp_nxt_port_cd||')') as next_port                          " ).append("\n"); 
		query.append("     			,bkg_cust.cust_nm as shipper_name                       " ).append("\n"); 
		query.append("   		 		,cust_cntc.phn_no as shipper_telephone_number           " ).append("\n"); 
		query.append("     			,commcode_pkg.get_comdtl_name_fnc('CD00284',so.dor_svc_tp_cd) as door_service_type" ).append("\n"); 
		query.append("     		    ,CASE WHEN so.cgor_frt_pay_ind_flg = 'Y'                                 " ).append("\n"); 
		query.append("           		 	     AND so.cgor_org_bl_rcvr_ind_flg = 'Y'                                 " ).append("\n"); 
		query.append("            		     AND so.cgor_cstms_acpt_re_ind_flg = 'Y'                                 " ).append("\n"); 
		query.append("           		   	   THEN so.cntr_pkup_no                                                     " ).append("\n"); 
		query.append("           		 	 ELSE ''                                                                  " ).append("\n"); 
		query.append("      		 	  END as pickup_no" ).append("\n"); 
		query.append(" 	    		,TO_CHAR(so.aval_dt,'yyyy-mm-dd') as available_date" ).append("\n"); 
		query.append("   		  		,TO_CHAR(so.lst_free_dt,'yyyy-mm-dd') as last_free_date" ).append("\n"); 
		query.append("     			,hd.cstms_clr_no as cs_clear_no" ).append("\n"); 
		query.append("     			,TO_CHAR(tmp.n1st_nod_pln_dt,'YYYY-MM-DD HH24:MI') as expected_departure_time" ).append("\n"); 
		query.append("     			,TO_CHAR(tmp.lst_nod_pln_dt,'YYYY-MM-DD HH24:MI') as expected_arrival_time" ).append("\n"); 
		query.append("     			,TO_CHAR(tmp.dor_nod_pln_dt,'YYYY-MM-DD HH24:MI') as door_arrival_appointment_time" ).append("\n"); 
		query.append("    	 		,so.lst_loc_cd as usa_last_city" ).append("\n"); 
		query.append("--    	 		,nvl(trs_get_blck_stwg_cd_fnc(so.bkg_no), '   ')	as blck_stwg" ).append("\n"); 
		query.append("                ,nvl((select bkg.blck_stwg_cd from bkg_booking bkg where bkg.bkg_no = so.bkg_no), '   ') as blck_stwg" ).append("\n"); 
		query.append("     			,loc3.loc_nm||'('||so.del_cd||')' as del_cd" ).append("\n"); 
		query.append("     			,tmp.spcl_instr_rmk as remark" ).append("\n"); 
		query.append("     			,tmp.wo_cxl_flg as wo_cxl_flg" ).append("\n"); 
		query.append("  	   			,bkg_cntr.cntr_seal_no as seal_no" ).append("\n"); 
		query.append("    	 		,DECODE(tmp.dtn_use_flg, 'Y','Detain', '') as detain" ).append("\n"); 
		query.append("     			,so.mlt_stop_de_flg as mlt_stop_de_flg" ).append("\n"); 
		query.append("   		  		,DECODE(tmp.wo_bl_no_iss_flg, 'Y','B-No Issue', '') as bnum                               " ).append("\n"); 
		query.append("     			,so.bkg_no as bkg_no                             " ).append("\n"); 
		query.append("     			,hd.trsp_rqst_ord_seq as trsp_rqst_ord_seq                  " ).append("\n"); 
		query.append("     			,so.tro_lod_ref_no as tro_lod_ref_no                     " ).append("\n"); 
		query.append("     			,rownum as cntr_seq " ).append("\n"); 
		query.append("     		FROM trs_trsp_wrk_ord_prv_tmp tmp" ).append("\n"); 
		query.append("     			,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("     			,mdm_commodity cmdt" ).append("\n"); 
		query.append("     			,edi_usa_ib_cgo_rlse us_cgo_rlse                           " ).append("\n"); 
		query.append("     			,bkg_bkg_cntr bkg_cntr" ).append("\n"); 
		query.append("     			,bkg_bkg_cust bkg_cust" ).append("\n"); 
		query.append("     			,mdm_customer cust" ).append("\n"); 
		query.append("     			,mdm_cust_cntc_pnt cust_cntc" ).append("\n"); 
		query.append("     			,mdm_cntr_tp_sz tpsz" ).append("\n"); 
		query.append("     			,mdm_vsl_cntr vsl" ).append("\n"); 
		query.append("     			,mdm_location loc1" ).append("\n"); 
		query.append("     			,mdm_location loc2" ).append("\n"); 
		query.append("     			,mdm_location loc3" ).append("\n"); 
		query.append("	     	    ,trs_trsp_rqst_ord_hd hd" ).append("\n"); 
		query.append("	       WHERE tmp.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("   		  	 AND tmp.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("     		 AND tmp.trsp_so_ofc_cty_cd = so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("     		 AND tmp.trsp_so_seq = so.trsp_so_seq" ).append("\n"); 
		query.append("     		 AND so.cmdt_cd = cmdt.cmdt_cd(+)" ).append("\n"); 
		query.append("     		 AND so.bkg_no = bkg_cntr.bkg_no(+)" ).append("\n"); 
		query.append("     		 AND so.eq_no = bkg_cntr.cntr_no(+)" ).append("\n"); 
		query.append("     		 AND so.bl_no = us_cgo_rlse.bl_no(+)" ).append("\n"); 
		query.append("     		 AND so.bkg_no = bkg_cust.bkg_no(+)" ).append("\n"); 
		query.append("     		 AND bkg_cust.bkg_cust_tp_cd(+)= DECODE(SO.TRSP_BND_CD,'I','C','S')" ).append("\n"); 
		query.append("     		 AND bkg_cust.cust_cnt_cd = cust.cust_cnt_cd(+)" ).append("\n"); 
		query.append("     		 AND bkg_cust.cust_seq = cust.cust_seq(+)" ).append("\n"); 
		query.append("     		 AND cust.cust_cnt_cd = cust_cntc.cust_cnt_cd(+)" ).append("\n"); 
		query.append("     		 AND cust.cust_seq = cust_cntc.cust_seq(+)" ).append("\n"); 
		query.append("     		 AND NVL(cust.nmd_cust_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("     		 AND cust_cntc.cust_cntc_pnt_seq(+)= 1" ).append("\n"); 
		query.append("     		 AND so.trsp_nxt_port_cd = loc1.loc_cd (+)" ).append("\n"); 
		query.append("     		 AND so.pod_cd = loc2.loc_cd(+)" ).append("\n"); 
		query.append("     		 AND so.del_cd = loc3.loc_cd(+)" ).append("\n"); 
		query.append("     		 AND so.vsl_cd = vsl.vsl_cd(+)" ).append("\n"); 
		query.append("     		 AND so.bkg_no = hd.bkg_no(+)" ).append("\n"); 
		query.append("    	 	 AND so.trsp_bnd_cd = hd.trsp_rqst_ord_bnd_cd(+)" ).append("\n"); 
		query.append("    	 	 AND TO_NUMBER(SUBSTR(so.bkg_tro_no,3,LENGTH(so.bkg_tro_no)-4) )= hd.trsp_rqst_ord_seq(+)" ).append("\n"); 
		query.append("     		 AND eq_tpsz_cd = tpsz.cntr_tpsz_cd(+)" ).append("\n"); 
		query.append("    		 AND so.hjl_no IS NULL) cntr" ).append("\n"); 
		query.append(" 		  ,trs_trsp_rqst_ord_addr  multi" ).append("\n"); 
		query.append("  	 WHERE cntr.bkg_no = multi.bkg_no(+)" ).append("\n"); 
		query.append("       AND cntr.trsp_rqst_ord_seq = multi.trsp_rqst_ord_seq(+)          " ).append("\n"); 
		query.append("  GROUP BY cntr_seq" ).append("\n"); 
		query.append(" 		  ,equipment_number                                                                  " ).append("\n"); 
		query.append("		  ,type_size                                                                         " ).append("\n"); 
		query.append("		  ,rate                                                                              " ).append("\n"); 
		query.append("		  ,special_cargo                                                                     " ).append("\n"); 
		query.append("		  ,weight                                                                            " ).append("\n"); 
		query.append("		  ,commodity_description                                                             " ).append("\n"); 
		query.append("		  ,inbond_transit_number                                                             " ).append("\n"); 
		query.append("		  ,purchase_order_no                                                                 " ).append("\n"); 
		query.append("		  ,booking_number                                                                    " ).append("\n"); 
		query.append("		  ,bl_no                                                                             " ).append("\n"); 
		query.append("		  ,vessel                                                                            " ).append("\n"); 
		query.append("		  ,next_port                                                                         " ).append("\n"); 
		query.append("		  ,shipper_name                                                                      " ).append("\n"); 
		query.append("		  ,shipper_telephone_number                                                          " ).append("\n"); 
		query.append("		  ,door_service_type                                                                 " ).append("\n"); 
		query.append("		  ,pickup_no                                                                         " ).append("\n"); 
		query.append("		  ,available_date                                                                    " ).append("\n"); 
		query.append("		  ,last_free_date                                                                    " ).append("\n"); 
		query.append("		  ,cs_clear_no                                                                       " ).append("\n"); 
		query.append("		  ,expected_departure_time                                                           " ).append("\n"); 
		query.append("		  ,expected_arrival_time                                                             " ).append("\n"); 
		query.append("		  ,door_arrival_appointment_time                                                     " ).append("\n"); 
		query.append("		  ,usa_last_city                                                                     " ).append("\n"); 
		query.append("		  ,blck_stwg                                                                         " ).append("\n"); 
		query.append("		  ,del_cd                                                                            " ).append("\n"); 
		query.append("		  ,remark                                                                            " ).append("\n"); 
		query.append("		  ,wo_cxl_flg                                                                        " ).append("\n"); 
		query.append("		  ,seal_no                                                                           " ).append("\n"); 
		query.append("		  ,detain                                                                            " ).append("\n"); 
		query.append("		  ,mlt_stop_de_flg                                                                   " ).append("\n"); 
		query.append("		  ,bnum                                                                              " ).append("\n"); 
		query.append("		  ,tro_lod_ref_no                                                                    " ).append("\n"); 
		query.append("  ORDER BY cntr_seq" ).append("\n"); 

	}
}