/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchGuaranteeIrregularCntrListVO.java
*@FileTitle : SearchGuaranteeIrregularCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.08 yOng hO lEE 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo;

import java.lang.reflect.Field;
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
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchGuaranteeIrregularCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchGuaranteeIrregularCntrListVO> models = new ArrayList<SearchGuaranteeIrregularCntrListVO>();
	
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String tmlIfSeq = null;
	/* Column Info */
	private String gnteProcTpCd = null;
	/* Column Info */
	private String gnteAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String tmlGnteCntrListSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String gnteNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String irrNo = null;
	/* Column Info */
	private String bkgNo2 = null;
	/* Column Info */
	private String bkgNoListCtnt = null;
	/* Column Info */
	private String tmlIfOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchGuaranteeIrregularCntrListVO() {}

	public SearchGuaranteeIrregularCntrListVO(String ibflag, String pagerows, String gnteNo, String tmlGnteCntrListSeq, String gnteProcTpCd, String irrNo, String cntrNo, String cntrTpszCd, String bkgNo, String bkgNo2, String bkgNoListCtnt, String blNo, String scNo, String vvdCd, String fmDt, String toDt, String tmlIfOfcCd, String tmlIfSeq, String gnteAmt) {
		this.fmDt = fmDt;
		this.tmlIfSeq = tmlIfSeq;
		this.gnteProcTpCd = gnteProcTpCd;
		this.gnteAmt = gnteAmt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.gnteNo = gnteNo;
		this.vvdCd = vvdCd;
		this.cntrNo = cntrNo;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.irrNo = irrNo;
		this.bkgNo2 = bkgNo2;
		this.bkgNoListCtnt = bkgNoListCtnt;
		this.tmlIfOfcCd = tmlIfOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("tml_if_seq", getTmlIfSeq());
		this.hashColumns.put("gnte_proc_tp_cd", getGnteProcTpCd());
		this.hashColumns.put("gnte_amt", getGnteAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("tml_gnte_cntr_list_seq", getTmlGnteCntrListSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("gnte_no", getGnteNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("irr_no", getIrrNo());
		this.hashColumns.put("bkg_no2", getBkgNo2());
		this.hashColumns.put("bkg_no_list_ctnt", getBkgNoListCtnt());
		this.hashColumns.put("tml_if_ofc_cd", getTmlIfOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("tml_if_seq", "tmlIfSeq");
		this.hashFields.put("gnte_proc_tp_cd", "gnteProcTpCd");
		this.hashFields.put("gnte_amt", "gnteAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("tml_gnte_cntr_list_seq", "tmlGnteCntrListSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("gnte_no", "gnteNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("irr_no", "irrNo");
		this.hashFields.put("bkg_no2", "bkgNo2");
		this.hashFields.put("bkg_no_list_ctnt", "bkgNoListCtnt");
		this.hashFields.put("tml_if_ofc_cd", "tmlIfOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return tmlIfSeq
	 */
	public String getTmlIfSeq() {
		return this.tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @return gnteProcTpCd
	 */
	public String getGnteProcTpCd() {
		return this.gnteProcTpCd;
	}
	
	/**
	 * Column Info
	 * @return gnteAmt
	 */
	public String getGnteAmt() {
		return this.gnteAmt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return tmlGnteCntrListSeq
	 */
	public String getTmlGnteCntrListSeq() {
		return this.tmlGnteCntrListSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return gnteNo
	 */
	public String getGnteNo() {
		return this.gnteNo;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return irrNo
	 */
	public String getIrrNo() {
		return this.irrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo2
	 */
	public String getBkgNo2() {
		return this.bkgNo2;
	}
	
	/**
	 * Column Info
	 * @return bkgNoListCtnt
	 */
	public String getBkgNoListCtnt() {
		return this.bkgNoListCtnt;
	}
	
	/**
	 * Column Info
	 * @return tmlIfOfcCd
	 */
	public String getTmlIfOfcCd() {
		return this.tmlIfOfcCd;
	}
	

	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param tmlIfSeq
	 */
	public void setTmlIfSeq(String tmlIfSeq) {
		this.tmlIfSeq = tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @param gnteProcTpCd
	 */
	public void setGnteProcTpCd(String gnteProcTpCd) {
		this.gnteProcTpCd = gnteProcTpCd;
	}
	
	/**
	 * Column Info
	 * @param gnteAmt
	 */
	public void setGnteAmt(String gnteAmt) {
		this.gnteAmt = gnteAmt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param tmlGnteCntrListSeq
	 */
	public void setTmlGnteCntrListSeq(String tmlGnteCntrListSeq) {
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param gnteNo
	 */
	public void setGnteNo(String gnteNo) {
		this.gnteNo = gnteNo;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param irrNo
	 */
	public void setIrrNo(String irrNo) {
		this.irrNo = irrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNo2
	 */
	public void setBkgNo2(String bkgNo2) {
		this.bkgNo2 = bkgNo2;
	}
	
	/**
	 * Column Info
	 * @param bkgNoListCtnt
	 */
	public void setBkgNoListCtnt(String bkgNoListCtnt) {
		this.bkgNoListCtnt = bkgNoListCtnt;
	}
	
	/**
	 * Column Info
	 * @param tmlIfOfcCd
	 */
	public void setTmlIfOfcCd(String tmlIfOfcCd) {
		this.tmlIfOfcCd = tmlIfOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setTmlIfSeq(JSPUtil.getParameter(request, "tml_if_seq", ""));
		setGnteProcTpCd(JSPUtil.getParameter(request, "gnte_proc_tp_cd", ""));
		setGnteAmt(JSPUtil.getParameter(request, "gnte_amt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setTmlGnteCntrListSeq(JSPUtil.getParameter(request, "tml_gnte_cntr_list_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setGnteNo(JSPUtil.getParameter(request, "gnte_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setIrrNo(JSPUtil.getParameter(request, "irr_no", ""));
		setBkgNo2(JSPUtil.getParameter(request, "bkg_no2", ""));
		setBkgNoListCtnt(JSPUtil.getParameter(request, "bkg_no_list_ctnt", ""));
		setTmlIfOfcCd(JSPUtil.getParameter(request, "tml_if_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchGuaranteeIrregularCntrListVO[]
	 */
	public SearchGuaranteeIrregularCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchGuaranteeIrregularCntrListVO[]
	 */
	public SearchGuaranteeIrregularCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchGuaranteeIrregularCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] tmlIfSeq = (JSPUtil.getParameter(request, prefix	+ "tml_if_seq", length));
			String[] gnteProcTpCd = (JSPUtil.getParameter(request, prefix	+ "gnte_proc_tp_cd", length));
			String[] gnteAmt = (JSPUtil.getParameter(request, prefix	+ "gnte_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] tmlGnteCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "tml_gnte_cntr_list_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] gnteNo = (JSPUtil.getParameter(request, prefix	+ "gnte_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] irrNo = (JSPUtil.getParameter(request, prefix	+ "irr_no", length));
			String[] bkgNo2 = (JSPUtil.getParameter(request, prefix	+ "bkg_no2", length));
			String[] bkgNoListCtnt = (JSPUtil.getParameter(request, prefix	+ "bkg_no_list_ctnt", length));
			String[] tmlIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "tml_if_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchGuaranteeIrregularCntrListVO();
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (tmlIfSeq[i] != null)
					model.setTmlIfSeq(tmlIfSeq[i]);
				if (gnteProcTpCd[i] != null)
					model.setGnteProcTpCd(gnteProcTpCd[i]);
				if (gnteAmt[i] != null)
					model.setGnteAmt(gnteAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (tmlGnteCntrListSeq[i] != null)
					model.setTmlGnteCntrListSeq(tmlGnteCntrListSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (gnteNo[i] != null)
					model.setGnteNo(gnteNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (irrNo[i] != null)
					model.setIrrNo(irrNo[i]);
				if (bkgNo2[i] != null)
					model.setBkgNo2(bkgNo2[i]);
				if (bkgNoListCtnt[i] != null)
					model.setBkgNoListCtnt(bkgNoListCtnt[i]);
				if (tmlIfOfcCd[i] != null)
					model.setTmlIfOfcCd(tmlIfOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchGuaranteeIrregularCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchGuaranteeIrregularCntrListVO[]
	 */
	public SearchGuaranteeIrregularCntrListVO[] getSearchGuaranteeIrregularCntrListVOs(){
		SearchGuaranteeIrregularCntrListVO[] vos = (SearchGuaranteeIrregularCntrListVO[])models.toArray(new SearchGuaranteeIrregularCntrListVO[models.size()]);
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
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlIfSeq = this.tmlIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteProcTpCd = this.gnteProcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteAmt = this.gnteAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlGnteCntrListSeq = this.tmlGnteCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteNo = this.gnteNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrNo = this.irrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo2 = this.bkgNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoListCtnt = this.bkgNoListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlIfOfcCd = this.tmlIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
