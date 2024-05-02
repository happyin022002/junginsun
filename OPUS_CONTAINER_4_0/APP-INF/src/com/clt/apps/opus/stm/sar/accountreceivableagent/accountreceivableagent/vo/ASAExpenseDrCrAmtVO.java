/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ASAExpenseDrCrAmtVO.java
*@FileTitle : ASAExpenseDrCrAmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

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

public class ASAExpenseDrCrAmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ASAExpenseDrCrAmtVO> models = new ArrayList<ASAExpenseDrCrAmtVO>();
	
	/* Column Info */
	private String debitAmt = null;
	/* Column Info */
	private String chgTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creditAmt = null;
	/* Column Info */
	private String asaNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ASAExpenseDrCrAmtVO() {}

	public ASAExpenseDrCrAmtVO(String ibflag, String pagerows, String debitAmt, String creditAmt, String asaNo, String chgTpCd) {
		this.debitAmt = debitAmt;
		this.chgTpCd = chgTpCd;
		this.ibflag = ibflag;
		this.creditAmt = creditAmt;
		this.asaNo = asaNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("debit_amt", getDebitAmt());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("credit_amt", getCreditAmt());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("debit_amt", "debitAmt");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("credit_amt", "creditAmt");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return debitAmt
	 */
	public String getDebitAmt() {
		return this.debitAmt;
	}
	
	/**
	 * Column Info
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
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
	 * @return creditAmt
	 */
	public String getCreditAmt() {
		return this.creditAmt;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
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
	 * @param debitAmt
	 */
	public void setDebitAmt(String debitAmt) {
		this.debitAmt = debitAmt;
	}
	
	/**
	 * Column Info
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
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
	 * @param creditAmt
	 */
	public void setCreditAmt(String creditAmt) {
		this.creditAmt = creditAmt;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
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
		setDebitAmt(JSPUtil.getParameter(request, prefix + "debit_amt", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreditAmt(JSPUtil.getParameter(request, prefix + "credit_amt", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ASAExpenseDrCrAmtVO[]
	 */
	public ASAExpenseDrCrAmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ASAExpenseDrCrAmtVO[]
	 */
	public ASAExpenseDrCrAmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ASAExpenseDrCrAmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] debitAmt = (JSPUtil.getParameter(request, prefix	+ "debit_amt", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creditAmt = (JSPUtil.getParameter(request, prefix	+ "credit_amt", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ASAExpenseDrCrAmtVO();
				if (debitAmt[i] != null)
					model.setDebitAmt(debitAmt[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creditAmt[i] != null)
					model.setCreditAmt(creditAmt[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getASAExpenseDrCrAmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ASAExpenseDrCrAmtVO[]
	 */
	public ASAExpenseDrCrAmtVO[] getASAExpenseDrCrAmtVOs(){
		ASAExpenseDrCrAmtVO[] vos = (ASAExpenseDrCrAmtVO[])models.toArray(new ASAExpenseDrCrAmtVO[models.size()]);
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
		this.debitAmt = this.debitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditAmt = this.creditAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
