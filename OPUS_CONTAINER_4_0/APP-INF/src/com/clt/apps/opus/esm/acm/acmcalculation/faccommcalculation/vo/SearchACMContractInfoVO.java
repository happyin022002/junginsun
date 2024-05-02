/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchACMContractInfoVO.java
*@FileTitle : SearchACMContractInfoVO
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

public class SearchACMContractInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchACMContractInfoVO> models = new ArrayList<SearchACMContractInfoVO>();

	/* Column Info */
	private String ppdOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3ptyRcvOfcCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String ppayrCntCd = null;
	/* Column Info */
	private String cgoRcvDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchACMContractInfoVO() {}

	public SearchACMContractInfoVO(String ibflag, String pagerows, String ppdOfcCd, String cltOfcCd, String ppayrCntCd, String cgoRcvDt, String n3ptyRcvOfcCd) {
		this.ppdOfcCd = ppdOfcCd;
		this.ibflag = ibflag;
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
		this.cltOfcCd = cltOfcCd;
		this.ppayrCntCd = ppayrCntCd;
		this.cgoRcvDt = cgoRcvDt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ppd_ofc_cd", getPpdOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3pty_rcv_ofc_cd", getN3ptyRcvOfcCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("ppayr_cnt_cd", getPpayrCntCd());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ppd_ofc_cd", "ppdOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3pty_rcv_ofc_cd", "n3ptyRcvOfcCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("ppayr_cnt_cd", "ppayrCntCd");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ppdOfcCd
	 */
	public String getPpdOfcCd() {
		return this.ppdOfcCd;
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
	 * @return n3ptyRcvOfcCd
	 */
	public String getN3ptyRcvOfcCd() {
		return this.n3ptyRcvOfcCd;
	}

	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}

	/**
	 * Column Info
	 * @return ppayrCntCd
	 */
	public String getPpayrCntCd() {
		return this.ppayrCntCd;
	}

	/**
	 * Column Info
	 * @return cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return this.cgoRcvDt;
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
	 * @param ppdOfcCd
	 */
	public void setPpdOfcCd(String ppdOfcCd) {
		this.ppdOfcCd = ppdOfcCd;
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
	 * @param n3ptyRcvOfcCd
	 */
	public void setN3ptyRcvOfcCd(String n3ptyRcvOfcCd) {
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
	}

	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}

	/**
	 * Column Info
	 * @param ppayrCntCd
	 */
	public void setPpayrCntCd(String ppayrCntCd) {
		this.ppayrCntCd = ppayrCntCd;
	}

	/**
	 * Column Info
	 * @param cgoRcvDt
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
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
		setPpdOfcCd(JSPUtil.getParameter(request, prefix + "ppd_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN3ptyRcvOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_rcv_ofc_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setPpayrCntCd(JSPUtil.getParameter(request, prefix + "ppayr_cnt_cd", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchACMContractInfoVO[]
	 */
	public SearchACMContractInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchACMContractInfoVO[]
	 */
	public SearchACMContractInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchACMContractInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ppdOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppd_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3ptyRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_rcv_ofc_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] ppayrCntCd = (JSPUtil.getParameter(request, prefix	+ "ppayr_cnt_cd", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new SearchACMContractInfoVO();
				if (ppdOfcCd[i] != null)
					model.setPpdOfcCd(ppdOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3ptyRcvOfcCd[i] != null)
					model.setN3ptyRcvOfcCd(n3ptyRcvOfcCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (ppayrCntCd[i] != null)
					model.setPpayrCntCd(ppayrCntCd[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchACMContractInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchACMContractInfoVO[]
	 */
	public SearchACMContractInfoVO[] getSearchACMContractInfoVOs(){
		SearchACMContractInfoVO[] vos = (SearchACMContractInfoVO[])models.toArray(new SearchACMContractInfoVO[models.size()]);
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
		this.ppdOfcCd = this.ppdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyRcvOfcCd = this.n3ptyRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayrCntCd = this.ppayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
