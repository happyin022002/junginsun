/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InterrstServiceVO.java
*@FileTitle : InterrstServiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.09 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InterrstServiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InterrstServiceVO> models = new ArrayList<InterrstServiceVO>();
	
	/* Column Info */
	private String installment = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bal = null;
	/* Column Info */
	private String principal = null;
	/* Column Info */
	private String interest = null;
	/* Column Info */
	private String seq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InterrstServiceVO() {}

	public InterrstServiceVO(String ibflag, String pagerows, String seq, String bal, String principal, String interest, String installment) {
		this.installment = installment;
		this.ibflag = ibflag;
		this.bal = bal;
		this.principal = principal;
		this.interest = interest;
		this.seq = seq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("installment", getInstallment());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bal", getBal());
		this.hashColumns.put("principal", getPrincipal());
		this.hashColumns.put("interest", getInterest());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("installment", "installment");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bal", "bal");
		this.hashFields.put("principal", "principal");
		this.hashFields.put("interest", "interest");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return installment
	 */
	public String getInstallment() {
		return this.installment;
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
	 * @return bal
	 */
	public String getBal() {
		return this.bal;
	}
	
	/**
	 * Column Info
	 * @return principal
	 */
	public String getPrincipal() {
		return this.principal;
	}
	
	/**
	 * Column Info
	 * @return interest
	 */
	public String getInterest() {
		return this.interest;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @param installment
	 */
	public void setInstallment(String installment) {
		this.installment = installment;
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
	 * @param bal
	 */
	public void setBal(String bal) {
		this.bal = bal;
	}
	
	/**
	 * Column Info
	 * @param principal
	 */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	/**
	 * Column Info
	 * @param interest
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setInstallment(JSPUtil.getParameter(request, prefix + "installment", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBal(JSPUtil.getParameter(request, prefix + "bal", ""));
		setPrincipal(JSPUtil.getParameter(request, prefix + "principal", ""));
		setInterest(JSPUtil.getParameter(request, prefix + "interest", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InterrstServiceVO[]
	 */
	public InterrstServiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InterrstServiceVO[]
	 */
	public InterrstServiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InterrstServiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] installment = (JSPUtil.getParameter(request, prefix	+ "installment", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bal = (JSPUtil.getParameter(request, prefix	+ "bal", length));
			String[] principal = (JSPUtil.getParameter(request, prefix	+ "principal", length));
			String[] interest = (JSPUtil.getParameter(request, prefix	+ "interest", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InterrstServiceVO();
				if (installment[i] != null)
					model.setInstallment(installment[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bal[i] != null)
					model.setBal(bal[i]);
				if (principal[i] != null)
					model.setPrincipal(principal[i]);
				if (interest[i] != null)
					model.setInterest(interest[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInterrstServiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InterrstServiceVO[]
	 */
	public InterrstServiceVO[] getInterrstServiceVOs(){
		InterrstServiceVO[] vos = (InterrstServiceVO[])models.toArray(new InterrstServiceVO[models.size()]);
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
		this.installment = this.installment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bal = this.bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.principal = this.principal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interest = this.interest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
