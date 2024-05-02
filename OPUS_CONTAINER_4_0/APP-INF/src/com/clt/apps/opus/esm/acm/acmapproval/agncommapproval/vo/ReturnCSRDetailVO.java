/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ReturnCSRDetailVO.java
*@FileTitle : ReturnCSRDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.26 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReturnCSRDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ReturnCSRDetailVO> models = new ArrayList<ReturnCSRDetailVO>();

	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String audNo = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String netAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ReturnCSRDetailVO() {}

	public ReturnCSRDetailVO(String ibflag, String pagerows, String audNo, String agnCd, String vvdCnt, String currCd, String netAmt, String vat, String totAmt, String aproDt) {
		this.agnCd = agnCd;
		this.audNo = audNo;
		this.totAmt = totAmt;
		this.netAmt = netAmt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.vat = vat;
		this.aproDt = aproDt;
		this.vvdCnt = vvdCnt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("aud_no", getAudNo());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("net_amt", getNetAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vat", getVat());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("aud_no", "audNo");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("net_amt", "netAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return audNo
	 */
	public String getAudNo() {
		return this.audNo;
	}

	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}

	/**
	 * Column Info
	 * @return netAmt
	 */
	public String getNetAmt() {
		return this.netAmt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return vat
	 */
	public String getVat() {
		return this.vat;
	}

	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}

	/**
	 * Column Info
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}

	/**
	 * Column Info
	 * @param audNo
	 */
	public void setAudNo(String audNo) {
		this.audNo = audNo;
	}

	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}

	/**
	 * Column Info
	 * @param netAmt
	 */
	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param vat
	 */
	public void setVat(String vat) {
		this.vat = vat;
	}

	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}

	/**
	 * Column Info
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setAudNo(JSPUtil.getParameter(request, prefix + "aud_no", ""));
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setNetAmt(JSPUtil.getParameter(request, prefix + "net_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setVat(JSPUtil.getParameter(request, prefix + "vat", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReturnCSRDetailVO[]
	 */
	public ReturnCSRDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReturnCSRDetailVO[]
	 */
	public ReturnCSRDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReturnCSRDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] audNo = (JSPUtil.getParameter(request, prefix	+ "aud_no", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ReturnCSRDetailVO();
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (audNo[i] != null)
					model.setAudNo(audNo[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReturnCSRDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReturnCSRDetailVO[]
	 */
	public ReturnCSRDetailVO[] getReturnCSRDetailVOs(){
		ReturnCSRDetailVO[] vos = (ReturnCSRDetailVO[])models.toArray(new ReturnCSRDetailVO[models.size()]);
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
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNo = this.audNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
