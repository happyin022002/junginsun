/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApPayBatchNameListVO.java
*@FileTitle : ApPayBatchNameListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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

public class ApPayBatchNameListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApPayBatchNameListVO> models = new ArrayList<ApPayBatchNameListVO>();
	
	/* Column Info */
	private String payDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payStsCd = null;
	/* Column Info */
	private String payBatNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ApPayBatchNameListVO() {}

	public ApPayBatchNameListVO(String ibflag, String pagerows, String payBatNm, String payDt, String payStsCd) {
		this.payDt = payDt;
		this.ibflag = ibflag;
		this.payStsCd = payStsCd;
		this.payBatNm = payBatNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_sts_cd", getPayStsCd());
		this.hashColumns.put("pay_bat_nm", getPayBatNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_sts_cd", "payStsCd");
		this.hashFields.put("pay_bat_nm", "payBatNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
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
	 * @return payStsCd
	 */
	public String getPayStsCd() {
		return this.payStsCd;
	}
	
	/**
	 * Column Info
	 * @return payBatNm
	 */
	public String getPayBatNm() {
		return this.payBatNm;
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
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
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
	 * @param payStsCd
	 */
	public void setPayStsCd(String payStsCd) {
		this.payStsCd = payStsCd;
	}
	
	/**
	 * Column Info
	 * @param payBatNm
	 */
	public void setPayBatNm(String payBatNm) {
		this.payBatNm = payBatNm;
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
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPayStsCd(JSPUtil.getParameter(request, prefix + "pay_sts_cd", ""));
		setPayBatNm(JSPUtil.getParameter(request, prefix + "pay_bat_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApPayBatchNameListVO[]
	 */
	public ApPayBatchNameListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApPayBatchNameListVO[]
	 */
	public ApPayBatchNameListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApPayBatchNameListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payStsCd = (JSPUtil.getParameter(request, prefix	+ "pay_sts_cd", length));
			String[] payBatNm = (JSPUtil.getParameter(request, prefix	+ "pay_bat_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApPayBatchNameListVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payStsCd[i] != null)
					model.setPayStsCd(payStsCd[i]);
				if (payBatNm[i] != null)
					model.setPayBatNm(payBatNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApPayBatchNameListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApPayBatchNameListVO[]
	 */
	public ApPayBatchNameListVO[] getApPayBatchNameListVOs(){
		ApPayBatchNameListVO[] vos = (ApPayBatchNameListVO[])models.toArray(new ApPayBatchNameListVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsCd = this.payStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatNm = this.payBatNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
