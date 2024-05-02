/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchFFAGMTRateInfoVO.java
*@FileTitle : SearchFFAGMTRateInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.21
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFFAGMTRateInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchFFAGMTRateInfoVO> models = new ArrayList<SearchFFAGMTRateInfoVO>();

	/* Column Info */
	private String ffBxAmt = null;
	/* Column Info */
	private String ffFeuAmt = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String ffBkgRt = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String ffChgCtnt = null;
	/* Column Info */
	private String ffAgmtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ffDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffTeuAmt = null;
	/* Column Info */
	private String ffSeq = null;
	/* Column Info */
	private String ffRfAmt = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String shprSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchFFAGMTRateInfoVO() {}

	public SearchFFAGMTRateInfoVO(String ibflag, String pagerows, String ffCntCd, String ffSeq, String shprCntCd, String shprSeq, String ffDivCd, String ffBkgRt, String ffChgCtnt, String ffBxAmt, String ffTeuAmt, String ffFeuAmt, String ffRfAmt, String fmEffDt, String toEffDt, String ffAgmtSeq) {
		this.ffBxAmt = ffBxAmt;
		this.ffFeuAmt = ffFeuAmt;
		this.shprCntCd = shprCntCd;
		this.ffBkgRt = ffBkgRt;
		this.toEffDt = toEffDt;
		this.ffChgCtnt = ffChgCtnt;
		this.ffAgmtSeq = ffAgmtSeq;
		this.pagerows = pagerows;
		this.ffDivCd = ffDivCd;
		this.ibflag = ibflag;
		this.ffTeuAmt = ffTeuAmt;
		this.ffSeq = ffSeq;
		this.ffRfAmt = ffRfAmt;
		this.ffCntCd = ffCntCd;
		this.fmEffDt = fmEffDt;
		this.shprSeq = shprSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ff_bx_amt", getFfBxAmt());
		this.hashColumns.put("ff_feu_amt", getFfFeuAmt());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("ff_bkg_rt", getFfBkgRt());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("ff_chg_ctnt", getFfChgCtnt());
		this.hashColumns.put("ff_agmt_seq", getFfAgmtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ff_div_cd", getFfDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ff_teu_amt", getFfTeuAmt());
		this.hashColumns.put("ff_seq", getFfSeq());
		this.hashColumns.put("ff_rf_amt", getFfRfAmt());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("shpr_seq", getShprSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ff_bx_amt", "ffBxAmt");
		this.hashFields.put("ff_feu_amt", "ffFeuAmt");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("ff_bkg_rt", "ffBkgRt");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("ff_chg_ctnt", "ffChgCtnt");
		this.hashFields.put("ff_agmt_seq", "ffAgmtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ff_div_cd", "ffDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ff_teu_amt", "ffTeuAmt");
		this.hashFields.put("ff_seq", "ffSeq");
		this.hashFields.put("ff_rf_amt", "ffRfAmt");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("shpr_seq", "shprSeq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ffBxAmt
	 */
	public String getFfBxAmt() {
		return this.ffBxAmt;
	}

	/**
	 * Column Info
	 * @return ffFeuAmt
	 */
	public String getFfFeuAmt() {
		return this.ffFeuAmt;
	}

	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}

	/**
	 * Column Info
	 * @return ffBkgRt
	 */
	public String getFfBkgRt() {
		return this.ffBkgRt;
	}

	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}

	/**
	 * Column Info
	 * @return ffChgCtnt
	 */
	public String getFfChgCtnt() {
		return this.ffChgCtnt;
	}

	/**
	 * Column Info
	 * @return ffAgmtSeq
	 */
	public String getFfAgmtSeq() {
		return this.ffAgmtSeq;
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
	 * @return ffDivCd
	 */
	public String getFfDivCd() {
		return this.ffDivCd;
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
	 * @return ffTeuAmt
	 */
	public String getFfTeuAmt() {
		return this.ffTeuAmt;
	}

	/**
	 * Column Info
	 * @return ffSeq
	 */
	public String getFfSeq() {
		return this.ffSeq;
	}

	/**
	 * Column Info
	 * @return ffRfAmt
	 */
	public String getFfRfAmt() {
		return this.ffRfAmt;
	}

	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}

	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}

	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}


	/**
	 * Column Info
	 * @param ffBxAmt
	 */
	public void setFfBxAmt(String ffBxAmt) {
		this.ffBxAmt = ffBxAmt;
	}

	/**
	 * Column Info
	 * @param ffFeuAmt
	 */
	public void setFfFeuAmt(String ffFeuAmt) {
		this.ffFeuAmt = ffFeuAmt;
	}

	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}

	/**
	 * Column Info
	 * @param ffBkgRt
	 */
	public void setFfBkgRt(String ffBkgRt) {
		this.ffBkgRt = ffBkgRt;
	}

	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}

	/**
	 * Column Info
	 * @param ffChgCtnt
	 */
	public void setFfChgCtnt(String ffChgCtnt) {
		this.ffChgCtnt = ffChgCtnt;
	}

	/**
	 * Column Info
	 * @param ffAgmtSeq
	 */
	public void setFfAgmtSeq(String ffAgmtSeq) {
		this.ffAgmtSeq = ffAgmtSeq;
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
	 * @param ffDivCd
	 */
	public void setFfDivCd(String ffDivCd) {
		this.ffDivCd = ffDivCd;
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
	 * @param ffTeuAmt
	 */
	public void setFfTeuAmt(String ffTeuAmt) {
		this.ffTeuAmt = ffTeuAmt;
	}

	/**
	 * Column Info
	 * @param ffSeq
	 */
	public void setFfSeq(String ffSeq) {
		this.ffSeq = ffSeq;
	}

	/**
	 * Column Info
	 * @param ffRfAmt
	 */
	public void setFfRfAmt(String ffRfAmt) {
		this.ffRfAmt = ffRfAmt;
	}

	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}

	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}

	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
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
		setFfBxAmt(JSPUtil.getParameter(request, prefix + "ff_bx_amt", ""));
		setFfFeuAmt(JSPUtil.getParameter(request, prefix + "ff_feu_amt", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setFfBkgRt(JSPUtil.getParameter(request, prefix + "ff_bkg_rt", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setFfChgCtnt(JSPUtil.getParameter(request, prefix + "ff_chg_ctnt", ""));
		setFfAgmtSeq(JSPUtil.getParameter(request, prefix + "ff_agmt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFfDivCd(JSPUtil.getParameter(request, prefix + "ff_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFfTeuAmt(JSPUtil.getParameter(request, prefix + "ff_teu_amt", ""));
		setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
		setFfRfAmt(JSPUtil.getParameter(request, prefix + "ff_rf_amt", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFFAGMTRateInfoVO[]
	 */
	public SearchFFAGMTRateInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchFFAGMTRateInfoVO[]
	 */
	public SearchFFAGMTRateInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFFAGMTRateInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ffBxAmt = (JSPUtil.getParameter(request, prefix	+ "ff_bx_amt", length));
			String[] ffFeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_feu_amt", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] ffBkgRt = (JSPUtil.getParameter(request, prefix	+ "ff_bkg_rt", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] ffChgCtnt = (JSPUtil.getParameter(request, prefix	+ "ff_chg_ctnt", length));
			String[] ffAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "ff_agmt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ffDivCd = (JSPUtil.getParameter(request, prefix	+ "ff_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffTeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_teu_amt", length));
			String[] ffSeq = (JSPUtil.getParameter(request, prefix	+ "ff_seq", length));
			String[] ffRfAmt = (JSPUtil.getParameter(request, prefix	+ "ff_rf_amt", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));

			for (int i = 0; i < length; i++) {
				model = new SearchFFAGMTRateInfoVO();
				if (ffBxAmt[i] != null)
					model.setFfBxAmt(ffBxAmt[i]);
				if (ffFeuAmt[i] != null)
					model.setFfFeuAmt(ffFeuAmt[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (ffBkgRt[i] != null)
					model.setFfBkgRt(ffBkgRt[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (ffChgCtnt[i] != null)
					model.setFfChgCtnt(ffChgCtnt[i]);
				if (ffAgmtSeq[i] != null)
					model.setFfAgmtSeq(ffAgmtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ffDivCd[i] != null)
					model.setFfDivCd(ffDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffTeuAmt[i] != null)
					model.setFfTeuAmt(ffTeuAmt[i]);
				if (ffSeq[i] != null)
					model.setFfSeq(ffSeq[i]);
				if (ffRfAmt[i] != null)
					model.setFfRfAmt(ffRfAmt[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFFAGMTRateInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFFAGMTRateInfoVO[]
	 */
	public SearchFFAGMTRateInfoVO[] getSearchFFAGMTRateInfoVOs(){
		SearchFFAGMTRateInfoVO[] vos = (SearchFFAGMTRateInfoVO[])models.toArray(new SearchFFAGMTRateInfoVO[models.size()]);
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
		this.ffBxAmt = this.ffBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffFeuAmt = this.ffFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffBkgRt = this.ffBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffChgCtnt = this.ffChgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffAgmtSeq = this.ffAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffDivCd = this.ffDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffTeuAmt = this.ffTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffSeq = this.ffSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRfAmt = this.ffRfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
