/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChgAmtInfoVO.java
*@FileTitle : ChgAmtInfoVO
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

public class ChgAmtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChgAmtInfoVO> models = new ArrayList<ChgAmtInfoVO>();

	/* Column Info */
	private String cltChgAmt = null;
	/* Column Info */
	private String ppdOfrtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ppdChgAmt = null;
	/* Column Info */
	private String cltOfrtAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChgAmtInfoVO() {}

	public ChgAmtInfoVO(String ibflag, String pagerows, String ppdOfrtAmt, String ppdChgAmt, String cltOfrtAmt, String cltChgAmt) {
		this.cltChgAmt = cltChgAmt;
		this.ppdOfrtAmt = ppdOfrtAmt;
		this.ibflag = ibflag;
		this.ppdChgAmt = ppdChgAmt;
		this.cltOfrtAmt = cltOfrtAmt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clt_chg_amt", getCltChgAmt());
		this.hashColumns.put("ppd_ofrt_amt", getPpdOfrtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ppd_chg_amt", getPpdChgAmt());
		this.hashColumns.put("clt_ofrt_amt", getCltOfrtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clt_chg_amt", "cltChgAmt");
		this.hashFields.put("ppd_ofrt_amt", "ppdOfrtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ppd_chg_amt", "ppdChgAmt");
		this.hashFields.put("clt_ofrt_amt", "cltOfrtAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cltChgAmt
	 */
	public String getCltChgAmt() {
		return this.cltChgAmt;
	}

	/**
	 * Column Info
	 * @return ppdOfrtAmt
	 */
	public String getPpdOfrtAmt() {
		return this.ppdOfrtAmt;
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
	 * @return ppdChgAmt
	 */
	public String getPpdChgAmt() {
		return this.ppdChgAmt;
	}

	/**
	 * Column Info
	 * @return cltOfrtAmt
	 */
	public String getCltOfrtAmt() {
		return this.cltOfrtAmt;
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
	 * @param cltChgAmt
	 */
	public void setCltChgAmt(String cltChgAmt) {
		this.cltChgAmt = cltChgAmt;
	}

	/**
	 * Column Info
	 * @param ppdOfrtAmt
	 */
	public void setPpdOfrtAmt(String ppdOfrtAmt) {
		this.ppdOfrtAmt = ppdOfrtAmt;
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
	 * @param ppdChgAmt
	 */
	public void setPpdChgAmt(String ppdChgAmt) {
		this.ppdChgAmt = ppdChgAmt;
	}

	/**
	 * Column Info
	 * @param cltOfrtAmt
	 */
	public void setCltOfrtAmt(String cltOfrtAmt) {
		this.cltOfrtAmt = cltOfrtAmt;
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
		setCltChgAmt(JSPUtil.getParameter(request, prefix + "clt_chg_amt", ""));
		setPpdOfrtAmt(JSPUtil.getParameter(request, prefix + "ppd_ofrt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPpdChgAmt(JSPUtil.getParameter(request, prefix + "ppd_chg_amt", ""));
		setCltOfrtAmt(JSPUtil.getParameter(request, prefix + "clt_ofrt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChgAmtInfoVO[]
	 */
	public ChgAmtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChgAmtInfoVO[]
	 */
	public ChgAmtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChgAmtInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cltChgAmt = (JSPUtil.getParameter(request, prefix	+ "clt_chg_amt", length));
			String[] ppdOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_ofrt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ppdChgAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_chg_amt", length));
			String[] cltOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "clt_ofrt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ChgAmtInfoVO();
				if (cltChgAmt[i] != null)
					model.setCltChgAmt(cltChgAmt[i]);
				if (ppdOfrtAmt[i] != null)
					model.setPpdOfrtAmt(ppdOfrtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ppdChgAmt[i] != null)
					model.setPpdChgAmt(ppdChgAmt[i]);
				if (cltOfrtAmt[i] != null)
					model.setCltOfrtAmt(cltOfrtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChgAmtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChgAmtInfoVO[]
	 */
	public ChgAmtInfoVO[] getChgAmtInfoVOs(){
		ChgAmtInfoVO[] vos = (ChgAmtInfoVO[])models.toArray(new ChgAmtInfoVO[models.size()]);
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
		this.cltChgAmt = this.cltChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfrtAmt = this.ppdOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdChgAmt = this.ppdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfrtAmt = this.cltOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
