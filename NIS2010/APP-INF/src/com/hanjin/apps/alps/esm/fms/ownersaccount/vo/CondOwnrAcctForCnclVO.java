/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CondOwnrAcctForCnclVO.java
*@FileTitle : CondOwnrAcctForCnclVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.ownersaccount.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class CondOwnrAcctForCnclVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondOwnrAcctForCnclVO> models = new ArrayList<CondOwnrAcctForCnclVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String acctItmSeq = null;
	/* Column Info */
	private String csrFrDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String supplier = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String csrToDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CondOwnrAcctForCnclVO() {}

	public CondOwnrAcctForCnclVO(String ibflag, String pagerows, String slpOfcCd, String supplier, String csrFrDt, String csrToDt, String acctItmSeq, String vslCd, String csrNo) {
		this.csrNo = csrNo;
		this.vslCd = vslCd;
		this.acctItmSeq = acctItmSeq;
		this.csrFrDt = csrFrDt;
		this.ibflag = ibflag;
		this.supplier = supplier;
		this.slpOfcCd = slpOfcCd;
		this.csrToDt = csrToDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("csr_fr_dt", getCsrFrDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("supplier", getSupplier());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("csr_to_dt", getCsrToDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("csr_fr_dt", "csrFrDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("supplier", "supplier");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("csr_to_dt", "csrToDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return acctItmSeq
	 */
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}
	
	/**
	 * Column Info
	 * @return csrFrDt
	 */
	public String getCsrFrDt() {
		return this.csrFrDt;
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
	 * @return supplier
	 */
	public String getSupplier() {
		return this.supplier;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return csrToDt
	 */
	public String getCsrToDt() {
		return this.csrToDt;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param acctItmSeq
	 */
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
	}
	
	/**
	 * Column Info
	 * @param csrFrDt
	 */
	public void setCsrFrDt(String csrFrDt) {
		this.csrFrDt = csrFrDt;
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
	 * @param supplier
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param csrToDt
	 */
	public void setCsrToDt(String csrToDt) {
		this.csrToDt = csrToDt;
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
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, prefix + "acct_itm_seq", ""));
		setCsrFrDt(JSPUtil.getParameter(request, prefix + "csr_fr_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSupplier(JSPUtil.getParameter(request, prefix + "supplier", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setCsrToDt(JSPUtil.getParameter(request, prefix + "csr_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondOwnrAcctForCnclVO[]
	 */
	public CondOwnrAcctForCnclVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondOwnrAcctForCnclVO[]
	 */
	public CondOwnrAcctForCnclVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondOwnrAcctForCnclVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq", length));
			String[] csrFrDt = (JSPUtil.getParameter(request, prefix	+ "csr_fr_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] supplier = (JSPUtil.getParameter(request, prefix	+ "supplier", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] csrToDt = (JSPUtil.getParameter(request, prefix	+ "csr_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondOwnrAcctForCnclVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (csrFrDt[i] != null)
					model.setCsrFrDt(csrFrDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (supplier[i] != null)
					model.setSupplier(supplier[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (csrToDt[i] != null)
					model.setCsrToDt(csrToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondOwnrAcctForCnclVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondOwnrAcctForCnclVO[]
	 */
	public CondOwnrAcctForCnclVO[] getCondOwnrAcctForCnclVOs(){
		CondOwnrAcctForCnclVO[] vos = (CondOwnrAcctForCnclVO[])models.toArray(new CondOwnrAcctForCnclVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrFrDt = this.csrFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supplier = this.supplier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrToDt = this.csrToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
