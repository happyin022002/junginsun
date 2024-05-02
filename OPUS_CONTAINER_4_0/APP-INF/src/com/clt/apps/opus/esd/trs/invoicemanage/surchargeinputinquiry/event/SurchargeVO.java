/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SurchargeVO.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-14
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-03-14 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - 모든 업무에서 공통으로 사용하는 PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author poong_yeon
 * @see OtherSOManageBCImpl 참조
 * @since J2EE 1.4
 */
public final class SurchargeVO implements java.io.Serializable {

	private String                      ibflag                      = "";
	private String                      page_rows                   = "";
	private String                      trsp_so_ofc_cty_cd          = "";
	private String                      trsp_so_seq                 = "";
	private String                      lgs_cost_cd                 = "";
	private String                      unique_cd                   = "";
	private String                      scg_amt                     = "";
	private String                      chss_mgst_tpsz_cd           = "";
	private String                      dry_run_rlbl_pty_tp_cd      = "";
	private String                      fne_cuz_desc                = "";
	private String                      fumg_cost_tp_cd             = "";
	private String                      mgst_tpsz_cd                = "";
	private String                      insp_rf_pti_cstms_tp_cd     = "";
	private String                      lftg_knt                    = "";
	private String                      lftg_cuz_desc               = "";
	private String                      stop_loc_nod_cd             = "";
	private String                      grs_wgt                     = "";
	private String                      incrt_dt                    = "";
	private String                      scl_stop_plc_nod_cd         = "";
	private String                      sto_dys                     = "";
	private String                      ob_bkg_no                   = "";
	private String                      ob_bkg_no_split             = "";
	private String                      wt_hrs                      = "";
	private String                      otr_rmk                     = "";
	private String                      inv_scg_amt                 = "";
	private String                      inv_chss_mgst_tpsz_cd       = "";
	private String                      inv_dry_run_rlbl_pty_tp_cd  = "";
	private String                      inv_fne_cuz_desc            = "";
	private String                      inv_fumg_cost_tp_cd         = "";
	private String                      inv_mgst_tpsz_cd            = "";
	private String                      inv_insp_rf_pti_cstms_tp_cd = "";
	private String                      inv_lftg_knt                = "";
	private String                      inv_lftg_cuz_desc           = "";
	private String                      inv_stop_loc_nod_cd         = "";
	private String                      inv_grs_wgt                 = "";
	private String                      inv_incrt_dt                = "";
	private String                      inv_scl_stop_plc_nod_cd     = "";
	private String                      inv_sto_dys                 = "";
	private String                      inv_ob_bkg_no               = "";
	private String                      inv_ob_bkg_no_split         = "";
	private String                      inv_wt_hrs                  = "";
	private String                      inv_otr_rmk                 = "";
	private String                      n3pty_bil_flg               = "";
	private String                      cust_cnt_cd                 = "";
	private String                      cust_seq                    = "";
	private String                      n3pty_vndr_seq              = "";
	private String                      n3pty_ofc_cd                = "";
	private String                      n3pty_amt                   = "";
	private String                      n3pty_desc                  = "";
	private String                      cre_ofc_cd                  = "";
	private String                      cre_usr_id                  = "";
	private String                      cre_dt                      = "";
	private String                      upd_usr_id                  = "";
	private String                      upd_dt                      = "";

	public SurchargeVO(){}

	public SurchargeVO(
			String                      ibflag                     ,
			String                      page_rows                  ,
			String                      trsp_so_ofc_cty_cd         ,
			String                      trsp_so_seq                ,
			String                      lgs_cost_cd                ,
			String                      unique_cd                  ,
			String                      scg_amt                    ,
			String                      chss_mgst_tpsz_cd          ,
			String                      dry_run_rlbl_pty_tp_cd     ,
			String                      fne_cuz_desc               ,
			String                      fumg_cost_tp_cd            ,
			String                      mgst_tpsz_cd               ,
			String                      insp_rf_pti_cstms_tp_cd    ,
			String                      lftg_knt                   ,
			String                      lftg_cuz_desc              ,
			String                      stop_loc_nod_cd            ,
			String                      grs_wgt                    ,
			String                      incrt_dt                   ,
			String                      scl_stop_plc_nod_cd        ,
			String                      sto_dys                    ,
			String                      ob_bkg_no                  ,
			String                      ob_bkg_no_split            ,
			String                      wt_hrs                     ,
			String                      otr_rmk                    ,
			String                      inv_scg_amt                ,
			String                      inv_chss_mgst_tpsz_cd      ,
			String                      inv_dry_run_rlbl_pty_tp_cd ,
			String                      inv_fne_cuz_desc           ,
			String                      inv_fumg_cost_tp_cd        ,
			String                      inv_mgst_tpsz_cd           ,
			String                      inv_insp_rf_pti_cstms_tp_cd,
			String                      inv_lftg_knt               ,
			String                      inv_lftg_cuz_desc          ,
			String                      inv_stop_loc_nod_cd        ,
			String                      inv_grs_wgt                ,
			String                      inv_incrt_dt               ,
			String                      inv_scl_stop_plc_nod_cd    ,
			String                      inv_sto_dys                ,
			String                      inv_ob_bkg_no              ,
			String                      inv_ob_bkg_no_split        ,
			String                      inv_wt_hrs                 ,
			String                      inv_otr_rmk                ,
			String                      n3pty_bil_flg              ,
			String                      cust_cnt_cd                ,
			String                      cust_seq                   ,
			String                      n3pty_vndr_seq             ,
			String                      n3pty_ofc_cd               ,
			String                      n3pty_amt                  ,
			String                      n3pty_desc                 ,
			String                      cre_ofc_cd                 ,
			String                      cre_usr_id                 ,
			String                      cre_dt                     ,
			String                      upd_usr_id                 ,
			String                      upd_dt                     ){
		this.ibflag                      = ibflag                     ;
		this.page_rows                   = page_rows                  ;
		this.trsp_so_ofc_cty_cd          = trsp_so_ofc_cty_cd         ;
		this.trsp_so_seq                 = trsp_so_seq                ;
		this.lgs_cost_cd                 = lgs_cost_cd                ;
		this.unique_cd                   = unique_cd                  ;
		this.scg_amt                     = scg_amt                    ;
		this.chss_mgst_tpsz_cd           = chss_mgst_tpsz_cd          ;
		this.dry_run_rlbl_pty_tp_cd      = dry_run_rlbl_pty_tp_cd     ;
		this.fne_cuz_desc                = fne_cuz_desc               ;
		this.fumg_cost_tp_cd             = fumg_cost_tp_cd            ;
		this.mgst_tpsz_cd                = mgst_tpsz_cd               ;
		this.insp_rf_pti_cstms_tp_cd     = insp_rf_pti_cstms_tp_cd    ;
		this.lftg_knt                    = lftg_knt                   ;
		this.lftg_cuz_desc               = lftg_cuz_desc              ;
		this.stop_loc_nod_cd             = stop_loc_nod_cd            ;
		this.grs_wgt                     = grs_wgt                    ;
		this.incrt_dt                    = incrt_dt                   ;
		this.scl_stop_plc_nod_cd         = scl_stop_plc_nod_cd        ;
		this.sto_dys                     = sto_dys                    ;
		this.ob_bkg_no                   = ob_bkg_no                  ;
		this.ob_bkg_no_split             = ob_bkg_no_split            ;
		this.wt_hrs                      = wt_hrs                     ;
		this.otr_rmk                     = otr_rmk                    ;
		this.inv_scg_amt                 = inv_scg_amt                ;
		this.inv_chss_mgst_tpsz_cd       = inv_chss_mgst_tpsz_cd      ;
		this.inv_dry_run_rlbl_pty_tp_cd  = inv_dry_run_rlbl_pty_tp_cd ;
		this.inv_fne_cuz_desc            = inv_fne_cuz_desc           ;
		this.inv_fumg_cost_tp_cd         = inv_fumg_cost_tp_cd        ;
		this.inv_mgst_tpsz_cd            = inv_mgst_tpsz_cd           ;
		this.inv_insp_rf_pti_cstms_tp_cd = inv_insp_rf_pti_cstms_tp_cd;
		this.inv_lftg_knt                = inv_lftg_knt               ;
		this.inv_lftg_cuz_desc           = inv_lftg_cuz_desc          ;
		this.inv_stop_loc_nod_cd         = inv_stop_loc_nod_cd        ;
		this.inv_grs_wgt                 = inv_grs_wgt                ;
		this.inv_incrt_dt                = inv_incrt_dt               ;
		this.inv_scl_stop_plc_nod_cd     = inv_scl_stop_plc_nod_cd    ;
		this.inv_sto_dys                 = inv_sto_dys                ;
		this.inv_ob_bkg_no               = inv_ob_bkg_no              ;
		this.inv_ob_bkg_no_split         = inv_ob_bkg_no_split        ;
		this.inv_wt_hrs                  = inv_wt_hrs                 ;
		this.inv_otr_rmk                 = inv_otr_rmk                ;
		this.n3pty_bil_flg               = n3pty_bil_flg              ;
		this.cust_cnt_cd                 = cust_cnt_cd                ;
		this.cust_seq                    = cust_seq                   ;
		this.n3pty_vndr_seq              = n3pty_vndr_seq             ;
		this.n3pty_ofc_cd                = n3pty_ofc_cd               ;
		this.n3pty_amt                   = n3pty_amt                  ;
		this.n3pty_desc                  = n3pty_desc                 ;
		this.cre_ofc_cd                  = cre_ofc_cd                 ;
		this.cre_usr_id                  = cre_usr_id                 ;
		this.cre_dt                      = cre_dt                     ;
		this.upd_usr_id                  = upd_usr_id                 ;
		this.upd_dt                      = upd_dt                     ;
	}

