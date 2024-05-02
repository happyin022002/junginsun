/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSAssetsSmryVO.java
*@FileTitle : CHSAssetsSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.25
*@LastModifier : NK
*@LastVersion : 1.0
* 2011.05.25 NK 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSAssetsSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSAssetsSmryVO> models = new ArrayList<CHSAssetsSmryVO>();
	
	/* Column Info */
	private String tllQty = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String donQty = null;
	/* Column Info */
	private String muoQty = null;
	/* Column Info */
	private String asetQty = null;
	/* Column Info */
	private String ctrtQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lstQty = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnfrYr = null;
	/* Column Info */
	private String cntrPfxCd = null;
	/* Column Info */
	private String lotCntrPfxCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String mftrVndrSeq = null;
	/* Column Info */
	private String fmPrd = null;
	/* Column Info */
	private String dioQty = null;
	/* Column Info */
	private String toPrd = null;
	/* Column Info */
	private String scrQty = null;
	/* Column Info */
	private String lsoQty = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String actQty = null;
	/* Column Info */
	private String sldQty = null;
	/* Column Info */
	private String sboQty = null;
	/* Column Info */
	private String locTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSAssetsSmryVO() {}

	public CHSAssetsSmryVO(String ibflag, String pagerows, String lotCntrPfxCd, String fmPrd, String toPrd, String locTpCd, String locCd, String cntrPfxCd, String fmSerNo, String toSerNo, String lstmCd, String cntrTpszCd, String mftrVndrSeq, String mnfrYr, String mftDt, String ctrtQty, String sldQty, String tllQty, String donQty, String scrQty, String asetQty, String lstQty, String sboQty, String muoQty, String lsoQty, String dioQty, String actQty) {
		this.tllQty = tllQty;
		this.fmSerNo = fmSerNo;
		this.donQty = donQty;
		this.muoQty = muoQty;
		this.asetQty = asetQty;
		this.ctrtQty = ctrtQty;
		this.pagerows = pagerows;
		this.lstQty = lstQty;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.mnfrYr = mnfrYr;
		this.cntrPfxCd = cntrPfxCd;
		this.lotCntrPfxCd = lotCntrPfxCd;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.toSerNo = toSerNo;
		this.mftrVndrSeq = mftrVndrSeq;
		this.fmPrd = fmPrd;
		this.dioQty = dioQty;
		this.toPrd = toPrd;
		this.scrQty = scrQty;
		this.lsoQty = lsoQty;
		this.mftDt = mftDt;
		this.actQty = actQty;
		this.sldQty = sldQty;
		this.sboQty = sboQty;
		this.locTpCd = locTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tll_qty", getTllQty());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("don_qty", getDonQty());
		this.hashColumns.put("muo_qty", getMuoQty());
		this.hashColumns.put("aset_qty", getAsetQty());
		this.hashColumns.put("ctrt_qty", getCtrtQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lst_qty", getLstQty());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnfr_yr", getMnfrYr());
		this.hashColumns.put("cntr_pfx_cd", getCntrPfxCd());
		this.hashColumns.put("lot_cntr_pfx_cd", getLotCntrPfxCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("mftr_vndr_seq", getMftrVndrSeq());
		this.hashColumns.put("fm_prd", getFmPrd());
		this.hashColumns.put("dio_qty", getDioQty());
		this.hashColumns.put("to_prd", getToPrd());
		this.hashColumns.put("scr_qty", getScrQty());
		this.hashColumns.put("lso_qty", getLsoQty());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("act_qty", getActQty());
		this.hashColumns.put("sld_qty", getSldQty());
		this.hashColumns.put("sbo_qty", getSboQty());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tll_qty", "tllQty");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("don_qty", "donQty");
		this.hashFields.put("muo_qty", "muoQty");
		this.hashFields.put("aset_qty", "asetQty");
		this.hashFields.put("ctrt_qty", "ctrtQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lst_qty", "lstQty");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnfr_yr", "mnfrYr");
		this.hashFields.put("cntr_pfx_cd", "cntrPfxCd");
		this.hashFields.put("lot_cntr_pfx_cd", "lotCntrPfxCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("mftr_vndr_seq", "mftrVndrSeq");
		this.hashFields.put("fm_prd", "fmPrd");
		this.hashFields.put("dio_qty", "dioQty");
		this.hashFields.put("to_prd", "toPrd");
		this.hashFields.put("scr_qty", "scrQty");
		this.hashFields.put("lso_qty", "lsoQty");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("act_qty", "actQty");
		this.hashFields.put("sld_qty", "sldQty");
		this.hashFields.put("sbo_qty", "sboQty");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tllQty
	 */
	public String getTllQty() {
		return this.tllQty;
	}
	
	/**
	 * Column Info
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
	}
	
	/**
	 * Column Info
	 * @return donQty
	 */
	public String getDonQty() {
		return this.donQty;
	}
	
	/**
	 * Column Info
	 * @return muoQty
	 */
	public String getMuoQty() {
		return this.muoQty;
	}
	
	/**
	 * Column Info
	 * @return asetQty
	 */
	public String getAsetQty() {
		return this.asetQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtQty
	 */
	public String getCtrtQty() {
		return this.ctrtQty;
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
	 * @return lstQty
	 */
	public String getLstQty() {
		return this.lstQty;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return mnfrYr
	 */
	public String getMnfrYr() {
		return this.mnfrYr;
	}
	
	/**
	 * Column Info
	 * @return cntrPfxCd
	 */
	public String getCntrPfxCd() {
		return this.cntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @return lotCntrPfxCd
	 */
	public String getLotCntrPfxCd() {
		return this.lotCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
	}
	
	/**
	 * Column Info
	 * @return mftrVndrSeq
	 */
	public String getMftrVndrSeq() {
		return this.mftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return fmPrd
	 */
	public String getFmPrd() {
		return this.fmPrd;
	}
	
	/**
	 * Column Info
	 * @return dioQty
	 */
	public String getDioQty() {
		return this.dioQty;
	}
	
	/**
	 * Column Info
	 * @return toPrd
	 */
	public String getToPrd() {
		return this.toPrd;
	}
	
	/**
	 * Column Info
	 * @return scrQty
	 */
	public String getScrQty() {
		return this.scrQty;
	}
	
	/**
	 * Column Info
	 * @return lsoQty
	 */
	public String getLsoQty() {
		return this.lsoQty;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return actQty
	 */
	public String getActQty() {
		return this.actQty;
	}
	
	/**
	 * Column Info
	 * @return sldQty
	 */
	public String getSldQty() {
		return this.sldQty;
	}
	
	/**
	 * Column Info
	 * @return sboQty
	 */
	public String getSboQty() {
		return this.sboQty;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	

	/**
	 * Column Info
	 * @param tllQty
	 */
	public void setTllQty(String tllQty) {
		this.tllQty = tllQty;
	}
	
	/**
	 * Column Info
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
	}
	
	/**
	 * Column Info
	 * @param donQty
	 */
	public void setDonQty(String donQty) {
		this.donQty = donQty;
	}
	
	/**
	 * Column Info
	 * @param muoQty
	 */
	public void setMuoQty(String muoQty) {
		this.muoQty = muoQty;
	}
	
	/**
	 * Column Info
	 * @param asetQty
	 */
	public void setAsetQty(String asetQty) {
		this.asetQty = asetQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtQty
	 */
	public void setCtrtQty(String ctrtQty) {
		this.ctrtQty = ctrtQty;
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
	 * @param lstQty
	 */
	public void setLstQty(String lstQty) {
		this.lstQty = lstQty;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param mnfrYr
	 */
	public void setMnfrYr(String mnfrYr) {
		this.mnfrYr = mnfrYr;
	}
	
	/**
	 * Column Info
	 * @param cntrPfxCd
	 */
	public void setCntrPfxCd(String cntrPfxCd) {
		this.cntrPfxCd = cntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @param lotCntrPfxCd
	 */
	public void setLotCntrPfxCd(String lotCntrPfxCd) {
		this.lotCntrPfxCd = lotCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
	}
	
	/**
	 * Column Info
	 * @param mftrVndrSeq
	 */
	public void setMftrVndrSeq(String mftrVndrSeq) {
		this.mftrVndrSeq = mftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param fmPrd
	 */
	public void setFmPrd(String fmPrd) {
		this.fmPrd = fmPrd;
	}
	
	/**
	 * Column Info
	 * @param dioQty
	 */
	public void setDioQty(String dioQty) {
		this.dioQty = dioQty;
	}
	
	/**
	 * Column Info
	 * @param toPrd
	 */
	public void setToPrd(String toPrd) {
		this.toPrd = toPrd;
	}
	
	/**
	 * Column Info
	 * @param scrQty
	 */
	public void setScrQty(String scrQty) {
		this.scrQty = scrQty;
	}
	
	/**
	 * Column Info
	 * @param lsoQty
	 */
	public void setLsoQty(String lsoQty) {
		this.lsoQty = lsoQty;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param actQty
	 */
	public void setActQty(String actQty) {
		this.actQty = actQty;
	}
	
	/**
	 * Column Info
	 * @param sldQty
	 */
	public void setSldQty(String sldQty) {
		this.sldQty = sldQty;
	}
	
	/**
	 * Column Info
	 * @param sboQty
	 */
	public void setSboQty(String sboQty) {
		this.sboQty = sboQty;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTllQty(JSPUtil.getParameter(request, "tll_qty", ""));
		setFmSerNo(JSPUtil.getParameter(request, "fm_ser_no", ""));
		setDonQty(JSPUtil.getParameter(request, "don_qty", ""));
		setMuoQty(JSPUtil.getParameter(request, "muo_qty", ""));
		setAsetQty(JSPUtil.getParameter(request, "aset_qty", ""));
		setCtrtQty(JSPUtil.getParameter(request, "ctrt_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLstQty(JSPUtil.getParameter(request, "lst_qty", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnfrYr(JSPUtil.getParameter(request, "mnfr_yr", ""));
		setCntrPfxCd(JSPUtil.getParameter(request, "cntr_pfx_cd", ""));
		setLotCntrPfxCd(JSPUtil.getParameter(request, "lot_cntr_pfx_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setToSerNo(JSPUtil.getParameter(request, "to_ser_no", ""));
		setMftrVndrSeq(JSPUtil.getParameter(request, "mftr_vndr_seq", ""));
		setFmPrd(JSPUtil.getParameter(request, "fm_prd", ""));
		setDioQty(JSPUtil.getParameter(request, "dio_qty", ""));
		setToPrd(JSPUtil.getParameter(request, "to_prd", ""));
		setScrQty(JSPUtil.getParameter(request, "scr_qty", ""));
		setLsoQty(JSPUtil.getParameter(request, "lso_qty", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setActQty(JSPUtil.getParameter(request, "act_qty", ""));
		setSldQty(JSPUtil.getParameter(request, "sld_qty", ""));
		setSboQty(JSPUtil.getParameter(request, "sbo_qty", ""));
		setLocTpCd(JSPUtil.getParameter(request, "loc_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AssetsSmryVO[]
	 */
	public CHSAssetsSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AssetsSmryVO[]
	 */
	public CHSAssetsSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSAssetsSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tllQty = (JSPUtil.getParameter(request, prefix	+ "tll_qty", length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no", length));
			String[] donQty = (JSPUtil.getParameter(request, prefix	+ "don_qty", length));
			String[] muoQty = (JSPUtil.getParameter(request, prefix	+ "muo_qty", length));
			String[] asetQty = (JSPUtil.getParameter(request, prefix	+ "aset_qty", length));
			String[] ctrtQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lstQty = (JSPUtil.getParameter(request, prefix	+ "lst_qty", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnfrYr = (JSPUtil.getParameter(request, prefix	+ "mnfr_yr", length));
			String[] cntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pfx_cd", length));
			String[] lotCntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "lot_cntr_pfx_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no", length));
			String[] mftrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mftr_vndr_seq", length));
			String[] fmPrd = (JSPUtil.getParameter(request, prefix	+ "fm_prd", length));
			String[] dioQty = (JSPUtil.getParameter(request, prefix	+ "dio_qty", length));
			String[] toPrd = (JSPUtil.getParameter(request, prefix	+ "to_prd", length));
			String[] scrQty = (JSPUtil.getParameter(request, prefix	+ "scr_qty", length));
			String[] lsoQty = (JSPUtil.getParameter(request, prefix	+ "lso_qty", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] actQty = (JSPUtil.getParameter(request, prefix	+ "act_qty", length));
			String[] sldQty = (JSPUtil.getParameter(request, prefix	+ "sld_qty", length));
			String[] sboQty = (JSPUtil.getParameter(request, prefix	+ "sbo_qty", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSAssetsSmryVO();
				if (tllQty[i] != null)
					model.setTllQty(tllQty[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (donQty[i] != null)
					model.setDonQty(donQty[i]);
				if (muoQty[i] != null)
					model.setMuoQty(muoQty[i]);
				if (asetQty[i] != null)
					model.setAsetQty(asetQty[i]);
				if (ctrtQty[i] != null)
					model.setCtrtQty(ctrtQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lstQty[i] != null)
					model.setLstQty(lstQty[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnfrYr[i] != null)
					model.setMnfrYr(mnfrYr[i]);
				if (cntrPfxCd[i] != null)
					model.setCntrPfxCd(cntrPfxCd[i]);
				if (lotCntrPfxCd[i] != null)
					model.setLotCntrPfxCd(lotCntrPfxCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (mftrVndrSeq[i] != null)
					model.setMftrVndrSeq(mftrVndrSeq[i]);
				if (fmPrd[i] != null)
					model.setFmPrd(fmPrd[i]);
				if (dioQty[i] != null)
					model.setDioQty(dioQty[i]);
				if (toPrd[i] != null)
					model.setToPrd(toPrd[i]);
				if (scrQty[i] != null)
					model.setScrQty(scrQty[i]);
				if (lsoQty[i] != null)
					model.setLsoQty(lsoQty[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (actQty[i] != null)
					model.setActQty(actQty[i]);
				if (sldQty[i] != null)
					model.setSldQty(sldQty[i]);
				if (sboQty[i] != null)
					model.setSboQty(sboQty[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAssetsSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AssetsSmryVO[]
	 */
	public CHSAssetsSmryVO[] getAssetsSmryVOs(){
		CHSAssetsSmryVO[] vos = (CHSAssetsSmryVO[])models.toArray(new CHSAssetsSmryVO[models.size()]);
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
		this.tllQty = this.tllQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.donQty = this.donQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.muoQty = this.muoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetQty = this.asetQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtQty = this.ctrtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstQty = this.lstQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnfrYr = this.mnfrYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPfxCd = this.cntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrPfxCd = this.lotCntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftrVndrSeq = this.mftrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrd = this.fmPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dioQty = this.dioQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrd = this.toPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrQty = this.scrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsoQty = this.lsoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actQty = this.actQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sldQty = this.sldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sboQty = this.sboQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
