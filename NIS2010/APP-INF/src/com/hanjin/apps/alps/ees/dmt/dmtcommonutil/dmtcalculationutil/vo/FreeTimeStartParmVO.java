/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FreeTimeStartParmVO.java
*@FileTitle : FreeTimeStartParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.06
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.12.06 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FreeTimeStartParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FreeTimeStartParmVO> models = new ArrayList<FreeTimeStartParmVO>();
	
	/* Column Info */
	private String yrdLocCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String cmncHr = null;
	/* Column Info */
	private String exclSun = null;
	/* Column Info */
	private String cstopNo = null;
	/* Column Info */
	private String cmncTp = null;
	/* Column Info */
	private String bkgRgnCd = null;
	/* Column Info */
	private String yrdCntCd = null;
	/* Column Info */
	private String cstopIdx = null;
	/* Column Info */
	private String yrdRgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String exclHoli = null;
	/* Column Info */
	private String exclSat = null;
	/* Column Info */
	private String bkgStateCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgLocCd = null;
	/* Column Info */
	private String yrdStateCd = null;
	/* Column Info */
	private String dttCode = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String bkgCntCd = null;
	/* Column Info */
	private List<String> cstopNoList = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String expType = null;

	/**
	 * Column Info
	 * @return this.cstopNoVOS
	 */
	public void setCStopNoList(List<String> cstopNoList) {
		this.cstopNoList = cstopNoList;
	}
	
	/**
	 * Column Info
	 * @return List<String>
	 */
	public List<String> getCStopNoList() {
		return cstopNoList;
	}
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FreeTimeStartParmVO() {}

	public FreeTimeStartParmVO(String ibflag, String pagerows, String fromDt, String bkgCntCd, String bkgRgnCd, String bkgStateCd, String bkgLocCd, String yrdCntCd, String yrdRgnCd, String yrdStateCd, String yrdLocCd, String dttCode, String ofcCd, String exclSat, String exclSun, String exclHoli, String cmncTp, String cmncHr, String cstopIdx, String cstopNo, String svrId, String yardCd, String ioBndCd, String bkgDeTermCd, String bkgRcvTermCd, String expType) {
		this.yrdLocCd = yrdLocCd;
		this.fromDt = fromDt;
		this.cmncHr = cmncHr;
		this.exclSun = exclSun;
		this.cstopNo = cstopNo;
		this.cmncTp = cmncTp;
		this.bkgRgnCd = bkgRgnCd;
		this.yrdCntCd = yrdCntCd;
		this.cstopIdx = cstopIdx;
		this.yrdRgnCd = yrdRgnCd;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.exclHoli = exclHoli;
		this.exclSat = exclSat;
		this.bkgStateCd = bkgStateCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgLocCd = bkgLocCd;
		this.yrdStateCd = yrdStateCd;
		this.dttCode = dttCode;
		this.yardCd = yardCd;
		this.bkgCntCd = bkgCntCd;
		this.ioBndCd = ioBndCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.expType = expType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yrd_loc_cd", getYrdLocCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("cmnc_hr", getCmncHr());
		this.hashColumns.put("excl_sun", getExclSun());
		this.hashColumns.put("cstop_no", getCstopNo());
		this.hashColumns.put("cmnc_tp", getCmncTp());
		this.hashColumns.put("bkg_rgn_cd", getBkgRgnCd());
		this.hashColumns.put("yrd_cnt_cd", getYrdCntCd());
		this.hashColumns.put("cstop_idx", getCstopIdx());
		this.hashColumns.put("yrd_rgn_cd", getYrdRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("excl_holi", getExclHoli());
		this.hashColumns.put("excl_sat", getExclSat());
		this.hashColumns.put("bkg_state_cd", getBkgStateCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_loc_cd", getBkgLocCd());
		this.hashColumns.put("yrd_state_cd", getYrdStateCd());
		this.hashColumns.put("dtt_code", getDttCode());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("bkg_cnt_cd", getBkgCntCd());
		this.hashColumns.put("io_bnd_cd",getIoBndCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("exp_type", getExpType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yrd_loc_cd", "yrdLocCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("cmnc_hr", "cmncHr");
		this.hashFields.put("excl_sun", "exclSun");
		this.hashFields.put("cstop_no", "cstopNo");
		this.hashFields.put("cmnc_tp", "cmncTp");
		this.hashFields.put("bkg_rgn_cd", "bkgRgnCd");
		this.hashFields.put("yrd_cnt_cd", "yrdCntCd");
		this.hashFields.put("cstop_idx", "cstopIdx");
		this.hashFields.put("yrd_rgn_cd", "yrdRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("excl_holi", "exclHoli");
		this.hashFields.put("excl_sat", "exclSat");
		this.hashFields.put("bkg_state_cd", "bkgStateCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_loc_cd", "bkgLocCd");
		this.hashFields.put("yrd_state_cd", "yrdStateCd");
		this.hashFields.put("dtt_code", "dttCode");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("bkg_cnt_cd", "bkgCntCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("exp_type", "expType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yrdLocCd
	 */
	public String getYrdLocCd() {
		return this.yrdLocCd;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return cmncHr
	 */
	public String getCmncHr() {
		return this.cmncHr;
	}
	
	/**
	 * Column Info
	 * @return exclSun
	 */
	public String getExclSun() {
		return this.exclSun;
	}
	
	/**
	 * Column Info
	 * @return cstopNo
	 */
	public String getCstopNo() {
		return this.cstopNo;
	}
	
	/**
	 * Column Info
	 * @return cmncTp
	 */
	public String getCmncTp() {
		return this.cmncTp;
	}
	
	/**
	 * Column Info
	 * @return bkgRgnCd
	 */
	public String getBkgRgnCd() {
		return this.bkgRgnCd;
	}
	
	/**
	 * Column Info
	 * @return yrdCntCd
	 */
	public String getYrdCntCd() {
		return this.yrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return cstopIdx
	 */
	public String getCstopIdx() {
		return this.cstopIdx;
	}
	
	/**
	 * Column Info
	 * @return yrdRgnCd
	 */
	public String getYrdRgnCd() {
		return this.yrdRgnCd;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return exclHoli
	 */
	public String getExclHoli() {
		return this.exclHoli;
	}
	
	/**
	 * Column Info
	 * @return exclSat
	 */
	public String getExclSat() {
		return this.exclSat;
	}
	
	/**
	 * Column Info
	 * @return bkgStateCd
	 */
	public String getBkgStateCd() {
		return this.bkgStateCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bkgLocCd
	 */
	public String getBkgLocCd() {
		return this.bkgLocCd;
	}
	
	/**
	 * Column Info
	 * @return yrdStateCd
	 */
	public String getYrdStateCd() {
		return this.yrdStateCd;
	}
	
	/**
	 * Column Info
	 * @return dttCode
	 */
	public String getDttCode() {
		return this.dttCode;
	}
	
	/**
	 * Column Info
	 * @return yardCd
	 */
	public String getYardCd() {
		return this.yardCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCntCd
	 */
	public String getBkgCntCd() {
		return this.bkgCntCd;
	}
	

	
	public String getIoBndCd() {
		return ioBndCd;
	}

	public String getBkgDeTermCd() {
		return bkgDeTermCd;
	}
	
	public String getBkgRcvTermCd() {
		return bkgRcvTermCd;
	}
	
	public String getExpType() {
		return expType;
	}

	/**
	 * Column Info
	 * @param yrdLocCd
	 */
	public void setYrdLocCd(String yrdLocCd) {
		this.yrdLocCd = yrdLocCd;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param cmncHr
	 */
	public void setCmncHr(String cmncHr) {
		this.cmncHr = cmncHr;
	}
	
	/**
	 * Column Info
	 * @param exclSun
	 */
	public void setExclSun(String exclSun) {
		this.exclSun = exclSun;
	}
	
	/**
	 * Column Info
	 * @param cstopNo
	 */
	public void setCstopNo(String cstopNo) {
		this.cstopNo = cstopNo;
	}
	
	/**
	 * Column Info
	 * @param cmncTp
	 */
	public void setCmncTp(String cmncTp) {
		this.cmncTp = cmncTp;
	}
	
	/**
	 * Column Info
	 * @param bkgRgnCd
	 */
	public void setBkgRgnCd(String bkgRgnCd) {
		this.bkgRgnCd = bkgRgnCd;
	}
	
	/**
	 * Column Info
	 * @param yrdCntCd
	 */
	public void setYrdCntCd(String yrdCntCd) {
		this.yrdCntCd = yrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param cstopIdx
	 */
	public void setCstopIdx(String cstopIdx) {
		this.cstopIdx = cstopIdx;
	}
	
	/**
	 * Column Info
	 * @param yrdRgnCd
	 */
	public void setYrdRgnCd(String yrdRgnCd) {
		this.yrdRgnCd = yrdRgnCd;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param exclHoli
	 */
	public void setExclHoli(String exclHoli) {
		this.exclHoli = exclHoli;
	}
	
	/**
	 * Column Info
	 * @param exclSat
	 */
	public void setExclSat(String exclSat) {
		this.exclSat = exclSat;
	}
	
	/**
	 * Column Info
	 * @param bkgStateCd
	 */
	public void setBkgStateCd(String bkgStateCd) {
		this.bkgStateCd = bkgStateCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bkgLocCd
	 */
	public void setBkgLocCd(String bkgLocCd) {
		this.bkgLocCd = bkgLocCd;
	}
	
	/**
	 * Column Info
	 * @param yrdStateCd
	 */
	public void setYrdStateCd(String yrdStateCd) {
		this.yrdStateCd = yrdStateCd;
	}
	
	/**
	 * Column Info
	 * @param dttCode
	 */
	public void setDttCode(String dttCode) {
		this.dttCode = dttCode;
	}
	
	/**
	 * Column Info
	 * @param yardCd
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCntCd
	 */
	public void setBkgCntCd(String bkgCntCd) {
		this.bkgCntCd = bkgCntCd;
	}
	
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}

	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
    public void setExpType(String expType) {
		this.expType = expType;
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
		setYrdLocCd(JSPUtil.getParameter(request, prefix + "yrd_loc_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setCmncHr(JSPUtil.getParameter(request, prefix + "cmnc_hr", ""));
		setExclSun(JSPUtil.getParameter(request, prefix + "excl_sun", ""));
		setCstopNo(JSPUtil.getParameter(request, prefix + "cstop_no", ""));
		setCmncTp(JSPUtil.getParameter(request, prefix + "cmnc_tp", ""));
		setBkgRgnCd(JSPUtil.getParameter(request, prefix + "bkg_rgn_cd", ""));
		setYrdCntCd(JSPUtil.getParameter(request, prefix + "yrd_cnt_cd", ""));
		setCstopIdx(JSPUtil.getParameter(request, prefix + "cstop_idx", ""));
		setYrdRgnCd(JSPUtil.getParameter(request, prefix + "yrd_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setExclHoli(JSPUtil.getParameter(request, prefix + "excl_holi", ""));
		setExclSat(JSPUtil.getParameter(request, prefix + "excl_sat", ""));
		setBkgStateCd(JSPUtil.getParameter(request, prefix + "bkg_state_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgLocCd(JSPUtil.getParameter(request, prefix + "bkg_loc_cd", ""));
		setYrdStateCd(JSPUtil.getParameter(request, prefix + "yrd_state_cd", ""));
		setDttCode(JSPUtil.getParameter(request, prefix + "dtt_code", ""));
		setYardCd(JSPUtil.getParameter(request, prefix + "yard_cd", ""));
		setBkgCntCd(JSPUtil.getParameter(request, prefix + "bkg_cnt_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setExpType(JSPUtil.getParameter(request, prefix + "exp_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FreeTimeStartParmVO[]
	 */
	public FreeTimeStartParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FreeTimeStartParmVO[]
	 */
	public FreeTimeStartParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FreeTimeStartParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yrdLocCd = (JSPUtil.getParameter(request, prefix	+ "yrd_loc_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] cmncHr = (JSPUtil.getParameter(request, prefix	+ "cmnc_hr", length));
			String[] exclSun = (JSPUtil.getParameter(request, prefix	+ "excl_sun", length));
			String[] cstopNo = (JSPUtil.getParameter(request, prefix	+ "cstop_no", length));
			String[] cmncTp = (JSPUtil.getParameter(request, prefix	+ "cmnc_tp", length));
			String[] bkgRgnCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rgn_cd", length));
			String[] yrdCntCd = (JSPUtil.getParameter(request, prefix	+ "yrd_cnt_cd", length));
			String[] cstopIdx = (JSPUtil.getParameter(request, prefix	+ "cstop_idx", length));
			String[] yrdRgnCd = (JSPUtil.getParameter(request, prefix	+ "yrd_rgn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] exclHoli = (JSPUtil.getParameter(request, prefix	+ "excl_holi", length));
			String[] exclSat = (JSPUtil.getParameter(request, prefix	+ "excl_sat", length));
			String[] bkgStateCd = (JSPUtil.getParameter(request, prefix	+ "bkg_state_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgLocCd = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_cd", length));
			String[] yrdStateCd = (JSPUtil.getParameter(request, prefix	+ "yrd_state_cd", length));
			String[] dttCode = (JSPUtil.getParameter(request, prefix	+ "dtt_code", length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd", length));
			String[] bkgCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] expType = (JSPUtil.getParameter(request, prefix	+ "exp_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new FreeTimeStartParmVO();
				if (yrdLocCd[i] != null)
					model.setYrdLocCd(yrdLocCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (cmncHr[i] != null)
					model.setCmncHr(cmncHr[i]);
				if (exclSun[i] != null)
					model.setExclSun(exclSun[i]);
				if (cstopNo[i] != null)
					model.setCstopNo(cstopNo[i]);
				if (cmncTp[i] != null)
					model.setCmncTp(cmncTp[i]);
				if (bkgRgnCd[i] != null)
					model.setBkgRgnCd(bkgRgnCd[i]);
				if (yrdCntCd[i] != null)
					model.setYrdCntCd(yrdCntCd[i]);
				if (cstopIdx[i] != null)
					model.setCstopIdx(cstopIdx[i]);
				if (yrdRgnCd[i] != null)
					model.setYrdRgnCd(yrdRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (exclHoli[i] != null)
					model.setExclHoli(exclHoli[i]);
				if (exclSat[i] != null)
					model.setExclSat(exclSat[i]);
				if (bkgStateCd[i] != null)
					model.setBkgStateCd(bkgStateCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgLocCd[i] != null)
					model.setBkgLocCd(bkgLocCd[i]);
				if (yrdStateCd[i] != null)
					model.setYrdStateCd(yrdStateCd[i]);
				if (dttCode[i] != null)
					model.setDttCode(dttCode[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (bkgCntCd[i] != null)
					model.setBkgCntCd(bkgCntCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (expType[i] != null)
					model.setExpType(expType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFreeTimeStartParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FreeTimeStartParmVO[]
	 */
	public FreeTimeStartParmVO[] getFreeTimeStartParmVOs(){
		FreeTimeStartParmVO[] vos = (FreeTimeStartParmVO[])models.toArray(new FreeTimeStartParmVO[models.size()]);
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
		this.yrdLocCd = this.yrdLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmncHr = this.cmncHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSun = this.exclSun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopNo = this.cstopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmncTp = this.cmncTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRgnCd = this.bkgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdCntCd = this.yrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopIdx = this.cstopIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdRgnCd = this.yrdRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclHoli = this.exclHoli .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSat = this.exclSat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStateCd = this.bkgStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocCd = this.bkgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdStateCd = this.yrdStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dttCode = this.dttCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntCd = this.bkgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expType = this.expType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	} 
}