	// getter method is proceeding ..
	public String                      getIbflag                     (){	return ibflag                     	;	}
	public String                      getPage_rows                  (){	return page_rows                  	;	}
	public String                      getTrsp_so_ofc_cty_cd         (){	return trsp_so_ofc_cty_cd         	;	}
	public String                      getTrsp_so_seq                (){	return trsp_so_seq                	;	}
	public String                      getLgs_cost_cd                (){	return lgs_cost_cd                	;	}
	public String                      getUnique_cd                  (){	return unique_cd                  	;	}
	public String                      getScg_amt                    (){	return scg_amt                    	;	}
	public String                      getChss_mgst_tpsz_cd          (){	return chss_mgst_tpsz_cd          	;	}
	public String                      getDry_run_rlbl_pty_tp_cd     (){	return dry_run_rlbl_pty_tp_cd     	;	}
	public String                      getFne_cuz_desc               (){	return fne_cuz_desc               	;	}
	public String                      getFumg_cost_tp_cd            (){	return fumg_cost_tp_cd            	;	}
	public String                      getMgst_tpsz_cd               (){	return mgst_tpsz_cd               	;	}
	public String                      getInsp_rf_pti_cstms_tp_cd    (){	return insp_rf_pti_cstms_tp_cd    	;	}
	public String                      getLftg_knt                   (){	return lftg_knt                   	;	}
	public String                      getLftg_cuz_desc              (){	return lftg_cuz_desc              	;	}
	public String                      getStop_loc_nod_cd            (){	return stop_loc_nod_cd            	;	}
	public String                      getGrs_wgt                    (){	return grs_wgt                    	;	}
	public String                      getIncrt_dt                   (){	return incrt_dt                   	;	}
	public String                      getScl_stop_plc_nod_cd        (){	return scl_stop_plc_nod_cd        	;	}
	public String                      getSto_dys                    (){	return sto_dys                    	;	}
	public String                      getOb_bkg_no                  (){	return ob_bkg_no                  	;	}
	public String                      getOb_bkg_no_split            (){	return ob_bkg_no_split            	;	}
	public String                      getWt_hrs                     (){	return wt_hrs                     	;	}
	public String                      getOtr_rmk                    (){	return otr_rmk                    	;	}
	public String                      getInv_scg_amt                (){	return inv_scg_amt                	;	}
	public String                      getInv_chss_mgst_tpsz_cd      (){	return inv_chss_mgst_tpsz_cd      	;	}
	public String                      getInv_dry_run_rlbl_pty_tp_cd (){	return inv_dry_run_rlbl_pty_tp_cd 	;	}
	public String                      getInv_fne_cuz_desc           (){	return inv_fne_cuz_desc           	;	}
	public String                      getInv_fumg_cost_tp_cd        (){	return inv_fumg_cost_tp_cd        	;	}
	public String                      getInv_mgst_tpsz_cd           (){	return inv_mgst_tpsz_cd           	;	}
	public String                      getInv_insp_rf_pti_cstms_tp_cd(){	return inv_insp_rf_pti_cstms_tp_cd	;	}
	public String                      getInv_lftg_knt               (){	return inv_lftg_knt               	;	}
	public String                      getInv_lftg_cuz_desc          (){	return inv_lftg_cuz_desc          	;	}
	public String                      getInv_stop_loc_nod_cd        (){	return inv_stop_loc_nod_cd        	;	}
	public String                      getInv_grs_wgt                (){	return inv_grs_wgt                	;	}
	public String                      getInv_incrt_dt               (){	return inv_incrt_dt               	;	}
	public String                      getInv_scl_stop_plc_nod_cd    (){	return inv_scl_stop_plc_nod_cd    	;	}
	public String                      getInv_sto_dys                (){	return inv_sto_dys                	;	}
	public String                      getInv_ob_bkg_no              (){	return inv_ob_bkg_no              	;	}
	public String                      getInv_ob_bkg_no_split        (){	return inv_ob_bkg_no_split        	;	}
	public String                      getInv_wt_hrs                 (){	return inv_wt_hrs                 	;	}
	public String                      getInv_otr_rmk                (){	return inv_otr_rmk                	;	}
	public String                      getN3pty_bil_flg              (){	return n3pty_bil_flg              	;	}
	public String                      getCust_cnt_cd                (){	return cust_cnt_cd                	;	}
	public String                      getCust_seq                   (){	return cust_seq                   	;	}
	public String                      getN3pty_vndr_seq             (){	return n3pty_vndr_seq             	;	}
	public String                      getN3pty_ofc_cd               (){	return n3pty_ofc_cd               	;	}
	public String                      getN3pty_amt                  (){	return n3pty_amt                  	;	}
	public String                      getN3pty_desc                 (){	return n3pty_desc                 	;	}
	public String                      getCre_ofc_cd                 (){	return cre_ofc_cd                 	;	}
	public String                      getCre_usr_id                 (){	return cre_usr_id                 	;	}
	public String                      getCre_dt                     (){	return cre_dt                     	;	}
	public String                      getUpd_usr_id                 (){	return upd_usr_id                 	;	}
	public String                      getUpd_dt                     (){	return upd_dt                     	;	}

