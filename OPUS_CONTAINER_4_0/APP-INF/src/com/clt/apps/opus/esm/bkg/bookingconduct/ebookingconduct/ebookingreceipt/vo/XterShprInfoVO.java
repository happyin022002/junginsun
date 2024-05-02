/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : XterShprInfoVO.java
*@FileTitle : XterShprInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.28 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterShprInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterShprInfoVO> models = new ArrayList<XterShprInfoVO>();
	
	/* Column Info */
	private String timestamp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String ibcsTp = null;
	/* Column Info */
	private String optCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterShprInfoVO() {}

	public XterShprInfoVO(String ibflag, String pagerows, String ibcsTp, String cntCd, String custCd, String optCd, String timestamp) {
		this.timestamp = timestamp;
		this.ibflag = ibflag;
		this.custCd = custCd;
		this.cntCd = cntCd;
		this.ibcsTp = ibcsTp;
		this.optCd = optCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("timestamp", getTimestamp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ibcs_tp", getIbcsTp());
		this.hashColumns.put("opt_cd", getOptCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("timestamp", "timestamp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ibcs_tp", "ibcsTp");
		this.hashFields.put("opt_cd", "optCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return timestamp
	 */
	public String getTimestamp() {
		return this.timestamp;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return ibcsTp
	 */
	public String getIbcsTp() {
		return this.ibcsTp;
	}
	
	/**
	 * Column Info
	 * @return optCd
	 */
	public String getOptCd() {
		return this.optCd;
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
	 * @param timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param ibcsTp
	 */
	public void setIbcsTp(String ibcsTp) {
		this.ibcsTp = ibcsTp;
	}
	
	/**
	 * Column Info
	 * @param optCd
	 */
	public void setOptCd(String optCd) {
		this.optCd = optCd;
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
		setTimestamp(JSPUtil.getParameter(request, "timestamp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setIbcsTp(JSPUtil.getParameter(request, "ibcs_tp", ""));
		setOptCd(JSPUtil.getParameter(request, "opt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterShprInfoVO[]
	 */
	public XterShprInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterShprInfoVO[]
	 */
	public XterShprInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterShprInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] timestamp = (JSPUtil.getParameter(request, prefix	+ "timestamp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] ibcsTp = (JSPUtil.getParameter(request, prefix	+ "ibcs_tp", length));
			String[] optCd = (JSPUtil.getParameter(request, prefix	+ "opt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterShprInfoVO();
				if (timestamp[i] != null)
					model.setTimestamp(timestamp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (ibcsTp[i] != null)
					model.setIbcsTp(ibcsTp[i]);
				if (optCd[i] != null)
					model.setOptCd(optCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterShprInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterShprInfoVO[]
	 */
	public XterShprInfoVO[] getXterShprInfoVOs(){
		XterShprInfoVO[] vos = (XterShprInfoVO[])models.toArray(new XterShprInfoVO[models.size()]);
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
		this.timestamp = this.timestamp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsTp = this.ibcsTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optCd = this.optCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
