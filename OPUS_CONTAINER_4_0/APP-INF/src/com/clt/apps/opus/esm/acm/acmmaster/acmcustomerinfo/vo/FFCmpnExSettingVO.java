/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnExSettingVO.java
*@FileTitle : FFCmpnExSettingVO
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

public class FFCmpnExSettingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<FFCmpnExSettingVO> models = new ArrayList<FFCmpnExSettingVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String orgFfSeq = null;
	/* Column Info */
	private String orgShprCntCd = null;
	/* Column Info */
	private String shprLglEngNm = null;
	/* Column Info */
	private String shprCntSeq = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Column Info */
	private String orgShprSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public FFCmpnExSettingVO() {}

	public FFCmpnExSettingVO(String ibflag, String pagerows, String ffCntSeq, String custLglEngNm, String shprCntSeq, String shprLglEngNm, String ffCntCd, String orgFfSeq, String orgShprCntCd, String orgShprSeq, String usrId) {
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.ffCntCd = ffCntCd;
		this.orgFfSeq = orgFfSeq;
		this.orgShprCntCd = orgShprCntCd;
		this.shprLglEngNm = shprLglEngNm;
		this.shprCntSeq = shprCntSeq;
		this.ffCntSeq = ffCntSeq;
		this.orgShprSeq = orgShprSeq;
		this.custLglEngNm = custLglEngNm;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("org_ff_seq", getOrgFfSeq());
		this.hashColumns.put("org_shpr_cnt_cd", getOrgShprCntCd());
		this.hashColumns.put("shpr_lgl_eng_nm", getShprLglEngNm());
		this.hashColumns.put("shpr_cnt_seq", getShprCntSeq());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("org_shpr_seq", getOrgShprSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("org_ff_seq", "orgFfSeq");
		this.hashFields.put("org_shpr_cnt_cd", "orgShprCntCd");
		this.hashFields.put("shpr_lgl_eng_nm", "shprLglEngNm");
		this.hashFields.put("shpr_cnt_seq", "shprCntSeq");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("org_shpr_seq", "orgShprSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
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
	 * @return orgShprCntCd
	 */
	public String getOrgShprCntCd() {
		return this.orgShprCntCd;
	}

	/**
	 * Column Info
	 * @return shprLglEngNm
	 */
	public String getShprLglEngNm() {
		return this.shprLglEngNm;
	}

	/**
	 * Column Info
	 * @return shprCntSeq
	 */
	public String getShprCntSeq() {
		return this.shprCntSeq;
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
	 * @return orgShprSeq
	 */
	public String getOrgShprSeq() {
		return this.orgShprSeq;
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
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
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
	 * @param orgShprCntCd
	 */
	public void setOrgShprCntCd(String orgShprCntCd) {
		this.orgShprCntCd = orgShprCntCd;
	}

	/**
	 * Column Info
	 * @param shprLglEngNm
	 */
	public void setShprLglEngNm(String shprLglEngNm) {
		this.shprLglEngNm = shprLglEngNm;
	}

	/**
	 * Column Info
	 * @param shprCntSeq
	 */
	public void setShprCntSeq(String shprCntSeq) {
		this.shprCntSeq = shprCntSeq;
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
	 * @param orgShprSeq
	 */
	public void setOrgShprSeq(String orgShprSeq) {
		this.orgShprSeq = orgShprSeq;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setOrgFfSeq(JSPUtil.getParameter(request, prefix + "org_ff_seq", ""));
		setOrgShprCntCd(JSPUtil.getParameter(request, prefix + "org_shpr_cnt_cd", ""));
		setShprLglEngNm(JSPUtil.getParameter(request, prefix + "shpr_lgl_eng_nm", ""));
		setShprCntSeq(JSPUtil.getParameter(request, prefix + "shpr_cnt_seq", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setOrgShprSeq(JSPUtil.getParameter(request, prefix + "org_shpr_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFCmpnExSettingVO[]
	 */
	public FFCmpnExSettingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FFCmpnExSettingVO[]
	 */
	public FFCmpnExSettingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFCmpnExSettingVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] orgFfSeq = (JSPUtil.getParameter(request, prefix	+ "org_ff_seq", length));
			String[] orgShprCntCd = (JSPUtil.getParameter(request, prefix	+ "org_shpr_cnt_cd", length));
			String[] shprLglEngNm = (JSPUtil.getParameter(request, prefix	+ "shpr_lgl_eng_nm", length));
			String[] shprCntSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_seq", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] orgShprSeq = (JSPUtil.getParameter(request, prefix	+ "org_shpr_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new FFCmpnExSettingVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (orgFfSeq[i] != null)
					model.setOrgFfSeq(orgFfSeq[i]);
				if (orgShprCntCd[i] != null)
					model.setOrgShprCntCd(orgShprCntCd[i]);
				if (shprLglEngNm[i] != null)
					model.setShprLglEngNm(shprLglEngNm[i]);
				if (shprCntSeq[i] != null)
					model.setShprCntSeq(shprCntSeq[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (orgShprSeq[i] != null)
					model.setOrgShprSeq(orgShprSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFCmpnExSettingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFCmpnExSettingVO[]
	 */
	public FFCmpnExSettingVO[] getFFCmpnExSettingVOs(){
		FFCmpnExSettingVO[] vos = (FFCmpnExSettingVO[])models.toArray(new FFCmpnExSettingVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFfSeq = this.orgFfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgShprCntCd = this.orgShprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprLglEngNm = this.shprLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntSeq = this.shprCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgShprSeq = this.orgShprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
