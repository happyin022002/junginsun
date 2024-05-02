/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopySplitBkgEtcVO.java
*@FileTitle : CopySplitBkgEtcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.15 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CopySplitBkgEtcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CopySplitBkgEtcVO> models = new ArrayList<CopySplitBkgEtcVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String stopOffLocCd = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String fdGrdFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String memosplitno = null;
	/* Column Info */
	private String hotDeFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String caflag = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String railBlkCd = null;
	/* Column Info */
	private String oldBkgNo = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String localtime = null;
	/* Column Info */
	private String splitreason = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bdrFlag = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String splitcount = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String partialflag = null;
	/* Column Info */
	private String spclHideFlg = null;
	/* Column Info */
	private String hngrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CopySplitBkgEtcVO() {}

	public CopySplitBkgEtcVO(String ibflag, String pagerows, String blNo, String tvvd, String porCd, String polCd, String podCd, String delCd, String stwgCd, String railBlkCd, String fdGrdFlg, String hngrFlg, String hotDeFlg, String prctFlg, String stopOffLocCd, String spclHideFlg, String remark, String splitreason, String splitcount, String localtime, String bdrFlag, String partialflag, String memosplitno, String bkgStsCd, String bkgCgoTpCd, String caflag, String oldBkgNo) {
		this.porCd = porCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.stopOffLocCd = stopOffLocCd;
		this.remark = remark;
		this.bkgStsCd = bkgStsCd;
		this.fdGrdFlg = fdGrdFlg;
		this.blNo = blNo;
		this.memosplitno = memosplitno;
		this.hotDeFlg = hotDeFlg;
		this.pagerows = pagerows;
		this.caflag = caflag;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.railBlkCd = railBlkCd;
		this.oldBkgNo = oldBkgNo;
		this.prctFlg = prctFlg;
		this.stwgCd = stwgCd;
		this.localtime = localtime;
		this.splitreason = splitreason;
		this.delCd = delCd;
		this.bdrFlag = bdrFlag;
		this.tvvd = tvvd;
		this.splitcount = splitcount;
		this.podCd = podCd;
		this.partialflag = partialflag;
		this.spclHideFlg = spclHideFlg;
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("stop_off_loc_cd", getStopOffLocCd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("memosplitno", getMemosplitno());
		this.hashColumns.put("hot_de_flg", getHotDeFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("caflag", getCaflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rail_blk_cd", getRailBlkCd());
		this.hashColumns.put("old_bkg_no", getOldBkgNo());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("localtime", getLocaltime());
		this.hashColumns.put("splitreason", getSplitreason());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bdr_flag", getBdrFlag());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("splitcount", getSplitcount());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("partialflag", getPartialflag());
		this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("stop_off_loc_cd", "stopOffLocCd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("fd_grd_flg", "fdGrdFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("memosplitno", "memosplitno");
		this.hashFields.put("hot_de_flg", "hotDeFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("caflag", "caflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rail_blk_cd", "railBlkCd");
		this.hashFields.put("old_bkg_no", "oldBkgNo");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("localtime", "localtime");
		this.hashFields.put("splitreason", "splitreason");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bdr_flag", "bdrFlag");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("splitcount", "splitcount");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("partialflag", "partialflag");
		this.hashFields.put("spcl_hide_flg", "spclHideFlg");
		this.hashFields.put("hngr_flg", "hngrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return stopOffLocCd
	 */
	public String getStopOffLocCd() {
		return this.stopOffLocCd;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return fdGrdFlg
	 */
	public String getFdGrdFlg() {
		return this.fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return memosplitno
	 */
	public String getMemosplitno() {
		return this.memosplitno;
	}
	
	/**
	 * Column Info
	 * @return hotDeFlg
	 */
	public String getHotDeFlg() {
		return this.hotDeFlg;
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
	 * @return caflag
	 */
	public String getCaflag() {
		return this.caflag;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return railBlkCd
	 */
	public String getRailBlkCd() {
		return this.railBlkCd;
	}
	
	/**
	 * Column Info
	 * @return oldBkgNo
	 */
	public String getOldBkgNo() {
		return this.oldBkgNo;
	}
	
	/**
	 * Column Info
	 * @return prctFlg
	 */
	public String getPrctFlg() {
		return this.prctFlg;
	}
	
	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}
	
	/**
	 * Column Info
	 * @return localtime
	 */
	public String getLocaltime() {
		return this.localtime;
	}
	
	/**
	 * Column Info
	 * @return splitreason
	 */
	public String getSplitreason() {
		return this.splitreason;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlag
	 */
	public String getBdrFlag() {
		return this.bdrFlag;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return splitcount
	 */
	public String getSplitcount() {
		return this.splitcount;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return partialflag
	 */
	public String getPartialflag() {
		return this.partialflag;
	}
	
	/**
	 * Column Info
	 * @return spclHideFlg
	 */
	public String getSpclHideFlg() {
		return this.spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param stopOffLocCd
	 */
	public void setStopOffLocCd(String stopOffLocCd) {
		this.stopOffLocCd = stopOffLocCd;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param fdGrdFlg
	 */
	public void setFdGrdFlg(String fdGrdFlg) {
		this.fdGrdFlg = fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param memosplitno
	 */
	public void setMemosplitno(String memosplitno) {
		this.memosplitno = memosplitno;
	}
	
	/**
	 * Column Info
	 * @param hotDeFlg
	 */
	public void setHotDeFlg(String hotDeFlg) {
		this.hotDeFlg = hotDeFlg;
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
	 * @param caflag
	 */
	public void setCaflag(String caflag) {
		this.caflag = caflag;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param railBlkCd
	 */
	public void setRailBlkCd(String railBlkCd) {
		this.railBlkCd = railBlkCd;
	}
	
	/**
	 * Column Info
	 * @param oldBkgNo
	 */
	public void setOldBkgNo(String oldBkgNo) {
		this.oldBkgNo = oldBkgNo;
	}
	
	/**
	 * Column Info
	 * @param prctFlg
	 */
	public void setPrctFlg(String prctFlg) {
		this.prctFlg = prctFlg;
	}
	
	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	/**
	 * Column Info
	 * @param localtime
	 */
	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}
	
	/**
	 * Column Info
	 * @param splitreason
	 */
	public void setSplitreason(String splitreason) {
		this.splitreason = splitreason;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlag
	 */
	public void setBdrFlag(String bdrFlag) {
		this.bdrFlag = bdrFlag;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param splitcount
	 */
	public void setSplitcount(String splitcount) {
		this.splitcount = splitcount;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param partialflag
	 */
	public void setPartialflag(String partialflag) {
		this.partialflag = partialflag;
	}
	
	/**
	 * Column Info
	 * @param spclHideFlg
	 */
	public void setSpclHideFlg(String spclHideFlg) {
		this.spclHideFlg = spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setStopOffLocCd(JSPUtil.getParameter(request, "stop_off_loc_cd", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setFdGrdFlg(JSPUtil.getParameter(request, "fd_grd_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMemosplitno(JSPUtil.getParameter(request, "memosplitno", ""));
		setHotDeFlg(JSPUtil.getParameter(request, "hot_de_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCaflag(JSPUtil.getParameter(request, "caflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRailBlkCd(JSPUtil.getParameter(request, "rail_blk_cd", ""));
		setOldBkgNo(JSPUtil.getParameter(request, "old_bkg_no", ""));
		setPrctFlg(JSPUtil.getParameter(request, "prct_flg", ""));
		setStwgCd(JSPUtil.getParameter(request, "stwg_cd", ""));
		setLocaltime(JSPUtil.getParameter(request, "localtime", ""));
		setSplitreason(JSPUtil.getParameter(request, "splitreason", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBdrFlag(JSPUtil.getParameter(request, "bdr_flag", ""));
		setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
		setSplitcount(JSPUtil.getParameter(request, "splitcount", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPartialflag(JSPUtil.getParameter(request, "partialflag", ""));
		setSpclHideFlg(JSPUtil.getParameter(request, "spcl_hide_flg", ""));
		setHngrFlg(JSPUtil.getParameter(request, "hngr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CopySplitBkgEtcVO[]
	 */
	public CopySplitBkgEtcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CopySplitBkgEtcVO[]
	 */
	public CopySplitBkgEtcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CopySplitBkgEtcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] stopOffLocCd = (JSPUtil.getParameter(request, prefix	+ "stop_off_loc_cd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix	+ "fd_grd_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] memosplitno = (JSPUtil.getParameter(request, prefix	+ "memosplitno", length));
			String[] hotDeFlg = (JSPUtil.getParameter(request, prefix	+ "hot_de_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] caflag = (JSPUtil.getParameter(request, prefix	+ "caflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] railBlkCd = (JSPUtil.getParameter(request, prefix	+ "rail_blk_cd", length));
			String[] oldBkgNo = (JSPUtil.getParameter(request, prefix	+ "old_bkg_no", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] localtime = (JSPUtil.getParameter(request, prefix	+ "localtime", length));
			String[] splitreason = (JSPUtil.getParameter(request, prefix	+ "splitreason", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bdrFlag = (JSPUtil.getParameter(request, prefix	+ "bdr_flag", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] splitcount = (JSPUtil.getParameter(request, prefix	+ "splitcount", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] partialflag = (JSPUtil.getParameter(request, prefix	+ "partialflag", length));
			String[] spclHideFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_hide_flg", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CopySplitBkgEtcVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (stopOffLocCd[i] != null)
					model.setStopOffLocCd(stopOffLocCd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (fdGrdFlg[i] != null)
					model.setFdGrdFlg(fdGrdFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (memosplitno[i] != null)
					model.setMemosplitno(memosplitno[i]);
				if (hotDeFlg[i] != null)
					model.setHotDeFlg(hotDeFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (caflag[i] != null)
					model.setCaflag(caflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (railBlkCd[i] != null)
					model.setRailBlkCd(railBlkCd[i]);
				if (oldBkgNo[i] != null)
					model.setOldBkgNo(oldBkgNo[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (localtime[i] != null)
					model.setLocaltime(localtime[i]);
				if (splitreason[i] != null)
					model.setSplitreason(splitreason[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bdrFlag[i] != null)
					model.setBdrFlag(bdrFlag[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (splitcount[i] != null)
					model.setSplitcount(splitcount[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (partialflag[i] != null)
					model.setPartialflag(partialflag[i]);
				if (spclHideFlg[i] != null)
					model.setSpclHideFlg(spclHideFlg[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCopySplitBkgEtcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CopySplitBkgEtcVO[]
	 */
	public CopySplitBkgEtcVO[] getCopySplitBkgEtcVOs(){
		CopySplitBkgEtcVO[] vos = (CopySplitBkgEtcVO[])models.toArray(new CopySplitBkgEtcVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopOffLocCd = this.stopOffLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdFlg = this.fdGrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.memosplitno = this.memosplitno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hotDeFlg = this.hotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caflag = this.caflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railBlkCd = this.railBlkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBkgNo = this.oldBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localtime = this.localtime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitreason = this.splitreason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlag = this.bdrFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitcount = this.splitcount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partialflag = this.partialflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHideFlg = this.spclHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
