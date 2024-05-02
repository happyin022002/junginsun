/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchSpaceAllocation0042MListVO.java
*@FileTitle : SearchSpaceAllocation0042MListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocation0042MListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0042MListVO> models = new ArrayList<SearchSpaceAllocation0042MListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String alOcnVol = null;
	/* Column Info */
	private String ctrlPortFlg = null;
	/* Column Info */
	private String ctrl40ftHcFlg = null;
	/* Column Info */
	private String lodHc = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fcIpcWgt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String alOcnWgt = null;
	/* Column Info */
	private String costMon = null;
	/* Column Info */
	private String alIpcWgt = null;
	/* Column Info */
	private String bkgTsVol = null;
	/* Column Info */
	private String lodVol = null;
	/* Column Info */
	private String mtyGnte = null;
	/* Column Info */
	private String bsaVol = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bkgIpcVol = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* Column Info */
	private String lodWgt = null;
	/* Column Info */
	private String ctrl53ftFlg = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String alTsVol = null;
	/* Column Info */
	private String qtaOcn = null;
	/* Column Info */
	private String lod45 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String qtaIpc = null;
	/* Column Info */
	private String fcTsVol = null;
	/* Column Info */
	private String fcIpcVol = null;
	/* Column Info */
	private String bsaWgt = null;
	/* Column Info */
	private String ctrlWgtFlg = null;
	/* Column Info */
	private String bkgIpcWgt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String alTsWgt = null;
	/* Column Info */
	private String lodRf = null;
	/* Column Info */
	private String ctrlRfFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String alIpcVol = null;
	/* Column Info */
	private String fcOcnVol = null;
	/* Column Info */
	private String bkgTsWgt = null;
	/* Column Info */
	private String fcOcnWgt = null;
	/* Column Info */
	private String ctrlSpcFlg = null;
	/* Column Info */
	private String ctrl45ftHcFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fcTsWgt = null;
	/* Column Info */
	private String bkgOcnWgt = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String bkgOcnVol = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceAllocation0042MListVO() {}

	public SearchSpaceAllocation0042MListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String costYr, String costMon, String costWk, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String bsaVol, String bsaWgt, String lodVol, String lodWgt, String lodHc, String lod45, String lodRf, String qtaOcn, String qtaIpc, String fcOcnVol, String fcOcnWgt, String fcIpcVol, String fcIpcWgt, String fcTsVol, String fcTsWgt, String alOcnVol, String alOcnWgt, String alIpcVol, String alIpcWgt, String alTsVol, String alTsWgt, String bkgOcnVol, String bkgOcnWgt, String bkgIpcVol, String bkgIpcWgt, String bkgTsVol, String bkgTsWgt, String lstLodgPortEtdDt, String lstLodgPortCd, String ctrlPortFlg, String ctrl40ftHcFlg, String ctrl45ftHcFlg, String ctrl53ftFlg, String ctrlRfFlg, String ctrlWgtFlg, String ctrlSpcFlg, String mtyGnte) {
		this.vslCd = vslCd;
		this.alOcnVol = alOcnVol;
		this.ctrlPortFlg = ctrlPortFlg;
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
		this.lodHc = lodHc;
		this.trdCd = trdCd;
		this.fcIpcWgt = fcIpcWgt;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.alOcnWgt = alOcnWgt;
		this.costMon = costMon;
		this.alIpcWgt = alIpcWgt;
		this.bkgTsVol = bkgTsVol;
		this.lodVol = lodVol;
		this.mtyGnte = mtyGnte;
		this.bsaVol = bsaVol;
		this.skdVoyNo = skdVoyNo;
		this.bkgIpcVol = bkgIpcVol;
		this.vvd = vvd;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.lodWgt = lodWgt;
		this.ctrl53ftFlg = ctrl53ftFlg;
		this.costWk = costWk;
		this.alTsVol = alTsVol;
		this.qtaOcn = qtaOcn;
		this.lod45 = lod45;
		this.subTrdCd = subTrdCd;
		this.qtaIpc = qtaIpc;
		this.fcTsVol = fcTsVol;
		this.fcIpcVol = fcIpcVol;
		this.bsaWgt = bsaWgt;
		this.ctrlWgtFlg = ctrlWgtFlg;
		this.bkgIpcWgt = bkgIpcWgt;
		this.ibflag = ibflag;
		this.alTsWgt = alTsWgt;
		this.lodRf = lodRf;
		this.ctrlRfFlg = ctrlRfFlg;
		this.dirCd = dirCd;
		this.lstLodgPortCd = lstLodgPortCd;
		this.alIpcVol = alIpcVol;
		this.fcOcnVol = fcOcnVol;
		this.bkgTsWgt = bkgTsWgt;
		this.fcOcnWgt = fcOcnWgt;
		this.ctrlSpcFlg = ctrlSpcFlg;
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
		this.skdDirCd = skdDirCd;
		this.fcTsWgt = fcTsWgt;
		this.bkgOcnWgt = bkgOcnWgt;
		this.costYr = costYr;
		this.bkgOcnVol = bkgOcnVol;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("al_ocn_vol", getAlOcnVol());
		this.hashColumns.put("ctrl_port_flg", getCtrlPortFlg());
		this.hashColumns.put("ctrl_40ft_hc_flg", getCtrl40ftHcFlg());
		this.hashColumns.put("lod_hc", getLodHc());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("fc_ipc_wgt", getFcIpcWgt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("al_ocn_wgt", getAlOcnWgt());
		this.hashColumns.put("cost_mon", getCostMon());
		this.hashColumns.put("al_ipc_wgt", getAlIpcWgt());
		this.hashColumns.put("bkg_ts_vol", getBkgTsVol());
		this.hashColumns.put("lod_vol", getLodVol());
		this.hashColumns.put("mty_gnte", getMtyGnte());
		this.hashColumns.put("bsa_vol", getBsaVol());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bkg_ipc_vol", getBkgIpcVol());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("lod_wgt", getLodWgt());
		this.hashColumns.put("ctrl_53ft_flg", getCtrl53ftFlg());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("al_ts_vol", getAlTsVol());
		this.hashColumns.put("qta_ocn", getQtaOcn());
		this.hashColumns.put("lod_45", getLod45());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("qta_ipc", getQtaIpc());
		this.hashColumns.put("fc_ts_vol", getFcTsVol());
		this.hashColumns.put("fc_ipc_vol", getFcIpcVol());
		this.hashColumns.put("bsa_wgt", getBsaWgt());
		this.hashColumns.put("ctrl_wgt_flg", getCtrlWgtFlg());
		this.hashColumns.put("bkg_ipc_wgt", getBkgIpcWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("al_ts_wgt", getAlTsWgt());
		this.hashColumns.put("lod_rf", getLodRf());
		this.hashColumns.put("ctrl_rf_flg", getCtrlRfFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("al_ipc_vol", getAlIpcVol());
		this.hashColumns.put("fc_ocn_vol", getFcOcnVol());
		this.hashColumns.put("bkg_ts_wgt", getBkgTsWgt());
		this.hashColumns.put("fc_ocn_wgt", getFcOcnWgt());
		this.hashColumns.put("ctrl_spc_flg", getCtrlSpcFlg());
		this.hashColumns.put("ctrl_45ft_hc_flg", getCtrl45ftHcFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fc_ts_wgt", getFcTsWgt());
		this.hashColumns.put("bkg_ocn_wgt", getBkgOcnWgt());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("bkg_ocn_vol", getBkgOcnVol());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("al_ocn_vol", "alOcnVol");
		this.hashFields.put("ctrl_port_flg", "ctrlPortFlg");
		this.hashFields.put("ctrl_40ft_hc_flg", "ctrl40ftHcFlg");
		this.hashFields.put("lod_hc", "lodHc");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("fc_ipc_wgt", "fcIpcWgt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("al_ocn_wgt", "alOcnWgt");
		this.hashFields.put("cost_mon", "costMon");
		this.hashFields.put("al_ipc_wgt", "alIpcWgt");
		this.hashFields.put("bkg_ts_vol", "bkgTsVol");
		this.hashFields.put("lod_vol", "lodVol");
		this.hashFields.put("mty_gnte", "mtyGnte");
		this.hashFields.put("bsa_vol", "bsaVol");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bkg_ipc_vol", "bkgIpcVol");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("lod_wgt", "lodWgt");
		this.hashFields.put("ctrl_53ft_flg", "ctrl53ftFlg");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("al_ts_vol", "alTsVol");
		this.hashFields.put("qta_ocn", "qtaOcn");
		this.hashFields.put("lod_45", "lod45");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("qta_ipc", "qtaIpc");
		this.hashFields.put("fc_ts_vol", "fcTsVol");
		this.hashFields.put("fc_ipc_vol", "fcIpcVol");
		this.hashFields.put("bsa_wgt", "bsaWgt");
		this.hashFields.put("ctrl_wgt_flg", "ctrlWgtFlg");
		this.hashFields.put("bkg_ipc_wgt", "bkgIpcWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("al_ts_wgt", "alTsWgt");
		this.hashFields.put("lod_rf", "lodRf");
		this.hashFields.put("ctrl_rf_flg", "ctrlRfFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("al_ipc_vol", "alIpcVol");
		this.hashFields.put("fc_ocn_vol", "fcOcnVol");
		this.hashFields.put("bkg_ts_wgt", "bkgTsWgt");
		this.hashFields.put("fc_ocn_wgt", "fcOcnWgt");
		this.hashFields.put("ctrl_spc_flg", "ctrlSpcFlg");
		this.hashFields.put("ctrl_45ft_hc_flg", "ctrl45ftHcFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fc_ts_wgt", "fcTsWgt");
		this.hashFields.put("bkg_ocn_wgt", "bkgOcnWgt");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("bkg_ocn_vol", "bkgOcnVol");
		return this.hashFields;
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
	 * @return alOcnVol
	 */
	public String getAlOcnVol() {
		return this.alOcnVol;
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
	 * @return ctrl40ftHcFlg
	 */
	public String getCtrl40ftHcFlg() {
		return this.ctrl40ftHcFlg;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return alOcnWgt
	 */
	public String getAlOcnWgt() {
		return this.alOcnWgt;
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
	 * @return alIpcWgt
	 */
	public String getAlIpcWgt() {
		return this.alIpcWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgTsVol
	 */
	public String getBkgTsVol() {
		return this.bkgTsVol;
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
	 * @return mtyGnte
	 */
	public String getMtyGnte() {
		return this.mtyGnte;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return lodWgt
	 */
	public String getLodWgt() {
		return this.lodWgt;
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
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return alTsVol
	 */
	public String getAlTsVol() {
		return this.alTsVol;
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
	 * @return lod45
	 */
	public String getLod45() {
		return this.lod45;
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
	
	/**
	 * Column Info
	 * @return fcTsVol
	 */
	public String getFcTsVol() {
		return this.fcTsVol;
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
	 * @return bsaWgt
	 */
	public String getBsaWgt() {
		return this.bsaWgt;
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
	 * @return alTsWgt
	 */
	public String getAlTsWgt() {
		return this.alTsWgt;
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
	 * @return ctrlRfFlg
	 */
	public String getCtrlRfFlg() {
		return this.ctrlRfFlg;
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
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
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
	 * @return fcOcnVol
	 */
	public String getFcOcnVol() {
		return this.fcOcnVol;
	}
	
	/**
	 * Column Info
	 * @return bkgTsWgt
	 */
	public String getBkgTsWgt() {
		return this.bkgTsWgt;
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
	 * @return ctrlSpcFlg
	 */
	public String getCtrlSpcFlg() {
		return this.ctrlSpcFlg;
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
	 * @return fcTsWgt
	 */
	public String getFcTsWgt() {
		return this.fcTsWgt;
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
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param ctrlPortFlg
	 */
	public void setCtrlPortFlg(String ctrlPortFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
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
	 * @param lodHc
	 */
	public void setLodHc(String lodHc) {
		this.lodHc = lodHc;
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
	 * @param fcIpcWgt
	 */
	public void setFcIpcWgt(String fcIpcWgt) {
		this.fcIpcWgt = fcIpcWgt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param alOcnWgt
	 */
	public void setAlOcnWgt(String alOcnWgt) {
		this.alOcnWgt = alOcnWgt;
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
	 * @param alIpcWgt
	 */
	public void setAlIpcWgt(String alIpcWgt) {
		this.alIpcWgt = alIpcWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgTsVol
	 */
	public void setBkgTsVol(String bkgTsVol) {
		this.bkgTsVol = bkgTsVol;
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
	 * @param mtyGnte
	 */
	public void setMtyGnte(String mtyGnte) {
		this.mtyGnte = mtyGnte;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param lodWgt
	 */
	public void setLodWgt(String lodWgt) {
		this.lodWgt = lodWgt;
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
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param alTsVol
	 */
	public void setAlTsVol(String alTsVol) {
		this.alTsVol = alTsVol;
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
	 * @param lod45
	 */
	public void setLod45(String lod45) {
		this.lod45 = lod45;
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
	
	/**
	 * Column Info
	 * @param fcTsVol
	 */
	public void setFcTsVol(String fcTsVol) {
		this.fcTsVol = fcTsVol;
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
	 * @param bsaWgt
	 */
	public void setBsaWgt(String bsaWgt) {
		this.bsaWgt = bsaWgt;
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
	 * @param alTsWgt
	 */
	public void setAlTsWgt(String alTsWgt) {
		this.alTsWgt = alTsWgt;
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
	 * @param ctrlRfFlg
	 */
	public void setCtrlRfFlg(String ctrlRfFlg) {
		this.ctrlRfFlg = ctrlRfFlg;
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
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
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
	 * @param fcOcnVol
	 */
	public void setFcOcnVol(String fcOcnVol) {
		this.fcOcnVol = fcOcnVol;
	}
	
	/**
	 * Column Info
	 * @param bkgTsWgt
	 */
	public void setBkgTsWgt(String bkgTsWgt) {
		this.bkgTsWgt = bkgTsWgt;
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
	 * @param ctrlSpcFlg
	 */
	public void setCtrlSpcFlg(String ctrlSpcFlg) {
		this.ctrlSpcFlg = ctrlSpcFlg;
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
	 * @param fcTsWgt
	 */
	public void setFcTsWgt(String fcTsWgt) {
		this.fcTsWgt = fcTsWgt;
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
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param bkgOcnVol
	 */
	public void setBkgOcnVol(String bkgOcnVol) {
		this.bkgOcnVol = bkgOcnVol;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAlOcnVol(JSPUtil.getParameter(request, prefix + "al_ocn_vol", ""));
		setCtrlPortFlg(JSPUtil.getParameter(request, prefix + "ctrl_port_flg", ""));
		setCtrl40ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_40ft_hc_flg", ""));
		setLodHc(JSPUtil.getParameter(request, prefix + "lod_hc", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFcIpcWgt(JSPUtil.getParameter(request, prefix + "fc_ipc_wgt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAlOcnWgt(JSPUtil.getParameter(request, prefix + "al_ocn_wgt", ""));
		setCostMon(JSPUtil.getParameter(request, prefix + "cost_mon", ""));
		setAlIpcWgt(JSPUtil.getParameter(request, prefix + "al_ipc_wgt", ""));
		setBkgTsVol(JSPUtil.getParameter(request, prefix + "bkg_ts_vol", ""));
		setLodVol(JSPUtil.getParameter(request, prefix + "lod_vol", ""));
		setMtyGnte(JSPUtil.getParameter(request, prefix + "mty_gnte", ""));
		setBsaVol(JSPUtil.getParameter(request, prefix + "bsa_vol", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBkgIpcVol(JSPUtil.getParameter(request, prefix + "bkg_ipc_vol", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "lst_lodg_port_etd_dt", ""));
		setLodWgt(JSPUtil.getParameter(request, prefix + "lod_wgt", ""));
		setCtrl53ftFlg(JSPUtil.getParameter(request, prefix + "ctrl_53ft_flg", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setAlTsVol(JSPUtil.getParameter(request, prefix + "al_ts_vol", ""));
		setQtaOcn(JSPUtil.getParameter(request, prefix + "qta_ocn", ""));
		setLod45(JSPUtil.getParameter(request, prefix + "lod_45", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setQtaIpc(JSPUtil.getParameter(request, prefix + "qta_ipc", ""));
		setFcTsVol(JSPUtil.getParameter(request, prefix + "fc_ts_vol", ""));
		setFcIpcVol(JSPUtil.getParameter(request, prefix + "fc_ipc_vol", ""));
		setBsaWgt(JSPUtil.getParameter(request, prefix + "bsa_wgt", ""));
		setCtrlWgtFlg(JSPUtil.getParameter(request, prefix + "ctrl_wgt_flg", ""));
		setBkgIpcWgt(JSPUtil.getParameter(request, prefix + "bkg_ipc_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAlTsWgt(JSPUtil.getParameter(request, prefix + "al_ts_wgt", ""));
		setLodRf(JSPUtil.getParameter(request, prefix + "lod_rf", ""));
		setCtrlRfFlg(JSPUtil.getParameter(request, prefix + "ctrl_rf_flg", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, prefix + "lst_lodg_port_cd", ""));
		setAlIpcVol(JSPUtil.getParameter(request, prefix + "al_ipc_vol", ""));
		setFcOcnVol(JSPUtil.getParameter(request, prefix + "fc_ocn_vol", ""));
		setBkgTsWgt(JSPUtil.getParameter(request, prefix + "bkg_ts_wgt", ""));
		setFcOcnWgt(JSPUtil.getParameter(request, prefix + "fc_ocn_wgt", ""));
		setCtrlSpcFlg(JSPUtil.getParameter(request, prefix + "ctrl_spc_flg", ""));
		setCtrl45ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_45ft_hc_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFcTsWgt(JSPUtil.getParameter(request, prefix + "fc_ts_wgt", ""));
		setBkgOcnWgt(JSPUtil.getParameter(request, prefix + "bkg_ocn_wgt", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setBkgOcnVol(JSPUtil.getParameter(request, prefix + "bkg_ocn_vol", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocation0042MListVO[]
	 */
	public SearchSpaceAllocation0042MListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocation0042MListVO[]
	 */
	public SearchSpaceAllocation0042MListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocation0042MListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] alOcnVol = (JSPUtil.getParameter(request, prefix	+ "al_ocn_vol", length));
			String[] ctrlPortFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_port_flg", length));
			String[] ctrl40ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_40ft_hc_flg", length));
			String[] lodHc = (JSPUtil.getParameter(request, prefix	+ "lod_hc", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fcIpcWgt = (JSPUtil.getParameter(request, prefix	+ "fc_ipc_wgt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] alOcnWgt = (JSPUtil.getParameter(request, prefix	+ "al_ocn_wgt", length));
			String[] costMon = (JSPUtil.getParameter(request, prefix	+ "cost_mon", length));
			String[] alIpcWgt = (JSPUtil.getParameter(request, prefix	+ "al_ipc_wgt", length));
			String[] bkgTsVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_vol", length));
			String[] lodVol = (JSPUtil.getParameter(request, prefix	+ "lod_vol", length));
			String[] mtyGnte = (JSPUtil.getParameter(request, prefix	+ "mty_gnte", length));
			String[] bsaVol = (JSPUtil.getParameter(request, prefix	+ "bsa_vol", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bkgIpcVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ipc_vol", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] lodWgt = (JSPUtil.getParameter(request, prefix	+ "lod_wgt", length));
			String[] ctrl53ftFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_53ft_flg", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] alTsVol = (JSPUtil.getParameter(request, prefix	+ "al_ts_vol", length));
			String[] qtaOcn = (JSPUtil.getParameter(request, prefix	+ "qta_ocn", length));
			String[] lod45 = (JSPUtil.getParameter(request, prefix	+ "lod_45", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] qtaIpc = (JSPUtil.getParameter(request, prefix	+ "qta_ipc", length));
			String[] fcTsVol = (JSPUtil.getParameter(request, prefix	+ "fc_ts_vol", length));
			String[] fcIpcVol = (JSPUtil.getParameter(request, prefix	+ "fc_ipc_vol", length));
			String[] bsaWgt = (JSPUtil.getParameter(request, prefix	+ "bsa_wgt", length));
			String[] ctrlWgtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_wgt_flg", length));
			String[] bkgIpcWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ipc_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alTsWgt = (JSPUtil.getParameter(request, prefix	+ "al_ts_wgt", length));
			String[] lodRf = (JSPUtil.getParameter(request, prefix	+ "lod_rf", length));
			String[] ctrlRfFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rf_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] alIpcVol = (JSPUtil.getParameter(request, prefix	+ "al_ipc_vol", length));
			String[] fcOcnVol = (JSPUtil.getParameter(request, prefix	+ "fc_ocn_vol", length));
			String[] bkgTsWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_wgt", length));
			String[] fcOcnWgt = (JSPUtil.getParameter(request, prefix	+ "fc_ocn_wgt", length));
			String[] ctrlSpcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_spc_flg", length));
			String[] ctrl45ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_45ft_hc_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fcTsWgt = (JSPUtil.getParameter(request, prefix	+ "fc_ts_wgt", length));
			String[] bkgOcnWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ocn_wgt", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] bkgOcnVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ocn_vol", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0042MListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (alOcnVol[i] != null)
					model.setAlOcnVol(alOcnVol[i]);
				if (ctrlPortFlg[i] != null)
					model.setCtrlPortFlg(ctrlPortFlg[i]);
				if (ctrl40ftHcFlg[i] != null)
					model.setCtrl40ftHcFlg(ctrl40ftHcFlg[i]);
				if (lodHc[i] != null)
					model.setLodHc(lodHc[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fcIpcWgt[i] != null)
					model.setFcIpcWgt(fcIpcWgt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (alOcnWgt[i] != null)
					model.setAlOcnWgt(alOcnWgt[i]);
				if (costMon[i] != null)
					model.setCostMon(costMon[i]);
				if (alIpcWgt[i] != null)
					model.setAlIpcWgt(alIpcWgt[i]);
				if (bkgTsVol[i] != null)
					model.setBkgTsVol(bkgTsVol[i]);
				if (lodVol[i] != null)
					model.setLodVol(lodVol[i]);
				if (mtyGnte[i] != null)
					model.setMtyGnte(mtyGnte[i]);
				if (bsaVol[i] != null)
					model.setBsaVol(bsaVol[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bkgIpcVol[i] != null)
					model.setBkgIpcVol(bkgIpcVol[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (lodWgt[i] != null)
					model.setLodWgt(lodWgt[i]);
				if (ctrl53ftFlg[i] != null)
					model.setCtrl53ftFlg(ctrl53ftFlg[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (alTsVol[i] != null)
					model.setAlTsVol(alTsVol[i]);
				if (qtaOcn[i] != null)
					model.setQtaOcn(qtaOcn[i]);
				if (lod45[i] != null)
					model.setLod45(lod45[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (qtaIpc[i] != null)
					model.setQtaIpc(qtaIpc[i]);
				if (fcTsVol[i] != null)
					model.setFcTsVol(fcTsVol[i]);
				if (fcIpcVol[i] != null)
					model.setFcIpcVol(fcIpcVol[i]);
				if (bsaWgt[i] != null)
					model.setBsaWgt(bsaWgt[i]);
				if (ctrlWgtFlg[i] != null)
					model.setCtrlWgtFlg(ctrlWgtFlg[i]);
				if (bkgIpcWgt[i] != null)
					model.setBkgIpcWgt(bkgIpcWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alTsWgt[i] != null)
					model.setAlTsWgt(alTsWgt[i]);
				if (lodRf[i] != null)
					model.setLodRf(lodRf[i]);
				if (ctrlRfFlg[i] != null)
					model.setCtrlRfFlg(ctrlRfFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				if (alIpcVol[i] != null)
					model.setAlIpcVol(alIpcVol[i]);
				if (fcOcnVol[i] != null)
					model.setFcOcnVol(fcOcnVol[i]);
				if (bkgTsWgt[i] != null)
					model.setBkgTsWgt(bkgTsWgt[i]);
				if (fcOcnWgt[i] != null)
					model.setFcOcnWgt(fcOcnWgt[i]);
				if (ctrlSpcFlg[i] != null)
					model.setCtrlSpcFlg(ctrlSpcFlg[i]);
				if (ctrl45ftHcFlg[i] != null)
					model.setCtrl45ftHcFlg(ctrl45ftHcFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fcTsWgt[i] != null)
					model.setFcTsWgt(fcTsWgt[i]);
				if (bkgOcnWgt[i] != null)
					model.setBkgOcnWgt(bkgOcnWgt[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (bkgOcnVol[i] != null)
					model.setBkgOcnVol(bkgOcnVol[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocation0042MListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocation0042MListVO[]
	 */
	public SearchSpaceAllocation0042MListVO[] getSearchSpaceAllocation0042MListVOs(){
		SearchSpaceAllocation0042MListVO[] vos = (SearchSpaceAllocation0042MListVO[])models.toArray(new SearchSpaceAllocation0042MListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alOcnVol = this.alOcnVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlPortFlg = this.ctrlPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl40ftHcFlg = this.ctrl40ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodHc = this.lodHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcIpcWgt = this.fcIpcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alOcnWgt = this.alOcnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMon = this.costMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alIpcWgt = this.alIpcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsVol = this.bkgTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodVol = this.lodVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyGnte = this.mtyGnte .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaVol = this.bsaVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIpcVol = this.bkgIpcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodWgt = this.lodWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl53ftFlg = this.ctrl53ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alTsVol = this.alTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaOcn = this.qtaOcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lod45 = this.lod45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaIpc = this.qtaIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTsVol = this.fcTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcIpcVol = this.fcIpcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaWgt = this.bsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlWgtFlg = this.ctrlWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIpcWgt = this.bkgIpcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alTsWgt = this.alTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodRf = this.lodRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRfFlg = this.ctrlRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alIpcVol = this.alIpcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcOcnVol = this.fcOcnVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsWgt = this.bkgTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcOcnWgt = this.fcOcnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlSpcFlg = this.ctrlSpcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl45ftHcFlg = this.ctrl45ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTsWgt = this.fcTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOcnWgt = this.bkgOcnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOcnVol = this.bkgOcnVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