	// setter method is proceeding ..
	public void setIbflag                     ( String                      ibflag                      ){	this.ibflag                      = ibflag                     	;	}
	public void setPage_rows                  ( String                      page_rows                   ){	this.page_rows                   = page_rows                  	;	}
	public void setTrsp_so_ofc_cty_cd         ( String                      trsp_so_ofc_cty_cd          ){	this.trsp_so_ofc_cty_cd          = trsp_so_ofc_cty_cd         	;	}
	public void setTrsp_so_seq                ( String                      trsp_so_seq                 ){	this.trsp_so_seq                 = trsp_so_seq                	;	}
	public void setLgs_cost_cd                ( String                      lgs_cost_cd                 ){	this.lgs_cost_cd                 = lgs_cost_cd                	;	}
	public void setUnique_cd                  ( String                      unique_cd                   ){	this.unique_cd                   = unique_cd                  	;	}
	public void setScg_amt                    ( String                      scg_amt                     ){	this.scg_amt                     = scg_amt                    	;	}
	public void setChss_mgst_tpsz_cd          ( String                      chss_mgst_tpsz_cd           ){	this.chss_mgst_tpsz_cd           = chss_mgst_tpsz_cd          	;	}
	public void setDry_run_rlbl_pty_tp_cd     ( String                      dry_run_rlbl_pty_tp_cd      ){	this.dry_run_rlbl_pty_tp_cd      = dry_run_rlbl_pty_tp_cd     	;	}
	public void setFne_cuz_desc               ( String                      fne_cuz_desc                ){	this.fne_cuz_desc                = fne_cuz_desc               	;	}
	public void setFumg_cost_tp_cd            ( String                      fumg_cost_tp_cd             ){	this.fumg_cost_tp_cd             = fumg_cost_tp_cd            	;	}
	public void setMgst_tpsz_cd               ( String                      mgst_tpsz_cd                ){	this.mgst_tpsz_cd                = mgst_tpsz_cd               	;	}
	public void setInsp_rf_pti_cstms_tp_cd    ( String                      insp_rf_pti_cstms_tp_cd     ){	this.insp_rf_pti_cstms_tp_cd     = insp_rf_pti_cstms_tp_cd    	;	}
	public void setLftg_knt                   ( String                      lftg_knt                    ){	this.lftg_knt                    = lftg_knt                   	;	}
	public void setLftg_cuz_desc              ( String                      lftg_cuz_desc               ){	this.lftg_cuz_desc               = lftg_cuz_desc              	;	}
	public void setStop_loc_nod_cd            ( String                      stop_loc_nod_cd             ){	this.stop_loc_nod_cd             = stop_loc_nod_cd            	;	}
	public void setGrs_wgt                    ( String                      grs_wgt                     ){	this.grs_wgt                     = grs_wgt                    	;	}
	public void setIncrt_dt                   ( String                      incrt_dt                    ){	this.incrt_dt                    = incrt_dt                   	;	}
	public void setScl_stop_plc_nod_cd        ( String                      scl_stop_plc_nod_cd         ){	this.scl_stop_plc_nod_cd         = scl_stop_plc_nod_cd        	;	}
	public void setSto_dys                    ( String                      sto_dys                     ){	this.sto_dys                     = sto_dys                    	;	}
	public void setOb_bkg_no                  ( String                      ob_bkg_no                   ){	this.ob_bkg_no                   = ob_bkg_no                  	;	}
	public void setOb_bkg_no_split            ( String                      ob_bkg_no_split             ){	this.ob_bkg_no_split             = ob_bkg_no_split            	;	}
	public void setWt_hrs                     ( String                      wt_hrs                      ){	this.wt_hrs                      = wt_hrs                     	;	}
	public void setOtr_rmk                    ( String                      otr_rmk                     ){	this.otr_rmk                     = otr_rmk                    	;	}
	public void setInv_scg_amt                ( String                      inv_scg_amt                 ){	this.inv_scg_amt                 = inv_scg_amt                	;	}
	public void setInv_chss_mgst_tpsz_cd      ( String                      inv_chss_mgst_tpsz_cd       ){	this.inv_chss_mgst_tpsz_cd       = inv_chss_mgst_tpsz_cd      	;	}
	public void setInv_dry_run_rlbl_pty_tp_cd ( String                      inv_dry_run_rlbl_pty_tp_cd  ){	this.inv_dry_run_rlbl_pty_tp_cd  = inv_dry_run_rlbl_pty_tp_cd 	;	}
	public void setInv_fne_cuz_desc           ( String                      inv_fne_cuz_desc            ){	this.inv_fne_cuz_desc            = inv_fne_cuz_desc           	;	}
	public void setInv_fumg_cost_tp_cd        ( String                      inv_fumg_cost_tp_cd         ){	this.inv_fumg_cost_tp_cd         = inv_fumg_cost_tp_cd        	;	}
	public void setInv_mgst_tpsz_cd           ( String                      inv_mgst_tpsz_cd            ){	this.inv_mgst_tpsz_cd            = inv_mgst_tpsz_cd           	;	}
	public void setInv_insp_rf_pti_cstms_tp_cd( String                      inv_insp_rf_pti_cstms_tp_cd ){	this.inv_insp_rf_pti_cstms_tp_cd = inv_insp_rf_pti_cstms_tp_cd	;	}
	public void setInv_lftg_knt               ( String                      inv_lftg_knt                ){	this.inv_lftg_knt                = inv_lftg_knt               	;	}
	public void setInv_lftg_cuz_desc          ( String                      inv_lftg_cuz_desc           ){	this.inv_lftg_cuz_desc           = inv_lftg_cuz_desc          	;	}
	public void setInv_stop_loc_nod_cd        ( String                      inv_stop_loc_nod_cd         ){	this.inv_stop_loc_nod_cd         = inv_stop_loc_nod_cd        	;	}
	public void setInv_grs_wgt                ( String                      inv_grs_wgt                 ){	this.inv_grs_wgt                 = inv_grs_wgt                	;	}
	public void setInv_incrt_dt               ( String                      inv_incrt_dt                ){	this.inv_incrt_dt                = inv_incrt_dt               	;	}
	public void setInv_scl_stop_plc_nod_cd    ( String                      inv_scl_stop_plc_nod_cd     ){	this.inv_scl_stop_plc_nod_cd     = inv_scl_stop_plc_nod_cd    	;	}
	public void setInv_sto_dys                ( String                      inv_sto_dys                 ){	this.inv_sto_dys                 = inv_sto_dys                	;	}
	public void setInv_ob_bkg_no              ( String                      inv_ob_bkg_no               ){	this.inv_ob_bkg_no               = inv_ob_bkg_no              	;	}
	public void setInv_ob_bkg_no_split        ( String                      inv_ob_bkg_no_split         ){	this.inv_ob_bkg_no_split         = inv_ob_bkg_no_split        	;	}
	public void setInv_wt_hrs                 ( String                      inv_wt_hrs                  ){	this.inv_wt_hrs                  = inv_wt_hrs                 	;	}
	public void setInv_otr_rmk                ( String                      inv_otr_rmk                 ){	this.inv_otr_rmk                 = inv_otr_rmk                	;	}
	public void setN3pty_bil_flg              ( String                      n3pty_bil_flg               ){	this.n3pty_bil_flg               = n3pty_bil_flg              	;	}
	public void setCust_cnt_cd                ( String                      cust_cnt_cd                 ){	this.cust_cnt_cd                 = cust_cnt_cd                	;	}
	public void setCust_seq                   ( String                      cust_seq                    ){	this.cust_seq                    = cust_seq                   	;	}
	public void setN3pty_vndr_seq             ( String                      n3pty_vndr_seq              ){	this.n3pty_vndr_seq              = n3pty_vndr_seq             	;	}
	public void setN3pty_ofc_cd               ( String                      n3pty_ofc_cd                ){	this.n3pty_ofc_cd                = n3pty_ofc_cd               	;	}
	public void setN3pty_amt                  ( String                      n3pty_amt                   ){	this.n3pty_amt                   = n3pty_amt                  	;	}
	public void setN3pty_desc                 ( String                      n3pty_desc                  ){	this.n3pty_desc                  = n3pty_desc                 	;	}
	public void setCre_ofc_cd                 ( String                      cre_ofc_cd                  ){	this.cre_ofc_cd                  = cre_ofc_cd                 	;	}
	public void setCre_usr_id                 ( String                      cre_usr_id                  ){	this.cre_usr_id                  = cre_usr_id                 	;	}
	public void setCre_dt                     ( String                      cre_dt                      ){	this.cre_dt                      = cre_dt                     	;	}
	public void setUpd_usr_id                 ( String                      upd_usr_id                  ){	this.upd_usr_id                  = upd_usr_id                 	;	}
	public void setUpd_dt                     ( String                      upd_dt                      ){	this.upd_dt                      = upd_dt                     	;	}

