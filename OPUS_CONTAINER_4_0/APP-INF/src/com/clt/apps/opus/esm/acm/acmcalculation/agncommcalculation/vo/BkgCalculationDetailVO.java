/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgCalculationDetailVO.java
*@FileTitle : BkgCalculationDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.18
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.09.18 김영오
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgCalculationDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgCalculationDetailVO> models = new ArrayList<BkgCalculationDetailVO>();

	/* Column Info */
	private String brogAmt = null;
	/* Column Info */
	private String ffCmpn = null;
	/* Column Info */
	private String generalAmt = null;
	/* Column Info */
	private String facAmt = null;
	/* Column Info */
	private String facComm = null; 
	/* Column Info */
	private String spclAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String tsAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chfAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crossAmt = null;
	/* Column Info */
	private String ffAmt = null;
	/* Column Info */
	private String spclCmpn = null;
	/* Column Info */
	private String csfAmt = null;
	/* Column Info */
	private String rcsfAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgCalculationDetailVO() {}

	public BkgCalculationDetailVO(String ibflag, String pagerows, String agnCd, String blNo, String ioBndCd, String generalAmt, String brogAmt, String chfAmt, String tsAmt, String crossAmt, String facComm, String ffCmpn, String spclCmpn, String bkgNo, String facAmt, String ffAmt, String spclAmt, String csfAmt, String rcsfAmt) {
		this.brogAmt = brogAmt;
		this.ffCmpn = ffCmpn;
		this.generalAmt = generalAmt;
		this.facAmt = facAmt;
		this.facComm = facComm;
		this.spclAmt = spclAmt;
		this.ioBndCd = ioBndCd;
		this.tsAmt = tsAmt;
		this.blNo = blNo;
		this.chfAmt = chfAmt;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.crossAmt = crossAmt;
		this.ffAmt = ffAmt;
		this.spclCmpn = spclCmpn;
		this.csfAmt = csfAmt;
		this.rcsfAmt = rcsfAmt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("brog_amt", getBrogAmt());
		this.hashColumns.put("ff_cmpn", getFfCmpn());
		this.hashColumns.put("general_amt", getGeneralAmt());
		this.hashColumns.put("fac_amt", getFacAmt());
		this.hashColumns.put("fac_comm", getFacComm());
		this.hashColumns.put("spcl_amt", getSpclAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ts_amt", getTsAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chf_amt", getChfAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cross_amt", getCrossAmt());
		this.hashColumns.put("ff_amt", getFfAmt());
		this.hashColumns.put("spcl_cmpn", getSpclCmpn());
		this.hashColumns.put("csf_amt", getCsfAmt());
		this.hashColumns.put("rcsf_amt", getRcsfAmt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("brog_amt", "brogAmt");
		this.hashFields.put("ff_cmpn", "ffCmpn");
		this.hashFields.put("general_amt", "generalAmt");
		this.hashFields.put("fac_amt", "facAmt");
		this.hashFields.put("fac_comm", "facComm");
		this.hashFields.put("spcl_amt", "spclAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ts_amt", "tsAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chf_amt", "chfAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cross_amt", "crossAmt");
		this.hashFields.put("ff_amt", "ffAmt");
		this.hashFields.put("spcl_cmpn", "spclCmpn");
		this.hashFields.put("csf_amt", "csfAmt");
		this.hashFields.put("rcsf_amt", "rcsfAmt");		
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return brogAmt
	 */
	public String getBrogAmt() {
		return this.brogAmt;
	}

	/**
	 * Column Info
	 * @return ffCmpn
	 */
	public String getFfCmpn() {
		return this.ffCmpn;
	}

	/**
	 * Column Info
	 * @return generalAmt
	 */
	public String getGeneralAmt() {
		return this.generalAmt;
	}

	/**
	 * Column Info
	 * @return facAmt
	 */
	public String getFacAmt() {
		return this.facAmt;
	}

	/**
	 * Column Info
	 * @return facComm
	 */
	public String getFacComm() {
		return this.facComm;
	}

	/**
	 * Column Info
	 * @return spclAmt
	 */
	public String getSpclAmt() {
		return this.spclAmt;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * @return tsAmt
	 */
	public String getTsAmt() {
		return this.tsAmt;
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
	 * @return chfAmt
	 */
	public String getChfAmt() {
		return this.chfAmt;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return crossAmt
	 */
	public String getCrossAmt() {
		return this.crossAmt;
	}

	/**
	 * Column Info
	 * @return ffAmt
	 */
	public String getFfAmt() {
		return this.ffAmt;
	}

	/**
	 * Column Info
	 * @return spclCmpn
	 */
	public String getSpclCmpn() {
		return this.spclCmpn;
	}
	
	/**
	 * Column Info
	 * @return csfAmt
	 */
	public String getCsfAmt() {
		return this.csfAmt;
	}
	
	/**
	 * Column Info
	 * @return rcsfAmt
	 */
	public String getRcsfAmt() {
		return this.rcsfAmt;
	}


	/**
	 * Column Info
	 * @param brogAmt
	 */
	public void setBrogAmt(String brogAmt) {
		this.brogAmt = brogAmt;
	}

	/**
	 * Column Info
	 * @param ffCmpn
	 */
	public void setFfCmpn(String ffCmpn) {
		this.ffCmpn = ffCmpn;
	}

	/**
	 * Column Info
	 * @param generalAmt
	 */
	public void setGeneralAmt(String generalAmt) {
		this.generalAmt = generalAmt;
	}

	/**
	 * Column Info
	 * @param facAmt
	 */
	public void setFacAmt(String facAmt) {
		this.facAmt = facAmt;
	}

	/**
	 * Column Info
	 * @param facComm
	 */
	public void setFacComm(String facComm) {
		this.facComm = facComm;
	}

	/**
	 * Column Info
	 * @param spclAmt
	 */
	public void setSpclAmt(String spclAmt) {
		this.spclAmt = spclAmt;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param tsAmt
	 */
	public void setTsAmt(String tsAmt) {
		this.tsAmt = tsAmt;
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
	 * @param chfAmt
	 */
	public void setChfAmt(String chfAmt) {
		this.chfAmt = chfAmt;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param crossAmt
	 */
	public void setCrossAmt(String crossAmt) {
		this.crossAmt = crossAmt;
	}

	/**
	 * Column Info
	 * @param ffAmt
	 */
	public void setFfAmt(String ffAmt) {
		this.ffAmt = ffAmt;
	}

	/**
	 * Column Info
	 * @param spclCmpn
	 */
	public void setSpclCmpn(String spclCmpn) {
		this.spclCmpn = spclCmpn;
	}
	
	/**
	 * Column Info
	 * @param csfAmt
	 */
	public void setCsfAmt(String csfAmt) {
		this.csfAmt = csfAmt;
	}
	
	/**
	 * Column Info
	 * @param rcsfAmt
	 */
	public void setRcsfAmt(String rcsfAmt) {
		this.rcsfAmt = rcsfAmt;
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
		setBrogAmt(JSPUtil.getParameter(request, prefix + "brog_amt", ""));
		setFfCmpn(JSPUtil.getParameter(request, prefix + "ff_cmpn", ""));
		setGeneralAmt(JSPUtil.getParameter(request, prefix + "general_amt", ""));
		setFacAmt(JSPUtil.getParameter(request, prefix + "fac_amt", ""));
		setFacComm(JSPUtil.getParameter(request, prefix + "fac_comm", ""));
		setSpclAmt(JSPUtil.getParameter(request, prefix + "spcl_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setTsAmt(JSPUtil.getParameter(request, prefix + "ts_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setChfAmt(JSPUtil.getParameter(request, prefix + "chf_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrossAmt(JSPUtil.getParameter(request, prefix + "cross_amt", ""));
		setFfAmt(JSPUtil.getParameter(request, prefix + "ff_amt", ""));
		setSpclCmpn(JSPUtil.getParameter(request, prefix + "spcl_cmpn", ""));
		setCsfAmt(JSPUtil.getParameter(request, prefix + "csf_amt", ""));
		setRcsfAmt(JSPUtil.getParameter(request, prefix + "rcsf_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCalculationDetailVO[]
	 */
	public BkgCalculationDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgCalculationDetailVO[]
	 */
	public BkgCalculationDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCalculationDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] brogAmt = (JSPUtil.getParameter(request, prefix	+ "brog_amt", length));
			String[] ffCmpn = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn", length));
			String[] generalAmt = (JSPUtil.getParameter(request, prefix	+ "general_amt", length));
			String[] facAmt = (JSPUtil.getParameter(request, prefix	+ "fac_amt", length));
			String[] facComm = (JSPUtil.getParameter(request, prefix	+ "fac_comm", length));
			String[] spclAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] tsAmt = (JSPUtil.getParameter(request, prefix	+ "ts_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chfAmt = (JSPUtil.getParameter(request, prefix	+ "chf_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crossAmt = (JSPUtil.getParameter(request, prefix	+ "cross_amt", length));
			String[] ffAmt = (JSPUtil.getParameter(request, prefix	+ "ff_amt", length));
			String[] spclCmpn = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn", length));
			String[] csfAmt = (JSPUtil.getParameter(request, prefix	+ "csf_amt", length));
			String[] rcsfAmt = (JSPUtil.getParameter(request, prefix	+ "rcsf_amt", length));

			for (int i = 0; i < length; i++) {
				model = new BkgCalculationDetailVO();
				if (brogAmt[i] != null)
					model.setBrogAmt(brogAmt[i]);
				if (ffCmpn[i] != null)
					model.setFfCmpn(ffCmpn[i]);
				if (generalAmt[i] != null)
					model.setGeneralAmt(generalAmt[i]);
				if (facAmt[i] != null)
					model.setFacAmt(facAmt[i]);
				if (facComm[i] != null)
					model.setFacComm(facComm[i]);
				if (spclAmt[i] != null)
					model.setSpclAmt(spclAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (tsAmt[i] != null)
					model.setTsAmt(tsAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chfAmt[i] != null)
					model.setChfAmt(chfAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crossAmt[i] != null)
					model.setCrossAmt(crossAmt[i]);
				if (ffAmt[i] != null)
					model.setFfAmt(ffAmt[i]);
				if (spclCmpn[i] != null)
					model.setSpclCmpn(spclCmpn[i]);
				if (csfAmt[i] != null)
					model.setCsfAmt(csfAmt[i]);
				if (rcsfAmt[i] != null)
					model.setRcsfAmt(rcsfAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCalculationDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCalculationDetailVO[]
	 */
	public BkgCalculationDetailVO[] getBkgCalculationDetailVOs(){
		BkgCalculationDetailVO[] vos = (BkgCalculationDetailVO[])models.toArray(new BkgCalculationDetailVO[models.size()]);
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
		this.brogAmt = this.brogAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpn = this.ffCmpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.generalAmt = this.generalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facAmt = this.facAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facComm = this.facComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAmt = this.spclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsAmt = this.tsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chfAmt = this.chfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crossAmt = this.crossAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffAmt = this.ffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpn = this.spclCmpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csfAmt = this.csfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcsfAmt = this.rcsfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
