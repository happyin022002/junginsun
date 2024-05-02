/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PaymentLetterTitVO.java
*@FileTitle : PaymentLetterTitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class PaymentLetterTitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentLetterTitVO> models = new ArrayList<PaymentLetterTitVO>();
	
	/* Column Info */
	private String arCrCustPrnCtnt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arPrnTitNm = null;
	/* Column Info */
	private String arPrnCtnt = null;
	/* Column Info */
	private String refEml = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentLetterTitVO() {}

	public PaymentLetterTitVO(String ibflag, String pagerows, String arCrCustPrnCtnt, String ofcCd, String arPrnTitNm, String arPrnCtnt, String refEml) {
		this.arCrCustPrnCtnt = arCrCustPrnCtnt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.arPrnTitNm = arPrnTitNm;
		this.arPrnCtnt = arPrnCtnt;
		this.refEml = refEml;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ar_cr_cust_prn_ctnt", getArCrCustPrnCtnt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_prn_tit_nm", getArPrnTitNm());
		this.hashColumns.put("ar_prn_ctnt", getArPrnCtnt());
		this.hashColumns.put("ref_eml", getRefEml());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ar_cr_cust_prn_ctnt", "arCrCustPrnCtnt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_prn_tit_nm", "arPrnTitNm");
		this.hashFields.put("ar_prn_ctnt", "arPrnCtnt");
		this.hashFields.put("ref_eml", "refEml");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return arCrCustPrnCtnt
	 */
	public String getArCrCustPrnCtnt() {
		return this.arCrCustPrnCtnt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return arPrnTitNm
	 */
	public String getArPrnTitNm() {
		return this.arPrnTitNm;
	}
	
	/**
	 * Column Info
	 * @return arPrnCtnt
	 */
	public String getArPrnCtnt() {
		return this.arPrnCtnt;
	}
	
	/**
	 * Column Info
	 * @return refEml
	 */
	public String getRefEml() {
		return this.refEml;
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
	 * @param arCrCustPrnCtnt
	 */
	public void setArCrCustPrnCtnt(String arCrCustPrnCtnt) {
		this.arCrCustPrnCtnt = arCrCustPrnCtnt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param arPrnTitNm
	 */
	public void setArPrnTitNm(String arPrnTitNm) {
		this.arPrnTitNm = arPrnTitNm;
	}
	
	/**
	 * Column Info
	 * @param arPrnCtnt
	 */
	public void setArPrnCtnt(String arPrnCtnt) {
		this.arPrnCtnt = arPrnCtnt;
	}
	
	/**
	 * Column Info
	 * @param refEml
	 */
	public void setRefEml(String refEml) {
		this.refEml = refEml;
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
		setArCrCustPrnCtnt(JSPUtil.getParameter(request, prefix + "ar_cr_cust_prn_ctnt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArPrnTitNm(JSPUtil.getParameter(request, prefix + "ar_prn_tit_nm", ""));
		setArPrnCtnt(JSPUtil.getParameter(request, prefix + "ar_prn_ctnt", ""));
		setRefEml(JSPUtil.getParameter(request, prefix + "ref_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentLetterTitVO[]
	 */
	public PaymentLetterTitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentLetterTitVO[]
	 */
	public PaymentLetterTitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentLetterTitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] arCrCustPrnCtnt = (JSPUtil.getParameter(request, prefix	+ "ar_cr_cust_prn_ctnt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arPrnTitNm = (JSPUtil.getParameter(request, prefix	+ "ar_prn_tit_nm", length));
			String[] arPrnCtnt = (JSPUtil.getParameter(request, prefix	+ "ar_prn_ctnt", length));
			String[] refEml = (JSPUtil.getParameter(request, prefix	+ "ref_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentLetterTitVO();
				if (arCrCustPrnCtnt[i] != null)
					model.setArCrCustPrnCtnt(arCrCustPrnCtnt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arPrnTitNm[i] != null)
					model.setArPrnTitNm(arPrnTitNm[i]);
				if (arPrnCtnt[i] != null)
					model.setArPrnCtnt(arPrnCtnt[i]);
				if (refEml[i] != null)
					model.setRefEml(refEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentLetterTitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentLetterTitVO[]
	 */
	public PaymentLetterTitVO[] getPaymentLetterTitVOs(){
		PaymentLetterTitVO[] vos = (PaymentLetterTitVO[])models.toArray(new PaymentLetterTitVO[models.size()]);
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
		this.arCrCustPrnCtnt = this.arCrCustPrnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arPrnTitNm = this.arPrnTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arPrnCtnt = this.arPrnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refEml = this.refEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
