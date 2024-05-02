/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpclReqInVO.java
*@FileTitle : SpclReqInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.10.14 이병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpclReqInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpclReqInVO> models = new ArrayList<SpclReqInVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String dcgoQty = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String spclTp = null;
	/* Column Info */
	private String cargoSeq = null;
	/* Column Info */
	private String awkCgoQty = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lstRqstDatFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAproCd = null;
	/* Column Info */
	private String rcQty = null;
	/* Column Info */
	private String cntrSeq = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String spclBkgRqstFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bbCgoQty = null;
	/* Column Info */
	private String bbCgoSeq = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String aproCd = null;
	/* Column Info */
	private String stwgCgoSeq = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpclReqInVO() {}

	public SpclReqInVO(String ibflag, String pagerows, String bkgNo, String spclTp, String cargoSeq, String cntrSeq, String spclCgoAproCd, String awkCgoSeq, String dcgoSeq, String rcSeq, String bbCgoSeq, String spclCgoCateCd, String porCd, String delCd, String awkCgoQty, String bbCgoQty, String dcgoQty, String rcQty, String lstRqstDatFlg, String rcvTermCd, String deTermCd, String rqstUsrId, String rqstOfcCd, String rqstDt, String spclBkgRqstFlg, String aproCd, String stwgCgoSeq) {
		this.porCd = porCd;
		this.dcgoQty = dcgoQty;
		this.rqstUsrId = rqstUsrId;
		this.spclTp = spclTp;
		this.cargoSeq = cargoSeq;
		this.awkCgoQty = awkCgoQty;
		this.dcgoSeq = dcgoSeq;
		this.awkCgoSeq = awkCgoSeq;
		this.pagerows = pagerows;
		this.lstRqstDatFlg = lstRqstDatFlg;
		this.ibflag = ibflag;
		this.spclCgoAproCd = spclCgoAproCd;
		this.rcQty = rcQty;
		this.cntrSeq = cntrSeq;
		this.rcvTermCd = rcvTermCd;
		this.rqstDt = rqstDt;
		this.rcSeq = rcSeq;
		this.spclCgoCateCd = spclCgoCateCd;
		this.delCd = delCd;
		this.spclBkgRqstFlg = spclBkgRqstFlg;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.bbCgoQty = bbCgoQty;
		this.bbCgoSeq = bbCgoSeq;
		this.rqstOfcCd = rqstOfcCd;
		this.aproCd = aproCd;
		this.stwgCgoSeq = stwgCgoSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("dcgo_qty", getDcgoQty());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("spcl_tp", getSpclTp());
		this.hashColumns.put("cargo_seq", getCargoSeq());
		this.hashColumns.put("awk_cgo_qty", getAwkCgoQty());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lst_rqst_dat_flg", getLstRqstDatFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
		this.hashColumns.put("rc_qty", getRcQty());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("spcl_bkg_rqst_flg", getSpclBkgRqstFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bb_cgo_qty", getBbCgoQty());
		this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("apro_cd", getAproCd());
		this.hashColumns.put("stwg_cgo_seq", getStwgCgoSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("dcgo_qty", "dcgoQty");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("spcl_tp", "spclTp");
		this.hashFields.put("cargo_seq", "cargoSeq");
		this.hashFields.put("awk_cgo_qty", "awkCgoQty");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lst_rqst_dat_flg", "lstRqstDatFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
		this.hashFields.put("rc_qty", "rcQty");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("spcl_bkg_rqst_flg", "spclBkgRqstFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bb_cgo_qty", "bbCgoQty");
		this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("apro_cd", "aproCd");
		this.hashFields.put("stwg_cgo_seq", "stwgCgoSeq");
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
	 * @return dcgoQty
	 */
	public String getDcgoQty() {
		return this.dcgoQty;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return spclTp
	 */
	public String getSpclTp() {
		return this.spclTp;
	}
	
	/**
	 * Column Info
	 * @return cargoSeq
	 */
	public String getCargoSeq() {
		return this.cargoSeq;
	}
	
	/**
	 * Column Info
	 * @return awkCgoQty
	 */
	public String getAwkCgoQty() {
		return this.awkCgoQty;
	}
	
	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
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
	 * @return lstRqstDatFlg
	 */
	public String getLstRqstDatFlg() {
		return this.lstRqstDatFlg;
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
	 * @return spclCgoAproCd
	 */
	public String getSpclCgoAproCd() {
		return this.spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @return rcQty
	 */
	public String getRcQty() {
		return this.rcQty;
	}
	
	/**
	 * Column Info
	 * @return cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
	}
	
	/**
	 * Column Info
	 * @return spclCgoCateCd
	 */
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
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
	 * @return spclBkgRqstFlg
	 */
	public String getSpclBkgRqstFlg() {
		return this.spclBkgRqstFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return bbCgoQty
	 */
	public String getBbCgoQty() {
		return this.bbCgoQty;
	}
	
	/**
	 * Column Info
	 * @return bbCgoSeq
	 */
	public String getBbCgoSeq() {
		return this.bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aproCd
	 */
	public String getAproCd() {
		return this.aproCd;
	}

	/**
	 * Column Info
	 * @return stwgCgoSeq
	 */
	public String getStwgCgoSeq() {
		return this.stwgCgoSeq;
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
	 * @param dcgoQty
	 */
	public void setDcgoQty(String dcgoQty) {
		this.dcgoQty = dcgoQty;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param spclTp
	 */
	public void setSpclTp(String spclTp) {
		this.spclTp = spclTp;
	}
	
	/**
	 * Column Info
	 * @param cargoSeq
	 */
	public void setCargoSeq(String cargoSeq) {
		this.cargoSeq = cargoSeq;
	}
	
	/**
	 * Column Info
	 * @param awkCgoQty
	 */
	public void setAwkCgoQty(String awkCgoQty) {
		this.awkCgoQty = awkCgoQty;
	}
	
	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
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
	 * @param lstRqstDatFlg
	 */
	public void setLstRqstDatFlg(String lstRqstDatFlg) {
		this.lstRqstDatFlg = lstRqstDatFlg;
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
	 * @param spclCgoAproCd
	 */
	public void setSpclCgoAproCd(String spclCgoAproCd) {
		this.spclCgoAproCd = spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @param rcQty
	 */
	public void setRcQty(String rcQty) {
		this.rcQty = rcQty;
	}
	
	/**
	 * Column Info
	 * @param cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}
	
	/**
	 * Column Info
	 * @param spclCgoCateCd
	 */
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
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
	 * @param spclBkgRqstFlg
	 */
	public void setSpclBkgRqstFlg(String spclBkgRqstFlg) {
		this.spclBkgRqstFlg = spclBkgRqstFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param bbCgoQty
	 */
	public void setBbCgoQty(String bbCgoQty) {
		this.bbCgoQty = bbCgoQty;
	}
	
	/**
	 * Column Info
	 * @param bbCgoSeq
	 */
	public void setBbCgoSeq(String bbCgoSeq) {
		this.bbCgoSeq = bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aproCd
	 */
	public void setAproCd(String aproCd) {
		this.aproCd = aproCd;
	}

	/**
	 * Column Info
	 * @param stwgCgoSeq
	 */
	public void setStwgCgoSeq(String stwgCgoSeq) {
		this.stwgCgoSeq = stwgCgoSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDcgoQty(JSPUtil.getParameter(request, "dcgo_qty", ""));
		setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
		setSpclTp(JSPUtil.getParameter(request, "spcl_tp", ""));
		setCargoSeq(JSPUtil.getParameter(request, "cargo_seq", ""));
		setAwkCgoQty(JSPUtil.getParameter(request, "awk_cgo_qty", ""));
		setDcgoSeq(JSPUtil.getParameter(request, "dcgo_seq", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, "awk_cgo_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLstRqstDatFlg(JSPUtil.getParameter(request, "lst_rqst_dat_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpclCgoAproCd(JSPUtil.getParameter(request, "spcl_cgo_apro_cd", ""));
		setRcQty(JSPUtil.getParameter(request, "rc_qty", ""));
		setCntrSeq(JSPUtil.getParameter(request, "cntr_seq", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setRcSeq(JSPUtil.getParameter(request, "rc_seq", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, "spcl_cgo_cate_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSpclBkgRqstFlg(JSPUtil.getParameter(request, "spcl_bkg_rqst_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBbCgoQty(JSPUtil.getParameter(request, "bb_cgo_qty", ""));
		setBbCgoSeq(JSPUtil.getParameter(request, "bb_cgo_seq", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setAproCd(JSPUtil.getParameter(request, "apro_cd", ""));
		setStwgCgoSeq(JSPUtil.getParameter(request, "stwg_cgo_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpclReqInVO[]
	 */
	public SpclReqInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpclReqInVO[]
	 */
	public SpclReqInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpclReqInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] dcgoQty = (JSPUtil.getParameter(request, prefix	+ "dcgo_qty", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] spclTp = (JSPUtil.getParameter(request, prefix	+ "spcl_tp", length));
			String[] cargoSeq = (JSPUtil.getParameter(request, prefix	+ "cargo_seq", length));
			String[] awkCgoQty = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_qty", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lstRqstDatFlg = (JSPUtil.getParameter(request, prefix	+ "lst_rqst_dat_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_cd", length));
			String[] rcQty = (JSPUtil.getParameter(request, prefix	+ "rc_qty", length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seq", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] spclBkgRqstFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_bkg_rqst_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bbCgoQty = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_qty", length));
			String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_seq", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] aproCd = (JSPUtil.getParameter(request, prefix	+ "apro_cd", length));
			String[] stwgCgoSeq = (JSPUtil.getParameter(request, prefix	+ "stwg_cgo_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpclReqInVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (dcgoQty[i] != null)
					model.setDcgoQty(dcgoQty[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (spclTp[i] != null)
					model.setSpclTp(spclTp[i]);
				if (cargoSeq[i] != null)
					model.setCargoSeq(cargoSeq[i]);
				if (awkCgoQty[i] != null)
					model.setAwkCgoQty(awkCgoQty[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lstRqstDatFlg[i] != null)
					model.setLstRqstDatFlg(lstRqstDatFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAproCd[i] != null)
					model.setSpclCgoAproCd(spclCgoAproCd[i]);
				if (rcQty[i] != null)
					model.setRcQty(rcQty[i]);
				if (cntrSeq[i] != null)
					model.setCntrSeq(cntrSeq[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (spclBkgRqstFlg[i] != null)
					model.setSpclBkgRqstFlg(spclBkgRqstFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bbCgoQty[i] != null)
					model.setBbCgoQty(bbCgoQty[i]);
				if (bbCgoSeq[i] != null)
					model.setBbCgoSeq(bbCgoSeq[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (aproCd[i] != null)
					model.setAproCd(aproCd[i]);
				if (stwgCgoSeq[i] != null)
					model.setStwgCgoSeq(stwgCgoSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpclReqInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpclReqInVO[]
	 */
	public SpclReqInVO[] getSpclReqInVOs(){
		SpclReqInVO[] vos = (SpclReqInVO[])models.toArray(new SpclReqInVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoQty = this.dcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTp = this.spclTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoSeq = this.cargoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoQty = this.awkCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstRqstDatFlg = this.lstRqstDatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproCd = this.spclCgoAproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcQty = this.rcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBkgRqstFlg = this.spclBkgRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoQty = this.bbCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoSeq = this.bbCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproCd = this.aproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCgoSeq = this.stwgCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