	public static SurchargeVO fromRequest(HttpServletRequest request) {
		SurchargeVO model = new SurchargeVO();
			model.setIbflag                     	(JSPUtil.getParameter(request, "ibflag                     		".trim(), ""));
			model.setPage_rows                  	(JSPUtil.getParameter(request, "page_rows                  		".trim(), ""));
			model.setTrsp_so_ofc_cty_cd         	(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd         		".trim(), ""));
			model.setTrsp_so_seq                	(JSPUtil.getParameter(request, "trsp_so_seq                		".trim(), ""));
			model.setLgs_cost_cd                	(JSPUtil.getParameter(request, "lgs_cost_cd                		".trim(), ""));
			model.setUnique_cd                  	(JSPUtil.getParameter(request, "unique_cd                  		".trim(), ""));
			model.setScg_amt                    	(JSPUtil.getParameter(request, "scg_amt                    		".trim(), ""));
			model.setChss_mgst_tpsz_cd          	(JSPUtil.getParameter(request, "chss_mgst_tpsz_cd          		".trim(), ""));
			model.setDry_run_rlbl_pty_tp_cd     	(JSPUtil.getParameter(request, "dry_run_rlbl_pty_tp_cd     		".trim(), ""));
			model.setFne_cuz_desc               	(JSPUtil.getParameter(request, "fne_cuz_desc               		".trim(), ""));
			model.setFumg_cost_tp_cd            	(JSPUtil.getParameter(request, "fumg_cost_tp_cd            		".trim(), ""));
			model.setMgst_tpsz_cd               	(JSPUtil.getParameter(request, "mgst_tpsz_cd               		".trim(), ""));
			model.setInsp_rf_pti_cstms_tp_cd    	(JSPUtil.getParameter(request, "insp_rf_pti_cstms_tp_cd    		".trim(), ""));
			model.setLftg_knt                   	(JSPUtil.getParameter(request, "lftg_knt                   		".trim(), ""));
			model.setLftg_cuz_desc              	(JSPUtil.getParameter(request, "lftg_cuz_desc              		".trim(), ""));
			model.setStop_loc_nod_cd            	(JSPUtil.getParameter(request, "stop_loc_nod_cd            		".trim(), ""));
			model.setGrs_wgt                    	(JSPUtil.getParameter(request, "grs_wgt                    		".trim(), ""));
			model.setIncrt_dt                   	(JSPUtil.getParameter(request, "incrt_dt                   		".trim(), ""));
			model.setScl_stop_plc_nod_cd        	(JSPUtil.getParameter(request, "scl_stop_plc_nod_cd        		".trim(), ""));
			model.setSto_dys                    	(JSPUtil.getParameter(request, "sto_dys                    		".trim(), ""));
			model.setOb_bkg_no                  	(JSPUtil.getParameter(request, "ob_bkg_no                  		".trim(), ""));
			model.setOb_bkg_no_split            	(JSPUtil.getParameter(request, "ob_bkg_no_split            		".trim(), ""));
			model.setWt_hrs                     	(JSPUtil.getParameter(request, "wt_hrs                     		".trim(), ""));
			model.setOtr_rmk                    	(JSPUtil.getParameter(request, "otr_rmk                    		".trim(), ""));
			model.setInv_scg_amt                	(JSPUtil.getParameter(request, "inv_scg_amt                		".trim(), ""));
			model.setInv_chss_mgst_tpsz_cd      	(JSPUtil.getParameter(request, "inv_chss_mgst_tpsz_cd      		".trim(), ""));
			model.setInv_dry_run_rlbl_pty_tp_cd 	(JSPUtil.getParameter(request, "inv_dry_run_rlbl_pty_tp_cd 		".trim(), ""));
			model.setInv_fne_cuz_desc           	(JSPUtil.getParameter(request, "inv_fne_cuz_desc           		".trim(), ""));
			model.setInv_fumg_cost_tp_cd        	(JSPUtil.getParameter(request, "inv_fumg_cost_tp_cd        		".trim(), ""));
			model.setInv_mgst_tpsz_cd           	(JSPUtil.getParameter(request, "inv_mgst_tpsz_cd           		".trim(), ""));
			model.setInv_insp_rf_pti_cstms_tp_cd	(JSPUtil.getParameter(request, "inv_insp_rf_pti_cstms_tp_cd		".trim(), ""));
			model.setInv_lftg_knt               	(JSPUtil.getParameter(request, "inv_lftg_knt               		".trim(), ""));
			model.setInv_lftg_cuz_desc          	(JSPUtil.getParameter(request, "inv_lftg_cuz_desc          		".trim(), ""));
			model.setInv_stop_loc_nod_cd        	(JSPUtil.getParameter(request, "inv_stop_loc_nod_cd        		".trim(), ""));
			model.setInv_grs_wgt                	(JSPUtil.getParameter(request, "inv_grs_wgt                		".trim(), ""));
			model.setInv_incrt_dt               	(JSPUtil.getParameter(request, "inv_incrt_dt               		".trim(), ""));
			model.setInv_scl_stop_plc_nod_cd    	(JSPUtil.getParameter(request, "inv_scl_stop_plc_nod_cd    		".trim(), ""));
			model.setInv_sto_dys                	(JSPUtil.getParameter(request, "inv_sto_dys                		".trim(), ""));
			model.setInv_ob_bkg_no              	(JSPUtil.getParameter(request, "inv_ob_bkg_no              		".trim(), ""));
			model.setInv_ob_bkg_no_split        	(JSPUtil.getParameter(request, "inv_ob_bkg_no_split        		".trim(), ""));
			model.setInv_wt_hrs                 	(JSPUtil.getParameter(request, "inv_wt_hrs                 		".trim(), ""));
			model.setInv_otr_rmk                	(JSPUtil.getParameter(request, "inv_otr_rmk                		".trim(), ""));
			model.setN3pty_bil_flg              	(JSPUtil.getParameter(request, "n3pty_bil_flg              		".trim(), ""));
			model.setCust_cnt_cd                	(JSPUtil.getParameter(request, "cust_cnt_cd                		".trim(), ""));
			model.setCust_seq                   	(JSPUtil.getParameter(request, "cust_seq                   		".trim(), ""));
			model.setN3pty_vndr_seq             	(JSPUtil.getParameter(request, "n3pty_vndr_seq             		".trim(), ""));
			model.setN3pty_ofc_cd               	(JSPUtil.getParameter(request, "n3pty_ofc_cd               		".trim(), ""));
			model.setN3pty_amt                  	(JSPUtil.getParameter(request, "n3pty_amt                  		".trim(), ""));
			model.setN3pty_desc                 	(JSPUtil.getParameter(request, "n3pty_desc                 		".trim(), ""));
			model.setCre_ofc_cd                 	(JSPUtil.getParameter(request, "cre_ofc_cd                 		".trim(), ""));
			model.setCre_usr_id                 	(JSPUtil.getParameter(request, "cre_usr_id                 		".trim(), ""));
			model.setCre_dt                     	(JSPUtil.getParameter(request, "cre_dt                     		".trim(), ""));
			model.setUpd_usr_id                 	(JSPUtil.getParameter(request, "upd_usr_id                 		".trim(), ""));
			model.setUpd_dt                     	(JSPUtil.getParameter(request, "upd_dt                     		".trim(), ""));
		return model;
	}
	public static Collection fromRequest(HttpServletRequest request, int length) {
		SurchargeVO model = null;
		Collection models = new ArrayList();
			String[] ibflag                      =  (JSPUtil.getParameter(request, "ibflag                     		".trim(), length));
			String[] page_rows                   =  (JSPUtil.getParameter(request, "page_rows                  		".trim(), length));
			String[] trsp_so_ofc_cty_cd          =  (JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd         		".trim(), length));
			String[] trsp_so_seq                 =  (JSPUtil.getParameter(request, "trsp_so_seq                		".trim(), length));
			String[] lgs_cost_cd                 =  (JSPUtil.getParameter(request, "lgs_cost_cd                		".trim(), length));
			String[] unique_cd                   =  (JSPUtil.getParameter(request, "unique_cd                  		".trim(), length));
			String[] scg_amt                     =  (JSPUtil.getParameter(request, "scg_amt                    		".trim(), length));
			String[] chss_mgst_tpsz_cd           =  (JSPUtil.getParameter(request, "chss_mgst_tpsz_cd          		".trim(), length));
			String[] dry_run_rlbl_pty_tp_cd      =  (JSPUtil.getParameter(request, "dry_run_rlbl_pty_tp_cd     		".trim(), length));
			String[] fne_cuz_desc                =  (JSPUtil.getParameter(request, "fne_cuz_desc               		".trim(), length));
			String[] fumg_cost_tp_cd             =  (JSPUtil.getParameter(request, "fumg_cost_tp_cd            		".trim(), length));
			String[] mgst_tpsz_cd                =  (JSPUtil.getParameter(request, "mgst_tpsz_cd               		".trim(), length));
			String[] insp_rf_pti_cstms_tp_cd     =  (JSPUtil.getParameter(request, "insp_rf_pti_cstms_tp_cd    		".trim(), length));
			String[] lftg_knt                    =  (JSPUtil.getParameter(request, "lftg_knt                   		".trim(), length));
			String[] lftg_cuz_desc               =  (JSPUtil.getParameter(request, "lftg_cuz_desc              		".trim(), length));
			String[] stop_loc_nod_cd             =  (JSPUtil.getParameter(request, "stop_loc_nod_cd            		".trim(), length));
			String[] grs_wgt                     =  (JSPUtil.getParameter(request, "grs_wgt                    		".trim(), length));
			String[] incrt_dt                    =  (JSPUtil.getParameter(request, "incrt_dt                   		".trim(), length));
			String[] scl_stop_plc_nod_cd         =  (JSPUtil.getParameter(request, "scl_stop_plc_nod_cd        		".trim(), length));
			String[] sto_dys                     =  (JSPUtil.getParameter(request, "sto_dys                    		".trim(), length));
			String[] ob_bkg_no                   =  (JSPUtil.getParameter(request, "ob_bkg_no                  		".trim(), length));
			String[] ob_bkg_no_split             =  (JSPUtil.getParameter(request, "ob_bkg_no_split            		".trim(), length));
			String[] wt_hrs                      =  (JSPUtil.getParameter(request, "wt_hrs                     		".trim(), length));
			String[] otr_rmk                     =  (JSPUtil.getParameter(request, "otr_rmk                    		".trim(), length));
			String[] inv_scg_amt                 =  (JSPUtil.getParameter(request, "inv_scg_amt                		".trim(), length));
			String[] inv_chss_mgst_tpsz_cd       =  (JSPUtil.getParameter(request, "inv_chss_mgst_tpsz_cd      		".trim(), length));
			String[] inv_dry_run_rlbl_pty_tp_cd  =  (JSPUtil.getParameter(request, "inv_dry_run_rlbl_pty_tp_cd 		".trim(), length));
			String[] inv_fne_cuz_desc            =  (JSPUtil.getParameter(request, "inv_fne_cuz_desc           		".trim(), length));
			String[] inv_fumg_cost_tp_cd         =  (JSPUtil.getParameter(request, "inv_fumg_cost_tp_cd        		".trim(), length));
			String[] inv_mgst_tpsz_cd            =  (JSPUtil.getParameter(request, "inv_mgst_tpsz_cd           		".trim(), length));
			String[] inv_insp_rf_pti_cstms_tp_cd =  (JSPUtil.getParameter(request, "inv_insp_rf_pti_cstms_tp_cd		".trim(), length));
			String[] inv_lftg_knt                =  (JSPUtil.getParameter(request, "inv_lftg_knt               		".trim(), length));
			String[] inv_lftg_cuz_desc           =  (JSPUtil.getParameter(request, "inv_lftg_cuz_desc          		".trim(), length));
			String[] inv_stop_loc_nod_cd         =  (JSPUtil.getParameter(request, "inv_stop_loc_nod_cd        		".trim(), length));
			String[] inv_grs_wgt                 =  (JSPUtil.getParameter(request, "inv_grs_wgt                		".trim(), length));
			String[] inv_incrt_dt                =  (JSPUtil.getParameter(request, "inv_incrt_dt               		".trim(), length));
			String[] inv_scl_stop_plc_nod_cd     =  (JSPUtil.getParameter(request, "inv_scl_stop_plc_nod_cd    		".trim(), length));
			String[] inv_sto_dys                 =  (JSPUtil.getParameter(request, "inv_sto_dys                		".trim(), length));
			String[] inv_ob_bkg_no               =  (JSPUtil.getParameter(request, "inv_ob_bkg_no              		".trim(), length));
			String[] inv_ob_bkg_no_split         =  (JSPUtil.getParameter(request, "inv_ob_bkg_no_split        		".trim(), length));
			String[] inv_wt_hrs                  =  (JSPUtil.getParameter(request, "inv_wt_hrs                 		".trim(), length));
			String[] inv_otr_rmk                 =  (JSPUtil.getParameter(request, "inv_otr_rmk                		".trim(), length));
			String[] n3pty_bil_flg               =  (JSPUtil.getParameter(request, "n3pty_bil_flg              		".trim(), length));
			String[] cust_cnt_cd                 =  (JSPUtil.getParameter(request, "cust_cnt_cd                		".trim(), length));
			String[] cust_seq                    =  (JSPUtil.getParameter(request, "cust_seq                   		".trim(), length));
			String[] n3pty_vndr_seq              =  (JSPUtil.getParameter(request, "n3pty_vndr_seq             		".trim(), length));
			String[] n3pty_ofc_cd                =  (JSPUtil.getParameter(request, "n3pty_ofc_cd               		".trim(), length));
			String[] n3pty_amt                   =  (JSPUtil.getParameter(request, "n3pty_amt                  		".trim(), length));
			String[] n3pty_desc                  =  (JSPUtil.getParameter(request, "n3pty_desc                 		".trim(), length));
			String[] cre_ofc_cd                  =  (JSPUtil.getParameter(request, "cre_ofc_cd                 		".trim(), length));
			String[] cre_usr_id                  =  (JSPUtil.getParameter(request, "cre_usr_id                 		".trim(), length));
			String[] cre_dt                      =  (JSPUtil.getParameter(request, "cre_dt                     		".trim(), length));
			String[] upd_usr_id                  =  (JSPUtil.getParameter(request, "upd_usr_id                 		".trim(), length));
			String[] upd_dt                      =  (JSPUtil.getParameter(request, "upd_dt                     		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new SurchargeVO();
				model.setIbflag                     		  (ibflag                     	[i]);
				model.setPage_rows                  		  (page_rows                  	[i]);
				model.setTrsp_so_ofc_cty_cd         		  (trsp_so_ofc_cty_cd         	[i]);
				model.setTrsp_so_seq                		  (trsp_so_seq                	[i]);
				model.setLgs_cost_cd                		  (lgs_cost_cd                	[i]);
				model.setUnique_cd                  		  (unique_cd                  	[i]);
				model.setScg_amt                    		  (scg_amt                    	[i]);
				model.setChss_mgst_tpsz_cd          		  (chss_mgst_tpsz_cd          	[i]);
				model.setDry_run_rlbl_pty_tp_cd     		  (dry_run_rlbl_pty_tp_cd     	[i]);
				model.setFne_cuz_desc               		  (fne_cuz_desc               	[i]);
				model.setFumg_cost_tp_cd            		  (fumg_cost_tp_cd            	[i]);
				model.setMgst_tpsz_cd               		  (mgst_tpsz_cd               	[i]);
				model.setInsp_rf_pti_cstms_tp_cd    		  (insp_rf_pti_cstms_tp_cd    	[i]);
				model.setLftg_knt                   		  (lftg_knt                   	[i]);
				model.setLftg_cuz_desc              		  (lftg_cuz_desc              	[i]);
				model.setStop_loc_nod_cd            		  (stop_loc_nod_cd            	[i]);
				model.setGrs_wgt                    		  (grs_wgt                    	[i]);
				model.setIncrt_dt                   		  (incrt_dt                   	[i]);
				model.setScl_stop_plc_nod_cd        		  (scl_stop_plc_nod_cd        	[i]);
				model.setSto_dys                    		  (sto_dys                    	[i]);
				model.setOb_bkg_no                  		  (ob_bkg_no                  	[i]);
				model.setOb_bkg_no_split            		  (ob_bkg_no_split            	[i]);
				model.setWt_hrs                     		  (wt_hrs                     	[i]);
				model.setOtr_rmk                    		  (otr_rmk                    	[i]);
				model.setInv_scg_amt                		  (inv_scg_amt                	[i]);
				model.setInv_chss_mgst_tpsz_cd      		  (inv_chss_mgst_tpsz_cd      	[i]);
				model.setInv_dry_run_rlbl_pty_tp_cd 		  (inv_dry_run_rlbl_pty_tp_cd 	[i]);
				model.setInv_fne_cuz_desc           		  (inv_fne_cuz_desc           	[i]);
				model.setInv_fumg_cost_tp_cd        		  (inv_fumg_cost_tp_cd        	[i]);
				model.setInv_mgst_tpsz_cd           		  (inv_mgst_tpsz_cd           	[i]);
				model.setInv_insp_rf_pti_cstms_tp_cd		  (inv_insp_rf_pti_cstms_tp_cd	[i]);
				model.setInv_lftg_knt               		  (inv_lftg_knt               	[i]);
				model.setInv_lftg_cuz_desc          		  (inv_lftg_cuz_desc          	[i]);
				model.setInv_stop_loc_nod_cd        		  (inv_stop_loc_nod_cd        	[i]);
				model.setInv_grs_wgt                		  (inv_grs_wgt                	[i]);
				model.setInv_incrt_dt               		  (inv_incrt_dt               	[i]);
				model.setInv_scl_stop_plc_nod_cd    		  (inv_scl_stop_plc_nod_cd    	[i]);
				model.setInv_sto_dys                		  (inv_sto_dys                	[i]);
				model.setInv_ob_bkg_no              		  (inv_ob_bkg_no              	[i]);
				model.setInv_ob_bkg_no_split        		  (inv_ob_bkg_no_split        	[i]);
				model.setInv_wt_hrs                 		  (inv_wt_hrs                 	[i]);
				model.setInv_otr_rmk                		  (inv_otr_rmk                	[i]);
				model.setN3pty_bil_flg              		  (n3pty_bil_flg              	[i]);
				model.setCust_cnt_cd                		  (cust_cnt_cd                	[i]);
				model.setCust_seq                   		  (cust_seq                   	[i]);
				model.setN3pty_vndr_seq             		  (n3pty_vndr_seq             	[i]);
				model.setN3pty_ofc_cd               		  (n3pty_ofc_cd               	[i]);
				model.setN3pty_amt                  		  (n3pty_amt                  	[i]);
				model.setN3pty_desc                 		  (n3pty_desc                 	[i]);
				model.setCre_ofc_cd                 		  (cre_ofc_cd                 	[i]);
				model.setCre_usr_id                 		  (cre_usr_id                 	[i]);
				model.setCre_dt                     		  (cre_dt                     	[i]);
				model.setUpd_usr_id                 		  (upd_usr_id                 	[i]);
				model.setUpd_dt                     		  (upd_dt                     	[i]);
				models.add(model);
			}
		return models;
	}
	public static Collection fromRequestGrid(HttpServletRequest request, String prefix) {
		SurchargeVO model = null;
		Collection models = new ArrayList();
		int length = request.getParameterValues(prefix+"ibflag").length;
			String[] ibflag                      =  (JSPUtil.getParameter(request, prefix + "ibflag                     		".trim(), length));
			String[] page_rows                   =  (JSPUtil.getParameter(request, prefix + "page_rows                  		".trim(), length));
			String[] trsp_so_ofc_cty_cd          =  (JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd         		".trim(), length));
			String[] trsp_so_seq                 =  (JSPUtil.getParameter(request, prefix + "trsp_so_seq                		".trim(), length));
			String[] lgs_cost_cd                 =  (JSPUtil.getParameter(request, prefix + "lgs_cost_cd                		".trim(), length));
			String[] unique_cd                   =  (JSPUtil.getParameter(request, prefix + "unique_cd                  		".trim(), length));
			String[] scg_amt                     =  (JSPUtil.getParameter(request, prefix + "scg_amt                    		".trim(), length));
			String[] chss_mgst_tpsz_cd           =  (JSPUtil.getParameter(request, prefix + "chss_mgst_tpsz_cd          		".trim(), length));
			String[] dry_run_rlbl_pty_tp_cd      =  (JSPUtil.getParameter(request, prefix + "dry_run_rlbl_pty_tp_cd     		".trim(), length));
			String[] fne_cuz_desc                =  (JSPUtil.getParameter(request, prefix + "fne_cuz_desc               		".trim(), length));
			String[] fumg_cost_tp_cd             =  (JSPUtil.getParameter(request, prefix + "fumg_cost_tp_cd            		".trim(), length));
			String[] mgst_tpsz_cd                =  (JSPUtil.getParameter(request, prefix + "mgst_tpsz_cd               		".trim(), length));
			String[] insp_rf_pti_cstms_tp_cd     =  (JSPUtil.getParameter(request, prefix + "insp_rf_pti_cstms_tp_cd    		".trim(), length));
			String[] lftg_knt                    =  (JSPUtil.getParameter(request, prefix + "lftg_knt                   		".trim(), length));
			String[] lftg_cuz_desc               =  (JSPUtil.getParameter(request, prefix + "lftg_cuz_desc              		".trim(), length));
			String[] stop_loc_nod_cd             =  (JSPUtil.getParameter(request, prefix + "stop_loc_nod_cd            		".trim(), length));
			String[] grs_wgt                     =  (JSPUtil.getParameter(request, prefix + "grs_wgt                    		".trim(), length));
			String[] incrt_dt                    =  (JSPUtil.getParameter(request, prefix + "incrt_dt                   		".trim(), length));
			String[] scl_stop_plc_nod_cd         =  (JSPUtil.getParameter(request, prefix + "scl_stop_plc_nod_cd        		".trim(), length));
			String[] sto_dys                     =  (JSPUtil.getParameter(request, prefix + "sto_dys                    		".trim(), length));
			String[] ob_bkg_no                   =  (JSPUtil.getParameter(request, prefix + "ob_bkg_no                  		".trim(), length));
			String[] ob_bkg_no_split             =  (JSPUtil.getParameter(request, prefix + "ob_bkg_no_split            		".trim(), length));
			String[] wt_hrs                      =  (JSPUtil.getParameter(request, prefix + "wt_hrs                     		".trim(), length));
			String[] otr_rmk                     =  (JSPUtil.getParameter(request, prefix + "otr_rmk                    		".trim(), length));
			String[] inv_scg_amt                 =  (JSPUtil.getParameter(request, prefix + "inv_scg_amt                		".trim(), length));
			String[] inv_chss_mgst_tpsz_cd       =  (JSPUtil.getParameter(request, prefix + "inv_chss_mgst_tpsz_cd      		".trim(), length));
			String[] inv_dry_run_rlbl_pty_tp_cd  =  (JSPUtil.getParameter(request, prefix + "inv_dry_run_rlbl_pty_tp_cd 		".trim(), length));
			String[] inv_fne_cuz_desc            =  (JSPUtil.getParameter(request, prefix + "inv_fne_cuz_desc           		".trim(), length));
			String[] inv_fumg_cost_tp_cd         =  (JSPUtil.getParameter(request, prefix + "inv_fumg_cost_tp_cd        		".trim(), length));
			String[] inv_mgst_tpsz_cd            =  (JSPUtil.getParameter(request, prefix + "inv_mgst_tpsz_cd           		".trim(), length));
			String[] inv_insp_rf_pti_cstms_tp_cd =  (JSPUtil.getParameter(request, prefix + "inv_insp_rf_pti_cstms_tp_cd		".trim(), length));
			String[] inv_lftg_knt                =  (JSPUtil.getParameter(request, prefix + "inv_lftg_knt               		".trim(), length));
			String[] inv_lftg_cuz_desc           =  (JSPUtil.getParameter(request, prefix + "inv_lftg_cuz_desc          		".trim(), length));
			String[] inv_stop_loc_nod_cd         =  (JSPUtil.getParameter(request, prefix + "inv_stop_loc_nod_cd        		".trim(), length));
			String[] inv_grs_wgt                 =  (JSPUtil.getParameter(request, prefix + "inv_grs_wgt                		".trim(), length));
			String[] inv_incrt_dt                =  (JSPUtil.getParameter(request, prefix + "inv_incrt_dt               		".trim(), length));
			String[] inv_scl_stop_plc_nod_cd     =  (JSPUtil.getParameter(request, prefix + "inv_scl_stop_plc_nod_cd    		".trim(), length));
			String[] inv_sto_dys                 =  (JSPUtil.getParameter(request, prefix + "inv_sto_dys                		".trim(), length));
			String[] inv_ob_bkg_no               =  (JSPUtil.getParameter(request, prefix + "inv_ob_bkg_no              		".trim(), length));
			String[] inv_ob_bkg_no_split         =  (JSPUtil.getParameter(request, prefix + "inv_ob_bkg_no_split        		".trim(), length));
			String[] inv_wt_hrs                  =  (JSPUtil.getParameter(request, prefix + "inv_wt_hrs                 		".trim(), length));
			String[] inv_otr_rmk                 =  (JSPUtil.getParameter(request, prefix + "inv_otr_rmk                		".trim(), length));
			String[] n3pty_bil_flg               =  (JSPUtil.getParameter(request, prefix + "n3pty_bil_flg              		".trim(), length));
			String[] cust_cnt_cd                 =  (JSPUtil.getParameter(request, prefix + "cust_cnt_cd                		".trim(), length));
			String[] cust_seq                    =  (JSPUtil.getParameter(request, prefix + "cust_seq                   		".trim(), length));
			String[] n3pty_vndr_seq              =  (JSPUtil.getParameter(request, prefix + "n3pty_vndr_seq             		".trim(), length));
			String[] n3pty_ofc_cd                =  (JSPUtil.getParameter(request, prefix + "n3pty_ofc_cd               		".trim(), length));
			String[] n3pty_amt                   =  (JSPUtil.getParameter(request, prefix + "n3pty_amt                  		".trim(), length));
			String[] n3pty_desc                  =  (JSPUtil.getParameter(request, prefix + "n3pty_desc                 		".trim(), length));
			String[] cre_ofc_cd                  =  (JSPUtil.getParameter(request, prefix + "cre_ofc_cd                 		".trim(), length));
			String[] cre_usr_id                  =  (JSPUtil.getParameter(request, prefix + "cre_usr_id                 		".trim(), length));
			String[] cre_dt                      =  (JSPUtil.getParameter(request, prefix + "cre_dt                     		".trim(), length));
			String[] upd_usr_id                  =  (JSPUtil.getParameter(request, prefix + "upd_usr_id                 		".trim(), length));
			String[] upd_dt                      =  (JSPUtil.getParameter(request, prefix + "upd_dt                     		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new SurchargeVO();
				model.setIbflag                     		  ( ibflag                     	[i]);
				model.setPage_rows                  		  ( page_rows                  	[i]);
				model.setTrsp_so_ofc_cty_cd         		  ( trsp_so_ofc_cty_cd         	[i]);
				model.setTrsp_so_seq                		  ( trsp_so_seq                	[i]);
				model.setLgs_cost_cd                		  ( lgs_cost_cd                	[i]);
				model.setUnique_cd                  		  ( unique_cd                  	[i]);
				model.setScg_amt                    		  ( scg_amt                    	[i]);
				model.setChss_mgst_tpsz_cd          		  ( chss_mgst_tpsz_cd          	[i]);
				model.setDry_run_rlbl_pty_tp_cd     		  ( dry_run_rlbl_pty_tp_cd     	[i]);
				model.setFne_cuz_desc               		  ( fne_cuz_desc               	[i]);
				model.setFumg_cost_tp_cd            		  ( fumg_cost_tp_cd            	[i]);
				model.setMgst_tpsz_cd               		  ( mgst_tpsz_cd               	[i]);
				model.setInsp_rf_pti_cstms_tp_cd    		  ( insp_rf_pti_cstms_tp_cd    	[i]);
				model.setLftg_knt                   		  ( lftg_knt                   	[i]);
				model.setLftg_cuz_desc              		  ( lftg_cuz_desc              	[i]);
				model.setStop_loc_nod_cd            		  ( stop_loc_nod_cd            	[i]);
				model.setGrs_wgt                    		  ( grs_wgt                    	[i]);
				model.setIncrt_dt                   		  ( incrt_dt                   	[i]);
				model.setScl_stop_plc_nod_cd        		  ( scl_stop_plc_nod_cd        	[i]);
				model.setSto_dys                    		  ( sto_dys                    	[i]);
				model.setOb_bkg_no                  		  ( ob_bkg_no                  	[i]);
				model.setOb_bkg_no_split            		  ( ob_bkg_no_split            	[i]);
				model.setWt_hrs                     		  ( wt_hrs                     	[i]);
				model.setOtr_rmk                    		  ( otr_rmk                    	[i]);
				model.setInv_scg_amt                		  ( inv_scg_amt                	[i]);
				model.setInv_chss_mgst_tpsz_cd      		  ( inv_chss_mgst_tpsz_cd      	[i]);
				model.setInv_dry_run_rlbl_pty_tp_cd 		  ( inv_dry_run_rlbl_pty_tp_cd 	[i]);
				model.setInv_fne_cuz_desc           		  ( inv_fne_cuz_desc           	[i]);
				model.setInv_fumg_cost_tp_cd        		  ( inv_fumg_cost_tp_cd        	[i]);
				model.setInv_mgst_tpsz_cd           		  ( inv_mgst_tpsz_cd           	[i]);
				model.setInv_insp_rf_pti_cstms_tp_cd		  ( inv_insp_rf_pti_cstms_tp_cd	[i]);
				model.setInv_lftg_knt               		  ( inv_lftg_knt               	[i]);
				model.setInv_lftg_cuz_desc          		  ( inv_lftg_cuz_desc          	[i]);
				model.setInv_stop_loc_nod_cd        		  ( inv_stop_loc_nod_cd        	[i]);
				model.setInv_grs_wgt                		  ( inv_grs_wgt                	[i]);
				model.setInv_incrt_dt               		  ( inv_incrt_dt               	[i]);
				model.setInv_scl_stop_plc_nod_cd    		  ( inv_scl_stop_plc_nod_cd    	[i]);
				model.setInv_sto_dys                		  ( inv_sto_dys                	[i]);
				model.setInv_ob_bkg_no              		  ( inv_ob_bkg_no              	[i]);
				model.setInv_ob_bkg_no_split        		  ( inv_ob_bkg_no_split        	[i]);
				model.setInv_wt_hrs                 		  ( inv_wt_hrs                 	[i]);
				model.setInv_otr_rmk                		  ( inv_otr_rmk                	[i]);
				model.setN3pty_bil_flg              		  ( n3pty_bil_flg              	[i]);
				model.setCust_cnt_cd                		  ( cust_cnt_cd                	[i]);
				model.setCust_seq                   		  ( cust_seq                   	[i]);
				model.setN3pty_vndr_seq             		  ( n3pty_vndr_seq             	[i]);
				model.setN3pty_ofc_cd               		  ( n3pty_ofc_cd               	[i]);
				model.setN3pty_amt                  		  ( n3pty_amt                  	[i]);
				model.setN3pty_desc                 		  ( n3pty_desc                 	[i]);
				model.setCre_ofc_cd                 		  ( cre_ofc_cd                 	[i]);
				model.setCre_usr_id                 		  ( cre_usr_id                 	[i]);
				model.setCre_dt                     		  ( cre_dt                     	[i]);
				model.setUpd_usr_id                 		  ( upd_usr_id                 	[i]);
				model.setUpd_dt                     		  ( upd_dt                     	[i]);
				models.add(model);
			}
		return models;
	}
}
