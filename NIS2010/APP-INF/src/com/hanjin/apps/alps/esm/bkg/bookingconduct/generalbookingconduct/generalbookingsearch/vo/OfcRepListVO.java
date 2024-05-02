/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OfcRepListVO.java
*@FileTitle : OfcRepListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.12  
* 1.0 Creation
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfcRepListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfcRepListVO> models = new ArrayList<OfcRepListVO>();
	
	/* Column Info */
	private String custSlsOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String custSrepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custOfcRepCd = null;
	/* Column Info */
	private String compareCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfcRepListVO() {}

	public OfcRepListVO(String ibflag, String pagerows, String custSlsOfcCd, String custSrepCd, String srepNm, String custOfcRepCd, String compareCd) {
		this.custSlsOfcCd = custSlsOfcCd;
		this.ibflag = ibflag;
		this.srepNm = srepNm;
		this.custSrepCd = custSrepCd;
		this.pagerows = pagerows;
		this.custOfcRepCd = custOfcRepCd;
		this.compareCd = compareCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_sls_ofc_cd", getCustSlsOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("cust_srep_cd", getCustSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_ofc_rep_cd", getCustOfcRepCd());
		this.hashColumns.put("compare_cd", getCompareCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_sls_ofc_cd", "custSlsOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("cust_srep_cd", "custSrepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_ofc_rep_cd", "custOfcRepCd");
		this.hashFields.put("compare_cd", "compareCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custSlsOfcCd
	 */
	public String getCustSlsOfcCd() {
		return this.custSlsOfcCd;
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
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return custSrepCd
	 */
	public String getCustSrepCd() {
		return this.custSrepCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getCustOfcRepCd() {
		return custOfcRepCd;
	}

	public String getCompareCd() {
		return compareCd;
	}

	public void setCompareCd(String compareCd) {
		this.compareCd = compareCd;
	}

	public void setCustOfcRepCd(String custOfcRepCd) {
		this.custOfcRepCd = custOfcRepCd;
	}

	/**
	 * Column Info
	 * @param custSlsOfcCd
	 */
	public void setCustSlsOfcCd(String custSlsOfcCd) {
		this.custSlsOfcCd = custSlsOfcCd;
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
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param custSrepCd
	 */
	public void setCustSrepCd(String custSrepCd) {
		this.custSrepCd = custSrepCd;
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
		setCustSlsOfcCd(JSPUtil.getParameter(request, prefix + "cust_sls_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setCustSrepCd(JSPUtil.getParameter(request, prefix + "cust_srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustOfcRepCd(JSPUtil.getParameter(request, prefix + "cust_ofc_rep_cd", ""));
		setCompareCd(JSPUtil.getParameter(request, prefix + "compare_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfcRepListVO[]
	 */
	public OfcRepListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfcRepListVO[]
	 */
	public OfcRepListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfcRepListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "cust_sls_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] custSrepCd = (JSPUtil.getParameter(request, prefix	+ "cust_srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custOfcRepCd = (JSPUtil.getParameter(request, prefix	+ "cust_ofc_rep_cd", length));
			String[] compareCd = (JSPUtil.getParameter(request, prefix	+ "compare_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfcRepListVO();
				if (custSlsOfcCd[i] != null)
					model.setCustSlsOfcCd(custSlsOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (custSrepCd[i] != null)
					model.setCustSrepCd(custSrepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custOfcRepCd[i] != null)
					model.setCustOfcRepCd(custOfcRepCd[i]);
				if (compareCd[i] != null)
					model.setCompareCd(compareCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfcRepListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfcRepListVO[]
	 */
	public OfcRepListVO[] getOfcRepListVOs(){
		OfcRepListVO[] vos = (OfcRepListVO[])models.toArray(new OfcRepListVO[models.size()]);
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
		this.custSlsOfcCd = this.custSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSrepCd = this.custSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custOfcRepCd = this.custOfcRepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compareCd = this.compareCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
