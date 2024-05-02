/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRDetailforCommissionDtrbVO.java
*@FileTitle : CSRDetailforCommissionDtrbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.06 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CSRDetailforCommissionDtrbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CSRDetailforCommissionDtrbVO> models = new ArrayList<CSRDetailforCommissionDtrbVO>();
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String netAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String seq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CSRDetailforCommissionDtrbVO() {}

	public CSRDetailforCommissionDtrbVO(String ibflag, String pagerows, String seq, String invNo, String netAmt, String taxAmt, String totAmt, String csrNo) {
		this.invNo = invNo;
		this.csrNo = csrNo;
		this.totAmt = totAmt;
		this.netAmt = netAmt;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.seq = seq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("net_amt", getNetAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("net_amt", "netAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return netAmt
	 */
	public String getNetAmt() {
		return this.netAmt;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param netAmt
	 */
	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
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
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setTotAmt(JSPUtil.getParameter(request, "tot_amt", ""));
		setNetAmt(JSPUtil.getParameter(request, "net_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSRDetailforCommissionDtrbVO[]
	 */
	public CSRDetailforCommissionDtrbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CSRDetailforCommissionDtrbVO[]
	 */
	public CSRDetailforCommissionDtrbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSRDetailforCommissionDtrbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CSRDetailforCommissionDtrbVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSRDetailforCommissionDtrbVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CSRDetailforCommissionDtrbVO[]
	 */
	public CSRDetailforCommissionDtrbVO[] getCSRDetailforCommissionDtrbVOs(){
		CSRDetailforCommissionDtrbVO[] vos = (CSRDetailforCommissionDtrbVO[])models.toArray(new CSRDetailforCommissionDtrbVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
