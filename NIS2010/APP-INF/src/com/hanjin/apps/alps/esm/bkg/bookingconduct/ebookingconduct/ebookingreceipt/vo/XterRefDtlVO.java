/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : XterRefDtlVO.java
*@FileTitle : XterRefDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2015.01.08 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterRefDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterRefDtlVO> models = new ArrayList<XterRefDtlVO>();
	
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String deNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prtNo = null;
	/* Column Info */
	private String custRefTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterRefDtlVO() {}

	public XterRefDtlVO(String ibflag, String pagerows, String refSeq, String deNo, String prtNo, String custRefTpCd) {
		this.refSeq = refSeq;
		this.deNo = deNo;
		this.ibflag = ibflag;
		this.prtNo = prtNo;
		this.custRefTpCd = custRefTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("de_no", getDeNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prt_no", getPrtNo());
		this.hashColumns.put("cust_ref_tp_cd", getCustRefTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("de_no", "deNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prt_no", "prtNo");
		this.hashFields.put("cust_ref_tp_cd", "custRefTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
	}
	
	/**
	 * Column Info
	 * @return deNo
	 */
	public String getDeNo() {
		return this.deNo;
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
	 * @return prtNo
	 */
	public String getPrtNo() {
		return this.prtNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCustRefTpCd() {
		return this.custRefTpCd;
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
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}
	
	/**
	 * Column Info
	 * @param deNo
	 */
	public void setDeNo(String deNo) {
		this.deNo = deNo;
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
	 * @param prtNo
	 */
	public void setPrtNo(String prtNo) {
		this.prtNo = prtNo;
	}
	
	/**
	 * Column Info
	 * @param custRefTpCd
	 */
	public void setCustRefTpCd(String custRefTpCd) {
		this.custRefTpCd = custRefTpCd;
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
		setRefSeq(JSPUtil.getParameter(request, prefix + "ref_seq", ""));
		setDeNo(JSPUtil.getParameter(request, prefix + "de_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrtNo(JSPUtil.getParameter(request, prefix + "prt_no", ""));
		setCustRefTpCd(JSPUtil.getParameter(request, prefix + "cust_ref_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterRefDtlVO[]
	 */
	public XterRefDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterRefDtlVO[]
	 */
	public XterRefDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterRefDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] deNo = (JSPUtil.getParameter(request, prefix	+ "de_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prtNo = (JSPUtil.getParameter(request, prefix	+ "prt_no", length));
			String[] custRefTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_ref_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterRefDtlVO();
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (deNo[i] != null)
					model.setDeNo(deNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prtNo[i] != null)
					model.setPrtNo(prtNo[i]);
				if (custRefTpCd[i] != null)
					model.setCustRefTpCd(custRefTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterRefDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterRefDtlVO[]
	 */
	public XterRefDtlVO[] getXterRefDtlVOs(){
		XterRefDtlVO[] vos = (XterRefDtlVO[])models.toArray(new XterRefDtlVO[models.size()]);
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
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deNo = this.deNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtNo = this.prtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefTpCd = this.custRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
