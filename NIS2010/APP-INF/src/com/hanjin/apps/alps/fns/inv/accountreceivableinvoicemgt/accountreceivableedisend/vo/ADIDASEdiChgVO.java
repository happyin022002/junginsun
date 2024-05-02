/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ADIDASEdiChgVO.java
*@FileTitle : ADIDASEdiChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class ADIDASEdiChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ADIDASEdiChgVO> models = new ArrayList<ADIDASEdiChgVO>();
	
	/* Column Info */
	private String fcRate = null;
	/* Column Info */
	private String fcVatInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcRemarks = null;
	/* Column Info */
	private String fcPertype = null;
	/* Column Info */
	private String fcType = null;
	/* Column Info */
	private String fcAmount = null;
	/* Column Info */
	private String fcExchrate = null;
	/* Column Info */
	private String fcRateCurr = null;
	/* Column Info */
	private String fcRevenueton = null;
	/* Column Info */
	private String fcText = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ADIDASEdiChgVO() {}

	public ADIDASEdiChgVO(String ibflag, String pagerows, String fcType, String fcText, String fcPertype, String fcRevenueton, String fcRate, String fcAmount, String fcRateCurr, String fcExchrate, String fcVatInd, String fcRemarks) {
		this.fcRate = fcRate;
		this.fcVatInd = fcVatInd;
		this.ibflag = ibflag;
		this.fcRemarks = fcRemarks;
		this.fcPertype = fcPertype;
		this.fcType = fcType;
		this.fcAmount = fcAmount;
		this.fcExchrate = fcExchrate;
		this.fcRateCurr = fcRateCurr;
		this.fcRevenueton = fcRevenueton;
		this.fcText = fcText;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fc_rate", getFcRate());
		this.hashColumns.put("fc_vat_ind", getFcVatInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fc_remarks", getFcRemarks());
		this.hashColumns.put("fc_pertype", getFcPertype());
		this.hashColumns.put("fc_type", getFcType());
		this.hashColumns.put("fc_amount", getFcAmount());
		this.hashColumns.put("fc_exchrate", getFcExchrate());
		this.hashColumns.put("fc_rate_curr", getFcRateCurr());
		this.hashColumns.put("fc_revenueton", getFcRevenueton());
		this.hashColumns.put("fc_text", getFcText());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fc_rate", "fcRate");
		this.hashFields.put("fc_vat_ind", "fcVatInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fc_remarks", "fcRemarks");
		this.hashFields.put("fc_pertype", "fcPertype");
		this.hashFields.put("fc_type", "fcType");
		this.hashFields.put("fc_amount", "fcAmount");
		this.hashFields.put("fc_exchrate", "fcExchrate");
		this.hashFields.put("fc_rate_curr", "fcRateCurr");
		this.hashFields.put("fc_revenueton", "fcRevenueton");
		this.hashFields.put("fc_text", "fcText");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fcRate
	 */
	public String getFcRate() {
		return this.fcRate;
	}
	
	/**
	 * Column Info
	 * @return fcVatInd
	 */
	public String getFcVatInd() {
		return this.fcVatInd;
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
	 * @return fcRemarks
	 */
	public String getFcRemarks() {
		return this.fcRemarks;
	}
	
	/**
	 * Column Info
	 * @return fcPertype
	 */
	public String getFcPertype() {
		return this.fcPertype;
	}
	
	/**
	 * Column Info
	 * @return fcType
	 */
	public String getFcType() {
		return this.fcType;
	}
	
	/**
	 * Column Info
	 * @return fcAmount
	 */
	public String getFcAmount() {
		return this.fcAmount;
	}
	
	/**
	 * Column Info
	 * @return fcExchrate
	 */
	public String getFcExchrate() {
		return this.fcExchrate;
	}
	
	/**
	 * Column Info
	 * @return fcRateCurr
	 */
	public String getFcRateCurr() {
		return this.fcRateCurr;
	}
	
	/**
	 * Column Info
	 * @return fcRevenueton
	 */
	public String getFcRevenueton() {
		return this.fcRevenueton;
	}
	
	/**
	 * Column Info
	 * @return fcText
	 */
	public String getFcText() {
		return this.fcText;
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
	 * @param fcRate
	 */
	public void setFcRate(String fcRate) {
		this.fcRate = fcRate;
	}
	
	/**
	 * Column Info
	 * @param fcVatInd
	 */
	public void setFcVatInd(String fcVatInd) {
		this.fcVatInd = fcVatInd;
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
	 * @param fcRemarks
	 */
	public void setFcRemarks(String fcRemarks) {
		this.fcRemarks = fcRemarks;
	}
	
	/**
	 * Column Info
	 * @param fcPertype
	 */
	public void setFcPertype(String fcPertype) {
		this.fcPertype = fcPertype;
	}
	
	/**
	 * Column Info
	 * @param fcType
	 */
	public void setFcType(String fcType) {
		this.fcType = fcType;
	}
	
	/**
	 * Column Info
	 * @param fcAmount
	 */
	public void setFcAmount(String fcAmount) {
		this.fcAmount = fcAmount;
	}
	
	/**
	 * Column Info
	 * @param fcExchrate
	 */
	public void setFcExchrate(String fcExchrate) {
		this.fcExchrate = fcExchrate;
	}
	
	/**
	 * Column Info
	 * @param fcRateCurr
	 */
	public void setFcRateCurr(String fcRateCurr) {
		this.fcRateCurr = fcRateCurr;
	}
	
	/**
	 * Column Info
	 * @param fcRevenueton
	 */
	public void setFcRevenueton(String fcRevenueton) {
		this.fcRevenueton = fcRevenueton;
	}
	
	/**
	 * Column Info
	 * @param fcText
	 */
	public void setFcText(String fcText) {
		this.fcText = fcText;
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
		setFcRate(JSPUtil.getParameter(request, prefix + "fc_rate", ""));
		setFcVatInd(JSPUtil.getParameter(request, prefix + "fc_vat_ind", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcRemarks(JSPUtil.getParameter(request, prefix + "fc_remarks", ""));
		setFcPertype(JSPUtil.getParameter(request, prefix + "fc_pertype", ""));
		setFcType(JSPUtil.getParameter(request, prefix + "fc_type", ""));
		setFcAmount(JSPUtil.getParameter(request, prefix + "fc_amount", ""));
		setFcExchrate(JSPUtil.getParameter(request, prefix + "fc_exchrate", ""));
		setFcRateCurr(JSPUtil.getParameter(request, prefix + "fc_rate_curr", ""));
		setFcRevenueton(JSPUtil.getParameter(request, prefix + "fc_revenueton", ""));
		setFcText(JSPUtil.getParameter(request, prefix + "fc_text", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ADIDASEdiChgVO[]
	 */
	public ADIDASEdiChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ADIDASEdiChgVO[]
	 */
	public ADIDASEdiChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ADIDASEdiChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fcRate = (JSPUtil.getParameter(request, prefix	+ "fc_rate", length));
			String[] fcVatInd = (JSPUtil.getParameter(request, prefix	+ "fc_vat_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcRemarks = (JSPUtil.getParameter(request, prefix	+ "fc_remarks", length));
			String[] fcPertype = (JSPUtil.getParameter(request, prefix	+ "fc_pertype", length));
			String[] fcType = (JSPUtil.getParameter(request, prefix	+ "fc_type", length));
			String[] fcAmount = (JSPUtil.getParameter(request, prefix	+ "fc_amount", length));
			String[] fcExchrate = (JSPUtil.getParameter(request, prefix	+ "fc_exchrate", length));
			String[] fcRateCurr = (JSPUtil.getParameter(request, prefix	+ "fc_rate_curr", length));
			String[] fcRevenueton = (JSPUtil.getParameter(request, prefix	+ "fc_revenueton", length));
			String[] fcText = (JSPUtil.getParameter(request, prefix	+ "fc_text", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ADIDASEdiChgVO();
				if (fcRate[i] != null)
					model.setFcRate(fcRate[i]);
				if (fcVatInd[i] != null)
					model.setFcVatInd(fcVatInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcRemarks[i] != null)
					model.setFcRemarks(fcRemarks[i]);
				if (fcPertype[i] != null)
					model.setFcPertype(fcPertype[i]);
				if (fcType[i] != null)
					model.setFcType(fcType[i]);
				if (fcAmount[i] != null)
					model.setFcAmount(fcAmount[i]);
				if (fcExchrate[i] != null)
					model.setFcExchrate(fcExchrate[i]);
				if (fcRateCurr[i] != null)
					model.setFcRateCurr(fcRateCurr[i]);
				if (fcRevenueton[i] != null)
					model.setFcRevenueton(fcRevenueton[i]);
				if (fcText[i] != null)
					model.setFcText(fcText[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getADIDASEdiChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ADIDASEdiChgVO[]
	 */
	public ADIDASEdiChgVO[] getADIDASEdiChgVOs(){
		ADIDASEdiChgVO[] vos = (ADIDASEdiChgVO[])models.toArray(new ADIDASEdiChgVO[models.size()]);
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
		this.fcRate = this.fcRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcVatInd = this.fcVatInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRemarks = this.fcRemarks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcPertype = this.fcPertype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcType = this.fcType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcAmount = this.fcAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcExchrate = this.fcExchrate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRateCurr = this.fcRateCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRevenueton = this.fcRevenueton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcText = this.fcText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
