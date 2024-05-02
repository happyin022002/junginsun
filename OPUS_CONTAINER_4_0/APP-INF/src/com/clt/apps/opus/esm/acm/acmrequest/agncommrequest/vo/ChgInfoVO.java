/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChgInfoVO.java
*@FileTitle : ChgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.01
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.01 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChgInfoVO> models = new ArrayList<ChgInfoVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hd = null;
	/* Column Info */
	private String fd = null;
	/* Column Info */
	private String fo = null;
	/* Column Info */
	private String ho = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChgInfoVO() {}

	public ChgInfoVO(String ibflag, String pagerows, String ho, String hd, String fo, String fd) {
		this.ibflag = ibflag;
		this.hd = hd;
		this.fd = fd;
		this.fo = fo;
		this.ho = ho;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hd", getHd());
		this.hashColumns.put("fd", getFd());
		this.hashColumns.put("fo", getFo());
		this.hashColumns.put("ho", getHo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hd", "hd");
		this.hashFields.put("fd", "fd");
		this.hashFields.put("fo", "fo");
		this.hashFields.put("ho", "ho");
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
	 * @return hd
	 */
	public String getHd() {
		return this.hd;
	}

	/**
	 * Column Info
	 * @return fd
	 */
	public String getFd() {
		return this.fd;
	}

	/**
	 * Column Info
	 * @return fo
	 */
	public String getFo() {
		return this.fo;
	}

	/**
	 * Column Info
	 * @return ho
	 */
	public String getHo() {
		return this.ho;
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
	 * @param hd
	 */
	public void setHd(String hd) {
		this.hd = hd;
	}

	/**
	 * Column Info
	 * @param fd
	 */
	public void setFd(String fd) {
		this.fd = fd;
	}

	/**
	 * Column Info
	 * @param fo
	 */
	public void setFo(String fo) {
		this.fo = fo;
	}

	/**
	 * Column Info
	 * @param ho
	 */
	public void setHo(String ho) {
		this.ho = ho;
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
		setHd(JSPUtil.getParameter(request, prefix + "hd", ""));
		setFd(JSPUtil.getParameter(request, prefix + "fd", ""));
		setFo(JSPUtil.getParameter(request, prefix + "fo", ""));
		setHo(JSPUtil.getParameter(request, prefix + "ho", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChgInfoVO[]
	 */
	public ChgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChgInfoVO[]
	 */
	public ChgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChgInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hd = (JSPUtil.getParameter(request, prefix	+ "hd", length));
			String[] fd = (JSPUtil.getParameter(request, prefix	+ "fd", length));
			String[] fo = (JSPUtil.getParameter(request, prefix	+ "fo", length));
			String[] ho = (JSPUtil.getParameter(request, prefix	+ "ho", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ChgInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hd[i] != null)
					model.setHd(hd[i]);
				if (fd[i] != null)
					model.setFd(fd[i]);
				if (fo[i] != null)
					model.setFo(fo[i]);
				if (ho[i] != null)
					model.setHo(ho[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChgInfoVO[]
	 */
	public ChgInfoVO[] getChgInfoVOs(){
		ChgInfoVO[] vos = (ChgInfoVO[])models.toArray(new ChgInfoVO[models.size()]);
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
		this.hd = this.hd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fd = this.fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fo = this.fo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ho = this.ho .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
