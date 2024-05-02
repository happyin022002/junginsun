/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFVendorMatchVO.java
*@FileTitle : FFVendorMatchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.07 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.vo;

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

public class FFVendorMatchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<FFVendorMatchVO> models = new ArrayList<FFVendorMatchVO>();

	/* Column Info */
	private String vndrCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String orgVndrCntCd = null;
	/* Column Info */
	private String orgFfSeq = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Column Info */
	private String orgVndrSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public FFVendorMatchVO() {}

	public FFVendorMatchVO(String ibflag, String pagerows, String ffCntSeq, String custLglEngNm, String vndrSeq, String vndrLglEngNm, String ffCntCd, String orgFfSeq, String vndrCntCd, String orgVndrCntCd, String orgVndrSeq, String usrId) {
		this.vndrCntCd = vndrCntCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.vndrSeq = vndrSeq;
		this.ffCntCd = ffCntCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.orgVndrCntCd = orgVndrCntCd;
		this.orgFfSeq = orgFfSeq;
		this.ffCntSeq = ffCntSeq;
		this.orgVndrSeq = orgVndrSeq;
		this.custLglEngNm = custLglEngNm;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("org_vndr_cnt_cd", getOrgVndrCntCd());
		this.hashColumns.put("org_ff_seq", getOrgFfSeq());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("org_vndr_seq", getOrgVndrSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("org_vndr_cnt_cd", "orgVndrCntCd");
		this.hashFields.put("org_ff_seq", "orgFfSeq");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("org_vndr_seq", "orgVndrSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @return orgVndrCntCd
	 */
	public String getOrgVndrCntCd() {
		return this.orgVndrCntCd;
	}

	/**
	 * Column Info
	 * @return orgFfSeq
	 */
	public String getOrgFfSeq() {
		return this.orgFfSeq;
	}

	/**
	 * Column Info
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
	}

	/**
	 * Column Info
	 * @return orgVndrSeq
	 */
	public String getOrgVndrSeq() {
		return this.orgVndrSeq;
	}

	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @param orgVndrCntCd
	 */
	public void setOrgVndrCntCd(String orgVndrCntCd) {
		this.orgVndrCntCd = orgVndrCntCd;
	}

	/**
	 * Column Info
	 * @param orgFfSeq
	 */
	public void setOrgFfSeq(String orgFfSeq) {
		this.orgFfSeq = orgFfSeq;
	}

	/**
	 * Column Info
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
	}

	/**
	 * Column Info
	 * @param orgVndrSeq
	 */
	public void setOrgVndrSeq(String orgVndrSeq) {
		this.orgVndrSeq = orgVndrSeq;
	}

	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setOrgVndrCntCd(JSPUtil.getParameter(request, prefix + "org_vndr_cnt_cd", ""));
		setOrgFfSeq(JSPUtil.getParameter(request, prefix + "org_ff_seq", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setOrgVndrSeq(JSPUtil.getParameter(request, prefix + "org_vndr_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFVendorMatchVO[]
	 */
	public FFVendorMatchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FFVendorMatchVO[]
	 */
	public FFVendorMatchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFVendorMatchVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] orgVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "org_vndr_cnt_cd", length));
			String[] orgFfSeq = (JSPUtil.getParameter(request, prefix	+ "org_ff_seq", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] orgVndrSeq = (JSPUtil.getParameter(request, prefix	+ "org_vndr_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new FFVendorMatchVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (orgVndrCntCd[i] != null)
					model.setOrgVndrCntCd(orgVndrCntCd[i]);
				if (orgFfSeq[i] != null)
					model.setOrgFfSeq(orgFfSeq[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (orgVndrSeq[i] != null)
					model.setOrgVndrSeq(orgVndrSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFVendorMatchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFVendorMatchVO[]
	 */
	public FFVendorMatchVO[] getFFVendorMatchVOs(){
		FFVendorMatchVO[] vos = (FFVendorMatchVO[])models.toArray(new FFVendorMatchVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrCntCd = this.orgVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFfSeq = this.orgFfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrSeq = this.orgVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
