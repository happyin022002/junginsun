/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchManualSlipListVO.java
*@FileTitle : SearchManualSlipListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.01 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchManualSlipListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchManualSlipListVO> models = new ArrayList<SearchManualSlipListVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String slpLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchManualSlipListVO() {}

	public SearchManualSlipListVO(String ibflag, String pagerows, String acctCd, String vndrSeq, String ctrCd, String slpLocCd, String effDt, String csrAmt, String csrDesc, String vvdCd, String toInvNo, String csrNo) {
		this.csrNo = csrNo;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.vvdCd = vvdCd;
		this.vndrSeq = vndrSeq;
		this.csrDesc = csrDesc;
		this.acctCd = acctCd;
		this.csrAmt = csrAmt;
		this.toInvNo = toInvNo;
		this.slpLocCd = slpLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
	}
	
	/**
	 * Column Info
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}
	
	/**
	 * Column Info
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
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
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchManualSlipListVO[]
	 */
	public SearchManualSlipListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchManualSlipListVO[]
	 */
	public SearchManualSlipListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchManualSlipListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchManualSlipListVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchManualSlipListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchManualSlipListVO[]
	 */
	public SearchManualSlipListVO[] getSearchManualSlipListVOs(){
		SearchManualSlipListVO[] vos = (SearchManualSlipListVO[])models.toArray(new SearchManualSlipListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
