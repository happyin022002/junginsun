/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorOFMCustVO.java
*@FileTitle : KorOFMCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.16 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorOFMCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorOFMCustVO> models = new ArrayList<KorOFMCustVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNNm = null;
	/* Column Info */
	private String custCNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorOFMCustVO() {}

	public KorOFMCustVO(String ibflag, String pagerows, String custCNm, String custNNm) {
		this.ibflag = ibflag;
		this.custNNm = custNNm;
		this.custCNm = custCNm;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_n_nm", getCustNNm());
		this.hashColumns.put("cust_c_nm", getCustCNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_n_nm", "custNNm");
		this.hashFields.put("cust_c_nm", "custCNm");
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
	 * @return custNNm
	 */
	public String getCustNNm() {
		return this.custNNm;
	}

	/**
	 * Column Info
	 * @return custCNm
	 */
	public String getCustCNm() {
		return this.custCNm;
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
	 * @param custNNm
	 */
	public void setCustNNm(String custNNm) {
		this.custNNm = custNNm;
	}

	/**
	 * Column Info
	 * @param custCNm
	 */
	public void setCustCNm(String custCNm) {
		this.custCNm = custCNm;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustNNm(JSPUtil.getParameter(request, "cust_n_nm", ""));
		setCustCNm(JSPUtil.getParameter(request, "cust_c_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorOFMCustVO[]
	 */
	public KorOFMCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorOFMCustVO[]
	 */
	public KorOFMCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorOFMCustVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNNm = (JSPUtil.getParameter(request, prefix	+ "cust_n_nm", length));
			String[] custCNm = (JSPUtil.getParameter(request, prefix	+ "cust_c_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorOFMCustVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNNm[i] != null)
					model.setCustNNm(custNNm[i]);
				if (custCNm[i] != null)
					model.setCustCNm(custCNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorOFMCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorOFMCustVO[]
	 */
	public KorOFMCustVO[] getKorOFMCustVOs(){
		KorOFMCustVO[] vos = (KorOFMCustVO[])models.toArray(new KorOFMCustVO[models.size()]);
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
		this.custNNm = this.custNNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCNm = this.custCNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
