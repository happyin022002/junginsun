/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchRevLanebndInfoVO.java
*@FileTitle : SearchRevLanebndInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.05
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo;

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

public class SearchRevLanebndInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchRevLanebndInfoVO> models = new ArrayList<SearchRevLanebndInfoVO>();

	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revVvdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String commRlaneCd = null;
	/* Column Info */
	private String estmIocDivCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchRevLanebndInfoVO() {}

	public SearchRevLanebndInfoVO(String ibflag, String pagerows, String bkgNo, String estmIocDivCd, String rlaneCd, String revVvdCd, String commRlaneCd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.revVvdCd = revVvdCd;
		this.rlaneCd = rlaneCd;
		this.commRlaneCd = commRlaneCd;
		this.estmIocDivCd = estmIocDivCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("comm_rlane_cd", getCommRlaneCd());
		this.hashColumns.put("estm_ioc_div_cd", getEstmIocDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("comm_rlane_cd", "commRlaneCd");
		this.hashFields.put("estm_ioc_div_cd", "estmIocDivCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return revVvdCd
	 */
	public String getRevVvdCd() {
		return this.revVvdCd;
	}

	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}

	/**
	 * Column Info
	 * @return commRlaneCd
	 */
	public String getCommRlaneCd() {
		return this.commRlaneCd;
	}

	/**
	 * Column Info
	 * @return estmIocDivCd
	 */
	public String getEstmIocDivCd() {
		return this.estmIocDivCd;
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
	 * @param revVvdCd
	 */
	public void setRevVvdCd(String revVvdCd) {
		this.revVvdCd = revVvdCd;
	}

	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}

	/**
	 * Column Info
	 * @param commRlaneCd
	 */
	public void setCommRlaneCd(String commRlaneCd) {
		this.commRlaneCd = commRlaneCd;
	}

	/**
	 * Column Info
	 * @param estmIocDivCd
	 */
	public void setEstmIocDivCd(String estmIocDivCd) {
		this.estmIocDivCd = estmIocDivCd;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRevVvdCd(JSPUtil.getParameter(request, prefix + "rev_vvd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCommRlaneCd(JSPUtil.getParameter(request, prefix + "comm_rlane_cd", ""));
		setEstmIocDivCd(JSPUtil.getParameter(request, prefix + "estm_ioc_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRevLanebndInfoVO[]
	 */
	public SearchRevLanebndInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchRevLanebndInfoVO[]
	 */
	public SearchRevLanebndInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRevLanebndInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revVvdCd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] commRlaneCd = (JSPUtil.getParameter(request, prefix	+ "comm_rlane_cd", length));
			String[] estmIocDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_ioc_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new SearchRevLanebndInfoVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revVvdCd[i] != null)
					model.setRevVvdCd(revVvdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (commRlaneCd[i] != null)
					model.setCommRlaneCd(commRlaneCd[i]);
				if (estmIocDivCd[i] != null)
					model.setEstmIocDivCd(estmIocDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRevLanebndInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRevLanebndInfoVO[]
	 */
	public SearchRevLanebndInfoVO[] getSearchRevLanebndInfoVOs(){
		SearchRevLanebndInfoVO[] vos = (SearchRevLanebndInfoVO[])models.toArray(new SearchRevLanebndInfoVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd = this.revVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRlaneCd = this.commRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmIocDivCd = this.estmIocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
