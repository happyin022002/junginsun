/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PrepaymentPayScheduleCheckVO.java
*@FileTitle : PrepaymentPayScheduleCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class PrepaymentPayScheduleCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrepaymentPayScheduleCheckVO> models = new ArrayList<PrepaymentPayScheduleCheckVO>();
	
	/* Column Info */
	private String payGrsAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String paySkdNo = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String payRmnAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PrepaymentPayScheduleCheckVO() {}

	public PrepaymentPayScheduleCheckVO(String ibflag, String pagerows, String invSeq, String paySkdNo, String payRmnAmt, String payGrsAmt) {
		this.payGrsAmt = payGrsAmt;
		this.ibflag = ibflag;
		this.paySkdNo = paySkdNo;
		this.invSeq = invSeq;
		this.payRmnAmt = payRmnAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_grs_amt", getPayGrsAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_skd_no", getPaySkdNo());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("pay_rmn_amt", getPayRmnAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_grs_amt", "payGrsAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_skd_no", "paySkdNo");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pay_rmn_amt", "payRmnAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payGrsAmt
	 */
	public String getPayGrsAmt() {
		return this.payGrsAmt;
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
	 * @return paySkdNo
	 */
	public String getPaySkdNo() {
		return this.paySkdNo;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return payRmnAmt
	 */
	public String getPayRmnAmt() {
		return this.payRmnAmt;
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
	 * @param payGrsAmt
	 */
	public void setPayGrsAmt(String payGrsAmt) {
		this.payGrsAmt = payGrsAmt;
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
	 * @param paySkdNo
	 */
	public void setPaySkdNo(String paySkdNo) {
		this.paySkdNo = paySkdNo;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param payRmnAmt
	 */
	public void setPayRmnAmt(String payRmnAmt) {
		this.payRmnAmt = payRmnAmt;
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
		setPayGrsAmt(JSPUtil.getParameter(request, prefix + "pay_grs_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPaySkdNo(JSPUtil.getParameter(request, prefix + "pay_skd_no", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setPayRmnAmt(JSPUtil.getParameter(request, prefix + "pay_rmn_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrepaymentPayScheduleCheckVO[]
	 */
	public PrepaymentPayScheduleCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrepaymentPayScheduleCheckVO[]
	 */
	public PrepaymentPayScheduleCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrepaymentPayScheduleCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payGrsAmt = (JSPUtil.getParameter(request, prefix	+ "pay_grs_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] paySkdNo = (JSPUtil.getParameter(request, prefix	+ "pay_skd_no", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] payRmnAmt = (JSPUtil.getParameter(request, prefix	+ "pay_rmn_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrepaymentPayScheduleCheckVO();
				if (payGrsAmt[i] != null)
					model.setPayGrsAmt(payGrsAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (paySkdNo[i] != null)
					model.setPaySkdNo(paySkdNo[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (payRmnAmt[i] != null)
					model.setPayRmnAmt(payRmnAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrepaymentPayScheduleCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrepaymentPayScheduleCheckVO[]
	 */
	public PrepaymentPayScheduleCheckVO[] getPrepaymentPayScheduleCheckVOs(){
		PrepaymentPayScheduleCheckVO[] vos = (PrepaymentPayScheduleCheckVO[])models.toArray(new PrepaymentPayScheduleCheckVO[models.size()]);
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
		this.payGrsAmt = this.payGrsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySkdNo = this.paySkdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRmnAmt = this.payRmnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
