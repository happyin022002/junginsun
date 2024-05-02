/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpaceControlInquiryOfficeListVO.java
*@FileTitle : SearchSpaceControlInquiryOfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.12 한상훈 
* 1.0 Creation
* 2011.07.05 김종준 [CHM-201111880-01]  control by HO 화면 보완 - IPC, TS 관련 fctTcWgt,alcTsVol,alcTsWgt,bkgTsVol,bkgTsWgt 필드추가 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiryOfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryOfficeListVO> models = new ArrayList<SearchSpaceControlInquiryOfficeListVO>();
	
	/* Column Info */
	private String fctWgt = null;
	/* Column Info */
	private String bkgWait = null;
	/* Column Info */
	private String qtaVol = null;
	/* Column Info */
	private String fctVol = null;
	/* Column Info */
	private String alcVol = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgWgt = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String alcWgt = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String bkgFirm = null;
	/* Column Info */
	private String alcTs = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String qtaCmb = null;
	/* Column Info */
	private String bkgVol = null;
	/* Column Info */
	private String subTrdCd = null;

	/* Column Info */
	private String fctTcVol = null;
	/* Column Info */
	private String fctTcWgt = null;
	/* Column Info */
	private String alcTsVol = null;
	/* Column Info */
	private String alcTsWgt = null;
	/* Column Info */
	private String bkgTsVol = null;
	/* Column Info */
	private String bkgTsWgt = null;
	/* Column Info */
	private String bkgWgtVgm = null;
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
	
	public SearchSpaceControlInquiryOfficeListVO() {}

	public SearchSpaceControlInquiryOfficeListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String costYr, String costWk, String vvd, String qtaVol, String qtaCmb, String fctVol, String fctWgt, String alcVol, String alcWgt, String alcTs, String bkgFirm, String bkgWait, String bkgVol, String bkgWgt, String ratio    , String fctTcVol, String fctTcWgt, String alcTsVol, String alcTsWgt, String bkgTsVol, String bkgTsWgt
	,String bkgWgtVgm,String bkgTsWgtVgm,String bkgVolVgm,String bkgIpcVolVgm,String bkgOcnVolVgm,String bkgTsVolVgm) {
		this.fctWgt = fctWgt;
		this.bkgWait = bkgWait;
		this.qtaVol = qtaVol;
		this.fctVol = fctVol;
		this.alcVol = alcVol;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.bkgWgt = bkgWgt;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.alcWgt = alcWgt;
		this.ratio = ratio;
		this.costYr = costYr;
		this.costWk = costWk;
		this.bkgFirm = bkgFirm;
		this.alcTs = alcTs;
		this.dirCd = dirCd;
		this.qtaCmb = qtaCmb;
		this.bkgVol = bkgVol;
		this.subTrdCd = subTrdCd;
		
		this.fctTcVol = fctTcVol;
		this.fctTcWgt = fctTcWgt;
		this.alcTsVol = alcTsVol;
		this.alcTsWgt = alcTsWgt;
		this.bkgTsVol = bkgTsVol;
		this.bkgTsWgt = bkgTsWgt;
		this.bkgWgtVgm = bkgWgtVgm;
		this.bkgTsWgtVgm = bkgTsWgtVgm;
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
		this.hashColumns.put("fct_wgt", getFctWgt());
		this.hashColumns.put("bkg_wait", getBkgWait());
		this.hashColumns.put("qta_vol", getQtaVol());
		this.hashColumns.put("fct_vol", getFctVol());
		this.hashColumns.put("alc_vol", getAlcVol());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_wgt", getBkgWgt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("alc_wgt", getAlcWgt());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("bkg_firm", getBkgFirm());
		this.hashColumns.put("alc_ts", getAlcTs());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("qta_cmb", getQtaCmb());
		this.hashColumns.put("bkg_vol", getBkgVol());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());

		this.hashColumns.put("fct_tc_vol", getFctTcVol());
		this.hashColumns.put("fct_tc_wgt", getFctTcWgt());
		this.hashColumns.put("alc_ts_vol", getAlcTsVol());
		this.hashColumns.put("alc_ts_wgt", getAlcTsWgt());
		this.hashColumns.put("bkg_ts_vol", getBkgTsVol());
		this.hashColumns.put("bkg_ts_wgt", getBkgTsWgt());
		this.hashColumns.put("bkg_wgt_vgm", getBkgWgtVgm());
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
		this.hashFields.put("fct_wgt", "fctWgt");
		this.hashFields.put("bkg_wait", "bkgWait");
		this.hashFields.put("qta_vol", "qtaVol");
		this.hashFields.put("fct_vol", "fctVol");
		this.hashFields.put("alc_vol", "alcVol");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_wgt", "bkgWgt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("alc_wgt", "alcWgt");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("bkg_firm", "bkgFirm");
		this.hashFields.put("alc_ts", "alcTs");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("qta_cmb", "qtaCmb");
		this.hashFields.put("bkg_vol", "bkgVol");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		
		this.hashFields.put("fct_tc_vol", "fctTcVol");
		this.hashFields.put("fct_tc_wgt", "fctTcWgt");
		this.hashFields.put("alc_ts_vol", "alcTsVol");
		this.hashFields.put("alc_ts_wgt", "alcTsWgt");
		this.hashFields.put("bkg_ts_vol", "bkgTsVol");
		this.hashFields.put("bkg_ts_wgt", "bkgTsWgt");		
		this.hashFields.put("bkg_wgt_vgm", "bkgWgtVgm");
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
	 * @return bkgTsWgtVgm			
	 */			
	public String getBkgTsWgtVgm() {
		return bkgTsWgtVgm;
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
	 * @return fctWgt
	 */
	public String getFctWgt() {
		return this.fctWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgWait
	 */
	public String getBkgWait() {
		return this.bkgWait;
	}
	
	/**
	 * Column Info
	 * @return qtaVol
	 */
	public String getQtaVol() {
		return this.qtaVol;
	}
	
	/**
	 * Column Info
	 * @return fctVol
	 */
	public String getFctVol() {
		return this.fctVol;
	}
	
	/**
	 * Column Info
	 * @return alcVol
	 */
	public String getAlcVol() {
		return this.alcVol;
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
	 * @return bkgWgt
	 */
	public String getBkgWgt() {
		return this.bkgWgt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return alcWgt
	 */
	public String getAlcWgt() {
		return this.alcWgt;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
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
	 * @return bkgFirm
	 */
	public String getBkgFirm() {
		return this.bkgFirm;
	}
	
	/**
	 * Column Info
	 * @return alcTs
	 */
	public String getAlcTs() {
		return this.alcTs;
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
	 * @return qtaCmb
	 */
	public String getQtaCmb() {
		return this.qtaCmb;
	}
	
	/**
	 * Column Info
	 * @return bkgVol
	 */
	public String getBkgVol() {
		return this.bkgVol;
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
	 * @return fctTcVol
	 */
	public String getFctTcVol() {
		return this.fctTcVol;
	}
	/**
	 * Column Info
	 * @return fctTcWgt
	 */
	public String getFctTcWgt() {
		return this.fctTcWgt;
	}
	/**
	 * Column Info
	 * @return alcTsVol
	 */
	public String getAlcTsVol() {
		return this.alcTsVol;
	}
	/**
	 * Column Info
	 * @return alcTsWgt
	 */
	public String getAlcTsWgt() {
		return this.alcTsWgt;
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
	 * @return bkgTsWgt
	 */
	public String getBkgTsWgt() {
		return this.bkgTsWgt;
	}
	
	/**
	 * Column Info
	 * @param fctWgt
	 */
	public void setFctWgt(String fctWgt) {
		this.fctWgt = fctWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgWait
	 */
	public void setBkgWait(String bkgWait) {
		this.bkgWait = bkgWait;
	}
	
	/**
	 * Column Info
	 * @param qtaVol
	 */
	public void setQtaVol(String qtaVol) {
		this.qtaVol = qtaVol;
	}
	
	/**
	 * Column Info
	 * @param fctVol
	 */
	public void setFctVol(String fctVol) {
		this.fctVol = fctVol;
	}
	
	/**
	 * Column Info
	 * @param alcVol
	 */
	public void setAlcVol(String alcVol) {
		this.alcVol = alcVol;
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
	 * @param bkgWgt
	 */
	public void setBkgWgt(String bkgWgt) {
		this.bkgWgt = bkgWgt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param alcWgt
	 */
	public void setAlcWgt(String alcWgt) {
		this.alcWgt = alcWgt;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
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
	 * @param bkgFirm
	 */
	public void setBkgFirm(String bkgFirm) {
		this.bkgFirm = bkgFirm;
	}
	
	/**
	 * Column Info
	 * @param alcTs
	 */
	public void setAlcTs(String alcTs) {
		this.alcTs = alcTs;
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
	 * @param qtaCmb
	 */
	public void setQtaCmb(String qtaCmb) {
		this.qtaCmb = qtaCmb;
	}
	
	/**
	 * Column Info
	 * @param bkgVol
	 */
	public void setBkgVol(String bkgVol) {
		this.bkgVol = bkgVol;
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
	 * @param fctTcVol
	 */
	public void setFctTcVol(String fctTcVol) {
		this.fctTcVol = fctTcVol;
	}	/**
	 * Column Info
	 * @param fctTcWgt
	 */
	public void setFctTcWgt(String fctTcWgt) {
		this.fctTcWgt = fctTcWgt;
	}	/**
	 * Column Info
	 * @param alcTsVol
	 */
	public void setAlcTsVol(String alcTsVol) {
		this.alcTsVol = alcTsVol;
	}	/**
	 * Column Info
	 * @param alcTsWgt
	 */
	public void setAlcTsWgt(String alcTsWgt) {
		this.alcTsWgt = alcTsWgt;
	}	/**
	 * Column Info
	 * @param bkgTsVol
	 */
	public void setBkgTsVol(String bkgTsVol) {
		this.bkgTsVol = bkgTsVol;
	}	/**
	 * Column Info
	 * @param bkgTsWgt
	 */
	public void setBkgTsWgt(String bkgTsWgt) {
		this.bkgTsWgt = bkgTsWgt;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFctWgt(JSPUtil.getParameter(request, "fct_wgt", ""));
		setBkgWait(JSPUtil.getParameter(request, "bkg_wait", ""));
		setQtaVol(JSPUtil.getParameter(request, "qta_vol", ""));
		setFctVol(JSPUtil.getParameter(request, "fct_vol", ""));
		setAlcVol(JSPUtil.getParameter(request, "alc_vol", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgWgt(JSPUtil.getParameter(request, "bkg_wgt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAlcWgt(JSPUtil.getParameter(request, "alc_wgt", ""));
		setRatio(JSPUtil.getParameter(request, "ratio", ""));
		setCostYr(JSPUtil.getParameter(request, "cost_yr", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setBkgFirm(JSPUtil.getParameter(request, "bkg_firm", ""));
		setAlcTs(JSPUtil.getParameter(request, "alc_ts", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setQtaCmb(JSPUtil.getParameter(request, "qta_cmb", ""));
		setBkgVol(JSPUtil.getParameter(request, "bkg_vol", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));

		setFctTcVol(JSPUtil.getParameter(request, "fct_tc_vol", ""));
		setFctTcWgt(JSPUtil.getParameter(request, "fct_tc_wgt", ""));
		setAlcTsVol(JSPUtil.getParameter(request, "alc_ts_vol", ""));
		setAlcTsWgt(JSPUtil.getParameter(request, "alc_ts_wgt", ""));
		setBkgTsVol(JSPUtil.getParameter(request, "bkg_ts_vol", ""));
		setBkgTsWgt(JSPUtil.getParameter(request, "bkg_ts_wgt", ""));
		setBkgWgtVgm(JSPUtil.getParameter(request, "bkg_wgt_vgm", ""));
		setBkgTsWgtVgm(JSPUtil.getParameter(request, "bkg_ts_wgt_vgm", ""));
		setBkgVolVgm(JSPUtil.getParameter(request,  "bkg_vol_vgm", ""));
		setBkgIpcVolVgm(JSPUtil.getParameter(request,  "bkg_ipc_vol_vgm", ""));
		setBkgOcnVolVgm(JSPUtil.getParameter(request,  "bkg_ocn_vol_vgm", ""));
		setBkgTsVolVgm(JSPUtil.getParameter(request,  "bkg_ts_vol_vgm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiryOfficeListVO[]
	 */
	public SearchSpaceControlInquiryOfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryOfficeListVO[]
	 */
	public SearchSpaceControlInquiryOfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryOfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fctWgt = (JSPUtil.getParameter(request, prefix	+ "fct_wgt", length));
			String[] bkgWait = (JSPUtil.getParameter(request, prefix	+ "bkg_wait", length));
			String[] qtaVol = (JSPUtil.getParameter(request, prefix	+ "qta_vol", length));
			String[] fctVol = (JSPUtil.getParameter(request, prefix	+ "fct_vol", length));
			String[] alcVol = (JSPUtil.getParameter(request, prefix	+ "alc_vol", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alcWgt = (JSPUtil.getParameter(request, prefix	+ "alc_wgt", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] bkgFirm = (JSPUtil.getParameter(request, prefix	+ "bkg_firm", length));
			String[] alcTs = (JSPUtil.getParameter(request, prefix	+ "alc_ts", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] qtaCmb = (JSPUtil.getParameter(request, prefix	+ "qta_cmb", length));
			String[] bkgVol = (JSPUtil.getParameter(request, prefix	+ "bkg_vol", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));

			String[] fctTcVol = (JSPUtil.getParameter(request, prefix	+ "fct_tc_vol", length));
			String[] fctTcWgt = (JSPUtil.getParameter(request, prefix	+ "fct_tc_wgt", length));
			String[] alcTsVol = (JSPUtil.getParameter(request, prefix	+ "alc_ts_vol", length));
			String[] alcTsWgt = (JSPUtil.getParameter(request, prefix	+ "alc_ts_wgt", length));
			String[] bkgTsVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_vol", length));
			String[] bkgTsWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_wgt", length));
			String[] bkgWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_vgm", length));
			String[] bkgTsWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_wgt_vgm", length));
			String[] bkgVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_vgm", length));
			String[] bkgIpcVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ipc_vol_vgm", length));
			String[] bkgOcnVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ocn_vol_vgm", length));
			String[] bkgTsVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_vol_vgm", length));	
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryOfficeListVO();
				if (fctWgt[i] != null)
					model.setFctWgt(fctWgt[i]);
				if (bkgWait[i] != null)
					model.setBkgWait(bkgWait[i]);
				if (qtaVol[i] != null)
					model.setQtaVol(qtaVol[i]);
				if (fctVol[i] != null)
					model.setFctVol(fctVol[i]);
				if (alcVol[i] != null)
					model.setAlcVol(alcVol[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgWgt[i] != null)
					model.setBkgWgt(bkgWgt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alcWgt[i] != null)
					model.setAlcWgt(alcWgt[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (bkgFirm[i] != null)
					model.setBkgFirm(bkgFirm[i]);
				if (alcTs[i] != null)
					model.setAlcTs(alcTs[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (qtaCmb[i] != null)
					model.setQtaCmb(qtaCmb[i]);
				if (bkgVol[i] != null)
					model.setBkgVol(bkgVol[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				
				if (fctTcVol[i] != null)
					model.setFctTcVol(fctTcVol[i]);
				if (fctTcWgt[i] != null)
					model.setFctTcWgt(fctTcWgt[i]);
				if (alcTsVol[i] != null)
					model.setAlcTsVol(alcTsVol[i]);
				if (alcTsWgt[i] != null)
					model.setAlcTsWgt(alcTsWgt[i]);
				if (bkgTsVol[i] != null)
					model.setBkgTsVol(bkgTsVol[i]);
				if (bkgTsWgt[i] != null)
					model.setBkgTsWgt(bkgTsWgt[i]);				
				if (bkgWgtVgm[i] != null) model.setBkgWgtVgm(bkgWgtVgm[i]);
				if (bkgTsWgtVgm[i] != null) model.setBkgWgtVgm(bkgTsWgtVgm[i]);
				if (bkgVolVgm[i] != null) model.setBkgVolVgm(bkgVolVgm[i]);
				if (bkgIpcVolVgm[i] != null) model.setBkgIpcVolVgm(bkgIpcVolVgm[i]);
				if (bkgOcnVolVgm[i] != null) model.setBkgOcnVolVgm(bkgOcnVolVgm[i]);
				if (bkgTsVolVgm[i] != null) model.setBkgTsVolVgm(bkgTsVolVgm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiryOfficeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryOfficeListVO[]
	 */
	public SearchSpaceControlInquiryOfficeListVO[] getSearchSpaceControlInquiryOfficeListVOs(){
		SearchSpaceControlInquiryOfficeListVO[] vos = (SearchSpaceControlInquiryOfficeListVO[])models.toArray(new SearchSpaceControlInquiryOfficeListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.fctWgt = this.fctWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWait = this.bkgWait .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaVol = this.qtaVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctVol = this.fctVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcVol = this.alcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgt = this.bkgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcWgt = this.alcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFirm = this.bkgFirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcTs = this.alcTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaCmb = this.qtaCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVol = this.bkgVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.fctTcVol = this.fctTcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctTcWgt = this.fctTcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcTsVol = this.alcTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcTsWgt = this.alcTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsVol = this.bkgTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsWgt = this.bkgTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtVgm = this.bkgWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsWgtVgm = this.bkgTsWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVolVgm = this.bkgVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgIpcVolVgm = this.bkgIpcVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgOcnVolVgm = this.bkgOcnVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgTsVolVgm = this.bkgTsVolVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
