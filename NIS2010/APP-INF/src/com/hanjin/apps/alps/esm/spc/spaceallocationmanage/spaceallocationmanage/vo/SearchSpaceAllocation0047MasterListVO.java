/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceAllocation0047MasterListVO.java
*@FileTitle : SearchSpaceAllocation0047MasterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.07.05 최윤성 
* 1.0 Creation
* 
* 2011.07.05 이석준 [CHM-201111880] control by HO 화면 보완 - IPC, TS 관련 
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocation0047MasterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0047MasterListVO> models = new ArrayList<SearchSpaceAllocation0047MasterListVO>();
	
	/* Column Info */
	private String ctrlPortFlg = null;
	/* Column Info */
	private String alOcnVol = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fdWgt = null;
	/* Column Info */
	private String ctrl40ftHcFlg = null;
	/* Column Info */
	private String fcIpcVol = null;
	/* Column Info */
	private String lodHc = null;
	/* Column Info */
	private String fcIpcWgt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bsaWgt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String ctrlWgtFlg = null;
	/* Column Info */
	private String alOcnWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgIpcWgt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String ctrlRfFlg = null;
	/* Column Info */
	private String costMon = null;
	/* Column Info */
	private String lodRf = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String alIpcWgt = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String lodVol = null;
	/* Column Info */
	private String alIpcVol = null;
	/* Column Info */
	private String mtyGnte = null;
	/* Column Info */
	private String fcOcnVol = null;
	/* Column Info */
	private String bsaVol = null;
	/* Column Info */
	private String fcOcnWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ctrlSpcFlg = null;
	/* Column Info */
	private String bkgIpcVol = null;
	/* Column Info */
	private String ctrl45ftHcFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fdVol = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* Column Info */
	private String epVol = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String lodWgt = null;
	/* Column Info */
	private String bkgOcnWgt = null;
	/* Column Info */
	private String ctrl53ftFlg = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String lod45 = null;
	/* Column Info */
	private String qtaOcn = null;
	/* Column Info */
	private String bkgOcnVol = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String qtaIpc = null;
	/* Column Info */
	private String alTsVol = null;
	/* Column Info */
	private String alTsWgt= null;
	/* Column Info */
	private String fcTsWgt = null;
	/* Column Info */
	private String fcTsVol= null;
	/* Column Info */
	private String bkgTsWgt = null;
	/* Column Info */
	private String bkgTsVol = null;		
	/* Column Info */
	private String cmOp= null;
	/* Column Info */
	private String cmOc = null;
	/* Column Info */
	private String cmVl = null;		
	/* Column Info */
	private String acct = null; //spc_aloc_ctrl_opt.acct_grp_ctrl_flg	
	
	/* Column Info */
	private String ctrlD2Flg = null;	
	/* Column Info */
	private String ctrlD4Flg = null;	
	/* Column Info */
	private String ctrlRdFlg = null;
	
	/* Column Info */
	private String ctrlEccFlg = null;
	/* Column Info */
	private String ctrlLocFlg = null;
	/* Column Info */
	private String ctrlUsaSvcModFlg = null;
	/* Column Info */
	private String ctrlAcctFlg = null;
	/* Column Info */
	private String ctrlDestLvlCd = null;
	/* Column Info */
	private String bkgBsWgt = null;
	/* Column Info */
	private String bkgBsVol = null;
	
	/* Column Info */
	private String ctrlFxRtFlg = null;  
	/* Column Info */
	private String bkgWgtVgm;
	/* Column Info */
	private String bkgOcnWgtVgm = null;
	/* Column Info */
	private String bkgIpcWgtVgm = null;
	/* Column Info */
	private String bkgTsWgtVgm = null;
	/* Column Info */
	private String bkgVolVgm = null;
	/* Column Info */
	private String bkgOcnVolVgm = null;
	/* Column Info */
	private String bkgIpcVolVgm = null;
	/* Column Info */
	private String bkgTsVolVgm = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceAllocation0047MasterListVO() {}

	public SearchSpaceAllocation0047MasterListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, 
			String dirCd, String costYr, String costMon, String costWk, String vslCd, String skdVoyNo, String skdDirCd, String vvd,
			String bsaVol, String bsaWgt, String lodVol, String lodWgt, String lodHc, String lod45, String lodRf, String fdVol, 
			String fdWgt, String qtaOcn, String qtaIpc, String fcOcnVol, String fcOcnWgt, String fcIpcVol, String fcIpcWgt, 
			String epVol, String alOcnVol, String alOcnWgt, String alIpcVol, String alIpcWgt, String bkgOcnVol, String bkgOcnWgt, 
			String bkgIpcVol, String bkgIpcWgt, String lstLodgPortEtdDt, String lstLodgPortCd, String ctrlPortFlg, String ctrl40ftHcFlg, 
			String ctrl45ftHcFlg, String ctrl53ftFlg, String ctrlRfFlg, String ctrlWgtFlg, String ctrlSpcFlg, String mtyGnte,String fcTsVol,
			String fcTsWgt,String alTsVol,String alTsWgt,String bkgTsVol,String bkgTsWgt, String cmOp, String cmOc, String cmVl, String acct
			, String ctrlD2Flg, String ctrlD4Flg, String ctrlRdFlg, String ctrlEccFlg, String ctrlLocFlg, String ctrlUsaSvcModFlg,
			String ctrlAcctFlg, String ctrlDestLvlCd, String bkgBsWgt, String bkgBsVol, String ctrlFxRtFlg,String bkgWgtVgm,String bkgVolVgm,String bkgIpcVolVgm,String bkgOcnVolVgm,String bkgTsVolVgm) {
		this.ctrlPortFlg = ctrlPortFlg;
		this.alOcnVol = alOcnVol;
		this.vslCd = vslCd;
		this.fdWgt = fdWgt;
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
		this.fcIpcVol = fcIpcVol;
		this.lodHc = lodHc;
		this.fcIpcWgt = fcIpcWgt;
		this.trdCd = trdCd;
		this.bsaWgt = bsaWgt;
		this.rlaneCd = rlaneCd;
		this.ctrlWgtFlg = ctrlWgtFlg;
		this.alOcnWgt = alOcnWgt;
		this.pagerows = pagerows;
		this.bkgIpcWgt = bkgIpcWgt;
		this.ibflag = ibflag;
		this.ctrlRfFlg = ctrlRfFlg;
		this.costMon = costMon;
		this.lodRf = lodRf;
		this.dirCd = dirCd;
		this.alIpcWgt = alIpcWgt;
		this.lstLodgPortCd = lstLodgPortCd;
		this.lodVol = lodVol;
		this.alIpcVol = alIpcVol;
		this.mtyGnte = mtyGnte;
		this.fcOcnVol = fcOcnVol;
		this.bsaVol = bsaVol;
		this.fcOcnWgt = fcOcnWgt;
		this.skdVoyNo = skdVoyNo;
		this.ctrlSpcFlg = ctrlSpcFlg;
		this.bkgIpcVol = bkgIpcVol;
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
		this.skdDirCd = skdDirCd;
		this.fdVol = fdVol;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.epVol = epVol;
		this.vvd = vvd;
		this.lodWgt = lodWgt;
		this.bkgOcnWgt = bkgOcnWgt;
		this.ctrl53ftFlg = ctrl53ftFlg;
		this.costYr = costYr;
		this.costWk = costWk;
		this.lod45 = lod45;
		this.qtaOcn = qtaOcn;
		this.bkgOcnVol = bkgOcnVol;
		this.subTrdCd = subTrdCd;
		this.qtaIpc = qtaIpc;
		this.fcTsVol = fcTsVol;
		this.fcTsWgt = fcTsWgt;
		this.alTsVol = alTsVol;
		this.alTsWgt = alTsWgt;
		this.bkgTsVol = bkgTsVol;
		this.bkgTsWgt = bkgTsWgt;		
		this.cmOp = cmOp;
		this.cmOc = cmOp;
		this.cmVl = cmVl;		
		this.acct = acct;	
		
		this.ctrlD2Flg = ctrlD2Flg;
		this.ctrlD4Flg = ctrlD4Flg;
		this.ctrlRdFlg = ctrlRdFlg;
		
		this.ctrlEccFlg = ctrlEccFlg;
		this.ctrlLocFlg = ctrlLocFlg;
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
		this.ctrlAcctFlg = ctrlAcctFlg;
		this.ctrlDestLvlCd = ctrlDestLvlCd;
		
		this.bkgBsVol = bkgBsVol;
		this.bkgBsWgt = bkgBsWgt;
		
		this.ctrlFxRtFlg = ctrlFxRtFlg;
		this.bkgWgtVgm = bkgWgtVgm;
		this.bkgVolVgm = bkgVolVgm;
		this.bkgIpcVolVgm = bkgIpcVolVgm;
		this.bkgOcnVolVgm = bkgOcnVolVgm;
		this.bkgTsVolVgm = bkgTsVolVgm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrl_port_flg", getCtrlPortFlg());
		this.hashColumns.put("al_ocn_vol", getAlOcnVol());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("fd_wgt", getFdWgt());
		this.hashColumns.put("ctrl_40ft_hc_flg", getCtrl40ftHcFlg());
		this.hashColumns.put("fc_ipc_vol", getFcIpcVol());
		this.hashColumns.put("lod_hc", getLodHc());
		this.hashColumns.put("fc_ipc_wgt", getFcIpcWgt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bsa_wgt", getBsaWgt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ctrl_wgt_flg", getCtrlWgtFlg());
		this.hashColumns.put("al_ocn_wgt", getAlOcnWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_ipc_wgt", getBkgIpcWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrl_rf_flg", getCtrlRfFlg());
		this.hashColumns.put("cost_mon", getCostMon());
		this.hashColumns.put("lod_rf", getLodRf());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("al_ipc_wgt", getAlIpcWgt());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("lod_vol", getLodVol());
		this.hashColumns.put("al_ipc_vol", getAlIpcVol());
		this.hashColumns.put("mty_gnte", getMtyGnte());
		this.hashColumns.put("fc_ocn_vol", getFcOcnVol());
		this.hashColumns.put("bsa_vol", getBsaVol());
		this.hashColumns.put("fc_ocn_wgt", getFcOcnWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ctrl_spc_flg", getCtrlSpcFlg());
		this.hashColumns.put("bkg_ipc_vol", getBkgIpcVol());
		this.hashColumns.put("ctrl_45ft_hc_flg", getCtrl45ftHcFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fd_vol", getFdVol());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("ep_vol", getEpVol());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("lod_wgt", getLodWgt());
		this.hashColumns.put("bkg_ocn_wgt", getBkgOcnWgt());
		this.hashColumns.put("ctrl_53ft_flg", getCtrl53ftFlg());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("lod_45", getLod45());
		this.hashColumns.put("qta_ocn", getQtaOcn());
		this.hashColumns.put("bkg_ocn_vol", getBkgOcnVol());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("qta_ipc", getQtaIpc());
		
		this.hashColumns.put("fc_ts_vol", getFcTsVol());
		this.hashColumns.put("fc_ts_wgt", getFcTsWgt());
		this.hashColumns.put("al_ts_vol", getAlTsVol());
		this.hashColumns.put("al_ts_wgt", getAlTsWgt());
		this.hashColumns.put("bkg_ts_vol", getBkgTsVol());
		this.hashColumns.put("bkg_ts_wgt", getBkgTsWgt());		
		this.hashColumns.put("cm_op", getCmOp());
		this.hashColumns.put("cm_oc", getCmOc());
		this.hashColumns.put("cm_vl", getCmVl());		
		this.hashColumns.put("acct", getAcct());

		this.hashColumns.put("ctrl_d2_flg", getCtrlD2Flg());
		this.hashColumns.put("ctrl_d4_flg", getCtrlD4Flg());
		this.hashColumns.put("ctrl_rd_flg", getCtrlRdFlg());
		
		this.hashColumns.put("ctrl_ecc_flg", getCtrlEccFlg());
		this.hashColumns.put("ctrl_loc_flg", getCtrlLocFlg());
		this.hashColumns.put("ctrl_usa_svc_mod_flg", getCtrlUsaSvcModFlg());
		this.hashColumns.put("ctrl_acct_flg", getCtrlAcctFlg());
		this.hashColumns.put("ctrl_dest_lvl_cd", getCtrlDestLvlCd());

		this.hashColumns.put("bkg_bs_vol", getBkgBsVol());
		this.hashColumns.put("bkg_bs_wgt", getBkgBsWgt());
		this.hashColumns.put("ctrl_fx_rt_flg", getCtrlFxRtFlg());
		this.hashColumns.put("bkg_wgt_vgm", getBkgWgtVgm());
		this.hashColumns.put("bkg_ipc_wgt_vgm", getBkgIpcWgtVgm());	
		this.hashColumns.put("bkg_ocn_wgt_vgm", getBkgOcnWgtVgm());	
		this.hashColumns.put("bkg_ts_wgt_vgm", getBkgTsWgtVgm());	
		this.hashColumns.put("bkg_vol_vgm", getBkgVolVgm());
		this.hashColumns.put("bkg_ipc_vol_vgm", getBkgIpcVolVgm());	
		this.hashColumns.put("bkg_ocn_vol_vgm", getBkgOcnVolVgm());	
		this.hashColumns.put("bkg_ts_vol_vgm", getBkgTsVolVgm());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrl_port_flg", "ctrlPortFlg");
		this.hashFields.put("al_ocn_vol", "alOcnVol");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("fd_wgt", "fdWgt");
		this.hashFields.put("ctrl_40ft_hc_flg", "ctrl40ftHcFlg");
		this.hashFields.put("fc_ipc_vol", "fcIpcVol");
		this.hashFields.put("lod_hc", "lodHc");
		this.hashFields.put("fc_ipc_wgt", "fcIpcWgt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bsa_wgt", "bsaWgt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ctrl_wgt_flg", "ctrlWgtFlg");
		this.hashFields.put("al_ocn_wgt", "alOcnWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_ipc_wgt", "bkgIpcWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrl_rf_flg", "ctrlRfFlg");
		this.hashFields.put("cost_mon", "costMon");
		this.hashFields.put("lod_rf", "lodRf");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("al_ipc_wgt", "alIpcWgt");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("lod_vol", "lodVol");
		this.hashFields.put("al_ipc_vol", "alIpcVol");
		this.hashFields.put("mty_gnte", "mtyGnte");
		this.hashFields.put("fc_ocn_vol", "fcOcnVol");
		this.hashFields.put("bsa_vol", "bsaVol");
		this.hashFields.put("fc_ocn_wgt", "fcOcnWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ctrl_spc_flg", "ctrlSpcFlg");
		this.hashFields.put("bkg_ipc_vol", "bkgIpcVol");
		this.hashFields.put("ctrl_45ft_hc_flg", "ctrl45ftHcFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fd_vol", "fdVol");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("ep_vol", "epVol");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("lod_wgt", "lodWgt");
		this.hashFields.put("bkg_ocn_wgt", "bkgOcnWgt");
		this.hashFields.put("ctrl_53ft_flg", "ctrl53ftFlg");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("lod_45", "lod45");
		this.hashFields.put("qta_ocn", "qtaOcn");
		this.hashFields.put("bkg_ocn_vol", "bkgOcnVol");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("qta_ipc", "qtaIpc");
		
		this.hashFields.put("fc_ts_vol",  "fcTsVol");
		this.hashFields.put("fc_ts_wgt",  "fcTsWgt");
		this.hashFields.put("al_ts_vol",  "alTsVol");
		this.hashFields.put("al_ts_wgt",  "alTsWgt");
		this.hashFields.put("bkg_ts_vol", "bkgTsVol");
		this.hashFields.put("bkg_ts_wgt", "bkgTsWgt");		
		this.hashFields.put("cm_op",  "cmOp");
		this.hashFields.put("cm_oc", "cmOc");
		this.hashFields.put("cm_vl", "cmVl");		
		this.hashFields.put("acct", "acct");
		
		this.hashFields.put("ctrl_d2_flg", "ctrlD2Flg");
		this.hashFields.put("ctrl_d4_flg", "ctrlD4Flg");
		this.hashFields.put("ctrl_rd_flg", "ctrlRdFlg");
		
		this.hashFields.put("ctrl_ecc_flg", "ctrlEccFlg");
		this.hashFields.put("ctrl_loc_flg", "ctrlLocFlg");
		this.hashFields.put("ctrl_usa_svc_mod_flg", "ctrlUsaSvcModFlg");
		this.hashFields.put("ctrl_acct_flg", "ctrlAcctFlg");
		this.hashFields.put("ctrl_dest_lvl_cd", "ctrlDestLvlCd");
		
		this.hashFields.put("bkg_bs_vol", "bkgBsVol");
		this.hashFields.put("bkg_bs_wgt", "bkgBsWgt");
		this.hashFields.put("ctrl_fx_rt_flg", "ctrlFxRtFlg");
		this.hashFields.put("bkg_wgt_vgm", "bkgWgtVgm");
		this.hashFields.put("bkg_ipc_wgt_vgm", "bkgIpcWgtVgm");
		this.hashFields.put("bkg_ocn_wgt_vgm", "bkgOcnWgtVgm");
		this.hashFields.put("bkg_ts_wgt_vgm", "bkgTsWgtVgm");
		this.hashFields.put("bkg_vol_vgm", "bkgVolVgm");
		this.hashFields.put("bkg_ipc_vol_vgm", "bkgIpcVolVgm");
		this.hashFields.put("bkg_ocn_vol_vgm", "bkgOcnVolVgm");
		this.hashFields.put("bkg_ts_vol_vgm", "bkgTsVolVgm");
		return this.hashFields;
	}
	/**
	 * Column Info			
	 * @return bkgVolVgm			
	 */		
	public String getBkgVolVgm() {
		return bkgVolVgm;
	}
	/**			
	 * Column Info			
	 * @param bkgVolVgm			
	 */		
	public void setBkgVolVgm(String bkgVolVgm) {
		this.bkgVolVgm = bkgVolVgm;
	}
	/**			
	 * Column Info			
	 * @return bkgOcnWgtVgm			
	 */		
	public String getBkgOcnVolVgm() {
		return bkgOcnVolVgm;
	}
	/**			
	 * Column Info			
	 * @param bkgOcnWgtVgm			
	 */		
	public void setBkgOcnVolVgm(String bkgOcnVolVgm) {
		this.bkgOcnVolVgm = bkgOcnVolVgm;
	}
	/**			
	 * Column Info			
	 * @return bkgIpcVolVgm			
	 */		
	public String getBkgIpcVolVgm() {
		return bkgIpcVolVgm;
	}
	/**			
	 * Column Info			
	 * @param bkgIpcVolVgm			
	 */		
	public void setBkgIpcVolVgm(String bkgIpcVolVgm) {
		this.bkgIpcVolVgm = bkgIpcVolVgm;
	}
	/**			
	 * Column Info			
	 * @return bkgTsVolVgm			
	 */		
	public String getBkgTsVolVgm() {
		return bkgTsVolVgm;
	}
	/**			
	 * Column Info			
	 * @param bkgTsVolVgm			
	 */		
	public void setBkgTsVolVgm(String bkgTsVolVgm) {
		this.bkgTsVolVgm = bkgTsVolVgm;
	}
	/**			
	 * Column Info			
	 * @return bkgOcnWgtVgm			
	 */			
	public String getBkgOcnWgtVgm() {
		return this.bkgOcnWgtVgm;
	}

	/**			
	 * Column Info			
	 * @param bkgOcnWgtVgm			
	 */			
	public void setBkgOcnWgtVgm(String bkgOcnWgtVgm) {
		this.bkgOcnWgtVgm = bkgOcnWgtVgm;
	}

	/**			
	 * Column Info			
	 * @return bkgIpcWgtVgm			
	 */			
	public String getBkgIpcWgtVgm() {
		return this.bkgIpcWgtVgm;
	}

	/**			
	 * Column Info			
	 * @param bkgIpcWgtVgm			
	 */			
	public void setBkgIpcWgtVgm(String bkgIpcWgtVgm) {
		this.bkgIpcWgtVgm = bkgIpcWgtVgm;
	}

	/**			
	 * Column Info			
	 * @return bkgTsWgtVgm			
	 */			
	public String getBkgTsWgtVgm() {
		return this.bkgTsWgtVgm;
	}

	/**			
	 * Column Info			
	 * @param bkgTsWgtVgm			
	 */			
	public void setBkgTsWgtVgm(String bkgTsWgtVgm) {
		this.bkgTsWgtVgm = bkgTsWgtVgm;
	}
	
	/**			
	 * Column Info			
	 * @return bkgWgtVgm			
	 */			
	public String getBkgWgtVgm() {			
		return this.bkgWgtVgm;		
	}			
	/**			
	 * Column Info			
	 * @param bkgWgtVgm			
	 */			
	public void setBkgWgtVgm(String bkgWgtVgm) {			
		this.bkgWgtVgm = bkgWgtVgm;		
	}			
	/**
	 * Column Info
	 * @return ctrlPortFlg
	 */
	public String getCtrlPortFlg() {
		return this.ctrlPortFlg;
	}
	
	/**
	 * Column Info
	 * @return alOcnVol
	 */
	public String getAlOcnVol() {
		return this.alOcnVol;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return fdWgt
	 */
	public String getFdWgt() {
		return this.fdWgt;
	}
	
	/**
	 * Column Info
	 * @return ctrl40ftHcFlg
	 */
	public String getCtrl40ftHcFlg() {
		return this.ctrl40ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @return fcIpcVol
	 */
	public String getFcIpcVol() {
		return this.fcIpcVol;
	}
	
	/**
	 * Column Info
	 * @return lodHc
	 */
	public String getLodHc() {
		return this.lodHc;
	}
	
	/**
	 * Column Info
	 * @return fcIpcWgt
	 */
	public String getFcIpcWgt() {
		return this.fcIpcWgt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaWgt
	 */
	public String getBsaWgt() {
		return this.bsaWgt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlWgtFlg
	 */
	public String getCtrlWgtFlg() {
		return this.ctrlWgtFlg;
	}
	
	/**
	 * Column Info
	 * @return alOcnWgt
	 */
	public String getAlOcnWgt() {
		return this.alOcnWgt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return bkgIpcWgt
	 */
	public String getBkgIpcWgt() {
		return this.bkgIpcWgt;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return ctrlRfFlg
	 */
	public String getCtrlRfFlg() {
		return this.ctrlRfFlg;
	}
	
	/**
	 * Column Info
	 * @return costMon
	 */
	public String getCostMon() {
		return this.costMon;
	}
	
	/**
	 * Column Info
	 * @return lodRf
	 */
	public String getLodRf() {
		return this.lodRf;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return alIpcWgt
	 */
	public String getAlIpcWgt() {
		return this.alIpcWgt;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @return lodVol
	 */
	public String getLodVol() {
		return this.lodVol;
	}
	
	/**
	 * Column Info
	 * @return alIpcVol
	 */
	public String getAlIpcVol() {
		return this.alIpcVol;
	}
	
	/**
	 * Column Info
	 * @return mtyGnte
	 */
	public String getMtyGnte() {
		return this.mtyGnte;
	}
	
	/**
	 * Column Info
	 * @return fcOcnVol
	 */
	public String getFcOcnVol() {
		return this.fcOcnVol;
	}
	
	/**
	 * Column Info
	 * @return bsaVol
	 */
	public String getBsaVol() {
		return this.bsaVol;
	}
	
	/**
	 * Column Info
	 * @return fcOcnWgt
	 */
	public String getFcOcnWgt() {
		return this.fcOcnWgt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ctrlSpcFlg
	 */
	public String getCtrlSpcFlg() {
		return this.ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgIpcVol
	 */
	public String getBkgIpcVol() {
		return this.bkgIpcVol;
	}
	
	/**
	 * Column Info
	 * @return ctrl45ftHcFlg
	 */
	public String getCtrl45ftHcFlg() {
		return this.ctrl45ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return fdVol
	 */
	public String getFdVol() {
		return this.fdVol;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortEtdDt
	 */
	public String getLstLodgPortEtdDt() {
		return this.lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return epVol
	 */
	public String getEpVol() {
		return this.epVol;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return lodWgt
	 */
	public String getLodWgt() {
		return this.lodWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgOcnWgt
	 */
	public String getBkgOcnWgt() {
		return this.bkgOcnWgt;
	}
	
	/**
	 * Column Info
	 * @return ctrl53ftFlg
	 */
	public String getCtrl53ftFlg() {
		return this.ctrl53ftFlg;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return lod45
	 */
	public String getLod45() {
		return this.lod45;
	}
	
	/**
	 * Column Info
	 * @return qtaOcn
	 */
	public String getQtaOcn() {
		return this.qtaOcn;
	}
	
	/**
	 * Column Info
	 * @return bkgOcnVol
	 */
	public String getBkgOcnVol() {
		return this.bkgOcnVol;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return qtaIpc
	 */
	public String getQtaIpc() {
		return this.qtaIpc;
	}
	
	public String getAlTsVol() {
		return alTsVol;
	}

	public String getAlTsWgt() {
		return alTsWgt;
	}

	public String getFcTsWgt() {
		return fcTsWgt;
	}

	public String getFcTsVol() {
		return fcTsVol;
	}

	public String getBkgTsWgt() {
		return bkgTsWgt;
	}

	public String getBkgTsVol() {
		return bkgTsVol;
	}
	
	public String getCtrlD2Flg() {
		return this.ctrlD2Flg;
	}

	public String getCtrlD4Flg() {
		return this.ctrlD4Flg;
	}

	public String getCtrlRdFlg() {
		return this.ctrlRdFlg;
	}
	
	public String getCtrlEccFlg() {
		return this.ctrlEccFlg;
	}

	public String getCtrlLocFlg() {
		return this.ctrlLocFlg;
	}

	public String getCtrlUsaSvcModFlg() {
		return this.ctrlUsaSvcModFlg;
	}
	
	public String getCtrlAcctFlg() {
		return this.ctrlAcctFlg;
	}

	public String getCtrlDestLvlCd() {
		return this.ctrlDestLvlCd;
	}
	
	/**
	 * @return the cmOp
	 */
	public String getCmOp() {
		return cmOp;
	}

	/**
	 * @param cmOp the cmOp to set
	 */
	public void setCmOp(String cmOp) {
		this.cmOp = cmOp;
	}

	/**
	 * @return the cmOc
	 */
	public String getCmOc() {
		return cmOc;
	}

	/**
	 * @param cmOc the cmOc to set
	 */
	public void setCmOc(String cmOc) {
		this.cmOc = cmOc;
	}

	/**
	 * @return the cmVl
	 */
	public String getCmVl() {
		return cmVl;
	}
	
	/**
	 * @return the acct
	 */
	public String getAcct() {
		return acct;
	}

	/**
	 * @return the bkgBsVol
	 */
	public String getBkgBsVol() {
		return bkgBsVol;
	}
	
	/**
	 * @return the bkgBsWgt
	 */
	public String getBkgBsWgt() {
		return bkgBsWgt;
	}
	
	/**
	 * @param cmVl the cmVl to set
	 */
	public void setCmVl(String cmVl) {
		this.cmVl = cmVl;
	}
	
	/**
	 * @param acct the acct to set
	 */
	public void setAcct(String acct) {
		this.acct = acct;
	}

	/**
	 * Column Info
	 * @param ctrlPortFlg
	 */
	public void setCtrlPortFlg(String ctrlPortFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
	}
	
	/**
	 * Column Info
	 * @param alOcnVol
	 */
	public void setAlOcnVol(String alOcnVol) {
		this.alOcnVol = alOcnVol;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param fdWgt
	 */
	public void setFdWgt(String fdWgt) {
		this.fdWgt = fdWgt;
	}
	
	/**
	 * Column Info
	 * @param ctrl40ftHcFlg
	 */
	public void setCtrl40ftHcFlg(String ctrl40ftHcFlg) {
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @param fcIpcVol
	 */
	public void setFcIpcVol(String fcIpcVol) {
		this.fcIpcVol = fcIpcVol;
	}
	
	/**
	 * Column Info
	 * @param lodHc
	 */
	public void setLodHc(String lodHc) {
		this.lodHc = lodHc;
	}
	
	/**
	 * Column Info
	 * @param fcIpcWgt
	 */
	public void setFcIpcWgt(String fcIpcWgt) {
		this.fcIpcWgt = fcIpcWgt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaWgt
	 */
	public void setBsaWgt(String bsaWgt) {
		this.bsaWgt = bsaWgt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlWgtFlg
	 */
	public void setCtrlWgtFlg(String ctrlWgtFlg) {
		this.ctrlWgtFlg = ctrlWgtFlg;
	}
	
	/**
	 * Column Info
	 * @param alOcnWgt
	 */
	public void setAlOcnWgt(String alOcnWgt) {
		this.alOcnWgt = alOcnWgt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param bkgIpcWgt
	 */
	public void setBkgIpcWgt(String bkgIpcWgt) {
		this.bkgIpcWgt = bkgIpcWgt;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param ctrlRfFlg
	 */
	public void setCtrlRfFlg(String ctrlRfFlg) {
		this.ctrlRfFlg = ctrlRfFlg;
	}
	
	/**
	 * Column Info
	 * @param costMon
	 */
	public void setCostMon(String costMon) {
		this.costMon = costMon;
	}
	
	/**
	 * Column Info
	 * @param lodRf
	 */
	public void setLodRf(String lodRf) {
		this.lodRf = lodRf;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param alIpcWgt
	 */
	public void setAlIpcWgt(String alIpcWgt) {
		this.alIpcWgt = alIpcWgt;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @param lodVol
	 */
	public void setLodVol(String lodVol) {
		this.lodVol = lodVol;
	}
	
	/**
	 * Column Info
	 * @param alIpcVol
	 */
	public void setAlIpcVol(String alIpcVol) {
		this.alIpcVol = alIpcVol;
	}
	
	/**
	 * Column Info
	 * @param mtyGnte
	 */
	public void setMtyGnte(String mtyGnte) {
		this.mtyGnte = mtyGnte;
	}
	
	/**
	 * Column Info
	 * @param fcOcnVol
	 */
	public void setFcOcnVol(String fcOcnVol) {
		this.fcOcnVol = fcOcnVol;
	}
	
	/**
	 * Column Info
	 * @param bsaVol
	 */
	public void setBsaVol(String bsaVol) {
		this.bsaVol = bsaVol;
	}
	
	/**
	 * Column Info
	 * @param fcOcnWgt
	 */
	public void setFcOcnWgt(String fcOcnWgt) {
		this.fcOcnWgt = fcOcnWgt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ctrlSpcFlg
	 */
	public void setCtrlSpcFlg(String ctrlSpcFlg) {
		this.ctrlSpcFlg = ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgIpcVol
	 */
	public void setBkgIpcVol(String bkgIpcVol) {
		this.bkgIpcVol = bkgIpcVol;
	}
	
	/**
	 * Column Info
	 * @param ctrl45ftHcFlg
	 */
	public void setCtrl45ftHcFlg(String ctrl45ftHcFlg) {
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param fdVol
	 */
	public void setFdVol(String fdVol) {
		this.fdVol = fdVol;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortEtdDt
	 */
	public void setLstLodgPortEtdDt(String lstLodgPortEtdDt) {
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param epVol
	 */
	public void setEpVol(String epVol) {
		this.epVol = epVol;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param lodWgt
	 */
	public void setLodWgt(String lodWgt) {
		this.lodWgt = lodWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgOcnWgt
	 */
	public void setBkgOcnWgt(String bkgOcnWgt) {
		this.bkgOcnWgt = bkgOcnWgt;
	}
	
	/**
	 * Column Info
	 * @param ctrl53ftFlg
	 */
	public void setCtrl53ftFlg(String ctrl53ftFlg) {
		this.ctrl53ftFlg = ctrl53ftFlg;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param lod45
	 */
	public void setLod45(String lod45) {
		this.lod45 = lod45;
	}
	
	/**
	 * Column Info
	 * @param qtaOcn
	 */
	public void setQtaOcn(String qtaOcn) {
		this.qtaOcn = qtaOcn;
	}
	
	/**
	 * Column Info
	 * @param bkgOcnVol
	 */
	public void setBkgOcnVol(String bkgOcnVol) {
		this.bkgOcnVol = bkgOcnVol;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param qtaIpc
	 */
	public void setQtaIpc(String qtaIpc) {
		this.qtaIpc = qtaIpc;
	}
	
	public void setAlTsVol(String alTsVol) {
		this.alTsVol = alTsVol;
	}

	public void setAlTsWgt(String alTsWgt) {
		this.alTsWgt = alTsWgt;
	}

	public void setFcTsWgt(String fcTsWgt) {
		this.fcTsWgt = fcTsWgt;
	}

	public void setFcTsVol(String fcTsVol) {
		this.fcTsVol = fcTsVol;
	}

	public void setBkgTsWgt(String bkgTsWgt) {
		this.bkgTsWgt = bkgTsWgt;
	}

	public void setBkgTsVol(String bkgTsVol) {
		this.bkgTsVol = bkgTsVol;
	}
	
	public void setCtrlD2Flg(String ctrlD2Flg) {
		this.ctrlD2Flg = ctrlD2Flg;
	}

	public void setCtrlD4Flg(String ctrlD4Flg) {
		this.ctrlD4Flg = ctrlD4Flg;
	}

	public void setCtrlRdFlg(String ctrlRdFlg) {
		this.ctrlRdFlg = ctrlRdFlg;
	}
	
	public void setCtrlEccFlg(String ctrlEccFlg) {
		this.ctrlEccFlg = ctrlEccFlg;
	}

	public void setCtrlLocFlg(String ctrlLocFlg) {
		this.ctrlLocFlg = ctrlLocFlg;
	}

	public void setCtrlUsaSvcModFlg(String ctrlUsaSvcModFlg) {
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
	}
	
	public void setCtrlAcctFlg(String ctrlAcctFlg) {
		this.ctrlAcctFlg = ctrlAcctFlg;
	}

	public void setCtrlDestLvlCd(String ctrlDestLvlCd) {
		this.ctrlDestLvlCd = ctrlDestLvlCd;
	}

	public void setBkgBsWgt(String bkgBsWgt) {
		this.bkgBsWgt = bkgBsWgt;
	}

	public void setBkgBsVol(String bkgBsVol) {
		this.bkgBsVol = bkgBsVol;
	}
	
	/**
	 * @return the ctrlFxRtFlg
	 */
	public String getCtrlFxRtFlg() {
		return ctrlFxRtFlg;
	}
	
	/**
	 * @param ctrlFxRtFlg the ctrlFxRtFlg to set
	 */
	public void setCtrlFxRtFlg(String ctrlFxRtFlg) {
		this.ctrlFxRtFlg = ctrlFxRtFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCtrlPortFlg(JSPUtil.getParameter(request, prefix + "ctrl_port_flg", ""));
		setAlOcnVol(JSPUtil.getParameter(request, prefix + "al_ocn_vol", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFdWgt(JSPUtil.getParameter(request, prefix + "fd_wgt", ""));
		setCtrl40ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_40ft_hc_flg", ""));
		setFcIpcVol(JSPUtil.getParameter(request, prefix + "fc_ipc_vol", ""));
		setLodHc(JSPUtil.getParameter(request, prefix + "lod_hc", ""));
		setFcIpcWgt(JSPUtil.getParameter(request, prefix + "fc_ipc_wgt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBsaWgt(JSPUtil.getParameter(request, prefix + "bsa_wgt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCtrlWgtFlg(JSPUtil.getParameter(request, prefix + "ctrl_wgt_flg", ""));
		setAlOcnWgt(JSPUtil.getParameter(request, prefix + "al_ocn_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgIpcWgt(JSPUtil.getParameter(request, prefix + "bkg_ipc_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrlRfFlg(JSPUtil.getParameter(request, prefix + "ctrl_rf_flg", ""));
		setCostMon(JSPUtil.getParameter(request, prefix + "cost_mon", ""));
		setLodRf(JSPUtil.getParameter(request, prefix + "lod_rf", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setAlIpcWgt(JSPUtil.getParameter(request, prefix + "al_ipc_wgt", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, prefix + "lst_lodg_port_cd", ""));
		setLodVol(JSPUtil.getParameter(request, prefix + "lod_vol", ""));
		setAlIpcVol(JSPUtil.getParameter(request, prefix + "al_ipc_vol", ""));
		setMtyGnte(JSPUtil.getParameter(request, prefix + "mty_gnte", ""));
		setFcOcnVol(JSPUtil.getParameter(request, prefix + "fc_ocn_vol", ""));
		setBsaVol(JSPUtil.getParameter(request, prefix + "bsa_vol", ""));
		setFcOcnWgt(JSPUtil.getParameter(request, prefix + "fc_ocn_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCtrlSpcFlg(JSPUtil.getParameter(request, prefix + "ctrl_spc_flg", ""));
		setBkgIpcVol(JSPUtil.getParameter(request, prefix + "bkg_ipc_vol", ""));
		setCtrl45ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_45ft_hc_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFdVol(JSPUtil.getParameter(request, prefix + "fd_vol", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "lst_lodg_port_etd_dt", ""));
		setEpVol(JSPUtil.getParameter(request, prefix + "ep_vol", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setLodWgt(JSPUtil.getParameter(request, prefix + "lod_wgt", ""));
		setBkgOcnWgt(JSPUtil.getParameter(request, prefix + "bkg_ocn_wgt", ""));
		setCtrl53ftFlg(JSPUtil.getParameter(request, prefix + "ctrl_53ft_flg", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setLod45(JSPUtil.getParameter(request, prefix + "lod_45", ""));
		setQtaOcn(JSPUtil.getParameter(request, prefix + "qta_ocn", ""));
		setBkgOcnVol(JSPUtil.getParameter(request, prefix + "bkg_ocn_vol", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setQtaIpc(JSPUtil.getParameter(request, prefix + "qta_ipc", ""));
		
		setQtaIpc(JSPUtil.getParameter(request, prefix + "fc_ts_vol", ""));
		setQtaIpc(JSPUtil.getParameter(request, prefix + "fc_ts_wgt", ""));
		setQtaIpc(JSPUtil.getParameter(request, prefix + "al_ts_vol", ""));
		setQtaIpc(JSPUtil.getParameter(request, prefix + "al_ts_wgt", ""));
		setQtaIpc(JSPUtil.getParameter(request, prefix + "bkg_ts_vol", ""));
		setQtaIpc(JSPUtil.getParameter(request, prefix + "bkg_ts_wgt", ""));		
		setCmOp(JSPUtil.getParameter(request, prefix + "cm_op", ""));
		setCmOc(JSPUtil.getParameter(request, prefix + "cm_oc", ""));
		setCmVl(JSPUtil.getParameter(request, prefix + "cm_vl", ""));		
		setAcct(JSPUtil.getParameter(request, prefix + "acct", ""));
		
		setCtrlD2Flg(JSPUtil.getParameter(request, prefix + "ctrl_d2_flg", ""));
		setCtrlD4Flg(JSPUtil.getParameter(request, prefix + "ctrl_d4_flg", ""));
		setCtrlRdFlg(JSPUtil.getParameter(request, prefix + "ctrl_rd_flg", ""));
		
		setCtrlEccFlg(JSPUtil.getParameter(request, prefix + "ctrl_ecc_flg", ""));
		setCtrlLocFlg(JSPUtil.getParameter(request, prefix + "ctrl_loc_flg", ""));
		setCtrlUsaSvcModFlg(JSPUtil.getParameter(request, prefix + "ctrl_usa_svc_mod_flg", ""));
		setCtrlAcctFlg(JSPUtil.getParameter(request, prefix + "ctrl_acct_flg", ""));
		setCtrlDestLvlCd(JSPUtil.getParameter(request, prefix + "ctrl_dest_lvl_cd", ""));
		
		setBkgBsVol(JSPUtil.getParameter(request, prefix + "bkg_bs_vol", ""));
		setBkgBsWgt(JSPUtil.getParameter(request, prefix + "bkg_bs_wgt", ""));
		
		setCtrlFxRtFlg(JSPUtil.getParameter(request, prefix + "ctrl_fx_rt_flg", ""));
		setBkgWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_wgt_vgm", ""));
		setBkgIpcWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_ipc_wgt_vgm", ""));
		setBkgOcnWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_ocn_wgt_vgm", ""));
		setBkgTsWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_ts_wgt_vgm", ""));
		setBkgVolVgm(JSPUtil.getParameter(request, prefix + "bkg_vol_vgm", ""));
		setBkgIpcVolVgm(JSPUtil.getParameter(request, prefix + "bkg_ipc_vol_vgm", ""));
		setBkgOcnVolVgm(JSPUtil.getParameter(request, prefix + "bkg_ocn_vol_vgm", ""));
		setBkgTsVolVgm(JSPUtil.getParameter(request, prefix + "bkg_ts_vol_vgm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocation0047MasterListVO[]
	 */
	public SearchSpaceAllocation0047MasterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocation0047MasterListVO[]
	 */
	public SearchSpaceAllocation0047MasterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocation0047MasterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrlPortFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_port_flg", length));
			String[] alOcnVol = (JSPUtil.getParameter(request, prefix	+ "al_ocn_vol", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fdWgt = (JSPUtil.getParameter(request, prefix	+ "fd_wgt", length));
			String[] ctrl40ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_40ft_hc_flg", length));
			String[] fcIpcVol = (JSPUtil.getParameter(request, prefix	+ "fc_ipc_vol", length));
			String[] lodHc = (JSPUtil.getParameter(request, prefix	+ "lod_hc", length));
			String[] fcIpcWgt = (JSPUtil.getParameter(request, prefix	+ "fc_ipc_wgt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bsaWgt = (JSPUtil.getParameter(request, prefix	+ "bsa_wgt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ctrlWgtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_wgt_flg", length));
			String[] alOcnWgt = (JSPUtil.getParameter(request, prefix	+ "al_ocn_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgIpcWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ipc_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrlRfFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rf_flg", length));
			String[] costMon = (JSPUtil.getParameter(request, prefix	+ "cost_mon", length));
			String[] lodRf = (JSPUtil.getParameter(request, prefix	+ "lod_rf", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] alIpcWgt = (JSPUtil.getParameter(request, prefix	+ "al_ipc_wgt", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] lodVol = (JSPUtil.getParameter(request, prefix	+ "lod_vol", length));
			String[] alIpcVol = (JSPUtil.getParameter(request, prefix	+ "al_ipc_vol", length));
			String[] mtyGnte = (JSPUtil.getParameter(request, prefix	+ "mty_gnte", length));
			String[] fcOcnVol = (JSPUtil.getParameter(request, prefix	+ "fc_ocn_vol", length));
			String[] bsaVol = (JSPUtil.getParameter(request, prefix	+ "bsa_vol", length));
			String[] fcOcnWgt = (JSPUtil.getParameter(request, prefix	+ "fc_ocn_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ctrlSpcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_spc_flg", length));
			String[] bkgIpcVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ipc_vol", length));
			String[] ctrl45ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_45ft_hc_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fdVol = (JSPUtil.getParameter(request, prefix	+ "fd_vol", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] epVol = (JSPUtil.getParameter(request, prefix	+ "ep_vol", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] lodWgt = (JSPUtil.getParameter(request, prefix	+ "lod_wgt", length));
			String[] bkgOcnWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ocn_wgt", length));
			String[] ctrl53ftFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_53ft_flg", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] lod45 = (JSPUtil.getParameter(request, prefix	+ "lod_45", length));
			String[] qtaOcn = (JSPUtil.getParameter(request, prefix	+ "qta_ocn", length));
			String[] bkgOcnVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ocn_vol", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] qtaIpc = (JSPUtil.getParameter(request, prefix	+ "qta_ipc", length));
			
			String[] fcTsVol = (JSPUtil.getParameter(request, prefix	+ "fc_ts_vol", length));
			String[] fcTsWgt= (JSPUtil.getParameter(request, prefix	+ "fc_ts_wgt", length));
			String[] alTsVol = (JSPUtil.getParameter(request, prefix	+ "al_ts_vol", length));
			String[] alTsWgt = (JSPUtil.getParameter(request, prefix	+ "al_ts_wgt", length));
			String[] bkgTsVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_vol", length));
			String[] bkgTsWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_wgt", length));			
			String[] cmOp = (JSPUtil.getParameter(request, prefix	+ "cm_op", length));
			String[] cmOc = (JSPUtil.getParameter(request, prefix	+ "cm_oc", length));
			String[] cmVl = (JSPUtil.getParameter(request, prefix	+ "cm_vl", length));			
			String[] acct = (JSPUtil.getParameter(request, prefix	+ "acct", length));	
			
			String[] ctrlD2Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d2_flg", length));
			String[] ctrlD4Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d4_flg", length));
			String[] ctrlRdFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rd_flg", length));
			
			String[] ctrlEccFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ecc_flg", length));
			String[] ctrlLocFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_loc_flg", length));
			String[] ctrlUsaSvcModFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_usa_svc_mod_flg", length));
			String[] ctrlAcctFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_acct_flg", length));
			String[] ctrlDestLvlCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_dest_lvl_cd", length));
			
			String[] bkgBsVol = (JSPUtil.getParameter(request, prefix	+ "bkg_bs_vol", length));
			String[] bkgBsWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_bs_wgt", length));
			String[] ctrlFxRtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_fx_rt_flg", length));
			String[] bkgWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_vgm", length));
			String[] bkgIpcWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ipc_wgt_vgm", length));
			String[] bkgOcnWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ocn_wgt_vgm", length));
			String[] bkgTsWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_wgt_vgm", length));
			String[] bkgVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_vgm", length));
			String[] bkgIpcVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ipc_vol_vgm", length));
			String[] bkgOcnVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ocn_vol_vgm", length));
			String[] bkgTsVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_vol_vgm", length));	
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0047MasterListVO();
				if (ctrlPortFlg[i] != null)
					model.setCtrlPortFlg(ctrlPortFlg[i]);
				if (alOcnVol[i] != null)
					model.setAlOcnVol(alOcnVol[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fdWgt[i] != null)
					model.setFdWgt(fdWgt[i]);
				if (ctrl40ftHcFlg[i] != null)
					model.setCtrl40ftHcFlg(ctrl40ftHcFlg[i]);
				if (fcIpcVol[i] != null)
					model.setFcIpcVol(fcIpcVol[i]);
				if (lodHc[i] != null)
					model.setLodHc(lodHc[i]);
				if (fcIpcWgt[i] != null)
					model.setFcIpcWgt(fcIpcWgt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bsaWgt[i] != null)
					model.setBsaWgt(bsaWgt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ctrlWgtFlg[i] != null)
					model.setCtrlWgtFlg(ctrlWgtFlg[i]);
				if (alOcnWgt[i] != null)
					model.setAlOcnWgt(alOcnWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgIpcWgt[i] != null)
					model.setBkgIpcWgt(bkgIpcWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrlRfFlg[i] != null)
					model.setCtrlRfFlg(ctrlRfFlg[i]);
				if (costMon[i] != null)
					model.setCostMon(costMon[i]);
				if (lodRf[i] != null)
					model.setLodRf(lodRf[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (alIpcWgt[i] != null)
					model.setAlIpcWgt(alIpcWgt[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				if (lodVol[i] != null)
					model.setLodVol(lodVol[i]);
				if (alIpcVol[i] != null)
					model.setAlIpcVol(alIpcVol[i]);
				if (mtyGnte[i] != null)
					model.setMtyGnte(mtyGnte[i]);
				if (fcOcnVol[i] != null)
					model.setFcOcnVol(fcOcnVol[i]);
				if (bsaVol[i] != null)
					model.setBsaVol(bsaVol[i]);
				if (fcOcnWgt[i] != null)
					model.setFcOcnWgt(fcOcnWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ctrlSpcFlg[i] != null)
					model.setCtrlSpcFlg(ctrlSpcFlg[i]);
				if (bkgIpcVol[i] != null)
					model.setBkgIpcVol(bkgIpcVol[i]);
				if (ctrl45ftHcFlg[i] != null)
					model.setCtrl45ftHcFlg(ctrl45ftHcFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fdVol[i] != null)
					model.setFdVol(fdVol[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (epVol[i] != null)
					model.setEpVol(epVol[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (lodWgt[i] != null)
					model.setLodWgt(lodWgt[i]);
				if (bkgOcnWgt[i] != null)
					model.setBkgOcnWgt(bkgOcnWgt[i]);
				if (ctrl53ftFlg[i] != null)
					model.setCtrl53ftFlg(ctrl53ftFlg[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (lod45[i] != null)
					model.setLod45(lod45[i]);
				if (qtaOcn[i] != null)
					model.setQtaOcn(qtaOcn[i]);
				if (bkgOcnVol[i] != null)
					model.setBkgOcnVol(bkgOcnVol[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (qtaIpc[i] != null)
					model.setQtaIpc(qtaIpc[i]);
				
				if (fcTsVol[i] != null)
					model.setFcTsVol(fcTsVol[i]);
				if (fcTsWgt[i] != null)
					model.setFcTsWgt(fcTsWgt[i]);
				if (alTsVol[i] != null)
					model.setAlTsVol(alTsVol[i]);
				if (alTsWgt[i] != null)
					model.setAlTsWgt(alTsWgt[i]);
				if (bkgTsVol[i] != null)
					model.setBkgTsVol(bkgTsVol[i]);
				if (bkgTsWgt[i] != null)
					model.setBkgTsWgt(bkgTsWgt[i]);					
				if (cmOp[i] != null)
					model.setCmOp(cmOp[i]);
				if (cmOc[i] != null)
					model.setCmOc(cmOc[i]);
				if (cmVl[i] != null)
					model.setCmVl(cmVl[i]);					
				if (acct[i] != null)
					model.setAcct(acct[i]);	
				
				if (ctrlD2Flg[i] != null)
					model.setCtrlD2Flg(ctrlD2Flg[i]);				
				if (ctrlD4Flg[i] != null)
					model.setCtrlD4Flg(ctrlD4Flg[i]);					
				if (ctrlRdFlg[i] != null)
					model.setCtrlRdFlg(ctrlRdFlg[i]);	
				
				if (ctrlEccFlg[i] != null)
					model.setCtrlEccFlg(ctrlEccFlg[i]);				
				if (ctrlLocFlg[i] != null)
					model.setCtrlLocFlg(ctrlLocFlg[i]);					
				if (ctrlUsaSvcModFlg[i] != null)
					model.setCtrlUsaSvcModFlg(ctrlUsaSvcModFlg[i]);
				if (ctrlAcctFlg[i] != null)
					model.setCtrlAcctFlg(ctrlAcctFlg[i]);				
				if (ctrlDestLvlCd[i] != null)
					model.setCtrlDestLvlCd(ctrlDestLvlCd[i]);
				
				if (bkgBsVol[i] != null)
					model.setBkgBsVol(bkgBsVol[i]);
				if (bkgBsWgt[i] != null)
					model.setBkgBsWgt(bkgBsWgt[i]);	
				if (ctrlFxRtFlg[i] != null) model.setCtrlFxRtFlg(ctrlFxRtFlg[i]);
				if (bkgWgtVgm[i] != null) model.setBkgWgtVgm(bkgWgtVgm[i]);
				if (bkgIpcWgtVgm[i] != null) model.setBkgIpcWgtVgm(bkgWgtVgm[i]);
				if (bkgOcnWgtVgm[i] != null) model.setBkgOcnWgtVgm(bkgWgtVgm[i]);
				if (bkgTsWgtVgm[i] != null) model.setBkgTsWgtVgm(bkgWgtVgm[i]);
				if (bkgVolVgm[i] != null) model.setBkgVolVgm(bkgVolVgm[i]);
				if (bkgIpcVolVgm[i] != null) model.setBkgIpcVolVgm(bkgIpcVolVgm[i]);
				if (bkgOcnVolVgm[i] != null) model.setBkgOcnVolVgm(bkgOcnVolVgm[i]);
				if (bkgTsVolVgm[i] != null) model.setBkgTsVolVgm(bkgTsVolVgm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocation0047MasterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocation0047MasterListVO[]
	 */
	public SearchSpaceAllocation0047MasterListVO[] getSearchSpaceAllocation0047MasterListVOs(){
		SearchSpaceAllocation0047MasterListVO[] vos = (SearchSpaceAllocation0047MasterListVO[])models.toArray(new SearchSpaceAllocation0047MasterListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ctrlPortFlg = this.ctrlPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alOcnVol = this.alOcnVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdWgt = this.fdWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl40ftHcFlg = this.ctrl40ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcIpcVol = this.fcIpcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodHc = this.lodHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcIpcWgt = this.fcIpcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaWgt = this.bsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlWgtFlg = this.ctrlWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alOcnWgt = this.alOcnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIpcWgt = this.bkgIpcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRfFlg = this.ctrlRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMon = this.costMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodRf = this.lodRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alIpcWgt = this.alIpcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodVol = this.lodVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alIpcVol = this.alIpcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyGnte = this.mtyGnte .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcOcnVol = this.fcOcnVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaVol = this.bsaVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcOcnWgt = this.fcOcnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlSpcFlg = this.ctrlSpcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIpcVol = this.bkgIpcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl45ftHcFlg = this.ctrl45ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdVol = this.fdVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.epVol = this.epVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodWgt = this.lodWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOcnWgt = this.bkgOcnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl53ftFlg = this.ctrl53ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lod45 = this.lod45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaOcn = this.qtaOcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOcnVol = this.bkgOcnVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaIpc = this.qtaIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.fcTsVol = this.fcTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTsWgt = this.fcTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alTsVol = this.alTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alTsWgt = this.alTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsVol = this.bkgTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsWgt = this.bkgTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.cmOp = this.cmOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc = this.cmOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl = this.cmVl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.acct = this.acct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		
		this.ctrlD2Flg = this.ctrlD2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD4Flg = this.ctrlD4Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRdFlg = this.ctrlRdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.ctrlEccFlg = this.ctrlEccFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLocFlg = this.ctrlLocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUsaSvcModFlg = this.ctrlUsaSvcModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAcctFlg = this.ctrlAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlDestLvlCd = this.ctrlDestLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.bkgBsVol = this.bkgBsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBsWgt = this.bkgBsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlFxRtFlg = this.ctrlFxRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtVgm = this.bkgWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIpcWgtVgm = this.bkgIpcWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOcnWgtVgm = this.bkgOcnWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsWgtVgm = this.bkgTsWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVolVgm = this.bkgVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgIpcVolVgm = this.bkgIpcVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgOcnVolVgm = this.bkgOcnVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgTsVolVgm = this.bkgTsVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
